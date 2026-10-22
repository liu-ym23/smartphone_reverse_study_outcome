package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k1 extends u0.w implements Parcelable, u0.n {
    public static final Parcelable.Creator<k1> CREATOR = new j1();

    /* renamed from: f, reason: collision with root package name */
    public y0 f6965f;

    /* renamed from: g, reason: collision with root package name */
    public m2 f6966g;

    public k1(Object obj, y0 y0Var) {
        this.f6965f = y0Var;
        u0.f fVarK = u0.m.k();
        m2 m2Var = new m2(obj, fVarK.g());
        if (!(fVarK instanceof u0.a)) {
            m2Var.f13714b = new m2(obj, 1);
        }
        this.f6966g = m2Var;
    }

    @Override // u0.v
    public final u0.x a() {
        return this.f6966g;
    }

    @Override // u0.n
    public final y0 b() {
        return this.f6965f;
    }

    @Override // u0.v
    public final void c(u0.x xVar) {
        xVar.getClass();
        this.f6966g = (m2) xVar;
    }

    @Override // u0.v
    public final u0.x d(u0.x xVar, u0.x xVar2, u0.x xVar3) {
        if (this.f6965f.b(((m2) xVar2).f6979c, ((m2) xVar3).f6979c)) {
            return xVar2;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // k0.r2
    public final Object getValue() {
        return ((m2) u0.m.t(this.f6966g, this)).f6979c;
    }

    @Override // k0.c1
    public final void setValue(Object obj) {
        u0.f fVarK;
        m2 m2Var = (m2) u0.m.i(this.f6966g);
        if (this.f6965f.b(m2Var.f6979c, obj)) {
            return;
        }
        m2 m2Var2 = this.f6966g;
        synchronized (u0.m.f13676c) {
            fVarK = u0.m.k();
            ((m2) u0.m.o(m2Var2, this, fVarK, m2Var)).f6979c = obj;
        }
        u0.m.n(fVarK, this);
    }

    public final String toString() {
        return "MutableState(value=" + ((m2) u0.m.i(this.f6966g)).f6979c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i3;
        parcel.writeValue(getValue());
        y0 y0Var = this.f6965f;
        if (yb.k.a(y0Var, y0.f7137g)) {
            i3 = 0;
        } else if (yb.k.a(y0Var, y0.f7139j)) {
            i3 = 1;
        } else {
            if (!yb.k.a(y0Var, y0.f7138h)) {
                od.f.e("Only known types of MutableState's SnapshotMutationPolicy are supported");
                return;
            }
            i3 = 2;
        }
        parcel.writeInt(i3);
    }
}
