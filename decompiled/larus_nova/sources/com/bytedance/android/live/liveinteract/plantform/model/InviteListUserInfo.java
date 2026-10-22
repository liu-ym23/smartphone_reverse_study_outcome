package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class InviteListUserInfo extends FlexModelBase<i> implements i {

    @SerializedName("fuzzy_fan_ticket")
    public String fuzzyFanTicket;

    @SerializedName("is_active")
    public boolean isActive;

    @SerializedName("last_7_days_gift_count_text")
    public String last7DaysGiftCountTxt;

    public int hashCode() {
        return Objects.hash(new Object[]{this.last7DaysGiftCountTxt, this.fuzzyFanTicket, Boolean.valueOf(this.isActive)});
    }

    public InviteListUserInfo() {
        super(i.class);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.i
    public String getFuzzyFanTicket() {
        return this.fuzzyFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.i
    public String getLast7DaysGiftCountTxt() {
        return this.last7DaysGiftCountTxt;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.i
    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        InviteListUserInfo r101 = (InviteListUserInfo) r100;
        if (TextUtils.equals(this.last7DaysGiftCountTxt, r101.last7DaysGiftCountTxt) == true) goto L13;
    L17:
        return false;
    L13:
        if (TextUtils.equals(this.fuzzyFanTicket, r101.fuzzyFanTicket) == false) goto L17;
        if (this.isActive != r101.isActive) goto L17;
        return true;
    }

    public boolean isEqual(InviteListUserInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.last7DaysGiftCountTxt, r100.last7DaysGiftCountTxt) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(this.fuzzyFanTicket, r100.fuzzyFanTicket) == true) goto L10;
        return false;
    L10:
        if (this.isActive != r100.isActive) goto L15;
        return true;
    L15:
        return false;
    }
}
