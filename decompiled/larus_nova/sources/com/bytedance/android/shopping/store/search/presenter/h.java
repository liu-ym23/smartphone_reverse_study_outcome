package com.bytedance.android.shopping.store.search.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zm.b f186085a;

    public h(zm.b r100) {
        this.f186085a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        zm.b r101 = this.f186085a;
        r101.setData((List) r100);
    }
}
