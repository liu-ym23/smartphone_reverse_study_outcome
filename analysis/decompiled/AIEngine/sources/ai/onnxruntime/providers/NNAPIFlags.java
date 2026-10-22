package ai.onnxruntime.providers;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public enum NNAPIFlags implements OrtFlags {
    USE_FP16(1),
    USE_NCHW(2),
    CPU_DISABLED(4),
    CPU_ONLY(8);

    public final int value;

    NNAPIFlags(int i10) {
        this.value = i10;
    }

    @Override // ai.onnxruntime.providers.OrtFlags
    public int getValue() {
        return this.value;
    }
}
