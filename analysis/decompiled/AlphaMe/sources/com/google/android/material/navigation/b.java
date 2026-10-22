package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10872a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f10872a) {
            case 0:
                return new NavigationBarView$SavedState(parcel, classLoader);
            default:
                return new NavigationView$SavedState(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f10872a) {
            case 0:
                return new NavigationBarView$SavedState[i4];
            default:
                return new NavigationView$SavedState[i4];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10872a) {
            case 0:
                return new NavigationBarView$SavedState(parcel, null);
            default:
                return new NavigationView$SavedState(parcel, null);
        }
    }
}
