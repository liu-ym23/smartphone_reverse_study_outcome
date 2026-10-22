package androidx.core.os;

import android.os.Parcel;

@Deprecated
/* loaded from: classes.dex */
public interface h<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i5);
}
