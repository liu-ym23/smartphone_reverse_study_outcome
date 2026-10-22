package com.stepos.ability.manager.cache;

import M0.h;
import android.content.Context;
import com.stepos.ability.database.AppDatabase;
import com.stepos.ability.database.dao.SyncCacheMetaDao;

/* loaded from: classes3.dex */
public final class c {
    public static final h b = new h(6);
    public static volatile c c;

    /* renamed from: a, reason: collision with root package name */
    public final SyncCacheMetaDao f3134a;

    public c(Context context) {
        this.f3134a = AppDatabase.Companion.b(context).syncCacheMetaDao();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.ability.manager.cache.SyncCacheMetaRepository$get$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ability.manager.cache.SyncCacheMetaRepository$get$1 r0 = (com.stepos.ability.manager.cache.SyncCacheMetaRepository$get$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.SyncCacheMetaRepository$get$1 r0 = new com.stepos.ability.manager.cache.SyncCacheMetaRepository$get$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 0
            com.stepos.ability.database.dao.SyncCacheMetaDao r6 = r6.f3134a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            com.stepos.ability.database.entity.SyncCacheMetaEntity r6 = r0.f3130a
            kotlin.b.b(r7)
            return r6
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.b.b(r7)
            goto L48
        L3b:
            kotlin.b.b(r7)
            r0.d = r5
            r7 = 0
            java.lang.Object r7 = com.stepos.ability.database.dao.SyncCacheMetaDao.getById$default(r6, r3, r0, r5, r7)
            if (r7 != r1) goto L48
            goto L5b
        L48:
            com.stepos.ability.database.entity.SyncCacheMetaEntity r7 = (com.stepos.ability.database.entity.SyncCacheMetaEntity) r7
            if (r7 != 0) goto L5c
            com.stepos.ability.database.entity.SyncCacheMetaEntity r7 = new com.stepos.ability.database.entity.SyncCacheMetaEntity
            r7.<init>(r3)
            r0.f3130a = r7
            r0.d = r4
            java.lang.Object r6 = r6.insertOrReplace(r7, r0)
            if (r6 != r1) goto L5c
        L5b:
            return r1
        L5c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.c.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(S7.k r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ability.manager.cache.SyncCacheMetaRepository$update$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ability.manager.cache.SyncCacheMetaRepository$update$1 r0 = (com.stepos.ability.manager.cache.SyncCacheMetaRepository$update$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.SyncCacheMetaRepository$update$1 r0 = new com.stepos.ability.manager.cache.SyncCacheMetaRepository$update$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            com.stepos.ability.database.entity.SyncCacheMetaEntity r5 = r0.b
            kotlin.b.b(r7)
            return r5
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            S7.k r6 = r0.f3131a
            kotlin.b.b(r7)
            goto L48
        L3a:
            kotlin.b.b(r7)
            r0.f3131a = r6
            r0.e = r4
            java.lang.Object r7 = r5.a(r0)
            if (r7 != r1) goto L48
            goto L64
        L48:
            com.stepos.ability.database.entity.SyncCacheMetaEntity r7 = (com.stepos.ability.database.entity.SyncCacheMetaEntity) r7
            java.lang.Object r6 = r6.invoke(r7)
            com.stepos.ability.database.entity.SyncCacheMetaEntity r6 = (com.stepos.ability.database.entity.SyncCacheMetaEntity) r6
            r7 = 0
            r0.f3131a = r7
            r0.b = r6
            r0.e = r3
            com.stepos.ability.database.dao.SyncCacheMetaDao r5 = r5.f3134a
            java.lang.Object r5 = r5.insertOrReplace(r6, r0)
            if (r5 != r1) goto L60
            goto L62
        L60:
            C7.r r5 = C7.r.f317a
        L62:
            if (r5 != r1) goto L65
        L64:
            return r1
        L65:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.c.b(S7.k, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
