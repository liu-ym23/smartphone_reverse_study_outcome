package com.google.gson.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String r1) {
        this.value = r1;
    }

    @Override // java.lang.Number
    public int intValue() {
        return Integer.parseInt(this.value);
    L4:
        return (int) Long.parseLong(this.value);
    L8:
        return new BigDecimal(this.value).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return Long.parseLong(this.value);
    L5:
        return new BigDecimal(this.value).longValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public String toString() {
        return this.value;
    }

    private Object writeReplace() {
        return new BigDecimal(this.value);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LazilyParsedNumber.class) == false) goto L14;
        LazilyParsedNumber r6 = (LazilyParsedNumber) ZeusTransformUtils.preCheckCast(r5, LazilyParsedNumber.class, "com.obric.aiagent.plugin");
        String r4 = this.value;
        String r7 = r6.value;
        if (r4 != r7) goto L10;
        return true;
    L10:
        if (r4.equals(r7) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }
}
