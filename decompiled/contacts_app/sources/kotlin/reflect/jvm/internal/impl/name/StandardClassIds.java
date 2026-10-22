package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: StandardClassIds.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StandardClassIds {
    private static final ClassId Annotation = null;
    private static final ClassId AnnotationRetention = null;
    private static final ClassId AnnotationTarget = null;
    private static final ClassId Any = null;
    private static final ClassId Array = null;
    private static final FqName BASE_ANNOTATION_PACKAGE = null;
    private static final FqName BASE_COLLECTIONS_PACKAGE = null;
    private static final FqName BASE_COROUTINES_PACKAGE = null;
    private static final FqName BASE_INTERNAL_IR_PACKAGE = null;
    private static final FqName BASE_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE = null;
    private static final FqName BASE_JVM_PACKAGE = null;
    private static final FqName BASE_KOTLIN_PACKAGE = null;
    private static final FqName BASE_RANGES_PACKAGE = null;
    private static final FqName BASE_REFLECT_PACKAGE = null;
    private static final ClassId Boolean = null;
    private static final ClassId Byte = null;
    private static final ClassId Char = null;
    private static final ClassId CharRange = null;
    private static final ClassId Cloneable = null;
    private static final ClassId Collection = null;
    private static final ClassId Comparable = null;
    private static final ClassId Continuation = null;
    private static final ClassId Double = null;
    private static final ClassId Enum = null;
    private static final ClassId Float = null;
    private static final ClassId Function = null;
    public static final StandardClassIds INSTANCE = null;
    private static final ClassId Int = null;
    private static final ClassId IntRange = null;
    private static final ClassId Iterable = null;
    private static final ClassId Iterator = null;
    private static final ClassId KCallable = null;
    private static final ClassId KClass = null;
    private static final ClassId KFunction = null;
    private static final ClassId KMutableProperty = null;
    private static final ClassId KMutableProperty0 = null;
    private static final ClassId KMutableProperty1 = null;
    private static final ClassId KMutableProperty2 = null;
    private static final ClassId KProperty = null;
    private static final ClassId KProperty0 = null;
    private static final ClassId KProperty1 = null;
    private static final ClassId KProperty2 = null;
    private static final ClassId List = null;
    private static final ClassId ListIterator = null;
    private static final ClassId Long = null;
    private static final ClassId LongRange = null;
    private static final ClassId Map = null;
    private static final ClassId MapEntry = null;
    private static final ClassId MutableCollection = null;
    private static final ClassId MutableIterable = null;
    private static final ClassId MutableIterator = null;
    private static final ClassId MutableList = null;
    private static final ClassId MutableListIterator = null;
    private static final ClassId MutableMap = null;
    private static final ClassId MutableMapEntry = null;
    private static final ClassId MutableSet = null;
    private static final ClassId Nothing = null;
    private static final ClassId Number = null;
    private static final ClassId Result = null;
    private static final ClassId Set = null;
    private static final ClassId Short = null;
    private static final ClassId String = null;
    private static final ClassId Throwable = null;
    private static final ClassId UByte = null;
    private static final ClassId UInt = null;
    private static final ClassId ULong = null;
    private static final ClassId UShort = null;
    private static final ClassId Unit = null;
    private static final Set<FqName> builtInsPackages = null;
    private static final Set<ClassId> constantAllowedTypes = null;
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType = null;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType = null;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType = null;
    private static final Set<ClassId> primitiveTypes = null;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType = null;
    private static final Set<ClassId> unsignedTypes = null;

    private StandardClassIds() {
    }

    static {
        INSTANCE = new StandardClassIds();
        FqName r0 = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = r0;
        FqName r1 = r0.child(Name.identifier("reflect"));
        Intrinsics.checkNotNullExpressionValue(r1, "BASE_KOTLIN_PACKAGE.chil…me.identifier(\"reflect\"))");
        BASE_REFLECT_PACKAGE = r1;
        FqName r2 = r0.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(r2, "BASE_KOTLIN_PACKAGE.chil…dentifier(\"collections\"))");
        BASE_COLLECTIONS_PACKAGE = r2;
        FqName r3 = r0.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(r3, "BASE_KOTLIN_PACKAGE.chil…ame.identifier(\"ranges\"))");
        BASE_RANGES_PACKAGE = r3;
        FqName r4 = r0.child(Name.identifier("jvm"));
        Intrinsics.checkNotNullExpressionValue(r4, "BASE_KOTLIN_PACKAGE.child(Name.identifier(\"jvm\"))");
        BASE_JVM_PACKAGE = r4;
        FqName r5 = r4.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(r5, "BASE_JVM_PACKAGE.child(N…e.identifier(\"internal\"))");
        BASE_JVM_INTERNAL_PACKAGE = r5;
        FqName r6 = r0.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(r6, "BASE_KOTLIN_PACKAGE.chil…identifier(\"annotation\"))");
        BASE_ANNOTATION_PACKAGE = r6;
        FqName r7 = r0.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(r7, "BASE_KOTLIN_PACKAGE.chil…e.identifier(\"internal\"))");
        BASE_INTERNAL_PACKAGE = r7;
        FqName r8 = r7.child(Name.identifier("ir"));
        Intrinsics.checkNotNullExpressionValue(r8, "BASE_INTERNAL_PACKAGE.child(Name.identifier(\"ir\"))");
        BASE_INTERNAL_IR_PACKAGE = r8;
        FqName r9 = r0.child(Name.identifier("coroutines"));
        Intrinsics.checkNotNullExpressionValue(r9, "BASE_KOTLIN_PACKAGE.chil…identifier(\"coroutines\"))");
        BASE_COROUTINES_PACKAGE = r9;
        builtInsPackages = SetsKt.setOf(new FqName[]{r0, r2, r3, r6, r1, r7, r9});
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        ClassId r10 = StandardClassIdsKt.access$baseId("Boolean");
        Boolean = r10;
        ClassId r11 = StandardClassIdsKt.access$baseId("Char");
        Char = r11;
        ClassId r12 = StandardClassIdsKt.access$baseId("Byte");
        Byte = r12;
        ClassId r13 = StandardClassIdsKt.access$baseId("Short");
        Short = r13;
        ClassId r14 = StandardClassIdsKt.access$baseId("Int");
        Int = r14;
        ClassId r15 = StandardClassIdsKt.access$baseId("Long");
        Long = r15;
        ClassId r16 = StandardClassIdsKt.access$baseId("Float");
        Float = r16;
        ClassId r17 = StandardClassIdsKt.access$baseId("Double");
        Double = r17;
        UByte = StandardClassIdsKt.access$unsignedId(r12);
        UShort = StandardClassIdsKt.access$unsignedId(r13);
        UInt = StandardClassIdsKt.access$unsignedId(r14);
        ULong = StandardClassIdsKt.access$unsignedId(r15);
        String = StandardClassIdsKt.access$baseId("String");
        Throwable = StandardClassIdsKt.access$baseId("Throwable");
        Cloneable = StandardClassIdsKt.access$baseId("Cloneable");
        KProperty = StandardClassIdsKt.access$reflectId("KProperty");
        KMutableProperty = StandardClassIdsKt.access$reflectId("KMutableProperty");
        KProperty0 = StandardClassIdsKt.access$reflectId("KProperty0");
        KMutableProperty0 = StandardClassIdsKt.access$reflectId("KMutableProperty0");
        KProperty1 = StandardClassIdsKt.access$reflectId("KProperty1");
        KMutableProperty1 = StandardClassIdsKt.access$reflectId("KMutableProperty1");
        KProperty2 = StandardClassIdsKt.access$reflectId("KProperty2");
        KMutableProperty2 = StandardClassIdsKt.access$reflectId("KMutableProperty2");
        KFunction = StandardClassIdsKt.access$reflectId("KFunction");
        KClass = StandardClassIdsKt.access$reflectId("KClass");
        KCallable = StandardClassIdsKt.access$reflectId("KCallable");
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        Set<ClassId> r18 = SetsKt.setOf(new ClassId[]{r10, r11, r12, r13, r14, r15, r16, r17});
        primitiveTypes = r18;
        Set<ClassId> r19 = r18;
        LinkedHashMap r20 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16));
        Iterator<T> r21 = r19.iterator();
    L4:
        if (r21.hasNext() == false) goto L6;
        Object r22 = r21.next();
        Name r110 = ((ClassId) r22).getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r110, "id.shortClassName");
        r20.put(r22, StandardClassIdsKt.access$primitiveArrayId(r110));
        goto L4
    L6:
        LinkedHashMap r23 = r20;
        primitiveArrayTypeByElementType = r23;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(r23);
        Set<ClassId> r24 = SetsKt.setOf(new ClassId[]{UByte, UShort, UInt, ULong});
        unsignedTypes = r24;
        Set<ClassId> r25 = r24;
        LinkedHashMap r26 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r25, 10)), 16));
        Iterator<T> r27 = r25.iterator();
    L8:
        if (r27.hasNext() == false) goto L10;
        Object r28 = r27.next();
        Name r29 = ((ClassId) r28).getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r29, "id.shortClassName");
        r26.put(r28, StandardClassIdsKt.access$primitiveArrayId(r29));
        goto L8
    L10:
        LinkedHashMap r30 = r26;
        unsignedArrayTypeByElementType = r30;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(r30);
        constantAllowedTypes = SetsKt.plus(SetsKt.plus(primitiveTypes, unsignedTypes), String);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        ClassId r31 = StandardClassIdsKt.access$collectionsId("Map");
        Map = r31;
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        ClassId r32 = StandardClassIdsKt.access$collectionsId("MutableMap");
        MutableMap = r32;
        ClassId r33 = r31.createNestedClassId(Name.identifier("Entry"));
        Intrinsics.checkNotNullExpressionValue(r33, "Map.createNestedClassId(Name.identifier(\"Entry\"))");
        MapEntry = r33;
        ClassId r34 = r32.createNestedClassId(Name.identifier("MutableEntry"));
        Intrinsics.checkNotNullExpressionValue(r34, "MutableMap.createNestedC…entifier(\"MutableEntry\"))");
        MutableMapEntry = r34;
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
    }

    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    public final ClassId getArray() {
        return Array;
    }

    public final ClassId getKFunction() {
        return KFunction;
    }

    public final ClassId getKClass() {
        return KClass;
    }

    public final ClassId getMutableList() {
        return MutableList;
    }

    public final ClassId getMutableSet() {
        return MutableSet;
    }

    public final ClassId getMutableMap() {
        return MutableMap;
    }
}
