package com.google.zxing;

/* loaded from: classes2.dex */
public abstract class ReaderException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f21811a;

    /* renamed from: b, reason: collision with root package name */
    public static final StackTraceElement[] f21812b;

    static {
        f21811a = System.getProperty("surefire.test.class.path") != null;
        f21812b = new StackTraceElement[0];
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
