package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList();
    }

    public void add(Boolean r10) {
        List<JsonElement> r11 = this.elements;
        if (r10 != null) goto L5;
        JsonElement r12 = JsonNull.INSTANCE;
    L6:
        r11.add(r12);
        return;
    L5:
        r12 = new JsonPrimitive(r10);
        goto L6
    }

    public void addAll(JsonArray r10) {
        this.elements.addAll(r10.elements);
    }

    public boolean contains(JsonElement r10) {
        return this.elements.contains(r10);
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof JsonArray) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonArray) r10).elements.equals(this.elements) == false) goto L8;
        goto L8
    }

    public JsonElement get(int r10) {
        return this.elements.get(r10);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsBigDecimal();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsBigInteger();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsBoolean();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsByte();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsCharacter();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsDouble();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsFloat();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsInt();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsLong();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsNumber();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsShort();
    L7:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (this.elements.size() != 1) goto L7;
        return this.elements.get(0).getAsString();
    L7:
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(JsonElement r10) {
        return this.elements.remove(r10);
    }

    public JsonElement set(int r10, JsonElement r11) {
        return this.elements.set(r10, r11);
    }

    public int size() {
        return this.elements.size();
    }

    public void add(Character r10) {
        List<JsonElement> r11 = this.elements;
        if (r10 != null) goto L5;
        JsonElement r12 = JsonNull.INSTANCE;
    L6:
        r11.add(r12);
        return;
    L5:
        r12 = new JsonPrimitive(r10);
        goto L6
    }

    @Override // com.google.gson.JsonElement
    public JsonArray deepCopy() {
        if (this.elements.isEmpty() == true) goto L10;
        JsonArray r10 = new JsonArray(this.elements.size());
        Iterator<JsonElement> r11 = this.elements.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(r11.next().deepCopy());
        goto L6
    L8:
        return r10;
    L10:
        return new JsonArray();
    }

    public JsonElement remove(int r10) {
        return this.elements.remove(r10);
    }

    public JsonArray(int r10) {
        this.elements = new ArrayList(r10);
    }

    public void add(Number r10) {
        List<JsonElement> r11 = this.elements;
        if (r10 != null) goto L5;
        JsonElement r12 = JsonNull.INSTANCE;
    L6:
        r11.add(r12);
        return;
    L5:
        r12 = new JsonPrimitive(r10);
        goto L6
    }

    public void add(String r10) {
        List<JsonElement> r11 = this.elements;
        if (r10 != null) goto L5;
        JsonElement r12 = JsonNull.INSTANCE;
    L6:
        r11.add(r12);
        return;
    L5:
        r12 = new JsonPrimitive(r10);
        goto L6
    }

    public void add(JsonElement r10) {
        if (r10 != null) goto L4;
        r10 = JsonNull.INSTANCE;
    L4:
        this.elements.add(r10);
    }
}
