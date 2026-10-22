package c1;

import d1.d;
import d1.e;
import d1.f;
import d1.g;
import d1.h;
import d1.i;
import f1.C1431a;
import java.util.concurrent.CopyOnWriteArrayList;
import k1.AbstractC1620b;

/* renamed from: c1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0870a {

    /* renamed from: a, reason: collision with root package name */
    public static final C4.a f2080a;

    static {
        C4.a aVar = new C4.a(6);
        e eVar = new e();
        C1431a c1431a = (C1431a) AbstractC1620b.a(C1431a.class);
        eVar.b = c1431a;
        b bVar = new b();
        bVar.f2081a = false;
        bVar.b = false;
        bVar.d = c1431a;
        eVar.f4286a = bVar;
        g gVar = new g(eVar.f4286a);
        h hVar = new h(eVar.f4286a);
        hVar.e = 0;
        i iVar = new i(eVar.f4286a);
        iVar.g = 0L;
        iVar.b = new CopyOnWriteArrayList();
        iVar.d = new CopyOnWriteArrayList();
        iVar.c = new CopyOnWriteArrayList();
        iVar.e = new C0.b(iVar);
        b bVar2 = eVar.f4286a;
        d dVar = new d(bVar2);
        dVar.c = false;
        dVar.b = new d1.c(dVar, dVar.c ? 1200000L : 120000L, bVar2);
        f fVar = new f(eVar.f4286a);
        b bVar3 = eVar.f4286a;
        if (!bVar3.b) {
            bVar3.h = gVar;
            bVar3.i = hVar;
            bVar3.f2082j = iVar;
            bVar3.k = dVar;
            bVar3.l = fVar;
            try {
                bVar3.e = S0.b.h(H.h.f711a);
            } catch (Throwable unused) {
            }
            bVar3.b = true;
        }
        C1431a c1431a2 = eVar.b;
        synchronized (c1431a2.f4433a) {
            c1431a2.f4433a.add(eVar);
        }
        aVar.c = eVar;
        f2080a = aVar;
    }
}
