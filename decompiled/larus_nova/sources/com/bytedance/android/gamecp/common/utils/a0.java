package com.bytedance.android.gamecp.common.utils;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f57197a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f57197a.requestFocus();     // Catch: Throwable -> L6
        InputMethodManager r100 = (InputMethodManager) y0.getContext().getSystemService("input_method");     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.showSoftInput(this.f57197a, 1);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a0(EditText r100) {
        this.f57197a = r100;
    }
}
