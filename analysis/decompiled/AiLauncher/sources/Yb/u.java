package Yb;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes5.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public u f7078a = null;

    /* renamed from: b, reason: collision with root package name */
    public u f7079b = null;

    /* renamed from: c, reason: collision with root package name */
    public u f7080c = null;

    /* renamed from: d, reason: collision with root package name */
    public u f7081d = null;

    /* renamed from: e, reason: collision with root package name */
    public u f7082e = null;

    public abstract void a(B b10);

    public void b(u uVar) {
        uVar.l();
        uVar.j(this);
        u uVar2 = this.f7080c;
        if (uVar2 == null) {
            this.f7079b = uVar;
            this.f7080c = uVar;
        } else {
            uVar2.f7082e = uVar;
            uVar.f7081d = uVar2;
            this.f7080c = uVar;
        }
    }

    public u c() {
        return this.f7079b;
    }

    public u d() {
        return this.f7080c;
    }

    public u e() {
        return this.f7082e;
    }

    public u f() {
        return this.f7078a;
    }

    public u g() {
        return this.f7081d;
    }

    public void h(u uVar) {
        uVar.l();
        u uVar2 = this.f7082e;
        uVar.f7082e = uVar2;
        if (uVar2 != null) {
            uVar2.f7081d = uVar;
        }
        uVar.f7081d = this;
        this.f7082e = uVar;
        u uVar3 = this.f7078a;
        uVar.f7078a = uVar3;
        if (uVar.f7082e == null) {
            uVar3.f7080c = uVar;
        }
    }

    public void i(u uVar) {
        uVar.l();
        u uVar2 = this.f7081d;
        uVar.f7081d = uVar2;
        if (uVar2 != null) {
            uVar2.f7082e = uVar;
        }
        uVar.f7082e = this;
        this.f7081d = uVar;
        u uVar3 = this.f7078a;
        uVar.f7078a = uVar3;
        if (uVar.f7081d == null) {
            uVar3.f7079b = uVar;
        }
    }

    public void j(u uVar) {
        this.f7078a = uVar;
    }

    public String k() {
        return "";
    }

    public void l() {
        u uVar = this.f7081d;
        if (uVar != null) {
            uVar.f7082e = this.f7082e;
        } else {
            u uVar2 = this.f7078a;
            if (uVar2 != null) {
                uVar2.f7079b = this.f7082e;
            }
        }
        u uVar3 = this.f7082e;
        if (uVar3 != null) {
            uVar3.f7081d = uVar;
        } else {
            u uVar4 = this.f7078a;
            if (uVar4 != null) {
                uVar4.f7080c = uVar;
            }
        }
        this.f7078a = null;
        this.f7082e = null;
        this.f7081d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + Const.STR_MART_JSON_BEGIN + k() + "}";
    }
}
