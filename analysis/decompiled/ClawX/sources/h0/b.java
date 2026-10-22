package h0;

import android.os.Parcel;
import android.os.Parcelable;
import g.c2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final Parcelable f3000a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f2999b = new a();
    public static final Parcelable.Creator<b> CREATOR = new c2(1);

    public b() {
        this.f3000a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeParcelable(this.f3000a, i8);
    }

    public b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f3000a = parcelable == f2999b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f3000a = parcelable == null ? f2999b : parcelable;
    }
}
