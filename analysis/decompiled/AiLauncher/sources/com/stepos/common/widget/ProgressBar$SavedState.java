package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class ProgressBar$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ProgressBar$SavedState> CREATOR = new a();
    int progress;
    int secondaryProgress;

    public class a implements Parcelable.Creator<ProgressBar$SavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProgressBar$SavedState createFromParcel(Parcel parcel) {
            return new ProgressBar$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProgressBar$SavedState[] newArray(int i10) {
            return new ProgressBar$SavedState[i10];
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
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
