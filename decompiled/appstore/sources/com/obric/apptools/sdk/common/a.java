package com.obric.apptools.sdk.common;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.collections.k0;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11138a = null;

    static {
        f11138a = new a();
    }

    public a() {
    }

    public final JSONObject a(Event r10) {
        q.g(r10, "<this>");
        JSONObject r11 = new JSONObject();
        r11.put("event_name", r10.e());
        r11.put("client_timestamp", r10.d());
        r11.put("log_type", "flexible");
        r11.put("category", new JSONObject(k0.s(r10.c())));
        r11.put("metrics", new JSONObject(k0.s(r10.g())));
        r11.put(WsConstants.KEY_EXTRA, new JSONObject(k0.s(r10.f())));
        return r11;
    }
}
