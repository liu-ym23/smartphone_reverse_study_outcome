package com.zyql.ai.selector;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.zyql.ai.selector.app.PictureAppMaster;
import com.zyql.ai.selector.compress.Luban;
import com.zyql.ai.selector.compress.OnCompressListener;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.dialog.PictureCustomDialog;
import com.zyql.ai.selector.dialog.PictureLoadingDialog;
import com.zyql.ai.selector.engine.CompressEngine;
import com.zyql.ai.selector.engine.PictureSelectorEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.entity.LocalMediaFolder;
import com.zyql.ai.selector.immersive.ImmersiveManage;
import com.zyql.ai.selector.immersive.NavBarUtils;
import com.zyql.ai.selector.language.PictureLanguageUtils;
import com.zyql.ai.selector.listener.OnCallbackListener;
import com.zyql.ai.selector.listener.OnChooseLimitCallback;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import com.zyql.ai.selector.model.LocalMediaPageLoader;
import com.zyql.ai.selector.permissions.PermissionChecker;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.StringUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import com.zyql.ai.selector.tools.VoiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class PictureBaseActivity extends androidx.appcompat.app.d {
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected PictureSelectionConfig config;
    protected View container;
    protected boolean isOnSaveInstanceState;
    protected PictureLoadingDialog mLoadingDialog;
    protected boolean numComplete;
    protected boolean openWhiteStatusBar;
    protected List<LocalMedia> selectionMedias = new ArrayList();
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected boolean isHasMore = true;
    protected int mPage = 1;

    private void compressToLuban(final List<LocalMedia> list) {
        if (this.config.synOrAsy) {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.zyql.ai.selector.PictureBaseActivity.2
                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public List<LocalMedia> doInBackground() throws Exception {
                    return Luban.with(PictureBaseActivity.this.getContext()).loadMediaData(list).isCamera(PictureBaseActivity.this.config.camera).setTargetDir(PictureBaseActivity.this.config.compressSavePath).setCompressQuality(PictureBaseActivity.this.config.compressQuality).isAutoRotating(PictureBaseActivity.this.config.isAutoRotating).setFocusAlpha(PictureBaseActivity.this.config.focusAlpha).setNewCompressFileName(PictureBaseActivity.this.config.renameCompressFileName).ignoreBy(PictureBaseActivity.this.config.minimumCompressSize).get();
                }

                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public void onSuccess(List<LocalMedia> list2) {
                    PictureBaseActivity.this.onResult(list2);
                }
            });
        } else {
            Luban.with(this).loadMediaData(list).ignoreBy(this.config.minimumCompressSize).isCamera(this.config.camera).setCompressQuality(this.config.compressQuality).setTargetDir(this.config.compressSavePath).isAutoRotating(this.config.isAutoRotating).setFocusAlpha(this.config.focusAlpha).setNewCompressFileName(this.config.renameCompressFileName).setCompressListener(new OnCompressListener() { // from class: com.zyql.ai.selector.PictureBaseActivity.3
                @Override // com.zyql.ai.selector.compress.OnCompressListener
                public void onError(Throwable th) {
                    PictureBaseActivity.this.onResult(list);
                }

                @Override // com.zyql.ai.selector.compress.OnCompressListener
                public void onStart() {
                }

                @Override // com.zyql.ai.selector.compress.OnCompressListener
                public void onSuccess(List<LocalMedia> list2) {
                    PictureBaseActivity.this.onResult(list2);
                }
            }).launch();
        }
    }

    private void initConfig() {
        if (this.config.selectionMedias != null) {
            this.selectionMedias.clear();
            this.selectionMedias.addAll(this.config.selectionMedias);
        }
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            this.openWhiteStatusBar = pictureSelectorUIStyle.picture_statusBarChangeTextColor;
            int i10 = pictureSelectorUIStyle.picture_top_titleBarBackgroundColor;
            if (i10 != 0) {
                this.colorPrimary = i10;
            }
            int i11 = pictureSelectorUIStyle.picture_statusBarBackgroundColor;
            if (i11 != 0) {
                this.colorPrimaryDark = i11;
            }
            this.numComplete = pictureSelectorUIStyle.picture_switchSelectTotalStyle;
            this.config.checkNumMode = pictureSelectorUIStyle.picture_switchSelectNumberStyle;
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                this.openWhiteStatusBar = pictureParameterStyle.isChangeStatusBarFontColor;
                int i12 = pictureParameterStyle.pictureTitleBarBackgroundColor;
                if (i12 != 0) {
                    this.colorPrimary = i12;
                }
                int i13 = pictureParameterStyle.pictureStatusBarColor;
                if (i13 != 0) {
                    this.colorPrimaryDark = i13;
                }
                this.numComplete = pictureParameterStyle.isOpenCompletedNumStyle;
                this.config.checkNumMode = pictureParameterStyle.isOpenCheckNumStyle;
            } else {
                boolean z10 = this.config.isChangeStatusBarFontColor;
                this.openWhiteStatusBar = z10;
                if (!z10) {
                    this.openWhiteStatusBar = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_statusFontColor);
                }
                boolean z11 = this.config.isOpenStyleNumComplete;
                this.numComplete = z11;
                if (!z11) {
                    this.numComplete = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_style_numComplete);
                }
                PictureSelectionConfig pictureSelectionConfig = this.config;
                boolean z12 = pictureSelectionConfig.isOpenStyleCheckNumMode;
                pictureSelectionConfig.checkNumMode = z12;
                if (!z12) {
                    pictureSelectionConfig.checkNumMode = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_style_checkNumMode);
                }
                int i14 = this.config.titleBarBackgroundColor;
                if (i14 != 0) {
                    this.colorPrimary = i14;
                } else {
                    this.colorPrimary = AttrsUtils.getTypeValueColor(this, R.color.color_primary);
                }
                int i15 = this.config.pictureStatusBarColor;
                if (i15 != 0) {
                    this.colorPrimaryDark = i15;
                } else {
                    this.colorPrimaryDark = AttrsUtils.getTypeValueColor(this, androidx.appcompat.R$attr.colorPrimaryDark);
                }
            }
        }
        if (this.config.openClickSound) {
            VoiceUtils.getInstance().init(getContext());
        }
    }

    private void newCreateEngine() {
        PictureSelectorEngine pictureSelectorEngine;
        if (PictureSelectionConfig.imageEngine != null || (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) == null) {
            return;
        }
        PictureSelectionConfig.imageEngine = pictureSelectorEngine.createEngine();
    }

    private void newCreateResultCallbackListener() {
        PictureSelectorEngine pictureSelectorEngine;
        if (this.config.isCallbackMode && PictureSelectionConfig.listener == null && (pictureSelectorEngine = PictureAppMaster.getInstance().getPictureSelectorEngine()) != null) {
            PictureSelectionConfig.listener = pictureSelectorEngine.getResultCallbackListener();
        }
    }

    private void normalResult(List<LocalMedia> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            LocalMedia localMedia = list.get(i10);
            if (localMedia != null && !TextUtils.isEmpty(localMedia.getPath())) {
                if (localMedia.isCut() && localMedia.isCompressed()) {
                    localMedia.setAndroidQToPath(localMedia.getCompressPath());
                }
                if (this.config.isCheckOriginalImage) {
                    localMedia.setOriginal(true);
                    localMedia.setOriginalPath(localMedia.getAndroidQToPath());
                }
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onResult(list);
        } else {
            setResult(-1, PictureSelector.putIntentResult(list));
        }
        exit();
    }

    private void onResultToAndroidAsy(List<LocalMedia> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            LocalMedia localMedia = list.get(i10);
            if (localMedia != null && !TextUtils.isEmpty(localMedia.getPath()) && (this.config.isCheckOriginalImage || (!localMedia.isCut() && !localMedia.isCompressed() && TextUtils.isEmpty(localMedia.getAndroidQToPath())))) {
                startThreadCopySandbox(list);
                return;
            }
        }
        normalResult(list);
    }

    public static /* synthetic */ int r(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }

    private void releaseResultListener() {
        if (this.config != null) {
            PictureSelectionConfig.destroy();
            LocalMediaPageLoader.setInstanceNull();
            PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
        }
    }

    private void startThreadCopySandbox(final List<LocalMedia> list) {
        showPleaseDialog();
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.zyql.ai.selector.PictureBaseActivity.4
            /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00c9 A[SYNTHETIC] */
            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List<com.zyql.ai.selector.entity.LocalMedia> doInBackground() {
                /*
                    r14 = this;
                    java.util.List r0 = r2
                    int r0 = r0.size()
                    r1 = 0
                    r2 = r1
                L8:
                    if (r2 >= r0) goto Lcd
                    java.util.List r3 = r2
                    java.lang.Object r3 = r3.get(r2)
                    com.zyql.ai.selector.entity.LocalMedia r3 = (com.zyql.ai.selector.entity.LocalMedia) r3
                    if (r3 == 0) goto Lc9
                    java.lang.String r4 = r3.getPath()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L20
                    goto Lc9
                L20:
                    boolean r4 = r3.isCut()
                    r5 = 1
                    if (r4 != 0) goto L39
                    boolean r4 = r3.isCompressed()
                    if (r4 != 0) goto L39
                    java.lang.String r4 = r3.getAndroidQToPath()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L39
                    r4 = r5
                    goto L3a
                L39:
                    r4 = r1
                L3a:
                    if (r4 == 0) goto L79
                    java.lang.String r4 = r3.getPath()
                    boolean r4 = com.zyql.ai.selector.config.PictureMimeType.isContent(r4)
                    if (r4 == 0) goto L79
                    java.lang.String r4 = r3.getPath()
                    boolean r4 = com.zyql.ai.selector.config.PictureMimeType.isHasHttp(r4)
                    if (r4 != 0) goto L8c
                    com.zyql.ai.selector.PictureBaseActivity r4 = com.zyql.ai.selector.PictureBaseActivity.this
                    android.content.Context r6 = r4.getContext()
                    long r7 = r3.getId()
                    java.lang.String r9 = r3.getPath()
                    int r10 = r3.getWidth()
                    int r11 = r3.getHeight()
                    java.lang.String r12 = r3.getMimeType()
                    com.zyql.ai.selector.PictureBaseActivity r4 = com.zyql.ai.selector.PictureBaseActivity.this
                    com.zyql.ai.selector.config.PictureSelectionConfig r4 = r4.config
                    java.lang.String r13 = r4.cameraFileName
                    java.lang.String r4 = com.zyql.ai.selector.tools.AndroidQTransformUtils.copyPathToAndroidQ(r6, r7, r9, r10, r11, r12, r13)
                    r3.setAndroidQToPath(r4)
                    r4 = r5
                    goto L8d
                L79:
                    boolean r4 = r3.isCut()
                    if (r4 == 0) goto L8c
                    boolean r4 = r3.isCompressed()
                    if (r4 == 0) goto L8c
                    java.lang.String r4 = r3.getCompressPath()
                    r3.setAndroidQToPath(r4)
                L8c:
                    r4 = r1
                L8d:
                    com.zyql.ai.selector.PictureBaseActivity r6 = com.zyql.ai.selector.PictureBaseActivity.this
                    com.zyql.ai.selector.config.PictureSelectionConfig r6 = r6.config
                    boolean r6 = r6.isCheckOriginalImage
                    if (r6 == 0) goto Lc9
                    r3.setOriginal(r5)
                    if (r4 == 0) goto La2
                    java.lang.String r4 = r3.getAndroidQToPath()
                    r3.setOriginalPath(r4)
                    goto Lc9
                La2:
                    com.zyql.ai.selector.PictureBaseActivity r4 = com.zyql.ai.selector.PictureBaseActivity.this
                    android.content.Context r5 = r4.getContext()
                    long r6 = r3.getId()
                    java.lang.String r8 = r3.getPath()
                    int r9 = r3.getWidth()
                    int r10 = r3.getHeight()
                    java.lang.String r11 = r3.getMimeType()
                    com.zyql.ai.selector.PictureBaseActivity r4 = com.zyql.ai.selector.PictureBaseActivity.this
                    com.zyql.ai.selector.config.PictureSelectionConfig r4 = r4.config
                    java.lang.String r12 = r4.cameraFileName
                    java.lang.String r4 = com.zyql.ai.selector.tools.AndroidQTransformUtils.copyPathToAndroidQ(r5, r6, r8, r9, r10, r11, r12)
                    r3.setOriginalPath(r4)
                Lc9:
                    int r2 = r2 + 1
                    goto L8
                Lcd:
                    java.util.List r14 = r2
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.PictureBaseActivity.AnonymousClass4.doInBackground():java.util.List");
            }

            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMedia> list2) {
                PictureBaseActivity.this.dismissDialog();
                if (list2 != null) {
                    PictureSelectionConfig pictureSelectionConfig = PictureBaseActivity.this.config;
                    if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2) {
                        list2.addAll(list2.size() > 0 ? list2.size() - 1 : 0, PictureBaseActivity.this.selectionMedias);
                    }
                    OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
                    if (onResultCallbackListener != null) {
                        onResultCallbackListener.onResult(list2);
                    } else {
                        PictureBaseActivity.this.setResult(-1, PictureSelector.putIntentResult(list2));
                    }
                    PictureBaseActivity.this.exit();
                }
            }
        });
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(PictureContextWrapper.wrap(context, pictureSelectionConfig.language));
        }
    }

    public void compressImage(List<LocalMedia> list) {
        CompressEngine compressEngine = PictureSelectionConfig.compressEngine;
        if (compressEngine != null) {
            compressEngine.onCompress(getContext(), list, new OnCallbackListener<List<LocalMedia>>() { // from class: com.zyql.ai.selector.PictureBaseActivity.1
                @Override // com.zyql.ai.selector.listener.OnCallbackListener
                public void onCall(List<LocalMedia> list2) {
                    PictureBaseActivity.this.onResult(list2);
                }
            });
        } else {
            showPleaseDialog();
            compressToLuban(list);
        }
    }

    public void createNewFolder(List<LocalMediaFolder> list) {
        if (list.size() == 0) {
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.setName(getString(this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll));
            localMediaFolder.setFirstImagePath("");
            localMediaFolder.setCameraFolder(true);
            localMediaFolder.setBucketId(-1L);
            localMediaFolder.setChecked(true);
            list.add(localMediaFolder);
        }
    }

    public void dismissDialog() {
        if (isFinishing()) {
            return;
        }
        try {
            PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
            if (pictureLoadingDialog == null || !pictureLoadingDialog.isShowing()) {
                return;
            }
            this.mLoadingDialog.dismiss();
        } catch (Exception e10) {
            this.mLoadingDialog = null;
            e10.printStackTrace();
        }
    }

    public void exit() {
        finish();
        if (this.config.camera) {
            overridePendingTransition(0, R.anim.picture_anim_fade_out);
            if ((getContext() instanceof PictureSelectorCameraEmptyActivity) || (getContext() instanceof PictureCustomCameraActivity)) {
                releaseResultListener();
                return;
            }
            return;
        }
        overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityExitAnimation);
        if (getContext() instanceof PictureSelectorActivity) {
            releaseResultListener();
            if (this.config.openClickSound) {
                VoiceUtils.getInstance().releaseSoundPool();
            }
        }
    }

    public String getAudioPath(Intent intent) {
        try {
            Uri data = intent.getData();
            return data == null ? "" : PictureMimeType.isContent(data.toString()) ? data.toString() : data.getPath();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public Context getContext() {
        return this;
    }

    public LocalMediaFolder getImageFolder(String str, String str2, String str3, List<LocalMediaFolder> list) {
        if (!PictureMimeType.isContent(str)) {
            str2 = str;
        }
        File parentFile = new File(str2).getParentFile();
        for (LocalMediaFolder localMediaFolder : list) {
            if (parentFile != null && localMediaFolder.getName().equals(parentFile.getName())) {
                return localMediaFolder;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder2.setFirstImagePath(str);
        localMediaFolder2.setFirstMimeType(str3);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    public abstract int getResourceId();

    public void handlerResult(List<LocalMedia> list) {
        if (this.config.isCompress) {
            compressImage(list);
        } else {
            onResult(list);
        }
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, this.colorPrimaryDark, this.colorPrimary, this.openWhiteStatusBar);
    }

    public void initCompleteText(int i10) {
    }

    public void initPictureSelectorStyle() {
    }

    public void initWidgets() {
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        this.config = PictureSelectionConfig.getInstance();
        PictureLanguageUtils.setAppLanguage(getContext(), this.config.language);
        int i11 = this.config.themeStyleId;
        if (i11 == 0) {
            i11 = R.style.picture_default_style;
        }
        setTheme(i11);
        super.onCreate(bundle);
        newCreateEngine();
        newCreateResultCallbackListener();
        if (isRequestedOrientation()) {
            setNewRequestedOrientation();
        }
        initConfig();
        if (isImmersive()) {
            immersive();
        }
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i12 = pictureSelectorUIStyle.picture_navBarColor;
            if (i12 != 0) {
                NavBarUtils.setNavBarColor(this, i12);
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null && (i10 = pictureParameterStyle.pictureNavBarColor) != 0) {
                NavBarUtils.setNavBarColor(this, i10);
            }
        }
        int resourceId = getResourceId();
        if (resourceId != 0) {
            setContentView(resourceId);
        }
        initWidgets();
        initPictureSelectorStyle();
        this.isOnSaveInstanceState = false;
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        PictureLoadingDialog pictureLoadingDialog = this.mLoadingDialog;
        if (pictureLoadingDialog != null) {
            pictureLoadingDialog.dismiss();
            this.mLoadingDialog = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 3) {
            if (iArr[0] != 0) {
                ToastUtils.s(getContext(), getString(R.string.picture_audio));
                return;
            }
            Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
            }
        }
    }

    public void onResult(List<LocalMedia> list) {
        if (SdkVersionUtils.checkedAndroid_Q() && this.config.isAndroidQTransform) {
            onResultToAndroidAsy(list);
            return;
        }
        dismissDialog();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        if (this.config.isCheckOriginalImage) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                LocalMedia localMedia = list.get(i10);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onResult(list);
        } else {
            setResult(-1, PictureSelector.putIntentResult(list));
        }
        exit();
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isOnSaveInstanceState = true;
        bundle.putParcelable(PictureConfig.EXTRA_CONFIG, this.config);
    }

    public void setNewRequestedOrientation() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null || pictureSelectionConfig.camera) {
            return;
        }
        setRequestedOrientation(pictureSelectionConfig.requestedOrientation);
    }

    public void showPermissionsDialog(boolean z10, String[] strArr, String str) {
    }

    public void showPleaseDialog() {
        try {
            if (isFinishing()) {
                return;
            }
            if (this.mLoadingDialog == null) {
                this.mLoadingDialog = new PictureLoadingDialog(getContext());
            }
            if (this.mLoadingDialog.isShowing()) {
                this.mLoadingDialog.dismiss();
            }
            this.mLoadingDialog.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void showPromptDialog(String str) {
        if (isFinishing()) {
            return;
        }
        OnChooseLimitCallback onChooseLimitCallback = PictureSelectionConfig.onChooseLimitCallback;
        if (onChooseLimitCallback != null) {
            onChooseLimitCallback.onChooseLimit(getContext(), str);
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_prompt_dialog);
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.btnOk);
        ((TextView) pictureCustomDialog.findViewById(R.id.tv_content)).setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.PictureBaseActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PictureBaseActivity.this.isFinishing()) {
                    return;
                }
                pictureCustomDialog.dismiss();
            }
        });
        pictureCustomDialog.show();
    }

    public void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, new Comparator() { // from class: com.zyql.ai.selector.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return PictureBaseActivity.r((LocalMediaFolder) obj, (LocalMediaFolder) obj2);
            }
        });
    }

    public void startOpenCamera() {
        String strRename;
        Uri uriParUri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            int i10 = pictureSelectionConfig.chooseMode;
            if (i10 == 0) {
                i10 = 1;
            }
            if (TextUtils.isEmpty(pictureSelectionConfig.cameraFileName)) {
                strRename = null;
            } else {
                boolean zIsSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                pictureSelectionConfig2.cameraFileName = !zIsSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig2.cameraFileName, PictureMimeType.JPG) : pictureSelectionConfig2.cameraFileName;
                PictureSelectionConfig pictureSelectionConfig3 = this.config;
                boolean z10 = pictureSelectionConfig3.camera;
                strRename = pictureSelectionConfig3.cameraFileName;
                if (!z10) {
                    strRename = StringUtils.rename(strRename);
                }
            }
            if (SdkVersionUtils.checkedAndroid_Q()) {
                if (TextUtils.isEmpty(this.config.outPutCameraPath)) {
                    PictureSelectionConfig pictureSelectionConfig4 = this.config;
                    uriParUri = MediaUtils.createImageUri(this, pictureSelectionConfig4.cameraFileName, pictureSelectionConfig4.suffixType);
                } else {
                    PictureSelectionConfig pictureSelectionConfig5 = this.config;
                    File fileCreateCameraFile = PictureFileUtils.createCameraFile(this, i10, strRename, pictureSelectionConfig5.suffixType, pictureSelectionConfig5.outPutCameraPath);
                    this.config.cameraPath = fileCreateCameraFile.getAbsolutePath();
                    uriParUri = PictureFileUtils.parUri(this, fileCreateCameraFile);
                }
                if (uriParUri != null) {
                    this.config.cameraPath = uriParUri.toString();
                }
            } else {
                PictureSelectionConfig pictureSelectionConfig6 = this.config;
                File fileCreateCameraFile2 = PictureFileUtils.createCameraFile(this, i10, strRename, pictureSelectionConfig6.suffixType, pictureSelectionConfig6.outPutCameraPath);
                this.config.cameraPath = fileCreateCameraFile2.getAbsolutePath();
                uriParUri = PictureFileUtils.parUri(this, fileCreateCameraFile2);
            }
            if (uriParUri == null) {
                ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                if (this.config.camera) {
                    exit();
                    return;
                }
                return;
            }
            this.config.cameraMimeType = PictureMimeType.ofImage();
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra("output", uriParUri);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    public void startOpenCameraAudio() {
        try {
            if (!PermissionChecker.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
                PermissionChecker.requestPermissions(this, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, 3);
                return;
            }
            Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            if (intent.resolveActivity(getPackageManager()) == null) {
                ToastUtils.s(getContext(), "System recording is not supported");
                return;
            }
            this.config.cameraMimeType = PictureMimeType.ofAudio();
            if (SdkVersionUtils.checkedAndroid_Q()) {
                Uri uriCreateAudioUri = MediaUtils.createAudioUri(this, this.config.suffixType);
                if (uriCreateAudioUri == null) {
                    ToastUtils.s(getContext(), "open is audio error，the uri is empty ");
                    if (this.config.camera) {
                        exit();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = uriCreateAudioUri.toString();
                intent.putExtra("output", uriCreateAudioUri);
            }
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        } catch (Exception e10) {
            e10.printStackTrace();
            ToastUtils.s(getContext(), e10.getMessage());
        }
    }

    public void startOpenCameraVideo() {
        String strRename;
        Uri uriParUri;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            int i10 = pictureSelectionConfig.chooseMode;
            if (i10 == 0) {
                i10 = 2;
            }
            if (TextUtils.isEmpty(pictureSelectionConfig.cameraFileName)) {
                strRename = null;
            } else {
                boolean zIsSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                pictureSelectionConfig2.cameraFileName = zIsSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig2.cameraFileName, ".mp4") : pictureSelectionConfig2.cameraFileName;
                PictureSelectionConfig pictureSelectionConfig3 = this.config;
                boolean z10 = pictureSelectionConfig3.camera;
                strRename = pictureSelectionConfig3.cameraFileName;
                if (!z10) {
                    strRename = StringUtils.rename(strRename);
                }
            }
            if (SdkVersionUtils.checkedAndroid_Q()) {
                if (TextUtils.isEmpty(this.config.outPutCameraPath)) {
                    PictureSelectionConfig pictureSelectionConfig4 = this.config;
                    uriParUri = MediaUtils.createVideoUri(this, pictureSelectionConfig4.cameraFileName, pictureSelectionConfig4.suffixType);
                } else {
                    PictureSelectionConfig pictureSelectionConfig5 = this.config;
                    File fileCreateCameraFile = PictureFileUtils.createCameraFile(this, i10, strRename, pictureSelectionConfig5.suffixType, pictureSelectionConfig5.outPutCameraPath);
                    this.config.cameraPath = fileCreateCameraFile.getAbsolutePath();
                    uriParUri = PictureFileUtils.parUri(this, fileCreateCameraFile);
                }
                if (uriParUri != null) {
                    this.config.cameraPath = uriParUri.toString();
                }
            } else {
                PictureSelectionConfig pictureSelectionConfig6 = this.config;
                File fileCreateCameraFile2 = PictureFileUtils.createCameraFile(this, i10, strRename, pictureSelectionConfig6.suffixType, pictureSelectionConfig6.outPutCameraPath);
                this.config.cameraPath = fileCreateCameraFile2.getAbsolutePath();
                uriParUri = PictureFileUtils.parUri(this, fileCreateCameraFile2);
            }
            if (uriParUri == null) {
                ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                if (this.config.camera) {
                    exit();
                    return;
                }
                return;
            }
            this.config.cameraMimeType = PictureMimeType.ofVideo();
            intent.putExtra("output", uriParUri);
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra(PictureConfig.EXTRA_QUICK_CAPTURE, this.config.isQuickCapture);
            intent.putExtra("android.intent.extra.durationLimit", this.config.recordVideoSecond);
            intent.putExtra("android.intent.extra.videoQuality", this.config.videoQuality);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    public void initCompleteText(List<LocalMedia> list) {
    }
}
