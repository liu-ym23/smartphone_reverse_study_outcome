package com.bytedance.android.livesdkapi.depend.model.live.audio;

import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0007\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0007\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00002\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0007\u001a \u0010\u000b\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAudioSpeakingImageList;", "", "isInvalide", "isV2Invalide", "", "state", "Lpy/k;", "getSizeImage", "gender", "enableAudioStageVirtualAvatar", "getGenderImage", "getGenderSizeImage", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IAudioSpeakingImageListKt {
    public static final boolean isInvalide(IAudioSpeakingImageList r100) {
        if (r100 != null) goto L4;
    L16:
        return false;
    L4:
        if (r100.getMaleImage() == null) goto L16;
        if (ISpeakingImageKt.isInvalide(r100.getMaleImage()) == false) goto L16;
        if (r100.getFemaleImage() == null) goto L16;
        if (ISpeakingImageKt.isInvalide(r100.getFemaleImage()) == false) goto L16;
        if (r100.getUnknownImage() == null) goto L16;
        if (ISpeakingImageKt.isInvalide(r100.getUnknownImage()) == false) goto L16;
        return true;
    }

    public static final boolean isV2Invalide(IAudioSpeakingImageList r100) {
        if (r100 != null) goto L4;
    L16:
        return false;
    L4:
        if (r100.getMaleImage() == null) goto L16;
        if (ISpeakingImageKt.isMedimInvalide(r100.getMaleImage()) == false) goto L16;
        if (r100.getFemaleImage() == null) goto L16;
        if (ISpeakingImageKt.isMedimInvalide(r100.getFemaleImage()) == false) goto L16;
        if (r100.getUnknownImage() == null) goto L16;
        if (ISpeakingImageKt.isMedimInvalide(r100.getUnknownImage()) == false) goto L16;
        return true;
    }

    public static final k getSizeImage(IAudioSpeakingImageList r100, int r101) {
        if (r100 == null) goto L5;
        ISpeakingImage r102 = r100.getUnknownImage();
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r101 != 1) goto L15;
        ISpeakingImage r103 = r100.getUnknownImage();
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getLow();
    L15:
        if (r101 != 2) goto L21;
        ISpeakingImage r104 = r100.getUnknownImage();
        if (r104 != null) goto L19;
        return null;
    L19:
        return r104.getMedium();
    L21:
        if (r101 != 3) goto L28;
        ISpeakingImage r105 = r100.getUnknownImage();
        if (r105 != null) goto L25;
        return null;
    L25:
        return r105.getHigh();
    L28:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public static final k getGenderImage(IAudioSpeakingImageList r100, int r101, boolean r102) {
        if (r102 == false) goto L14;
        if (r100 == null) goto L6;
        ISpeakingImage r103 = r100.getAudioStageSpeakingImage();
    L7:
        if (r103 == null) goto L14;
        if (r100 == null) goto L44;
        ISpeakingImage r104 = r100.getAudioStageSpeakingImage();
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104.getMedium();
    L44:
        return null;
    L6:
        r103 = null;
    L14:
        if (r101 != 1) goto L25;
        if (r100 == null) goto L17;
        ISpeakingImage r105 = r100.getMaleImage();
    L18:
        if (r105 == null) goto L25;
        if (r100 == null) goto L46;
        ISpeakingImage r106 = r100.getMaleImage();
        if (r106 != null) goto L23;
        return null;
    L23:
        return r106.getMedium();
    L46:
        return null;
    L17:
        r105 = null;
    L25:
        if (r101 != 2) goto L35;
        if (r100 == null) goto L28;
        ISpeakingImage r107 = r100.getFemaleImage();
    L29:
        if (r107 == null) goto L35;
        if (r100 == null) goto L48;
        ISpeakingImage r108 = r100.getFemaleImage();
        if (r108 != null) goto L34;
        return null;
    L34:
        return r108.getMedium();
    L48:
        return null;
    L28:
        r107 = null;
    L35:
        if (r100 == null) goto L37;
        ISpeakingImage r109 = r100.getUnknownImage();
    L38:
        if (r109 == null) goto L50;
        if (r100 == null) goto L51;
        ISpeakingImage r110 = r100.getUnknownImage();
        if (r110 != null) goto L43;
        return null;
    L43:
        return r110.getMedium();
    L51:
        return null;
    L50:
        return null;
    L37:
        r109 = null;
        goto L38
    }

    public static final k getGenderSizeImage(IAudioSpeakingImageList r100, int r101, int r102) {
        if (r101 != 1) goto L6;
        if (r100 == null) goto L15;
        ISpeakingImage r103 = r100.getMaleImage();
    L16:
        if (r103 != null) goto L18;
        return null;
    L18:
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L25;
        return r103.getMedium();
    L25:
        if (r102 == 3) goto L27;
        return null;
    L27:
        return r103.getHigh();
    L20:
        return r103.getLow();
    L15:
        r103 = null;
        goto L16
    L6:
        if (r101 != 2) goto L9;
        if (r100 == null) goto L15;
        r103 = r100.getFemaleImage();
        goto L16
    L9:
        if (r100 == null) goto L11;
        ISpeakingImage r104 = r100.getUnknownImage();
    L12:
        if (r104 == null) goto L15;
        if (r100 == null) goto L15;
        r103 = r100.getUnknownImage();
        goto L16
    L11:
        r104 = null;
        goto L12
    }

    public static /* synthetic */ k getGenderImage$default(IAudioSpeakingImageList r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return getGenderImage(r100, r101, r102);
    }
}
