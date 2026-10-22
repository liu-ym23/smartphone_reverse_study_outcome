package com.android.server.biometrics.sensors.face.aidl;

import android.R;
import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricFaceConstants;
import android.hardware.biometrics.BiometricSourceType;
import android.hardware.biometrics.common.ICancellationSignal;
import android.hardware.biometrics.common.OperationContext;
import android.hardware.biometrics.events.AuthenticationErrorInfo;
import android.hardware.biometrics.events.AuthenticationHelpInfo;
import android.hardware.biometrics.events.AuthenticationStartedInfo;
import android.hardware.biometrics.events.AuthenticationStoppedInfo;
import android.hardware.common.NativeHandle;
import android.hardware.face.Face;
import android.hardware.face.FaceEnrollFrame;
import android.hardware.face.FaceEnrollOptions;
import android.hardware.face.FaceManager;
import android.hardware.keymaster.HardwareAuthToken;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.Surface;
import com.android.server.biometrics.HardwareAuthTokenUtils;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.log.OperationContextExt;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.BiometricNotificationUtils;
import com.android.server.biometrics.sensors.BiometricUtils;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ClientMonitorCompositeCallback;
import com.android.server.biometrics.sensors.EnrollClient;
import com.android.server.biometrics.sensors.face.FaceService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FaceEnrollClient extends EnrollClient<AidlSession> {
    private static final String TAG = "FaceEnrollClient";
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private final BiometricUtils<Face> mBiometricUtils;
    private ICancellationSignal mCancellationSignal;
    private final boolean mDebugConsent;
    private final int[] mDisabledFeatures;
    private final int[] mEnrollIgnoreList;
    private final int[] mEnrollIgnoreListVendor;
    private final int mEnrollReason;
    private NativeHandle mHwPreviewHandle;
    private final int mMaxTemplatesPerUser;
    private android.os.NativeHandle mOsPreviewHandle;
    private final ClientMonitorCallback mPreviewHandleDeleterCallback;
    private final Surface mPreviewSurface;

    public static /* synthetic */ void $r8$lambda$jYqRfbso371GyjQM82pmz1gPIRQ(FaceEnrollClient r0, AidlSession r1, HardwareAuthToken r2, byte[] r3, OperationContext r4) {
        r0.lambda$doEnroll$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$u-619P39B2HfqUuSwvy2osPMC8Y, reason: not valid java name */
    public static /* synthetic */ void m2662$r8$lambda$u619P39B2HfqUuSwvy2osPMC8Y(AidlSession r0, OperationContext r1) {
        lambda$doEnroll$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseSurfaceHandlesIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2663$$Nest$mreleaseSurfaceHandlesIfNeeded(FaceEnrollClient r0) {
        r0.releaseSurfaceHandlesIfNeeded();
    }

    public FaceEnrollClient(Context context, Supplier<AidlSession> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, byte[] hardwareAuthToken, String opPackageName, long requestId, BiometricUtils<Face> utils, int[] disabledFeatures, int timeoutSec, Surface previewSurface, int sensorId, BiometricLogger logger, BiometricContext biometricContext, int maxTemplatesPerUser, boolean debugConsent, FaceEnrollOptions options, AuthenticationStateListeners authenticationStateListeners, BiometricUtils<Face> biometricUtils) {
        super(context, lazyDaemon, token, listener, userId, hardwareAuthToken, opPackageName, utils, timeoutSec, sensorId, false, logger, biometricContext, BiometricFaceConstants.reasonToMetric(options.getEnrollReason()));
        this.mPreviewHandleDeleterCallback = new AnonymousClass1(this);
        setRequestId(requestId);
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mEnrollReason = options.getEnrollReason();
        this.mEnrollIgnoreList = getContext().getResources().getIntArray(R.array.config_highRefreshRateBlacklist);
        this.mEnrollIgnoreListVendor = getContext().getResources().getIntArray(R.array.config_localNotStealTopFocusDisplayPorts);
        this.mMaxTemplatesPerUser = maxTemplatesPerUser;
        this.mDebugConsent = debugConsent;
        this.mDisabledFeatures = disabledFeatures;
        this.mPreviewSurface = previewSurface;
        this.mBiometricUtils = biometricUtils;
        Slog.w(TAG, "EnrollOptions " + FaceEnrollOptions.enrollReasonToString(options.getEnrollReason()));
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient, com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        BiometricNotificationUtils.cancelFaceEnrollNotification(getContext());
        BiometricNotificationUtils.cancelFaceReEnrollNotification(getContext());
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    protected ClientMonitorCallback wrapCallbackForStart(ClientMonitorCallback callback) {
        return new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{this.mPreviewHandleDeleterCallback, getLogger().getAmbientLightProbe(true), callback});
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient
    protected boolean hasReachedEnrollmentLimit() {
        if (this.mBiometricUtils.getBiometricsForUser(getContext(), getTargetUserId()).size() < this.mMaxTemplatesPerUser) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean shouldSendAcquiredMessage(int acquireInfo, int vendorCode) {
        if (acquireInfo != 22) goto L8;
        if (Utils.listContains(this.mEnrollIgnoreListVendor, vendorCode) == false) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (Utils.listContains(this.mEnrollIgnoreList, acquireInfo) == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    public void onAcquired(int acquireInfo, int vendorCode) {
        boolean shouldSend = shouldSendAcquiredMessage(acquireInfo, vendorCode);
        if (shouldSend == false) goto L5;
        int helpCode = getHelpCode(acquireInfo, vendorCode);
        String helpMessage = FaceManager.getEnrollHelpMessage(getContext(), acquireInfo, vendorCode);
        this.mAuthenticationStateListeners.onAuthenticationHelp(new AuthenticationHelpInfo.Builder(BiometricSourceType.FACE, getRequestReasonFromFaceEnrollReason(this.mEnrollReason), helpMessage, helpCode).build());
    L5:
        onAcquiredInternal(acquireInfo, vendorCode, shouldSend);
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient
    public void onEnrollResult(BiometricAuthenticator.Identifier identifier, int remaining) {
        super.onEnrollResult(identifier, remaining);
        if (remaining != 0) goto L6;
        notifyLastEnrollmentTime(4);
        return;
    }

    public void onEnrollmentFrame(FaceEnrollFrame frame) {
        int acquireInfo = frame.getData().getAcquiredInfo();
        int vendorCode = frame.getData().getVendorCode();
        onAcquiredInternal(acquireInfo, vendorCode, false);
        boolean shouldSend = shouldSendAcquiredMessage(acquireInfo, vendorCode);
        if (shouldSend == false) goto L11;
        int helpCode = getHelpCode(acquireInfo, vendorCode);     // Catch: RemoteException -> L6
        String helpMessage = FaceManager.getEnrollHelpMessage(getContext(), acquireInfo, vendorCode);     // Catch: RemoteException -> L6
        this.mAuthenticationStateListeners.onAuthenticationHelp(new AuthenticationHelpInfo.Builder(BiometricSourceType.FACE, getRequestReasonFromFaceEnrollReason(this.mEnrollReason), helpMessage, helpCode).build());     // Catch: RemoteException -> L6
        getListener().onEnrollmentFrame(frame);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Failed to send enrollment frame", e);
        this.mCallback.onClientFinished(this, false);
        return;
    }

    @Override // com.android.server.biometrics.sensors.HalClientMonitor
    protected void startHalOperation() {
        this.mAuthenticationStateListeners.onAuthenticationStarted(new AuthenticationStartedInfo.Builder(BiometricSourceType.FACE, getRequestReasonFromFaceEnrollReason(this.mEnrollReason)).build());
        obtainSurfaceHandlesIfNeeded();
        List<Byte> featureList = new ArrayList();     // Catch: Throwable -> L6
        if (this.mDebugConsent == false) goto L8;
        featureList.add((byte) 2);     // Catch: Throwable -> L6
    L8:
        boolean shouldAddDiversePoses = true;
        int[] r4 = this.mDisabledFeatures;     // Catch: Throwable -> L6
        int r5 = r4.length;     // Catch: Throwable -> L6
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        int disabledFeature = r4[r6];     // Catch: Throwable -> L6
        if (AidlConversionUtils.convertFrameworkToAidlFeature(disabledFeature) != 1) goto L14;
        shouldAddDiversePoses = false;
    L14:
        r6 = r6 + 1;     // Catch: Throwable -> L6
        goto L10
    L15:
        if (shouldAddDiversePoses == false) goto L17;
        featureList.add((byte) 1);     // Catch: Throwable -> L6
    L17:
        byte[] features = new byte[featureList.size()];     // Catch: Throwable -> L6
        int i = 0;
    L19:
        if (i >= featureList.size()) goto L21;
        features[i] = featureList.get(i).byteValue();     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L19
    L21:
        doEnroll(features);     // Catch: Throwable -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Exception when requesting enroll", e);
        onError(2, 0);
        this.mCallback.onClientFinished(this, false);
    }

    @Override // com.android.server.biometrics.sensors.EnrollClient, com.android.server.biometrics.sensors.AcquisitionClient, com.android.server.biometrics.sensors.ErrorConsumer
    public void onError(int error, int vendorCode) {
        this.mAuthenticationStateListeners.onAuthenticationError(new AuthenticationErrorInfo.Builder(BiometricSourceType.FACE, getRequestReasonFromFaceEnrollReason(this.mEnrollReason), FaceManager.getErrorString(getContext(), error, vendorCode), error).build());
        super.onError(error, vendorCode);
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, getRequestReasonFromFaceEnrollReason(this.mEnrollReason)).build());
    }

    private void doEnroll(final byte[] features) throws RemoteException {
        final AidlSession session = getFreshDaemon();
        final HardwareAuthToken hat = HardwareAuthTokenUtils.toHardwareAuthToken(this.mHardwareAuthToken);
        if (session.hasContextMethods() == false) goto L5;
        OperationContextExt opContext = getOperationContext();
        getBiometricContext().subscribe(opContext, new FaceEnrollClient$$ExternalSyntheticLambda0(this, session, hat, features), new FaceEnrollClient$$ExternalSyntheticLambda1(session), null);
        return;
    L5:
        this.mCancellationSignal = session.getSession().enroll(hat, (byte) 0, features, this.mHwPreviewHandle);
    }

    private /* synthetic */ void lambda$doEnroll$0(AidlSession session, HardwareAuthToken hat, byte[] features, OperationContext ctx) {
    L15:
        e = e;
    L17:
        Slog.e(TAG, "Exception when requesting enroll", e);
        onError(2, 0);
        this.mCallback.onClientFinished(this, false);
        return;
    L4:
        if (session.supportsFaceEnrollOptions() == true) goto L23;
        this.mCancellationSignal = session.getSession().enrollWithContext(hat, (byte) 0, features, this.mHwPreviewHandle, ctx);     // Catch: RemoteException -> L13
        return;
    L13:
        e = e;
        goto L17
    L23:
        android.hardware.biometrics.face.FaceEnrollOptions options = new android.hardware.biometrics.face.FaceEnrollOptions();     // Catch: RemoteException -> L7
        options.hardwareAuthToken = hat;     // Catch: RemoteException -> L7
        options.enrollmentType = 0;     // Catch: RemoteException -> L7
        options.features = features;     // Catch: RemoteException -> L7
        options.nativeHandlePreview = null;     // Catch: RemoteException -> L7
        options.context = ctx;     // Catch: RemoteException -> L7
        options.surfacePreview = this.mPreviewSurface;     // Catch: RemoteException -> L7
        this.mCancellationSignal = session.getSession().enrollWithOptions(options);     // Catch: RemoteException -> L7
        return;
    L7:
        e = e;
        goto L17
    }

    private static /* synthetic */ void lambda$doEnroll$1(AidlSession session, OperationContext ctx) {
        session.getSession().onContextChanged(ctx);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to notify context changed", e);
    }

    @Override // com.android.server.biometrics.sensors.AcquisitionClient
    protected void stopHalOperation() {
        this.mAuthenticationStateListeners.onAuthenticationStopped(new AuthenticationStoppedInfo.Builder(BiometricSourceType.FACE, getRequestReasonFromFaceEnrollReason(this.mEnrollReason)).build());
        unsubscribeBiometricContext();
        if (this.mCancellationSignal == null) goto L11;
        this.mCancellationSignal.cancel();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Remote exception when requesting cancel", e);
        onError(1, 0);
        this.mCallback.onClientFinished(this, false);
        return;
    }

    private void obtainSurfaceHandlesIfNeeded() {
        if (this.mPreviewSurface == null) goto L12;
        this.mOsPreviewHandle = FaceService.acquireSurfaceHandle(this.mPreviewSurface);
        this.mHwPreviewHandle = AidlNativeHandleUtils.dup(this.mOsPreviewHandle);     // Catch: IOException -> L7
        Slog.v(TAG, "Obtained handles for the preview surface.");     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.mHwPreviewHandle = null;
        Slog.e(TAG, "Failed to dup mOsPreviewHandle", e);
        return;
    }

    private void releaseSurfaceHandlesIfNeeded() {
        if (this.mPreviewSurface == null) goto L8;
        if (this.mHwPreviewHandle != null) goto L8;
        Slog.w(TAG, "mHwPreviewHandle is null even though mPreviewSurface is not null.");
    L8:
        if (this.mHwPreviewHandle == null) goto L15;
        Slog.v(TAG, "Closing mHwPreviewHandle");     // Catch: IOException -> L11
        AidlNativeHandleUtils.close(this.mHwPreviewHandle);     // Catch: IOException -> L11
    L13:
        this.mHwPreviewHandle = null;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to close mPreviewSurface", e);
    L15:
        if (this.mOsPreviewHandle == null) goto L18;
        Slog.v(TAG, "Releasing mOsPreviewHandle");
        FaceService.releaseSurfaceHandle(this.mOsPreviewHandle);
        this.mOsPreviewHandle = null;
    L18:
        if (this.mPreviewSurface == null) goto L23;
        Slog.v(TAG, "Releasing mPreviewSurface");
        this.mPreviewSurface.release();
        return;
    }

    private static int getHelpCode(int acquireInfo, int vendorCode) {
        if (acquireInfo != 22) goto L6;
        return vendorCode + 1000;
    L6:
        return acquireInfo;
    }
}
