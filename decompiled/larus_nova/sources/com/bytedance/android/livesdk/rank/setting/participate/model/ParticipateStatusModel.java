package com.bytedance.android.livesdk.rank.setting.participate.model;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.rank.setting.participate.ParticipateStatus;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.ranklist.GetRankListsStatusResponse.RankListStatus")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/rank/setting/participate/model/ParticipateStatusModel;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "rankId", "getRankId", "setRankId", "rankLevel1", "getRankLevel1", "setRankLevel1", "rankLevel2", "getRankLevel2", "setRankLevel2", "rankName", "getRankName", "setRankName", "rankOrder", "", "getRankOrder", "()I", "setRankOrder", "(I)V", "status", "Lcom/bytedance/android/livesdk/rank/setting/participate/ParticipateStatus;", "getStatus", "()Lcom/bytedance/android/livesdk/rank/setting/participate/ParticipateStatus;", "statusInt", "getStatusInt", "setStatusInt", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParticipateStatusModel implements h {

    @SerializedName("ranklist_desc")
    protected String description;

    @SerializedName("ranklist_name")
    protected String rankId;

    @SerializedName("rank_level1")
    protected String rankLevel1;

    @SerializedName("rank_level2")
    protected String rankLevel2;

    @SerializedName("ranklist_show_name")
    protected String rankName;

    @SerializedName(a.KEY_RANK_INDEX)
    protected int rankOrder;

    @SerializedName("status")
    protected int statusInt;

    public final ParticipateStatus getStatus() {
        int r100 = this.statusInt;
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        return ParticipateStatus.Normal;
    L17:
        return ParticipateStatus.Banned;
    L18:
        return ParticipateStatus.Rejoin;
    L19:
        return ParticipateStatus.Exited;
    L15:
        return ParticipateStatus.Normal;
    }

    public ParticipateStatusModel() {
        this.rankId = "";
        this.rankName = "";
        this.description = "";
        this.rankLevel1 = "";
        this.rankLevel2 = "";
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final String getRankLevel1() {
        return this.rankLevel1;
    }

    public final String getRankLevel2() {
        return this.rankLevel2;
    }

    public final String getRankName() {
        return this.rankName;
    }

    public final int getRankOrder() {
        return this.rankOrder;
    }

    public final int getStatusInt() {
        return this.statusInt;
    }

    public ParticipateStatusModel(g r100) {
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
        this.rankLevel2 = am3.h.c(r100);
        goto L3
    L8:
        this.rankLevel1 = am3.h.c(r100);
        goto L3
    L9:
        this.rankOrder = (int) r100.j();
        goto L3
    L10:
        this.statusInt = (int) r100.j();
        goto L3
    L11:
        this.description = am3.h.c(r100);
        goto L3
    L12:
        this.rankName = am3.h.c(r100);
        goto L3
    L13:
        this.rankId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.rankId != null) goto L18;
        this.rankId = "";
    L18:
        if (this.rankName != null) goto L21;
        this.rankName = "";
    L21:
        if (this.description != null) goto L24;
        this.description = "";
    L24:
        if (this.rankLevel1 != null) goto L27;
        this.rankLevel1 = "";
    L27:
        if (this.rankLevel2 != null) goto L48;
        this.rankLevel2 = "";
        return;
    }

    public final void setDescription(String r100) {
        this.description = r100;
    }

    public final void setRankId(String r100) {
        this.rankId = r100;
    }

    public final void setRankLevel1(String r100) {
        this.rankLevel1 = r100;
    }

    public final void setRankLevel2(String r100) {
        this.rankLevel2 = r100;
    }

    public final void setRankName(String r100) {
        this.rankName = r100;
    }

    public final void setRankOrder(int r100) {
        this.rankOrder = r100;
    }

    public final void setStatusInt(int r100) {
        this.statusInt = r100;
    }
}
