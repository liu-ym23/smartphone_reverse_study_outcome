package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class w1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f136004a;

    public w1(x1 r100) {
        this.f136004a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f136004a.f136017a.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
