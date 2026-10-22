package com.android.server.biometrics.sensors.fingerprint.hidl;

import android.content.Context;
import android.content.pm.UserInfo;
import android.hardware.biometrics.fingerprint.ISession;
import android.hardware.biometrics.fingerprint.SensorProps;
import android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint;
import android.os.Handler;
import android.os.IBinder;
import android.os.IHwBinder;
import android.os.RemoteException;
import android.os.UserManager;
import android.util.Slog;
import com.android.server.am.ProcessList;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.BiometricScheduler;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.StartUserClient;
import com.android.server.biometrics.sensors.StopUserClient;
import com.android.server.biometrics.sensors.UserSwitchProvider;
import com.android.server.biometrics.sensors.fingerprint.FingerprintUtils;
import com.android.server.biometrics.sensors.fingerprint.GestureAvailabilityDispatcher;
import com.android.server.biometrics.sensors.fingerprint.aidl.AidlResponseHandler;
import com.android.server.biometrics.sensors.fingerprint.aidl.AidlSession;
import com.android.server.biometrics.sensors.fingerprint.aidl.FingerprintProvider;
import com.android.server.biometrics.sensors.fingerprint.aidl.Sensor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class HidlToAidlSensorAdapter extends Sensor implements IHwBinder.DeathRecipient {
    private static final String TAG = "HidlToAidlSensorAdapter";
    private final AidlResponseHandler.AidlResponseHandlerCallback mAidlResponseHandlerCallback;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private int mCurrentUserId;
    private IBiometricsFingerprint mDaemon;
    private final Runnable mInternalCleanupRunnable;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private LockoutFrameworkImpl mLockoutTracker;
    private AidlSession mSession;
    private final StartUserClient.UserStartedCallback<AidlSession> mUserStartedCallback;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.fingerprint.hidl.HidlToAidlSensorAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements UserSwitchProvider<ISession, AidlSession> {
        final /* synthetic */ HidlToAidlSensorAdapter this$0;

        /* JADX INFO: renamed from: $r8$lambda$Kc293C62WtUnpWYG7-OdssgqiWA, reason: not valid java name */
        public static /* synthetic */ AidlSession m2752$r8$lambda$Kc293C62WtUnpWYG7OdssgqiWA(HidlToAidlSensorAdapter r0) {
            return HidlToAidlSensorAdapter.m2751$$Nest$mgetSession(r0);
        }

        public static /* synthetic */ void $r8$lambda$XIr3kWHZgf_bKl21aUcLAlEZgp8(AnonymousClass2 r0) {
            r0.lambda$getStopUserClient$0();
        }

        AnonymousClass2(HidlToAidlSensorAdapter this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.biometrics.sensors.UserSwitchProvider
        public StopUserClient<AidlSession> getStopUserClient(final int userId) {
            final Context r2 = HidlToAidlSensorAdapter.access$000(this.this$0);
            final HidlToAidlSensorAdapter r1 = this.this$0;
            final Supplier r3 = new HidlToAidlSensorAdapter$2$$ExternalSyntheticLambda0(r1);
            final int r6 = this.this$0.getSensorProperties().sensorId;
            final BiometricLogger r7 = BiometricLogger.ofUnknown(HidlToAidlSensorAdapter.access$100(this.this$0));
            final BiometricContext r8 = HidlToAidlSensorAdapter.access$200(this.this$0);
            final StopUserClient.UserStoppedCallback r9 = new HidlToAidlSensorAdapter$2$$ExternalSyntheticLambda1(this);
            final IBinder r4 = null;
            return new AnonymousClass1(this, r2, r3, r4, userId, r6, r7, r8, r9);
        }

        private /* synthetic */ void lambda$getStopUserClient$0() {
            HidlToAidlSensorAdapter.m2747$$Nest$fputmCurrentUserId(this.this$0, ProcessList.INVALID_ADJ);
            HidlToAidlSensorAdapter.m2749$$Nest$fputmSession(this.this$0, null);
        }

        @Override // com.android.server.biometrics.sensors.UserSwitchProvider
        public StartUserClient<ISession, AidlSession> getStartUserClient(int newUserId) {
            return HidlToAidlSensorAdapter.m2750$$Nest$mgetFingerprintUpdateActiveUserClient(this.this$0, newUserId, false);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-wPEXYFlazZdGejZvf6Ir12IwiY, reason: not valid java name */
    public static /* synthetic */ Integer m2742$r8$lambda$wPEXYFlazZdGejZvf6Ir12IwiY(HidlToAidlSensorAdapter r0) {
        return r0.lambda$getFingerprintUpdateActiveUserClient$4();
    }

    public static /* synthetic */ Integer $r8$lambda$BeN6LuKE2VbzG2uCNRJ3x9xCoDY(HidlToAidlSensorAdapter r0) {
        return r0.lambda$init$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$IVuIoFhufoTQ65AD-R7g5bNnQJo, reason: not valid java name */
    public static /* synthetic */ void m2743$r8$lambda$IVuIoFhufoTQ65ADR7g5bNnQJo(HidlToAidlSensorAdapter r0) {
        r0.lambda$scheduleLoadAuthenticatorIds$5();
    }

    public static /* synthetic */ void $r8$lambda$K5qiiEOAFuDRwfLo4odO9ZBPQO0(HidlToAidlSensorAdapter r0, int r1) {
        r0.lambda$init$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Kc293C62WtUnpWYG7-OdssgqiWA, reason: not valid java name */
    public static /* synthetic */ AidlSession m2744$r8$lambda$Kc293C62WtUnpWYG7OdssgqiWA(HidlToAidlSensorAdapter r0) {
        return r0.getSession();
    }

    public static /* synthetic */ ISession $r8$lambda$hzKCz0gy8JwjgnnYzUAAoIgGgh4(HidlToAidlSensorAdapter r0) {
        return r0.lambda$getFingerprintUpdateActiveUserClient$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$q5X-Y07QkYsG5y1YYqK5eK1ouSw, reason: not valid java name */
    public static /* synthetic */ void m2745$r8$lambda$q5XY07QkYsG5y1YYqK5eK1ouSw(HidlToAidlSensorAdapter r0, int r1, AidlSession r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2746$$Nest$fgetmCurrentUserId(HidlToAidlSensorAdapter r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2747$$Nest$fputmCurrentUserId(HidlToAidlSensorAdapter r0, int r1) {
        r0.mCurrentUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDaemon, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2748$$Nest$fputmDaemon(HidlToAidlSensorAdapter r0, IBiometricsFingerprint r1) {
        r0.mDaemon = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2749$$Nest$fputmSession(HidlToAidlSensorAdapter r0, AidlSession r1) {
        r0.mSession = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFingerprintUpdateActiveUserClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ FingerprintUpdateActiveUserClient m2750$$Nest$mgetFingerprintUpdateActiveUserClient(HidlToAidlSensorAdapter r0, int r1, boolean r2) {
        return r0.getFingerprintUpdateActiveUserClient(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ AidlSession m2751$$Nest$mgetSession(HidlToAidlSensorAdapter r0) {
        return r0.getSession();
    }

    static /* synthetic */ Context access$000(HidlToAidlSensorAdapter x0) {
        return x0.getContext();
    }

    static /* synthetic */ Context access$100(HidlToAidlSensorAdapter x0) {
        return x0.getContext();
    }

    static /* synthetic */ BiometricContext access$200(HidlToAidlSensorAdapter x0) {
        return x0.getBiometricContext();
    }

    private /* synthetic */ void lambda$new$0(int newUserId, AidlSession newUser, int halInterfaceVersion) {
        if (this.mCurrentUserId == newUserId) goto L6;
        handleUserChanged(newUserId);
        return;
    }

    public HidlToAidlSensorAdapter(FingerprintProvider provider, Context context, Handler handler, SensorProps prop, LockoutResetDispatcher lockoutResetDispatcher, BiometricContext biometricContext, boolean resetLockoutRequiresHardwareAuthToken, Runnable internalCleanupRunnable) {
        this(provider, context, handler, prop, lockoutResetDispatcher, biometricContext, resetLockoutRequiresHardwareAuthToken, internalCleanupRunnable, new AuthSessionCoordinator(), null, null);
    }

    HidlToAidlSensorAdapter(FingerprintProvider provider, Context context, Handler handler, SensorProps prop, LockoutResetDispatcher lockoutResetDispatcher, BiometricContext biometricContext, boolean resetLockoutRequiresHardwareAuthToken, Runnable internalCleanupRunnable, AuthSessionCoordinator authSessionCoordinator, IBiometricsFingerprint daemon, AidlResponseHandler.AidlResponseHandlerCallback aidlResponseHandlerCallback) {
        super(provider, context, handler, Sensor.getFingerprintSensorPropertiesInternal(prop, new ArrayList(), resetLockoutRequiresHardwareAuthToken), biometricContext, null);
        this.mCurrentUserId = ProcessList.INVALID_ADJ;
        this.mUserStartedCallback = new HidlToAidlSensorAdapter$$ExternalSyntheticLambda0(this);
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mInternalCleanupRunnable = internalCleanupRunnable;
        this.mAuthSessionCoordinator = authSessionCoordinator;
        this.mDaemon = daemon;
        if (aidlResponseHandlerCallback != null) goto L5;
        AidlResponseHandler.AidlResponseHandlerCallback r4 = new AnonymousClass1(this);
    L6:
        this.mAidlResponseHandlerCallback = r4;
        return;
    L5:
        r4 = aidlResponseHandlerCallback;
        goto L6
    }

    public void serviceDied(long cookie) {
        Slog.d(TAG, "Fingerprint HAL died.");
        this.mSession = null;
        this.mDaemon = null;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.Sensor
    public int getLockoutModeForUser(int userId) {
        return this.mLockoutTracker.getLockoutModeForUser(userId);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.Sensor
    public void init(GestureAvailabilityDispatcher gestureAvailabilityDispatcher, LockoutResetDispatcher lockoutResetDispatcher) {
        setLazySession(new HidlToAidlSensorAdapter$$ExternalSyntheticLambda5(this));
        setScheduler(new BiometricScheduler(getHandler(), BiometricScheduler.sensorTypeFromFingerprintProperties(getSensorProperties()), gestureAvailabilityDispatcher, new HidlToAidlSensorAdapter$$ExternalSyntheticLambda6(this), getUserSwitchProvider()));
        this.mLockoutTracker = new LockoutFrameworkImpl(getContext(), new HidlToAidlSensorAdapter$$ExternalSyntheticLambda7(this), getHandler());
    }

    private /* synthetic */ Integer lambda$init$1() {
        return Integer.valueOf(this.mCurrentUserId);
    }

    private /* synthetic */ void lambda$init$2(int userId) {
        this.mLockoutResetDispatcher.notifyLockoutResetCallbacks(getSensorProperties().sensorId);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.Sensor
    public FingerprintUtils getFingerprintUtilsInstance() {
        return FingerprintUtils.getLegacyInstance(getSensorProperties().sensorId);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.Sensor
    protected AidlSession getSessionForUser(int userId) {
        if (this.mSession != null) goto L5;
        return null;
    L5:
        if (this.mSession.getUserId() == userId) goto L7;
        return null;
    L7:
        return this.mSession;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.Sensor
    protected boolean isHardwareDetected(String halInstance) {
        if (getIBiometricsFingerprint() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.Sensor
    protected LockoutTracker getLockoutTracker(boolean forAuth) {
        return this.mLockoutTracker;
    }

    private synchronized AidlSession getSession() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mSession != null) goto L6;
    L12:
        AidlSession r0 = new AidlSession(new HidlToAidlSensorAdapter$$ExternalSyntheticLambda2(this), this.mCurrentUserId, getAidlResponseHandler());     // Catch: Throwable -> L10
        this.mSession = r0;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L6:
        if (this.mDaemon == null) goto L12;
        AidlSession r1 = this.mSession;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    }

    private AidlResponseHandler getAidlResponseHandler() {
        return new AidlResponseHandler(getContext(), getScheduler(), getSensorProperties().sensorId, this.mCurrentUserId, this.mLockoutTracker, this.mLockoutResetDispatcher, this.mAuthSessionCoordinator, this.mAidlResponseHandlerCallback, getFingerprintUtilsInstance());
    }

    IBiometricsFingerprint getIBiometricsFingerprint() {
        if (getProvider().getTestHalEnabled() == false) goto L7;
        TestHal testHal = new TestHal(getContext(), getSensorProperties().sensorId);
        testHal.setNotify(new HidlToAidlCallbackConverter(getAidlResponseHandler()));
        return testHal;
    L7:
        if (this.mDaemon != null) goto L9;
        this.mDaemon = IBiometricsFingerprint.getService();     // Catch: NoSuchElementException -> L12 RemoteException -> L14
    L19:
        if (this.mDaemon != null) goto L22;
        Slog.w(TAG, "Fingerprint HAL not available");
        return null;
    L22:
        this.mDaemon.asBinder().linkToDeath(this, 0);
        scheduleLoadAuthenticatorIds();
        this.mInternalCleanupRunnable.run();
        return this.mDaemon;
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to get fingerprint HAL", e);
    L12:
        e = move-exception;
        Slog.w(TAG, "NoSuchElementException", e);
        goto L19
    L9:
        return this.mDaemon;
    }

    private UserSwitchProvider<ISession, AidlSession> getUserSwitchProvider() {
        return new AnonymousClass2(this);
    }

    private FingerprintUpdateActiveUserClient getFingerprintUpdateActiveUserClient(int newUserId, boolean forceUpdateAuthenticatorIds) {
        return new FingerprintUpdateActiveUserClient(getContext(), new HidlToAidlSensorAdapter$$ExternalSyntheticLambda3(this), newUserId, TAG, getSensorProperties().sensorId, BiometricLogger.ofUnknown(getContext()), getBiometricContext(), new HidlToAidlSensorAdapter$$ExternalSyntheticLambda4(this), !getFingerprintUtilsInstance().getBiometricsForUser(getContext(), newUserId).isEmpty(), getAuthenticatorIds(), forceUpdateAuthenticatorIds, this.mUserStartedCallback);
    }

    private /* synthetic */ ISession lambda$getFingerprintUpdateActiveUserClient$3() {
        return getSession().getSession();
    }

    private /* synthetic */ Integer lambda$getFingerprintUpdateActiveUserClient$4() {
        return Integer.valueOf(this.mCurrentUserId);
    }

    private void scheduleLoadAuthenticatorIds() {
        getHandler().post(new HidlToAidlSensorAdapter$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$scheduleLoadAuthenticatorIds$5() {
        Iterator r0 = UserManager.get(getContext()).getAliveUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserInfo user = (UserInfo) r0.next();
        int targetUserId = user.id;
        if (getAuthenticatorIds().containsKey(Integer.valueOf(targetUserId)) == true) goto L4;
        getScheduler().scheduleClientMonitor(getFingerprintUpdateActiveUserClient(targetUserId, true));
        goto L4
    }

    void handleUserChanged(int newUserId) {
        Slog.d(TAG, "User changed. Current user for fingerprint sensor is " + newUserId);
        this.mSession = null;
        this.mCurrentUserId = newUserId;
    }
}
