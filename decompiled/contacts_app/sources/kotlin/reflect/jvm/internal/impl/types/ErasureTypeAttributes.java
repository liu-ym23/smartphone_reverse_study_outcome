package kotlin.reflect.jvm.internal.impl.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: compiled from: ErasureTypeAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final TypeUsage howThisTypeIsUsed;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(TypeUsage r2, Set<? extends TypeParameterDescriptor> r3, SimpleType r4) {
        Intrinsics.checkNotNullParameter(r2, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = r2;
        this.visitedTypeParameters = r3;
        this.defaultType = r4;
    }

    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    public ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "typeParameter");
        TypeUsage r0 = getHowThisTypeIsUsed();
        Set<TypeParameterDescriptor> r1 = getVisitedTypeParameters();
        if (r1 == null) goto L6;
        Set r2 = SetsKt.plus(r1, r3);
        if (r2 == null) goto L6;
    L8:
        return new ErasureTypeAttributes(r0, r2, getDefaultType());
    L6:
        r2 = SetsKt.setOf(r3);
        goto L8
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ErasureTypeAttributes) == true) goto L5;
        return false;
    L5:
        ErasureTypeAttributes r5 = (ErasureTypeAttributes) r4;
        if (Intrinsics.areEqual(r5.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r5.getHowThisTypeIsUsed() != getHowThisTypeIsUsed()) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        SimpleType r0 = getDefaultType();
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return r1 + ((r1 * 31) + getHowThisTypeIsUsed().hashCode());
    L5:
        r1 = 0;
        goto L7
    }
}
