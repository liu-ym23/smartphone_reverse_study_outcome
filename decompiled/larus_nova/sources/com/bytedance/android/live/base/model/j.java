package com.bytedance.android.live.base.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/j;", "", "", "MULTI_LINK_GAME", "I", "getMULTI_LINK_GAME", "()I", "setMULTI_LINK_GAME", "(I)V", "POKE_PRIORITY", "getPOKE_PRIORITY", "setPOKE_PRIORITY", "PK_PRIORITY", "getPK_PRIORITY", "setPK_PRIORITY", "FANS_LUCKY_MONEY_PRIORITY", "getFANS_LUCKY_MONEY_PRIORITY", "setFANS_LUCKY_MONEY_PRIORITY", "LUCKY_BAG_PRIORITY", "getLUCKY_BAG_PRIORITY", "setLUCKY_BAG_PRIORITY", "LUCKY_MONEY_PRIORITY", "getLUCKY_MONEY_PRIORITY", "setLUCKY_MONEY_PRIORITY", "HOT_COMMENT_PRIORITY", "getHOT_COMMENT_PRIORITY", "setHOT_COMMENT_PRIORITY", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("fansLuckyMoney")
    private int FANS_LUCKY_MONEY_PRIORITY;

    @SerializedName("comment")
    private int HOT_COMMENT_PRIORITY;

    @SerializedName("luckyBag")
    private int LUCKY_BAG_PRIORITY;

    @SerializedName("luckyMoney")
    private int LUCKY_MONEY_PRIORITY;

    @SerializedName("micLink")
    private int MULTI_LINK_GAME;

    @SerializedName(PbRequest.SwitchType.PK)
    private int PK_PRIORITY;

    @SerializedName("poke")
    private int POKE_PRIORITY;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L20;
        j r101 = (j) r100;
        if (this.MULTI_LINK_GAME == r101.MULTI_LINK_GAME) goto L8;
        return false;
    L8:
        if (this.POKE_PRIORITY == r101.POKE_PRIORITY) goto L10;
        return false;
    L10:
        if (this.PK_PRIORITY == r101.PK_PRIORITY) goto L12;
        return false;
    L12:
        if (this.FANS_LUCKY_MONEY_PRIORITY == r101.FANS_LUCKY_MONEY_PRIORITY) goto L14;
        return false;
    L14:
        if (this.LUCKY_BAG_PRIORITY == r101.LUCKY_BAG_PRIORITY) goto L16;
        return false;
    L16:
        if (this.LUCKY_MONEY_PRIORITY == r101.LUCKY_MONEY_PRIORITY) goto L18;
        return false;
    L18:
        if (this.HOT_COMMENT_PRIORITY == r101.HOT_COMMENT_PRIORITY) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.MULTI_LINK_GAME * 31) + this.POKE_PRIORITY) * 31) + this.PK_PRIORITY) * 31) + this.FANS_LUCKY_MONEY_PRIORITY) * 31) + this.LUCKY_BAG_PRIORITY) * 31) + this.LUCKY_MONEY_PRIORITY) * 31) + this.HOT_COMMENT_PRIORITY;
    }

    public final String toString() {
        return "LiveActivitiesPriority(MULTI_LINK_GAME=" + this.MULTI_LINK_GAME + ", POKE_PRIORITY=" + this.POKE_PRIORITY + ", PK_PRIORITY=" + this.PK_PRIORITY + ", FANS_LUCKY_MONEY_PRIORITY=" + this.FANS_LUCKY_MONEY_PRIORITY + ", LUCKY_BAG_PRIORITY=" + this.LUCKY_BAG_PRIORITY + ", LUCKY_MONEY_PRIORITY=" + this.LUCKY_MONEY_PRIORITY + ", HOT_COMMENT_PRIORITY=" + this.HOT_COMMENT_PRIORITY + ")";
    }

    public j() {
        this.MULTI_LINK_GAME = 800;
        this.POKE_PRIORITY = 450;
        this.PK_PRIORITY = 400;
        this.FANS_LUCKY_MONEY_PRIORITY = TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG;
        this.LUCKY_BAG_PRIORITY = 300;
        this.LUCKY_MONEY_PRIORITY = 200;
        this.HOT_COMMENT_PRIORITY = 100;
    }
}
