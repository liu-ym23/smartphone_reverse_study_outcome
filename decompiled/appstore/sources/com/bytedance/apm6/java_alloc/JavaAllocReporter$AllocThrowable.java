package com.bytedance.apm6.java_alloc;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class JavaAllocReporter$AllocThrowable extends Throwable {
    private final StackTraceElement[] elements;
    private final String msg;

    public JavaAllocReporter$AllocThrowable(String r10, StackTraceElement[] r11) {
        this.msg = r10;
        this.elements = r11;
    }

    @Override // java.lang.Throwable
    @NonNull
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    @Override // java.lang.Throwable
    @NonNull
    public StackTraceElement[] getStackTrace() {
        return this.elements;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.msg;
    }
}
