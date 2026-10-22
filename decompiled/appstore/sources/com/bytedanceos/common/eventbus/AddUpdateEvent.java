package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class AddUpdateEvent extends BaseEvent {
    public static final int EVENT_ADD_APP = 1;
    public static final int EVENT_ADD_APPS = 2;
    public static final int EVENT_DEFAULT = 0;
    private int mEvent;
    private String mPackageName;

    public AddUpdateEvent() {
        this.mEvent = 2;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public AddUpdateEvent(String r10) {
        this.mEvent = 1;
        this.mPackageName = r10;
    }
}
