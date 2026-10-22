package com.android.server.vibrator;

import android.R;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build;
import android.os.CombinedVibration;
import android.os.ExternalVibration;
import android.os.ExternalVibrationScale;
import android.os.Handler;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.IExternalVibratorService;
import android.os.IVibratorManagerService;
import android.os.IVibratorServiceSmtEx;
import android.os.IVibratorStateListener;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.TikTapVibrationEffect;
import android.os.Trace;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.VibratorInfo;
import android.os.vibrator.IVibrationSessionCallback;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.VibrationConfig;
import android.os.vibrator.VibrationEffectSegment;
import android.os.vibrator.VibratorInfoFactory;
import android.os.vibrator.persistence.ParsedVibration;
import android.os.vibrator.persistence.VibrationXmlParser;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import com.android.server.notification.NotificationShellCmd;
import com.android.server.pm.BackgroundUserSoundNotifier;
import com.android.server.pm.UserManagerInternal;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import libcore.util.NativeAllocationRegistry;
import org.apache.commons.compress.archivers.zip.UnixStat;
import vendor.awinic.hardware.tiktap.vibrator.ITiktapCallback;

/* JADX INFO: loaded from: classes3.dex */
public class VibratorManagerService extends IVibratorManagerService.Stub {
    private static final int ATTRIBUTES_ALL_BYPASS_FLAGS = 3;
    private static final long BATTERY_STATS_REPEATING_VIBRATION_DURATION = 5000;
    private static final boolean DEBUG = false;
    private static final VibrationAttributes DEFAULT_ATTRIBUTES = null;
    private static final int DEFAULT_LOCK_TIME = 3000;
    private static final String EXTERNAL_VIBRATOR_SERVICE = "external_vibrator_service";
    private static final String TAG = "VibratorManagerService";
    private static final boolean TIKTAP_JAVA_TO_HIDL = true;
    private static final long VIBRATION_CANCEL_WAIT_MILLIS = 5000;
    private static final String VIBRATOR_CONTROL_SERVICE = "android.frameworks.vibrator.IVibratorControlService/default";
    private final SparseArray<AlwaysOnVibration> mAlwaysOnEffects;
    private final AppOpsManager mAppOps;
    final AppOpsManager.OnOpChangedInternalListener mAppOpsChangeListener;
    private final IBatteryStats mBatteryStatsService;
    private final long mCapabilities;
    private VibratorInfo mCombinedVibratorInfo;
    private final Context mContext;
    private VibrationSession mCurrentSession;
    private final DeviceAdapter mDeviceAdapter;
    private final ExternalVibrationCallbacks mExternalVibrationCallbacks;
    private final VibratorFrameworkStatsLogger mFrameworkStatsLogger;
    private final Handler mHandler;
    private HapticFeedbackVibrationProvider mHapticFeedbackVibrationProvider;
    private final Injector mInjector;
    private final InputDeviceDelegate mInputDeviceDelegate;
    BroadcastReceiver mIntentReceiver;
    protected final Object mLock;
    private final NativeWrapper mNativeWrapper;
    private VibrationSession mNextSession;
    private boolean mServiceReady;
    private VibratorServiceSmtEx mServiceSmtEx;
    ITiktapCallback mTiktapAidlCallback;
    private final VendorVibrationSessionCallbacks mVendorVibrationSessionCallbacks;
    private final VibrationConfig mVibrationConfig;
    private final VibrationScaler mVibrationScaler;
    final VibrationSettings mVibrationSettings;
    private final VibrationThread mVibrationThread;
    private final VibrationThreadCallbacks mVibrationThreadCallbacks;
    private final VibratorControlService mVibratorControlService;
    private final int[] mVibratorIds;
    private SparseArray<VibratorInfo> mVibratorInfos;
    private final VibratorManagerRecords mVibratorManagerRecords;
    private final SparseArray<VibratorController> mVibrators;
    private final PowerManager.WakeLock mWakeLock;
    private TikTapVibratorService tikTapService;

    /* JADX INFO: renamed from: com.android.server.vibrator.VibratorManagerService$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ VibratorManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$ECyrqMgejyUjUk4rWrvhVC1v6h0(VibratorManagerService r0, VibrationSession r1) {
            return VibratorManagerService.m9349$$Nest$mshouldCancelOnFgUserRequest(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$PVxfgSp8zGujJlQ7K2Kf8OnnJLk(VibratorManagerService r0, VibrationSession r1) {
            return VibratorManagerService.m9350$$Nest$mshouldCancelOnScreenOffLocked(r0, r1);
        }

        AnonymousClass1(VibratorManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF") == false) goto L13;
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            VibratorManagerService r1 = this.this$0;     // Catch: Throwable -> L9
            final VibratorManagerService r2 = this.this$0;     // Catch: Throwable -> L9
            VibratorManagerService.m9342$$Nest$mmaybeClearCurrentAndNextSessionsLocked(r1, new VibratorManagerService$1$$ExternalSyntheticLambda0(r2), VibrationSession.Status.CANCELLED_BY_SCREEN_OFF);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            if (UserManagerInternal.shouldShowNotificationForBackgroundUserSounds() == true) goto L15;
            return;
        L15:
            if (intent.getAction().equals(BackgroundUserSoundNotifier.ACTION_MUTE_SOUND) == false) goto L30;
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            VibratorManagerService r4 = this.this$0;     // Catch: Throwable -> L21
            final VibratorManagerService r5 = this.this$0;     // Catch: Throwable -> L21
            VibratorManagerService.m9342$$Nest$mmaybeClearCurrentAndNextSessionsLocked(r4, new VibratorManagerService$1$$ExternalSyntheticLambda1(r5), VibrationSession.Status.CANCELLED_BY_FOREGROUND_USER);     // Catch: Throwable -> L21
            monitor-exit(r3);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.android.server.vibrator.VibratorManagerService$2, reason: invalid class name */
    class AnonymousClass2 extends AppOpsManager.OnOpChangedInternalListener {
        final /* synthetic */ VibratorManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$D7dDlhWGVGSpdCd8_rA1pzLX7xY(VibratorManagerService r0, VibrationSession r1) {
            return VibratorManagerService.m9348$$Nest$mshouldCancelAppOpModeChangedLocked(r0, r1);
        }

        AnonymousClass2(VibratorManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onOpChanged(int op, String packageName) {
            if (op == 3) goto L5;
            return;
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            VibratorManagerService r1 = this.this$0;     // Catch: Throwable -> L10
            final VibratorManagerService r2 = this.this$0;     // Catch: Throwable -> L10
            VibratorManagerService.m9342$$Nest$mmaybeClearCurrentAndNextSessionsLocked(r1, new VibratorManagerService$2$$ExternalSyntheticLambda0(r2), VibrationSession.Status.CANCELLED_BY_APP_OPS);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.android.server.vibrator.VibratorManagerService$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$vibrator$VibrationSession$Status = null;

        static {
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status = new int[VibrationSession.Status.values().length];
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_BACKGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L35:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_ERROR_APP_OPS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L27:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_EXTERNAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L25:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_HIGHER_IMPORTANCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L29:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_ONGOING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FOR_RINGER_MODE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            $SwitchMap$com$android$server$vibrator$VibrationSession$Status[VibrationSession.Status.IGNORED_FROM_VIRTUAL_DEVICE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    private static final class AlwaysOnVibration {
        public final int alwaysOnId;
        public final VibrationSession.CallerInfo callerInfo;
        public final SparseArray<PrebakedSegment> effects;

        AlwaysOnVibration(int alwaysOnId, VibrationSession.CallerInfo callerInfo, SparseArray<PrebakedSegment> effects) {
            this.alwaysOnId = alwaysOnId;
            this.callerInfo = callerInfo;
            this.effects = effects;
        }
    }

    private final class ExternalVibrationCallbacks implements ExternalVibrationSession.VibratorManagerHooks {
        final /* synthetic */ VibratorManagerService this$0;

        /* synthetic */ ExternalVibrationCallbacks(VibratorManagerService r1, VibratorManagerServiceIA r2) {
            this(r1);
        }

        private ExternalVibrationCallbacks(VibratorManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.vibrator.ExternalVibrationSession.VibratorManagerHooks
        public void onExternalVibrationReleased(long vibrationId) {
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(VibratorManagerService.TAG, "External vibration " + vibrationId + " released");
        L5:
            Trace.traceBegin(8388608, "onExternalVibrationReleased");
            Object r0 = this.this$0.mLock;     // Catch: Throwable -> L29
            monitor-enter(r0);     // Catch: Throwable -> L29
            VibrationSession r3 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L15
            if ((r3 instanceof ExternalVibrationSession) == false) goto L22;
            ExternalVibrationSession session = (ExternalVibrationSession) r3;     // Catch: Throwable -> L15
            if (Build.IS_DEBUGGABLE == true) goto L13;
        L17:
            VibratorManagerService.m9347$$Nest$msetExternalControl(this.this$0, false, session.stats);     // Catch: Throwable -> L15
            VibratorManagerService.m9333$$Nest$mclearCurrentSessionLocked(this.this$0);     // Catch: Throwable -> L15
            VibratorManagerService.m9343$$Nest$mmaybeStartNextSessionLocked(this.this$0);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L13:
            if (session.id == vibrationId) goto L17;
            Slog.wtf(VibratorManagerService.TAG, TextUtils.formatSimple("VibrationId mismatch on external vibration release. expected=%d, released=%d", new Object[]{Long.valueOf(session.id), Long.valueOf(vibrationId)}));     // Catch: Throwable -> L15
            goto L17
        L22:
            if (Build.IS_DEBUGGABLE == false) goto L24;
            Slog.wtf(VibratorManagerService.TAG, "VibrationSession invalid on external vibration release. currentSession=" + VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0));     // Catch: Throwable -> L15
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }
    }

    final class ExternalVibratorService extends IExternalVibratorService.Stub {
        final /* synthetic */ VibratorManagerService this$0;

        ExternalVibratorService(VibratorManagerService this$0) {
            this.this$0 = this$0;
        }

        public ExternalVibrationScale onExternalVibrationStart(ExternalVibration vib) {
            Trace.traceBegin(8388608, "onExternalVibrationStart");
            ExternalVibrationSession session = new ExternalVibrationSession(vib, VibratorManagerService.m9323$$Nest$fgetmExternalVibrationCallbacks(this.this$0));     // Catch: Throwable -> L60
            session.muteScale();     // Catch: Throwable -> L60
            boolean waitForCompletion = false;
            Object r4 = this.this$0.mLock;     // Catch: Throwable -> L60
            monitor-enter(r4);     // Catch: Throwable -> L60
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L60
        L6:
            if (hasExternalControlCapability() == true) goto L14;
            VibratorManagerService.m9337$$Nest$mendSessionLocked(this.this$0, session, VibrationSession.Status.IGNORED_UNSUPPORTED);     // Catch: Throwable -> L11
            ExternalVibrationScale r5 = session.getScale();     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            Trace.traceEnd(8388608);
            return r5;
        L14:
            if (ActivityManager.checkComponentPermission("android.permission.VIBRATE", vib.getUid(), -1, true) == 0) goto L19;
            Slog.w(VibratorManagerService.TAG, "pkg=" + vib.getPackage() + ", uid=" + vib.getUid() + " tried to play externally controlled vibration without VIBRATE permission, ignoring.");     // Catch: Throwable -> L11
            VibratorManagerService.m9337$$Nest$mendSessionLocked(this.this$0, session, VibrationSession.Status.IGNORED_MISSING_PERMISSION);     // Catch: Throwable -> L11
            ExternalVibrationScale r6 = session.getScale();     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            Trace.traceEnd(8388608);
            return r6;
        L19:
            VibrationSession.Status ignoreStatus = VibratorManagerService.m9352$$Nest$mshouldIgnoreVibrationLocked(this.this$0, session.callerInfo);     // Catch: Throwable -> L11
            if (ignoreStatus == null) goto L25;
            VibratorManagerService.m9337$$Nest$mendSessionLocked(this.this$0, session, ignoreStatus);     // Catch: Throwable -> L11
            ExternalVibrationScale r7 = session.getScale();     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            Trace.traceEnd(8388608);
            return r7;
        L25:
            VibrationSession r8 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L11
            if ((r8 instanceof ExternalVibrationSession) == false) goto L33;
            ExternalVibrationSession evs = (ExternalVibrationSession) r8;     // Catch: Throwable -> L11
            if (evs.isHoldingSameVibration(vib) == false) goto L33;
            ExternalVibrationScale r9 = evs.getScale();     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            Trace.traceEnd(8388608);
            return r9;
        L33:
            Vibration.EndInfo ignoreInfo = VibratorManagerService.m9351$$Nest$mshouldIgnoreForOngoingLocked(this.this$0, session);     // Catch: Throwable -> L11
            if (ignoreInfo == null) goto L39;
            VibratorManagerService.m9338$$Nest$mendSessionLocked(this.this$0, session, ignoreInfo.status, ignoreInfo.endedBy);     // Catch: Throwable -> L11
            ExternalVibrationScale r10 = session.getScale();     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            Trace.traceEnd(8388608);
            return r10;
        L39:
            VibratorManagerService.m9334$$Nest$mclearNextSessionLocked(this.this$0, VibrationSession.Status.IGNORED_FOR_EXTERNAL, session.callerInfo);     // Catch: Throwable -> L11
            VibratorManagerService.m9332$$Nest$fputmNextSession(this.this$0, session);     // Catch: Throwable -> L11
            if (VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0) == null) goto L42;
            session.stats.reportInterruptedAnotherVibration(VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0).getCallerInfo());     // Catch: Throwable -> L11
            VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0).requestEnd(VibrationSession.Status.CANCELLED_SUPERSEDED, session.callerInfo, true);     // Catch: Throwable -> L11
            waitForCompletion = true;
        L42:
            monitor-exit(r4);     // Catch: Throwable -> L11
            if (waitForCompletion == true) goto L46;
        L62:
            Object r11 = this.this$0.mLock;     // Catch: Throwable -> L60
            monitor-enter(r11);     // Catch: Throwable -> L60
        L72:
            th = move-exception;
            throw th;     // Catch: Throwable -> L60
        L65:
            if (VibratorManagerService.m9326$$Nest$fgetmNextSession(this.this$0) != session) goto L87;
            VibratorManagerService.m9332$$Nest$fputmNextSession(this.this$0, null);     // Catch: Throwable -> L72
            if (session.linkToDeath() == true) goto L75;
            VibratorManagerService.m9337$$Nest$mendSessionLocked(this.this$0, session, VibrationSession.Status.IGNORED_ERROR_TOKEN);     // Catch: Throwable -> L72
            ExternalVibrationScale r12 = session.getScale();     // Catch: Throwable -> L72
            monitor-exit(r11);     // Catch: Throwable -> L72
            Trace.traceEnd(8388608);
            return r12;
        L75:
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L77;
            Slog.d(VibratorManagerService.TAG, "Vibrator going under external control.");     // Catch: Throwable -> L72
        L77:
            VibratorManagerService.m9347$$Nest$msetExternalControl(this.this$0, true, session.stats);     // Catch: Throwable -> L72
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L80;
            Slog.d(VibratorManagerService.TAG, "Playing external vibration: " + vib);     // Catch: Throwable -> L72
        L80:
            VibrationAttributes attrs = VibratorManagerService.m9340$$Nest$mfixupVibrationAttributes(this.this$0, vib.getVibrationAttributes(), null);     // Catch: Throwable -> L72
            if (attrs.isFlagSet(4) == false) goto L83;
            this.this$0.mVibrationSettings.update();     // Catch: Throwable -> L72
        L83:
            VibratorManagerService.m9331$$Nest$fputmCurrentSession(this.this$0, session);     // Catch: Throwable -> L72
            session.scale(VibratorManagerService.m9327$$Nest$fgetmVibrationScaler(this.this$0), attrs.getUsage());     // Catch: Throwable -> L72
            session.stats.reportStarted();     // Catch: Throwable -> L72
            ExternalVibrationScale r13 = session.getScale();     // Catch: Throwable -> L72
            monitor-exit(r11);     // Catch: Throwable -> L72
            Trace.traceEnd(8388608);
            return r13;
        L87:
            ExternalVibrationScale r14 = session.getScale();     // Catch: Throwable -> L72
            monitor-exit(r11);     // Catch: Throwable -> L72
            Trace.traceEnd(8388608);
            return r14;
        L46:
            if (this.this$0.waitForCurrentSessionEnd(5000) == true) goto L62;
            Slog.e(VibratorManagerService.TAG, "Timed out waiting for vibration to cancel");     // Catch: Throwable -> L60
            Object r15 = this.this$0.mLock;     // Catch: Throwable -> L60
            monitor-enter(r15);     // Catch: Throwable -> L60
        L52:
            th = move-exception;
            throw th;     // Catch: Throwable -> L60
        L50:
            if (VibratorManagerService.m9326$$Nest$fgetmNextSession(this.this$0) != session) goto L54;
            VibratorManagerService.m9332$$Nest$fputmNextSession(this.this$0, null);     // Catch: Throwable -> L52
        L54:
            VibratorManagerService.m9337$$Nest$mendSessionLocked(this.this$0, session, VibrationSession.Status.IGNORED_ERROR_CANCELLING);     // Catch: Throwable -> L52
            ExternalVibrationScale r16 = session.getScale();     // Catch: Throwable -> L52
            monitor-exit(r15);     // Catch: Throwable -> L52
            Trace.traceEnd(8388608);
            return r16;
        L60:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }

        public void onExternalVibrationStop(ExternalVibration vib) {
            Trace.traceBegin(8388608, "onExternalVibrationStop");
            Object r0 = this.this$0.mLock;     // Catch: Throwable -> L23
            monitor-enter(r0);     // Catch: Throwable -> L23
            VibrationSession r3 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L12
            if ((r3 instanceof ExternalVibrationSession) == false) goto L16;
            ExternalVibrationSession evs = (ExternalVibrationSession) r3;     // Catch: Throwable -> L12
            if (evs.isHoldingSameVibration(vib) == false) goto L16;
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L14;
            Slog.d(VibratorManagerService.TAG, "Stopping external vibration: " + vib);     // Catch: Throwable -> L12
        L14:
            VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0).requestEnd(VibrationSession.Status.FINISHED);     // Catch: Throwable -> L12
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L12
            Trace.traceEnd(8388608);
            return;
        L16:
            if (Build.IS_DEBUGGABLE == false) goto L18;
            Slog.wtf(VibratorManagerService.TAG, "VibrationSession invalid on external vibration stop. currentSession=" + VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0) + ", received=" + vib);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }

        private boolean hasExternalControlCapability() {
            int i = 0;
        L4:
            if (i >= VibratorManagerService.m9330$$Nest$fgetmVibrators(this.this$0).size()) goto L10;
            if (((VibratorController) VibratorManagerService.m9330$$Nest$fgetmVibrators(this.this$0).valueAt(i)).hasCapability(8) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }
    }

    static class Injector {
        Injector() {
        }

        NativeWrapper getNativeWrapper() {
            return new NativeWrapper();
        }

        Handler createHandler(Looper looper) {
            return new Handler(looper);
        }

        IBatteryStats getBatteryStatsService() {
            return IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
        }

        VibratorFrameworkStatsLogger getFrameworkStatsLogger(Handler handler) {
            return new VibratorFrameworkStatsLogger(handler);
        }

        VibratorController createVibratorController(int vibratorId, VibratorController.OnVibrationCompleteListener listener) {
            return new VibratorController(vibratorId, listener);
        }

        HapticFeedbackVibrationProvider createHapticFeedbackVibrationProvider(Resources resources, VibratorInfo vibratorInfo) {
            return new HapticFeedbackVibrationProvider(resources, vibratorInfo);
        }

        void addService(String name, IBinder service) {
            ServiceManager.addService(name, service);
        }

        VibratorControllerHolder createVibratorControllerHolder() {
            return new VibratorControllerHolder();
        }

        boolean isServiceDeclared(String name) {
            return ServiceManager.isDeclared(name);
        }
    }

    public static class Lifecycle extends SystemService {
        private VibratorManagerService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new VibratorManagerService(getContext(), new Injector());
            publishBinderService("vibrator_manager", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L6;
            this.mService.systemReady();
            return;
        }
    }

    public static class NativeWrapper {
        private long mNativeServicePtr;

        public NativeWrapper() {
            this.mNativeServicePtr = 0;
        }

        public void init(VibratorManagerNativeCallbacks listener) {
            this.mNativeServicePtr = VibratorManagerService.nativeInit(listener);
            long finalizerPtr = VibratorManagerService.nativeGetFinalizer();
            if (finalizerPtr == 0) goto L6;
            NativeAllocationRegistry registry = NativeAllocationRegistry.createMalloced(VibratorManagerService.class.getClassLoader(), finalizerPtr);
            registry.registerNativeAllocation(this, this.mNativeServicePtr);
            return;
        }

        public long getCapabilities() {
            return VibratorManagerService.nativeGetCapabilities(this.mNativeServicePtr);
        }

        public int[] getVibratorIds() {
            return VibratorManagerService.nativeGetVibratorIds(this.mNativeServicePtr);
        }

        public boolean prepareSynced(int[] vibratorIds) {
            return VibratorManagerService.nativePrepareSynced(this.mNativeServicePtr, vibratorIds);
        }

        public boolean triggerSynced(long vibrationId) {
            return VibratorManagerService.nativeTriggerSynced(this.mNativeServicePtr, vibrationId);
        }

        public void cancelSynced() {
            VibratorManagerService.nativeCancelSynced(this.mNativeServicePtr);
        }

        public boolean startSession(long sessionId, int[] vibratorIds) {
            return VibratorManagerService.nativeStartSession(this.mNativeServicePtr, sessionId, vibratorIds);
        }

        public void endSession(long sessionId, boolean shouldAbort) {
            VibratorManagerService.nativeEndSession(this.mNativeServicePtr, sessionId, shouldAbort);
        }

        public void clearSessions() {
            VibratorManagerService.nativeClearSessions(this.mNativeServicePtr);
        }
    }

    private final class TiktapCallback extends ITiktapCallback.Stub {
        /* synthetic */ TiktapCallback(VibratorManagerService r1, VibratorManagerServiceIA r2) {
            this(r1);
        }

        private TiktapCallback(VibratorManagerService r1) {
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapCallback
        public void onCallback(int result) {
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.d(VibratorManagerService.TAG, " result:" + result);
            return;
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapCallback
        public int getInterfaceVersion() {
            Slog.d(VibratorManagerService.TAG, "getInterfaceVersion");
            return 1;
        }

        @Override // vendor.awinic.hardware.tiktap.vibrator.ITiktapCallback
        public String getInterfaceHash() {
            Slog.d(VibratorManagerService.TAG, "getInterfaceHash");
            return "awinic_tiktap";
        }
    }

    private final class VendorVibrationSessionCallbacks implements VendorVibrationSession.VibratorManagerHooks {
        final /* synthetic */ VibratorManagerService this$0;

        /* synthetic */ VendorVibrationSessionCallbacks(VibratorManagerService r1, VibratorManagerServiceIA r2) {
            this(r1);
        }

        private VendorVibrationSessionCallbacks(VibratorManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.vibrator.VendorVibrationSession.VibratorManagerHooks
        public void vibrate(long sessionId, VibrationSession.CallerInfo callerInfo, CombinedVibration effect) {
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(VibratorManagerService.TAG, "Vibration session " + sessionId + " vibration requested");
        L5:
            Trace.traceBegin(8388608, "sessionVibrate");
            Object r0 = this.this$0.mLock;     // Catch: Throwable -> L64
            monitor-enter(r0);     // Catch: Throwable -> L64
            VibrationSession r3 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L15
            if ((r3 instanceof VendorVibrationSession) == false) goto L57;
            VendorVibrationSession session = (VendorVibrationSession) r3;     // Catch: Throwable -> L15
            if (session.getSessionId() == sessionId) goto L21;
            if (Build.IS_DEBUGGABLE == false) goto L17;
            Slog.wtf(VibratorManagerService.TAG, TextUtils.formatSimple("SessionId mismatch on vendor vibration session vibrate. expected=%d, released=%d", new Object[]{Long.valueOf(session.getSessionId()), Long.valueOf(sessionId)}));     // Catch: Throwable -> L15
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L21:
            if (session.wasEndRequested() == false) goto L30;
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L25;
            Slog.d(VibratorManagerService.TAG, "session vibrate; session is ending, vibration ignored");     // Catch: Throwable -> L15
        L25:
            session.notifyVibrationAttempt(VibratorManagerService.m9336$$Nest$mcreateVibrationAttemptDebugInfo(this.this$0, effect, callerInfo, VibrationSession.Status.IGNORED_ERROR_SCHEDULING));     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L30:
            if (VibratorManagerService.m9354$$Nest$smisEffectValid(effect) == true) goto L36;
            session.notifyVibrationAttempt(VibratorManagerService.m9336$$Nest$mcreateVibrationAttemptDebugInfo(this.this$0, effect, callerInfo, VibrationSession.Status.IGNORED_UNSUPPORTED));     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L36:
            if (effect.getDuration() != Long.MAX_VALUE) goto L41;
            session.notifyVibrationAttempt(VibratorManagerService.m9336$$Nest$mcreateVibrationAttemptDebugInfo(this.this$0, effect, callerInfo, VibrationSession.Status.IGNORED_UNSUPPORTED));     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L41:
            HalVibration vib = new HalVibration(callerInfo, effect);     // Catch: Throwable -> L15
            VibrationSettings r5 = this.this$0.mVibrationSettings;     // Catch: Throwable -> L15
            r5.getClass();     // Catch: Throwable -> L15
            vib.fillFallbacks(new VibratorManagerService$$ExternalSyntheticLambda2(r5));     // Catch: Throwable -> L15
            if (callerInfo.attrs.isFlagSet(4) == false) goto L45;
            this.this$0.mVibrationSettings.update();     // Catch: Throwable -> L15
        L45:
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L47;
            Slog.d(VibratorManagerService.TAG, "Starting vibrate for vibration " + vib.id + " in session " + sessionId);     // Catch: Throwable -> L15
        L47:
            VibrationStepConductor conductor = VibratorManagerService.m9335$$Nest$mcreateSessionVibrationStepConductor(this.this$0, vib, session.getDeviceAdapter());     // Catch: Throwable -> L15
            if (session.maybeSetVibrationConductor(conductor) == true) goto L50;
            session.notifyVibrationAttempt(VibratorManagerService.m9336$$Nest$mcreateVibrationAttemptDebugInfo(this.this$0, effect, callerInfo, VibrationSession.Status.IGNORED_ERROR_SCHEDULING));     // Catch: Throwable -> L15
        L53:
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L50:
            if (VibratorManagerService.m9328$$Nest$fgetmVibrationThread(this.this$0).runVibrationOnVibrationThread(conductor) == true) goto L53;
            vib.end(new Vibration.EndInfo(VibrationSession.Status.IGNORED_ERROR_SCHEDULING));     // Catch: Throwable -> L15
            session.clearVibrationConductor();     // Catch: Throwable -> L15
            goto L53
        L57:
            if (Build.IS_DEBUGGABLE == false) goto L59;
            Slog.wtf(VibratorManagerService.TAG, "VibrationSession invalid on session vibrate. currentSession=" + VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0));     // Catch: Throwable -> L15
        L59:
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L64
        L64:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }

        @Override // com.android.server.vibrator.VendorVibrationSession.VibratorManagerHooks
        public void endSession(long sessionId, boolean shouldAbort) {
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L9;
            StringBuilder r0 = new StringBuilder();
            r0.append("Vibration session ");
            r0.append(sessionId);
            if (shouldAbort == false) goto L7;
            String r1 = " aborting";
        L8:
            r0.append(r1);
            Slog.d(VibratorManagerService.TAG, r0.toString());
            goto L9
        L7:
            r1 = " ending";
        L9:
            Trace.traceBegin(8388608, "endSession");
            VibratorManagerService.m9325$$Nest$fgetmNativeWrapper(this.this$0).endSession(sessionId, shouldAbort);     // Catch: Throwable -> L13
            Trace.traceEnd(8388608);
            return;
        L13:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }

        @Override // com.android.server.vibrator.VendorVibrationSession.VibratorManagerHooks
        public void onSessionReleased(long sessionId) {
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(VibratorManagerService.TAG, "Vibration session " + sessionId + " released");
        L5:
            Trace.traceBegin(8388608, "onVendorSessionReleased");
            Object r0 = this.this$0.mLock;     // Catch: Throwable -> L32
            monitor-enter(r0);     // Catch: Throwable -> L32
            VibrationSession r3 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L15
            if ((r3 instanceof VendorVibrationSession) == false) goto L25;
            VendorVibrationSession session = (VendorVibrationSession) r3;     // Catch: Throwable -> L15
            if (Build.IS_DEBUGGABLE == true) goto L13;
        L17:
            int[] r4 = session.getVibratorIds();     // Catch: Throwable -> L15
            int r5 = r4.length;     // Catch: Throwable -> L15
            int r6 = 0;
        L18:
            if (r6 >= r5) goto L20;
            int vibratorId = r4[r6];     // Catch: Throwable -> L15
            ((VibratorController) VibratorManagerService.m9330$$Nest$fgetmVibrators(this.this$0).get(vibratorId)).off();     // Catch: Throwable -> L15
            r6 = r6 + 1;     // Catch: Throwable -> L15
            goto L18
        L20:
            VibratorManagerService.m9339$$Nest$mfinishAppOpModeLocked(this.this$0, VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0).getCallerInfo());     // Catch: Throwable -> L15
            VibratorManagerService.m9333$$Nest$mclearCurrentSessionLocked(this.this$0);     // Catch: Throwable -> L15
            VibratorManagerService.m9343$$Nest$mmaybeStartNextSessionLocked(this.this$0);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L13:
            if (session.getSessionId() == sessionId) goto L17;
            Slog.wtf(VibratorManagerService.TAG, TextUtils.formatSimple("SessionId mismatch on vendor vibration session release. expected=%d, released=%d", new Object[]{Long.valueOf(session.getSessionId()), Long.valueOf(sessionId)}));     // Catch: Throwable -> L15
            goto L17
        L25:
            if (Build.IS_DEBUGGABLE == false) goto L27;
            Slog.wtf(VibratorManagerService.TAG, "VibrationSession invalid on vibration session release. currentSession=" + VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0));     // Catch: Throwable -> L15
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }
    }

    private static final class VibrationCompleteListener implements VibratorController.OnVibrationCompleteListener, VibratorManagerNativeCallbacks {
        private WeakReference<VibratorManagerService> mServiceRef;

        VibrationCompleteListener(VibratorManagerService service) {
            this.mServiceRef = new WeakReference(service);
        }

        @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerNativeCallbacks
        public void onSyncedVibrationComplete(long vibrationId) {
            VibratorManagerService service = this.mServiceRef.get();
            if (service == null) goto L6;
            VibratorManagerService.m9344$$Nest$monSyncedVibrationComplete(service, vibrationId);
            return;
        }

        @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerNativeCallbacks
        public void onVibrationSessionComplete(long sessionId) {
            VibratorManagerService service = this.mServiceRef.get();
            if (service == null) goto L6;
            VibratorManagerService.m9346$$Nest$monVibrationSessionComplete(service, sessionId);
            return;
        }

        @Override // com.android.server.vibrator.VibratorController.OnVibrationCompleteListener
        public void onComplete(int vibratorId, long vibrationId, long stepId) {
            VibratorManagerService service = this.mServiceRef.get();
            if (service == null) goto L6;
            VibratorManagerService.m9345$$Nest$monVibrationComplete(service, vibratorId, vibrationId, stepId);
            return;
        }
    }

    private static final class VibrationRecord implements GroupedAggregatedLogRecords.SingleLogRecord {
        private final VibrationSession.DebugInfo mInfo;

        VibrationRecord(VibrationSession.DebugInfo info) {
            this.mInfo = info;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public int getGroupKey() {
            return this.mInfo.getCallerInfo().attrs.getUsage();
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public long getCreateUptimeMs() {
            return this.mInfo.getCreateUptimeMillis();
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public boolean mayAggregate(GroupedAggregatedLogRecords.SingleLogRecord record) {
            if ((record instanceof VibrationRecord) == true) goto L5;
            return false;
        L5:
            VibrationSession.DebugInfo info = ((VibrationRecord) record).mInfo;
            if (this.mInfo.getCallerInfo().uid == info.getCallerInfo().uid) goto L8;
            return false;
        L8:
            if (Objects.equals(this.mInfo.getCallerInfo().attrs, info.getCallerInfo().attrs) == true) goto L10;
            return false;
        L10:
            if (Objects.equals(this.mInfo.getDumpAggregationKey(), info.getDumpAggregationKey()) == false) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public void dump(IndentingPrintWriter pw) {
            this.mInfo.dumpCompact(pw);
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public void dump(ProtoOutputStream proto, long fieldId) {
            this.mInfo.dump(proto, fieldId);
        }
    }

    private static final class VibrationRecords extends GroupedAggregatedLogRecords<VibrationRecord> {
        VibrationRecords(int sizeLimit, int aggregationTimeLimit) {
            super(sizeLimit, aggregationTimeLimit);
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords
        void dumpGroupHeader(IndentingPrintWriter pw, int usage) {
            pw.println(VibrationAttributes.usageToString(usage) + ":");
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords
        long findGroupKeyProtoFieldId(int usage) {
            switch(usage) {
                case 17: goto L6;
                case 33: goto L5;
                case 49: goto L4;
                default: goto L3;
            };
        L3:
            return 2246267895824L;
        L4:
            return 2246267895822L;
        L5:
            return 2246267895821L;
        L6:
            return 2246267895823L;
        }
    }

    private final class VibrationThreadCallbacks implements VibrationThread.VibratorManagerHooks {
        final /* synthetic */ VibratorManagerService this$0;

        /* synthetic */ VibrationThreadCallbacks(VibratorManagerService r1, VibratorManagerServiceIA r2) {
            this(r1);
        }

        private VibrationThreadCallbacks(VibratorManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.vibrator.VibrationThread.VibratorManagerHooks
        public boolean prepareSyncedVibration(long requiredCapabilities, int[] vibratorIds) {
            Trace.traceBegin(8388608, "prepareSyncedVibration");
        L11:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        L5:
            if ((VibratorManagerService.m9321$$Nest$fgetmCapabilities(this.this$0) & requiredCapabilities) == requiredCapabilities) goto L8;
            Trace.traceEnd(8388608);
            return false;
        L8:
            boolean r0 = VibratorManagerService.m9325$$Nest$fgetmNativeWrapper(this.this$0).prepareSynced(vibratorIds);     // Catch: Throwable -> L11
            Trace.traceEnd(8388608);
            return r0;
        }

        @Override // com.android.server.vibrator.VibrationThread.VibratorManagerHooks
        public boolean triggerSyncedVibration(long vibrationId) {
            Trace.traceBegin(8388608, "triggerSyncedVibration");
            boolean r0 = VibratorManagerService.m9325$$Nest$fgetmNativeWrapper(this.this$0).triggerSynced(vibrationId);     // Catch: Throwable -> L6
            Trace.traceEnd(8388608);
            return r0;
        L6:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }

        @Override // com.android.server.vibrator.VibrationThread.VibratorManagerHooks
        public void cancelSyncedVibration() {
            Trace.traceBegin(8388608, "cancelSyncedVibration");
            VibratorManagerService.m9325$$Nest$fgetmNativeWrapper(this.this$0).cancelSynced();     // Catch: Throwable -> L6
            Trace.traceEnd(8388608);
            return;
        L6:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }

        @Override // com.android.server.vibrator.VibrationThread.VibratorManagerHooks
        public void noteVibratorOn(int uid, long duration) {
            Trace.traceBegin(8388608, "noteVibratorOn");
            if (duration > 0) goto L7;
            Trace.traceEnd(8388608);
            return;
        L7:
            if (duration != Long.MAX_VALUE) goto L19;
            duration = 5000;
        L19:
            VibratorManagerService.m9320$$Nest$fgetmBatteryStatsService(this.this$0).noteVibratorOn(uid, duration);     // Catch: Throwable -> L11 RemoteException -> L13
            VibratorManagerService.m9324$$Nest$fgetmFrameworkStatsLogger(this.this$0).writeVibratorStateOnAsync(uid, duration);     // Catch: Throwable -> L11 RemoteException -> L13
        L10:
            Trace.traceEnd(8388608);
            return;
        L11:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        L13:
            e = move-exception;
            Slog.e(VibratorManagerService.TAG, "Error logging VibratorStateChanged to ON", e);     // Catch: Throwable -> L11
            goto L10
        }

        @Override // com.android.server.vibrator.VibrationThread.VibratorManagerHooks
        public void noteVibratorOff(int uid) {
            Trace.traceBegin(8388608, "noteVibratorOff");
            VibratorManagerService.m9320$$Nest$fgetmBatteryStatsService(this.this$0).noteVibratorOff(uid);     // Catch: Throwable -> L5 RemoteException -> L7
            VibratorManagerService.m9324$$Nest$fgetmFrameworkStatsLogger(this.this$0).writeVibratorStateOffAsync(uid);     // Catch: Throwable -> L5 RemoteException -> L7
        L4:
            Trace.traceEnd(8388608);
            return;
        L5:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        L7:
            e = move-exception;
            Slog.e(VibratorManagerService.TAG, "Error logging VibratorStateChanged to OFF", e);     // Catch: Throwable -> L5
            goto L4
        }

        @Override // com.android.server.vibrator.VibrationThread.VibratorManagerHooks
        public void onVibrationThreadReleased(long vibrationId) {
            if (VibratorManagerService.m9353$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(VibratorManagerService.TAG, "VibrationThread released vibration " + vibrationId);
        L5:
            Trace.traceBegin(8388608, "onVibrationThreadReleased");
            Object r0 = this.this$0.mLock;     // Catch: Throwable -> L36
            monitor-enter(r0);     // Catch: Throwable -> L36
            VibrationSession r3 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L15
            if ((r3 instanceof SingleVibrationSession) == false) goto L18;
            SingleVibrationSession session = (SingleVibrationSession) r3;     // Catch: Throwable -> L15
            if (Build.IS_DEBUGGABLE == true) goto L13;
        L17:
            VibratorManagerService.m9339$$Nest$mfinishAppOpModeLocked(this.this$0, VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0).getCallerInfo());     // Catch: Throwable -> L15
            VibratorManagerService.m9333$$Nest$mclearCurrentSessionLocked(this.this$0);     // Catch: Throwable -> L15
            Trace.asyncTraceEnd(8388608, "vibration", 0);     // Catch: Throwable -> L15
            VibratorManagerService.m9343$$Nest$mmaybeStartNextSessionLocked(this.this$0);     // Catch: Throwable -> L15
        L31:
            monitor-exit(r0);     // Catch: Throwable -> L15
            Trace.traceEnd(8388608);
            return;
        L13:
            if (session.getVibration().id == vibrationId) goto L17;
            Slog.wtf(VibratorManagerService.TAG, TextUtils.formatSimple("VibrationId mismatch on vibration thread release. expected=%d, released=%d", new Object[]{Long.valueOf(session.getVibration().id), Long.valueOf(vibrationId)}));     // Catch: Throwable -> L15
            goto L17
        L18:
            VibrationSession r4 = VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0);     // Catch: Throwable -> L15
            if ((r4 instanceof VendorVibrationSession) == false) goto L29;
            VibrationStepConductor conductor = ((VendorVibrationSession) r4).clearVibrationConductor();     // Catch: Throwable -> L15
            if (Build.IS_DEBUGGABLE == false) goto L31;
            if (conductor != null) goto L25;
            Slog.wtf(VibratorManagerService.TAG, "Vendor session without ongoing vibration on thread release. currentSession=" + VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0));     // Catch: Throwable -> L15
            goto L31
        L25:
            if (conductor.getVibration().id == vibrationId) goto L31;
            Slog.wtf(VibratorManagerService.TAG, TextUtils.formatSimple("VibrationId mismatch on vibration thread release. expected=%d, released=%d", new Object[]{Long.valueOf(conductor.getVibration().id), Long.valueOf(vibrationId)}));     // Catch: Throwable -> L15
            goto L31
        L29:
            if (Build.IS_DEBUGGABLE == false) goto L31;
            Slog.wtf(VibratorManagerService.TAG, "VibrationSession invalid on vibration thread release. currentSession=" + VibratorManagerService.m9322$$Nest$fgetmCurrentSession(this.this$0));     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        }
    }

    interface VibratorManagerNativeCallbacks {
        void onSyncedVibrationComplete(long r1);

        void onVibrationSessionComplete(long r1);
    }

    private static final class VibratorManagerRecords {
        private final VibrationRecords mAggregatedVibrationHistory;
        private final VibrationRecords mRecentVibrations;

        VibratorManagerRecords(int recentVibrationSizeLimit, int aggregationSizeLimit, int aggregationTimeLimit) {
            this.mAggregatedVibrationHistory = new VibrationRecords(aggregationSizeLimit, aggregationTimeLimit);
            this.mRecentVibrations = new VibrationRecords(recentVibrationSizeLimit, 0);
        }

        synchronized void record(VibrationSession.DebugInfo info) {
            monitor-enter(this);
            GroupedAggregatedLogRecords.AggregatedLogRecord<VibrationRecord> droppedRecord = this.mRecentVibrations.add(new VibrationRecord(info));     // Catch: Throwable -> L7
            if (droppedRecord == null) goto L9;
            this.mAggregatedVibrationHistory.add((VibrationRecord) droppedRecord.getLatest());     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void dump(IndentingPrintWriter pw) {
            monitor-enter(this);
            pw.println("Recent vibrations:");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            this.mRecentVibrations.dump(pw);     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            pw.println();     // Catch: Throwable -> L6
            pw.println();     // Catch: Throwable -> L6
            pw.println("Aggregated vibration history:");     // Catch: Throwable -> L6
            pw.increaseIndent();     // Catch: Throwable -> L6
            this.mAggregatedVibrationHistory.dump(pw);     // Catch: Throwable -> L6
            pw.decreaseIndent();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void dump(ProtoOutputStream proto) {
            monitor-enter(this);
            this.mRecentVibrations.dump(proto);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    private final class VibratorManagerShellCommand extends ShellCommand {
        public static final String SHELL_PACKAGE_NAME = "com.android.shell";
        public static final long VIBRATION_END_TIMEOUT_MS = 500;
        private final IBinder mShellCallbacksToken;
        final /* synthetic */ VibratorManagerService this$0;

        private static class AdvancedEnveloperBuilderWrapper implements EnvelopeBuilder {
            private VibrationEffect.WaveformEnvelopeBuilder mBuilder;

            /* synthetic */ AdvancedEnveloperBuilderWrapper(VibratorManagerServiceIA r1) {
                this();
            }

            private AdvancedEnveloperBuilderWrapper() {
                this.mBuilder = new VibrationEffect.WaveformEnvelopeBuilder();
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public void setInitialSharpness(float sharpness) {
                this.mBuilder.setInitialFrequencyHz(sharpness);
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public void addControlPoint(float intensity, float sharpness, long duration) {
                this.mBuilder.addControlPoint(intensity, sharpness, duration);
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public void reset(float initialSharpness) {
                this.mBuilder = new VibrationEffect.WaveformEnvelopeBuilder();
                this.mBuilder.setInitialFrequencyHz(initialSharpness);
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public VibrationEffect build() {
                return this.mBuilder.build();
            }
        }

        private static class BasicEnveloperBuilderWrapper implements EnvelopeBuilder {
            private VibrationEffect.BasicEnvelopeBuilder mBuilder;

            /* synthetic */ BasicEnveloperBuilderWrapper(VibratorManagerServiceIA r1) {
                this();
            }

            private BasicEnveloperBuilderWrapper() {
                this.mBuilder = new VibrationEffect.BasicEnvelopeBuilder();
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public void setInitialSharpness(float sharpness) {
                this.mBuilder.setInitialSharpness(sharpness);
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public void addControlPoint(float intensity, float sharpness, long duration) {
                this.mBuilder.addControlPoint(intensity, sharpness, duration);
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public void reset(float initialSharpness) {
                this.mBuilder = new VibrationEffect.BasicEnvelopeBuilder();
                this.mBuilder.setInitialSharpness(initialSharpness);
            }

            @Override // com.android.server.vibrator.VibratorManagerService.VibratorManagerShellCommand.EnvelopeBuilder
            public VibrationEffect build() {
                return this.mBuilder.build();
            }
        }

        private final class CommonOptions {
            public boolean background;
            public String description;
            public boolean force;

            CommonOptions(VibratorManagerShellCommand r5) {
                this.force = false;
                this.description = NotificationShellCmd.CHANNEL_NAME;
                this.background = false;
            L3:
                String nextArg = r5.peekNextArg();
                if (nextArg == null) goto L24;
                switch(nextArg.hashCode()) {
                    case 1461: goto L15;
                    case 1495: goto L12;
                    case 1497: goto L9;
                    default: goto L17;
                };
            L17:
                byte r1 = -1;
            L18:
                switch(r1) {
                    case 0: goto L22;
                    case 1: goto L21;
                    case 2: goto L20;
                    default: goto L19;
                };
            L19:
                return;
            L21:
                r5.getNextArgRequired();
                this.background = true;
                goto L3
            L22:
                r5.getNextArgRequired();
                this.force = true;
                goto L3
            L20:
                r5.getNextArgRequired();
                this.description = r5.getNextArgRequired();
                goto L3
            L9:
                if (nextArg.equals("-f") == false) goto L17;
                r1 = 0;
                goto L18
            L12:
                if (nextArg.equals("-d") == false) goto L17;
                r1 = 2;
                goto L18
            L15:
                if (nextArg.equals("-B") == false) goto L17;
                r1 = 1;
                goto L18
            }
        }

        private interface EnvelopeBuilder {
            void addControlPoint(float r1, float r2, long r3);

            VibrationEffect build();

            void reset(float r1);

            void setInitialSharpness(float r1);
        }

        /* synthetic */ VibratorManagerShellCommand(VibratorManagerService r1, IBinder r2, VibratorManagerServiceIA r3) {
            this(r1, r2);
        }

        private VibratorManagerShellCommand(VibratorManagerService r1, IBinder shellCallbacksToken) {
            this.this$0 = r1;
            this.mShellCallbacksToken = shellCallbacksToken;
        }

        public int onCommand(String cmd) {
        L8:
            th = move-exception;
            Trace.traceEnd(8388608);
            throw th;
        L4:
            if ("list".equals(cmd) == false) goto L11;
            Trace.traceBegin(8388608, "onCommand: list");     // Catch: Throwable -> L8
            int r2 = runListVibrators();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r2;
        L11:
            if ("synced".equals(cmd) == false) goto L16;
            Trace.traceBegin(8388608, "onCommand: synced");     // Catch: Throwable -> L8
            int r3 = runMono();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r3;
        L16:
            if ("combined".equals(cmd) == false) goto L21;
            Trace.traceBegin(8388608, "onCommand: combined");     // Catch: Throwable -> L8
            int r4 = runStereo();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r4;
        L21:
            if ("sequential".equals(cmd) == false) goto L26;
            Trace.traceBegin(8388608, "onCommand: sequential");     // Catch: Throwable -> L8
            int r5 = runSequential();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r5;
        L26:
            if ("xml".equals(cmd) == false) goto L31;
            Trace.traceBegin(8388608, "onCommand: xml");     // Catch: Throwable -> L8
            int r6 = runXml();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r6;
        L31:
            if ("cancel".equals(cmd) == false) goto L36;
            Trace.traceBegin(8388608, "onCommand: cancel");     // Catch: Throwable -> L8
            int r7 = runCancel();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r7;
        L36:
            if ("feedback".equals(cmd) == false) goto L40;
            Trace.traceBegin(8388608, "onCommand: feedback");     // Catch: Throwable -> L8
            int r8 = runHapticFeedback();     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r8;
        L40:
            Trace.traceBegin(8388608, "onCommand: default");     // Catch: Throwable -> L8
            int r9 = handleDefaultCommands(cmd);     // Catch: Throwable -> L8
            Trace.traceEnd(8388608);
            return r9;
        }

        private int runListVibrators() {
            PrintWriter pw = getOutPrintWriter();
        L6:
            th = move-exception;
            if (pw != null) goto L22;
        L19:
            throw th;
        L22:
            pw.close();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.addSuppressed(th);
            goto L19
        L4:
            if (VibratorManagerService.m9329$$Nest$fgetmVibratorIds(this.this$0).length != 0) goto L8;
            pw.println("No vibrator found");     // Catch: Throwable -> L6
        L11:
            pw.println("");     // Catch: Throwable -> L6
            pw.close();
            return 0;
        L8:
            int[] r1 = VibratorManagerService.m9329$$Nest$fgetmVibratorIds(this.this$0);     // Catch: Throwable -> L6
            int r3 = r1.length;     // Catch: Throwable -> L6
            int r4 = 0;
        L9:
            if (r4 >= r3) goto L11;
            int id = r1[r4];     // Catch: Throwable -> L6
            pw.println(id);     // Catch: Throwable -> L6
            r4 = r4 + 1;     // Catch: Throwable -> L6
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.android.server.vibrator.VibratorManagerService] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void runVibrate(CommonOptions commonOptions, CombinedVibration combined) {
            VibrationAttributes attrs = createVibrationAttributes(commonOptions);
            if (commonOptions.background == false) goto L5;
            ?? r7 = this.this$0;
        L6:
            int uid = Binder.getCallingUid();
            String resolvedPackageName = AppOpsManager.resolvePackageName(uid, "com.android.shell");
            HalVibration vib = this.this$0.vibrateWithPermissionCheck(uid, 0, resolvedPackageName, combined, attrs, commonOptions.description, r7);
            maybeWaitOnVibration(vib, commonOptions);
            return;
        L5:
            r7 = this.mShellCallbacksToken;
            goto L6
        }

        private int runMono() {
            runVibrate(new CommonOptions(this), CombinedVibration.createParallel(nextEffect()));
            return 0;
        }

        private int runStereo() {
            CommonOptions commonOptions = new CommonOptions(this);
            CombinedVibration.ParallelCombination combination = CombinedVibration.startParallel();
        L4:
            if ("-v".equals(getNextOption()) == false) goto L6;
            int vibratorId = parseInt(getNextArgRequired(), "Expected vibrator id after -v");
            combination.addVibrator(vibratorId, nextEffect());
            goto L4
        L6:
            runVibrate(commonOptions, combination.combine());
            return 0;
        }

        private int runSequential() {
            CommonOptions commonOptions = new CommonOptions(this);
            CombinedVibration.SequentialCombination combination = CombinedVibration.startSequential();
        L4:
            if ("-v".equals(getNextOption()) == false) goto L6;
            int vibratorId = parseInt(getNextArgRequired(), "Expected vibrator id after -v");
            combination.addNext(vibratorId, nextEffect());
            goto L4
        L6:
            runVibrate(commonOptions, combination.combine());
            return 0;
        }

        private int runXml() {
            CommonOptions commonOptions = new CommonOptions(this);
            String xml = getNextArgRequired();
            CombinedVibration vibration = parseXml(xml);
            runVibrate(commonOptions, vibration);
            return 0;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private int runCancel() {
            this.this$0.cancelVibrate(-1, this.this$0);
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.android.server.vibrator.VibratorManagerService] */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1, types: [android.os.IBinder] */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private int runHapticFeedback() {
            CommonOptions commonOptions = new CommonOptions(this);
            int constant = parseInt(getNextArgRequired(), "Expected haptic feedback constant id");
            if (commonOptions.background == false) goto L5;
            ?? r9 = this.this$0;
        L7:
            if (commonOptions.force == false) goto L9;
            int flags = 2;
        L10:
            HalVibration vib = this.this$0.performHapticFeedbackInternal(Binder.getCallingUid(), 0, "com.android.shell", constant, commonOptions.description, r9, flags, 0);
            maybeWaitOnVibration(vib, commonOptions);
            return 0;
        L9:
            flags = 0;
            goto L10
        L5:
            r9 = this.mShellCallbacksToken;
            goto L7
        }

        private VibrationEffect nextEffect() {
            VibrationEffect.Composition composition = VibrationEffect.startComposition();
        L3:
            String nextArg = peekNextArg();
            if (nextArg == null) goto L21;
            if ("oneshot".equals(nextArg) == true) goto L7;
            if ("waveform".equals(nextArg) == true) goto L10;
            if ("prebaked".equals(nextArg) == true) goto L13;
            if ("primitives".equals(nextArg) == true) goto L16;
            if ("envelope".equals(nextArg) == false) goto L21;
            addEnvelopeToComposition(composition);
            goto L3
        L16:
            addPrimitivesToComposition(composition);
            goto L3
        L13:
            addPrebakedToComposition(composition);
            goto L3
        L10:
            addWaveformToComposition(composition);
            goto L3
        L7:
            addOneShotToComposition(composition);
        L21:
            return composition.compose();
        }

        private void addOneShotToComposition(VibrationEffect.Composition composition) {
            boolean hasAmplitude = false;
            int delay = 0;
            getNextArgRequired();
        L3:
            String nextOption = getNextOption();
            if (nextOption == null) goto L11;
            if ("-a".equals(nextOption) == true) goto L7;
            if ("-w".equals(nextOption) == false) goto L3;
            delay = parseInt(getNextArgRequired(), "Expected delay millis after -w");
            goto L3
        L7:
            hasAmplitude = true;
            goto L3
        L11:
            long duration = parseInt(getNextArgRequired(), "Expected one-shot duration millis");
            if (hasAmplitude == false) goto L14;
            int amplitude = parseInt(getNextArgRequired(), "Expected one-shot amplitude");
        L15:
            composition.addOffDuration(Duration.ofMillis(delay));
            composition.addEffect(VibrationEffect.createOneShot(duration, amplitude));
            return;
        L14:
            amplitude = -1;
            goto L15
        }

        private void addEnvelopeToComposition(VibrationEffect.Composition composition) {
            getNextArgRequired();
            int repeat = -1;
            float initialSharpness = Float.NaN;
            VibrationEffect preamble = null;
            boolean isAdvanced = false;
        L3:
            String nextOption = getNextOption();
            if (nextOption == null) goto L24;
            switch(nextOption.hashCode()) {
                case 1492: goto L15;
                case 1500: goto L12;
                case 1509: goto L9;
                default: goto L17;
            };
        L17:
            byte r4 = -1;
        L18:
            switch(r4) {
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L20;
                default: goto L3;
            };
        L20:
            repeat = parseInt(getNextArgRequired(), "Expected repeat index after -r");
            goto L3
        L21:
            initialSharpness = parseFloat(getNextArgRequired(), "Expected initial sharpness after -i");
            goto L3
        L22:
            isAdvanced = true;
            goto L3
        L9:
            if (nextOption.equals("-r") == false) goto L17;
            r4 = 2;
            goto L18
        L12:
            if (nextOption.equals("-i") == false) goto L17;
            r4 = 1;
            goto L18
        L15:
            if (nextOption.equals("-a") == false) goto L17;
            r4 = 0;
            goto L18
        L24:
            VibratorManagerServiceIA r5 = null;
            if (isAdvanced == false) goto L27;
            EnvelopeBuilder builder = new AdvancedEnveloperBuilderWrapper(r5);
        L29:
            if (Float.isNaN(initialSharpness) == true) goto L31;
            builder.setInitialSharpness(initialSharpness);
        L31:
            int pos = 0;
            float sharpness = 0.0f;
        L32:
            String nextArg = peekNextArg();
            if (nextArg == null) goto L40;
            if (pos <= 0) goto L47;
            if (pos != repeat) goto L47;
            preamble = builder.build();
            builder.reset(sharpness);
        L47:
            int duration = Integer.parseInt(nextArg);     // Catch: NumberFormatException -> L39
            getNextArgRequired();     // Catch: NumberFormatException -> L39
            float intensity = parseFloat(getNextArgRequired(), "Expected envelope intensity");
            sharpness = parseFloat(getNextArgRequired(), "Expected envelope sharpness");
            builder.addControlPoint(intensity, sharpness, duration);
            pos = pos + 1;
        L40:
            if (repeat < 0) goto L45;
            if (preamble != null) goto L43;
            composition.addEffect(VibrationEffect.createRepeatingEffect(builder.build()));
            return;
        L43:
            composition.addEffect(VibrationEffect.createRepeatingEffect(preamble, builder.build()));
            return;
        L45:
            composition.addEffect(builder.build());
            return;
        L27:
            builder = new BasicEnveloperBuilderWrapper(r5);
            goto L29
        }

        private void addWaveformToComposition(VibrationEffect.Composition composition) {
            getNextArgRequired();
            int delay = 0;
            int delay2 = -1;
            int repeat = 0;
            boolean isContinuous = false;
            boolean hasFrequencies = false;
        L3:
            String nextOption = getNextOption();
            if (nextOption == null) goto L32;
            switch(nextOption.hashCode()) {
                case 1492: goto L21;
                case 1494: goto L18;
                case 1497: goto L15;
                case 1509: goto L12;
                case 1514: goto L9;
                default: goto L23;
            };
        L23:
            byte r0 = -1;
        L24:
            switch(r0) {
                case 0: goto L30;
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                default: goto L3;
            };
        L26:
            delay = parseInt(getNextArgRequired(), "Expected delay millis after -w");
            goto L3
        L27:
            delay2 = parseInt(getNextArgRequired(), "Expected repeat index after -r");
            goto L3
        L28:
            repeat = 1;
            goto L3
        L29:
            isContinuous = true;
            goto L3
        L30:
            hasFrequencies = true;
            goto L3
        L9:
            if (nextOption.equals("-w") == false) goto L23;
            r0 = 4;
            goto L24
        L12:
            if (nextOption.equals("-r") == false) goto L23;
            r0 = 3;
            goto L24
        L15:
            if (nextOption.equals("-f") == false) goto L23;
            r0 = 1;
            goto L24
        L18:
            if (nextOption.equals("-c") == false) goto L23;
            r0 = 2;
            goto L24
        L21:
            if (nextOption.equals("-a") == false) goto L23;
            r0 = 0;
            goto L24
        L32:
            List<Integer> durations = new ArrayList();
            List<Float> amplitudes = new ArrayList();
            List<Float> frequencies = new ArrayList();
            float nextAmplitude = 0.0f;
        L33:
            String nextArg = peekNextArg();
            if (nextArg == null) goto L42;
            durations.add(Integer.valueOf(Integer.parseInt(nextArg)));     // Catch: NumberFormatException -> L41
            getNextArgRequired();     // Catch: NumberFormatException -> L41
            if (hasFrequencies == false) goto L38;
            int amplitude = parseInt(getNextArgRequired(), "Expected waveform amplitude");
            amplitudes.add(Float.valueOf(amplitude / 255.0f));
        L39:
            if (isContinuous == false) goto L33;
            frequencies.add(Float.valueOf(parseFloat(getNextArgRequired(), "Expected waveform frequency")));
            goto L33
        L38:
            amplitudes.add(Float.valueOf(nextAmplitude));
            nextAmplitude = 1.0f - nextAmplitude;
        L42:
            composition.addOffDuration(Duration.ofMillis(delay));
            VibrationEffect.WaveformBuilder waveform = VibrationEffect.startWaveform();
            int i = 0;
        L44:
            if (i >= durations.size()) goto L67;
            if (repeat == 0) goto L47;
            Duration transitionDuration = Duration.ofMillis(durations.get(i).intValue());
        L49:
            if (repeat == 0) goto L51;
            Duration sustainDuration = Duration.ZERO;
        L53:
            if (isContinuous == 0) goto L55;
            waveform.addTransition(transitionDuration, VibrationEffect.VibrationParameter.targetAmplitude(amplitudes.get(i).floatValue()), VibrationEffect.VibrationParameter.targetFrequency(frequencies.get(i).floatValue()));
        L57:
            if (sustainDuration.isZero() == true) goto L59;
            waveform.addSustain(sustainDuration);
        L59:
            if (i <= 0) goto L65;
            if (i != delay2) goto L65;
            composition.addEffect(waveform.build());
            if (isContinuous == false) goto L64;
            waveform = VibrationEffect.startWaveform(VibrationEffect.VibrationParameter.targetAmplitude(amplitudes.get(i).floatValue()), VibrationEffect.VibrationParameter.targetFrequency(frequencies.get(i).floatValue()));
            goto L65
        L64:
            waveform = VibrationEffect.startWaveform(VibrationEffect.VibrationParameter.targetAmplitude(amplitudes.get(i).floatValue()));
        L65:
            i = i + 1;
            hasFrequencies = hasFrequencies;
            isContinuous = isContinuous;
            goto L44
        L55:
            waveform.addTransition(transitionDuration, VibrationEffect.VibrationParameter.targetAmplitude(amplitudes.get(i).floatValue()));
            goto L57
        L51:
            sustainDuration = Duration.ofMillis(durations.get(i).intValue());
            goto L53
        L47:
            transitionDuration = Duration.ZERO;
            goto L49
        L67:
            if (delay2 >= 0) goto L69;
            composition.addEffect(waveform.build());
            return;
        L69:
            composition.repeatEffectIndefinitely(waveform.build());
        }

        private void addPrebakedToComposition(VibrationEffect.Composition composition) {
            boolean shouldFallback = false;
            int delay = 0;
            getNextArgRequired();
        L3:
            String nextOption = getNextOption();
            if (nextOption == null) goto L11;
            if ("-b".equals(nextOption) == true) goto L7;
            if ("-w".equals(nextOption) == false) goto L3;
            delay = parseInt(getNextArgRequired(), "Expected delay millis after -w");
            goto L3
        L7:
            shouldFallback = true;
            goto L3
        L11:
            int effectId = parseInt(getNextArgRequired(), "Expected prebaked effect id");
            composition.addOffDuration(Duration.ofMillis(delay));
            composition.addEffect(VibrationEffect.get(effectId, shouldFallback));
        }

        private void addPrimitivesToComposition(VibrationEffect.Composition composition) {
            getNextArgRequired();
        L4:
            if (peekNextArg() == null) goto L35;
            int delay = 0;
            float scale = 1.0f;
            int delayType = 0;
        L6:
            String nextOption = getNextOption();
            if (nextOption != null) goto L9;
            String nextArg = peekNextArg();     // Catch: Throwable -> L19
            composition.addPrimitive(Integer.parseInt(nextArg), scale, delay, delayType);     // Catch: Throwable -> L19
            getNextArgRequired();     // Catch: Throwable -> L19
        L20:
            return;
        L9:
            if ("-s".equals(nextOption) == true) goto L10;
            if ("-o".equals(nextOption) == true) goto L13;
            if ("-w".equals(nextOption) == false) goto L6;
            delayType = 0;
            delay = parseInt(getNextArgRequired(), "Expected delay millis after -w");
            goto L6
        L13:
            delayType = 1;
            delay = parseInt(getNextArgRequired(), "Expected offset millis after -o");
            goto L6
        L10:
            scale = parseFloat(getNextArgRequired(), "Expected scale after -s");
            goto L6
        }

        private VibrationAttributes createVibrationAttributes(CommonOptions commonOptions) {
            if (commonOptions.force == false) goto L5;
            int flags = 3;
        L7:
            return new VibrationAttributes.Builder().setFlags(flags).setUsage(65).build();
        L5:
            flags = 0;
            goto L7
        }

        private CombinedVibration parseXml(String xml) {
            ParsedVibration parsedVibration = VibrationXmlParser.parseDocument(new StringReader(xml));     // Catch: IOException -> L8
            VibratorInfo combinedVibratorInfo = VibratorManagerService.m9341$$Nest$mgetCombinedVibratorInfo(this.this$0);     // Catch: IOException -> L8
            if (combinedVibratorInfo == null) goto L13;
            VibrationEffect effect = parsedVibration.resolve(combinedVibratorInfo);     // Catch: IOException -> L8
            if (effect == null) goto L11;
            return CombinedVibration.createParallel(effect);
        L11:
            throw new IllegalArgumentException("Parsed XML cannot be resolved: " + xml);     // Catch: IOException -> L8
        L13:
            throw new IllegalStateException("No vibrator info available to parse XML");     // Catch: IOException -> L8
        L8:
            e = move-exception;
            throw new RuntimeException("Error parsing XML: " + xml, e);
        }

        private void maybeWaitOnVibration(HalVibration vib, CommonOptions commonOptions) {
            if (vib != null) goto L4;
            return;
        L4:
            if (commonOptions.background == true) goto L12;
            vib.waitForEnd();     // Catch: InterruptedException -> L7
            VibratorManagerService.m9328$$Nest$fgetmVibrationThread(this.this$0).waitForThreadIdle(((long) this.this$0.mVibrationSettings.getRampDownDuration()) + 500);     // Catch: InterruptedException -> L7
            return;
        L8:
            return;
        }

        private static int parseInt(String text, String errorMessage) {
            return Integer.parseInt(text);
        L4:
            e = move-exception;
            throw new IllegalArgumentException(errorMessage, e);
        }

        private static float parseFloat(String text, String errorMessage) {
            return Float.parseFloat(text);
        L4:
            e = move-exception;
            throw new IllegalArgumentException(errorMessage, e);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("Vibrator Manager commands:");     // Catch: Throwable -> L6
            pw.println("  help");     // Catch: Throwable -> L6
            pw.println("    Prints this help text.");     // Catch: Throwable -> L6
            pw.println("  list");     // Catch: Throwable -> L6
            pw.println("    Prints device vibrator ids; does not include input devices.");     // Catch: Throwable -> L6
            pw.println("  synced [options] <effect>...");     // Catch: Throwable -> L6
            pw.println("    Vibrates effect on all vibrators in sync.");     // Catch: Throwable -> L6
            pw.println("  combined [options] (-v <vibrator-id> <effect>...)...");     // Catch: Throwable -> L6
            pw.println("    Vibrates different effects on each vibrator in sync.");     // Catch: Throwable -> L6
            pw.println("  sequential [options] (-v <vibrator-id> <effect>...)...");     // Catch: Throwable -> L6
            pw.println("    Vibrates different effects on each vibrator in sequence.");     // Catch: Throwable -> L6
            pw.println("  xml [options] <xml>");     // Catch: Throwable -> L6
            pw.println("    Vibrates using combined vibration described in given XML string");     // Catch: Throwable -> L6
            pw.println("    on all vibrators in sync. The XML could be:");     // Catch: Throwable -> L6
            pw.println("        A single <vibration-effect>, or");     // Catch: Throwable -> L6
            pw.println("        A <vibration-select> containing multiple effects.");     // Catch: Throwable -> L6
            pw.println("  feedback [options] <constant>");     // Catch: Throwable -> L6
            pw.println("    Performs a haptic feedback with the given constant.");     // Catch: Throwable -> L6
            pw.println("  cancel");     // Catch: Throwable -> L6
            pw.println("    Cancels any active vibration");     // Catch: Throwable -> L6
            pw.println("");     // Catch: Throwable -> L6
            pw.println("Effect commands:");     // Catch: Throwable -> L6
            pw.println("  oneshot [-w delay] [-a] <duration> [<amplitude>]");     // Catch: Throwable -> L6
            pw.println("    Vibrates for duration milliseconds.");     // Catch: Throwable -> L6
            pw.println("    If -w is provided, the effect will be played after the specified");     // Catch: Throwable -> L6
            pw.println("    wait time in milliseconds.");     // Catch: Throwable -> L6
            pw.println("    If -a is provided, the command accepts a second argument for ");     // Catch: Throwable -> L6
            pw.println("    amplitude, in a scale of 1-255.");     // Catch: Throwable -> L6
            pw.print("  waveform [-w delay] [-r index] [-a] [-f] [-c] ");     // Catch: Throwable -> L6
            pw.println("(<duration> [<amplitude>] [<frequency>])...");     // Catch: Throwable -> L6
            pw.println("    Vibrates for durations and amplitudes in list.");     // Catch: Throwable -> L6
            pw.println("    If -w is provided, the effect will be played after the specified");     // Catch: Throwable -> L6
            pw.println("    wait time in milliseconds.");     // Catch: Throwable -> L6
            pw.println("    If -r is provided, the waveform loops back to the specified");     // Catch: Throwable -> L6
            pw.println("    index (e.g. 0 loops from the beginning).");     // Catch: Throwable -> L6
            pw.println("    If -a is provided, the command expects amplitude to follow each");     // Catch: Throwable -> L6
            pw.println("    duration; otherwise, it accepts durations only and alternates");     // Catch: Throwable -> L6
            pw.println("    off/on.");     // Catch: Throwable -> L6
            pw.println("    If -f is provided, the command expects frequency to follow each");     // Catch: Throwable -> L6
            pw.println("    amplitude or duration; otherwise, it uses resonant frequency.");     // Catch: Throwable -> L6
            pw.println("    If -c is provided, the waveform is continuous and will ramp");     // Catch: Throwable -> L6
            pw.println("    between values; otherwise each entry is a fixed step.");     // Catch: Throwable -> L6
            pw.println("    Duration is in milliseconds; amplitude is a scale of 1-255;");     // Catch: Throwable -> L6
            pw.println("    frequency is an absolute value in hertz.");     // Catch: Throwable -> L6
            pw.print("  envelope [-a] [-i initial sharpness] [-r index]  ");     // Catch: Throwable -> L6
            pw.println("[<duration1> <intensity1> <sharpness1>]...");     // Catch: Throwable -> L6
            pw.println("    Generates a vibration pattern based on a series of duration, ");     // Catch: Throwable -> L6
            pw.println("    intensity, and sharpness values. The total vibration time is ");     // Catch: Throwable -> L6
            pw.println("    the sum of all durations.");     // Catch: Throwable -> L6
            pw.println("    If -a is provided, the waveform will use the advanced APIs to ");     // Catch: Throwable -> L6
            pw.println("    generate the vibration pattern and the input parameters ");     // Catch: Throwable -> L6
            pw.println("    become [<duration1> <amplitude1> <frequency1>].");     // Catch: Throwable -> L6
            pw.println("    If -i is provided, the waveform will have an initial sharpness ");     // Catch: Throwable -> L6
            pw.println("    it will start from.");     // Catch: Throwable -> L6
            pw.println("    If -r is provided, the waveform loops back to the specified index");     // Catch: Throwable -> L6
            pw.println("    (e.g. 0 loops from the beginning).");     // Catch: Throwable -> L6
            pw.println("  prebaked [-w delay] [-b] <effect-id>");     // Catch: Throwable -> L6
            pw.println("    Vibrates with prebaked effect.");     // Catch: Throwable -> L6
            pw.println("    If -w is provided, the effect will be played after the specified");     // Catch: Throwable -> L6
            pw.println("    wait time in milliseconds.");     // Catch: Throwable -> L6
            pw.println("    If -b is provided, the prebaked fallback effect will be played if");     // Catch: Throwable -> L6
            pw.println("    the device doesn't support the given effect-id.");     // Catch: Throwable -> L6
            pw.print("  primitives ([-w delay] [-o time] [-s scale]");     // Catch: Throwable -> L6
            pw.println("<primitive-id> [<scale>])...");     // Catch: Throwable -> L6
            pw.println("    Vibrates with a composed effect.");     // Catch: Throwable -> L6
            pw.println("    If -w is provided, the next primitive will be played after the ");     // Catch: Throwable -> L6
            pw.println("    specified wait time in milliseconds.");     // Catch: Throwable -> L6
            pw.println("    If -o is provided, the next primitive will be played at the ");     // Catch: Throwable -> L6
            pw.println("    specified start offset time in milliseconds.");     // Catch: Throwable -> L6
            pw.println("    If -s is provided, the next primitive will be played with the");     // Catch: Throwable -> L6
            pw.println("    specified amplitude scale, in a scale of [0,1].");     // Catch: Throwable -> L6
            pw.println("");     // Catch: Throwable -> L6
            pw.println("Common Options:");     // Catch: Throwable -> L6
            pw.println("  -f");     // Catch: Throwable -> L6
            pw.println("    Force. Ignore Do Not Disturb setting.");     // Catch: Throwable -> L6
            pw.println("  -B");     // Catch: Throwable -> L6
            pw.println("    Run in the background; without this option the shell cmd will");     // Catch: Throwable -> L6
            pw.println("    block until the vibration has completed.");     // Catch: Throwable -> L6
            pw.println("  -d <description>");     // Catch: Throwable -> L6
            pw.println("    Add description to the vibration.");     // Catch: Throwable -> L6
            pw.println("");     // Catch: Throwable -> L6
            pw.println("Notes");     // Catch: Throwable -> L6
            pw.println("    Vibrations triggered by these commands will be ignored when");     // Catch: Throwable -> L6
            pw.println("    device is on DND (Do Not Disturb) mode; notification strength");     // Catch: Throwable -> L6
            pw.println("    user settings will be applied for scale.");     // Catch: Throwable -> L6
            pw.println("");     // Catch: Throwable -> L6
            pw.close();
            return;
        L6:
            th = move-exception;
            if (pw != null) goto L15;
        L12:
            throw th;
        L15:
            pw.close();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            th.addSuppressed(th);
            goto L12
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9C5qR-p6NGG3nM1ySJAO3subppM, reason: not valid java name */
    public static /* synthetic */ void m9318$r8$lambda$9C5qRp6NGG3nM1ySJAO3subppM(int r0, VibratorController r1) {
        lambda$setAlwaysOnEffect$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dPajBvP8G0Ta9blw1JsgCuv-t5A, reason: not valid java name */
    public static /* synthetic */ VibrationEffect m9319$r8$lambda$dPajBvP8G0Ta9blw1JsgCuvt5A(VibrationEffect r0, VibratorController r1) {
        return lambda$fixupAlwaysOnEffectsLocked$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStatsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBatteryStats m9320$$Nest$fgetmBatteryStatsService(VibratorManagerService r0) {
        return r0.mBatteryStatsService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCapabilities, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9321$$Nest$fgetmCapabilities(VibratorManagerService r2) {
        return r2.mCapabilities;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationSession m9322$$Nest$fgetmCurrentSession(VibratorManagerService r0) {
        return r0.mCurrentSession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalVibrationCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExternalVibrationCallbacks m9323$$Nest$fgetmExternalVibrationCallbacks(VibratorManagerService r0) {
        return r0.mExternalVibrationCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrameworkStatsLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibratorFrameworkStatsLogger m9324$$Nest$fgetmFrameworkStatsLogger(VibratorManagerService r0) {
        return r0.mFrameworkStatsLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNativeWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeWrapper m9325$$Nest$fgetmNativeWrapper(VibratorManagerService r0) {
        return r0.mNativeWrapper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationSession m9326$$Nest$fgetmNextSession(VibratorManagerService r0) {
        return r0.mNextSession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibrationScaler, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationScaler m9327$$Nest$fgetmVibrationScaler(VibratorManagerService r0) {
        return r0.mVibrationScaler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibrationThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationThread m9328$$Nest$fgetmVibrationThread(VibratorManagerService r0) {
        return r0.mVibrationThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m9329$$Nest$fgetmVibratorIds(VibratorManagerService r0) {
        return r0.mVibratorIds;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibrators, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9330$$Nest$fgetmVibrators(VibratorManagerService r0) {
        return r0.mVibrators;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9331$$Nest$fputmCurrentSession(VibratorManagerService r0, VibrationSession r1) {
        r0.mCurrentSession = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9332$$Nest$fputmNextSession(VibratorManagerService r0, VibrationSession r1) {
        r0.mNextSession = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearCurrentSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9333$$Nest$mclearCurrentSessionLocked(VibratorManagerService r0) {
        r0.clearCurrentSessionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mclearNextSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9334$$Nest$mclearNextSessionLocked(VibratorManagerService r0, VibrationSession.Status r1, VibrationSession.CallerInfo r2) {
        r0.clearNextSessionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateSessionVibrationStepConductor, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationStepConductor m9335$$Nest$mcreateSessionVibrationStepConductor(VibratorManagerService r0, HalVibration r1, DeviceAdapter r2) {
        return r0.createSessionVibrationStepConductor(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateVibrationAttemptDebugInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationSession.DebugInfo m9336$$Nest$mcreateVibrationAttemptDebugInfo(VibratorManagerService r0, CombinedVibration r1, VibrationSession.CallerInfo r2, VibrationSession.Status r3) {
        return r0.createVibrationAttemptDebugInfo(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mendSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9337$$Nest$mendSessionLocked(VibratorManagerService r0, VibrationSession r1, VibrationSession.Status r2) {
        r0.endSessionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mendSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9338$$Nest$mendSessionLocked(VibratorManagerService r0, VibrationSession r1, VibrationSession.Status r2, VibrationSession.CallerInfo r3) {
        r0.endSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishAppOpModeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9339$$Nest$mfinishAppOpModeLocked(VibratorManagerService r0, VibrationSession.CallerInfo r1) {
        r0.finishAppOpModeLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfixupVibrationAttributes, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationAttributes m9340$$Nest$mfixupVibrationAttributes(VibratorManagerService r0, VibrationAttributes r1, CombinedVibration r2) {
        return r0.fixupVibrationAttributes(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCombinedVibratorInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibratorInfo m9341$$Nest$mgetCombinedVibratorInfo(VibratorManagerService r0) {
        return r0.getCombinedVibratorInfo();
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeClearCurrentAndNextSessionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9342$$Nest$mmaybeClearCurrentAndNextSessionsLocked(VibratorManagerService r0, Predicate r1, VibrationSession.Status r2) {
        r0.maybeClearCurrentAndNextSessionsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeStartNextSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9343$$Nest$mmaybeStartNextSessionLocked(VibratorManagerService r0) {
        r0.maybeStartNextSessionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monSyncedVibrationComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9344$$Nest$monSyncedVibrationComplete(VibratorManagerService r0, long r1) {
        r0.onSyncedVibrationComplete(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monVibrationComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9345$$Nest$monVibrationComplete(VibratorManagerService r0, int r1, long r2, long r4) {
        r0.onVibrationComplete(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monVibrationSessionComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9346$$Nest$monVibrationSessionComplete(VibratorManagerService r0, long r1) {
        r0.onVibrationSessionComplete(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetExternalControl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9347$$Nest$msetExternalControl(VibratorManagerService r0, boolean r1, VibrationStats r2) {
        r0.setExternalControl(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldCancelAppOpModeChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9348$$Nest$mshouldCancelAppOpModeChangedLocked(VibratorManagerService r0, VibrationSession r1) {
        return r0.shouldCancelAppOpModeChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldCancelOnFgUserRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9349$$Nest$mshouldCancelOnFgUserRequest(VibratorManagerService r0, VibrationSession r1) {
        return r0.shouldCancelOnFgUserRequest(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldCancelOnScreenOffLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9350$$Nest$mshouldCancelOnScreenOffLocked(VibratorManagerService r0, VibrationSession r1) {
        return r0.shouldCancelOnScreenOffLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldIgnoreForOngoingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ Vibration.EndInfo m9351$$Nest$mshouldIgnoreForOngoingLocked(VibratorManagerService r0, VibrationSession r1) {
        return r0.shouldIgnoreForOngoingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldIgnoreVibrationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ VibrationSession.Status m9352$$Nest$mshouldIgnoreVibrationLocked(VibratorManagerService r0, VibrationSession.CallerInfo r1) {
        return r0.shouldIgnoreVibrationLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9353$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smisEffectValid, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9354$$Nest$smisEffectValid(CombinedVibration r0) {
        return isEffectValid(r0);
    }

    static native void nativeCancelSynced(long r0);

    static native void nativeClearSessions(long r0);

    static native void nativeEndSession(long r0, long r2, boolean r4);

    static native long nativeGetCapabilities(long r0);

    static native long nativeGetFinalizer();

    static native int[] nativeGetVibratorIds(long r0);

    static native long nativeInit(VibratorManagerNativeCallbacks r0);

    static native boolean nativePrepareSynced(long r0, int[] r2);

    static native boolean nativeStartSession(long r0, long r2, int[] r4);

    static native boolean nativeTriggerSynced(long r0, long r2);

    static {
        DEBUG = VibratorDebugUtils.isDebuggable(TAG);
        DEFAULT_ATTRIBUTES = new VibrationAttributes.Builder().build();
    }

    VibratorManagerService(Context context, Injector r14) {
        this.mLock = new Object();
        VibratorManagerServiceIA r1 = null;
        this.mVibrationThreadCallbacks = new VibrationThreadCallbacks(this, r1);
        this.mExternalVibrationCallbacks = new ExternalVibrationCallbacks(this, r1);
        this.mVendorVibrationSessionCallbacks = new VendorVibrationSessionCallbacks(this, r1);
        this.mAlwaysOnEffects = new SparseArray();
        this.mTiktapAidlCallback = new TiktapCallback(this, r1);
        this.tikTapService = new TikTapVibratorService(true, this.mTiktapAidlCallback);
        this.mIntentReceiver = new AnonymousClass1(this);
        this.mAppOpsChangeListener = new AnonymousClass2(this);
        this.mServiceSmtEx = new VibratorServiceSmtEx(this);
        this.mContext = context;
        this.mInjector = r14;
        this.mHandler = r14.createHandler(Looper.myLooper());
        this.mFrameworkStatsLogger = r14.getFrameworkStatsLogger(this.mHandler);
        this.mVibrationConfig = new VibrationConfig(context.getResources());
        this.mVibrationSettings = new VibrationSettings(this.mContext, this.mHandler, this.mVibrationConfig);
        this.mVibrationSettings.setVibratorServiceSmtEx(this.mServiceSmtEx);
        this.mVibrationScaler = new VibrationScaler(this.mVibrationConfig, this.mVibrationSettings);
        this.mVibratorControlService = new VibratorControlService(this.mContext, r14.createVibratorControllerHolder(), this.mVibrationScaler, this.mVibrationSettings, this.mFrameworkStatsLogger, this.mLock);
        this.mInputDeviceDelegate = new InputDeviceDelegate(this.mContext, this.mHandler);
        VibrationCompleteListener listener = new VibrationCompleteListener(this);
        this.mNativeWrapper = r14.getNativeWrapper();
        this.mNativeWrapper.init(listener);
        int recentDumpSizeLimit = this.mContext.getResources().getInteger(R.integer.config_satellite_modem_image_switching_duration_millis);
        int dumpSizeLimit = this.mContext.getResources().getInteger(R.integer.config_satellite_emergency_mode_duration);
        int dumpAggregationTimeLimit = this.mContext.getResources().getInteger(R.integer.config_satellite_demo_mode_nb_iot_inactivity_timeout_millis);
        this.mVibratorManagerRecords = new VibratorManagerRecords(recentDumpSizeLimit, dumpSizeLimit, dumpAggregationTimeLimit);
        this.mBatteryStatsService = r14.getBatteryStatsService();
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mAppOps.startWatchingMode(3, null, this.mAppOpsChangeListener);
        PowerManager pm = (PowerManager) context.getSystemService(PowerManager.class);
        this.mWakeLock = pm.newWakeLock(1, "*vibrator*");
        this.mWakeLock.setReferenceCounted(true);
        this.mVibrationThread = new VibrationThread(this.mWakeLock, this.mVibrationThreadCallbacks);
        this.mVibrationThread.start();
        this.mCapabilities = this.mNativeWrapper.getCapabilities();
        int[] vibratorIds = this.mNativeWrapper.getVibratorIds();
        int r6 = 0;
        if (vibratorIds != null) goto L5;
        this.mVibratorIds = new int[0];
        this.mVibrators = new SparseArray(0);
    L9:
        this.mDeviceAdapter = new DeviceAdapter(this.mVibrationSettings, this.mVibrators);
        this.mNativeWrapper.cancelSynced();
        this.mNativeWrapper.clearSessions();
        int i = 0;
    L11:
        if (i >= this.mVibrators.size()) goto L13;
        this.mVibrators.valueAt(i).reset();
        i = i + 1;
        goto L11
    L13:
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_OFF");
        if (UserManagerInternal.shouldShowNotificationForBackgroundUserSounds() == false) goto L16;
        filter.addAction(BackgroundUserSoundNotifier.ACTION_MUTE_SOUND);
    L16:
        context.registerReceiver(this.mIntentReceiver, filter, 4);
        r14.addService(EXTERNAL_VIBRATOR_SERVICE, new ExternalVibratorService(this));
        if (r14.isServiceDeclared(VIBRATOR_CONTROL_SERVICE) == false) goto L22;
        r14.addService(VIBRATOR_CONTROL_SERVICE, this.mVibratorControlService);
        return;
    L22:
        return;
    L5:
        this.mVibratorIds = vibratorIds;
        this.mVibrators = new SparseArray(this.mVibratorIds.length);
        int r7 = vibratorIds.length;
    L7:
        if (r6 >= r7) goto L9;
        int vibratorId = vibratorIds[r6];
        VibratorController vibratorController = r14.createVibratorController(vibratorId, listener);
        this.mVibrators.put(vibratorId, vibratorController);
        r6 = r6 + 1;
        goto L7
    }

    void systemReady() {
        Slog.v(TAG, "Initializing VibratorManager service...");
        Trace.traceBegin(8388608, "systemReady");
        int i = 0;
    L44:
    L7:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mServiceReady = true;     // Catch: Throwable -> L37
        Slog.v(TAG, "VibratorManager service initialized");
        Trace.traceEnd(8388608);
        throw th;
    L37:
        th = move-exception;
        throw th;
    L5:
        if (i >= this.mVibrators.size()) goto L9;
        this.mVibrators.valueAt(i).reloadVibratorInfoIfNeeded();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L44
    L9:
        Object r0 = this.mLock;     // Catch: Throwable -> L7
        monitor-enter(r0);     // Catch: Throwable -> L7
        this.mVibratorInfos = transformAllVibratorsLocked(new VibratorManagerService$$ExternalSyntheticLambda3());     // Catch: Throwable -> L15
        VibratorInfo[] infos = new VibratorInfo[this.mVibratorInfos.size()];     // Catch: Throwable -> L15
        int i2 = 0;
    L13:
        if (i2 >= this.mVibratorInfos.size()) goto L17;
        infos[i2] = this.mVibratorInfos.valueAt(i2);     // Catch: Throwable -> L15
        i2 = i2 + 1;     // Catch: Throwable -> L15
        goto L13
    L17:
        this.mCombinedVibratorInfo = VibratorInfoFactory.create(-1, infos);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        this.mVibrationSettings.onSystemReady();     // Catch: Throwable -> L7
        this.mInputDeviceDelegate.onSystemReady();     // Catch: Throwable -> L7
        this.mVibrationSettings.addListener(new VibratorManagerService$$ExternalSyntheticLambda4(this));     // Catch: Throwable -> L7
        updateServiceState();     // Catch: Throwable -> L7
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mServiceReady = true;     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        Slog.v(TAG, "VibratorManager service initialized");
        Trace.traceEnd(8388608);
        return;
    L26:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    }

    public int[] getVibratorIds() {
        return Arrays.copyOf(this.mVibratorIds, this.mVibratorIds.length);
    }

    public int getCapabilities() {
        return (int) this.mCapabilities;
    }

    public VibratorInfo getVibratorInfo(int vibratorId) {
        VibratorController controller = this.mVibrators.get(vibratorId);
        if (controller != null) goto L5;
        return null;
    L5:
        VibratorInfo info = controller.getVibratorInfo();
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mServiceReady == false) goto L13;
        monitor-exit(r3);     // Catch: Throwable -> L11
        return info;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L11
        if (controller.isVibratorInfoLoadSuccessful() == true) goto L17;
        return null;
    L17:
        return info;
    }

    public boolean isVibrating(int vibratorId) {
        isVibrating_enforcePermission();
        VibratorController controller = this.mVibrators.get(vibratorId);
        if (controller != null) goto L5;
    L7:
        return false;
    L5:
        if (controller.isVibrating() == false) goto L7;
        return true;
    }

    public boolean registerVibratorStateListener(int vibratorId, IVibratorStateListener listener) {
        registerVibratorStateListener_enforcePermission();
        VibratorController controller = this.mVibrators.get(vibratorId);
        if (controller != null) goto L7;
        return false;
    L7:
        return controller.registerVibratorStateListener(listener);
    }

    public boolean unregisterVibratorStateListener(int vibratorId, IVibratorStateListener listener) {
        unregisterVibratorStateListener_enforcePermission();
        VibratorController controller = this.mVibrators.get(vibratorId);
        if (controller != null) goto L7;
        return false;
    L7:
        return controller.unregisterVibratorStateListener(listener);
    }

    public boolean setAlwaysOnEffect(int uid, String opPkg, final int alwaysOnId, CombinedVibration effect, VibrationAttributes attrs) {
        Trace.traceBegin(8388608, "setAlwaysOnEffect");
        this.mContext.enforceCallingOrSelfPermission("android.permission.VIBRATE_ALWAYS_ON", "setAlwaysOnEffect");     // Catch: Throwable -> L14
        if (effect != null) goto L18;
        Object r5 = this.mLock;     // Catch: Throwable -> L14
        monitor-enter(r5);     // Catch: Throwable -> L14
        this.mAlwaysOnEffects.delete(alwaysOnId);     // Catch: Throwable -> L11
        onAllVibratorsLocked(new VibratorManagerService$$ExternalSyntheticLambda1(alwaysOnId));     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        Trace.traceEnd(8388608);
        return true;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L18:
        if (isEffectValid(effect) == true) goto L49;
        Trace.traceEnd(8388608);
        return false;
    L49:
        VibrationAttributes attrs2 = fixupVibrationAttributes(attrs, effect);     // Catch: Throwable -> L41
        Object r6 = this.mLock;     // Catch: Throwable -> L39
        monitor-enter(r6);     // Catch: Throwable -> L39
        SparseArray<PrebakedSegment> effects = fixupAlwaysOnEffectsLocked(effect);     // Catch: Throwable -> L31
        if (effects != null) goto L33;
        monitor-exit(r6);     // Catch: Throwable -> L31
        Trace.traceEnd(8388608);
        return false;
    L33:
        AlwaysOnVibration alwaysOnVibration = new AlwaysOnVibration(alwaysOnId, new VibrationSession.CallerInfo(attrs2, uid, 0, opPkg, null), effects);     // Catch: Throwable -> L31
        this.mAlwaysOnEffects.put(alwaysOnId, alwaysOnVibration);     // Catch: Throwable -> L31
        updateAlwaysOnLocked(alwaysOnVibration);     // Catch: Throwable -> L31
        monitor-exit(r6);     // Catch: Throwable -> L31
        Trace.traceEnd(8388608);
        return true;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = th;
    L42:
        Trace.traceEnd(8388608);
        throw th;
    L41:
        th = th;
    L14:
        th = th;
        goto L42
    }

    private static /* synthetic */ void lambda$setAlwaysOnEffect$0(int alwaysOnId, VibratorController v) {
        if (v.hasCapability(64) == false) goto L6;
        v.updateAlwaysOn(alwaysOnId, null);
        return;
    }

    public boolean isSupportDynamicEffect() {
        return true;
    }

    public void update_vib_info(int interval, int amplitude, int frequency) {
        Slog.d(TAG, "update: interval=" + interval + ", amplitude=" + amplitude + ", frequency=" + frequency);
    }

    public void stopDynamicEffect() {
        Slog.d(TAG, "stopDynamicEffect");
    }

    public int getTikTapVibratorIntensity() {
        return this.mVibrationSettings.getHapticFeedbackIntensity();
    }

    public void vibrate(int uid, int deviceId, String opPkg, CombinedVibration effect, VibrationAttributes attrs, String reason, IBinder token) {
        Slog.d(TAG, "vibrate:uid: " + uid + " opPkg:" + opPkg + " attrs:" + attrs + " reason:" + reason);
        Trace.traceBegin(8388608, "vibrate");
        vibrateWithPermissionCheck(uid, deviceId, opPkg, effect, attrs, reason, token);     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void performHapticFeedback(int uid, int deviceId, String opPkg, int constant, String reason, int flags, int privFlags) {
        Trace.traceBegin(8388608, "performHapticFeedback");
        Slog.d(TAG, "performHapticFeedback:uid: " + uid + " deviceId:" + deviceId + " opPkg:" + opPkg + " constant:" + constant + " reason:" + reason + " flags:" + flags + " privFlags:" + privFlags);     // Catch: Throwable -> L6
        performHapticFeedbackInternal(uid, deviceId, opPkg, constant, reason, this, flags, privFlags);     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void performHapticFeedbackForInputDevice(int uid, int deviceId, String opPkg, int constant, int inputDeviceId, int inputSource, String reason, int flags, int privFlags) {
        Trace.traceBegin(8388608, "performHapticFeedbackForInputDevice");
        Slog.d(TAG, "performHapticFeedbackForInputDevice:uid: " + uid + " deviceId:" + deviceId + " opPkg:" + opPkg + " constant:" + constant + " inputDeviceId:" + inputDeviceId + " inputSource:" + inputSource + " reason:" + reason + " flags:" + flags + " privFlags:" + privFlags);     // Catch: Throwable -> L6
        performHapticFeedbackForInputDeviceInternal(uid, deviceId, opPkg, constant, inputDeviceId, inputSource, reason, this, flags, privFlags);     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    HalVibration performHapticFeedbackInternal(int uid, int deviceId, String opPkg, int constant, String reason, IBinder token, int flags, int privFlags) {
        String reason2 = "performHapticFeedback(constant=" + constant + "): " + reason;
        HapticFeedbackVibrationProvider hapticVibrationProvider = getHapticVibrationProvider();
        VibrationSession.Status ignoreStatus = shouldIgnoreHapticFeedback(constant, reason2, hapticVibrationProvider);
        if (ignoreStatus == null) goto L7;
        logAndRecordPerformHapticFeedbackAttempt(uid, deviceId, opPkg, reason2, ignoreStatus);
        return null;
    L7:
        return performHapticFeedbackWithEffect(uid, deviceId, opPkg, constant, reason2, token, hapticVibrationProvider.getVibration(constant), hapticVibrationProvider.getVibrationAttributes(constant, flags, privFlags));
    }

    HalVibration performHapticFeedbackForInputDeviceInternal(int uid, int deviceId, String opPkg, int constant, int inputDeviceId, int inputSource, String reason, IBinder token, int flags, int privFlags) {
        String reason2 = "performHapticFeedbackForInputDevice(constant=" + constant + ", inputDeviceId=" + inputDeviceId + ", inputSource=" + inputSource + "): " + reason;
        HapticFeedbackVibrationProvider hapticVibrationProvider = getHapticVibrationProvider();
        VibrationSession.Status ignoreStatus = shouldIgnoreHapticFeedback(constant, reason2, hapticVibrationProvider);
        if (ignoreStatus == null) goto L7;
        logAndRecordPerformHapticFeedbackAttempt(uid, deviceId, opPkg, reason2, ignoreStatus);
        return null;
    L7:
        return performHapticFeedbackWithEffect(uid, deviceId, opPkg, constant, reason2, token, hapticVibrationProvider.getVibration(constant, inputSource), hapticVibrationProvider.getVibrationAttributes(constant, inputSource, flags, privFlags));
    }

    private HalVibration performHapticFeedbackWithEffect(int uid, int deviceId, String opPkg, int constant, String reason, IBinder token, VibrationEffect effect, VibrationAttributes attrs) {
        if (effect != null) goto L6;
        logAndRecordPerformHapticFeedbackAttempt(uid, deviceId, opPkg, reason, VibrationSession.Status.IGNORED_UNSUPPORTED);
        Slog.w(TAG, "performHapticFeedbackWithEffect; vibration absent for constant " + constant);
        return null;
    L6:
        CombinedVibration vib = CombinedVibration.createParallel(effect);
        VibratorFrameworkStatsLogger.logPerformHapticsFeedbackIfKeyboard(uid, constant);
        return vibrateWithoutPermissionCheck(uid, deviceId, opPkg, vib, attrs, reason, token);
    }

    HalVibration vibrateWithPermissionCheck(int uid, int deviceId, String opPkg, CombinedVibration effect, VibrationAttributes attrs, String reason, IBinder token) {
        VibrationAttributes attrs2 = fixupVibrationAttributes(attrs, effect);
        this.mContext.enforceCallingOrSelfPermission("android.permission.VIBRATE", "vibrate");
        return vibrateInternal(uid, deviceId, opPkg, effect, attrs2, reason, token);
    }

    HalVibration vibrateWithoutPermissionCheck(int uid, int deviceId, String opPkg, CombinedVibration effect, VibrationAttributes attrs, String reason, IBinder token) {
        return vibrateInternal(uid, deviceId, opPkg, effect, attrs, reason, token);
    }

    private HalVibration vibrateInternal(int uid, int deviceId, String opPkg, CombinedVibration effect, VibrationAttributes attrs, String reason, IBinder token) {
        VibrationSession.CallerInfo callerInfo = new VibrationSession.CallerInfo(attrs, uid, deviceId, opPkg, reason);
        if (token != null) goto L6;
        Slog.e(TAG, "token must not be null");
        logAndRecordVibrationAttempt(effect, callerInfo, VibrationSession.Status.IGNORED_ERROR_TOKEN);
        return null;
    L6:
        enforceUpdateAppOpsStatsPermission(uid);
        if (isEffectValid(effect) == true) goto L11;
        logAndRecordVibrationAttempt(effect, callerInfo, VibrationSession.Status.IGNORED_UNSUPPORTED);
        return null;
    L11:
        if (this.tikTapService.disposeTiktapEffectParams(effect) == false) goto L15;
        Slog.d(TAG, "vibration_test TikTap vib!");
        return null;
    L15:
        if (effect.hasVendorEffects() == true) goto L17;
    L20:
        SingleVibrationSession session = new SingleVibrationSession(token, callerInfo, effect);
        HalVibration vib = session.getVibration();
        VibrationSettings r7 = this.mVibrationSettings;
        r7.getClass();
        vib.fillFallbacks(new VibratorManagerService$$ExternalSyntheticLambda2(r7));
        if (attrs.isFlagSet(4) == false) goto L23;
        this.mVibrationSettings.update();
    L23:
        Object r8 = this.mLock;
        monitor-enter(r8);
    L28:
        th = move-exception;
        throw th;
    L26:
        if (DEBUG == false) goto L30;
        Slog.d(TAG, "Starting vibrate for vibration " + vib.id);     // Catch: Throwable -> L28
    L30:
        VibrationSession.Status ignoreStatus = shouldIgnoreVibrationLocked(callerInfo);     // Catch: Throwable -> L28
        VibrationSession.CallerInfo ignoredBy = null;
        if (ignoreStatus != null) goto L35;
        Vibration.EndInfo vibrationEndInfo = shouldIgnoreForOngoingLocked(session);     // Catch: Throwable -> L28
        if (vibrationEndInfo == null) goto L35;
        ignoreStatus = vibrationEndInfo.status;     // Catch: Throwable -> L28
        ignoredBy = vibrationEndInfo.endedBy;     // Catch: Throwable -> L28
    L35:
        if (ignoreStatus != null) goto L70;
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L28
    L49:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L38:
        if ((effect instanceof CombinedVibration.Mono) == false) goto L56;
        VibrationEffect vibrEffect = ((CombinedVibration.Mono) effect).getEffect();     // Catch: Throwable -> L49
        if (this.tikTapService.checkIfEffectHe2_0(vibrEffect) == false) goto L54;
        TikTapVibratorService.SenderId senderId = this.tikTapService.getSenderId(vibrEffect);     // Catch: Throwable -> L49
        boolean sameSenderId = this.tikTapService.checkIfPrevPatternData(senderId);     // Catch: Throwable -> L49
        if (sameSenderId == true) goto L58;
        boolean firstPackage = this.tikTapService.checkIfFirstHe2_0Package(vibrEffect);     // Catch: Throwable -> L49
        if (firstPackage == true) goto L52;
        Slog.d(TAG, "Ignoring interrupted package,just abbandon");     // Catch: Throwable -> L49
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L28
        monitor-exit(r8);     // Catch: Throwable -> L28
        return null;
    L52:
        doStopVibrateLocked();     // Catch: Throwable -> L49
        this.tikTapService.setCurrentSenderId(senderId);     // Catch: Throwable -> L49
    L58:
        if (this.mCurrentSession != null) goto L60;
    L65:
        clearNextSessionLocked(VibrationSession.Status.CANCELLED_SUPERSEDED, callerInfo);     // Catch: Throwable -> L49
        ignoreStatus = startVibrationLocked(session);     // Catch: Throwable -> L49
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L28
        goto L70
    L60:
        if (shouldPipelineVibrationLocked(this.mCurrentSession, vib) == true) goto L62;
        vib.stats.reportInterruptedAnotherVibration(this.mCurrentSession.getCallerInfo());     // Catch: Throwable -> L49
        this.mCurrentSession.requestEnd(VibrationSession.Status.CANCELLED_SUPERSEDED, callerInfo, false);     // Catch: Throwable -> L49
        goto L65
    L62:
        if (DEBUG == false) goto L65;
        Slog.d(TAG, "Pipelining vibration " + vib.id);     // Catch: Throwable -> L49
        goto L65
    L54:
        doStopVibrateLocked();     // Catch: Throwable -> L49
        this.tikTapService.resetCurrentSenderId();     // Catch: Throwable -> L49
        goto L58
    L56:
        doStopVibrateLocked();     // Catch: Throwable -> L49
    L70:
        if (ignoreStatus == null) goto L72;
        endSessionLocked(session, ignoreStatus, ignoredBy);     // Catch: Throwable -> L28
    L72:
        monitor-exit(r8);     // Catch: Throwable -> L28
        return vib;
    L17:
        if (hasPermission("android.permission.VIBRATE_VENDOR_EFFECTS") == true) goto L20;
        Slog.e(TAG, "vibrate; no permission for vendor effects");
        logAndRecordVibrationAttempt(effect, callerInfo, VibrationSession.Status.IGNORED_MISSING_PERMISSION);
        return null;
    }

    public void cancelVibrate(int usageFilter, IBinder token) {
        Trace.traceBegin(8388608, "cancelVibrate");
        this.mContext.enforceCallingOrSelfPermission("android.permission.VIBRATE", "cancelVibrate");     // Catch: Throwable -> L35
        Object r0 = this.mLock;     // Catch: Throwable -> L35
        monitor-enter(r0);     // Catch: Throwable -> L35
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L6:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Canceling vibration");     // Catch: Throwable -> L8
    L10:
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
        IBinder cancelToken = null;
        if ((this.mNextSession instanceof ExternalVibrationSession) == false) goto L14;
        IBinder cancelToken2 = null;
    L16:
        if (shouldCancelSession(this.mNextSession, usageFilter, cancelToken2) == false) goto L21;
        clearNextSessionLocked(VibrationSession.Status.CANCELLED_BY_USER);     // Catch: Throwable -> L18
    L21:
        if ((this.mCurrentSession instanceof ExternalVibrationSession) == true) goto L25;
        cancelToken = token;
    L25:
        if (shouldCancelSession(this.mCurrentSession, usageFilter, cancelToken) == false) goto L27;
        doStopVibrateLocked();     // Catch: Throwable -> L18
        this.mCurrentSession.requestEnd(VibrationSession.Status.CANCELLED_BY_USER);     // Catch: Throwable -> L18
    L27:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Trace.traceEnd(8388608);
        return;
    L14:
        cancelToken2 = token;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L35:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    public ICancellationSignal startVendorVibrationSession(int uid, int deviceId, String opPkg, int[] vibratorIds, VibrationAttributes attrs, String reason, IVibrationSessionCallback callback) {
        startVendorVibrationSession_enforcePermission();
        Trace.traceBegin(8388608, "startVibrationSession");
        VendorVibrationSession session = startVendorVibrationSessionInternal(uid, deviceId, opPkg, vibratorIds, attrs, reason, callback);     // Catch: Throwable -> L9
        if (session != null) goto L6;
        ICancellationSignal r3 = null;
    L7:
        Trace.traceEnd(8388608);
        return r3;
    L6:
        r3 = session.getCancellationSignal();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    VendorVibrationSession startVendorVibrationSessionInternal(int uid, int deviceId, String opPkg, int[] vibratorIds, VibrationAttributes attrs, String reason, IVibrationSessionCallback callback) {
        VibrationAttributes attrs2 = fixupVibrationAttributes(attrs, null);
        VibrationSession.CallerInfo callerInfo = new VibrationSession.CallerInfo(attrs2, uid, deviceId, opPkg, reason);
        if (callback != null) goto L7;
        Slog.e(TAG, "session callback must not be null");
        logAndRecordSessionAttempt(callerInfo, VibrationSession.Status.IGNORED_ERROR_TOKEN);
        return null;
    L7:
        if (vibratorIds != null) goto L9;
        int[] vibratorIds2 = new int[0];
    L10:
        enforceUpdateAppOpsStatsPermission(uid);
        SparseArray<VibratorController> sessionVibrators = new SparseArray(vibratorIds2.length);
        int r3 = vibratorIds2.length;
        int r5 = 0;
    L11:
        if (r5 >= r3) goto L16;
        int vibratorId = vibratorIds2[r5];
        VibratorController controller = this.mVibrators.get(vibratorId);
        if (controller == null) goto L15;
        sessionVibrators.put(vibratorId, controller);
    L15:
        r5 = r5 + 1;
        goto L11
    L16:
        DeviceAdapter deviceAdapter = new DeviceAdapter(this.mVibrationSettings, sessionVibrators);
        VendorVibrationSession session = new VendorVibrationSession(callerInfo, this.mHandler, this.mVendorVibrationSessionCallbacks, deviceAdapter, callback);
        if (attrs2.isFlagSet(4) == false) goto L19;
        this.mVibrationSettings.update();
    L19:
        Object r6 = this.mLock;
        monitor-enter(r6);
    L24:
        th = move-exception;
        throw th;
    L22:
        if (DEBUG == false) goto L26;
        Slog.d(TAG, "Starting vendor session " + session.getSessionId());     // Catch: Throwable -> L24
    L26:
        VibrationSession.Status ignoreStatus = null;
        VibrationSession.CallerInfo ignoredBy = null;
        if ((this.mCapabilities & 256) == 0) goto L29;
    L32:
        if (ignoreStatus == null) goto L34;
    L38:
        if (ignoreStatus != null) goto L40;
        ignoreStatus = shouldIgnoreVibrationLocked(callerInfo);     // Catch: Throwable -> L24
    L40:
        if (ignoreStatus != null) goto L44;
        Vibration.EndInfo vibrationEndInfo = shouldIgnoreForOngoingLocked(session);     // Catch: Throwable -> L24
        if (vibrationEndInfo == null) goto L44;
        ignoreStatus = vibrationEndInfo.status;     // Catch: Throwable -> L24
        ignoredBy = vibrationEndInfo.endedBy;     // Catch: Throwable -> L24
    L44:
        if (ignoreStatus != null) goto L56;
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L24
        clearNextSessionLocked(VibrationSession.Status.CANCELLED_SUPERSEDED, callerInfo);     // Catch: Throwable -> L49
        if (this.mCurrentSession == null) goto L52;
        this.mNextSession = session;     // Catch: Throwable -> L49
        this.mCurrentSession.requestEnd(VibrationSession.Status.CANCELLED_SUPERSEDED, callerInfo, false);     // Catch: Throwable -> L49
    L53:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L24
        goto L56
    L52:
        ignoreStatus = startVendorSessionLocked(session);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L56:
        if (ignoreStatus == null) goto L58;
        endSessionLocked(session, ignoreStatus, ignoredBy);     // Catch: Throwable -> L24
    L58:
        monitor-exit(r6);     // Catch: Throwable -> L24
        return session;
    L34:
        if (vibratorIds2.length != 0) goto L36;
    L37:
        Slog.e(TAG, "Bad vibrator ids to start session, ignoring request. requested=" + Arrays.toString(vibratorIds2) + " available=" + Arrays.toString(this.mVibratorIds));     // Catch: Throwable -> L24
        ignoreStatus = VibrationSession.Status.IGNORED_UNSUPPORTED;     // Catch: Throwable -> L24
        goto L38
    L36:
        if (vibratorIds2.length == deviceAdapter.getAvailableVibratorIds().length) goto L38;
    L29:
        if (DEBUG == false) goto L31;
        Slog.d(TAG, "Missing capability to start sessions, ignoring request");     // Catch: Throwable -> L24
    L31:
        ignoreStatus = VibrationSession.Status.IGNORED_UNSUPPORTED;     // Catch: Throwable -> L24
        goto L32
    L9:
        vibratorIds2 = vibratorIds;
        goto L10
    }

    private VibrationSession.Status startVendorSessionLocked(VendorVibrationSession session) {
        Trace.traceBegin(8388608, "startSessionLocked");
        long sessionId = session.getSessionId();     // Catch: Throwable -> L7
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Starting session " + sessionId + " in HAL");     // Catch: Throwable -> L7
    L10:
        if (session.isEnded() == false) goto L14;
        VibrationSession.Status r0 = session.getStatus();     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r0;
    L14:
        VibrationSession.CallerInfo callerInfo = session.getCallerInfo();     // Catch: Throwable -> L7
        int mode = startAppOpModeLocked(callerInfo);     // Catch: Throwable -> L7
        switch(mode) {
            case 0: goto L22;
            case 1: goto L16;
            case 2: goto L19;
            default: goto L16;
        };     // Catch: Throwable -> L7
    L16:
        VibrationSession.Status r5 = VibrationSession.Status.IGNORED_APP_OPS;     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r5;
    L19:
        Slog.w(TAG, "Start AppOpsManager operation errored for uid " + callerInfo.uid);     // Catch: Throwable -> L7
        VibrationSession.Status r6 = VibrationSession.Status.IGNORED_ERROR_APP_OPS;     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r6;
    L22:
        Trace.asyncTraceBegin(8388608, "vibration", 0);     // Catch: Throwable -> L7
        this.mCurrentSession = session;     // Catch: Throwable -> L7
        if (session.linkToDeath() == true) goto L28;
        finishAppOpModeLocked(callerInfo);     // Catch: Throwable -> L7
        this.mCurrentSession = null;     // Catch: Throwable -> L7
        VibrationSession.Status r7 = VibrationSession.Status.IGNORED_ERROR_TOKEN;     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r7;
    L28:
        if (this.mNativeWrapper.startSession(sessionId, session.getVibratorIds()) == true) goto L32;
        Slog.e(TAG, "Error starting session " + sessionId + " on vibrators " + Arrays.toString(session.getVibratorIds()));     // Catch: Throwable -> L7
        session.unlinkToDeath();     // Catch: Throwable -> L7
        finishAppOpModeLocked(callerInfo);     // Catch: Throwable -> L7
        this.mCurrentSession = null;     // Catch: Throwable -> L7
        VibrationSession.Status r8 = VibrationSession.Status.IGNORED_UNSUPPORTED;     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return r8;
    L32:
        session.notifyStart();     // Catch: Throwable -> L7
        Trace.traceEnd(8388608);
        return null;
    L7:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        long ident = Binder.clearCallingIdentity();
        boolean isDumpProto = false;
        int r3 = args.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L20;
        String arg = args[r4];
        if (arg.equals("--proto") == false) goto L10;
        isDumpProto = true;
    L10:
        r4 = r4 + 1;
        goto L6
    L20:
        if (isDumpProto == false) goto L15;
        dumpProto(fd);     // Catch: Throwable -> L13
    L16:
        Binder.restoreCallingIdentity(ident);
        return;
    L15:
        dumpText(pw);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void dumpText(PrintWriter w) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Dumping vibrator manager service to text...");
    L5:
        IndentingPrintWriter pw = new IndentingPrintWriter(w, "  ");
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.println("VibratorManagerService:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        this.mVibrationSettings.dump(pw);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        this.mVibrationScaler.dump(pw);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Vibrators:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L9:
        if (i >= this.mVibrators.size()) goto L13;
        this.mVibrators.valueAt(i).dump(pw);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("CurrentVibration:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        if (this.mCurrentSession == null) goto L16;
        this.mCurrentSession.getDebugInfo().dump(pw);     // Catch: Throwable -> L11
    L17:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("NextVibration:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        if (this.mNextSession == null) goto L20;
        this.mNextSession.getDebugInfo().dump(pw);     // Catch: Throwable -> L11
    L21:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        pw.println();
        pw.println();
        this.mVibratorManagerRecords.dump(pw);
        pw.println();
        pw.println();
        this.mVibratorControlService.dump(pw);
        return;
    L20:
        pw.println("null");     // Catch: Throwable -> L11
        goto L21
    L16:
        pw.println("null");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void dumpProto(FileDescriptor fd) {
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Dumping vibrator manager service to proto...");
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mVibrationSettings.dump(proto);     // Catch: Throwable -> L10
        this.mVibrationScaler.dump(proto);     // Catch: Throwable -> L10
        if (this.mCurrentSession == null) goto L12;
        this.mCurrentSession.getDebugInfo().dump(proto, 1146756268034L);     // Catch: Throwable -> L10
    L12:
        int i = 0;
    L14:
        if (i >= this.mVibrators.size()) goto L17;
        proto.write(2220498092033L, this.mVibrators.keyAt(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L14
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L10
        this.mVibratorManagerRecords.dump(proto);
        this.mVibratorControlService.dump(proto);
        proto.flush();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback cb, ResultReceiver resultReceiver) {
        new VibratorManagerShellCommand(this, cb.getShellCallbackBinder(), null).exec(this, in, out, err, args, cb, resultReceiver);
    }

    void updateServiceState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "Updating device state...");     // Catch: Throwable -> L7
    L9:
        boolean inputDevicesChanged = this.mInputDeviceDelegate.updateInputDeviceVibrators(this.mVibrationSettings.shouldVibrateInputDevices());     // Catch: Throwable -> L7
        int i = 0;
    L11:
        if (i >= this.mAlwaysOnEffects.size()) goto L14;
        updateAlwaysOnLocked(this.mAlwaysOnEffects.valueAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L11
    L14:
        if (this.mCurrentSession != null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L18:
        if ((this.mCurrentSession instanceof ExternalVibrationSession) == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L21:
        VibrationSession.Status ignoreStatus = shouldIgnoreVibrationLocked(this.mCurrentSession.getCallerInfo());     // Catch: Throwable -> L7
        if (inputDevicesChanged == true) goto L25;
        if (ignoreStatus != null) goto L25;
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L25:
        if (DEBUG == false) goto L31;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L7
        r4.append("Canceling vibration because settings changed: ");     // Catch: Throwable -> L7
        if (ignoreStatus != null) goto L29;
        Object r5 = "input devices changed";
    L30:
        r4.append(r5);     // Catch: Throwable -> L7
        Slog.d(TAG, r4.toString());     // Catch: Throwable -> L7
        goto L31
    L29:
        r5 = ignoreStatus;
    L31:
        this.mCurrentSession.requestEnd(VibrationSession.Status.CANCELLED_BY_SETTINGS_UPDATE);     // Catch: Throwable -> L7
        goto L32
    }

    private void setExternalControl(boolean externalControl, VibrationStats vibrationStats) {
        int i = 0;
    L4:
        if (i >= this.mVibrators.size()) goto L7;
        this.mVibrators.valueAt(i).setExternalControl(externalControl);
        vibrationStats.reportSetExternalControl();
        i = i + 1;
        goto L4
    }

    private void updateAlwaysOnLocked(AlwaysOnVibration vib) {
        int i = 0;
    L4:
        if (i >= vib.effects.size()) goto L15;
        VibratorController vibrator = this.mVibrators.get(vib.effects.keyAt(i));
        PrebakedSegment effect = vib.effects.valueAt(i);
        if (vibrator == null) goto L13;
        VibrationSession.Status ignoreStatus = shouldIgnoreVibrationLocked(vib.callerInfo);
        if (ignoreStatus != null) goto L11;
        PrebakedSegment effect2 = this.mVibrationScaler.scale(effect, vib.callerInfo.attrs.getUsage());
    L12:
        vibrator.updateAlwaysOn(vib.alwaysOnId, effect2);
        goto L13
    L11:
        effect2 = null;
    L13:
        i = i + 1;
        goto L4
    }

    private void doVibratorOnEnvelope(int[] relativeTime, int[] scaleArr, int[] freqArr, boolean steepMode, int amplitude, int uid, VibrationAttributes attrs) {
        TikTapVibratorService r1 = this.tikTapService;
        monitor-enter(r1);
        this.tikTapService.tikTapVibratorOnEnvelope(relativeTime, scaleArr, freqArr, steepMode, amplitude);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    private long doVibratorOnPatternHe(VibrationEffect effect, int uid) {
        TikTapVibratorService r0 = this.tikTapService;
        monitor-enter(r0);
        this.tikTapService.tikTapVibratorOnPatternHe(effect);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    private void doStopVibrateLocked() {
        TikTapVibratorService r0 = this.tikTapService;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "time before vibratorStop : " + System.currentTimeMillis());     // Catch: Throwable -> L7
    L9:
        this.tikTapService.tikTapVibratorStop();     // Catch: Throwable -> L7
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "time after vibratorStop : " + System.currentTimeMillis());     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private long doVibratorOnExtPrebakedEffectLocked(VibrationEffect effect) {
        Trace.traceBegin(8388608, "doVibratorOnExtPrebakedEffectLocked");
        TikTapVibrationEffect.ExtPrebaked prebaked = (TikTapVibrationEffect.ExtPrebaked) effect;     // Catch: Throwable -> L6
        this.tikTapService.tikTapVibratorSetAmplitude(255);     // Catch: Throwable -> L6
        this.tikTapService.tikTapVibratorPerform(prebaked.getId(), (byte) prebaked.getScale());     // Catch: Throwable -> L6
        Trace.traceEnd(8388608);
        return 0;
    L6:
        th = move-exception;
        Trace.traceEnd(8388608);
        throw th;
    }

    private VibrationSession.Status startVibrationLocked(SingleVibrationSession session) {
        Trace.traceBegin(8388608, "startVibrationLocked");
        HalVibration vib = session.getVibration();     // Catch: Throwable -> L13
        CombinedVibration.Mono r3 = vib.getEffectToPlay();     // Catch: Throwable -> L13
        if ((r3 instanceof CombinedVibration.Mono) == false) goto L44;
        TikTapVibrationEffect.Envelope r4 = r3.getEffect();     // Catch: Throwable -> L13
        if ((r4 instanceof TikTapVibrationEffect.ExtPrebaked) == false) goto L19;
        if (this.tikTapService == null) goto L15;
        doVibratorOnExtPrebakedEffectLocked(r4);     // Catch: Throwable -> L13
        VibrationSession.Status r5 = VibrationSession.Status.RUNNING;     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return r5;
    L15:
        Slog.d(TAG, "tikTapService is null or current is calling state, ignore current ExtPrebaked");     // Catch: Throwable -> L13
        VibrationSession.Status r6 = VibrationSession.Status.IGNORED_FOR_RINGER_MODE;     // Catch: Throwable -> L13
        Trace.traceEnd(8388608);
        return r6;
    L19:
        if ((r4 instanceof TikTapVibrationEffect.Envelope) == true) goto L21;
        VibratorManagerService r7 = this;
        if ((r4 instanceof TikTapVibrationEffect.PatternHe) == true) goto L37;
    L45:
        Slog.d(TAG, "vibration_test: start google vibration!");     // Catch: Throwable -> L27
        if (r7.mInputDeviceDelegate.isAvailable() == false) goto L51;
        VibrationSession.Status r8 = startVibrationOnInputDevicesLocked(session.getVibration());     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return r8;
    L51:
        if (r7.mCurrentSession != null) goto L55;
        VibrationSession.Status r9 = startVibrationOnThreadLocked(session);     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return r9;
    L55:
        clearNextSessionLocked(VibrationSession.Status.IGNORED_SUPERSEDED, session.getCallerInfo());     // Catch: Throwable -> L27
        r7.mNextSession = session;     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return null;
    L37:
        if (r7.tikTapService == null) goto L41;
        TikTapVibrationEffect.PatternHe patternHe = (TikTapVibrationEffect.PatternHe) r4;     // Catch: Throwable -> L27
        Slog.d(TAG, "vibration_test: vibratorservice play he");     // Catch: Throwable -> L27
        doVibratorOnPatternHe(patternHe, vib.callerInfo.uid);     // Catch: Throwable -> L27
        VibrationSession.Status r10 = VibrationSession.Status.RUNNING;     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return r10;
    L41:
        Slog.d(TAG, "vibration_test tikTapService is null or current is calling state, ignore current PatternHe");     // Catch: Throwable -> L27
        VibrationSession.Status r11 = VibrationSession.Status.IGNORED_FOR_RINGER_MODE;     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return r11;
    L21:
        if (this.tikTapService == null) goto L30;
        TikTapVibrationEffect.Envelope envelope = r4;     // Catch: Throwable -> L13
        doVibratorOnEnvelope(envelope.getRelativeTimeArr(), envelope.getScaleArr(), envelope.getFreqArr(), envelope.isSteepMode(), envelope.getAmplitude(), vib.callerInfo.uid, vib.callerInfo.attrs);     // Catch: Throwable -> L27
        VibrationSession.Status r12 = VibrationSession.Status.RUNNING;     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return r12;
    L30:
        Slog.d(TAG, "tikTapService is null or current is calling state, ignore current Envelope");     // Catch: Throwable -> L27
        VibrationSession.Status r13 = VibrationSession.Status.IGNORED_FOR_RINGER_MODE;     // Catch: Throwable -> L27
        Trace.traceEnd(8388608);
        return r13;
    L44:
        r7 = this;
    L27:
        th = th;
    L58:
        Trace.traceEnd(8388608);
        throw th;
    L13:
        th = th;
        goto L58
    }

    private VibrationSession.Status startVibrationOnThreadLocked(SingleVibrationSession session) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Starting vibration " + session.getVibration().id + " on thread");
    L5:
        VibrationStepConductor conductor = createVibrationStepConductor(session.getVibration());
        session.setVibrationConductor(conductor);
        VibrationSession.CallerInfo callerInfo = session.getCallerInfo();
        int mode = startAppOpModeLocked(callerInfo);
        switch(mode) {
            case 0: goto L11;
            case 1: goto L8;
            case 2: goto L9;
            default: goto L8;
        };
    L9:
        Slog.w(TAG, "Start AppOpsManager operation errored for uid " + callerInfo.uid);
        return VibrationSession.Status.IGNORED_ERROR_APP_OPS;
    L11:
        Trace.asyncTraceBegin(8388608, "vibration", 0);
        this.mCurrentSession = session;
        if (this.mCurrentSession.linkToDeath() == true) goto L16;
        finishAppOpModeLocked(callerInfo);
        this.mCurrentSession = null;
        return VibrationSession.Status.IGNORED_ERROR_TOKEN;
    L16:
        if (this.mVibrationThread.runVibrationOnVibrationThread(conductor) == true) goto L19;
        session.setVibrationConductor(null);
        this.mCurrentSession.unlinkToDeath();
        finishAppOpModeLocked(callerInfo);
        this.mCurrentSession = null;
        return VibrationSession.Status.IGNORED_ERROR_SCHEDULING;
    L19:
        return null;
    L8:
        return VibrationSession.Status.IGNORED_APP_OPS;
    }

    private void maybeStartNextSessionLocked() {
        VibrationSession r0 = this.mNextSession;
        if ((r0 instanceof SingleVibrationSession) == false) goto L11;
        SingleVibrationSession session = (SingleVibrationSession) r0;
        this.mNextSession = null;
        VibrationSession.Status errorStatus = startVibrationOnThreadLocked(session);
        if (errorStatus != null) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "Error starting next vibration " + session.getVibration().id);
    L9:
        endSessionLocked(session, errorStatus);
        return;
    L11:
        VibrationSession r1 = this.mNextSession;
        if ((r1 instanceof VendorVibrationSession) == false) goto L20;
        VendorVibrationSession session2 = (VendorVibrationSession) r1;
        this.mNextSession = null;
        VibrationSession.Status errorStatus2 = startVendorSessionLocked(session2);
        if (errorStatus2 != null) goto L16;
        return;
    L16:
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "Error starting next session " + session2.getSessionId());
    L18:
        endSessionLocked(session2, errorStatus2);
        return;
    }

    private void endSessionLocked(VibrationSession session, VibrationSession.Status status) {
        endSessionLocked(session, status, null);
    }

    private void endSessionLocked(VibrationSession session, VibrationSession.Status status, VibrationSession.CallerInfo endedBy) {
        session.requestEnd(status, endedBy, false);
        logAndRecordVibration(session.getDebugInfo());
    }

    private VibrationStepConductor createVibrationStepConductor(HalVibration vib) {
        return createVibrationStepConductor(vib, this.mDeviceAdapter, false);
    }

    private VibrationStepConductor createSessionVibrationStepConductor(HalVibration vib, DeviceAdapter deviceAdapter) {
        return createVibrationStepConductor(vib, deviceAdapter, true);
    }

    private VibrationStepConductor createVibrationStepConductor(HalVibration vib, DeviceAdapter deviceAdapter, boolean isInSession) {
        if (this.mVibratorControlService.shouldRequestVibrationParams(vib.callerInfo.attrs.getUsage()) == false) goto L5;
        CompletableFuture<Void> requestVibrationParamsFuture = this.mVibratorControlService.triggerVibrationParamsRequest(vib.callerInfo.uid, vib.callerInfo.attrs.getUsage(), this.mVibrationSettings.getRequestVibrationParamsTimeoutMs());
        CompletableFuture<Void> requestVibrationParamsFuture2 = requestVibrationParamsFuture;
    L7:
        return new VibrationStepConductor(vib, isInSession, this.mVibrationSettings, deviceAdapter, this.mVibrationScaler, this.mFrameworkStatsLogger, requestVibrationParamsFuture2, this.mVibrationThreadCallbacks);
    L5:
        requestVibrationParamsFuture2 = null;
        goto L7
    }

    private VibrationSession.Status startVibrationOnInputDevicesLocked(HalVibration vib) {
        vib.scaleEffects(this.mVibrationScaler);
        this.mInputDeviceDelegate.vibrateIfAvailable(vib.callerInfo, vib.getEffectToPlay());
        return VibrationSession.Status.FORWARDED_TO_INPUT_DEVICES;
    }

    private void logAndRecordPerformHapticFeedbackAttempt(int uid, int deviceId, String opPkg, String reason, VibrationSession.Status status) {
        VibrationSession.CallerInfo callerInfo = new VibrationSession.CallerInfo(VibrationAttributes.createForUsage(0), uid, deviceId, opPkg, reason);
        logAndRecordVibrationAttempt(null, callerInfo, status);
    }

    private void logAndRecordVibrationAttempt(CombinedVibration effect, VibrationSession.CallerInfo callerInfo, VibrationSession.Status status) {
        logAndRecordVibration(createVibrationAttemptDebugInfo(effect, callerInfo, status));
    }

    private void logAndRecordSessionAttempt(VibrationSession.CallerInfo callerInfo, VibrationSession.Status status) {
        logAndRecordVibration(new VendorVibrationSession.DebugInfoImpl(status, callerInfo, SystemClock.uptimeMillis(), System.currentTimeMillis(), 0, 0, 0, false, null));
    }

    private void logAndRecordVibration(VibrationSession.DebugInfo info) {
        info.logMetrics(this.mFrameworkStatsLogger);
        logVibrationStatus(info.getCallerInfo().uid, info.getCallerInfo().attrs, info.getStatus());
        this.mVibratorManagerRecords.record(info);
    }

    private VibrationSession.DebugInfo createVibrationAttemptDebugInfo(CombinedVibration effect, VibrationSession.CallerInfo callerInfo, VibrationSession.Status status) {
        return new Vibration.DebugInfoImpl(status, callerInfo, VibrationStats.StatsInfo.findVibrationType(effect), new VibrationStats(), effect, null, 0, 1.0f);
    }

    private void logVibrationStatus(int uid, VibrationAttributes attrs, VibrationSession.Status status) {
        switch(AnonymousClass3.$SwitchMap$com$android$server$vibrator$VibrationSession$Status[status.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L17;
            case 5: goto L14;
            case 6: goto L11;
            case 7: goto L8;
            default: goto L5;
        };
    L22:
        Slog.w(TAG, "Would be an error: vibrate from uid " + uid);
        return;
    L23:
        Slog.e(TAG, "Ignoring incoming vibration as process with uid= " + uid + " is background, attrs= " + attrs);
        return;
    L5:
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "Vibration for uid=" + uid + " and with attrs=" + attrs + " ended with status " + status);
        return;
    L25:
        return;
    L8:
        if (DEBUG == false) goto L27;
        Slog.d(TAG, "Ignoring incoming vibration because it came from a virtual device, attrs= " + attrs);
        return;
    L27:
        return;
    L11:
        if (DEBUG == false) goto L29;
        Slog.d(TAG, "Ignoring incoming vibration because of ringer mode, attrs=" + attrs);
        return;
    L29:
        return;
    L14:
        if (DEBUG == false) goto L31;
        Slog.d(TAG, "Ignoring incoming vibration in favor of repeating vibration");
        return;
    L31:
        return;
    L17:
        if (DEBUG == false) goto L33;
        Slog.d(TAG, "Ignoring incoming vibration in favor of ongoing vibration with higher importance");
        return;
    L33:
        return;
    L20:
        if (DEBUG == false) goto L35;
        Slog.d(TAG, "Ignoring incoming vibration for current external vibration");
        return;
    }

    private void onVibrationSessionComplete(long sessionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentSession == null) goto L18;
        if (this.mCurrentSession.getSessionId() != sessionId) goto L18;
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Vibration session " + sessionId + " complete, notifying session");     // Catch: Throwable -> L12
    L14:
        this.mCurrentSession.notifySessionCallback();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L18:
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "Vibration session " + sessionId + " callback ignored");     // Catch: Throwable -> L12
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private void onSyncedVibrationComplete(long vibrationId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentSession != null) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Synced vibration " + vibrationId + " complete, notifying thread");     // Catch: Throwable -> L9
    L11:
        this.mCurrentSession.notifySyncedVibratorsCallback(vibrationId);     // Catch: Throwable -> L9
        goto L12
    }

    private void onVibrationComplete(int vibratorId, long vibrationId, long stepId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L15:
        th = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw th;
    L17:
        th = th;
        goto L22
    L5:
        if (this.mCurrentSession == null) goto L20;
        if (DEBUG == true) goto L25;
    L12:
        this.mCurrentSession.notifyVibratorCallback(vibratorId, vibrationId, stepId);     // Catch: Throwable -> L15
        goto L20
    L25:
        Slog.d(TAG, "Vibration " + vibrationId + " step " + stepId + " on vibrator " + vibratorId + " complete, notifying thread");     // Catch: Throwable -> L10
    L10:
        th = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L15
    }

    private Vibration.EndInfo shouldIgnoreForOngoingLocked(VibrationSession session) {
        if (this.mNextSession == null) goto L8;
        Vibration.EndInfo vibrationEndInfo = shouldIgnoreForOngoing(session, this.mNextSession);
        if (vibrationEndInfo == null) goto L8;
        return vibrationEndInfo;
    L8:
        if (this.mCurrentSession != null) goto L10;
        return null;
    L10:
        if (this.mCurrentSession.wasEndRequested() == false) goto L13;
        return null;
    L13:
        return shouldIgnoreForOngoing(session, this.mCurrentSession);
    }

    private static Vibration.EndInfo shouldIgnoreForOngoing(VibrationSession newSession, VibrationSession ongoingSession) {
        int newSessionImportance = getVibrationImportance(newSession);
        int ongoingSessionImportance = getVibrationImportance(ongoingSession);
        if (newSessionImportance <= ongoingSessionImportance) goto L5;
        return null;
    L5:
        if (ongoingSessionImportance <= newSessionImportance) goto L9;
        return new Vibration.EndInfo(VibrationSession.Status.IGNORED_FOR_HIGHER_IMPORTANCE, ongoingSession.getCallerInfo());
    L9:
        if (ongoingSession.isRepeating() == true) goto L11;
    L14:
        return null;
    L11:
        if (newSession.isRepeating() == true) goto L14;
        return new Vibration.EndInfo(VibrationSession.Status.IGNORED_FOR_ONGOING, ongoingSession.getCallerInfo());
    }

    private static int getVibrationImportance(VibrationSession session) {
        int usage = session.getCallerInfo().attrs.getUsage();
        if (usage == 0) goto L5;
    L8:
        switch(usage) {
            case 17: goto L19;
            case 33: goto L17;
            case 34: goto L15;
            case 49: goto L13;
            case 50: goto L15;
            case 65: goto L11;
            case 66: goto L11;
            default: goto L9;
        };
    L9:
        return 0;
    L11:
        return 2;
    L13:
        return 3;
    L15:
        return 1;
    L17:
        return 5;
    L19:
        return 4;
    L5:
        if (session.isRepeating() == false) goto L7;
        usage = 33;
        goto L8
    L7:
        usage = 18;
        goto L8
    }

    private boolean shouldPipelineVibrationLocked(VibrationSession currentSession, HalVibration nextVibration) {
        if ((currentSession instanceof SingleVibrationSession) == false) goto L6;
        SingleVibrationSession currentVibration = (SingleVibrationSession) currentSession;
        return currentVibration.getVibration().canPipelineWith(nextVibration, this.mVibratorInfos, this.mVibrationConfig.getVibrationPipelineMaxDurationMs());
    L6:
        return false;
    }

    private VibrationSession.Status shouldIgnoreVibrationLocked(VibrationSession.CallerInfo callerInfo) {
        VibrationSession.Status statusFromSettings = this.mVibrationSettings.shouldIgnoreVibration(callerInfo);
        VibrationSession.Status statusFromSettings2 = this.mVibrationSettings.shouldIgnoreVibrationSmt(statusFromSettings, callerInfo.uid, callerInfo.attrs, callerInfo.opPkg, callerInfo.reason);
        if (statusFromSettings2 == null) goto L5;
        return statusFromSettings2;
    L5:
        int mode = checkAppOpModeLocked(callerInfo);
        if ((callerInfo.attrs.getPrivateFlags() & UnixStat.PERM_MASK) != 0) goto L14;
        if (mode != 0) goto L9;
        return null;
    L9:
        if (mode != 2) goto L13;
        return VibrationSession.Status.IGNORED_ERROR_APP_OPS;
    L13:
        return VibrationSession.Status.IGNORED_APP_OPS;
    L14:
        return null;
    }

    private VibrationSession.Status shouldIgnoreHapticFeedback(int constant, String reason, HapticFeedbackVibrationProvider hapticVibrationProvider) {
        if (hapticVibrationProvider != null) goto L7;
        Slog.e(TAG, reason + "; haptic vibration provider not ready.");
        return VibrationSession.Status.IGNORED_ERROR_SCHEDULING;
    L7:
        if (hapticVibrationProvider.isRestrictedHapticFeedback(constant) == true) goto L9;
        return null;
    L9:
        if (hasPermission("android.permission.VIBRATE_SYSTEM_CONSTANTS") == true) goto L14;
        Slog.w(TAG, reason + "; no permission for system constant " + constant);
        return VibrationSession.Status.IGNORED_MISSING_PERMISSION;
    L14:
        return null;
    }

    private boolean shouldCancelSession(VibrationSession session, int usageFilter, IBinder tokenFilter) {
        if (session != null) goto L6;
        return false;
    L6:
        if ((session instanceof VendorVibrationSession) == false) goto L8;
        return false;
    L8:
        if (tokenFilter != null) goto L10;
    L12:
        int usage = session.getCallerInfo().attrs.getUsage();
        if (usage != 0) goto L20;
        if (usageFilter == 0) goto L18;
        if (usageFilter == (-1)) goto L18;
        return false;
    L18:
        return true;
    L20:
        if ((usageFilter & usage) == usage) goto L22;
        return false;
    L22:
        return true;
    L10:
        if (tokenFilter == session.getCallerToken()) goto L12;
        return false;
    }

    private int checkAppOpModeLocked(VibrationSession.CallerInfo callerInfo) {
        int mode = this.mAppOps.checkAudioOpNoThrow(3, callerInfo.attrs.getAudioUsage(), callerInfo.uid, callerInfo.opPkg);
        if (DEBUG == false) goto L5;
        int opMode = this.mAppOps.checkOpNoThrow(3, callerInfo.uid, callerInfo.opPkg);
        Slog.d(TAG, "Check AppOp mode VIBRATE for uid " + callerInfo.uid + " and package " + callerInfo.opPkg + " returned audio=" + AppOpsManager.MODE_NAMES[mode] + ", op=" + AppOpsManager.MODE_NAMES[opMode]);
    L5:
        int fixedMode = fixupAppOpModeLocked(mode, callerInfo.attrs);
        if (mode == fixedMode) goto L9;
        if (fixedMode != 0) goto L9;
        Slog.d(TAG, "Bypassing DND for vibrate from uid " + callerInfo.uid);
    L9:
        return fixedMode;
    }

    private int startAppOpModeLocked(VibrationSession.CallerInfo callerInfo) {
        int mode = this.mAppOps.startOpNoThrow(3, callerInfo.uid, callerInfo.opPkg);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Start AppOp mode VIBRATE for uid " + callerInfo.uid + " and package " + callerInfo.opPkg + " returned " + AppOpsManager.MODE_NAMES[mode]);
    L6:
        return fixupAppOpModeLocked(mode, callerInfo.attrs);
    }

    private void finishAppOpModeLocked(VibrationSession.CallerInfo callerInfo) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Finish AppOp mode VIBRATE for uid " + callerInfo.uid + " and package " + callerInfo.opPkg);
    L5:
        this.mAppOps.finishOp(3, callerInfo.uid, callerInfo.opPkg);
    }

    private void enforceUpdateAppOpsStatsPermission(int uid) {
        if (uid != Binder.getCallingUid()) goto L6;
        return;
    L6:
        if (Binder.getCallingPid() != Process.myPid()) goto L8;
        return;
    L8:
        this.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
    }

    private static boolean isEffectValid(CombinedVibration effect) {
        if (effect != null) goto L12;
        Slog.wtf(TAG, "effect must not be null");
        return false;
    L12:
        effect.validate();     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        Slog.wtf(TAG, "Encountered issue when verifying vibration: " + effect, e);
        return false;
    }

    private VibrationAttributes fixupVibrationAttributes(VibrationAttributes attrs, CombinedVibration effect) {
        if (attrs != null) goto L4;
        attrs = DEFAULT_ATTRIBUTES;
    L4:
        int usage = attrs.getUsage();
        if (usage != 0) goto L10;
        if (effect == null) goto L10;
        if (effect.isHapticFeedbackCandidate() == false) goto L10;
        usage = 18;
    L10:
        int flags = attrs.getFlags();
        if ((flags & 3) == 0) goto L20;
        if (hasPermission("android.permission.WRITE_SECURE_SETTINGS") == true) goto L20;
        if (hasPermission("android.permission.MODIFY_PHONE_STATE") == true) goto L20;
        if (hasPermission("android.permission.MODIFY_AUDIO_ROUTING") == true) goto L20;
        flags = flags & (-4);
    L20:
        if (usage != attrs.getUsage()) goto L25;
        if (flags != attrs.getFlags()) goto L25;
        return attrs;
    L25:
        return new VibrationAttributes.Builder(attrs).setUsage(usage).setFlags(flags, attrs.getFlags()).build();
    }

    private SparseArray<PrebakedSegment> fixupAlwaysOnEffectsLocked(CombinedVibration effect) {
        if ((effect instanceof CombinedVibration.Mono) == false) goto L6;
        final VibrationEffect syncedEffect = ((CombinedVibration.Mono) effect).getEffect();
        SparseArray<VibrationEffect> effects = transformAllVibratorsLocked(new VibratorManagerService$$ExternalSyntheticLambda0(syncedEffect));
    L8:
        SparseArray<PrebakedSegment> result = new SparseArray();
        int i = 0;
    L10:
        if (i >= effects.size()) goto L21;
        PrebakedSegment prebaked = extractPrebakedSegment(effects.valueAt(i));
        if (prebaked == null) goto L13;
        int vibratorId = effects.keyAt(i);
        VibratorController vibrator = this.mVibrators.get(vibratorId);
        if (vibrator == null) goto L20;
        if (vibrator.hasCapability(64) == false) goto L20;
        result.put(vibratorId, prebaked);
    L20:
        i = i + 1;
        goto L10
    L13:
        Slog.e(TAG, "Only prebaked effects supported for always-on.");
        return null;
    L21:
        int i2 = result.size();
        if (i2 != 0) goto L24;
        return null;
    L24:
        return result;
    L6:
        if ((effect instanceof CombinedVibration.Stereo) == false) goto L25;
        effects = ((CombinedVibration.Stereo) effect).getEffects();
        goto L8
    L25:
        return null;
    }

    private static /* synthetic */ VibrationEffect lambda$fixupAlwaysOnEffectsLocked$1(VibrationEffect syncedEffect, VibratorController unused) {
        return syncedEffect;
    }

    private static PrebakedSegment extractPrebakedSegment(VibrationEffect effect) {
        if ((effect instanceof VibrationEffect.Composed) == false) goto L10;
        VibrationEffect.Composed composed = (VibrationEffect.Composed) effect;
        if (composed.getSegments().size() != 1) goto L12;
        PrebakedSegment r1 = (VibrationEffectSegment) composed.getSegments().get(0);
        if ((r1 instanceof PrebakedSegment) == false) goto L13;
        PrebakedSegment prebaked = r1;
        return prebaked;
    L13:
        return null;
    L12:
        return null;
    L10:
        return null;
    }

    private int fixupAppOpModeLocked(int mode, VibrationAttributes attrs) {
        if (mode == 1) goto L5;
    L8:
        return mode;
    L5:
        if (attrs.isFlagSet(1) == false) goto L8;
        return 0;
    }

    private boolean hasPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean shouldCancelOnScreenOffLocked(VibrationSession session) {
        if (session != null) goto L6;
        return false;
    L6:
        return this.mVibrationSettings.shouldCancelVibrationOnScreenOff(session.getCallerInfo(), session.getCreateUptimeMillis());
    }

    private boolean shouldCancelAppOpModeChangedLocked(VibrationSession session) {
        if (session != null) goto L6;
        return false;
    L6:
        if (checkAppOpModeLocked(session.getCallerInfo()) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean shouldCancelOnFgUserRequest(VibrationSession session) {
        if (session != null) goto L6;
        return false;
    L6:
        if (session.getCallerInfo().attrs.getUsageClass() == 1) goto L8;
        return false;
    L8:
        return true;
    }

    private void onAllVibratorsLocked(Consumer<VibratorController> consumer) {
        int i = 0;
    L4:
        if (i >= this.mVibrators.size()) goto L7;
        consumer.accept(this.mVibrators.valueAt(i));
        i = i + 1;
        goto L4
    }

    private <T> SparseArray<T> transformAllVibratorsLocked(Function<VibratorController, T> fn) {
        SparseArray<T> ret = new SparseArray(this.mVibrators.size());
        int i = 0;
    L4:
        if (i >= this.mVibrators.size()) goto L7;
        ret.put(this.mVibrators.keyAt(i), fn.apply(this.mVibrators.valueAt(i)));
        i = i + 1;
        goto L4
    L7:
        return ret;
    }

    private void clearNextSessionLocked(VibrationSession.Status status) {
        clearNextSessionLocked(status, null);
    }

    private void clearNextSessionLocked(VibrationSession.Status status, VibrationSession.CallerInfo endedBy) {
        if (this.mNextSession != null) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "Dropping pending vibration from " + this.mNextSession.getCallerInfo() + " with status: " + status);
    L7:
        endSessionLocked(this.mNextSession, status, endedBy);
        this.mNextSession = null;
    }

    private void clearCurrentSessionLocked() {
        if (this.mCurrentSession == null) goto L6;
        this.mCurrentSession.unlinkToDeath();
        logAndRecordVibration(this.mCurrentSession.getDebugInfo());
        this.mCurrentSession = null;
        this.mLock.notify();
        return;
    }

    private void maybeClearCurrentAndNextSessionsLocked(Predicate<VibrationSession> shouldEndSessionPredicate, VibrationSession.Status endStatus) {
        if ((this.mNextSession instanceof ExternalVibrationSession) == true) goto L8;
        if (shouldEndSessionPredicate.test(this.mNextSession) == false) goto L8;
        clearNextSessionLocked(endStatus);
    L8:
        if ((this.mCurrentSession instanceof ExternalVibrationSession) == false) goto L10;
        return;
    L10:
        if (shouldEndSessionPredicate.test(this.mCurrentSession) == false) goto L14;
        this.mCurrentSession.requestEnd(endStatus);
        return;
    }

    public boolean waitForCurrentSessionEnd(long maxWaitMillis) {
        long now = SystemClock.elapsedRealtime();
        long deadline = now + maxWaitMillis;
        Object r4 = this.mLock;
        monitor-enter(r4);
    L23:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentSession == null) goto L6;
        if (now >= deadline) goto L13;
        this.mLock.wait(deadline - now);     // Catch: Throwable -> L9 InterruptedException -> L18
    L20:
        now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L19:
        Slog.w(TAG, "VibratorManagerService interrupted waiting to stop, continuing");     // Catch: Throwable -> L9
        goto L20
    L13:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    L6:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    }

    private HapticFeedbackVibrationProvider getHapticVibrationProvider() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHapticFeedbackVibrationProvider == null) goto L11;
        HapticFeedbackVibrationProvider r1 = this.mHapticFeedbackVibrationProvider;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        VibratorInfo combinedVibratorInfo = getCombinedVibratorInfo();     // Catch: Throwable -> L9
        if (combinedVibratorInfo != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L16:
        HapticFeedbackVibrationProvider r2 = this.mInjector.createHapticFeedbackVibrationProvider(this.mContext.getResources(), combinedVibratorInfo);     // Catch: Throwable -> L9
        this.mHapticFeedbackVibrationProvider = r2;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    private VibratorInfo getCombinedVibratorInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VibratorInfo r1 = this.mCombinedVibratorInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public VibratorServiceSmtEx getSmtEx() {
        return this.mServiceSmtEx;
    }

    public IVibratorServiceSmtEx getISmtEx() {
        return this.mServiceSmtEx;
    }
}
