package m;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t2 extends t3.b {
    public static final Parcelable.Creator<t2> CREATOR = new u0.p(4);

    /* renamed from: c, reason: collision with root package name */
    public int f8079c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8080f;

    public t2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8079c = parcel.readInt();
        this.f8080f = parcel.readInt() != 0;
    }

    @Override // t3.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f8079c);
        parcel.writeInt(this.f8080f ? 1 : 0);
    }
}
