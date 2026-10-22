package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes4.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new StepOSRecyclerView.StepOSSavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new StepOSRecyclerView.StepOSSavedState[i];
    }
}
