package com.bytedance.android.shopping.commentv3.uitree.p008float;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import lc3.b;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f172812a;

    public a(b r100) {
        this.f172812a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        b r101 = (b) r100;
        this.f172812a.e(new FloatWindowLogic$observeStat$1$1(this));
    }
}
