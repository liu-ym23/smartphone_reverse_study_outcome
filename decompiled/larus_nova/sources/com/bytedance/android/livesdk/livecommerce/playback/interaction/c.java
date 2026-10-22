package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractionAutoRecycleView f149899a;

    public final void a() {
        RecyclerView.LayoutManager r100 = this.f149899a.getLayoutManager();
        if (r100 == null) goto L12;
        LinearLayoutManager r101 = (LinearLayoutManager) r100;
        this.f149899a.f149894c.setTargetPosition(r101.findLastVisibleItemPosition() + 1);
        int r102 = this.f149899a.f149894c.getTargetPosition();
        RecyclerView.Adapter r103 = this.f149899a.getAdapter();
        if (r103 == null) goto L7;
        int r104 = r103.getItemCount();
    L8:
        if (r102 >= r104) goto L13;
        r101.startSmoothScroll(this.f149899a.f149894c);
        InteractionAutoRecycleView.r(this.f149899a).postDelayed(this, 1500);
        return;
    L13:
        return;
    L7:
        r104 = 0;
        goto L8
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
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

    public c(InteractionAutoRecycleView r100) {
        this.f149899a = r100;
    }
}
