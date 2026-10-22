package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import M0.i;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class AnnotationUseSiteTarget {
    public static final AnnotationUseSiteTarget b;
    public static final AnnotationUseSiteTarget c;
    public static final AnnotationUseSiteTarget d;
    public static final AnnotationUseSiteTarget e;
    public static final AnnotationUseSiteTarget f;
    public static final AnnotationUseSiteTarget g;
    public static final AnnotationUseSiteTarget h;
    public static final AnnotationUseSiteTarget i;

    /* renamed from: j, reason: collision with root package name */
    public static final AnnotationUseSiteTarget f4954j;
    public static final /* synthetic */ AnnotationUseSiteTarget[] k;

    /* renamed from: a, reason: collision with root package name */
    public final String f4955a;

    static {
        AnnotationUseSiteTarget annotationUseSiteTarget = new AnnotationUseSiteTarget("FIELD", 0, null);
        b = annotationUseSiteTarget;
        AnnotationUseSiteTarget annotationUseSiteTarget2 = new AnnotationUseSiteTarget("FILE", 1, null);
        c = annotationUseSiteTarget2;
        AnnotationUseSiteTarget annotationUseSiteTarget3 = new AnnotationUseSiteTarget("PROPERTY", 2, null);
        d = annotationUseSiteTarget3;
        AnnotationUseSiteTarget annotationUseSiteTarget4 = new AnnotationUseSiteTarget("PROPERTY_GETTER", 3, "get");
        e = annotationUseSiteTarget4;
        AnnotationUseSiteTarget annotationUseSiteTarget5 = new AnnotationUseSiteTarget("PROPERTY_SETTER", 4, "set");
        f = annotationUseSiteTarget5;
        AnnotationUseSiteTarget annotationUseSiteTarget6 = new AnnotationUseSiteTarget("RECEIVER", 5, null);
        g = annotationUseSiteTarget6;
        AnnotationUseSiteTarget annotationUseSiteTarget7 = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 6, "param");
        h = annotationUseSiteTarget7;
        AnnotationUseSiteTarget annotationUseSiteTarget8 = new AnnotationUseSiteTarget("SETTER_PARAMETER", 7, "setparam");
        i = annotationUseSiteTarget8;
        AnnotationUseSiteTarget annotationUseSiteTarget9 = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 8, "delegate");
        f4954j = annotationUseSiteTarget9;
        AnnotationUseSiteTarget[] annotationUseSiteTargetArr = {annotationUseSiteTarget, annotationUseSiteTarget2, annotationUseSiteTarget3, annotationUseSiteTarget4, annotationUseSiteTarget5, annotationUseSiteTarget6, annotationUseSiteTarget7, annotationUseSiteTarget8, annotationUseSiteTarget9};
        k = annotationUseSiteTargetArr;
        a.a(annotationUseSiteTargetArr);
    }

    public AnnotationUseSiteTarget(String str, int i6, String str2) {
        this.f4955a = str2 == null ? i.J(name()) : str2;
    }

    public static AnnotationUseSiteTarget valueOf(String str) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, str);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) k.clone();
    }
}
