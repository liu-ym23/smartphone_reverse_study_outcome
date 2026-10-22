package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class p extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f181818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f181819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f181820e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f181819d.indexOfChild(((m) this.f181820e.element).e2());
        n.b(this.f181818c, this.f181819d, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.m(), null, r100, 4);
    }

    public p(n r100, FrameLayout r101, Ref.ObjectRef r102) {
        this.f181818c = r100;
        this.f181819d = r101;
        this.f181820e = r102;
        super("root_component_first_screen_delay_load");
    }
}
