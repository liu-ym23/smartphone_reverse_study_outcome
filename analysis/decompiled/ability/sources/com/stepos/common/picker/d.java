package com.stepos.common.picker;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.picker.DatePicker2;

/* loaded from: classes3.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DatePicker2.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new DatePicker2.SavedState[i];
    }
}
