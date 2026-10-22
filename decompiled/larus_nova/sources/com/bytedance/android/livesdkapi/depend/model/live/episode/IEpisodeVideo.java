package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0006R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006R$\u0010&\u001a\u0004\u0018\u00010 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R6\u0010/\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010'j\n\u0012\u0004\u0012\u00020(\u0018\u0001`)8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R:\u00104\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010'j\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u0001`)8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-R6\u00109\u001a\u0016\u0012\u0004\u0012\u000205\u0018\u00010'j\n\u0012\u0004\u0012\u000205\u0018\u0001`)8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\b\u001a\u0004\b6\u0010+\"\u0004\b7\u0010-R\"\u0010@\u001a\u00020:8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b?\u0010\b\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020A8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bF\u0010\b\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010H8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\b\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010R\u001a\u00020:8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bQ\u0010\b\u001a\u0004\bO\u0010<\"\u0004\bP\u0010>R$\u0010Y\u001a\u0004\u0018\u00010S8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\b\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Z"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideoModelContainer;", "getPlayInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideoModelContainer;", "setPlayInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideoModelContainer;)V", "getPlayInfo$annotations", "()V", "playInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStartLocation;", "getStartPosition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStartLocation;", "setStartPosition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStartLocation;)V", "getStartPosition$annotations", "startPosition", "", "getDuration", "()J", "setDuration", "(J)V", "getDuration$annotations", "duration", "getCastInfo", "setCastInfo", "getCastInfo$annotations", "castInfo", "getWatermarkedEncrypt", "setWatermarkedEncrypt", "getWatermarkedEncrypt$annotations", "watermarkedEncrypt", "", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "getVid$annotations", "vid", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ISegmentFlowTime;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getSegmentFlowTimeList", "()Ljava/util/List;", "setSegmentFlowTimeList", "(Ljava/util/List;)V", "getSegmentFlowTimeList$annotations", "segmentFlowTimeList", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IDefinitionInfo;", "getDefinitionInfoList", "setDefinitionInfoList", "getDefinitionInfoList$annotations", "definitionInfoList", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeDefinitionInfo;", "getVideoDefinitionInfoList", "setVideoDefinitionInfoList", "getVideoDefinitionInfoList$annotations", "videoDefinitionInfoList", "", "getVideoCode", "()I", "setVideoCode", "(I)V", "getVideoCode$annotations", "videoCode", "", "getRefresh", "()Z", "setRefresh", "(Z)V", "getRefresh$annotations", "refresh", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICommentSpecialEffectData;", "getCommentSpecialEffectData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICommentSpecialEffectData;", "setCommentSpecialEffectData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICommentSpecialEffectData;)V", "getCommentSpecialEffectData$annotations", "commentSpecialEffectData", "getVideoModelType", "setVideoModelType", "getVideoModelType$annotations", "videoModelType", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IReplayStreamUrl;", "getReplayStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IReplayStreamUrl;", "setReplayStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IReplayStreamUrl;)V", "getReplayStreamUrl$annotations", "replayStreamUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodeVideo extends c<IEpisodeVideo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "cast_info")
        public static /* synthetic */ void getCastInfo$annotations() {
        }

        @FieldName(name = "comment_special_effect_data")
        public static /* synthetic */ void getCommentSpecialEffectData$annotations() {
        }

        @FieldName(name = "download_sizes")
        public static /* synthetic */ void getDefinitionInfoList$annotations() {
        }

        @FieldName(name = "duration")
        public static /* synthetic */ void getDuration$annotations() {
        }

        @FieldName(name = "play_info")
        public static /* synthetic */ void getPlayInfo$annotations() {
        }

        @FieldName(name = "refresh")
        public static /* synthetic */ void getRefresh$annotations() {
        }

        @FieldName(name = "replay_stream_url")
        public static /* synthetic */ void getReplayStreamUrl$annotations() {
        }

        @FieldName(name = "segment_flow_time_list")
        public static /* synthetic */ void getSegmentFlowTimeList$annotations() {
        }

        @FieldName(name = "start_position")
        public static /* synthetic */ void getStartPosition$annotations() {
        }

        @FieldName(name = "vid")
        public static /* synthetic */ void getVid$annotations() {
        }

        @FieldName(name = "video_code")
        public static /* synthetic */ void getVideoCode$annotations() {
        }

        @FieldName(name = "definition_infos")
        public static /* synthetic */ void getVideoDefinitionInfoList$annotations() {
        }

        @FieldName(name = "video_model_type")
        public static /* synthetic */ void getVideoModelType$annotations() {
        }

        @FieldName(name = "watermarked_encrypt")
        public static /* synthetic */ void getWatermarkedEncrypt$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "cast_info")
    IEpisodeVideoModelContainer getCastInfo();

    @FieldName(name = "comment_special_effect_data")
    ICommentSpecialEffectData getCommentSpecialEffectData();

    @FieldName(name = "download_sizes")
    List<IDefinitionInfo> getDefinitionInfoList();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "play_info")
    IEpisodeVideoModelContainer getPlayInfo();

    @FieldName(name = "refresh")
    boolean getRefresh();

    @FieldName(name = "replay_stream_url")
    IReplayStreamUrl getReplayStreamUrl();

    @FieldName(name = "segment_flow_time_list")
    List<ISegmentFlowTime> getSegmentFlowTimeList();

    @FieldName(name = "start_position")
    IStartLocation getStartPosition();

    @FieldName(name = "vid")
    String getVid();

    @FieldName(name = "video_code")
    int getVideoCode();

    @FieldName(name = "definition_infos")
    List<IEpisodeDefinitionInfo> getVideoDefinitionInfoList();

    @FieldName(name = "video_model_type")
    int getVideoModelType();

    @FieldName(name = "watermarked_encrypt")
    IEpisodeVideoModelContainer getWatermarkedEncrypt();

    @FieldName(name = "cast_info#setter")
    void setCastInfo(IEpisodeVideoModelContainer r100);

    @FieldName(name = "comment_special_effect_data#setter")
    void setCommentSpecialEffectData(ICommentSpecialEffectData r100);

    @FieldName(name = "download_sizes#setter")
    void setDefinitionInfoList(List<? extends IDefinitionInfo> r100);

    @FieldName(name = "duration#setter")
    void setDuration(long r100);

    @FieldName(name = "play_info#setter")
    void setPlayInfo(IEpisodeVideoModelContainer r100);

    @FieldName(name = "refresh#setter")
    void setRefresh(boolean r100);

    @FieldName(name = "replay_stream_url#setter")
    void setReplayStreamUrl(IReplayStreamUrl r100);

    @FieldName(name = "segment_flow_time_list#setter")
    void setSegmentFlowTimeList(List<? extends ISegmentFlowTime> r100);

    @FieldName(name = "start_position#setter")
    void setStartPosition(IStartLocation r100);

    @FieldName(name = "vid#setter")
    void setVid(String r100);

    @FieldName(name = "video_code#setter")
    void setVideoCode(int r100);

    @FieldName(name = "definition_infos#setter")
    void setVideoDefinitionInfoList(List<? extends IEpisodeDefinitionInfo> r100);

    @FieldName(name = "video_model_type#setter")
    void setVideoModelType(int r100);

    @FieldName(name = "watermarked_encrypt#setter")
    void setWatermarkedEncrypt(IEpisodeVideoModelContainer r100);
}
