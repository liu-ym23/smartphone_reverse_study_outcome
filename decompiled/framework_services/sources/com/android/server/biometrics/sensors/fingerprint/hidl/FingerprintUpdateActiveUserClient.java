package com.android.server.biometrics.sensors.fingerprint.hidl;

import android.content.Context;
import android.hardware.biometrics.fingerprint.ISession;
import android.os.Build;
import android.os.Environment;
import android.os.RemoteException;
import android.os.SELinux;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.StartUserClient;
import com.android.server.biometrics.sensors.fingerprint.aidl.AidlSession;
import java.io.File;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintUpdateActiveUserClient extends StartUserClient<ISession, AidlSession> {
    private static final String FP_DATA_DIR = "fpdata";
    private static final String TAG = "FingerprintUpdateActiveUserClient";
    private final Map<Integer, Long> mAuthenticatorIds;
    private final Supplier<Integer> mCurrentUserId;
    private File mDirectory;
    private final boolean mForceUpdateAuthenticatorId;
    private final boolean mHasEnrolledBiometrics;

    FingerprintUpdateActiveUserClient(Context context, Supplier<ISession> lazyDaemon, int userId, String owner, int sensorId, BiometricLogger logger, BiometricContext biometricContext, Supplier<Integer> currentUserId, boolean hasEnrolledBiometrics, Map<Integer, Long> authenticatorIds, boolean forceUpdateAuthenticatorId, StartUserClient.UserStartedCallback<AidlSession> userStartedCallback) {
        super(context, lazyDaemon, null, userId, sensorId, logger, biometricContext, userStartedCallback);
        this.mCurrentUserId = currentUserId;
        this.mForceUpdateAuthenticatorId = forceUpdateAuthenticatorId;
        this.mHasEnrolledBiometrics = hasEnrolledBiometrics;
        this.mAuthenticatorIds = authenticatorIds;
    }

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
    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        if (this.mCurrentUserId.get().intValue() == getTargetUserId()) goto L5;
    L8:
        int firstSdkInt = Build.VERSION.DEVICE_INITIAL_SDK_INT;
        if (firstSdkInt >= 1) goto L12;
        Slog.e(TAG, "First SDK version " + firstSdkInt + " is invalid; must be at least VERSION_CODES.BASE");
    L12:
        if (firstSdkInt > 27) goto L14;
        File baseDir = Environment.getUserSystemDirectory(getTargetUserId());
    L15:
        this.mDirectory = new File(baseDir, FP_DATA_DIR);
        if (this.mDirectory.exists() == false) goto L18;
    L25:
        startHalOperation();
        return;
    L18:
        if (this.mDirectory.mkdir() == true) goto L22;
        Slog.e(TAG, "Cannot make directory: " + this.mDirectory.getAbsolutePath());
        callback.onClientFinished(this, false);
        return;
    L22:
        if (SELinux.restorecon(this.mDirectory) == true) goto L25;
        Slog.e(TAG, "Restorecons failed. Directory will have wrong label.");
        callback.onClientFinished(this, false);
        return;
    L14:
        baseDir = Environment.getDataVendorDeDirectory(getTargetUserId());
        goto L15
    L5:
        if (this.mForceUpdateAuthenticatorId == true) goto L8;
        Slog.d(TAG, "Already user: " + this.mCurrentUserId + ", returning");
        this.mUserStartedCallback.onUserStarted(getTargetUserId(), null, 0);
        callback.onClientFinished(this, true);
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    public void unableToStart() {
    }

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
    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        int targetId = getTargetUserId();     // Catch: RemoteException -> L7
        Slog.d(TAG, "Setting active user: " + targetId);     // Catch: RemoteException -> L7
        HidlToAidlSessionAdapter sessionAdapter = (HidlToAidlSessionAdapter) getFreshDaemon();     // Catch: RemoteException -> L7
        if (sessionAdapter.getIBiometricsFingerprint() != null) goto L9;
        Slog.e(TAG, "Failed to setActiveGroup: HIDL daemon is null.");     // Catch: RemoteException -> L7
        this.mCallback.onClientFinished(this, false);     // Catch: RemoteException -> L7
        return;
    L9:
        sessionAdapter.setActiveGroup(targetId, this.mDirectory.getAbsolutePath());     // Catch: RemoteException -> L7
        Map<Integer, Long> r4 = this.mAuthenticatorIds;     // Catch: RemoteException -> L7
        Integer r5 = Integer.valueOf(targetId);     // Catch: RemoteException -> L7
        if (this.mHasEnrolledBiometrics == false) goto L12;
        long r6 = sessionAdapter.getAuthenticatorIdForUpdateClient();     // Catch: RemoteException -> L7
    L13:
        r4.put(r5, Long.valueOf(r6));     // Catch: RemoteException -> L7
        this.mUserStartedCallback.onUserStarted(targetId, null, 0);     // Catch: RemoteException -> L7
        this.mCallback.onClientFinished(this, true);     // Catch: RemoteException -> L7
        return;
    L12:
        r6 = 0;
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to setActiveGroup: " + e);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.StartUserClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 1;
    }
}
