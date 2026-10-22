package com.stepos.datacenter.api;

import U6.e;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0004¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0012\u0010\u0011J \u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0013\u0010\u0011J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u0018\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0086@¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/datacenter/api/EntityCrudOps;", "", "<init>", "()V", "", "Lkotlin/Pair;", "Lw9/d;", "LU6/e$a;", "pairs", "LY8/t;", Const.INTENT_KEY_APIKEY, "([Lkotlin/Pair;)V", "Lcom/stepos/datacenter/api/DataCenter;", "inst", Const.LBS_FAIL_BD_ENTITY, "", Const.INTENT_KEY_UMID, "(Lcom/stepos/datacenter/api/DataCenter;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "f", Const.INTENT_KEY_PKGNAME, "", "entities", "e", "(Lcom/stepos/datacenter/api/DataCenter;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "c", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntityCrudOps {

    /* renamed from: a, reason: collision with root package name */
    public static final EntityCrudOps f29848a = new EntityCrudOps();

    public final void a(Pair<? extends InterfaceC5745d<?>, ? extends e.a<?>>[] pairs) {
        p.i(pairs, "pairs");
        for (Pair<? extends InterfaceC5745d<?>, ? extends e.a<?>> pair : pairs) {
            InterfaceC5745d<?> interfaceC5745dA = pair.a();
            e.a<?> aVarB = pair.b();
            U6.e eVar = U6.e.f6308a;
            p.g(interfaceC5745dA, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            p.g(aVarB, "null cannot be cast to non-null type com.stepos.datacenter.annotation.EntityRegistry.EntityBinding<kotlin.Any>");
            eVar.l(interfaceC5745dA, aVarB);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0113, code lost:
    
        if (r1.a(r0, r3, r5, r6) != r13) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec A[PHI: r10 r11
      0x00ec: PHI (r10v13 java.lang.Object) = (r10v10 java.lang.Object), (r10v18 java.lang.Object) binds: [B:44:0x00ab, B:49:0x00bd] A[DONT_GENERATE, DONT_INLINE]
      0x00ec: PHI (r11v12 long) = (r11v10 long), (r11v15 long) binds: [B:44:0x00ab, B:49:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.stepos.datacenter.api.DataCenter r11, java.lang.Object r12, e9.InterfaceC4014c<? super Y8.t> r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.EntityCrudOps.b(com.stepos.datacenter.api.DataCenter, java.lang.Object, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.stepos.datacenter.api.DataCenter r8, java.util.List<? extends java.lang.Object> r9, e9.InterfaceC4014c<? super Y8.t> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.datacenter.api.EntityCrudOps$removeAll$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.datacenter.api.EntityCrudOps$removeAll$1 r0 = (com.stepos.datacenter.api.EntityCrudOps$removeAll$1) r0
            int r1 = r0.f29860g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29860g = r1
            goto L18
        L13:
            com.stepos.datacenter.api.EntityCrudOps$removeAll$1 r0 = new com.stepos.datacenter.api.EntityCrudOps$removeAll$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f29858e
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f29860g
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r7 = r0.f29857d
            java.lang.Object r8 = r0.f29856c
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f29855b
            com.stepos.datacenter.api.DataCenter r9 = (com.stepos.datacenter.api.DataCenter) r9
            java.lang.Object r2 = r0.f29854a
            com.stepos.datacenter.api.EntityCrudOps r2 = (com.stepos.datacenter.api.EntityCrudOps) r2
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L37
            goto L93
        L37:
            r10 = move-exception
            goto L6b
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            kotlin.C4849c.b(r10)
            java.util.Iterator r9 = r9.iterator()
            r6 = r9
            r9 = r8
            r8 = r6
        L4b:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L95
            java.lang.Object r10 = r8.next()
            r0.f29854a = r7     // Catch: java.lang.Throwable -> L66
            r0.f29855b = r9     // Catch: java.lang.Throwable -> L66
            r0.f29856c = r8     // Catch: java.lang.Throwable -> L66
            r0.f29857d = r10     // Catch: java.lang.Throwable -> L66
            r0.f29860g = r3     // Catch: java.lang.Throwable -> L66
            java.lang.Object r10 = r7.b(r9, r10, r0)     // Catch: java.lang.Throwable -> L66
            if (r10 != r1) goto L4b
            return r1
        L66:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L6b:
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "removeAll: remove("
            r4.append(r5)
            r4.append(r7)
            java.lang.String r7 = ") failed"
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            java.lang.String r4 = "DataCenter"
            int r7 = android.util.Log.w(r4, r7, r10)
            g9.C4109a.f(r7)
        L93:
            r7 = r2
            goto L4b
        L95:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.EntityCrudOps.c(com.stepos.datacenter.api.DataCenter, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.stepos.datacenter.api.DataCenter r8, java.lang.Object r9, e9.InterfaceC4014c<? super java.lang.Long> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.EntityCrudOps.d(com.stepos.datacenter.api.DataCenter, java.lang.Object, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:26:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(com.stepos.datacenter.api.DataCenter r10, java.util.List<? extends java.lang.Object> r11, e9.InterfaceC4014c<? super java.util.List<java.lang.Long>> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.EntityCrudOps.e(com.stepos.datacenter.api.DataCenter, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        if (r7.d(r8, r9, null, r0) != r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
    
        if (r7.d(r8, r9, r1, r0) != r10) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(com.stepos.datacenter.api.DataCenter r8, java.lang.Object r9, e9.InterfaceC4014c<? super Y8.t> r10) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.EntityCrudOps.f(com.stepos.datacenter.api.DataCenter, java.lang.Object, e9.c):java.lang.Object");
    }
}
