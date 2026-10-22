package com.bytedance.services.apm.api;

import android.content.Context;
import i6.d;

/* JADX INFO: loaded from: classes.dex */
public interface IWidget {
    void destroy();

    String getTag();

    void init(Context r10);

    boolean isOnlyMainProcess();

    void notifyParams(d r10);

    void start();

    void stop();
}
