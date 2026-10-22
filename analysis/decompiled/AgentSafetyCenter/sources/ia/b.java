package ia;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        NetResponse netResponse = new NetResponse();
        netResponse.f2840c = parcel.readInt();
        netResponse.f2841f = parcel.readString();
        return netResponse;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new NetResponse[i];
    }
}
