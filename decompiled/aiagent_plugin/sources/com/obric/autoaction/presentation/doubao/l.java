package com.obric.autoaction.presentation.doubao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: GsonUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f24897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Gson f24899c;

    public /* synthetic */ l(Class r1, String r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "_type_widget_state_class_type";
    L5:
        this(r1, r2);
    }

    public l(Class<T> r3, String r4) {
        o.e(r3, "baseClass");
        o.e(r4, "typeFieldName");
        this.f24897a = r3;
        this.f24898b = r4;
        this.f24899c = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(CharSequence.class, Type.class, "com.obric.aiagent.plugin"), new g()).create();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r2, T r3) {
        o.e(r2, "out");
        if (r3 != null) goto L6;
        r2.nullValue();
        return;
    L6:
        JsonObject r0 = this.f24899c.toJsonTree(r3).getAsJsonObject();
        r0.addProperty(this.f24898b, r3.getClass().getName());
        Streams.write((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.aiagent.plugin"), r2);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r3) {
        o.e(r3, "in");
        JsonElement r4 = JsonParser.parseReader(r3);
        if (r4.isJsonObject() == true) goto L6;
        return null;
    L6:
        JsonElement r0 = r4.getAsJsonObject().get(this.f24898b);
        if (r0 == null) goto L10;
        String r1 = r0.getAsString();
        if (r1 == null) goto L10;
    L11:
        Class<T> r2 = ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin").asSubclass(this.f24897a);
        return (T) this.f24899c.fromJson(r4, r2);
    L10:
        r1 = this.f24897a.getName();
        goto L11
    }
}
