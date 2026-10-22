package com.bytedance.android.shopping.slice.elements.shoprecommend;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f183340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f183341b;

    public b(a r100, int r101) {
        this.f183340a = r100;
        this.f183341b = r101;
    }

    public final void a() {
        if (this.f183340a.getChildCount() > 0) goto L5;
        return;
    L5:
        if (com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.f183340a), 0)).size() <= this.f183341b) goto L14;
        Object r100 = ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.f183340a), 0)), this.f183341b)), 0);
        if ((r100 instanceof ki3.a) == true) goto L9;
        r100 = null;
    L9:
        ki3.a r101 = (ki3.a) r100;
        if (r101 == null) goto L15;
        r101.scrollTo(r101.f503607k, 0);
        return;
    L15:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
