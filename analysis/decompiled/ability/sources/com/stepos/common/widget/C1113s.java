package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.DayTimeDatePicker;

/* renamed from: com.stepos.common.widget.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1113s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DayTimeDatePicker.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new DayTimeDatePicker.SavedState[i];
    }
}
