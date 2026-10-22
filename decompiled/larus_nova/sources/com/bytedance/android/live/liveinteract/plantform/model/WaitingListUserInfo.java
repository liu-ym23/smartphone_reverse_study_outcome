package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class WaitingListUserInfo extends FlexModelBase<o0> implements o0 {
    private static final int HASH_CODE_37 = 37;

    @SerializedName("application_reason")
    public String applyReason;

    @SerializedName("apply_time_sec")
    public Long applyTimeSec;

    @SerializedName("fuzzy_fan_ticket_str")
    public String fuzzyFanTicketStr;

    @SerializedName("application_has_expired")
    public boolean hasExpired;

    @SerializedName("is_mutual_following")
    public boolean isMutualFollow;

    @SerializedName("last_7_days_gift_count_text")
    public String last7DaysGiftCountTxt;

    public WaitingListUserInfo() {
        super(o0.class);
    }

    public int hashCode() {
        int r100 = (((this.hasExpired ? 1 : 0) * 37) + (this.isMutualFollow ? 1 : 0)) * 37;
        String r101 = this.applyReason;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 37;
        String r105 = this.last7DaysGiftCountTxt;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 37;
        String r108 = this.fuzzyFanTicketStr;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 37;
        Long r111 = this.applyTimeSec;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public String getApplyReason() {
        return this.applyReason;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public Long getApplyTimeSec() {
        return this.applyTimeSec;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public String getFuzzyFanTicketStr() {
        return this.fuzzyFanTicketStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public String getLast7DaysGiftCountTxt() {
        return this.last7DaysGiftCountTxt;
    }

    public boolean hasExpired() {
        return this.hasExpired;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public boolean isHasExpired() {
        return this.hasExpired;
    }

    public boolean isIsMutualFollow() {
        return this.isMutualFollow;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public boolean isMutualFollow() {
        return this.isMutualFollow;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        WaitingListUserInfo r101 = (WaitingListUserInfo) r100;
        if (this.hasExpired == r101.hasExpired) goto L13;
    L23:
        return false;
    L13:
        if (this.isMutualFollow != r101.isMutualFollow) goto L23;
        if (TextUtils.equals(this.applyReason, r101.applyReason) == false) goto L23;
        if (TextUtils.equals(this.last7DaysGiftCountTxt, r101.last7DaysGiftCountTxt) == false) goto L23;
        if (TextUtils.equals(this.fuzzyFanTicketStr, r101.fuzzyFanTicketStr) == false) goto L23;
        if (Objects.equals(this.applyTimeSec, r101.applyTimeSec) == false) goto L23;
        return true;
    }

    public boolean isEqual(WaitingListUserInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.hasExpired == r100.hasExpired) goto L8;
        return false;
    L8:
        if (this.isMutualFollow == r100.isMutualFollow) goto L10;
        return false;
    L10:
        if (TextUtils.equals(this.applyReason, r100.applyReason) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.last7DaysGiftCountTxt, r100.last7DaysGiftCountTxt) == true) goto L14;
        return false;
    L14:
        if (TextUtils.equals(this.fuzzyFanTicketStr, r100.fuzzyFanTicketStr) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(this.applyTimeSec, r100.applyTimeSec) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setApplyReason(String r100) {
        this.applyReason = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setApplyTimeSec(Long r100) {
        this.applyTimeSec = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setFuzzyFanTicketStr(String r100) {
        this.fuzzyFanTicketStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setHasExpired(boolean r100) {
        this.hasExpired = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setLast7DaysGiftCountTxt(String r100) {
        this.last7DaysGiftCountTxt = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o0
    public void setMutualFollow(boolean r100) {
        this.isMutualFollow = r100;
    }
}
