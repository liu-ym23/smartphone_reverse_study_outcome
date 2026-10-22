package l0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class p implements Parcelable.ClassLoaderCreator {
    public static q a(Parcel parcel, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = p.class.getClassLoader();
        }
        int i2 = parcel.readInt();
        if (i2 == 0) {
            return new q();
        }
        f0.g gVarJ = f0.j.f3351g.j();
        for (int i10 = 0; i10 < i2; i10++) {
            gVarJ.add(parcel.readValue(classLoader));
        }
        return new q(gVarJ.h());
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        return new q[i2];
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return a(parcel, null);
    }
}
