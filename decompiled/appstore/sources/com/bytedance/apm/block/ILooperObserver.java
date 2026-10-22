package com.bytedance.apm.block;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public interface ILooperObserver {
    void messageDispatchStarting(String r10);

    void messageDispatched(String r10, Message r11);
}
