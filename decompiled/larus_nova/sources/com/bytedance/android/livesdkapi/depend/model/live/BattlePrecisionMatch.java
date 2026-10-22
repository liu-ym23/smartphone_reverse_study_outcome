package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PrecisionMatch")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattlePrecisionMatch;", "", "()V", "matchReason", "", "getMatchReason", "()Ljava/lang/String;", "setMatchReason", "(Ljava/lang/String;)V", "matcherList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattlePrecisionMatcher;", "getMatcherList", "()Ljava/util/List;", "setMatcherList", "(Ljava/util/List;)V", "precisionMatchId", "", "getPrecisionMatchId", "()J", "setPrecisionMatchId", "(J)V", "sponsorId", "getSponsorId", "setSponsorId", "waitSeconds", "getWaitSeconds", "setWaitSeconds", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattlePrecisionMatch implements h {

    @SerializedName("match_reason")
    protected String matchReason;

    @SerializedName("matchers")
    protected List<BattlePrecisionMatcher> matcherList;

    @SerializedName("precision_match_id")
    protected long precisionMatchId;

    @SerializedName("sponsor_open_id")
    protected String sponsorId;

    @SerializedName("wait_seconds")
    protected long waitSeconds;

    public BattlePrecisionMatch() {
    }

    public final String getMatchReason() {
        return this.matchReason;
    }

    public final List<BattlePrecisionMatcher> getMatcherList() {
        return this.matcherList;
    }

    public final long getPrecisionMatchId() {
        return this.precisionMatchId;
    }

    public final String getSponsorId() {
        return this.sponsorId;
    }

    public final long getWaitSeconds() {
        return this.waitSeconds;
    }

    public BattlePrecisionMatch(g r100) {
        this.matcherList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 2) goto L8;
        this.matcherList.add(new BattlePrecisionMatcher(r100));
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.matchReason = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.waitSeconds = r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.precisionMatchId = r100.j();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        this.sponsorId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setMatchReason(String r100) {
        this.matchReason = r100;
    }

    public final void setMatcherList(List<BattlePrecisionMatcher> r100) {
        this.matcherList = r100;
    }

    public final void setPrecisionMatchId(long r100) {
        this.precisionMatchId = r100;
    }

    public final void setSponsorId(String r100) {
        this.sponsorId = r100;
    }

    public final void setWaitSeconds(long r100) {
        this.waitSeconds = r100;
    }
}
