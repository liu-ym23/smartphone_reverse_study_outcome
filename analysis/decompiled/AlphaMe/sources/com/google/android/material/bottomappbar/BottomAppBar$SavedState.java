package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes.dex */
class BottomAppBar$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<BottomAppBar$SavedState> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f10402a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10403b;

    public BottomAppBar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f10402a = parcel.readInt();
        this.f10403b = parcel.readInt() != 0;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f10402a);
        parcel.writeInt(this.f10403b ? 1 : 0);
    }
}
