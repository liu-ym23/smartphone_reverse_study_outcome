package com.google.android.material.checkbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
class MaterialCheckBox$SavedState extends View.BaseSavedState {

    @NonNull
    public static final Parcelable.Creator<MaterialCheckBox$SavedState> CREATOR = new b();
    int checkedState;

    public /* synthetic */ MaterialCheckBox$SavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    @NonNull
    private String getCheckedStateString() {
        int i = this.checkedState;
        return i != 1 ? i != 2 ? "unchecked" : "indeterminate" : "checked";
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        return B7.a.q(sb, getCheckedStateString(), "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Integer.valueOf(this.checkedState));
    }

    public MaterialCheckBox$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private MaterialCheckBox$SavedState(Parcel parcel) {
        super(parcel);
        this.checkedState = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
    }
}
