package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends RecyclerView.OnFlingListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f4431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f4432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.OnScrollListener f4433c;

    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f4435b;

        public a(n r10) {
            this.f4435b = r10;
            this.f4434a = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            super.onScrollStateChanged(r10, r11);
            if (r11 == 0) goto L5;
            return;
        L5:
            if (this.f4434a == false) goto L9;
            this.f4434a = false;
            this.f4435b.k();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView r10, int r11, int r12) {
            if (r11 != 0) goto L4;
            if (r12 != 0) goto L4;
            return;
        L4:
            this.f4434a = true;
        }
    }

    public n() {
        this.f4433c = new a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean a(int r10, int r11) {
        RecyclerView.LayoutManager r12 = this.f4431a.getLayoutManager();
        if (r12 != null) goto L6;
        return false;
    L6:
        if (this.f4431a.getAdapter() != null) goto L8;
        return false;
    L8:
        int r13 = this.f4431a.getMinFlingVelocity();
        if (Math.abs(r11) > r13) goto L13;
        if (Math.abs(r10) > r13) goto L13;
        return false;
    L13:
        if (j(r12, r10, r11) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public void b(RecyclerView r10) {
        RecyclerView r11 = this.f4431a;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        f();
    L7:
        this.f4431a = r10;
        if (r10 == null) goto L11;
        i();
        this.f4432b = new Scroller(this.f4431a.getContext(), new DecelerateInterpolator());
        k();
        return;
    }

    public abstract int[] c(RecyclerView.LayoutManager r10, View r11);

    public int[] d(int r10, int r11) {
        this.f4432b.fling(0, 0, r10, r11, Integer.MIN_VALUE, Channel.UNLIMITED, Integer.MIN_VALUE, Channel.UNLIMITED);
        return new int[]{this.f4432b.getFinalX(), this.f4432b.getFinalY()};
    }

    public abstract RecyclerView.SmoothScroller e(RecyclerView.LayoutManager r10);

    public final void f() {
        this.f4431a.removeOnScrollListener(this.f4433c);
        this.f4431a.setOnFlingListener(null);
    }

    public abstract View g(RecyclerView.LayoutManager r10);

    public abstract int h(RecyclerView.LayoutManager r10, int r11, int r12);

    public final void i() {
        if (this.f4431a.getOnFlingListener() != null) goto L7;
        this.f4431a.addOnScrollListener(this.f4433c);
        this.f4431a.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public final boolean j(RecyclerView.LayoutManager r10, int r11, int r12) {
        if ((r10 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return false;
    L5:
        RecyclerView.SmoothScroller r13 = e(r10);
        if (r13 != null) goto L8;
        return false;
    L8:
        int r14 = h(r10, r11, r12);
        if (r14 != (-1)) goto L11;
        return false;
    L11:
        r13.setTargetPosition(r14);
        r10.startSmoothScroll(r13);
        return true;
    }

    public void k() {
        RecyclerView r10 = this.f4431a;
        if (r10 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r11 = r10.getLayoutManager();
        if (r11 != null) goto L8;
        return;
    L8:
        View r12 = g(r11);
        if (r12 != null) goto L11;
        return;
    L11:
        int[] r13 = c(r11, r12);
        int r14 = r13[0];
        if (r14 == 0) goto L14;
    L15:
        this.f4431a.smoothScrollBy(r14, r13[1]);
        return;
    L14:
        if (r13[1] != 0) goto L15;
    }
}
