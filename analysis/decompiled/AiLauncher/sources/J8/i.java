package J8;

import Yb.u;
import Yb.z;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public k f3754a;

    /* renamed from: b, reason: collision with root package name */
    public u f3755b;

    /* renamed from: c, reason: collision with root package name */
    public String f3756c;

    /* renamed from: d, reason: collision with root package name */
    public int f3757d;

    public void a(Tb.e eVar) {
        this.f3754a.f(eVar);
    }

    public Tb.e b() {
        return this.f3754a.m();
    }

    public Tb.f c() {
        return this.f3754a.i();
    }

    public String d(Pattern pattern) {
        this.f3754a.setIndex(this.f3757d);
        String strC = this.f3754a.c(pattern);
        this.f3757d = this.f3754a.index();
        return strC;
    }

    public abstract u e();

    public u f(k kVar) {
        this.f3754a = kVar;
        this.f3755b = kVar.block();
        this.f3756c = kVar.g();
        this.f3757d = kVar.index();
        u uVarE = e();
        kVar.setIndex(this.f3757d);
        return uVarE;
    }

    public String g() {
        this.f3754a.setIndex(this.f3757d);
        String strE = this.f3754a.e();
        this.f3757d = this.f3754a.index();
        return strE;
    }

    public int h() {
        this.f3754a.setIndex(this.f3757d);
        int iH = this.f3754a.h();
        this.f3757d = this.f3754a.index();
        return iH;
    }

    public String i() {
        this.f3754a.setIndex(this.f3757d);
        String strB = this.f3754a.b();
        this.f3757d = this.f3754a.index();
        return strB;
    }

    public char j() {
        this.f3754a.setIndex(this.f3757d);
        return this.f3754a.peek();
    }

    public void k(Tb.f fVar) {
        this.f3754a.setIndex(this.f3757d);
        this.f3754a.j(fVar);
        this.f3757d = this.f3754a.index();
    }

    public void l() {
        this.f3754a.k();
    }

    public abstract char m();

    public void n() {
        this.f3754a.setIndex(this.f3757d);
        this.f3754a.d();
        this.f3757d = this.f3754a.index();
    }

    public z o(String str) {
        return this.f3754a.text(str);
    }

    public z p(String str, int i10, int i11) {
        return this.f3754a.l(str, i10, i11);
    }
}
