package com.bytedanceos.common.eventbus;

import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class CollectEvent extends BaseEvent {
    public static final int EVENT_ADD_COLLECTTION = 3;
    public static final int EVENT_DELETE_COLLECTTION = 4;
    public static final int EVENT_FETCH_DATA_FAILED = 2;
    public static final int EVENT_FETCH_DATA_SUCCESS = 1;
    private AppInfo mAppInfo;
    private int mEvent;

    public CollectEvent(int r10) {
        this(r10, null);
    }

    public AppInfo getAppInfo() {
        return this.mAppInfo;
    }

    public int getEventStatus() {
        return this.mEvent;
    }

    public CollectEvent(int r10, AppInfo r11) {
        this.mEvent = r10;
        this.mAppInfo = r11;
    }
}
