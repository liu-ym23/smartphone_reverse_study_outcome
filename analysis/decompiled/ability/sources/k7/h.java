package k7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.agentfront.bean.PauseTaskRequest;

/* loaded from: classes3.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        return new PauseTaskRequest(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new PauseTaskRequest[i];
    }
}
