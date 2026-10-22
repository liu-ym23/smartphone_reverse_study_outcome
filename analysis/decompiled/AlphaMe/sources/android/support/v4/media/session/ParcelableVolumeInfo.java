package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new C0354a(8);

    /* renamed from: a, reason: collision with root package name */
    public int f2342a;

    /* renamed from: b, reason: collision with root package name */
    public int f2343b;

    /* renamed from: c, reason: collision with root package name */
    public int f2344c;

    /* renamed from: d, reason: collision with root package name */
    public int f2345d;

    /* renamed from: e, reason: collision with root package name */
    public int f2346e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2342a);
        parcel.writeInt(this.f2344c);
        parcel.writeInt(this.f2345d);
        parcel.writeInt(this.f2346e);
        parcel.writeInt(this.f2343b);
    }
}
