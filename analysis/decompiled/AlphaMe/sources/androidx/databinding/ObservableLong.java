package androidx.databinding;

import R.a;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableLong extends a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new C0354a(19);

    /* renamed from: i, reason: collision with root package name */
    public long f3392i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.f3392i);
    }
}
