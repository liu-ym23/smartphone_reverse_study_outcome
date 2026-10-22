package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import com.bytedance.android.shopping.anchorv3.matchpurchase.model.SkuSelectStruct;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseGroupViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f165161a;

    public m(p r100) {
        this.f165161a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List<SkuSelectStruct> r101 = (List) r100;
        MatchPurchaseGroupViewModel r102 = this.f165161a.f165164f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r102.getMatchPurchasePageInfoDynamic(r101);
    }
}
