package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0280b(3);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3595a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f3596b;

    /* renamed from: c, reason: collision with root package name */
    public BackStackRecordState[] f3597c;

    /* renamed from: d, reason: collision with root package name */
    public int f3598d;

    /* renamed from: e, reason: collision with root package name */
    public String f3599e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3600f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f3601g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f3602h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.f3595a);
        parcel.writeStringList(this.f3596b);
        parcel.writeTypedArray(this.f3597c, i4);
        parcel.writeInt(this.f3598d);
        parcel.writeString(this.f3599e);
        parcel.writeStringList(this.f3600f);
        parcel.writeTypedList(this.f3601g);
        parcel.writeTypedList(this.f3602h);
    }
}
