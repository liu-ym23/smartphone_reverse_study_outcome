package com.stepos.statsrpk.service;

import android.content.Context;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f2887a;

    /* renamed from: b, reason: collision with root package name */
    public n6.a f2888b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f2889c;

    public static void a(e eVar) {
        ua.c.a("a", "flushQueueInternalByTimer");
        n6.a aVar = eVar.f2888b;
        ArrayList arrayListH = aVar.h();
        int size = arrayListH.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListH.get(i);
            i++;
            String str = (String) obj;
            aVar.g();
            eVar.b(str, aVar.c(str));
        }
        ScheduledExecutorService scheduledExecutorService = eVar.f2889c;
        c cVar = new c(1);
        cVar.f2883f = eVar;
        VarHandle.storeStoreFence();
        scheduledExecutorService.schedule(cVar, 1800000L, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:248:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r19, java.util.ArrayList r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.service.e.b(java.lang.String, java.util.ArrayList):void");
    }

    public final void c(String str) {
        ua.c.a("a", "flushQueueInternalWhenEnvChanged, appKey: " + str);
        n6.a aVar = this.f2888b;
        aVar.g();
        b(str, aVar.c(str));
    }
}
