package F4;

import C4.A;
import C4.C0271a;
import C4.H;
import C4.InterfaceC0275e;
import C4.s;
import C4.x;
import F4.j;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private final k f1776a;

    /* renamed from: b, reason: collision with root package name */
    private final C0271a f1777b;

    /* renamed from: c, reason: collision with root package name */
    private final g f1778c;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC0275e f1779d;

    /* renamed from: e, reason: collision with root package name */
    private final s f1780e;

    /* renamed from: f, reason: collision with root package name */
    private j.a f1781f;

    /* renamed from: g, reason: collision with root package name */
    private final j f1782g;

    /* renamed from: h, reason: collision with root package name */
    private e f1783h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1784i;

    /* renamed from: j, reason: collision with root package name */
    private H f1785j;

    d(k kVar, g gVar, C0271a c0271a, InterfaceC0275e interfaceC0275e, s sVar) {
        this.f1776a = kVar;
        this.f1778c = gVar;
        this.f1777b = c0271a;
        this.f1779d = interfaceC0275e;
        this.f1780e = sVar;
        this.f1782g = new j(c0271a, gVar.f1808e, interfaceC0275e, sVar);
    }

    private e c(int i5, int i6, int i7, int i8, boolean z5) throws Throwable {
        e eVar;
        Socket socketS;
        Socket socketN;
        e eVar2;
        boolean z6;
        H hC;
        boolean z7;
        List<H> listA;
        e eVar3;
        j.a aVar;
        synchronized (this.f1778c) {
            try {
                if (this.f1776a.i()) {
                    throw new IOException("Canceled");
                }
                this.f1784i = false;
                k kVar = this.f1776a;
                eVar = kVar.f1831i;
                socketS = null;
                socketN = (eVar == null || !eVar.f1795k) ? null : kVar.n();
                k kVar2 = this.f1776a;
                eVar2 = kVar2.f1831i;
                if (eVar2 != null) {
                    eVar = null;
                } else {
                    eVar2 = null;
                }
                if (eVar2 != null) {
                    z6 = false;
                    hC = null;
                } else if (this.f1778c.g(this.f1777b, kVar2, null, false)) {
                    eVar2 = this.f1776a.f1831i;
                    hC = null;
                    z6 = true;
                } else {
                    hC = this.f1785j;
                    if (hC != null) {
                        this.f1785j = null;
                    } else {
                        if (g()) {
                            hC = this.f1776a.f1831i.q();
                        }
                        z6 = false;
                        hC = null;
                    }
                    z6 = false;
                }
            } finally {
            }
        }
        D4.e.h(socketN);
        if (eVar != null) {
            this.f1780e.i(this.f1779d, eVar);
        }
        if (z6) {
            this.f1780e.h(this.f1779d, eVar2);
        }
        if (eVar2 != null) {
            return eVar2;
        }
        if (hC != null || ((aVar = this.f1781f) != null && aVar.b())) {
            z7 = false;
        } else {
            this.f1781f = this.f1782g.d();
            z7 = true;
        }
        synchronized (this.f1778c) {
            try {
                if (this.f1776a.i()) {
                    throw new IOException("Canceled");
                }
                if (z7) {
                    listA = this.f1781f.a();
                    if (this.f1778c.g(this.f1777b, this.f1776a, listA, false)) {
                        eVar2 = this.f1776a.f1831i;
                        z6 = true;
                    }
                } else {
                    listA = null;
                }
                if (!z6) {
                    if (hC == null) {
                        hC = this.f1781f.c();
                    }
                    eVar2 = new e(this.f1778c, hC);
                    this.f1783h = eVar2;
                }
                eVar3 = eVar2;
            } finally {
            }
        }
        if (z6) {
            this.f1780e.h(this.f1779d, eVar3);
            return eVar3;
        }
        eVar3.d(i5, i6, i7, i8, z5, this.f1779d, this.f1780e);
        this.f1778c.f1808e.a(eVar3.q());
        synchronized (this.f1778c) {
            try {
                this.f1783h = null;
                if (this.f1778c.g(this.f1777b, this.f1776a, listA, true)) {
                    eVar3.f1795k = true;
                    socketS = eVar3.s();
                    eVar3 = this.f1776a.f1831i;
                    this.f1785j = hC;
                } else {
                    this.f1778c.f(eVar3);
                    this.f1776a.a(eVar3);
                }
            } finally {
            }
        }
        D4.e.h(socketS);
        this.f1780e.h(this.f1779d, eVar3);
        return eVar3;
    }

    private e d(int i5, int i6, int i7, int i8, boolean z5, boolean z6) throws Throwable {
        while (true) {
            e eVarC = c(i5, i6, i7, i8, z5);
            synchronized (this.f1778c) {
                try {
                    if (eVarC.f1797m == 0 && !eVarC.n()) {
                        return eVarC;
                    }
                    if (eVarC.m(z6)) {
                        return eVarC;
                    }
                    eVarC.p();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean g() {
        e eVar = this.f1776a.f1831i;
        return eVar != null && eVar.f1796l == 0 && D4.e.D(eVar.q().a().l(), this.f1777b.l());
    }

    e a() {
        return this.f1783h;
    }

    public G4.c b(A a6, x.a aVar, boolean z5) {
        try {
            return d(aVar.e(), aVar.c(), aVar.d(), a6.y(), a6.E(), z5).o(a6, aVar);
        } catch (i e6) {
            h();
            throw e6;
        } catch (IOException e7) {
            h();
            throw new i(e7);
        }
    }

    boolean e() {
        synchronized (this.f1778c) {
            try {
                boolean z5 = true;
                if (this.f1785j != null) {
                    return true;
                }
                if (g()) {
                    this.f1785j = this.f1776a.f1831i.q();
                    return true;
                }
                j.a aVar = this.f1781f;
                if ((aVar == null || !aVar.b()) && !this.f1782g.b()) {
                    z5 = false;
                }
                return z5;
            } finally {
            }
        }
    }

    boolean f() {
        boolean z5;
        synchronized (this.f1778c) {
            z5 = this.f1784i;
        }
        return z5;
    }

    void h() {
        synchronized (this.f1778c) {
            this.f1784i = true;
        }
    }
}
