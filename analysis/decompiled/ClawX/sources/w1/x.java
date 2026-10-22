package w1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import g.c2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x extends h0.b {
    public static final Parcelable.Creator<x> CREATOR = new c2(8);

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f6181c;
    public boolean d;

    public x(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6181c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f6181c) + "}";
    }

    @Override // h0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        super.writeToParcel(parcel, i8);
        TextUtils.writeToParcel(this.f6181c, parcel, i8);
        parcel.writeInt(this.d ? 1 : 0);
    }
}
