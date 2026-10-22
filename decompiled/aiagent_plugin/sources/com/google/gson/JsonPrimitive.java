package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonPrimitive extends JsonElement {
    private final Object value;

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public JsonPrimitive(Boolean r1) {
        this.value = Objects.requireNonNull(r1);
    }

    public JsonPrimitive(Number r1) {
        this.value = Objects.requireNonNull(r1);
    }

    public JsonPrimitive(String r1) {
        this.value = Objects.requireNonNull(r1);
    }

    public JsonPrimitive(Character r3) {
        this.value = ((Character) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), Character.class, "com.obric.aiagent.plugin")).toString();
    }

    public boolean isBoolean() {
        return ZeusTransformUtils.instanceOf(this.value, Boolean.class);
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean() == false) goto L7;
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.value, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L7:
        return Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return ZeusTransformUtils.instanceOf(this.value, Number.class);
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        if (ZeusTransformUtils.instanceOf(this.value, Number.class) == false) goto L7;
        return (Number) ZeusTransformUtils.preCheckCast(this.value, Number.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(this.value, String.class) == false) goto L11;
        return new LazilyParsedNumber((String) ZeusTransformUtils.preCheckCast(this.value, String.class, "com.obric.aiagent.plugin"));
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean isString() {
        return ZeusTransformUtils.instanceOf(this.value, String.class);
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (ZeusTransformUtils.instanceOf(this.value, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(this.value, String.class, "com.obric.aiagent.plugin");
    L7:
        if (isNumber() == false) goto L11;
        return getAsNumber().toString();
    L11:
        if (isBoolean() == false) goto L15;
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.value, Boolean.class, "com.obric.aiagent.plugin")).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber() == false) goto L6;
        return getAsNumber().doubleValue();
    L6:
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        if (ZeusTransformUtils.instanceOf(this.value, BigDecimal.class) == false) goto L6;
        return (BigDecimal) ZeusTransformUtils.preCheckCast(this.value, BigDecimal.class, "com.obric.aiagent.plugin");
    L6:
        return new BigDecimal(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        if (ZeusTransformUtils.instanceOf(this.value, BigInteger.class) == false) goto L6;
        return (BigInteger) ZeusTransformUtils.preCheckCast(this.value, BigInteger.class, "com.obric.aiagent.plugin");
    L6:
        return new BigInteger(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber() == false) goto L6;
        return getAsNumber().floatValue();
    L6:
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber() == false) goto L6;
        return getAsNumber().longValue();
    L6:
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber() == false) goto L6;
        return getAsNumber().shortValue();
    L6:
        return Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber() == false) goto L6;
        return getAsNumber().intValue();
    L6:
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber() == false) goto L6;
        return getAsNumber().byteValue();
    L6:
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        String r1 = getAsString();
        if (r1.isEmpty() == true) goto L7;
        return r1.charAt(0);
    L7:
        throw new UnsupportedOperationException("String value is empty");
    }

    public int hashCode() {
        if (this.value != null) goto L7;
        return 31;
    L7:
        if (isIntegral(this) == false) goto L11;
        long r2 = getAsNumber().longValue();
        return (int) ((r2 >>> 32) ^ r2);
    L11:
        if (ZeusTransformUtils.instanceOf(this.value, Number.class) == false) goto L15;
        long r3 = Double.doubleToLongBits(getAsNumber().doubleValue());
        return (int) ((r3 >>> 32) ^ r3);
    L15:
        return this.value.hashCode();
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L41:
        return false;
    L8:
        if (getClass() != r6.getClass()) goto L41;
        JsonPrimitive r7 = (JsonPrimitive) ZeusTransformUtils.preCheckCast(r6, JsonPrimitive.class, "com.obric.aiagent.plugin");
        if (this.value != null) goto L18;
        if (r7.value != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (isIntegral(this) == false) goto L27;
        if (isIntegral(r7) == false) goto L27;
        if (getAsNumber().longValue() != r7.getAsNumber().longValue()) goto L25;
        return true;
    L25:
        return false;
    L27:
        if (ZeusTransformUtils.instanceOf(this.value, Number.class) == false) goto L40;
        if (ZeusTransformUtils.instanceOf(r7.value, Number.class) == false) goto L40;
        double r2 = getAsNumber().doubleValue();
        double r5 = r7.getAsNumber().doubleValue();
        if (r2 != r5) goto L33;
        return true;
    L33:
        if (Double.isNaN(r2) == false) goto L38;
        if (Double.isNaN(r5) == false) goto L38;
        return true;
    L38:
        return false;
    L40:
        return this.value.equals(r7.value);
    }

    private static boolean isIntegral(JsonPrimitive r3) {
        if (ZeusTransformUtils.instanceOf(r3.value, Number.class) == false) goto L16;
        Number r4 = (Number) ZeusTransformUtils.preCheckCast(r3.value, Number.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, BigInteger.class) == false) goto L7;
    L14:
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == true) goto L14;
        return false;
    L16:
        return false;
    }
}
