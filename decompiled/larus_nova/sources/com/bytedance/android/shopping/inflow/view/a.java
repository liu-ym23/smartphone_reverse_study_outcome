package com.bytedance.android.shopping.inflow.view;

import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InFlowActivityLayout f176367a;

    public a(InFlowActivityLayout r100) {
        this.f176367a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if ((this.f176367a.getContext() instanceof LifecycleOwner) == false) goto L12;
        Object r100 = this.f176367a.getContext();     // Catch: Throwable -> L9
        if (r100 == null) goto L8;
        ((LifecycleOwner) r100).getLifecycle().addObserver(this.f176367a);     // Catch: Throwable -> L9
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L9
    }
}
