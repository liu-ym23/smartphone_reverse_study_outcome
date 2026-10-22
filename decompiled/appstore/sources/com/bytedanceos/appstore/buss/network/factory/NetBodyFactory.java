package com.bytedanceos.appstore.buss.network.factory;

import com.bytedanceos.appstore.buss.entity.netwrap.NetBodyEntity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import q7.e;

/* JADX INFO: loaded from: classes2.dex */
public final class NetBodyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetBodyFactory f8806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f8807b = null;

    static {
        f8806a = new NetBodyFactory();
        f8807b = b.b(NetBodyFactory$netBodyEntity$2.INSTANCE);
    }

    public NetBodyFactory() {
    }

    public final RequestBody a(RequestBody r10) {
        c().setBody(d(r10));
        String r11 = new Gson().toJson(c());
        RequestBody r12 = RequestBody.c(MediaType.c("application/json"), r11);
        q.f(r12, "create(...)");
        return r12;
    }

    public final String b(RequestBody r10) {
        Buffer r11 = new Buffer();
        r10.g(r11);
        MediaType r12 = r10.b();
        if (r12 == null) goto L5;
        Charset r13 = r12.b(StandardCharsets.UTF_8);
    L6:
        if (r13 != null) goto L9;
        r13 = StandardCharsets.UTF_8;
        q.f(r13, "UTF_8");
    L9:
        if (e.a(r11) == false) goto L15;
        String r14 = r11.readString(r13);
        if (o.r(r14) == true) goto L14;
        return r14;
    L14:
        return new JSONObject().toString();
    L15:
        return null;
    L5:
        r13 = null;
        goto L6
    }

    public final NetBodyEntity c() {
        return (NetBodyEntity) f8807b.getValue();
    }

    public final JsonElement d(RequestBody r10) {
        if (r10 == null) goto L13;
        String r11 = b(r10);
        if (r11 == null) goto L14;
        Object r12 = new JSONTokener(r11).nextValue();
        if ((r12 instanceof JSONObject) == false) goto L10;
        return (JsonElement) new Gson().fromJson(r11, JsonObject.class);
    L10:
        if ((r12 instanceof JSONArray) == true) goto L12;
        return null;
    L12:
        return (JsonElement) new Gson().fromJson(r11, JsonArray.class);
    L14:
        return null;
    L13:
        return null;
    }
}
