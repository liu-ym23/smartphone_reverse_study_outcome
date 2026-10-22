package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.CircularProgressButton;

/* renamed from: com.stepos.common.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0492h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        CircularProgressButton.SavedState savedState = new CircularProgressButton.SavedState(parcel);
        savedState.f11503c = parcel.readInt();
        savedState.f11501a = parcel.readInt() == 1;
        savedState.f11502b = parcel.readInt() == 1;
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new CircularProgressButton.SavedState[i4];
    }
}
