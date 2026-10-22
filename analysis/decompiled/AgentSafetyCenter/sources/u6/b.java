package u6;

import android.os.Parcel;
import android.os.Parcelable;
import u0.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends t3.b {
    public static final Parcelable.Creator<b> CREATOR = new p(7);

    /* renamed from: c, reason: collision with root package name */
    public boolean f14107c;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            b.class.getClassLoader();
        }
        this.f14107c = parcel.readInt() == 1;
    }

    @Override // t3.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f14107c ? 1 : 0);
    }
}
