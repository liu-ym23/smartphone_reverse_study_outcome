package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.TargetConfig;

/* JADX INFO: loaded from: classes2.dex */
public interface UseCaseConfig<T extends UseCase> extends TargetConfig<T>, ImageInputConfig {
    public static final Config.Option<CaptureConfig.OptionUnpacker> OPTION_CAPTURE_CONFIG_UNPACKER = null;
    public static final Config.Option<UseCaseConfigFactory.CaptureType> OPTION_CAPTURE_TYPE = null;
    public static final Config.Option<CaptureConfig> OPTION_DEFAULT_CAPTURE_CONFIG = null;
    public static final Config.Option<SessionConfig> OPTION_DEFAULT_SESSION_CONFIG = null;
    public static final Config.Option<Boolean> OPTION_HIGH_RESOLUTION_DISABLED = null;
    public static final Config.Option<Integer> OPTION_PREVIEW_STABILIZATION_MODE = null;
    public static final Config.Option<SessionConfig.OptionUnpacker> OPTION_SESSION_CONFIG_UNPACKER = null;
    public static final Config.Option<Integer> OPTION_SURFACE_OCCUPANCY_PRIORITY = null;
    public static final Config.Option<Range<Integer>> OPTION_TARGET_FRAME_RATE = null;
    public static final Config.Option<Integer> OPTION_VIDEO_STABILIZATION_MODE = null;
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.UseCaseConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T extends UseCase> {
        public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig r100) {
            return (CaptureConfig.OptionUnpacker) r100.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
        }

        public static UseCaseConfigFactory.CaptureType $default$getCaptureType(UseCaseConfig r100) {
            return (UseCaseConfigFactory.CaptureType) r100.retrieveOption(UseCaseConfig.OPTION_CAPTURE_TYPE);
        }

        public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig r100) {
            return (CaptureConfig) r100.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
        }

        public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig r100) {
            return (SessionConfig) r100.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
        }

        public static int $default$getPreviewStabilizationMode(UseCaseConfig r100) {
            return ((Integer) r100.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE, 0)).intValue();
        }

        public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig r100) {
            return (SessionConfig.OptionUnpacker) r100.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
        }

        public static int $default$getSurfaceOccupancyPriority(UseCaseConfig r100) {
            return ((Integer) r100.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
        }

        public static Range $default$getTargetFrameRate(UseCaseConfig r100) {
            return (Range) r100.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
        }

        public static int $default$getVideoStabilizationMode(UseCaseConfig r100) {
            return ((Integer) r100.retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE, 0)).intValue();
        }

        public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig r100, CaptureConfig.OptionUnpacker r101) {
            return (CaptureConfig.OptionUnpacker) r100.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, r101);
        }

        public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig r100, CaptureConfig r101) {
            return (CaptureConfig) r100.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, r101);
        }

        public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig r100, SessionConfig r101) {
            return (SessionConfig) r100.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, r101);
        }

        public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig r100, SessionConfig.OptionUnpacker r101) {
            return (SessionConfig.OptionUnpacker) r100.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, r101);
        }

        public static int $default$getSurfaceOccupancyPriority(UseCaseConfig r100, int r101) {
            return ((Integer) r100.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(r101))).intValue();
        }

        public static Range $default$getTargetFrameRate(UseCaseConfig r100, Range r101) {
            return (Range) r100.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, r101);
        }

        public static boolean $default$isHighResolutionDisabled(UseCaseConfig r100, boolean r101) {
            return ((Boolean) r100.retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(r101))).booleanValue();
        }

        public static boolean $default$isZslDisabled(UseCaseConfig r100, boolean r101) {
            return ((Boolean) r100.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(r101))).booleanValue();
        }
    }

    public interface Builder<T extends UseCase, C extends UseCaseConfig<T>, B> extends TargetConfig.Builder<T, B>, ExtendableBuilder<T> {
        C getUseCaseConfig();

        B setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r100);

        B setCaptureType(UseCaseConfigFactory.CaptureType r100);

        B setDefaultCaptureConfig(CaptureConfig r100);

        B setDefaultSessionConfig(SessionConfig r100);

        B setHighResolutionDisabled(boolean r100);

        B setSessionOptionUnpacker(SessionConfig.OptionUnpacker r100);

        B setSurfaceOccupancyPriority(int r100);

        B setZslDisabled(boolean r100);
    }

    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker();

    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r100);

    UseCaseConfigFactory.CaptureType getCaptureType();

    CaptureConfig getDefaultCaptureConfig();

    CaptureConfig getDefaultCaptureConfig(CaptureConfig r100);

    SessionConfig getDefaultSessionConfig();

    SessionConfig getDefaultSessionConfig(SessionConfig r100);

    int getPreviewStabilizationMode();

    SessionConfig.OptionUnpacker getSessionOptionUnpacker();

    SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker r100);

    int getSurfaceOccupancyPriority();

    int getSurfaceOccupancyPriority(int r100);

    Range<Integer> getTargetFrameRate();

    Range<Integer> getTargetFrameRate(Range<Integer> r100);

    int getVideoStabilizationMode();

    boolean isHighResolutionDisabled(boolean r100);

    boolean isZslDisabled(boolean r100);

    static {
        OPTION_DEFAULT_SESSION_CONFIG = Config.Option.create("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
        OPTION_DEFAULT_CAPTURE_CONFIG = Config.Option.create("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
        OPTION_SESSION_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);
        OPTION_CAPTURE_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);
        Class r100 = Integer.TYPE;
        OPTION_SURFACE_OCCUPANCY_PRIORITY = Config.Option.create("camerax.core.useCase.surfaceOccupancyPriority", r100);
        OPTION_TARGET_FRAME_RATE = Config.Option.create("camerax.core.useCase.targetFrameRate", Range.class);
        Class r101 = Boolean.TYPE;
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.useCase.zslDisabled", r101);
        OPTION_HIGH_RESOLUTION_DISABLED = Config.Option.create("camerax.core.useCase.highResolutionDisabled", r101);
        OPTION_CAPTURE_TYPE = Config.Option.create("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
        OPTION_PREVIEW_STABILIZATION_MODE = Config.Option.create("camerax.core.useCase.previewStabilizationMode", r100);
        OPTION_VIDEO_STABILIZATION_MODE = Config.Option.create("camerax.core.useCase.videoStabilizationMode", r100);
    }
}
