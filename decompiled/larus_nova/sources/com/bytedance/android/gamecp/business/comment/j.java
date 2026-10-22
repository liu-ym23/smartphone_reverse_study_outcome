package com.bytedance.android.gamecp.business.comment;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplyInputView f52224a;

    public j(ReplyInputView r100) {
        this.f52224a = r100;
    }

    public final void a() {
        EditText r100 = this.f52224a.f51875a;
        if (r100 == null) goto L5;
        r100.setFocusable(true);
    L5:
        EditText r101 = this.f52224a.f51875a;
        if (r101 == null) goto L8;
        r101.requestFocus();
    L8:
        Object r102 = this.f52224a.getContext().getSystemService("input_method");
        if ((r102 instanceof InputMethodManager) == true) goto L11;
        r102 = null;
    L11:
        InputMethodManager r103 = (InputMethodManager) r102;
        if (r103 == null) goto L15;
        r103.showSoftInput(this.f52224a.f51875a, 1);
        return;
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
