package com.bytedance.android.livesdk.config;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f120085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f120086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f120087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f120088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f120089e;

    public static final class a {
    }

    static {
    }

    public e41() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e41) == false) goto L16;
        e41 r101 = (e41) r100;
        if (this.f120085a == r101.f120085a) goto L8;
        return false;
    L8:
        if (this.f120086b == r101.f120086b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f120087c, r101.f120087c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f120088d, r101.f120088d) == true) goto L14;
        return false;
    L14:
        if (this.f120089e == r101.f120089e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f120085a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f120086b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f120087c;
        int r108 = 0;
        if (r107 == null) goto L11;
        int r109 = r107.hashCode();
    L12:
        int r110 = (r106 + r109) * 31;
        Map<String, Integer> r111 = this.f120088d;
        if (r111 == null) goto L15;
        r108 = r111.hashCode();
    L15:
        int r112 = (r110 + r108) * 31;
        boolean r113 = this.f120089e;
        if (r113 == true) goto L20;
        r101 = r113;
    L20:
        return r112 + r101;
    L11:
        r109 = 0;
        goto L12
    }

    public final String toString() {
        return "LiveIndependentGuideConfig(isShownGuide=" + this.f120085a + ", isShownClose=" + this.f120086b + ", currentDate=" + this.f120087c + ", dateCountMap=" + this.f120088d + ", isFirstBackGround=" + this.f120089e + ")";
    }

    @JvmStatic
    public static final e41 b() {
        return new e41(0);
    }

    public /* synthetic */ e41(int r100) {
        this(false, false, "", new LinkedHashMap(), false);
    }

    public e41(boolean r100, boolean r101, String r102, Map<String, Integer> r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "dateCountMap");
        this.f120085a = r100;
        this.f120086b = r101;
        this.f120087c = r102;
        this.f120088d = r103;
        this.f120089e = r104;
    }

    public static e41 a(e41 r100, boolean r101, boolean r102, String r103, Map r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f120085a;
    L5:
        boolean r104 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f120086b;
    L8:
        boolean r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f120087c;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r110 = r100.f120088d;
    L14:
        Map r107 = r110;
        if ((r111 & 16) == 0) goto L17;
        boolean r108 = r100.f120089e;
    L18:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r107, "dateCountMap");
        return new e41(r104, r105, r106, r107, r108);
    L17:
        r108 = false;
        goto L18
    }
}
