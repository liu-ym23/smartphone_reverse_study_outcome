package com.bytedance.apm6.util.log;

/* JADX INFO: loaded from: classes.dex */
public interface ILogger {
    void d(String r10, String r11);

    void e(String r10, String r11);

    void e(String r10, String r11, Throwable r12);

    void i(String r10, String r11);

    void v(String r10, String r11);

    void w(String r10, String r11);

    void w(String r10, String r11, Throwable r12);

    void wtf(String r10, String r11);

    void wtf(String r10, String r11, Throwable r12);
}
