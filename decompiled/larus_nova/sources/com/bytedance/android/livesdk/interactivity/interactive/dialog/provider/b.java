package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CharSequence f137276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f137277b;

    public b(CharSequence r100, a.b r101) {
        this.f137276a = r100;
        this.f137277b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r100 = this.f137277b.f137255e;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.setText(this.f137276a);     // Catch: Throwable -> L7
    L5:
        this.f137277b.f502091b.c();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
