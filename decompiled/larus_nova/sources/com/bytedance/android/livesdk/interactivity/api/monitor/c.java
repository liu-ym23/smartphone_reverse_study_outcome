package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f133317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f133318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f133319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f133320d;

    public c() {
        this(0, null, 0, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (this.f133317a == r101.f133317a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133318b, r101.f133318b) == true) goto L10;
        return false;
    L10:
        if (this.f133319c == r101.f133319c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f133320d, r101.f133320d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f133317a * 31;
        String r101 = this.f133318b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.f133319c;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Map<String, String> r106 = this.f133320d;
        if (r106 == null) goto L10;
        r102 = r106.hashCode();
    L10:
        return r105 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractivityMonitorData(statusCode=" + this.f133317a + ", statusMsg=" + this.f133318b + ", duration=" + this.f133319c + ", extraInfo=" + this.f133320d + ")";
    }

    public final void a(InteractivityMonitor.Event r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = this.f133317a;
        String r101 = this.f133318b;
        long r102 = this.f133319c;
        Map<String, String> r103 = this.f133320d;
        int r104 = InteractivityMonitor.f133299a;
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        IRoomContextService r105 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r105 == null) goto L9;
        o r106 = IRoomContextService.a.a(r105, null, 0, 3);
        if (r106 == null) goto L9;
        m<IRoom> r107 = r106.getRoom();
        if (r107 == null) goto L9;
        IRoom r108 = r107.getValue();
    L10:
        LiveMonitor.a r111 = InteractivityMonitor.a(r110, r108, null);
        r111.l(r100);
        r111.h(r102);
        r111.e("status", r101);
        if (r103 == null) goto L16;
        Iterator<Map.Entry<String, String>> r109 = r103.entrySet().iterator();
    L14:
        if (r109.hasNext() == false) goto L16;
        Map.Entry<String, String> r112 = r109.next();
        r111.i(r112.getKey(), r112.getValue());
    L16:
        r111.a().report();
        return;
    L9:
        r108 = null;
        goto L10
    }

    public final void b(InteractivityTraceMonitor.Event r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = this.f133317a;
        String r101 = this.f133318b;
        long r102 = this.f133319c;
        Map<String, String> r103 = this.f133320d;
        int r104 = InteractivityTraceMonitor.f133301a;
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        JSONObject r105 = new JSONObject();
        if (r103 == null) goto L8;
        Iterator<Map.Entry<String, String>> r106 = r103.entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        Map.Entry<String, String> r107 = r106.next();
        d.a(r105, r107.getKey(), r107.getValue());
    L8:
        d.a(r105, "status_code", String.valueOf(r100));
        d.a(r105, "status_msg", r101);
        d.a(r105, "duration", String.valueOf(r102));
        if (r110.getNeedRoomCommonParams() == false) goto L37;
        int r108 = InteractivityTraceMonitor.a.f133303a;
        Intrinsics.checkNotNullParameter(r105, "extra");
        IRoomContextService r109 = (IRoomContextService) k.f(IRoomContextService.class);
        IRoom r111 = null;
        if (r109 == null) goto L17;
        o r112 = IRoomContextService.a.a(r109, null, 0, 3);
        if (r112 == null) goto L17;
        m<IRoom> r113 = r112.getRoom();
        if (r113 == null) goto L17;
        IRoom r114 = r113.getValue();
    L18:
        if (r114 != null) goto L20;
    L24:
        boolean r115 = false;
    L25:
        if (r115 == false) goto L27;
        r111 = r114;
    L27:
        if (r111 == null) goto L29;
        d.a(r105, "room_id", String.valueOf(r111.getId()));
        LiveMode r116 = r111.getStreamType();
        int r117 = h1.f66189a;
        d.a(r105, IPerformanceManager.Params.room_type, i1.a(r116));
        d.a(r105, "anchor_id", r111.getOwnerUserIdString());
    L29:
        IMiddlewareUserService r118 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r118 == null) goto L35;
        com.bytedance.android.livesdk.user.e r119 = r118.user();
        if (r119 == null) goto L35;
        String r120 = r119.n();
        if (r120 == null) goto L35;
    L36:
        d.a(r105, "user_id", r120);
    L35:
        r120 = "";
        goto L36
    L20:
        if (r114.getId() <= 0) goto L24;
        if (r114.getOwner() == null) goto L24;
        r115 = true;
    L17:
        r114 = null;
    L37:
        int r121 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r122 = com.bytedance.android.live.core.monitor.trace.e.b.a(r110.getEventType(), r110.getBusinessType());
        r122.f65012c = r110.getProductId();
        r122.f65017h = Integer.valueOf(r100);
        r122.f65018i = r101;
        r122.f65014e = r105.optString("room_id");
        r122.f65015f = r105.optString("anchor_id");
        r122.f65016g = r105.optString("user_id");
        com.bytedance.android.live.core.monitor.trace.c.b(r122.a(), r105);
    }

    public c(int r100, String r101, long r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        this.f133317a = r100;
        this.f133318b = r101;
        this.f133319c = r102;
        this.f133320d = r103;
    }

    public /* synthetic */ c(int r100, String r101, long r102, Map r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        int r103 = 0;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = "";
    L9:
        String r104 = r101;
        if ((r111 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        long r105 = r102;
        if ((r111 & 8) == 0) goto L15;
        r110 = null;
    L15:
        this(r103, r104, r105, r110);
        return;
    L5:
        r103 = r100;
        goto L7
    }
}
