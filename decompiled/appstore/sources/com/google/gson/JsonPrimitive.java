package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonPrimitive extends JsonElement {
    private final Object value;

    public JsonPrimitive(Boolean r10) {
        this.value = C$Gson$Preconditions.checkNotNull(r10);
    }

    private static boolean isIntegral(JsonPrimitive r10) {
        Object r11 = r10.value;
        if ((r11 instanceof Number) == false) goto L16;
        Number r12 = (Number) r11;
        if ((r12 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r12 instanceof Long) == true) goto L14;
        if ((r12 instanceof Integer) == true) goto L14;
        if ((r12 instanceof Short) == true) goto L14;
        if ((r12 instanceof Byte) == true) goto L14;
        return false;
    L16:
        return false;
    }

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L41:
        return false;
    L8:
        if (JsonPrimitive.class != r10.getClass()) goto L41;
        JsonPrimitive r11 = (JsonPrimitive) r10;
        if (this.value != null) goto L18;
        if (r11.value != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (isIntegral(this) == true) goto L20;
    L26:
        Object r12 = this.value;
        if ((r12 instanceof Number) == false) goto L40;
        if ((r11.value instanceof Number) == false) goto L40;
        double r13 = getAsNumber().doubleValue();
        double r14 = r11.getAsNumber().doubleValue();
        if (r13 != r14) goto L33;
        return true;
    L33:
        if (Double.isNaN(r13) == false) goto L38;
        if (Double.isNaN(r14) == false) goto L38;
        return true;
    L38:
        return false;
    L40:
        return r12.equals(r11.value);
    L20:
        if (isIntegral(r11) == false) goto L26;
        if (getAsNumber().longValue() != r11.getAsNumber().longValue()) goto L25;
        return true;
    L25:
        return false;
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object r10 = this.value;
        if ((r10 instanceof BigDecimal) == false) goto L6;
        return (BigDecimal) r10;
    L6:
        return new BigDecimal(this.value.toString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object r10 = this.value;
        if ((r10 instanceof BigInteger) == false) goto L6;
        return (BigInteger) r10;
    L6:
        return new BigInteger(this.value.toString());
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean() == false) goto L7;
        return ((Boolean) this.value).booleanValue();
    L7:
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber() == false) goto L6;
        return getAsNumber().byteValue();
    L6:
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber() == false) goto L6;
        return getAsNumber().doubleValue();
    L6:
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber() == false) goto L6;
        return getAsNumber().floatValue();
    L6:
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber() == false) goto L6;
        return getAsNumber().intValue();
    L6:
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber() == false) goto L6;
        return getAsNumber().longValue();
    L6:
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object r10 = this.value;
        if ((r10 instanceof String) == false) goto L6;
        return new LazilyParsedNumber((String) this.value);
    L6:
        return (Number) r10;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber() == false) goto L6;
        return getAsNumber().shortValue();
    L6:
        return Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (isNumber() == false) goto L7;
        return getAsNumber().toString();
    L7:
        if (isBoolean() == false) goto L11;
        return ((Boolean) this.value).toString();
    L11:
        return (String) this.value;
    }

    public int hashCode() {
        if (this.value != null) goto L7;
        return 31;
    L7:
        if (isIntegral(this) == false) goto L11;
        long r10 = getAsNumber().longValue();
    L10:
        return (int) ((r10 >>> 32) ^ r10);
    L11:
        Object r11 = this.value;
        if ((r11 instanceof Number) == false) goto L15;
        r10 = Double.doubleToLongBits(getAsNumber().doubleValue());
        goto L10
    L15:
        return r11.hashCode();
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonPrimitive(Number r10) {
        this.value = C$Gson$Preconditions.checkNotNull(r10);
    }

    public JsonPrimitive(String r10) {
        this.value = C$Gson$Preconditions.checkNotNull(r10);
    }

    public JsonPrimitive(Character r10) {
        this.value = ((Character) C$Gson$Preconditions.checkNotNull(r10)).toString();
    }
}
