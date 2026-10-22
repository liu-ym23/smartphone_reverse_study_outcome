package com.stepos.common.animator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class SurroundShaderLayout$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SurroundShaderLayout$SavedState> CREATOR = new n();
    public boolean mAnimatorHasStarted;

    public SurroundShaderLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SurroundShaderLayout.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" hasAnimStarted=");
        return B7.a.s(sb, this.mAnimatorHasStarted, "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBoolean(this.mAnimatorHasStarted);
    }

    public SurroundShaderLayout$SavedState(Parcel parcel) {
        super(parcel);
        this.mAnimatorHasStarted = parcel.readBoolean();
    }
}
