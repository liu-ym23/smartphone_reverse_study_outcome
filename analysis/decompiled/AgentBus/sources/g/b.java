package g;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import q7.k;

/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a(0);

    /* renamed from: f, reason: collision with root package name */
    public final int f3665f;

    /* renamed from: g, reason: collision with root package name */
    public final Intent f3666g;

    public b(Intent intent, int i2) {
        this.f3665f = i2;
        this.f3666g = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ActivityResult{resultCode=");
        int i2 = this.f3665f;
        sb2.append(i2 != -1 ? i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED" : "RESULT_OK");
        sb2.append(", data=");
        sb2.append(this.f3666g);
        sb2.append('}');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        k.e(parcel, "dest");
        parcel.writeInt(this.f3665f);
        Intent intent = this.f3666g;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }
}
