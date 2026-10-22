package com.bytedance.android.shopping.new_cart.monitor;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179139a = 0;

    public static void a() {
        com.bytedance.android.shopping.base.event.a.d("cart", "page_create", "end", null, false, null, 56);
    }

    public static void c() {
        com.bytedance.android.shopping.base.event.a.d("cart", ChameleonOpenTracker.Stage.RENDER, "start", null, false, null, 56);
    }

    static {
    }

    public static void b(boolean r100) {
        ConcurrentHashMap<String, String> r101 = com.bytedance.android.shopping.base.event.a.f170704a;
        JSONObject r102 = new JSONObject();
        r102.put("full_mode", r100);
        Unit r103 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.d("cart", "page_create", "start", null, false, r102, 24);
    }

    public static void d(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        ConcurrentHashMap<String, String> r102 = com.bytedance.android.shopping.base.event.a.f170704a;
        JSONObject r103 = new JSONObject();
        r103.put("statusCode", r100);
        Unit r104 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.c("cart", "request", "failed", r101, true, r103);
    }
}
