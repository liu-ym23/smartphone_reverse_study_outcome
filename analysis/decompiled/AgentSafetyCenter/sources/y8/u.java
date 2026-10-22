package y8;

import android.util.Log;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public qa.b f15999a;

    /* renamed from: b, reason: collision with root package name */
    public v3.p f16000b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.room.c f16001c;

    /* renamed from: d, reason: collision with root package name */
    public kc.t f16002d;

    /* renamed from: e, reason: collision with root package name */
    public xb.a f16003e;

    /* renamed from: f, reason: collision with root package name */
    public a f16004f;

    /* renamed from: g, reason: collision with root package name */
    public sc.c f16005g;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(boolean r11, pb.c r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof y8.r
            if (r0 == 0) goto L13
            r0 = r12
            y8.r r0 = (y8.r) r0
            int r1 = r0.f15988g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15988g = r1
            goto L18
        L13:
            y8.r r0 = new y8.r
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f15986c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f15988g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r12)     // Catch: java.lang.Throwable -> L8a
            goto L3a
        L27:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L2e:
            id.c.I(r12)
            r0.f15988g = r3     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r12 = r10.c(r11, r0)     // Catch: java.lang.Throwable -> L8a
            if (r12 != r1) goto L3a
            return r1
        L3a:
            y8.q r12 = (y8.q) r12     // Catch: java.lang.Throwable -> L8a
            boolean r10 = r12 instanceof y8.o     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L52
            y8.v r0 = new y8.v     // Catch: java.lang.Throwable -> L8a
            y8.o r12 = (y8.o) r12     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = r12.f15982a     // Catch: java.lang.Throwable -> L8a
            r7 = 0
            r8 = 124(0x7c, float:1.74E-43)
            r1 = 4
            r3 = 0
            r5 = 0
            r6 = 0
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L8a
            goto L90
        L52:
            boolean r10 = r12 instanceof y8.p     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L84
            y8.v r0 = new y8.v     // Catch: java.lang.Throwable -> L8a
            r10 = r12
            y8.p r10 = (y8.p) r10     // Catch: java.lang.Throwable -> L8a
            y8.n r10 = r10.f15983a     // Catch: java.lang.Throwable -> L8a
            long r3 = r10.f15980b     // Catch: java.lang.Throwable -> L8a
            r10 = r12
            y8.p r10 = (y8.p) r10     // Catch: java.lang.Throwable -> L8a
            boolean r5 = r10.f15984b     // Catch: java.lang.Throwable -> L8a
            r10 = r12
            y8.p r10 = (y8.p) r10     // Catch: java.lang.Throwable -> L8a
            boolean r6 = r10.f15985c     // Catch: java.lang.Throwable -> L8a
            y8.p r12 = (y8.p) r12     // Catch: java.lang.Throwable -> L8a
            y8.n r10 = r12.f15983a     // Catch: java.lang.Throwable -> L8a
            y8.e r10 = r10.f15979a     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L7c
            java.lang.String r7 = r10.a()     // Catch: java.lang.Throwable -> L8a
            r8 = 6
            r1 = 0
            r2 = 0
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L8a
            goto L90
        L7c:
            java.lang.String r10 = "Required value was null."
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L8a
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L8a
            throw r11     // Catch: java.lang.Throwable -> L8a
        L84:
            androidx.fragment.app.d r10 = new androidx.fragment.app.d     // Catch: java.lang.Throwable -> L8a
            r10.<init>()     // Catch: java.lang.Throwable -> L8a
            throw r10     // Catch: java.lang.Throwable -> L8a
        L8a:
            r0 = move-exception
            r10 = r0
            jb.h r0 = id.c.l(r10)
        L90:
            java.lang.Throwable r10 = jb.i.b(r0)
            if (r10 != 0) goto L97
            goto Lae
        L97:
            y8.v r1 = new y8.v
            java.lang.String r10 = r10.getMessage()
            if (r10 != 0) goto La1
            java.lang.String r10 = ""
        La1:
            r3 = r10
            r8 = 0
            r9 = 124(0x7c, float:1.74E-43)
            r2 = 6
            r4 = 0
            r6 = 0
            r7 = 0
            r1.<init>(r2, r3, r4, r6, r7, r8, r9)
            r0 = r1
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.u.a(boolean, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(pb.c r12) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.u.b(pb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4 A[Catch: all -> 0x0049, PHI: r2 r12 r13
      0x00e4: PHI (r2v11 ??) = (r2v16 ??), (r2v17 ??) binds: [B:47:0x00e1, B:18:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x00e4: PHI (r12v7 boolean) = (r12v6 boolean), (r12v17 boolean) binds: [B:47:0x00e1, B:18:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x00e4: PHI (r13v11 java.lang.Object) = (r13v10 java.lang.Object), (r13v1 java.lang.Object) binds: [B:47:0x00e1, B:18:0x0044] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:18:0x0044, B:49:0x00e4, B:46:0x00d3), top: B:67:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, y8.u] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [sc.a] */
    /* JADX WARN: Type inference failed for: r2v11, types: [sc.a] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(boolean r12, pb.c r13) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.u.c(boolean, pb.c):java.lang.Object");
    }

    public final q d(String str) {
        Object objL;
        a aVar = this.f16004f;
        e eVar = aVar.f15940d;
        if (eVar == null) {
            synchronized (aVar) {
                try {
                    eVar = aVar.f15940d;
                    if (eVar == null) {
                        try {
                            objL = aVar.a();
                        } catch (Throwable th) {
                            objL = id.c.l(th);
                        }
                        Throwable thB = jb.i.b(objL);
                        if (thB != null) {
                            Log.w("LedgerSeed", "load seed failed: " + thB.getMessage(), thB);
                        }
                        if (objL instanceof jb.h) {
                            objL = null;
                        }
                        eVar = (e) objL;
                        if (eVar != null) {
                            aVar.f15940d = eVar;
                        } else {
                            eVar = null;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (eVar != null) {
            return new p(new n(eVar, 0L, false), true, true);
        }
        o oVar = new o();
        oVar.f15982a = str;
        VarHandle.storeStoreFence();
        return oVar;
    }
}
