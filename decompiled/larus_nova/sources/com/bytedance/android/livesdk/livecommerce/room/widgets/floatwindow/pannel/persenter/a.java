package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECFloatWindowCarouselPresenter f152147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScrollingLinearLayoutManager f152148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f152149c;

    public a(ECFloatWindowCarouselPresenter r100, ScrollingLinearLayoutManager r101, RecyclerView r102) {
        this.f152147a = r100;
        this.f152148b = r101;
        this.f152149c = r102;
    }

    public final void a() {
        ECFloatWindowCarouselPresenter r100 = this.f152147a;
        if (r100.f152143o == true) goto L6;
        return;
    L6:
        if (r100.E().getItemCount() <= 1) goto L27;
        View r101 = ((PagerSnapHelper) this.f152147a.f152135g.getValue()).findSnapView(this.f152148b);
        if (r101 == null) goto L28;
        int r102 = this.f152148b.getPosition(r101);
        if (r102 == (-1)) goto L29;
        int r103 = (r102 + 1) % this.f152147a.E().getItemCount();
        int r104 = this.f152147a.E().getItemCount();
        if (r103 < 0) goto L19;
        if (r104 <= r103) goto L19;
        this.f152149c.smoothScrollToPosition(r103);
    L19:
        ECFloatWindowCarouselPresenter r105 = this.f152147a;
        a r106 = r105.f152140l;
        if (r105.f152143o == false) goto L24;
        if (r106 == null) goto L25;
        r105.f152142n.postDelayed(r106, r105.f152141m);
        return;
    L25:
        return;
    L24:
        return;
    L29:
        return;
    L28:
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
