package com.tmall.wireless.tangram.eventbus;

import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes4.dex */
public class Event {
    public ArrayMap args;
    public EventContext eventContext;
    public String sourceId;
    public String type;

    public Event() {
        this.args = new ArrayMap();
    }

    public void appendArg(String r10, String r11) {
        ArrayMap r12 = this.args;
        if (r12 == null) goto L6;
        r12.put(r10, r11);
        return;
    }

    public String toString() {
        return "Event{args=" + this.args + ", sourceId='" + this.sourceId + "', type=" + this.type + '}';
    }
}
