package com.bytedance.android.window.shop.home.tab;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f188744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f188745b;

    public g(String r100, String r101) {
        this.f188744a = r100;
        this.f188745b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        b r101 = (b) r100;
        if (r101 == null) goto L6;
        r101.a(this.f188744a, this.f188745b);
        return;
    }
}
