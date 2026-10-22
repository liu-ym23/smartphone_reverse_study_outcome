package b0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class l1 extends l0.w implements Parcelable, l0.n, f1, b3 {
    public static final Parcelable.Creator<l1> CREATOR = new j1(1);

    /* renamed from: g, reason: collision with root package name */
    public u2 f1235g;

    public l1(int i2) {
        l0.f fVarK = l0.m.k();
        u2 u2Var = new u2(fVarK.g(), i2);
        if (!(fVarK instanceof l0.a)) {
            u2Var.f5814b = new u2(1, i2);
        }
        this.f1235g = u2Var;
    }

    @Override // l0.v
    public final l0.x a() {
        return this.f1235g;
    }

    @Override // l0.n
    public final x2 b() {
        return b1.f1111k;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int e() {
        return ((u2) l0.m.t(this.f1235g, this)).f1378c;
    }

    @Override // l0.v
    public final void f(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.f1235g = (u2) xVar;
    }

    public final void g(int i2) {
        l0.f fVarK;
        u2 u2Var = (u2) l0.m.i(this.f1235g);
        if (u2Var.f1378c != i2) {
            u2 u2Var2 = this.f1235g;
            synchronized (l0.m.f5774c) {
                fVarK = l0.m.k();
                ((u2) l0.m.o(u2Var2, this, fVarK, u2Var)).f1378c = i2;
            }
            l0.m.n(fVarK, this);
        }
    }

    @Override // b0.b3
    public Object getValue() {
        return Integer.valueOf(e());
    }

    @Override // l0.v
    public final l0.x h(l0.x xVar, l0.x xVar2, l0.x xVar3) {
        if (((u2) xVar2).f1378c == ((u2) xVar3).f1378c) {
            return xVar2;
        }
        return null;
    }

    @Override // b0.f1
    public void setValue(Object obj) {
        g(((Number) obj).intValue());
    }

    public final String toString() {
        return "MutableIntState(value=" + ((u2) l0.m.i(this.f1235g)).f1378c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(e());
    }
}
