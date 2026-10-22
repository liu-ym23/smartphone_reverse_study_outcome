package t6;

import android.os.Parcel;
import android.os.Parcelable;
import u0.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends t3.b {
    public static final Parcelable.Creator<a> CREATOR = new p(6);

    /* renamed from: c, reason: collision with root package name */
    public int f13199c;

    /* renamed from: f, reason: collision with root package name */
    public int f13200f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13201g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13202h;
    public boolean i;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f13199c = parcel.readInt();
        this.f13200f = parcel.readInt();
        this.f13201g = parcel.readInt() == 1;
        this.f13202h = parcel.readInt() == 1;
        this.i = parcel.readInt() == 1;
    }

    @Override // t3.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f13199c);
        parcel.writeInt(this.f13200f);
        parcel.writeInt(this.f13201g ? 1 : 0);
        parcel.writeInt(this.f13202h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
    }
}
