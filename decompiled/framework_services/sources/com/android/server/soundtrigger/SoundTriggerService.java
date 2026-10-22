package com.android.server.soundtrigger;

import android.app.ActivityThread;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.soundtrigger.ConversionUtil;
import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.SoundTrigger;
import android.hardware.soundtrigger.SoundTriggerModule;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.permission.ClearCallingIdentityContext;
import android.media.permission.Identity;
import android.media.permission.IdentityContext;
import android.media.permission.PermissionUtil;
import android.media.permission.SafeCloseable;
import android.media.soundtrigger.ISoundTriggerDetectionService;
import android.media.soundtrigger.ISoundTriggerDetectionServiceClient;
import android.media.soundtrigger_middleware.ISoundTriggerInjection;
import android.media.soundtrigger_middleware.ISoundTriggerMiddlewareService;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelUuid;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.app.ISoundTriggerService;
import com.android.internal.app.ISoundTriggerSession;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.SoundTriggerInternal;
import com.android.server.SystemService;
import com.android.server.utils.EventLogger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerService extends SystemService {
    private static final boolean DEBUG = true;
    private static final int SESSION_MAX_EVENT_SIZE = 128;
    private static final String TAG = "SoundTriggerService";
    private AppOpsManager mAppOpsManager;
    private final Context mContext;
    private SoundTriggerDbHelper mDbHelper;
    private final Deque<EventLogger> mDetachedSessionEventLoggers;
    private final EventLogger mDeviceEventLogger;
    private final DeviceStateHandler mDeviceStateHandler;
    private final Executor mDeviceStateHandlerExecutor;
    private final LocalSoundTriggerService mLocalSoundTriggerService;
    private final Object mLock;
    private ISoundTriggerMiddlewareService mMiddlewareService;
    private final ArrayMap<String, NumOps> mNumOpsPerPackage;
    private PackageManager mPackageManager;
    private PhoneCallStateHandler mPhoneCallStateHandler;
    private final EventLogger mServiceEventLogger;
    private final SoundTriggerServiceStub mServiceStub;
    private final Set<EventLogger> mSessionEventLoggers;
    private AtomicInteger mSessionIdCounter;
    private final SoundModelStatTracker mSoundModelStatTracker;

    public final class LocalSoundTriggerService implements SoundTriggerInternal {
        private final Context mContext;
        final /* synthetic */ SoundTriggerService this$0;

        private class SessionImpl implements SoundTriggerInternal.Session {
            private final MyAppOpsListener mAppOpsListener;
            private final IBinder mClient;
            private final EventLogger mEventLogger;
            private final DeviceStateHandler.DeviceStateListener mListener;
            private final SparseArray<UUID> mModelUuid;
            private final Identity mOriginatorIdentity;
            private final SoundTriggerHelper mSoundTriggerHelper;
            final /* synthetic */ LocalSoundTriggerService this$1;

            public static /* synthetic */ void $r8$lambda$bFrRRkjaqxOAb9gQmxpCVXHfEVY(SessionImpl r0, DeviceStateHandler.SoundTriggerDeviceState r1) {
                r0.lambda$new$1(r1);
            }

            public static /* synthetic */ void $r8$lambda$cVjQiSrrz_ZCTGuGTwfHOmktLEA(SessionImpl r0) {
                r0.lambda$new$0();
            }

            /* synthetic */ SessionImpl(LocalSoundTriggerService r1, SoundTriggerHelper r2, IBinder r3, EventLogger r4, Identity r5, SoundTriggerServiceIA r6) {
                this(r1, r2, r3, r4, r5);
            }

            private SessionImpl(LocalSoundTriggerService r7, SoundTriggerHelper soundTriggerHelper, IBinder client, EventLogger eventLogger, Identity originatorIdentity) {
                this.this$1 = r7;
                this.mModelUuid = new SparseArray(1);
                this.mSoundTriggerHelper = soundTriggerHelper;
                this.mClient = client;
                this.mOriginatorIdentity = originatorIdentity;
                this.mEventLogger = eventLogger;
                SoundTriggerService.m8196$$Nest$fgetmSessionEventLoggers(r7.this$0).add(this.mEventLogger);
                this.mClient.linkToDeath(new SoundTriggerService$LocalSoundTriggerService$SessionImpl$$ExternalSyntheticLambda0(this), 0);     // Catch: RemoteException -> L5
            L7:
                this.mListener = new SoundTriggerService$LocalSoundTriggerService$SessionImpl$$ExternalSyntheticLambda1(this);
                SoundTriggerService r2 = r7.this$0;
                Identity r3 = this.mOriginatorIdentity;
                SoundTriggerHelper r4 = this.mSoundTriggerHelper;
                r4.getClass();
                this.mAppOpsListener = new MyAppOpsListener(r2, r3, new SoundTriggerService$LocalSoundTriggerService$SessionImpl$$ExternalSyntheticLambda2(r4));
                this.mAppOpsListener.forceOpChangeRefresh();
                SoundTriggerService.m8186$$Nest$fgetmAppOpsManager(r7.this$0).startWatchingMode("android:record_audio", this.mOriginatorIdentity.packageName, 1, this.mAppOpsListener);
                SoundTriggerService.m8191$$Nest$fgetmDeviceStateHandler(r7.this$0).registerListener(this.mListener);
                return;
            L6:
                clientDied();
                goto L7
            }

            private /* synthetic */ void lambda$new$0() {
                clientDied();
            }

            private /* synthetic */ void lambda$new$1(DeviceStateHandler.SoundTriggerDeviceState state) {
                this.mSoundTriggerHelper.onDeviceStateChanged(state);
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public int startRecognition(int keyphraseId, SoundTrigger.KeyphraseSoundModel soundModel, IRecognitionStatusCallback listener, SoundTrigger.RecognitionConfig recognitionConfig, boolean runInBatterySaverMode) {
                this.mModelUuid.put(keyphraseId, soundModel.getUuid());
                this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION, soundModel.getUuid()));
                return this.mSoundTriggerHelper.startKeyphraseRecognition(keyphraseId, soundModel, listener, recognitionConfig, runInBatterySaverMode);
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public synchronized int stopRecognition(int keyphraseId, IRecognitionStatusCallback listener) {
                monitor-enter(this);
                UUID uuid = this.mModelUuid.get(keyphraseId);     // Catch: Throwable -> L6
                this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION, uuid));     // Catch: Throwable -> L6
                int r1 = this.mSoundTriggerHelper.stopKeyphraseRecognition(keyphraseId, listener);     // Catch: Throwable -> L6
                monitor-exit(this);
                return r1;
            L6:
                th = move-exception;
                throw th;
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public SoundTrigger.ModuleProperties getModuleProperties() {
                this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.GET_MODULE_PROPERTIES, null));
                return this.mSoundTriggerHelper.getModuleProperties();
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public int setParameter(int keyphraseId, int modelParam, int value) {
                UUID uuid = this.mModelUuid.get(keyphraseId);
                this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.SET_PARAMETER, uuid));
                return this.mSoundTriggerHelper.setKeyphraseParameter(keyphraseId, modelParam, value);
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public int getParameter(int keyphraseId, int modelParam) {
                return this.mSoundTriggerHelper.getKeyphraseParameter(keyphraseId, modelParam);
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public SoundTrigger.ModelParamRange queryParameter(int keyphraseId, int modelParam) {
                return this.mSoundTriggerHelper.queryKeyphraseParameter(keyphraseId, modelParam);
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public void detach() {
                detachInternal();
            }

            @Override // com.android.server.SoundTriggerInternal.Session
            public int unloadKeyphraseModel(int keyphraseId) {
                UUID uuid = this.mModelUuid.get(keyphraseId);
                this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.UNLOAD_MODEL, uuid));
                return this.mSoundTriggerHelper.unloadKeyphraseSoundModel(keyphraseId);
            }

            private void clientDied() {
                SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$1.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.DETACH, this.mOriginatorIdentity.packageName, "Client died").printLog(2, SoundTriggerService.TAG));
                detachInternal();
            }

            private void detachInternal() {
                if (this.mAppOpsListener == null) goto L5;
                SoundTriggerService.m8186$$Nest$fgetmAppOpsManager(this.this$1.this$0).stopWatchingMode(this.mAppOpsListener);
            L5:
                this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.DETACH, null));
                SoundTriggerService.m8199$$Nest$mdetachSessionLogger(this.this$1.this$0, this.mEventLogger);
                SoundTriggerService.m8191$$Nest$fgetmDeviceStateHandler(this.this$1.this$0).unregisterListener(this.mListener);
                this.mSoundTriggerHelper.detach();
            }
        }

        LocalSoundTriggerService(SoundTriggerService this$0, Context context) {
            this.this$0 = this$0;
            this.mContext = context;
        }

        @Override // com.android.server.SoundTriggerInternal
        public SoundTriggerInternal.Session attach(IBinder client, SoundTrigger.ModuleProperties underlyingModule, boolean isTrusted) {
            Identity identity = IdentityContext.getNonNull();
            int sessionId = SoundTriggerService.m8197$$Nest$fgetmSessionIdCounter(this.this$0).getAndIncrement();
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.ATTACH, identity.packageName + "#" + sessionId));
            EventLogger eventLogger = new EventLogger(128, "LocalSoundTriggerEventLogger for package: " + identity.packageName + "#" + sessionId + " - " + identity.uid + "|" + identity.pid);
            return new SessionImpl(this, SoundTriggerService.m8202$$Nest$mnewSoundTriggerHelper(this.this$0, underlyingModule, eventLogger, isTrusted), client, eventLogger, identity, null);
        }

        @Override // com.android.server.SoundTriggerInternal
        public List<SoundTrigger.ModuleProperties> listModuleProperties(Identity originatorIdentity) {
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.LIST_MODULE, originatorIdentity.packageName));
            SafeCloseable ignored = PermissionUtil.establishIdentityDirect(originatorIdentity);
            List<SoundTrigger.ModuleProperties> r1 = SoundTriggerService.m8200$$Nest$mlistUnderlyingModuleProperties(this.this$0, originatorIdentity);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }
    }

    class MyAppOpsListener implements AppOpsManager.OnOpChangedListener {
        private final Consumer<Boolean> mOnOpModeChanged;
        private final Identity mOriginatorIdentity;
        final /* synthetic */ SoundTriggerService this$0;

        MyAppOpsListener(SoundTriggerService this$0, Identity originatorIdentity, Consumer<Boolean> onOpModeChanged) {
            this.this$0 = this$0;
            originatorIdentity.getClass();
            this.mOriginatorIdentity = originatorIdentity;
            onOpModeChanged.getClass();
            this.mOnOpModeChanged = onOpModeChanged;
            int uid = SoundTriggerService.m8194$$Nest$fgetmPackageManager(this$0).getPackageUid(this.mOriginatorIdentity.packageName, PackageManager.PackageInfoFlags.of(4194304));     // Catch: PackageManager.NameNotFoundException -> L8
            if (UserHandle.isSameApp(uid, this.mOriginatorIdentity.uid) == false) goto L7;
            return;
        L7:
            throw new SecurityException("Uid " + this.mOriginatorIdentity.uid + " attempted to spoof package name " + this.mOriginatorIdentity.packageName + " with uid: " + uid);     // Catch: PackageManager.NameNotFoundException -> L8
        L10:
            throw new SecurityException("Package name not found: " + this.mOriginatorIdentity.packageName);
        }

        @Override // android.app.AppOpsManager.OnOpChangedListener
        public void onOpChanged(String op, String packageName) {
            if (Objects.equals(op, "android:record_audio") == true) goto L5;
            return;
        L5:
            int mode = SoundTriggerService.m8186$$Nest$fgetmAppOpsManager(this.this$0).checkOpNoThrow("android:record_audio", this.mOriginatorIdentity.uid, this.mOriginatorIdentity.packageName);
            Consumer<Boolean> r1 = this.mOnOpModeChanged;
            if (mode != 0) goto L8;
            boolean r2 = true;
        L9:
            r1.accept(Boolean.valueOf(r2));
            return;
        L8:
            r2 = false;
            goto L9
        }

        void forceOpChangeRefresh() {
            onOpChanged("android:record_audio", this.mOriginatorIdentity.packageName);
        }
    }

    private static class NumOps {
        private long mLastOpsHourSinceBoot;
        private final Object mLock;
        private int[] mNumOps;

        /* synthetic */ NumOps(SoundTriggerServiceIA r1) {
            this();
        }

        private NumOps() {
            this.mLock = new Object();
            this.mNumOps = new int[24];
        }

        void clearOldOps(long currentTime) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            long numHoursSinceBoot = TimeUnit.HOURS.convert(currentTime, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L10
            if (this.mLastOpsHourSinceBoot == 0) goto L12;
            long hour = this.mLastOpsHourSinceBoot + 1;     // Catch: Throwable -> L10
        L8:
            if (hour > numHoursSinceBoot) goto L12;
            this.mNumOps[(int) (hour % 24)] = 0;     // Catch: Throwable -> L10
            hour = hour + 1;     // Catch: Throwable -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        void addOp(long currentTime) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            long numHoursSinceBoot = TimeUnit.HOURS.convert(currentTime, TimeUnit.NANOSECONDS);     // Catch: Throwable -> L7
            int[] r3 = this.mNumOps;     // Catch: Throwable -> L7
            int r4 = (int) (numHoursSinceBoot % 24);     // Catch: Throwable -> L7
            r3[r4] = r3[r4] + 1;     // Catch: Throwable -> L7
            this.mLastOpsHourSinceBoot = numHoursSinceBoot;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        int getOpsAdded() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int totalOperationsInLastDay = 0;
            int i = 0;
        L6:
            if (i >= 24) goto L11;
            totalOperationsInLastDay = totalOperationsInLastDay + this.mNumOps[i];     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return totalOperationsInLastDay;
        }
    }

    private static class Operation {
        private final Runnable mDropOp;
        private final ExecuteOp mExecuteOp;
        private final Runnable mSetupOp;

        private interface ExecuteOp {
            void run(int r1, ISoundTriggerDetectionService r2) throws RemoteException;
        }

        /* synthetic */ Operation(Runnable r1, ExecuteOp r2, Runnable r3, SoundTriggerServiceIA r4) {
            this(r1, r2, r3);
        }

        private Operation(Runnable setupOp, ExecuteOp executeOp, Runnable cancelOp) {
            this.mSetupOp = setupOp;
            this.mExecuteOp = executeOp;
            this.mDropOp = cancelOp;
        }

        private void setup() {
            if (this.mSetupOp == null) goto L6;
            this.mSetupOp.run();
            return;
        }

        void run(int opId, ISoundTriggerDetectionService service) throws RemoteException {
            setup();
            this.mExecuteOp.run(opId, service);
        }

        void drop() {
            setup();
            if (this.mDropOp == null) goto L6;
            this.mDropOp.run();
            return;
        }
    }

    class SoundModelStatTracker {
        private final TreeMap<UUID, SoundModelStat> mModelStats;

        private class SoundModelStat {
            boolean mIsStarted;
            long mLastStartTimestampMsec;
            long mLastStopTimestampMsec;
            long mStartCount;
            long mTotalTimeMsec;

            SoundModelStat(SoundModelStatTracker r3) {
                this.mStartCount = 0;
                this.mTotalTimeMsec = 0;
                this.mLastStartTimestampMsec = 0;
                this.mLastStopTimestampMsec = 0;
                this.mIsStarted = false;
            }
        }

        SoundModelStatTracker(SoundTriggerService this$0) {
            this.mModelStats = new TreeMap();
        }

        public synchronized void onStart(UUID id) {
            monitor-enter(this);
            SoundModelStat stat = this.mModelStats.get(id);     // Catch: Throwable -> L6
            if (stat != null) goto L9;
            stat = new SoundModelStat(this);     // Catch: Throwable -> L6
            this.mModelStats.put(id, stat);     // Catch: Throwable -> L6
        L9:
            if (stat.mIsStarted == false) goto L13;
            Slog.w(SoundTriggerService.TAG, "error onStart(): Model " + id + " already started");     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L13:
            stat.mStartCount++;     // Catch: Throwable -> L6
            stat.mLastStartTimestampMsec = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
            stat.mIsStarted = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void onStop(UUID id) {
            monitor-enter(this);
            SoundModelStat stat = this.mModelStats.get(id);     // Catch: Throwable -> L8
            if (stat != null) goto L11;
            Slog.i(SoundTriggerService.TAG, "error onStop(): Model " + id + " has no stats available");     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L11:
            if (stat.mIsStarted == true) goto L15;
            Slog.w(SoundTriggerService.TAG, "error onStop(): Model " + id + " already stopped");     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L15:
            stat.mLastStopTimestampMsec = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
            stat.mTotalTimeMsec += stat.mLastStopTimestampMsec - stat.mLastStartTimestampMsec;     // Catch: Throwable -> L8
            stat.mIsStarted = false;     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public synchronized void dump(PrintWriter pw) {
            monitor-enter(this);
            long curTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
            pw.println("Model Stats:");     // Catch: Throwable -> L9
            Iterator<Map.Entry<UUID, SoundModelStat>> r2 = this.mModelStats.entrySet().iterator();     // Catch: Throwable -> L9
        L4:
            if (r2.hasNext() == false) goto L13;
            Map.Entry<UUID, SoundModelStat> entry = r2.next();     // Catch: Throwable -> L9
            UUID uuid = entry.getKey();     // Catch: Throwable -> L9
            SoundModelStat stat = entry.getValue();     // Catch: Throwable -> L9
            long totalTimeMsec = stat.mTotalTimeMsec;     // Catch: Throwable -> L9
            if (stat.mIsStarted == false) goto L11;
            totalTimeMsec = totalTimeMsec + (curTime - stat.mLastStartTimestampMsec);     // Catch: Throwable -> L9
        L11:
            pw.println(uuid + ", total_time(msec)=" + totalTimeMsec + ", total_count=" + stat.mStartCount + ", last_start=" + stat.mLastStartTimestampMsec + ", last_stop=" + stat.mLastStopTimestampMsec);     // Catch: Throwable -> L9
            goto L4
        L13:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    class SoundTriggerServiceStub extends ISoundTriggerService.Stub {
        final /* synthetic */ SoundTriggerService this$0;

        SoundTriggerServiceStub(SoundTriggerService this$0) {
            this.this$0 = this$0;
        }

        public ISoundTriggerSession attachAsOriginator(Identity originatorIdentity, SoundTrigger.ModuleProperties moduleProperties, IBinder client) {
            int sessionId = SoundTriggerService.m8197$$Nest$fgetmSessionIdCounter(this.this$0).getAndIncrement();
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.ATTACH, originatorIdentity.packageName + "#" + sessionId));
            SafeCloseable ignored = PermissionUtil.establishIdentityDirect(originatorIdentity);
            StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L7
            r3.append("SoundTriggerSessionLogs for package: ");     // Catch: Throwable -> L7
            String r4 = originatorIdentity.packageName;     // Catch: Throwable -> L7
            r4.getClass();     // Catch: Throwable -> L7
            r3.append(r4);     // Catch: Throwable -> L7
            r3.append("#");     // Catch: Throwable -> L7
            r3.append(sessionId);     // Catch: Throwable -> L7
            r3.append(" - ");     // Catch: Throwable -> L7
            r3.append(originatorIdentity.uid);     // Catch: Throwable -> L7
            r3.append("|");     // Catch: Throwable -> L7
            r3.append(originatorIdentity.pid);     // Catch: Throwable -> L7
            EventLogger eventLogger = new EventLogger(128, r3.toString());     // Catch: Throwable -> L7
            SoundTriggerSessionStub r5 = new SoundTriggerSessionStub(this.this$0, client, SoundTriggerService.m8201$$Nest$mnewSoundTriggerHelper(this.this$0, moduleProperties, eventLogger), eventLogger);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r5;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public ISoundTriggerSession attachAsMiddleman(Identity originatorIdentity, Identity middlemanIdentity, SoundTrigger.ModuleProperties moduleProperties, IBinder client) {
            int sessionId = SoundTriggerService.m8197$$Nest$fgetmSessionIdCounter(this.this$0).getAndIncrement();
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.ATTACH, originatorIdentity.packageName + "#" + sessionId));
            SafeCloseable ignored = PermissionUtil.establishIdentityIndirect(SoundTriggerService.m8187$$Nest$fgetmContext(this.this$0), "android.permission.SOUNDTRIGGER_DELEGATE_IDENTITY", middlemanIdentity, originatorIdentity);
            StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L7
            r3.append("SoundTriggerSessionLogs for package: ");     // Catch: Throwable -> L7
            String r4 = originatorIdentity.packageName;     // Catch: Throwable -> L7
            r4.getClass();     // Catch: Throwable -> L7
            r3.append(r4);     // Catch: Throwable -> L7
            r3.append("#");     // Catch: Throwable -> L7
            r3.append(sessionId);     // Catch: Throwable -> L7
            r3.append(" - ");     // Catch: Throwable -> L7
            r3.append(originatorIdentity.uid);     // Catch: Throwable -> L7
            r3.append("|");     // Catch: Throwable -> L7
            r3.append(originatorIdentity.pid);     // Catch: Throwable -> L7
            EventLogger eventLogger = new EventLogger(128, r3.toString());     // Catch: Throwable -> L7
            SoundTriggerSessionStub r5 = new SoundTriggerSessionStub(this.this$0, client, SoundTriggerService.m8201$$Nest$mnewSoundTriggerHelper(this.this$0, moduleProperties, eventLogger), eventLogger);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r5;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public List<SoundTrigger.ModuleProperties> listModuleProperties(Identity originatorIdentity) {
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.LIST_MODULE, originatorIdentity.packageName));
            SafeCloseable ignored = PermissionUtil.establishIdentityDirect(originatorIdentity);
            List<SoundTrigger.ModuleProperties> r1 = SoundTriggerService.m8200$$Nest$mlistUnderlyingModuleProperties(this.this$0, originatorIdentity);     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return r1;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void attachInjection(ISoundTriggerInjection injection) {
            if (PermissionChecker.checkCallingPermissionForPreflight(SoundTriggerService.m8187$$Nest$fgetmContext(this.this$0), "android.permission.MANAGE_SOUND_TRIGGER", null) != 0) goto L10;
            ISoundTriggerMiddlewareService.Stub.asInterface(ServiceManager.waitForService("soundtrigger_middleware")).attachFakeHalInjection(injection);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            throw e.rethrowFromSystemServer();
        L10:
            throw new SecurityException();
        }

        public void setInPhoneCallState(boolean isInPhoneCall) {
            Slog.i(SoundTriggerService.TAG, "Overriding phone call state: " + isInPhoneCall);
            SoundTriggerService.m8191$$Nest$fgetmDeviceStateHandler(this.this$0).onPhoneCallStateChanged(isInPhoneCall);
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(SoundTriggerService.m8187$$Nest$fgetmContext(this.this$0), SoundTriggerService.TAG, pw) == true) goto L5;
            return;
        L5:
            pw.println("##Service-Wide logs:");
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).dump(pw, "  ");
            pw.println("\n##Device state logs:");
            SoundTriggerService.m8191$$Nest$fgetmDeviceStateHandler(this.this$0).dump(pw);
            SoundTriggerService.m8190$$Nest$fgetmDeviceEventLogger(this.this$0).dump(pw, "  ");
            pw.println("\n##Active Session dumps:\n");
            Iterator r0 = SoundTriggerService.m8196$$Nest$fgetmSessionEventLoggers(this.this$0).iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            EventLogger sessionLogger = (EventLogger) r0.next();
            sessionLogger.dump(pw, "  ");
            pw.println("");
            goto L7
        L9:
            pw.println("##Detached Session dumps:\n");
            Iterator r1 = SoundTriggerService.m8189$$Nest$fgetmDetachedSessionEventLoggers(this.this$0).iterator();
        L11:
            if (r1.hasNext() == false) goto L13;
            EventLogger sessionLogger2 = (EventLogger) r1.next();
            sessionLogger2.dump(pw, "  ");
            pw.println("");
            goto L11
        L13:
            pw.println("##Enrolled db dump:\n");
            SoundTriggerService.m8188$$Nest$fgetmDbHelper(this.this$0).dump(pw);
            pw.println("\n##Sound Model Stats dump:\n");
            SoundTriggerService.m8198$$Nest$fgetmSoundModelStatTracker(this.this$0).dump(pw);
        }

        protected void onUnhandledException(int code, int flags, Exception e) {
            Slog.wtf(SoundTriggerService.TAG, "Unhandled exception code: " + code, e);
        }
    }

    class SoundTriggerSessionStub extends ISoundTriggerSession.Stub {
        private final MyAppOpsListener mAppOpsListener;
        private final TreeMap<UUID, IRecognitionStatusCallback> mCallbacks;
        private final Object mCallbacksLock;
        private final IBinder mClient;
        private final EventLogger mEventLogger;
        private final DeviceStateHandler.DeviceStateListener mListener;
        private final TreeMap<UUID, SoundTrigger.SoundModel> mLoadedModels;
        private final Identity mOriginatorIdentity;
        private final SoundTriggerHelper mSoundTriggerHelper;
        final /* synthetic */ SoundTriggerService this$0;

        private class RemoteSoundTriggerDetectionService extends IRecognitionStatusCallback.Stub implements ServiceConnection {
            private static final int MSG_STOP_ALL_PENDING_OPERATIONS = 1;
            private final ISoundTriggerDetectionServiceClient mClient;
            private boolean mDestroyOnceRunningOpsDone;
            private final Handler mHandler;
            private boolean mIsBound;
            private boolean mIsDestroyed;
            private final NumOps mNumOps;
            private int mNumTotalOpsPerformed;
            private final Bundle mParams;
            private final ArrayList<Operation> mPendingOps;
            private final ParcelUuid mPuuid;
            private final SoundTrigger.RecognitionConfig mRecognitionConfig;
            private final Object mRemoteServiceLock;
            private final PowerManager.WakeLock mRemoteServiceWakeLock;
            private final ArraySet<Integer> mRunningOpIds;
            private ISoundTriggerDetectionService mService;
            private final ComponentName mServiceName;
            private final UserHandle mUser;
            final /* synthetic */ SoundTriggerSessionStub this$1;

            public static /* synthetic */ void $r8$lambda$CDG3hXoHDRhluoWO8OE3nRPfzhc(RemoteSoundTriggerDetectionService r0) {
                r0.lambda$onGenericSoundTriggerDetected$0();
            }

            public static /* synthetic */ void $r8$lambda$DKgnta5wapOTmICg82DjR9RtCps(RemoteSoundTriggerDetectionService r0, SoundTrigger.GenericRecognitionEvent r1) {
                r0.lambda$onGenericSoundTriggerDetected$2(r1);
            }

            /* JADX INFO: renamed from: $r8$lambda$NxNiOXBuVVGDzfx-mEsuIrRejZE, reason: not valid java name */
            public static /* synthetic */ void m8206$r8$lambda$NxNiOXBuVVGDzfxmEsuIrRejZE(RemoteSoundTriggerDetectionService r0) {
                r0.lambda$onError$3();
            }

            /* JADX INFO: renamed from: $r8$lambda$emUg-EPmQhZ_TMScuU1tGA198Eg, reason: not valid java name */
            public static /* synthetic */ void m8207$r8$lambda$emUgEPmQhZ_TMScuU1tGA198Eg(RemoteSoundTriggerDetectionService r0, int r1, int r2, ISoundTriggerDetectionService r3) {
                r0.lambda$onError$4(r1, r2, r3);
            }

            /* JADX INFO: renamed from: $r8$lambda$g55U78Hre4NtE0CZQtNQ2yTTw-I, reason: not valid java name */
            public static /* synthetic */ void m8208$r8$lambda$g55U78Hre4NtE0CZQtNQ2yTTwI(RemoteSoundTriggerDetectionService r0) {
                r0.stopAllPendingOperations();
            }

            public static /* synthetic */ void $r8$lambda$vyP5nVaAe7mEce9L_8n88okovSE(RemoteSoundTriggerDetectionService r0, SoundTrigger.GenericRecognitionEvent r1, int r2, ISoundTriggerDetectionService r3) {
                r0.lambda$onGenericSoundTriggerDetected$1(r1, r2, r3);
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmDestroyOnceRunningOpsDone, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m8209$$Nest$fgetmDestroyOnceRunningOpsDone(RemoteSoundTriggerDetectionService r0) {
                return r0.mDestroyOnceRunningOpsDone;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmPendingOps, reason: not valid java name */
            static /* bridge */ /* synthetic */ ArrayList m8210$$Nest$fgetmPendingOps(RemoteSoundTriggerDetectionService r0) {
                return r0.mPendingOps;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmRemoteServiceLock, reason: not valid java name */
            static /* bridge */ /* synthetic */ Object m8211$$Nest$fgetmRemoteServiceLock(RemoteSoundTriggerDetectionService r0) {
                return r0.mRemoteServiceLock;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmRunningOpIds, reason: not valid java name */
            static /* bridge */ /* synthetic */ ArraySet m8212$$Nest$fgetmRunningOpIds(RemoteSoundTriggerDetectionService r0) {
                return r0.mRunningOpIds;
            }

            /* JADX INFO: renamed from: -$$Nest$mdestroy, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m8213$$Nest$mdestroy(RemoteSoundTriggerDetectionService r0) {
                r0.destroy();
            }

            /* JADX INFO: renamed from: -$$Nest$mdisconnectLocked, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m8214$$Nest$mdisconnectLocked(RemoteSoundTriggerDetectionService r0) {
                r0.disconnectLocked();
            }

            public RemoteSoundTriggerDetectionService(final SoundTriggerSessionStub r6, UUID modelUuid, Bundle params, ComponentName serviceName, UserHandle user, SoundTrigger.RecognitionConfig config) {
                this.this$1 = r6;
                this.mRemoteServiceLock = new Object();
                this.mPendingOps = new ArrayList();
                this.mRunningOpIds = new ArraySet();
                this.mPuuid = new ParcelUuid(modelUuid);
                this.mParams = params;
                this.mServiceName = serviceName;
                this.mUser = user;
                this.mRecognitionConfig = config;
                this.mHandler = new Handler(Looper.getMainLooper());
                PowerManager pm = (PowerManager) SoundTriggerService.m8187$$Nest$fgetmContext(r6.this$0).getSystemService("power");
                this.mRemoteServiceWakeLock = pm.newWakeLock(1, "RemoteSoundTriggerDetectionService " + this.mServiceName.getPackageName() + ":" + this.mServiceName.getClassName());
                Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(r6.this$0);
                monitor-enter(r1);
                NumOps numOps = (NumOps) SoundTriggerService.m8193$$Nest$fgetmNumOpsPerPackage(r6.this$0).get(this.mServiceName.getPackageName());     // Catch: Throwable -> L7
                if (numOps != null) goto L9;
                numOps = new NumOps(null);     // Catch: Throwable -> L7
                SoundTriggerService.m8193$$Nest$fgetmNumOpsPerPackage(r6.this$0).put(this.mServiceName.getPackageName(), numOps);     // Catch: Throwable -> L7
            L9:
                this.mNumOps = numOps;     // Catch: Throwable -> L7
                monitor-exit(r1);     // Catch: Throwable -> L7
                this.mClient = new AnonymousClass1(this, r6);
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public boolean pingBinder() {
                if (this.mIsDestroyed == false) goto L5;
            L7:
                return false;
            L5:
                if (this.mDestroyOnceRunningOpsDone == true) goto L7;
                return true;
            }

            private void disconnectLocked() {
                if (this.mService == null) goto L10;
                this.mService.removeClient(this.mPuuid);     // Catch: Exception -> L6
            L8:
                this.mService = null;
            L6:
                e = move-exception;
                Slog.e(SoundTriggerService.TAG, this.mPuuid + ": Cannot remove client", e);
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": Cannot remove client"));
            L10:
                if (this.mIsBound == false) goto L19;
                SoundTriggerService.m8187$$Nest$fgetmContext(this.this$1.this$0).unbindService(this);
                this.mIsBound = false;
                Object r0 = SoundTriggerSessionStub.m8204$$Nest$fgetmCallbacksLock(this.this$1);
                monitor-enter(r0);
                this.mRemoteServiceWakeLock.release();     // Catch: Throwable -> L16
                monitor-exit(r0);     // Catch: Throwable -> L16
                return;
            L16:
                th = move-exception;
                throw th;
            }

            private void destroy() {
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": destroy"));
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
                disconnectLocked();     // Catch: Throwable -> L17
                this.mIsDestroyed = true;     // Catch: Throwable -> L17
                monitor-exit(r0);     // Catch: Throwable -> L17
                if (this.mDestroyOnceRunningOpsDone == true) goto L16;
                Object r1 = SoundTriggerSessionStub.m8204$$Nest$fgetmCallbacksLock(this.this$1);
                monitor-enter(r1);
                SoundTriggerSessionStub.m8203$$Nest$fgetmCallbacks(this.this$1).remove(this.mPuuid.getUuid());     // Catch: Throwable -> L13
                monitor-exit(r1);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            L16:
                return;
            L17:
                th = move-exception;
                throw th;
            }

            private void stopAllPendingOperations() {
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
            L8:
                th = move-exception;
                throw th;
            L5:
                if (this.mIsDestroyed == false) goto L11;
                monitor-exit(r0);     // Catch: Throwable -> L8
                return;
            L11:
                if (this.mService == null) goto L21;
                int numOps = this.mRunningOpIds.size();     // Catch: Throwable -> L8
                int i = 0;
            L14:
                if (i >= numOps) goto L20;
                this.mService.onStopOperation(this.mPuuid, this.mRunningOpIds.valueAt(i).intValue());     // Catch: Throwable -> L8 Exception -> L17
            L19:
                i = i + 1;     // Catch: Throwable -> L8
            L17:
                e = move-exception;
                Slog.e(SoundTriggerService.TAG, this.mPuuid + ": Could not stop operation " + this.mRunningOpIds.valueAt(i), e);     // Catch: Throwable -> L8
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": Could not stop operation " + this.mRunningOpIds.valueAt(i)));     // Catch: Throwable -> L8
                goto L19
            L20:
                this.mRunningOpIds.clear();     // Catch: Throwable -> L8
            L21:
                disconnectLocked();     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
            }

            private void bind() {
                long token = Binder.clearCallingIdentity();
                Intent i = new Intent();     // Catch: Throwable -> L9
                i.setComponent(this.mServiceName);     // Catch: Throwable -> L9
                ResolveInfo ri = SoundTriggerService.m8187$$Nest$fgetmContext(this.this$1.this$0).getPackageManager().resolveServiceAsUser(i, 268435588, this.mUser.getIdentifier());     // Catch: Throwable -> L9
                if (ri != null) goto L12;
                Slog.w(SoundTriggerService.TAG, this.mPuuid + ": " + this.mServiceName + " not found");     // Catch: Throwable -> L9
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": " + this.mServiceName + " not found"));     // Catch: Throwable -> L9
                Binder.restoreCallingIdentity(token);
                return;
            L12:
                if ("android.permission.BIND_SOUND_TRIGGER_DETECTION_SERVICE".equals(ri.serviceInfo.permission) == true) goto L16;
                Slog.w(SoundTriggerService.TAG, this.mPuuid + ": " + this.mServiceName + " does not require android.permission.BIND_SOUND_TRIGGER_DETECTION_SERVICE");     // Catch: Throwable -> L9
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": " + this.mServiceName + " does not require android.permission.BIND_SOUND_TRIGGER_DETECTION_SERVICE"));     // Catch: Throwable -> L9
                Binder.restoreCallingIdentity(token);
                return;
            L16:
                this.mIsBound = SoundTriggerService.m8187$$Nest$fgetmContext(this.this$1.this$0).bindServiceAsUser(i, this, 67112961, this.mUser);     // Catch: Throwable -> L9
                if (this.mIsBound == false) goto L19;
                this.mRemoteServiceWakeLock.acquire();     // Catch: Throwable -> L9
            L20:
                Binder.restoreCallingIdentity(token);
                return;
            L19:
                Slog.w(SoundTriggerService.TAG, this.mPuuid + ": Could not bind to " + this.mServiceName);     // Catch: Throwable -> L9
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": Could not bind to " + this.mServiceName));     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                Binder.restoreCallingIdentity(token);
                throw th;
            }

            private void runOrAddOperation(Operation op) {
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
            L14:
                th = move-exception;
                throw th;
            L5:
                if (this.mIsDestroyed == true) goto L34;
                if (this.mDestroyOnceRunningOpsDone == true) goto L34;
                if (this.mService != null) goto L16;
                this.mPendingOps.add(op);     // Catch: Throwable -> L14
                if (this.mIsBound == true) goto L32;
                bind();     // Catch: Throwable -> L14
            L32:
                monitor-exit(r0);     // Catch: Throwable -> L14
                return;
            L16:
                long currentTime = System.nanoTime();     // Catch: Throwable -> L14
                this.mNumOps.clearOldOps(currentTime);     // Catch: Throwable -> L14
                Settings.Global.getInt(SoundTriggerService.m8187$$Nest$fgetmContext(this.this$1.this$0).getContentResolver(), "max_sound_trigger_detection_service_ops_per_day", Integer.MAX_VALUE);     // Catch: Throwable -> L14
                this.mNumOps.getOpsAdded();     // Catch: Throwable -> L14
                this.mNumOps.addOp(currentTime);     // Catch: Throwable -> L14
                int opId = this.mNumTotalOpsPerformed;     // Catch: Throwable -> L14
            L17:
                this.mNumTotalOpsPerformed++;     // Catch: Throwable -> L14
                if (this.mRunningOpIds.contains(Integer.valueOf(opId)) == true) goto L17;
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": runOp " + opId);     // Catch: Throwable -> L14 Exception -> L21
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": runOp " + opId));     // Catch: Throwable -> L14 Exception -> L21
                op.run(opId, this.mService);     // Catch: Throwable -> L14 Exception -> L21
                this.mRunningOpIds.add(Integer.valueOf(opId));     // Catch: Throwable -> L14 Exception -> L21
            L24:
                if (this.mPendingOps.isEmpty() == true) goto L26;
            L31:
                this.mHandler.removeMessages(1);     // Catch: Throwable -> L14
                this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new SoundTriggerService$SoundTriggerSessionStub$RemoteSoundTriggerDetectionService$$ExternalSyntheticLambda0(), this).setWhat(1), Settings.Global.getLong(SoundTriggerService.m8187$$Nest$fgetmContext(this.this$1.this$0).getContentResolver(), "sound_trigger_detection_service_op_timeout", Long.MAX_VALUE));     // Catch: Throwable -> L14
                goto L32
            L26:
                if (this.mRunningOpIds.isEmpty() == false) goto L31;
                if (this.mDestroyOnceRunningOpsDone == false) goto L30;
                destroy();     // Catch: Throwable -> L14
                goto L32
            L30:
                disconnectLocked();     // Catch: Throwable -> L14
            L21:
                e = move-exception;
                Slog.e(SoundTriggerService.TAG, this.mPuuid + ": Could not run operation " + opId, e);     // Catch: Throwable -> L14
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": Could not run operation " + opId));     // Catch: Throwable -> L14
            L34:
                Slog.w(SoundTriggerService.TAG, this.mPuuid + ": Dropped operation as already destroyed or marked for destruction");     // Catch: Throwable -> L14
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ":Dropped operation as already destroyed or marked for destruction"));     // Catch: Throwable -> L14
                op.drop();     // Catch: Throwable -> L14
                monitor-exit(r0);     // Catch: Throwable -> L14
            }

            public void onKeyphraseDetected(SoundTrigger.KeyphraseRecognitionEvent event) {
            }

            private AudioRecord createAudioRecordForEvent(SoundTrigger.GenericRecognitionEvent event) throws IllegalArgumentException, UnsupportedOperationException {
                AudioAttributes.Builder attributesBuilder = new AudioAttributes.Builder();
                attributesBuilder.setInternalCapturePreset(1999);
                AudioAttributes attributes = attributesBuilder.build();
                AudioFormat originalFormat = event.getCaptureFormat();
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent("createAudioRecordForEvent"));
                return new AudioRecord.Builder().setAudioAttributes(attributes).setAudioFormat(new AudioFormat.Builder().setChannelMask(originalFormat.getChannelMask()).setEncoding(originalFormat.getEncoding()).setSampleRate(originalFormat.getSampleRate()).build()).setSessionId(event.getCaptureSession()).build();
            }

            public void onGenericSoundTriggerDetected(final SoundTrigger.GenericRecognitionEvent event) {
                runOrAddOperation(new Operation(new SoundTriggerService$SoundTriggerSessionStub$RemoteSoundTriggerDetectionService$$ExternalSyntheticLambda1(this), new SoundTriggerService$SoundTriggerSessionStub$RemoteSoundTriggerDetectionService$$ExternalSyntheticLambda2(this, event), new SoundTriggerService$SoundTriggerSessionStub$RemoteSoundTriggerDetectionService$$ExternalSyntheticLambda3(this, event), null));
            }

            private /* synthetic */ void lambda$onGenericSoundTriggerDetected$0() {
                if (this.mRecognitionConfig.isMultipleTriggersAllowed() == true) goto L12;
                Object r0 = SoundTriggerSessionStub.m8204$$Nest$fgetmCallbacksLock(this.this$1);
                monitor-enter(r0);
                SoundTriggerSessionStub.m8203$$Nest$fgetmCallbacks(this.this$1).remove(this.mPuuid.getUuid());     // Catch: Throwable -> L9
                monitor-exit(r0);     // Catch: Throwable -> L9
                this.mDestroyOnceRunningOpsDone = true;
                return;
            L9:
                th = move-exception;
                throw th;
            }

            private /* synthetic */ void lambda$onGenericSoundTriggerDetected$1(SoundTrigger.GenericRecognitionEvent event, int opId, ISoundTriggerDetectionService service) throws RemoteException {
                service.onGenericRecognitionEvent(this.mPuuid, opId, event);
            }

            private /* synthetic */ void lambda$onGenericSoundTriggerDetected$2(SoundTrigger.GenericRecognitionEvent event) {
                if (event.isCaptureAvailable() == false) goto L11;
                AudioRecord capturedData = createAudioRecordForEvent(event);     // Catch: Throwable -> L6
                capturedData.startRecording();     // Catch: Throwable -> L6
                capturedData.release();     // Catch: Throwable -> L6
                return;
            L7:
                Slog.w(SoundTriggerService.TAG, this.mPuuid + ": createAudioRecordForEvent(" + event + "), failed to create AudioRecord");
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private void onError(final int r6) {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onError: " + r6);
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": onError: " + r6));
                runOrAddOperation(new Operation(new SoundTriggerService$SoundTriggerSessionStub$RemoteSoundTriggerDetectionService$$ExternalSyntheticLambda4(this), new SoundTriggerService$SoundTriggerSessionStub$RemoteSoundTriggerDetectionService$$ExternalSyntheticLambda5(this, r6), null, 0 == true ? 1 : 0));
            }

            private /* synthetic */ void lambda$onError$3() {
                Object r0 = SoundTriggerSessionStub.m8204$$Nest$fgetmCallbacksLock(this.this$1);
                monitor-enter(r0);
                SoundTriggerSessionStub.m8203$$Nest$fgetmCallbacks(this.this$1).remove(this.mPuuid.getUuid());     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                this.mDestroyOnceRunningOpsDone = true;
                return;
            L8:
                th = move-exception;
                throw th;
            }

            private /* synthetic */ void lambda$onError$4(int status, int opId, ISoundTriggerDetectionService service) throws RemoteException {
                service.onError(this.mPuuid, opId, status);
            }

            public void onPreempted() {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onPreempted");
                onError(Integer.MIN_VALUE);
            }

            public void onModuleDied() {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onModuleDied");
                onError(SoundTrigger.STATUS_DEAD_OBJECT);
            }

            public void onResumeFailed(int status) {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onResumeFailed: " + status);
                onError(status);
            }

            public void onPauseFailed(int status) {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onPauseFailed: " + status);
                onError(status);
            }

            public void onRecognitionPaused() {
            }

            public void onRecognitionResumed() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onServiceConnected(" + service + ")");
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": onServiceConnected(" + service + ")"));
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
                this.mService = ISoundTriggerDetectionService.Stub.asInterface(service);     // Catch: Throwable -> L9
                this.mService.setClient(this.mPuuid, this.mParams, this.mClient);     // Catch: Throwable -> L9 Exception -> L13
            L7:
                if (this.mPendingOps.isEmpty() == true) goto L11;
                runOrAddOperation(this.mPendingOps.remove(0));     // Catch: Throwable -> L9
                goto L7
            L11:
                monitor-exit(r0);     // Catch: Throwable -> L9
                return;
            L13:
                e = move-exception;
                Slog.e(SoundTriggerService.TAG, this.mPuuid + ": Could not init " + this.mServiceName, e);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onServiceDisconnected");
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": onServiceDisconnected"));
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
                this.mService = null;     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                return;
            L8:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onBindingDied(ComponentName name) {
                Slog.v(SoundTriggerService.TAG, this.mPuuid + ": onBindingDied");
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(this.mPuuid + ": onBindingDied"));
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
                destroy();     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName name) {
                Slog.w(SoundTriggerService.TAG, name + " for model " + this.mPuuid + " returned a null binding");
                SoundTriggerSessionStub.m8205$$Nest$fgetmEventLogger(this.this$1).enqueue(new EventLogger.StringEvent(name + " for model " + this.mPuuid + " returned a null binding"));
                Object r0 = this.mRemoteServiceLock;
                monitor-enter(r0);
                disconnectLocked();     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public static /* synthetic */ void $r8$lambda$eUwzt9osHt4HleFc2LqltNBNXY4(SoundTriggerSessionStub r0, DeviceStateHandler.SoundTriggerDeviceState r1) {
            r0.lambda$new$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$v5KUhMJKSsM1xhlXPr5YKNHNsZQ(SoundTriggerSessionStub r0) {
            r0.lambda$new$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ TreeMap m8203$$Nest$fgetmCallbacks(SoundTriggerSessionStub r0) {
            return r0.mCallbacks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbacksLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m8204$$Nest$fgetmCallbacksLock(SoundTriggerSessionStub r0) {
            return r0.mCallbacksLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEventLogger, reason: not valid java name */
        static /* bridge */ /* synthetic */ EventLogger m8205$$Nest$fgetmEventLogger(SoundTriggerSessionStub r0) {
            return r0.mEventLogger;
        }

        SoundTriggerSessionStub(SoundTriggerService this$0, IBinder client, SoundTriggerHelper soundTriggerHelper, EventLogger eventLogger) {
            this.this$0 = this$0;
            this.mLoadedModels = new TreeMap();
            this.mCallbacksLock = new Object();
            this.mCallbacks = new TreeMap();
            this.mSoundTriggerHelper = soundTriggerHelper;
            this.mClient = client;
            this.mOriginatorIdentity = IdentityContext.getNonNull();
            this.mEventLogger = eventLogger;
            SoundTriggerService.m8196$$Nest$fgetmSessionEventLoggers(this$0).add(this.mEventLogger);
            this.mClient.linkToDeath(new SoundTriggerService$SoundTriggerSessionStub$$ExternalSyntheticLambda0(this), 0);     // Catch: RemoteException -> L5
        L7:
            this.mListener = new SoundTriggerService$SoundTriggerSessionStub$$ExternalSyntheticLambda1(this);
            Identity r1 = this.mOriginatorIdentity;
            SoundTriggerHelper r2 = this.mSoundTriggerHelper;
            r2.getClass();
            this.mAppOpsListener = new MyAppOpsListener(this$0, r1, new SoundTriggerService$LocalSoundTriggerService$SessionImpl$$ExternalSyntheticLambda2(r2));
            this.mAppOpsListener.forceOpChangeRefresh();
            SoundTriggerService.m8186$$Nest$fgetmAppOpsManager(this$0).startWatchingMode("android:record_audio", this.mOriginatorIdentity.packageName, 1, this.mAppOpsListener);
            SoundTriggerService.m8191$$Nest$fgetmDeviceStateHandler(this$0).registerListener(this.mListener);
            return;
        L6:
            clientDied();
            goto L7
        }

        private /* synthetic */ void lambda$new$0() {
            clientDied();
        }

        private /* synthetic */ void lambda$new$1(DeviceStateHandler.SoundTriggerDeviceState state) {
            this.mSoundTriggerHelper.onDeviceStateChanged(state);
        }

        public int startRecognition(SoundTrigger.GenericSoundModel soundModel, IRecognitionStatusCallback callback, SoundTrigger.RecognitionConfig config, boolean runInBatterySaverMode) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION, getUuid(soundModel)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L26
            if (soundModel != null) goto L12;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION, getUuid(soundModel), "Invalid sound model").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L10
            if (ignored == null) goto L43;
            ignored.close();
            return Integer.MIN_VALUE;
        L43:
            return Integer.MIN_VALUE;
        L12:
            if (runInBatterySaverMode == false) goto L14;
            enforceCallingPermission("android.permission.SOUND_TRIGGER_RUN_IN_BATTERY_SAVER");     // Catch: Throwable -> L10
        L14:
            int ret = this.mSoundTriggerHelper.startGenericRecognition(soundModel.getUuid(), soundModel, callback, config, runInBatterySaverMode);     // Catch: Throwable -> L20
            if (ret != 0) goto L23;
            SoundTriggerService.m8198$$Nest$fgetmSoundModelStatTracker(this.this$0).onStart(soundModel.getUuid());     // Catch: Throwable -> L20
        L23:
            if (ignored == null) goto L25;
            ignored.close();
        L25:
            return ret;
        L20:
            th = move-exception;
            Throwable r9 = th;
        L28:
            if (ignored == null) goto L41;
            ignored.close();     // Catch: Throwable -> L31
            throw r9;
        L31:
            th = move-exception;
            r9.addSuppressed(th);
            throw r9;
        L41:
            throw r9;
        L10:
            th = move-exception;
            r9 = th;
        L26:
            th = move-exception;
            r9 = th;
            goto L28
        }

        public int stopRecognition(ParcelUuid parcelUuid, IRecognitionStatusCallback callback) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION, getUuid(parcelUuid)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L7
            int ret = this.mSoundTriggerHelper.stopGenericRecognition(parcelUuid.getUuid(), callback);     // Catch: Throwable -> L7
            if (ret != 0) goto L10;
            SoundTriggerService.m8198$$Nest$fgetmSoundModelStatTracker(this.this$0).onStop(parcelUuid.getUuid());     // Catch: Throwable -> L7
        L10:
            if (ignored == null) goto L12;
            ignored.close();
        L12:
            return ret;
        L7:
            th = move-exception;
            if (ignored != null) goto L19;
        L18:
            throw th;
        L19:
            ignored.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);
            goto L18
        }

        public SoundTrigger.GenericSoundModel getSoundModel(ParcelUuid soundModelId) {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L7
            SoundTrigger.GenericSoundModel model = SoundTriggerService.m8188$$Nest$fgetmDbHelper(this.this$0).getGenericSoundModel(soundModelId.getUuid());     // Catch: Throwable -> L7
            if (ignored == null) goto L6;
            ignored.close();
        L6:
            return model;
        L7:
            th = move-exception;
            if (ignored != null) goto L14;
        L13:
            throw th;
        L14:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void updateSoundModel(SoundTrigger.GenericSoundModel soundModel) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.UPDATE_MODEL, getUuid(soundModel)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L7
            SoundTriggerService.m8188$$Nest$fgetmDbHelper(this.this$0).updateGenericSoundModel(soundModel);     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public void deleteSoundModel(ParcelUuid soundModelId) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.DELETE_MODEL, getUuid(soundModelId)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L7
            this.mSoundTriggerHelper.unloadGenericSoundModel(soundModelId.getUuid());     // Catch: Throwable -> L7
            SoundTriggerService.m8198$$Nest$fgetmSoundModelStatTracker(this.this$0).onStop(soundModelId.getUuid());     // Catch: Throwable -> L7
            SoundTriggerService.m8188$$Nest$fgetmDbHelper(this.this$0).deleteGenericSoundModel(soundModelId.getUuid());     // Catch: Throwable -> L7
            if (ignored == null) goto L18;
            ignored.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (ignored != null) goto L16;
        L13:
            throw th;
        L16:
            ignored.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }

        public int loadGenericSoundModel(SoundTrigger.GenericSoundModel soundModel) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.LOAD_MODEL, getUuid(soundModel)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L32
            if (soundModel == null) goto L34;
            if (soundModel.getUuid() == null) goto L34;
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L32
            monitor-enter(r1);     // Catch: Throwable -> L32
            SoundTrigger.SoundModel oldModel = this.mLoadedModels.get(soundModel.getUuid());     // Catch: Throwable -> L22
            if (oldModel != null) goto L13;
        L24:
            this.mLoadedModels.put(soundModel.getUuid(), soundModel);     // Catch: Throwable -> L22
            monitor-exit(r1);     // Catch: Throwable -> L22
            if (ignored == null) goto L51;
            ignored.close();
            return 0;
        L51:
            return 0;
        L13:
            if (oldModel.equals(soundModel) == true) goto L24;
            this.mSoundTriggerHelper.unloadGenericSoundModel(soundModel.getUuid());     // Catch: Throwable -> L22
            Object r3 = this.mCallbacksLock;     // Catch: Throwable -> L22
            monitor-enter(r3);     // Catch: Throwable -> L22
            this.mCallbacks.remove(soundModel.getUuid());     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L34:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.LOAD_MODEL, getUuid(soundModel), "Invalid sound model").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L32
            if (ignored == null) goto L52;
            ignored.close();
            return Integer.MIN_VALUE;
        L52:
            return Integer.MIN_VALUE;
        L32:
            th = move-exception;
            if (ignored != null) goto L48;
        L44:
            throw th;
        L48:
            ignored.close();     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            th.addSuppressed(th);
            goto L44
        }

        public int loadKeyphraseSoundModel(SoundTrigger.KeyphraseSoundModel soundModel) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.LOAD_MODEL, getUuid(soundModel)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L36
            if (soundModel == null) goto L42;
            if (soundModel.getUuid() == null) goto L42;
            if (soundModel.getKeyphrases() == null) goto L38;
            if (soundModel.getKeyphrases().length != 1) goto L38;
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L36
            monitor-enter(r1);     // Catch: Throwable -> L36
            SoundTrigger.SoundModel oldModel = this.mLoadedModels.get(soundModel.getUuid());     // Catch: Throwable -> L27
            if (oldModel != null) goto L18;
        L29:
            this.mLoadedModels.put(soundModel.getUuid(), soundModel);     // Catch: Throwable -> L27
            monitor-exit(r1);     // Catch: Throwable -> L27
            if (ignored == null) goto L33;
            ignored.close();
        L33:
            return 0;
        L18:
            if (oldModel.equals(soundModel) == true) goto L29;
            this.mSoundTriggerHelper.unloadKeyphraseSoundModel(soundModel.getKeyphrases()[0].getId());     // Catch: Throwable -> L27
            Object r4 = this.mCallbacksLock;     // Catch: Throwable -> L27
            monitor-enter(r4);     // Catch: Throwable -> L27
            this.mCallbacks.remove(soundModel.getUuid());     // Catch: Throwable -> L24
            monitor-exit(r4);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L38:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.LOAD_MODEL, getUuid(soundModel), "Only one keyphrase supported").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L36
            if (ignored == null) goto L41;
            ignored.close();
        L41:
            return Integer.MIN_VALUE;
        L42:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.LOAD_MODEL, getUuid(soundModel), "Invalid sound model").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L36
            if (ignored == null) goto L45;
            ignored.close();
        L45:
            return Integer.MIN_VALUE;
        L36:
            th = move-exception;
            if (ignored != null) goto L54;
        L51:
            throw th;
        L54:
            ignored.close();     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            th.addSuppressed(th);
            goto L51
        }

        public int startRecognitionForService(ParcelUuid soundModelId, Bundle params, ComponentName detectionService, SoundTrigger.RecognitionConfig config) {
            UserHandle userHandle = Binder.getCallingUserHandle();
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION_SERVICE, getUuid(soundModelId)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            soundModelId.getClass();     // Catch: Throwable -> L57
            detectionService.getClass();     // Catch: Throwable -> L57
            config.getClass();     // Catch: Throwable -> L57
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L57
            enforceDetectionPermissions(detectionService);     // Catch: Throwable -> L57
            IRecognitionStatusCallback callback = new RemoteSoundTriggerDetectionService(this, soundModelId.getUuid(), params, detectionService, userHandle, config);     // Catch: Throwable -> L57
            Object r2 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L57
            monitor-enter(r2);     // Catch: Throwable -> L57
            SoundTrigger.GenericSoundModel r0 = (SoundTrigger.SoundModel) this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (r0 != null) goto L15;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION_SERVICE, getUuid(soundModelId), "Model not loaded").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L11;
            ignored.close();
        L11:
            return Integer.MIN_VALUE;
        L15:
            Object r8 = this.mCallbacksLock;     // Catch: Throwable -> L12
            monitor-enter(r8);     // Catch: Throwable -> L12
            IRecognitionStatusCallback existingCallback = this.mCallbacks.get(soundModelId.getUuid());     // Catch: Throwable -> L52
            monitor-exit(r8);     // Catch: Throwable -> L52
            if (existingCallback == null) goto L26;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION_SERVICE, getUuid(soundModelId), "Model already running").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L24;
            ignored.close();
        L24:
            return Integer.MIN_VALUE;
        L26:
            switch(r0.getType()) {
                case 1: goto L32;
                default: goto L27;
            };     // Catch: Throwable -> L12
        L27:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION_SERVICE, getUuid(soundModelId), "Unsupported model type").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L31;
            ignored.close();
        L31:
            return Integer.MIN_VALUE;
        L32:
            int ret = this.mSoundTriggerHelper.startGenericRecognition(r0.getUuid(), r0, callback, config, false);     // Catch: Throwable -> L12
            if (ret == 0) goto L39;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.START_RECOGNITION_SERVICE, getUuid(soundModelId), "Model start fail").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L38;
            ignored.close();
        L38:
            return ret;
        L39:
            Object r4 = this.mCallbacksLock;     // Catch: Throwable -> L12
            monitor-enter(r4);     // Catch: Throwable -> L12
            this.mCallbacks.put(soundModelId.getUuid(), callback);     // Catch: Throwable -> L49
            monitor-exit(r4);     // Catch: Throwable -> L49
            SoundTriggerService.m8198$$Nest$fgetmSoundModelStatTracker(this.this$0).onStart(soundModelId.getUuid());     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L75;
            ignored.close();
            return 0;
        L75:
            return 0;
        L49:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L52:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            if (ignored == null) goto L73;
            ignored.close();     // Catch: Throwable -> L62
            throw th;
        L62:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L73:
            throw th;
        }

        public int stopRecognitionForService(ParcelUuid soundModelId) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION_SERVICE, getUuid(soundModelId)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L57
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L57
            monitor-enter(r1);     // Catch: Throwable -> L57
            SoundTrigger.SoundModel soundModel = this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (soundModel != null) goto L15;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION_SERVICE, getUuid(soundModelId), "Model not loaded").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L11;
            ignored.close();
        L11:
            return Integer.MIN_VALUE;
        L15:
            Object r6 = this.mCallbacksLock;     // Catch: Throwable -> L12
            monitor-enter(r6);     // Catch: Throwable -> L12
            IRecognitionStatusCallback callback = this.mCallbacks.get(soundModelId.getUuid());     // Catch: Throwable -> L52
            monitor-exit(r6);     // Catch: Throwable -> L52
            if (callback != null) goto L26;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION_SERVICE, getUuid(soundModelId), "Model not running").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L24;
            ignored.close();
        L24:
            return Integer.MIN_VALUE;
        L26:
            switch(soundModel.getType()) {
                case 1: goto L32;
                default: goto L27;
            };     // Catch: Throwable -> L12
        L27:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION_SERVICE, getUuid(soundModelId), "Unknown model type").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L31;
            ignored.close();
        L31:
            return Integer.MIN_VALUE;
        L32:
            int ret = this.mSoundTriggerHelper.stopGenericRecognition(soundModel.getUuid(), callback);     // Catch: Throwable -> L12
            if (ret == 0) goto L39;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.STOP_RECOGNITION_SERVICE, getUuid(soundModelId), "Failed to stop model").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L38;
            ignored.close();
        L38:
            return ret;
        L39:
            Object r4 = this.mCallbacksLock;     // Catch: Throwable -> L12
            monitor-enter(r4);     // Catch: Throwable -> L12
            this.mCallbacks.remove(soundModelId.getUuid());     // Catch: Throwable -> L49
            monitor-exit(r4);     // Catch: Throwable -> L49
            SoundTriggerService.m8198$$Nest$fgetmSoundModelStatTracker(this.this$0).onStop(soundModelId.getUuid());     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L72;
            ignored.close();
            return 0;
        L72:
            return 0;
        L49:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L52:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            if (ignored != null) goto L66;
        L63:
            throw th;
        L66:
            ignored.close();     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            th.addSuppressed(th);
            goto L63
        }

        public int unloadSoundModel(ParcelUuid soundModelId) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.UNLOAD_MODEL, getUuid(soundModelId)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L36
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L36
            monitor-enter(r1);     // Catch: Throwable -> L36
            SoundTrigger.KeyphraseSoundModel r2 = (SoundTrigger.SoundModel) this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (r2 != null) goto L15;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.UNLOAD_MODEL, getUuid(soundModelId), "Model not loaded").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L11;
            ignored.close();
        L11:
            return Integer.MIN_VALUE;
        L15:
            switch(r2.getType()) {
                case 0: goto L22;
                case 1: goto L21;
                default: goto L16;
            };     // Catch: Throwable -> L12
        L16:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.UNLOAD_MODEL, getUuid(soundModelId), "Unknown model type").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L20;
            ignored.close();
        L20:
            return Integer.MIN_VALUE;
        L21:
            int ret = this.mSoundTriggerHelper.unloadGenericSoundModel(r2.getUuid());     // Catch: Throwable -> L12
        L23:
            if (ret == 0) goto L29;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.UNLOAD_MODEL, getUuid(soundModelId), "Failed to unload model").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L28;
            ignored.close();
        L28:
            return ret;
        L29:
            this.mLoadedModels.remove(soundModelId.getUuid());     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L33;
            ignored.close();
        L33:
            return 0;
        L22:
            ret = this.mSoundTriggerHelper.unloadKeyphraseSoundModel(r2.getKeyphrases()[0].getId());     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            if (ignored != null) goto L44;
        L42:
            throw th;
        L44:
            ignored.close();     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            th.addSuppressed(th);
            goto L42
        }

        public boolean isRecognitionActive(ParcelUuid parcelUuid) {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L20
            Object r1 = this.mCallbacksLock;     // Catch: Throwable -> L20
            monitor-enter(r1);     // Catch: Throwable -> L20
            IRecognitionStatusCallback callback = this.mCallbacks.get(parcelUuid.getUuid());     // Catch: Throwable -> L12
            if (callback != null) goto L15;
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L34;
            ignored.close();
            return false;
        L34:
            return false;
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L12
            boolean r2 = this.mSoundTriggerHelper.isRecognitionRequested(parcelUuid.getUuid());     // Catch: Throwable -> L20
            if (ignored == null) goto L19;
            ignored.close();
        L19:
            return r2;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            if (ignored != null) goto L30;
        L29:
            throw th;
        L30:
            ignored.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.addSuppressed(th);
            goto L29
        }

        public int getModelState(ParcelUuid soundModelId) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.GET_MODEL_STATE, getUuid(soundModelId)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L24
            int ret = Integer.MIN_VALUE;
            Object r2 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L24
            monitor-enter(r2);     // Catch: Throwable -> L24
            SoundTrigger.SoundModel soundModel = this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (soundModel != null) goto L15;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.GET_MODEL_STATE, getUuid(soundModelId), "Model is not loaded").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L11;
            ignored.close();
        L11:
            return Integer.MIN_VALUE;
        L15:
            switch(soundModel.getType()) {
                case 1: goto L17;
                default: goto L16;
            };     // Catch: Throwable -> L12
        L16:
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.GET_MODEL_STATE, getUuid(soundModelId), "Unsupported model type").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
        L18:
            monitor-exit(r2);     // Catch: Throwable -> L12
            if (ignored == null) goto L21;
            ignored.close();
        L21:
            return ret;
        L17:
            ret = this.mSoundTriggerHelper.getGenericModelState(soundModel.getUuid());     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            if (ignored != null) goto L33;
        L30:
            throw th;
        L33:
            ignored.close();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            th.addSuppressed(th);
            goto L30
        }

        public SoundTrigger.ModuleProperties getModuleProperties() {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.GET_MODULE_PROPERTIES, null));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L13
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L13
            monitor-enter(r1);     // Catch: Throwable -> L13
            SoundTrigger.ModuleProperties properties = this.mSoundTriggerHelper.getModuleProperties();     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            if (ignored == null) goto L9;
            ignored.close();
        L9:
            return properties;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (ignored != null) goto L20;
        L19:
            throw th;
        L20:
            ignored.close();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.addSuppressed(th);
            goto L19
        }

        public int setParameter(ParcelUuid soundModelId, int modelParam, int value) {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.SET_PARAMETER, getUuid(soundModelId)));
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L21
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L21
            monitor-enter(r1);     // Catch: Throwable -> L21
            SoundTrigger.SoundModel soundModel = this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (soundModel != null) goto L14;
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.SET_PARAMETER, getUuid(soundModelId), "Model not loaded").printLog(2, SoundTriggerService.TAG));     // Catch: Throwable -> L12
            int r3 = SoundTrigger.STATUS_BAD_VALUE;     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L11;
            ignored.close();
        L11:
            return r3;
        L14:
            int r4 = this.mSoundTriggerHelper.setParameter(soundModel.getUuid(), modelParam, value);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L18;
            ignored.close();
        L18:
            return r4;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            if (ignored != null) goto L30;
        L27:
            throw th;
        L30:
            ignored.close();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            th.addSuppressed(th);
            goto L27
        }

        public int getParameter(ParcelUuid soundModelId, int modelParam) throws UnsupportedOperationException, IllegalArgumentException {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L18
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r1);     // Catch: Throwable -> L18
            SoundTrigger.SoundModel soundModel = this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (soundModel == null) goto L15;
            int r3 = this.mSoundTriggerHelper.getParameter(soundModel.getUuid(), modelParam);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L11;
            ignored.close();
        L11:
            return r3;
        L15:
            throw new IllegalArgumentException("sound model is not loaded");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            if (ignored != null) goto L25;
        L24:
            throw th;
        L25:
            ignored.close();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            th.addSuppressed(th);
            goto L24
        }

        public SoundTrigger.ModelParamRange queryParameter(ParcelUuid soundModelId, int modelParam) {
            SafeCloseable ignored = ClearCallingIdentityContext.create();
            enforceCallingPermission("android.permission.MANAGE_SOUND_TRIGGER");     // Catch: Throwable -> L21
            Object r1 = SoundTriggerService.m8192$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L21
            monitor-enter(r1);     // Catch: Throwable -> L21
            SoundTrigger.SoundModel soundModel = this.mLoadedModels.get(soundModelId.getUuid());     // Catch: Throwable -> L12
            if (soundModel != null) goto L14;
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L32;
            ignored.close();
            return null;
        L32:
            return null;
        L14:
            SoundTrigger.ModelParamRange r3 = this.mSoundTriggerHelper.queryParameter(soundModel.getUuid(), modelParam);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            if (ignored == null) goto L18;
            ignored.close();
        L18:
            return r3;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            if (ignored != null) goto L28;
        L27:
            throw th;
        L28:
            ignored.close();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            th.addSuppressed(th);
            goto L27
        }

        private void clientDied() {
            this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.DETACH, null));
            SoundTriggerService.m8195$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new SoundTriggerEvent.ServiceEvent(SoundTriggerEvent.ServiceEvent.Type.DETACH, this.mOriginatorIdentity.packageName, "Client died").printLog(2, SoundTriggerService.TAG));
            detach();
        }

        private void detach() {
            if (this.mAppOpsListener == null) goto L5;
            SoundTriggerService.m8186$$Nest$fgetmAppOpsManager(this.this$0).stopWatchingMode(this.mAppOpsListener);
        L5:
            SoundTriggerService.m8191$$Nest$fgetmDeviceStateHandler(this.this$0).unregisterListener(this.mListener);
            this.mSoundTriggerHelper.detach();
            SoundTriggerService.m8199$$Nest$mdetachSessionLogger(this.this$0, this.mEventLogger);
        }

        private void enforceCallingPermission(String permission) {
            if (PermissionUtil.checkPermissionForPreflight(SoundTriggerService.m8187$$Nest$fgetmContext(this.this$0), this.mOriginatorIdentity, permission) != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Identity " + this.mOriginatorIdentity + " does not have permission " + permission);
        }

        private void enforceDetectionPermissions(ComponentName detectionService) {
            String packageName = detectionService.getPackageName();
            if (SoundTriggerService.m8194$$Nest$fgetmPackageManager(this.this$0).checkPermission("android.permission.CAPTURE_AUDIO_HOTWORD", packageName) != 0) goto L6;
            return;
        L6:
            throw new SecurityException(detectionService.getPackageName() + " does not have permission android.permission.CAPTURE_AUDIO_HOTWORD");
        }

        private UUID getUuid(ParcelUuid uuid) {
            if (uuid != null) goto L6;
            return null;
        L6:
            return uuid.getUuid();
        }

        private UUID getUuid(SoundTrigger.SoundModel model) {
            if (model != null) goto L6;
            return null;
        L6:
            return model.getUuid();
        }
    }

    public static /* synthetic */ SoundTriggerModule $r8$lambda$Yd6BNKMVRNYU3nM5WkPaev7hHP4(SoundTriggerService r0, int r1, Identity r2, Identity r3, boolean r4, SoundTrigger.StatusListener r5) {
        return r0.lambda$newSoundTriggerHelper$1(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$iD0ZlB-zFTaC1rrojNzUNSbktNw, reason: not valid java name */
    public static /* synthetic */ List m8185$r8$lambda$iD0ZlBzFTaC1rrojNzUNSbktNw(SoundTriggerService r0, Identity r1) {
        return r0.lambda$newSoundTriggerHelper$2(r1);
    }

    public static /* synthetic */ SoundTrigger.ModuleProperties $r8$lambda$vQgG8E0Ss0PPW5wdvVWfqb9FzEQ(SoundTriggerModuleDescriptor r0) {
        return lambda$listUnderlyingModuleProperties$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m8186$$Nest$fgetmAppOpsManager(SoundTriggerService r0) {
        return r0.mAppOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8187$$Nest$fgetmContext(SoundTriggerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDbHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundTriggerDbHelper m8188$$Nest$fgetmDbHelper(SoundTriggerService r0) {
        return r0.mDbHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDetachedSessionEventLoggers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Deque m8189$$Nest$fgetmDetachedSessionEventLoggers(SoundTriggerService r0) {
        return r0.mDetachedSessionEventLoggers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m8190$$Nest$fgetmDeviceEventLogger(SoundTriggerService r0) {
        return r0.mDeviceEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceStateHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceStateHandler m8191$$Nest$fgetmDeviceStateHandler(SoundTriggerService r0) {
        return r0.mDeviceStateHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8192$$Nest$fgetmLock(SoundTriggerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumOpsPerPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m8193$$Nest$fgetmNumOpsPerPackage(SoundTriggerService r0) {
        return r0.mNumOpsPerPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m8194$$Nest$fgetmPackageManager(SoundTriggerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m8195$$Nest$fgetmServiceEventLogger(SoundTriggerService r0) {
        return r0.mServiceEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionEventLoggers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8196$$Nest$fgetmSessionEventLoggers(SoundTriggerService r0) {
        return r0.mSessionEventLoggers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionIdCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m8197$$Nest$fgetmSessionIdCounter(SoundTriggerService r0) {
        return r0.mSessionIdCounter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundModelStatTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundModelStatTracker m8198$$Nest$fgetmSoundModelStatTracker(SoundTriggerService r0) {
        return r0.mSoundModelStatTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$mdetachSessionLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8199$$Nest$mdetachSessionLogger(SoundTriggerService r0, EventLogger r1) {
        r0.detachSessionLogger(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlistUnderlyingModuleProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m8200$$Nest$mlistUnderlyingModuleProperties(SoundTriggerService r0, Identity r1) {
        return r0.listUnderlyingModuleProperties(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnewSoundTriggerHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundTriggerHelper m8201$$Nest$mnewSoundTriggerHelper(SoundTriggerService r0, SoundTrigger.ModuleProperties r1, EventLogger r2) {
        return r0.newSoundTriggerHelper(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnewSoundTriggerHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundTriggerHelper m8202$$Nest$mnewSoundTriggerHelper(SoundTriggerService r0, SoundTrigger.ModuleProperties r1, EventLogger r2, boolean r3) {
        return r0.newSoundTriggerHelper(r1, r2, r3);
    }

    public SoundTriggerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mServiceEventLogger = new EventLogger(256, "Service");
        this.mDeviceEventLogger = new EventLogger(256, "Device Event");
        this.mSessionEventLoggers = ConcurrentHashMap.newKeySet(4);
        this.mDetachedSessionEventLoggers = new LinkedBlockingDeque(4);
        this.mSessionIdCounter = new AtomicInteger(0);
        this.mNumOpsPerPackage = new ArrayMap();
        this.mDeviceStateHandlerExecutor = Executors.newSingleThreadExecutor();
        this.mContext = context;
        this.mServiceStub = new SoundTriggerServiceStub(this);
        this.mLocalSoundTriggerService = new LocalSoundTriggerService(this, context);
        this.mSoundModelStatTracker = new SoundModelStatTracker(this);
        this.mDeviceStateHandler = new DeviceStateHandler(this.mDeviceStateHandlerExecutor, this.mDeviceEventLogger);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("soundtrigger", this.mServiceStub);
        publishLocalService(SoundTriggerInternal.class, this.mLocalSoundTriggerService);
    }

    private boolean hasCalling() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.calling");
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        Slog.d(TAG, "onBootPhase: " + phase + " : " + isSafeMode());
        if (600 != phase) goto L7;
        this.mDbHelper = new SoundTriggerDbHelper(this.mContext);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mPackageManager = this.mContext.getPackageManager();
        final PowerManager powerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mContext.registerReceiver(new AnonymousClass1(this, powerManager), new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
        this.mDeviceStateHandler.onPowerModeChanged(powerManager.getSoundTriggerPowerSaveMode());
        if (hasCalling() == false) goto L7;
        this.mPhoneCallStateHandler = new PhoneCallStateHandler((SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class), (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class), this.mDeviceStateHandler);
    L7:
        this.mMiddlewareService = ISoundTriggerMiddlewareService.Stub.asInterface(ServiceManager.waitForService("soundtrigger_middleware"));
    }

    private List<SoundTrigger.ModuleProperties> listUnderlyingModuleProperties(Identity originatorIdentity) {
        Identity middlemanIdentity = new Identity();
        middlemanIdentity.packageName = ActivityThread.currentOpPackageName();
        return (List) Arrays.stream(this.mMiddlewareService.listModulesAsMiddleman(middlemanIdentity, originatorIdentity)).map(new SoundTriggerService$$ExternalSyntheticLambda0()).collect(Collectors.toList());
    L7:
        throw new ServiceSpecificException(SoundTrigger.STATUS_DEAD_OBJECT);
    }

    private static /* synthetic */ SoundTrigger.ModuleProperties lambda$listUnderlyingModuleProperties$0(SoundTriggerModuleDescriptor desc) {
        return ConversionUtil.aidl2apiModuleDescriptor(desc);
    }

    private SoundTriggerHelper newSoundTriggerHelper(SoundTrigger.ModuleProperties moduleProperties, EventLogger eventLogger) {
        return newSoundTriggerHelper(moduleProperties, eventLogger, false);
    }

    private SoundTriggerHelper newSoundTriggerHelper(SoundTrigger.ModuleProperties moduleProperties, EventLogger eventLogger, final boolean isTrusted) {
        final Identity middlemanIdentity = new Identity();
        middlemanIdentity.packageName = ActivityThread.currentOpPackageName();
        final Identity originatorIdentity = IdentityContext.getNonNull();
        List<SoundTrigger.ModuleProperties> moduleList = listUnderlyingModuleProperties(originatorIdentity);
        if (moduleProperties == null) goto L5;
        final int moduleId = moduleProperties.getId();
    L6:
        if (moduleId == (-1)) goto L13;
        if (moduleList.contains(moduleProperties) == true) goto L13;
        throw new IllegalArgumentException("Invalid module properties");
    L13:
        return new SoundTriggerHelper(this.mContext, eventLogger, new SoundTriggerService$$ExternalSyntheticLambda1(this, moduleId, middlemanIdentity, originatorIdentity, isTrusted), moduleId, new SoundTriggerService$$ExternalSyntheticLambda2(this, originatorIdentity));
    L5:
        moduleId = -1;
        goto L6
    }

    private /* synthetic */ SoundTriggerModule lambda$newSoundTriggerHelper$1(int moduleId, Identity middlemanIdentity, Identity originatorIdentity, boolean isTrusted, SoundTrigger.StatusListener statusListener) {
        return new SoundTriggerModule(this.mMiddlewareService, moduleId, statusListener, Looper.getMainLooper(), middlemanIdentity, originatorIdentity, isTrusted);
    }

    private /* synthetic */ List lambda$newSoundTriggerHelper$2(Identity originatorIdentity) {
        return listUnderlyingModuleProperties(originatorIdentity);
    }

    private void detachSessionLogger(EventLogger logger) {
        if (this.mSessionEventLoggers.remove(logger) == true) goto L6;
        return;
    L6:
        if (this.mDetachedSessionEventLoggers.offerFirst(logger) == true) goto L8;
        this.mDetachedSessionEventLoggers.pollLast();
        goto L6
    }
}
