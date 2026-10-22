package com.bytedance.android.live.liveinteract.interact.audience;

import com.alibaba.gaiax.template.GXTemplateKey;
import gd0.s;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f73981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.a f73982b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f73981a, r101.f73981a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f73982b, r101.f73982b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        s r100 = this.f73981a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        z.a r104 = this.f73982b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractGuestLayerData(data=" + this.f73981a + ", layer=" + this.f73982b + ")";
    }

    public o(s r100, z.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_LAYER);
        this.f73981a = r100;
        this.f73982b = r101;
    }
}
