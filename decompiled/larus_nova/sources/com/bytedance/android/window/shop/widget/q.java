package com.bytedance.android.window.shop.widget;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f190105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f190106b;

    public q(LifecycleOwner r100, r r101) {
        this.f190105a = r100;
        this.f190106b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = WindowPopupWindowManager.f190064a;     // Catch: Throwable -> L7
        ConstraintLayout r101 = this.f190106b.f190107a.f189894g;     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlArea");     // Catch: Throwable -> L7
    L5:
        WindowPopupWindowManager.a(r101, ToolBarView.R5(this.f190106b.f190107a), this.f190105a, WindowPopupWindowManager.PopupPosition.ABOVE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
