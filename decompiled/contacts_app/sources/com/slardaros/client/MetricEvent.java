package com.slardaros.client;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MetricEvent extends AgentEvent {
    public static final String CATEGORY_KEY = "category";
    public static final String EVENTNAME_KEY = "event_name";
    public static final String EXTRA_KEY = "extra";
    public static final String LOGTYPE_KEY = "log_type";
    public static final String METRICS_KEY = "metrics";
    public static final String TIMESTAMP_KEY = "client_timestamp";
    public String event;
    public JSONObject jsonParams;

    public MetricEvent(String r1, JSONObject r2) {
        this.event = r1;
        this.jsonParams = r2;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String r1) {
        this.event = r1;
    }

    public JSONObject getJsonParams() {
        return this.jsonParams;
    }

    public void setJsonParams(JSONObject r1) {
        this.jsonParams = r1;
    }

    public String toString() {
        return "MetricEvent{event = '" + this.event + "', jsonParams = '" + this.jsonParams + "'}";
    }
}
