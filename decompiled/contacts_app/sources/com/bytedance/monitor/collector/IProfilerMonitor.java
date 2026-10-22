package com.bytedance.monitor.collector;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface IProfilerMonitor {
    String dumpStack(long r1, long r3);

    void enableEvilMethodCollect(boolean r1);

    void init(Context r1, long r2);

    void start();

    void stop();
}
