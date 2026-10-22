package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Against;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.MatchAgainstScoreMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MatchAgainstScoreMessage;", "Lcom/bytedance/android/livesdkapi/depend/message/MatchBaseStreamLiveMessage;", "()V", "against", "Lcom/bytedance/android/livesdkapi/depend/model/live/Against;", "getAgainst", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Against;", "setAgainst", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Against;)V", "displayStatus", "", "getDisplayStatus", "()I", "setDisplayStatus", "(I)V", "matchId", "", "getMatchId", "()J", "setMatchId", "(J)V", "matchIdStr", "", "getMatchIdStr", "()Ljava/lang/String;", "setMatchIdStr", "(Ljava/lang/String;)V", "matchStatus", "getMatchStatus", "setMatchStatus", "isStreamMessage", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchAgainstScoreMessage extends MatchBaseStreamLiveMessage implements h {

    @SerializedName("against")
    protected Against against;

    @SerializedName("display_status")
    protected int displayStatus;

    @SerializedName(VSConstants.VS_MATCH_ID)
    protected long matchId;

    @SerializedName("match_id_str")
    protected String matchIdStr;

    @SerializedName("match_status")
    protected int matchStatus;

    @Override // com.bytedance.android.livesdkapi.depend.message.MatchBaseStreamLiveMessage, com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public boolean isStreamMessage() {
        return true;
    }

    public MatchAgainstScoreMessage() {
        this.matchIdStr = "";
        this.type = MessageType.MATCH_AGAINST_SCORE_MESSAGE;
    }

    public final Against getAgainst() {
        return this.against;
    }

    public final int getDisplayStatus() {
        return this.displayStatus;
    }

    public final long getMatchId() {
        return this.matchId;
    }

    public final String getMatchIdStr() {
        return this.matchIdStr;
    }

    public final int getMatchStatus() {
        return this.matchStatus;
    }

    public MatchAgainstScoreMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.matchIdStr = am3.h.c(r100);
        goto L3
    L8:
        this.matchId = r100.j();
        goto L3
    L9:
        this.displayStatus = r100.i();
        goto L3
    L10:
        this.matchStatus = r100.i();
        goto L3
    L11:
        this.against = new Against(r100);
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.matchIdStr != null) goto L16;
        this.matchIdStr = "";
    L16:
        this.type = MessageType.MATCH_AGAINST_SCORE_MESSAGE;
    }

    public final void setAgainst(Against r100) {
        this.against = r100;
    }

    public final void setDisplayStatus(int r100) {
        this.displayStatus = r100;
    }

    public final void setMatchId(long r100) {
        this.matchId = r100;
    }

    public final void setMatchIdStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.matchIdStr = r100;
    }

    public final void setMatchStatus(int r100) {
        this.matchStatus = r100;
    }
}
