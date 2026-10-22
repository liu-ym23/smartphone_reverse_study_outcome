package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import android.app.Activity;
import com.bytedance.android.shopping.anchorv3.matchpurchase.viewmodel.MatchPurchaseActivityModel;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f165155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MatchPurchaseActivityModel f165156b;

    public j(l r100, MatchPurchaseActivityModel r101) {
        this.f165155a = r100;
        this.f165156b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L8;
        this.f165156b.getRepository().a();
        Activity r101 = d0.f165305a.getActivity(this.f165155a.u().c());
        if (r101 == null) goto L9;
        r101.finish();
        return;
    L9:
        return;
    }
}
