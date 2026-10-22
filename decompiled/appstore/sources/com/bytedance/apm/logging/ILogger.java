package com.bytedance.apm.logging;

/* JADX INFO: loaded from: classes.dex */
public interface ILogger {
    void d(String r10, String... r11);

    void e(String r10, String... r11);

    void i(String r10, String... r11);

    void printErrStackTrace(String r10, Throwable r11, String... r12);

    void v(String r10, String... r11);

    void w(String r10, String... r11);
}
