package com.bytedance.platform.thread;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformThreadPool$RejectedCallback {
    void rejectedExecution(Runnable r10, ThreadPoolExecutor r11);
}
