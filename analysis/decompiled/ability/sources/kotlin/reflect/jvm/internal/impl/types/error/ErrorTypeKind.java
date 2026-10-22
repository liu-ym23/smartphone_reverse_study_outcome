package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ErrorTypeKind {

    /* renamed from: A, reason: collision with root package name */
    public static final ErrorTypeKind f5149A;

    /* renamed from: B, reason: collision with root package name */
    public static final ErrorTypeKind f5150B;

    /* renamed from: C, reason: collision with root package name */
    public static final ErrorTypeKind f5151C;

    /* renamed from: D, reason: collision with root package name */
    public static final ErrorTypeKind f5152D;
    public static final ErrorTypeKind E;

    /* renamed from: F, reason: collision with root package name */
    public static final /* synthetic */ ErrorTypeKind[] f5153F;
    public static final ErrorTypeKind c;
    public static final ErrorTypeKind d;
    public static final ErrorTypeKind e;
    public static final ErrorTypeKind f;
    public static final ErrorTypeKind g;
    public static final ErrorTypeKind h;
    public static final ErrorTypeKind i;

    /* renamed from: j, reason: collision with root package name */
    public static final ErrorTypeKind f5154j;
    public static final ErrorTypeKind k;
    public static final ErrorTypeKind l;
    public static final ErrorTypeKind m;
    public static final ErrorTypeKind n;
    public static final ErrorTypeKind o;
    public static final ErrorTypeKind p;

    /* renamed from: q, reason: collision with root package name */
    public static final ErrorTypeKind f5155q;

    /* renamed from: r, reason: collision with root package name */
    public static final ErrorTypeKind f5156r;

    /* renamed from: s, reason: collision with root package name */
    public static final ErrorTypeKind f5157s;

    /* renamed from: t, reason: collision with root package name */
    public static final ErrorTypeKind f5158t;
    public static final ErrorTypeKind u;

    /* renamed from: v, reason: collision with root package name */
    public static final ErrorTypeKind f5159v;

    /* renamed from: w, reason: collision with root package name */
    public static final ErrorTypeKind f5160w;

    /* renamed from: x, reason: collision with root package name */
    public static final ErrorTypeKind f5161x;
    public static final ErrorTypeKind y;

    /* renamed from: z, reason: collision with root package name */
    public static final ErrorTypeKind f5162z;

    /* renamed from: a, reason: collision with root package name */
    public final String f5163a;
    public final boolean b;

    static {
        ErrorTypeKind errorTypeKind = new ErrorTypeKind("UNRESOLVED_TYPE", 0, "Unresolved type for %s", true);
        ErrorTypeKind errorTypeKind2 = new ErrorTypeKind("UNRESOLVED_TYPE_PARAMETER_TYPE", 1, "Unresolved type parameter type", true);
        ErrorTypeKind errorTypeKind3 = new ErrorTypeKind("UNRESOLVED_CLASS_TYPE", 2, "Unresolved class %s", true);
        ErrorTypeKind errorTypeKind4 = new ErrorTypeKind("UNRESOLVED_JAVA_CLASS", 3, "Unresolved java class %s", true);
        c = errorTypeKind4;
        ErrorTypeKind errorTypeKind5 = new ErrorTypeKind("UNRESOLVED_DECLARATION", 4, "Unresolved declaration %s", true);
        ErrorTypeKind errorTypeKind6 = new ErrorTypeKind("UNRESOLVED_KCLASS_CONSTANT_VALUE", 5, "Unresolved type for %s (arrayDimensions=%s)", true);
        d = errorTypeKind6;
        ErrorTypeKind errorTypeKind7 = new ErrorTypeKind("UNRESOLVED_TYPE_ALIAS", 6, "Unresolved type alias %s", false);
        ErrorTypeKind errorTypeKind8 = new ErrorTypeKind("RETURN_TYPE", 7, "Return type for %s cannot be resolved", false);
        ErrorTypeKind errorTypeKind9 = new ErrorTypeKind("RETURN_TYPE_FOR_FUNCTION", 8, "Return type for function cannot be resolved", false);
        e = errorTypeKind9;
        ErrorTypeKind errorTypeKind10 = new ErrorTypeKind("RETURN_TYPE_FOR_PROPERTY", 9, "Return type for property %s cannot be resolved", false);
        ErrorTypeKind errorTypeKind11 = new ErrorTypeKind("RETURN_TYPE_FOR_CONSTRUCTOR", 10, "Return type for constructor %s cannot be resolved", false);
        ErrorTypeKind errorTypeKind12 = new ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_FUNCTION", 11, "Implicit return type for function %s cannot be resolved", false);
        ErrorTypeKind errorTypeKind13 = new ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_PROPERTY", 12, "Implicit return type for property %s cannot be resolved", false);
        ErrorTypeKind errorTypeKind14 = new ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR", 13, "Implicit return type for property accessor %s cannot be resolved", false);
        ErrorTypeKind errorTypeKind15 = new ErrorTypeKind("ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT", 14, "%s() return type", false);
        ErrorTypeKind errorTypeKind16 = new ErrorTypeKind("RECURSIVE_TYPE", 15, "Recursive type", false);
        ErrorTypeKind errorTypeKind17 = new ErrorTypeKind("RECURSIVE_TYPE_ALIAS", 16, "Recursive type alias %s", false);
        f = errorTypeKind17;
        ErrorTypeKind errorTypeKind18 = new ErrorTypeKind("RECURSIVE_ANNOTATION_TYPE", 17, "Recursive annotation's type", false);
        ErrorTypeKind errorTypeKind19 = new ErrorTypeKind("CYCLIC_UPPER_BOUNDS", 18, "Cyclic upper bounds", false);
        g = errorTypeKind19;
        ErrorTypeKind errorTypeKind20 = new ErrorTypeKind("CYCLIC_SUPERTYPES", 19, "Cyclic supertypes", false);
        h = errorTypeKind20;
        ErrorTypeKind errorTypeKind21 = new ErrorTypeKind("UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE", 20, "Cannot infer a lambda context receiver type", false);
        ErrorTypeKind errorTypeKind22 = new ErrorTypeKind("UNINFERRED_LAMBDA_PARAMETER_TYPE", 21, "Cannot infer a lambda parameter type", false);
        i = errorTypeKind22;
        ErrorTypeKind errorTypeKind23 = new ErrorTypeKind("UNINFERRED_TYPE_VARIABLE", 22, "Cannot infer a type variable %s", false);
        f5154j = errorTypeKind23;
        ErrorTypeKind errorTypeKind24 = new ErrorTypeKind("RESOLUTION_ERROR_TYPE", 23, "Resolution error type (%s)", false);
        ErrorTypeKind errorTypeKind25 = new ErrorTypeKind("ERROR_EXPECTED_TYPE", 24, "Error expected type", false);
        ErrorTypeKind errorTypeKind26 = new ErrorTypeKind("ERROR_DATA_FLOW_TYPE", 25, "Error type for data flow", false);
        ErrorTypeKind errorTypeKind27 = new ErrorTypeKind("ERROR_WHILE_RECONSTRUCTING_BARE_TYPE", 26, "Failed to reconstruct type %s", false);
        ErrorTypeKind errorTypeKind28 = new ErrorTypeKind("UNABLE_TO_SUBSTITUTE_TYPE", 27, "Unable to substitute type (%s)", false);
        k = errorTypeKind28;
        ErrorTypeKind errorTypeKind29 = new ErrorTypeKind("DONT_CARE", 28, "Special DONT_CARE type", false);
        l = errorTypeKind29;
        ErrorTypeKind errorTypeKind30 = new ErrorTypeKind("STUB_TYPE", 29, "Stub type %s", false);
        ErrorTypeKind errorTypeKind31 = new ErrorTypeKind("FUNCTION_PLACEHOLDER_TYPE", 30, "Function placeholder type (arguments: %s)", false);
        ErrorTypeKind errorTypeKind32 = new ErrorTypeKind("TYPE_FOR_RESULT", 31, "Stubbed 'Result' type", false);
        ErrorTypeKind errorTypeKind33 = new ErrorTypeKind("TYPE_FOR_COMPILER_EXCEPTION", 32, "Error type for a compiler exception while analyzing %s", false);
        ErrorTypeKind errorTypeKind34 = new ErrorTypeKind("ERROR_FLEXIBLE_TYPE", 33, "Error java flexible type with id %s. (%s..%s)", false);
        m = errorTypeKind34;
        ErrorTypeKind errorTypeKind35 = new ErrorTypeKind("ERROR_RAW_TYPE", 34, "Error raw type %s", false);
        n = errorTypeKind35;
        ErrorTypeKind errorTypeKind36 = new ErrorTypeKind("TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS", 35, "Inconsistent type %s (parameters.size = %s, arguments.size = %s)", false);
        ErrorTypeKind errorTypeKind37 = new ErrorTypeKind("ILLEGAL_TYPE_RANGE_FOR_DYNAMIC", 36, "Illegal type range for dynamic type %s..%s", false);
        ErrorTypeKind errorTypeKind38 = new ErrorTypeKind("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER", 37, "Unknown type parameter %s. Please try recompiling module containing \"%s\"", false);
        o = errorTypeKind38;
        ErrorTypeKind errorTypeKind39 = new ErrorTypeKind("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME", 38, "Couldn't deserialize type parameter %s in %s", false);
        p = errorTypeKind39;
        ErrorTypeKind errorTypeKind40 = new ErrorTypeKind("INCONSISTENT_SUSPEND_FUNCTION", 39, "Inconsistent suspend function type in metadata with constructor %s", false);
        f5155q = errorTypeKind40;
        ErrorTypeKind errorTypeKind41 = new ErrorTypeKind("UNEXPECTED_FLEXIBLE_TYPE_ID", 40, "Unexpected id of a flexible type %s. (%s..%s)", false);
        ErrorTypeKind errorTypeKind42 = new ErrorTypeKind("UNKNOWN_TYPE", 41, "Unknown type", false);
        f5156r = errorTypeKind42;
        ErrorTypeKind errorTypeKind43 = new ErrorTypeKind("NO_TYPE_SPECIFIED", 42, "No type specified for %s", false);
        ErrorTypeKind errorTypeKind44 = new ErrorTypeKind("NO_TYPE_FOR_LOOP_RANGE", 43, "Loop range has no type", false);
        ErrorTypeKind errorTypeKind45 = new ErrorTypeKind("NO_TYPE_FOR_LOOP_PARAMETER", 44, "Loop parameter has no type", false);
        ErrorTypeKind errorTypeKind46 = new ErrorTypeKind("MISSED_TYPE_FOR_PARAMETER", 45, "Missed a type for a value parameter %s", false);
        ErrorTypeKind errorTypeKind47 = new ErrorTypeKind("MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER", 46, "Missed a type argument for a type parameter %s", false);
        f5157s = errorTypeKind47;
        ErrorTypeKind errorTypeKind48 = new ErrorTypeKind("PARSE_ERROR_ARGUMENT", 47, "Error type for parse error argument %s", false);
        ErrorTypeKind errorTypeKind49 = new ErrorTypeKind("STAR_PROJECTION_IN_CALL", 48, "Error type for star projection directly passing as a call type argument", false);
        ErrorTypeKind errorTypeKind50 = new ErrorTypeKind("PROHIBITED_DYNAMIC_TYPE", 49, "Dynamic type in a not allowed context", false);
        ErrorTypeKind errorTypeKind51 = new ErrorTypeKind("NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT", 50, "Not an annotation type %s in the annotation context", false);
        ErrorTypeKind errorTypeKind52 = new ErrorTypeKind("UNIT_RETURN_TYPE_FOR_INC_DEC", 51, "Unit type returned by inc or dec", false);
        ErrorTypeKind errorTypeKind53 = new ErrorTypeKind("RETURN_NOT_ALLOWED", 52, "Return not allowed", false);
        ErrorTypeKind errorTypeKind54 = new ErrorTypeKind("UNRESOLVED_PARCEL_TYPE", 53, "Unresolved 'Parcel' type", true);
        ErrorTypeKind errorTypeKind55 = new ErrorTypeKind("KAPT_ERROR_TYPE", 54, "Kapt error type", false);
        ErrorTypeKind errorTypeKind56 = new ErrorTypeKind("SYNTHETIC_ELEMENT_ERROR_TYPE", 55, "Error type for synthetic element", false);
        ErrorTypeKind errorTypeKind57 = new ErrorTypeKind("AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE", 56, "Error type in ad hoc resolve for lighter classes", false);
        ErrorTypeKind errorTypeKind58 = new ErrorTypeKind("ERROR_EXPRESSION_TYPE", 57, "Error expression type", false);
        ErrorTypeKind errorTypeKind59 = new ErrorTypeKind("ERROR_RECEIVER_TYPE", 58, "Error receiver type for %s", false);
        ErrorTypeKind errorTypeKind60 = new ErrorTypeKind("ERROR_CONSTANT_VALUE", 59, "Error constant value %s", false);
        f5158t = errorTypeKind60;
        ErrorTypeKind errorTypeKind61 = new ErrorTypeKind("EMPTY_CALLABLE_REFERENCE", 60, "Empty callable reference", false);
        ErrorTypeKind errorTypeKind62 = new ErrorTypeKind("UNSUPPORTED_CALLABLE_REFERENCE_TYPE", 61, "Unsupported callable reference type %s", false);
        ErrorTypeKind errorTypeKind63 = new ErrorTypeKind("TYPE_FOR_DELEGATION", 62, "Error delegation type for %s", false);
        ErrorTypeKind errorTypeKind64 = new ErrorTypeKind("UNAVAILABLE_TYPE_FOR_DECLARATION", 63, "Type is unavailable for declaration %s", false);
        ErrorTypeKind errorTypeKind65 = new ErrorTypeKind("ERROR_TYPE_PARAMETER", 64, "Error type parameter", false);
        ErrorTypeKind errorTypeKind66 = new ErrorTypeKind("ERROR_TYPE_PROJECTION", 65, "Error type projection", false);
        ErrorTypeKind errorTypeKind67 = new ErrorTypeKind("ERROR_SUPER_TYPE", 66, "Error super type", false);
        ErrorTypeKind errorTypeKind68 = new ErrorTypeKind("SUPER_TYPE_FOR_ERROR_TYPE", 67, "Supertype of error type %s", false);
        ErrorTypeKind errorTypeKind69 = new ErrorTypeKind("ERROR_PROPERTY_TYPE", 68, "Error property type", false);
        u = errorTypeKind69;
        ErrorTypeKind errorTypeKind70 = new ErrorTypeKind("ERROR_CLASS", 69, "Error class", false);
        f5159v = errorTypeKind70;
        ErrorTypeKind errorTypeKind71 = new ErrorTypeKind("TYPE_FOR_ERROR_TYPE_CONSTRUCTOR", 70, "Type for error type constructor (%s)", false);
        f5160w = errorTypeKind71;
        ErrorTypeKind errorTypeKind72 = new ErrorTypeKind("INTERSECTION_OF_ERROR_TYPES", 71, "Intersection of error types %s", false);
        f5161x = errorTypeKind72;
        ErrorTypeKind errorTypeKind73 = new ErrorTypeKind("CANNOT_COMPUTE_ERASED_BOUND", 72, "Cannot compute erased upper bound of a type parameter %s", false);
        y = errorTypeKind73;
        ErrorTypeKind errorTypeKind74 = new ErrorTypeKind("NOT_FOUND_UNSIGNED_TYPE", 73, "Unsigned type %s not found", false);
        f5162z = errorTypeKind74;
        ErrorTypeKind errorTypeKind75 = new ErrorTypeKind("ERROR_ENUM_TYPE", 74, "Not found the corresponding enum class for given enum entry %s.%s", false);
        f5149A = errorTypeKind75;
        ErrorTypeKind errorTypeKind76 = new ErrorTypeKind("NO_RECORDED_TYPE", 75, "Not found recorded type for %s", false);
        f5150B = errorTypeKind76;
        ErrorTypeKind errorTypeKind77 = new ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_FUNCTION", 76, "Descriptor not found for function %s", false);
        ErrorTypeKind errorTypeKind78 = new ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_CLASS", 77, "Cannot build class type, descriptor not found for builder %s", false);
        ErrorTypeKind errorTypeKind79 = new ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER", 78, "Cannot build type parameter type, descriptor not found for builder %s", false);
        ErrorTypeKind errorTypeKind80 = new ErrorTypeKind("UNMAPPED_ANNOTATION_TARGET_TYPE", 79, "Type for unmapped Java annotation target to Kotlin one", false);
        f5151C = errorTypeKind80;
        ErrorTypeKind errorTypeKind81 = new ErrorTypeKind("UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT", 80, "Unknown type for an array element of a java annotation argument", false);
        f5152D = errorTypeKind81;
        ErrorTypeKind errorTypeKind82 = new ErrorTypeKind("NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION", 81, "No fqName for annotation %s", false);
        E = errorTypeKind82;
        ErrorTypeKind[] errorTypeKindArr = {errorTypeKind, errorTypeKind2, errorTypeKind3, errorTypeKind4, errorTypeKind5, errorTypeKind6, errorTypeKind7, errorTypeKind8, errorTypeKind9, errorTypeKind10, errorTypeKind11, errorTypeKind12, errorTypeKind13, errorTypeKind14, errorTypeKind15, errorTypeKind16, errorTypeKind17, errorTypeKind18, errorTypeKind19, errorTypeKind20, errorTypeKind21, errorTypeKind22, errorTypeKind23, errorTypeKind24, errorTypeKind25, errorTypeKind26, errorTypeKind27, errorTypeKind28, errorTypeKind29, errorTypeKind30, errorTypeKind31, errorTypeKind32, errorTypeKind33, errorTypeKind34, errorTypeKind35, errorTypeKind36, errorTypeKind37, errorTypeKind38, errorTypeKind39, errorTypeKind40, errorTypeKind41, errorTypeKind42, errorTypeKind43, errorTypeKind44, errorTypeKind45, errorTypeKind46, errorTypeKind47, errorTypeKind48, errorTypeKind49, errorTypeKind50, errorTypeKind51, errorTypeKind52, errorTypeKind53, errorTypeKind54, errorTypeKind55, errorTypeKind56, errorTypeKind57, errorTypeKind58, errorTypeKind59, errorTypeKind60, errorTypeKind61, errorTypeKind62, errorTypeKind63, errorTypeKind64, errorTypeKind65, errorTypeKind66, errorTypeKind67, errorTypeKind68, errorTypeKind69, errorTypeKind70, errorTypeKind71, errorTypeKind72, errorTypeKind73, errorTypeKind74, errorTypeKind75, errorTypeKind76, errorTypeKind77, errorTypeKind78, errorTypeKind79, errorTypeKind80, errorTypeKind81, errorTypeKind82, new ErrorTypeKind("NOT_FOUND_FQNAME", 82, "No fqName for %s", false), new ErrorTypeKind("TYPE_FOR_GENERATED_ERROR_EXPRESSION", 83, "Type for generated error expression", false)};
        f5153F = errorTypeKindArr;
        a.a(errorTypeKindArr);
    }

    public ErrorTypeKind(String str, int i6, String str2, boolean z10) {
        this.f5163a = str2;
        this.b = z10;
    }

    public static ErrorTypeKind valueOf(String str) {
        return (ErrorTypeKind) Enum.valueOf(ErrorTypeKind.class, str);
    }

    public static ErrorTypeKind[] values() {
        return (ErrorTypeKind[]) f5153F.clone();
    }
}
