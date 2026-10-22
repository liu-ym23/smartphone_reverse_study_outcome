package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0011\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006R\"\u0010\u0015\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "Lvh7/c;", "", "getEpisodeStage", "()I", "setEpisodeStage", "(I)V", "getEpisodeStage$annotations", "()V", "episodeStage", "getEpisodeType", "setEpisodeType", "getEpisodeType$annotations", "episodeType", "getEpisodeSubType", "setEpisodeSubType", "getEpisodeSubType$annotations", "episodeSubType", "getEpisodeRecordType", "setEpisodeRecordType", "getEpisodeRecordType$annotations", "episodeRecordType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBaseEpisodeMod extends c<IBaseEpisodeMod> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "episode_record_type")
        public static /* synthetic */ void getEpisodeRecordType$annotations() {
        }

        @FieldName(name = "episode_stage")
        public static /* synthetic */ void getEpisodeStage$annotations() {
        }

        @FieldName(name = "episode_sub_type")
        public static /* synthetic */ void getEpisodeSubType$annotations() {
        }

        @FieldName(name = "episode_type")
        public static /* synthetic */ void getEpisodeType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "episode_record_type")
    int getEpisodeRecordType();

    @FieldName(name = "episode_stage")
    int getEpisodeStage();

    @FieldName(name = "episode_sub_type")
    int getEpisodeSubType();

    @FieldName(name = "episode_type")
    int getEpisodeType();

    @FieldName(name = "episode_record_type#setter")
    void setEpisodeRecordType(int r100);

    @FieldName(name = "episode_stage#setter")
    void setEpisodeStage(int r100);

    @FieldName(name = "episode_sub_type#setter")
    void setEpisodeSubType(int r100);

    @FieldName(name = "episode_type#setter")
    void setEpisodeType(int r100);
}
