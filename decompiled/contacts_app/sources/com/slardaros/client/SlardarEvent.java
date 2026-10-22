package com.slardaros.client;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SlardarEvent extends AgentEvent {
    public String event;
    public boolean isInstant;
    public JSONObject jsonParams;
    public long timestamp;

    public SlardarEvent(String r2, JSONObject r3) {
        this(r2, r3, false);
    }

    public SlardarEvent(String r7, JSONObject r8, boolean r9) {
        this(r7, r8, r9, System.currentTimeMillis());
    }

    public SlardarEvent(String r1, JSONObject r2, boolean r3, long r4) {
        this.event = r1;
        this.jsonParams = r2;
        this.isInstant = r3;
        this.timestamp = r4;
    }

    public void setEvent(String r1) {
        this.event = r1;
    }

    public void setJsonParams(JSONObject r1) {
        this.jsonParams = r1;
    }

    public String getEvent() {
        return this.event;
    }

    public JSONObject getJsonParams() {
        return this.jsonParams;
    }

    public boolean isInstant() {
        return this.isInstant;
    }

    public void setInstant(boolean r1) {
        this.isInstant = r1;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public String toString() {
        return "SlardarEvent{isInstant = '" + this.isInstant + "', event = '" + this.event + "', jsonParams = '" + this.jsonParams + "'}";
    }
}
