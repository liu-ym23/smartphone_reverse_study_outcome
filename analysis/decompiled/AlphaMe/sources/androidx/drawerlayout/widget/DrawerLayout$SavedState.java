package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.customview.view.a;

/* loaded from: classes.dex */
public class DrawerLayout$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<DrawerLayout$SavedState> CREATOR = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f3563a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3564b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3565c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3566d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3567e;

    public DrawerLayout$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3563a = 0;
        this.f3563a = parcel.readInt();
        this.f3564b = parcel.readInt();
        this.f3565c = parcel.readInt();
        this.f3566d = parcel.readInt();
        this.f3567e = parcel.readInt();
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f3563a);
        parcel.writeInt(this.f3564b);
        parcel.writeInt(this.f3565c);
        parcel.writeInt(this.f3566d);
        parcel.writeInt(this.f3567e);
    }
}
