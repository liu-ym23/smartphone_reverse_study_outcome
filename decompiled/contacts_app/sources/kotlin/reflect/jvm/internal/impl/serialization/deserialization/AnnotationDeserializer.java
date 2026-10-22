package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: AnnotationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationDeserializer {
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    /* JADX INFO: compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            r0[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor r2, NotFoundClasses r3) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        this.module = r2;
        this.notFoundClasses = r3;
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation r6, NameResolver r7) {
        Intrinsics.checkNotNullParameter(r6, "proto");
        Intrinsics.checkNotNullParameter(r7, "nameResolver");
        ClassDescriptor r0 = resolveClass(NameResolverUtilKt.getClassId(r7, r6.getId()));
        Map r1 = MapsKt.emptyMap();
        if (r6.getArgumentCount() == 0) goto L22;
        ClassDescriptor r2 = r0;
        if (ErrorUtils.isError(r2) == true) goto L22;
        if (DescriptorUtils.isAnnotationClass(r2) == false) goto L22;
        Collection<ClassConstructorDescriptor> r3 = r0.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r3, "annotationClass.constructors");
        ClassConstructorDescriptor r4 = (ClassConstructorDescriptor) CollectionsKt.singleOrNull(r3);
        if (r4 == null) goto L22;
        List<ValueParameterDescriptor> r5 = r4.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "constructor.valueParameters");
        List<ValueParameterDescriptor> r8 = r5;
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator<T> r10 = r8.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Object r11 = r10.next();
        r9.put(((ValueParameterDescriptor) r11).getName(), r11);
        goto L12
    L14:
        List<ProtoBuf.Annotation.Argument> r12 = r6.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(r12, "proto.argumentList");
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        ProtoBuf.Annotation.Argument r15 = (ProtoBuf.Annotation.Argument) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        Pair<Name, ConstantValue<?>> r16 = resolveArgument(r15, r9, r7);
        if (r16 == null) goto L16;
        r13.add(r16);
        goto L16
    L20:
        r1 = MapsKt.toMap(r13);
    L22:
        return new AnnotationDescriptorImpl(r0.getDefaultType(), r1, SourceElement.NO_SOURCE);
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument r4, Map<Name, ? extends ValueParameterDescriptor> r5, NameResolver r6) {
        ValueParameterDescriptor r7 = r5.get(NameResolverUtilKt.getName(r6, r4.getNameId()));
        if (r7 != null) goto L6;
        return null;
    L6:
        Name r1 = NameResolverUtilKt.getName(r6, r4.getNameId());
        KotlinType r8 = r7.getType();
        Intrinsics.checkNotNullExpressionValue(r8, "parameter.type");
        ProtoBuf.Annotation.Argument.Value r9 = r4.getValue();
        Intrinsics.checkNotNullExpressionValue(r9, "proto.value");
        return new Pair(r1, resolveValueAndCheckExpectedType(r8, r9, r6));
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType r2, ProtoBuf.Annotation.Argument.Value r3, NameResolver r4) {
        ConstantValue<?> r5 = resolveValue(r2, r3, r4);
        if (doesValueConformToExpectedType(r5, r2, r3) == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return ErrorValue.Companion.create("Unexpected argument value: actual type " + r3.getType() + " != expected type " + r2);
    }

    public final ConstantValue<?> resolveValue(KotlinType r5, ProtoBuf.Annotation.Argument.Value r6, NameResolver r7) {
        Intrinsics.checkNotNullParameter(r5, "expectedType");
        Intrinsics.checkNotNullParameter(r6, "value");
        Intrinsics.checkNotNullParameter(r7, "nameResolver");
        Boolean r0 = Flags.IS_UNSIGNED.get(r6.getFlags());
        Intrinsics.checkNotNullExpressionValue(r0, "IS_UNSIGNED.get(value.flags)");
        boolean r1 = r0.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type r2 = r6.getType();
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        switch(r3) {
            case 1: goto L41;
            case 2: goto L59;
            case 3: goto L35;
            case 4: goto L30;
            case 5: goto L25;
            case 6: goto L55;
            case 7: goto L54;
            case 8: goto L19;
            case 9: goto L52;
            case 10: goto L51;
            case 11: goto L50;
            case 12: goto L14;
            case 13: goto L9;
            default: goto L8;
        };
    L9:
        List<ProtoBuf.Annotation.Argument.Value> r8 = r6.getArrayElementList();
        Intrinsics.checkNotNullExpressionValue(r8, "value.arrayElementList");
        List<ProtoBuf.Annotation.Argument.Value> r9 = r8;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L48;
        ProtoBuf.Annotation.Argument.Value r11 = (ProtoBuf.Annotation.Argument.Value) r10.next();
        SimpleType r12 = getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(r12, "builtIns.anyType");
        Intrinsics.checkNotNullExpressionValue(r11, "it");
        r4.add(resolveValue(r12, r11, r7));
        goto L11
    L48:
        return new DeserializedArrayValue(r4, r5);
    L14:
        ProtoBuf.Annotation r13 = r6.getAnnotation();
        Intrinsics.checkNotNullExpressionValue(r13, "value.annotation");
        return new AnnotationValue(deserializeAnnotation(r13, r7));
    L25:
        long r14 = r6.getIntValue();
        if (r1 == false) goto L28;
        ConstantValue<?> r15 = new ULongValue(r14);
    L56:
        return r15;
    L28:
        r15 = new LongValue(r14);
        goto L56
    L30:
        int r16 = (int) r6.getIntValue();
        if (r1 == false) goto L33;
        ConstantValue<?> r17 = new UIntValue(r16);
    L57:
        return r17;
    L33:
        r17 = new IntValue(r16);
        goto L57
    L35:
        short r18 = (short) r6.getIntValue();
        if (r1 == false) goto L38;
        ConstantValue<?> r19 = new UShortValue(r18);
    L58:
        return r19;
    L38:
        r19 = new ShortValue(r18);
        goto L58
    L41:
        byte r20 = (byte) r6.getIntValue();
        if (r1 == false) goto L44;
        ConstantValue<?> r21 = new UByteValue(r20);
    L46:
        return r21;
    L44:
        r21 = new ByteValue(r20);
        goto L46
    L8:
        throw new IllegalStateException(("Unsupported annotation argument type: " + r6.getType() + " (expected " + r5 + ')').toString());
    L50:
        return new EnumValue(NameResolverUtilKt.getClassId(r7, r6.getClassId()), NameResolverUtilKt.getName(r7, r6.getEnumValueId()));
    L51:
        return new KClassValue(NameResolverUtilKt.getClassId(r7, r6.getClassId()), r6.getArrayDimensionCount());
    L52:
        return new StringValue(r7.getString(r6.getStringValue()));
    L19:
        if (r6.getIntValue() == 0) goto L21;
        boolean r22 = true;
    L53:
        return new BooleanValue(r22);
    L21:
        r22 = false;
        goto L53
    L54:
        return new DoubleValue(r6.getDoubleValue());
    L55:
        return new FloatValue(r6.getFloatValue());
    L59:
        return new CharValue((char) r6.getIntValue());
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L6
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> r7, KotlinType r8, ProtoBuf.Annotation.Argument.Value r9) {
        ProtoBuf.Annotation.Argument.Value.Type r0 = r9.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 10) goto L9;
        ClassifierDescriptor r6 = r8.getConstructor().mo2083getDeclarationDescriptor();
        if ((r6 instanceof ClassDescriptor) == false) goto L34;
        ClassDescriptor r10 = (ClassDescriptor) r6;
    L35:
        if (r10 != null) goto L37;
    L39:
        return true;
    L37:
        if (KotlinBuiltIns.isKClass(r10) == true) goto L39;
        return false;
    L34:
        r10 = null;
        goto L35
    L9:
        if (r1 == 13) goto L12;
        return Intrinsics.areEqual(r7.getType(this.module), r8);
    L12:
        if ((r7 instanceof ArrayValue) == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L30;
        KotlinType r11 = getBuiltIns().getArrayElementType(r8);
        Intrinsics.checkNotNullExpressionValue(r11, "builtIns.getArrayElementType(expectedType)");
        ArrayValue r12 = (ArrayValue) r7;
        Iterable r3 = CollectionsKt.getIndices(r12.getValue());
        if ((r3 instanceof Collection) == true) goto L21;
    L23:
        Iterator r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L39;
        int r5 = ((IntIterator) r4).nextInt();
        ConstantValue<?> r13 = r12.getValue().get(r5);
        ProtoBuf.Annotation.Argument.Value r14 = r9.getArrayElement(r5);
        Intrinsics.checkNotNullExpressionValue(r14, "value.getArrayElement(i)");
        if (doesValueConformToExpectedType(r13, r11, r14) == true) goto L25;
        return false;
    L21:
        if (((Collection) r3).isEmpty() == false) goto L23;
    L30:
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + r7).toString());
    L14:
        if (((ArrayValue) r7).getValue().size() != r9.getArrayElementList().size()) goto L16;
        r2 = true;
        goto L17
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L7
    }

    private final ClassDescriptor resolveClass(ClassId r2) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r2, this.notFoundClasses);
    }
}
