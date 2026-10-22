package k7;

import android.os.Parcel;
import android.os.Parcelable;
import com.zyql.agentfront.bean.AbilityMetadata;

/* renamed from: k7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1627a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        kotlin.jvm.internal.k.f(parcel, "parcel");
        return new AbilityMetadata(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new AbilityMetadata[i];
    }
}
