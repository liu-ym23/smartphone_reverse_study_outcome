package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.Match")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/Match;", "", "()V", "ag_match_info", "Lcom/bytedance/android/livesdk/message/model/ag/AGMatchInfo;", "getAg_match_info", "()Lcom/bytedance/android/livesdk/message/model/ag/AGMatchInfo;", "setAg_match_info", "(Lcom/bytedance/android/livesdk/message/model/ag/AGMatchInfo;)V", ButtonColorBean.StateFocus, "", "getFocus", "()Ljava/lang/String;", "setFocus", "(Ljava/lang/String;)V", "match_live", "Lcom/bytedance/android/livesdk/message/model/ag/MatchLive;", "getMatch_live", "()Lcom/bytedance/android/livesdk/message/model/ag/MatchLive;", "setMatch_live", "(Lcom/bytedance/android/livesdk/message/model/ag/MatchLive;)V", "start_time_ms", "", "getStart_time_ms", "()J", "setStart_time_ms", "(J)V", a.KEY_TAG_TYPE, "", "getTag_type", "()I", "setTag_type", "(I)V", "title", "getTitle", d.f25925o, BdpAppEventConstant.PARAMS_UNIQUEID, "getUnique_id", "setUnique_id", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Match implements h {

    @SerializedName("ag_match_info")
    protected AGMatchInfo ag_match_info;

    @SerializedName(ButtonColorBean.StateFocus)
    protected String focus;

    @SerializedName("match_live")
    protected MatchLive match_live;

    @SerializedName("start_time_ms")
    protected long start_time_ms;

    @SerializedName(a.KEY_TAG_TYPE)
    protected int tag_type;

    @SerializedName("title")
    protected String title;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    protected String unique_id;

    public Match() {
    }

    public final AGMatchInfo getAg_match_info() {
        return this.ag_match_info;
    }

    public final String getFocus() {
        return this.focus;
    }

    public final MatchLive getMatch_live() {
        return this.match_live;
    }

    public final long getStart_time_ms() {
        return this.start_time_ms;
    }

    public final int getTag_type() {
        return this.tag_type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public Match(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.unique_id = am3.h.c(r100);
        goto L3
    L8:
        this.match_live = new MatchLive(r100);
        goto L3
    L9:
        this.ag_match_info = new AGMatchInfo(r100);
        goto L3
    L10:
        this.tag_type = r100.i();
        goto L3
    L11:
        this.focus = am3.h.c(r100);
        goto L3
    L12:
        this.start_time_ms = r100.j();
        goto L3
    L13:
        this.title = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }

    public final void setAg_match_info(AGMatchInfo r100) {
        this.ag_match_info = r100;
    }

    public final void setFocus(String r100) {
        this.focus = r100;
    }

    public final void setMatch_live(MatchLive r100) {
        this.match_live = r100;
    }

    public final void setStart_time_ms(long r100) {
        this.start_time_ms = r100;
    }

    public final void setTag_type(int r100) {
        this.tag_type = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUnique_id(String r100) {
        this.unique_id = r100;
    }
}
