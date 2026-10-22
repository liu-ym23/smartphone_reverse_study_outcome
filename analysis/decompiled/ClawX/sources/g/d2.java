package g;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d2 extends h0.b {
    public static final Parcelable.Creator<d2> CREATOR = new c2(0);

    /* renamed from: c, reason: collision with root package name */
    public int f2689c;
    public boolean d;

    public d2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2689c = parcel.readInt();
        this.d = parcel.readInt() != 0;
    }

    @Override // h0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        parcel.writeInt(this.f2689c);
        parcel.writeInt(this.d ? 1 : 0);
    }
}
