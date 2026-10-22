package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new android.support.v4.os.a(5);

    /* renamed from: c, reason: collision with root package name */
    public String f1343c;

    /* renamed from: f, reason: collision with root package name */
    public String f1344f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1345g;

    /* renamed from: h, reason: collision with root package name */
    public int f1346h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public String f1347j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1348k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1349l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1350m;

    /* renamed from: n, reason: collision with root package name */
    public Bundle f1351n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1352o;

    /* renamed from: p, reason: collision with root package name */
    public int f1353p;

    /* renamed from: q, reason: collision with root package name */
    public Bundle f1354q;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str = this.f1347j;
        int i = this.i;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f1343c);
        sb2.append(" (");
        sb2.append(this.f1344f);
        sb2.append(")}:");
        if (this.f1345g) {
            sb2.append(" fromLayout");
        }
        if (i != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(i));
        }
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(str);
        }
        if (this.f1348k) {
            sb2.append(" retainInstance");
        }
        if (this.f1349l) {
            sb2.append(" removing");
        }
        if (this.f1350m) {
            sb2.append(" detached");
        }
        if (this.f1352o) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1343c);
        parcel.writeString(this.f1344f);
        parcel.writeInt(this.f1345g ? 1 : 0);
        parcel.writeInt(this.f1346h);
        parcel.writeInt(this.i);
        parcel.writeString(this.f1347j);
        parcel.writeInt(this.f1348k ? 1 : 0);
        parcel.writeInt(this.f1349l ? 1 : 0);
        parcel.writeInt(this.f1350m ? 1 : 0);
        parcel.writeBundle(this.f1351n);
        parcel.writeInt(this.f1352o ? 1 : 0);
        parcel.writeBundle(this.f1354q);
        parcel.writeInt(this.f1353p);
    }
}
