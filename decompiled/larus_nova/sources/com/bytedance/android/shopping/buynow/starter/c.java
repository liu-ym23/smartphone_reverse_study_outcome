package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f171136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final YataPageInfo f171137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Object> f171138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f171139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f171140e;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f171136a, r101.f171136a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f171137b, r101.f171137b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f171138c, r101.f171138c) == true) goto L12;
        return false;
    L12:
        if (this.f171139d == r101.f171139d) goto L14;
        return false;
    L14:
        if (this.f171140e == r101.f171140e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r100 = this.f171136a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        YataPageInfo r104 = this.f171137b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        WeakReference<Object> r107 = this.f171138c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f171139d;
        ?? r110 = 1;
        ?? r111 = r109;
        if (r109 == false) goto L16;
        r111 = 1;
    L16:
        int r112 = (r108 + r111) * 31;
        boolean r113 = this.f171140e;
        if (r113 == true) goto L21;
        r110 = r113;
    L21:
        return r112 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyNowPageInfo(sessionId=" + this.f171136a + ", pageInfo=" + this.f171137b + ", btmNodeRef=" + this.f171138c + ", isSplitScreen=" + this.f171139d + ", splitScreenOpened=" + this.f171140e + ")";
    }

    public c(String r100, YataPageInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "pageInfo");
        this.f171136a = r100;
        this.f171137b = r101;
        this.f171138c = null;
        this.f171139d = false;
        this.f171140e = false;
    }
}
