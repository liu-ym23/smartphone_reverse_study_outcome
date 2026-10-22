package v0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r0 implements Parcelable {
    public static final Parcelable.Creator<r0> CREATOR = new a3.a(12);

    /* renamed from: a, reason: collision with root package name */
    public int f5921a;

    /* renamed from: b, reason: collision with root package name */
    public int f5922b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f5923c;
    public boolean d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f5921a + ", mGapDir=" + this.f5922b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.f5923c) + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f5921a);
        parcel.writeInt(this.f5922b);
        parcel.writeInt(this.d ? 1 : 0);
        int[] iArr = this.f5923c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f5923c);
        }
    }
}
