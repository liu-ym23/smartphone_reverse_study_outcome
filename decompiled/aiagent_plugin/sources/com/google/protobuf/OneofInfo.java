package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class OneofInfo {
    private final java.lang.reflect.Field caseField;
    private final int id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int r1, java.lang.reflect.Field r2, java.lang.reflect.Field r3) {
        this.id = r1;
        this.caseField = r2;
        this.valueField = r3;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
