package y;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new e();

    /* renamed from: c, reason: collision with root package name */
    public final int f15738c;

    public f(int i) {
        this.f15738c = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f15738c == ((f) obj).f15738c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15738c);
    }

    public final String toString() {
        return androidx.activity.b.l(new StringBuilder("DefaultLazyKey(index="), this.f15738c, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15738c);
    }
}
