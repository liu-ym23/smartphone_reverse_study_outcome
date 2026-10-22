package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: stepos.support.v7.widget.c0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC1982c0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ItemAnimator f6605a;

    public RunnableC1982c0(RecyclerView.ItemAnimator itemAnimator) {
        this.f6605a = itemAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6605a.endAnimations();
    }
}
