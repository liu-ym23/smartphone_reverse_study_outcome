package i9;

import f8.g;
import f8.q0;
import g8.j;
import m.x;
import q7.k;
import v9.p0;
import v9.s0;
import v9.v;

/* loaded from: classes.dex */
public final class d extends s0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4913b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f4914c;

    public /* synthetic */ d(s0 s0Var, int i2) {
        this.f4913b = i2;
        this.f4914c = s0Var;
    }

    @Override // v9.s0
    public boolean a() {
        switch (this.f4913b) {
            case 0:
                return this.f4914c.a();
            default:
                return super.a();
        }
    }

    @Override // v9.s0
    public boolean b() {
        switch (this.f4913b) {
            case 0:
                return true;
            default:
                return super.b();
        }
    }

    @Override // v9.s0
    public final j c(j jVar) {
        switch (this.f4913b) {
            case 0:
                k.e(jVar, "annotations");
                break;
            default:
                k.e(jVar, "annotations");
                break;
        }
        return this.f4914c.c(jVar);
    }

    @Override // v9.s0
    public final p0 d(v vVar) {
        switch (this.f4913b) {
            case 0:
                p0 p0VarD = this.f4914c.d(vVar);
                if (p0VarD == null) {
                    return null;
                }
                g gVarC = vVar.E0().c();
                return a.a.l(p0VarD, gVarC instanceof q0 ? (q0) gVarC : null);
            default:
                return this.f4914c.d(vVar);
        }
    }

    @Override // v9.s0
    public final boolean e() {
        switch (this.f4913b) {
        }
        return this.f4914c.e();
    }

    @Override // v9.s0
    public final v f(int i2, v vVar) {
        switch (this.f4913b) {
            case 0:
                k.e(vVar, "topLevelType");
                x.t(i2, "position");
                break;
            default:
                k.e(vVar, "topLevelType");
                x.t(i2, "position");
                break;
        }
        return this.f4914c.f(i2, vVar);
    }
}
