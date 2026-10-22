package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/StoreV3DeleteCommitDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "followButtonDisplay", "", "followIconType", "", "followGiftConfig", "Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)V", "getFollowButtonDisplay", "()Ljava/lang/String;", "getFollowGiftConfig", "()Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "getFollowIconType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)Lcom/bytedance/android/shopping/store/repository/dto/StoreV3DeleteCommitDTO;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV3DeleteCommitDTO extends CommerceBaseResponse {

    @SerializedName("follow_button_display")
    private final String followButtonDisplay;

    @SerializedName("follow_config")
    private final StoreFollowGiftConfig followGiftConfig;

    @SerializedName("follow_icon_type")
    private final Integer followIconType;

    public StoreV3DeleteCommitDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StoreV3DeleteCommitDTO copy$default(StoreV3DeleteCommitDTO r100, String r101, Integer r102, StoreFollowGiftConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.followButtonDisplay;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.followIconType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.followGiftConfig;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.followButtonDisplay;
    }

    public final Integer component2() {
        return this.followIconType;
    }

    public final StoreFollowGiftConfig component3() {
        return this.followGiftConfig;
    }

    public final StoreV3DeleteCommitDTO copy(String r100, Integer r101, StoreFollowGiftConfig r102) {
        return new StoreV3DeleteCommitDTO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StoreV3DeleteCommitDTO) == false) goto L12;
        StoreV3DeleteCommitDTO r101 = (StoreV3DeleteCommitDTO) r100;
        if (Intrinsics.areEqual(this.followButtonDisplay, r101.followButtonDisplay) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.followIconType, r101.followIconType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.followGiftConfig, r101.followGiftConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.followButtonDisplay;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.followIconType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        StoreFollowGiftConfig r107 = this.followGiftConfig;
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
        return "StoreV3DeleteCommitDTO(followButtonDisplay=" + this.followButtonDisplay + ", followIconType=" + this.followIconType + ", followGiftConfig=" + this.followGiftConfig + ")";
    }

    public final String getFollowButtonDisplay() {
        return this.followButtonDisplay;
    }

    public final StoreFollowGiftConfig getFollowGiftConfig() {
        return this.followGiftConfig;
    }

    public final Integer getFollowIconType() {
        return this.followIconType;
    }

    public StoreV3DeleteCommitDTO(String r100, Integer r101, StoreFollowGiftConfig r102) {
        this.followButtonDisplay = r100;
        this.followIconType = r101;
        this.followGiftConfig = r102;
    }

    public /* synthetic */ StoreV3DeleteCommitDTO(String r100, Integer r101, StoreFollowGiftConfig r102, int r103, DefaultConstructorMarker r104) {
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
