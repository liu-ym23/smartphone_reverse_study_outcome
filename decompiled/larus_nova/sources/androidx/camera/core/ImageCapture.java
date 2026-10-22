package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.imagecapture.ImageCaptureControl;
import androidx.camera.core.imagecapture.ImagePipeline;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.ScreenFlashWrapper;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    public static final int CAPTURE_MODE_ZERO_SHUTTER_LAG = 2;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    public static final Defaults DEFAULT_CONFIG = null;
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = null;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    public static final int FLASH_MODE_SCREEN = 3;
    private static final int FLASH_MODE_UNKNOWN = -1;
    public static final int FLASH_TYPE_ONE_SHOT_FLASH = 0;
    public static final int FLASH_TYPE_USE_TORCH_AS_FLASH = 1;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    public static final int OUTPUT_FORMAT_JPEG = 0;
    public static final int OUTPUT_FORMAT_JPEG_ULTRA_HDR = 1;
    public static final long SCREEN_FLASH_UI_APPLY_TIMEOUT_SECONDS = 3;
    private static final String TAG = "ImageCapture";
    private final int mCaptureMode;
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener;
    private Rational mCropAspectRatio;
    private int mFlashMode;
    private final int mFlashType;
    private final ImageCaptureControl mImageCaptureControl;
    private ImagePipeline mImagePipeline;
    private final AtomicReference<Integer> mLockedFlashMode;
    private ScreenFlashWrapper mScreenFlashWrapper;
    SessionConfig.Builder mSessionConfigBuilder;
    private TakePictureManager mTakePictureManager;

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder>, ImageInputConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public ImageCapture build() {
            Integer r100 = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (r100 == null) goto L6;
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, r100);
        L9:
            ImageCaptureConfig r101 = getUseCaseConfig();
            ImageOutputConfig.CC.validateConfig(r101);
            ImageCapture r102 = new ImageCapture(r101);
            Size r103 = (Size) getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null);
            if (r103 == null) goto L12;
            r102.setCropAspectRatio(new Rational(r103.getWidth(), r103.getHeight()));
        L12:
            Preconditions.checkNotNull((Executor) getMutableConfig().retrieveOption(IoConfig.OPTION_IO_EXECUTOR, CameraXExecutors.ioExecutor()), "The IO executor can't be null");
            MutableConfig r104 = getMutableConfig();
            Config.Option<Integer> r105 = ImageCaptureConfig.OPTION_FLASH_MODE;
            if (r104.containsOption(r105) == false) goto L33;
            Integer r106 = (Integer) getMutableConfig().retrieveOption(r105);
            if (r106 == null) goto L32;
            if (r106.intValue() == 0) goto L25;
            if (r106.intValue() == 1) goto L25;
            if (r106.intValue() == 3) goto L25;
            if (r106.intValue() != 2) goto L32;
        L25:
            if (r106.intValue() != 3) goto L33;
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, null) != null) goto L33;
            throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
        L32:
            throw new IllegalArgumentException("The flash mode is not allowed to set: " + r106);
        L33:
            return r102;
        L6:
            if (ImageCapture.access$000(getMutableConfig()) == false) goto L8;
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
            goto L9
        L8:
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
            goto L9
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
            setCaptureType(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
            setTargetClass(ImageCapture.class);
            return;
        L5:
            if (r101.equals(ImageCapture.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r101);
        }

        public static Builder fromConfig(Config r100) {
            return new Builder(MutableOptionsBundle.from(r100));
        }

        public Builder setBufferFormat(int r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(r100));
            return this;
        }

        public Builder setCaptureMode(int r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(r100));
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

        public Builder setFlashMode(int r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(r100));
            return this;
        }

        public Builder setFlashType(int r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_TYPE, Integer.valueOf(r100));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setHighResolutionDisabled(boolean r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r100));
            return this;
        }

        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.IoConfig.Builder
        public Builder setIoExecutor(Executor r100) {
            getMutableConfig().insertOption(IoConfig.OPTION_IO_EXECUTOR, r100);
            return this;
        }

        public Builder setJpegQuality(int r100) {
            Preconditions.checkArgumentInRange(r100, 1, 100, "jpegQuality");
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(r100));
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
            throw new UnsupportedOperationException("setMirrorMode is not supported.");
        }

        public Builder setOutputFormat(int r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, Integer.valueOf(r100));
            return this;
        }

        public Builder setPostviewEnabled(boolean r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.valueOf(r100));
            return this;
        }

        public Builder setPostviewResolutionSelector(ResolutionSelector r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setResolutionSelector(ResolutionSelector r100) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, r100);
            return this;
        }

        public Builder setScreenFlash(ScreenFlash r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SCREEN_FLASH, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r100);
            return this;
        }

        public Builder setSoftwareJpegEncoderRequested(boolean r100) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.valueOf(r100));
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
        public Builder setTargetClass(Class<ImageCapture> r100) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r100);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r100.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
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
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setZslDisabled(boolean r100) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r100));
            return this;
        }

        public static Builder fromConfig(ImageCaptureConfig r100) {
            return new Builder(MutableOptionsBundle.from(r100));
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

        @Override // androidx.camera.core.internal.IoConfig.Builder
        public /* bridge */ /* synthetic */ Builder setIoExecutor(Executor r100) {
            return setIoExecutor(r100);
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

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageCaptureConfig DEFAULT_CONFIG = null;
        private static final DynamicRange DEFAULT_DYNAMIC_RANGE = null;
        private static final int DEFAULT_OUTPUT_FORMAT = 0;
        private static final ResolutionSelector DEFAULT_RESOLUTION_SELECTOR = null;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        public Defaults() {
        }

        static {
            ResolutionSelector r100 = new ResolutionSelector.Builder().setAspectRatioStrategy(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY).setResolutionStrategy(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY).build();
            DEFAULT_RESOLUTION_SELECTOR = r100;
            DynamicRange r101 = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = r101;
            DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).setResolutionSelector(r100).setOutputFormat(0).setDynamicRange(r101).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public /* bridge */ /* synthetic */ Config getConfig() {
            return getConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public ImageCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashType {
    }

    public static class ImageCaptureCapabilitiesImpl implements ImageCaptureCapabilities {
        private final CameraInfo mCameraInfo;

        private boolean isUltraHdrSupported() {
            CameraInfo r100 = this.mCameraInfo;
            if ((r100 instanceof CameraInfoInternal) == true) goto L5;
            return false;
        L5:
            return ((CameraInfoInternal) r100).getSupportedOutputFormats().contains(4101);
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public Set<Integer> getSupportedOutputFormats() {
            HashSet r100 = new HashSet();
            r100.add(0);
            if (isUltraHdrSupported() == false) goto L5;
            r100.add(1);
        L5:
            return r100;
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public boolean isCaptureProcessProgressSupported() {
            CameraInfo r100 = this.mCameraInfo;
            if ((r100 instanceof CameraInfoInternal) == true) goto L5;
            return false;
        L5:
            return ((CameraInfoInternal) r100).isCaptureProcessProgressSupported();
        }

        @Override // androidx.camera.core.ImageCaptureCapabilities
        public boolean isPostviewSupported() {
            CameraInfo r100 = this.mCameraInfo;
            if ((r100 instanceof CameraInfoInternal) == true) goto L5;
            return false;
        L5:
            return ((CameraInfoInternal) r100).isPostviewSupported();
        }

        public ImageCaptureCapabilitiesImpl(CameraInfo r100) {
            this.mCameraInfo = r100;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageCaptureError {
    }

    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedHorizontalSet;
        private boolean mIsReversedVertical;
        private Location mLocation;

        public String toString() {
            return "Metadata{mIsReversedHorizontal=" + this.mIsReversedHorizontal + ", mIsReversedVertical=" + this.mIsReversedVertical + ", mLocation=" + this.mLocation + com.alipay.sdk.m.u.i.f25855d;
        }

        public Metadata() {
            this.mIsReversedHorizontalSet = false;
        }

        public Location getLocation() {
            return this.mLocation;
        }

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        public boolean isReversedHorizontalSet() {
            return this.mIsReversedHorizontalSet;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setLocation(Location r100) {
            this.mLocation = r100;
        }

        public void setReversedHorizontal(boolean r100) {
            this.mIsReversedHorizontal = r100;
            this.mIsReversedHorizontalSet = true;
        }

        public void setReversedVertical(boolean r100) {
            this.mIsReversedVertical = r100;
        }
    }

    public static abstract class OnImageCapturedCallback {
        public OnImageCapturedCallback() {
        }

        public void onCaptureProcessProgressed(int r100) {
        }

        public void onCaptureStarted() {
        }

        public void onCaptureSuccess(ImageProxy r100) {
        }

        public void onError(ImageCaptureException r100) {
        }

        public void onPostviewBitmapAvailable(Bitmap r100) {
        }
    }

    public interface OnImageSavedCallback {

        /* JADX INFO: renamed from: androidx.camera.core.ImageCapture$OnImageSavedCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCaptureProcessProgressed(OnImageSavedCallback r100, int r101) {
            }

            public static void $default$onCaptureStarted(OnImageSavedCallback r100) {
            }

            public static void $default$onPostviewBitmapAvailable(OnImageSavedCallback r100, Bitmap r101) {
            }
        }

        void onCaptureProcessProgressed(int r100);

        void onCaptureStarted();

        void onError(ImageCaptureException r100);

        void onImageSaved(OutputFileResults r100);

        void onPostviewBitmapAvailable(Bitmap r100);
    }

    public static final class OutputFileOptions {
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final Metadata mMetadata;
        private final OutputStream mOutputStream;
        private final Uri mSaveCollection;

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private Metadata mMetadata;
            private OutputStream mOutputStream;
            private Uri mSaveCollection;

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }

            public Builder(File r100) {
                this.mFile = r100;
            }

            public Builder setMetadata(Metadata r100) {
                this.mMetadata = r100;
                return this;
            }

            public Builder(OutputStream r100) {
                this.mOutputStream = r100;
            }

            public Builder(ContentResolver r100, Uri r101, ContentValues r102) {
                this.mContentResolver = r100;
                this.mSaveCollection = r101;
                this.mContentValues = r102;
            }
        }

        public String toString() {
            return "OutputFileOptions{mFile=" + this.mFile + ", mContentResolver=" + this.mContentResolver + ", mSaveCollection=" + this.mSaveCollection + ", mContentValues=" + this.mContentValues + ", mOutputStream=" + this.mOutputStream + ", mMetadata=" + this.mMetadata + com.alipay.sdk.m.u.i.f25855d;
        }

        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        public File getFile() {
            return this.mFile;
        }

        public Metadata getMetadata() {
            return this.mMetadata;
        }

        public OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        public OutputFileOptions(File r100, ContentResolver r101, Uri r102, ContentValues r103, OutputStream r104, Metadata r105) {
            this.mFile = r100;
            this.mContentResolver = r101;
            this.mSaveCollection = r102;
            this.mContentValues = r103;
            this.mOutputStream = r104;
            if (r105 != null) goto L5;
            r105 = new Metadata();
        L5:
            this.mMetadata = r105;
        }
    }

    public static class OutputFileResults {
        private final Uri mSavedUri;

        public Uri getSavedUri() {
            return this.mSavedUri;
        }

        public OutputFileResults(Uri r100) {
            this.mSavedUri = r100;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputFormat {
    }

    public interface ScreenFlash {
        void apply(long r100, ScreenFlashListener r101);

        void clear();
    }

    public interface ScreenFlashListener {
        void onCompleted();
    }

    public static /* synthetic */ Void a(List r100) {
        return lambda$submitStillCaptureRequest$4(r100);
    }

    public static /* synthetic */ void b(ImageCapture r100, SessionConfig r101, SessionConfig.SessionError r102) {
        r100.lambda$createPipeline$3(r101, r102);
    }

    public static /* synthetic */ void c(ImageReaderProxy r100) {
        lambda$new$0(r100);
    }

    private void clearPipeline() {
        clearPipeline(false);
    }

    public static /* synthetic */ void d(ImageCapture r100, Executor r101, OnImageCapturedCallback r102) {
        r100.lambda$takePicture$1(r101, r102);
    }

    public static /* synthetic */ void e(ImageCapture r100, OutputFileOptions r101, Executor r102, OnImageSavedCallback r103) {
        r100.lambda$takePicture$2(r101, r102, r103);
    }

    private static /* synthetic */ Void lambda$submitStillCaptureRequest$4(List r100) {
        return null;
    }

    static {
        DEFAULT_CONFIG = new Defaults();
        EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    }

    private void abortImageCaptureRequests() {
        this.mScreenFlashWrapper.completePendingTasks();
        TakePictureManager r100 = this.mTakePictureManager;
        if (r100 == null) goto L6;
        r100.abortRequests();
        return;
    }

    private void setScreenFlashToCameraControl() {
        setScreenFlashToCameraControl(this.mScreenFlashWrapper);
    }

    private void trySetFlashModeToCameraControl() {
        AtomicReference<Integer> r100 = this.mLockedFlashMode;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockedFlashMode.get() == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        getCameraControl().setFlashMode(getFlashMode());     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public int getFlashMode() {
        AtomicReference<Integer> r100 = this.mLockedFlashMode;
        monitor-enter(r100);
        int r101 = this.mFlashMode;     // Catch: Throwable -> L10
        if (r101 != (-1)) goto L8;
        r101 = ((ImageCaptureConfig) getCurrentConfig()).getFlashMode(2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public ScreenFlash getScreenFlash() {
        return this.mScreenFlashWrapper.getBaseScreenFlash();
    }

    @Override // androidx.camera.core.UseCase
    public Set<Integer> getSupportedEffectTargets() {
        HashSet r100 = new HashSet();
        r100.add(4);
        return r100;
    }

    public TakePictureManager getTakePictureManager() {
        TakePictureManager r100 = this.mTakePictureManager;
        Objects.requireNonNull(r100);
        return r100;
    }

    public boolean isProcessingPipelineEnabled() {
        if (this.mImagePipeline != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mTakePictureManager == null) goto L7;
        return true;
    }

    public void lockFlashMode() {
        AtomicReference<Integer> r100 = this.mLockedFlashMode;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockedFlashMode.get() == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        this.mLockedFlashMode.set(Integer.valueOf(getFlashMode()));     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    @Override // androidx.camera.core.UseCase
    public void onCameraControlReady() {
        Logger.d(TAG, "onCameraControlReady");
        trySetFlashModeToCameraControl();
        setScreenFlashToCameraControl();
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    public void unlockFlashMode() {
        AtomicReference<Integer> r100 = this.mLockedFlashMode;
        monitor-enter(r100);
        Integer r101 = this.mLockedFlashMode.getAndSet(null);     // Catch: Throwable -> L13
        if (r101 != null) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L9:
        if (r101.intValue() == getFlashMode()) goto L11;
        trySetFlashModeToCameraControl();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private int getCameraLens() {
        CameraInternal r100 = getCamera();
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getCameraInfo().getLensFacing();
    }

    private int getJpegQualityInternal() {
        ImageCaptureConfig r100 = (ImageCaptureConfig) getCurrentConfig();
        Config.Option<Integer> r101 = ImageCaptureConfig.OPTION_JPEG_COMPRESSION_QUALITY;
        r100.getClass();
        if (ReadableConfig.CC.$default$containsOption(r100, r101) == true) goto L5;
        int r102 = this.mCaptureMode;
        if (r102 != 0) goto L9;
        return 100;
    L9:
        if (r102 != 1) goto L11;
        return 95;
    L11:
        if (r102 != 2) goto L14;
        return 95;
    L14:
        throw new IllegalStateException("CaptureMode " + this.mCaptureMode + " is invalid");
    L5:
        return r100.getJpegQuality();
    }

    private SessionProcessor getSessionProcessor() {
        return getCamera().getExtendedConfig().getSessionProcessor(null);
    }

    private Rect getTakePictureCropRect() {
        Rect r100 = getViewPortCropRect();
        Size r101 = getAttachedSurfaceResolution();
        Objects.requireNonNull(r101);
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (ImageUtil.isAspectRatioValid(this.mCropAspectRatio) == false) goto L14;
        CameraInternal r102 = getCamera();
        Objects.requireNonNull(r102);
        int r103 = getRelativeRotation(r102);
        Rational r104 = new Rational(this.mCropAspectRatio.getDenominator(), this.mCropAspectRatio.getNumerator());
        if (TransformUtils.is90or270(r103) == true) goto L11;
        r104 = this.mCropAspectRatio;
    L11:
        Rect r105 = ImageUtil.computeCropRectFromAspectRatio(r101, r104);
        Objects.requireNonNull(r105);
        return r105;
    L14:
        return new Rect(0, 0, r101.getWidth(), r101.getHeight());
    }

    private boolean isSessionProcessorEnabledInCurrentCamera() {
        if (getCamera() != null) goto L6;
        return false;
    L6:
        if (getCamera().getExtendedConfig().getSessionProcessor(null) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public int getJpegQuality() {
        return getJpegQualityInternal();
    }

    public int getOutputFormat() {
        return ((Integer) Preconditions.checkNotNull((Integer) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, 0))).intValue();
    }

    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
    }

    public ImageCaptureLatencyEstimate getRealtimeCaptureLatencyEstimate() {
        CameraInternal r100 = getCamera();
        if (r100 == null) goto L5;
        Pair<Long, Long> r101 = r100.getExtendedConfig().getSessionProcessor().getRealtimeCaptureLatency();
        if (r101 != null) goto L11;
        return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
    L11:
        return new ImageCaptureLatencyEstimate(((Long) r101.first).longValue(), ((Long) r101.second).longValue());
    L5:
        return ImageCaptureLatencyEstimate.UNDEFINED_IMAGE_CAPTURE_LATENCY;
    }

    public ResolutionInfo getResolutionInfo() {
        return getResolutionInfoInternal();
    }

    @Override // androidx.camera.core.UseCase
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal r100 = getCamera();
        Size r101 = getAttachedSurfaceResolution();
        if (r100 == null) goto L13;
        if (r101 == null) goto L15;
        Rect r102 = getViewPortCropRect();
        Rational r103 = this.mCropAspectRatio;
        if (r102 != null) goto L11;
        if (r103 == null) goto L10;
        r102 = ImageUtil.computeCropRectFromAspectRatio(r101, r103);
        goto L11
    L10:
        r102 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
    L11:
        int r104 = getRelativeRotation(r100);
        Objects.requireNonNull(r102);
        return new ResolutionInfo(r101, r102, r104);
    L15:
        return null;
    L13:
        return null;
    }

    public ResolutionSelector getResolutionSelector() {
        return ((ImageOutputConfig) getCurrentConfig()).getResolutionSelector(null);
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public boolean isPostviewEnabled() {
        return ((Boolean) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue();
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        Preconditions.checkNotNull(getCamera(), "Attached camera cannot be null");
        if (getFlashMode() == 3) goto L5;
        return;
    L5:
        if (getCameraLens() != 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        abortImageCaptureRequests();
        clearPipeline();
        setScreenFlashToCameraControl(null);
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        abortImageCaptureRequests();
    }

    public ImageCapture(ImageCaptureConfig r100) {
        super(r100);
        this.mClosingListener = new q();
        this.mLockedFlashMode = new AtomicReference(null);
        this.mFlashMode = -1;
        this.mCropAspectRatio = null;
        this.mImageCaptureControl = new AnonymousClass1(this);
        ImageCaptureConfig r101 = (ImageCaptureConfig) getCurrentConfig();
        Config.Option<Integer> r102 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        r101.getClass();
        if (ReadableConfig.CC.$default$containsOption(r101, r102) == false) goto L5;
        this.mCaptureMode = r101.getCaptureMode();
    L6:
        this.mFlashType = r101.getFlashType(0);
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(r101.getScreenFlash());
        return;
    L5:
        this.mCaptureMode = 1;
        goto L6
    }

    public static /* synthetic */ boolean access$000(MutableConfig r100) {
        return isOutputFormatUltraHdr(r100);
    }

    private void clearPipeline(boolean r100) {
        Threads.checkMainThread();
        SessionConfig.CloseableErrorListener r101 = this.mCloseableErrorListener;
        if (r101 == null) goto L5;
        r101.close();
        this.mCloseableErrorListener = null;
    L5:
        ImagePipeline r102 = this.mImagePipeline;
        if (r102 == null) goto L8;
        r102.close();
        this.mImagePipeline = null;
    L8:
        if (r100 == true) goto L13;
        TakePictureManager r103 = this.mTakePictureManager;
        if (r103 == null) goto L14;
        r103.abortRequests();
        this.mTakePictureManager = null;
        return;
    L14:
        return;
    }

    public static int getError(Throwable r100) {
        if ((r100 instanceof CameraClosedException) == false) goto L7;
        return 3;
    L7:
        if ((r100 instanceof ImageCaptureException) == true) goto L9;
        return 0;
    L9:
        return ((ImageCaptureException) r100).getImageCaptureError();
    }

    public static ImageCaptureCapabilities getImageCaptureCapabilities(CameraInfo r100) {
        return new ImageCaptureCapabilitiesImpl(r100);
    }

    private static boolean isOutputFormatUltraHdr(MutableConfig r100) {
        return Objects.equals(r100.retrieveOption(ImageCaptureConfig.OPTION_OUTPUT_FORMAT, null), 1);
    }

    private static /* synthetic */ void lambda$new$0(ImageReaderProxy r100) {
        ImageProxy r101 = r100.acquireLatestImage();     // Catch: IllegalStateException -> L15
        Objects.toString(r101);     // Catch: Throwable -> L7
        if (r101 == null) goto L14;
        r101.close();     // Catch: IllegalStateException -> L15
        return;
    L14:
        return;
    L7:
        th = move-exception;
        if (r101 != null) goto L16;
    L13:
        throw th;     // Catch: IllegalStateException -> L15
    L16:
        r101.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L15
    }

    private void setScreenFlashToCameraControl(ScreenFlash r100) {
        getCameraControl().setScreenFlash(r100);
    }

    public boolean enforceSoftwareJpegConstraints(MutableConfig r100) {
        Boolean r101 = Boolean.TRUE;
        Config.Option<Boolean> r102 = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean r103 = Boolean.FALSE;
        boolean r104 = false;
        if (r101.equals(r100.retrieveOption(r102, r103)) == true) goto L5;
    L16:
        return r104;
    L5:
        if (isSessionProcessorEnabledInCurrentCamera() == false) goto L7;
        Logger.w(TAG, "Software JPEG cannot be used with Extensions.");
        boolean r105 = false;
    L8:
        Integer r106 = (Integer) r100.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        if (r106 != null) goto L11;
    L13:
        r104 = r105;
    L14:
        if (r104 == true) goto L16;
        Logger.w(TAG, "Unable to support software JPEG. Disabling.");
        r100.insertOption(r102, r103);
        goto L16
    L11:
        if (r106.intValue() == 256) goto L13;
        Logger.w(TAG, "Software JPEG cannot be used with non-JPEG output buffer format.");
        goto L14
    L7:
        r105 = true;
        goto L8
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

    public void setCropAspectRatio(Rational r100) {
        this.mCropAspectRatio = r100;
    }

    public void setFlashMode(int r100) {
        Logger.d(TAG, "setFlashMode: flashMode = " + r100);
        if (r100 != 0) goto L5;
    L23:
        AtomicReference<Integer> r101 = this.mLockedFlashMode;
        monitor-enter(r101);
        this.mFlashMode = r100;     // Catch: Throwable -> L28
        trySetFlashModeToCameraControl();     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L23;
        if (r100 != 3) goto L22;
        if (this.mScreenFlashWrapper.getBaseScreenFlash() == null) goto L20;
        if (getCamera() == null) goto L23;
        if (getCameraLens() == 0) goto L23;
        throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
    L20:
        throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
    L22:
        throw new IllegalArgumentException("Invalid flash mode: " + r100);
    }

    public void setScreenFlash(ScreenFlash r100) {
        this.mScreenFlashWrapper = ScreenFlashWrapper.from(r100);
        setScreenFlashToCameraControl();
    }

    public void setTargetRotation(int r100) {
        int r101 = getTargetRotation();
        if (setTargetRotationInternal(r100) == true) goto L5;
        return;
    L5:
        if (this.mCropAspectRatio == null) goto L9;
        int r102 = CameraOrientationUtil.surfaceRotationToDegrees(r101);
        this.mCropAspectRatio = ImageUtil.getRotatedAspectRatio(Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(r100) - r102), this.mCropAspectRatio);
        return;
    }

    public ListenableFuture<Void> submitStillCaptureRequest(List<CaptureConfig> r100) {
        Threads.checkMainThread();
        return Futures.transform(getCameraControl().submitStillCaptureRequests(r100, this.mCaptureMode, this.mFlashType), new s(), CameraXExecutors.directExecutor());
    }

    private static boolean isImageFormatSupported(List<Pair<Integer, Size[]>> r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<Pair<Integer, Size[]>> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (((Integer) r102.next().first).equals(Integer.valueOf(r101)) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private /* synthetic */ void lambda$createPipeline$3(SessionConfig r100, SessionConfig.SessionError r101) {
        if (getCamera() != null) goto L5;
        return;
    L5:
        this.mTakePictureManager.pause();
        clearPipeline(true);
        SessionConfig.Builder r102 = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec()));
        this.mSessionConfigBuilder = r102;
        Object[] r103 = {r102.build()};
        ArrayList r104 = new ArrayList(1);
        Object r105 = r103[0];
        Objects.requireNonNull(r105);
        r104.add(r105);
        updateSessionConfig(Collections.unmodifiableList(r104));
        notifyReset();
        this.mTakePictureManager.resume();
    }

    private /* synthetic */ void lambda$takePicture$1(Executor r100, OnImageCapturedCallback r101) {
        takePicture(r100, r101);
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean r100, UseCaseConfigFactory r101) {
        Defaults r102 = DEFAULT_CONFIG;
        ImageCaptureConfig r103 = r102.getConfig();
        r103.getClass();
        Config r104 = r101.getConfig(UseCaseConfig.CC.$default$getCaptureType(r103), getCaptureMode());
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
        if (r100.getCameraQuirks().contains(SoftwareJpegEncodingPreferredQuirk.class) == false) goto L8;
        Boolean r102 = Boolean.FALSE;
        MutableConfig r103 = r101.getMutableConfig();
        Config.Option<Boolean> r104 = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        Boolean r105 = Boolean.TRUE;
        if (r102.equals(r103.retrieveOption(r104, r105)) == false) goto L7;
        Logger.w(TAG, "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
        goto L8
    L7:
        Logger.i(TAG, "Requesting software JPEG due to device quirk.");
        r101.getMutableConfig().insertOption(r104, r105);
    L8:
        boolean r106 = enforceSoftwareJpegConstraints(r101.getMutableConfig());
        Integer r107 = (Integer) r101.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        int r108 = 35;
        if (r107 == null) goto L23;
        if (isSessionProcessorEnabledInCurrentCamera() == true) goto L13;
    L16:
        boolean r109 = true;
    L17:
        Preconditions.checkArgument(r109, "Cannot set non-JPEG buffer format with Extensions enabled.");
        MutableConfig r110 = r101.getMutableConfig();
        Config.Option<Integer> r111 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (r106 == true) goto L21;
        r108 = r107.intValue();
    L21:
        r110.insertOption(r111, Integer.valueOf(r108));
    L37:
        return r101.getUseCaseConfig();
    L13:
        if (r107.intValue() == 256) goto L16;
        r109 = false;
        goto L17
    L23:
        if (isOutputFormatUltraHdr(r101.getMutableConfig()) == false) goto L25;
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 4101);
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
        goto L37
    L25:
        if (r106 == false) goto L27;
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        goto L37
    L27:
        List r112 = (List) r101.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
        if (r112 != null) goto L31;
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
        goto L37
    L31:
        if (isImageFormatSupported(r112, 256) == false) goto L34;
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
        goto L37
    L34:
        if (isImageFormatSupported(r112, 35) == false) goto L37;
        r101.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
        goto L37
    }

    @Override // androidx.camera.core.UseCase
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec r100, StreamSpec r101) {
        SessionConfig.Builder r102 = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), r100);
        this.mSessionConfigBuilder = r102;
        Object[] r103 = {r102.build()};
        ArrayList r104 = new ArrayList(1);
        Object r105 = r103[0];
        Objects.requireNonNull(r105);
        r104.add(r105);
        updateSessionConfig(Collections.unmodifiableList(r104));
        notifyActive();
        return r100;
    }

    public void takePicture(final Executor r100, final OnImageCapturedCallback r101) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        CameraXExecutors.mainThreadExecutor().execute(new u(this, r100, r101));
        return;
    L6:
        takePictureInternal(r100, r101, null, null);
    }

    private SessionConfig.Builder createPipeline(String r110, ImageCaptureConfig r210, StreamSpec r211) {
        Threads.checkMainThread();
        String.format("createPipeline(cameraId: %s, streamSpec: %s)", new Object[]{r110, r211});
        Size r100 = r211.getResolution();
        CameraInternal r101 = getCamera();
        Objects.requireNonNull(r101);
        boolean r111 = !r101.getHasTransform();
        if (this.mImagePipeline == null) goto L5;
        Preconditions.checkState(r111);
        this.mImagePipeline.close();
    L5:
        int r102 = 35;
        if (((Boolean) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue() == false) goto L28;
        SessionProcessor r103 = getSessionProcessor();
        if (r103 == null) goto L28;
        ResolutionSelector r112 = (ResolutionSelector) getCurrentConfig().retrieveOption(ImageCaptureConfig.OPTION_POSTVIEW_RESOLUTION_SELECTOR, null);
        Map<Integer, List<Size>> r104 = r103.getSupportedPostviewSize(r100);
        List<Size> r105 = r104.get(35);
        if (r105 != null) goto L12;
    L15:
        r102 = 256;
        List<Size> r113 = r104.get(256);
    L16:
        if (r113 != null) goto L18;
    L27:
        int r114 = r102;
        Size r115 = null;
    L29:
        this.mImagePipeline = new ImagePipeline(r210, r100, getEffect(), r111, r115, r114);
        if (this.mTakePictureManager != null) goto L32;
        this.mTakePictureManager = new TakePictureManager(this.mImageCaptureControl);
    L32:
        this.mTakePictureManager.setImagePipeline(this.mImagePipeline);
        SessionConfig.Builder r106 = this.mImagePipeline.createSessionConfigBuilder(r211.getResolution());
        if (Build.VERSION.SDK_INT < 23) goto L40;
        if (getCaptureMode() != 2) goto L40;
        if (r211.getZslDisabled() == true) goto L40;
        getCameraControl().addZslConfig(r106);
    L40:
        if (r211.getImplementationOptions() == null) goto L42;
        r106.addImplementationOptions(r211.getImplementationOptions());
    L42:
        SessionConfig.CloseableErrorListener r107 = this.mCloseableErrorListener;
        if (r107 == null) goto L45;
        r107.close();
    L45:
        SessionConfig.CloseableErrorListener r108 = new SessionConfig.CloseableErrorListener(new t(this));
        this.mCloseableErrorListener = r108;
        r106.setErrorListener(r108);
        return r106;
    L18:
        if (r113.isEmpty() == true) goto L27;
        if (r112 == null) goto L25;
        Collections.sort(r113, new CompareSizesByArea(true));
        CameraInternal r109 = getCamera();
        Rect r116 = r109.getCameraControlInternal().getSensorRect();
        CameraInfoInternal r117 = r109.getCameraInfoInternal();
        List<Size> r118 = SupportedOutputSizesSorter.sortSupportedOutputSizesByResolutionSelector(r112, r113, null, getTargetRotation(), new Rational(r116.width(), r116.height()), r117.getSensorRotationDegrees(), r117.getLensFacing());
        if (r118.isEmpty() == true) goto L24;
        Size r119 = (Size) ListProtector.get(r118, 0);
    L26:
        r115 = r119;
        r114 = r102;
        goto L29
    L24:
        throw new IllegalArgumentException("The postview ResolutionSelector cannot select a valid size for the postview.");
    L25:
        r119 = (Size) Collections.max(r113, new CompareSizesByArea());
        goto L26
    L12:
        if (r105.isEmpty() == true) goto L15;
        r113 = r105;
    L28:
        r115 = null;
        r114 = 35;
        goto L29
    }

    private /* synthetic */ void lambda$takePicture$2(OutputFileOptions r100, Executor r101, OnImageSavedCallback r102) {
        takePicture(r100, r101, r102);
    }

    private void sendInvalidCameraError(Executor r100, OnImageCapturedCallback r101, OnImageSavedCallback r102) {
        ImageCaptureException r103 = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null);
        if (r101 == null) goto L5;
        r101.onError(r103);
        return;
    L5:
        if (r102 == null) goto L9;
        r102.onError(r103);
        return;
    L9:
        throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
    }

    public void takePicture(final OutputFileOptions r100, final Executor r101, final OnImageSavedCallback r102) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        CameraXExecutors.mainThreadExecutor().execute(new r(this, r100, r101, r102));
        return;
    L6:
        takePictureInternal(r101, null, r102, r100);
    }

    private void takePictureInternal(Executor r110, OnImageCapturedCallback r111, OnImageSavedCallback r112, OutputFileOptions r113) {
        Threads.checkMainThread();
        if (getFlashMode() == 3) goto L5;
    L9:
        CameraInternal r100 = getCamera();
        if (r100 != null) goto L13;
        sendInvalidCameraError(r110, r111, r112);
        return;
    L13:
        TakePictureManager r101 = this.mTakePictureManager;
        Objects.requireNonNull(r101);
        r101.offerRequest(TakePictureRequest.of(r110, r111, r112, r113, getTakePictureCropRect(), getSensorToBufferTransformMatrix(), getRelativeRotation(r100), getJpegQualityInternal(), getCaptureMode(), this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks()));
        return;
    L5:
        if (this.mScreenFlashWrapper.getBaseScreenFlash() != null) goto L9;
        throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
    }

    public static Rect computeDispatchCropRect(Rect r100, Rational r101, int r102, Size r103, int r104) {
        if (r100 != null) goto L4;
        if (r101 == null) goto L14;
        if ((r104 % 180) == 0) goto L10;
        r101 = new Rational(r101.getDenominator(), r101.getNumerator());
    L10:
        if (ImageUtil.isAspectRatioValid(r103, r101) == false) goto L14;
        Rect r105 = ImageUtil.computeCropRectFromAspectRatio(r103, r101);
        Objects.requireNonNull(r105);
        return r105;
    L14:
        return new Rect(0, 0, r103.getWidth(), r103.getHeight());
    L4:
        return ImageUtil.computeCropRectFromDispatchInfo(r100, r102, r103, r104);
    }
}
