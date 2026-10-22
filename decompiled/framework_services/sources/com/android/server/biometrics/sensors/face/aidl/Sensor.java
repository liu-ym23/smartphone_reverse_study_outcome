package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.content.pm.UserInfo;
import android.hardware.biometrics.ComponentInfoInternal;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.common.ComponentInfo;
import android.hardware.biometrics.face.IFace;
import android.hardware.biometrics.face.ISession;
import android.hardware.biometrics.face.SensorProps;
import android.hardware.face.FaceSensorConfigurations;
import android.hardware.face.FaceSensorPropertiesInternal;
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
import com.android.server.biometrics.sensors.ErrorConsumer;
import com.android.server.biometrics.sensors.LockoutCache;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.StartUserClient;
import com.android.server.biometrics.sensors.StopUserClient;
import com.android.server.biometrics.sensors.UserSwitchProvider;
import com.android.server.biometrics.sensors.face.FaceUtils;
import com.android.server.slice.SliceClientPermissions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class Sensor {
    private static final String TAG = "Sensor";
    private final Map<Integer, Long> mAuthenticatorIds;
    BiometricContext mBiometricContext;
    private final Context mContext;
    AidlSession mCurrentSession;
    private final Handler mHandler;
    private Supplier<AidlSession> mLazySession;
    private LockoutTracker mLockoutTracker;
    private final FaceProvider mProvider;
    private BiometricScheduler<IFace, ISession> mScheduler;
    private final FaceSensorPropertiesInternal mSensorProperties;
    private boolean mTestHalEnabled;
    private final IBinder mToken;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.face.aidl.Sensor$1, reason: invalid class name */
    class AnonymousClass1 implements UserSwitchProvider<IFace, ISession> {
        final /* synthetic */ Sensor this$0;
        final /* synthetic */ LockoutResetDispatcher val$lockoutResetDispatcher;
        final /* synthetic */ FaceProvider val$provider;

        public static /* synthetic */ ISession $r8$lambda$GQAdQXXZipYRxgjWoBtb6EQCYNA(AnonymousClass1 r0) {
            return r0.lambda$getStopUserClient$0();
        }

        public static /* synthetic */ void $r8$lambda$Tcycdm6zKrJxWb64qR2pbNXwNM0(AnonymousClass1 r0) {
            r0.lambda$getStopUserClient$1();
        }

        AnonymousClass1(Sensor this$0, LockoutResetDispatcher r2, FaceProvider r3) {
            this.this$0 = this$0;
            this.val$lockoutResetDispatcher = r2;
            this.val$provider = r3;
        }

        @Override // com.android.server.biometrics.sensors.UserSwitchProvider
        public StopUserClient<ISession> getStopUserClient(int userId) {
            return new FaceStopUserClient(Sensor.m2680$$Nest$fgetmContext(this.this$0), new Sensor$1$$ExternalSyntheticLambda0(this), Sensor.m2686$$Nest$fgetmToken(this.this$0), userId, Sensor.m2685$$Nest$fgetmSensorProperties(this.this$0).sensorId, BiometricLogger.ofUnknown(Sensor.m2680$$Nest$fgetmContext(this.this$0)), this.this$0.mBiometricContext, new Sensor$1$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ ISession lambda$getStopUserClient$0() {
            return ((AidlSession) Sensor.m2681$$Nest$fgetmLazySession(this.this$0).get()).getSession();
        }

        private /* synthetic */ void lambda$getStopUserClient$1() {
            this.this$0.mCurrentSession = null;
        }

        @Override // com.android.server.biometrics.sensors.UserSwitchProvider
        public StartUserClient<IFace, ISession> getStartUserClient(final int newUserId) {
            final int sensorId = Sensor.m2685$$Nest$fgetmSensorProperties(this.this$0).sensorId;
            AidlResponseHandler resultController = new AidlResponseHandler(Sensor.m2680$$Nest$fgetmContext(this.this$0), Sensor.m2684$$Nest$fgetmScheduler(this.this$0), sensorId, newUserId, Sensor.m2682$$Nest$fgetmLockoutTracker(this.this$0), this.val$lockoutResetDispatcher, this.this$0.mBiometricContext.getAuthSessionCoordinator(), new C00081(this, sensorId, newUserId), this.this$0.getFaceUtilsInstance());
            return Sensor.m2687$$Nest$mgetStartUserClient(this.this$0, resultController, sensorId, newUserId, this.val$provider);
        }
    }

    public static /* synthetic */ AidlSession $r8$lambda$FKMQ1vN18Uvp2Dnpwu0_t3IAMtc(Sensor r0) {
        return r0.lambda$init$0();
    }

    public static /* synthetic */ void $r8$lambda$NXmbBxOrhLocTKn0Kwo_uRvHLpU(Sensor r0, AidlResponseHandler r1, int r2, FaceProvider r3, int r4, ISession r5, int r6) {
        r0.lambda$getStartUserClient$2(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$_xxo_3fZnAUB9k5Vy-arsC27-SE, reason: not valid java name */
    public static /* synthetic */ Integer m2679$r8$lambda$_xxo_3fZnAUB9k5VyarsC27SE(Sensor r0) {
        return r0.lambda$getBiometricSchedulerForInit$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2680$$Nest$fgetmContext(Sensor r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLazySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m2681$$Nest$fgetmLazySession(Sensor r0) {
        return r0.mLazySession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockoutTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockoutTracker m2682$$Nest$fgetmLockoutTracker(Sensor r0) {
        return r0.mLockoutTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ FaceProvider m2683$$Nest$fgetmProvider(Sensor r0) {
        return r0.mProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScheduler, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricScheduler m2684$$Nest$fgetmScheduler(Sensor r0) {
        return r0.mScheduler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ FaceSensorPropertiesInternal m2685$$Nest$fgetmSensorProperties(Sensor r0) {
        return r0.mSensorProperties;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m2686$$Nest$fgetmToken(Sensor r0) {
        return r0.mToken;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStartUserClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ FaceStartUserClient m2687$$Nest$mgetStartUserClient(Sensor r0, AidlResponseHandler r1, int r2, int r3, FaceProvider r4) {
        return r0.getStartUserClient(r1, r2, r3, r4);
    }

    Sensor(FaceProvider provider, Context context, Handler handler, FaceSensorPropertiesInternal sensorProperties, BiometricContext biometricContext) {
        this.mProvider = provider;
        this.mContext = context;
        this.mToken = new Binder();
        this.mHandler = handler;
        this.mSensorProperties = sensorProperties;
        this.mBiometricContext = biometricContext;
        this.mAuthenticatorIds = new HashMap();
    }

    public Sensor(FaceProvider provider, Context context, Handler handler, SensorProps prop, BiometricContext biometricContext, boolean resetLockoutRequiresChallenge) {
        this(provider, context, handler, getFaceSensorPropertiesInternal(prop, resetLockoutRequiresChallenge), biometricContext);
    }

    public void init(LockoutResetDispatcher lockoutResetDispatcher, FaceProvider provider) {
        setScheduler(getBiometricSchedulerForInit(lockoutResetDispatcher, provider));
        this.mLazySession = new Sensor$$ExternalSyntheticLambda0(this);
        this.mLockoutTracker = new LockoutCache();
    }

    private /* synthetic */ AidlSession lambda$init$0() {
        if (this.mCurrentSession != null) goto L7;
        return null;
    L7:
        return this.mCurrentSession;
    }

    private BiometricScheduler<IFace, ISession> getBiometricSchedulerForInit(LockoutResetDispatcher lockoutResetDispatcher, FaceProvider provider) {
        return new BiometricScheduler(this.mHandler, 1, null, new Sensor$$ExternalSyntheticLambda1(this), new AnonymousClass1(this, lockoutResetDispatcher, provider));
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

    private FaceStartUserClient getStartUserClient(final AidlResponseHandler resultController, final int sensorId, int newUserId, final FaceProvider provider) {
        StartUserClient.UserStartedCallback<ISession> userStartedCallback = new Sensor$$ExternalSyntheticLambda2(this, resultController, sensorId, provider);
        Context r2 = this.mContext;
        provider.getClass();
        return new FaceStartUserClient(r2, new Sensor$$ExternalSyntheticLambda3(provider), this.mToken, newUserId, this.mSensorProperties.sensorId, BiometricLogger.ofUnknown(this.mContext), this.mBiometricContext, resultController, userStartedCallback);
    }

    private /* synthetic */ void lambda$getStartUserClient$2(AidlResponseHandler resultController, int sensorId, FaceProvider provider, int userIdStarted, ISession newSession, int halInterfaceVersion) {
        Slog.d(TAG, "New face session created for user: " + userIdStarted + " with hal version: " + halInterfaceVersion);
        this.mCurrentSession = new AidlSession(halInterfaceVersion, newSession, userIdStarted, resultController);
        if (FaceUtils.getLegacyInstance(sensorId).isInvalidationInProgress(this.mContext, userIdStarted) == false) goto L6;
        Slog.w(TAG, "Scheduling unfinished invalidation request for face sensor: " + sensorId + ", user: " + userIdStarted);
        provider.scheduleInvalidationRequest(sensorId, userIdStarted);
        return;
    }

    private static FaceSensorPropertiesInternal getFaceSensorPropertiesInternal(SensorProps prop, boolean resetLockoutRequiresChallenge) {
        List<ComponentInfoInternal> componentInfo = new ArrayList();
        if (prop.commonProps.componentInfo == null) goto L9;
        ComponentInfo[] r0 = prop.commonProps.componentInfo;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        ComponentInfo info = r0[r2];
        componentInfo.add(new ComponentInfoInternal(info.componentId, info.hardwareVersion, info.firmwareVersion, info.serialNumber, info.softwareVersion));
        r2 = r2 + 1;
    L9:
        return new FaceSensorPropertiesInternal(prop.commonProps.sensorId, prop.commonProps.sensorStrength, prop.commonProps.maxEnrollmentsPerUser, componentInfo, prop.sensorType, prop.supportsDetectInteraction, prop.halControlsPreview, resetLockoutRequiresChallenge);
    }

    public Supplier<AidlSession> getLazySession() {
        return this.mLazySession;
    }

    protected FaceSensorPropertiesInternal getSensorProperties() {
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

    ITestSession createTestSession(ITestSessionCallback callback) {
        return new BiometricTestSessionImpl(this.mContext, this.mSensorProperties.sensorId, callback, this.mProvider, this);
    }

    public BiometricScheduler<IFace, ISession> getScheduler() {
        return this.mScheduler;
    }

    protected LockoutTracker getLockoutTracker(boolean forAuth) {
        if (forAuth == false) goto L6;
        return null;
    L6:
        return this.mLockoutTracker;
    }

    protected Map<Integer, Long> getAuthenticatorIds() {
        return this.mAuthenticatorIds;
    }

    void setTestHalEnabled(boolean enabled) {
        Slog.w(TAG, "Face setTestHalEnabled: " + enabled);
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
        Slog.d(TAG, "Closing old face session");     // Catch: RemoteException -> L8
        this.mCurrentSession.getSession().close();     // Catch: RemoteException -> L8
        goto L12
    }

    void dumpProtoState(int sensorId, ProtoOutputStream proto, boolean clearSchedulerBuffer) {
        long sensorToken = proto.start(2246267895809L);
        proto.write(1120986464257L, this.mSensorProperties.sensorId);
        proto.write(1159641169922L, 2);
        proto.write(1120986464259L, Utils.getCurrentStrength(this.mSensorProperties.sensorId));
        proto.write(1146756268036L, this.mScheduler.dumpProtoState(clearSchedulerBuffer));
        Iterator r2 = UserManager.get(this.mContext).getUsers().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        UserInfo user = (UserInfo) r2.next();
        int userId = user.getUserHandle().getIdentifier();
        long userToken = proto.start(2246267895813L);
        proto.write(1120986464257L, userId);
        proto.write(1120986464258L, getFaceUtilsInstance().getBiometricsForUser(this.mContext, userId).size());
        proto.end(userToken);
        goto L4
    L6:
        proto.write(1133871366150L, this.mSensorProperties.resetLockoutRequiresHardwareAuthToken);
        proto.write(1133871366151L, this.mSensorProperties.resetLockoutRequiresChallenge);
        proto.end(sensorToken);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBinderDied() {
        BaseClientMonitor r0 = this.mScheduler.getCurrentClient();
        if (r0 != 0) goto L5;
    L8:
        if (r0 == 0) goto L10;
        r0.cancel();
    L10:
        this.mScheduler.recordCrashState();
        this.mScheduler.reset();
        this.mCurrentSession = null;
        return;
    L5:
        if (r0.isInterruptable() == false) goto L8;
        Slog.e(TAG, "Sending face hardware unavailable error for client: " + r0);
        ErrorConsumer errorConsumer = (ErrorConsumer) r0;
        errorConsumer.onError(1, 0);
        FrameworkStatsLog.write(148, 4, 1, -1);
        goto L10
    }

    protected BiometricContext getBiometricContext() {
        return this.mBiometricContext;
    }

    protected Handler getHandler() {
        return this.mHandler;
    }

    protected Context getContext() {
        return this.mContext;
    }

    public void scheduleFaceUpdateActiveUserClient(int userId) {
    }

    public boolean isHardwareDetected(String halInstanceName) {
        if (this.mTestHalEnabled == false) goto L6;
        return true;
    L6:
        if (ServiceManager.checkService(FaceSensorConfigurations.remapFqName(IFace.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + halInstanceName)) != null) goto L10;
        return false;
    L10:
        return true;
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

    public FaceUtils getFaceUtilsInstance() {
        return FaceUtils.getInstance(this.mSensorProperties.sensorId);
    }
}
