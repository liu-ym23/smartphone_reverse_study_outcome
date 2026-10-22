package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.TimePicker;

/* loaded from: classes.dex */
public final class N implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new TimePicker.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new TimePicker.SavedState[i4];
    }
}
