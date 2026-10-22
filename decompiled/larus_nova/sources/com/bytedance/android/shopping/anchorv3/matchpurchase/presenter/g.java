package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.FloatingTagLayout;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes12.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f165152a;

    public g(i r100) {
        this.f165152a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CombinationVO r101 = (CombinationVO) r100;
        if (r101 == null) goto L7;
        FloatingTagLayout r102 = (FloatingTagLayout) this.f165152a.Z().b(R.id.header_layout).f();
        f r103 = new f(this);
        int r104 = FloatingTagLayout.f165184d;
        r102.a(r101, null, r103, true, null);
        return;
    }
}
