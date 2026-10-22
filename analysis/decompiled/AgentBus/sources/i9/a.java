package i9;

import java.util.List;
import o9.n;
import q7.k;
import v9.i0;
import v9.m0;
import v9.p0;
import v9.v;
import v9.z;
import v9.z0;
import w9.g;
import x9.i;

/* loaded from: classes.dex */
public final class a extends z implements y9.d {

    /* renamed from: g, reason: collision with root package name */
    public final p0 f4907g;

    /* renamed from: h, reason: collision with root package name */
    public final c f4908h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4909i;

    /* renamed from: j, reason: collision with root package name */
    public final i0 f4910j;

    public a(p0 p0Var, c cVar, boolean z4, i0 i0Var) {
        k.e(p0Var, "typeProjection");
        k.e(i0Var, "attributes");
        this.f4907g = p0Var;
        this.f4908h = cVar;
        this.f4909i = z4;
        this.f4910j = i0Var;
    }

    @Override // v9.v
    public final List C0() {
        return d7.z.f2978f;
    }

    @Override // v9.v
    public final i0 D0() {
        return this.f4910j;
    }

    @Override // v9.v
    public final m0 E0() {
        return this.f4908h;
    }

    @Override // v9.v
    public final boolean F0() {
        return this.f4909i;
    }

    @Override // v9.v
    public final v G0(g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        return new a(this.f4907g.d(gVar), this.f4908h, this.f4909i, this.f4910j);
    }

    @Override // v9.z, v9.z0
    public final z0 I0(boolean z4) {
        if (z4 == this.f4909i) {
            return this;
        }
        return new a(this.f4907g, this.f4908h, z4, this.f4910j);
    }

    @Override // v9.z0
    /* renamed from: J0 */
    public final z0 G0(g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        return new a(this.f4907g.d(gVar), this.f4908h, this.f4909i, this.f4910j);
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        if (z4 == this.f4909i) {
            return this;
        }
        return new a(this.f4907g, this.f4908h, z4, this.f4910j);
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        k.e(i0Var, "newAttributes");
        return new a(this.f4907g, this.f4908h, this.f4909i, i0Var);
    }

    @Override // v9.z
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Captured(");
        sb2.append(this.f4907g);
        sb2.append(')');
        sb2.append(this.f4909i ? "?" : "");
        return sb2.toString();
    }

    @Override // v9.v
    public final n v0() {
        return i.a(1, true, new String[0]);
    }
}
