package ai.onnxruntime.providers;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public enum CoreMLFlags implements OrtFlags {
    CPU_ONLY(1),
    ENABLE_ON_SUBGRAPH(2),
    ONLY_ENABLE_DEVICE_WITH_ANE(4);

    public final int value;

    CoreMLFlags(int i10) {
        this.value = i10;
    }

    @Override // ai.onnxruntime.providers.OrtFlags
    public int getValue() {
        return this.value;
    }
}
