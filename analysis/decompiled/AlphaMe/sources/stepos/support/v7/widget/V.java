package stepos.support.v7.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class V implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ItemAnimator f15049a;

    public V(RecyclerView.ItemAnimator itemAnimator) {
        this.f15049a = itemAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15049a.endAnimations();
    }
}
