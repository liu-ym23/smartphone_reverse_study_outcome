package k7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.agentfront.bean.SyncConversationsResponse;

/* loaded from: classes3.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        return new SyncConversationsResponse(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new SyncConversationsResponse[i];
    }
}
