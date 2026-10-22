package androidx.camera.core;

import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;
    public static final int OUTPUT_OPTION_ONE_FOR_ALL_TARGETS = 0;
    public static final int OUTPUT_OPTION_ONE_FOR_EACH_TARGET = 1;
    public static final int PREVIEW = 1;
    private static final List<Integer> SURFACE_PROCESSOR_TARGETS = null;
    public static final int TRANSFORMATION_ARBITRARY = 0;
    public static final int TRANSFORMATION_CAMERA_AND_SURFACE_ROTATION = 1;
    public static final int TRANSFORMATION_PASSTHROUGH = 2;
    public static final int VIDEO_CAPTURE = 2;
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;
    private final int mOutputOption;
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;
    private final int mTransformation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Formats {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Targets {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformations {
    }

    static {
        SURFACE_PROCESSOR_TARGETS = Arrays.asList(new Integer[]{1, 2, 3, 7});
    }

    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        return new SurfaceProcessorWithExecutor(this);
    }

    public Consumer<Throwable> getErrorListener() {
        return this.mErrorListener;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    public int getOutputOption() {
        return this.mOutputOption;
    }

    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public int getTransformation() {
        return this.mTransformation;
    }

    public CameraEffect(int r100, Executor r101, ImageProcessor r102, Consumer<Throwable> r103) {
        if (r100 != 4) goto L5;
        boolean r104 = true;
    L6:
        Preconditions.checkArgument(r104, "Currently ImageProcessor can only target IMAGE_CAPTURE.");
        this.mTargets = r100;
        this.mTransformation = 0;
        this.mOutputOption = 0;
        this.mExecutor = r101;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = r102;
        this.mErrorListener = r103;
        return;
    L5:
        r104 = false;
        goto L6
    }

    public CameraEffect(int r100, Executor r101, SurfaceProcessor r110, Consumer<Throwable> r111) {
        this(r100, 0, 0, r101, r110, r111);
    }

    public CameraEffect(int r100, int r101, Executor r110, SurfaceProcessor r111, Consumer<Throwable> r112) {
        this(r100, 0, r101, r110, r111, r112);
    }

    public CameraEffect(int r100, int r101, int r102, Executor r103, SurfaceProcessor r104, Consumer<Throwable> r105) {
        TargetUtils.checkSupportedTargets(SURFACE_PROCESSOR_TARGETS, r100);
        this.mTargets = r100;
        this.mOutputOption = r101;
        this.mTransformation = r102;
        this.mExecutor = r103;
        this.mSurfaceProcessor = r104;
        this.mImageProcessor = null;
        this.mErrorListener = r105;
    }
}
