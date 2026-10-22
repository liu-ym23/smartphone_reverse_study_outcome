package i7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.ability.service.model.AbilityExeReqParcelable;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        k.f(parcel, "parcel");
        return new AbilityExeReqParcelable(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AbilityExeReqParcelable[i];
    }
}
