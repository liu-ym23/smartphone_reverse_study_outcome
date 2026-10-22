package w9;

import java.util.List;
import v9.i0;
import v9.m0;
import v9.p0;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public final class i extends z implements y9.d {

    /* renamed from: g, reason: collision with root package name */
    public final y9.b f10935g;

    /* renamed from: h, reason: collision with root package name */
    public final j f10936h;

    /* renamed from: i, reason: collision with root package name */
    public final z0 f10937i;

    /* renamed from: j, reason: collision with root package name */
    public final i0 f10938j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10939k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f10940l;

    public i(y9.b bVar, j jVar, z0 z0Var, i0 i0Var, boolean z4, boolean z10) {
        q7.k.e(bVar, "captureStatus");
        q7.k.e(jVar, "constructor");
        q7.k.e(i0Var, "attributes");
        this.f10935g = bVar;
        this.f10936h = jVar;
        this.f10937i = z0Var;
        this.f10938j = i0Var;
        this.f10939k = z4;
        this.f10940l = z10;
    }

    @Override // v9.v
    public final List C0() {
        return d7.z.f2978f;
    }

    @Override // v9.v
    public final i0 D0() {
        return this.f10938j;
    }

    @Override // v9.v
    public final m0 E0() {
        return this.f10936h;
    }

    @Override // v9.v
    public final boolean F0() {
        return this.f10939k;
    }

    @Override // v9.z, v9.z0
    public final z0 I0(boolean z4) {
        return new i(this.f10935g, this.f10936h, this.f10937i, this.f10938j, z4, 32);
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        return new i(this.f10935g, this.f10936h, this.f10937i, this.f10938j, z4, 32);
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        q7.k.e(i0Var, "newAttributes");
        return new i(this.f10935g, this.f10936h, this.f10937i, i0Var, this.f10939k, this.f10940l);
    }

    @Override // v9.z0
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public final i G0(g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        j jVar = this.f10936h;
        jVar.getClass();
        p0 p0VarD = jVar.f10941a.d(gVar);
        a8.e eVar = jVar.f10942b != null ? new a8.e(22, jVar, gVar) : null;
        j jVar2 = jVar.f10943c;
        if (jVar2 == null) {
            jVar2 = jVar;
        }
        j jVar3 = new j(p0VarD, eVar, jVar2, jVar.f10944d);
        z0 z0Var = this.f10937i;
        return new i(this.f10935g, jVar3, z0Var != null ? z0Var : null, this.f10938j, this.f10939k, 32);
    }

    @Override // v9.v
    public final o9.n v0() {
        return x9.i.a(1, true, new String[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i(y9.b bVar, j jVar, z0 z0Var, i0 i0Var, boolean z4, int i2) {
        if ((i2 & 8) != 0) {
            i0.f10557g.getClass();
            i0Var = i0.f10558h;
        }
        this(bVar, jVar, z0Var, i0Var, (i2 & 16) != 0 ? false : z4, false);
    }
}
