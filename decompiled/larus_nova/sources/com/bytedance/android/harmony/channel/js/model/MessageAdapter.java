package com.bytedance.android.harmony.channel.js.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import xw.b;
import xw.d;
import xw.e;
import xw.f;
import xw.g;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/harmony/channel/js/model/MessageAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lxw/d;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "runtime"}, k = 1, mv = {1, 4, 0})
public final class MessageAdapter implements JsonDeserializer<d>, JsonSerializer<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Type> f58193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Type, String> f58194b;

    public static final class a {
    }

    static {
    }

    public MessageAdapter() {
        HashMap<String, Type> r100 = new HashMap();
        this.f58193a = r100;
        HashMap<Type, String> r101 = new HashMap();
        this.f58194b = r101;
        r100.put("create_channel", b.class);
        r101.put(b.class, "create_channel");
        r100.put("write_channel", g.class);
        r101.put(g.class, "write_channel");
        r100.put("close_channel", xw.a.class);
        r101.put(xw.a.class, "close_channel");
        r100.put("register_service", f.class);
        r101.put(f.class, "register_service");
    }

    @Override // com.google.gson.JsonDeserializer
    public final d deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        JsonArray r103 = r100.getAsJsonObject().getAsJsonArray("operations");
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<JsonElement> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L17;
        JsonObject r106 = r105.next().getAsJsonObject();
        Iterator<T> r107 = r106.keySet().iterator();
    L7:
        if (r107.hasNext() == false) goto L11;
        Object r108 = r107.next();
        HashMap<String, Type> r109 = this.f58193a;
        if (r109.containsKey((String) r108) == false) goto L7;
    L12:
        String r110 = (String) r108;
        if (r110 == null) goto L16;
        r104.add((e) r102.deserialize(r106.getAsJsonObject(r110), this.f58193a.get(r110)));
        goto L4
    L16:
        throw new IllegalArgumentException("object does not match any operation types");
    L11:
        r108 = null;
        goto L12
    L17:
        d r111 = new d();
        r111.b(r104);
        return r111;
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(d r100, Type r101, JsonSerializationContext r102) {
        JsonArray r103 = new JsonArray();
        Iterator<T> r104 = r100.a().iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        e r105 = (e) r104.next();
        String r106 = this.f58194b.get(r105.getClass());
        if (r106 == null) goto L9;
        JsonObject r107 = new JsonObject();
        r107.add(r106, r102.serialize(r105));
        r103.add(r107);
        goto L4
    L9:
        throw new IllegalArgumentException("object type does not match any field names");
    L10:
        JsonObject r108 = new JsonObject();
        r108.add("operations", r103);
        return r108;
    }
}
