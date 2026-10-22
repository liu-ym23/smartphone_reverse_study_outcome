package p1;

import android.os.Parcel;
import android.os.Parcelable;
import g.c2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends h0.b {
    public static final Parcelable.Creator<a> CREATOR = new c2(4);

    /* renamed from: c, reason: collision with root package name */
    public boolean f4662c;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4662c = parcel.readInt() == 1;
    }

    @Override // h0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        parcel.writeInt(this.f4662c ? 1 : 0);
    }
}
