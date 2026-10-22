package cc.dd.dd.b0;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new g(1);

    /* renamed from: a, reason: collision with root package name */
    public String f2132a;
    public Object b;

    public l(String str, Object obj) {
        this.f2132a = str;
        this.b = obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2132a);
        parcel.writeValue(this.b);
    }

    public l(Parcel parcel) {
        this.f2132a = parcel.readString();
        this.b = parcel.readValue(l.class.getClassLoader());
    }
}
