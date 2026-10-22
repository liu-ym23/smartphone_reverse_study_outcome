package w8;

import java.util.ArrayList;
import java.util.Iterator;
import o8.u;
import v9.v;
import v9.x0;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final g8.a f10920a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10921b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.b f10922c;

    /* renamed from: d, reason: collision with root package name */
    public final o8.a f10923d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10924e;

    public o(g8.a aVar, boolean z4, a3.b bVar, o8.a aVar2, boolean z10) {
        q7.k.e(bVar, "containerContext");
        this.f10920a = aVar;
        this.f10921b = z4;
        this.f10922c = bVar;
        this.f10923d = aVar2;
        this.f10924e = z10;
    }

    public static void a(Object obj, ArrayList arrayList, r8.c cVar) {
        arrayList.add(obj);
        Iterable iterable = (Iterable) cVar.invoke(obj);
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next(), arrayList, cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Iterable, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w8.i b(y9.n r5) {
        /*
            w9.f r0 = w9.f.f10932g
            java.lang.String r1 = "<this>"
            q7.k.e(r5, r1)
            boolean r2 = r5 instanceof s8.f0
            if (r2 != 0) goto Ld
            goto Lc3
        Ld:
            java.util.List r5 = w9.a.getUpperBounds(r0, r5)
            if (r5 == 0) goto L1b
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L1b
            goto Lc3
        L1b:
            java.util.Iterator r2 = r5.iterator()
        L1f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lc3
            java.lang.Object r3 = r2.next()
            y9.h r3 = (y9.h) r3
            boolean r3 = w9.a.isError(r0, r3)
            if (r3 != 0) goto L1f
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L38
            goto L50
        L38:
            java.util.Iterator r2 = r5.iterator()
        L3c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L50
            java.lang.Object r3 = r2.next()
            y9.h r3 = (y9.h) r3
            w8.h r3 = d(r3)
            if (r3 == 0) goto L3c
            r2 = r5
            goto L96
        L50:
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L57
            goto Lc3
        L57:
            java.util.Iterator r2 = r5.iterator()
        L5b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lc3
            java.lang.Object r3 = r2.next()
            y9.h r3 = (y9.h) r3
            q7.k.e(r3, r1)
            v9.v r3 = (v9.v) r3
            v9.v r3 = v9.c.e(r3)
            if (r3 == 0) goto L5b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r5.iterator()
        L7b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L96
            java.lang.Object r4 = r3.next()
            y9.h r4 = (y9.h) r4
            q7.k.e(r4, r1)
            v9.v r4 = (v9.v) r4
            v9.v r4 = v9.c.e(r4)
            if (r4 == 0) goto L7b
            r2.add(r4)
            goto L7b
        L96:
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L9d
            goto Lb6
        L9d:
            java.util.Iterator r1 = r2.iterator()
        La1:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lb6
            java.lang.Object r3 = r1.next()
            y9.h r3 = (y9.h) r3
            boolean r3 = w9.a.isNullableType(r0, r3)
            if (r3 != 0) goto La1
            w8.h r0 = w8.h.f10900h
            goto Lb8
        Lb6:
            w8.h r0 = w8.h.f10899g
        Lb8:
            w8.i r1 = new w8.i
            if (r2 == r5) goto Lbe
            r5 = 1
            goto Lbf
        Lbe:
            r5 = 0
        Lbf:
            r1.<init>(r0, r5)
            return r1
        Lc3:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.o.b(y9.n):w8.i");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e9.e c(y9.j jVar) {
        x9.f fVar = x0.f10604a;
        f8.g gVarC = ((v) jVar).E0().c();
        f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
        if (eVar != null) {
            return h9.f.g(eVar);
        }
        return null;
    }

    public static h d(y9.h hVar) {
        w9.f fVar = w9.f.f10932g;
        if (w9.a.isMarkedNullable(fVar, fVar.P(hVar))) {
            return h.f10899g;
        }
        if (w9.a.isMarkedNullable(fVar, fVar.l0(hVar))) {
            return null;
        }
        return h.f10900h;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [c7.f, java.lang.Object] */
    public final ArrayList e(y9.h hVar) {
        a3.b bVar = this.f10922c;
        u uVar = (u) bVar.f165i.getValue();
        o8.c cVar = ((r8.a) bVar.f162f).f9018q;
        q7.k.e(hVar, "<this>");
        a aVar = new a(hVar, cVar.b(uVar, ((v) hVar).getAnnotations()), null);
        r8.c cVar2 = new r8.c(13, this);
        ArrayList arrayList = new ArrayList(1);
        a(aVar, arrayList, cVar2);
        return arrayList;
    }
}
