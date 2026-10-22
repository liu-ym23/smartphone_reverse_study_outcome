package kotlin.reflect.jvm.internal.impl.builtins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: suspendFunctionTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SuspendFunctionTypesKt {
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR = null;

    static {
        MutableClassDescriptor r8 = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(ErrorUtils.INSTANCE.getErrorModule(), StandardNames.COROUTINES_PACKAGE_FQ_NAME), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
        r8.setModality(Modality.ABSTRACT);
        r8.setVisibility(DescriptorVisibilities.PUBLIC);
        r8.setTypeParameterDescriptors(CollectionsKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(r8, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, LockBasedStorageManager.NO_LOCKS)));
        r8.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = r8;
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType r13) {
        Intrinsics.checkNotNullParameter(r13, "suspendFunType");
        FunctionTypesKt.isSuspendFunctionType(r13);
        KotlinBuiltIns r1 = TypeUtilsKt.getBuiltIns(r13);
        Annotations r2 = r13.getAnnotations();
        KotlinType r3 = FunctionTypesKt.getReceiverTypeFromFunctionType(r13);
        List<KotlinType> r4 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r13);
        List<TypeProjection> r0 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r13);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r6 = r0.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(((TypeProjection) r6.next()).getType());
        goto L4
    L6:
        TypeAttributes r7 = TypeAttributes.Companion.getEmpty();
        TypeConstructor r8 = FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r8, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List r9 = CollectionsKt.plus(r5, KotlinTypeFactory.simpleType$default(r7, r8, CollectionsKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(r13))), false, null, 16, null));
        SimpleType r10 = TypeUtilsKt.getBuiltIns(r13).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r10, "suspendFunType.builtIns.nullableAnyType");
        return FunctionTypesKt.createFunctionType$default(r1, r2, r3, r4, r9, null, r10, false, 128, null).makeNullableAsSpecified(r13.isMarkedNullable());
    }
}
