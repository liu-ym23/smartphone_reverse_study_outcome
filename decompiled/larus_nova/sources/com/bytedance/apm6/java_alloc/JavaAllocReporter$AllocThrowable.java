package com.bytedance.apm6.java_alloc;

/* JADX INFO: loaded from: classes14.dex */
final class JavaAllocReporter$AllocThrowable extends Throwable {
    private final StackTraceElement[] elements;
    private final String msg;

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    @Override // java.lang.Throwable
    public StackTraceElement[] getStackTrace() {
        return this.elements;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.msg;
    }

    public JavaAllocReporter$AllocThrowable(String r100, StackTraceElement[] r101) {
        this.msg = r100;
        this.elements = r101;
    }
}
