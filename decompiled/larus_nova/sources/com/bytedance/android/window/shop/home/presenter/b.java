package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsWindowFloatPresenter f188496a;

    public b(AbsWindowFloatPresenter r100) {
        this.f188496a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if ((!Intrinsics.areEqual(this.f188496a.f188263h, Boolean.TRUE)) == true) goto L7;
        this.f188496a.N();
        return;
    }
}
