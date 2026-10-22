package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class OnSubEvent extends BaseEvent {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f9822id;
    private boolean isSub;

    public OnSubEvent() {
        this.f9822id = "";
        this.isSub = false;
    }

    public String getId() {
        return this.f9822id;
    }

    public boolean isSub() {
        return this.isSub;
    }

    public void setId(String r10) {
        this.f9822id = r10;
    }

    public void setSub(boolean r10) {
        this.isSub = r10;
    }
}
