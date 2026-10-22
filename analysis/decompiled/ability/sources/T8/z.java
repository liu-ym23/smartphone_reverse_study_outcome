package T8;

import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;

/* loaded from: classes4.dex */
public final class z {
    public static Modality a(ProtoBuf$Modality protoBuf$Modality) {
        int i = protoBuf$Modality == null ? -1 : y.f1236a[protoBuf$Modality.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Modality.b : Modality.c : Modality.e : Modality.d : Modality.b;
    }
}
