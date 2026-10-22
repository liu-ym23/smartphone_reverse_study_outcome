package s0;

import android.os.Trace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import k0.a2;
import k0.b2;
import p.f0;
import p.g0;
import p.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public Set f11184a;

    /* renamed from: b, reason: collision with root package name */
    public v0.b f11185b;

    /* renamed from: c, reason: collision with root package name */
    public final m0.e f11186c;

    /* renamed from: d, reason: collision with root package name */
    public g0 f11187d;

    /* renamed from: e, reason: collision with root package name */
    public m0.e f11188e;

    /* renamed from: f, reason: collision with root package name */
    public final m0.e f11189f;

    /* renamed from: g, reason: collision with root package name */
    public final m0.e f11190g;

    /* renamed from: h, reason: collision with root package name */
    public g0 f11191h;
    public f0 i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f11192j;

    /* renamed from: k, reason: collision with root package name */
    public g0 f11193k;

    public i() {
        m0.e eVar = new m0.e(new b2[16]);
        this.f11186c = eVar;
        int i = o0.f9601a;
        this.f11187d = new g0();
        this.f11188e = eVar;
        this.f11189f = new m0.e(new Object[16]);
        this.f11190g = new m0.e(new xb.a[16]);
    }

    public final void a() {
        this.f11184a = null;
        this.f11185b = null;
        m0.e eVar = this.f11186c;
        eVar.g();
        this.f11187d.b();
        this.f11188e = eVar;
        this.f11189f.g();
        this.f11190g.g();
        this.f11191h = null;
        this.i = null;
        this.f11192j = null;
    }

    public final void b() {
        Set set = this.f11184a;
        if (set == null || set.isEmpty()) {
            return;
        }
        Trace.beginSection("Compose:abandons");
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                a2 a2Var = (a2) it.next();
                it.remove();
                a2Var.a();
            }
        } finally {
            Trace.endSection();
        }
    }

    public final void c() {
        Set set = this.f11184a;
        if (set == null) {
            return;
        }
        this.f11193k = null;
        m0.e eVar = this.f11189f;
        if (eVar.f8160g != 0) {
            Trace.beginSection("Compose:onForgotten");
            try {
                g0 g0Var = this.f11191h;
                int i = eVar.f8160g;
                while (true) {
                    i--;
                    if (-1 >= i) {
                        break;
                    }
                    Object obj = eVar.f8158c[i];
                    try {
                        if (obj instanceof b2) {
                            a2 a2Var = ((b2) obj).f6867a;
                            set.remove(a2Var);
                            a2Var.b();
                        }
                        if (obj instanceof k0.k) {
                            if (g0Var == null || !g0Var.c(obj)) {
                                ((k0.k) obj).b();
                            } else {
                                ((k0.k) obj).a();
                            }
                        }
                    } catch (Throwable th) {
                        v0.b bVar = this.f11185b;
                        if (bVar != null) {
                            bVar.a(th, obj);
                        }
                        throw th;
                    }
                }
            } finally {
            }
        }
        m0.e eVar2 = this.f11186c;
        if (eVar2.f8160g != 0) {
            Trace.beginSection("Compose:onRemembered");
            try {
                Set set2 = this.f11184a;
                if (set2 != null) {
                    Object[] objArr = eVar2.f8158c;
                    int i3 = eVar2.f8160g;
                    for (int i10 = 0; i10 < i3; i10++) {
                        b2 b2Var = (b2) objArr[i10];
                        a2 a2Var2 = b2Var.f6867a;
                        set2.remove(a2Var2);
                        try {
                            a2Var2.c();
                        } catch (Throwable th2) {
                            v0.b bVar2 = this.f11185b;
                            if (bVar2 != null) {
                                bVar2.a(th2, b2Var);
                            }
                            throw th2;
                        }
                    }
                }
            } finally {
            }
        }
    }

    public final void d(b2 b2Var) {
        if (this.f11187d.c(b2Var)) {
            this.f11187d.k(b2Var);
            if (!this.f11188e.j(b2Var)) {
                m0.e eVar = this.f11186c;
                if (!eVar.j(b2Var)) {
                    Object[] objArr = eVar.f8158c;
                    int i = eVar.f8160g;
                    for (int i3 = 0; i3 < i; i3++) {
                        if (((b2) objArr[i3]).f6867a instanceof e) {
                            throw null;
                        }
                    }
                }
            }
            Set set = this.f11184a;
            if (set == null) {
                return;
            } else {
                set.add(b2Var.f6867a);
            }
        }
        g0 g0Var = this.f11193k;
        if (g0Var == null || !g0Var.c(b2Var)) {
            this.f11189f.b(b2Var);
        }
    }

    public final void e(Set set, v0.b bVar) {
        a();
        this.f11184a = set;
        this.f11185b = bVar;
    }
}
