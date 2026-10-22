package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class SpeakingImage extends FlexModelBase<ISpeakingImage> implements ISpeakingImage {
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int NONE = 0;

    @SerializedName("speaking_high_image")
    public k high;

    @SerializedName("speaking_low_image")
    public k low;

    @SerializedName("speaking_default_image")
    public k medium;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ValidVoiceVolume {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VoiceVolume {
    }

    public static boolean supportTalkEnum(int r100) {
        if (r100 >= 0) goto L6;
        r100 = 0;
    L6:
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L13;
        return false;
    L13:
        return true;
    }

    public SpeakingImage() {
        super(ISpeakingImage.class);
    }

    public boolean isInvalide() {
        if (this.low != null) goto L5;
    L9:
        return false;
    L5:
        if (this.medium == null) goto L9;
        if (this.high == null) goto L9;
        return true;
    }

    public boolean isMedimInvalide() {
        if (this.medium == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.ISpeakingImageDef
    public k getHigh() {
        return this.high;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.ISpeakingImageDef
    public k getLow() {
        return this.low;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.ISpeakingImageDef
    public k getMedium() {
        return this.medium;
    }
}
