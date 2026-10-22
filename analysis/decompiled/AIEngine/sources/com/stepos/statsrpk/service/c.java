package com.stepos.statsrpk.service;

import com.stepos.core.ota.process.OtaIdleExitPolicy;
import com.stepos.statsapp.v3.lib.plugin.emitter.d;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import ka.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends d implements a.c {

    /* renamed from: b, reason: collision with root package name */
    public androidx.preference.c f8102b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f8103c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8104a;

        public a(String str) {
            this.f8104a = str;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            String str = this.f8104a;
            ta.c.a("a", "environmentChanged. changeName: ".concat(str));
            c cVar = c.this;
            ArrayList arrayListG = cVar.f8102b.g();
            int i10 = 0;
            if ("CHANGE_NAME_NETWORKCONNECT".equals(str)) {
                int size = arrayListG.size();
                while (i10 < size) {
                    Object obj = arrayListG.get(i10);
                    i10++;
                    cVar.d((String) obj);
                }
                return;
            }
            if ("CHANGE_NAME_POWER".equals(str)) {
                int size2 = arrayListG.size();
                while (i10 < size2) {
                    Object obj2 = arrayListG.get(i10);
                    i10++;
                    cVar.d((String) obj2);
                }
            }
        }
    }

    public static void b(c cVar) {
        ta.c.a("a", "flushQueueInternalByTimer");
        androidx.preference.c cVar2 = cVar.f8102b;
        ArrayList arrayListG = cVar2.g();
        int size = arrayListG.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListG.get(i10);
            i10++;
            String str = (String) obj;
            cVar2.f();
            cVar.c(str, cVar2.d(str));
        }
        cVar.f8103c.schedule(new com.stepos.statsrpk.service.a(cVar, 1), OtaIdleExitPolicy.TERMINAL_IDLE_MS, TimeUnit.MILLISECONDS);
    }

    @Override // ka.a.c
    public final void a(String str) {
        this.f8103c.execute(new a(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:248:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0549 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.String r19, java.util.ArrayList<com.stepos.statsapp.v3.lib.plugin.emitter.a> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.service.c.c(java.lang.String, java.util.ArrayList):void");
    }

    public final void d(String str) throws Throwable {
        ta.c.a("a", "flushQueueInternalWhenEnvChanged, appKey: " + str);
        androidx.preference.c cVar = this.f8102b;
        cVar.f();
        c(str, cVar.d(str));
    }
}
