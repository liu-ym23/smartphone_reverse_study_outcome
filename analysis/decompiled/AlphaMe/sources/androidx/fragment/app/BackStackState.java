package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0280b(1);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3583a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3584b;

    public BackStackState(Parcel parcel) {
        this.f3583a = parcel.createStringArrayList();
        this.f3584b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.f3583a);
        parcel.writeTypedList(this.f3584b);
    }
}
