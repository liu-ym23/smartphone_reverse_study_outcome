package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: compiled from: JavaTypeAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaTypeAttributes extends ErasureTypeAttributes {
    private final SimpleType defaultType;
    private final JavaTypeFlexibility flexibility;
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final boolean isRaw;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes r4, TypeUsage r5, JavaTypeFlexibility r6, boolean r7, boolean r8, Set r9, SimpleType r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.getHowThisTypeIsUsed();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.flexibility;
    L8:
        JavaTypeFlexibility r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.isRaw;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isForAnnotationParameter;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.getVisitedTypeParameters();
    L17:
        Set r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.getDefaultType();
    L20:
        TypeUsage r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final JavaTypeAttributes copy(TypeUsage r8, JavaTypeFlexibility r9, boolean r10, boolean r11, Set<? extends TypeParameterDescriptor> r12, SimpleType r13) {
        Intrinsics.checkNotNullParameter(r8, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r9, "flexibility");
        return new JavaTypeAttributes(r8, r9, r10, r11, r12, r13);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + getHowThisTypeIsUsed() + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + getVisitedTypeParameters() + ", defaultType=" + getDefaultType() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public /* bridge */ /* synthetic */ ErasureTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r1) {
        return withNewVisitedTypeParameter(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public /* synthetic */ JavaTypeAttributes(TypeUsage r8, JavaTypeFlexibility r9, boolean r10, boolean r11, Set r12, SimpleType r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = JavaTypeFlexibility.INFLEXIBLE;
    L5:
        JavaTypeFlexibility r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r14 & 8) == 0) goto L12;
        boolean r4 = false;
    L14:
        if ((r14 & 16) == 0) goto L16;
        Set r5 = null;
    L18:
        if ((r14 & 32) == 0) goto L20;
        SimpleType r6 = null;
    L21:
        this(r8, r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r13;
        goto L21
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public SimpleType getDefaultType() {
        return this.defaultType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeAttributes(TypeUsage r2, JavaTypeFlexibility r3, boolean r4, boolean r5, Set<? extends TypeParameterDescriptor> r6, SimpleType r7) {
        Intrinsics.checkNotNullParameter(r2, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(r3, "flexibility");
        super(r2, r6, r7);
        this.howThisTypeIsUsed = r2;
        this.flexibility = r3;
        this.isRaw = r4;
        this.isForAnnotationParameter = r5;
        this.visitedTypeParameters = r6;
        this.defaultType = r7;
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility r11) {
        Intrinsics.checkNotNullParameter(r11, "flexibility");
        return copy$default(this, null, r11, false, false, null, null, 61, null);
    }

    public final JavaTypeAttributes markIsRaw(boolean r10) {
        return copy$default(this, null, null, r10, false, null, null, 59, null);
    }

    public JavaTypeAttributes withDefaultType(SimpleType r10) {
        return copy$default(this, null, null, false, false, null, r10, 31, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor r11) {
        Intrinsics.checkNotNullParameter(r11, "typeParameter");
        if (getVisitedTypeParameters() == null) goto L5;
        Set r12 = SetsKt.plus(getVisitedTypeParameters(), r11);
    L7:
        return copy$default(this, null, null, false, false, r12, null, 47, null);
    L5:
        r12 = SetsKt.setOf(r11);
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public boolean equals(Object r4) {
        if ((r4 instanceof JavaTypeAttributes) == true) goto L5;
        return false;
    L5:
        JavaTypeAttributes r5 = (JavaTypeAttributes) r4;
        if (Intrinsics.areEqual(r5.getDefaultType(), getDefaultType()) == true) goto L8;
        return false;
    L8:
        if (r5.getHowThisTypeIsUsed() == getHowThisTypeIsUsed()) goto L10;
        return false;
    L10:
        if (r5.flexibility == this.flexibility) goto L12;
        return false;
    L12:
        if (r5.isRaw == this.isRaw) goto L14;
        return false;
    L14:
        if (r5.isForAnnotationParameter != this.isForAnnotationParameter) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public int hashCode() {
        SimpleType r0 = getDefaultType();
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 + ((r1 * 31) + getHowThisTypeIsUsed().hashCode());
        int r3 = r2 + ((r2 * 31) + this.flexibility.hashCode());
        int r4 = r3 + ((r3 * 31) + (this.isRaw ? 1 : 0));
        return r4 + ((r4 * 31) + (this.isForAnnotationParameter ? 1 : 0));
    L5:
        r1 = 0;
        goto L6
    }
}
