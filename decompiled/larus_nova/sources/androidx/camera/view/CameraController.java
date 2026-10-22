package androidx.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.video.AudioConfig;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final ImageCapture.ScreenFlash NO_OP_SCREEN_FLASH = null;
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached to CameraController.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_FOCUSED = 2;
    public static final int TAP_TO_FOCUS_NOT_FOCUSED = 3;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private static final String VIDEO_RECORDING_UNFINISHED = "Recording video. Only one recording can be active at a time.";
    Recording mActiveRecording;
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisBackgroundExecutor;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    Camera mCamera;
    ProcessCameraProviderWrapper mCameraProvider;
    CameraSelector mCameraSelector;
    final RotationProvider.Listener mDeviceRotationListener;
    private final Set<CameraEffect> mEffects;
    private int mEnabledUseCases;
    ImageAnalysis mImageAnalysis;
    ResolutionSelector mImageAnalysisResolutionSelector;
    OutputSize mImageAnalysisTargetSize;
    ImageCapture mImageCapture;
    Executor mImageCaptureIoExecutor;
    ResolutionSelector mImageCaptureResolutionSelector;
    OutputSize mImageCaptureTargetSize;
    private final ListenableFuture<Void> mInitializationFuture;
    private final PendingValue<Boolean> mPendingEnableTorch;
    private final PendingValue<Float> mPendingLinearZoom;
    private final PendingValue<Float> mPendingZoomRatio;
    private boolean mPinchToZoomEnabled;
    Preview mPreview;
    private DynamicRange mPreviewDynamicRange;
    ResolutionSelector mPreviewResolutionSelector;
    OutputSize mPreviewTargetSize;
    Map<Consumer<VideoRecordEvent>, Recording> mRecordingMap;
    private final RotationProvider mRotationProvider;
    private final Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> mScreenFlashUiInfoMap;
    Preview.SurfaceProvider mSurfaceProvider;
    private boolean mTapToFocusEnabled;
    final MutableLiveData<Integer> mTapToFocusState;
    private final ForwardingLiveData<Integer> mTorchState;
    VideoCapture<Recorder> mVideoCapture;
    private DynamicRange mVideoCaptureDynamicRange;
    private int mVideoCaptureMirrorMode;
    QualitySelector mVideoCaptureQualitySelector;
    private Range<Integer> mVideoCaptureTargetFrameRate;
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState;

    /* JADX INFO: renamed from: androidx.camera.view.CameraController$2, reason: invalid class name */
    public class AnonymousClass2 implements Consumer<VideoRecordEvent> {
        final /* synthetic */ CameraController this$0;
        final /* synthetic */ Consumer val$listener;
        final /* synthetic */ Executor val$mainExecutor;

        public static /* synthetic */ void a(AnonymousClass2 r100) {
            r100.lambda$accept$0();
        }

        private /* synthetic */ void lambda$accept$0() {
            this.this$0.deactivateRecordingByListener(this);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(VideoRecordEvent r100) {
            if ((r100 instanceof VideoRecordEvent.Finalize) == true) goto L5;
        L8:
            this.val$listener.accept(r100);
            return;
        L5:
            if (Threads.isMainThread() == true) goto L7;
            this.val$mainExecutor.execute(new i(this));
            goto L8
        L7:
            this.this$0.deactivateRecordingByListener(this);
            goto L8
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(VideoRecordEvent r100) {
            accept2(r100);
        }

        public AnonymousClass2(CameraController r100, Executor r101, Consumer r102) {
            this.this$0 = r100;
            this.val$mainExecutor = r101;
            this.val$listener = r102;
        }
    }

    public static final class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;
        private final Size mResolution;

        @Retention(RetentionPolicy.SOURCE)
        public @interface OutputAspectRatio {
        }

        public String toString() {
            return "aspect ratio: " + this.mAspectRatio + " resolution: " + this.mResolution;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        public Size getResolution() {
            return this.mResolution;
        }

        public OutputSize(int r100) {
            if (r100 == (-1)) goto L5;
            boolean r101 = true;
        L6:
            Preconditions.checkArgument(r101);
            this.mAspectRatio = r100;
            this.mResolution = null;
            return;
        L5:
            r101 = false;
            goto L6
        }

        public OutputSize(Size r100) {
            Preconditions.checkNotNull(r100);
            this.mAspectRatio = -1;
            this.mResolution = r100;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UseCases {
    }

    public static /* synthetic */ void a(CameraController r100, int r101) {
        r100.lambda$new$1(r101);
    }

    public static /* synthetic */ void b(CameraController r100, int r101) {
        r100.lambda$setEnabledUseCases$2(r101);
    }

    public static /* synthetic */ void c(CameraController r100, CameraSelector r101) {
        r100.lambda$setCameraSelector$3(r101);
    }

    public static /* synthetic */ Void d(CameraController r100, ProcessCameraProviderWrapper r101) {
        return r100.lambda$new$0(r101);
    }

    private float speedUpZoomBy2X(float r100) {
        if (r100 <= 1.0f) goto L7;
        return ((r100 - 1.0f) * 2.0f) + 1.0f;
    L7:
        return 1.0f - ((1.0f - r100) * 2.0f);
    }

    public abstract Camera startCamera();

    public void startCameraAndTrackStates() {
        startCameraAndTrackStates(null);
    }

    static {
        NO_OP_SCREEN_FLASH = new AnonymousClass1();
    }

    private void checkAudioPermissionGranted() {
        if (PermissionChecker.checkSelfPermission(this.mAppContext, "android.permission.RECORD_AUDIO") == (-1)) goto L6;
        return;
    L6:
        throw new SecurityException("Attempted to start recording with audio, but application does not have RECORD_AUDIO permission granted.");
    }

    private Preview createPreview() {
        Preview.Builder r100 = new Preview.Builder();
        configureResolution(r100, this.mPreviewResolutionSelector, this.mPreviewTargetSize);
        r100.setDynamicRange(this.mPreviewDynamicRange);
        return r100.build();
    }

    private VideoCapture<Recorder> createVideoCapture() {
        Recorder.Builder r100 = new Recorder.Builder().setQualitySelector(this.mVideoCaptureQualitySelector);
        ViewPort r101 = this.mViewPort;
        if (r101 == null) goto L10;
        if (this.mVideoCaptureQualitySelector != Recorder.DEFAULT_QUALITY_SELECTOR) goto L10;
        int r102 = getViewportAspectRatioInt(r101);
        if (r102 == (-1)) goto L10;
        r100.setAspectRatio(r102);
    L10:
        return new VideoCapture.Builder(r100.build()).setTargetFrameRate(this.mVideoCaptureTargetFrameRate).setMirrorMode(this.mVideoCaptureMirrorMode).setDynamicRange(this.mVideoCaptureDynamicRange).build();
    }

    private boolean isCameraAttached() {
        if (this.mCamera == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCameraInitialized() {
        if (this.mCameraProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isPreviewViewAttached() {
        if (this.mSurfaceProvider != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mViewPort == null) goto L7;
        return true;
    }

    private void startListeningToRotationEvents() {
        this.mRotationProvider.addListener(CameraXExecutors.mainThreadExecutor(), this.mDeviceRotationListener);
    }

    private void stopListeningToRotationEvents() {
        this.mRotationProvider.removeListener(this.mDeviceRotationListener);
    }

    public ScreenFlashUiInfo getScreenFlashUiInfoByPriority() {
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> r100 = this.mScreenFlashUiInfoMap;
        ScreenFlashUiInfo.ProviderType r101 = ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW;
        if (r100.get(r101) != null) goto L5;
        Map<ScreenFlashUiInfo.ProviderType, ScreenFlashUiInfo> r102 = this.mScreenFlashUiInfoMap;
        ScreenFlashUiInfo.ProviderType r103 = ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW;
        if (r102.get(r103) != null) goto L9;
        return null;
    L9:
        return this.mScreenFlashUiInfoMap.get(r103);
    L5:
        return this.mScreenFlashUiInfoMap.get(r101);
    }

    private void stopRecording() {
        Threads.checkMainThread();
        Recording r100 = this.mActiveRecording;
        if (r100 == null) goto L6;
        r100.stop();
        deactivateRecording(this.mActiveRecording);
        return;
    }

    private void throwExceptionForInvalidScreenFlashCapture() {
        if (getImageCaptureFlashMode() == 3) goto L5;
        return;
    L5:
        if (getScreenFlashUiInfoByPriority() == null) goto L10;
        if (getScreenFlashUiInfoByPriority().getScreenFlash() == null) goto L10;
        return;
    L10:
        throw new IllegalStateException("No window set in PreviewView despite setting FLASH_MODE_SCREEN");
    }

    private void unbindAllAndRecreate() {
        unbindPreviewAndRecreate();
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        unbindVideoAndRecreate();
    }

    private void unbindPreviewAndRecreate() {
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mPreview});
    L5:
        this.mPreview = createPreview();
        if (this.mSurfaceProvider == null) goto L9;
        this.mPreview.setSurfaceProvider(this.mSurfaceProvider);
        return;
    }

    private void unbindVideoAndRecreate() {
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mVideoCapture});
    L5:
        this.mVideoCapture = createVideoCapture();
    }

    public void clearEffects() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper r100 = this.mCameraProvider;
        if (r100 == null) goto L5;
        r100.unbindAll();
    L5:
        this.mEffects.clear();
        startCameraAndTrackStates();
    }

    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer r100 = this.mAnalysisAnalyzer;
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
        restartCameraIfAnalyzerResolutionChanged(r100, null);
    }

    public void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper r100 = this.mCameraProvider;
        if (r100 == null) goto L5;
        r100.unbind(new UseCase[]{this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture});
    L5:
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        stopListeningToRotationEvents();
    }

    public UseCaseGroup createUseCaseGroup() {
        if (isCameraInitialized() == true) goto L7;
        Logger.d(TAG, CAMERA_NOT_INITIALIZED);
        return null;
    L7:
        if (isPreviewViewAttached() == true) goto L10;
        Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
        return null;
    L10:
        UseCaseGroup.Builder r100 = new UseCaseGroup.Builder().addUseCase(this.mPreview);
        if (isImageCaptureEnabled() == false) goto L13;
        r100.addUseCase(this.mImageCapture);
    L15:
        if (isImageAnalysisEnabled() == false) goto L17;
        r100.addUseCase(this.mImageAnalysis);
    L19:
        if (isVideoCaptureEnabled() == false) goto L21;
        r100.addUseCase(this.mVideoCapture);
    L22:
        r100.setViewPort(this.mViewPort);
        Iterator<CameraEffect> r101 = this.mEffects.iterator();
    L24:
        if (r101.hasNext() == false) goto L27;
        r100.addEffect(r101.next());
        goto L24
    L27:
        return r100.build();
    L21:
        this.mCameraProvider.unbind(new UseCase[]{this.mVideoCapture});
        goto L22
    L17:
        this.mCameraProvider.unbind(new UseCase[]{this.mImageAnalysis});
        goto L19
    L13:
        this.mCameraProvider.unbind(new UseCase[]{this.mImageCapture});
        goto L15
    }

    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera r100 = this.mCamera;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getCameraControl();
    }

    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera r100 = this.mCamera;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getCameraInfo();
    }

    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mAnalysisBackgroundExecutor;
    }

    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    public int getImageAnalysisOutputImageFormat() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getOutputImageFormat();
    }

    public ResolutionSelector getImageAnalysisResolutionSelector() {
        Threads.checkMainThread();
        return this.mImageAnalysisResolutionSelector;
    }

    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        return this.mImageAnalysisTargetSize;
    }

    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mImageCaptureIoExecutor;
    }

    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    public ResolutionSelector getImageCaptureResolutionSelector() {
        Threads.checkMainThread();
        return this.mImageCaptureResolutionSelector;
    }

    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mImageCaptureTargetSize;
    }

    public DynamicRange getPreviewDynamicRange() {
        Threads.checkMainThread();
        return this.mPreviewDynamicRange;
    }

    public ResolutionSelector getPreviewResolutionSelector() {
        Threads.checkMainThread();
        return this.mPreviewResolutionSelector;
    }

    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        return this.mPreviewTargetSize;
    }

    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    public DynamicRange getVideoCaptureDynamicRange() {
        Threads.checkMainThread();
        return this.mVideoCaptureDynamicRange;
    }

    public int getVideoCaptureMirrorMode() {
        Threads.checkMainThread();
        return this.mVideoCaptureMirrorMode;
    }

    public QualitySelector getVideoCaptureQualitySelector() {
        Threads.checkMainThread();
        return this.mVideoCaptureQualitySelector;
    }

    public Range<Integer> getVideoCaptureTargetFrameRate() {
        Threads.checkMainThread();
        return this.mVideoCaptureTargetFrameRate;
    }

    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    public boolean isRecording() {
        Threads.checkMainThread();
        Recording r100 = this.mActiveRecording;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isClosed() == true) goto L7;
        return true;
    }

    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    public void updateScreenFlashToImageCapture() {
        ScreenFlashUiInfo r100 = getScreenFlashUiInfoByPriority();
        if (r100 != null) goto L6;
        Logger.d(TAG, "No ScreenFlash instance set yet, need to wait for controller to be set to either ScreenFlashView or PreviewView");
        this.mImageCapture.setScreenFlash(NO_OP_SCREEN_FLASH);
        return;
    L6:
        this.mImageCapture.setScreenFlash(r100.getScreenFlash());
        Logger.d(TAG, "Set ScreenFlash instance to ImageCapture, provided by " + r100.getProviderType().name());
    }

    public ListenableFuture<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    public CameraController(Context r100) {
        this(r100, Futures.transform(ProcessCameraProvider.getInstance(r100), new b(), CameraXExecutors.directExecutor()));
    }

    private ImageCapture createImageCapture(Integer r100) {
        ImageCapture.Builder r101 = new ImageCapture.Builder();
        if (r100 == null) goto L5;
        r101.setCaptureMode(r100.intValue());
    L5:
        configureResolution(r101, this.mImageCaptureResolutionSelector, this.mImageCaptureTargetSize);
        Executor r102 = this.mImageCaptureIoExecutor;
        if (r102 == null) goto L9;
        r101.setIoExecutor(r102);
    L9:
        return r101.build();
    }

    private void deactivateRecording(Recording r100) {
        if (this.mActiveRecording != r100) goto L6;
        this.mActiveRecording = null;
        return;
    }

    private int getViewportAspectRatioInt(ViewPort r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        ProcessCameraProviderWrapper r102 = this.mCameraProvider;
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        ProcessCameraProviderWrapper r104 = this.mCameraProvider;
        if (r104 != null) goto L14;
    L12:
        boolean r105 = true;
    L17:
        int r106 = CameraOrientationUtil.getRelativeImageRotation(r101, r103, r105);
        Rational r107 = r100.getAspectRatio();
        if (r106 != 90) goto L20;
    L21:
        r107 = new Rational(r107.getDenominator(), r107.getNumerator());
    L23:
        if (r107.equals(new Rational(4, 3)) == false) goto L26;
        return 0;
    L26:
        if (r107.equals(new Rational(16, 9)) == false) goto L28;
        return 1;
    L28:
        return -1;
    L20:
        if (r106 != 270) goto L23;
    L14:
        if (r104.getCameraInfo(this.mCameraSelector).getLensFacing() == 1) goto L12;
        r105 = false;
        goto L17
    L9:
        r103 = r102.getCameraInfo(this.mCameraSelector).getSensorRotationDegrees();
        goto L10
    L5:
        r101 = CameraOrientationUtil.surfaceRotationToDegrees(r100.getRotation());
        goto L6
    }

    private AspectRatioStrategy getViewportAspectRatioStrategy(ViewPort r100) {
        int r101 = getViewportAspectRatioInt(r100);
        if (r101 != (-1)) goto L5;
        return null;
    L5:
        return new AspectRatioStrategy(r101, 1);
    }

    private boolean isUseCaseEnabled(int r100) {
        if ((r100 & this.mEnabledUseCases) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ Void lambda$new$0(ProcessCameraProviderWrapper r100) {
        this.mCameraProvider = r100;
        unbindAllAndRecreate();
        startCameraAndTrackStates();
        return null;
    }

    private /* synthetic */ void lambda$new$1(int r100) {
        this.mImageAnalysis.setTargetRotation(r100);
        this.mImageCapture.setTargetRotation(r100);
        this.mVideoCapture.setTargetRotation(r100);
    }

    private /* synthetic */ void lambda$setCameraSelector$3(CameraSelector r100) {
        this.mCameraSelector = r100;
    }

    private /* synthetic */ void lambda$setEnabledUseCases$2(int r100) {
        this.mEnabledUseCases = r100;
    }

    private PendingRecording prepareRecording(OutputOptions r100) {
        Recorder r101 = (Recorder) this.mVideoCapture.getOutput();
        if ((r100 instanceof FileOutputOptions) == false) goto L7;
        return r101.prepareRecording(this.mAppContext, (FileOutputOptions) r100);
    L7:
        if ((r100 instanceof FileDescriptorOutputOptions) == false) goto L15;
        if (Build.VERSION.SDK_INT < 26) goto L13;
        return r101.prepareRecording(this.mAppContext, (FileDescriptorOutputOptions) r100);
    L13:
        throw new UnsupportedOperationException("File descriptors are not supported on pre-Android O (API 26) devices.");
    L15:
        if ((r100 instanceof MediaStoreOutputOptions) == false) goto L19;
        return r101.prepareRecording(this.mAppContext, (MediaStoreOutputOptions) r100);
    L19:
        throw new IllegalArgumentException("Unsupported OutputOptions type.");
    }

    private void unbindImageCaptureAndRecreate(Integer r100) {
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mImageCapture});
    L5:
        int r101 = this.mImageCapture.getFlashMode();
        this.mImageCapture = createImageCapture(r100);
        setImageCaptureFlashMode(r101);
    }

    private Consumer<VideoRecordEvent> wrapListenerToDeactivateRecordingOnFinalized(Consumer<VideoRecordEvent> r100) {
        return new AnonymousClass2(this, ContextCompat.getMainExecutor(this.mAppContext), r100);
    }

    public void deactivateRecordingByListener(Consumer<VideoRecordEvent> r100) {
        Recording r101 = this.mRecordingMap.remove(r100);
        if (r101 == null) goto L6;
        deactivateRecording(r101);
        return;
    }

    public ListenableFuture<Void> enableTorch(boolean r100) {
        Threads.checkMainThread();
        if (isCameraAttached() == true) goto L7;
        return this.mPendingEnableTorch.setValue(Boolean.valueOf(r100));
    L7:
        return this.mCamera.getCameraControl().enableTorch(r100);
    }

    public boolean hasCamera(CameraSelector r100) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(r100);
        ProcessCameraProviderWrapper r101 = this.mCameraProvider;
        if (r101 == null) goto L10;
        return r101.hasCamera(r100);
    L6:
        e = move-exception;
        Logger.w(TAG, "Failed to check camera availability", e);
        return false;
    L10:
        throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
    }

    public void onPinchToZoom(float r100) {
        if (isCameraAttached() == true) goto L7;
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return;
    L7:
        if (this.mPinchToZoomEnabled == true) goto L10;
        Logger.d(TAG, "Pinch to zoom disabled.");
        return;
    L10:
        Logger.d(TAG, "Pinch to zoom with scale: " + r100);
        ZoomState r101 = getZoomState().getValue();
        if (r101 != null) goto L13;
        return;
    L13:
        setZoomRatio(Math.min(Math.max(r101.getZoomRatio() * speedUpZoomBy2X(r100), r101.getMinZoomRatio()), r101.getMaxZoomRatio()));
    }

    public void setCameraSelector(CameraSelector r100) {
        Threads.checkMainThread();
        if (this.mCameraSelector != r100) goto L5;
        return;
    L5:
        Integer r101 = r100.getLensFacing();
        if (this.mImageCapture.getFlashMode() != 3) goto L13;
        if (r101 == null) goto L13;
        if (r101.intValue() == 0) goto L13;
        throw new IllegalStateException("Not a front camera despite setting FLASH_MODE_SCREEN");
    L13:
        final CameraSelector r102 = this.mCameraSelector;
        this.mCameraSelector = r100;
        ProcessCameraProviderWrapper r103 = this.mCameraProvider;
        if (r103 != null) goto L16;
        return;
    L16:
        r103.unbind(new UseCase[]{this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture});
        startCameraAndTrackStates(new a(this, r102));
    }

    public void setEffects(Set<CameraEffect> r100) {
        Threads.checkMainThread();
        if (Objects.equals(this.mEffects, r100) == false) goto L5;
        return;
    L5:
        ProcessCameraProviderWrapper r101 = this.mCameraProvider;
        if (r101 == null) goto L8;
        r101.unbindAll();
    L8:
        this.mEffects.clear();
        this.mEffects.addAll(r100);
        startCameraAndTrackStates();
    }

    public void setEnabledUseCases(int r100) {
        Threads.checkMainThread();
        final int r101 = this.mEnabledUseCases;
        if (r100 != r101) goto L5;
        return;
    L5:
        this.mEnabledUseCases = r100;
        if (isVideoCaptureEnabled() == false) goto L8;
    L10:
        startCameraAndTrackStates(new h(this, r101));
        return;
    L8:
        if (isRecording() == false) goto L10;
        stopRecording();
        goto L10
    }

    public void setImageAnalysisBackgroundExecutor(Executor r100) {
        Threads.checkMainThread();
        if (this.mAnalysisBackgroundExecutor != r100) goto L5;
        return;
    L5:
        this.mAnalysisBackgroundExecutor = r100;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisBackpressureStrategy(int r100) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() != r100) goto L5;
        return;
    L5:
        unbindImageAnalysisAndRecreate(Integer.valueOf(r100), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisImageQueueDepth(int r100) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() != r100) goto L5;
        return;
    L5:
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(r100), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisOutputImageFormat(int r100) {
        Threads.checkMainThread();
        if (r100 != this.mImageAnalysis.getOutputImageFormat()) goto L5;
        return;
    L5:
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(r100));
    }

    public void setImageAnalysisResolutionSelector(ResolutionSelector r100) {
        Threads.checkMainThread();
        if (this.mImageAnalysisResolutionSelector != r100) goto L5;
        return;
    L5:
        this.mImageAnalysisResolutionSelector = r100;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageAnalysisTargetSize(OutputSize r100) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageAnalysisTargetSize, r100) == false) goto L5;
        return;
    L5:
        this.mImageAnalysisTargetSize = r100;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
    }

    public void setImageCaptureFlashMode(int r100) {
        Threads.checkMainThread();
        if (r100 != 3) goto L12;
        Integer r101 = this.mCameraSelector.getLensFacing();
        if (r101 != null) goto L7;
    L11:
        updateScreenFlashToImageCapture();
        goto L12
    L7:
        if (r101.intValue() == 0) goto L11;
        throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
    L12:
        this.mImageCapture.setFlashMode(r100);
    }

    public void setImageCaptureIoExecutor(Executor r100) {
        Threads.checkMainThread();
        if (this.mImageCaptureIoExecutor != r100) goto L5;
        return;
    L5:
        this.mImageCaptureIoExecutor = r100;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    public void setImageCaptureMode(int r100) {
        Threads.checkMainThread();
        if (this.mImageCapture.getCaptureMode() != r100) goto L5;
        return;
    L5:
        unbindImageCaptureAndRecreate(Integer.valueOf(r100));
        startCameraAndTrackStates();
    }

    public void setImageCaptureResolutionSelector(ResolutionSelector r100) {
        Threads.checkMainThread();
        if (this.mImageCaptureResolutionSelector != r100) goto L5;
        return;
    L5:
        this.mImageCaptureResolutionSelector = r100;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    public void setImageCaptureTargetSize(OutputSize r100) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageCaptureTargetSize, r100) == false) goto L5;
        return;
    L5:
        this.mImageCaptureTargetSize = r100;
        unbindImageCaptureAndRecreate(Integer.valueOf(getImageCaptureMode()));
        startCameraAndTrackStates();
    }

    public ListenableFuture<Void> setLinearZoom(float r100) {
        Threads.checkMainThread();
        if (isCameraAttached() == true) goto L7;
        return this.mPendingLinearZoom.setValue(Float.valueOf(r100));
    L7:
        return this.mCamera.getCameraControl().setLinearZoom(r100);
    }

    public void setPinchToZoomEnabled(boolean r100) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = r100;
    }

    public void setPreviewDynamicRange(DynamicRange r100) {
        Threads.checkMainThread();
        this.mPreviewDynamicRange = r100;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    public void setPreviewResolutionSelector(ResolutionSelector r100) {
        Threads.checkMainThread();
        if (this.mPreviewResolutionSelector != r100) goto L5;
        return;
    L5:
        this.mPreviewResolutionSelector = r100;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    public void setPreviewTargetSize(OutputSize r100) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mPreviewTargetSize, r100) == false) goto L5;
        return;
    L5:
        this.mPreviewTargetSize = r100;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    public void setScreenFlashUiInfo(ScreenFlashUiInfo r100) {
        ScreenFlashUiInfo r101 = getScreenFlashUiInfoByPriority();
        this.mScreenFlashUiInfoMap.put(r100.getProviderType(), r100);
        ScreenFlashUiInfo r102 = getScreenFlashUiInfoByPriority();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.equals(r101) == true) goto L9;
        updateScreenFlashToImageCapture();
        return;
    }

    public void setTapToFocusEnabled(boolean r100) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = r100;
    }

    public void setVideoCaptureDynamicRange(DynamicRange r100) {
        Threads.checkMainThread();
        this.mVideoCaptureDynamicRange = r100;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public void setVideoCaptureMirrorMode(int r100) {
        Threads.checkMainThread();
        this.mVideoCaptureMirrorMode = r100;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public void setVideoCaptureQualitySelector(QualitySelector r100) {
        Threads.checkMainThread();
        this.mVideoCaptureQualitySelector = r100;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public void setVideoCaptureTargetFrameRate(Range<Integer> r100) {
        Threads.checkMainThread();
        this.mVideoCaptureTargetFrameRate = r100;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    public ListenableFuture<Void> setZoomRatio(float r100) {
        Threads.checkMainThread();
        if (isCameraAttached() == true) goto L7;
        return this.mPendingZoomRatio.setValue(Float.valueOf(r100));
    L7:
        return this.mCamera.getCameraControl().setZoomRatio(r100);
    }

    public void startCameraAndTrackStates(Runnable r100) {
        this.mCamera = startCamera();     // Catch: RuntimeException -> L9
        if (isCameraAttached() == true) goto L7;
        Logger.d(TAG, CAMERA_NOT_ATTACHED);
        return;
    L7:
        this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
        this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
        this.mPendingEnableTorch.propagateIfHasValue(new e(this));
        this.mPendingLinearZoom.propagateIfHasValue(new f(this));
        this.mPendingZoomRatio.propagateIfHasValue(new g(this));
        return;
    L9:
        e = move-exception;
        if (r100 == null) goto L12;
        r100.run();
    L12:
        throw e;
    }

    public void updateMirroringFlagInOutputFileOptions(ImageCapture.OutputFileOptions r100) {
        if (this.mCameraSelector.getLensFacing() != null) goto L5;
        return;
    L5:
        if (r100.getMetadata().isReversedHorizontalSet() == true) goto L13;
        ImageCapture.Metadata r101 = r100.getMetadata();
        if (this.mCameraSelector.getLensFacing().intValue() != 0) goto L9;
        boolean r102 = true;
    L10:
        r101.setReversedHorizontal(r102);
        return;
    L9:
        r102 = false;
        goto L10
    }

    public void updatePreviewViewTransform(Matrix r100) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer r101 = this.mAnalysisAnalyzer;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getTargetCoordinateSystem() != 1) goto L9;
        this.mAnalysisAnalyzer.updateTransform(r100);
        return;
    }

    public CameraController(Context r100, ListenableFuture<ProcessCameraProviderWrapper> r101) {
        this.mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        this.mEnabledUseCases = 3;
        this.mActiveRecording = null;
        this.mRecordingMap = new HashMap();
        this.mVideoCaptureQualitySelector = Recorder.DEFAULT_QUALITY_SELECTOR;
        this.mVideoCaptureMirrorMode = 0;
        DynamicRange r102 = DynamicRange.UNSPECIFIED;
        this.mVideoCaptureDynamicRange = r102;
        this.mPreviewDynamicRange = r102;
        this.mVideoCaptureTargetFrameRate = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        this.mPinchToZoomEnabled = true;
        this.mTapToFocusEnabled = true;
        this.mZoomState = new ForwardingLiveData();
        this.mTorchState = new ForwardingLiveData();
        this.mTapToFocusState = new MutableLiveData(0);
        this.mPendingEnableTorch = new PendingValue();
        this.mPendingLinearZoom = new PendingValue();
        this.mPendingZoomRatio = new PendingValue();
        this.mEffects = new HashSet();
        this.mScreenFlashUiInfoMap = new HashMap();
        Context r103 = ContextUtil.getApplicationContext(r100);
        this.mAppContext = r103;
        this.mPreview = createPreview();
        this.mImageCapture = createImageCapture(null);
        this.mImageAnalysis = createImageAnalysis(null, null, null);
        this.mVideoCapture = createVideoCapture();
        this.mInitializationFuture = Futures.transform(r101, new c(this), CameraXExecutors.mainThreadExecutor());
        this.mRotationProvider = new RotationProvider(r103);
        this.mDeviceRotationListener = new d(this);
    }

    private boolean isOutputSizeEqual(OutputSize r100, OutputSize r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if (r100.equals(r101) == false) goto L9;
        return true;
    }

    private void restartCameraIfAnalyzerResolutionChanged(ImageAnalysis.Analyzer r100, ImageAnalysis.Analyzer r101) {
        Size r102 = null;
        if (r100 != null) goto L5;
        Size r103 = null;
    L6:
        if (r101 == null) goto L10;
        r102 = r101.getDefaultTargetResolution();
    L10:
        if (Objects.equals(r103, r102) == true) goto L13;
        unbindImageAnalysisAndRecreate(Integer.valueOf(this.mImageAnalysis.getBackpressureStrategy()), Integer.valueOf(this.mImageAnalysis.getImageQueueDepth()), Integer.valueOf(this.mImageAnalysis.getOutputImageFormat()));
        startCameraAndTrackStates();
        return;
    L13:
        return;
    L5:
        r103 = r100.getDefaultTargetResolution();
        goto L6
    }

    private void setActiveRecording(Recording r100, Consumer<VideoRecordEvent> r101) {
        this.mRecordingMap.put(r101, r100);
        this.mActiveRecording = r100;
    }

    private void setTargetOutputSize(ImageOutputConfig.Builder<?> r100, OutputSize r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getResolution() == null) goto L8;
        r100.setTargetResolution(r101.getResolution());
        return;
    L8:
        if (r101.getAspectRatio() == (-1)) goto L10;
        r100.setTargetAspectRatio(r101.getAspectRatio());
        return;
    L10:
        Logger.e(TAG, "Invalid target surface size. " + r101);
    }

    public void attachPreviewSurface(Preview.SurfaceProvider r100, ViewPort r101) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider == r100) goto L6;
        this.mSurfaceProvider = r100;
        this.mPreview.setSurfaceProvider(r100);
    L6:
        if (this.mViewPort != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        this.mViewPort = r101;
        startListeningToRotationEvents();
        if (r102 == false) goto L15;
        unbindAllAndRecreate();
    L15:
        startCameraAndTrackStates();
        return;
    L8:
        if (getViewportAspectRatioStrategy(r101) != getViewportAspectRatioStrategy(this.mViewPort)) goto L11;
        r102 = false;
        goto L12
    }

    public void setImageAnalysisAnalyzer(Executor r100, ImageAnalysis.Analyzer r101) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer r102 = this.mAnalysisAnalyzer;
        if (r102 == r101) goto L5;
    L7:
        this.mAnalysisExecutor = r100;
        this.mAnalysisAnalyzer = r101;
        this.mImageAnalysis.setAnalyzer(r100, r101);
        restartCameraIfAnalyzerResolutionChanged(r102, r101);
        return;
    L5:
        if (this.mAnalysisExecutor != r100) goto L7;
    }

    public void takePicture(Executor r100, ImageCapture.OnImageCapturedCallback r101) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        this.mImageCapture.takePicture(r100, r101);
    }

    private void configureResolution(ImageOutputConfig.Builder<?> r100, ResolutionSelector r101, OutputSize r102) {
        if (r101 == null) goto L4;
        r100.setResolutionSelector(r101);
        return;
    L4:
        if (r102 == null) goto L6;
        setTargetOutputSize(r100, r102);
        return;
    L6:
        ViewPort r103 = this.mViewPort;
        if (r103 == null) goto L14;
        AspectRatioStrategy r104 = getViewportAspectRatioStrategy(r103);
        if (r104 == null) goto L15;
        r100.setResolutionSelector(new ResolutionSelector.Builder().setAspectRatioStrategy(r104).build());
        return;
    L15:
        return;
    }

    private ImageAnalysis createImageAnalysis(Integer r100, Integer r101, Integer r102) {
        ImageAnalysis.Builder r103 = new ImageAnalysis.Builder();
        if (r100 == null) goto L5;
        r103.setBackpressureStrategy(r100.intValue());
    L5:
        if (r101 == null) goto L7;
        r103.setImageQueueDepth(r101.intValue());
    L7:
        if (r102 == null) goto L9;
        r103.setOutputImageFormat(r102.intValue());
    L9:
        configureResolution(r103, this.mImageAnalysisResolutionSelector, this.mImageAnalysisTargetSize);
        Executor r104 = this.mAnalysisBackgroundExecutor;
        if (r104 == null) goto L13;
        r103.setBackgroundExecutor(r104);
    L13:
        return r103.build();
    }

    private void unbindImageAnalysisAndRecreate(Integer r100, Integer r101, Integer r102) {
        Threads.checkMainThread();
        if (isCameraInitialized() == false) goto L5;
        this.mCameraProvider.unbind(new UseCase[]{this.mImageAnalysis});
    L5:
        ImageAnalysis r103 = createImageAnalysis(r100, r101, r102);
        this.mImageAnalysis = r103;
        Executor r104 = this.mAnalysisExecutor;
        if (r104 == null) goto L11;
        ImageAnalysis.Analyzer r105 = this.mAnalysisAnalyzer;
        if (r105 == null) goto L12;
        r103.setAnalyzer(r104, r105);
        return;
    L12:
        return;
    }

    public void onTapToFocus(MeteringPointFactory r100, float r101, float r102) {
        if (isCameraAttached() == true) goto L7;
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return;
    L7:
        if (this.mTapToFocusEnabled == true) goto L10;
        Logger.d(TAG, "Tap to focus disabled. ");
        return;
    L10:
        Logger.d(TAG, "Tap to focus started: " + r101 + ", " + r102);
        this.mTapToFocusState.postValue(1);
        MeteringPoint r103 = r100.createPoint(r101, r102, AF_SIZE);
        Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(r103, 1).addPoint(r100.createPoint(r101, r102, 0.25f), 2).build()), new AnonymousClass3(this), CameraXExecutors.directExecutor());
    }

    public void takePicture(ImageCapture.OutputFileOptions r100, Executor r101, ImageCapture.OnImageSavedCallback r102) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        throwExceptionForInvalidScreenFlashCapture();
        updateMirroringFlagInOutputFileOptions(r100);
        this.mImageCapture.takePicture(r100, r101, r102);
    }

    private Recording startRecordingInternal(OutputOptions r100, AudioConfig r101, Executor r102, Consumer<VideoRecordEvent> r103) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        Preconditions.checkState(!isRecording(), VIDEO_RECORDING_UNFINISHED);
        Consumer<VideoRecordEvent> r104 = wrapListenerToDeactivateRecordingOnFinalized(r103);
        PendingRecording r105 = prepareRecording(r100);
        if (r101.getAudioEnabled() == false) goto L5;
        checkAudioPermissionGranted();
        r105.withAudioEnabled();
    L5:
        Recording r106 = r105.start(r102, r104);
        setActiveRecording(r106, r104);
        return r106;
    }

    public Recording startRecording(FileDescriptorOutputOptions r100, AudioConfig r101, Executor r102, Consumer<VideoRecordEvent> r103) {
        return startRecordingInternal(r100, r101, r102, r103);
    }

    public Recording startRecording(FileOutputOptions r100, AudioConfig r101, Executor r102, Consumer<VideoRecordEvent> r103) {
        return startRecordingInternal(r100, r101, r102, r103);
    }

    public Recording startRecording(MediaStoreOutputOptions r100, AudioConfig r101, Executor r102, Consumer<VideoRecordEvent> r103) {
        return startRecordingInternal(r100, r101, r102, r103);
    }
}
