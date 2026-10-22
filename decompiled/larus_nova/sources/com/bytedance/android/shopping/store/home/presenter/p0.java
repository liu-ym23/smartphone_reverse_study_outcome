package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class p0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f184262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f184263b;

    public p0(o0 r100, float r101) {
        this.f184262a = r100;
        this.f184263b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        this.f184262a.r0(this.f184263b, r101.intValue() & 16777215, r101.intValue());
    }
}
