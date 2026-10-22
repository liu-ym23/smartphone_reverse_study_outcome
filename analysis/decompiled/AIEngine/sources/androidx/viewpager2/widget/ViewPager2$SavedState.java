package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ViewPager2$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ViewPager2$SavedState> CREATOR = new a();
    Parcelable mAdapterState;
    int mCurrentItem;
    int mRecyclerViewId;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements Parcelable.ClassLoaderCreator<ViewPager2$SavedState> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new ViewPager2$SavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i10) {
            return new ViewPager2$SavedState[i10];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ViewPager2$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ViewPager2$SavedState(parcel, classLoader);
        }
    }

    public ViewPager2$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        readValues(parcel, classLoader);
    }

    private void readValues(Parcel parcel, ClassLoader classLoader) {
        this.mRecyclerViewId = parcel.readInt();
        this.mCurrentItem = parcel.readInt();
        this.mAdapterState = parcel.readParcelable(classLoader);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.mRecyclerViewId);
        parcel.writeInt(this.mCurrentItem);
        parcel.writeParcelable(this.mAdapterState, i10);
    }

    public ViewPager2$SavedState(Parcel parcel) {
        super(parcel);
        readValues(parcel, null);
    }

    public ViewPager2$SavedState(Parcelable parcelable) {
        super(parcelable);
    }
}
