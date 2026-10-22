package v0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s0 implements Parcelable {
    public static final Parcelable.Creator<s0> CREATOR = new a3.a(13);

    /* renamed from: a, reason: collision with root package name */
    public int f5927a;

    /* renamed from: b, reason: collision with root package name */
    public int f5928b;

    /* renamed from: c, reason: collision with root package name */
    public int f5929c;
    public int[] d;

    /* renamed from: e, reason: collision with root package name */
    public int f5930e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f5931f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f5932g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5933h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5934j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5935k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f5927a);
        parcel.writeInt(this.f5928b);
        parcel.writeInt(this.f5929c);
        if (this.f5929c > 0) {
            parcel.writeIntArray(this.d);
        }
        parcel.writeInt(this.f5930e);
        if (this.f5930e > 0) {
            parcel.writeIntArray(this.f5931f);
        }
        parcel.writeInt(this.f5933h ? 1 : 0);
        parcel.writeInt(this.f5934j ? 1 : 0);
        parcel.writeInt(this.f5935k ? 1 : 0);
        parcel.writeList(this.f5932g);
    }
}
