package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricAuthenticator.Identifier;
import android.os.IBinder;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class InternalCleanupClient<S extends BiometricAuthenticator.Identifier, T> extends HalClientMonitor<T> implements EnumerateConsumer, RemovalConsumer, EnrollmentModifier {
    private static final String TAG = "Biometrics/InternalCleanupClient";
    private final Map<Integer, Long> mAuthenticatorIds;
    protected final BiometricUtils<S> mBiometricUtils;
    private BaseClientMonitor mCurrentTask;
    private final ClientMonitorCallback mEnumerateCallback;
    private boolean mFavorHalEnrollments;
    private final boolean mHasEnrollmentsBeforeStarting;
    private final ClientMonitorCallback mRemoveCallback;
    private final ArrayList<UserTemplate> mUnknownHALTemplates;

    private static final class UserTemplate {
        final BiometricAuthenticator.Identifier mIdentifier;
        final int mUserId;

        UserTemplate(BiometricAuthenticator.Identifier identifier, int userId) {
            this.mIdentifier = identifier;
            this.mUserId = userId;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ BaseClientMonitor m2623$$Nest$fgetmCurrentTask(InternalCleanupClient r0) {
        return r0.mCurrentTask;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFavorHalEnrollments, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2624$$Nest$fgetmFavorHalEnrollments(InternalCleanupClient r0) {
        return r0.mFavorHalEnrollments;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUnknownHALTemplates, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2625$$Nest$fgetmUnknownHALTemplates(InternalCleanupClient r0) {
        return r0.mUnknownHALTemplates;
    }

    /* JADX INFO: renamed from: -$$Nest$mstartCleanupUnknownHalTemplates, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2626$$Nest$mstartCleanupUnknownHalTemplates(InternalCleanupClient r0) {
        r0.startCleanupUnknownHalTemplates();
    }

    protected abstract InternalEnumerateClient<T> getEnumerateClient(Context r1, Supplier<T> r2, IBinder r3, int r4, String r5, List<S> r6, BiometricUtils<S> r7, int r8, BiometricLogger r9, BiometricContext r10);

    protected abstract int getModality();

    protected abstract RemovalClient<S, T> getRemovalClient(Context r1, Supplier<T> r2, IBinder r3, int r4, int r5, String r6, BiometricUtils<S> r7, int r8, BiometricLogger r9, BiometricContext r10, Map<Integer, Long> r11, int r12);

    protected InternalCleanupClient(Context context, Supplier<T> lazyDaemon, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, BiometricUtils<S> utils, Map<Integer, Long> authenticatorIds) {
        super(context, lazyDaemon, null, null, userId, owner, 0, sensorId, logger, biometricContext, false);
        this.mUnknownHALTemplates = new ArrayList();
        this.mFavorHalEnrollments = false;
        this.mEnumerateCallback = new AnonymousClass1(this);
        this.mRemoveCallback = new AnonymousClass2(this);
        this.mBiometricUtils = utils;
        this.mAuthenticatorIds = authenticatorIds;
        this.mHasEnrollmentsBeforeStarting = !utils.getBiometricsForUser(context, userId).isEmpty();
    }

    private void startCleanupUnknownHalTemplates() {
        Slog.d(TAG, "startCleanupUnknownHalTemplates, size: " + this.mUnknownHALTemplates.size());
        UserTemplate template = this.mUnknownHALTemplates.get(0);
        this.mUnknownHALTemplates.remove(template);
        this.mCurrentTask = getRemovalClient(getContext(), this.mLazyDaemon, getToken(), template.mIdentifier.getBiometricId(), template.mUserId, getContext().getPackageName(), this.mBiometricUtils, getSensorId(), getLogger(), getBiometricContext(), this.mAuthenticatorIds, 1);
        getLogger().logUnknownEnrollmentInHal();
        if (this.mBiometricUtils.hasValidBiometricUserState(getContext(), getTargetUserId()) == false) goto L5;
        getLogger().logFingerprintsLoe();
    L5:
        this.mCurrentTask.start(this.mRemoveCallback);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        List<S> enrolledList = this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId());
        this.mCurrentTask = getEnumerateClient(getContext(), this.mLazyDaemon, getToken(), getTargetUserId(), getOwnerString(), enrolledList, this.mBiometricUtils, getSensorId(), getLogger(), getBiometricContext());
        Slog.d(TAG, "Starting enumerate: " + this.mCurrentTask + " enrolledList size:" + enrolledList.size());
        this.mCurrentTask.start(this.mEnumerateCallback);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
    }

    @Override // com.android.server.biometrics.sensors.RemovalConsumer
    public void onRemoved(BiometricAuthenticator.Identifier identifier, int remaining) {
        if ((this.mCurrentTask instanceof RemovalClient) == true) goto L6;
        Slog.e(TAG, "onRemoved received during client: " + this.mCurrentTask.getClass().getSimpleName());
        return;
    L6:
        ((RemovalClient) this.mCurrentTask).onRemoved(identifier, remaining);
    }

    @Override // com.android.server.biometrics.sensors.EnrollmentModifier
    public boolean hasEnrollmentStateChanged() {
        boolean hasEnrollmentsNow = !this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).isEmpty();
        if (hasEnrollmentsNow != this.mHasEnrollmentsBeforeStarting) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.biometrics.sensors.EnrollmentModifier
    public boolean hasEnrollments() {
        return !this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).isEmpty();
    }

    @Override // com.android.server.biometrics.sensors.EnumerateConsumer
    public void onEnumerationResult(BiometricAuthenticator.Identifier identifier, int remaining) {
        if ((this.mCurrentTask instanceof InternalEnumerateClient) == true) goto L6;
        Slog.e(TAG, "onEnumerationResult received during client: " + this.mCurrentTask.getClass().getSimpleName());
        return;
    L6:
        Slog.d(TAG, "onEnumerated, remaining: " + remaining);
        ((EnumerateConsumer) this.mCurrentTask).onEnumerationResult(identifier, remaining);
    }

    public void setFavorHalEnrollments() {
        this.mFavorHalEnrollments = true;
    }

    protected void onAddUnknownTemplate(int userId, BiometricAuthenticator.Identifier identifier) {
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 7;
    }

    public InternalEnumerateClient<T> getCurrentEnumerateClient() {
        return (InternalEnumerateClient) this.mCurrentTask;
    }

    public RemovalClient<S, T> getCurrentRemoveClient() {
        return (RemovalClient) this.mCurrentTask;
    }

    public ArrayList<UserTemplate> getUnknownHALTemplates() {
        return this.mUnknownHALTemplates;
    }

    protected void handleInvalidBiometricState() {
    }
}
