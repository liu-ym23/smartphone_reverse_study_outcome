package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class ProgressBar$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ProgressBar$SavedState> CREATOR = new C1098c(2);
    int progress;
    int secondaryProgress;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.progress);
        parcel.writeInt(this.secondaryProgress);
    }

    public ProgressBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private ProgressBar$SavedState(Parcel parcel) {
        super(parcel);
        this.progress = parcel.readInt();
        this.secondaryProgress = parcel.readInt();
    }
}
