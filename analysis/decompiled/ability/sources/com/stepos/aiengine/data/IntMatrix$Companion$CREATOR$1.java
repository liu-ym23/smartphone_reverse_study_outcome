package com.stepos.aiengine.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/aiengine/data/IntMatrix$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/aiengine/data/IntMatrix;", "createFromParcel", AgentBusWakeContract.EXTRA_SOURCE, "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stepos/aiengine/data/IntMatrix;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntMatrix$Companion$CREATOR$1 implements Parcelable.Creator<IntMatrix> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public IntMatrix createFromParcel(Parcel source) {
        k.f(source, "source");
        return new IntMatrix(source, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public IntMatrix[] newArray(int size) {
        return new IntMatrix[size];
    }
}
