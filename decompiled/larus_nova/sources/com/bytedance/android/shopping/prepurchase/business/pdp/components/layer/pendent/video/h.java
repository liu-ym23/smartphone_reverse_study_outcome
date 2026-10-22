package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f181537a;

    public h(i r100) {
        this.f181537a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_PAUSE) goto L10;
        i.a r102 = this.f181537a.f181540c;
        if (r102 == null) goto L10;
        s r103 = r102.f181546b;
        if (r103 == null) goto L10;
        r103.Q0();
    L10:
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L17;
        i.a r104 = this.f181537a.f181540c;
        if (r104 == null) goto L18;
        s r105 = r104.f181546b;
        if (r105 == null) goto L19;
        r105.onPageDestroy();
        return;
    L19:
        return;
    L18:
        return;
    }
}
