package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.airbnb.lottie.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0401f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        LottieAnimationView$SavedState lottieAnimationView$SavedState = new LottieAnimationView$SavedState(parcel);
        lottieAnimationView$SavedState.f4534a = parcel.readString();
        lottieAnimationView$SavedState.f4536c = parcel.readFloat();
        lottieAnimationView$SavedState.f4537d = parcel.readInt() == 1;
        lottieAnimationView$SavedState.f4538e = parcel.readString();
        lottieAnimationView$SavedState.f4539f = parcel.readInt();
        lottieAnimationView$SavedState.f4540g = parcel.readInt();
        return lottieAnimationView$SavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new LottieAnimationView$SavedState[i4];
    }
}
