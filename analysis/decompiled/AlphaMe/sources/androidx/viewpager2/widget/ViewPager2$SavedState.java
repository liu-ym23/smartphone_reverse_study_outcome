package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class ViewPager2$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<ViewPager2$SavedState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f4307a;

    /* renamed from: b, reason: collision with root package name */
    public int f4308b;

    /* renamed from: c, reason: collision with root package name */
    public Parcelable f4309c;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f4307a);
        parcel.writeInt(this.f4308b);
        parcel.writeParcelable(this.f4309c, i4);
    }
}
