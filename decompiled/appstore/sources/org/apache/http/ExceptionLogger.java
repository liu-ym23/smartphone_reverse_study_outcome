package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = null;
    public static final ExceptionLogger STD_ERR = null;

    static {
        NO_OP = new AnonymousClass1();
        STD_ERR = new AnonymousClass2();
    }

    void log(Exception r10);
}
