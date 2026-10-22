package androidx.databinding;

import R.d;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableParcelable<T extends Parcelable> extends d implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new C0354a(20);

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable((Parcelable) this.f1658i, 0);
    }
}
