package com.bytedance.android.ec.model;

import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B\u008d\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010=\u001a\u00020\u0004HÆ\u0003J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010B\u001a\u00020\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u000bHÆ\u0003J\t\u0010D\u001a\u00020\u000bHÆ\u0003J\u009a\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\u0014HÖ\u0001J\t\u0010K\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010#\"\u0004\b$\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%¨\u0006L"}, d2 = {"Lcom/bytedance/android/ec/model/ECUser;", "Ljava/io/Serializable;", "()V", "uid", "", "secUid", "(Ljava/lang/String;Ljava/lang/String;)V", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", InstantPlayContext.NICKNAME, "isHasOrders", "", CJOuterPayManager.KEY_BINDPHONE, "withCommerceRights", "withShopEntry", "withNewGoods", "withCommerceNewbieTask", "withItemCommerceEntry", "shopMicroApp", "followStatus", "", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZZLjava/lang/String;Ljava/lang/Integer;)V", "getAvatarMedium", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAvatarMedium", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getBindPhone", "()Ljava/lang/String;", "setBindPhone", "(Ljava/lang/String;)V", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setHasOrders", "(Z)V", "getNickname", "setNickname", "getSecUid", "setSecUid", "getShopMicroApp", "setShopMicroApp", "getUid", "setUid", "getWithCommerceNewbieTask", "setWithCommerceNewbieTask", "getWithCommerceRights", "setWithCommerceRights", "getWithItemCommerceEntry", "setWithItemCommerceEntry", "getWithNewGoods", "setWithNewGoods", "getWithShopEntry", "setWithShopEntry", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZZLjava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/ECUser;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUser implements Serializable {
    private ECUrlModel avatarMedium;
    private String bindPhone;
    private Integer followStatus;
    private boolean isHasOrders;
    private String nickname;
    private String secUid;
    private String shopMicroApp;
    private String uid;
    private boolean withCommerceNewbieTask;
    private boolean withCommerceRights;
    private boolean withItemCommerceEntry;
    private boolean withNewGoods;
    private boolean withShopEntry;

    public ECUser() {
        this(null, "", "", "", false, "", false, false, false, false, false, null, null, 7680, null);
    }

    public static /* synthetic */ ECUser copy$default(ECUser r110, ECUrlModel r111, String r112, String r113, String r114, boolean r115, String r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, String r216, Integer r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        ECUrlModel r100 = r110.avatarMedium;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.uid;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.secUid;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.nickname;
    L19:
        if ((r218 & 16) == 0) goto L21;
        boolean r104 = r110.isHasOrders;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.bindPhone;
    L27:
        if ((r218 & 64) == 0) goto L29;
        boolean r106 = r110.withCommerceRights;
    L31:
        if ((r218 & 128) == 0) goto L33;
        boolean r107 = r110.withShopEntry;
    L35:
        if ((r218 & 256) == 0) goto L37;
        boolean r116 = r110.withNewGoods;
    L39:
        if ((r218 & 512) == 0) goto L41;
        boolean r117 = r110.withCommerceNewbieTask;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        boolean r118 = r110.withItemCommerceEntry;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r119 = r110.shopMicroApp;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Integer r108 = r110.followStatus;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final ECUrlModel component1() {
        return this.avatarMedium;
    }

    public final boolean component10() {
        return this.withCommerceNewbieTask;
    }

    public final boolean component11() {
        return this.withItemCommerceEntry;
    }

    public final String component12() {
        return this.shopMicroApp;
    }

    public final Integer component13() {
        return this.followStatus;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.secUid;
    }

    public final String component4() {
        return this.nickname;
    }

    public final boolean component5() {
        return this.isHasOrders;
    }

    public final String component6() {
        return this.bindPhone;
    }

    public final boolean component7() {
        return this.withCommerceRights;
    }

    public final boolean component8() {
        return this.withShopEntry;
    }

    public final boolean component9() {
        return this.withNewGoods;
    }

    public final ECUser copy(ECUrlModel r110, String r111, String r112, String r113, boolean r210, String r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, String r217, Integer r218) {
        Intrinsics.checkNotNullParameter(r111, "uid");
        Intrinsics.checkNotNullParameter(r112, "secUid");
        return new ECUser(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECUser) == false) goto L32;
        ECUser r101 = (ECUser) r100;
        if (Intrinsics.areEqual(this.avatarMedium, r101.avatarMedium) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L14;
        return false;
    L14:
        if (this.isHasOrders == r101.isHasOrders) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bindPhone, r101.bindPhone) == true) goto L18;
        return false;
    L18:
        if (this.withCommerceRights == r101.withCommerceRights) goto L20;
        return false;
    L20:
        if (this.withShopEntry == r101.withShopEntry) goto L22;
        return false;
    L22:
        if (this.withNewGoods == r101.withNewGoods) goto L24;
        return false;
    L24:
        if (this.withCommerceNewbieTask == r101.withCommerceNewbieTask) goto L26;
        return false;
    L26:
        if (this.withItemCommerceEntry == r101.withItemCommerceEntry) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.shopMicroApp, r101.shopMicroApp) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ECUrlModel r100 = this.avatarMedium;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.uid;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.secUid;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.nickname;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.isHasOrders;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        String r117 = this.bindPhone;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.withCommerceRights;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (r119 + r121) * 31;
        boolean r123 = this.withShopEntry;
        ?? r124 = r123;
        if (r123 == false) goto L31;
        r124 = 1;
    L31:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.withNewGoods;
        ?? r127 = r126;
        if (r126 == false) goto L34;
        r127 = 1;
    L34:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.withCommerceNewbieTask;
        ?? r130 = r129;
        if (r129 == false) goto L37;
        r130 = 1;
    L37:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.withItemCommerceEntry;
        if (r132 == true) goto L41;
        r114 = r132;
    L41:
        int r133 = (r131 + r114) * 31;
        String r134 = this.shopMicroApp;
        if (r134 == null) goto L44;
        int r135 = r134.hashCode();
    L45:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.followStatus;
        if (r137 == null) goto L49;
        r101 = r137.hashCode();
    L49:
        return r136 + r101;
    L44:
        r135 = 0;
        goto L45
    L24:
        r118 = 0;
        goto L25
    L17:
        r111 = 0;
        goto L18
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
        return "ECUser(avatarMedium=" + this.avatarMedium + ", uid=" + this.uid + ", secUid=" + this.secUid + ", nickname=" + this.nickname + ", isHasOrders=" + this.isHasOrders + ", bindPhone=" + this.bindPhone + ", withCommerceRights=" + this.withCommerceRights + ", withShopEntry=" + this.withShopEntry + ", withNewGoods=" + this.withNewGoods + ", withCommerceNewbieTask=" + this.withCommerceNewbieTask + ", withItemCommerceEntry=" + this.withItemCommerceEntry + ", shopMicroApp=" + this.shopMicroApp + ", followStatus=" + this.followStatus + ")";
    }

    public final ECUrlModel getAvatarMedium() {
        return this.avatarMedium;
    }

    public final String getBindPhone() {
        return this.bindPhone;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getShopMicroApp() {
        return this.shopMicroApp;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean getWithCommerceNewbieTask() {
        return this.withCommerceNewbieTask;
    }

    public final boolean getWithCommerceRights() {
        return this.withCommerceRights;
    }

    public final boolean getWithItemCommerceEntry() {
        return this.withItemCommerceEntry;
    }

    public final boolean getWithNewGoods() {
        return this.withNewGoods;
    }

    public final boolean getWithShopEntry() {
        return this.withShopEntry;
    }

    public final boolean isHasOrders() {
        return this.isHasOrders;
    }

    public final void setAvatarMedium(ECUrlModel r100) {
        this.avatarMedium = r100;
    }

    public final void setBindPhone(String r100) {
        this.bindPhone = r100;
    }

    public final void setFollowStatus(Integer r100) {
        this.followStatus = r100;
    }

    public final void setHasOrders(boolean r100) {
        this.isHasOrders = r100;
    }

    public final void setNickname(String r100) {
        this.nickname = r100;
    }

    public final void setSecUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secUid = r100;
    }

    public final void setShopMicroApp(String r100) {
        this.shopMicroApp = r100;
    }

    public final void setUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uid = r100;
    }

    public final void setWithCommerceNewbieTask(boolean r100) {
        this.withCommerceNewbieTask = r100;
    }

    public final void setWithCommerceRights(boolean r100) {
        this.withCommerceRights = r100;
    }

    public final void setWithItemCommerceEntry(boolean r100) {
        this.withItemCommerceEntry = r100;
    }

    public final void setWithNewGoods(boolean r100) {
        this.withNewGoods = r100;
    }

    public final void setWithShopEntry(boolean r100) {
        this.withShopEntry = r100;
    }

    public ECUser(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "uid");
        Intrinsics.checkNotNullParameter(r111, "secUid");
        this(null, r110, r111, "", false, "", false, false, false, false, false, null, null, 7680, null);
    }

    public ECUser(ECUrlModel r100, String r101, String r102, String r103, boolean r104, String r105, boolean r106, boolean r107, boolean r110, boolean r111, boolean r112, String r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        this.avatarMedium = r100;
        this.uid = r101;
        this.secUid = r102;
        this.nickname = r103;
        this.isHasOrders = r104;
        this.bindPhone = r105;
        this.withCommerceRights = r106;
        this.withShopEntry = r107;
        this.withNewGoods = r110;
        this.withCommerceNewbieTask = r111;
        this.withItemCommerceEntry = r112;
        this.shopMicroApp = r113;
        this.followStatus = r114;
    }

    public /* synthetic */ ECUser(ECUrlModel r110, String r111, String r210, String r211, boolean r212, String r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, String r219, Integer r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 2) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r311 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r311 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r311 & 32) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r311 & 64) == 0) goto L21;
        boolean r112 = false;
    L23:
        if ((r311 & 128) == 0) goto L25;
        boolean r113 = false;
    L27:
        if ((r311 & 256) == 0) goto L29;
        boolean r114 = false;
    L31:
        if ((r311 & 512) == 0) goto L33;
        boolean r115 = false;
    L35:
        if ((r311 & 1024) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r311 & 2048) == 0) goto L41;
        String r117 = "";
    L43:
        if ((r311 & 4096) == 0) goto L45;
        Integer r118 = -1;
    L46:
        this(r110, r100, r101, r102, r212, r103, r112, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r310;
        goto L46
    L41:
        r117 = r219;
        goto L43
    L37:
        r116 = r218;
        goto L39
    L33:
        r115 = r217;
        goto L35
    L29:
        r114 = r216;
        goto L31
    L25:
        r113 = r215;
        goto L27
    L21:
        r112 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
