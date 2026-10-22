package com.bytedance.android.live.liveinteract.view;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f79982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f79983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f79984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f79985e;

    public b() {
        this(0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (this.f79981a == r101.f79981a) goto L8;
        return false;
    L8:
        if (this.f79982b == r101.f79982b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f79983c, r101.f79983c) == true) goto L12;
        return false;
    L12:
        if (this.f79984d == r101.f79984d) goto L14;
        return false;
    L14:
        if (this.f79985e == r101.f79985e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = this.f79981a * 31;
        long r101 = this.f79982b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f79983c;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L6:
        int r105 = (r102 + r104) * 31;
        boolean r106 = this.f79984d;
        ?? r107 = r106;
        if (r106 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r105 + r107) * 31;
        long r109 = this.f79985e;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "RadioContentConfig(gravity=" + this.f79981a + ", textSize=" + this.f79982b + ", textColor=" + this.f79983c + ", isScrolling=" + this.f79984d + ", scrollSpeed=" + this.f79985e + ")";
    }

    public /* synthetic */ b(long r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        int r100 = 17;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r110 = 12;
    L9:
        long r101 = r110;
        if ((r111 & 4) == 0) goto L12;
        String r112 = CustomHeaderConfig.COLOR_LIGHT;
    L13:
        String r102 = r112;
        if ((r111 & 8) == 0) goto L16;
        boolean r103 = true;
    L18:
        if ((r111 & 16) == 0) goto L20;
        long r113 = 2000;
    L21:
        this(r100, r101, r102, r103, r113);
        return;
    L20:
        r113 = 0;
        goto L21
    L16:
        r103 = false;
        goto L18
    L12:
        r112 = null;
        goto L13
    L5:
        r100 = 0;
        goto L7
    }

    public b(int r100, long r101, String r102, boolean r103, long r104) {
        Intrinsics.checkNotNullParameter(r102, "textColor");
        this.f79981a = r100;
        this.f79982b = r101;
        this.f79983c = r102;
        this.f79984d = r103;
        this.f79985e = r104;
    }
}
