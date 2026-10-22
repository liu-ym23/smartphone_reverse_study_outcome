package kotlin.reflect.jvm.internal.calls;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode", "", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnotationConstructorCaller$CallMode {

    /* renamed from: a, reason: collision with root package name */
    public static final AnnotationConstructorCaller$CallMode f4940a;
    public static final AnnotationConstructorCaller$CallMode b;
    public static final /* synthetic */ AnnotationConstructorCaller$CallMode[] c;

    static {
        AnnotationConstructorCaller$CallMode annotationConstructorCaller$CallMode = new AnnotationConstructorCaller$CallMode("CALL_BY_NAME", 0);
        f4940a = annotationConstructorCaller$CallMode;
        AnnotationConstructorCaller$CallMode annotationConstructorCaller$CallMode2 = new AnnotationConstructorCaller$CallMode("POSITIONAL_CALL", 1);
        b = annotationConstructorCaller$CallMode2;
        AnnotationConstructorCaller$CallMode[] annotationConstructorCaller$CallModeArr = {annotationConstructorCaller$CallMode, annotationConstructorCaller$CallMode2};
        c = annotationConstructorCaller$CallModeArr;
        a.a(annotationConstructorCaller$CallModeArr);
    }

    public static AnnotationConstructorCaller$CallMode valueOf(String str) {
        return (AnnotationConstructorCaller$CallMode) Enum.valueOf(AnnotationConstructorCaller$CallMode.class, str);
    }

    public static AnnotationConstructorCaller$CallMode[] values() {
        return (AnnotationConstructorCaller$CallMode[]) c.clone();
    }
}
