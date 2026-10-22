package com.stepos.ability.mcpserver.search;

import C7.r;
import com.stepos.ability.api.ability.repository.IAtomicAbilityRepository;
import j4.C1598c;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import s9.C1923c;
import u9.c;
import u9.d;
import z2.l;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final IAtomicAbilityRepository f3198a;
    public final C1923c b;
    public final C1598c c;
    public final a d;

    /* JADX WARN: Type inference failed for: r2v5, types: [com.stepos.ability.mcpserver.search.a] */
    public b(IAtomicAbilityRepository repository) {
        k.f(repository, "repository");
        this.f3198a = repository;
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.b = AbstractC1683A.b(l.H(r0VarC, c.f6743a));
        C1598c c1598c = new C1598c();
        c1598c.f4774a = kotlin.collections.a.M();
        c1598c.b = kotlin.collections.a.M();
        c1598c.e = kotlin.collections.a.M();
        c1598c.f = kotlin.collections.a.M();
        this.c = c1598c;
        this.d = new S7.a() { // from class: com.stepos.ability.mcpserver.search.a
            @Override // S7.a
            public final Object invoke() {
                b bVar = this.f3197a;
                AbstractC1683A.n(bVar.b, null, new ToolSearchEngine$dataChangedListener$1$1(bVar, null), 3);
                return r.f317a;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.mcpserver.search.b r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            java.lang.String r0 = "Index rebuilt: "
            boolean r1 = r7 instanceof com.stepos.ability.mcpserver.search.ToolSearchEngine$rebuildIndex$1
            if (r1 == 0) goto L15
            r1 = r7
            com.stepos.ability.mcpserver.search.ToolSearchEngine$rebuildIndex$1 r1 = (com.stepos.ability.mcpserver.search.ToolSearchEngine$rebuildIndex$1) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.c = r2
            goto L1a
        L15:
            com.stepos.ability.mcpserver.search.ToolSearchEngine$rebuildIndex$1 r1 = new com.stepos.ability.mcpserver.search.ToolSearchEngine$rebuildIndex$1
            r1.<init>(r6, r7)
        L1a:
            java.lang.Object r7 = r1.f3195a
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.c
            java.lang.String r4 = "ToolSearchEngine"
            r5 = 1
            if (r3 == 0) goto L35
            if (r3 != r5) goto L2d
            kotlin.b.b(r7)     // Catch: java.lang.Exception -> L2b
            goto L43
        L2b:
            r6 = move-exception
            goto L63
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.b.b(r7)
            com.stepos.ability.api.ability.repository.IAtomicAbilityRepository r7 = r6.f3198a     // Catch: java.lang.Exception -> L2b
            r1.c = r5     // Catch: java.lang.Exception -> L2b
            java.lang.Object r7 = r7.getAll(r1)     // Catch: java.lang.Exception -> L2b
            if (r7 != r2) goto L43
            return r2
        L43:
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> L2b
            j4.c r6 = r6.c     // Catch: java.lang.Exception -> L2b
            r6.a(r7)     // Catch: java.lang.Exception -> L2b
            int r6 = r7.size()     // Catch: java.lang.Exception -> L2b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2b
            r7.<init>(r0)     // Catch: java.lang.Exception -> L2b
            r7.append(r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = " tools"
            r7.append(r6)     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Exception -> L2b
            android.util.Log.i(r4, r6)     // Catch: java.lang.Exception -> L2b
            goto L68
        L63:
            java.lang.String r7 = "Failed to rebuild index"
            android.util.Log.e(r4, r7, r6)
        L68:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.mcpserver.search.b.a(com.stepos.ability.mcpserver.search.b, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b() {
        this.f3198a.addOnDataChangedListener(this.d);
        AbstractC1683A.n(this.b, null, new ToolSearchEngine$start$1(this, null), 3);
    }
}
