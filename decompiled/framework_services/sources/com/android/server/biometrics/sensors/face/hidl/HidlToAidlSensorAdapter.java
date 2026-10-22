package com.android.server.biometrics.sensors.face.hidl;

import android.content.Context;
import android.content.pm.UserInfo;
import android.hardware.biometrics.face.SensorProps;
import android.hardware.biometrics.face.V1_0.IBiometricsFace;
import android.os.Handler;
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
import com.android.server.biometrics.sensors.face.FaceUtils;
import com.android.server.biometrics.sensors.face.LockoutHalImpl;
import com.android.server.biometrics.sensors.face.aidl.AidlResponseHandler;
import com.android.server.biometrics.sensors.face.aidl.AidlSession;
import com.android.server.biometrics.sensors.face.aidl.FaceProvider;
import com.android.server.biometrics.sensors.face.aidl.Sensor;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class HidlToAidlSensorAdapter extends Sensor implements IHwBinder.DeathRecipient {
    private static final String TAG = "HidlToAidlSensorAdapter";
    private final AidlResponseHandler.AidlResponseHandlerCallback mAidlResponseHandlerCallback;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private int mCurrentUserId;
    private IBiometricsFace mDaemon;
    private final FaceProvider mFaceProvider;
    private final Runnable mInternalCleanupAndGetFeatureRunnable;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private LockoutHalImpl mLockoutTracker;
    private AidlSession mSession;
    private final StartUserClient.UserStartedCallback<AidlSession> mUserStartedCallback;

    public static /* synthetic */ Integer $r8$lambda$FJjvKbPjEv6TEUrQiM1jjsfDAHc(HidlToAidlSensorAdapter r0) {
        return r0.lambda$init$1();
    }

    public static /* synthetic */ void $r8$lambda$HOc3JPOzKL5jUL6VYht1uq31aXo(HidlToAidlSensorAdapter r0) {
        r0.lambda$scheduleLoadAuthenticatorIds$2();
    }

    public static /* synthetic */ void $r8$lambda$s2IFFJnZU55Q9zycXiLrNywSER0(HidlToAidlSensorAdapter r0, int r1, AidlSession r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    public static /* synthetic */ IBiometricsFace $r8$lambda$tyLcgWxvpxdJHyIZWnoWBI4BDzE(HidlToAidlSensorAdapter r0) {
        return r0.getIBiometricsFace();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2688$$Nest$fgetmCurrentUserId(HidlToAidlSensorAdapter r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2689$$Nest$fputmCurrentUserId(HidlToAidlSensorAdapter r0, int r1) {
        r0.mCurrentUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDaemon, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2690$$Nest$fputmDaemon(HidlToAidlSensorAdapter r0, IBiometricsFace r1) {
        r0.mDaemon = r1;
    }

    private /* synthetic */ void lambda$new$0(int newUserId, AidlSession newUser, int halInterfaceVersion) {
        if (newUserId == this.mCurrentUserId) goto L6;
        handleUserChanged(newUserId);
        return;
    }

    public HidlToAidlSensorAdapter(FaceProvider provider, Context context, Handler handler, SensorProps prop, LockoutResetDispatcher lockoutResetDispatcher, BiometricContext biometricContext, boolean resetLockoutRequiresChallenge, Runnable internalCleanupAndGetFeatureRunnable) {
        this(provider, context, handler, prop, lockoutResetDispatcher, biometricContext, resetLockoutRequiresChallenge, internalCleanupAndGetFeatureRunnable, new AuthSessionCoordinator(), null, null);
    }

    HidlToAidlSensorAdapter(FaceProvider provider, Context context, Handler handler, SensorProps prop, LockoutResetDispatcher lockoutResetDispatcher, BiometricContext biometricContext, boolean resetLockoutRequiresChallenge, Runnable internalCleanupAndGetFeatureRunnable, AuthSessionCoordinator authSessionCoordinator, IBiometricsFace daemon, AidlResponseHandler.AidlResponseHandlerCallback aidlResponseHandlerCallback) {
        super(provider, context, handler, prop, biometricContext, resetLockoutRequiresChallenge);
        this.mCurrentUserId = ProcessList.INVALID_ADJ;
        this.mUserStartedCallback = new HidlToAidlSensorAdapter$$ExternalSyntheticLambda4(this);
        this.mInternalCleanupAndGetFeatureRunnable = internalCleanupAndGetFeatureRunnable;
        this.mFaceProvider = provider;
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
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

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    public void scheduleFaceUpdateActiveUserClient(int userId) {
        getScheduler().scheduleClientMonitor(getFaceUpdateActiveUserClient(userId));
    }

    public void serviceDied(long cookie) {
        Slog.d(TAG, "Face HAL died.");
        this.mDaemon = null;
    }

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    public boolean isHardwareDetected(String halInstanceName) {
        if (getIBiometricsFace() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    public int getLockoutModeForUser(int userId) {
        return this.mLockoutTracker.getLockoutModeForUser(userId);
    }

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    public void init(LockoutResetDispatcher lockoutResetDispatcher, FaceProvider provider) {
        setScheduler(new BiometricScheduler(getHandler(), 1, null, new HidlToAidlSensorAdapter$$ExternalSyntheticLambda0(this), null));
        setLazySession(new HidlToAidlSensorAdapter$$ExternalSyntheticLambda1(this));
        this.mLockoutTracker = new LockoutHalImpl();
    }

    private /* synthetic */ Integer lambda$init$1() {
        return Integer.valueOf(this.mCurrentUserId);
    }

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    protected AidlSession getSessionForUser(int userId) {
        if (this.mSession != null) goto L5;
        return null;
    L5:
        if (this.mSession.getUserId() == userId) goto L7;
        return null;
    L7:
        return this.mSession;
    }

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    public FaceUtils getFaceUtilsInstance() {
        return FaceUtils.getLegacyInstance(getSensorProperties().sensorId);
    }

    @Override // com.android.server.biometrics.sensors.face.aidl.Sensor
    protected LockoutTracker getLockoutTracker(boolean forAuth) {
        return this.mLockoutTracker;
    }

    AidlSession getSession() {
        if (this.mDaemon != null) goto L5;
    L8:
        AidlSession r0 = new AidlSession(getContext(), new HidlToAidlSensorAdapter$$ExternalSyntheticLambda3(this), this.mCurrentUserId, getAidlResponseHandler());
        this.mSession = r0;
        return r0;
    L5:
        if (this.mSession == null) goto L8;
        return this.mSession;
    }

    private AidlResponseHandler getAidlResponseHandler() {
        return new AidlResponseHandler(getContext(), getScheduler(), getSensorProperties().sensorId, this.mCurrentUserId, this.mLockoutTracker, this.mLockoutResetDispatcher, this.mAuthSessionCoordinator, this.mAidlResponseHandlerCallback, getFaceUtilsInstance());
    }

    private IBiometricsFace getIBiometricsFace() {
        if (this.mFaceProvider.getTestHalEnabled() == false) goto L7;
        TestHal testHal = new TestHal(getContext(), getSensorProperties().sensorId);
        testHal.setCallback(new HidlToAidlCallbackConverter(getAidlResponseHandler()));
        return testHal;
    L7:
        if (this.mDaemon != null) goto L9;
        Slog.d(TAG, "Face daemon was null, reconnecting, current operation: " + getScheduler().getCurrentClient());
        this.mDaemon = IBiometricsFace.getService();     // Catch: RemoteException -> L13 NoSuchElementException -> L15
    L20:
        if (this.mDaemon != null) goto L23;
        Slog.w(TAG, "Face HAL not available");
        return null;
    L23:
        this.mDaemon.asBinder().linkToDeath(this, 0);
        scheduleLoadAuthenticatorIds();
        this.mInternalCleanupAndGetFeatureRunnable.run();
        return this.mDaemon;
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to get face HAL", e);
    L15:
        e = move-exception;
        Slog.w(TAG, "NoSuchElementException", e);
        goto L20
    L9:
        return this.mDaemon;
    }

    void handleUserChanged(int newUserId) {
        Slog.d(TAG, "User changed. Current user for face sensor is " + newUserId);
        this.mSession = null;
        this.mCurrentUserId = newUserId;
    }

    private void scheduleLoadAuthenticatorIds() {
        getHandler().post(new HidlToAidlSensorAdapter$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$scheduleLoadAuthenticatorIds$2() {
        Iterator r0 = UserManager.get(getContext()).getAliveUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserInfo user = (UserInfo) r0.next();
        int targetUserId = user.id;
        if (getAuthenticatorIds().containsKey(Integer.valueOf(targetUserId)) == true) goto L4;
        scheduleFaceUpdateActiveUserClient(targetUserId);
        goto L4
    }

    private FaceUpdateActiveUserClient getFaceUpdateActiveUserClient(int userId) {
        return new FaceUpdateActiveUserClient(getContext(), new HidlToAidlSensorAdapter$$ExternalSyntheticLambda3(this), this.mUserStartedCallback, userId, TAG, getSensorProperties().sensorId, BiometricLogger.ofUnknown(getContext()), getBiometricContext(), !getFaceUtilsInstance().getBiometricsForUser(getContext(), userId).isEmpty(), getAuthenticatorIds());
    }
}
