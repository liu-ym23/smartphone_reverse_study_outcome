package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface o<T> {
    void a(Map<String, String> r100);

    void c(String r100, String r101);

    Map<String, String> getMap();

    void putAll(Map<String, String> r100);

    void remove(String r100);

    void setData(T r100);

    void u(Map<String, String> r100, T r101);
}
