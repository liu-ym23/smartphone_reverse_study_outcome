package com.bytedance.android.shopping.api.mall.feed;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f170511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f170512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.api.mall.feed.a f170513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f170514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f170515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f170516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f170517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ECMallFeedStickyConfig f170518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f170519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f170520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f170521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.shopping.api.mall.idl.c f170522n;

    public static final class a {
    }

    static {
    }

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L34;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f170509a, r101.f170509a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170510b, r101.f170510b) == true) goto L10;
        return false;
    L10:
        if (this.f170511c == r101.f170511c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170512d, r101.f170512d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170513e, r101.f170513e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170514f, r101.f170514f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f170515g, r101.f170515g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f170516h, r101.f170516h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f170517i, r101.f170517i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f170518j, r101.f170518j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f170519k, r101.f170519k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f170520l, r101.f170520l) == true) goto L30;
        return false;
    L30:
        if (this.f170521m == r101.f170521m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f170522n, r101.f170522n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f170509a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f170510b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f170511c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        Integer r111 = this.f170512d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        com.bytedance.android.shopping.api.mall.feed.a r114 = this.f170513e;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        c r117 = this.f170514f;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        i r120 = this.f170515g;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f170516h;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f170517i;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        ECMallFeedStickyConfig r129 = this.f170518j;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        Map<String, Object> r132 = this.f170519k;
        if (r132 == null) goto L44;
        int r133 = r132.hashCode();
    L45:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f170520l;
        if (r135 == null) goto L48;
        int r136 = r135.hashCode();
    L49:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.f170521m;
        if (r138 == true) goto L53;
        r108 = r138;
    L53:
        int r139 = (r137 + r108) * 31;
        com.bytedance.android.shopping.api.mall.idl.c r140 = this.f170522n;
        if (r140 == null) goto L57;
        r101 = r140.hashCode();
    L57:
        return r139 + r101;
    L48:
        r136 = 0;
        goto L49
    L44:
        r133 = 0;
        goto L45
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallFeedConfig(pageName=" + this.f170509a + ", title=" + this.f170510b + ", initImmediately=" + this.f170511c + ", triggerLoadMoreThreshold=" + this.f170512d + ", apiCacheConfig=" + this.f170513e + ", imagePrefetchConfig=" + this.f170514f + ", titleUi=" + this.f170515g + ", bundleConfigUrl=" + this.f170516h + ", pageCardUrl=" + this.f170517i + ", stickyConfig=" + this.f170518j + ", logExtra=" + this.f170519k + ", fetchId=" + this.f170520l + ", isInSplit=" + this.f170521m + ", screenModel=" + this.f170522n + ")";
    }

    public b(String r110, String r111, Integer r112, com.bytedance.android.shopping.api.mall.feed.a r210, c r211, i r212, String r213, String r214, ECMallFeedStickyConfig r215, String r216, boolean r217, com.bytedance.android.shopping.api.mall.idl.c r218, int r219) {
        if ((r219 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r219 & 8) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r219 & 16) == 0) goto L13;
        com.bytedance.android.shopping.api.mall.feed.a r102 = null;
    L15:
        if ((r219 & 32) == 0) goto L17;
        c r103 = null;
    L19:
        if ((r219 & 64) == 0) goto L21;
        i r104 = null;
    L23:
        if ((r219 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r219 & 256) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r219 & 512) == 0) goto L33;
        ECMallFeedStickyConfig r114 = null;
    L35:
        if ((r219 & 2048) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r219 & 4096) == 0) goto L41;
        boolean r116 = false;
    L43:
        if ((r219 & 8192) == 0) goto L45;
        com.bytedance.android.shopping.api.mall.idl.c r106 = null;
    L46:
        Intrinsics.checkNotNullParameter(r110, "pageName");
        this.f170509a = r110;
        this.f170510b = r100;
        this.f170511c = false;
        this.f170512d = r101;
        this.f170513e = r102;
        this.f170514f = r103;
        this.f170515g = r104;
        this.f170516h = r105;
        this.f170517i = r113;
        this.f170518j = r114;
        this.f170519k = null;
        this.f170520l = r115;
        this.f170521m = r116;
        this.f170522n = r106;
        return;
    L45:
        r106 = r218;
        goto L46
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
