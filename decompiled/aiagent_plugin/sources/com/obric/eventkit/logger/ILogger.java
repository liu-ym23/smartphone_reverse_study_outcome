package com.obric.eventkit.logger;

/* JADX INFO: loaded from: classes4.dex */
public interface ILogger {
    void d(String r1, String r2);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    void i(String r1, String r2);

    boolean isDebug();

    void v(String r1, String r2);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void w(String r1, Throwable r2);
}
