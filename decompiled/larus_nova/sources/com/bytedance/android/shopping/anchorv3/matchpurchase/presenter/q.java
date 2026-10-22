package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;

/* JADX INFO: loaded from: classes12.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f165165a;

    public q(s r100) {
        this.f165165a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Query r101 = this.f165165a.Z().b(R.id.match_purchase_fragment_title_v2);
        r101.e((String) r100);
    }
}
