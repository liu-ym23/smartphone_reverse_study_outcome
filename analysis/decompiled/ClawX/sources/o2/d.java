package o2;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a3.a(10);

    /* renamed from: a, reason: collision with root package name */
    public String f4302a;

    /* renamed from: b, reason: collision with root package name */
    public String f4303b;

    /* renamed from: c, reason: collision with root package name */
    public String f4304c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f4302a);
        parcel.writeString(this.f4303b);
        parcel.writeString(this.f4304c);
    }
}
