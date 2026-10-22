package com.bytedance.applog.log;

import java.util.List;

/* JADX INFO: compiled from: IAppLogLogger.java */
/* JADX INFO: loaded from: classes.dex */
public interface f {
    void a(int r1, String r2, Throwable r3, Object... r4);

    void a(int r1, String r2, Object... r3);

    void a(int r1, List<String> r2, String r3, Throwable r4, Object... r5);

    void a(int r1, List<String> r2, String r3, Object... r4);

    void a(String r1);

    void a(String r1, Throwable r2, Object... r3);

    void a(List<String> r1, String r2, Throwable r3, Object... r4);

    void a(List<String> r1, String r2, Object... r3);

    void b(int r1, String r2, Object... r3);

    void b(int r1, List<String> r2, String r3, Object... r4);

    void b(String r1, Object... r2);

    void b(List<String> r1, String r2, Object... r3);

    void c(int r1, String r2, Object... r3);

    void c(int r1, List<String> r2, String r3, Object... r4);

    void c(String r1, Object... r2);

    void c(List<String> r1, String r2, Object... r3);

    void d(int r1, String r2, Object... r3);

    void d(int r1, List<String> r2, String r3, Object... r4);

    void d(String r1, Object... r2);

    void d(List<String> r1, String r2, Object... r3);

    void e(int r1, String r2, Object... r3);

    void e(String r1, Object... r2);

    void f(String r1, Object... r2);
}
