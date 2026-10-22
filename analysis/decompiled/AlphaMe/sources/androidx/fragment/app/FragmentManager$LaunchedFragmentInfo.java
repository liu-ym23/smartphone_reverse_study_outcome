package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class FragmentManager$LaunchedFragmentInfo implements Parcelable {
    public static final Parcelable.Creator<FragmentManager$LaunchedFragmentInfo> CREATOR = new C0280b(2);

    /* renamed from: a, reason: collision with root package name */
    public String f3593a;

    /* renamed from: b, reason: collision with root package name */
    public int f3594b;

    public FragmentManager$LaunchedFragmentInfo(String str, int i4) {
        this.f3593a = str;
        this.f3594b = i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f3593a);
        parcel.writeInt(this.f3594b);
    }
}
