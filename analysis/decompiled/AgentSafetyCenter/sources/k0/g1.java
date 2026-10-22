package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g1 extends u0.w implements Parcelable, u0.n, r2, c1 {
    public static final Parcelable.Creator<g1> CREATOR = new f1(0);

    /* renamed from: f, reason: collision with root package name */
    public j2 f6919f;

    public g1(float f5) {
        u0.f fVarK = u0.m.k();
        j2 j2Var = new j2(f5, fVarK.g());
        if (!(fVarK instanceof u0.a)) {
            j2Var.f13714b = new j2(f5, 1);
        }
        this.f6919f = j2Var;
    }

    @Override // u0.v
    public final u0.x a() {
        return this.f6919f;
    }

    @Override // u0.n
    public final y0 b() {
        return y0.f7139j;
    }

    @Override // u0.v
    public final void c(u0.x xVar) {
        xVar.getClass();
        this.f6919f = (j2) xVar;
    }

    @Override // u0.v
    public final u0.x d(u0.x xVar, u0.x xVar2, u0.x xVar3) {
        if (((j2) xVar2).f6964c == ((j2) xVar3).f6964c) {
            return xVar2;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float g() {
        return ((j2) u0.m.t(this.f6919f, this)).f6964c;
    }

    @Override // k0.r2
    public final Object getValue() {
        return Float.valueOf(g());
    }

    public final void h(float f5) {
        u0.f fVarK;
        j2 j2Var = (j2) u0.m.i(this.f6919f);
        if (j2Var.f6964c == f5) {
            return;
        }
        j2 j2Var2 = this.f6919f;
        synchronized (u0.m.f13676c) {
            fVarK = u0.m.k();
            ((j2) u0.m.o(j2Var2, this, fVarK, j2Var)).f6964c = f5;
        }
        u0.m.n(fVarK, this);
    }

    @Override // k0.c1
    public final void setValue(Object obj) {
        h(((Number) obj).floatValue());
    }

    public final String toString() {
        return "MutableFloatState(value=" + ((j2) u0.m.i(this.f6919f)).f6964c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(g());
    }
}
