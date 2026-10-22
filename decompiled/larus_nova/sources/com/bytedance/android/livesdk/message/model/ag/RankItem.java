package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RankItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/RankItem;", "", "()V", "copper_medal", "", "getCopper_medal", "()J", "setCopper_medal", "(J)V", DistrictSearchQuery.KEYWORDS_COUNTRY, "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "country_img_url", "getCountry_img_url", "setCountry_img_url", "extra", "getExtra", "setExtra", "gold_medal", "getGold_medal", "setGold_medal", "rank", "getRank", "setRank", "silver_medal", "getSilver_medal", "setSilver_medal", "total_medal", "getTotal_medal", "setTotal_medal", BdpAppEventConstant.PARAMS_UNIQUEID, "getUnique_id", "setUnique_id", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankItem implements h {

    @SerializedName("copper_medal")
    protected long copper_medal;

    @SerializedName(DistrictSearchQuery.KEYWORDS_COUNTRY)
    protected String country;

    @SerializedName("country_img_url")
    protected String country_img_url;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("gold_medal")
    protected long gold_medal;

    @SerializedName("rank")
    protected long rank;

    @SerializedName("silver_medal")
    protected long silver_medal;

    @SerializedName("total_medal")
    protected long total_medal;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    protected String unique_id;

    public RankItem() {
    }

    public final long getCopper_medal() {
        return this.copper_medal;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getCountry_img_url() {
        return this.country_img_url;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final long getGold_medal() {
        return this.gold_medal;
    }

    public final long getRank() {
        return this.rank;
    }

    public final long getSilver_medal() {
        return this.silver_medal;
    }

    public final long getTotal_medal() {
        return this.total_medal;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public RankItem(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 255) goto L7;
        this.extra = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this.unique_id = am3.h.c(r100);
        goto L3
    L10:
        this.total_medal = r100.j();
        goto L3
    L11:
        this.copper_medal = r100.j();
        goto L3
    L12:
        this.silver_medal = r100.j();
        goto L3
    L13:
        this.gold_medal = r100.j();
        goto L3
    L14:
        this.country_img_url = am3.h.c(r100);
        goto L3
    L15:
        this.country = am3.h.c(r100);
        goto L3
    L16:
        this.rank = r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setCopper_medal(long r100) {
        this.copper_medal = r100;
    }

    public final void setCountry(String r100) {
        this.country = r100;
    }

    public final void setCountry_img_url(String r100) {
        this.country_img_url = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setGold_medal(long r100) {
        this.gold_medal = r100;
    }

    public final void setRank(long r100) {
        this.rank = r100;
    }

    public final void setSilver_medal(long r100) {
        this.silver_medal = r100;
    }

    public final void setTotal_medal(long r100) {
        this.total_medal = r100;
    }

    public final void setUnique_id(String r100) {
        this.unique_id = r100;
    }
}
