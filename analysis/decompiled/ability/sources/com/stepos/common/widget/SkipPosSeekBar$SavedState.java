package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class SkipPosSeekBar$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SkipPosSeekBar$SavedState> CREATOR = new C1098c(3);
    int realProgress;

    public SkipPosSeekBar$SavedState(Parcel parcel) {
        super(parcel);
        this.realProgress = parcel.readInt();
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.realProgress);
    }

    public SkipPosSeekBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
