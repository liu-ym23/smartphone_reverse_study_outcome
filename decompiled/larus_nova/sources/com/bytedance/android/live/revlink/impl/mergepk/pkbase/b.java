package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import com.bytedance.android.livesdk.link.model.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f92697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x2 f92698b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f92697a == r101.f92697a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92698b, r101.f92698b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f92697a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        x2 r102 = this.f92698b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "CompatSkinConfig(skinType=" + this.f92697a + ", skinConfig=" + this.f92698b + ")";
    }

    public /* synthetic */ b(int r100) {
        this(0, null);
    }

    public b(long r100, x2 r101) {
        this.f92697a = r100;
        this.f92698b = r101;
    }
}
