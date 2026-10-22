package com.bytedance.android.ec.window.base.shop;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003JR\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"¨\u00062"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "Ljava/io/Serializable;", "openFansClub", "", "joinStatus", "fansClubLevel", "", "fansClubUrl", "", "fansClubBubbleConfig", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubBubbleConfig;", "fansClubCouponConfig", "Lcom/bytedance/android/ec/window/base/shop/WindowFollowGiftConfig;", "(ZZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/window/base/shop/WindowFansClubBubbleConfig;Lcom/bytedance/android/ec/window/base/shop/WindowFollowGiftConfig;)V", "getFansClubBubbleConfig", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubBubbleConfig;", "setFansClubBubbleConfig", "(Lcom/bytedance/android/ec/window/base/shop/WindowFansClubBubbleConfig;)V", "getFansClubCouponConfig", "()Lcom/bytedance/android/ec/window/base/shop/WindowFollowGiftConfig;", "setFansClubCouponConfig", "(Lcom/bytedance/android/ec/window/base/shop/WindowFollowGiftConfig;)V", "getFansClubLevel", "()Ljava/lang/Integer;", "setFansClubLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFansClubUrl", "()Ljava/lang/String;", "setFansClubUrl", "(Ljava/lang/String;)V", "getJoinStatus", "()Z", "setJoinStatus", "(Z)V", "getOpenFansClub", "setOpenFansClub", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/window/base/shop/WindowFansClubBubbleConfig;Lcom/bytedance/android/ec/window/base/shop/WindowFollowGiftConfig;)Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "equals", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFansClubInfo implements Serializable {

    @SerializedName("fans_config")
    private WindowFansClubBubbleConfig fansClubBubbleConfig;

    @SerializedName("fans_club_coupon_config")
    private WindowFollowGiftConfig fansClubCouponConfig;

    @SerializedName("fans_club_level")
    private Integer fansClubLevel;

    @SerializedName("fans_club_url")
    private String fansClubUrl;

    @SerializedName("join_status")
    private boolean joinStatus;

    @SerializedName("open_fans_club")
    private boolean openFansClub;

    public WindowFansClubInfo() {
        this(false, false, null, null, null, null, 63, null);
    }

    public static /* synthetic */ WindowFansClubInfo copy$default(WindowFansClubInfo r100, boolean r101, boolean r102, Integer r103, String r104, WindowFansClubBubbleConfig r105, WindowFollowGiftConfig r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.openFansClub;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.joinStatus;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.fansClubLevel;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.fansClubUrl;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.fansClubBubbleConfig;
    L17:
        WindowFansClubBubbleConfig r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.fansClubCouponConfig;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.openFansClub;
    }

    public final boolean component2() {
        return this.joinStatus;
    }

    public final Integer component3() {
        return this.fansClubLevel;
    }

    public final String component4() {
        return this.fansClubUrl;
    }

    public final WindowFansClubBubbleConfig component5() {
        return this.fansClubBubbleConfig;
    }

    public final WindowFollowGiftConfig component6() {
        return this.fansClubCouponConfig;
    }

    public final WindowFansClubInfo copy(boolean r100, boolean r110, Integer r111, String r112, WindowFansClubBubbleConfig r113, WindowFollowGiftConfig r114) {
        return new WindowFansClubInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowFansClubInfo) == false) goto L18;
        WindowFansClubInfo r101 = (WindowFansClubInfo) r100;
        if (this.openFansClub == r101.openFansClub) goto L8;
        return false;
    L8:
        if (this.joinStatus == r101.joinStatus) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fansClubLevel, r101.fansClubLevel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fansClubUrl, r101.fansClubUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansClubBubbleConfig, r101.fansClubBubbleConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fansClubCouponConfig, r101.fansClubCouponConfig) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        boolean r100 = this.openFansClub;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.joinStatus;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        Integer r106 = this.fansClubLevel;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        String r110 = this.fansClubUrl;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        WindowFansClubBubbleConfig r113 = this.fansClubBubbleConfig;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        WindowFollowGiftConfig r116 = this.fansClubCouponConfig;
        if (r116 == null) goto L25;
        r107 = r116.hashCode();
    L25:
        return r115 + r107;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public String toString() {
        return "WindowFansClubInfo(openFansClub=" + this.openFansClub + ", joinStatus=" + this.joinStatus + ", fansClubLevel=" + this.fansClubLevel + ", fansClubUrl=" + this.fansClubUrl + ", fansClubBubbleConfig=" + this.fansClubBubbleConfig + ", fansClubCouponConfig=" + this.fansClubCouponConfig + ")";
    }

    public final WindowFansClubBubbleConfig getFansClubBubbleConfig() {
        return this.fansClubBubbleConfig;
    }

    public final WindowFollowGiftConfig getFansClubCouponConfig() {
        return this.fansClubCouponConfig;
    }

    public final Integer getFansClubLevel() {
        return this.fansClubLevel;
    }

    public final String getFansClubUrl() {
        return this.fansClubUrl;
    }

    public final boolean getJoinStatus() {
        return this.joinStatus;
    }

    public final boolean getOpenFansClub() {
        return this.openFansClub;
    }

    public final void setFansClubBubbleConfig(WindowFansClubBubbleConfig r100) {
        this.fansClubBubbleConfig = r100;
    }

    public final void setFansClubCouponConfig(WindowFollowGiftConfig r100) {
        this.fansClubCouponConfig = r100;
    }

    public final void setFansClubLevel(Integer r100) {
        this.fansClubLevel = r100;
    }

    public final void setFansClubUrl(String r100) {
        this.fansClubUrl = r100;
    }

    public final void setJoinStatus(boolean r100) {
        this.joinStatus = r100;
    }

    public final void setOpenFansClub(boolean r100) {
        this.openFansClub = r100;
    }

    public WindowFansClubInfo(boolean r100, boolean r101, Integer r102, String r103, WindowFansClubBubbleConfig r104, WindowFollowGiftConfig r105) {
        this.openFansClub = r100;
        this.joinStatus = r101;
        this.fansClubLevel = r102;
        this.fansClubUrl = r103;
        this.fansClubBubbleConfig = r104;
        this.fansClubCouponConfig = r105;
    }

    public /* synthetic */ WindowFansClubInfo(boolean r100, boolean r101, Integer r102, String r103, WindowFansClubBubbleConfig r104, WindowFollowGiftConfig r110, int r111, DefaultConstructorMarker r112) {
        boolean r105 = false;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) != 0) goto L11;
        r105 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r111 & 16) == 0) goto L21;
        WindowFansClubBubbleConfig r108 = null;
    L23:
        if ((r111 & 32) == 0) goto L25;
        WindowFollowGiftConfig r114 = null;
    L26:
        this(r113, r105, r106, r107, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L5:
        r113 = r100;
        goto L7
    }
}
