package com.bytedance.android.shopping.jedi;

import android.view.View;
import com.bytedance.android.ec.core.jedi.PullUpLoadMoreHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadMoreRecyclerViewAdapter.LoadMoreViewHolder f176418a;

    public a(LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r100) {
        this.f176418a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f176418a.f176415c.f176411r;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r101.invoke();
    L5:
        PullUpLoadMoreHelper r102 = this.f176418a.f176413a;
        if (r102 == null) goto L10;
        if (r102 == null) goto L11;
        r102.f45098a = false;
        return;
    L11:
        return;
    }
}
