package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String r10) {
        this.value = r10;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LazilyParsedNumber) == false) goto L14;
        String r11 = this.value;
        String r12 = ((LazilyParsedNumber) r10).value;
        if (r11 != r12) goto L10;
        return true;
    L10:
        if (r11.equals(r12) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
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

    public String toString() {
        return this.value;
    }
}
