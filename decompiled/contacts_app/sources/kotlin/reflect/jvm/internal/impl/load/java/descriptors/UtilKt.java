package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UtilKt {
    public static final List<ValueParameterDescriptor> copyValueParameters(Collection<? extends KotlinType> r16, Collection<? extends ValueParameterDescriptor> r17, CallableDescriptor r18) {
        Intrinsics.checkNotNullParameter(r16, "newValueParameterTypes");
        Intrinsics.checkNotNullParameter(r17, "oldValueParameters");
        Intrinsics.checkNotNullParameter(r18, "newOwner");
        r16.size();
        r17.size();
        List r0 = CollectionsKt.zip(r16, r17);
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r14 = r0.iterator();
    L4:
        if (r14.hasNext() == false) goto L11;
        Pair r1 = (Pair) r14.next();
        KotlinType r6 = (KotlinType) r1.component1();
        ValueParameterDescriptor r2 = (ValueParameterDescriptor) r1.component2();
        int r3 = r2.getIndex();
        Annotations r4 = r2.getAnnotations();
        Name r5 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "oldParameter.name");
        boolean r7 = r2.declaresDefaultValue();
        boolean r8 = r2.isCrossinline();
        boolean r9 = r2.isNoinline();
        if (r2.getVarargElementType() == null) goto L8;
        KotlinType r10 = DescriptorUtilsKt.getModule(r18).getBuiltIns().getArrayElementType(r6);
    L9:
        SourceElement r11 = r2.getSource();
        Intrinsics.checkNotNullExpressionValue(r11, "oldParameter.source");
        r13.add(new ValueParameterDescriptorImpl(r18, null, r3, r4, r5, r6, r7, r8, r9, r10, r11));
        goto L4
    L8:
        r10 = null;
        goto L9
    L11:
        return r13;
    }

    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ClassDescriptor r4 = DescriptorUtilsKt.getSuperClassNotAny(r3);
        LazyJavaStaticClassScope r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        MemberScope r1 = r4.getStaticScope();
        if ((r1 instanceof LazyJavaStaticClassScope) == false) goto L8;
        r0 = (LazyJavaStaticClassScope) r1;
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        return getParentJavaStaticClassScope(r4);
    }
}
