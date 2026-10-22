package v0;

import android.os.Parcel;
import android.os.Parcelable;
import g.c2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j0 extends h0.b {
    public static final Parcelable.Creator<j0> CREATOR = new c2(7);

    /* renamed from: c, reason: collision with root package name */
    public Parcelable f5860c;

    public j0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5860c = parcel.readParcelable(classLoader == null ? b0.class.getClassLoader() : classLoader);
    }

    @Override // h0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        parcel.writeParcelable(this.f5860c, 0);
    }
}
