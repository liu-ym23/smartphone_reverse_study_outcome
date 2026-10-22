package V;

import U.i;
import cc.dd.dd.cc.dd.ff.a$a;
import h2.d;
import w0.C2085f;

/* loaded from: classes2.dex */
public final class a {
    public static final d c = W.a.f1470a;
    public final i b = new i();

    /* renamed from: a, reason: collision with root package name */
    public a$a f1298a = a$a.f2134a;

    public final void a(long j5) {
        if (!b()) {
            this.b.e.c = j5;
            return;
        }
        d dVar = c;
        this.f1298a.toString();
        synchronized (dVar) {
            ((C2085f) dVar.f4555a).getClass();
        }
    }

    public final boolean b() {
        return this.f1298a.ordinal() >= 2;
    }

    public final void c(long j5) {
        if (!b()) {
            this.b.e.b = j5;
            this.f1298a = a$a.b;
        } else {
            d dVar = c;
            this.f1298a.toString();
            synchronized (dVar) {
                ((C2085f) dVar.f4555a).getClass();
            }
        }
    }

    public final String toString() {
        return this.b.toString();
    }
}
