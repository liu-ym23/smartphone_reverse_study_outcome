package com.bytedance.crash.tracker;

import com.bytedance.crash.runtime.DefaultWorkThread;

/* JADX INFO: compiled from: TrackerManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a() {
        DefaultWorkThread.post(new AnonymousClass1());
    }

    public static void b() {
        ActivityLifecycle.b();
    }
}
