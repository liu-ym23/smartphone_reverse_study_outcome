package com.bytedance.android.gamecp.business.gamedetail.page.root.effect;

import com.bytedance.android.gamecp.business.gamedetail.view.NestedParentRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f55502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NestedParentRecyclerView f55503b;

    public a(int r100, NestedParentRecyclerView r101) {
        this.f55502a = r100;
        this.f55503b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f55503b.smoothScrollToPosition(this.f55502a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
