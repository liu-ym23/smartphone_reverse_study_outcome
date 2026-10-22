package com.bytedance.android.livesdkapi.eventbus;

/* JADX INFO: loaded from: classes12.dex */
public class DoFollowEvent {
    public boolean mDoFollow;
    public String mUserId;

    public DoFollowEvent(String r100) {
        this.mUserId = r100;
    }

    public DoFollowEvent(String r100, boolean r101) {
        this.mUserId = r100;
        this.mDoFollow = r101;
    }
}
