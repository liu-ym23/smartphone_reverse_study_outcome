package com.stepos.common.animator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class SurroundShaderLayout$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SurroundShaderLayout$SavedState> CREATOR = new n();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11267a;

    public final String toString() {
        return "SurroundShaderLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " hasAnimStarted=" + this.f11267a + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeBoolean(this.f11267a);
    }
}
