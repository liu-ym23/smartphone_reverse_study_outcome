package com.bytedance.android.live.incentive.et;

import com.bytedance.android.live.incentive.exchange.e;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import mz0.o;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static final void a(String r100, e r101, Function1<? super o, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "eventPropertyBuilder");
        n r103 = new n();
        m r104 = new m();
        r104.b(LogCommon.ROOM);
        r104.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r105 = r103.f516448b;
        ArrayList r106 = (ArrayList) r105;
        r106.addAll(r104.f516446a);
        if (r101 == null) goto L5;
        Map<String, String> r107 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r107, "map");
        Intrinsics.checkNotNullParameter("_exchange_session_id", "key");
        Intrinsics.checkNotNullParameter(null, "value");
        r107.put("_exchange_session_id", null);
    L5:
        r102.invoke(new o(r103.f516447a));
        cy0.e.f465759a.getClass();
        j r108 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r109 = com.bytedance.android.scope.m.b(r108).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r109);
        ((i) ((f80.a) r109)).w3(r100, r103.f516447a, r103.f516448b);
    }

    public static final void b(o r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$set");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.a(r101, r102);
    }
}
