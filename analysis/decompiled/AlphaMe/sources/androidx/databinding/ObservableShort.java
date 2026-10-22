package androidx.databinding;

import R.a;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableShort extends a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new C0354a(21);

    /* renamed from: i, reason: collision with root package name */
    public short f3393i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3393i);
    }
}
