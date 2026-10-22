package com.google.android.material.search;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class a implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2507a;

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f2507a) {
            case 0:
                return new SearchBar$SavedState(parcel, classLoader);
            default:
                return new SearchView$SavedState(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2507a) {
            case 0:
                return new SearchBar$SavedState[i];
            default:
                return new SearchView$SavedState[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2507a) {
            case 0:
                return new SearchBar$SavedState(parcel);
            default:
                return new SearchView$SavedState(parcel);
        }
    }
}
