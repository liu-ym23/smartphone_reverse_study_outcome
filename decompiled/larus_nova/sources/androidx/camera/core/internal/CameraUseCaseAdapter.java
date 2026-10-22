package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private final RestrictedCameraControl mAdapterCameraControl;
    private final RestrictedCameraInfo mAdapterCameraInfo;
    private final RestrictedCameraInfo mAdapterSecondaryCameraInfo;
    private final List<UseCase> mAppUseCases;
    private boolean mAttached;
    private final CameraConfig mCameraConfig;
    private final CameraCoordinator mCameraCoordinator;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    private final CameraInternal mCameraInternal;
    private final List<UseCase> mCameraUseCases;
    private List<CameraEffect> mEffects;
    private final CameraId mId;
    private Config mInteropConfig;
    private final LayoutSettings mLayoutSettings;
    private final Object mLock;
    private UseCase mPlaceholderForExtensions;
    private final CameraInternal mSecondaryCameraInternal;
    private final LayoutSettings mSecondaryLayoutSettings;
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private ViewPort mViewPort;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(String r100) {
            super(r100);
        }

        public CameraException(Throwable r100) {
            super(r100);
        }
    }

    public static abstract class CameraId {
        public CameraId() {
        }

        public abstract Identifier getCameraConfigId();

        public abstract String getCameraIdString();

        public static CameraId create(String r100, Identifier r101) {
            return new AutoValue_CameraUseCaseAdapter_CameraId(r100, r101);
        }
    }

    public static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> r100, UseCaseConfig<?> r101) {
            this.mExtendedConfig = r100;
            this.mCameraConfig = r101;
        }
    }

    public static /* synthetic */ void a(SurfaceRequest r100) {
        lambda$createExtraPreview$1(r100);
    }

    public static /* synthetic */ void b(Surface r100, SurfaceTexture r101, SurfaceRequest.Result r102) {
        lambda$createExtraPreview$0(r100, r101, r102);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... r100) {
        return Camera.CC.$default$isUseCasesCombinationSupported(this, r100);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... r100) {
        return Camera.CC.$default$isUseCasesCombinationSupportedByFramework(this, r100);
    }

    private void cacheInteropConfig() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        CameraControlInternal r101 = this.mCameraInternal.getCameraControlInternal();     // Catch: Throwable -> L7
        this.mInteropConfig = r101.getInteropConfig();     // Catch: Throwable -> L7
        r101.clearInteropConfig();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview r100 = new Preview.Builder().setTargetName("Preview-Extra").build();
        r100.setSurfaceProvider(new b());
        return r100;
    }

    private int getCameraMode() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraCoordinator.getCameraOperatingMode() != 2) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return 1;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return 0;
    }

    private boolean hasExtension() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraConfig.getSessionProcessor(null) == null) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = true;
        if (this.mCameraConfig.getUseCaseCombinationRequiredRule() == 1) goto L8;
        r101 = false;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    private void restoreInteropConfig() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mInteropConfig == null) goto L7;
        this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public void attachUseCases() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mAttached == false) goto L7;
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    L7:
        if (this.mCameraUseCases.isEmpty() == true) goto L11;
        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
        CameraInternal r101 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L21
        if (r101 == null) goto L11;
        r101.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
    L11:
        this.mCameraInternal.attachUseCases(this.mCameraUseCases);     // Catch: Throwable -> L21
        CameraInternal r102 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L21
        if (r102 == null) goto L14;
        r102.attachUseCases(this.mCameraUseCases);     // Catch: Throwable -> L21
    L14:
        restoreInteropConfig();     // Catch: Throwable -> L21
        Iterator<UseCase> r103 = this.mCameraUseCases.iterator();     // Catch: Throwable -> L21
    L16:
        if (r103.hasNext() == false) goto L18;
        r103.next().notifyState();     // Catch: Throwable -> L21
        goto L16
    L18:
        this.mAttached = true;     // Catch: Throwable -> L21
        goto L19
    }

    public void detachUseCases() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mAttached == false) goto L10;
        this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));     // Catch: Throwable -> L12
        CameraInternal r101 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        r101.detachUseCases(new ArrayList(this.mCameraUseCases));     // Catch: Throwable -> L12
    L9:
        cacheInteropConfig();     // Catch: Throwable -> L12
        this.mAttached = false;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    public Collection<UseCase> getCameraUseCases() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mCameraUseCases);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        CameraConfig r101 = this.mCameraConfig;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<UseCase> getUseCases() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mAppUseCases);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.Camera
    public CameraControl getCameraControl() {
        return this.mAdapterCameraControl;
    }

    public CameraId getCameraId() {
        return this.mId;
    }

    @Override // androidx.camera.core.Camera
    public CameraInfo getCameraInfo() {
        return this.mAdapterCameraInfo;
    }

    public CameraInfo getSecondaryCameraInfo() {
        return this.mAdapterSecondaryCameraInfo;
    }

    private void checkUnsupportedFeatureCombinationAndThrow(Collection<UseCase> r100) throws IllegalArgumentException {
        if (hasExtension() == true) goto L5;
    L13:
        Object r101 = this.mLock;
        monitor-enter(r101);
    L24:
        th = move-exception;
        throw th;
    L16:
        if (this.mEffects.isEmpty() == false) goto L18;
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L24
        return;
    L18:
        if (hasUltraHdrImageCapture(r100) == false) goto L22;
        throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");     // Catch: Throwable -> L24
    L5:
        if (hasNonSdrConfig(r100) == true) goto L12;
        if (hasUltraHdrImageCapture(r100) == false) goto L13;
        throw new IllegalArgumentException("Extensions are not supported for use with Ultra HDR image capture.");
    L12:
        throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
    }

    private int getSharingTargets(boolean r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Iterator<CameraEffect> r102 = this.mEffects.iterator();     // Catch: Throwable -> L19
        CameraEffect r103 = null;
    L5:
        int r104 = 0;
        boolean r105 = false;
        if (r102.hasNext() == false) goto L12;
        CameraEffect r106 = r102.next();     // Catch: Throwable -> L19
        if (TargetUtils.getNumberOfTargets(r106.getTargets()) <= 1) goto L5;
        if (r103 != null) goto L11;
        r105 = true;
    L11:
        Preconditions.checkState(r105, "Can only have one sharing effect.");     // Catch: Throwable -> L19
        r103 = r106;
        goto L5
    L12:
        if (r103 == null) goto L15;
        r104 = r103.getTargets();     // Catch: Throwable -> L19
    L15:
        if (r100 == false) goto L17;
        r104 = r104 | 3;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r104;
    L19:
        th = move-exception;
        throw th;
    }

    private static boolean hasNonSdrConfig(Collection<UseCase> r100) {
        Iterator<UseCase> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (isNotSdr(r101.next().getCurrentConfig().getDynamicRange()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static boolean hasUltraHdrImageCapture(Collection<UseCase> r100) {
        Iterator<UseCase> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        UseCase r102 = r101.next();
        if (isImageCapture(r102) == false) goto L4;
        UseCaseConfig<?> r103 = r102.getCurrentConfig();
        Config.Option<?> r104 = ImageCaptureConfig.OPTION_OUTPUT_FORMAT;
        if (r103.containsOption(r104) == false) goto L4;
        if (((Integer) Preconditions.checkNotNull((Integer) r103.retrieveOption(r104))).intValue() != 1) goto L4;
        return true;
    L13:
        return false;
    }

    private static boolean hasVideoCapture(Collection<UseCase> r100) {
        Iterator<UseCase> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (isVideoCapture(r101.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static boolean isExtraImageCaptureRequired(Collection<UseCase> r100) {
        Iterator<UseCase> r101 = r100.iterator();
        boolean r102 = false;
        boolean r103 = false;
    L4:
        if (r101.hasNext() == false) goto L14;
        UseCase r104 = r101.next();
        if (isPreview(r104) == true) goto L13;
        if (StreamSharing.isStreamSharing(r104) == true) goto L13;
        if (isImageCapture(r104) == false) goto L4;
        r103 = true;
    L13:
        r102 = true;
        goto L4
    L14:
        if (r102 == false) goto L27;
        if (r103 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    }

    private static boolean isExtraPreviewRequired(Collection<UseCase> r100) {
        Iterator<UseCase> r101 = r100.iterator();
        boolean r102 = false;
        boolean r103 = false;
    L4:
        if (r101.hasNext() == false) goto L14;
        UseCase r104 = r101.next();
        if (isPreview(r104) == true) goto L13;
        if (StreamSharing.isStreamSharing(r104) == true) goto L13;
        if (isImageCapture(r104) == false) goto L4;
        r102 = true;
    L13:
        r103 = true;
        goto L4
    L14:
        if (r102 == false) goto L27;
        if (r103 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    }

    private static boolean isImageCapture(UseCase r100) {
        return r100 instanceof ImageCapture;
    }

    private static boolean isNotSdr(DynamicRange r100) {
        if (r100.getBitDepth() != 10) goto L5;
        boolean r101 = true;
    L7:
        if (r100.getEncoding() != 1) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r101 == true) goto L14;
        if (r102 == true) goto L14;
        return false;
    L14:
        return true;
    L9:
        if (r100.getEncoding() == 0) goto L11;
        r102 = true;
        goto L12
    L5:
        r101 = false;
        goto L7
    }

    private static boolean isPreview(UseCase r100) {
        return r100 instanceof Preview;
    }

    public static boolean isStreamSharingChildrenCombinationValid(Collection<UseCase> r100) {
        int[] r101 = {1, 2, 4};
        HashSet r102 = new HashSet();
        Iterator<UseCase> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        UseCase r104 = r103.next();
        int r105 = 0;
    L6:
        if (r105 >= 3) goto L4;
        int r106 = r101[r105];
        if (r104.isEffectTargetsSupported(r106) == true) goto L10;
    L13:
        r105 = r105 + 1;
        goto L6
    L10:
        if (r102.contains(Integer.valueOf(r106)) == true) goto L11;
        r102.add(Integer.valueOf(r106));
        goto L13
    L11:
        return false;
    L14:
        return true;
    }

    private static boolean isVideoCapture(UseCase r100) {
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) == true) goto L7;
        r100.toString();
        goto L11
    L7:
        if (r100.getCurrentConfig().getCaptureType() != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) goto L12;
        return true;
    L12:
        return false;
    }

    private static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest r100) {
        final SurfaceTexture r101 = new SurfaceTexture(0);
        r101.setDefaultBufferSize(r100.getResolution().getWidth(), r100.getResolution().getHeight());
        r101.detachFromGLContext();
        final Surface r102 = new Surface(r101);
        r100.provideSurface(r102, CameraXExecutors.directExecutor(), new a(r102, r101));
    }

    public void addUseCases(Collection<UseCase> r100) throws CameraException {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCameraInternal.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
        CameraInternal r102 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L21
        if (r102 == null) goto L7;
        r102.setExtendedConfig(this.mCameraConfig);     // Catch: Throwable -> L21
    L7:
        LinkedHashSet r103 = new LinkedHashSet(this.mAppUseCases);     // Catch: Throwable -> L21
        r103.addAll(r100);     // Catch: Throwable -> L21
        CameraInternal r104 = this.mSecondaryCameraInternal;     // Catch: IllegalArgumentException -> L18 Throwable -> L21
        boolean r105 = true;
        if (r104 == null) goto L11;
        boolean r106 = true;
    L12:
        if (r104 != null) goto L15;
        r105 = false;
    L15:
        updateUseCases(r103, r106, r105);     // Catch: IllegalArgumentException -> L18 Throwable -> L21
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L11:
        r106 = false;
    L18:
        e = move-exception;
        throw new CameraException(e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public boolean isEquivalent(CameraUseCaseAdapter r100) {
        return getCameraId().equals(r100.getCameraId());
    }

    public void removeUseCases(Collection<UseCase> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        LinkedHashSet r102 = new LinkedHashSet(this.mAppUseCases);     // Catch: Throwable -> L14
        r102.removeAll(r100);     // Catch: Throwable -> L14
        CameraInternal r103 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L14
        boolean r104 = true;
        if (r103 == null) goto L7;
        boolean r105 = true;
    L8:
        if (r103 != null) goto L11;
        r104 = false;
    L11:
        updateUseCases(r102, r105, r104);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L7:
        r105 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public void setActiveResumingMode(boolean r100) {
        this.mCameraInternal.setActiveResumingMode(r100);
    }

    public void setEffects(List<CameraEffect> r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mEffects = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setViewPort(ViewPort r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mViewPort = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateUseCases(Collection<UseCase> r100) {
        updateUseCases(r100, false, false);
    }

    private UseCase calculatePlaceholderForExtensions(Collection<UseCase> r100, StreamSharing r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        ArrayList r103 = new ArrayList(r100);     // Catch: Throwable -> L24
        if (r101 == null) goto L8;
        r103.add(r101);     // Catch: Throwable -> L24
        r103.removeAll(r101.getChildren());     // Catch: Throwable -> L24
    L8:
        if (isCoexistingPreviewImageCaptureRequired() == true) goto L10;
    L21:
        UseCase r104 = null;
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L24
        return r104;
    L10:
        if (isExtraPreviewRequired(r103) == false) goto L16;
        if (isPreview(this.mPlaceholderForExtensions) == false) goto L14;
        r104 = this.mPlaceholderForExtensions;     // Catch: Throwable -> L24
        goto L22
    L14:
        r104 = createExtraPreview();     // Catch: Throwable -> L24
        goto L22
    L16:
        if (isExtraImageCaptureRequired(r103) == false) goto L21;
        if (isImageCapture(this.mPlaceholderForExtensions) == false) goto L20;
        r104 = this.mPlaceholderForExtensions;     // Catch: Throwable -> L24
        goto L22
    L20:
        r104 = createExtraImageCapture();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static Matrix calculateSensorToBufferTransformMatrix(Rect r100, Size r101) {
        if (r100.width() > 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Preconditions.checkArgument(r102, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF r103 = new RectF(r100);
        Matrix r104 = new Matrix();
        r104.setRectToRect(new RectF(0.0f, 0.0f, r101.getWidth(), r101.getHeight()), r103, Matrix.ScaleToFit.CENTER);
        r104.invert(r104);
        return r104;
    L5:
        if (r100.height() <= 0) goto L7;
        r102 = true;
        goto L8
    }

    private StreamSharing createOrReuseStreamSharing(Collection<UseCase> r100, boolean r110) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Set<UseCase> r102 = getStreamSharingChildren(r100, r110);     // Catch: Throwable -> L26
        if (r102.size() < 2) goto L7;
    L12:
        StreamSharing r103 = this.mStreamSharing;     // Catch: Throwable -> L26
        if (r103 == null) goto L20;
        if (r103.getChildren().equals(r102) == false) goto L20;
        StreamSharing r104 = this.mStreamSharing;     // Catch: Throwable -> L26
        Objects.requireNonNull(r104);     // Catch: Throwable -> L26
        StreamSharing r111 = r104;     // Catch: Throwable -> L26
        monitor-exit(r101);     // Catch: Throwable -> L26
        return r104;
    L20:
        if (isStreamSharingChildrenCombinationValid(r102) == true) goto L23;
        monitor-exit(r101);     // Catch: Throwable -> L26
        return null;
    L23:
        StreamSharing r105 = new StreamSharing(this.mCameraInternal, this.mSecondaryCameraInternal, this.mLayoutSettings, this.mSecondaryLayoutSettings, r102, this.mUseCaseConfigFactory);     // Catch: Throwable -> L26
        monitor-exit(r101);     // Catch: Throwable -> L26
        return r105;
    L7:
        if (hasExtension() == true) goto L9;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L26
        return null;
    L9:
        if (hasVideoCapture(r102) == true) goto L12;
    L26:
        th = move-exception;
        throw th;
    }

    public static CameraId generateCameraId(RestrictedCameraInfo r100, RestrictedCameraInfo r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.getCameraId());
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.append(r103);
        return CameraId.create(r102.toString(), r100.getCameraConfig().getCompatibilityId());
    L5:
        r103 = r101.getCameraId();
        goto L6
    }

    private static UseCaseConfig<?> generateExtendedStreamSharingConfigFromPreview(UseCaseConfigFactory r100, StreamSharing r101) {
        UseCaseConfig<?> r102 = new Preview.Builder().build().getDefaultConfig(false, r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        MutableOptionsBundle r103 = MutableOptionsBundle.from(r102);
        r103.removeOption(TargetConfig.OPTION_TARGET_CLASS);
        return r101.getUseCaseConfigBuilder(r103).getUseCaseConfig();
    }

    private Set<UseCase> getStreamSharingChildren(Collection<UseCase> r100, boolean r101) {
        HashSet r102 = new HashSet();
        int r103 = getSharingTargets(r101);
        Iterator<UseCase> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        UseCase r105 = r104.next();
        Preconditions.checkArgument(!StreamSharing.isStreamSharing(r105), "Only support one level of sharing for now.");
        if (r105.isEffectTargetsSupported(r103) == false) goto L4;
        r102.add(r105);
        goto L4
    L8:
        return r102;
    }

    private static boolean hasImplementationOptionChanged(StreamSpec r100, SessionConfig r101) {
        Config r102 = r100.getImplementationOptions();
        Config r103 = r101.getImplementationOptions();
        if (r102.listOptions().size() == r101.getImplementationOptions().listOptions().size()) goto L5;
        return true;
    L5:
        Iterator<Config.Option<?>> r104 = r102.listOptions().iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        Config.Option<?> r105 = r104.next();
        if (r103.containsOption(r105) == false) goto L12;
        if (Objects.equals(r103.retrieveOption(r105), r102.retrieveOption(r105)) == true) goto L7;
    L12:
        return true;
    L13:
        return false;
    }

    private static List<CameraEffect> setEffectsOnUseCases(List<CameraEffect> r100, Collection<UseCase> r101) {
        ArrayList r102 = new ArrayList(r100);
        Iterator<UseCase> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        UseCase r104 = r103.next();
        r104.setEffect(null);
        Iterator<CameraEffect> r105 = r100.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        CameraEffect r106 = r105.next();
        if (r104.isEffectTargetsSupported(r106.getTargets()) == false) goto L7;
        if (r104.getEffect() != null) goto L13;
        boolean r107 = true;
    L14:
        Preconditions.checkState(r107, r104 + " already has effect" + r104.getEffect());
        r104.setEffect(r106);
        r102.remove(r106);
        goto L7
    L13:
        r107 = false;
        goto L14
    L15:
        return r102;
    }

    private void updateViewPortAndSensorToBufferMatrix(Map<UseCase, StreamSpec> r110, Collection<UseCase> r111) {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mViewPort != null) goto L7;
    L20:
        Iterator<UseCase> r112 = r111.iterator();     // Catch: Throwable -> L26
    L22:
        if (r112.hasNext() == false) goto L24;
        UseCase r101 = r112.next();     // Catch: Throwable -> L26
        r101.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(r110.get(r101))).getResolution()));     // Catch: Throwable -> L26
        goto L22
    L24:
        monitor-exit(r100);     // Catch: Throwable -> L26
        return;
    L7:
        if (r111.isEmpty() == true) goto L20;
        Integer r102 = Integer.valueOf(this.mCameraInternal.getCameraInfoInternal().getLensFacing());     // Catch: Throwable -> L26
        boolean r103 = true;
        if (r102 != null) goto L12;
        Logger.w(TAG, "The lens facing is null, probably an external.");     // Catch: Throwable -> L26
        boolean r104 = true;
    L16:
        Map<UseCase, Rect> r105 = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), r104, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), r110);     // Catch: Throwable -> L26
        Iterator<UseCase> r106 = r111.iterator();     // Catch: Throwable -> L26
    L18:
        if (r106.hasNext() == false) goto L20;
        UseCase r107 = r106.next();     // Catch: Throwable -> L26
        r107.setViewPortCropRect((Rect) Preconditions.checkNotNull(r105.get(r107)));     // Catch: Throwable -> L26
        goto L18
    L12:
        if (r102.intValue() == 0) goto L15;
        r103 = false;
    L15:
        r104 = r103;
        goto L16
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(boolean r100, UseCase... r101) {
        Collection<UseCase> r102 = Arrays.asList(r101);
        if (r100 == false) goto L5;
        r102 = calculateCameraUseCases(r102, null, createOrReuseStreamSharing(r102, true));
    L5:
        Collection<UseCase> r103 = r102;
        Object r104 = this.mLock;
        monitor-enter(r104);
        Map<UseCase, ConfigPair> r105 = getConfigs(r103, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), r103, Collections.emptyList(), r105);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        monitor-exit(r104);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L13:
        return false;
    }

    public static Collection<UseCase> calculateCameraUseCases(Collection<UseCase> r100, UseCase r101, StreamSharing r102) {
        ArrayList r103 = new ArrayList(r100);
        if (r101 == null) goto L5;
        r103.add(r101);
    L5:
        if (r102 == null) goto L7;
        r103.add(r102);
        r103.removeAll(r102.getChildren());
    L7:
        return r103;
    }

    private static Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> r100, UseCaseConfigFactory r101, UseCaseConfigFactory r102) {
        HashMap r103 = new HashMap();
        Iterator<UseCase> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        UseCase r105 = r104.next();
        if (StreamSharing.isStreamSharing(r105) == false) goto L8;
        UseCaseConfig<?> r106 = generateExtendedStreamSharingConfigFromPreview(r101, (StreamSharing) r105);
    L9:
        r103.put(r105, new ConfigPair(r106, r105.getDefaultConfig(true, r102)));
        goto L4
    L8:
        r106 = r105.getDefaultConfig(false, r101);
        goto L9
    L10:
        return r103;
    }

    private static /* synthetic */ void lambda$createExtraPreview$0(Surface r100, SurfaceTexture r101, SurfaceRequest.Result r102) {
        r100.release();
        r101.release();
    }

    public static void updateEffects(List<CameraEffect> r100, Collection<UseCase> r101, Collection<UseCase> r102) {
        List<CameraEffect> r103 = setEffectsOnUseCases(r100, r101);
        ArrayList r104 = new ArrayList(r102);
        r104.removeAll(r101);
        List<CameraEffect> r105 = setEffectsOnUseCases(r103, r104);
        if (r105.size() <= 0) goto L6;
        Logger.w(TAG, "Unused effects: " + r105);
        return;
    }

    public void updateUseCases(Collection<UseCase> r210, boolean r211, boolean r212) {
        Object r110 = this.mLock;
        monitor-enter(r110);
        checkUnsupportedFeatureCombinationAndThrow(r210);     // Catch: Throwable -> L77
        if (r211 == false) goto L7;
    L13:
        StreamSharing r100 = createOrReuseStreamSharing(r210, r211);     // Catch: Throwable -> L77
        UseCase r111 = calculatePlaceholderForExtensions(r210, r100);     // Catch: Throwable -> L77
        Collection<UseCase> r112 = calculateCameraUseCases(r210, r111, r100);     // Catch: Throwable -> L77
        ArrayList r113 = new ArrayList(r112);     // Catch: Throwable -> L77
        r113.removeAll(this.mCameraUseCases);     // Catch: Throwable -> L77
        ArrayList r114 = new ArrayList(r112);     // Catch: Throwable -> L77
        r114.retainAll(this.mCameraUseCases);     // Catch: Throwable -> L77
        ArrayList r101 = new ArrayList(this.mCameraUseCases);     // Catch: Throwable -> L77
        r101.removeAll(r112);     // Catch: Throwable -> L77
        Map<UseCase, ConfigPair> r102 = getConfigs(r113, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);     // Catch: Throwable -> L77
        Map<UseCase, StreamSpec> r115 = Collections.emptyMap();     // Catch: Throwable -> L77
        Map<UseCase, ConfigPair> r116 = r102;
        Map<UseCase, StreamSpec> r103 = calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), r113, r114, r116);     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        if (this.mSecondaryCameraInternal == null) goto L19;
        int r104 = getCameraMode();     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        CameraInternal r105 = this.mSecondaryCameraInternal;     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        Objects.requireNonNull(r105);     // Catch: IllegalArgumentException -> L67 Throwable -> L77
        r115 = calculateSuggestedStreamSpecs(r104, r105.getCameraInfoInternal(), r113, r114, r116);     // Catch: IllegalArgumentException -> L67 Throwable -> L77
    L19:
        Map<UseCase, StreamSpec> r106 = r115;
        updateViewPortAndSensorToBufferMatrix(r103, r112);     // Catch: Throwable -> L77
        updateEffects(this.mEffects, r112, r210);     // Catch: Throwable -> L77
        Iterator r107 = r101.iterator();     // Catch: Throwable -> L77
    L22:
        if (r107.hasNext() == false) goto L24;
        ((UseCase) r107.next()).unbindFromCamera(this.mCameraInternal);     // Catch: Throwable -> L77
        goto L22
    L24:
        this.mCameraInternal.detachUseCases(r101);     // Catch: Throwable -> L77
        if (this.mSecondaryCameraInternal == null) goto L32;
        Iterator r108 = r101.iterator();     // Catch: Throwable -> L77
    L28:
        if (r108.hasNext() == false) goto L30;
        UseCase r109 = (UseCase) r108.next();     // Catch: Throwable -> L77
        CameraInternal r117 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        Objects.requireNonNull(r117);     // Catch: Throwable -> L77
        r109.unbindFromCamera(r117);     // Catch: Throwable -> L77
        goto L28
    L30:
        CameraInternal r118 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        Objects.requireNonNull(r118);     // Catch: Throwable -> L77
        r118.detachUseCases(r101);     // Catch: Throwable -> L77
    L32:
        if (r101.isEmpty() == false) goto L47;
        Iterator r119 = r114.iterator();     // Catch: Throwable -> L77
    L35:
        if (r119.hasNext() == false) goto L47;
        UseCase r120 = (UseCase) r119.next();     // Catch: Throwable -> L77
        if (r103.containsKey(r120) == false) goto L35;
        StreamSpec r121 = r103.get(r120);     // Catch: Throwable -> L77
        Config r122 = r121.getImplementationOptions();     // Catch: Throwable -> L77
        if (r122 == null) goto L35;
        if (hasImplementationOptionChanged(r121, r120.getSessionConfig()) == false) goto L35;
        r120.updateSuggestedStreamSpecImplementationOptions(r122);     // Catch: Throwable -> L77
        if (this.mAttached == false) goto L35;
        this.mCameraInternal.onUseCaseUpdated(r120);     // Catch: Throwable -> L77
        CameraInternal r123 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        if (r123 == null) goto L35;
        Objects.requireNonNull(r123);     // Catch: Throwable -> L77
        r123.onUseCaseUpdated(r120);     // Catch: Throwable -> L77
    L47:
        Iterator r124 = r113.iterator();     // Catch: Throwable -> L77
    L49:
        if (r124.hasNext() == false) goto L56;
        UseCase r125 = (UseCase) r124.next();     // Catch: Throwable -> L77
        Map<UseCase, ConfigPair> r126 = r116;
        ConfigPair r127 = r126.get(r125);     // Catch: Throwable -> L77
        Objects.requireNonNull(r127);     // Catch: Throwable -> L77
        ConfigPair r128 = r127;     // Catch: Throwable -> L77
        CameraInternal r129 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        if (r129 == null) goto L53;
        CameraInternal r130 = this.mCameraInternal;     // Catch: Throwable -> L77
        Objects.requireNonNull(r129);     // Catch: Throwable -> L77
        r125.bindToCamera(r130, r129, r127.mExtendedConfig, r127.mCameraConfig);     // Catch: Throwable -> L77
        r125.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(r103.get(r125)), r106.get(r125));     // Catch: Throwable -> L77
    L54:
        r116 = r126;
        goto L49
    L53:
        r125.bindToCamera(this.mCameraInternal, null, r127.mExtendedConfig, r127.mCameraConfig);     // Catch: Throwable -> L77
        r125.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(r103.get(r125)), null);     // Catch: Throwable -> L77
        goto L54
    L56:
        if (this.mAttached == false) goto L60;
        this.mCameraInternal.attachUseCases(r113);     // Catch: Throwable -> L77
        CameraInternal r131 = this.mSecondaryCameraInternal;     // Catch: Throwable -> L77
        if (r131 == null) goto L60;
        Objects.requireNonNull(r131);     // Catch: Throwable -> L77
        r131.attachUseCases(r113);     // Catch: Throwable -> L77
    L60:
        Iterator r132 = r113.iterator();     // Catch: Throwable -> L77
    L62:
        if (r132.hasNext() == false) goto L64;
        ((UseCase) r132.next()).notifyState();     // Catch: Throwable -> L77
        goto L62
    L64:
        this.mAppUseCases.clear();     // Catch: Throwable -> L77
        this.mAppUseCases.addAll(r210);     // Catch: Throwable -> L77
        this.mCameraUseCases.clear();     // Catch: Throwable -> L77
        this.mCameraUseCases.addAll(r112);     // Catch: Throwable -> L77
        this.mPlaceholderForExtensions = r111;     // Catch: Throwable -> L77
        this.mStreamSharing = r100;     // Catch: Throwable -> L77
        monitor-exit(r110);     // Catch: Throwable -> L77
        return;
    L67:
        e = move-exception;
        if (r211 == false) goto L70;
    L76:
        throw e;     // Catch: Throwable -> L77
    L70:
        if (hasExtension() == true) goto L76;
        if (this.mCameraCoordinator.getCameraOperatingMode() == 2) goto L76;
        updateUseCases(r210, true, r212);     // Catch: Throwable -> L77
        return;
    L7:
        if (hasExtension() == false) goto L13;
        if (hasVideoCapture(r210) == false) goto L13;
        updateUseCases(r210, true, r212);     // Catch: Throwable -> L77
        monitor-exit(r110);     // Catch: Throwable -> L77
        return;
    L77:
        th = move-exception;
        throw th;
    }

    public CameraUseCaseAdapter(CameraInternal r110, CameraCoordinator r111, CameraDeviceSurfaceManager r112, UseCaseConfigFactory r113) {
        RestrictedCameraInfo r100 = new RestrictedCameraInfo(r110.getCameraInfoInternal(), CameraConfigs.defaultConfig());
        LayoutSettings r101 = LayoutSettings.DEFAULT;
        this(r110, null, r100, null, r101, r101, r111, r112, r113);
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(int r210, CameraInfoInternal r211, Collection<UseCase> r212, Collection<UseCase> r213, Map<UseCase, ConfigPair> r214) {
        ArrayList r100 = new ArrayList();
        String r101 = r211.getCameraId();
        HashMap r102 = new HashMap();
        HashMap r103 = new HashMap();
        Iterator<UseCase> r104 = r213.iterator();
    L3:
        Size r105 = null;
        if (r104.hasNext() == false) goto L7;
        UseCase r106 = r104.next();
        AttachedSurfaceInfo r107 = AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(r210, r101, r106.getImageFormat(), r106.getAttachedSurfaceResolution()), r106.getImageFormat(), r106.getAttachedSurfaceResolution(), ((StreamSpec) Preconditions.checkNotNull(r106.getAttachedStreamSpec())).getDynamicRange(), StreamSharing.getCaptureTypes(r106), r106.getAttachedStreamSpec().getImplementationOptions(), r106.getCurrentConfig().getTargetFrameRate(null));
        r100.add(r107);
        r103.put(r107, r106);
        r102.put(r106, r106.getAttachedStreamSpec());
        goto L3
    L7:
        if (r212.isEmpty() == true) goto L34;
        HashMap r110 = new HashMap();
        HashMap r108 = new HashMap();
        Rect r109 = this.mCameraInternal.getCameraControlInternal().getSensorRect();     // Catch: NullPointerException -> L11
    L13:
        if (r109 == null) goto L15;
        r105 = TransformUtils.rectToSize(r109);
    L15:
        SupportedOutputSizesSorter r111 = new SupportedOutputSizesSorter(r211, r105);
        Iterator<UseCase> r112 = r212.iterator();
    L16:
        boolean r113 = false;
    L18:
        if (r112.hasNext() == false) goto L24;
        UseCase r114 = r112.next();
        ConfigPair r115 = r214.get(r114);
        UseCaseConfig<?> r116 = r114.mergeConfigs(r211, r115.mExtendedConfig, r115.mCameraConfig);
        r110.put(r116, r114);
        r108.put(r116, r111.getSortedSupportedOutputSizes(r116));
        if ((r114.getCurrentConfig() instanceof PreviewConfig) == false) goto L18;
        PreviewConfig r117 = (PreviewConfig) r114.getCurrentConfig();
        r117.getClass();
        if (UseCaseConfig.CC.$default$getPreviewStabilizationMode(r117) != 2) goto L16;
        r113 = true;
        goto L18
    L24:
        Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> r118 = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(r210, r101, r100, r108, r113, hasVideoCapture(r212));
        Iterator r119 = r110.entrySet().iterator();
    L26:
        if (r119.hasNext() == false) goto L28;
        Map.Entry r120 = (Map.Entry) r119.next();
        r102.put((UseCase) r120.getValue(), (StreamSpec) ((Map) r118.first).get(r120.getKey()));
        goto L26
    L28:
        Iterator r121 = ((Map) r118.second).entrySet().iterator();
    L30:
        if (r121.hasNext() == false) goto L34;
        Map.Entry r122 = (Map.Entry) r121.next();
        if (r103.containsKey(r122.getKey()) == false) goto L30;
        r102.put((UseCase) r103.get(r122.getKey()), (StreamSpec) r122.getValue());
    L11:
        r109 = null;
    L34:
        return r102;
    }

    public CameraUseCaseAdapter(CameraInternal r100, CameraInternal r101, RestrictedCameraInfo r102, RestrictedCameraInfo r103, LayoutSettings r104, LayoutSettings r105, CameraCoordinator r106, CameraDeviceSurfaceManager r107, UseCaseConfigFactory r110) {
        this.mAppUseCases = new ArrayList();
        this.mCameraUseCases = new ArrayList();
        this.mEffects = Collections.emptyList();
        this.mLock = new Object();
        this.mAttached = true;
        this.mInteropConfig = null;
        this.mCameraInternal = r100;
        this.mSecondaryCameraInternal = r101;
        this.mLayoutSettings = r104;
        this.mSecondaryLayoutSettings = r105;
        this.mCameraCoordinator = r106;
        this.mCameraDeviceSurfaceManager = r107;
        this.mUseCaseConfigFactory = r110;
        CameraConfig r108 = r102.getCameraConfig();
        this.mCameraConfig = r108;
        SessionProcessor r109 = r108.getSessionProcessor(null);
        this.mAdapterCameraControl = new RestrictedCameraControl(r100.getCameraControlInternal(), r109);
        this.mAdapterCameraInfo = r102;
        this.mAdapterSecondaryCameraInfo = r103;
        this.mId = generateCameraId(r102, r103);
    }
}
