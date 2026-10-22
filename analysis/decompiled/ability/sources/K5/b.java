package K5;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;

/* loaded from: classes3.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new NetResponse(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new NetResponse[i];
    }
}
