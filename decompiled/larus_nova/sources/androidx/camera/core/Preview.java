package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.capability.PreviewCapabilitiesImpl;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.util.OutConfig;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Preview extends UseCase {
    public static final Defaults DEFAULT_CONFIG = null;
    private static final Executor DEFAULT_SURFACE_PROVIDER_EXECUTOR = null;
    private static final String TAG = "Preview";
    private SurfaceEdge mCameraEdge;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    SurfaceRequest mCurrentSurfaceRequest;
    private SurfaceProcessorNode mNode;
    SessionConfig.Builder mSessionConfigBuilder;
    private DeferrableSurface mSessionDeferrableSurface;
    private SurfaceProvider mSurfaceProvider;
    private Executor mSurfaceProviderExecutor;

    public static final class Builder implements UseCaseConfig.Builder<Preview, PreviewConfig, Builder>, ImageOutputConfig.Builder<Builder>, ImageInputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public PreviewConfig getUseCaseConfig() {
            return new PreviewConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public Preview build() {
            PreviewConfig r100 = getUseCaseConfig();
            ImageOutputConfig.CC.validateConfig(r100);
            return new Preview(r100);
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public /* bridge */ /* synthetic */ Object build() {
            return build();
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ UseCaseConfig getUseCaseConfig() {
            return getUseCaseConfig();
        }

        private Builder(MutableOptionsBundle r100) {
            this.mMutableConfig = r100;
            Class r101 = (Class) r100.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (r101 != null) goto L5;
        L9:
            setCaptureType(UseCaseConfigFactory.CaptureType.PREVIEW);
            setTargetClass(Preview.class);
            Config.Option<Integer> r102 = ImageOutputConfig.OPTION_MIRROR_MODE;
            if (((Integer) r100.retrieveOption(r102, -1)).intValue() != (-1)) goto L13;
            r100.insertOption(r102, 2);
            return;
        L13:
            return;
        L5:
            if (r101.equals(Preview.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r101);
        }

        public static Builder fromConfig(Config r100) {
            return new Builder(MutableOptionsBundle.from(r100));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public Builder setBackgroundExecutor(Executor r100) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setCaptureType(UseCaseConfigFactory.CaptureType r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setCustomOrderedResolutions(List<Size> r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setDefaultCaptureConfig(CaptureConfig r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setDefaultResolution(Size r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setDefaultSessionConfig(SessionConfig r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public Builder setDynamicRange(DynamicRange r100) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setHighResolutionDisabled(boolean r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r100));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setMaxResolution(Size r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setMirrorMode(int r100) {
            if (Build.VERSION.SDK_INT < 33) goto L5;
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(r100));
        L5:
            return this;
        }

        public Builder setPreviewStabilizationEnabled(boolean r100) {
            MutableConfig r101 = getMutableConfig();
            Config.Option<Integer> r102 = UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE;
            if (r100 == false) goto L5;
            int r103 = 2;
        L6:
            r101.insertOption(r102, Integer.valueOf(r103));
            return this;
        L5:
            r103 = 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setResolutionSelector(ResolutionSelector r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSurfaceOccupancyPriority(int r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(r100));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetAspectRatio(int r100) {
            if (r100 != (-1)) goto L5;
            r100 = 0;
        L5:
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(r100));
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetClass(Class<Preview> r100) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r100);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r100.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
            return this;
        }

        public Builder setTargetFrameRate(Range<Integer> r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, r100);
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetName(String r100) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetResolution(Size r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetRotation(int r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r100));
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(r100));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setZslDisabled(boolean r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r100));
            return this;
        }

        public static Builder fromConfig(PreviewConfig r100) {
            return new Builder(MutableOptionsBundle.from(r100));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public /* bridge */ /* synthetic */ Builder setBackgroundExecutor(Executor r100) {
            return setBackgroundExecutor(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r100) {
            return setCaptureOptionUnpacker(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setCaptureType(UseCaseConfigFactory.CaptureType r100) {
            return setCaptureType(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setCustomOrderedResolutions(List r100) {
            return setCustomOrderedResolutions(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDefaultCaptureConfig(CaptureConfig r100) {
            return setDefaultCaptureConfig(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDefaultResolution(Size r100) {
            return setDefaultResolution(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDefaultSessionConfig(SessionConfig r100) {
            return setDefaultSessionConfig(r100);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setDynamicRange(DynamicRange r100) {
            return setDynamicRange(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setHighResolutionDisabled(boolean r100) {
            return setHighResolutionDisabled(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setMaxResolution(Size r100) {
            return setMaxResolution(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setMirrorMode(int r100) {
            return setMirrorMode(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setResolutionSelector(ResolutionSelector r100) {
            return setResolutionSelector(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r100) {
            return setSessionOptionUnpacker(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(List r100) {
            return setSupportedResolutions(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSurfaceOccupancyPriority(int r100) {
            return setSurfaceOccupancyPriority(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetAspectRatio(int r100) {
            return setTargetAspectRatio(r100);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetClass(Class r100) {
            return setTargetClass(r100);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetName(String r100) {
            return setTargetName(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetResolution(Size r100) {
            return setTargetResolution(r100);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetRotation(int r100) {
            return setTargetRotation(r100);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public /* bridge */ /* synthetic */ Builder setZslDisabled(boolean r100) {
            return setZslDisabled(r100);
        }
    }

    public static final class Defaults implements ConfigProvider<PreviewConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final PreviewConfig DEFAULT_CONFIG = null;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE = null;
        private static final int DEFAULT_MIRROR_MODE = 2;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR = null;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;

        public Defaults() {
        }

        static {
            ResolutionSelector r100 = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = r100;
            DynamicRange r101 = DynamicRange.UNSPECIFIED;
            DEFAULT_DYNAMIC_RANGE = r101;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(2).setTargetAspectRatio(0).setResolutionSelector(r100).setDynamicRange(r101).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public /* bridge */ /* synthetic */ Config getConfig() {
            return getConfig();
        }

        public static /* synthetic */ DynamicRange access$000() {
            return DEFAULT_DYNAMIC_RANGE;
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public PreviewConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    public interface SurfaceProvider {
        void onSurfaceRequested(SurfaceRequest r100);
    }

    public static /* synthetic */ void a(Preview r100, CameraInternal r101) {
        r100.lambda$createPipeline$0(r101);
    }

    public static /* synthetic */ void b(Preview r100, SessionConfig r101, SessionConfig.SessionError r102) {
        r100.lambda$addCameraSurfaceAndErrorListener$1(r101, r102);
    }

    public static /* synthetic */ void c(SurfaceProvider r100, SurfaceRequest r101) {
        lambda$sendSurfaceRequest$2(r100, r101);
    }

    static {
        DEFAULT_CONFIG = new Defaults();
        DEFAULT_SURFACE_PROVIDER_EXECUTOR = CameraXExecutors.mainThreadExecutor();
    }

    private void clearPipeline() {
        SessionConfig.CloseableErrorListener r100 = this.mCloseableErrorListener;
        if (r100 == null) goto L5;
        r100.close();
        this.mCloseableErrorListener = null;
    L5:
        DeferrableSurface r101 = this.mSessionDeferrableSurface;
        if (r101 == null) goto L8;
        r101.close();
        this.mSessionDeferrableSurface = null;
    L8:
        SurfaceProcessorNode r102 = this.mNode;
        if (r102 == null) goto L11;
        r102.release();
        this.mNode = null;
    L11:
        SurfaceEdge r103 = this.mCameraEdge;
        if (r103 == null) goto L14;
        r103.close();
        this.mCameraEdge = null;
    L14:
        this.mCurrentSurfaceRequest = null;
    }

    public SurfaceEdge getCameraEdge() {
        SurfaceEdge r100 = this.mCameraEdge;
        Objects.requireNonNull(r100);
        return r100;
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet r100 = new HashSet();
        r100.add(1);
        return r100;
    }

    public String toString() {
        return "Preview:" + getName();
    }

    private void sendSurfaceRequest() {
        sendTransformationInfoIfReady();
        final SurfaceProvider r100 = (SurfaceProvider) Preconditions.checkNotNull(this.mSurfaceProvider);
        final SurfaceRequest r101 = (SurfaceRequest) Preconditions.checkNotNull(this.mCurrentSurfaceRequest);
        this.mSurfaceProviderExecutor.execute(new z(r100, r101));
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal r100 = getCamera();
        SurfaceEdge r101 = this.mCameraEdge;
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r101.updateTransformation(getRelativeRotation(r100, isMirroringRequired(r100)), getAppTargetRotation());
        return;
    L8:
        return;
    }

    public DynamicRange getDynamicRange() {
        if (getCurrentConfig().hasDynamicRange() == false) goto L6;
        return getCurrentConfig().getDynamicRange();
    L6:
        return Defaults.access$000();
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    public Range<Integer> getTargetFrameRate() {
        return getTargetFrameRateInternal();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public boolean isPreviewStabilizationEnabled() {
        if (getCurrentConfig().getPreviewStabilizationMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        clearPipeline();
    }

    public Preview(PreviewConfig r100) {
        super(r100);
        this.mSurfaceProviderExecutor = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
    }

    private Rect getCropRect(Size r100) {
        if (getViewPortCropRect() != null) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Rect(0, 0, r100.getWidth(), r100.getHeight());
    L5:
        return getViewPortCropRect();
    }

    public static PreviewCapabilities getPreviewCapabilities(CameraInfo r100) {
        return PreviewCapabilitiesImpl.from(r100);
    }

    private /* synthetic */ void lambda$createPipeline$0(CameraInternal r100) {
        onAppEdgeInvalidated(this.mCameraEdge, r100);
    }

    private boolean shouldMirror(CameraInternal r100) {
        if (r100.getHasTransform() == true) goto L5;
    L7:
        return false;
    L5:
        if (isMirroringRequired(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config r100) {
        return Builder.fromConfig(r100);
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config r100) {
        this.mSessionConfigBuilder.addImplementationOptions(r100);
        Object[] r101 = {this.mSessionConfigBuilder.build()};
        ArrayList r102 = new ArrayList(1);
        Object r103 = r101[0];
        Objects.requireNonNull(r103);
        r102.add(r103);
        updateSessionConfig(Collections.unmodifiableList(r102));
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(r100).build();
    }

    public void setSurfaceProvider(SurfaceProvider r100) {
        setSurfaceProvider(DEFAULT_SURFACE_PROVIDER_EXECUTOR, r100);
    }

    public void setTargetRotation(int r100) {
        if (setTargetRotationInternal(r100) == false) goto L6;
        sendTransformationInfoIfReady();
        return;
    }

    @Override // androidx.camera.core.UseCase
    public void setViewPortCropRect(Rect r100) {
        super.setViewPortCropRect(r100);
        sendTransformationInfoIfReady();
    }

    private void addCameraSurfaceAndErrorListener(SessionConfig.Builder r100, StreamSpec r101) {
        if (this.mSurfaceProvider == null) goto L5;
        r100.addSurface(this.mSessionDeferrableSurface, r101.getDynamicRange(), getPhysicalCameraId(), getMirrorModeInternal());
    L5:
        SessionConfig.CloseableErrorListener r102 = this.mCloseableErrorListener;
        if (r102 == null) goto L8;
        r102.close();
    L8:
        SessionConfig.CloseableErrorListener r103 = new SessionConfig.CloseableErrorListener(new c0(this));
        this.mCloseableErrorListener = r103;
        r100.setErrorListener(r103);
    }

    private SessionConfig.Builder createPipeline(PreviewConfig r110, StreamSpec r111) {
        Threads.checkMainThread();
        CameraInternal r100 = getCamera();
        Objects.requireNonNull(r100);
        final CameraInternal r101 = r100;
        clearPipeline();
        if (this.mCameraEdge != null) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102);
        Matrix r103 = getSensorToBufferTransformMatrix();
        boolean r104 = r101.getHasTransform();
        Rect r105 = getCropRect(r111.getResolution());
        Objects.requireNonNull(r105);
        this.mCameraEdge = new SurfaceEdge(1, 34, r111, r103, r104, r105, getRelativeRotation(r101, isMirroringRequired(r101)), getAppTargetRotation(), shouldMirror(r101));
        CameraEffect r106 = getEffect();
        if (r106 == null) goto L9;
        this.mNode = new SurfaceProcessorNode(r101, r106.createSurfaceProcessorInternal());
        this.mCameraEdge.addOnInvalidatedListener(new a0(this));
        OutConfig r107 = OutConfig.of(this.mCameraEdge);
        SurfaceProcessorNode.In r108 = SurfaceProcessorNode.In.of(this.mCameraEdge, Collections.singletonList(r107));
        SurfaceEdge r109 = this.mNode.transform2(r108).get(r107);
        Objects.requireNonNull(r109);
        r109.addOnInvalidatedListener(new b0(this, r101));
        this.mCurrentSurfaceRequest = r109.createSurfaceRequest(r101);
        this.mSessionDeferrableSurface = this.mCameraEdge.getDeferrableSurface();
    L11:
        if (this.mSurfaceProvider == null) goto L13;
        sendSurfaceRequest();
    L13:
        SessionConfig.Builder r112 = SessionConfig.Builder.createFrom(r110, r111.getResolution());
        r112.setExpectedFrameRateRange(r111.getExpectedFrameRateRange());
        r110.getClass();
        r112.setPreviewStabilization(UseCaseConfig.CC.$default$getPreviewStabilizationMode(r110));
        if (r111.getImplementationOptions() == null) goto L16;
        r112.addImplementationOptions(r111.getImplementationOptions());
    L16:
        addCameraSurfaceAndErrorListener(r112, r111);
        return r112;
    L9:
        this.mCameraEdge.addOnInvalidatedListener(new a0(this));
        SurfaceRequest r113 = this.mCameraEdge.createSurfaceRequest(r101);
        this.mCurrentSurfaceRequest = r113;
        this.mSessionDeferrableSurface = r113.getDeferrableSurface();
        goto L11
    L5:
        r102 = false;
        goto L6
    }

    private /* synthetic */ void lambda$addCameraSurfaceAndErrorListener$1(SessionConfig r100, SessionConfig.SessionError r101) {
        if (getCamera() != null) goto L5;
        return;
    L5:
        updateConfigAndOutput((PreviewConfig) getCurrentConfig(), getAttachedStreamSpec());
        notifyReset();
    }

    private static /* synthetic */ void lambda$sendSurfaceRequest$2(SurfaceProvider r100, SurfaceRequest r101) {
        r100.onSurfaceRequested(r101);
    }

    private void onAppEdgeInvalidated(SurfaceEdge r100, CameraInternal r101) {
        Threads.checkMainThread();
        if (r101 != getCamera()) goto L6;
        r100.invalidate();
        return;
    }

    private void updateConfigAndOutput(PreviewConfig r100, StreamSpec r101) {
        SessionConfig.Builder r102 = createPipeline(r100, r101);
        this.mSessionConfigBuilder = r102;
        Object[] r103 = {r102.build()};
        ArrayList r104 = new ArrayList(1);
        Object r105 = r103[0];
        Objects.requireNonNull(r105);
        r104.add(r105);
        updateSessionConfig(Collections.unmodifiableList(r104));
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r100, UseCaseConfigFactory r101) {
        Defaults r102 = DEFAULT_CONFIG;
        PreviewConfig r103 = r102.getConfig();
        r103.getClass();
        Config r104 = r101.getConfig(UseCaseConfig.CC.$default$getCaptureType(r103), 1);
        if (r100 == false) goto L5;
        r104 = Config.CC.mergeConfigs(r104, r102.getConfig());
    L5:
        if (r104 != null) goto L8;
        return null;
    L8:
        return getUseCaseConfigBuilder(r104).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> onMergeConfig(CameraInfoInternal r100, UseCaseConfig.Builder<?, ?, ?> r101) {
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        return r101.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r100, StreamSpec r101) {
        updateConfigAndOutput((PreviewConfig) getCurrentConfig(), r100);
        return r100;
    }

    public void setSurfaceProvider(Executor r100, SurfaceProvider r101) {
        Threads.checkMainThread();
        if (r101 != null) goto L5;
        this.mSurfaceProvider = null;
        notifyInactive();
        return;
    L5:
        this.mSurfaceProvider = r101;
        this.mSurfaceProviderExecutor = r100;
        if (getAttachedSurfaceResolution() == null) goto L8;
        updateConfigAndOutput((PreviewConfig) getCurrentConfig(), getAttachedStreamSpec());
        notifyReset();
    L8:
        notifyActive();
    }
}
