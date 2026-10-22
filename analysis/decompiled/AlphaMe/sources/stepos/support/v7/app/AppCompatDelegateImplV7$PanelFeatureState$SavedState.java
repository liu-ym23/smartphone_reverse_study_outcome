package stepos.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
class AppCompatDelegateImplV7$PanelFeatureState$SavedState implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImplV7$PanelFeatureState$SavedState> CREATOR = new G.j(new C0878x());

    /* renamed from: a, reason: collision with root package name */
    public int f14263a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14264b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f14265c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f14263a);
        parcel.writeInt(this.f14264b ? 1 : 0);
        if (this.f14264b) {
            parcel.writeBundle(this.f14265c);
        }
    }
}
