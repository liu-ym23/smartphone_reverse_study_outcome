package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsWindowFloatPresenter f188488a;

    public a(AbsWindowFloatPresenter r100) {
        this.f188488a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual(this.f188488a.f188263h, Boolean.TRUE)) == false) goto L5;
        return;
    L5:
        this.f188488a.N();
    }
}
