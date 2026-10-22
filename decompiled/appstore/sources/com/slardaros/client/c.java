package com.slardaros.client;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f17838c;

    public c(String r10, JSONObject r11) {
        this.f17837b = r10;
        this.f17838c = r11;
    }

    public String a() {
        return this.f17837b;
    }

    public JSONObject b() {
        return this.f17838c;
    }

    public String toString() {
        return "MetricEvent{event = '" + this.f17837b + "', jsonParams = '" + this.f17838c + "'}";
    }
}
