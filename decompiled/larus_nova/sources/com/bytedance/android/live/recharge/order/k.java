package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f90118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f90120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f90121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f90122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f90123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f90124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f90125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f90126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f90127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final NoPasswordPayType f90128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f90129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f90130m;

    public k() {
        this(null, null, false, 0, false, false, 0, 0, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L32;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f90118a, r101.f90118a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f90119b, r101.f90119b) == true) goto L10;
        return false;
    L10:
        if (this.f90120c == r101.f90120c) goto L12;
        return false;
    L12:
        if (this.f90121d == r101.f90121d) goto L14;
        return false;
    L14:
        if (this.f90122e == r101.f90122e) goto L16;
        return false;
    L16:
        if (this.f90123f == r101.f90123f) goto L18;
        return false;
    L18:
        if (this.f90124g == r101.f90124g) goto L20;
        return false;
    L20:
        if (this.f90125h == r101.f90125h) goto L22;
        return false;
    L22:
        if (this.f90126i == r101.f90126i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f90127j, r101.f90127j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f90128k, r101.f90128k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f90129l, r101.f90129l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f90130m, r101.f90130m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        j r100 = this.f90118a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f90119b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f90120c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (((r106 + r109) * 31) + this.f90121d) * 31;
        boolean r111 = this.f90122e;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f90123f;
        if (r114 == true) goto L20;
        r108 = r114;
    L20:
        long r115 = this.f90124g;
        int r116 = (((((((r113 + r108) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31) + this.f90125h) * 31) + this.f90126i) * 31;
        JSONObject r117 = this.f90127j;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        NoPasswordPayType r120 = this.f90128k;
        if (r120 == null) goto L27;
        int r121 = r120.hashCode();
    L28:
        int r122 = (r119 + r121) * 31;
        Map<String, String> r123 = this.f90129l;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        Map<String, String> r126 = this.f90130m;
        if (r126 == null) goto L36;
        r101 = r126.hashCode();
    L36:
        return r125 + r101;
    L31:
        r124 = 0;
        goto L32
    L27:
        r121 = 0;
        goto L28
    L23:
        r118 = 0;
        goto L24
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RechargeOrderOptions(eventProperties=" + this.f90118a + ", oneStepPayScene=" + this.f90119b + ", isFastPay=" + this.f90120c + ", rechargeDialogHeight=" + this.f90121d + ", supportCombinedPay=" + this.f90122e + ", useCombinedPay=" + this.f90123f + ", combinedPayIncomeAmount=" + this.f90124g + ", orderSource=" + this.f90125h + ", businessScene=" + this.f90126i + ", bizExtra=" + this.f90127j + ", noPasswordPayType=" + this.f90128k + ", queriesMap=" + this.f90129l + ", extraMap=" + this.f90130m + ")";
    }

    public static k a(k r110, j r111, String r210, JSONObject r211, NoPasswordPayType r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        j r100 = r110.f90118a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = r110.f90119b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        boolean r102 = r110.f90120c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r103 = r110.f90121d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        boolean r104 = r110.f90122e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r105 = r110.f90123f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        long r112 = r110.f90124g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r113 = r110.f90125h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        int r114 = r110.f90126i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        JSONObject r115 = r110.f90127j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        NoPasswordPayType r116 = r110.f90128k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        Map<String, String> r106 = r110.f90129l;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        Map<String, String> r107 = r110.f90130m;
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventProperties");
        Intrinsics.checkNotNullParameter(r101, "oneStepPayScene");
        Intrinsics.checkNotNullParameter(r115, "bizExtra");
        Intrinsics.checkNotNullParameter(r116, "noPasswordPayType");
        Intrinsics.checkNotNullParameter(r106, "queriesMap");
        Intrinsics.checkNotNullParameter(r107, "extraMap");
        return new k(r100, r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r106, r107);
    L53:
        r107 = null;
        goto L54
    L49:
        r106 = null;
        goto L51
    L45:
        r116 = r212;
        goto L47
    L41:
        r115 = r211;
        goto L43
    L37:
        r114 = 0;
        goto L39
    L33:
        r113 = 0;
        goto L35
    L29:
        r112 = 0;
        goto L31
    L25:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = 0;
        goto L19
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ k(j r110, String r111, boolean r210, int r211, boolean r212, boolean r213, int r214, int r215, JSONObject r216, NoPasswordPayType r217, Map r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        j r100 = new j();
    L7:
        if ((r219 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r219 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r219 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r219 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r219 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r219 & 128) == 0) goto L29;
        int r112 = -1;
    L31:
        if ((r219 & 256) == 0) goto L33;
        int r113 = -1;
    L35:
        if ((r219 & 512) == 0) goto L37;
        JSONObject r114 = new JSONObject();
    L39:
        if ((r219 & 1024) == 0) goto L41;
        NoPasswordPayType r115 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
    L43:
        if ((r219 & 2048) == 0) goto L45;
        Map r116 = new LinkedHashMap();
    L47:
        if ((r219 & 4096) == 0) goto L49;
        LinkedHashMap r106 = new LinkedHashMap();
    L50:
        this(r100, r101, r102, r103, r104, r105, 0, r112, r113, r114, r115, r116, r106);
        return;
    L49:
        r106 = null;
        goto L50
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r112 = r214;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public k(j r100, String r101, boolean r102, int r103, boolean r104, boolean r105, long r106, int r110, int r111, JSONObject r112, NoPasswordPayType r113, Map<String, String> r114, Map<String, String> r115) {
        Intrinsics.checkNotNullParameter(r100, "eventProperties");
        Intrinsics.checkNotNullParameter(r101, "oneStepPayScene");
        Intrinsics.checkNotNullParameter(r112, "bizExtra");
        Intrinsics.checkNotNullParameter(r113, "noPasswordPayType");
        Intrinsics.checkNotNullParameter(r114, "queriesMap");
        Intrinsics.checkNotNullParameter(r115, "extraMap");
        this.f90118a = r100;
        this.f90119b = r101;
        this.f90120c = r102;
        this.f90121d = r103;
        this.f90122e = r104;
        this.f90123f = r105;
        this.f90124g = r106;
        this.f90125h = r110;
        this.f90126i = r111;
        this.f90127j = r112;
        this.f90128k = r113;
        this.f90129l = r114;
        this.f90130m = r115;
    }
}
