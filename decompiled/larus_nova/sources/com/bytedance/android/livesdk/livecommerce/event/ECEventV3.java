package com.bytedance.android.livesdk.livecommerce.event;

import android.text.TextUtils;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "废弃，请使用ECParamEvent")
public abstract class ECEventV3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f147719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f147720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f147721c;

    public @interface NoticeTypeDef {
    }

    public void k() {
        if (TextUtils.isEmpty(this.f147719a) == false) goto L5;
        return;
    L5:
        oh.a.a(new n0(this));
    }

    public ECEventV3(String r100) {
        this.f147720b = true;
        j(r100);
    }

    public final ECEventV3 a(long r100) {
        this.f147721c.b("is_from_ug", r100);
        return this;
    }

    public ECEventV3 g(Map<String, String> r100) {
        if (r100 == null) goto L11;
        Iterator<String> r101 = r100.keySet().iterator();
    L5:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        String r103 = r100.get(r102);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        if (TextUtils.isEmpty(r103) == true) goto L5;
        f(r102, r103);
    L11:
        return this;
    }

    public final String i(String r100) {
        k0 r101 = this.f147721c;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.f(r100);
    }

    public final void j(String r100) {
        this.f147719a = r100;
        this.f147721c = new k0();
        if (this.f147720b == false) goto L20;
        HashMap<String, String> r101 = l0.g();
        HashMap r102 = new HashMap();
        r102.putAll(r101);
        String r103 = (String) r102.get("live_tracker_params");
        if (TextUtils.isEmpty(r103) == false) goto L31;
    L14:
        HashMap<String, String> r104 = l0.o();
        if (r104.isEmpty() == true) goto L17;
        this.f147721c.d(r104);
    L17:
        h(null, null);
        this.f147721c.d(r102);
        Map r105 = Collections.unmodifiableMap(f2.f147736b.f147737a);
        if (r105 == null) goto L20;
        this.f147721c.d(r105);
        goto L20
    L31:
        JSONObject r106 = new JSONObject(r103);     // Catch: JSONException -> L12
        Iterator<String> r107 = r106.keys();     // Catch: JSONException -> L12
    L8:
        if (r107.hasNext() == false) goto L10;
        String r108 = r107.next();     // Catch: JSONException -> L12
        r102.put(r108, r106.get(r108).toString());     // Catch: JSONException -> L12
        goto L8
    L10:
        r102.remove("live_tracker_params");     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L20:
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        this.f147721c.c("enter_from", "live");
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        int r109 = RoomContextController.f151593h;
        if (RoomContextController.a.a().x() == false) goto L27;
        RoomContextController r110 = RoomContextController.a.a();
        this.f147721c.c("display_room_id", r110.B());
        this.f147721c.c("display_anchor_id", r110.y());
        this.f147721c.c("display_sec_anchor_id", r110.z());
        this.f147721c.c("display_follow_status", r110.K().get("follow_status"));
        com.bytedance.android.ec.model.response.n1 r111 = r110.f151597f;
        if (r111 == null) goto L27;
        if (r111.a() == null) goto L27;
        k0 r112 = this.f147721c;
        int r113 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;
        r112.c("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a, r111.a()));
    L27:
        int r114 = ECSdk.f48106a;
        IAdapterService r115 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r115 == null) goto L34;
        r115.getStrategyService();
        return;
    }

    public final void m(Map r100) {
        if (r100 == null) goto L15;
        Map r101 = (Map) r100.get("all");
        if (r101 == null) goto L9;
        Iterator r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        f((String) r103.getKey(), (String) r103.getValue());
    L9:
        Map r104 = (Map) r100.get(this.f147719a);
        if (r104 == null) goto L18;
        Iterator r105 = r104.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L19;
        Map.Entry r106 = (Map.Entry) r105.next();
        f((String) r106.getKey(), (String) r106.getValue());
        goto L13
    L19:
        return;
    L18:
        return;
    }

    public ECEventV3(RoomContextController r100, String r101) {
        this.f147720b = true;
        if (r100 != null) goto L5;
    L40:
        j(r101);
        return;
    L5:
        if (com.bytedance.android.ec.core.opt.ab.c.q() != 1) goto L40;
        this.f147719a = r101;
        this.f147721c = new k0();
        HashMap<String, String> r102 = l0.h(r100);
        HashMap r103 = new HashMap();
        r103.putAll(r102);
        String r104 = (String) r103.get("live_tracker_params");
        if (TextUtils.isEmpty(r104) == true) goto L17;
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L14
        Iterator<String> r106 = r105.keys();     // Catch: JSONException -> L14
    L10:
        if (r106.hasNext() == false) goto L12;
        String r107 = r106.next();     // Catch: JSONException -> L14
        r103.put(r107, r105.get(r107).toString());     // Catch: JSONException -> L14
        goto L10
    L12:
        r103.remove("live_tracker_params");     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L17:
        if (r100.x() == false) goto L19;
        ECContext r108 = r100.r();
    L20:
        if (r108 != null) goto L22;
        HashMap r109 = new HashMap();
    L27:
        if (r109.isEmpty() == true) goto L29;
        this.f147721c.d(r109);
    L29:
        h(r100.B(), r100.D());
        this.f147721c.d(r103);
        Map r110 = Collections.unmodifiableMap(f2.f147736b.f147737a);
        if (r110 == null) goto L32;
        this.f147721c.d(r110);
    L32:
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        this.f147721c.c("enter_from", "live");
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        this.f147721c.c("display_room_id", r100.B());
        this.f147721c.c("display_anchor_id", r100.y());
        this.f147721c.c("display_sec_anchor_id", r100.z());
        this.f147721c.c("display_follow_status", r100.K().get("follow_status"));
        com.bytedance.android.ec.model.response.n1 r111 = r100.f151597f;
        if (r111 != null) goto L35;
    L37:
        int r112 = ECSdk.f48106a;
        IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r113 == null) goto L45;
        r113.getStrategyService();
        return;
    L45:
        return;
    L35:
        if (r111.a() == null) goto L37;
        k0 r114 = this.f147721c;
        int r115 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;
        r114.c("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a, r111.a()));
        goto L37
    L22:
        if (r108.getEnterRoomParams().getValue().containsKey("jump_schema") == false) goto L24;
        r109 = new HashMap(r108.getEnterRoomParams().getValue());
        r109.remove("jump_schema");
        goto L27
    L24:
        r109 = (HashMap) r108.getEnterRoomParams().getValue();
        goto L27
    L19:
        r108 = null;
        goto L20
    }

    public final ECEventV3 b(String r100, int r101) {
        this.f147721c.a(r100, r101);
        return this;
    }

    public final ECEventV3 c(String r100, String r101) {
        this.f147721c.c(r100, r101);
        return this;
    }

    public final void d(String r100, int r101) {
        this.f147721c.a(r100, r101);
    }

    public final void e(String r100, long r101) {
        this.f147721c.b(r100, r101);
    }

    public final void f(String r100, String r101) {
        this.f147721c.c(r100, r101);
    }

    public final void h(String r100, String r101) {
        Lazy r102 = ExtraController.f151511l;     // Catch: Exception -> L11
        ExtraController r103 = ControllerCenter.c(r100, r101).f151430u;     // Catch: Exception -> L11
        Objects.toString(r103);     // Catch: Exception -> L11
        if (r103.x() == false) goto L13;
        JSONObject r104 = r103.H();     // Catch: Exception -> L11
        if (r104 == null) goto L13;
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L11
    L8:
        if (r105.hasNext() == false) goto L13;
        String r106 = r105.next();     // Catch: Exception -> L11
        this.f147721c.c(r106, r104.optString(r106, ""));     // Catch: Exception -> L11
    L13:
        Map<String, String> r107 = this.f147721c.f147739a;
        if (r107 == null) goto L21;
        HashMap r108 = (HashMap) r107;
        r108.remove("pass_through_log_data");
        r108.remove("multi_room_data");
        r108.remove("single_room_data");
        return;
    L21:
        return;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L13
    }

    public final void l(final String r100, final String r101) {
        if (TextUtils.isEmpty(this.f147719a) == false) goto L5;
        return;
    L5:
        oh.a.a(new m0(this, r100, r101));
    }

    public ECEventV3(String r100, int r101) {
        this.f147720b = true;
        this.f147720b = false;
        j(r100);
    }
}
