package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i1 extends u0.w implements Parcelable, u0.n, r2, c1 {
    public static final Parcelable.Creator<i1> CREATOR = new f1(2);

    /* renamed from: f, reason: collision with root package name */
    public l2 f6937f;

    public i1(long j10) {
        u0.f fVarK = u0.m.k();
        l2 l2Var = new l2(fVarK.g(), j10);
        if (!(fVarK instanceof u0.a)) {
            l2Var.f13714b = new l2(1, j10);
        }
        this.f6937f = l2Var;
    }

    @Override // u0.v
    public final u0.x a() {
        return this.f6937f;
    }

    @Override // u0.n
    public final y0 b() {
        return y0.f7139j;
    }

    @Override // u0.v
    public final void c(u0.x xVar) {
        xVar.getClass();
        this.f6937f = (l2) xVar;
    }

    @Override // u0.v
    public final u0.x d(u0.x xVar, u0.x xVar2, u0.x xVar3) {
        if (((l2) xVar2).f6973c == ((l2) xVar3).f6973c) {
            return xVar2;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long g() {
        return ((l2) u0.m.t(this.f6937f, this)).f6973c;
    }

    @Override // k0.r2
    public final Object getValue() {
        return Long.valueOf(g());
    }

    public final void h(long j10) {
        u0.f fVarK;
        l2 l2Var = (l2) u0.m.i(this.f6937f);
        if (l2Var.f6973c != j10) {
            l2 l2Var2 = this.f6937f;
            synchronized (u0.m.f13676c) {
                fVarK = u0.m.k();
                ((l2) u0.m.o(l2Var2, this, fVarK, l2Var)).f6973c = j10;
            }
            u0.m.n(fVarK, this);
        }
    }

    @Override // k0.c1
    public final void setValue(Object obj) {
        h(((Number) obj).longValue());
    }

    public final String toString() {
        return "MutableLongState(value=" + ((l2) u0.m.i(this.f6937f)).f6973c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(g());
    }
}
