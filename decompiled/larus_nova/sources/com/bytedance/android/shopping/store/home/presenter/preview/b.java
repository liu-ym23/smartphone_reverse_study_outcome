package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements cf.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopExplainCardPresenter f184345a;

    public b(ECShopExplainCardPresenter r100) {
        this.f184345a = r100;
    }

    @Override // cf.n
    public final boolean open(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        dm.a.a("点击进直播间").a("setupOpenSchemaProxy");
        ECShopExplainCardPresenter r101 = this.f184345a;
        ViewGroup r102 = r101.f184271k;
        if (r102 == null) goto L7;
        o r103 = (o) r101.f184274n.getValue();
        if (r103 == null) goto L7;
        return r103.c(r100, r102);
    L7:
        return false;
    }
}
