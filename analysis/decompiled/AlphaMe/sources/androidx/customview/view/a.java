package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout$SavedState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.stateful.ExtendableSavedState;

/* loaded from: classes.dex */
public final class a implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3383a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f3383a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return AbsSavedState.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new DrawerLayout$SavedState(parcel, classLoader);
            case 2:
                return new ParcelableSparseArray(parcel, classLoader);
            default:
                return new ExtendableSavedState(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f3383a) {
            case 0:
                return new AbsSavedState[i4];
            case 1:
                return new DrawerLayout$SavedState[i4];
            case 2:
                return new ParcelableSparseArray[i4];
            default:
                return new ExtendableSavedState[i4];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3383a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return AbsSavedState.EMPTY_STATE;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new DrawerLayout$SavedState(parcel, null);
            case 2:
                return new ParcelableSparseArray(parcel, null);
            default:
                return new ExtendableSavedState(parcel, null);
        }
    }
}
