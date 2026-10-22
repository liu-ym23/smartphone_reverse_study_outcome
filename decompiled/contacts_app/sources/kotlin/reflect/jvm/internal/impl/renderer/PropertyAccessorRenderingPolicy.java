package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum PropertyAccessorRenderingPolicy extends Enum<PropertyAccessorRenderingPolicy> {
    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $VALUES = null;
    public static final PropertyAccessorRenderingPolicy DEBUG = null;
    public static final PropertyAccessorRenderingPolicy NONE = null;
    public static final PropertyAccessorRenderingPolicy PRETTY = null;

    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $values() {
        return new PropertyAccessorRenderingPolicy[]{PRETTY, DEBUG, NONE};
    }

    public static PropertyAccessorRenderingPolicy valueOf(String r1) {
        return (PropertyAccessorRenderingPolicy) Enum.valueOf(PropertyAccessorRenderingPolicy.class, r1);
    }

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[]) $VALUES.clone();
    }

    private PropertyAccessorRenderingPolicy(String r1, int r2) {
        super(r1, r2);
    }

    static {
        PRETTY = new PropertyAccessorRenderingPolicy("PRETTY", 0);
        DEBUG = new PropertyAccessorRenderingPolicy("DEBUG", 1);
        NONE = new PropertyAccessorRenderingPolicy("NONE", 2);
        $VALUES = $values();
    }
}
