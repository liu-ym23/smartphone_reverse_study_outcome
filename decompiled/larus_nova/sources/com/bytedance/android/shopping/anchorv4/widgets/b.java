package com.bytedance.android.shopping.anchorv4.widgets;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpNestedScrollView f170179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f170180b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f170181a;

        public a(b r100) {
            this.f170181a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f170181a;     // Catch: Throwable -> L4
            r100.f170179a.e(r100.f170180b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(PdpNestedScrollView r100, BasePdpRecyclerView r101) {
        this.f170179a = r100;
        this.f170180b = r101;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (this.f170180b.getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f170179a.g() == true) goto L8;
        return;
    L8:
        if (this.f170179a.canScrollVertically(-1) == true) goto L10;
        return;
    L10:
        if (this.f170179a.h() == false) goto L13;
        int r109 = this.f170179a.getScrollY();
        this.f170179a.scrollBy(0, -r109);
        this.f170180b.startNestedScroll(2);
        this.f170180b.scrollBy(0, r109);
        this.f170180b.stopNestedScroll();
        return;
    L13:
        if (this.f170180b.canScrollVertically(1) == false) goto L19;
        this.f170179a.post(new a(this));
        return;
    }
}
