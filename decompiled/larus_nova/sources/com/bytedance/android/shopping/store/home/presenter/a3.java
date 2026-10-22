package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class a3<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t2.b f184115a;

    public a3(t2.b r100) {
        this.f184115a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        t2.r0(this.f184115a.f184413a);
    }
}
