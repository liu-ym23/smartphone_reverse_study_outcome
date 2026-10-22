package k0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j1 implements Parcelable.ClassLoaderCreator {
    public static k1 a(Parcel parcel, ClassLoader classLoader) {
        y0 y0Var;
        if (classLoader == null) {
            classLoader = j1.class.getClassLoader();
        }
        Object value = parcel.readValue(classLoader);
        int i = parcel.readInt();
        if (i == 0) {
            y0Var = y0.f7137g;
        } else if (i == 1) {
            y0Var = y0.f7139j;
        } else {
            if (i != 2) {
                od.f.e(a.k(i, "Unsupported MutableState policy ", " was restored"));
                return null;
            }
            y0Var = y0.f7138h;
        }
        return new k1(value, y0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return a(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new k1[i];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return a(parcel, classLoader);
    }
}
