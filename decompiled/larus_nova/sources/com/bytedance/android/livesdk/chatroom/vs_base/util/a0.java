package com.bytedance.android.livesdk.chatroom.vs_base.util;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f118189a;

    public a0(Function0 r100) {
        this.f118189a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f118189a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
