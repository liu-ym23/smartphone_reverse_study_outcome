package x9;

import java.util.Arrays;
import java.util.List;
import o9.n;
import q7.k;
import v9.i0;
import v9.m0;
import v9.v;
import v9.z;
import v9.z0;

/* loaded from: classes.dex */
public final class f extends z {

    /* renamed from: g, reason: collision with root package name */
    public final m0 f11292g;

    /* renamed from: h, reason: collision with root package name */
    public final e f11293h;

    /* renamed from: i, reason: collision with root package name */
    public final h f11294i;

    /* renamed from: j, reason: collision with root package name */
    public final List f11295j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f11296k;

    /* renamed from: l, reason: collision with root package name */
    public final String[] f11297l;

    /* renamed from: m, reason: collision with root package name */
    public final String f11298m;

    public f(m0 m0Var, e eVar, h hVar, List list, boolean z4, String... strArr) {
        k.e(hVar, "kind");
        k.e(list, "arguments");
        k.e(strArr, "formatParams");
        this.f11292g = m0Var;
        this.f11293h = eVar;
        this.f11294i = hVar;
        this.f11295j = list;
        this.f11296k = z4;
        this.f11297l = strArr;
        String str = hVar.f11321f;
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        this.f11298m = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    @Override // v9.v
    public final List C0() {
        return this.f11295j;
    }

    @Override // v9.v
    public final i0 D0() {
        i0.f10557g.getClass();
        return i0.f10558h;
    }

    @Override // v9.v
    public final m0 E0() {
        return this.f11292g;
    }

    @Override // v9.v
    public final boolean F0() {
        return this.f11296k;
    }

    @Override // v9.v
    /* renamed from: G0 */
    public final v J0(w9.g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // v9.z0
    public final z0 J0(w9.g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // v9.z, v9.z0
    public final z0 K0(i0 i0Var) {
        k.e(i0Var, "newAttributes");
        return this;
    }

    @Override // v9.z
    /* renamed from: L0 */
    public final z I0(boolean z4) {
        String[] strArr = this.f11297l;
        return new f(this.f11292g, this.f11293h, this.f11294i, this.f11295j, z4, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // v9.z
    /* renamed from: M0 */
    public final z K0(i0 i0Var) {
        k.e(i0Var, "newAttributes");
        return this;
    }

    @Override // v9.v
    public final n v0() {
        return this.f11293h;
    }
}
