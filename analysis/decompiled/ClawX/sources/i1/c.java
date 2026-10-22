package i1;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g.c2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h0.b {
    public static final Parcelable.Creator<c> CREATOR = new c2(2);

    /* renamed from: c, reason: collision with root package name */
    public final int f3130c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3131e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3132f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3133g;

    public c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3130c = parcel.readInt();
        this.d = parcel.readInt();
        this.f3131e = parcel.readInt() == 1;
        this.f3132f = parcel.readInt() == 1;
        this.f3133g = parcel.readInt() == 1;
    }

    @Override // h0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        parcel.writeInt(this.f3130c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f3131e ? 1 : 0);
        parcel.writeInt(this.f3132f ? 1 : 0);
        parcel.writeInt(this.f3133g ? 1 : 0);
    }

    public c(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f3130c = bottomSheetBehavior.N;
        this.d = bottomSheetBehavior.f1239e;
        this.f3131e = bottomSheetBehavior.f1234b;
        this.f3132f = bottomSheetBehavior.I;
        this.f3133g = bottomSheetBehavior.J;
    }
}
