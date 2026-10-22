package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class SkipPosSeekBar$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SkipPosSeekBar$SavedState> CREATOR = new a();
    int realProgress;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<SkipPosSeekBar$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final SkipPosSeekBar$SavedState createFromParcel(Parcel parcel) {
            return new SkipPosSeekBar$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SkipPosSeekBar$SavedState[] newArray(int i10) {
            return new SkipPosSeekBar$SavedState[i10];
        }
    }

    public SkipPosSeekBar$SavedState(Parcel parcel) {
        super(parcel);
        this.realProgress = parcel.readInt();
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.realProgress);
    }

    public SkipPosSeekBar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
