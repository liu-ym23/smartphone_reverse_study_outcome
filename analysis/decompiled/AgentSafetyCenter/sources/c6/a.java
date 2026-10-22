package c6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.os.a(6);

    /* renamed from: c, reason: collision with root package name */
    public final String f2207c;

    /* renamed from: f, reason: collision with root package name */
    public final Map f2208f;

    public a(String str, Map map) {
        this.f2207c = str;
        this.f2208f = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f2207c, aVar.f2207c) && k.a(this.f2208f, aVar.f2208f);
    }

    public final int hashCode() {
        return this.f2208f.hashCode() + (this.f2207c.hashCode() * 31);
    }

    public final String toString() {
        return "Key(key=" + this.f2207c + ", extras=" + this.f2208f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2207c);
        Map map = this.f2208f;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            parcel.writeString(str);
            parcel.writeString(str2);
        }
    }
}
