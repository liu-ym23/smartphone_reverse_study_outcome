package com.bytedance.apm.logging;

/* JADX INFO: loaded from: classes2.dex */
public interface ILogger {
    void d(String r1, String... r2);

    void e(String r1, String... r2);

    void i(String r1, String... r2);

    void printErrStackTrace(String r1, Throwable r2, String... r3);

    void v(String r1, String... r2);

    void w(String r1, String... r2);
}
