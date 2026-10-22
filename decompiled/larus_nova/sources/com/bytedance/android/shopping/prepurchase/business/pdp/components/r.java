package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.widget.FrameLayout;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx.LynxPendentComponent;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f181826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f181827d;

    @Override // java.lang.Runnable
    public final void run() {
        n r100 = this.f181826c;
        if (r100.f181806b != null) goto L10;
        LynxPendentComponent r101 = new LynxPendentComponent();
        m r102 = this.f181826c.f181808d;
        if (r102 == null) goto L7;
        int r103 = this.f181827d.indexOfChild(r102.e2()) + 1;
    L8:
        n.b(this.f181826c, this.f181827d, r101, null, r103, 4);
        Unit r104 = Unit.INSTANCE;
        r100.f181806b = r101;
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public r(n r100, FrameLayout r101) {
        this.f181826c = r100;
        this.f181827d = r101;
        super("load_lynx_pendent_component");
    }
}
