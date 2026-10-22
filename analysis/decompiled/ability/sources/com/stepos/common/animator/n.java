package com.stepos.common.animator;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class n implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new SurroundShaderLayout$SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new SurroundShaderLayout$SavedState[i];
    }
}
