package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f137278a;

    public c(a.b r100) {
        this.f137278a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r100 = this.f137278a.f137255e;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.requestFocus();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
