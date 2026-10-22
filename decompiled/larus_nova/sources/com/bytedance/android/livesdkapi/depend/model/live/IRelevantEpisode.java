package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRelevantEpisode;", "Lvh7/c;", "", "getEpisodeId", "()Ljava/lang/Long;", "getEpisodeId$annotations", "()V", "episodeId", "", "getEpisodeName", "()Ljava/lang/String;", "getEpisodeName$annotations", "episodeName", "Lpy/k;", "getEpisodeCover", "()Lpy/k;", "getEpisodeCover$annotations", "episodeCover", "getCurrentPeriod", "getCurrentPeriod$annotations", "currentPeriod", "getSeasonId", "getSeasonId$annotations", "seasonId", "getItemId", "getItemId$annotations", "itemId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IRelevantEpisode extends c<IRelevantEpisode> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "current_period")
        public static /* synthetic */ void getCurrentPeriod$annotations() {
        }

        @FieldName(name = "episode_cover")
        public static /* synthetic */ void getEpisodeCover$annotations() {
        }

        @FieldName(name = "episode_id")
        public static /* synthetic */ void getEpisodeId$annotations() {
        }

        @FieldName(name = "episode_name")
        public static /* synthetic */ void getEpisodeName$annotations() {
        }

        @FieldName(name = "item_id")
        public static /* synthetic */ void getItemId$annotations() {
        }

        @FieldName(name = "season_id")
        public static /* synthetic */ void getSeasonId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "current_period")
    String getCurrentPeriod();

    @FieldName(name = "episode_cover")
    k getEpisodeCover();

    @FieldName(name = "episode_id")
    Long getEpisodeId();

    @FieldName(name = "episode_name")
    String getEpisodeName();

    @FieldName(name = "item_id")
    String getItemId();

    @FieldName(name = "season_id")
    Long getSeasonId();
}
