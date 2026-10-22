package androidx.core.os;

import android.os.Parcel;

/* JADX INFO: loaded from: classes17.dex */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel r100, ClassLoader r101);

    T[] newArray(int r100);
}
