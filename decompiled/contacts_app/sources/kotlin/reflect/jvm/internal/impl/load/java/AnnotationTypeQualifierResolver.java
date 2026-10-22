package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable enumArguments(AnnotationDescriptor r1, boolean r2) {
        return enumArguments2(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ FqName getFqName(AnnotationDescriptor r1) {
        return getFqName2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Object getKey(AnnotationDescriptor r1) {
        return getKey2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable<AnnotationDescriptor> getMetaAnnotations(AnnotationDescriptor r1) {
        return getMetaAnnotations2(r1);
    }

    public AnnotationTypeQualifierResolver(JavaTypeEnhancementState r2) {
        Intrinsics.checkNotNullParameter(r2, "javaTypeEnhancementState");
        super(r2);
    }

    /* JADX INFO: renamed from: getMetaAnnotations, reason: avoid collision after fix types in other method */
    protected Iterable<AnnotationDescriptor> getMetaAnnotations2(AnnotationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassDescriptor r0 = DescriptorUtilsKt.getAnnotationClass(r1);
        if (r0 == null) goto L7;
        Iterable<AnnotationDescriptor> r2 = r0.getAnnotations();
        if (r2 == null) goto L7;
    L9:
        return r2;
    L7:
        r2 = CollectionsKt.emptyList();
        goto L9
    }

    /* JADX INFO: renamed from: getKey, reason: avoid collision after fix types in other method */
    protected Object getKey2(AnnotationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassDescriptor r0 = DescriptorUtilsKt.getAnnotationClass(r1);
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    /* JADX INFO: renamed from: getFqName, reason: avoid collision after fix types in other method */
    protected FqName getFqName2(AnnotationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getFqName();
    }

    /* JADX INFO: renamed from: enumArguments, reason: avoid collision after fix types in other method */
    protected Iterable<String> enumArguments2(AnnotationDescriptor r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<Name, ConstantValue<?>> r7 = r5.getAllValueArguments();
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<Name, ConstantValue<?>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        Map.Entry<Name, ConstantValue<?>> r1 = r8.next();
        Name r2 = r1.getKey();
        ConstantValue<?> r3 = r1.getValue();
        if (r6 == true) goto L8;
    L11:
        List<String> r4 = toEnumNames(r3);
    L12:
        CollectionsKt.addAll(r0, r4);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L11;
        r4 = CollectionsKt.emptyList();
        goto L12
    L14:
        return r0;
    }

    private final List<String> toEnumNames(ConstantValue<?> r3) {
        if ((r3 instanceof ArrayValue) == false) goto L10;
        List<? extends ConstantValue<?>> r4 = ((ArrayValue) r3).getValue();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        CollectionsKt.addAll(r0, toEnumNames((ConstantValue) r5.next()));
        goto L6
    L15:
        return r0;
    L10:
        if ((r3 instanceof EnumValue) == false) goto L13;
        return CollectionsKt.listOf(((EnumValue) r3).getEnumEntryName().getIdentifier());
    L13:
        return CollectionsKt.emptyList();
    }
}
