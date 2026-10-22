package com.bytedance.android.livesdk.interactivity.api.monitorV2;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.d;
import com.bytedance.live.datacontext.j;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j<d> f133339a;

    public static j a() {
        j<d> r100 = f133339a;
        if (r100 != null) goto L11;
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r101 == null) goto L10;
        o r102 = IRoomContextService.a.a(r101, null, 0, 3);
        if (r102 == null) goto L10;
        return r102.D2();
    L10:
        return null;
    L11:
        return r100;
    }

    static {
    }

    @JvmStatic
    public static final void g(final MonitorEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "newEvent");
        j r101 = a();
        if (r101 == null) goto L6;
        r101.c(new InteractivityMonitorHelper$registEvent$1(r100));
        Unit r102 = Unit.INSTANCE;
        return;
    }

    @JvmStatic
    public static final void d(EventName r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        j r102 = a();
        if (r102 == null) goto L8;
        d r103 = (d) r102.getValue();
        if (r103 == null) goto L9;
        r103.g(r100, r101);
        Unit r104 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void b(EventName r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "nodeName");
        Intrinsics.checkNotNullParameter(r102, "value");
        j r103 = a();
        if (r103 == null) goto L8;
        d r104 = (d) r103.getValue();
        if (r104 == null) goto L9;
        r104.a(r100, r101, r102);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void c(EventName r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "fieldName");
        Intrinsics.checkNotNullParameter(r102, "fieldValue");
        j r103 = a();
        if (r103 == null) goto L8;
        d r104 = (d) r103.getValue();
        if (r104 == null) goto L9;
        r104.e(r100, r101, r102);
        Unit r105 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void e(EventName r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "indiName");
        j r103 = a();
        if (r103 == null) goto L8;
        d r104 = (d) r103.getValue();
        if (r104 == null) goto L9;
        r104.h(r100, r101, r102);
        Unit r105 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void f(EventName r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "nodeName");
        j r103 = a();
        if (r103 == null) goto L8;
        d r104 = (d) r103.getValue();
        if (r104 == null) goto L9;
        r104.c(r100, r101, r102);
        Unit r105 = Unit.INSTANCE;
        return;
    L9:
        return;
    }
}
