package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: compiled from: ErasureProjectionComputer.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ErasureProjectionComputer {
    public ErasureProjectionComputer() {
    }

    public static /* synthetic */ TypeProjection computeProjection$default(ErasureProjectionComputer r0, TypeParameterDescriptor r1, ErasureTypeAttributes r2, TypeParameterUpperBoundEraser r3, KotlinType r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L7;
        r4 = r3.getErasedUpperBound(r1, r2);
    L7:
        return r0.computeProjection(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
    }

    public TypeProjection computeProjection(TypeParameterDescriptor r1, ErasureTypeAttributes r2, TypeParameterUpperBoundEraser r3, KotlinType r4) {
        Intrinsics.checkNotNullParameter(r1, "parameter");
        Intrinsics.checkNotNullParameter(r2, "typeAttr");
        Intrinsics.checkNotNullParameter(r3, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r4, "erasedUpperBound");
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r4);
    }
}
