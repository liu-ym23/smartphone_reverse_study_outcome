package com.stepos.common.animator;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class n implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        SurroundShaderLayout$SavedState surroundShaderLayout$SavedState = new SurroundShaderLayout$SavedState(parcel);
        surroundShaderLayout$SavedState.f11267a = parcel.readBoolean();
        return surroundShaderLayout$SavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new SurroundShaderLayout$SavedState[i4];
    }
}
