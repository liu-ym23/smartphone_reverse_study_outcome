package b0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class m1 extends l0.w implements Parcelable, l0.n, f1, b3 {
    public static final Parcelable.Creator<m1> CREATOR = new j1(2);

    /* renamed from: g, reason: collision with root package name */
    public v2 f1241g;

    public m1(long j2) {
        l0.f fVarK = l0.m.k();
        v2 v2Var = new v2(fVarK.g(), j2);
        if (!(fVarK instanceof l0.a)) {
            v2Var.f5814b = new v2(1, j2);
        }
        this.f1241g = v2Var;
    }

    @Override // l0.v
    public final l0.x a() {
        return this.f1241g;
    }

    @Override // l0.n
    public final x2 b() {
        return b1.f1111k;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(long j2) {
        l0.f fVarK;
        v2 v2Var = (v2) l0.m.i(this.f1241g);
        if (v2Var.f1386c != j2) {
            v2 v2Var2 = this.f1241g;
            synchronized (l0.m.f5774c) {
                fVarK = l0.m.k();
                ((v2) l0.m.o(v2Var2, this, fVarK, v2Var)).f1386c = j2;
            }
            l0.m.n(fVarK, this);
        }
    }

    @Override // l0.v
    public final void f(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.f1241g = (v2) xVar;
    }

    @Override // b0.b3
    public Object getValue() {
        return Long.valueOf(((v2) l0.m.t(this.f1241g, this)).f1386c);
    }

    @Override // l0.v
    public final l0.x h(l0.x xVar, l0.x xVar2, l0.x xVar3) {
        if (((v2) xVar2).f1386c == ((v2) xVar3).f1386c) {
            return xVar2;
        }
        return null;
    }

    @Override // b0.f1
    public void setValue(Object obj) {
        e(((Number) obj).longValue());
    }

    public final String toString() {
        return "MutableLongState(value=" + ((v2) l0.m.i(this.f1241g)).f1386c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(((v2) l0.m.t(this.f1241g, this)).f1386c);
    }
}
