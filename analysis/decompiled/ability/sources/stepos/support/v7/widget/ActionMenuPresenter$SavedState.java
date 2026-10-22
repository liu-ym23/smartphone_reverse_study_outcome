package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
class ActionMenuPresenter$SavedState implements Parcelable {
    public static final Parcelable.Creator<ActionMenuPresenter$SavedState> CREATOR = new C2004t();
    public int openSubMenuId;

    public ActionMenuPresenter$SavedState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.openSubMenuId);
    }

    public ActionMenuPresenter$SavedState(Parcel parcel) {
        this.openSubMenuId = parcel.readInt();
    }
}
