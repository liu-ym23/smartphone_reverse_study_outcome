package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes2.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Toolbar.SavedState savedState = new Toolbar.SavedState(parcel);
        savedState.f15041a = parcel.readInt();
        savedState.f15042b = parcel.readInt() != 0;
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new Toolbar.SavedState[i4];
    }
}
