package com.bytedance.android.live.profit.vip;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f89133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f89134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f89135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f89136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f89137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f89138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f89139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f89140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f89141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f89142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f89143k;

    public static final class a {
    }

    static {
    }

    public h() {
        this(2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L28;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f89133a, r101.f89133a) == true) goto L8;
        return false;
    L8:
        if (this.f89134b == r101.f89134b) goto L10;
        return false;
    L10:
        if (this.f89135c == r101.f89135c) goto L12;
        return false;
    L12:
        if (this.f89136d == r101.f89136d) goto L14;
        return false;
    L14:
        if (this.f89137e == r101.f89137e) goto L16;
        return false;
    L16:
        if (this.f89138f == r101.f89138f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f89139g, r101.f89139g) == true) goto L20;
        return false;
    L20:
        if (this.f89140h == r101.f89140h) goto L22;
        return false;
    L22:
        if (this.f89141i == r101.f89141i) goto L24;
        return false;
    L24:
        if (this.f89142j == r101.f89142j) goto L26;
        return false;
    L26:
        if (this.f89143k == r101.f89143k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        List<l> r100 = this.f89133a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f89134b) * 31;
        boolean r104 = this.f89135c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (((r103 + r106) * 31) + this.f89136d) * 31;
        boolean r108 = this.f89137e;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f89138f;
        ?? r112 = r111;
        if (r111 == false) goto L15;
        r112 = 1;
    L15:
        int r113 = (r110 + r112) * 31;
        m r114 = this.f89139g;
        if (r114 == null) goto L18;
        r101 = r114.hashCode();
    L18:
        int r115 = (r113 + r101) * 31;
        boolean r116 = this.f89140h;
        if (r116 == true) goto L22;
        r105 = r116;
    L22:
        int r117 = (((r115 + r105) * 31) + this.f89141i) * 31;
        long r118 = this.f89142j;
        return ((r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.f89143k;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SubscribeInfo(emojiList=" + this.f89133a + ", status=" + this.f89134b + ", isMember=" + this.f89135c + ", memberType=" + this.f89136d + ", entrance=" + this.f89137e + ", entranceTab=" + this.f89138f + ", emojiTabInfo=" + this.f89139g + ", isVsRoom=" + this.f89140h + ", level=" + this.f89141i + ", expiredTime=" + this.f89142j + ", initStatus=" + this.f89143k + ")";
    }

    public /* synthetic */ h(int r110) {
        if ((r110 & 1) == 0) goto L5;
        List r100 = com.bytedance.revenue.platform.api.core.c.a(new l[0]);
    L6:
        List r101 = r100;
        if ((r110 & 8) == 0) goto L9;
        int r102 = -1;
    L11:
        if ((r110 & 1024) == 0) goto L13;
        int r111 = -1;
    L14:
        this(r101, 0, false, r102, false, false, null, false, 0, 0, r111);
        return;
    L13:
        r111 = 0;
        goto L14
    L9:
        r102 = 0;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    public h(List<l> r100, int r101, boolean r102, int r103, boolean r104, boolean r105, m r106, boolean r107, int r110, long r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "emojiList");
        this.f89133a = r100;
        this.f89134b = r101;
        this.f89135c = r102;
        this.f89136d = r103;
        this.f89137e = r104;
        this.f89138f = r105;
        this.f89139g = r106;
        this.f89140h = r107;
        this.f89141i = r110;
        this.f89142j = r111;
        this.f89143k = r112;
    }
}
