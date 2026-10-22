package k7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.agentfront.bean.SessionOperationResponse;

/* loaded from: classes3.dex */
public final class o implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        return new SessionOperationResponse(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new SessionOperationResponse[i];
    }
}
