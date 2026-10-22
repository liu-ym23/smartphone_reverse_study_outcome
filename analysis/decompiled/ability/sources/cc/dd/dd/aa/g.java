package cc.dd.dd.aa;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new L.g(0);

    /* renamed from: a, reason: collision with root package name */
    public String f2130a;
    public Object b;

    public g(String str, Object obj) {
        this.f2130a = str;
        this.b = obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2130a);
        parcel.writeValue(this.b);
    }

    public g(Parcel parcel) {
        this.f2130a = parcel.readString();
        this.b = parcel.readValue(g.class.getClassLoader());
    }
}
