package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes13.dex */
public final class TopNavigationComponentV2$processShareButton$1 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TopNavigationComponentV2 f181225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TopNavVO f181226d;

    @Override // java.lang.Runnable
    public final void run() {
        BuildersKt.launch$default(this.f181225c.Q1(), Dispatchers.getIO(), null, new TopNavigationComponentV2$processShareButton$1$run$1(this, null), 2, null);
    }

    public TopNavigationComponentV2$processShareButton$1(TopNavigationComponentV2 r100, TopNavVO r101) {
        this.f181225c = r100;
        this.f181226d = r101;
        super("processShareButton");
    }
}
