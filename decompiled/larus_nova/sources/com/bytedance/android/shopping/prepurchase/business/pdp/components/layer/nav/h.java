package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TopNavigationComponentV2 f181257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f181258d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f181257c.p2(this.f181258d, false);
    }

    public h(TopNavigationComponentV2 r100, String r101) {
        this.f181257c = r100;
        this.f181258d = r101;
        super("select_tab");
    }
}
