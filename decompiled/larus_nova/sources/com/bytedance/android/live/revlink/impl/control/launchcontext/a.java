package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements sc0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f92430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f21.a f92431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v3 f92432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p0 f92433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f92434e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f92430a, r101.f92430a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92431b, r101.f92431b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92432c, r101.f92432c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92433d, r101.f92433d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f92434e, r101.f92434e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        u r100 = this.f92430a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f21.a r104 = this.f92431b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        v3 r107 = this.f92432c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        p0 r110 = this.f92433d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f92434e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "MultiLinkAnchorLaunchContext(launchParameters=" + this.f92430a + ", connectionContext=" + this.f92431b + ", clientAttachedInfo=" + this.f92432c + ", battleAttachedInfo=" + this.f92433d + ", eventTrackingInfo=" + this.f92434e + ")";
    }

    public a(u r100, f21.a r101, v3 r102, p0 r103, String r104) {
        this.f92430a = r100;
        this.f92431b = r101;
        this.f92432c = r102;
        this.f92433d = r103;
        this.f92434e = r104;
    }
}
