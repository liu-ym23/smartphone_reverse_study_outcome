package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class AudioSpeakingImageList extends FlexModelBase<IAudioSpeakingImageList> implements IAudioSpeakingImageList {
    private static final int FEMALE = 2;
    private static final int MALE = 1;

    @IgnoreProtoFieldCheck
    @SerializedName("audio_stage_speaking_image")
    public SpeakingImage audioStageSpeakingImage;

    @SerializedName("female_speaking_image")
    public SpeakingImage femaleImage;

    @SerializedName("male_speaking_image")
    public SpeakingImage maleImage;

    @SerializedName("unknown_speaking_image")
    public SpeakingImage unknownImage;

    public AudioSpeakingImageList() {
        super(IAudioSpeakingImageList.class);
    }

    public boolean isInvalide() {
        SpeakingImage r100 = this.maleImage;
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if (r100.isInvalide() == false) goto L15;
        SpeakingImage r101 = this.femaleImage;
        if (r101 == null) goto L15;
        if (r101.isInvalide() == false) goto L15;
        SpeakingImage r102 = this.unknownImage;
        if (r102 == null) goto L15;
        if (r102.isInvalide() == false) goto L15;
        return true;
    }

    public boolean isV2Invalide() {
        SpeakingImage r100 = this.maleImage;
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if (r100.isMedimInvalide() == false) goto L15;
        SpeakingImage r101 = this.femaleImage;
        if (r101 == null) goto L15;
        if (r101.isMedimInvalide() == false) goto L15;
        SpeakingImage r102 = this.unknownImage;
        if (r102 == null) goto L15;
        if (r102.isMedimInvalide() == false) goto L15;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public /* bridge */ /* synthetic */ ISpeakingImage getFemaleImage() {
        return getFemaleImage();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public /* bridge */ /* synthetic */ ISpeakingImage getMaleImage() {
        return getMaleImage();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public /* bridge */ /* synthetic */ ISpeakingImage getUnknownImage() {
        return getUnknownImage();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public ISpeakingImage getAudioStageSpeakingImage() {
        return this.audioStageSpeakingImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public SpeakingImage getFemaleImage() {
        return this.femaleImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public SpeakingImage getMaleImage() {
        return this.maleImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IAudioSpeakingImageList
    public SpeakingImage getUnknownImage() {
        return this.unknownImage;
    }

    public k getGenderImage(int r100) {
        if (r100 != 1) goto L9;
        SpeakingImage r101 = this.maleImage;
        if (r101 == null) goto L9;
        return r101.medium;
    L9:
        if (r100 != 2) goto L14;
        SpeakingImage r102 = this.femaleImage;
        if (r102 == null) goto L14;
        return r102.medium;
    L14:
        SpeakingImage r103 = this.unknownImage;
        if (r103 != null) goto L17;
        return null;
    L17:
        return r103.medium;
    }

    public k getSizeImage(int r100) {
        SpeakingImage r101 = this.unknownImage;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 != 1) goto L10;
        return r101.low;
    L10:
        if (r100 != 2) goto L14;
        return r101.medium;
    L14:
        if (r100 == 3) goto L16;
        return null;
    L16:
        return r101.high;
    }

    public k getGenderSizeImage(int r100, int r101) {
        if (r100 != 1) goto L5;
        SpeakingImage r102 = this.maleImage;
    L11:
        if (r102 != null) goto L13;
        return null;
    L13:
        if (r101 == 1) goto L15;
        if (r101 != 2) goto L20;
        return r102.medium;
    L20:
        if (r101 == 3) goto L22;
        return null;
    L22:
        return r102.high;
    L15:
        return r102.low;
    L5:
        if (r100 != 2) goto L7;
        r102 = this.femaleImage;
        goto L11
    L7:
        r102 = this.unknownImage;
        if (r102 != null) goto L11;
        r102 = null;
        goto L11
    }
}
