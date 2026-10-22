package com.bytedance.android.ec.hybrid.list;

import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ListEngineOptConfig {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f46915o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f46916p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f46917q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f46918r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f46919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f46920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f46921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f46922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f46923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f46924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f46925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f46926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f46927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f46928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<String> f46929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f46930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f46931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f46932n;

    public static final class a {
        public a() {
        }

        public static Integer a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "pageName");
            Object r101 = ((Map) ListEngineOptConfig.f46916p.getValue()).get(r100);
            if ((r101 instanceof Number) == true) goto L5;
            r101 = null;
        L5:
            Number r102 = (Number) r101;
            if (r102 != null) goto L8;
            return null;
        L8:
            return Integer.valueOf(r102.intValue());
        }
    }

    public ListEngineOptConfig() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ListEngineOptConfig) == false) goto L34;
        ListEngineOptConfig r101 = (ListEngineOptConfig) r100;
        if (Intrinsics.areEqual(this.f46919a, r101.f46919a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f46920b, r101.f46920b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46921c, r101.f46921c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f46922d, r101.f46922d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f46923e, r101.f46923e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f46924f, r101.f46924f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f46925g, r101.f46925g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f46926h, r101.f46926h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f46927i, r101.f46927i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f46928j, r101.f46928j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f46929k, r101.f46929k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f46930l, r101.f46930l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f46931m, r101.f46931m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f46932n, r101.f46932n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f46919a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f46920b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f46921c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f46922d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f46923e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f46924f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f46925g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f46926h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f46927i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f46928j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Set<String> r131 = this.f46929k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f46930l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.f46931m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.f46932n;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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

    public final String toString() {
        return "ListEngineOptConfig(firstScreenPreloadCount=" + this.f46919a + ", notFirstScreenPreloadCount=" + this.f46920b + ", allowAutoLoadCount=" + this.f46921c + ", gulLoadOnFirstExposure=" + this.f46922d + ", gulLoadOnFirstExposureInFistScreen=" + this.f46923e + ", gulLoadOnFirstExposureAfterScroll=" + this.f46924f + ", scroll0NotAllowLoadMore=" + this.f46925g + ", allowLoadMoreInFirstScreen=" + this.f46926h + ", delayLoadMoreCheck=" + this.f46927i + ", loadMoreMinNum=" + this.f46928j + ", preInflaterView=" + this.f46929k + ", loadMoreImageImmPreloadNum=" + this.f46930l + ", loadMoreEndPreloadImageRadicalizationNum=" + this.f46931m + ", loadMoreEndRadicalization=" + this.f46932n + ")";
    }

    static {
        f46918r = new a();
        f46915o = LazyKt.lazy(ListEngineOptConfig$Companion$scroll0NotAllowLoadMorePage$2.INSTANCE);
        f46916p = LazyKt.lazy(ListEngineOptConfig$Companion$loadMoreCardMinNum$2.INSTANCE);
        f46917q = LazyKt.lazy(ListEngineOptConfig$Companion$loadMoreCardMinNumBlack$2.INSTANCE);
    }

    public ListEngineOptConfig(Integer r110, Integer r111, Integer r112, Integer r113, Integer r210, Integer r211, Boolean r212, Boolean r213, Boolean r214, Integer r215, Set r216, Integer r217, Integer r218, Integer r219, int r310) {
        Integer r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Boolean r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Boolean r114 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Boolean r115 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Integer r116 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Set r117 = null;
    L47:
        if ((r310 & 4096) == 0) goto L49;
        Integer r118 = null;
    L51:
        if ((r310 & 8192) != 0) goto L54;
        r100 = r219;
    L54:
        this.f46919a = r101;
        this.f46920b = r102;
        this.f46921c = r103;
        this.f46922d = r104;
        this.f46923e = r105;
        this.f46924f = r106;
        this.f46925g = r107;
        this.f46926h = r114;
        this.f46927i = r115;
        this.f46928j = r116;
        this.f46929k = r117;
        this.f46930l = r217;
        this.f46931m = r118;
        this.f46932n = r100;
        return;
    L49:
        r118 = r218;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
}
