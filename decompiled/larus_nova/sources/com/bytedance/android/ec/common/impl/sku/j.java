package com.bytedance.android.ec.common.impl.sku;

import android.widget.ScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollView f43087a;

    public j(ScrollView r100) {
        this.f43087a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView r100 = this.f43087a;     // Catch: Throwable -> L4
        r100.scrollTo(0, r100.getBottom());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
