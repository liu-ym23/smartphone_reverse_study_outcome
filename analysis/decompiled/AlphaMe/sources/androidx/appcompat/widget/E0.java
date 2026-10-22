package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;

/* loaded from: classes.dex */
public final class E0 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G0 f2814a;

    public E0(G0 g02) {
        this.f2814a = g02;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i4, int i5, int i6) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i4) {
        if (i4 == 1) {
            G0 g02 = this.f2814a;
            if (g02.f2846z.getInputMethodMode() == 2 || g02.f2846z.getContentView() == null) {
                return;
            }
            Handler handler = g02.f2842v;
            RunnableC0239z0 runnableC0239z0 = g02.f2838r;
            handler.removeCallbacks(runnableC0239z0);
            runnableC0239z0.run();
        }
    }
}
