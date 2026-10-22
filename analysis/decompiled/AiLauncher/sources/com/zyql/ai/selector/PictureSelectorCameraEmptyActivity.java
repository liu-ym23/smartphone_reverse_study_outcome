package com.zyql.ai.selector;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.entity.MediaExtraInfo;
import com.zyql.ai.selector.immersive.ImmersiveManage;
import com.zyql.ai.selector.listener.OnCustomCameraInterfaceListener;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import com.zyql.ai.selector.manager.UCropManager;
import com.zyql.ai.selector.permissions.PermissionChecker;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import com.zyql.ai.selector.tools.ValueOf;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class PictureSelectorCameraEmptyActivity extends PictureBaseActivity {
    private AbstractC3936b activityResultLauncher;

    private void dispatchCameraHandleResult(LocalMedia localMedia) {
        boolean zIsHasImage = PictureMimeType.isHasImage(localMedia.getMimeType());
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enableCrop && !pictureSelectionConfig.isCheckOriginalImage && zIsHasImage) {
            String str = pictureSelectionConfig.cameraPath;
            pictureSelectionConfig.originalPath = str;
            UCropManager.ofCrop(this, str, localMedia.getMimeType());
        } else if (pictureSelectionConfig.isCompress && zIsHasImage) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(localMedia);
            compressImage(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(localMedia);
            onResult(arrayList2);
        }
    }

    private void onTakePhoto() {
        if (!PermissionChecker.checkSelfPermission(this, "android.permission.CAMERA")) {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if ((pictureSelectionConfig == null || !pictureSelectionConfig.isUseCustomCamera) ? true : PermissionChecker.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
            startCamera();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, 4);
        }
    }

    public static /* synthetic */ void s(Map map) {
        String[] storagePermissions = PermissionAdapter.INSTANCE.getStoragePermissions();
        if (storagePermissions == null || storagePermissions.length <= 0) {
            return;
        }
        for (String str : storagePermissions) {
            ((Boolean) map.get(str)).getClass();
            Log.w("PictureSelector", "user deny permission request :" + str);
        }
    }

    private void setActivitySize() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    private void startCamera() {
        int i10 = this.config.chooseMode;
        if (i10 == 0 || i10 == 1) {
            startOpenCamera();
        } else if (i10 == 2) {
            startOpenCameraVideo();
        } else {
            if (i10 != 3) {
                return;
            }
            startOpenCameraAudio();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d A[Catch: Exception -> 0x02d2, TryCatch #4 {Exception -> 0x02d2, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0027, B:24:0x006f, B:26:0x0075, B:34:0x0087, B:36:0x008d, B:37:0x0090, B:30:0x007e, B:38:0x0091, B:41:0x009d, B:43:0x00ac, B:45:0x00dd, B:52:0x0139, B:54:0x0147, B:56:0x0156, B:58:0x015e, B:59:0x0164, B:70:0x0205, B:72:0x0215, B:74:0x021f, B:76:0x022a, B:79:0x024e, B:81:0x0258, B:83:0x0262, B:85:0x0268, B:86:0x0276, B:87:0x028c, B:89:0x0292, B:91:0x02b5, B:93:0x02bf, B:95:0x02ca, B:90:0x02a0, B:75:0x0225, B:46:0x00f8, B:48:0x00fe, B:49:0x0120, B:51:0x0126, B:60:0x0169, B:62:0x018e, B:69:0x01f7, B:63:0x01b6, B:65:0x01bc, B:66:0x01de, B:68:0x01e4), top: B:103:0x0000 }] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Closeable, java.nio.channels.Channel] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispatchHandleCamera(android.content.Intent r8) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.PictureSelectorCameraEmptyActivity.dispatchHandleCamera(android.content.Intent):void");
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_empty;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void immersive() {
        int i10 = R.color.picture_color_transparent;
        ImmersiveManage.immersiveAboveAPI23(this, androidx.core.content.a.c(this, i10), androidx.core.content.a.c(this, i10), this.openWhiteStatusBar);
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        Throwable th;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1) {
            if (i10 == 69) {
                singleCropHandleResult(intent);
                return;
            } else {
                if (i10 != 909) {
                    return;
                }
                dispatchHandleCamera(intent);
                return;
            }
        }
        if (i11 != 0) {
            if (i11 != 96 || intent == null || (th = (Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)) == null) {
                return;
            }
            ToastUtils.s(getContext(), th.getMessage());
            return;
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onCancel();
        }
        if (i10 == 909) {
            MediaUtils.deleteCamera(this, this.config.cameraPath);
        }
        exit();
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        exit();
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.config == null) {
            exit();
            return;
        }
        this.activityResultLauncher = registerForActivityResult(new e.c(), new InterfaceC3935a() { // from class: com.zyql.ai.selector.B
            @Override // d.InterfaceC3935a
            public final void a(Object obj) {
                PictureSelectorCameraEmptyActivity.s((Map) obj);
            }
        });
        if (this.config.isUseCustomCamera) {
            return;
        }
        setActivitySize();
        if (bundle == null) {
            PermissionAdapter permissionAdapter = PermissionAdapter.INSTANCE;
            if (!permissionAdapter.checkMediaPermission(this)) {
                permissionAdapter.requestMediaPermission(this, this.activityResultLauncher);
                return;
            }
            OnCustomCameraInterfaceListener onCustomCameraInterfaceListener = PictureSelectionConfig.onCustomCameraInterfaceListener;
            if (onCustomCameraInterfaceListener == null) {
                onTakePhoto();
            } else if (this.config.chooseMode == 2) {
                onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 2);
            } else {
                onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
            }
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
                return;
            } else {
                ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
                exit();
                return;
            }
        }
        if (i10 == 2) {
            if (iArr.length > 0 && iArr[0] == 0) {
                onTakePhoto();
                return;
            } else {
                exit();
                ToastUtils.s(getContext(), getString(R.string.picture_camera));
                return;
            }
        }
        if (i10 != 4) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            onTakePhoto();
        } else {
            exit();
            ToastUtils.s(getContext(), getString(R.string.picture_audio));
        }
    }

    public void singleCropHandleResult(Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Uri output = UCrop.getOutput(intent);
        if (output == null) {
            return;
        }
        String path = output.getPath();
        boolean zIsEmpty = TextUtils.isEmpty(path);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        LocalMedia localMedia = new LocalMedia(pictureSelectionConfig.cameraPath, 0L, false, pictureSelectionConfig.isCamera ? 1 : 0, 0, pictureSelectionConfig.chooseMode);
        if (SdkVersionUtils.checkedAndroid_Q()) {
            int iLastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
            localMedia.setId(iLastIndexOf > 0 ? ValueOf.toLong(this.config.cameraPath.substring(iLastIndexOf)) : -1L);
            localMedia.setAndroidQToPath(path);
        } else {
            localMedia.setId(System.currentTimeMillis());
        }
        localMedia.setCut(!zIsEmpty);
        localMedia.setCutPath(path);
        localMedia.setMimeType(PictureMimeType.getImageMimeType(path));
        if (PictureMimeType.isContent(localMedia.getPath())) {
            localMedia.setRealPath(PictureFileUtils.getPath(getContext(), Uri.parse(localMedia.getPath())));
            if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                MediaExtraInfo videoSize = MediaUtils.getVideoSize(getContext(), localMedia.getPath());
                localMedia.setWidth(videoSize.getWidth());
                localMedia.setHeight(videoSize.getHeight());
            } else if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                MediaExtraInfo imageSize = MediaUtils.getImageSize(getContext(), localMedia.getPath());
                localMedia.setWidth(imageSize.getWidth());
                localMedia.setHeight(imageSize.getHeight());
            }
        } else {
            localMedia.setRealPath(localMedia.getPath());
            if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                MediaExtraInfo videoSize2 = MediaUtils.getVideoSize(getContext(), localMedia.getPath());
                localMedia.setWidth(videoSize2.getWidth());
                localMedia.setHeight(videoSize2.getHeight());
            } else if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                MediaExtraInfo imageSize2 = MediaUtils.getImageSize(getContext(), localMedia.getPath());
                localMedia.setWidth(imageSize2.getWidth());
                localMedia.setHeight(imageSize2.getHeight());
            }
        }
        File file = new File(localMedia.getRealPath());
        localMedia.setSize(file.length());
        localMedia.setFileName(file.getName());
        arrayList.add(localMedia);
        handlerResult(arrayList);
    }
}
