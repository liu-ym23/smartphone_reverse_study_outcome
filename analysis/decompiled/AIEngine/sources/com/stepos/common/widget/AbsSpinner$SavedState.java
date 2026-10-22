package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class AbsSpinner$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<AbsSpinner$SavedState> CREATOR = new a();
    int position;
    long selectedId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<AbsSpinner$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final AbsSpinner$SavedState createFromParcel(Parcel parcel) {
            return new AbsSpinner$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AbsSpinner$SavedState[] newArray(int i10) {
            return new AbsSpinner$SavedState[i10];
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AbsSpinner.SavedState{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" selectedId=");
        sb2.append(this.selectedId);
        sb2.append(" position=");
        return ai.onnxruntime.a.j("}", this.position, sb2);
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
