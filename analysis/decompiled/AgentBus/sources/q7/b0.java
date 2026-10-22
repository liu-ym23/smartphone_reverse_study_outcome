package q7;

import java.util.List;

/* loaded from: classes.dex */
public final class b0 implements w7.u {

    /* renamed from: f, reason: collision with root package name */
    public final w7.e f8797f;

    /* renamed from: g, reason: collision with root package name */
    public final List f8798g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8799h;

    public b0(w7.e eVar, List list, boolean z4) {
        k.e(eVar, "classifier");
        k.e(list, "arguments");
        this.f8797f = eVar;
        this.f8798g = list;
        this.f8799h = z4 ? 1 : 0;
    }

    public final String a(boolean z4) {
        String name;
        w7.e eVar = this.f8797f;
        w7.d dVar = eVar instanceof w7.d ? (w7.d) eVar : null;
        Class clsT = dVar != null ? nb.i.t(dVar) : null;
        if (clsT == null) {
            name = eVar.toString();
        } else if (clsT.isArray()) {
            name = clsT.equals(boolean[].class) ? "kotlin.BooleanArray" : clsT.equals(char[].class) ? "kotlin.CharArray" : clsT.equals(byte[].class) ? "kotlin.ByteArray" : clsT.equals(short[].class) ? "kotlin.ShortArray" : clsT.equals(int[].class) ? "kotlin.IntArray" : clsT.equals(float[].class) ? "kotlin.FloatArray" : clsT.equals(long[].class) ? "kotlin.LongArray" : clsT.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
        } else if (z4 && clsT.isPrimitive()) {
            k.c(eVar, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = nb.i.u((w7.d) eVar).getName();
        } else {
            name = clsT.getName();
        }
        return a1.a.x(name, this.f8798g.isEmpty() ? "" : d7.r.U0(this.f8798g, ", ", "<", ">", new a5.a(19, this), 24), p() ? "?" : "");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return k.a(this.f8797f, b0Var.f8797f) && k.a(this.f8798g, b0Var.f8798g) && this.f8799h == b0Var.f8799h;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8799h) + m.x.h(this.f8798g, this.f8797f.hashCode() * 31, 31);
    }

    @Override // w7.u
    public final List k() {
        return this.f8798g;
    }

    @Override // w7.u
    public final boolean p() {
        return (this.f8799h & 1) != 0;
    }

    @Override // w7.u
    public final w7.e q() {
        return this.f8797f;
    }

    public final String toString() {
        return a(false) + " (Kotlin reflection is not available)";
    }

    @Override // w7.b
    public final List w() {
        throw null;
    }
}
