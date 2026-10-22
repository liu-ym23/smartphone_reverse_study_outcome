package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.ListPreference;

/* renamed from: androidx.preference.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0335g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new ListPreference.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new ListPreference.SavedState[i4];
    }
}
