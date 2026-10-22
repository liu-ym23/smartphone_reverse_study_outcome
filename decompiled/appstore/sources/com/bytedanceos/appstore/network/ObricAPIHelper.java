package com.bytedanceos.appstore.network;

import android.os.Bundle;
import com.android.volley.VolleyError;
import com.bytedanceos.appstore.buss.network.AssistantHttpEngine;
import com.bytedanceos.appstore.buss.network.StoreService;
import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.common.network.api.BaseAPIHelper;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.appstore.network.g;
import com.obric.appstore.util.JsonUtilsKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.k0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.y0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.http.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricAPIHelper extends BaseRepository implements BaseAPIHelper.Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricAPIHelper f9432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f9433b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f9434c = null;

    static {
        f9432a = new ObricAPIHelper();
        f9433b = JsonUtilsKt.b();
        f9434c = kotlin.b.b(ObricAPIHelper$commonParams$2.INSTANCE);
    }

    public ObricAPIHelper() {
    }

    public static final /* synthetic */ void f(ObricAPIHelper r10, g r11, y8.a r12, Function1 r13) {
        r10.o(r11, r12, r13);
    }

    public static final /* synthetic */ StoreService g(ObricAPIHelper r10) {
        return r10.s();
    }

    public static final /* synthetic */ Object h(ObricAPIHelper r10, Function1 r11, Continuation r12) {
        return r10.e(r11, r12);
    }

    public static final /* synthetic */ JsonElement i(ObricAPIHelper r10, String r11) {
        return r10.u(r11);
    }

    public static final /* synthetic */ RequestBody j(ObricAPIHelper r10, JsonObject r11) {
        return r10.v(r11);
    }

    @Override // com.bytedanceos.common.network.api.BaseAPIHelper.Interceptor
    public boolean interceptRequest(int r10, int r11, int r12, Object[] r13, Map r14, String r15, y8.a r16, String r17) {
        return l(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public final void k(String r10, y8.a r11) {
        h.d(y0.f21772a, l0.b(), null, new ObricAPIHelper$doLocalAppsRequest$1(r10, r11, null), 2, null);
    }

    public final boolean l(int r10, int r11, int r12, Object[] r13, Map r14, String r15, y8.a r16, String r17) {
        if (r10 == 2) goto L6;
        return false;
    L6:
        switch(r12) {
            case 500002: goto L16;
            case 500003: goto L16;
            case 600002: goto L12;
            case 600006: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    L8:
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        k(r15, r16);
        return true;
    L12:
        if (r15 != null) goto L14;
        r15 = "";
    L14:
        n(r15, r16);
        return true;
    L16:
        if (r14 != null) goto L18;
        r14 = k0.h();
    L18:
        m(r14, r16);
        return true;
    }

    public final Job m(Map r10, y8.a r11) {
        return h.d(y0.f21772a, l0.b(), null, new ObricAPIHelper$doSearchRequest$1(r10, r11, null), 2, null);
    }

    public final void n(String r10, y8.a r11) {
        h.d(y0.f21772a, l0.b(), null, new ObricAPIHelper$doUpdateAppsRequest$1(r10, r11, null), 2, null);
    }

    public final void o(g r10, y8.a r11, Function1 r12) {
        if ((r10 instanceof g.d) == false) goto L8;
        JsonObject r13 = new JsonObject();
        r13.add(ServerElements.BODY, (JsonElement) r12.invoke(((g.d) r10).a()));
        JsonObject r14 = new JsonObject();
        r14.addProperty(ServerElements.CODE, 0);
        r14.addProperty("message", "");
        Unit r15 = Unit.f21064a;
        r13.add(ServerElements.HEAD, r14);
        if (r11 == null) goto L14;
        r11.c(new y8.a.C0414a(200, k0.h(), r13.toString()));
        return;
    L14:
        return;
    L8:
        if ((r10 instanceof g.a) == false) goto L11;
        if (r11 == null) goto L16;
        Map r16 = k0.h();
        StringBuilder r17 = new StringBuilder();
        g.a r18 = (g.a) r10;
        r17.append(r18.a());
        r17.append(TokenParser.SP);
        r17.append(r18.b());
        r11.a(new y8.a.C0414a(400, r16, new VolleyError(r17.toString())));
        return;
    L16:
        return;
    L11:
        if (r11 == null) goto L18;
        r11.a(new y8.a.C0414a(400, k0.h(), new VolleyError("error!!!")));
        return;
    }

    public final Bundle p(String r10, int r11) {
        q.g(r10, "packageName");
        return (Bundle) h.f(null, new ObricAPIHelper$getAutoUpdateAppBundleBlock$1(r10, r11, null), 1, null);
    }

    public final JsonObject q() {
        return (JsonObject) f9434c.getValue();
    }

    public final Gson r() {
        return f9433b;
    }

    public final StoreService s() {
        return AssistantHttpEngine.f8771b.g();
    }

    public final void t() {
        BaseAPIHelper.m(this);
    }

    public final JsonElement u(String r10) {
        Object r11 = new JSONTokener(r10).nextValue();
        if ((r11 instanceof JSONObject) == false) goto L6;
        return (JsonElement) f9433b.fromJson(r10, JsonObject.class);
    L6:
        if ((r11 instanceof JSONArray) == true) goto L11;
        return null;
    L11:
        return (JsonElement) f9433b.fromJson(r10, JsonArray.class);
    }

    public final RequestBody v(JsonObject r10) {
        MediaType r11 = MediaType.c("application/json; charset=utf-8");
        JsonObject r12 = new JsonObject();
        r12.add("params", r10);
        r12.add("common", f9432a.q());
        return RequestBody.c(r11, r12.toString());
    }
}
