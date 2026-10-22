package m8;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public Iterator f8294c;

    /* renamed from: f, reason: collision with root package name */
    public q8.i f8295f;

    /* renamed from: g, reason: collision with root package name */
    public int f8296g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8297h;
    public final /* synthetic */ k0 i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ long f8298j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f8299k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Set f8300l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Map f8301m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(k0 k0Var, long j10, long j11, Set set, Map map, nb.c cVar) {
        super(2, cVar);
        this.i = k0Var;
        this.f8298j = j10;
        this.f8299k = j11;
        this.f8300l = set;
        this.f8301m = map;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        a0 a0Var = new a0(this.i, this.f8298j, this.f8299k, this.f8300l, this.f8301m, cVar);
        a0Var.f8297h = obj;
        return a0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
    
        if (r0 == r10) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Type inference failed for: r0v13, types: [jb.h] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005f -> B:35:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:35:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0074 -> B:35:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b3 -> B:34:0x00b4). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws org.json.JSONException {
        /*
            r17 = this;
            r5 = r17
            java.lang.Object r0 = r5.f8297h
            r9 = r0
            kc.t r9 = (kc.t) r9
            ob.a r10 = ob.a.f9351c
            int r0 = r5.f8296g
            java.util.Set r11 = r5.f8300l
            m8.k0 r12 = r5.i
            r13 = 2
            r1 = 1
            if (r0 == 0) goto L2e
            if (r0 == r1) goto L28
            if (r0 != r13) goto L21
            q8.i r0 = r5.f8295f
            java.util.Iterator r1 = r5.f8294c
            id.c.I(r18)
            r14 = r1
            goto Lb4
        L21:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r0 = 0
            return r0
        L28:
            id.c.I(r18)
            r0 = r18
            goto L45
        L2e:
            id.c.I(r18)
            q8.t r0 = r12.u()
            r5.f8297h = r9
            r5.f8296g = r1
            long r1 = r5.f8298j
            long r3 = r5.f8299k
            java.lang.Object r0 = r0.c(r1, r3, r5)
            if (r0 != r10) goto L45
            goto Lb2
        L45:
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r14 = r0
        L4c:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto Ld5
            java.lang.Object r0 = r14.next()
            r15 = r0
            q8.i r15 = (q8.i) r15
            java.lang.String r0 = r15.f10122b
            boolean r1 = hc.h.g0(r0)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = "{}"
            boolean r1 = yb.k.a(r0, r1)
            if (r1 == 0) goto L6a
            goto Ld1
        L6a:
            java.util.Map r1 = r5.f8301m
            java.lang.String r1 = t0.a.h(r0, r11, r1)
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Ld1
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L80
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L80
            goto L85
        L80:
            r0 = move-exception
            jb.h r0 = id.c.l(r0)
        L85:
            java.lang.Throwable r2 = jb.i.b(r0)
            if (r2 != 0) goto L8c
            r1 = r0
        L8c:
            r1.getClass()
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            q8.t r0 = r12.u()
            long r1 = r15.f10121a
            int r4 = r15.f10123c
            int r6 = r15.f10124d
            r8 = r6
            long r6 = r15.f10125e
            r5.f8297h = r9
            r5.f8294c = r14
            r5.f8295f = r15
            r5.f8296g = r13
            r16 = r8
            r8 = r5
            r5 = r16
            java.lang.Object r0 = r0.k(r1, r3, r4, r5, r6, r8)
            if (r0 != r10) goto Lb3
        Lb2:
            return r10
        Lb3:
            r0 = r15
        Lb4:
            long r0 = r0.f10121a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[revoke] patched Room snapshot dayStart="
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = " keys="
            r2.append(r0)
            r2.append(r11)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "BehaviorAnalysis"
            android.util.Log.i(r1, r0)
        Ld1:
            r5 = r17
            goto L4c
        Ld5:
            jb.v r0 = jb.v.f6774a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.a0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
