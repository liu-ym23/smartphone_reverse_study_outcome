package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpNotifyHostService extends b0 {
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(vg3.a.class);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        vg3.a r100 = (vg3.a) N1(vg3.a.class);
        if (r100 == null) goto L7;
        AnchorV4PlayerStateManager r101 = r100.e();
        if (r101 == null) goto L7;
        r101.f167511e = null;
    L7:
        vg3.a r102 = (vg3.a) N1(vg3.a.class);
        if (r102 == null) goto L12;
        AnchorV4PlayerStateManager r103 = r102.e();
        if (r103 == null) goto L12;
        r103.f167512f = null;
    L12:
        super.U1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        vg3.a r100 = (vg3.a) N1(vg3.a.class);
        if (r100 == null) goto L7;
        AnchorV4PlayerStateManager r101 = r100.e();
        if (r101 == null) goto L7;
        r101.f167511e = PdpNotifyHostService$onAttach$1.INSTANCE;
    L7:
        vg3.a r102 = (vg3.a) N1(vg3.a.class);
        if (r102 == null) goto L13;
        AnchorV4PlayerStateManager r103 = r102.e();
        if (r103 == null) goto L14;
        r103.f167512f = PdpNotifyHostService$onAttach$2.INSTANCE;
        return;
    L14:
        return;
    }

    public PdpNotifyHostService() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
    }
}
