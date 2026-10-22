package com.bytedance.android.livesdk.log;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface g {
    void a(int r100);

    boolean addSendLogFilter(Object r100, com.bytedance.android.livesdk.log.filter.v r101);

    void b(String r100);

    com.bytedance.android.livesdk.log.filter.o c(Class r100);

    void d(String r100, Object... r101);

    void e(String r100, Map r101, Object... r102);

    void f(String r100, Map<String, String> r101, Object... r102);

    void g(String r100, boolean r101, boolean r102, Map<String, String> r103, Object... r104);

    Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter();

    void h(String r100, Map<String, String> r101, Object... r102);

    <T> void register(Class<? extends T> r100, com.bytedance.android.livesdk.log.filter.o<? extends T> r101);

    com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r100);

    void sendLog(String r100, Map<String, String> r101, Object... r102);
}
