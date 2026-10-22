package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: stepos.support.v7.widget.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0896p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.f14795a = parcel.readInt();
        return actionMenuPresenter$SavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new ActionMenuPresenter$SavedState[i4];
    }
}
