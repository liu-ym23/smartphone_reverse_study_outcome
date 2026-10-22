package com.bytedance.android.shopping.api.mall;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f170223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECHybridNetworkVO f170225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f170226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f170227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f170228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Throwable f170229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f170230h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L22;
        c r101 = (c) r100;
        if (this.f170223a == r101.f170223a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170224b, r101.f170224b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170225c, r101.f170225c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170226d, r101.f170226d) == true) goto L14;
        return false;
    L14:
        if (this.f170227e == r101.f170227e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f170228f, r101.f170228f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f170229g, r101.f170229g) == true) goto L20;
        return false;
    L20:
        if (this.f170230h == r101.f170230h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        boolean r100 = this.f170223a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f170224b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        ECHybridNetworkVO r108 = this.f170225c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f170226d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f170227e;
        if (r114 == true) goto L21;
        r101 = r114;
    L21:
        int r115 = (r113 + r101) * 31;
        String r116 = this.f170228f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Throwable r119 = this.f170229g;
        if (r119 == null) goto L28;
        r105 = r119.hashCode();
    L28:
        long r120 = this.f170230h;
        return ((r118 + r105) * 31) + ((int) (r120 ^ (r120 >>> 32)));
    L24:
        r117 = 0;
        goto L25
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return com.bytedance.android.ec.hybrid.list.util.k.d(this);
    }

    public /* synthetic */ c(boolean r110, String r111, ECHybridNetworkVO r112, String r113, String r114, Throwable r115) {
        this(r110, r111, r112, r113, false, r114, r115, System.currentTimeMillis());
    }

    public c(boolean r100, String r101, ECHybridNetworkVO r102, String r103, boolean r104, String r105, Throwable r106, long r107) {
        Intrinsics.checkNotNullParameter(r101, "apiKey");
        Intrinsics.checkNotNullParameter(r103, "requestKey");
        this.f170223a = r100;
        this.f170224b = r101;
        this.f170225c = r102;
        this.f170226d = r103;
        this.f170227e = r104;
        this.f170228f = r105;
        this.f170229g = r106;
        this.f170230h = r107;
    }
}
