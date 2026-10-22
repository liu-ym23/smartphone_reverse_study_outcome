package B3;

import B0.m;
import h3.C0611u;

/* loaded from: classes2.dex */
public final class k extends t3.c {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f234c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: b, reason: collision with root package name */
    public final Object f235b;

    public k(Object obj) {
        t3.a iVar = new i(obj);
        C0611u c0611u = E3.c.f413b;
        super(c0611u != null ? (t3.a) c0611u.call(iVar) : iVar);
        this.f235b = obj;
    }

    public final t3.c e(t3.f fVar) {
        x3.e iVar;
        if (fVar instanceof A3.h) {
            iVar = new m(10, this, (A3.h) fVar);
        } else {
            iVar = new m3.i(this, fVar, 0);
        }
        t3.a cVar = new y3.c(this.f235b, iVar, 3);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (t3.a) c0611u.call(cVar);
        }
        return new t3.c(cVar);
    }
}
