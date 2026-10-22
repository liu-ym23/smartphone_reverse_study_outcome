package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class AbsSpinner$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<AbsSpinner$SavedState> CREATOR = new C1098c(0);
    int position;
    long selectedId;

    public String toString() {
        StringBuilder sb = new StringBuilder("AbsSpinner.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" selectedId=");
        sb.append(this.selectedId);
        sb.append(" position=");
        return androidx.appfunctions.metadata.a.o(sb, "}", this.position);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.selectedId);
        parcel.writeInt(this.position);
    }

    public AbsSpinner$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private AbsSpinner$SavedState(Parcel parcel) {
        super(parcel);
        this.selectedId = parcel.readLong();
        this.position = parcel.readInt();
    }
}
