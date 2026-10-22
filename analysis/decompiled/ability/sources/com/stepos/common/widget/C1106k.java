package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.common.widget.CircularProgressButton;

/* renamed from: com.stepos.common.widget.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1106k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new CircularProgressButton.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new CircularProgressButton.SavedState[i];
    }
}
