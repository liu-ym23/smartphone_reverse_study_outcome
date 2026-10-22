package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class AccountAppsEvent extends BaseEvent {
    private boolean isDataChange;

    public AccountAppsEvent(Boolean r10) {
        this.isDataChange = r10.booleanValue();
    }

    public boolean isDataChange() {
        return this.isDataChange;
    }
}
