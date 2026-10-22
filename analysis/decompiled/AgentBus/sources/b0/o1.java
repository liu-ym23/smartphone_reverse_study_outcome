package b0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class o1 extends l0.w implements Parcelable, l0.n {
    public static final Parcelable.Creator<o1> CREATOR = new n1();

    /* renamed from: g, reason: collision with root package name */
    public final x2 f1255g;

    /* renamed from: h, reason: collision with root package name */
    public w2 f1256h;

    public o1(Object obj, x2 x2Var) {
        this.f1255g = x2Var;
        l0.f fVarK = l0.m.k();
        w2 w2Var = new w2(fVarK.g(), obj);
        if (!(fVarK instanceof l0.a)) {
            w2Var.f5814b = new w2(1, obj);
        }
        this.f1256h = w2Var;
    }

    @Override // l0.v
    public final l0.x a() {
        return this.f1256h;
    }

    @Override // l0.n
    public final x2 b() {
        return this.f1255g;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // l0.v
    public final void f(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.f1256h = (w2) xVar;
    }

    @Override // b0.b3
    public final Object getValue() {
        return ((w2) l0.m.t(this.f1256h, this)).f1392c;
    }

    @Override // l0.v
    public final l0.x h(l0.x xVar, l0.x xVar2, l0.x xVar3) {
        if (this.f1255g.a(((w2) xVar2).f1392c, ((w2) xVar3).f1392c)) {
            return xVar2;
        }
        return null;
    }

    @Override // b0.f1
    public final void setValue(Object obj) {
        l0.f fVarK;
        w2 w2Var = (w2) l0.m.i(this.f1256h);
        if (this.f1255g.a(w2Var.f1392c, obj)) {
            return;
        }
        w2 w2Var2 = this.f1256h;
        synchronized (l0.m.f5774c) {
            fVarK = l0.m.k();
            ((w2) l0.m.o(w2Var2, this, fVarK, w2Var)).f1392c = obj;
        }
        l0.m.n(fVarK, this);
    }

    public final String toString() {
        return "MutableState(value=" + ((w2) l0.m.i(this.f1256h)).f1392c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int i10;
        parcel.writeValue(getValue());
        b1 b1Var = b1.f1108h;
        x2 x2Var = this.f1255g;
        if (q7.k.a(x2Var, b1Var)) {
            i10 = 0;
        } else if (q7.k.a(x2Var, b1.f1111k)) {
            i10 = 1;
        } else {
            if (!q7.k.a(x2Var, b1.f1109i)) {
                throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
            }
            i10 = 2;
        }
        parcel.writeInt(i10);
    }
}
