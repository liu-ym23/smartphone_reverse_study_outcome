package stepai.aios.guiagent.takeover;

import java.util.concurrent.ConcurrentHashMap;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import s9.C1923c;
import z2.l;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final stepai.aios.guiagent.session.a f6172a;
    public final stepai.aios.guiagent.pipeline.a b;
    public final C1923c c;
    public final ConcurrentHashMap d;
    public final ConcurrentHashMap e;
    public final kotlinx.coroutines.sync.a f;

    public b(stepai.aios.guiagent.session.a aVar, stepai.aios.guiagent.pipeline.a aVar2) {
        this.f6172a = aVar;
        this.b = aVar2;
        C1923c c1923cB = AbstractC1683A.b(l.H(AbstractC1683A.c(), AbstractC1691I.f5315a));
        this.c = c1923cB;
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new kotlinx.coroutines.sync.a();
        AbstractC1683A.n(c1923cB, null, new TakeoverSafetyManager$startCleanupTask$1(this, null), 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e0, code lost:
    
        if (r2.b(r15, r6) == r7) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(stepai.aios.guiagent.takeover.b r16, java.lang.String r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.b.a(stepai.aios.guiagent.takeover.b, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(stepai.aios.guiagent.takeover.b r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.b.b(stepai.aios.guiagent.takeover.b, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r9, boolean r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Operation completed for session: "
            boolean r1 = r11 instanceof stepai.aios.guiagent.takeover.TakeoverSafetyManager$completeOperation$1
            if (r1 == 0) goto L15
            r1 = r11
            stepai.aios.guiagent.takeover.TakeoverSafetyManager$completeOperation$1 r1 = (stepai.aios.guiagent.takeover.TakeoverSafetyManager$completeOperation$1) r1
            int r2 = r1.f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f = r2
            goto L1a
        L15:
            stepai.aios.guiagent.takeover.TakeoverSafetyManager$completeOperation$1 r1 = new stepai.aios.guiagent.takeover.TakeoverSafetyManager$completeOperation$1
            r1.<init>(r8, r11)
        L1a:
            java.lang.Object r11 = r1.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.f
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            boolean r10 = r1.c
            kotlinx.coroutines.sync.a r9 = r1.b
            java.lang.String r1 = r1.f6160a
            kotlin.b.b(r11)
            r11 = r9
            r9 = r1
            goto L4e
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.b.b(r11)
            r1.f6160a = r9
            kotlinx.coroutines.sync.a r11 = r8.f
            r1.b = r11
            r1.c = r10
            r1.f = r4
            java.lang.Object r1 = r11.lock(r5, r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            java.util.concurrent.ConcurrentHashMap r1 = r8.d     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.remove(r9)     // Catch: java.lang.Throwable -> L96
            Ea.e r1 = (Ea.e) r1     // Catch: java.lang.Throwable -> L96
            if (r1 == 0) goto L98
            r2 = 0
            r1.e = r2     // Catch: java.lang.Throwable -> L96
            java.util.concurrent.ConcurrentHashMap r8 = r8.e     // Catch: java.lang.Throwable -> L96
            java.lang.Object r8 = r8.remove(r9)     // Catch: java.lang.Throwable -> L96
            m9.c0 r8 = (m9.c0) r8     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L68
            r8.cancel(r5)     // Catch: java.lang.Throwable -> L96
        L68:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L96
            long r6 = r1.c     // Catch: java.lang.Throwable -> L96
            long r2 = r2 - r6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L96
            r8.append(r9)     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = ", success: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L96
            r8.append(r10)     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = ", duration: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L96
            r8.append(r2)     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = "ms"
            r8.append(r9)     // Catch: java.lang.Throwable -> L96
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = "TakeoverSafetyManager"
            N9.j.H(r8, r9)     // Catch: java.lang.Throwable -> L96
            goto L98
        L96:
            r8 = move-exception
            goto L9e
        L98:
            r11.unlock(r5)
            C7.r r8 = C7.r.f317a
            return r8
        L9e:
            r11.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.b.c(java.lang.String, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|76|(1:(1:(7:12|77|13|14|79|53|(3:55|56|57)(2:64|(3:66|72|73)(3:67|68|69)))(2:19|20))(1:21))(3:22|(1:25)|51)|80|26|(3:28|29|30)(5:37|(3:39|(1:44)(1:43)|(3:46|47|48))|49|(4:52|79|53|(0)(0))|51)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cd A[Catch: all -> 0x00dd, Exception -> 0x00df, TRY_LEAVE, TryCatch #6 {Exception -> 0x00df, all -> 0x00dd, blocks: (B:53:0x00c9, B:55:0x00cd, B:64:0x00e1, B:66:0x00e7, B:67:0x011f), top: B:79:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e1 A[Catch: all -> 0x00dd, Exception -> 0x00df, TRY_ENTER, TryCatch #6 {Exception -> 0x00df, all -> 0x00dd, blocks: (B:53:0x00c9, B:55:0x00cd, B:64:0x00e1, B:66:0x00e7, B:67:0x011f), top: B:79:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r2v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r5v6, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r23, kotlin.coroutines.jvm.internal.ContinuationImpl r24) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.b.d(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(8:12|80|13|14|15|83|54|(3:56|57|58)(2:65|(3:71|72|73)(4:69|70|76|77)))(2:20|21))(1:22))(3:23|(1:26)|52)|84|27|(3:29|30|31)(5:38|(3:40|(1:45)(1:44)|(3:47|48|49))|50|(5:53|15|83|54|(0)(0))|52)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db A[Catch: all -> 0x00ec, Exception -> 0x00ee, TRY_LEAVE, TryCatch #6 {Exception -> 0x00ee, all -> 0x00ec, blocks: (B:54:0x00d7, B:56:0x00db, B:65:0x00f0, B:67:0x00f6, B:69:0x00fa, B:71:0x0131), top: B:83:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f0 A[Catch: all -> 0x00ec, Exception -> 0x00ee, TRY_ENTER, TryCatch #6 {Exception -> 0x00ee, all -> 0x00ec, blocks: (B:54:0x00d7, B:56:0x00db, B:65:0x00f0, B:67:0x00f6, B:69:0x00fa, B:71:0x0131), top: B:83:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r23, java.lang.String r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.b.e(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
