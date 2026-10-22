package com.bytedance.android.live.profit.vip;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f89157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f89158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f89159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f89160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f89161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f89162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f89163g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L20;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f89157a, r101.f89157a) == true) goto L8;
        return false;
    L8:
        if (this.f89158b == r101.f89158b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f89159c, r101.f89159c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f89160d, r101.f89160d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f89161e, r101.f89161e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f89162f, r101.f89162f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f89163g, r101.f89163g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public final int hashCode() {
        String r100 = this.f89157a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f89158b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f89159c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f89160d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f89161e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f89162f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f89163g;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VipEmojiTabInfoData(describe=" + this.f89157a + ", btnShow=" + this.f89158b + ", btnText=" + this.f89159c + ", btnSchema=" + this.f89160d + ", emojiIconSelectUrl=" + this.f89161e + ", emojiIconUnselectUrl=" + this.f89162f + ", emojiTabName=" + this.f89163g + ")";
    }

    public m(String r100, boolean r101, String r102, String r103, String r104, String r105, String r106) {
        this.f89157a = r100;
        this.f89158b = r101;
        this.f89159c = r102;
        this.f89160d = r103;
        this.f89161e = r104;
        this.f89162f = r105;
        this.f89163g = r106;
    }
}
