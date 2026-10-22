package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ParameterNameRenderingPolicy extends Enum<ParameterNameRenderingPolicy> {
    private static final /* synthetic */ ParameterNameRenderingPolicy[] $VALUES = null;
    public static final ParameterNameRenderingPolicy ALL = null;
    public static final ParameterNameRenderingPolicy NONE = null;
    public static final ParameterNameRenderingPolicy ONLY_NON_SYNTHESIZED = null;

    private static final /* synthetic */ ParameterNameRenderingPolicy[] $values() {
        return new ParameterNameRenderingPolicy[]{ALL, ONLY_NON_SYNTHESIZED, NONE};
    }

    public static ParameterNameRenderingPolicy valueOf(String r1) {
        return (ParameterNameRenderingPolicy) Enum.valueOf(ParameterNameRenderingPolicy.class, r1);
    }

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[]) $VALUES.clone();
    }

    private ParameterNameRenderingPolicy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ALL = new ParameterNameRenderingPolicy("ALL", 0);
        ONLY_NON_SYNTHESIZED = new ParameterNameRenderingPolicy("ONLY_NON_SYNTHESIZED", 1);
        NONE = new ParameterNameRenderingPolicy("NONE", 2);
        $VALUES = $values();
    }
}
