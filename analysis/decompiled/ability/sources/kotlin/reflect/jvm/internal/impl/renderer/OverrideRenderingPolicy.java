package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class OverrideRenderingPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final OverrideRenderingPolicy f5110a;
    public static final OverrideRenderingPolicy b;
    public static final /* synthetic */ OverrideRenderingPolicy[] c;

    static {
        OverrideRenderingPolicy overrideRenderingPolicy = new OverrideRenderingPolicy("RENDER_OVERRIDE", 0);
        f5110a = overrideRenderingPolicy;
        OverrideRenderingPolicy overrideRenderingPolicy2 = new OverrideRenderingPolicy("RENDER_OPEN", 1);
        b = overrideRenderingPolicy2;
        OverrideRenderingPolicy[] overrideRenderingPolicyArr = {overrideRenderingPolicy, overrideRenderingPolicy2, new OverrideRenderingPolicy("RENDER_OPEN_OVERRIDE", 2)};
        c = overrideRenderingPolicyArr;
        a.a(overrideRenderingPolicyArr);
    }

    public static OverrideRenderingPolicy valueOf(String str) {
        return (OverrideRenderingPolicy) Enum.valueOf(OverrideRenderingPolicy.class, str);
    }

    public static OverrideRenderingPolicy[] values() {
        return (OverrideRenderingPolicy[]) c.clone();
    }
}
