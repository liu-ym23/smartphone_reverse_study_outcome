package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.arch.FoldAdaptedFrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class u<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FoldAdaptedFrameLayout f184509a;

    public u(FoldAdaptedFrameLayout r100) {
        this.f184509a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        FoldAdaptedFrameLayout r102 = this.f184509a;
        if (r102 == null) goto L6;
        r102.setAdaptedEnabled(r101.booleanValue());
        return;
    }
}
