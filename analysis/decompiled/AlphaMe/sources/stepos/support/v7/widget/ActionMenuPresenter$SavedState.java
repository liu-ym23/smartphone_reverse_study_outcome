package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
class ActionMenuPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<ActionMenuPresenter$SavedState> CREATOR = new C0896p();

    /* renamed from: a, reason: collision with root package name */
    public int f14795a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f14795a);
    }
}
