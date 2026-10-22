package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CounterViewV2 f179318a;

    public i(CounterViewV2 r100) {
        this.f179318a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = this.f179318a.f179251q;     // Catch: Throwable -> L4
        r100.setFocusable(true);     // Catch: Throwable -> L4
        r100.requestFocus();     // Catch: Throwable -> L4
        r100.setImportantForAccessibility(1);     // Catch: Throwable -> L4
        r100.performAccessibilityAction(64, null);     // Catch: Throwable -> L4
        r100.sendAccessibilityEvent(32768);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
