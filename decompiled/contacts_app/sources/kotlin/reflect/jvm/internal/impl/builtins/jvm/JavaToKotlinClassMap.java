package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaToKotlinClassMap {
    private static final ClassId CLASS_CLASS_ID = null;
    private static final ClassId FUNCTION_N_CLASS_ID = null;
    private static final FqName FUNCTION_N_FQ_NAME = null;
    public static final JavaToKotlinClassMap INSTANCE = null;
    private static final ClassId K_CLASS_CLASS_ID = null;
    private static final ClassId K_FUNCTION_CLASS_ID = null;
    private static final String NUMBERED_FUNCTION_PREFIX = null;
    private static final String NUMBERED_K_FUNCTION_PREFIX = null;
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX = null;
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX = null;
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin = null;
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava = null;
    private static final List<PlatformMutabilityMapping> mutabilityMappings = null;
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly = null;
    private static final HashMap<ClassId, ClassId> mutableToReadOnlyClassId = null;
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable = null;
    private static final HashMap<ClassId, ClassId> readOnlyToMutableClassId = null;

    /* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PlatformMutabilityMapping) == true) goto L8;
            return false;
        L8:
            PlatformMutabilityMapping r6 = (PlatformMutabilityMapping) r5;
            if (Intrinsics.areEqual(this.javaClass, r6.javaClass) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.kotlinReadOnly, r6.kotlinReadOnly) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.kotlinMutable, r6.kotlinMutable) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }

        public PlatformMutabilityMapping(ClassId r2, ClassId r3, ClassId r4) {
            Intrinsics.checkNotNullParameter(r2, "javaClass");
            Intrinsics.checkNotNullParameter(r3, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(r4, "kotlinMutable");
            this.javaClass = r2;
            this.kotlinReadOnly = r3;
            this.kotlinMutable = r4;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }
    }

    private JavaToKotlinClassMap() {
    }

    static {
        JavaToKotlinClassMap r0 = new JavaToKotlinClassMap();
        INSTANCE = r0;
        NUMBERED_FUNCTION_PREFIX = FunctionClassKind.Function.getPackageFqName().toString() + '.' + FunctionClassKind.Function.getClassNamePrefix();
        NUMBERED_K_FUNCTION_PREFIX = FunctionClassKind.KFunction.getPackageFqName().toString() + '.' + FunctionClassKind.KFunction.getClassNamePrefix();
        NUMBERED_SUSPEND_FUNCTION_PREFIX = FunctionClassKind.SuspendFunction.getPackageFqName().toString() + '.' + FunctionClassKind.SuspendFunction.getClassNamePrefix();
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = FunctionClassKind.KSuspendFunction.getPackageFqName().toString() + '.' + FunctionClassKind.KSuspendFunction.getClassNamePrefix();
        ClassId r1 = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        FUNCTION_N_CLASS_ID = r1;
        FqName r2 = r1.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r2, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        FUNCTION_N_FQ_NAME = r2;
        K_FUNCTION_CLASS_ID = StandardClassIds.INSTANCE.getKFunction();
        K_CLASS_CLASS_ID = StandardClassIds.INSTANCE.getKClass();
        CLASS_CLASS_ID = r0.classId(Class.class);
        javaToKotlin = new HashMap();
        kotlinToJava = new HashMap();
        mutableToReadOnly = new HashMap();
        readOnlyToMutable = new HashMap();
        mutableToReadOnlyClassId = new HashMap();
        readOnlyToMutableClassId = new HashMap();
        ClassId r3 = ClassId.topLevel(StandardNames.FqNames.iterable);
        Intrinsics.checkNotNullExpressionValue(r3, "topLevel(FqNames.iterable)");
        FqName r4 = StandardNames.FqNames.mutableIterable;
        FqName r6 = r3.getPackageFqName();
        FqName r7 = r3.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r7, "kotlinReadOnly.packageFqName");
        FqName r5 = FqNamesUtilKt.tail(r4, r7);
        int r8 = 0;
        ClassId r9 = new ClassId(r6, r5, false);
        ClassId r10 = ClassId.topLevel(StandardNames.FqNames.iterator);
        Intrinsics.checkNotNullExpressionValue(r10, "topLevel(FqNames.iterator)");
        FqName r11 = StandardNames.FqNames.mutableIterator;
        FqName r12 = r10.getPackageFqName();
        FqName r13 = r10.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r13, "kotlinReadOnly.packageFqName");
        ClassId r14 = new ClassId(r12, FqNamesUtilKt.tail(r11, r13), false);
        ClassId r15 = ClassId.topLevel(StandardNames.FqNames.collection);
        Intrinsics.checkNotNullExpressionValue(r15, "topLevel(FqNames.collection)");
        FqName r16 = StandardNames.FqNames.mutableCollection;
        FqName r17 = r15.getPackageFqName();
        FqName r18 = r15.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r18, "kotlinReadOnly.packageFqName");
        ClassId r19 = new ClassId(r17, FqNamesUtilKt.tail(r16, r18), false);
        ClassId r20 = ClassId.topLevel(StandardNames.FqNames.list);
        Intrinsics.checkNotNullExpressionValue(r20, "topLevel(FqNames.list)");
        FqName r21 = StandardNames.FqNames.mutableList;
        FqName r22 = r20.getPackageFqName();
        FqName r23 = r20.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r23, "kotlinReadOnly.packageFqName");
        ClassId r24 = new ClassId(r22, FqNamesUtilKt.tail(r21, r23), false);
        ClassId r25 = ClassId.topLevel(StandardNames.FqNames.set);
        Intrinsics.checkNotNullExpressionValue(r25, "topLevel(FqNames.set)");
        FqName r26 = StandardNames.FqNames.mutableSet;
        FqName r27 = r25.getPackageFqName();
        FqName r28 = r25.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r28, "kotlinReadOnly.packageFqName");
        ClassId r29 = new ClassId(r27, FqNamesUtilKt.tail(r26, r28), false);
        ClassId r30 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        Intrinsics.checkNotNullExpressionValue(r30, "topLevel(FqNames.listIterator)");
        FqName r31 = StandardNames.FqNames.mutableListIterator;
        FqName r32 = r30.getPackageFqName();
        FqName r33 = r30.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r33, "kotlinReadOnly.packageFqName");
        ClassId r34 = new ClassId(r32, FqNamesUtilKt.tail(r31, r33), false);
        ClassId r35 = ClassId.topLevel(StandardNames.FqNames.map);
        Intrinsics.checkNotNullExpressionValue(r35, "topLevel(FqNames.map)");
        FqName r36 = StandardNames.FqNames.mutableMap;
        FqName r37 = r35.getPackageFqName();
        FqName r38 = r35.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r38, "kotlinReadOnly.packageFqName");
        ClassId r39 = new ClassId(r37, FqNamesUtilKt.tail(r36, r38), false);
        ClassId r40 = ClassId.topLevel(StandardNames.FqNames.map).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        Intrinsics.checkNotNullExpressionValue(r40, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        FqName r41 = StandardNames.FqNames.mutableMapEntry;
        FqName r42 = r40.getPackageFqName();
        FqName r43 = r40.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r43, "kotlinReadOnly.packageFqName");
        List<PlatformMutabilityMapping> r44 = CollectionsKt.listOf(new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(r0.classId(Iterable.class), r3, r9), new PlatformMutabilityMapping(r0.classId(Iterator.class), r10, r14), new PlatformMutabilityMapping(r0.classId(Collection.class), r15, r19), new PlatformMutabilityMapping(r0.classId(List.class), r20, r24), new PlatformMutabilityMapping(r0.classId(Set.class), r25, r29), new PlatformMutabilityMapping(r0.classId(ListIterator.class), r30, r34), new PlatformMutabilityMapping(r0.classId(Map.class), r35, r39), new PlatformMutabilityMapping(r0.classId(Map.Entry.class), r40, new ClassId(r42, FqNamesUtilKt.tail(r41, r43), false))});
        mutabilityMappings = r44;
        r0.addTopLevel(Object.class, StandardNames.FqNames.any);
        r0.addTopLevel(String.class, StandardNames.FqNames.string);
        r0.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        r0.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        r0.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        r0.addTopLevel(Number.class, StandardNames.FqNames.number);
        r0.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        r0.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        r0.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        Iterator<PlatformMutabilityMapping> r45 = r44.iterator();
    L4:
        if (r45.hasNext() == false) goto L6;
        INSTANCE.addMapping(r45.next());
        goto L4
    L6:
        JvmPrimitiveType[] r46 = JvmPrimitiveType.values();
        int r47 = r46.length;
        int r48 = 0;
    L7:
        if (r48 >= r47) goto L9;
        JvmPrimitiveType r49 = r46[r48];
        JavaToKotlinClassMap r50 = INSTANCE;
        ClassId r51 = ClassId.topLevel(r49.getWrapperFqName());
        Intrinsics.checkNotNullExpressionValue(r51, "topLevel(jvmType.wrapperFqName)");
        PrimitiveType r52 = r49.getPrimitiveType();
        Intrinsics.checkNotNullExpressionValue(r52, "jvmType.primitiveType");
        ClassId r53 = ClassId.topLevel(StandardNames.getPrimitiveFqName(r52));
        Intrinsics.checkNotNullExpressionValue(r53, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
        r50.add(r51, r53);
        r48 = r48 + 1;
        goto L7
    L9:
        Iterator<ClassId> r54 = CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions().iterator();
    L11:
        if (r54.hasNext() == false) goto L13;
        ClassId r55 = r54.next();
        JavaToKotlinClassMap r56 = INSTANCE;
        ClassId r57 = ClassId.topLevel(new FqName("kotlin.jvm.internal." + r55.getShortClassName().asString() + "CompanionObject"));
        Intrinsics.checkNotNullExpressionValue(r57, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
        ClassId r58 = r55.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
        Intrinsics.checkNotNullExpressionValue(r58, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
        r56.add(r57, r58);
        goto L11
    L13:
        int r59 = 0;
    L15:
        if (r59 >= 23) goto L18;
        JavaToKotlinClassMap r60 = INSTANCE;
        ClassId r61 = ClassId.topLevel(new FqName("kotlin.jvm.functions.Function" + r59));
        Intrinsics.checkNotNullExpressionValue(r61, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
        r60.add(r61, StandardNames.getFunctionClassId(r59));
        r60.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + r59), K_FUNCTION_CLASS_ID);
        r59 = r59 + 1;
    L18:
        if (r8 >= 22) goto L20;
        FunctionClassKind r62 = FunctionClassKind.KSuspendFunction;
        INSTANCE.addKotlinToJava(new FqName((r62.getPackageFqName().toString() + '.' + r62.getClassNamePrefix()) + r8), K_FUNCTION_CLASS_ID);
        r8 = r8 + 1;
        goto L18
    L20:
        JavaToKotlinClassMap r63 = INSTANCE;
        FqName r64 = StandardNames.FqNames.nothing.toSafe();
        Intrinsics.checkNotNullExpressionValue(r64, "nothing.toSafe()");
        r63.addKotlinToJava(r64, r63.classId(Void.class));
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final ClassId mapJavaToKotlin(FqName r1) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        return javaToKotlin.get(r1.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinFqName");
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_FUNCTION_PREFIX) == false) goto L6;
        return FUNCTION_N_CLASS_ID;
    L6:
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_SUSPEND_FUNCTION_PREFIX) == false) goto L9;
        return FUNCTION_N_CLASS_ID;
    L9:
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_K_FUNCTION_PREFIX) == false) goto L12;
        return K_FUNCTION_CLASS_ID;
    L12:
        if (isKotlinFunctionWithBigArity(r2, NUMBERED_K_SUSPEND_FUNCTION_PREFIX) == false) goto L15;
        return K_FUNCTION_CLASS_ID;
    L15:
        return kotlinToJava.get(r2);
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe r5, String r6) {
        String r4 = r5.asString();
        Intrinsics.checkNotNullExpressionValue(r4, "kotlinFqName.asString()");
        String r7 = StringsKt.substringAfter(r4, r6, "");
        String r8 = r7;
        if (r8.length() <= 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
    L16:
        return false;
    L8:
        if (StringsKt.startsWith$default(r8, '0', false, 2, null) == true) goto L16;
        Integer r10 = StringsKt.toIntOrNull(r7);
        if (r10 == null) goto L15;
        if (r10.intValue() < 23) goto L15;
        return true;
    L15:
        return false;
    L5:
        r9 = false;
        goto L6
    }

    private final void addMapping(PlatformMutabilityMapping r5) {
        ClassId r0 = r5.component1();
        ClassId r1 = r5.component2();
        ClassId r6 = r5.component3();
        add(r0, r1);
        FqName r2 = r6.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r2, "mutableClassId.asSingleFqName()");
        addKotlinToJava(r2, r0);
        mutableToReadOnlyClassId.put(r6, r1);
        readOnlyToMutableClassId.put(r1, r6);
        FqName r4 = r1.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r4, "readOnlyClassId.asSingleFqName()");
        FqName r3 = r6.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r3, "mutableClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, FqName> r7 = mutableToReadOnly;
        FqNameUnsafe r8 = r6.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r8, "mutableClassId.asSingleFqName().toUnsafe()");
        r7.put(r8, r4);
        HashMap<FqNameUnsafe, FqName> r9 = readOnlyToMutable;
        FqNameUnsafe r10 = r4.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r10, "readOnlyFqName.toUnsafe()");
        r9.put(r10, r3);
    }

    private final void add(ClassId r2, ClassId r3) {
        addJavaToKotlin(r2, r3);
        FqName r4 = r3.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r4, "kotlinClassId.asSingleFqName()");
        addKotlinToJava(r4, r2);
    }

    private final void addTopLevel(Class<?> r2, FqNameUnsafe r3) {
        FqName r4 = r3.toSafe();
        Intrinsics.checkNotNullExpressionValue(r4, "kotlinFqName.toSafe()");
        addTopLevel(r2, r4);
    }

    private final void addTopLevel(Class<?> r2, FqName r3) {
        ClassId r4 = classId(r2);
        ClassId r5 = ClassId.topLevel(r3);
        Intrinsics.checkNotNullExpressionValue(r5, "topLevel(kotlinFqName)");
        add(r4, r5);
    }

    private final void addJavaToKotlin(ClassId r2, ClassId r3) {
        HashMap<FqNameUnsafe, ClassId> r1 = javaToKotlin;
        FqNameUnsafe r4 = r2.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r4, "javaClassId.asSingleFqName().toUnsafe()");
        r1.put(r4, r3);
    }

    private final void addKotlinToJava(FqName r2, ClassId r3) {
        HashMap<FqNameUnsafe, ClassId> r1 = kotlinToJava;
        FqNameUnsafe r4 = r2.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r4, "kotlinFqNameUnsafe.toUnsafe()");
        r1.put(r4, r3);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe r1) {
        return mutableToReadOnly.get(r1);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe r1) {
        return readOnlyToMutable.get(r1);
    }

    public final boolean isMutable(FqNameUnsafe r1) {
        return mutableToReadOnly.containsKey(r1);
    }

    public final boolean isReadOnly(FqNameUnsafe r1) {
        return readOnlyToMutable.containsKey(r1);
    }

    private final ClassId classId(Class<?> r2) {
        if (r2.isPrimitive() == true) goto L5;
        r2.isArray();
    L5:
        Class<?> r0 = r2.getDeclaringClass();
        if (r0 != null) goto L8;
        ClassId r1 = ClassId.topLevel(new FqName(r2.getCanonicalName()));
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(FqName(clazz.canonicalName))");
        return r1;
    L8:
        ClassId r3 = classId(r0).createNestedClassId(Name.identifier(r2.getSimpleName()));
        Intrinsics.checkNotNullExpressionValue(r3, "classId(outer).createNes…tifier(clazz.simpleName))");
        return r3;
    }
}
