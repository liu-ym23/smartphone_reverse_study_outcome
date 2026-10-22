package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum OverrideRenderingPolicy extends Enum<OverrideRenderingPolicy> {
    private static final /* synthetic */ OverrideRenderingPolicy[] $VALUES = null;
    public static final OverrideRenderingPolicy RENDER_OPEN = null;
    public static final OverrideRenderingPolicy RENDER_OPEN_OVERRIDE = null;
    public static final OverrideRenderingPolicy RENDER_OVERRIDE = null;

    private static final /* synthetic */ OverrideRenderingPolicy[] $values() {
        return new OverrideRenderingPolicy[]{RENDER_OVERRIDE, RENDER_OPEN, RENDER_OPEN_OVERRIDE};
    }

    public static OverrideRenderingPolicy valueOf(String r1) {
        return (OverrideRenderingPolicy) Enum.valueOf(OverrideRenderingPolicy.class, r1);
    }

    public static OverrideRenderingPolicy[] values() {
        return (OverrideRenderingPolicy[]) $VALUES.clone();
    }

    private OverrideRenderingPolicy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        RENDER_OVERRIDE = new OverrideRenderingPolicy("RENDER_OVERRIDE", 0);
        RENDER_OPEN = new OverrideRenderingPolicy("RENDER_OPEN", 1);
        RENDER_OPEN_OVERRIDE = new OverrideRenderingPolicy("RENDER_OPEN_OVERRIDE", 2);
        $VALUES = $values();
    }
}
