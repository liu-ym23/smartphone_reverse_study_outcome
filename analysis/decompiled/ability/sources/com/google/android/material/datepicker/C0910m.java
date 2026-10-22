package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.material.datepicker.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0910m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new DateValidatorPointForward(parcel.readLong(), null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new DateValidatorPointForward[i];
    }
}
