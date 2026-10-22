package m;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends View.BaseSavedState {
    public static final Parcelable.Creator<l0> CREATOR = new android.support.v4.os.a(16);

    /* renamed from: c, reason: collision with root package name */
    public boolean f7986c;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f7986c ? (byte) 1 : (byte) 0);
    }
}
