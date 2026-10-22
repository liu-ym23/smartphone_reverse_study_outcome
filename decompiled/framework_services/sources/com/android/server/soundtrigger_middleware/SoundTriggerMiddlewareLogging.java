package com.android.server.soundtrigger_middleware;

import android.content.Context;
import android.media.permission.Identity;
import android.media.permission.IdentityContext;
import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseRecognitionEvent;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;
import android.os.BatteryStatsInternal;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.LatencyTracker;
import com.android.server.LocalServices;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerMiddlewareLogging implements ISoundTriggerMiddlewareInternal, Dumpable {
    private static final int SESSION_MAX_EVENT_SIZE = 128;
    private static final String TAG = "SoundTriggerMiddlewareLogging";
    private final Supplier<BatteryStatsInternal> mBatteryStatsInternalSupplier;
    private final ISoundTriggerMiddlewareInternal mDelegate;
    private final Deque<EventLogger> mDetachedSessionEventLoggers;
    private final LatencyTracker mLatencyTracker;
    private final EventLogger mServiceEventLogger;
    private final AtomicInteger mSessionCount;
    private final Set<EventLogger> mSessionEventLoggers;

    private static class BatteryStatsHolder {
        private static final BatteryStatsInternal INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ BatteryStatsInternal m8264$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private BatteryStatsHolder() {
        }

        static {
            INSTANCE = (BatteryStatsInternal) LocalServices.getService(BatteryStatsInternal.class);
        }
    }

    private class CallbackLogging implements ISoundTriggerCallback {
        private final ISoundTriggerCallback mCallbackDelegate;
        private final EventLogger mEventLogger;
        private final Identity mOriginatorIdentity;
        final /* synthetic */ SoundTriggerMiddlewareLogging this$0;

        /* synthetic */ CallbackLogging(SoundTriggerMiddlewareLogging r1, ISoundTriggerCallback r2, EventLogger r3, Identity r4, SoundTriggerMiddlewareLoggingIA r5) {
            this(r1, r2, r3, r4);
        }

        private CallbackLogging(SoundTriggerMiddlewareLogging r1, ISoundTriggerCallback delegate, EventLogger eventLogger, Identity originatorIdentity) {
            this.this$0 = r1;
            delegate.getClass();
            this.mCallbackDelegate = delegate;
            eventLogger.getClass();
            this.mEventLogger = eventLogger;
            this.mOriginatorIdentity = originatorIdentity;
        }

        public void onRecognition(int modelHandle, RecognitionEventSys event, int captureSession) throws RemoteException {
            ((BatteryStatsInternal) SoundTriggerMiddlewareLogging.m8259$$Nest$fgetmBatteryStatsInternalSupplier(this.this$0).get()).noteWakingSoundTrigger(SystemClock.elapsedRealtime(), this.mOriginatorIdentity.uid);     // Catch: Exception -> L5
            this.mCallbackDelegate.onRecognition(modelHandle, event, captureSession);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.RECOGNITION, new Object[]{Integer.valueOf(modelHandle), event, Integer.valueOf(captureSession)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.RECOGNITION, e, new Object[]{Integer.valueOf(modelHandle), event, Integer.valueOf(captureSession)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void onPhraseRecognition(int modelHandle, PhraseRecognitionEventSys event, int captureSession) throws RemoteException {
            ((BatteryStatsInternal) SoundTriggerMiddlewareLogging.m8259$$Nest$fgetmBatteryStatsInternalSupplier(this.this$0).get()).noteWakingSoundTrigger(SystemClock.elapsedRealtime(), this.mOriginatorIdentity.uid);     // Catch: Exception -> L5
            SoundTriggerMiddlewareLogging.m8262$$Nest$mstartKeyphraseEventLatencyTracking(this.this$0, event.phraseRecognitionEvent);     // Catch: Exception -> L5
            this.mCallbackDelegate.onPhraseRecognition(modelHandle, event, captureSession);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.RECOGNITION, new Object[]{Integer.valueOf(modelHandle), event, Integer.valueOf(captureSession)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.RECOGNITION, e, new Object[]{Integer.valueOf(modelHandle), event, Integer.valueOf(captureSession)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void onModelUnloaded(int modelHandle) throws RemoteException {
            this.mCallbackDelegate.onModelUnloaded(modelHandle);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.MODEL_UNLOADED, new Object[]{Integer.valueOf(modelHandle)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.MODEL_UNLOADED, e, new Object[]{Integer.valueOf(modelHandle)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void onResourcesAvailable() throws RemoteException {
            this.mCallbackDelegate.onResourcesAvailable();     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.RESOURCES_AVAILABLE, new Object[0]).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.RESOURCES_AVAILABLE, e, new Object[0]).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void onModuleDied() throws RemoteException {
            this.mCallbackDelegate.onModuleDied();     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.MODULE_DIED, new Object[0]).printLog(2, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.MODULE_DIED, e, new Object[0]).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public IBinder asBinder() {
            return this.mCallbackDelegate.asBinder();
        }

        public String toString() {
            return Objects.toString(this.mCallbackDelegate);
        }
    }

    private class ModuleLogging implements ISoundTriggerModule {
        private ISoundTriggerModule mDelegate;
        private EventLogger mEventLogger;
        final /* synthetic */ SoundTriggerMiddlewareLogging this$0;

        /* synthetic */ ModuleLogging(SoundTriggerMiddlewareLogging r1, SoundTriggerMiddlewareLoggingIA r2) {
            this(r1);
        }

        private ModuleLogging(SoundTriggerMiddlewareLogging r1) {
            this.this$0 = r1;
        }

        void attach(ISoundTriggerModule delegate, EventLogger eventLogger) {
            this.mDelegate = delegate;
            this.mEventLogger = eventLogger;
        }

        public int loadModel(SoundModel model) throws RemoteException {
            int result = this.mDelegate.loadModel(model);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForReturn(SessionEvent.Type.LOAD_MODEL, Integer.valueOf(result), new Object[]{model.uuid}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return result;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForReturn(SessionEvent.Type.LOAD_MODEL, e, new Object[]{model.uuid}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public int loadPhraseModel(PhraseSoundModel model) throws RemoteException {
            int result = this.mDelegate.loadPhraseModel(model);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForReturn(SessionEvent.Type.LOAD_PHRASE_MODEL, Integer.valueOf(result), new Object[]{model.common.uuid}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return result;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.LOAD_PHRASE_MODEL, e, new Object[]{model.common.uuid}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void unloadModel(int modelHandle) throws RemoteException {
            this.mDelegate.unloadModel(modelHandle);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.UNLOAD_MODEL, new Object[]{Integer.valueOf(modelHandle)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.UNLOAD_MODEL, e, new Object[]{Integer.valueOf(modelHandle)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public IBinder startRecognition(int modelHandle, RecognitionConfig config) throws RemoteException {
            IBinder result = this.mDelegate.startRecognition(modelHandle, config);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForReturn(SessionEvent.Type.START_RECOGNITION, result, new Object[]{Integer.valueOf(modelHandle), config}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return result;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.START_RECOGNITION, e, new Object[]{Integer.valueOf(modelHandle), config}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void stopRecognition(int modelHandle) throws RemoteException {
            this.mDelegate.stopRecognition(modelHandle);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.STOP_RECOGNITION, new Object[]{Integer.valueOf(modelHandle)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.STOP_RECOGNITION, e, new Object[]{Integer.valueOf(modelHandle)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void forceRecognitionEvent(int modelHandle) throws RemoteException {
            this.mDelegate.forceRecognitionEvent(modelHandle);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.FORCE_RECOGNITION, new Object[]{Integer.valueOf(modelHandle)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.FORCE_RECOGNITION, e, new Object[]{Integer.valueOf(modelHandle)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void setModelParameter(int modelHandle, int modelParam, int value) throws RemoteException {
            this.mDelegate.setModelParameter(modelHandle, modelParam, value);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.SET_MODEL_PARAMETER, new Object[]{Integer.valueOf(modelHandle), Integer.valueOf(modelParam), Integer.valueOf(value)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.SET_MODEL_PARAMETER, e, new Object[]{Integer.valueOf(modelHandle), Integer.valueOf(modelParam), Integer.valueOf(value)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public int getModelParameter(int modelHandle, int modelParam) throws RemoteException {
            int result = this.mDelegate.getModelParameter(modelHandle, modelParam);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForReturn(SessionEvent.Type.GET_MODEL_PARAMETER, Integer.valueOf(result), new Object[]{Integer.valueOf(modelHandle), Integer.valueOf(modelParam)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return result;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.GET_MODEL_PARAMETER, e, new Object[]{Integer.valueOf(modelHandle), Integer.valueOf(modelParam)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public ModelParameterRange queryModelParameterSupport(int modelHandle, int modelParam) throws RemoteException {
            ModelParameterRange result = this.mDelegate.queryModelParameterSupport(modelHandle, modelParam);     // Catch: Exception -> L5
            this.mEventLogger.enqueue(SessionEvent.createForReturn(SessionEvent.Type.QUERY_MODEL_PARAMETER, result, new Object[]{Integer.valueOf(modelHandle), Integer.valueOf(modelParam)}).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L5
            return result;
        L5:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.QUERY_MODEL_PARAMETER, e, new Object[]{Integer.valueOf(modelHandle), Integer.valueOf(modelParam)}).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        }

        public void detach() throws RemoteException {
        L8:
            e = move-exception;
            this.mEventLogger.enqueue(SessionEvent.createForException(SessionEvent.Type.DETACH, e, new Object[0]).printLog(2, SoundTriggerMiddlewareLogging.TAG));
            throw e;
        L4:
            if (SoundTriggerMiddlewareLogging.m8261$$Nest$fgetmSessionEventLoggers(this.this$0).remove(this.mEventLogger) == true) goto L6;
        L10:
            this.mDelegate.detach();     // Catch: Exception -> L8
            this.mEventLogger.enqueue(SessionEvent.createForVoid(SessionEvent.Type.DETACH, new Object[0]).printLog(0, SoundTriggerMiddlewareLogging.TAG));     // Catch: Exception -> L8
            return;
        L6:
            if (SoundTriggerMiddlewareLogging.m8260$$Nest$fgetmDetachedSessionEventLoggers(this.this$0).offerFirst(this.mEventLogger) == true) goto L10;
            SoundTriggerMiddlewareLogging.m8260$$Nest$fgetmDetachedSessionEventLoggers(this.this$0).pollLast();     // Catch: Exception -> L8
            goto L6
        }

        public IBinder asBinder() {
            return this.mDelegate.asBinder();
        }

        public String toString() {
            return Objects.toString(this.mDelegate);
        }
    }

    private static final class ModulePropertySummary {
        private int mId;
        private String mImplementor;
        private int mVersion;

        ModulePropertySummary(int id, String implementor, int version) {
            this.mId = id;
            this.mImplementor = implementor;
            this.mVersion = version;
        }

        public String toString() {
            return "{Id: " + this.mId + ", Implementor: " + this.mImplementor + ", Version: " + this.mVersion + "}";
        }
    }

    public static class ServiceEvent extends EventLogger.Event {
        private final Exception mException;
        private final String mPackageName;
        private final Object[] mParams;
        private final Object mReturnValue;
        private final Type mType;

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type ATTACH = null;
            public static final Type LIST_MODULE = null;

            private static /* synthetic */ Type[] $values() {
                return new Type[]{ATTACH, LIST_MODULE};
            }

            private Type(String r1, int r2) {
                super(r1, r2);
            }

            public static Type valueOf(String name) {
                return (Type) Enum.valueOf(Type.class, name);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            static {
                ATTACH = new Type("ATTACH", 0);
                LIST_MODULE = new Type("LIST_MODULE", 1);
                $VALUES = $values();
            }
        }

        public static ServiceEvent createForException(Type type, String packageName, Exception exception, Object... params) {
            return new ServiceEvent(exception, type, packageName, null, params);
        }

        public static ServiceEvent createForReturn(Type type, String packageName, Object returnValue, Object... params) {
            return new ServiceEvent(null, type, packageName, returnValue, params);
        }

        private ServiceEvent(Exception exception, Type type, String packageName, Object returnValue, Object... params) {
            this.mException = exception;
            this.mType = type;
            this.mPackageName = packageName;
            this.mReturnValue = returnValue;
            this.mParams = params;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public EventLogger.Event printLog(int type, String tag) {
            SoundTriggerMiddlewareLogging.printSystemLog(type, tag, eventToString(), this.mException);
            return this;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder sb = new StringBuilder(this.mType.name()).append(" [client= ");
            ObjectPrinter.print(sb, this.mPackageName);
            sb.append("] (");
            SoundTriggerMiddlewareLogging.m8263$$Nest$smprintArgs(sb, this.mParams);
            sb.append(") -> ");
            if (this.mException == null) goto L5;
            sb.append("ERROR: ");
            ObjectPrinter.print(sb, this.mException);
        L7:
            return sb.toString();
        L5:
            ObjectPrinter.print(sb, this.mReturnValue);
            goto L7
        }
    }

    public static class SessionEvent extends EventLogger.Event {
        private final Exception mException;
        private final Object[] mParams;
        private final Object mReturnValue;
        private final Type mType;

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type DETACH = null;
            public static final Type FORCE_RECOGNITION = null;
            public static final Type GET_MODEL_PARAMETER = null;
            public static final Type LOAD_MODEL = null;
            public static final Type LOAD_PHRASE_MODEL = null;
            public static final Type MODEL_UNLOADED = null;
            public static final Type MODULE_DIED = null;
            public static final Type QUERY_MODEL_PARAMETER = null;
            public static final Type RECOGNITION = null;
            public static final Type RESOURCES_AVAILABLE = null;
            public static final Type SET_MODEL_PARAMETER = null;
            public static final Type START_RECOGNITION = null;
            public static final Type STOP_RECOGNITION = null;
            public static final Type UNLOAD_MODEL = null;

            private static /* synthetic */ Type[] $values() {
                return new Type[]{LOAD_MODEL, LOAD_PHRASE_MODEL, START_RECOGNITION, STOP_RECOGNITION, FORCE_RECOGNITION, UNLOAD_MODEL, GET_MODEL_PARAMETER, SET_MODEL_PARAMETER, QUERY_MODEL_PARAMETER, DETACH, RECOGNITION, MODEL_UNLOADED, MODULE_DIED, RESOURCES_AVAILABLE};
            }

            private Type(String r1, int r2) {
                super(r1, r2);
            }

            public static Type valueOf(String name) {
                return (Type) Enum.valueOf(Type.class, name);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            static {
                LOAD_MODEL = new Type("LOAD_MODEL", 0);
                LOAD_PHRASE_MODEL = new Type("LOAD_PHRASE_MODEL", 1);
                START_RECOGNITION = new Type("START_RECOGNITION", 2);
                STOP_RECOGNITION = new Type("STOP_RECOGNITION", 3);
                FORCE_RECOGNITION = new Type("FORCE_RECOGNITION", 4);
                UNLOAD_MODEL = new Type("UNLOAD_MODEL", 5);
                GET_MODEL_PARAMETER = new Type("GET_MODEL_PARAMETER", 6);
                SET_MODEL_PARAMETER = new Type("SET_MODEL_PARAMETER", 7);
                QUERY_MODEL_PARAMETER = new Type("QUERY_MODEL_PARAMETER", 8);
                DETACH = new Type("DETACH", 9);
                RECOGNITION = new Type("RECOGNITION", 10);
                MODEL_UNLOADED = new Type("MODEL_UNLOADED", 11);
                MODULE_DIED = new Type("MODULE_DIED", 12);
                RESOURCES_AVAILABLE = new Type("RESOURCES_AVAILABLE", 13);
                $VALUES = $values();
            }
        }

        public static SessionEvent createForException(Type type, Exception exception, Object... params) {
            return new SessionEvent(exception, type, null, params);
        }

        public static SessionEvent createForReturn(Type type, Object returnValue, Object... params) {
            return new SessionEvent(null, type, returnValue, params);
        }

        public static SessionEvent createForVoid(Type type, Object... params) {
            return new SessionEvent(null, type, null, params);
        }

        private SessionEvent(Exception exception, Type type, Object returnValue, Object... params) {
            this.mException = exception;
            this.mType = type;
            this.mReturnValue = returnValue;
            this.mParams = params;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public EventLogger.Event printLog(int type, String tag) {
            SoundTriggerMiddlewareLogging.printSystemLog(type, tag, eventToString(), this.mException);
            return this;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder sb = new StringBuilder(this.mType.name());
            sb.append(" (");
            SoundTriggerMiddlewareLogging.m8263$$Nest$smprintArgs(sb, this.mParams);
            sb.append(")");
            if (this.mException == null) goto L6;
            sb.append(" -> ERROR: ");
            ObjectPrinter.print(sb, this.mException);
        L9:
            return sb.toString();
        L6:
            if (this.mReturnValue == null) goto L9;
            sb.append(" -> ");
            ObjectPrinter.print(sb, this.mReturnValue);
            goto L9
        }
    }

    public static /* synthetic */ ModulePropertySummary $r8$lambda$_H_3ku_eg15znq0fXxJWYk6Pp_s(SoundTriggerModuleDescriptor r0) {
        return lambda$listModules$1(r0);
    }

    public static /* synthetic */ BatteryStatsInternal $r8$lambda$qYVS_7NDYEjr1c0Lww1oCbFAdbc() {
        return lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$y496MtgzyZoUpLTpIkrpwFQ36-0, reason: not valid java name */
    public static /* synthetic */ ModulePropertySummary[] m8258$r8$lambda$y496MtgzyZoUpLTpIkrpwFQ360(int r0) {
        return lambda$listModules$2(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStatsInternalSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m8259$$Nest$fgetmBatteryStatsInternalSupplier(SoundTriggerMiddlewareLogging r0) {
        return r0.mBatteryStatsInternalSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDetachedSessionEventLoggers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Deque m8260$$Nest$fgetmDetachedSessionEventLoggers(SoundTriggerMiddlewareLogging r0) {
        return r0.mDetachedSessionEventLoggers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionEventLoggers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8261$$Nest$fgetmSessionEventLoggers(SoundTriggerMiddlewareLogging r0) {
        return r0.mSessionEventLoggers;
    }

    /* JADX INFO: renamed from: -$$Nest$mstartKeyphraseEventLatencyTracking, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8262$$Nest$mstartKeyphraseEventLatencyTracking(SoundTriggerMiddlewareLogging r0, PhraseRecognitionEvent r1) {
        r0.startKeyphraseEventLatencyTracking(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smprintArgs, reason: not valid java name */
    static /* bridge */ /* synthetic */ StringBuilder m8263$$Nest$smprintArgs(StringBuilder r0, Object[] r1) {
        return printArgs(r0, r1);
    }

    public SoundTriggerMiddlewareLogging(Context context, ISoundTriggerMiddlewareInternal delegate) {
        this(LatencyTracker.getInstance(context), new SoundTriggerMiddlewareLogging$$ExternalSyntheticLambda0(), delegate);
    }

    private static /* synthetic */ BatteryStatsInternal lambda$new$0() {
        return BatteryStatsHolder.m8264$$Nest$sfgetINSTANCE();
    }

    public SoundTriggerMiddlewareLogging(LatencyTracker latencyTracker, Supplier<BatteryStatsInternal> batteryStatsInternalSupplier, ISoundTriggerMiddlewareInternal delegate) {
        this.mServiceEventLogger = new EventLogger(256, "Service Events");
        this.mSessionEventLoggers = ConcurrentHashMap.newKeySet(4);
        this.mDetachedSessionEventLoggers = new LinkedBlockingDeque(4);
        this.mSessionCount = new AtomicInteger(0);
        this.mDelegate = delegate;
        this.mLatencyTracker = latencyTracker;
        this.mBatteryStatsInternalSupplier = batteryStatsInternalSupplier;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public SoundTriggerModuleDescriptor[] listModules() {
        SoundTriggerModuleDescriptor[] result = this.mDelegate.listModules();     // Catch: Exception -> L5
        ModulePropertySummary[] moduleSummary = (ModulePropertySummary[]) Arrays.stream(result).map(new SoundTriggerMiddlewareLogging$$ExternalSyntheticLambda1()).toArray(new SoundTriggerMiddlewareLogging$$ExternalSyntheticLambda2());     // Catch: Exception -> L5
        this.mServiceEventLogger.enqueue(ServiceEvent.createForReturn(ServiceEvent.Type.LIST_MODULE, IdentityContext.get().packageName, moduleSummary, new Object[0]).printLog(0, TAG));     // Catch: Exception -> L5
        return result;
    L5:
        e = move-exception;
        this.mServiceEventLogger.enqueue(ServiceEvent.createForException(ServiceEvent.Type.LIST_MODULE, IdentityContext.get().packageName, e, new Object[0]).printLog(2, TAG));
        throw e;
    }

    private static /* synthetic */ ModulePropertySummary lambda$listModules$1(SoundTriggerModuleDescriptor descriptor) {
        return new ModulePropertySummary(descriptor.handle, descriptor.properties.implementor, descriptor.properties.version);
    }

    private static /* synthetic */ ModulePropertySummary[] lambda$listModules$2(int x$0) {
        return new ModulePropertySummary[x$0];
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerMiddlewareInternal
    public ISoundTriggerModule attach(int handle, ISoundTriggerCallback callback, boolean isTrusted) {
        Identity originatorIdentity = IdentityContext.getNonNull();     // Catch: Exception -> L16
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L16
        r0.append(originatorIdentity.packageName);     // Catch: Exception -> L16
        r0.append(this.mSessionCount.getAndIncrement());     // Catch: Exception -> L16
        if (isTrusted == false) goto L9;
        String r2 = "trusted";
    L10:
        r0.append(r2);     // Catch: Exception -> L16
        String packageIdentification = r0.toString();     // Catch: Exception -> L16
        ModuleLogging result = new ModuleLogging(this, null);     // Catch: Exception -> L16
        EventLogger eventLogger = new EventLogger(128, "Session logger for: " + packageIdentification);     // Catch: Exception -> L16
        SoundTriggerMiddlewareLogging r3 = this;
        ISoundTriggerCallback callback2 = callback;
        CallbackLogging callbackWrapper = new CallbackLogging(r3, callback2, eventLogger, originatorIdentity, null);     // Catch: Exception -> L14
        result.attach(r3.mDelegate.attach(handle, callbackWrapper, isTrusted), eventLogger);     // Catch: Exception -> L14
        r3.mServiceEventLogger.enqueue(ServiceEvent.createForReturn(ServiceEvent.Type.ATTACH, packageIdentification, result, new Object[]{Integer.valueOf(handle), callback2, Boolean.valueOf(isTrusted)}).printLog(0, TAG));     // Catch: Exception -> L14
        r3.mSessionEventLoggers.add(eventLogger);     // Catch: Exception -> L14
        return result;
    L14:
        e = e;
    L18:
        r3.mServiceEventLogger.enqueue(ServiceEvent.createForException(ServiceEvent.Type.ATTACH, IdentityContext.get().packageName, e, new Object[]{Integer.valueOf(handle), callback2}).printLog(2, TAG));
        throw e;
    L9:
        r2 = "";
    L16:
        e = e;
        r3 = this;
        callback2 = callback;
        goto L18
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    private void startKeyphraseEventLatencyTracking(PhraseRecognitionEvent event) {
        if (event.common.status == 0) goto L5;
        return;
    L5:
        if (ArrayUtils.isEmpty(event.phraseExtras) == true) goto L10;
        String latencyTrackerTag = "KeyphraseId=" + event.phraseExtras[0].id;
        this.mLatencyTracker.onActionCancel(19);
        this.mLatencyTracker.onActionStart(19, latencyTrackerTag);
        return;
    }

    private static StringBuilder printArgs(StringBuilder builder, Object[] args) {
        int i = 0;
    L4:
        if (i >= args.length) goto L9;
        if (i <= 0) goto L7;
        builder.append(", ");
    L7:
        ObjectPrinter.print(builder, args[i]);
        i = i + 1;
        goto L4
    L9:
        return builder;
    }

    @Override // com.android.server.soundtrigger_middleware.Dumpable
    public void dump(PrintWriter pw) {
        pw.println("##Service-Wide logs:");
        this.mServiceEventLogger.dump(pw, "  ");
        pw.println("\n##Active Session dumps:\n");
        Iterator<EventLogger> r0 = this.mSessionEventLoggers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        EventLogger sessionLogger = r0.next();
        sessionLogger.dump(pw, "  ");
        pw.println("");
        goto L4
    L6:
        pw.println("##Detached Session dumps:\n");
        Iterator<EventLogger> r1 = this.mDetachedSessionEventLoggers.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        EventLogger sessionLogger2 = r1.next();
        sessionLogger2.dump(pw, "  ");
        pw.println("");
        goto L8
    L11:
        if ((this.mDelegate instanceof Dumpable) == false) goto L16;
        ((Dumpable) this.mDelegate).dump(pw);
        return;
    }

    public static void printSystemLog(int type, String tag, String message, Exception e) {
        switch(type) {
            case 0: goto L6;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L3;
        };
    L3:
        Slog.v(tag, message, e);
        return;
    L4:
        Slog.w(tag, message, e);
        return;
    L5:
        Slog.e(tag, message, e);
        return;
    L6:
        Slog.i(tag, message, e);
    }
}
