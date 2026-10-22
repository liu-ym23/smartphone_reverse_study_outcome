package com.stepos.ability.manager.cache;

import D7.v;
import F.i;
import android.content.Context;
import com.stepos.ability.database.AppDatabase;
import com.stepos.ability.database.dao.AtomicAbilityDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    public static final i e = new i();
    public static volatile a f;

    /* renamed from: a, reason: collision with root package name */
    public final AppDatabase f3132a;
    public final AtomicAbilityDao b;
    public final kotlinx.coroutines.sync.a c;
    public final ArrayList d;

    public a(Context context) {
        AppDatabase appDatabaseB = AppDatabase.Companion.b(context);
        this.f3132a = appDatabaseB;
        this.b = appDatabaseB.atomicAbilityDao();
        this.c = new kotlinx.coroutines.sync.a();
        this.d = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.manager.cache.a r40, com.stepos.ability.net.biz.model.AppItem r41, kotlin.coroutines.jvm.internal.ContinuationImpl r42) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.a.a(com.stepos.ability.manager.cache.a, com.stepos.ability.net.biz.model.AppItem, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b(S7.a aVar) {
        synchronized (this.d) {
            this.d.add(aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v3, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepository$deleteByPackageName$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ability.manager.cache.AtomicAbilityRepository$deleteByPackageName$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepository$deleteByPackageName$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepository$deleteByPackageName$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepository$deleteByPackageName$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            w9.a r7 = r0.b
            java.lang.String r0 = r0.f3116a
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L2f
            goto L6e
        L2f:
            r6 = move-exception
            goto L8c
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            int r7 = r0.c
            w9.a r2 = r0.b
            java.lang.String r4 = r0.f3116a
            kotlin.b.b(r8)
            r8 = r2
            r2 = r7
            r7 = r4
            goto L5b
        L46:
            kotlin.b.b(r8)
            r0.f3116a = r7
            kotlinx.coroutines.sync.a r8 = r6.c
            r0.b = r8
            r2 = 0
            r0.c = r2
            r0.f = r4
            java.lang.Object r4 = r8.lock(r5, r0)
            if (r4 != r1) goto L5b
            goto L6b
        L5b:
            com.stepos.ability.database.dao.AtomicAbilityDao r4 = r6.b     // Catch: java.lang.Throwable -> L8a
            r0.f3116a = r7     // Catch: java.lang.Throwable -> L8a
            r0.b = r8     // Catch: java.lang.Throwable -> L8a
            r0.c = r2     // Catch: java.lang.Throwable -> L8a
            r0.f = r3     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r0 = r4.deleteByPackageName(r7, r0)     // Catch: java.lang.Throwable -> L8a
            if (r0 != r1) goto L6c
        L6b:
            return r1
        L6c:
            r0 = r7
            r7 = r8
        L6e:
            r7.unlock(r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "deleteByPackageName: "
            r7.<init>(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "AtomicAbilityRepository"
            android.util.Log.i(r8, r7)
            r6.f()
            C7.r r6 = C7.r.f317a
            return r6
        L8a:
            r6 = move-exception
            r7 = r8
        L8c:
            r7.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.a.c(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepository$hasData$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ability.manager.cache.AtomicAbilityRepository$hasData$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepository$hasData$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepository$hasData$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepository$hasData$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3117a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            r0.c = r3
            com.stepos.ability.database.dao.AtomicAbilityDao r4 = r4.b
            java.lang.Object r5 = r4.count(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.Number r5 = (java.lang.Number) r5
            int r4 = r5.intValue()
            if (r4 <= 0) goto L46
            goto L47
        L46:
            r3 = 0
        L47:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.a.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(4:(1:(6:14|58|15|16|50|51)(2:19|20))(14:21|62|22|23|24|56|36|(1:38)|39|(2:42|40)|64|46|(3:49|50|51)|48)|18|54|55)(1:27))(3:28|(1:31)|48)|60|32|(10:35|24|56|36|(0)|39|(1:40)|64|46|(0))|48|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0184, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb A[Catch: all -> 0x0120, LOOP:0: B:40:0x00f5->B:42:0x00fb, LOOP_END, TryCatch #0 {all -> 0x0120, blocks: (B:36:0x00db, B:39:0x00ec, B:40:0x00f5, B:42:0x00fb, B:46:0x0124), top: B:56:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.util.List r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.a.e(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void f() {
        List listF1;
        synchronized (this.d) {
            listF1 = v.f1(this.d);
        }
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            ((S7.a) it.next()).invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v3, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.util.List r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            w9.a r8 = r0.b
            java.util.List r0 = r0.f3122a
            java.util.List r0 = (java.util.List) r0
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L31
            goto L79
        L31:
            r7 = move-exception
            goto L84
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            int r8 = r0.c
            w9.a r2 = r0.b
            java.util.List r4 = r0.f3122a
            java.util.List r4 = (java.util.List) r4
            kotlin.b.b(r9)
            r9 = r2
            r2 = r8
            r8 = r4
            goto L62
        L4a:
            kotlin.b.b(r9)
            r9 = r8
            java.util.List r9 = (java.util.List) r9
            r0.f3122a = r9
            kotlinx.coroutines.sync.a r9 = r7.c
            r0.b = r9
            r2 = 0
            r0.c = r2
            r0.f = r4
            java.lang.Object r4 = r9.lock(r5, r0)
            if (r4 != r1) goto L62
            goto L77
        L62:
            com.stepos.ability.database.AppDatabase r4 = r7.f3132a     // Catch: java.lang.Throwable -> L82
            com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$2$1 r6 = new com.stepos.ability.manager.cache.AtomicAbilityRepository$saveFullScan$2$1     // Catch: java.lang.Throwable -> L82
            r6.<init>(r8, r7, r5)     // Catch: java.lang.Throwable -> L82
            r0.f3122a = r5     // Catch: java.lang.Throwable -> L82
            r0.b = r9     // Catch: java.lang.Throwable -> L82
            r0.c = r2     // Catch: java.lang.Throwable -> L82
            r0.f = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r8 = androidx.room.RoomDatabaseKt.withTransaction(r4, r6, r0)     // Catch: java.lang.Throwable -> L82
            if (r8 != r1) goto L78
        L77:
            return r1
        L78:
            r8 = r9
        L79:
            r8.unlock(r5)
            r7.f()
            C7.r r7 = C7.r.f317a
            return r7
        L82:
            r7 = move-exception
            r8 = r9
        L84:
            r8.unlock(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.a.g(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(com.stepos.ability.net.biz.model.AppItem r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.g
            C7.r r3 = C7.r.f317a
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L48
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            w9.a r11 = r0.c
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L2f
            goto L86
        L2f:
            r10 = move-exception
            goto L94
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            int r11 = r0.d
            w9.a r2 = r0.c
            java.lang.String r5 = r0.b
            com.stepos.ability.net.biz.model.AppItem r7 = r0.f3124a
            kotlin.b.b(r12)
            r9 = r7
            r7 = r11
            r11 = r9
            goto L6d
        L48:
            kotlin.b.b(r12)
            java.lang.String r12 = r11.getPackageName()
            if (r12 == 0) goto L98
            boolean r2 = j9.m.s0(r12)
            if (r2 == 0) goto L58
            goto L98
        L58:
            r0.f3124a = r11
            r0.b = r12
            kotlinx.coroutines.sync.a r2 = r10.c
            r0.c = r2
            r7 = 0
            r0.d = r7
            r0.g = r5
            java.lang.Object r5 = r2.lock(r6, r0)
            if (r5 != r1) goto L6c
            goto L84
        L6c:
            r5 = r12
        L6d:
            com.stepos.ability.database.AppDatabase r12 = r10.f3132a     // Catch: java.lang.Throwable -> L92
            com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$2$1 r8 = new com.stepos.ability.manager.cache.AtomicAbilityRepository$syncPackage$2$1     // Catch: java.lang.Throwable -> L92
            r8.<init>(r10, r11, r5, r6)     // Catch: java.lang.Throwable -> L92
            r0.f3124a = r6     // Catch: java.lang.Throwable -> L92
            r0.b = r6     // Catch: java.lang.Throwable -> L92
            r0.c = r2     // Catch: java.lang.Throwable -> L92
            r0.d = r7     // Catch: java.lang.Throwable -> L92
            r0.g = r4     // Catch: java.lang.Throwable -> L92
            java.lang.Object r12 = androidx.room.RoomDatabaseKt.withTransaction(r12, r8, r0)     // Catch: java.lang.Throwable -> L92
            if (r12 != r1) goto L85
        L84:
            return r1
        L85:
            r11 = r2
        L86:
            java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> L2f
            r12.intValue()     // Catch: java.lang.Throwable -> L2f
            r11.unlock(r6)
            r10.f()
            return r3
        L92:
            r10 = move-exception
            r11 = r2
        L94:
            r11.unlock(r6)
            throw r10
        L98:
            java.lang.String r10 = "AtomicAbilityRepository"
            java.lang.String r11 = "syncPackage: packageName is null, skip."
            android.util.Log.w(r10, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.a.h(com.stepos.ability.net.biz.model.AppItem, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
