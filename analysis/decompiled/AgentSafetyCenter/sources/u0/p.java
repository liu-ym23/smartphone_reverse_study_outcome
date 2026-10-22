package u0;

import android.os.Parcel;
import android.os.Parcelable;
import m.t2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13686a;

    public /* synthetic */ p(int i) {
        this.f13686a = i;
    }

    public static q a(Parcel parcel, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = p.class.getClassLoader();
        }
        int i = parcel.readInt();
        if (i == 0) {
            return new q();
        }
        o0.f fVarE = o0.i.f8995g.e();
        for (int i3 = 0; i3 < i; i3++) {
            fVarE.add(parcel.readValue(classLoader));
        }
        return new q(fVarE.c());
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f13686a) {
            case 0:
                return a(parcel, null);
            case 1:
                return new b3.e(parcel, null);
            case 2:
                return new com.google.android.material.appbar.e(parcel, null);
            case 3:
                return new g7.e(parcel, null);
            case 4:
                return new t2(parcel, null);
            case 5:
                if (parcel.readParcelable(null) == null) {
                    return t3.b.EMPTY_STATE;
                }
                od.f.e("superState must be null");
                return null;
            case 6:
                return new t6.a(parcel, null);
            default:
                return new u6.b(parcel, null);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f13686a) {
            case 0:
                return new q[i];
            case 1:
                return new b3.e[i];
            case 2:
                return new com.google.android.material.appbar.e[i];
            case 3:
                return new g7.e[i];
            case 4:
                return new t2[i];
            case 5:
                return new t3.b[i];
            case 6:
                return new t6.a[i];
            default:
                return new u6.b[i];
        }
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f13686a) {
            case 0:
                return a(parcel, classLoader);
            case 1:
                return new b3.e(parcel, classLoader);
            case 2:
                return new com.google.android.material.appbar.e(parcel, classLoader);
            case 3:
                return new g7.e(parcel, classLoader);
            case 4:
                return new t2(parcel, classLoader);
            case 5:
                if (parcel.readParcelable(classLoader) == null) {
                    return t3.b.EMPTY_STATE;
                }
                od.f.e("superState must be null");
                return null;
            case 6:
                return new t6.a(parcel, classLoader);
            default:
                return new u6.b(parcel, classLoader);
        }
    }
}
