package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\f\u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a6\u0010\u000e\u001a\u0004\u0018\u00010\u0000*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0002\"\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010\"\u0015\u0010\u0012\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u0015\u0010\u0013\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010\"\u0015\u0010\u0014\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010\"\u0015\u0010\u0015\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010\"\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lpy/k;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "isImageModelValid", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "isValid", "theme", "isSourceEqual", "", "type", "talkState", "gender", "style", "enableAudioStageVirtualAvatar", "getVolumeAnim", "isVoiceAnimInvalid", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)Z", "isUgcImage", "isAddImage", "isUgcVideoTheme", "isVideoTheme", "isConfig", "isLocalUgcTheme", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IVoiceLiveThemeKt {
    public static final boolean isAddImage(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAddImage");
        if (r100.getImageType() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isConfig(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isConfig");
        if (r100.getImageType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isImageModelValid(k r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ((!r100.getUrls().isEmpty()) == false) goto L6;
        return true;
    }

    public static final boolean isLocalUgcTheme(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLocalUgcTheme");
        if (isUgcImage(r100) == true) goto L5;
        return false;
    L5:
        if (r100.getStaticBackground() == null) goto L7;
        return false;
    L7:
        if (r100.getLocalPath().length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r101 = false;
        goto L10
    }

    public static final boolean isUgcImage(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isUgcImage");
        if (r100.getImageType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean isUgcVideoTheme(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isUgcVideoTheme");
        if (r100.getImageType() == 1) goto L5;
    L24:
        return false;
    L5:
        if (r100.getAnimatedBgInfo() == null) goto L24;
        IAnimatedBgInfo r101 = r100.getAnimatedBgInfo();
        String r102 = null;
        if (r101 == null) goto L9;
        k r103 = r101.getAnimatedBg();
    L10:
        if (r103 == null) goto L24;
        IAnimatedBgInfo r104 = r100.getAnimatedBgInfo();
        if (r104 == null) goto L16;
        k r105 = r104.getAnimatedBg();
        if (r105 == null) goto L16;
        String r106 = r105.getUri();
    L17:
        if (r106 == null) goto L24;
        IAnimatedBgInfo r107 = r100.getAnimatedBgInfo();
        if (r107 == null) goto L22;
        r102 = r107.getFileFormat();
    L22:
        if (Intrinsics.areEqual("mp4", r102) == false) goto L24;
        return true;
    L16:
        r106 = null;
        goto L17
    L9:
        r103 = null;
        goto L10
    }

    public static final boolean isValid(IVoiceLiveTheme r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getStaticBackground() == null) goto L13;
        k r101 = r100.getStaticBackground();
        if (r101 == null) goto L13;
        List<String> r102 = r101.getUrls();
        if (r102 == null) goto L13;
        if ((!r102.isEmpty()) != true) goto L13;
        return true;
    L13:
        if (r100.getSingleStaticBackground() == null) goto L22;
        k r103 = r100.getSingleStaticBackground();
        if (r103 == null) goto L22;
        List<String> r104 = r103.getUrls();
        if (r104 == null) goto L22;
        if ((!r104.isEmpty()) != true) goto L22;
        return true;
    L22:
        if (r100.getAnimatedBgInfo() == null) goto L39;
        IAnimatedBgInfo r105 = r100.getAnimatedBgInfo();
        if (r105 == null) goto L26;
        k r106 = r105.getAnimatedBg();
    L27:
        if (r106 == null) goto L40;
        IAnimatedBgInfo r107 = r100.getAnimatedBgInfo();
        if (r107 == null) goto L41;
        k r108 = r107.getAnimatedBg();
        if (r108 == null) goto L42;
        List<String> r109 = r108.getUrls();
        if (r109 != null) goto L35;
        return false;
    L35:
        if ((!r109.isEmpty()) != true) goto L44;
        return true;
    L44:
        return false;
    L42:
        return false;
    L41:
        return false;
    L40:
        return false;
    L26:
        r106 = null;
        goto L27
    L39:
        return false;
    }

    public static final boolean isVideoTheme(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVideoTheme");
        if (r100.getAnimatedBgInfo() == null) goto L40;
        IAnimatedBgInfo r101 = r100.getAnimatedBgInfo();
        String r102 = null;
        if (r101 == null) goto L7;
        k r103 = r101.getAnimatedBg();
    L8:
        if (r103 == null) goto L40;
        IAnimatedBgInfo r104 = r100.getAnimatedBgInfo();
        if (r104 == null) goto L14;
        k r105 = r104.getAnimatedBg();
        if (r105 == null) goto L14;
        List<String> r106 = r105.getUrls();
    L15:
        if (r106 == null) goto L40;
        IAnimatedBgInfo r107 = r100.getAnimatedBgInfo();
        if (r107 == null) goto L19;
        String r108 = r107.getFileFormat();
    L21:
        if (Intrinsics.areEqual("mp4", r108) == true) goto L39;
        IAnimatedBgInfo r109 = r100.getAnimatedBgInfo();
        if (r109 == null) goto L25;
        String r110 = r109.getFileFormat();
    L27:
        if (Intrinsics.areEqual("gif", r110) == true) goto L39;
        IAnimatedBgInfo r111 = r100.getAnimatedBgInfo();
        if (r111 == null) goto L31;
        String r112 = r111.getFileFormat();
    L33:
        if (Intrinsics.areEqual("webp", r112) == true) goto L39;
        IAnimatedBgInfo r113 = r100.getAnimatedBgInfo();
        if (r113 == null) goto L38;
        r102 = r113.getFileFormat();
    L38:
        if (Intrinsics.areEqual("mov", r102) == false) goto L40;
    L31:
        r112 = null;
        goto L33
    L25:
        r110 = null;
    L39:
        return true;
    L19:
        r108 = null;
    L14:
        r106 = null;
        goto L15
    L7:
        r103 = null;
    L40:
        return false;
    }

    public static final boolean isVoiceAnimInvalid(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVoiceAnimInvalid");
        if (r100.getSpeakImageList() == null) goto L7;
        if (IAudioSpeakingImageListKt.isInvalide(r100.getSpeakImageList()) == false) goto L7;
    L10:
        return true;
    L7:
        if (r100.getSpeakImageListV2() != null) goto L9;
    L11:
        return false;
    L9:
        if (IAudioSpeakingImageListKt.isV2Invalide(r100.getSpeakImageListV2()) == false) goto L11;
        goto L10
    }

    public static final boolean isImageModelValid(IVoiceLiveTheme r100, k r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r101.getUrls().isEmpty() == true) goto L6;
        return true;
    }

    public static final boolean isSourceEqual(IVoiceLiveTheme r100, IVoiceLiveTheme r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSourceEqual");
        Intrinsics.checkNotNullParameter(r101, "theme");
        if (isLocalUgcTheme(r100) == false) goto L8;
        if (Intrinsics.areEqual(r100.getLocalPath(), r101.getLocalPath()) == false) goto L8;
        return true;
    L8:
        if (r100.getImageUri() == null) goto L15;
        if (Intrinsics.areEqual(r100.getImageUri(), r101.getImageUri()) == false) goto L15;
        if (r100.getBgStatus() != r101.getBgStatus()) goto L15;
        return true;
    L15:
        if (r100.getAnimatedBgInfo() != null) goto L17;
        return false;
    L17:
        if (r101.getAnimatedBgInfo() == null) goto L60;
        IAnimatedBgInfo r102 = r100.getAnimatedBgInfo();
        String r103 = null;
        if (r102 == null) goto L21;
        k r104 = r102.getAnimatedBg();
    L22:
        if (r104 == null) goto L61;
        IAnimatedBgInfo r105 = r101.getAnimatedBgInfo();
        if (r105 == null) goto L26;
        k r106 = r105.getAnimatedBg();
    L27:
        if (r106 == null) goto L62;
        IAnimatedBgInfo r107 = r100.getAnimatedBgInfo();
        if (r107 == null) goto L33;
        k r108 = r107.getAnimatedBg();
        if (r108 == null) goto L33;
        String r109 = r108.getUri();
    L34:
        if (r109 == null) goto L63;
        IAnimatedBgInfo r110 = r101.getAnimatedBgInfo();
        if (r110 == null) goto L40;
        k r111 = r110.getAnimatedBg();
        if (r111 == null) goto L40;
        String r112 = r111.getUri();
    L41:
        if (r112 == null) goto L64;
        IAnimatedBgInfo r113 = r100.getAnimatedBgInfo();
        if (r113 == null) goto L47;
        k r114 = r113.getAnimatedBg();
        if (r114 == null) goto L47;
        String r115 = r114.getUri();
    L48:
        IAnimatedBgInfo r116 = r101.getAnimatedBgInfo();
        if (r116 == null) goto L54;
        k r117 = r116.getAnimatedBg();
        if (r117 == null) goto L54;
        r103 = r117.getUri();
    L54:
        if (Intrinsics.areEqual(r115, r103) == true) goto L56;
        return false;
    L56:
        if (r100.getBgStatus() != r101.getBgStatus()) goto L66;
        return true;
    L66:
        return false;
    L47:
        r115 = null;
        goto L48
    L64:
        return false;
    L40:
        r112 = null;
        goto L41
    L63:
        return false;
    L33:
        r109 = null;
        goto L34
    L62:
        return false;
    L26:
        r106 = null;
        goto L27
    L61:
        return false;
    L21:
        r104 = null;
        goto L22
    L60:
        return false;
    }

    public static final k getVolumeAnim(IVoiceLiveTheme r100, int r101, int r102, int r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$getVolumeAnim");
        k r106 = r100.getEffectAvatarTalk();
        if (r104 == 1) goto L5;
        if (r104 != 2) goto L46;
        if (r100.getSpeakImageListV2() == null) goto L42;
        if (IAudioSpeakingImageListKt.isV2Invalide(r100.getSpeakImageListV2()) == false) goto L42;
        return IAudioSpeakingImageListKt.getGenderImage(r100.getSpeakImageListV2(), r103, r105);
    L42:
        if (r100.getSpeakImageList() != null) goto L44;
        return r106;
    L44:
        return IAudioSpeakingImageListKt.getGenderImage(r100.getSpeakImageList(), r103, r105);
    L46:
        if (r100.getSpeakImageList() != null) goto L48;
        return r106;
    L48:
        if (r101 == 1) goto L61;
        if (r101 != 2) goto L53;
        return IAudioSpeakingImageListKt.getGenderImage$default(r100.getSpeakImageList(), r103, false, 2, null);
    L53:
        if (r101 == 3) goto L55;
        return r106;
    L55:
        return IAudioSpeakingImageListKt.getGenderSizeImage(r100.getSpeakImageList(), r103, r102);
    L61:
        return IAudioSpeakingImageListKt.getSizeImage(r100.getSpeakImageList(), r102);
    L5:
        if (r100.getSpeakImageListV2() == null) goto L31;
        IAudioSpeakingImageList r107 = r100.getSpeakImageListV2();
        if (r107 == null) goto L9;
        ISpeakingImage r108 = r107.getUnknownImage();
    L10:
        if (r108 == null) goto L31;
        if (r105 == false) goto L23;
        IAudioSpeakingImageList r109 = r100.getSpeakImageListV2();
        if (r109 == null) goto L16;
        ISpeakingImage r110 = r109.getAudioStageSpeakingImage();
    L17:
        if (r110 == null) goto L23;
        IAudioSpeakingImageList r111 = r100.getSpeakImageListV2();
        if (r111 == null) goto L59;
        ISpeakingImage r112 = r111.getAudioStageSpeakingImage();
        if (r112 == null) goto L59;
        k r113 = r112.getMedium();
    L58:
        return r113;
    L59:
        return null;
    L16:
        r110 = null;
    L23:
        IAudioSpeakingImageList r114 = r100.getSpeakImageListV2();
        if (r114 == null) goto L59;
        ISpeakingImage r115 = r114.getUnknownImage();
        if (r115 == null) goto L59;
        r113 = r115.getMedium();
        goto L58
    L9:
        r108 = null;
    L31:
        if (r100.getSpeakImageList() != null) goto L33;
        return r106;
    L33:
        return IAudioSpeakingImageListKt.getSizeImage(r100.getSpeakImageList(), 2);
    }

    public static /* synthetic */ k getVolumeAnim$default(IVoiceLiveTheme r100, int r101, int r102, int r103, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return getVolumeAnim(r100, r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }
}
