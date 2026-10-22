package b0;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class n1 implements Parcelable.ClassLoaderCreator {
    public static o1 a(Parcel parcel, ClassLoader classLoader) {
        b1 b1Var;
        if (classLoader == null) {
            classLoader = n1.class.getClassLoader();
        }
        Object value = parcel.readValue(classLoader);
        int i2 = parcel.readInt();
        if (i2 == 0) {
            b1Var = b1.f1108h;
        } else if (i2 == 1) {
            b1Var = b1.f1111k;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException(a1.a.f(i2, "Unsupported MutableState policy ", " was restored"));
            }
            b1Var = b1.f1109i;
        }
        return new o1(value, b1Var);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        return new o1[i2];
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return a(parcel, null);
    }
}
