package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiRecyclerNestedScrollView f182286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f182287b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f182288a;

        public a(j r100) {
            this.f182288a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r100 = this.f182288a;     // Catch: Throwable -> L4
            MultiRecyclerNestedScrollView r101 = r100.f182286a;     // Catch: Throwable -> L4
            RecyclerView r102 = r100.f182287b;     // Catch: Throwable -> L4
            int r103 = MultiRecyclerNestedScrollView.f182245n;     // Catch: Throwable -> L4
            r101.j(r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public j(MultiRecyclerNestedScrollView r100, FixedRecyclerView r101) {
        this.f182286a = r100;
        this.f182287b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (this.f182287b.getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f182286a.h() == true) goto L8;
        return;
    L8:
        if (this.f182286a.canScrollVertically(-1) == true) goto L10;
        return;
    L10:
        if (this.f182286a.i() == false) goto L13;
        int r109 = this.f182286a.getScrollY();
        this.f182286a.scrollBy(0, -r109);
        this.f182287b.startNestedScroll(2);
        this.f182287b.scrollBy(0, r109);
        this.f182287b.stopNestedScroll();
        return;
    L13:
        if (this.f182287b.canScrollVertically(1) == false) goto L19;
        this.f182286a.post(new a(this));
        return;
    }
}
