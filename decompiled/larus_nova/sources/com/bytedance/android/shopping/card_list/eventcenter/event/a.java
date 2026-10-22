package com.bytedance.android.shopping.card_list.eventcenter.event;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f171607a;

    public a(RecyclerView r100) {
        this.f171607a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewExtensionsKt.d(this.f171607a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
