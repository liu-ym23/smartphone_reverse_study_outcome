package com.bytedance.services.apm.api;

import android.content.Context;

/* JADX INFO: compiled from: IWidget.java */
/* JADX INFO: loaded from: classes.dex */
public interface j {
    void init(Context r1);

    boolean isOnlyMainProcess();

    void notifyParams(m r1);

    void start();
}
