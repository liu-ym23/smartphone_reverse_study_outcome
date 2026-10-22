package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.content.Context;
import android.content.pm.UserInfo;
import android.hardware.biometrics.ComponentInfoInternal;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.SensorLocationInternal;
import android.hardware.biometrics.common.ComponentInfo;
import android.hardware.biometrics.fingerprint.IFingerprint;
import android.hardware.biometrics.fingerprint.ISession;
import android.hardware.biometrics.fingerprint.SensorLocation;
import android.hardware.biometrics.fingerprint.SensorProps;
import android.hardware.fingerprint.FingerprintSensorConfigurations;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.am.ProcessList;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.BiometricScheduler;
import com.android.server.biometrics.sensors.BiometricStateCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.StartUserClient;
import com.android.server.biometrics.sensors.StopUserClient;
import com.android.server.biometrics.sensors.UserSwitchProvider;
import com.android.server.biometrics.sensors.ZswLockoutTrackerImpl;
import com.android.server.biometrics.sensors.fingerprint.FingerprintUtils;
import com.android.server.biometrics.sensors.fingerprint.GestureAvailabilityDispatcher;
import com.android.server.slice.SliceClientPermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class Sensor {
    private static final String TAG = "Sensor";
    private final Map<Integer, Long> mAuthenticatorIds;
    private final BiometricContext mBiometricContext;
    private final Context mContext;
    AidlSession mCurrentSession;
    private final Handler mHandler;
    private Supplier<AidlSession> mLazySession;
    private LockoutTracker mLockoutTracker;
    private final FingerprintProvider mProvider;
    private BiometricScheduler<IFingerprint, ISession> mScheduler;
    private final FingerprintSensorPropertiesInternal mSensorProperties;
    private boolean mTestHalEnabled;
    private final IBinder mToken;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.fingerprint.aidl.Sensor$1, reason: invalid class name */
    class AnonymousClass1 implements UserSwitchProvider<IFingerprint, ISession> {
        final /* synthetic */ Sensor this$0;
        final /* synthetic */ LockoutResetDispatcher val$lockoutResetDispatcher;

        public static /* synthetic */ ISession $r8$lambda$6IraTHMy1QBsUPBXJiTWbJpMd80(AnonymousClass1 r0) {
            return r0.lambda$getStopUserClient$0();
        }

        public static /* synthetic */ void $r8$lambda$uT02xNFz11S9X_rHsV1K7ms_ghw(AnonymousClass1 r0) {
            r0.lambda$getStopUserClient$1();
        }

        AnonymousClass1(Sensor this$0, LockoutResetDispatcher r2) {
            this.this$0 = this$0;
            this.val$lockoutResetDispatcher = r2;
        }

        @Override // com.android.server.biometrics.sensors.UserSwitchProvider
        public StopUserClient<ISession> getStopUserClient(int userId) {
            return new FingerprintStopUserClient(Sensor.m2730$$Nest$fgetmContext(this.this$0), new Sensor$1$$ExternalSyntheticLambda0(this), Sensor.m2736$$Nest$fgetmToken(this.this$0), userId, Sensor.m2735$$Nest$fgetmSensorProperties(this.this$0).sensorId, BiometricLogger.ofUnknown(Sensor.m2730$$Nest$fgetmContext(this.this$0)), Sensor.m2729$$Nest$fgetmBiometricContext(this.this$0), new Sensor$1$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ ISession lambda$getStopUserClient$0() {
            return ((AidlSession) Sensor.m2731$$Nest$fgetmLazySession(this.this$0).get()).getSession();
        }

        private /* synthetic */ void lambda$getStopUserClient$1() {
            this.this$0.mCurrentSession = null;
        }

        @Override // com.android.server.biometrics.sensors.UserSwitchProvider
        public StartUserClient<IFingerprint, ISession> getStartUserClient(final int newUserId) {
            final int sensorId = Sensor.m2735$$Nest$fgetmSensorProperties(this.this$0).sensorId;
            AidlResponseHandler resultController = new AidlResponseHandler(Sensor.m2730$$Nest$fgetmContext(this.this$0), Sensor.m2734$$Nest$fgetmScheduler(this.this$0), sensorId, newUserId, Sensor.m2732$$Nest$fgetmLockoutTracker(this.this$0), this.val$lockoutResetDispatcher, Sensor.m2729$$Nest$fgetmBiometricContext(this.this$0).getAuthSessionCoordinator(), new C00111(this, sensorId, newUserId), this.this$0.getFingerprintUtilsInstance());
            return Sensor.m2737$$Nest$mgetStartUserClient(this.this$0, resultController, sensorId, newUserId);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-KQmHF3X1xhozR4LcNLarJOuYdM, reason: not valid java name */
    public static /* synthetic */ Integer m2725$r8$lambda$KQmHF3X1xhozR4LcNLarJOuYdM(Sensor r0) {
        return r0.lambda$getBiometricSchedulerForInit$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$5_mPPF3pM7Na-xROLmZvgUQkybQ, reason: not valid java name */
    public static /* synthetic */ void m2726$r8$lambda$5_mPPF3pM7NaxROLmZvgUQkybQ(Sensor r0, AidlResponseHandler r1, int r2, int r3, ISession r4, int r5) {
        r0.lambda$getStartUserClient$2(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$D95l73NKbYyECBDY-3cqPliPJYc, reason: not valid java name */
    public static /* synthetic */ AidlSession m2727$r8$lambda$D95l73NKbYyECBDY3cqPliPJYc(Sensor r0) {
        return r0.lambda$init$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$_GlcO2ai-HjPxKZq8Jmr8Z-zIlk, reason: not valid java name */
    public static /* synthetic */ SensorLocationInternal m2728$r8$lambda$_GlcO2aiHjPxKZq8Jmr8ZzIlk(SensorLocation r0) {
        return lambda$getFingerprintSensorPropertiesInternal$3(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricContext m2729$$Nest$fgetmBiometricContext(Sensor r0) {
        return r0.mBiometricContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2730$$Nest$fgetmContext(Sensor r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLazySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m2731$$Nest$fgetmLazySession(Sensor r0) {
        return r0.mLazySession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockoutTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockoutTracker m2732$$Nest$fgetmLockoutTracker(Sensor r0) {
        return r0.mLockoutTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ FingerprintProvider m2733$$Nest$fgetmProvider(Sensor r0) {
        return r0.mProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScheduler, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricScheduler m2734$$Nest$fgetmScheduler(Sensor r0) {
        return r0.mScheduler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ FingerprintSensorPropertiesInternal m2735$$Nest$fgetmSensorProperties(Sensor r0) {
        return r0.mSensorProperties;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m2736$$Nest$fgetmToken(Sensor r0) {
        return r0.mToken;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStartUserClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ FingerprintStartUserClient m2737$$Nest$mgetStartUserClient(Sensor r0, AidlResponseHandler r1, int r2, int r3) {
        return r0.getStartUserClient(r1, r2, r3);
    }

    public Sensor(FingerprintProvider provider, Context context, Handler handler, FingerprintSensorPropertiesInternal sensorProperties, BiometricContext biometricContext, AidlSession session) {
        this.mProvider = provider;
        this.mContext = context;
        this.mToken = new Binder();
        this.mHandler = handler;
        this.mSensorProperties = sensorProperties;
        this.mBiometricContext = biometricContext;
        this.mAuthenticatorIds = new HashMap();
        this.mCurrentSession = session;
    }

    Sensor(FingerprintProvider provider, Context context, Handler handler, SensorProps sensorProp, BiometricContext biometricContext, List<SensorLocationInternal> workaroundLocation, boolean resetLockoutRequiresHardwareAuthToken) {
        this(provider, context, handler, getFingerprintSensorPropertiesInternal(sensorProp, workaroundLocation, resetLockoutRequiresHardwareAuthToken), biometricContext, null);
    }

    public void init(GestureAvailabilityDispatcher gestureAvailabilityDispatcher, LockoutResetDispatcher lockoutResetDispatcher) {
        setScheduler(getBiometricSchedulerForInit(gestureAvailabilityDispatcher, lockoutResetDispatcher));
        this.mLockoutTracker = new ZswLockoutTrackerImpl(getContext(), getHandler(), lockoutResetDispatcher, this.mSensorProperties);
        this.mLazySession = new Sensor$$ExternalSyntheticLambda2(this);
    }

    private /* synthetic */ AidlSession lambda$init$0() {
        if (this.mCurrentSession != null) goto L7;
        return null;
    L7:
        return this.mCurrentSession;
    }

    private BiometricScheduler<IFingerprint, ISession> getBiometricSchedulerForInit(GestureAvailabilityDispatcher gestureAvailabilityDispatcher, LockoutResetDispatcher lockoutResetDispatcher) {
        return new BiometricScheduler(this.mHandler, BiometricScheduler.sensorTypeFromFingerprintProperties(this.mSensorProperties), gestureAvailabilityDispatcher, new Sensor$$ExternalSyntheticLambda3(this), new AnonymousClass1(this, lockoutResetDispatcher));
    }

    private /* synthetic */ Integer lambda$getBiometricSchedulerForInit$1() {
        if (this.mCurrentSession == null) goto L5;
        int r0 = this.mCurrentSession.getUserId();
    L7:
        return Integer.valueOf(r0);
    L5:
        r0 = ProcessList.INVALID_ADJ;
        goto L7
    }

    private FingerprintStartUserClient getStartUserClient(final AidlResponseHandler resultController, final int sensorId, int newUserId) {
        StartUserClient.UserStartedCallback<ISession> userStartedCallback = new Sensor$$ExternalSyntheticLambda0(this, resultController, sensorId);
        Context r2 = this.mContext;
        final FingerprintProvider r0 = this.mProvider;
        r0.getClass();
        return new FingerprintStartUserClient(r2, new Sensor$$ExternalSyntheticLambda1(r0), this.mToken, newUserId, this.mSensorProperties.sensorId, BiometricLogger.ofUnknown(this.mContext), this.mBiometricContext, resultController, userStartedCallback);
    }

    private /* synthetic */ void lambda$getStartUserClient$2(AidlResponseHandler resultController, int sensorId, int userIdStarted, ISession newSession, int halInterfaceVersion) {
        this.mCurrentSession = new AidlSession(halInterfaceVersion, newSession, userIdStarted, resultController);
        Slog.d(TAG, "New fingerprint session created for user: " + userIdStarted + " with hal version: " + halInterfaceVersion + " session=" + this.mCurrentSession + " resultController=" + resultController);
        if (getFingerprintUtilsInstance().isInvalidationInProgress(this.mContext, userIdStarted) == false) goto L6;
        Slog.w(TAG, "Scheduling unfinished invalidation request for fingerprint sensor: " + sensorId + ", user: " + userIdStarted);
        this.mProvider.scheduleInvalidationRequest(sensorId, userIdStarted);
        return;
    }

    protected static FingerprintSensorPropertiesInternal getFingerprintSensorPropertiesInternal(SensorProps prop, List<SensorLocationInternal> workaroundLocations, boolean resetLockoutRequiresHardwareAuthToken) {
        List<ComponentInfoInternal> componentInfo = new ArrayList();
        if (prop.commonProps.componentInfo == null) goto L8;
        ComponentInfo[] r0 = prop.commonProps.componentInfo;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        ComponentInfo info = r0[r2];
        componentInfo.add(new ComponentInfoInternal(info.componentId, info.hardwareVersion, info.firmwareVersion, info.serialNumber, info.softwareVersion));
        r2 = r2 + 1;
    L8:
        int r3 = prop.commonProps.sensorId;
        byte r4 = prop.commonProps.sensorStrength;
        int r5 = prop.commonProps.maxEnrollmentsPerUser;
        byte r6 = prop.sensorType;
        boolean r7 = prop.halControlsIllumination;
        if (workaroundLocations.isEmpty() == true) goto L11;
        List<SensorLocationInternal> r9 = workaroundLocations;
    L13:
        return new FingerprintSensorPropertiesInternal(r3, r4, r5, componentInfo, r6, r7, resetLockoutRequiresHardwareAuthToken, r9);
    L11:
        r9 = (List) Arrays.stream(prop.sensorLocations).map(new Sensor$$ExternalSyntheticLambda4()).collect(Collectors.toList());
        goto L13
    }

    private static /* synthetic */ SensorLocationInternal lambda$getFingerprintSensorPropertiesInternal$3(SensorLocation location) {
        return new SensorLocationInternal(location.display, location.sensorLocationX, location.sensorLocationY, location.sensorRadius);
    }

    public Supplier<AidlSession> getLazySession() {
        return this.mLazySession;
    }

    public FingerprintSensorPropertiesInternal getSensorProperties() {
        return this.mSensorProperties;
    }

    protected AidlSession getSessionForUser(int userId) {
        Slog.d(TAG, "getSessionForUser: mCurrentSession: " + this.mCurrentSession);
        if (this.mCurrentSession != null) goto L5;
        return null;
    L5:
        if (this.mCurrentSession.getUserId() == userId) goto L7;
        return null;
    L7:
        return this.mCurrentSession;
    }

    ITestSession createTestSession(ITestSessionCallback callback, BiometricStateCallback biometricStateCallback) {
        return new BiometricTestSessionImpl(this.mContext, this.mSensorProperties.sensorId, callback, biometricStateCallback, this.mProvider, this);
    }

    public BiometricScheduler<IFingerprint, ISession> getScheduler() {
        return this.mScheduler;
    }

    protected LockoutTracker getLockoutTracker(boolean forAuth) {
        return this.mLockoutTracker;
    }

    public Map<Integer, Long> getAuthenticatorIds() {
        return this.mAuthenticatorIds;
    }

    void setTestHalEnabled(boolean enabled) {
        Slog.w(TAG, "Fingerprint setTestHalEnabled: " + enabled);
        if (enabled != this.mTestHalEnabled) goto L15;
    L13:
        this.mTestHalEnabled = enabled;
        return;
    L15:
    L8:
        e = move-exception;
        Slog.e(TAG, "RemoteException", e);
    L12:
        this.mCurrentSession = null;
        goto L13
    L5:
        if (this.mCurrentSession == null) goto L12;
        Slog.d(TAG, "Closing old fingerprint session");     // Catch: RemoteException -> L8
        this.mCurrentSession.getSession().close();     // Catch: RemoteException -> L8
        goto L12
    }

    void dumpProtoState(int sensorId, ProtoOutputStream proto, boolean clearSchedulerBuffer) {
        long sensorToken = proto.start(2246267895809L);
        proto.write(1120986464257L, this.mSensorProperties.sensorId);
        proto.write(1159641169922L, 1);
        if (this.mSensorProperties.isAnyUdfpsType() == false) goto L5;
        proto.write(2259152797704L, 0);
    L5:
        proto.write(1120986464259L, Utils.getCurrentStrength(this.mSensorProperties.sensorId));
        proto.write(1146756268036L, this.mScheduler.dumpProtoState(clearSchedulerBuffer));
        Iterator r2 = UserManager.get(this.mContext).getUsers().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        UserInfo user = (UserInfo) r2.next();
        int userId = user.getUserHandle().getIdentifier();
        long userToken = proto.start(2246267895813L);
        proto.write(1120986464257L, userId);
        proto.write(1120986464258L, getFingerprintUtilsInstance().getBiometricsForUser(this.mContext, userId).size());
        proto.end(userToken);
        goto L7
    L9:
        proto.write(1133871366150L, this.mSensorProperties.resetLockoutRequiresHardwareAuthToken);
        proto.write(1133871366151L, this.mSensorProperties.resetLockoutRequiresChallenge);
        proto.end(sensorToken);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBinderDied() {
        BaseClientMonitor r0 = this.mScheduler.getCurrentClient();
        if ((r0 instanceof ErrorConsumer) == false) goto L6;
        Slog.e(TAG, "Sending fingerprint hardware unavailable error for client: " + r0);
        ErrorConsumer errorConsumer = (ErrorConsumer) r0;
        errorConsumer.onError(1, 0);
        FrameworkStatsLog.write(148, 1, 1, -1);
    L8:
        this.mScheduler.recordCrashState();
        this.mScheduler.reset();
        this.mCurrentSession = null;
        return;
    L6:
        if (r0 == 0) goto L8;
        r0.cancel();
        goto L8
    }

    protected Handler getHandler() {
        return this.mHandler;
    }

    protected Context getContext() {
        return this.mContext;
    }

    protected boolean isHardwareDetected(String halInstance) {
        if (this.mTestHalEnabled == false) goto L6;
        return true;
    L6:
        if (ServiceManager.checkService(FingerprintSensorConfigurations.remapFqName(IFingerprint.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + halInstance)) != null) goto L10;
        return false;
    L10:
        return true;
    }

    protected BiometricContext getBiometricContext() {
        return this.mBiometricContext;
    }

    public int getLockoutModeForUser(int userId) {
        return this.mBiometricContext.getAuthSessionCoordinator().getLockoutStateFor(userId, Utils.getCurrentStrength(this.mSensorProperties.sensorId));
    }

    public void setScheduler(BiometricScheduler scheduler) {
        this.mScheduler = scheduler;
    }

    public void setLazySession(Supplier<AidlSession> lazySession) {
        this.mLazySession = lazySession;
    }

    public FingerprintProvider getProvider() {
        return this.mProvider;
    }

    public FingerprintUtils getFingerprintUtilsInstance() {
        return FingerprintUtils.getInstance(this.mSensorProperties.sensorId);
    }

    void registerPostAuthAcquiredFallback(int userId, long requestId, ClientMonitorCallbackConverter listener) {
        AidlSession session = getSessionForUser(userId);
        if (session != null) goto L6;
        Slog.w(TAG, "Unable to register post-auth acquired fallback, no active session: sensorId=" + this.mSensorProperties.sensorId + ", userId=" + userId + ", requestId=" + requestId);
        return;
    L6:
        session.getHalSessionCallback().registerPostAuthAcquiredFallback(listener, requestId);
    }
}
