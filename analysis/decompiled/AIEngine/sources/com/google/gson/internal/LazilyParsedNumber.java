package com.google.gson.internal;

import androidx.datastore.preferences.protobuf.b1;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f5448a;

    public LazilyParsedNumber(String str) {
        this.f5448a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return b1.R(this.f5448a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f5448a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            return this.f5448a.equals(((LazilyParsedNumber) obj).f5448a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f5448a);
    }

    public final int hashCode() {
        return this.f5448a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f5448a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return b1.R(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f5448a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return b1.R(str).longValue();
        }
    }

    public final String toString() {
        return this.f5448a;
    }
}
