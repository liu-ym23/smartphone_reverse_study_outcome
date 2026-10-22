package com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f104584a;

    public b(Function0 r100) {
        this.f104584a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f104584a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
