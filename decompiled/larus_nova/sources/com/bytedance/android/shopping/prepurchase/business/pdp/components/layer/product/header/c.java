package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import vg3.m;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f181779a;

    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceRegistry");
        this.f181779a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w
    public final void y(d r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        m r103 = (m) this.f181779a.getService(m.class);
        if (r103 == null) goto L6;
        r103.y(r100, r101, r102);
        return;
    }
}
