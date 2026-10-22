package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAudioSpeakingImageList;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImage;", "getMaleImage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImage;", "getMaleImage$annotations", "()V", "maleImage", "getFemaleImage", "getFemaleImage$annotations", "femaleImage", "getUnknownImage", "getUnknownImage$annotations", "unknownImage", "getAudioStageSpeakingImage", "getAudioStageSpeakingImage$annotations", "audioStageSpeakingImage", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAudioSpeakingImageList extends c<IAudioSpeakingImageList> {
    public static final Companion Companion = null;
    public static final int FEMALE = 2;
    public static final int MALE = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAudioSpeakingImageList$Companion;", "", "()V", "FEMALE", "", "MALE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int FEMALE = 2;
        public static final int MALE = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "audio_stage_speaking_image")
        public static /* synthetic */ void getAudioStageSpeakingImage$annotations() {
        }

        @FieldName(name = "female_speaking_image")
        public static /* synthetic */ void getFemaleImage$annotations() {
        }

        @FieldName(name = "male_speaking_image")
        public static /* synthetic */ void getMaleImage$annotations() {
        }

        @FieldName(name = "unknown_speaking_image")
        public static /* synthetic */ void getUnknownImage$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "audio_stage_speaking_image")
    ISpeakingImage getAudioStageSpeakingImage();

    @FieldName(name = "female_speaking_image")
    ISpeakingImage getFemaleImage();

    @FieldName(name = "male_speaking_image")
    ISpeakingImage getMaleImage();

    @FieldName(name = "unknown_speaking_image")
    ISpeakingImage getUnknownImage();
}
