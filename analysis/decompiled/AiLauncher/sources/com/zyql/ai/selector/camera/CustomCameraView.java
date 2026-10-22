package com.zyql.ai.selector.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LifecycleOwner;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.camera.view.video.OutputFileResults;
import com.zyql.ai.selector.PictureMediaScannerConnection;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.camera.listener.CameraListener;
import com.zyql.ai.selector.camera.listener.CaptureListener;
import com.zyql.ai.selector.camera.listener.ClickListener;
import com.zyql.ai.selector.camera.listener.ImageCallbackListener;
import com.zyql.ai.selector.camera.listener.TypeListener;
import com.zyql.ai.selector.camera.view.CaptureLayout;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import com.zyql.ai.selector.tools.AndroidQTransformUtils;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.StringUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class CustomCameraView extends RelativeLayout {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int DEFAULT_MIN_RECORD_VIDEO = 1500;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    private LifecycleCameraController mCameraController;
    private CameraListener mCameraListener;
    private PreviewView mCameraPreviewView;
    private CaptureLayout mCaptureLayout;
    private PictureSelectionConfig mConfig;
    private ImageView mFlashLamp;
    private ImageCallbackListener mImageCallbackListener;
    private ImageView mImagePreview;
    private MediaPlayer mMediaPlayer;
    private ClickListener mOnClickListener;
    private File mOutMediaFile;
    private ImageView mSwitchCamera;
    private TextureView mTextureView;
    private long recordTime;
    private final TextureView.SurfaceTextureListener surfaceTextureListener;
    private int type_flash;

    public static class MyImageResultCallback implements ImageCapture.OnImageSavedCallback {
        private final WeakReference<CameraListener> mCameraListenerReference;
        private final WeakReference<CaptureLayout> mCaptureLayoutReference;
        private final WeakReference<File> mFileReference;
        private final WeakReference<ImageCallbackListener> mImageCallbackListenerReference;
        private final WeakReference<ImageView> mImagePreviewReference;

        public MyImageResultCallback(File file, ImageView imageView, CaptureLayout captureLayout, ImageCallbackListener imageCallbackListener, CameraListener cameraListener) {
            this.mFileReference = new WeakReference<>(file);
            this.mImagePreviewReference = new WeakReference<>(imageView);
            this.mCaptureLayoutReference = new WeakReference<>(captureLayout);
            this.mImageCallbackListenerReference = new WeakReference<>(imageCallbackListener);
            this.mCameraListenerReference = new WeakReference<>(cameraListener);
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public /* bridge */ /* synthetic */ void onCaptureProcessProgressed(int i10) {
            super.onCaptureProcessProgressed(i10);
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public /* bridge */ /* synthetic */ void onCaptureStarted() {
            super.onCaptureStarted();
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void onError(ImageCaptureException imageCaptureException) {
            if (this.mCaptureLayoutReference.get() != null) {
                this.mCaptureLayoutReference.get().setButtonCaptureEnabled(true);
            }
            if (this.mCameraListenerReference.get() != null) {
                this.mCameraListenerReference.get().onError(imageCaptureException.a(), imageCaptureException.getMessage(), imageCaptureException.getCause());
            }
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public void onImageSaved(ImageCapture.g gVar) {
            if (this.mCaptureLayoutReference.get() != null) {
                this.mCaptureLayoutReference.get().setButtonCaptureEnabled(true);
            }
            if (this.mImageCallbackListenerReference.get() != null && this.mFileReference.get() != null && this.mImagePreviewReference.get() != null) {
                this.mImageCallbackListenerReference.get().onLoadImage(this.mFileReference.get(), this.mImagePreviewReference.get());
            }
            if (this.mImagePreviewReference.get() != null) {
                this.mImagePreviewReference.get().setVisibility(0);
            }
            if (this.mCaptureLayoutReference.get() != null) {
                this.mCaptureLayoutReference.get().startTypeBtnAnimator();
            }
        }

        @Override // androidx.camera.core.ImageCapture.OnImageSavedCallback
        public /* bridge */ /* synthetic */ void onPostviewBitmapAvailable(Bitmap bitmap) {
            super.onPostviewBitmapAvailable(bitmap);
        }
    }

    public CustomCameraView(Context context) {
        super(context);
        this.type_flash = 35;
        this.recordTime = 0L;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                CustomCameraView customCameraView = CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mOutMediaFile);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initView();
    }

    private Uri getOutUri(int i10) {
        if (i10 == PictureMimeType.ofVideo()) {
            Context context = getContext();
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            return MediaUtils.createVideoUri(context, pictureSelectionConfig.cameraFileName, pictureSelectionConfig.suffixType);
        }
        Context context2 = getContext();
        PictureSelectionConfig pictureSelectionConfig2 = this.mConfig;
        return MediaUtils.createImageUri(context2, pictureSelectionConfig2.cameraFileName, pictureSelectionConfig2.suffixType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        int i10 = this.type_flash + 1;
        this.type_flash = i10;
        if (i10 > 35) {
            this.type_flash = 33;
        }
        setFlashRes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startVideoPlay$1(MediaPlayer mediaPlayer) throws IllegalStateException {
        mediaPlayer.start();
        float videoWidth = (mediaPlayer.getVideoWidth() * 1.0f) / mediaPlayer.getVideoHeight();
        int width = this.mTextureView.getWidth();
        ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
        layoutParams.height = (int) (width / videoWidth);
        this.mTextureView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UnsafeOptInUsageError"})
    public void resetState() {
        if (this.mCameraController.isImageCaptureEnabled()) {
            this.mImagePreview.setVisibility(4);
        } else if (this.mCameraController.isRecording()) {
            this.mCameraController.stopRecording();
        }
        File file = this.mOutMediaFile;
        if (file != null && file.exists()) {
            this.mOutMediaFile.delete();
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                new PictureMediaScannerConnection(getContext(), this.mOutMediaFile.getAbsolutePath());
            }
        }
        this.mSwitchCamera.setVisibility(0);
        this.mFlashLamp.setVisibility(0);
        this.mCameraPreviewView.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    private void setFlashRes() {
        switch (this.type_flash) {
            case 33:
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_auto);
                this.mCameraController.setImageCaptureFlashMode(0);
                break;
            case 34:
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_on);
                this.mCameraController.setImageCaptureFlashMode(1);
                break;
            case 35:
                this.mFlashLamp.setImageResource(R.drawable.picture_ic_flash_off);
                this.mCameraController.setImageCaptureFlashMode(2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoPlay(File file) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            if (this.mMediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            }
            this.mMediaPlayer.setDataSource(file.getAbsolutePath());
            this.mMediaPlayer.setSurface(new Surface(this.mTextureView.getSurfaceTexture()));
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.zyql.ai.selector.camera.b
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                    this.f31973a.lambda$startVideoPlay$1(mediaPlayer);
                }
            });
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoPlay() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mTextureView.setVisibility(8);
    }

    public File createImageFile() {
        String strRename;
        String str;
        boolean zCheckedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        String strReplaceAll = PictureMimeType.JPG;
        if (!zCheckedAndroid_Q) {
            if (TextUtils.isEmpty(this.mConfig.cameraFileName)) {
                strRename = "";
            } else {
                boolean zIsSuffixOfImage = PictureMimeType.isSuffixOfImage(this.mConfig.cameraFileName);
                PictureSelectionConfig pictureSelectionConfig = this.mConfig;
                pictureSelectionConfig.cameraFileName = !zIsSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, PictureMimeType.JPG) : pictureSelectionConfig.cameraFileName;
                PictureSelectionConfig pictureSelectionConfig2 = this.mConfig;
                boolean z10 = pictureSelectionConfig2.camera;
                strRename = pictureSelectionConfig2.cameraFileName;
                if (!z10) {
                    strRename = StringUtils.rename(strRename);
                }
            }
            Context context = getContext();
            int iOfImage = PictureMimeType.ofImage();
            PictureSelectionConfig pictureSelectionConfig3 = this.mConfig;
            File fileCreateCameraFile = PictureFileUtils.createCameraFile(context, iOfImage, strRename, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
            this.mConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
            return fileCreateCameraFile;
        }
        File file = new File(PictureFileUtils.getDiskCacheDir(getContext()));
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.mConfig.cameraFileName);
        if (this.mConfig.suffixType.startsWith("image/")) {
            strReplaceAll = this.mConfig.suffixType.replaceAll("image/", ".");
        }
        if (zIsEmpty) {
            str = DateUtils.getCreateFileName("IMG_") + strReplaceAll;
        } else {
            str = this.mConfig.cameraFileName;
        }
        File file2 = new File(file, str);
        Uri outUri = getOutUri(PictureMimeType.ofImage());
        if (outUri != null) {
            this.mConfig.cameraPath = outUri.toString();
        }
        return file2;
    }

    public File createVideoFile() {
        String strRename;
        String str;
        if (SdkVersionUtils.checkedAndroid_Q()) {
            File file = new File(PictureFileUtils.getVideoDiskCacheDir(getContext()));
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean zIsEmpty = TextUtils.isEmpty(this.mConfig.cameraFileName);
            String strReplaceAll = this.mConfig.suffixType.startsWith("video/") ? this.mConfig.suffixType.replaceAll("video/", ".") : ".mp4";
            if (zIsEmpty) {
                str = DateUtils.getCreateFileName("VID_") + strReplaceAll;
            } else {
                str = this.mConfig.cameraFileName;
            }
            File file2 = new File(file, str);
            Uri outUri = getOutUri(PictureMimeType.ofVideo());
            if (outUri != null) {
                this.mConfig.cameraPath = outUri.toString();
            }
            return file2;
        }
        if (TextUtils.isEmpty(this.mConfig.cameraFileName)) {
            strRename = "";
        } else {
            boolean zIsSuffixOfImage = PictureMimeType.isSuffixOfImage(this.mConfig.cameraFileName);
            PictureSelectionConfig pictureSelectionConfig = this.mConfig;
            pictureSelectionConfig.cameraFileName = !zIsSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".mp4") : pictureSelectionConfig.cameraFileName;
            PictureSelectionConfig pictureSelectionConfig2 = this.mConfig;
            boolean z10 = pictureSelectionConfig2.camera;
            strRename = pictureSelectionConfig2.cameraFileName;
            if (!z10) {
                strRename = StringUtils.rename(strRename);
            }
        }
        Context context = getContext();
        int iOfVideo = PictureMimeType.ofVideo();
        PictureSelectionConfig pictureSelectionConfig3 = this.mConfig;
        File fileCreateCameraFile = PictureFileUtils.createCameraFile(context, iOfVideo, strRename, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
        this.mConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
        return fileCreateCameraFile;
    }

    public CaptureLayout getCaptureLayout() {
        return this.mCaptureLayout;
    }

    public void initCamera(PictureSelectionConfig pictureSelectionConfig) {
        this.mConfig = pictureSelectionConfig;
        if (androidx.core.content.a.a(getContext(), "android.permission.CAMERA") == 0) {
            LifecycleCameraController lifecycleCameraController = new LifecycleCameraController(getContext());
            this.mCameraController = lifecycleCameraController;
            lifecycleCameraController.bindToLifecycle((LifecycleOwner) getContext());
            this.mCameraController.setCameraSelector(this.mConfig.isCameraAroundState ? CameraSelector.f11143c : CameraSelector.f11144d);
            this.mCameraPreviewView.setController(this.mCameraController);
        }
        setFlashRes();
    }

    public void initView() {
        View.inflate(getContext(), R.layout.picture_camera_view, this);
        setBackgroundColor(androidx.core.content.a.c(getContext(), R.color.picture_color_black));
        this.mCameraPreviewView = findViewById(R.id.cameraPreviewView);
        this.mTextureView = (TextureView) findViewById(R.id.video_play_preview);
        this.mImagePreview = (ImageView) findViewById(R.id.image_preview);
        this.mSwitchCamera = (ImageView) findViewById(R.id.image_switch);
        this.mFlashLamp = (ImageView) findViewById(R.id.image_flash);
        this.mCaptureLayout = (CaptureLayout) findViewById(R.id.capture_layout);
        this.mSwitchCamera.setImageResource(R.drawable.picture_ic_camera);
        this.mFlashLamp.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31972a.lambda$initView$0(view);
            }
        });
        this.mCaptureLayout.setDuration(15000);
        this.mSwitchCamera.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomCameraView.this.toggleCamera();
            }
        });
        this.mCaptureLayout.setCaptureListener(new CaptureListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.2
            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            @SuppressLint({"UnsafeOptInUsageError"})
            public void recordEnd(long j10) {
                CustomCameraView.this.recordTime = j10;
                CustomCameraView.this.mCameraController.stopRecording();
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordError() {
                if (CustomCameraView.this.mCameraListener != null) {
                    CustomCameraView.this.mCameraListener.onError(0, "An unknown error", null);
                }
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            @SuppressLint({"UnsafeOptInUsageError"})
            public void recordShort(long j10) {
                CustomCameraView.this.recordTime = j10;
                CustomCameraView.this.mSwitchCamera.setVisibility(0);
                CustomCameraView.this.mFlashLamp.setVisibility(0);
                CustomCameraView.this.mCaptureLayout.resetCaptureLayout();
                CustomCameraView.this.mCaptureLayout.setTextWithAnimation(CustomCameraView.this.getContext().getString(R.string.picture_recording_time_is_short));
                CustomCameraView.this.mCameraController.stopRecording();
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            @SuppressLint({"UnsafeOptInUsageError"})
            public void recordStart() {
                CustomCameraView customCameraView = CustomCameraView.this;
                customCameraView.mOutMediaFile = customCameraView.createVideoFile();
                CustomCameraView.this.mSwitchCamera.setVisibility(4);
                CustomCameraView.this.mFlashLamp.setVisibility(4);
                CustomCameraView.this.mCameraController.setEnabledUseCases(4);
                CustomCameraView.this.mCameraController.startRecording(OutputFileOptions.builder(CustomCameraView.this.mOutMediaFile).build(), androidx.core.content.a.h(CustomCameraView.this.getContext()), new OnVideoSavedCallback() { // from class: com.zyql.ai.selector.camera.CustomCameraView.2.1
                    public void onError(int i10, String str, Throwable th) {
                        if (CustomCameraView.this.mCameraListener != null) {
                            CustomCameraView.this.mCameraListener.onError(i10, str, th);
                        }
                    }

                    public void onVideoSaved(OutputFileResults outputFileResults) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                        if (CustomCameraView.this.recordTime < (CustomCameraView.this.mConfig.recordVideoMinSecond <= 0 ? 1500L : CustomCameraView.this.mConfig.recordVideoMinSecond * 1000) && CustomCameraView.this.mOutMediaFile.exists() && CustomCameraView.this.mOutMediaFile.delete()) {
                            return;
                        }
                        CustomCameraView.this.mTextureView.setVisibility(0);
                        CustomCameraView.this.mCameraPreviewView.setVisibility(4);
                        if (!CustomCameraView.this.mTextureView.isAvailable()) {
                            CustomCameraView.this.mTextureView.setSurfaceTextureListener(CustomCameraView.this.surfaceTextureListener);
                        } else {
                            CustomCameraView customCameraView2 = CustomCameraView.this;
                            customCameraView2.startVideoPlay(customCameraView2.mOutMediaFile);
                        }
                    }
                });
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void recordZoom(float f10) {
            }

            @Override // com.zyql.ai.selector.camera.listener.CaptureListener
            public void takePictures() {
                CustomCameraView customCameraView = CustomCameraView.this;
                customCameraView.mOutMediaFile = customCameraView.createImageFile();
                CustomCameraView.this.mCaptureLayout.setButtonCaptureEnabled(false);
                CustomCameraView.this.mSwitchCamera.setVisibility(4);
                CustomCameraView.this.mFlashLamp.setVisibility(4);
                CustomCameraView.this.mCameraController.setEnabledUseCases(1);
                CustomCameraView.this.mCameraController.takePicture(new ImageCapture.OutputFileOptions.a(CustomCameraView.this.mOutMediaFile).a(), androidx.core.content.a.h(CustomCameraView.this.getContext()), new MyImageResultCallback(CustomCameraView.this.mOutMediaFile, CustomCameraView.this.mImagePreview, CustomCameraView.this.mCaptureLayout, CustomCameraView.this.mImageCallbackListener, CustomCameraView.this.mCameraListener));
            }
        });
        this.mCaptureLayout.setTypeListener(new TypeListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.3
            @Override // com.zyql.ai.selector.camera.listener.TypeListener
            public void cancel() throws IllegalStateException {
                CustomCameraView.this.stopVideoPlay();
                CustomCameraView.this.resetState();
            }

            @Override // com.zyql.ai.selector.camera.listener.TypeListener
            public void confirm() throws IllegalStateException {
                if (CustomCameraView.this.mOutMediaFile == null || !CustomCameraView.this.mOutMediaFile.exists()) {
                    return;
                }
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(CustomCameraView.this.mConfig.cameraPath)) {
                    PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<Boolean>() { // from class: com.zyql.ai.selector.camera.CustomCameraView.3.1
                        @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                        public Boolean doInBackground() {
                            return Boolean.valueOf(AndroidQTransformUtils.copyPathToDCIM(CustomCameraView.this.getContext(), CustomCameraView.this.mOutMediaFile, Uri.parse(CustomCameraView.this.mConfig.cameraPath)));
                        }

                        @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                        public void onSuccess(Boolean bool) throws IllegalStateException {
                            if (CustomCameraView.this.mCameraController.isImageCaptureEnabled()) {
                                CustomCameraView.this.mImagePreview.setVisibility(4);
                                if (CustomCameraView.this.mCameraListener != null) {
                                    CustomCameraView.this.mCameraListener.onPictureSuccess(CustomCameraView.this.mOutMediaFile);
                                    return;
                                }
                                return;
                            }
                            CustomCameraView.this.stopVideoPlay();
                            if (CustomCameraView.this.mCameraListener == null && CustomCameraView.this.mOutMediaFile.exists()) {
                                return;
                            }
                            CustomCameraView.this.mCameraListener.onRecordSuccess(CustomCameraView.this.mOutMediaFile);
                        }
                    });
                    return;
                }
                if (CustomCameraView.this.mCameraController.isImageCaptureEnabled()) {
                    CustomCameraView.this.mImagePreview.setVisibility(4);
                    if (CustomCameraView.this.mCameraListener != null) {
                        CustomCameraView.this.mCameraListener.onPictureSuccess(CustomCameraView.this.mOutMediaFile);
                        return;
                    }
                    return;
                }
                CustomCameraView.this.stopVideoPlay();
                if (CustomCameraView.this.mCameraListener == null && CustomCameraView.this.mOutMediaFile.exists()) {
                    return;
                }
                CustomCameraView.this.mCameraListener.onRecordSuccess(CustomCameraView.this.mOutMediaFile);
            }
        });
        this.mCaptureLayout.setLeftClickListener(new ClickListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.4
            @Override // com.zyql.ai.selector.camera.listener.ClickListener
            public void onClick() {
                if (CustomCameraView.this.mOnClickListener != null) {
                    CustomCameraView.this.mOnClickListener.onClick();
                }
            }
        });
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.mCameraListener = cameraListener;
    }

    public void setCaptureLoadingColor(int i10) {
        this.mCaptureLayout.setCaptureLoadingColor(i10);
    }

    public void setImageCallbackListener(ImageCallbackListener imageCallbackListener) {
        this.mImageCallbackListener = imageCallbackListener;
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.mOnClickListener = clickListener;
    }

    public void setRecordVideoMaxTime(int i10) {
        this.mCaptureLayout.setDuration(i10 * 1000);
    }

    public void setRecordVideoMinTime(int i10) {
        this.mCaptureLayout.setMinDuration(i10 * 1000);
    }

    public void toggleCamera() {
        CameraSelector cameraSelector = this.mCameraController.getCameraSelector();
        CameraSelector cameraSelector2 = CameraSelector.f11144d;
        if (cameraSelector == cameraSelector2) {
            LifecycleCameraController lifecycleCameraController = this.mCameraController;
            CameraSelector cameraSelector3 = CameraSelector.f11143c;
            if (lifecycleCameraController.hasCamera(cameraSelector3)) {
                this.mCameraController.setCameraSelector(cameraSelector3);
                return;
            }
        }
        if (this.mCameraController.getCameraSelector() == CameraSelector.f11143c && this.mCameraController.hasCamera(cameraSelector2)) {
            this.mCameraController.setCameraSelector(cameraSelector2);
        }
    }

    public void unbindCameraController() {
        LifecycleCameraController lifecycleCameraController = this.mCameraController;
        if (lifecycleCameraController != null) {
            lifecycleCameraController.unbind();
        }
    }

    public CustomCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type_flash = 35;
        this.recordTime = 0L;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                CustomCameraView customCameraView = CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mOutMediaFile);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initView();
    }

    public CustomCameraView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.type_flash = 35;
        this.recordTime = 0L;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.zyql.ai.selector.camera.CustomCameraView.5
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i102, int i11) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                CustomCameraView customCameraView = CustomCameraView.this;
                customCameraView.startVideoPlay(customCameraView.mOutMediaFile);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i102, int i11) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initView();
    }
}
