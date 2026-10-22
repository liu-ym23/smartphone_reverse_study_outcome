package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members;

    public JsonObject() {
        this.members = new LinkedTreeMap();
    }

    public void add(String r10, JsonElement r11) {
        LinkedTreeMap<String, JsonElement> r12 = this.members;
        if (r11 != null) goto L5;
        r11 = JsonNull.INSTANCE;
    L5:
        r12.put(r10, r11);
    }

    public void addProperty(String r10, String r11) {
        if (r11 != null) goto L4;
        JsonElement r12 = JsonNull.INSTANCE;
    L5:
        add(r10, r12);
        return;
    L4:
        r12 = new JsonPrimitive(r11);
        goto L5
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof JsonObject) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonObject) r10).members.equals(this.members) == false) goto L8;
        goto L8
    }

    public JsonElement get(String r10) {
        return this.members.get(r10);
    }

    public JsonArray getAsJsonArray(String r10) {
        return (JsonArray) this.members.get(r10);
    }

    public JsonObject getAsJsonObject(String r10) {
        return (JsonObject) this.members.get(r10);
    }

    public JsonPrimitive getAsJsonPrimitive(String r10) {
        return (JsonPrimitive) this.members.get(r10);
    }

    public boolean has(String r10) {
        return this.members.containsKey(r10);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String r10) {
        return this.members.remove(r10);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String r10, Number r11) {
        if (r11 != null) goto L4;
        JsonElement r12 = JsonNull.INSTANCE;
    L5:
        add(r10, r12);
        return;
    L4:
        r12 = new JsonPrimitive(r11);
        goto L5
    }

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject r10 = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> r11 = this.members.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, JsonElement> r12 = r11.next();
        r10.add(r12.getKey(), r12.getValue().deepCopy());
        goto L4
    L6:
        return r10;
    }

    public void addProperty(String r10, Boolean r11) {
        if (r11 != null) goto L4;
        JsonElement r12 = JsonNull.INSTANCE;
    L5:
        add(r10, r12);
        return;
    L4:
        r12 = new JsonPrimitive(r11);
        goto L5
    }

    public void addProperty(String r10, Character r11) {
        if (r11 != null) goto L4;
        JsonElement r12 = JsonNull.INSTANCE;
    L5:
        add(r10, r12);
        return;
    L4:
        r12 = new JsonPrimitive(r11);
        goto L5
    }
}
