package com.bytedance.android.live.revlink.link.domain.service;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t51.b f98536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRegion f98537c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f98535a, r101.f98535a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98536b, r101.f98536b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98537c, r101.f98537c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f98535a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t51.b r104 = this.f98536b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IRegion r107 = this.f98537c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SeiWrap(linkerID=" + this.f98535a + ", position=" + this.f98536b + ", rtcRegion=" + this.f98537c + ")";
    }

    public d(String r100, t51.b r101, IRegion r102) {
        Intrinsics.checkNotNullParameter(r100, "linkerID");
        Intrinsics.checkNotNullParameter(r101, "position");
        this.f98535a = r100;
        this.f98536b = r101;
        this.f98537c = r102;
    }
}
