package com.bytedance.android.livesdk.livecommerce.iron.category;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CategoryRecyclerView f148580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f148581b;

    public b(CategoryRecyclerView r100, int r101) {
        this.f148580a = r100;
        this.f148581b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CategoryListAdapter r100 = this.f148580a.f148571a;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        int r101 = this.f148581b;     // Catch: Throwable -> L8
        if (r100.f148561e == r101) goto L15;
        r100.f148561e = r101;     // Catch: Throwable -> L8
        r100.notifyItemRangeChanged(0, r100.getItemCount(), new CategoryListAdapter.a(r101));     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
