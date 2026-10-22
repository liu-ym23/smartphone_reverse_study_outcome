package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* JADX INFO: compiled from: AnnotationUseSiteTarget.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum AnnotationUseSiteTarget extends Enum<AnnotationUseSiteTarget> {
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES = null;
    public static final AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = null;
    public static final AnnotationUseSiteTarget FIELD = null;
    public static final AnnotationUseSiteTarget FILE = null;
    public static final AnnotationUseSiteTarget PROPERTY = null;
    public static final AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = null;
    public static final AnnotationUseSiteTarget PROPERTY_GETTER = null;
    public static final AnnotationUseSiteTarget PROPERTY_SETTER = null;
    public static final AnnotationUseSiteTarget RECEIVER = null;
    public static final AnnotationUseSiteTarget SETTER_PARAMETER = null;
    private final String renderName;

    private static final /* synthetic */ AnnotationUseSiteTarget[] $values() {
        return new AnnotationUseSiteTarget[]{FIELD, FILE, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER, RECEIVER, CONSTRUCTOR_PARAMETER, SETTER_PARAMETER, PROPERTY_DELEGATE_FIELD};
    }

    public static AnnotationUseSiteTarget valueOf(String r1) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, r1);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }

    private AnnotationUseSiteTarget(String r1, int r2, String r3) {
        super(r1, r2);
        if (r3 != null) goto L5;
        r3 = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name());
    L5:
        this.renderName = r3;
    }

    /* synthetic */ AnnotationUseSiteTarget(String r1, int r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    static {
        FIELD = new AnnotationUseSiteTarget("FIELD", 0, null, 1, null);
        FILE = new AnnotationUseSiteTarget("FILE", 1, null, 1, null);
        PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 2, null, 1, null);
        PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 3, "get");
        PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 4, "set");
        RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 5, null, 1, null);
        CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 6, AutoTestConstant.PARAM);
        SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 7, "setparam");
        PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 8, "delegate");
        $VALUES = $values();
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
