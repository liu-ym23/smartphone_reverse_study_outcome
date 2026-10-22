package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class IgnoreAppEvent extends BaseEvent {
    private boolean isDateChange;

    public IgnoreAppEvent(boolean r10) {
        this.isDateChange = r10;
    }

    public boolean isDateChange() {
        return this.isDateChange;
    }
}
