package androidx.databinding;

import R.a;
import android.os.Parcel;
import android.os.Parcelable;
import b.C0354a;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableFloat extends a implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new C0354a(17);

    /* renamed from: i, reason: collision with root package name */
    public float f3390i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f3390i);
    }
}
