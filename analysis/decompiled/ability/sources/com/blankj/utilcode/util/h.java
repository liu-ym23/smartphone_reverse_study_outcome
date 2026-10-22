package com.blankj.utilcode.util;

import java.lang.Thread;

/* loaded from: classes2.dex */
public final class h implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        System.out.println(th);
    }
}
