package com.bytedance.android.livesdk.rank;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.RankEnterInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0006\u0010)\u001a\u00020\u000eJ\b\u0010*\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0006\u0010-\u001a\u00020\u0014J\u0006\u0010.\u001a\u00020\u0014J\u0016\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u00102\u001a\u0002002\u0006\u00103\u001a\u00020\u000eJ\u000e\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u0014J\u000e\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\u0014J\u0010\u00108\u001a\u0002002\b\u00109\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010:\u001a\u0002002\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0016\u0010<\u001a\u0002002\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\b\u0010>\u001a\u00020?H\u0016R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR&\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\t¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;", "", "()V", "_defaultPages", "", "Lcom/bytedance/android/livesdk/rank/RankEntranceSingleInfo;", "get_defaultPages", "()Ljava/util/List;", "set_defaultPages", "(Ljava/util/List;)V", "_defaultPagesNoShop", "get_defaultPagesNoShop", "set_defaultPagesNoShop", "_deltaTime", "", "get_deltaTime", "()J", "set_deltaTime", "(J)V", "_displayKtv", "", "get_displayKtv", "()Z", "set_displayKtv", "(Z)V", "_hiddenEntrance", "get_hiddenEntrance", "set_hiddenEntrance", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_rankPages", "get_rankPages", "set_rankPages", "_rankPagesNoShop", "get_rankPagesNoShop", "set_rankPagesNoShop", "getDefaultPages", "getDeltaTime", "getIcon", "getRankPages", "getRankPagesNoShop", "isDisplayKtv", "isHiddenEntrance", "setDefaultPages", "", "defaultPages", "setDeltaTime", "deltaTime", "setDisplayKtv", "displayKtv", "setHiddenEntrance", "hiddenEntrance", "setIcon", "icon", "setRankPages", "rankPages", "setRankPagesNoShop", "rankPagesNoShop", "toString", "", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankEntranceInfo implements vh7.h {

    @SerializedName("default_rank_infos")
    protected List<RankEntranceSingleInfo> _defaultPages;

    @SerializedName("customized_default_rank_infos")
    protected List<RankEntranceSingleInfo> _defaultPagesNoShop;

    @SerializedName("period_remaining_second")
    protected long _deltaTime;

    @SerializedName("display_ktv_rank")
    protected boolean _displayKtv;

    @SerializedName("hidden_enter")
    protected boolean _hiddenEntrance;

    @SerializedName("icon")
    protected ImageModel _icon;

    @SerializedName("rank_infos")
    protected List<RankEntranceSingleInfo> _rankPages;

    @SerializedName("rank_infos_without_shop")
    protected List<RankEntranceSingleInfo> _rankPagesNoShop;

    public RankEntranceInfo() {
    }

    public String toString() {
        return "RankEntranceInfo{rankPages=" + this._rankPages + ", rankPagesNoShop=" + this._rankPagesNoShop + ", defaultPages=" + this._defaultPages + ", deltaTime=" + this._deltaTime + ", hiddenEntrance=" + this._hiddenEntrance + ", displayKtv=" + this._displayKtv + '}';
    }

    public final List<RankEntranceSingleInfo> getDefaultPages() {
        return this._defaultPages;
    }

    public final long getDeltaTime() {
        return this._deltaTime;
    }

    public final ImageModel getIcon() {
        return this._icon;
    }

    public final List<RankEntranceSingleInfo> getRankPages() {
        return this._rankPages;
    }

    public final List<RankEntranceSingleInfo> getRankPagesNoShop() {
        return this._rankPagesNoShop;
    }

    public final List<RankEntranceSingleInfo> get_defaultPages() {
        return this._defaultPages;
    }

    public final List<RankEntranceSingleInfo> get_defaultPagesNoShop() {
        return this._defaultPagesNoShop;
    }

    public final long get_deltaTime() {
        return this._deltaTime;
    }

    public final boolean get_displayKtv() {
        return this._displayKtv;
    }

    public final boolean get_hiddenEntrance() {
        return this._hiddenEntrance;
    }

    public final ImageModel get_icon() {
        return this._icon;
    }

    public final List<RankEntranceSingleInfo> get_rankPages() {
        return this._rankPages;
    }

    public final List<RankEntranceSingleInfo> get_rankPagesNoShop() {
        return this._rankPagesNoShop;
    }

    public final boolean isDisplayKtv() {
        return this._displayKtv;
    }

    public final boolean isHiddenEntrance() {
        return this._hiddenEntrance;
    }

    public RankEntranceInfo(am3.g r100) {
        this._rankPages = new ArrayList();
        this._rankPagesNoShop = new ArrayList();
        this._defaultPages = new ArrayList();
        this._defaultPagesNoShop = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L6;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        List<RankEntranceSingleInfo> r103 = this._defaultPagesNoShop;
        RankEntranceSingleInfo r104 = new RankEntranceSingleInfo(r100);
    L15:
        r103.add(r104);
        goto L3
    L8:
        r103 = this._defaultPages;
        r104 = new RankEntranceSingleInfo(r100);
        goto L15
    L9:
        this._displayKtv = am3.h.a(r100);
        goto L3
    L10:
        r103 = this._rankPagesNoShop;
        r104 = new RankEntranceSingleInfo(r100);
        goto L15
    L11:
        this._deltaTime = r100.j();
        goto L3
    L12:
        this._icon = x.a(r100);
        goto L3
    L13:
        this._hiddenEntrance = am3.h.a(r100);
        goto L3
    L14:
        r103 = this._rankPages;
        r104 = new RankEntranceSingleInfo(r100);
        goto L15
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setDefaultPages(List<RankEntranceSingleInfo> r100) {
        this._defaultPages = r100;
    }

    public final void setDeltaTime(long r100) {
        this._deltaTime = r100;
    }

    public final void setDisplayKtv(boolean r100) {
        this._displayKtv = r100;
    }

    public final void setHiddenEntrance(boolean r100) {
        this._hiddenEntrance = r100;
    }

    public final void setIcon(ImageModel r100) {
        this._icon = r100;
    }

    public final void setRankPages(List<RankEntranceSingleInfo> r100) {
        this._rankPages = r100;
    }

    public final void setRankPagesNoShop(List<RankEntranceSingleInfo> r100) {
        this._rankPagesNoShop = r100;
    }

    public final void set_defaultPages(List<RankEntranceSingleInfo> r100) {
        this._defaultPages = r100;
    }

    public final void set_defaultPagesNoShop(List<RankEntranceSingleInfo> r100) {
        this._defaultPagesNoShop = r100;
    }

    public final void set_deltaTime(long r100) {
        this._deltaTime = r100;
    }

    public final void set_displayKtv(boolean r100) {
        this._displayKtv = r100;
    }

    public final void set_hiddenEntrance(boolean r100) {
        this._hiddenEntrance = r100;
    }

    public final void set_icon(ImageModel r100) {
        this._icon = r100;
    }

    public final void set_rankPages(List<RankEntranceSingleInfo> r100) {
        this._rankPages = r100;
    }

    public final void set_rankPagesNoShop(List<RankEntranceSingleInfo> r100) {
        this._rankPagesNoShop = r100;
    }
}
