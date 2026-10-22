package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0215n implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3125a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3125a) {
            case 0:
                ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
                actionMenuPresenter$SavedState.f2785a = parcel.readInt();
                return actionMenuPresenter$SavedState;
            default:
                AppCompatSpinner$SavedState appCompatSpinner$SavedState = new AppCompatSpinner$SavedState(parcel);
                appCompatSpinner$SavedState.f2799a = parcel.readByte() != 0;
                return appCompatSpinner$SavedState;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f3125a) {
            case 0:
                return new ActionMenuPresenter$SavedState[i4];
            default:
                return new AppCompatSpinner$SavedState[i4];
        }
    }
}
