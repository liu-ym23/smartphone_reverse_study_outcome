package com.bytedance.android.live.revenuelink.rtc;

import fr2.n0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends n0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<n0> f91974b;

    public s(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f91974b = new WeakReference(r100);
    }

    @Override // fr2.n0
    public final void b(gr2.b r100, int r101, long r110, Exception r111) {
        n0 r102 = this.f91974b.get();
        if (r102 == null) goto L6;
        r102.b(r100, r101, r110, r111);
        return;
    }

    @Override // fr2.n0
    public final void l(gr2.b r100, int r101, long r110, Object... r111) {
        Intrinsics.checkNotNullParameter(r111, "params");
        n0 r102 = this.f91974b.get();
        if (r102 == null) goto L6;
        r102.l(r100, r101, r110, Arrays.copyOf(r111, r111.length));
        return;
    }
}
