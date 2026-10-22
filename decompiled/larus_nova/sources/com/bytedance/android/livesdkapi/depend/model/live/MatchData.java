package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.GregorianCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020/H\u0016J\f\u00100\u001a\u00020\u0011*\u00020\u001fH\u0002R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001e\u0010\u001b\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001e\u0010\u001e\u001a\u00020\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\"\u0010'\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchData;", "()V", "against", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;", "getAgainst", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;", "setAgainst", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IAgainst;)V", "currentPreviewVersion", "", "getCurrentPreviewVersion", "()J", "setCurrentPreviewVersion", "(J)V", "matchGroup", "", "getMatchGroup", "()Ljava/lang/String;", "setMatchGroup", "(Ljava/lang/String;)V", "matchId", "getMatchId", "setMatchId", "matchIdStr", "getMatchIdStr", "matchRound", "getMatchRound", "setMatchRound", "matchStatus", "", "getMatchStatus", "()I", "setMatchStatus", "(I)V", "matchTitle", "getMatchTitle", "setMatchTitle", "startedTimeUnix", "getStartedTimeUnix", "()Ljava/lang/Long;", "setStartedTimeUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPreviewStartTimeStr", "isMatchBeforeStart", "", "toZeroString", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchData extends FlexModelBase<IMatchData> implements IMatchData, h {

    @SerializedName("against")
    protected IAgainst against;
    private long currentPreviewVersion;

    @SerializedName("match_group")
    protected String matchGroup;

    @SerializedName(VSConstants.VS_MATCH_ID)
    protected long matchId;

    @SerializedName("match_id_str")
    protected String matchIdStr;

    @SerializedName("match_round")
    protected String matchRound;

    @SerializedName("match_status")
    protected int matchStatus;

    @SerializedName("match_title")
    protected String matchTitle;

    @SerializedName("started_time_unix")
    protected Long startedTimeUnix;

    public MatchData() {
        super(IMatchData.class);
        this.currentPreviewVersion = Long.MIN_VALUE;
        this.matchGroup = "";
        this.matchRound = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchDataEx
    public String getPreviewStartTimeStr() {
        if (getStartedTimeUnix() == null) goto L9;
        Long r100 = getStartedTimeUnix();
        Intrinsics.checkNotNull(r100);
        if (r100.longValue() <= 0) goto L11;
        GregorianCalendar r101 = new GregorianCalendar();
        Long r102 = getStartedTimeUnix();
        Intrinsics.checkNotNull(r102);
        r101.setTime(new Date(r102.longValue() * ((long) 1000)));
        return toZeroString(r101.get(11)) + ':' + toZeroString(r101.get(12)) + " 开赛";
    L11:
        return "";
    L9:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchDataEx
    public boolean isMatchBeforeStart() {
        if (getMatchStatus() != 1) goto L5;
    L7:
        return false;
    L5:
        if (getMatchStatus() == 2) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public IAgainst getAgainst() {
        return this.against;
    }

    public final long getCurrentPreviewVersion() {
        return this.currentPreviewVersion;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public String getMatchGroup() {
        return this.matchGroup;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public long getMatchId() {
        return this.matchId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public String getMatchIdStr() {
        return this.matchIdStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public String getMatchRound() {
        return this.matchRound;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public int getMatchStatus() {
        return this.matchStatus;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public String getMatchTitle() {
        return this.matchTitle;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public Long getStartedTimeUnix() {
        return this.startedTimeUnix;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.livesdkapi.depend.model.live.matchroom.IAgainst, java.lang.Object] */
    public MatchData(g r100) {
        super(IMatchData.class);
        this.currentPreviewVersion = Long.MIN_VALUE;
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L25;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.matchId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.matchTitle = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.against = f.a(r100, IAgainst.class);
        goto L3
    L12:
        if (r102 != 10) goto L14;
        this.matchGroup = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 11) goto L15;
        this.matchRound = am3.h.c(r100);
        goto L3
    L15:
        switch(r102) {
            case 18: goto L19;
            case 19: goto L18;
            case 20: goto L17;
            default: goto L16;
        };
    L17:
        this.startedTimeUnix = Long.valueOf(r100.j());
        goto L3
    L18:
        this.matchIdStr = am3.h.c(r100);
        goto L3
    L19:
        this.matchStatus = r100.i();
        goto L3
    L16:
        am3.h.d(r103, r100);
        goto L3
    L25:
        r100.d(r101);
        setThreadSafe(true);
        if (this.matchGroup != null) goto L29;
        this.matchGroup = "";
    L29:
        if (this.matchRound != null) goto L57;
        this.matchRound = "";
        return;
    }

    private final String toZeroString(int r100) {
        if (r100 > 9) goto L6;
        return "0" + r100;
    L6:
        return String.valueOf(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setAgainst(IAgainst r100) {
        this.against = r100;
    }

    public final void setCurrentPreviewVersion(long r100) {
        this.currentPreviewVersion = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setMatchGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.matchGroup = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setMatchId(long r100) {
        this.matchId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setMatchRound(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.matchRound = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setMatchStatus(int r100) {
        this.matchStatus = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setMatchTitle(String r100) {
        this.matchTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchData
    public void setStartedTimeUnix(Long r100) {
        this.startedTimeUnix = r100;
    }
}
