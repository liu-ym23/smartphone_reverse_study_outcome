package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes.dex */
class SlidingPaneLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SlidingPaneLayout$SavedState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4269a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4270b;

    public SlidingPaneLayout$SavedState(Parcel parcel) {
        super(parcel, null);
        this.f4269a = parcel.readInt() != 0;
        this.f4270b = parcel.readInt();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f4269a ? 1 : 0);
        parcel.writeInt(this.f4270b);
    }
}
