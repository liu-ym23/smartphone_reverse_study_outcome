package com.stepos.ability.manager.cache;

import com.stepos.ability.api.ability.repository.IAtomicAbilityRepository;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b implements IAtomicAbilityRepository {

    /* renamed from: a, reason: collision with root package name */
    public final a f3133a;

    public b(a aVar) {
        this.f3133a = aVar;
    }

    @Override // com.stepos.ability.api.ability.repository.IAtomicAbilityRepository
    public final void addOnDataChangedListener(S7.a listener) {
        k.f(listener, "listener");
        this.f3133a.b(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ability.api.ability.repository.IAtomicAbilityRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAll(H7.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getAll$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getAll$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getAll$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getAll$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getAll$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f3127a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L3f
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            r0.c = r3
            com.stepos.ability.manager.cache.a r4 = r4.f3133a
            com.stepos.ability.database.dao.AtomicAbilityDao r4 = r4.b
            java.lang.Object r5 = r4.getAll(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r0 = 10
            int r0 = D7.w.c0(r5, r0)
            r4.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
        L50:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L64
            java.lang.Object r0 = r5.next()
            com.stepos.ability.database.entity.AtomicAbilityEntity r0 = (com.stepos.ability.database.entity.AtomicAbilityEntity) r0
            J3.a r0 = F1.a.g(r0)
            r4.add(r0)
            goto L50
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.b.getAll(H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ability.api.ability.repository.IAtomicAbilityRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getByAbilityId(int r6, H7.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByAbilityId$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByAbilityId$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByAbilityId$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByAbilityId$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByAbilityId$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f3128a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L30
            if (r2 != r4) goto L28
            kotlin.b.b(r7)
            goto L45
        L28:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L30:
            kotlin.b.b(r7)
            r0.c = r4
            if (r6 >= 0) goto L39
            r7 = r3
            goto L42
        L39:
            com.stepos.ability.manager.cache.a r5 = r5.f3133a
            com.stepos.ability.database.dao.AtomicAbilityDao r5 = r5.b
            java.lang.Object r5 = r5.getByAbilityId(r6, r0)
            r7 = r5
        L42:
            if (r7 != r1) goto L45
            return r1
        L45:
            com.stepos.ability.database.entity.AtomicAbilityEntity r7 = (com.stepos.ability.database.entity.AtomicAbilityEntity) r7
            if (r7 == 0) goto L4e
            J3.a r5 = F1.a.g(r7)
            return r5
        L4e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.b.getByAbilityId(int, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ability.api.ability.repository.IAtomicAbilityRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getByToolName(java.lang.String r5, H7.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByToolName$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByToolName$1 r0 = (com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByToolName$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByToolName$1 r0 = new com.stepos.ability.manager.cache.AtomicAbilityRepositoryAdapter$getByToolName$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f3129a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r6)
            goto L3f
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r6)
            r0.c = r3
            com.stepos.ability.manager.cache.a r4 = r4.f3133a
            com.stepos.ability.database.dao.AtomicAbilityDao r4 = r4.b
            java.lang.Object r6 = r4.getByToolName(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            com.stepos.ability.database.entity.AtomicAbilityEntity r6 = (com.stepos.ability.database.entity.AtomicAbilityEntity) r6
            if (r6 == 0) goto L48
            J3.a r4 = F1.a.g(r6)
            return r4
        L48:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.cache.b.getByToolName(java.lang.String, H7.c):java.lang.Object");
    }

    @Override // com.stepos.ability.api.ability.repository.IAtomicAbilityRepository
    public final void removeOnDataChangedListener(S7.a listener) {
        k.f(listener, "listener");
        a aVar = this.f3133a;
        synchronized (aVar.d) {
            aVar.d.remove(listener);
        }
    }
}
