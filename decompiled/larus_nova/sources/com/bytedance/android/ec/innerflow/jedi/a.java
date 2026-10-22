package com.bytedance.android.ec.innerflow.jedi;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadMoreRecyclerViewAdapter.LoadMoreViewHolder f47840a;

    public a(LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r100) {
        this.f47840a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f47840a.f47837a.f47835p;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.invoke();
    L5:
        this.f47840a.getClass();
    }
}
