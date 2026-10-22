package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.ChangeVsCameraViewResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "changeVsCameraView")
public final class r1 extends w20.q<w20.z7, ChangeVsCameraViewResultModel> {

    public static final class a {
    }

    static {
    }

    public r1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.z7 r112 = (w20.z7) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonObject r113 = r112.b();
        com.bytedance.android.livesdk.log.filter.o r100 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r100 instanceof com.bytedance.android.livesdk.log.filter.n0) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.livesdk.log.filter.n0 r101 = (com.bytedance.android.livesdk.log.filter.n0) r100;
        if (r101 == null) goto L41;
        Map<String, String> r102 = r101.f153291b;
        if (r102 == null) goto L41;
        if (r113 == null) goto L41;
        JsonElement r103 = r113.get("enter_from_merge");
        if (r103 == null) goto L15;
        String r104 = r103.getAsString();
    L16:
        JsonElement r114 = r113.get("enter_method");
        if (r114 == null) goto L19;
        String r115 = r114.getAsString();
    L20:
        boolean r105 = false;
        if (r104 != null) goto L23;
    L31:
        if (r115 == null) goto L41;
        if (r115.length() <= 0) goto L35;
        r105 = true;
    L35:
        if (r105 == true) goto L38;
        r115 = null;
    L38:
        if (r115 == null) goto L41;
        r102.put("enter_method", r115);
        goto L41
    L23:
        if (r104.length() <= 0) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == true) goto L29;
        r104 = null;
    L29:
        if (r104 == null) goto L31;
        r102.put("enter_from_merge", r104);
        goto L31
    L25:
        r106 = false;
        goto L26
    L19:
        r115 = null;
        goto L20
    L15:
        r104 = null;
    L41:
        if (dq1.b.b(true) == false) goto L49;
        dq1.a r107 = pm1.f.a();
        if (r107 == null) goto L54;
        String r116 = r112.a();
        if (r116 == null) goto L47;
        long r108 = CastLongProtector.parseLong(r116);
    L48:
        dq1.a.C5698a.a(r107, Long.valueOf(r108), null, false, null, null, 30);
        goto L54
    L47:
        r108 = 0;
    L54:
        RoomContext r117 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r117 == null) goto L62;
        com.bytedance.live.datacontext.m<Long> r118 = r117.getCameraId();
        if (r118 == null) goto L63;
        Observable<Long> r119 = r118.a();
        if (r119 == null) goto L64;
        r119.subscribe(new s1(this, r112));
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L49:
        xs2.b r120 = xs2.b.a();
        VSJumpCameraEvent r109 = new VSJumpCameraEvent();
        String r121 = r112.a();
        if (r121 == null) goto L52;
        long r122 = CastLongProtector.parseLong(r121);
    L53:
        r109.setCameraId(r122);
        Unit r123 = Unit.INSTANCE;
        r120.post(r109);
        goto L54
    L52:
        r122 = 0;
        goto L53
    }
}
