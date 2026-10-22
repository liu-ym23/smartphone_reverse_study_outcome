package G2;

import android.content.Intent;
import f2.C0702g;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private stepos.support.v7.app.d f1906a;

    /* renamed from: b, reason: collision with root package name */
    private u f1907b;

    /* renamed from: c, reason: collision with root package name */
    private String f1908c;

    /* renamed from: d, reason: collision with root package name */
    private final F2.y f1909d;

    /* renamed from: e, reason: collision with root package name */
    private final w f1910e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1911f;

    /* renamed from: g, reason: collision with root package name */
    private int f1912g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f1913h = -1;

    public v(F2.y yVar, boolean z5) {
        this.f1909d = yVar;
        this.f1911f = z5;
        this.f1910e = z5 ? new C0299g() : new y();
    }

    private void m(u uVar) {
        this.f1909d.C0(uVar.getId());
    }

    public void a() {
        C0702g.b("MinorStateContext", "clearRuntimeState() called with: mCurrentState = [" + this.f1907b + "]");
        this.f1907b = null;
        this.f1906a = null;
        this.f1908c = null;
        this.f1912g = -1;
        this.f1913h = -1;
    }

    public int b() {
        int i5 = this.f1913h;
        this.f1913h = -1;
        return i5;
    }

    public void c(int i5) {
        if (this.f1912g == i5) {
            this.f1912g = -1;
        }
    }

    public stepos.support.v7.app.d d() {
        return this.f1906a;
    }

    public String e() {
        return this.f1908c;
    }

    public u f() {
        return this.f1907b;
    }

    public F2.y g() {
        return this.f1909d;
    }

    public int h() {
        return this.f1912g;
    }

    public x3.f<F2.z> i() {
        return this.f1909d.A0();
    }

    public boolean j(int i5) {
        C0702g.b("MinorStateContext", "handleOperation() called with: operation = [" + AbstractC0293a.l(i5) + "] mCurrentState = [" + this.f1907b + "]");
        u uVar = this.f1907b;
        if (uVar != null) {
            return uVar.i(this.f1906a, i5);
        }
        C0702g.p("MinorStateContext", "handleOperation() called with: operation = [" + AbstractC0293a.l(i5) + "] mCurrentState = null");
        return false;
    }

    public boolean k(int i5, int i6, Intent intent) {
        u uVar = this.f1907b;
        if (uVar != null) {
            return uVar.a(this.f1906a, i5, i6, intent);
        }
        return false;
    }

    public boolean l() {
        return this.f1911f;
    }

    public void n(stepos.support.v7.app.d dVar) {
        this.f1906a = dVar;
    }

    public void o(String str) {
        this.f1908c = str;
    }

    public void p(int i5) {
        this.f1913h = i5;
    }

    public void q(F2.z zVar) {
        r(this.f1910e.a(zVar, this));
    }

    public void r(u uVar) {
        C0702g.b("MinorStateContext", "setState() called with: state = [" + uVar + "]");
        if (uVar == null || uVar.equals(this.f1907b)) {
            return;
        }
        u uVar2 = this.f1907b;
        this.f1907b = uVar;
        uVar.h(this.f1906a, uVar2);
        if (uVar2 != null) {
            uVar2.g(this.f1906a, uVar);
        }
        if (uVar.c()) {
            m(uVar);
        }
    }

    public boolean s(int i5) {
        if (this.f1912g < 0) {
            this.f1912g = i5;
            return true;
        }
        C0702g.b("MinorStateContext", "ignore duplicate password verification, activeRequestCode = [" + this.f1912g + "], requestCode = [" + i5 + "]");
        return false;
    }
}
