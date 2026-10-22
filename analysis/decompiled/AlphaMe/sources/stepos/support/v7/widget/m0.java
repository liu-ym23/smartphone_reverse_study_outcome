package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes2.dex */
public final class m0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        StepOSRecyclerView.StepOSSavedState stepOSSavedState = new StepOSRecyclerView.StepOSSavedState(parcel);
        stepOSSavedState.f14980a = parcel.readByte() != 0;
        stepOSSavedState.f14981b = parcel.readInt();
        stepOSSavedState.f14982c = parcel.readSparseBooleanArray();
        int i4 = parcel.readInt();
        if (i4 > 0) {
            stepOSSavedState.f14983d = new q.i();
            for (int i5 = 0; i5 < i4; i5++) {
                stepOSSavedState.f14983d.f(parcel.readLong(), Integer.valueOf(parcel.readInt()));
            }
        }
        return stepOSSavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new StepOSRecyclerView.StepOSSavedState[i4];
    }
}
