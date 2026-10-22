package com.bytedance.android.live.core.privacy.av.impl;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements com.bytedance.android.live.core.privacy.av.api.h {
    public i() {
    }

    public static String d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Iterator r101 = r100.entrySet().iterator();
        if (r101.hasNext() == true) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r102 = new StringBuilder("{");
    L7:
        Map.Entry r103 = (Map.Entry) r101.next();
        String r104 = (String) r103.getKey();
        String r105 = ((String) r103.getValue()).toString();
        r102.append(Typography.quote);
        r102.append(r104);
        r102.append("\":");
        r102.append(r105);
        if (r101.hasNext() == false) goto L9;
        r102.append(", ");
        goto L7
    L9:
        r102.append('}');
        return r102.toString();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("AudioAndVideoPrivacy", r100);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void c(com.bytedance.android.live.core.privacy.av.api.i r100) {
        Intrinsics.checkNotNullParameter(r100, "remoteData");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = com.bytedance.android.live.core.monitor.trace.e.f64997m;     // Catch: Throwable -> L5
        com.bytedance.android.live.core.monitor.trace.e.a r103 = com.bytedance.android.live.core.monitor.trace.e.b.a(r100.f65137a, "privacy_av");     // Catch: Throwable -> L5
        r103.f65012c = "webcast_client_privacy";     // Catch: Throwable -> L5
        r103.f65013d = r100.f65138b;     // Catch: Throwable -> L5
        r103.b("biz", r100.f65141e);     // Catch: Throwable -> L5
        r103.b("sense", r100.f65142f);     // Catch: Throwable -> L5
        r103.b("type", r100.getType());     // Catch: Throwable -> L5
        r103.b("params", d(r100.f65144h));     // Catch: Throwable -> L5
        r103.f65017h = Integer.valueOf(r100.f65139c);     // Catch: Throwable -> L5
        r103.f65018i = r100.f65140d;     // Catch: Throwable -> L5
        com.bytedance.android.live.core.monitor.trace.e r104 = r103.a();     // Catch: Throwable -> L5
        a60.e r105 = com.bytedance.android.live.core.monitor.trace.c.f64995a;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r104, "traceMeta");     // Catch: Throwable -> L5
        TraceMonitor.i(r104, null, null, null);     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        b("upload trace failed:" + r107.getMessage(), null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.h
    public final void b(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r101 == null) goto L5;
        ALogger.e("AudioAndVideoPrivacy", r100, r101);
        return;
    L5:
        ALogger.e("AudioAndVideoPrivacy", r100);
    }
}
