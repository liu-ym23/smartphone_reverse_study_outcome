package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class SkipPosSeekBar$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SkipPosSeekBar$SavedState> CREATOR = new C0486b(3);

    /* renamed from: a, reason: collision with root package name */
    public int f11782a;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f11782a);
    }
}
