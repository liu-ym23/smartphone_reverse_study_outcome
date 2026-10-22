package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class AnnotationArgumentsRenderingPolicy {
    public static final AnnotationArgumentsRenderingPolicy c;
    public static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5105a;
    public final boolean b;

    static {
        AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy = new AnnotationArgumentsRenderingPolicy("NO_ARGUMENTS", 0, 3);
        c = annotationArgumentsRenderingPolicy;
        AnnotationArgumentsRenderingPolicy[] annotationArgumentsRenderingPolicyArr = {annotationArgumentsRenderingPolicy, new AnnotationArgumentsRenderingPolicy("UNLESS_EMPTY", 1, 2), new AnnotationArgumentsRenderingPolicy("ALWAYS_PARENTHESIZED", 2, true, true)};
        d = annotationArgumentsRenderingPolicyArr;
        a.a(annotationArgumentsRenderingPolicyArr);
    }

    public /* synthetic */ AnnotationArgumentsRenderingPolicy(String str, int i, int i6) {
        this(str, i, (i6 & 1) == 0, false);
    }

    public static AnnotationArgumentsRenderingPolicy valueOf(String str) {
        return (AnnotationArgumentsRenderingPolicy) Enum.valueOf(AnnotationArgumentsRenderingPolicy.class, str);
    }

    public static AnnotationArgumentsRenderingPolicy[] values() {
        return (AnnotationArgumentsRenderingPolicy[]) d.clone();
    }

    public AnnotationArgumentsRenderingPolicy(String str, int i, boolean z10, boolean z11) {
        this.f5105a = z10;
        this.b = z11;
    }
}
