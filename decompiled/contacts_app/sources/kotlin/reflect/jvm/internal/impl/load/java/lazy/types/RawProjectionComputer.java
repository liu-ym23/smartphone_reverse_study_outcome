package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: RawProjectionComputer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RawProjectionComputer extends ErasureProjectionComputer {

    /* JADX INFO: compiled from: RawProjectionComputer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[JavaTypeFlexibility.values().length];
            r0[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public RawProjectionComputer() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer
    public TypeProjection computeProjection(TypeParameterDescriptor r2, ErasureTypeAttributes r3, TypeParameterUpperBoundEraser r4, KotlinType r5) {
        Intrinsics.checkNotNullParameter(r2, "parameter");
        Intrinsics.checkNotNullParameter(r3, "typeAttr");
        Intrinsics.checkNotNullParameter(r4, "typeParameterUpperBoundEraser");
        Intrinsics.checkNotNullParameter(r5, "erasedUpperBound");
        if ((r3 instanceof JavaTypeAttributes) == false) goto L5;
        JavaTypeAttributes r6 = (JavaTypeAttributes) r3;
        if (r6.isRaw() == true) goto L10;
        r6 = r6.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
    L10:
        int r1 = WhenMappings.$EnumSwitchMapping$0[r6.getFlexibility().ordinal()];
        if (r1 == 1) goto L28;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        if (r2.getVariance().getAllowsOutPosition() == true) goto L22;
        TypeProjectionImpl r7 = new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(r2).getNothingType());
    L26:
        Intrinsics.checkNotNullExpressionValue(r7, "{\n                if (!p…          }\n            }");
        return r7;
    L22:
        List<TypeParameterDescriptor> r8 = r5.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r8, "erasedUpperBound.constructor.parameters");
        if ((!r8.isEmpty()) == false) goto L25;
        r7 = new TypeProjectionImpl(Variance.OUT_VARIANCE, r5);
        goto L26
    L25:
        r7 = TypeUtils.makeStarProjection(r2, r6);
        goto L26
    L28:
        return new TypeProjectionImpl(Variance.INVARIANT, r5);
    L5:
        return super.computeProjection(r2, r3, r4, r5);
    }
}
