package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new LottieAnimationView$SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new LottieAnimationView$SavedState[i];
    }
}
