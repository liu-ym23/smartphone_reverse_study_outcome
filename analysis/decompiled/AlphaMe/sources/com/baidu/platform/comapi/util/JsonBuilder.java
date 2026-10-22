package com.baidu.platform.comapi.util;

import com.stepos.alphame.awareness.AwarenessDataItem;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonBuilder {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f9265a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private boolean f9266b = false;

    private void a() {
        if (this.f9266b) {
            this.f9265a.append(",");
        }
    }

    private void b() {
        this.f9266b = true;
    }

    private void c() {
        this.f9266b = false;
    }

    public JsonBuilder arrayValue() {
        a();
        this.f9265a.append("[");
        c();
        return this;
    }

    public JsonBuilder endArrayValue() {
        this.f9265a.append("]");
        b();
        return this;
    }

    public JsonBuilder endObject() {
        this.f9265a.append("}");
        b();
        return this;
    }

    public String getJson() {
        return this.f9265a.toString();
    }

    public JsonBuilder key(String str) {
        a();
        this.f9265a.append(JSONObject.quote(str));
        this.f9265a.append(AwarenessDataItem.USERID_SPLITTER);
        c();
        return this;
    }

    public JsonBuilder object() {
        a();
        this.f9265a.append("{");
        c();
        return this;
    }

    public JsonBuilder objectValue(String str) {
        a();
        this.f9265a.append(str);
        b();
        return this;
    }

    public JsonBuilder putObjectValue(String str, String str2) {
        if (str2 != null) {
            key(str).objectValue(str2);
        }
        return this;
    }

    public JsonBuilder putStringValue(String str, String str2) {
        if (str2 != null) {
            key(str).value(str2);
        }
        return this;
    }

    public void reset() {
        this.f9265a.setLength(0);
        this.f9266b = false;
    }

    public String toString() {
        return getJson();
    }

    public JsonBuilder value(boolean z4) {
        a();
        this.f9265a.append(z4);
        b();
        return this;
    }

    public JsonBuilder valueDirect(String str) {
        a();
        this.f9265a.append(str);
        b();
        return this;
    }

    public JsonBuilder value(int i4) {
        a();
        this.f9265a.append(i4);
        b();
        return this;
    }

    public JsonBuilder value(long j4) {
        a();
        this.f9265a.append(j4);
        b();
        return this;
    }

    public JsonBuilder value(double d4) {
        a();
        this.f9265a.append(String.valueOf(d4));
        b();
        return this;
    }

    public JsonBuilder value(String str) {
        a();
        this.f9265a.append(JSONObject.quote(str));
        b();
        return this;
    }

    public JsonBuilder value(Object obj) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (obj instanceof Byte) {
                return value((int) number.byteValue());
            }
            if (obj instanceof Short) {
                return value((int) number.shortValue());
            }
            if (obj instanceof Integer) {
                return value(number.intValue());
            }
            if (obj instanceof Long) {
                return value(number.longValue());
            }
            if (obj instanceof Float) {
                return value(number.floatValue());
            }
            if (obj instanceof Double) {
                return value(number.doubleValue());
            }
        }
        return value(obj.toString());
    }
}
