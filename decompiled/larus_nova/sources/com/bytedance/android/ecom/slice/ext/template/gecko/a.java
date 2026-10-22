package com.bytedance.android.ecom.slice.ext.template.gecko;

import com.bytedance.forest.model.Response;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f51251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f51252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f51253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Response f51254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f51255f;

    public a() {
        this(null, null, null, null, null, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f51250a, r101.f51250a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51251b, r101.f51251b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f51252c, r101.f51252c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f51253d, r101.f51253d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f51254e, r101.f51254e) == true) goto L16;
        return false;
    L16:
        if (this.f51255f == r101.f51255f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f51250a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f51251b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Throwable r107 = this.f51252c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f51253d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Response r113 = this.f51254e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f51255f;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
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
        return "FetchGeckoResult(content=" + this.f51250a + ", msg=" + this.f51251b + ", throwable=" + this.f51252c + ", errorCode=" + this.f51253d + ", response=" + this.f51254e + ", forceBuiltin=" + this.f51255f + ")";
    }

    public a(String r100, String r101, Throwable r102, String r103, Response r104, boolean r105) {
        this.f51250a = r100;
        this.f51251b = r101;
        this.f51252c = r102;
        this.f51253d = r103;
        this.f51254e = r104;
        this.f51255f = r105;
    }

    public /* synthetic */ a(String r100, String r101, Throwable r102, String r103, Response r110, boolean r111, int r112) {
        Response r104 = null;
        if ((r112 & 1) == 0) goto L5;
        String r105 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Throwable r107 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r108 = null;
    L19:
        if ((r112 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r113 = false;
    L26:
        this(r105, r106, r107, r108, r104, r113);
        return;
    L25:
        r113 = r111;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r105 = r100;
        goto L7
    }
}
