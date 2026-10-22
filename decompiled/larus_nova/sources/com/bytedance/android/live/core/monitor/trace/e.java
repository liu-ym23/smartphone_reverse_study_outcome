package com.bytedance.android.live.core.monitor.trace;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f64997m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f64998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f65000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f65001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f65002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f65003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f65004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f65005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f65006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f65007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f65008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Object> f65009l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f65010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f65011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f65012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f65013d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f65014e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f65015f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f65016g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f65017h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f65018i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map<String, Object> f65019j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f65020k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f65021l;

        public final e a() {
            return new e(this.f65020k, this.f65021l, this.f65010a, this.f65011b, this.f65012c, this.f65013d, this.f65014e, this.f65015f, this.f65016g, this.f65017h, this.f65018i, this.f65019j);
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            Intrinsics.checkNotNullParameter(r101, "businessType");
            this.f65020k = r100;
            this.f65021l = r101;
        }

        public final void b(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            if (this.f65019j != null) goto L5;
            this.f65019j = new LinkedHashMap();
            Unit r102 = Unit.INSTANCE;
        L5:
            Map<String, Object> r103 = this.f65019j;
            if (r103 == null) goto L9;
            r103.put(r100, r101);
            return;
        }
    }

    public static final class b {
        @JvmStatic
        public static a a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            Intrinsics.checkNotNullParameter(r101, "businessType");
            return new a(r100, r101);
        }
    }

    static {
    }

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L30;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f64998a, r101.f64998a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f64999b, r101.f64999b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f65000c, r101.f65000c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f65001d, r101.f65001d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f65002e, r101.f65002e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f65003f, r101.f65003f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f65004g, r101.f65004g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f65005h, r101.f65005h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f65006i, r101.f65006i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f65007j, r101.f65007j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f65008k, r101.f65008k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f65009l, r101.f65009l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f64998a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f64999b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f65000c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f65001d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f65002e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f65003f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f65004g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f65005h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f65006i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f65007j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f65008k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, Object> r134 = this.f65009l;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
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
        return "TraceMeta(eventType=" + this.f64998a + ", businessType=" + this.f64999b + ", traceId=" + this.f65000c + ", logId=" + this.f65001d + ", productId=" + this.f65002e + ", step=" + this.f65003f + ", roomId=" + this.f65004g + ", anchorId=" + this.f65005h + ", userId=" + this.f65006i + ", statusCode=" + this.f65007j + ", statusMsg=" + this.f65008k + ", index=" + this.f65009l + ")";
    }

    public /* synthetic */ e(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, Integer r215, String r216, Map r217, int r218) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r218 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r218 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r218 & 64) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r218 & 128) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r218 & 256) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r218 & 512) == 0) goto L37;
        Integer r116 = null;
    L39:
        if ((r218 & 1024) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r218 & 2048) == 0) goto L45;
        Map r118 = null;
    L46:
        this(r100, r101, r102, null, r103, r104, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r217;
        goto L46
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r113 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public e(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, Integer r111, String r112, Map<String, Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        this.f64998a = r100;
        this.f64999b = r101;
        this.f65000c = r102;
        this.f65001d = r103;
        this.f65002e = r104;
        this.f65003f = r105;
        this.f65004g = r106;
        this.f65005h = r107;
        this.f65006i = r110;
        this.f65007j = r111;
        this.f65008k = r112;
        this.f65009l = r113;
    }
}
