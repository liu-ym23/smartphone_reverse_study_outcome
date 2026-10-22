package com.stepos.common.animator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class SurroundShaderLayout$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SurroundShaderLayout$SavedState> CREATOR = new a();
    public boolean mAnimatorHasStarted;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<SurroundShaderLayout$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final SurroundShaderLayout$SavedState createFromParcel(Parcel parcel) {
            return new SurroundShaderLayout$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SurroundShaderLayout$SavedState[] newArray(int i10) {
            return new SurroundShaderLayout$SavedState[i10];
        }
    }

    public SurroundShaderLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SurroundShaderLayout.SavedState{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" hasAnimStarted=");
        return a0.a.m(sb2, this.mAnimatorHasStarted, "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeBoolean(this.mAnimatorHasStarted);
    }

    public SurroundShaderLayout$SavedState(Parcel parcel) {
        super(parcel);
        this.mAnimatorHasStarted = parcel.readBoolean();
    }
}
