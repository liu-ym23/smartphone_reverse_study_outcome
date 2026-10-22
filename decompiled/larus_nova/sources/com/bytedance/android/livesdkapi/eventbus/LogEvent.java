package com.bytedance.android.livesdkapi.eventbus;

/* JADX INFO: loaded from: classes12.dex */
public class LogEvent {
    public String event;
    public String status;

    public LogEvent(String r100) {
        this(r100, null);
    }

    public LogEvent(String r100, String r101) {
        this.event = r100;
        this.status = r101;
    }
}
