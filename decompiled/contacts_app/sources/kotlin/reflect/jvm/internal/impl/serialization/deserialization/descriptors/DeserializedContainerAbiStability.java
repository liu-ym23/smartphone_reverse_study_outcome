package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedContainerSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum DeserializedContainerAbiStability extends Enum<DeserializedContainerAbiStability> {
    private static final /* synthetic */ DeserializedContainerAbiStability[] $VALUES = null;
    public static final DeserializedContainerAbiStability FIR_UNSTABLE = null;
    public static final DeserializedContainerAbiStability IR_UNSTABLE = null;
    public static final DeserializedContainerAbiStability STABLE = null;

    private static final /* synthetic */ DeserializedContainerAbiStability[] $values() {
        return new DeserializedContainerAbiStability[]{STABLE, FIR_UNSTABLE, IR_UNSTABLE};
    }

    public static DeserializedContainerAbiStability valueOf(String r1) {
        return (DeserializedContainerAbiStability) Enum.valueOf(DeserializedContainerAbiStability.class, r1);
    }

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[]) $VALUES.clone();
    }

    private DeserializedContainerAbiStability(String r1, int r2) {
        super(r1, r2);
    }

    static {
        STABLE = new DeserializedContainerAbiStability("STABLE", 0);
        FIR_UNSTABLE = new DeserializedContainerAbiStability("FIR_UNSTABLE", 1);
        IR_UNSTABLE = new DeserializedContainerAbiStability("IR_UNSTABLE", 2);
        $VALUES = $values();
    }
}
