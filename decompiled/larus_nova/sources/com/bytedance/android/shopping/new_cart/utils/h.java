package com.bytedance.android.shopping.new_cart.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f179366a;

    public h(RecyclerView r100) {
        this.f179366a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.Adapter r100 = this.f179366a.getAdapter();     // Catch: Throwable -> L14
        if (r100 == null) goto L17;
        Integer r101 = Integer.valueOf(r100.getItemCount());     // Catch: Throwable -> L14
        if (r101.intValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L21;
        r101.intValue();     // Catch: Throwable -> L14
        this.f179366a.scrollToPosition(0);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L7:
        r102 = false;
        goto L8
    L17:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
