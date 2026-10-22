package com.stepos.common.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import s.AbstractC0831a;

/* loaded from: classes.dex */
class AbsSpinner$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<AbsSpinner$SavedState> CREATOR = new C0486b(0);

    /* renamed from: a, reason: collision with root package name */
    public long f11441a;

    /* renamed from: b, reason: collision with root package name */
    public int f11442b;

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbsSpinner.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" selectedId=");
        sb.append(this.f11441a);
        sb.append(" position=");
        return AbstractC0831a.d(sb, this.f11442b, "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeLong(this.f11441a);
        parcel.writeInt(this.f11442b);
    }
}
