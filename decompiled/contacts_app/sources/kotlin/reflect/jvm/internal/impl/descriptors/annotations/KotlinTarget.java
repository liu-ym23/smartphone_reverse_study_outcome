package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.android.vcard.VCardConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: KotlinTarget.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum KotlinTarget extends Enum<KotlinTarget> {
    private static final /* synthetic */ KotlinTarget[] $VALUES = null;
    private static final Set<KotlinTarget> ALL_TARGET_SET = null;
    public static final KotlinTarget ANNOTATION_CLASS = null;
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST = null;
    public static final KotlinTarget ANONYMOUS_FUNCTION = null;
    public static final KotlinTarget BACKING_FIELD = null;
    public static final KotlinTarget CLASS = null;
    private static final List<KotlinTarget> CLASS_LIST = null;
    public static final KotlinTarget CLASS_ONLY = null;
    public static final KotlinTarget COMPANION_OBJECT = null;
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST = null;
    public static final KotlinTarget CONSTRUCTOR = null;
    public static final Companion Companion = null;
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    public static final KotlinTarget DESTRUCTURING_DECLARATION = null;
    public static final KotlinTarget ENUM_CLASS = null;
    public static final KotlinTarget ENUM_ENTRY = null;
    private static final List<KotlinTarget> ENUM_ENTRY_LIST = null;
    private static final List<KotlinTarget> ENUM_LIST = null;
    public static final KotlinTarget EXPRESSION = null;
    public static final KotlinTarget FIELD = null;
    public static final KotlinTarget FILE = null;
    private static final List<KotlinTarget> FILE_LIST = null;
    public static final KotlinTarget FUNCTION = null;
    private static final List<KotlinTarget> FUNCTION_LIST = null;
    public static final KotlinTarget INITIALIZER = null;
    public static final KotlinTarget INTERFACE = null;
    private static final List<KotlinTarget> INTERFACE_LIST = null;
    public static final KotlinTarget LAMBDA_EXPRESSION = null;
    public static final KotlinTarget LOCAL_CLASS = null;
    private static final List<KotlinTarget> LOCAL_CLASS_LIST = null;
    public static final KotlinTarget LOCAL_FUNCTION = null;
    public static final KotlinTarget LOCAL_VARIABLE = null;
    public static final KotlinTarget MEMBER_FUNCTION = null;
    public static final KotlinTarget MEMBER_PROPERTY = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITH_BACKING_FIELD = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITH_DELEGATE = null;
    public static final KotlinTarget OBJECT = null;
    private static final List<KotlinTarget> OBJECT_LIST = null;
    public static final KotlinTarget OBJECT_LITERAL = null;
    public static final KotlinTarget PROPERTY = null;
    public static final KotlinTarget PROPERTY_GETTER = null;
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST = null;
    public static final KotlinTarget PROPERTY_PARAMETER = null;
    public static final KotlinTarget PROPERTY_SETTER = null;
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST = null;
    public static final KotlinTarget STANDALONE_OBJECT = null;
    public static final KotlinTarget STAR_PROJECTION = null;
    public static final KotlinTarget TOP_LEVEL_FUNCTION = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_DELEGATE = null;
    public static final KotlinTarget TYPE = null;
    public static final KotlinTarget TYPEALIAS = null;
    public static final KotlinTarget TYPE_PARAMETER = null;
    public static final KotlinTarget TYPE_PROJECTION = null;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    public static final KotlinTarget VALUE_PARAMETER = null;
    private static final HashMap<String, KotlinTarget> map = null;
    private final String description;
    private final boolean isDefault;

    /* JADX INFO: compiled from: KotlinTarget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ KotlinTarget[] $values() {
        return new KotlinTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS, TYPE_PROJECTION, STAR_PROJECTION, PROPERTY_PARAMETER, CLASS_ONLY, OBJECT, STANDALONE_OBJECT, COMPANION_OBJECT, INTERFACE, ENUM_CLASS, ENUM_ENTRY, LOCAL_CLASS, LOCAL_FUNCTION, MEMBER_FUNCTION, TOP_LEVEL_FUNCTION, MEMBER_PROPERTY, MEMBER_PROPERTY_WITH_BACKING_FIELD, MEMBER_PROPERTY_WITH_DELEGATE, MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, TOP_LEVEL_PROPERTY, TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD, TOP_LEVEL_PROPERTY_WITH_DELEGATE, TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, BACKING_FIELD, INITIALIZER, DESTRUCTURING_DECLARATION, LAMBDA_EXPRESSION, ANONYMOUS_FUNCTION, OBJECT_LITERAL};
    }

    public static KotlinTarget valueOf(String r1) {
        return (KotlinTarget) Enum.valueOf(KotlinTarget.class, r1);
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[]) $VALUES.clone();
    }

    private KotlinTarget(String r1, int r2, String r3, boolean r4) {
        super(r1, r2);
        this.description = r3;
        this.isDefault = r4;
    }

    /* synthetic */ KotlinTarget(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = true;
    L5:
        this(r1, r2, r3, r4);
    }

    static {
        CLASS = new KotlinTarget("CLASS", 0, "class", false, 2, null);
        ANNOTATION_CLASS = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
        TYPE_PARAMETER = new KotlinTarget("TYPE_PARAMETER", 2, "type parameter", false);
        boolean r9 = false;
        int r10 = 2;
        DefaultConstructorMarker r11 = null;
        PROPERTY = new KotlinTarget("PROPERTY", 3, "property", r9, r10, r11);
        boolean r16 = false;
        int r17 = 2;
        DefaultConstructorMarker r18 = null;
        FIELD = new KotlinTarget("FIELD", 4, "field", r16, r17, r18);
        LOCAL_VARIABLE = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", r9, r10, r11);
        VALUE_PARAMETER = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", r16, r17, r18);
        CONSTRUCTOR = new KotlinTarget("CONSTRUCTOR", 7, "constructor", r9, r10, r11);
        FUNCTION = new KotlinTarget("FUNCTION", 8, "function", r16, r17, r18);
        PROPERTY_GETTER = new KotlinTarget("PROPERTY_GETTER", 9, "getter", r9, r10, r11);
        PROPERTY_SETTER = new KotlinTarget("PROPERTY_SETTER", 10, "setter", r16, r17, r18);
        TYPE = new KotlinTarget(VCardConstants.PARAM_TYPE, 11, "type usage", false);
        EXPRESSION = new KotlinTarget("EXPRESSION", 12, "expression", false);
        FILE = new KotlinTarget("FILE", 13, "file", false);
        TYPEALIAS = new KotlinTarget("TYPEALIAS", 14, "typealias", false);
        TYPE_PROJECTION = new KotlinTarget("TYPE_PROJECTION", 15, "type projection", false);
        STAR_PROJECTION = new KotlinTarget("STAR_PROJECTION", 16, "star projection", false);
        PROPERTY_PARAMETER = new KotlinTarget("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
        CLASS_ONLY = new KotlinTarget("CLASS_ONLY", 18, "class", false);
        OBJECT = new KotlinTarget("OBJECT", 19, "object", false);
        STANDALONE_OBJECT = new KotlinTarget("STANDALONE_OBJECT", 20, "standalone object", false);
        COMPANION_OBJECT = new KotlinTarget("COMPANION_OBJECT", 21, "companion object", false);
        INTERFACE = new KotlinTarget("INTERFACE", 22, "interface", false);
        ENUM_CLASS = new KotlinTarget("ENUM_CLASS", 23, "enum class", false);
        ENUM_ENTRY = new KotlinTarget("ENUM_ENTRY", 24, "enum entry", false);
        LOCAL_CLASS = new KotlinTarget("LOCAL_CLASS", 25, "local class", false);
        LOCAL_FUNCTION = new KotlinTarget("LOCAL_FUNCTION", 26, "local function", false);
        MEMBER_FUNCTION = new KotlinTarget("MEMBER_FUNCTION", 27, "member function", false);
        TOP_LEVEL_FUNCTION = new KotlinTarget("TOP_LEVEL_FUNCTION", 28, "top level function", false);
        MEMBER_PROPERTY = new KotlinTarget("MEMBER_PROPERTY", 29, "member property", false);
        MEMBER_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, "member property with backing field", false);
        MEMBER_PROPERTY_WITH_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITH_DELEGATE", 31, "member property with delegate", false);
        MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, "member property without backing field or delegate", false);
        TOP_LEVEL_PROPERTY = new KotlinTarget("TOP_LEVEL_PROPERTY", 33, "top level property", false);
        TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, "top level property with backing field", false);
        TOP_LEVEL_PROPERTY_WITH_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, "top level property with delegate", false);
        TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, "top level property without backing field or delegate", false);
        BACKING_FIELD = new KotlinTarget("BACKING_FIELD", 37, "backing field", false, 2, null);
        INITIALIZER = new KotlinTarget("INITIALIZER", 38, "initializer", false);
        DESTRUCTURING_DECLARATION = new KotlinTarget("DESTRUCTURING_DECLARATION", 39, "destructuring declaration", false);
        LAMBDA_EXPRESSION = new KotlinTarget("LAMBDA_EXPRESSION", 40, "lambda expression", false);
        ANONYMOUS_FUNCTION = new KotlinTarget("ANONYMOUS_FUNCTION", 41, "anonymous function", false);
        OBJECT_LITERAL = new KotlinTarget("OBJECT_LITERAL", 42, "object literal", false);
        $VALUES = $values();
        Companion = new Companion(null);
        map = new HashMap();
        KotlinTarget[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        KotlinTarget r5 = r0[r3];
        map.put(r5.name(), r5);
        r3 = r3 + 1;
        goto L3
    L5:
        KotlinTarget[] r2 = values();
        ArrayList r4 = new ArrayList();
        int r6 = r2.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        KotlinTarget r8 = r2[r7];
        if (r8.isDefault == false) goto L10;
        r4.add(r8);
    L10:
        r7 = r7 + 1;
        goto L6
    L11:
        DEFAULT_TARGET_SET = CollectionsKt.toSet(r4);
        ALL_TARGET_SET = ArraysKt.toSet(values());
        KotlinTarget r12 = CLASS;
        ANNOTATION_CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{ANNOTATION_CLASS, r12});
        LOCAL_CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{LOCAL_CLASS, r12});
        CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{CLASS_ONLY, r12});
        KotlinTarget r13 = OBJECT;
        COMPANION_OBJECT_LIST = CollectionsKt.listOf(new KotlinTarget[]{COMPANION_OBJECT, r13, r12});
        OBJECT_LIST = CollectionsKt.listOf(new KotlinTarget[]{STANDALONE_OBJECT, r13, r12});
        INTERFACE_LIST = CollectionsKt.listOf(new KotlinTarget[]{INTERFACE, r12});
        ENUM_LIST = CollectionsKt.listOf(new KotlinTarget[]{ENUM_CLASS, r12});
        KotlinTarget r14 = PROPERTY;
        KotlinTarget r15 = FIELD;
        ENUM_ENTRY_LIST = CollectionsKt.listOf(new KotlinTarget[]{ENUM_ENTRY, r14, r15});
        KotlinTarget r19 = PROPERTY_SETTER;
        PROPERTY_SETTER_LIST = CollectionsKt.listOf(r19);
        KotlinTarget r20 = PROPERTY_GETTER;
        PROPERTY_GETTER_LIST = CollectionsKt.listOf(r20);
        FUNCTION_LIST = CollectionsKt.listOf(FUNCTION);
        KotlinTarget r21 = FILE;
        FILE_LIST = CollectionsKt.listOf(r21);
        AnnotationUseSiteTarget r110 = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget r111 = VALUE_PARAMETER;
        USE_SITE_MAPPING = MapsKt.mapOf(new Pair[]{TuplesKt.to(r110, r111), TuplesKt.to(AnnotationUseSiteTarget.FIELD, r15), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, r14), TuplesKt.to(AnnotationUseSiteTarget.FILE, r21), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, r20), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, r19), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, r111), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, r111), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, r15)});
    }
}
