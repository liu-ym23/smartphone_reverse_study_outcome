package g3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.stateful.ExtendableSavedState;

/* renamed from: g3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1453a implements Parcelable.ClassLoaderCreator {
    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ExtendableSavedState(parcel, classLoader, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ExtendableSavedState[i];
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new ExtendableSavedState(parcel, null, null);
    }
}
