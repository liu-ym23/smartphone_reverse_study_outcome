package g;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c2 implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2675a;

    public /* synthetic */ c2(int i8) {
        this.f2675a = i8;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f2675a) {
            case 0:
                return new d2(parcel, classLoader);
            case 1:
                if (parcel.readParcelable(classLoader) == null) {
                    return h0.b.f2999b;
                }
                throw new IllegalStateException("superState must be null");
            case 2:
                return new i1.c(parcel, classLoader);
            case 3:
                return new j1.d(parcel, classLoader);
            case 4:
                return new p1.a(parcel, classLoader);
            case 5:
                return new t.f(parcel, classLoader);
            case 6:
                return new u1.d(parcel, classLoader);
            case 7:
                return new v0.j0(parcel, classLoader);
            default:
                return new w1.x(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        switch (this.f2675a) {
            case 0:
                return new d2[i8];
            case 1:
                return new h0.b[i8];
            case 2:
                return new i1.c[i8];
            case 3:
                return new j1.d[i8];
            case 4:
                return new p1.a[i8];
            case 5:
                return new t.f[i8];
            case 6:
                return new u1.d[i8];
            case 7:
                return new v0.j0[i8];
            default:
                return new w1.x[i8];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2675a) {
            case 0:
                return new d2(parcel, null);
            case 1:
                if (parcel.readParcelable(null) == null) {
                    return h0.b.f2999b;
                }
                throw new IllegalStateException("superState must be null");
            case 2:
                return new i1.c(parcel, null);
            case 3:
                return new j1.d(parcel, null);
            case 4:
                return new p1.a(parcel, null);
            case 5:
                return new t.f(parcel, null);
            case 6:
                return new u1.d(parcel, null);
            case 7:
                return new v0.j0(parcel, null);
            default:
                return new w1.x(parcel, null);
        }
    }
}
