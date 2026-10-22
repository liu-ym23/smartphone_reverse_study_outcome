package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;

/* JADX INFO: loaded from: classes12.dex */
public final class n<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f165162a;

    public n(p r100) {
        this.f165162a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        p63.b r101 = (p63.b) r100;
        if (r101 == null) goto L5;
        String r102 = r101.f527880a;
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        this.f165162a.Z().b(R.id.tv_product_desc).c();
        return;
    L16:
        Query r104 = this.f165162a.Z().b(R.id.tv_product_desc);
        r104.g(0);
        r104.e(r102);
        return;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
