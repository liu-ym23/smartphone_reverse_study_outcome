package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CapturedTypeConstructorKt {
    public static final /* synthetic */ TypeProjection access$createCapturedIfNeeded(TypeProjection r0, TypeParameterDescriptor r1) {
        return createCapturedIfNeeded(r0, r1);
    }

    public static final KotlinType createCapturedType(TypeProjection r8) {
        Intrinsics.checkNotNullParameter(r8, "typeProjection");
        return new CapturedType(r8, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return wrapWithCapturingSubstitution(r0, r1);
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(final TypeSubstitution r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof IndexedParametersSubstitution) == false) goto L10;
        IndexedParametersSubstitution r6 = (IndexedParametersSubstitution) r4;
        TypeParameterDescriptor[] r0 = r6.getParameters();
        List r7 = ArraysKt.zip(r6.getArguments(), r6.getParameters());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        Pair r2 = (Pair) r8.next();
        r1.add(createCapturedIfNeeded((TypeProjection) r2.getFirst(), (TypeParameterDescriptor) r2.getSecond()));
        goto L6
    L8:
        Object[] r9 = r1.toArray(new TypeProjection[0]);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new IndexedParametersSubstitution(r0, (TypeProjection[]) r9, r5);
    L10:
        return new AnonymousClass2(r4, r5);
    }

    private static final TypeProjection createCapturedIfNeeded(final TypeProjection r3, TypeParameterDescriptor r4) {
        if (r4 != null) goto L4;
    L15:
        return r3;
    L4:
        if (r3.getProjectionKind() == Variance.INVARIANT) goto L15;
        if (r4.getVariance() != r3.getProjectionKind()) goto L14;
        if (r3.isStarProjection() == false) goto L12;
        StorageManager r1 = LockBasedStorageManager.NO_LOCKS;
        Intrinsics.checkNotNullExpressionValue(r1, "NO_LOCKS");
        return new TypeProjectionImpl(new LazyWrappedType(r1, new AnonymousClass1(r3)));
    L12:
        return new TypeProjectionImpl(r3.getType());
    L14:
        return new TypeProjectionImpl(createCapturedType(r3));
    }
}
