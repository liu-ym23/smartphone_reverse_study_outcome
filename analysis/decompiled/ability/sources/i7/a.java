package i7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.ability.service.model.AbilityCallerParcelable;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        k.f(parcel, "parcel");
        return new AbilityCallerParcelable(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AbilityCallerParcelable[i];
    }
}
