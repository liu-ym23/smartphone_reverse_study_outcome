package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.store.repository.dto.d;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sj3.j;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/StoreV3FollowCommitDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "component1", "Lsj3/j;", "component2", "Lcom/bytedance/android/ec/store/repository/dto/d;", "component3", "followSuccessMsg", "shopFollowGiftDTO", "hybridComponentDTO", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getFollowSuccessMsg", "()Ljava/lang/String;", "Lsj3/j;", "getShopFollowGiftDTO", "()Lsj3/j;", "Lcom/bytedance/android/ec/store/repository/dto/d;", "getHybridComponentDTO", "()Lcom/bytedance/android/ec/store/repository/dto/d;", "<init>", "(Ljava/lang/String;Lsj3/j;Lcom/bytedance/android/ec/store/repository/dto/d;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV3FollowCommitDTO extends CommerceBaseResponse {

    @SerializedName("follow_success_msg")
    private final String followSuccessMsg;

    @SerializedName("display_module")
    private final d hybridComponentDTO;

    @SerializedName("shop_follow_gift")
    private final j shopFollowGiftDTO;

    public StoreV3FollowCommitDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StoreV3FollowCommitDTO copy$default(StoreV3FollowCommitDTO r100, String r101, j r102, d r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.followSuccessMsg;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.shopFollowGiftDTO;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hybridComponentDTO;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.followSuccessMsg;
    }

    public final j component2() {
        return this.shopFollowGiftDTO;
    }

    public final d component3() {
        return this.hybridComponentDTO;
    }

    public final StoreV3FollowCommitDTO copy(String r100, j r101, d r102) {
        return new StoreV3FollowCommitDTO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StoreV3FollowCommitDTO) == false) goto L12;
        StoreV3FollowCommitDTO r101 = (StoreV3FollowCommitDTO) r100;
        if (Intrinsics.areEqual(this.followSuccessMsg, r101.followSuccessMsg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopFollowGiftDTO, r101.shopFollowGiftDTO) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hybridComponentDTO, r101.hybridComponentDTO) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.followSuccessMsg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        j r104 = this.shopFollowGiftDTO;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.hybridComponentDTO;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StoreV3FollowCommitDTO(followSuccessMsg=" + this.followSuccessMsg + ", shopFollowGiftDTO=" + this.shopFollowGiftDTO + ", hybridComponentDTO=" + this.hybridComponentDTO + ")";
    }

    public final String getFollowSuccessMsg() {
        return this.followSuccessMsg;
    }

    public final d getHybridComponentDTO() {
        return this.hybridComponentDTO;
    }

    public final j getShopFollowGiftDTO() {
        return this.shopFollowGiftDTO;
    }

    public StoreV3FollowCommitDTO(String r100, j r101, d r102) {
        this.followSuccessMsg = r100;
        this.shopFollowGiftDTO = r101;
        this.hybridComponentDTO = r102;
    }

    public /* synthetic */ StoreV3FollowCommitDTO(String r100, j r101, d r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
