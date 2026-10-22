package xa;

import d7.m;
import eb.p;
import q5.t;
import q7.k;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: d, reason: collision with root package name */
    public static final b f11331d = new b(new f(false, false, false, true, "    ", "type", true, a.f11329f), za.a.f12494a);

    /* renamed from: a, reason: collision with root package name */
    public final f f11332a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f11333b;

    /* renamed from: c, reason: collision with root package name */
    public final t f11334c = new t(2);

    public c(f fVar, w4.a aVar) {
        this.f11332a = fVar;
        this.f11333b = aVar;
    }

    public final Object a(sa.a aVar, String str) {
        k.e(aVar, "deserializer");
        k.e(str, "string");
        g3.e eVar = new g3.e(str);
        Object objC = new p(this, ya.i.f11740h, eVar, aVar.a()).c(aVar);
        if (eVar.e() == 10) {
            return objC;
        }
        g3.e.m(eVar, "Expected EOF after parsing, but had " + str.charAt(eVar.f3802b - 1) + " instead", 0, 6);
        throw null;
    }

    public final String b(sa.a aVar, Object obj) {
        char[] cArr;
        k.e(aVar, "serializer");
        d1.b bVar = new d1.b(8, false);
        ya.b bVar2 = ya.b.f11731c;
        synchronized (bVar2) {
            m mVar = (m) bVar2.f882b;
            cArr = null;
            char[] cArr2 = (char[]) (mVar.isEmpty() ? null : mVar.removeLast());
            if (cArr2 != null) {
                bVar2.f881a -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        bVar.f2768h = cArr;
        try {
            new f3.b(new a7.c(bVar), this, ya.i.f11740h, new f3.b[ya.i.f11745m.a()]).h(aVar, obj);
            return bVar.toString();
        } finally {
            bVar.h();
        }
    }
}
