package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
class AbsSpinner$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<AbsSpinner$SavedState> CREATOR = new a();
    int position;
    long selectedId;

    public class a implements Parcelable.Creator<AbsSpinner$SavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbsSpinner$SavedState createFromParcel(Parcel parcel) {
            return new AbsSpinner$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbsSpinner$SavedState[] newArray(int i10) {
            return new AbsSpinner$SavedState[i10];
        }
    }

    public String toString() {
        return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
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
