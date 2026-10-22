package com.bytedance.android.shopping.utils.gallery;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f187116a;

    public d(e r100) {
        this.f187116a = r100;
    }

    public final void a() {
        this.f187116a.getClass();
        e r100 = this.f187116a;
        int r101 = r100.f187122f;
        int r102 = ((r100.f187123g + r101) * 0) + (r101 / 2);
        r100.f187121e += r102;
        RecyclerView r103 = r100.f187118b;
        if (r103 == null) goto L5;
        r103.scrollBy(r102, 0);
    L5:
        RecyclerView r104 = this.f187116a.f187118b;
        RecyclerView.Adapter r105 = null;
        if (r104 == null) goto L8;
        RecyclerView.Adapter r106 = r104.getAdapter();
    L10:
        if ((r106 instanceof BannerAdapter) == false) goto L13;
        r105 = r106;
    L13:
        BannerAdapter r107 = (BannerAdapter) r105;
        if (r107 == null) goto L16;
        r107.y2(this.f187116a.f187121e);
    L16:
        RecyclerView r108 = this.f187116a.f187118b;
        if (r108 == null) goto L19;
        r108.setVisibility(0);
    L19:
        View r109 = this.f187116a.f187119c;
        if (r109 == null) goto L23;
        r109.setVisibility(0);
        return;
    L23:
        return;
    L8:
        r106 = null;
        goto L10
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
