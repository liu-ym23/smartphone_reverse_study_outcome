package com.baidu.platform.comapi.util;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class JsonBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f33385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f33386b;

    private void b() {
        this.f33386b = true;
    }

    private void c() {
        this.f33386b = false;
    }

    private void a() {
        if (this.f33386b == false) goto L6;
        this.f33385a.append(",");
        return;
    }

    public JsonBuilder endArrayValue() {
        this.f33385a.append("]");
        b();
        return this;
    }

    public JsonBuilder endObject() {
        this.f33385a.append(com.alipay.sdk.m.u.i.f25855d);
        b();
        return this;
    }

    public String getJson() {
        return this.f33385a.toString();
    }

    public void reset() {
        this.f33385a.setLength(0);
        this.f33386b = false;
    }

    public JsonBuilder() {
        this.f33385a = new StringBuilder();
        this.f33386b = false;
    }

    public JsonBuilder arrayValue() {
        a();
        this.f33385a.append("[");
        c();
        return this;
    }

    public JsonBuilder object() {
        a();
        this.f33385a.append("{");
        c();
        return this;
    }

    public String toString() {
        return getJson();
    }

    public JsonBuilder key(String r100) {
        a();
        this.f33385a.append(JSONObject.quote(r100));
        this.f33385a.append(":");
        c();
        return this;
    }

    public JsonBuilder objectValue(String r100) {
        a();
        this.f33385a.append(r100);
        b();
        return this;
    }

    public JsonBuilder value(Object r100) {
        if ((r100 instanceof Number) == false) goto L29;
        Number r101 = (Number) r100;
        if ((r100 instanceof Byte) == false) goto L9;
        return value(r101.byteValue());
    L9:
        if ((r100 instanceof Short) == false) goto L13;
        return value(r101.shortValue());
    L13:
        if ((r100 instanceof Integer) == false) goto L17;
        return value(r101.intValue());
    L17:
        if ((r100 instanceof Long) == false) goto L21;
        return value(r101.longValue());
    L21:
        if ((r100 instanceof Float) == false) goto L25;
        return value(r101.floatValue());
    L25:
        if ((r100 instanceof Double) == false) goto L29;
        return value(r101.doubleValue());
    L29:
        return value(r100.toString());
    }

    public JsonBuilder valueDirect(String r100) {
        a();
        this.f33385a.append(r100);
        b();
        return this;
    }

    public JsonBuilder value(double r100) {
        a();
        this.f33385a.append(String.valueOf(r100));
        b();
        return this;
    }

    public JsonBuilder value(String r100) {
        a();
        this.f33385a.append(JSONObject.quote(r100));
        b();
        return this;
    }

    public JsonBuilder value(int r100) {
        a();
        this.f33385a.append(r100);
        b();
        return this;
    }

    public JsonBuilder value(long r100) {
        a();
        this.f33385a.append(r100);
        b();
        return this;
    }

    public JsonBuilder value(boolean r100) {
        a();
        this.f33385a.append(r100);
        b();
        return this;
    }

    public JsonBuilder putObjectValue(String r100, String r101) {
        if (r101 == null) goto L4;
        key(r100).objectValue(r101);
    L4:
        return this;
    }

    public JsonBuilder putStringValue(String r100, String r101) {
        if (r101 == null) goto L4;
        key(r100).value(r101);
    L4:
        return this;
    }
}
