package com.bytedance.android.shopping.base.event;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f170705a = 0;

    static {
    }

    public static void c(String r100) {
        ConcurrentHashMap<String, String> r101 = a.f170704a;
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r100);
    L5:
        Unit r103 = Unit.INSTANCE;
        a.d("pdp", "page_create", "success", null, false, r102, 24);
    }

    public static void e(String r100) {
        ConcurrentHashMap<String, String> r101 = a.f170704a;
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r100);
    L5:
        Unit r103 = Unit.INSTANCE;
        a.d("pdp", "pdp_first_frame_start", "start", null, false, r102, 24);
    }

    public static void h(String r100) {
        ConcurrentHashMap<String, String> r101 = a.f170704a;
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r100);
    L5:
        Unit r103 = Unit.INSTANCE;
        a.d("pdp", ChameleonOpenTracker.Stage.RENDER, "success", null, false, r102, 24);
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        ConcurrentHashMap<String, String> r101 = a.f170704a;
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r100);
        Unit r103 = Unit.INSTANCE;
        a.d("pdp", "pre_check", "start", null, false, r102, 24);
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        ConcurrentHashMap<String, String> r101 = a.f170704a;
        a.f170704a.clear();
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r100);
        Unit r103 = Unit.INSTANCE;
        a.d("pdp", "schema_parse", "start", null, false, r102, 24);
    }

    public static void a(boolean r100, String r101) {
        ConcurrentHashMap<String, String> r102 = a.f170704a;
        JSONObject r103 = new JSONObject();
        r103.put("check_law", r100);
        if (r101 == null) goto L5;
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r101);
    L5:
        Unit r104 = Unit.INSTANCE;
        a.d("pdp", "first_screen_response_return", "success", null, false, r103, 24);
    }

    public static void d(String r100, boolean r101) {
        ConcurrentHashMap<String, String> r102 = a.f170704a;
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L5;
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r100);
    L5:
        r103.put("rebuild", r101);
        Unit r104 = Unit.INSTANCE;
        a.d("pdp", "pdp_first_frame_end", "success", null, false, r103, 24);
    }

    public static void g(boolean r100, String r101) {
        ConcurrentHashMap<String, String> r102 = a.f170704a;
        JSONObject r103 = new JSONObject();
        r103.put(MobConstants.FORM_CACHE, r100);
        if (r101 == null) goto L5;
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r101);
    L5:
        Unit r104 = Unit.INSTANCE;
        a.d("pdp", ChameleonOpenTracker.Stage.RENDER, "start", null, false, r103, 24);
    }

    public static void b(boolean r100, String r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        ConcurrentHashMap<String, String> r102 = a.f170704a;
        JSONObject r103 = new JSONObject();
        r103.put("enable_opt", r100);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r101);
        r103.put("key_data_is_null", r110);
        Unit r104 = Unit.INSTANCE;
        a.d("pdp", "first_screen_response_return", "start", null, false, r103, 24);
    }

    public static void f(boolean r100, String r101, boolean r110) {
        ConcurrentHashMap<String, String> r102 = a.f170704a;
        JSONObject r103 = new JSONObject();
        r103.put("full_mode", r100);
        r103.put("rebuild", r110);
        if (r101 == null) goto L5;
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID, r101);
    L5:
        Unit r104 = Unit.INSTANCE;
        a.d("pdp", "page_create", "start", null, false, r103, 24);
    }
}
