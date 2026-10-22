package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f191318a = 0;

    static {
    }

    public static void a(String r100, JsonObject r101) {
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("js_event", "publishEvent: ".concat(r100));
        com.larus.navigation.api.c.a("nav_protocol_trace", "[H5_EVENT/" + r100 + "] fieldCount=" + r101.entrySet().size());
        Lazy r103 = l3.d.f507201a;
        l3.d.c(new l3.a(r100, r101, 4));
        int r104 = com.larus.navigation.api.j.f359662a;
        String r105 = StringsKt.take(r101.toString(), 300);
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r105, "params");
    }
}
