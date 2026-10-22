package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes2.dex */
class LottieAnimationView$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<LottieAnimationView$SavedState> CREATOR = new b();
    String animationName;
    int animationResId;
    String imageAssetsFolder;
    boolean isAnimating;
    float progress;
    int repeatCount;
    int repeatMode;

    public /* synthetic */ LottieAnimationView$SavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.animationName);
        parcel.writeFloat(this.progress);
        parcel.writeInt(this.isAnimating ? 1 : 0);
        parcel.writeString(this.imageAssetsFolder);
        parcel.writeInt(this.repeatMode);
        parcel.writeInt(this.repeatCount);
    }

    public LottieAnimationView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private LottieAnimationView$SavedState(Parcel parcel) {
        super(parcel);
        this.animationName = parcel.readString();
        this.progress = parcel.readFloat();
        this.isAnimating = parcel.readInt() == 1;
        this.imageAssetsFolder = parcel.readString();
        this.repeatMode = parcel.readInt();
        this.repeatCount = parcel.readInt();
    }
}
