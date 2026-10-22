package com.bytedance.android.livesdkapi.broadcastgame;

/* JADX INFO: loaded from: classes12.dex */
public class NotificationConfig {
    private boolean mEnable;
    private String mFilterAction;

    public String getFilterAction() {
        return this.mFilterAction;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public NotificationConfig(boolean r100, String r101) {
        this.mEnable = r100;
        this.mFilterAction = r101;
    }
}
