package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class ProgressBar$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ProgressBar$SavedState> CREATOR = new C0486b(2);

    /* renamed from: a, reason: collision with root package name */
    public int f11731a;

    /* renamed from: b, reason: collision with root package name */
    public int f11732b;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f11731a);
        parcel.writeInt(this.f11732b);
    }
}
