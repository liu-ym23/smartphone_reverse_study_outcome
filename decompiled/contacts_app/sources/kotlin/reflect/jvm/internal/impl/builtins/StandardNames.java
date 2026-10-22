package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: compiled from: StandardNames.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME = null;
    public static final Name BACKING_FIELD = null;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME = null;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES = null;
    public static final Name BUILT_INS_PACKAGE_NAME = null;
    public static final Name CHAR_CODE = null;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME = null;
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = null;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME = null;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = null;
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = null;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME = null;
    public static final String DATA_CLASS_COMPONENT_PREFIX = null;
    public static final Name DATA_CLASS_COPY = null;
    public static final Name DEFAULT_VALUE_PARAMETER = null;
    public static final FqName DYNAMIC_FQ_NAME = null;
    public static final Name ENUM_VALUES = null;
    public static final Name ENUM_VALUE_OF = null;
    public static final Name HASHCODE_NAME = null;
    public static final StandardNames INSTANCE = null;
    private static final FqName KOTLIN_INTERNAL_FQ_NAME = null;
    public static final FqName KOTLIN_REFLECT_FQ_NAME = null;
    public static final List<String> PREFIXES = null;
    public static final FqName RANGES_PACKAGE_FQ_NAME = null;
    public static final FqName RESULT_FQ_NAME = null;
    public static final FqName TEXT_PACKAGE_FQ_NAME = null;

    /* JADX INFO: compiled from: StandardNames.kt */
    public static final class FqNames {
        public static final FqNames INSTANCE = null;
        public static final FqNameUnsafe _boolean = null;
        public static final FqNameUnsafe _byte = null;
        public static final FqNameUnsafe _char = null;
        public static final FqNameUnsafe _double = null;
        public static final FqNameUnsafe _enum = null;
        public static final FqNameUnsafe _float = null;
        public static final FqNameUnsafe _int = null;
        public static final FqNameUnsafe _long = null;
        public static final FqNameUnsafe _short = null;
        public static final FqName annotation = null;
        public static final FqName annotationRetention = null;
        public static final FqName annotationTarget = null;
        public static final FqNameUnsafe any = null;
        public static final FqNameUnsafe array = null;
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType = null;
        public static final FqNameUnsafe charSequence = null;
        public static final FqNameUnsafe cloneable = null;
        public static final FqName collection = null;
        public static final FqName comparable = null;
        public static final FqName contextFunctionTypeParams = null;
        public static final FqName deprecated = null;
        public static final FqName deprecatedSinceKotlin = null;
        public static final FqName deprecationLevel = null;
        public static final FqName extensionFunctionType = null;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType = null;
        public static final FqNameUnsafe functionSupertype = null;
        public static final FqNameUnsafe intRange = null;
        public static final FqName iterable = null;
        public static final FqName iterator = null;
        public static final FqNameUnsafe kCallable = null;
        public static final FqNameUnsafe kClass = null;
        public static final FqNameUnsafe kDeclarationContainer = null;
        public static final FqNameUnsafe kMutableProperty0 = null;
        public static final FqNameUnsafe kMutableProperty1 = null;
        public static final FqNameUnsafe kMutableProperty2 = null;
        public static final FqNameUnsafe kMutablePropertyFqName = null;
        public static final ClassId kProperty = null;
        public static final FqNameUnsafe kProperty0 = null;
        public static final FqNameUnsafe kProperty1 = null;
        public static final FqNameUnsafe kProperty2 = null;
        public static final FqNameUnsafe kPropertyFqName = null;
        public static final FqName list = null;
        public static final FqName listIterator = null;
        public static final FqNameUnsafe longRange = null;
        public static final FqName map = null;
        public static final FqName mapEntry = null;
        public static final FqName mustBeDocumented = null;
        public static final FqName mutableCollection = null;
        public static final FqName mutableIterable = null;
        public static final FqName mutableIterator = null;
        public static final FqName mutableList = null;
        public static final FqName mutableListIterator = null;
        public static final FqName mutableMap = null;
        public static final FqName mutableMapEntry = null;
        public static final FqName mutableSet = null;
        public static final FqNameUnsafe nothing = null;
        public static final FqNameUnsafe number = null;
        public static final FqName parameterName = null;
        public static final ClassId parameterNameClassId = null;
        public static final Set<Name> primitiveArrayTypeShortNames = null;
        public static final Set<Name> primitiveTypeShortNames = null;
        public static final FqName publishedApi = null;
        public static final FqName repeatable = null;
        public static final ClassId repeatableClassId = null;
        public static final FqName replaceWith = null;
        public static final FqName retention = null;
        public static final ClassId retentionClassId = null;
        public static final FqName set = null;
        public static final FqNameUnsafe string = null;
        public static final FqName suppress = null;
        public static final FqName target = null;
        public static final ClassId targetClassId = null;
        public static final FqName throwable = null;
        public static final ClassId uByte = null;
        public static final FqName uByteArrayFqName = null;
        public static final FqName uByteFqName = null;
        public static final ClassId uInt = null;
        public static final FqName uIntArrayFqName = null;
        public static final FqName uIntFqName = null;
        public static final ClassId uLong = null;
        public static final FqName uLongArrayFqName = null;
        public static final FqName uLongFqName = null;
        public static final ClassId uShort = null;
        public static final FqName uShortArrayFqName = null;
        public static final FqName uShortFqName = null;
        public static final FqNameUnsafe unit = null;
        public static final FqName unsafeVariance = null;

        private FqNames() {
        }

        static {
            FqNames r0 = new FqNames();
            INSTANCE = r0;
            any = r0.fqNameUnsafe("Any");
            nothing = r0.fqNameUnsafe("Nothing");
            cloneable = r0.fqNameUnsafe("Cloneable");
            suppress = r0.fqName("Suppress");
            unit = r0.fqNameUnsafe("Unit");
            charSequence = r0.fqNameUnsafe("CharSequence");
            string = r0.fqNameUnsafe("String");
            array = r0.fqNameUnsafe("Array");
            _boolean = r0.fqNameUnsafe("Boolean");
            _char = r0.fqNameUnsafe("Char");
            _byte = r0.fqNameUnsafe("Byte");
            _short = r0.fqNameUnsafe("Short");
            _int = r0.fqNameUnsafe("Int");
            _long = r0.fqNameUnsafe("Long");
            _float = r0.fqNameUnsafe("Float");
            _double = r0.fqNameUnsafe("Double");
            number = r0.fqNameUnsafe("Number");
            _enum = r0.fqNameUnsafe("Enum");
            functionSupertype = r0.fqNameUnsafe("Function");
            throwable = r0.fqName("Throwable");
            comparable = r0.fqName("Comparable");
            intRange = r0.rangesFqName("IntRange");
            longRange = r0.rangesFqName("LongRange");
            deprecated = r0.fqName("Deprecated");
            deprecatedSinceKotlin = r0.fqName("DeprecatedSinceKotlin");
            deprecationLevel = r0.fqName("DeprecationLevel");
            replaceWith = r0.fqName("ReplaceWith");
            extensionFunctionType = r0.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = r0.fqName("ContextFunctionTypeParams");
            FqName r1 = r0.fqName("ParameterName");
            parameterName = r1;
            ClassId r2 = ClassId.topLevel(r1);
            Intrinsics.checkNotNullExpressionValue(r2, "topLevel(parameterName)");
            parameterNameClassId = r2;
            annotation = r0.fqName("Annotation");
            FqName r3 = r0.annotationName("Target");
            target = r3;
            ClassId r4 = ClassId.topLevel(r3);
            Intrinsics.checkNotNullExpressionValue(r4, "topLevel(target)");
            targetClassId = r4;
            annotationTarget = r0.annotationName("AnnotationTarget");
            annotationRetention = r0.annotationName("AnnotationRetention");
            FqName r5 = r0.annotationName("Retention");
            retention = r5;
            ClassId r6 = ClassId.topLevel(r5);
            Intrinsics.checkNotNullExpressionValue(r6, "topLevel(retention)");
            retentionClassId = r6;
            FqName r7 = r0.annotationName("Repeatable");
            repeatable = r7;
            ClassId r8 = ClassId.topLevel(r7);
            Intrinsics.checkNotNullExpressionValue(r8, "topLevel(repeatable)");
            repeatableClassId = r8;
            mustBeDocumented = r0.annotationName("MustBeDocumented");
            unsafeVariance = r0.fqName("UnsafeVariance");
            publishedApi = r0.fqName("PublishedApi");
            iterator = r0.collectionsFqName("Iterator");
            iterable = r0.collectionsFqName("Iterable");
            collection = r0.collectionsFqName("Collection");
            list = r0.collectionsFqName("List");
            listIterator = r0.collectionsFqName("ListIterator");
            set = r0.collectionsFqName("Set");
            FqName r9 = r0.collectionsFqName("Map");
            map = r9;
            FqName r10 = r9.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(r10, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = r10;
            mutableIterator = r0.collectionsFqName("MutableIterator");
            mutableIterable = r0.collectionsFqName("MutableIterable");
            mutableCollection = r0.collectionsFqName("MutableCollection");
            mutableList = r0.collectionsFqName("MutableList");
            mutableListIterator = r0.collectionsFqName("MutableListIterator");
            mutableSet = r0.collectionsFqName("MutableSet");
            FqName r11 = r0.collectionsFqName("MutableMap");
            mutableMap = r11;
            FqName r12 = r11.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(r12, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = r12;
            kClass = reflect("KClass");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe r13 = reflect("KProperty");
            kPropertyFqName = r13;
            kMutablePropertyFqName = reflect("KMutableProperty");
            ClassId r14 = ClassId.topLevel(r13.toSafe());
            Intrinsics.checkNotNullExpressionValue(r14, "topLevel(kPropertyFqName.toSafe())");
            kProperty = r14;
            kDeclarationContainer = reflect("KDeclarationContainer");
            FqName r15 = r0.fqName("UByte");
            uByteFqName = r15;
            FqName r16 = r0.fqName("UShort");
            uShortFqName = r16;
            FqName r17 = r0.fqName("UInt");
            uIntFqName = r17;
            FqName r18 = r0.fqName("ULong");
            uLongFqName = r18;
            ClassId r19 = ClassId.topLevel(r15);
            Intrinsics.checkNotNullExpressionValue(r19, "topLevel(uByteFqName)");
            uByte = r19;
            ClassId r20 = ClassId.topLevel(r16);
            Intrinsics.checkNotNullExpressionValue(r20, "topLevel(uShortFqName)");
            uShort = r20;
            ClassId r21 = ClassId.topLevel(r17);
            Intrinsics.checkNotNullExpressionValue(r21, "topLevel(uIntFqName)");
            uInt = r21;
            ClassId r22 = ClassId.topLevel(r18);
            Intrinsics.checkNotNullExpressionValue(r22, "topLevel(uLongFqName)");
            uLong = r22;
            uByteArrayFqName = r0.fqName("UByteArray");
            uShortArrayFqName = r0.fqName("UShortArray");
            uIntArrayFqName = r0.fqName("UIntArray");
            uLongArrayFqName = r0.fqName("ULongArray");
            HashSet r23 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r24 = PrimitiveType.values();
            int r25 = r24.length;
            int r26 = 0;
            int r27 = 0;
        L3:
            if (r27 >= r25) goto L5;
            r23.add(r24[r27].getTypeName());
            r27 = r27 + 1;
            goto L3
        L5:
            primitiveTypeShortNames = r23;
            HashSet r28 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r29 = PrimitiveType.values();
            int r30 = r29.length;
            int r31 = 0;
        L6:
            if (r31 >= r30) goto L8;
            r28.add(r29[r31].getArrayTypeName());
            r31 = r31 + 1;
            goto L6
        L8:
            primitiveArrayTypeShortNames = r28;
            HashMap r32 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r33 = PrimitiveType.values();
            int r34 = r33.length;
            int r35 = 0;
        L9:
            if (r35 >= r34) goto L11;
            PrimitiveType r36 = r33[r35];
            FqNames r37 = INSTANCE;
            String r38 = r36.getTypeName().asString();
            Intrinsics.checkNotNullExpressionValue(r38, "primitiveType.typeName.asString()");
            r32.put(r37.fqNameUnsafe(r38), r36);
            r35 = r35 + 1;
            goto L9
        L11:
            fqNameToPrimitiveType = r32;
            HashMap r39 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r40 = PrimitiveType.values();
            int r41 = r40.length;
        L12:
            if (r26 >= r41) goto L14;
            PrimitiveType r42 = r40[r26];
            FqNames r43 = INSTANCE;
            String r44 = r42.getArrayTypeName().asString();
            Intrinsics.checkNotNullExpressionValue(r44, "primitiveType.arrayTypeName.asString()");
            r39.put(r43.fqNameUnsafe(r44), r42);
            r26 = r26 + 1;
            goto L12
        L14:
            arrayClassFqNameToPrimitiveType = r39;
        }

        private final FqNameUnsafe fqNameUnsafe(String r1) {
            FqNameUnsafe r0 = fqName(r1).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r0, "fqName(simpleName).toUnsafe()");
            return r0;
        }

        private final FqName fqName(String r1) {
            FqName r0 = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(r1));
            Intrinsics.checkNotNullExpressionValue(r0, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(simpleName))");
            return r0;
        }

        private final FqName collectionsFqName(String r1) {
            FqName r0 = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(r1));
            Intrinsics.checkNotNullExpressionValue(r0, "COLLECTIONS_PACKAGE_FQ_N…e.identifier(simpleName))");
            return r0;
        }

        private final FqNameUnsafe rangesFqName(String r1) {
            FqNameUnsafe r0 = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(r1)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r0, "RANGES_PACKAGE_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return r0;
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String r1) {
            Intrinsics.checkNotNullParameter(r1, "simpleName");
            FqNameUnsafe r2 = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(r1)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r2, "KOTLIN_REFLECT_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return r2;
        }

        private final FqName annotationName(String r1) {
            FqName r0 = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(r1));
            Intrinsics.checkNotNullExpressionValue(r0, "ANNOTATION_PACKAGE_FQ_NA…e.identifier(simpleName))");
            return r0;
        }
    }

    private StandardNames() {
    }

    static {
        INSTANCE = new StandardNames();
        Name r0 = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(r0, "identifier(\"field\")");
        BACKING_FIELD = r0;
        Name r1 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(r1, "identifier(\"value\")");
        DEFAULT_VALUE_PARAMETER = r1;
        Name r2 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(r2, "identifier(\"values\")");
        ENUM_VALUES = r2;
        Name r3 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(r3, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = r3;
        Name r4 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(r4, "identifier(\"copy\")");
        DATA_CLASS_COPY = r4;
        DATA_CLASS_COMPONENT_PREFIX = "component";
        Name r5 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(r5, "identifier(\"hashCode\")");
        HASHCODE_NAME = r5;
        Name r6 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(r6, "identifier(\"code\")");
        CHAR_CODE = r6;
        Name r7 = Name.identifier("count");
        Intrinsics.checkNotNullExpressionValue(r7, "identifier(\"count\")");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = r7;
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        FqName r8 = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = r8;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        FqName r9 = r8.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(r9, "COROUTINES_PACKAGE_FQ_NA…entifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME = r9;
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName r10 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = r10;
        PREFIXES = kotlin.collections.CollectionsKt.listOf(new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name r11 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(r11, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = r11;
        FqName r12 = FqName.topLevel(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = r12;
        FqName r13 = r12.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(r13, "BUILT_INS_PACKAGE_FQ_NAM…identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = r13;
        FqName r14 = r12.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(r14, "BUILT_INS_PACKAGE_FQ_NAM…dentifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = r14;
        FqName r15 = r12.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(r15, "BUILT_INS_PACKAGE_FQ_NAM…ame.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = r15;
        FqName r16 = r12.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(r16, "BUILT_INS_PACKAGE_FQ_NAM…(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = r16;
        FqName r17 = r12.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(r17, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(\"internal\"))");
        KOTLIN_INTERNAL_FQ_NAME = r17;
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[]{r12, r14, r15, r13, r10, r17, r8});
    }

    @JvmStatic
    public static final String getFunctionName(int r2) {
        return "Function" + r2;
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int r2) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(r2)));
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int r2) {
        return FunctionClassKind.SuspendFunction.getClassNamePrefix() + r2;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe r1) {
        Intrinsics.checkNotNullParameter(r1, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType r1) {
        Intrinsics.checkNotNullParameter(r1, "primitiveType");
        FqName r2 = BUILT_INS_PACKAGE_FQ_NAME.child(r1.getTypeName());
        Intrinsics.checkNotNullExpressionValue(r2, "BUILT_INS_PACKAGE_FQ_NAM…d(primitiveType.typeName)");
        return r2;
    }
}
