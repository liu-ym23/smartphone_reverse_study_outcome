package com.bytedance.android.window.shop.repository.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003Jj\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020:HÖ\u0001R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%¨\u0006;"}, d2 = {"Lcom/bytedance/android/window/shop/repository/vo/ShopHeaderControlVO;", "Ljava/io/Serializable;", "followStatus", "", "shopGuideDisplay", "", "showSearch", "showFollow", "fansClubInfo", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "followButtonBubble", "Lcom/bytedance/android/ec/model/ECUrlModel;", "fansRedPackBubble", "newReputationStyle", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Z)V", "getFansClubInfo", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "setFansClubInfo", "(Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;)V", "getFansRedPackBubble", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setFansRedPackBubble", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getFollowButtonBubble", "setFollowButtonBubble", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNewReputationStyle", "()Z", "setNewReputationStyle", "(Z)V", "getShopGuideDisplay", "()Ljava/lang/Boolean;", "setShopGuideDisplay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShowFollow", "setShowFollow", "getShowSearch", "setShowSearch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Z)Lcom/bytedance/android/window/shop/repository/vo/ShopHeaderControlVO;", "equals", "other", "", "hashCode", "toString", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopHeaderControlVO implements Serializable {

    @SerializedName("fans_club_info")
    private WindowFansClubInfo fansClubInfo;
    private ECUrlModel fansRedPackBubble;
    private ECUrlModel followButtonBubble;
    private Integer followStatus;
    private boolean newReputationStyle;
    private Boolean shopGuideDisplay;
    private boolean showFollow;
    private Boolean showSearch;

    public ShopHeaderControlVO() {
        this(null, null, null, false, null, null, null, false, 255, null);
    }

    public static /* synthetic */ ShopHeaderControlVO copy$default(ShopHeaderControlVO r100, Integer r110, Boolean r111, Boolean r112, boolean r113, WindowFansClubInfo r114, ECUrlModel r115, ECUrlModel r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.followStatus;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Boolean r102 = r100.shopGuideDisplay;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r103 = r100.showSearch;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.showFollow;
    L19:
        if ((r118 & 16) == 0) goto L21;
        WindowFansClubInfo r105 = r100.fansClubInfo;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ECUrlModel r106 = r100.followButtonBubble;
    L27:
        if ((r118 & 64) == 0) goto L29;
        ECUrlModel r107 = r100.fansRedPackBubble;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.newReputationStyle;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final Integer component1() {
        return this.followStatus;
    }

    public final Boolean component2() {
        return this.shopGuideDisplay;
    }

    public final Boolean component3() {
        return this.showSearch;
    }

    public final boolean component4() {
        return this.showFollow;
    }

    public final WindowFansClubInfo component5() {
        return this.fansClubInfo;
    }

    public final ECUrlModel component6() {
        return this.followButtonBubble;
    }

    public final ECUrlModel component7() {
        return this.fansRedPackBubble;
    }

    public final boolean component8() {
        return this.newReputationStyle;
    }

    public final ShopHeaderControlVO copy(Integer r110, Boolean r111, Boolean r112, boolean r113, WindowFansClubInfo r114, ECUrlModel r115, ECUrlModel r116, boolean r117) {
        return new ShopHeaderControlVO(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShopHeaderControlVO) == false) goto L22;
        ShopHeaderControlVO r101 = (ShopHeaderControlVO) r100;
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopGuideDisplay, r101.shopGuideDisplay) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showSearch, r101.showSearch) == true) goto L12;
        return false;
    L12:
        if (this.showFollow == r101.showFollow) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansClubInfo, r101.fansClubInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.followButtonBubble, r101.followButtonBubble) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fansRedPackBubble, r101.fansRedPackBubble) == true) goto L20;
        return false;
    L20:
        if (this.newReputationStyle == r101.newReputationStyle) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Integer r100 = this.followStatus;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.shopGuideDisplay;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.showSearch;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.showFollow;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        WindowFansClubInfo r114 = this.fansClubInfo;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        ECUrlModel r117 = this.followButtonBubble;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        ECUrlModel r120 = this.fansRedPackBubble;
        if (r120 == null) goto L28;
        r101 = r120.hashCode();
    L28:
        int r121 = (r119 + r101) * 31;
        boolean r122 = this.newReputationStyle;
        if (r122 == true) goto L33;
        r111 = r122;
    L33:
        return r121 + r111;
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ShopHeaderControlVO(followStatus=" + this.followStatus + ", shopGuideDisplay=" + this.shopGuideDisplay + ", showSearch=" + this.showSearch + ", showFollow=" + this.showFollow + ", fansClubInfo=" + this.fansClubInfo + ", followButtonBubble=" + this.followButtonBubble + ", fansRedPackBubble=" + this.fansRedPackBubble + ", newReputationStyle=" + this.newReputationStyle + ")";
    }

    public final WindowFansClubInfo getFansClubInfo() {
        return this.fansClubInfo;
    }

    public final ECUrlModel getFansRedPackBubble() {
        return this.fansRedPackBubble;
    }

    public final ECUrlModel getFollowButtonBubble() {
        return this.followButtonBubble;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getNewReputationStyle() {
        return this.newReputationStyle;
    }

    public final Boolean getShopGuideDisplay() {
        return this.shopGuideDisplay;
    }

    public final boolean getShowFollow() {
        return this.showFollow;
    }

    public final Boolean getShowSearch() {
        return this.showSearch;
    }

    public final void setFansClubInfo(WindowFansClubInfo r100) {
        this.fansClubInfo = r100;
    }

    public final void setFansRedPackBubble(ECUrlModel r100) {
        this.fansRedPackBubble = r100;
    }

    public final void setFollowButtonBubble(ECUrlModel r100) {
        this.followButtonBubble = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setNewReputationStyle(boolean r100) {
        this.newReputationStyle = r100;
    }

    public final void setShopGuideDisplay(Boolean r100) {
        this.shopGuideDisplay = r100;
    }

    public final void setShowFollow(boolean r100) {
        this.showFollow = r100;
    }

    public final void setShowSearch(Boolean r100) {
        this.showSearch = r100;
    }

    public ShopHeaderControlVO(Integer r100, Boolean r101, Boolean r102, boolean r103, WindowFansClubInfo r104, ECUrlModel r105, ECUrlModel r106, boolean r107) {
        this.followStatus = r100;
        this.shopGuideDisplay = r101;
        this.showSearch = r102;
        this.showFollow = r103;
        this.fansClubInfo = r104;
        this.followButtonBubble = r105;
        this.fansRedPackBubble = r106;
        this.newReputationStyle = r107;
    }

    public /* synthetic */ ShopHeaderControlVO(Integer r110, Boolean r111, Boolean r112, boolean r113, WindowFansClubInfo r114, ECUrlModel r115, ECUrlModel r116, boolean r117, int r118, DefaultConstructorMarker r210) {
        ECUrlModel r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Boolean r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Boolean r103 = Boolean.FALSE;
    L14:
        boolean r104 = false;
        if ((r118 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r118 & 16) == 0) goto L21;
        WindowFansClubInfo r106 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        ECUrlModel r107 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r104 = r117;
    L34:
        this(r101, r102, r103, r105, r106, r107, r100, r104);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
