package v0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new a3.a(11);

    /* renamed from: a, reason: collision with root package name */
    public int f5918a;

    /* renamed from: b, reason: collision with root package name */
    public int f5919b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5920c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f5918a);
        parcel.writeInt(this.f5919b);
        parcel.writeInt(this.f5920c ? 1 : 0);
    }
}
