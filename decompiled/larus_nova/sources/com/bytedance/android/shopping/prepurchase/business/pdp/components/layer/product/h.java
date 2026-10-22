package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ji3.i f181752a;

    public h(ji3.i r100) {
        this.f181752a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_START) goto L6;
        ji3.i r102 = this.f181752a;
        r102.f499176a = true;
        r102.a(r102.f499180e);
    L6:
        if (r101 != Lifecycle.Event.ON_STOP) goto L9;
        ji3.i r103 = this.f181752a;
        r103.f499176a = false;
        r103.f499177b.removeCallbacks(r103.f499178c);
        return;
    }
}
