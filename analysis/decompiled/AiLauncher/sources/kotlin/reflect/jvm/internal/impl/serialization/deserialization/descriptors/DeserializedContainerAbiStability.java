package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h9.InterfaceC4149a;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class DeserializedContainerAbiStability {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DeserializedContainerAbiStability[] $VALUES;
    public static final DeserializedContainerAbiStability STABLE = new DeserializedContainerAbiStability("STABLE", 0);
    public static final DeserializedContainerAbiStability UNSTABLE = new DeserializedContainerAbiStability("UNSTABLE", 1);

    private static final /* synthetic */ DeserializedContainerAbiStability[] $values() {
        return new DeserializedContainerAbiStability[]{STABLE, UNSTABLE};
    }

    static {
        DeserializedContainerAbiStability[] deserializedContainerAbiStabilityArr$values = $values();
        $VALUES = deserializedContainerAbiStabilityArr$values;
        $ENTRIES = a.a(deserializedContainerAbiStabilityArr$values);
    }

    private DeserializedContainerAbiStability(String str, int i10) {
    }

    public static DeserializedContainerAbiStability valueOf(String str) {
        return (DeserializedContainerAbiStability) Enum.valueOf(DeserializedContainerAbiStability.class, str);
    }

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[]) $VALUES.clone();
    }
}
