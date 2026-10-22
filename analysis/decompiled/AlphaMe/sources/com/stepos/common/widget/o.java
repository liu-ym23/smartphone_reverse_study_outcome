package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.DayTimeDatePicker;

/* loaded from: classes.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DayTimeDatePicker.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new DayTimeDatePicker.SavedState[i4];
    }
}
