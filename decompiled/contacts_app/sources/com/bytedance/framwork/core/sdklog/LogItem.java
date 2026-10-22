package com.bytedance.framwork.core.sdklog;

/* JADX INFO: loaded from: classes2.dex */
class LogItem {
    public long id;
    public int retryCount;
    public long retryTime;
    public long timestamp;
    public String type;
    public byte[] value;

    public LogItem() {
    }

    public LogItem(String r1, byte[] r2) {
        this.type = r1;
        this.value = r2;
    }
}
