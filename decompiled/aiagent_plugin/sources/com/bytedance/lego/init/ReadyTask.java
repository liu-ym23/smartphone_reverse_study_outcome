package com.bytedance.lego.init;

import com.bytedance.lego.init.model.InitTaskInfo;

/* JADX INFO: compiled from: InitTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ReadyTask extends Runnable {
    InitTaskInfo getInitTaskInfo();

    void setInitTaskInfo(InitTaskInfo r1);
}
