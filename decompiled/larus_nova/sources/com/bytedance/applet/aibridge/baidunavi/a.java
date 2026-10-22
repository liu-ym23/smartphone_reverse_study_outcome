package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f190937a = 0;

    static {
    }

    public static void a(int r100, String r101, dv3.c r102) {
        Lazy r103 = l3.d.f507201a;
        JsonObject r104 = new JsonObject();
        r104.addProperty("status", Integer.valueOf(r100));
        r104.addProperty("message", r101);
        r104.add("result", GsonProtectorUtils.toJsonTree(new Gson(), r102));
        Unit r105 = Unit.INSTANCE;
        l3.d.c(new l3.a("flow.onNavStatusChanged", r104, 4));
    }
}
