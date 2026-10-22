package com.bytedance.android.livesdk.widget.board;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f161474a;

    public f(e r100) {
        this.f161474a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams r100 = this.f161474a.getLayoutParams();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.height = this.f161474a.getParentViewHeight();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
