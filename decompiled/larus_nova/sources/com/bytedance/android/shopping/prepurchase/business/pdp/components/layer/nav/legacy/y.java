package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;

/* JADX INFO: loaded from: classes13.dex */
public final class y extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TopRightControlsComponent f181390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TopRightControlsVO f181391d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f181390c.a(this.f181391d);
    }

    public y(TopRightControlsComponent r100, TopRightControlsVO r101) {
        this.f181390c = r100;
        this.f181391d = r101;
        super("bindIconsInnerOpt");
    }
}
