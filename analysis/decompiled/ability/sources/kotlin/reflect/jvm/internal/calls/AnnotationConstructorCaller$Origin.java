package kotlin.reflect.jvm.internal.calls;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin", "", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnotationConstructorCaller$Origin {

    /* renamed from: a, reason: collision with root package name */
    public static final AnnotationConstructorCaller$Origin f4941a;
    public static final AnnotationConstructorCaller$Origin b;
    public static final /* synthetic */ AnnotationConstructorCaller$Origin[] c;

    static {
        AnnotationConstructorCaller$Origin annotationConstructorCaller$Origin = new AnnotationConstructorCaller$Origin("JAVA", 0);
        f4941a = annotationConstructorCaller$Origin;
        AnnotationConstructorCaller$Origin annotationConstructorCaller$Origin2 = new AnnotationConstructorCaller$Origin("KOTLIN", 1);
        b = annotationConstructorCaller$Origin2;
        AnnotationConstructorCaller$Origin[] annotationConstructorCaller$OriginArr = {annotationConstructorCaller$Origin, annotationConstructorCaller$Origin2};
        c = annotationConstructorCaller$OriginArr;
        a.a(annotationConstructorCaller$OriginArr);
    }

    public static AnnotationConstructorCaller$Origin valueOf(String str) {
        return (AnnotationConstructorCaller$Origin) Enum.valueOf(AnnotationConstructorCaller$Origin.class, str);
    }

    public static AnnotationConstructorCaller$Origin[] values() {
        return (AnnotationConstructorCaller$Origin[]) c.clone();
    }
}
