package com.zyql.ai.selector;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.engine.CacheResourcesEngine;
import com.zyql.ai.selector.engine.CompressEngine;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnChooseLimitCallback;
import com.zyql.ai.selector.listener.OnCustomCameraInterfaceListener;
import com.zyql.ai.selector.listener.OnCustomImagePreviewCallback;
import com.zyql.ai.selector.listener.OnPermissionsObtainCallback;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import com.zyql.ai.selector.listener.OnVideoSelectedPlayCallback;
import com.zyql.ai.selector.style.PictureCropParameterStyle;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.style.PictureWindowAnimationStyle;
import com.zyql.ai.selector.tools.DoubleUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes4.dex */
public class PictureSelectionModel {
    private final PictureSelectionConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionModel(PictureSelector pictureSelector, int i10) {
        this.selector = pictureSelector;
        PictureSelectionConfig cleanInstance = PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = cleanInstance;
        cleanInstance.chooseMode = i10;
    }

    public PictureSelectionModel basicUCropConfig(UCrop.Options options) {
        this.selectionConfig.uCropOptions = options;
        return this;
    }

    public PictureSelectionModel bindCustomCameraInterfaceListener(OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        PictureSelectionConfig.onCustomCameraInterfaceListener = (OnCustomCameraInterfaceListener) new WeakReference(onCustomCameraInterfaceListener).get();
        return this;
    }

    public PictureSelectionModel bindCustomChooseLimitListener(OnChooseLimitCallback onChooseLimitCallback) {
        PictureSelectionConfig.onChooseLimitCallback = (OnChooseLimitCallback) new WeakReference(onChooseLimitCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomPermissionsObtainListener(OnPermissionsObtainCallback onPermissionsObtainCallback) {
        PictureSelectionConfig.onPermissionsObtainCallback = (OnPermissionsObtainCallback) new WeakReference(onPermissionsObtainCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomPlayVideoCallback(OnVideoSelectedPlayCallback<LocalMedia> onVideoSelectedPlayCallback) {
        PictureSelectionConfig.customVideoPlayCallback = (OnVideoSelectedPlayCallback) new WeakReference(onVideoSelectedPlayCallback).get();
        return this;
    }

    public PictureSelectionModel bindCustomPreviewCallback(OnCustomImagePreviewCallback<LocalMedia> onCustomImagePreviewCallback) {
        PictureSelectionConfig.onCustomImagePreviewCallback = (OnCustomImagePreviewCallback) new WeakReference(onCustomImagePreviewCallback).get();
        return this;
    }

    @Deprecated
    public PictureSelectionModel bindPictureSelectorInterfaceListener(OnCustomCameraInterfaceListener onCustomCameraInterfaceListener) {
        PictureSelectionConfig.onCustomCameraInterfaceListener = (OnCustomCameraInterfaceListener) new WeakReference(onCustomCameraInterfaceListener).get();
        return this;
    }

    public PictureSelectionModel cameraFileName(String str) {
        this.selectionConfig.cameraFileName = str;
        return this;
    }

    public PictureSelectionModel circleDimmedLayer(boolean z10) {
        this.selectionConfig.circleDimmedLayer = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel closeAndroidQChangeVideoWH(boolean z10) {
        this.selectionConfig.isAndroidQChangeVideoWH = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel closeAndroidQChangeWH(boolean z10) {
        this.selectionConfig.isAndroidQChangeWH = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel compress(boolean z10) {
        this.selectionConfig.isCompress = z10;
        return this;
    }

    public PictureSelectionModel compressEngine(CompressEngine compressEngine) {
        if (PictureSelectionConfig.compressEngine != compressEngine) {
            PictureSelectionConfig.compressEngine = compressEngine;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel compressFocusAlpha(boolean z10) {
        this.selectionConfig.focusAlpha = z10;
        return this;
    }

    public PictureSelectionModel compressQuality(int i10) {
        this.selectionConfig.compressQuality = i10;
        return this;
    }

    public PictureSelectionModel compressSavePath(String str) {
        this.selectionConfig.compressSavePath = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel cropCompressQuality(int i10) {
        this.selectionConfig.cropCompressQuality = i10;
        return this;
    }

    public PictureSelectionModel cropImageWideHigh(int i10, int i11) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.cropWidth = i10;
        pictureSelectionConfig.cropHeight = i11;
        return this;
    }

    @Deprecated
    public PictureSelectionModel cropWH(int i10, int i11) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.cropWidth = i10;
        pictureSelectionConfig.cropHeight = i11;
        return this;
    }

    public PictureSelectionModel cutCompressFormat(String str) {
        this.selectionConfig.cropCompressFormat = str;
        return this;
    }

    public PictureSelectionModel cutOutQuality(int i10) {
        this.selectionConfig.cropCompressQuality = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel enableCrop(boolean z10) {
        this.selectionConfig.enableCrop = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel enablePreviewAudio(boolean z10) {
        this.selectionConfig.enablePreviewAudio = z10;
        return this;
    }

    public void externalPictureVideo(String str) {
        PictureSelector pictureSelector = this.selector;
        if (pictureSelector == null) {
            throw new NullPointerException("This PictureSelector is Null");
        }
        pictureSelector.externalPictureVideo(str);
    }

    public PictureSelectionModel filterMaxFileSize(long j10) {
        if (j10 >= PictureConfig.MB) {
            this.selectionConfig.filterMaxFileSize = j10;
            return this;
        }
        this.selectionConfig.filterMaxFileSize = j10 * 1024;
        return this;
    }

    public PictureSelectionModel filterMinFileSize(long j10) {
        if (j10 >= PictureConfig.MB) {
            this.selectionConfig.filterMinFileSize = j10;
            return this;
        }
        this.selectionConfig.filterMinFileSize = j10 * 1024;
        return this;
    }

    public void forResult(int i10) {
        Activity activity;
        PictureSelectionConfig pictureSelectionConfig;
        Intent intent;
        if (DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || (pictureSelectionConfig = this.selectionConfig) == null) {
            return;
        }
        if (pictureSelectionConfig.camera && pictureSelectionConfig.isUseCustomCamera) {
            intent = new Intent(activity, (Class<?>) PictureCustomCameraActivity.class);
        } else {
            PictureSelectionConfig pictureSelectionConfig2 = this.selectionConfig;
            intent = new Intent(activity, (Class<?>) (pictureSelectionConfig2.camera ? PictureSelectorCameraEmptyActivity.class : pictureSelectionConfig2.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class));
        }
        this.selectionConfig.isCallbackMode = false;
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i10);
        } else {
            activity.startActivityForResult(intent, i10);
        }
        activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
    }

    public PictureSelectionModel freeStyleCropEnabled(boolean z10) {
        this.selectionConfig.freeStyleCropEnabled = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel glideOverride(int i10, int i11) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.overrideWidth = i10;
        pictureSelectionConfig.overrideHeight = i11;
        return this;
    }

    public PictureSelectionModel hideBottomControls(boolean z10) {
        this.selectionConfig.hideBottomControls = z10;
        return this;
    }

    public PictureSelectionModel imageEngine(ImageEngine imageEngine) {
        if (PictureSelectionConfig.imageEngine != imageEngine) {
            PictureSelectionConfig.imageEngine = imageEngine;
        }
        return this;
    }

    public PictureSelectionModel imageFormat(String str) {
        if (SdkVersionUtils.checkedAndroid_Q() || SdkVersionUtils.checkedAndroid_R()) {
            if (TextUtils.equals(str, PictureMimeType.PNG)) {
                str = PictureMimeType.PNG_Q;
            }
            if (TextUtils.equals(str, PictureMimeType.JPG)) {
                str = "image/jpeg";
            }
            if (TextUtils.equals(str, ".mp4")) {
                str = "video/mp4";
            }
        }
        this.selectionConfig.suffixType = str;
        return this;
    }

    public PictureSelectionModel imageSpanCount(int i10) {
        this.selectionConfig.imageSpanCount = i10;
        return this;
    }

    public PictureSelectionModel isAndroidQTransform(boolean z10) {
        this.selectionConfig.isAndroidQTransform = z10;
        return this;
    }

    public PictureSelectionModel isAutoRotating(boolean z10) {
        this.selectionConfig.isAutoRotating = z10;
        return this;
    }

    public PictureSelectionModel isAutoScalePreviewImage(boolean z10) {
        this.selectionConfig.isAutoScalePreviewImage = z10;
        return this;
    }

    public PictureSelectionModel isAutomaticTitleRecyclerTop(boolean z10) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = z10;
        return this;
    }

    public PictureSelectionModel isBmp(boolean z10) {
        this.selectionConfig.isBmp = z10;
        return this;
    }

    public PictureSelectionModel isCamera(boolean z10) {
        this.selectionConfig.isCamera = z10;
        return this;
    }

    public PictureSelectionModel isCameraAroundState(boolean z10) {
        this.selectionConfig.isCameraAroundState = z10;
        return this;
    }

    public PictureSelectionModel isCameraRotateImage(boolean z10) {
        this.selectionConfig.isCameraRotateImage = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isChangeStatusBarFontColor(boolean z10) {
        this.selectionConfig.isChangeStatusBarFontColor = z10;
        return this;
    }

    public PictureSelectionModel isCompress(boolean z10) {
        this.selectionConfig.isCompress = z10;
        return this;
    }

    public PictureSelectionModel isDragFrame(boolean z10) {
        this.selectionConfig.isDragFrame = z10;
        return this;
    }

    public PictureSelectionModel isEnableCrop(boolean z10) {
        this.selectionConfig.enableCrop = z10;
        return this;
    }

    public PictureSelectionModel isEnablePreviewAudio(boolean z10) {
        this.selectionConfig.enablePreviewAudio = z10;
        return this;
    }

    public PictureSelectionModel isFallbackVersion(boolean z10) {
        this.selectionConfig.isFallbackVersion = z10;
        return this;
    }

    public PictureSelectionModel isFallbackVersion2(boolean z10) {
        this.selectionConfig.isFallbackVersion2 = z10;
        return this;
    }

    public PictureSelectionModel isFallbackVersion3(boolean z10) {
        this.selectionConfig.isFallbackVersion3 = z10;
        return this;
    }

    public PictureSelectionModel isGif(boolean z10) {
        this.selectionConfig.isGif = z10;
        return this;
    }

    public PictureSelectionModel isMaxSelectEnabledMask(boolean z10) {
        this.selectionConfig.isMaxSelectEnabledMask = z10;
        return this;
    }

    public PictureSelectionModel isMultipleRecyclerAnimation(boolean z10) {
        this.selectionConfig.isMultipleRecyclerAnimation = z10;
        return this;
    }

    public PictureSelectionModel isMultipleSkipCrop(boolean z10) {
        this.selectionConfig.isMultipleSkipCrop = z10;
        return this;
    }

    public PictureSelectionModel isNotPreviewDownload(boolean z10) {
        this.selectionConfig.isNotPreviewDownload = z10;
        return this;
    }

    public PictureSelectionModel isOpenClickSound(boolean z10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.openClickSound = !pictureSelectionConfig.camera && z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isOpenStyleCheckNumMode(boolean z10) {
        this.selectionConfig.isOpenStyleCheckNumMode = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isOpenStyleNumComplete(boolean z10) {
        this.selectionConfig.isOpenStyleNumComplete = z10;
        return this;
    }

    public PictureSelectionModel isOriginalImageControl(boolean z10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isOriginalControl = (pictureSelectionConfig.camera || pictureSelectionConfig.chooseMode == PictureMimeType.ofVideo() || this.selectionConfig.chooseMode == PictureMimeType.ofAudio() || !z10) ? false : true;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z10, int i10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isPageStrategy = z10;
        if (i10 < 10) {
            i10 = 60;
        }
        pictureSelectionConfig.pageSize = i10;
        return this;
    }

    public PictureSelectionModel isPreviewEggs(boolean z10) {
        this.selectionConfig.previewEggs = z10;
        return this;
    }

    public PictureSelectionModel isPreviewImage(boolean z10) {
        this.selectionConfig.enablePreview = z10;
        return this;
    }

    public PictureSelectionModel isPreviewVideo(boolean z10) {
        this.selectionConfig.enPreviewVideo = z10;
        return this;
    }

    public PictureSelectionModel isQuickCapture(boolean z10) {
        this.selectionConfig.isQuickCapture = z10;
        return this;
    }

    public PictureSelectionModel isReturnEmpty(boolean z10) {
        this.selectionConfig.returnEmpty = z10;
        return this;
    }

    public PictureSelectionModel isSingleDirectReturn(boolean z10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        int i10 = pictureSelectionConfig.selectionMode;
        boolean z11 = false;
        pictureSelectionConfig.isSingleDirectReturn = i10 == 1 && z10;
        if ((i10 != 1 || !z10) && pictureSelectionConfig.isOriginalControl) {
            z11 = true;
        }
        pictureSelectionConfig.isOriginalControl = z11;
        return this;
    }

    public PictureSelectionModel isSyncCover(boolean z10) {
        this.selectionConfig.isSyncCover = z10;
        return this;
    }

    public PictureSelectionModel isUseCustomCamera(boolean z10) {
        this.selectionConfig.isUseCustomCamera = z10;
        return this;
    }

    public PictureSelectionModel isWeChatStyle(boolean z10) {
        this.selectionConfig.isWeChatStyle = z10;
        return this;
    }

    public PictureSelectionModel isWebp(boolean z10) {
        this.selectionConfig.isWebp = z10;
        return this;
    }

    public PictureSelectionModel isWithVideoImage(boolean z10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isWithVideoImage = pictureSelectionConfig.selectionMode != 1 && pictureSelectionConfig.chooseMode == PictureMimeType.ofAll() && z10;
        return this;
    }

    public PictureSelectionModel isZoomAnim(boolean z10) {
        this.selectionConfig.zoomAnim = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel loadCacheResourcesCallback(CacheResourcesEngine cacheResourcesEngine) {
        if (SdkVersionUtils.checkedAndroid_Q() && PictureSelectionConfig.cacheResourcesEngine != cacheResourcesEngine) {
            PictureSelectionConfig.cacheResourcesEngine = (CacheResourcesEngine) new WeakReference(cacheResourcesEngine).get();
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel loadImageEngine(ImageEngine imageEngine) {
        if (PictureSelectionConfig.imageEngine != imageEngine) {
            PictureSelectionConfig.imageEngine = imageEngine;
        }
        return this;
    }

    public PictureSelectionModel maxSelectNum(int i10) {
        this.selectionConfig.maxSelectNum = i10;
        return this;
    }

    public PictureSelectionModel maxVideoSelectNum(int i10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig.chooseMode == PictureMimeType.ofVideo()) {
            i10 = 0;
        }
        pictureSelectionConfig.maxVideoSelectNum = i10;
        return this;
    }

    public PictureSelectionModel minSelectNum(int i10) {
        this.selectionConfig.minSelectNum = i10;
        return this;
    }

    public PictureSelectionModel minVideoSelectNum(int i10) {
        this.selectionConfig.minVideoSelectNum = i10;
        return this;
    }

    public PictureSelectionModel minimumCompressSize(int i10) {
        this.selectionConfig.minimumCompressSize = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel openClickSound(boolean z10) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.openClickSound = !pictureSelectionConfig.camera && z10;
        return this;
    }

    public void openExternalPreview(int i10, List<LocalMedia> list) {
        PictureSelector pictureSelector = this.selector;
        if (pictureSelector == null) {
            throw new NullPointerException("This PictureSelector is Null");
        }
        pictureSelector.externalPicturePreview(i10, list, PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
    }

    @Deprecated
    public PictureSelectionModel previewEggs(boolean z10) {
        this.selectionConfig.previewEggs = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewImage(boolean z10) {
        this.selectionConfig.enablePreview = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel previewVideo(boolean z10) {
        this.selectionConfig.enPreviewVideo = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel queryFileSize(float f10) {
        this.selectionConfig.filterFileSize = f10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel queryMaxFileSize(float f10) {
        this.selectionConfig.filterFileSize = f10;
        return this;
    }

    public PictureSelectionModel queryMimeTypeConditions(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            this.selectionConfig.queryMimeTypeHashSet = null;
            return this;
        }
        this.selectionConfig.queryMimeTypeHashSet = new HashSet<>(Arrays.asList(strArr));
        return this;
    }

    @Deprecated
    public PictureSelectionModel querySpecifiedFormatSuffix(String str) {
        this.selectionConfig.specifiedFormat = str;
        return this;
    }

    public PictureSelectionModel recordVideoMinSecond(int i10) {
        this.selectionConfig.recordVideoMinSecond = i10;
        return this;
    }

    public PictureSelectionModel recordVideoSecond(int i10) {
        this.selectionConfig.recordVideoSecond = i10;
        return this;
    }

    public PictureSelectionModel renameCompressFile(String str) {
        this.selectionConfig.renameCompressFileName = str;
        return this;
    }

    public PictureSelectionModel renameCropFileName(String str) {
        this.selectionConfig.renameCropFileName = str;
        return this;
    }

    public PictureSelectionModel rotateEnabled(boolean z10) {
        this.selectionConfig.rotateEnabled = z10;
        return this;
    }

    public PictureSelectionModel scaleEnabled(boolean z10) {
        this.selectionConfig.scaleEnabled = z10;
        return this;
    }

    public PictureSelectionModel selectionData(List<LocalMedia> list) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.isSingleDirectReturn) {
            pictureSelectionConfig.selectionMedias = null;
            return this;
        }
        pictureSelectionConfig.selectionMedias = list;
        return this;
    }

    @Deprecated
    public PictureSelectionModel selectionMedia(List<LocalMedia> list) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.isSingleDirectReturn) {
            pictureSelectionConfig.selectionMedias = null;
            return this;
        }
        pictureSelectionConfig.selectionMedias = list;
        return this;
    }

    public PictureSelectionModel selectionMode(int i10) {
        this.selectionConfig.selectionMode = i10;
        return this;
    }

    public PictureSelectionModel setButtonFeatures(int i10) {
        this.selectionConfig.buttonFeatures = i10;
        return this;
    }

    public PictureSelectionModel setCaptureLoadingColor(int i10) {
        this.selectionConfig.captureLoadingColor = i10;
        return this;
    }

    public PictureSelectionModel setCircleDimmedBorderColor(int i10) {
        this.selectionConfig.circleDimmedBorderColor = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCircleDimmedColor(int i10) {
        this.selectionConfig.circleDimmedColor = i10;
        return this;
    }

    public PictureSelectionModel setCircleStrokeWidth(int i10) {
        this.selectionConfig.circleStrokeWidth = i10;
        return this;
    }

    public PictureSelectionModel setCropDimmedColor(int i10) {
        this.selectionConfig.circleDimmedColor = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropStatusBarColorPrimaryDark(int i10) {
        this.selectionConfig.cropStatusBarColorPrimaryDark = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropTitleBarBackgroundColor(int i10) {
        this.selectionConfig.cropTitleBarBackgroundColor = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropTitleColor(int i10) {
        this.selectionConfig.cropTitleColor = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setDownArrowDrawable(int i10) {
        this.selectionConfig.downResId = i10;
        return this;
    }

    public PictureSelectionModel setLanguage(int i10) {
        this.selectionConfig.language = i10;
        return this;
    }

    public PictureSelectionModel setOutputCameraPath(String str) {
        this.selectionConfig.outPutCameraPath = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setPictureCropStyle(PictureCropParameterStyle pictureCropParameterStyle) {
        if (pictureCropParameterStyle != null) {
            PictureSelectionConfig.cropStyle = pictureCropParameterStyle;
            return this;
        }
        PictureSelectionConfig.cropStyle = PictureCropParameterStyle.ofDefaultCropStyle();
        return this;
    }

    @Deprecated
    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        if (pictureParameterStyle == null) {
            PictureSelectionConfig.style = PictureParameterStyle.ofDefaultStyle();
            return this;
        }
        PictureSelectionConfig.style = pictureParameterStyle;
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (!pictureSelectionConfig.isWeChatStyle) {
            pictureSelectionConfig.isWeChatStyle = pictureParameterStyle.isNewSelectStyle;
        }
        return this;
    }

    public PictureSelectionModel setPictureUIStyle(PictureSelectorUIStyle pictureSelectorUIStyle) {
        if (pictureSelectorUIStyle != null) {
            PictureSelectionConfig.uiStyle = pictureSelectorUIStyle;
            PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
            if (!pictureSelectionConfig.isWeChatStyle) {
                pictureSelectionConfig.isWeChatStyle = pictureSelectorUIStyle.isNewSelectStyle;
            }
        }
        return this;
    }

    public PictureSelectionModel setPictureWindowAnimationStyle(PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        if (pictureWindowAnimationStyle != null) {
            PictureSelectionConfig.windowAnimationStyle = pictureWindowAnimationStyle;
            return this;
        }
        PictureSelectionConfig.windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        return this;
    }

    public PictureSelectionModel setRecyclerAnimationMode(int i10) {
        this.selectionConfig.animationMode = i10;
        return this;
    }

    public PictureSelectionModel setRequestedOrientation(int i10) {
        this.selectionConfig.requestedOrientation = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setStatusBarColorPrimaryDark(int i10) {
        this.selectionConfig.pictureStatusBarColor = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setTitleBarBackgroundColor(int i10) {
        this.selectionConfig.titleBarBackgroundColor = i10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setUpArrowDrawable(int i10) {
        this.selectionConfig.upResId = i10;
        return this;
    }

    public PictureSelectionModel showCropFrame(boolean z10) {
        this.selectionConfig.showCropFrame = z10;
        return this;
    }

    public PictureSelectionModel showCropGrid(boolean z10) {
        this.selectionConfig.showCropGrid = z10;
        return this;
    }

    @Deprecated
    public PictureSelectionModel sizeMultiplier(float f10) {
        this.selectionConfig.sizeMultiplier = f10;
        return this;
    }

    public PictureSelectionModel synOrAsy(boolean z10) {
        this.selectionConfig.synOrAsy = z10;
        return this;
    }

    public PictureSelectionModel theme(int i10) {
        this.selectionConfig.themeStyleId = i10;
        return this;
    }

    public PictureSelectionModel videoMaxSecond(int i10) {
        this.selectionConfig.videoMaxSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionModel videoMinSecond(int i10) {
        this.selectionConfig.videoMinSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionModel videoQuality(int i10) {
        this.selectionConfig.videoQuality = i10;
        return this;
    }

    public PictureSelectionModel withAspectRatio(int i10, int i11) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.aspect_ratio_x = i10;
        pictureSelectionConfig.aspect_ratio_y = i11;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z10, int i10, boolean z11) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isPageStrategy = z10;
        if (i10 < 10) {
            i10 = 60;
        }
        pictureSelectionConfig.pageSize = i10;
        pictureSelectionConfig.isFilterInvalidFile = z11;
        return this;
    }

    @Deprecated
    public void openExternalPreview(int i10, String str, List<LocalMedia> list) {
        PictureSelector pictureSelector = this.selector;
        if (pictureSelector != null) {
            pictureSelector.externalPicturePreview(i10, str, list, PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation);
            return;
        }
        throw new NullPointerException("This PictureSelector is Null");
    }

    public PictureSelectionModel(PictureSelector pictureSelector, int i10, boolean z10) {
        this.selector = pictureSelector;
        PictureSelectionConfig cleanInstance = PictureSelectionConfig.getCleanInstance();
        this.selectionConfig = cleanInstance;
        cleanInstance.camera = z10;
        cleanInstance.chooseMode = i10;
    }

    public PictureSelectionModel isPageStrategy(boolean z10) {
        this.selectionConfig.isPageStrategy = z10;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z10, boolean z11) {
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isPageStrategy = z10;
        pictureSelectionConfig.isFilterInvalidFile = z11;
        return this;
    }

    @Deprecated
    public void forResult(int i10, int i11, int i12) {
        Activity activity;
        Class cls;
        if (DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        if (pictureSelectionConfig != null && pictureSelectionConfig.camera) {
            cls = PictureSelectorCameraEmptyActivity.class;
        } else {
            cls = pictureSelectionConfig.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class;
        }
        Intent intent = new Intent(activity, (Class<?>) cls);
        this.selectionConfig.isCallbackMode = false;
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i10);
        } else {
            activity.startActivityForResult(intent, i10);
        }
        activity.overridePendingTransition(i11, i12);
    }

    public void forResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Activity activity;
        Intent intent;
        Class cls;
        if (DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || this.selectionConfig == null) {
            return;
        }
        PictureSelectionConfig.listener = (OnResultCallbackListener) new WeakReference(onResultCallbackListener).get();
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isCallbackMode = true;
        if (pictureSelectionConfig.camera && pictureSelectionConfig.isUseCustomCamera) {
            intent = new Intent(activity, (Class<?>) PictureCustomCameraActivity.class);
        } else {
            PictureSelectionConfig pictureSelectionConfig2 = this.selectionConfig;
            if (pictureSelectionConfig2.camera) {
                cls = PictureSelectorCameraEmptyActivity.class;
            } else {
                cls = pictureSelectionConfig2.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class;
            }
            intent = new Intent(activity, (Class<?>) cls);
        }
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
        activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
    }

    public void forResult(int i10, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Activity activity;
        Intent intent;
        Class cls;
        if (DoubleUtils.isFastDoubleClick() || (activity = this.selector.getActivity()) == null || this.selectionConfig == null) {
            return;
        }
        PictureSelectionConfig.listener = (OnResultCallbackListener) new WeakReference(onResultCallbackListener).get();
        PictureSelectionConfig pictureSelectionConfig = this.selectionConfig;
        pictureSelectionConfig.isCallbackMode = true;
        if (pictureSelectionConfig.camera && pictureSelectionConfig.isUseCustomCamera) {
            intent = new Intent(activity, (Class<?>) PictureCustomCameraActivity.class);
        } else {
            PictureSelectionConfig pictureSelectionConfig2 = this.selectionConfig;
            if (pictureSelectionConfig2.camera) {
                cls = PictureSelectorCameraEmptyActivity.class;
            } else {
                cls = pictureSelectionConfig2.isWeChatStyle ? PictureSelectorWeChatStyleActivity.class : PictureSelectorActivity.class;
            }
            intent = new Intent(activity, (Class<?>) cls);
        }
        Fragment fragment = this.selector.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, i10);
        } else {
            activity.startActivityForResult(intent, i10);
        }
        activity.overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
    }
}
