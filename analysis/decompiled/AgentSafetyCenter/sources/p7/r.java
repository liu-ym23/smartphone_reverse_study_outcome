package p7;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends m7.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9892a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Object f9893b;

    /* renamed from: c, reason: collision with root package name */
    public m7.n f9894c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9895d;

    public r(m7.e eVar, m7.n nVar, Type type) {
        this.f9893b = eVar;
        this.f9894c = nVar;
        this.f9895d = type;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) throws IOException {
        switch (this.f9892a) {
            case 0:
                u7.b bVarY = aVar.Y();
                if (bVarY == u7.b.f14169m) {
                    aVar.U();
                    return null;
                }
                Map map = (Map) ((o7.o) this.f9895d).b();
                if (bVarY == u7.b.f14162c) {
                    aVar.d();
                    while (aVar.H()) {
                        aVar.d();
                        Object obj = ((r) this.f9893b).f9894c.read(aVar);
                        if (map.put(obj, ((r) this.f9894c).f9894c.read(aVar)) != null) {
                            throw new m7.h(k0.a.l(obj, "duplicate key: "));
                        }
                        aVar.n();
                    }
                    aVar.n();
                } else {
                    aVar.e();
                    while (aVar.H()) {
                        r2.i.f10409g.getClass();
                        if (aVar instanceof o) {
                            o oVar = (o) aVar;
                            oVar.h0(u7.b.i);
                            Map.Entry entry = (Map.Entry) ((Iterator) oVar.l0()).next();
                            oVar.n0(entry.getValue());
                            oVar.n0(new m7.l((String) entry.getKey()));
                        } else {
                            int i = aVar.f14153k;
                            if (i == 0) {
                                i = aVar.i();
                            }
                            if (i == 13) {
                                aVar.f14153k = 9;
                            } else if (i == 12) {
                                aVar.f14153k = 8;
                            } else {
                                if (i != 14) {
                                    throw aVar.g0("a name");
                                }
                                aVar.f14153k = 10;
                            }
                        }
                        Object obj2 = ((r) this.f9893b).f9894c.read(aVar);
                        if (map.put(obj2, ((r) this.f9894c).f9894c.read(aVar)) != null) {
                            throw new m7.h(k0.a.l(obj2, "duplicate key: "));
                        }
                    }
                    aVar.o();
                }
                return map;
            default:
                return this.f9894c.read(aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.reflect.Type] */
    @Override // m7.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void write(u7.c r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.f9892a
            switch(r0) {
                case 0: goto L49;
                default: goto L5;
            }
        L5:
            m7.n r0 = r3.f9894c
            java.lang.Object r1 = r3.f9895d
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            if (r5 == 0) goto L1a
            boolean r2 = r1 instanceof java.lang.Class
            if (r2 != 0) goto L15
            boolean r2 = r1 instanceof java.lang.reflect.TypeVariable
            if (r2 == 0) goto L1a
        L15:
            java.lang.Class r2 = r5.getClass()
            goto L1b
        L1a:
            r2 = r1
        L1b:
            if (r2 == r1) goto L45
            java.lang.Object r3 = r3.f9893b
            m7.e r3 = (m7.e) r3
            t7.a r1 = t7.a.get(r2)
            m7.n r3 = r3.c(r1)
            boolean r1 = r3 instanceof p7.x
            if (r1 != 0) goto L2e
            goto L44
        L2e:
            r1 = r0
        L2f:
            boolean r2 = r1 instanceof p7.c0
            if (r2 == 0) goto L3f
            r2 = r1
            p7.c0 r2 = (p7.c0) r2
            m7.n r2 = r2.a()
            if (r2 != r1) goto L3d
            goto L3f
        L3d:
            r1 = r2
            goto L2f
        L3f:
            boolean r1 = r1 instanceof p7.x
            if (r1 != 0) goto L44
            goto L45
        L44:
            r0 = r3
        L45:
            r0.write(r4, r5)
            return
        L49:
            java.util.Map r5 = (java.util.Map) r5
            m7.n r3 = r3.f9894c
            p7.r r3 = (p7.r) r3
            if (r5 != 0) goto L55
            r4.C()
            goto L82
        L55:
            r4.g()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L60:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L7f
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r4.r(r1)
            java.lang.Object r0 = r0.getValue()
            r3.write(r4, r0)
            goto L60
        L7f:
            r4.o()
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.r.write(u7.c, java.lang.Object):void");
    }

    public /* synthetic */ r() {
    }
}
