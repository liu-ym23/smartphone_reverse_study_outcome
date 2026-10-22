package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: mappingUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor r4, ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        r4.getDeclaredTypeParameters().size();
        r5.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion r0 = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> r6 = r4.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r6, "from.declaredTypeParameters");
        List<TypeParameterDescriptor> r7 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r1.add(((TypeParameterDescriptor) r8.next()).getTypeConstructor());
        goto L4
    L6:
        ArrayList r2 = r1;
        List<TypeParameterDescriptor> r9 = r5.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r9, "to.declaredTypeParameters");
        List<TypeParameterDescriptor> r10 = r9;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L11;
        SimpleType r3 = ((TypeParameterDescriptor) r12.next()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r3, "it.defaultType");
        r11.add(TypeUtilsKt.asTypeProjection(r3));
        goto L8
    L11:
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(r0, MapsKt.toMap(CollectionsKt.zip(r2, r11)), false, 2, null);
    }
}
