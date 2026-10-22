package stepos.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class t1 extends View.BaseSavedState {
    public static final Parcelable.Creator<t1> CREATOR = new android.support.v4.os.a(18);

    /* renamed from: c, reason: collision with root package name */
    public int f12834c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12835f;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f12834c);
        parcel.writeInt(this.f12835f ? 1 : 0);
    }
}
