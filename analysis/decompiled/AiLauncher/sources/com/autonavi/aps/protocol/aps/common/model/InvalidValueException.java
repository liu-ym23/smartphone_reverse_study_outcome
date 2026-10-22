package com.autonavi.aps.protocol.aps.common.model;

/* loaded from: classes.dex */
public class InvalidValueException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private String f18533a;

    /* renamed from: b, reason: collision with root package name */
    private Object f18534b;

    public InvalidValueException(String str, Object obj) {
        super("Invalid value set for '" + str + "', value is '" + obj + "'.");
        this.f18533a = str;
        this.f18534b = obj;
    }

    public String getField() {
        return this.f18533a;
    }

    public Object getValue() {
        return this.f18534b;
    }

    public void setField(String str) {
        this.f18533a = str;
    }

    public void setValue(Object obj) {
        this.f18534b = obj;
    }
}
