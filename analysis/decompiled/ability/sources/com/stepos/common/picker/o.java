package com.stepos.common.picker;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.picker.TimePicker2;

/* loaded from: classes3.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new TimePicker2.SavedStated(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new TimePicker2.SavedStated[i];
    }
}
