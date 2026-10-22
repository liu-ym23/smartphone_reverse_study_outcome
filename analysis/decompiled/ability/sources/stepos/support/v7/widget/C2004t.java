package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: stepos.support.v7.widget.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2004t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new ActionMenuPresenter$SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ActionMenuPresenter$SavedState[i];
    }
}
