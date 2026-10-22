package com.bytedance.apm6.service.d;

/* JADX INFO: compiled from: ActivityLifecycleService.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    String getTopActivityClassName();

    boolean isForeground();

    void register(c r1);

    void unregister(c r1);
}
