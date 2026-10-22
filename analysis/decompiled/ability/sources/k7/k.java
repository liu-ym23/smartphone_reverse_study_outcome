package k7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.agentfront.bean.ResumeTaskResponse;

/* loaded from: classes3.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        return new ResumeTaskResponse(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ResumeTaskResponse[i];
    }
}
