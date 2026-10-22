package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.arch.FoldAdaptedFrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class w<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FoldAdaptedFrameLayout f184760a;

    public w(FoldAdaptedFrameLayout r100) {
        this.f184760a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L8;
        FoldAdaptedFrameLayout r101 = this.f184760a;
        if (r101 == null) goto L9;
        r101.setBackgroundColor(0);
        return;
    L9:
        return;
    }
}
