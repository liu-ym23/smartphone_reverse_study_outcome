package g7;

import android.os.Parcel;
import android.os.Parcelable;
import u0.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends t3.b {
    public static final Parcelable.Creator<e> CREATOR = new p(3);

    /* renamed from: c, reason: collision with root package name */
    public int f4360c;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4360c = parcel.readInt();
    }

    @Override // t3.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f4360c);
    }
}
