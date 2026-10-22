package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC0533m;

/* loaded from: classes.dex */
final class D implements Parcelable {
    public static final Parcelable.Creator<D> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final String f10398a;

    /* renamed from: b, reason: collision with root package name */
    final String f10399b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f10400c;

    /* renamed from: d, reason: collision with root package name */
    final int f10401d;

    /* renamed from: e, reason: collision with root package name */
    final int f10402e;

    /* renamed from: f, reason: collision with root package name */
    final String f10403f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f10404g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f10405h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f10406i;

    /* renamed from: j, reason: collision with root package name */
    final Bundle f10407j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f10408k;

    /* renamed from: l, reason: collision with root package name */
    final int f10409l;

    /* renamed from: m, reason: collision with root package name */
    Bundle f10410m;

    class a implements Parcelable.Creator<D> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public D createFromParcel(Parcel parcel) {
            return new D(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public D[] newArray(int i5) {
            return new D[i5];
        }
    }

    D(ComponentCallbacksC0511f componentCallbacksC0511f) {
        this.f10398a = componentCallbacksC0511f.getClass().getName();
        this.f10399b = componentCallbacksC0511f.f10637f;
        this.f10400c = componentCallbacksC0511f.f10646o;
        this.f10401d = componentCallbacksC0511f.f10655x;
        this.f10402e = componentCallbacksC0511f.f10656y;
        this.f10403f = componentCallbacksC0511f.f10657z;
        this.f10404g = componentCallbacksC0511f.f10607C;
        this.f10405h = componentCallbacksC0511f.f10644m;
        this.f10406i = componentCallbacksC0511f.f10606B;
        this.f10407j = componentCallbacksC0511f.f10638g;
        this.f10408k = componentCallbacksC0511f.f10605A;
        this.f10409l = componentCallbacksC0511f.f10622U.ordinal();
    }

    ComponentCallbacksC0511f a(C0520o c0520o, ClassLoader classLoader) {
        ComponentCallbacksC0511f componentCallbacksC0511fA = c0520o.a(classLoader, this.f10398a);
        Bundle bundle = this.f10407j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        componentCallbacksC0511fA.G1(this.f10407j);
        componentCallbacksC0511fA.f10637f = this.f10399b;
        componentCallbacksC0511fA.f10646o = this.f10400c;
        componentCallbacksC0511fA.f10648q = true;
        componentCallbacksC0511fA.f10655x = this.f10401d;
        componentCallbacksC0511fA.f10656y = this.f10402e;
        componentCallbacksC0511fA.f10657z = this.f10403f;
        componentCallbacksC0511fA.f10607C = this.f10404g;
        componentCallbacksC0511fA.f10644m = this.f10405h;
        componentCallbacksC0511fA.f10606B = this.f10406i;
        componentCallbacksC0511fA.f10605A = this.f10408k;
        componentCallbacksC0511fA.f10622U = AbstractC0533m.b.values()[this.f10409l];
        Bundle bundle2 = this.f10410m;
        if (bundle2 != null) {
            componentCallbacksC0511fA.f10630b = bundle2;
            return componentCallbacksC0511fA;
        }
        componentCallbacksC0511fA.f10630b = new Bundle();
        return componentCallbacksC0511fA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f10398a);
        sb.append(" (");
        sb.append(this.f10399b);
        sb.append(")}:");
        if (this.f10400c) {
            sb.append(" fromLayout");
        }
        if (this.f10402e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f10402e));
        }
        String str = this.f10403f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f10403f);
        }
        if (this.f10404g) {
            sb.append(" retainInstance");
        }
        if (this.f10405h) {
            sb.append(" removing");
        }
        if (this.f10406i) {
            sb.append(" detached");
        }
        if (this.f10408k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f10398a);
        parcel.writeString(this.f10399b);
        parcel.writeInt(this.f10400c ? 1 : 0);
        parcel.writeInt(this.f10401d);
        parcel.writeInt(this.f10402e);
        parcel.writeString(this.f10403f);
        parcel.writeInt(this.f10404g ? 1 : 0);
        parcel.writeInt(this.f10405h ? 1 : 0);
        parcel.writeInt(this.f10406i ? 1 : 0);
        parcel.writeBundle(this.f10407j);
        parcel.writeInt(this.f10408k ? 1 : 0);
        parcel.writeBundle(this.f10410m);
        parcel.writeInt(this.f10409l);
    }

    D(Parcel parcel) {
        this.f10398a = parcel.readString();
        this.f10399b = parcel.readString();
        this.f10400c = parcel.readInt() != 0;
        this.f10401d = parcel.readInt();
        this.f10402e = parcel.readInt();
        this.f10403f = parcel.readString();
        this.f10404g = parcel.readInt() != 0;
        this.f10405h = parcel.readInt() != 0;
        this.f10406i = parcel.readInt() != 0;
        this.f10407j = parcel.readBundle();
        this.f10408k = parcel.readInt() != 0;
        this.f10410m = parcel.readBundle();
        this.f10409l = parcel.readInt();
    }
}
