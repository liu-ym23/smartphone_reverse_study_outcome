package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.annotation.RestrictTo;
import b.C0354a;
import e.EnumC0546d;

@RestrictTo({EnumC0546d.f12492a})
/* loaded from: classes.dex */
public final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$ResultReceiverWrapper> CREATOR = new C0354a(6);

    /* renamed from: a, reason: collision with root package name */
    public ResultReceiver f2340a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        this.f2340a.writeToParcel(parcel, i4);
    }
}
