package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ParameterNameRenderingPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final ParameterNameRenderingPolicy f5111a;
    public static final ParameterNameRenderingPolicy b;
    public static final ParameterNameRenderingPolicy c;
    public static final /* synthetic */ ParameterNameRenderingPolicy[] d;

    static {
        ParameterNameRenderingPolicy parameterNameRenderingPolicy = new ParameterNameRenderingPolicy("ALL", 0);
        f5111a = parameterNameRenderingPolicy;
        ParameterNameRenderingPolicy parameterNameRenderingPolicy2 = new ParameterNameRenderingPolicy("ONLY_NON_SYNTHESIZED", 1);
        b = parameterNameRenderingPolicy2;
        ParameterNameRenderingPolicy parameterNameRenderingPolicy3 = new ParameterNameRenderingPolicy("NONE", 2);
        c = parameterNameRenderingPolicy3;
        ParameterNameRenderingPolicy[] parameterNameRenderingPolicyArr = {parameterNameRenderingPolicy, parameterNameRenderingPolicy2, parameterNameRenderingPolicy3};
        d = parameterNameRenderingPolicyArr;
        a.a(parameterNameRenderingPolicyArr);
    }

    public static ParameterNameRenderingPolicy valueOf(String str) {
        return (ParameterNameRenderingPolicy) Enum.valueOf(ParameterNameRenderingPolicy.class, str);
    }

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[]) d.clone();
    }
}
