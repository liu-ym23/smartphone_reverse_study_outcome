package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.DatePicker;

/* renamed from: com.stepos.common.widget.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1111p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DatePicker.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new DatePicker.SavedState[i];
    }
}
