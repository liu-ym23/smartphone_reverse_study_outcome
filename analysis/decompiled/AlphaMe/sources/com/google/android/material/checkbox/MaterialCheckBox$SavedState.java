package com.google.android.material.checkbox;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class MaterialCheckBox$SavedState extends View.BaseSavedState {

    @NonNull
    public static final Parcelable.Creator<MaterialCheckBox$SavedState> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public int f10544a;

    public final String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        int i4 = this.f10544a;
        return g.r(sb, i4 != 1 ? i4 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeValue(Integer.valueOf(this.f10544a));
    }
}
