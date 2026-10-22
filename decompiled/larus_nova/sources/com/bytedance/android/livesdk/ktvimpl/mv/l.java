package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.livesdk.message.model.ed;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f146064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f146065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f146066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f146067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f146068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f146069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f146070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<ed> f146071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f146072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f146073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f146074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f146075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f146076m;

    public static final class a {
    }

    static {
    }

    public l() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L26;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f146067d, r101.f146067d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f146068e, r101.f146068e) == true) goto L10;
        return false;
    L10:
        if (this.f146069f == r101.f146069f) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f146070g, r101.f146070g) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f146071h, r101.f146071h) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f146072i, r101.f146072i) == true) goto L18;
        return false;
    L18:
        if (this.f146073j == r101.f146073j) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f146074k, r101.f146074k) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f146075l, r101.f146075l) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f146076m, r101.f146076m) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f146067d;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f146068e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f146069f;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f146070g;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        List<ed> r112 = this.f146071h;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.f146072i;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (((r114 + r116) * 31) + this.f146073j) * 31;
        String r118 = this.f146074k;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f146075l;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        Long r124 = this.f146076m;
        if (r124 == null) goto L34;
        r101 = r124.hashCode();
    L34:
        return r123 + r101;
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "vid=" + this.f146067d + "，songId=" + this.f146069f + "，orderUid=" + this.f146070g + "，playFrom=" + this.f146074k + "，，saveFrom=" + this.f146075l;
    }

    public /* synthetic */ l(y r100, String r110, String r111, List r112, int r113) {
        this(r100, r110, r111, r112, null, r113, "null");
    }

    public l(y r110, String r111, String r112, List<ed> r113, Integer r114, int r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "songParam");
        Intrinsics.checkNotNullParameter(r111, "vid");
        Intrinsics.checkNotNullParameter(r116, "saveFrom");
        this(r111, r112, r110.f146208b, r110.f146210d, r113, r114, r115, r116);
    }

    public l(String r100, String r101, long r102, String r103, List r104, Integer r105, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        Intrinsics.checkNotNullParameter(r103, "orderUidString");
        Intrinsics.checkNotNullParameter("null", "playFrom");
        Intrinsics.checkNotNullParameter(r111, "saveFrom");
        this.f146067d = r100;
        this.f146068e = r101;
        this.f146069f = r102;
        this.f146070g = r103;
        this.f146071h = r104;
        this.f146072i = r105;
        this.f146073j = r110;
        this.f146074k = "null";
        this.f146075l = r111;
        this.f146076m = null;
    }
}
