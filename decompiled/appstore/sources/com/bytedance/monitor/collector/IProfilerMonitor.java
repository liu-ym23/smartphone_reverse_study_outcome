package com.bytedance.monitor.collector;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IProfilerMonitor {
    String dumpStack(long r10, long r11);

    void enableEvilMethodCollect(boolean r10);

    void init(Context r10, long r11);

    void start();

    void stop();
}
