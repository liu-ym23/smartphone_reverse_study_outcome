package com.zyql.ai.selector;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.zyql.ai.selector.camera.CustomCameraView;
import com.zyql.ai.selector.camera.listener.CameraListener;
import com.zyql.ai.selector.camera.listener.ClickListener;
import com.zyql.ai.selector.camera.listener.ImageCallbackListener;
import com.zyql.ai.selector.camera.view.CaptureLayout;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.dialog.PictureCustomDialog;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnPermissionDialogOptionCallback;
import com.zyql.ai.selector.listener.OnPermissionsObtainCallback;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import com.zyql.ai.selector.permissions.PermissionChecker;
import java.io.File;

/* loaded from: classes4.dex */
public class PictureCustomCameraActivity extends PictureSelectorCameraEmptyActivity {
    private static final String TAG = "PictureCustomCameraActivity";
    protected boolean isEnterSetting;
    private CustomCameraView mCameraView;

    private void createCameraView() {
        if (this.mCameraView == null) {
            CustomCameraView customCameraView = new CustomCameraView(getContext());
            this.mCameraView = customCameraView;
            setContentView(customCameraView);
            initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(File file, ImageView imageView) {
        ImageEngine imageEngine;
        if (this.config == null || (imageEngine = PictureSelectionConfig.imageEngine) == null || file == null) {
            return;
        }
        imageEngine.loadImage(getContext(), file.getAbsolutePath(), imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionsDialog$1(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onCancel();
        }
        exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionsDialog$2(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
    }

    public void initView() {
        this.mCameraView.initCamera(this.config);
        int i10 = this.config.recordVideoSecond;
        if (i10 > 0) {
            this.mCameraView.setRecordVideoMaxTime(i10);
        }
        int i11 = this.config.recordVideoMinSecond;
        if (i11 > 0) {
            this.mCameraView.setRecordVideoMinTime(i11);
        }
        int i12 = this.config.captureLoadingColor;
        if (i12 != 0) {
            this.mCameraView.setCaptureLoadingColor(i12);
        }
        CaptureLayout captureLayout = this.mCameraView.getCaptureLayout();
        if (captureLayout != null) {
            captureLayout.setButtonFeatures(this.config.buttonFeatures);
        }
        this.mCameraView.setImageCallbackListener(new ImageCallbackListener() { // from class: com.zyql.ai.selector.b
            @Override // com.zyql.ai.selector.camera.listener.ImageCallbackListener
            public final void onLoadImage(File file, ImageView imageView) {
                this.f31969a.lambda$initView$0(file, imageView);
            }
        });
        this.mCameraView.setCameraListener(new CameraListener() { // from class: com.zyql.ai.selector.PictureCustomCameraActivity.1
            @Override // com.zyql.ai.selector.camera.listener.CameraListener
            public void onError(int i13, String str, Throwable th) {
                Log.i(PictureCustomCameraActivity.TAG, "onError: " + str);
            }

            @Override // com.zyql.ai.selector.camera.listener.CameraListener
            public void onPictureSuccess(File file) {
                PictureCustomCameraActivity.this.config.cameraMimeType = PictureMimeType.ofImage();
                Intent intent = new Intent();
                intent.putExtra(PictureConfig.EXTRA_MEDIA_PATH, file.getAbsolutePath());
                intent.putExtra(PictureConfig.EXTRA_CONFIG, PictureCustomCameraActivity.this.config);
                PictureCustomCameraActivity pictureCustomCameraActivity = PictureCustomCameraActivity.this;
                if (pictureCustomCameraActivity.config.camera) {
                    pictureCustomCameraActivity.dispatchHandleCamera(intent);
                } else {
                    pictureCustomCameraActivity.setResult(-1, intent);
                    PictureCustomCameraActivity.this.onBackPressed();
                }
            }

            @Override // com.zyql.ai.selector.camera.listener.CameraListener
            public void onRecordSuccess(File file) {
                PictureCustomCameraActivity.this.config.cameraMimeType = PictureMimeType.ofVideo();
                Intent intent = new Intent();
                intent.putExtra(PictureConfig.EXTRA_MEDIA_PATH, file.getAbsolutePath());
                intent.putExtra(PictureConfig.EXTRA_CONFIG, PictureCustomCameraActivity.this.config);
                PictureCustomCameraActivity pictureCustomCameraActivity = PictureCustomCameraActivity.this;
                if (pictureCustomCameraActivity.config.camera) {
                    pictureCustomCameraActivity.dispatchHandleCamera(intent);
                } else {
                    pictureCustomCameraActivity.setResult(-1, intent);
                    PictureCustomCameraActivity.this.onBackPressed();
                }
            }
        });
        this.mCameraView.setOnClickListener(new ClickListener() { // from class: com.zyql.ai.selector.PictureCustomCameraActivity.2
            @Override // com.zyql.ai.selector.camera.listener.ClickListener
            public void onClick() {
                PictureCustomCameraActivity.this.onBackPressed();
            }
        });
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.zyql.ai.selector.PictureSelectorCameraEmptyActivity, b.q, android.app.Activity
    public void onBackPressed() {
        OnResultCallbackListener<LocalMedia> onResultCallbackListener;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig != null && pictureSelectionConfig.camera && (onResultCallbackListener = PictureSelectionConfig.listener) != null) {
            onResultCallbackListener.onCancel();
        }
        exit();
    }

    @Override // com.zyql.ai.selector.PictureSelectorCameraEmptyActivity, com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(67108864, 67108864);
        getWindow().setFlags(134217728, 134217728);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(128);
        super.onCreate(bundle);
        if (!PermissionChecker.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") || !PermissionChecker.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
            return;
        }
        if (!PermissionChecker.checkSelfPermission(this, "android.permission.CAMERA")) {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
        } else if (PermissionChecker.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
            createCameraView();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, 4);
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        CustomCameraView customCameraView = this.mCameraView;
        if (customCameraView != null) {
            customCameraView.unbindCameraController();
        }
        super.onDestroy();
    }

    @Override // com.zyql.ai.selector.PictureSelectorCameraEmptyActivity, com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (i10 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(true, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, getString(R.string.picture_jurisdiction));
                return;
            } else {
                PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
                return;
            }
        }
        if (i10 != 2) {
            if (i10 != 4) {
                return;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, getString(R.string.picture_audio));
                return;
            } else {
                createCameraView();
                return;
            }
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionsDialog(true, new String[]{"android.permission.CAMERA"}, getString(R.string.picture_camera));
        } else if (PermissionChecker.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
            createCameraView();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, 4);
        }
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isEnterSetting) {
            if (!PermissionChecker.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") || !PermissionChecker.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, getString(R.string.picture_jurisdiction));
            } else if (!PermissionChecker.checkSelfPermission(this, "android.permission.CAMERA")) {
                showPermissionsDialog(false, new String[]{"android.permission.CAMERA"}, getString(R.string.picture_camera));
            } else if (PermissionChecker.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
                createCameraView();
            } else {
                showPermissionsDialog(false, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, getString(R.string.picture_audio));
            }
            this.isEnterSetting = false;
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void showPermissionsDialog(boolean z10, String[] strArr, String str) {
        if (isFinishing()) {
            return;
        }
        OnPermissionsObtainCallback onPermissionsObtainCallback = PictureSelectionConfig.onPermissionsObtainCallback;
        if (onPermissionsObtainCallback != null) {
            onPermissionsObtainCallback.onPermissionsIntercept(getContext(), z10, strArr, str, new OnPermissionDialogOptionCallback() { // from class: com.zyql.ai.selector.PictureCustomCameraActivity.3
                @Override // com.zyql.ai.selector.listener.OnPermissionDialogOptionCallback
                public void onCancel() {
                    OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
                    if (onResultCallbackListener != null) {
                        onResultCallbackListener.onCancel();
                    }
                    PictureCustomCameraActivity.this.exit();
                }

                @Override // com.zyql.ai.selector.listener.OnPermissionDialogOptionCallback
                public void onSetting() {
                    PictureCustomCameraActivity.this.isEnterSetting = true;
                }
            });
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        Button button = (Button) pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button) pictureCustomDialog.findViewById(R.id.btn_commit);
        button2.setText(getString(R.string.picture_go_setting));
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.tvTitle);
        TextView textView2 = (TextView) pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText(getString(R.string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31970a.lambda$showPermissionsDialog$1(pictureCustomDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31982a.lambda$showPermissionsDialog$2(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }
}
