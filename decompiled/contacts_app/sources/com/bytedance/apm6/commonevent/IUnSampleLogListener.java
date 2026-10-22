package com.bytedance.apm6.commonevent;

import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.commonevent.model.CommonLog;

/* JADX INFO: loaded from: classes2.dex */
public interface IUnSampleLogListener {
    void onCommonEvent(CommonEvent r1);

    void onCommonLog(CommonLog r1);
}
