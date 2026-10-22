package com.byted.cast.proxy;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface IMonitor {
    void onEvent(String r100, Event r101);

    void onEvent(String r100, Map<String, String> r101);

    void onException(String r100, Exception r101);
}
