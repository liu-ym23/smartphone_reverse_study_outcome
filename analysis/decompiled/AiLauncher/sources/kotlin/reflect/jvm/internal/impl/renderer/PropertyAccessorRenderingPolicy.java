package kotlin.reflect.jvm.internal.impl.renderer;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class PropertyAccessorRenderingPolicy {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $VALUES;
    public static final PropertyAccessorRenderingPolicy PRETTY = new PropertyAccessorRenderingPolicy("PRETTY", 0);
    public static final PropertyAccessorRenderingPolicy DEBUG = new PropertyAccessorRenderingPolicy("DEBUG", 1);
    public static final PropertyAccessorRenderingPolicy NONE = new PropertyAccessorRenderingPolicy(ModelFlowMeta.PLAN_NONE, 2);

    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $values() {
        return new PropertyAccessorRenderingPolicy[]{PRETTY, DEBUG, NONE};
    }

    static {
        PropertyAccessorRenderingPolicy[] propertyAccessorRenderingPolicyArr$values = $values();
        $VALUES = propertyAccessorRenderingPolicyArr$values;
        $ENTRIES = kotlin.enums.a.a(propertyAccessorRenderingPolicyArr$values);
    }

    private PropertyAccessorRenderingPolicy(String str, int i10) {
    }

    public static PropertyAccessorRenderingPolicy valueOf(String str) {
        return (PropertyAccessorRenderingPolicy) Enum.valueOf(PropertyAccessorRenderingPolicy.class, str);
    }

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[]) $VALUES.clone();
    }
}
