package com.bytedance.android.live.core.paging.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f65080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f65081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f65082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f65083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PagingAdapter.f f65084e;

    @Override // java.lang.Runnable
    public final void run() {
        ((RecyclerView.AdapterDataObserver) ListProtector.get(PagingAdapter.f.b(this.f65084e), this.f65080a)).onItemRangeChanged(this.f65081b, this.f65082c, this.f65083d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(PagingAdapter.f r100, int r101, int r102, int r103) {
        this.f65084e = r100;
        this.f65080a = r101;
        this.f65081b = r102;
        this.f65082c = r103;
        this.f65083d = null;
    }
}
