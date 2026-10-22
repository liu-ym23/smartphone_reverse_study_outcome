package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes13.dex */
public final class TopNavigationComponentV1$processShareButton$1 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TopNavigationComponentV1 f181341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ShareMeta f181342d;

    @Override // java.lang.Runnable
    public final void run() {
        BuildersKt.launch$default(this.f181341c.Q1(), Dispatchers.getIO(), null, new TopNavigationComponentV1$processShareButton$1$run$1(this, null), 2, null);
    }

    public TopNavigationComponentV1$processShareButton$1(TopNavigationComponentV1 r100, ShareMeta r101) {
        this.f181341c = r100;
        this.f181342d = r101;
        super("processShareButton");
    }
}
