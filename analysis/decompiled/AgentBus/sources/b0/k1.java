package b0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class k1 extends l0.w implements Parcelable, l0.n, f1, b3 {
    public static final Parcelable.Creator<k1> CREATOR = new j1(0);

    /* renamed from: g, reason: collision with root package name */
    public t2 f1230g;

    public k1(float f10) {
        l0.f fVarK = l0.m.k();
        t2 t2Var = new t2(f10, fVarK.g());
        if (!(fVarK instanceof l0.a)) {
            t2Var.f5814b = new t2(f10, 1);
        }
        this.f1230g = t2Var;
    }

    @Override // l0.v
    public final l0.x a() {
        return this.f1230g;
    }

    @Override // l0.n
    public final x2 b() {
        return b1.f1111k;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(float f10) {
        l0.f fVarK;
        t2 t2Var = (t2) l0.m.i(this.f1230g);
        if (t2Var.f1375c == f10) {
            return;
        }
        t2 t2Var2 = this.f1230g;
        synchronized (l0.m.f5774c) {
            fVarK = l0.m.k();
            ((t2) l0.m.o(t2Var2, this, fVarK, t2Var)).f1375c = f10;
        }
        l0.m.n(fVarK, this);
    }

    @Override // l0.v
    public final void f(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.f1230g = (t2) xVar;
    }

    @Override // b0.b3
    public Object getValue() {
        return Float.valueOf(((t2) l0.m.t(this.f1230g, this)).f1375c);
    }

    @Override // l0.v
    public final l0.x h(l0.x xVar, l0.x xVar2, l0.x xVar3) {
        if (((t2) xVar2).f1375c == ((t2) xVar3).f1375c) {
            return xVar2;
        }
        return null;
    }

    @Override // b0.f1
    public void setValue(Object obj) {
        e(((Number) obj).floatValue());
    }

    public final String toString() {
        return "MutableFloatState(value=" + ((t2) l0.m.i(this.f1230g)).f1375c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(((t2) l0.m.t(this.f1230g, this)).f1375c);
    }
}
