package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.preference.EditTextPreference;

/* renamed from: androidx.preference.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0332d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new EditTextPreference.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new EditTextPreference.SavedState[i4];
    }
}
