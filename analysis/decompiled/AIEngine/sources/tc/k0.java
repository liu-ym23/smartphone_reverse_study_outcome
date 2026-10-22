package tc;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class k0<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name */
    public final b1 f13001a;

    /* renamed from: b, reason: collision with root package name */
    public final uc.i f13002b;

    public k0(int i10) {
        b1 b1Var = b1.f12964a;
        uc.i iVar = uc.i.f13211a;
        this.f13001a = b1Var;
        this.f13002b = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        h(obj);
        d0 d0Var = ((e0) this).f12974c;
        sc.c cVarC = kVar.C(d0Var);
        Iterator<Map.Entry<? extends Key, ? extends Value>> itG = g(obj);
        int i10 = 0;
        while (itG.hasNext()) {
            Map.Entry<? extends Key, ? extends Value> next = itG.next();
            Key key = next.getKey();
            Value value = next.getValue();
            int i11 = i10 + 1;
            cVarC.g(d0Var, i10, this.f13001a, key);
            i10 += 2;
            cVarC.g(d0Var, i11, this.f13002b, value);
        }
        cVarC.a(d0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    @Override // tc.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(sc.b r6, int r7, java.lang.Object r8) {
        /*
            r5 = this;
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r0 = "builder"
            kotlin.jvm.internal.g.f(r8, r0)
            r0 = r5
            tc.e0 r0 = (tc.e0) r0
            tc.d0 r0 = r0.f12974c
            tc.b1 r1 = r5.f13001a
            r2 = 0
            java.lang.Object r1 = r6.c(r0, r7, r1, r2)
            int r3 = r6.f(r0)
            int r4 = r7 + 1
            if (r3 != r4) goto L3f
            boolean r7 = r8.containsKey(r1)
            uc.i r5 = r5.f13002b
            if (r7 == 0) goto L37
            r5.getClass()
            rc.f r7 = uc.i.f13212b
            rc.i r7 = r7.f11787b
            boolean r7 = r7 instanceof rc.d
            if (r7 != 0) goto L37
            java.lang.Object r7 = kotlin.collections.b.e0(r1, r8)
            java.lang.Object r5 = r6.c(r0, r3, r5, r7)
            goto L3b
        L37:
            java.lang.Object r5 = r6.c(r0, r3, r5, r2)
        L3b:
            r8.put(r1, r5)
            return
        L3f:
            java.lang.String r5 = "Value must follow key in a map, index for key: "
            java.lang.String r6 = ", returned index for value: "
            java.lang.String r5 = a0.a.f(r5, r7, r3, r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tc.k0.j(sc.b, int, java.lang.Object):void");
    }
}
