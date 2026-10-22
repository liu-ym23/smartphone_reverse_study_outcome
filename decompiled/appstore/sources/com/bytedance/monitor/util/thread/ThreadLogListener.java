package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes.dex */
public interface ThreadLogListener {
    boolean isDebug();

    void onError(String r10, String r11);

    void onLog(String r10, String r11);
}
