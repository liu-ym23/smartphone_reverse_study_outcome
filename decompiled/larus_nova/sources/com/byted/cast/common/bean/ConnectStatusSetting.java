package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class ConnectStatusSetting {
    private boolean enableAddConnectStatus;
    private int sendMsgFailedCount;

    public ConnectStatusSetting() {
        this.enableAddConnectStatus = false;
        this.sendMsgFailedCount = 3;
    }

    public int getSendMsgFailedCount() {
        return this.sendMsgFailedCount;
    }

    public boolean isEnableAddConnectStatus() {
        return this.enableAddConnectStatus;
    }

    public void setEnableAddConnectStatus(boolean r100) {
        this.enableAddConnectStatus = r100;
    }

    public void setSendMsgFailedCount(int r100) {
        this.sendMsgFailedCount = r100;
    }
}
