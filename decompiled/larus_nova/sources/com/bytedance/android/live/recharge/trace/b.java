package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import cy0.j;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90385a = 0;

    static {
    }

    public static void a(String r110, JSONObject r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "category");
        Intrinsics.checkNotNullParameter(r112, "extra");
        j01.d.b(r111, "status", 0);
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r101, "metric");
        EventModule r113 = EventModule.RECHARGE;
        Intrinsics.checkNotNullParameter(r113, "eventModule");
        String r103 = r113.getValue();
        Intrinsics.checkNotNullParameter(r102, "map");
        Iterator<String> r114 = r112.keys();
    L4:
        if (r114.hasNext() == false) goto L6;
        String r104 = r114.next();
        Object r105 = r112.get(r104);
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        r102.put(r104, r105);
        goto L4
    L6:
        cy0.e.f465759a.getClass();
        j r115 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r116 = m.b(r115).b(n97.a.class);
        Intrinsics.checkNotNull(r116);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r116)).g(r110, r103, "bussiness_api_call", r100, r101, r102);
    }
}
