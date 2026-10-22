package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UseCase {
    private SessionConfig mAttachedSecondarySessionConfig;
    private SessionConfig mAttachedSessionConfig;
    private StreamSpec mAttachedStreamSpec;
    private CameraInternal mCamera;
    private UseCaseConfig<?> mCameraConfig;
    private final Object mCameraLock;
    private UseCaseConfig<?> mCurrentConfig;
    private CameraEffect mEffect;
    private UseCaseConfig<?> mExtendedConfig;
    private String mPhysicalCameraId;
    private CameraInternal mSecondaryCamera;
    private Matrix mSensorToBufferTransformMatrix;
    private State mState;
    private final Set<StateChangeCallback> mStateChangeCallbacks;
    private UseCaseConfig<?> mUseCaseConfig;
    private Rect mViewPortCropRect;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ACTIVE = null;
        public static final State INACTIVE = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{ACTIVE, INACTIVE};
        }

        static {
            ACTIVE = new State("ACTIVE", 0);
            INACTIVE = new State("INACTIVE", 1);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface StateChangeCallback {
        void onUseCaseActive(UseCase r100);

        void onUseCaseInactive(UseCase r100);

        void onUseCaseReset(UseCase r100);

        void onUseCaseUpdated(UseCase r100);
    }

    public abstract UseCaseConfig<?> getDefaultConfig(boolean r100, UseCaseConfigFactory r101);

    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config r100);

    public void onBind() {
    }

    public void onCameraControlReady() {
    }

    public void onStateAttached() {
    }

    public void onStateDetached() {
    }

    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r100, StreamSpec r101) {
        return r100;
    }

    public void onUnbind() {
    }

    public int getAppTargetRotation() {
        return ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(-1);
    }

    public Size getAttachedSurfaceResolution() {
        StreamSpec r100 = this.mAttachedStreamSpec;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getResolution();
    }

    public CameraInternal getCamera() {
        Object r100 = this.mCameraLock;
        monitor-enter(r100);
        CameraInternal r101 = this.mCamera;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public CameraControlInternal getCameraControl() {
        Object r100 = this.mCameraLock;
        monitor-enter(r100);
        CameraInternal r101 = this.mCamera;     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        CameraControlInternal r102 = CameraControlInternal.DEFAULT_EMPTY_INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r102;
    L9:
        CameraControlInternal r103 = r101.getCameraControlInternal();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r103;
    L12:
        th = move-exception;
        throw th;
    }

    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    public int getMirrorModeInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode(-1);
    }

    public String getName() {
        String r100 = this.mCurrentConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(r100);
        return r100;
    }

    public CameraInternal getSecondaryCamera() {
        Object r100 = this.mCameraLock;
        monitor-enter(r100);
        CameraInternal r101 = this.mSecondaryCamera;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public Range<Integer> getTargetFrameRateInternal() {
        return this.mCurrentConfig.getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
    }

    public int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    public final void notifyReset() {
        Iterator<StateChangeCallback> r100 = this.mStateChangeCallbacks.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onUseCaseReset(this);
        goto L4
    }

    public final void notifyState() {
        int r100 = this.mState.ordinal();
        if (r100 != 0) goto L5;
        Iterator<StateChangeCallback> r101 = this.mStateChangeCallbacks.iterator();
    L13:
        if (r101.hasNext() == false) goto L19;
        r101.next().onUseCaseActive(this);
        goto L13
    L19:
        return;
    L5:
        if (r100 != 1) goto L15;
        Iterator<StateChangeCallback> r102 = this.mStateChangeCallbacks.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        r102.next().onUseCaseInactive(this);
        goto L9
    L18:
        return;
    }

    public final void notifyUpdated() {
        Iterator<StateChangeCallback> r100 = this.mStateChangeCallbacks.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onUseCaseUpdated(this);
        goto L4
    }

    public String getCameraId() {
        return ((CameraInternal) Preconditions.checkNotNull(getCamera(), "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal r100 = getCamera();
        Size r101 = getAttachedSurfaceResolution();
        if (r100 == null) goto L11;
        if (r101 == null) goto L13;
        Rect r102 = getViewPortCropRect();
        if (r102 != null) goto L10;
        r102 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
    L10:
        return new ResolutionInfo(r101, r102, getRelativeRotation(r100));
    L13:
        return null;
    L11:
        return null;
    }

    public String getSecondaryCameraId() {
        if (getSecondaryCamera() != null) goto L6;
        return null;
    L6:
        return getSecondaryCamera().getCameraInfoInternal().getCameraId();
    }

    public Set<Integer> getSupportedEffectTargets() {
        return Collections.emptySet();
    }

    public UseCaseConfig<?> getAppConfig() {
        return this.mUseCaseConfig;
    }

    public StreamSpec getAttachedStreamSpec() {
        return this.mAttachedStreamSpec;
    }

    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    public CameraEffect getEffect() {
        return this.mEffect;
    }

    public String getPhysicalCameraId() {
        return this.mPhysicalCameraId;
    }

    public SessionConfig getSecondarySessionConfig() {
        return this.mAttachedSecondarySessionConfig;
    }

    public Matrix getSensorToBufferTransformMatrix() {
        return this.mSensorToBufferTransformMatrix;
    }

    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    public UseCase(UseCaseConfig<?> r100) {
        this.mStateChangeCallbacks = new HashSet();
        this.mCameraLock = new Object();
        this.mState = State.INACTIVE;
        this.mSensorToBufferTransformMatrix = new Matrix();
        this.mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mAttachedSecondarySessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mUseCaseConfig = r100;
        this.mCurrentConfig = r100;
    }

    private void addStateChangeCallback(StateChangeCallback r100) {
        this.mStateChangeCallbacks.add(r100);
    }

    private void removeStateChangeCallback(StateChangeCallback r100) {
        this.mStateChangeCallbacks.remove(r100);
    }

    public static int snapToSurfaceRotation(int r100) {
        Preconditions.checkArgumentInRange(r100, 0, 359, "orientation");
        if (r100 < 315) goto L5;
    L17:
        return 0;
    L5:
        if (r100 < 45) goto L17;
        if (r100 < 225) goto L12;
        return 1;
    L12:
        if (r100 < 135) goto L15;
        return 2;
    L15:
        return 3;
    }

    public int getRelativeRotation(CameraInternal r100) {
        return getRelativeRotation(r100, false);
    }

    public boolean isCurrentCamera(String r100) {
        if (getCamera() != null) goto L7;
        return false;
    L7:
        return Objects.equals(r100, getCameraId());
    }

    public boolean isEffectTargetsSupported(int r100) {
        Iterator<Integer> r101 = getSupportedEffectTargets().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (TargetUtils.isSuperset(r100, r101.next().intValue()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isMirroringRequired(CameraInternal r100) {
        int r101 = getMirrorModeInternal();
        if (r101 == (-1)) goto L14;
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r101 != 1) goto L8;
        return true;
    L8:
        if (r101 != 2) goto L12;
        return r100.isFrontFacing();
    L12:
        throw new AssertionError("Unknown mirrorMode: " + r101);
    L14:
        return false;
    }

    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config r100) {
        StreamSpec r101 = this.mAttachedStreamSpec;
        if (r101 == null) goto L7;
        return r101.toBuilder().setImplementationOptions(r100).build();
    L7:
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    public void setEffect(CameraEffect r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Preconditions.checkArgument(r101);
        this.mEffect = r100;
        return;
    L4:
        if (isEffectTargetsSupported(r100.getTargets()) == true) goto L7;
        r101 = false;
        goto L8
    }

    public void setPhysicalCameraId(String r100) {
        this.mPhysicalCameraId = r100;
    }

    public void setSensorToBufferTransformMatrix(Matrix r100) {
        this.mSensorToBufferTransformMatrix = new Matrix(r100);
    }

    public boolean setTargetRotationInternal(int r100) {
        int r101 = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (r101 == (-1)) goto L8;
        if (r101 != r100) goto L8;
        return false;
    L8:
        UseCaseConfig.Builder<?, ?, ?> r102 = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(r102, r100);
        this.mUseCaseConfig = r102.getUseCaseConfig();
        CameraInternal r103 = getCamera();
        if (r103 != null) goto L11;
        this.mCurrentConfig = this.mUseCaseConfig;
        return true;
    L11:
        this.mCurrentConfig = mergeConfigs(r103.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    public void setViewPortCropRect(Rect r100) {
        this.mViewPortCropRect = r100;
    }

    public final void unbindFromCamera(CameraInternal r100) {
        onUnbind();
        Object r101 = this.mCameraLock;
        monitor-enter(r101);
        CameraInternal r102 = this.mCamera;     // Catch: Throwable -> L13
        if (r100 != r102) goto L7;
        removeStateChangeCallback(r102);     // Catch: Throwable -> L13
        this.mCamera = null;     // Catch: Throwable -> L13
    L7:
        CameraInternal r103 = this.mSecondaryCamera;     // Catch: Throwable -> L13
        if (r100 != r103) goto L10;
        removeStateChangeCallback(r103);     // Catch: Throwable -> L13
        this.mSecondaryCamera = null;     // Catch: Throwable -> L13
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L13
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void updateSessionConfig(List<SessionConfig> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        this.mAttachedSessionConfig = (SessionConfig) ListProtector.get(r100, 0);
        if (r100.size() <= 1) goto L8;
        this.mAttachedSecondarySessionConfig = (SessionConfig) ListProtector.get(r100, 1);
    L8:
        Iterator<SessionConfig> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L17;
        Iterator<DeferrableSurface> r102 = r101.next().getSurfaces().iterator();
    L13:
        if (r102.hasNext() == false) goto L10;
        DeferrableSurface r103 = r102.next();
        if (r103.getContainerClass() != null) goto L13;
        r103.setContainerClass(getClass());
        goto L13
    }

    public void updateSuggestedStreamSpecImplementationOptions(Config r100) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecImplementationOptionsUpdated(r100);
    }

    public int getRelativeRotation(CameraInternal r100, boolean r101) {
        int r102 = r100.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
        if (r100.getHasTransform() == true) goto L6;
        if (r101 == false) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        return r102;
    L9:
        return TransformUtils.within360(-r102);
    L6:
        r103 = false;
        goto L7
    }

    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r100, UseCaseConfig.Builder<?, ?, ?> r101) {
        return r101.getUseCaseConfig();
    }

    public void updateSuggestedStreamSpec(StreamSpec r100, StreamSpec r101) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecUpdated(r100, r101);
    }

    public UseCaseConfig<?> mergeConfigs(CameraInfoInternal r100, UseCaseConfig<?> r101, UseCaseConfig<?> r102) {
        if (r102 == null) goto L4;
        MutableOptionsBundle r103 = MutableOptionsBundle.from(r102);
        r103.removeOption(TargetConfig.OPTION_TARGET_NAME);
    L6:
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) == false) goto L8;
    L9:
        Config.Option<ResolutionSelector> r104 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r103.containsOption(r104) == false) goto L12;
        r103.removeOption(r104);
    L12:
        UseCaseConfig<?> r105 = this.mUseCaseConfig;
        Config.Option<ResolutionSelector> r106 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r105.containsOption(r106) == false) goto L19;
        Config.Option<Size> r107 = ImageOutputConfig.OPTION_MAX_RESOLUTION;
        if (r103.containsOption(r107) == false) goto L19;
        if (((ResolutionSelector) this.mUseCaseConfig.retrieveOption(r106)).getResolutionStrategy() == null) goto L19;
        r103.removeOption(r107);
    L19:
        Iterator<Config.Option<?>> r108 = this.mUseCaseConfig.listOptions().iterator();
    L21:
        if (r108.hasNext() == false) goto L23;
        Config.Option<?> r109 = r108.next();
        Config.CC.mergeOptionValue(r103, r103, this.mUseCaseConfig, r109);
        goto L21
    L23:
        if (r101 == null) goto L32;
        Iterator<Config.Option<?>> r110 = r101.listOptions().iterator();
    L26:
        if (r110.hasNext() == false) goto L32;
        Config.Option<?> r111 = r110.next();
        if (r111.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId()) == true) goto L26;
        Config.CC.mergeOptionValue(r103, r103, r101, r111);
    L32:
        if (r103.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION) == false) goto L36;
        Config.Option<Integer> r112 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
        if (r103.containsOption(r112) == false) goto L36;
        r103.removeOption(r112);
    L36:
        Config.Option<ResolutionSelector> r113 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (r103.containsOption(r113) == false) goto L42;
        if (((ResolutionSelector) r103.retrieveOption(r113)).getAllowedResolutionMode() == 0) goto L42;
        r103.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
    L42:
        return onMergeConfig(r100, getUseCaseConfigBuilder(r103));
    L8:
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION) == false) goto L12;
    L4:
        r103 = MutableOptionsBundle.create();
        goto L6
    }

    public final void bindToCamera(CameraInternal r100, CameraInternal r101, UseCaseConfig<?> r102, UseCaseConfig<?> r103) {
        Object r104 = this.mCameraLock;
        monitor-enter(r104);
        this.mCamera = r100;     // Catch: Throwable -> L10
        this.mSecondaryCamera = r101;     // Catch: Throwable -> L10
        addStateChangeCallback(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        addStateChangeCallback(r101);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r104);     // Catch: Throwable -> L10
        this.mExtendedConfig = r102;
        this.mCameraConfig = r103;
        this.mCurrentConfig = mergeConfigs(r100.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        onBind();
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
