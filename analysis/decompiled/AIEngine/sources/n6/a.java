package n6;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10642a = new a();

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.lang.String r9, java.util.Map r10) {
        /*
            java.lang.String r0 = "onEventRealtime "
            com.stepos.aiengine.usagestats.UsageStatsBootstrap r1 = com.stepos.aiengine.usagestats.UsageStatsBootstrap.f5934a
            r1.getClass()
            java.util.concurrent.atomic.AtomicBoolean r1 = com.stepos.aiengine.usagestats.UsageStatsBootstrap.f5935b
            boolean r1 = r1.get()
            java.lang.String r2 = "UsageStatsReporter"
            if (r1 != 0) goto L2a
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.SYSTEM
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "skip "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = ": SDK not initialized (CTA not granted?)"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.stepos.core.common.log.AIEngineLogger.i(r10, r2, r9)
            return
        L2a:
            boolean r1 = ea.a.f8623c     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L67
            java.lang.String r6 = "model_manager"
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L39
            r5 = r9
            r7 = r10
            goto L45
        L39:
            la.c r1 = la.c.a.f10391a     // Catch: java.lang.Throwable -> L64
            ha.c r3 = r1.f10389g     // Catch: java.lang.Throwable -> L64
            android.app.Application r4 = r1.f10383a     // Catch: java.lang.Throwable -> L64
            r8 = 2
            r5 = r9
            r7 = r10
            r3.a(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L61
        L45:
            com.stepos.core.common.log.LogModule r9 = com.stepos.core.common.log.LogModule.SYSTEM     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L61
            r10.append(r5)     // Catch: java.lang.Throwable -> L61
            java.lang.String r0 = " props="
            r10.append(r0)     // Catch: java.lang.Throwable -> L61
            r10.append(r7)     // Catch: java.lang.Throwable -> L61
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L61
            com.stepos.core.common.log.AIEngineLogger.i(r9, r2, r10)     // Catch: java.lang.Throwable -> L61
            lb.n r9 = lb.n.f10413a     // Catch: java.lang.Throwable -> L61
            goto L74
        L61:
            r0 = move-exception
        L62:
            r9 = r0
            goto L70
        L64:
            r0 = move-exception
            r5 = r9
            goto L62
        L67:
            r5 = r9
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L61
            java.lang.String r10 = "UsageStatsProxy3 is not initialised - invoke at least once with parameterised init"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L61
            throw r9     // Catch: java.lang.Throwable -> L61
        L70:
            kotlin.Result$Failure r9 = kotlin.c.a(r9)
        L74:
            java.lang.Throwable r9 = kotlin.Result.b(r9)
            if (r9 == 0) goto L8b
            com.stepos.core.common.log.LogModule r10 = com.stepos.core.common.log.LogModule.SYSTEM
            java.lang.String r0 = "report "
            java.lang.String r1 = " failed"
            java.lang.String r0 = a0.a.k(r0, r5, r1)
            java.lang.Object[] r9 = new java.lang.Object[]{r0, r9}
            com.stepos.core.common.log.AIEngineLogger.w(r10, r2, r9)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n6.a.a(java.lang.String, java.util.Map):void");
    }
}
