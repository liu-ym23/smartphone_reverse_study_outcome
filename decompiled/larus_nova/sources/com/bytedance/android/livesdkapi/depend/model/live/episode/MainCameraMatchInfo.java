package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.MatchData;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/MainCameraMatchInfo;", "", "()V", "contentId", "", "getContentId", "()J", "setContentId", "(J)V", b.f276361k, "", "getEventId", "()Ljava/util/List;", "setEventId", "(Ljava/util/List;)V", "hideTabIds", "getHideTabIds", "setHideTabIds", "isDisplayScoreType", "", "()Z", "setDisplayScoreType", "(Z)V", "leagueInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/LeagueInfo;", "getLeagueInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/LeagueInfo;", "setLeagueInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/LeagueInfo;)V", "matchData", "Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;", "getMatchData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;", "matchId", "getMatchId", "setMatchId", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainCameraMatchInfo implements h {

    @SerializedName(a.KEY_CONTENT_ID)
    protected long contentId;

    @SerializedName("event_ids")
    protected List<Long> eventId;

    @SerializedName("hide_tab_ids")
    protected List<Long> hideTabIds;

    @SerializedName("is_display_score_type")
    protected boolean isDisplayScoreType;

    @SerializedName("league_info")
    protected LeagueInfo leagueInfo;

    @SerializedName("match_data")
    protected MatchData matchData;

    @SerializedName(VSConstants.VS_MATCH_ID)
    protected long matchId;

    public MainCameraMatchInfo() {
        this.eventId = new ArrayList();
        this.hideTabIds = new ArrayList();
    }

    public final long getContentId() {
        return this.contentId;
    }

    public final List<Long> getEventId() {
        return this.eventId;
    }

    public final List<Long> getHideTabIds() {
        return this.hideTabIds;
    }

    public final LeagueInfo getLeagueInfo() {
        return this.leagueInfo;
    }

    public final MatchData getMatchData() {
        return this.matchData;
    }

    public final long getMatchId() {
        return this.matchId;
    }

    public final boolean isDisplayScoreType() {
        return this.isDisplayScoreType;
    }

    public MainCameraMatchInfo(g r100) {
        this.eventId = new ArrayList();
        this.hideTabIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        List<Long> r103 = this.hideTabIds;
    L12:
        r103.add(Long.valueOf(r100.j()));
        goto L3
    L8:
        this.isDisplayScoreType = am3.h.a(r100);
        goto L3
    L9:
        this.leagueInfo = new LeagueInfo(r100);
        goto L3
    L10:
        this.contentId = r100.j();
        goto L3
    L11:
        r103 = this.eventId;
        goto L12
    L13:
        this.matchId = r100.j();
        goto L3
    L14:
        this.matchData = new MatchData(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.eventId.isEmpty() == false) goto L19;
        this.eventId = new ArrayList();
    L19:
        if (this.hideTabIds.isEmpty() == false) goto L39;
        this.hideTabIds = new ArrayList();
        return;
    }

    public final void setContentId(long r100) {
        this.contentId = r100;
    }

    public final void setDisplayScoreType(boolean r100) {
        this.isDisplayScoreType = r100;
    }

    public final void setEventId(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventId = r100;
    }

    public final void setHideTabIds(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hideTabIds = r100;
    }

    public final void setLeagueInfo(LeagueInfo r100) {
        this.leagueInfo = r100;
    }

    public final void setMatchId(long r100) {
        this.matchId = r100;
    }
}
