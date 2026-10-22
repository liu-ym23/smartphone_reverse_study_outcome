package com.stepos.statsrpk.service;

import I.h;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class d extends h implements K2.b {

    /* renamed from: c, reason: collision with root package name */
    public V2.a f12381c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledExecutorService f12382d;

    public static void h(d dVar) {
        dVar.getClass();
        T2.d.a("a", "flushQueueInternalByTimer");
        V2.a aVar = dVar.f12381c;
        Iterator it = aVar.d().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            aVar.c();
            dVar.i(str, aVar.a(str));
        }
        dVar.f12382d.schedule(new c(dVar, 1), VehicleBluetoothManager.FAIL_START_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:281:0x06b7, code lost:
    
        if (r8 == false) goto L305;
     */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0646 A[Catch: JSONException -> 0x0677, TRY_ENTER, TryCatch #4 {JSONException -> 0x0677, blocks: (B:271:0x0646, B:276:0x067d), top: B:316:0x0644 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.String r18, java.util.ArrayList r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.service.d.i(java.lang.String, java.util.ArrayList):void");
    }

    public final void j(String str) {
        T2.d.a("a", "flushQueueInternalWhenEnvChanged, appKey: " + str);
        V2.a aVar = this.f12381c;
        aVar.c();
        i(str, aVar.a(str));
    }
}
