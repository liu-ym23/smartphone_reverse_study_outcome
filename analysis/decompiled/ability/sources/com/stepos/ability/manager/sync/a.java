package com.stepos.ability.manager.sync;

import android.content.Context;
import android.util.Log;
import com.stepos.ability.net.INet;
import d4.d;
import j9.m;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1724q;
import m9.q0;
import m9.r0;
import s9.C1923c;
import u9.c;
import z2.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final INet f3162a;
    public final d b;
    public final C1923c c;
    public final AtomicReference d;
    public final AtomicReference e;
    public final AtomicReference f;
    public final kotlinx.coroutines.sync.a g;
    public C1724q h;
    public q0 i;

    /* renamed from: j, reason: collision with root package name */
    public q0 f3163j;
    public int k;
    public String l;
    public com.stepos.ability.manager.discovery.a m;
    public String n;

    public a(INet iNet, d dVar) {
        k.f(iNet, "iNet");
        this.f3162a = iNet;
        this.b = dVar;
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar2 = AbstractC1691I.f5315a;
        this.c = AbstractC1683A.b(l.H(r0VarC, c.f6743a));
        this.d = new AtomicReference(SyncPhase.f3161a);
        Boolean bool = Boolean.FALSE;
        this.e = new AtomicReference(bool);
        this.f = new AtomicReference(bool);
        this.g = new kotlinx.coroutines.sync.a();
        this.l = "";
        this.n = "";
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0072: MOVE (r14 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:28:0x0071 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[PHI: r0 r5 r6 r8 r13 r14
      0x006c: PHI (r0v25 java.lang.Object) = (r0v32 java.lang.Object), (r0v1 java.lang.Object) binds: [B:91:0x0192, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r5v9 int) = (r5v11 int), (r5v16 int) binds: [B:91:0x0192, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r6v5 java.util.List) = (r6v6 java.util.List), (r6v14 java.util.List) binds: [B:91:0x0192, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r8v10 java.lang.String) = (r8v12 java.lang.String), (r8v16 java.lang.String) binds: [B:91:0x0192, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r13v10 java.lang.String) = (r13v11 java.lang.String), (r13v16 java.lang.String) binds: [B:91:0x0192, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x006c: PHI (r14v7 android.content.Context) = (r14v8 android.content.Context), (r14v13 android.content.Context) binds: [B:91:0x0192, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122 A[Catch: Exception -> 0x0137, TryCatch #4 {Exception -> 0x0137, blocks: (B:100:0x01d1, B:104:0x01e6, B:93:0x0195, B:90:0x017c, B:63:0x011e, B:65:0x0122, B:70:0x012d, B:81:0x014d, B:83:0x0153, B:85:0x0159, B:87:0x0162, B:59:0x0112), top: B:115:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014d A[Catch: Exception -> 0x0137, TryCatch #4 {Exception -> 0x0137, blocks: (B:100:0x01d1, B:104:0x01e6, B:93:0x0195, B:90:0x017c, B:63:0x011e, B:65:0x0122, B:70:0x012d, B:81:0x014d, B:83:0x0153, B:85:0x0159, B:87:0x0162, B:59:0x0112), top: B:115:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0159 A[Catch: Exception -> 0x0137, TryCatch #4 {Exception -> 0x0137, blocks: (B:100:0x01d1, B:104:0x01e6, B:93:0x0195, B:90:0x017c, B:63:0x011e, B:65:0x0122, B:70:0x012d, B:81:0x014d, B:83:0x0153, B:85:0x0159, B:87:0x0162, B:59:0x0112), top: B:115:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0162 A[Catch: Exception -> 0x0137, TryCatch #4 {Exception -> 0x0137, blocks: (B:100:0x01d1, B:104:0x01e6, B:93:0x0195, B:90:0x017c, B:63:0x011e, B:65:0x0122, B:70:0x012d, B:81:0x014d, B:83:0x0153, B:85:0x0159, B:87:0x0162, B:59:0x0112), top: B:115:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.manager.sync.a r31, android.content.Context r32, kotlin.coroutines.jvm.internal.ContinuationImpl r33) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.sync.a.a(com.stepos.ability.manager.sync.a, android.content.Context, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:4|(1:6)(1:7))(0)|8|(1:108)|(6:(1:(1:(1:(10:14|92|15|16|17|73|74|75|81|82)(2:23|24))(8:25|98|26|27|67|57|68|(1:70)(4:78|(1:80)|81|82)))(12:30|102|31|32|104|53|54|94|55|(2:58|(4:60|57|68|(0)(0))(2:63|(2:65|72)(5:66|67|57|68|(0)(0))))(3:57|68|(0)(0))|81|82))(4:35|100|36|37)|20|21|22|90|91)(2:40|(2:42|43)(4:106|44|(1:46)|72))|47|48|96|49|(9:52|104|53|54|94|55|(0)(0)|81|82)|72|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
    
        if (r1.b(r4, r5) == r7) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01bc, code lost:
    
        r17 = r6;
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012d A[PHI: r4 r8 r9 r11 r12 r14 r16 r17 r23
      0x012d: PHI (r4v4 boolean) = (r4v2 boolean), (r4v2 boolean), (r4v9 boolean) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r8v5 Z3.a) = (r8v4 Z3.a), (r8v4 Z3.a), (r8v6 Z3.a) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r9v2 long) = (r9v1 long), (r9v1 long), (r9v3 long) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r11v6 android.content.Context) = (r11v5 android.content.Context), (r11v5 android.content.Context), (r11v7 android.content.Context) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r12v3 long) = (r12v2 long), (r12v2 long), (r12v4 long) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r14v10 m9.q) = (r14v35 m9.q), (r14v36 m9.q), (r14v37 m9.q) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r16v7 C7.r) = (r16v5 C7.r), (r16v5 C7.r), (r16v8 C7.r) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r17v8 java.util.concurrent.atomic.AtomicReference) = 
      (r17v6 java.util.concurrent.atomic.AtomicReference)
      (r17v6 java.util.concurrent.atomic.AtomicReference)
      (r17v9 java.util.concurrent.atomic.AtomicReference)
     binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r23v3 M0.h) = (r23v2 M0.h), (r23v2 M0.h), (r23v4 M0.h) binds: [B:56:0x012b, B:60:0x0137, B:67:0x0159] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012f A[Catch: Exception -> 0x013d, TryCatch #1 {Exception -> 0x013d, blocks: (B:67:0x0159, B:68:0x0161, B:70:0x016c, B:55:0x010f, B:58:0x012f, B:60:0x0137, B:63:0x0140), top: B:94:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016c A[Catch: Exception -> 0x013d, TryCatch #1 {Exception -> 0x013d, blocks: (B:67:0x0159, B:68:0x0161, B:70:0x016c, B:55:0x010f, B:58:0x012f, B:60:0x0137, B:63:0x0140), top: B:94:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a3 A[Catch: Exception -> 0x01a1, TryCatch #8 {Exception -> 0x01a1, blocks: (B:75:0x019d, B:81:0x01ad, B:78:0x01a3, B:80:0x01a8), top: B:108:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18, types: [m9.p] */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r2v15, types: [m9.p] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.concurrent.atomic.AtomicReference] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r8v10, types: [m9.p] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(com.stepos.ability.manager.sync.a r20, android.content.Context r21, m9.C1724q r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.sync.a.b(com.stepos.ability.manager.sync.a, android.content.Context, m9.q, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.content.Context r5, long r6, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$1 r0 = (com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$1 r0 = new com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f3150a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r8)
            goto L57
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r8)
            java.util.concurrent.atomic.AtomicReference r8 = r4.d
            java.lang.Object r8 = r8.get()
            com.stepos.ability.manager.sync.SyncPhase r2 = com.stepos.ability.manager.sync.SyncPhase.f3161a
            if (r8 == r2) goto L3f
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L3f:
            m9.q r8 = r4.h
            if (r8 != 0) goto L48
            java.lang.String r8 = "awaitLocalReady"
            r4.l(r5, r8)
        L48:
            com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$2 r5 = new com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$2
            r8 = 0
            r5.<init>(r4, r8)
            r0.c = r3
            java.lang.Object r8 = kotlinx.coroutines.a.p(r6, r5, r0)
            if (r8 != r1) goto L57
            return r1
        L57:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L60
            boolean r4 = r8.booleanValue()
            goto L61
        L60:
            r4 = 0
        L61:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.sync.a.c(android.content.Context, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void d() {
        q0 q0Var = this.i;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        q0 q0Var2 = this.f3163j;
        if (q0Var2 != null) {
            q0Var2.cancel(null);
        }
        this.k = 0;
        this.l = "";
    }

    public final SyncPhase e() {
        Object obj = this.d.get();
        k.e(obj, "get(...)");
        return (SyncPhase) obj;
    }

    public final void f(Context context) {
        AtomicReference atomicReference = this.d;
        if (atomicReference.get() == SyncPhase.c) {
            atomicReference.set(SyncPhase.b);
            Log.i("AbilitySyncCoordinator", "onLocalDatabaseChanged: downgrade CLOUD_READY -> LOCAL_READY");
        }
        AbstractC1683A.n(this.c, null, new AbilitySyncCoordinator$onLocalDatabaseChanged$1(context, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(android.content.Context r9, boolean r10, java.lang.String r11, boolean r12) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.k.f(r9, r0)
            java.util.concurrent.atomic.AtomicReference r0 = r8.e
            java.util.concurrent.atomic.AtomicReference r1 = r8.d
            if (r10 == 0) goto L7b
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r0.set(r10)
            java.util.concurrent.atomic.AtomicReference r0 = r8.f
            r0.set(r10)
            com.stepos.ability.manager.sync.AbilitySyncCoordinator$onPackageUploadFinished$1 r10 = new com.stepos.ability.manager.sync.AbilitySyncCoordinator$onPackageUploadFinished$1
            r0 = 0
            r10.<init>(r9, r0)
            r2 = 3
            s9.c r3 = r8.c
            m9.AbstractC1683A.n(r3, r0, r10, r2)
            java.lang.Object r10 = r1.get()
            com.stepos.ability.manager.sync.SyncPhase r2 = com.stepos.ability.manager.sync.SyncPhase.c
            if (r10 == r2) goto L2e
            com.stepos.ability.manager.sync.SyncPhase r10 = com.stepos.ability.manager.sync.SyncPhase.b
            r1.set(r10)
        L2e:
            java.lang.String r10 = ""
            if (r12 == 0) goto L3e
            if (r11 == 0) goto L3c
            java.lang.CharSequence r11 = j9.m.R0(r11)
            java.lang.String r0 = r11.toString()
        L3c:
            if (r0 != 0) goto L40
        L3e:
            r6 = r10
            goto L41
        L40:
            r6 = r0
        L41:
            int r10 = r6.length()
            if (r10 != 0) goto L4a
            java.lang.String r10 = "<full>"
            goto L4b
        L4a:
            r10 = r6
        L4b:
            java.lang.Object r11 = r1.get()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "onPackageUploadFinished: incrementalCloudSync="
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r12 = " appNameFilter="
            r0.append(r12)
            r0.append(r10)
            java.lang.String r10 = " phase="
            r0.append(r10)
            r0.append(r11)
            java.lang.String r10 = r0.toString()
            java.lang.String r11 = "AbilitySyncCoordinator"
            android.util.Log.i(r11, r10)
            r4 = 500(0x1f4, double:2.47E-321)
            r7 = 1
            r2 = r8
            r3 = r9
            r2.k(r3, r4, r6, r7)
            return
        L7b:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r0.set(r8)
            java.lang.Object r8 = r1.get()
            com.stepos.ability.manager.sync.SyncPhase r9 = com.stepos.ability.manager.sync.SyncPhase.c
            if (r8 != r9) goto L8d
            com.stepos.ability.manager.sync.SyncPhase r8 = com.stepos.ability.manager.sync.SyncPhase.b
            r1.set(r8)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.sync.a.g(android.content.Context, boolean, java.lang.String, boolean):void");
    }

    public final void h(Context context) {
        k.f(context, "context");
        Log.i("AbilitySyncCoordinator", "onUserLoggedOut: reset sync session, keep local Room");
        d();
        this.d.set(SyncPhase.f3161a);
        Boolean bool = Boolean.FALSE;
        this.e.set(bool);
        this.f.set(bool);
        AbstractC1683A.n(this.c, null, new AbilitySyncCoordinator$onUserLoggedOut$1(context, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(android.content.Context r11, java.lang.String r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.sync.a.i(android.content.Context, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void j(Context context) {
        int i = this.k;
        int i6 = i + 1;
        this.k = i6;
        if (i6 >= 5) {
            String str = this.l;
            if (str.length() == 0) {
                str = "<full>";
            }
            Log.e("AbilitySyncCoordinator", "runCloudSyncPipeline: give up after 5 attempts, appNameFilter=" + ((Object) str) + "; wait for network/full rescan");
            return;
        }
        long j5 = (1 << (i < 0 ? 0 : i)) * 5000;
        long j6 = j5 > 60000 ? 60000L : j5;
        Log.w("AbilitySyncCoordinator", "runCloudSyncPipeline: retry " + (i + 2) + "/5 after " + j6 + "ms");
        k(context, j6, this.l, false);
    }

    public final void k(Context context, long j5, String appNameFilter, boolean z10) {
        k.f(context, "context");
        k.f(appNameFilter, "appNameFilter");
        if (!this.b.a()) {
            Log.i("AbilitySyncCoordinator", "scheduleCloudSync skipped: no auth token");
            return;
        }
        if (!((Boolean) this.e.get()).booleanValue()) {
            Log.i("AbilitySyncCoordinator", "scheduleCloudSync skipped: upload not successful.");
            return;
        }
        if (this.d.get() == SyncPhase.c) {
            return;
        }
        if (z10) {
            this.k = 0;
            this.l = m.R0(appNameFilter).toString();
        }
        q0 q0Var = this.f3163j;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        this.f3163j = AbstractC1683A.n(this.c, null, new AbilitySyncCoordinator$scheduleCloudSync$1(j5, this, context, null), 3);
    }

    public final void l(Context context, String str) {
        k.f(context, "context");
        AbstractC1683A.n(this.c, null, new AbilitySyncCoordinator$startFullRescan$1(this, str, context, null), 3);
    }
}
