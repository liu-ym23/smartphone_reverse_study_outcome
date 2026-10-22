package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class w {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f151719h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f151720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f151721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f151722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f151723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f151724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f151725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f151726g;

    public static final class a {
        public static String b() {
            return ControllerCenter.b(null).a();
        }

        public static JSONObject a(RoomContextController r100) {
            w r101 = ControllerCenter.b(r100);
            JSONObject r102 = r101.f151722c;
            if (r102 != null) goto L28;
            Map<String, String> r103 = r101.f151720a;
            if (r103 == null) goto L26;
            String r104 = r103.get("multi_room_data");
            if (r104 == null) goto L11;
            JSONObject r105 = z1.g(r104);
            if (r105 == null) goto L11;
        L12:
            String r106 = r103.get("task_enter_from");
            if (r106 == null) goto L15;
            r105.put("task_enter_from", r106);
        L15:
            String r107 = r103.get(AiProactiveTaskViewModel.PARAM_TASK_TYPE);
            if (r107 == null) goto L18;
            r105.put(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r107);
        L18:
            String r108 = r103.get("task_request_params");
            if (r108 == null) goto L21;
            r105.put("task_request_params", r108);
        L21:
            String r109 = r103.get("extra_params");
            if (r109 == null) goto L24;
            r105.put("extra_params", r109);
        L24:
            r101.f151722c = r105;
            return r105;
        L11:
            r105 = new JSONObject();
            goto L12
        L26:
            return new JSONObject();
        L28:
            return r102;
        }

        public static String c(Map r100) {
            if (r100 == null) goto L7;
            String r101 = (String) r100.get("multi_room_data");
            if (r101 == null) goto L7;
            JSONObject r102 = z1.g(r101);
            if (r102 == null) goto L7;
        L8:
            ArrayList r103 = new ArrayList();
            Iterator r104 = StringsKt.split$default(r102.optString("ecom_scene_id"), new String[]{","}, false, 0, 6, null).iterator();
        L10:
            if (r104.hasNext() == false) goto L19;
            String r105 = (String) r104.next();
            if (r105.length() <= 0) goto L14;
            boolean r106 = true;
        L15:
            if (r106 == false) goto L10;
            if (((HashSet) ExtraController.f151511l.getValue()).contains(r105) == false) goto L10;
            r103.add(r105);
            goto L10
        L14:
            r106 = false;
            goto L15
        L19:
            r103.add(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF);
            return CollectionsKt.joinToString$default(r103, ",", null, null, 0, null, null, 62, null);
        L7:
            r102 = new JSONObject();
            goto L8
        }
    }

    static {
    }

    public w() {
    }

    public final String a() {
        int r100 = RoomContextController.f151593h;
        if (RoomContextController.a.a().x() == true) goto L6;
        return AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
    L6:
        String r101 = this.f151723d;
        if (r101 == null) goto L9;
        return r101;
    L9:
        String r102 = a.c(this.f151721b);
        this.f151723d = r102;
        return r102;
    }
}
