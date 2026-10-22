package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class BaseEvent {
    public int errorType;
    public Object message;
    public int refreshType;
    public int what;

    public BaseEvent() {
    }

    public boolean isFirstRefresh() {
        if (this.refreshType != 3) goto L5;
        return true;
    L5:
        return false;
    }
}
