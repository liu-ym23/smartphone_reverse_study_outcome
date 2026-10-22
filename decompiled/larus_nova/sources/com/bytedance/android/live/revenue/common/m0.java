package com.bytedance.android.live.revenue.common;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fr2.e f90845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f90846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f90847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fr2.p f90848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f90849e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L16;
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f90845a, r101.f90845a) == true) goto L8;
        return false;
    L8:
        if (this.f90846b == r101.f90846b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f90847c, r101.f90847c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f90848d, r101.f90848d) == true) goto L14;
        return false;
    L14:
        if (this.f90849e == r101.f90849e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        fr2.e r100 = this.f90845a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f90846b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Map<String, Object> r108 = this.f90847c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        fr2.p r111 = this.f90848d;
        if (r111 == null) goto L16;
        r101 = r111.hashCode();
    L16:
        int r112 = (r110 + r101) * 31;
        boolean r113 = this.f90849e;
        if (r113 == true) goto L21;
        r105 = r113;
    L21:
        return r112 + r105;
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcData(client=" + this.f90845a + ", isEngineOn=" + this.f90846b + ", remoteMap=" + this.f90847c + ", liveCore=" + this.f90848d + ", hasLinkAudience4Stop=" + this.f90849e + ")";
    }

    public m0(fr2.e r100, boolean r101, Map<String, Object> r102, fr2.p r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "remoteMap");
        this.f90845a = r100;
        this.f90846b = r101;
        this.f90847c = r102;
        this.f90848d = r103;
        this.f90849e = r104;
    }
}
