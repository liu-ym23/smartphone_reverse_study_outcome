package com.bytedance.android.shopping.new_cart.eventcenter.event;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f179056a;

    public d(RecyclerView r100) {
        this.f179056a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewExtensionsKt.d(this.f179056a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
