package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.DatePicker;

/* renamed from: com.stepos.common.widget.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0495k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DatePicker.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new DatePicker.SavedState[i4];
    }
}
