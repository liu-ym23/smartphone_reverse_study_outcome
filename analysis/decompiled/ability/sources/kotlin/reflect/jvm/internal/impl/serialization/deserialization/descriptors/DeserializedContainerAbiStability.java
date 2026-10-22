package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class DeserializedContainerAbiStability {

    /* renamed from: a, reason: collision with root package name */
    public static final DeserializedContainerAbiStability f5128a;
    public static final DeserializedContainerAbiStability b;
    public static final /* synthetic */ DeserializedContainerAbiStability[] c;

    static {
        DeserializedContainerAbiStability deserializedContainerAbiStability = new DeserializedContainerAbiStability("STABLE", 0);
        f5128a = deserializedContainerAbiStability;
        DeserializedContainerAbiStability deserializedContainerAbiStability2 = new DeserializedContainerAbiStability("UNSTABLE", 1);
        b = deserializedContainerAbiStability2;
        DeserializedContainerAbiStability[] deserializedContainerAbiStabilityArr = {deserializedContainerAbiStability, deserializedContainerAbiStability2};
        c = deserializedContainerAbiStabilityArr;
        kotlin.enums.a.a(deserializedContainerAbiStabilityArr);
    }

    public static DeserializedContainerAbiStability valueOf(String str) {
        return (DeserializedContainerAbiStability) Enum.valueOf(DeserializedContainerAbiStability.class, str);
    }

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[]) c.clone();
    }
}
