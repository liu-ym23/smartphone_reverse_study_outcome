package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.e10;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class td extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zd f63680a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public td(zd r100) {
        this.f63680a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r210, CallContext r211) {
        JSONObject r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f63680a.getClass();
        zd.b("connect message manager");
        zd.a(this.f63680a);
        JSONObject r101 = new JSONObject();
        Long r102 = StringsKt.toLongOrNull(r100.optString("roomID", ""));
        if (r102 != null) goto L5;
        r101.put("code", 0);
        finishWithResult(r101);
        return;
    L5:
        String r103 = r100.optString("scene", "venue");
        int r104 = r100.optInt("service", 0);
        int r105 = r100.optInt(com.alipay.sdk.m.p.e.f25671s, 0);
        JSONObject r106 = r100.optJSONObject("custom_params");
        HashMap r110 = new HashMap();
        if (r106 == null) goto L12;
        Iterator<String> r111 = r106.keys();
        if (r111 == null) goto L12;
    L10:
        if (r111.hasNext() == false) goto L12;
        String r112 = r111.next();
        r110.put(r112, r106.get(r112).toString());
    L12:
        r110.put("room_id", String.valueOf(r102.longValue()));
        zd r107 = this.f63680a;
        Integer r113 = null;
        if (r104 <= 0) goto L16;
        if (r105 <= 0) goto L16;
        r211.getContext();
        vlc.d r108 = com.bytedance.android.livesdk.utils.z4.c(r104, r105, r110);
    L46:
        r107.f63753a = r108;
        vlc.d r109 = this.f63680a.f63753a;
        if (r109 == null) goto L49;
        r109.startMessage();
    L49:
        zd r114 = this.f63680a;
        StringBuilder r115 = new StringBuilder("create and start message manager: ");
        vlc.d r116 = this.f63680a.f63753a;
        if (r116 == null) goto L52;
        r113 = Integer.valueOf(r116.hashCode());
    L52:
        r115.append(r113);
        r115.append(", roomId: ");
        r115.append(r102);
        String r117 = r115.toString();
        r114.getClass();
        zd.b(r117);
        r101.put("code", 1);
        finishWithResult(r101);
        return;
    L16:
        Context r118 = r211.getContext();
        long r119 = r102.longValue();
        Map r120 = MapsKt.emptyMap();
        String r121 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n();
        ArrayList r122 = new ArrayList();
        r122.add(new com.bytedance.android.livesdk.message.interceptor.d(r119));
        vlc.b r123 = com.bytedance.android.livesdk.utils.z4.d();
        if (r123 == null) goto L19;
        r122.add(r123);
    L19:
        ArrayList r124 = new ArrayList();
        if ((r123 instanceof vlc.j) == false) goto L22;
        r124.add((vlc.j) r123);
    L22:
        hm2.n r125 = new hm2.n(r118, r103, r119, r121, r120, r122, r124);
        int r126 = vs1.d.f556977a;
        Intrinsics.checkNotNullParameter(r103, "scene");
        List<vs1.d> r127 = e10.f120079a.getValue().a();
        if (r127 == null) goto L36;
        Iterator<T> r128 = r127.iterator();
    L26:
        if (r128.hasNext() == false) goto L34;
        Object r129 = r128.next();
        vs1.d r130 = (vs1.d) r129;
        if (r130 == null) goto L30;
        String r131 = r130.b();
    L32:
        if (Intrinsics.areEqual(r131, r103) == false) goto L26;
    L35:
        vs1.d r132 = (vs1.d) r129;
    L37:
        if (r132 != null) goto L39;
    L45:
        r108 = amc.f.a(r125);
        goto L46
    L39:
        if (r132.d() == false) goto L45;
        if (r132.c() <= 0) goto L45;
        if (r132.a() <= 0) goto L45;
        r108 = st2.b.a(r132.c(), r132.a(), r125.f(), r122, r124, Collections.emptyList());
        goto L46
    L30:
        r131 = null;
        goto L32
    L34:
        r129 = null;
        goto L35
    L36:
        r132 = null;
        goto L37
    }
}
