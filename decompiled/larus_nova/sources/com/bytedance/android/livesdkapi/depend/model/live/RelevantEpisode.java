package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RelevantRecommendation.Episode")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RelevantEpisode;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRelevantEpisode;", "()V", "currentPeriod", "", "getCurrentPeriod", "()Ljava/lang/String;", "setCurrentPeriod", "(Ljava/lang/String;)V", "episodeCover", "Lcom/bytedance/android/live/base/model/ImageModel;", "getEpisodeCover", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setEpisodeCover", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "episodeId", "", "getEpisodeId", "()Ljava/lang/Long;", "setEpisodeId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "episodeName", "getEpisodeName", "setEpisodeName", "itemId", "getItemId", "setItemId", "seasonId", "getSeasonId", "setSeasonId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RelevantEpisode extends FlexModelBase<IRelevantEpisode> implements IRelevantEpisode, h {

    @SerializedName("current_period")
    protected String currentPeriod;

    @SerializedName("episode_cover")
    protected ImageModel episodeCover;

    @SerializedName("episode_id")
    protected Long episodeId;

    @SerializedName("episode_name")
    protected String episodeName;

    @SerializedName("item_id")
    protected String itemId;

    @SerializedName("season_id")
    protected Long seasonId;

    public RelevantEpisode() {
        super(IRelevantEpisode.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public /* bridge */ /* synthetic */ k getEpisodeCover() {
        return getEpisodeCover();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public String getCurrentPeriod() {
        return this.currentPeriod;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public Long getEpisodeId() {
        return this.episodeId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public String getEpisodeName() {
        return this.episodeName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public String getItemId() {
        return this.itemId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public Long getSeasonId() {
        return this.seasonId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRelevantEpisode
    public ImageModel getEpisodeCover() {
        return this.episodeCover;
    }

    public RelevantEpisode(g r100) {
        super(IRelevantEpisode.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.itemId = am3.h.c(r100);
        goto L3
    L9:
        this.seasonId = Long.valueOf(r100.j());
        goto L3
    L10:
        this.currentPeriod = am3.h.c(r100);
        goto L3
    L11:
        this.episodeCover = x.a(r100);
        goto L3
    L12:
        this.episodeName = am3.h.c(r100);
        goto L3
    L13:
        this.episodeId = Long.valueOf(r100.j());
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setCurrentPeriod(String r100) {
        this.currentPeriod = r100;
    }

    public void setEpisodeCover(ImageModel r100) {
        this.episodeCover = r100;
    }

    public void setEpisodeId(Long r100) {
        this.episodeId = r100;
    }

    public void setEpisodeName(String r100) {
        this.episodeName = r100;
    }

    public void setItemId(String r100) {
        this.itemId = r100;
    }

    public void setSeasonId(Long r100) {
        this.seasonId = r100;
    }
}
