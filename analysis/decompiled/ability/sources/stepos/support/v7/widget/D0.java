package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes4.dex */
public final class D0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new Toolbar.SavedState[i];
    }
}
