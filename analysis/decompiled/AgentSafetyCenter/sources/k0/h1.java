package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 extends u0.w implements Parcelable, u0.n, r2, c1 {
    public static final Parcelable.Creator<h1> CREATOR = new f1(1);

    /* renamed from: f, reason: collision with root package name */
    public k2 f6930f;

    public h1(int i) {
        u0.f fVarK = u0.m.k();
        k2 k2Var = new k2(i, fVarK.g());
        if (!(fVarK instanceof u0.a)) {
            k2Var.f13714b = new k2(i, 1);
        }
        this.f6930f = k2Var;
    }

    @Override // u0.v
    public final u0.x a() {
        return this.f6930f;
    }

    @Override // u0.n
    public final y0 b() {
        return y0.f7139j;
    }

    @Override // u0.v
    public final void c(u0.x xVar) {
        xVar.getClass();
        this.f6930f = (k2) xVar;
    }

    @Override // u0.v
    public final u0.x d(u0.x xVar, u0.x xVar2, u0.x xVar3) {
        if (((k2) xVar2).f6967c == ((k2) xVar3).f6967c) {
            return xVar2;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int g() {
        return ((k2) u0.m.t(this.f6930f, this)).f6967c;
    }

    @Override // k0.r2
    public final Object getValue() {
        return Integer.valueOf(g());
    }

    public final void h(int i) {
        u0.f fVarK;
        k2 k2Var = (k2) u0.m.i(this.f6930f);
        if (k2Var.f6967c != i) {
            k2 k2Var2 = this.f6930f;
            synchronized (u0.m.f13676c) {
                fVarK = u0.m.k();
                ((k2) u0.m.o(k2Var2, this, fVarK, k2Var)).f6967c = i;
            }
            u0.m.n(fVarK, this);
        }
    }

    @Override // k0.c1
    public final void setValue(Object obj) {
        h(((Number) obj).intValue());
    }

    public final String toString() {
        return "MutableIntState(value=" + ((k2) u0.m.i(this.f6930f)).f6967c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(g());
    }
}
