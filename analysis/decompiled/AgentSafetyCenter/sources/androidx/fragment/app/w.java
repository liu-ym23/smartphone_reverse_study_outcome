package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements Parcelable {
    public static final Parcelable.Creator<w> CREATOR = new android.support.v4.os.a(4);

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f1330c;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f1331f;

    /* renamed from: g, reason: collision with root package name */
    public b[] f1332g;

    /* renamed from: h, reason: collision with root package name */
    public int f1333h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f1334j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f1335k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f1336l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f1330c);
        parcel.writeStringList(this.f1331f);
        parcel.writeTypedArray(this.f1332g, i);
        parcel.writeInt(this.f1333h);
        parcel.writeString(this.i);
        parcel.writeStringList(this.f1334j);
        parcel.writeTypedList(this.f1335k);
        parcel.writeTypedList(this.f1336l);
    }
}
