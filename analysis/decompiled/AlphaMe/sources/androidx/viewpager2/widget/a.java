package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class a implements Parcelable.ClassLoaderCreator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ViewPager2$SavedState viewPager2$SavedState = new ViewPager2$SavedState(parcel, null);
        viewPager2$SavedState.f4307a = parcel.readInt();
        viewPager2$SavedState.f4308b = parcel.readInt();
        viewPager2$SavedState.f4309c = parcel.readParcelable(null);
        return viewPager2$SavedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        return new ViewPager2$SavedState[i4];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        ViewPager2$SavedState viewPager2$SavedState = new ViewPager2$SavedState(parcel, classLoader);
        viewPager2$SavedState.f4307a = parcel.readInt();
        viewPager2$SavedState.f4308b = parcel.readInt();
        viewPager2$SavedState.f4309c = parcel.readParcelable(classLoader);
        return viewPager2$SavedState;
    }
}
