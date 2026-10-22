package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IndexedParametersSubstitution extends TypeSubstitution {
    private final boolean approximateContravariantCapturedTypes;
    private final TypeProjection[] arguments;
    private final TypeParameterDescriptor[] parameters;

    public /* synthetic */ IndexedParametersSubstitution(TypeParameterDescriptor[] r1, TypeProjection[] r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public final TypeParameterDescriptor[] getParameters() {
        return this.parameters;
    }

    public final TypeProjection[] getArguments() {
        return this.arguments;
    }

    public IndexedParametersSubstitution(TypeParameterDescriptor[] r2, TypeProjection[] r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "parameters");
        Intrinsics.checkNotNullParameter(r3, "arguments");
        this.parameters = r2;
        this.arguments = r3;
        this.approximateContravariantCapturedTypes = r4;
        int r1 = r2.length;
        int r5 = r3.length;
    }

    public IndexedParametersSubstitution(List<? extends TypeParameterDescriptor> r9, List<? extends TypeProjection> r10) {
        Intrinsics.checkNotNullParameter(r9, "parameters");
        Intrinsics.checkNotNullParameter(r10, "argumentsList");
        Object[] r11 = r9.toArray(new TypeParameterDescriptor[0]);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        TypeParameterDescriptor[] r3 = (TypeParameterDescriptor[]) r11;
        Object[] r12 = r10.toArray(new TypeProjection[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this(r3, (TypeProjection[]) r12, false, 4, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        if (this.arguments.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.approximateContravariantCapturedTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo2088get(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        ClassifierDescriptor r6 = r5.getConstructor().mo2083getDeclarationDescriptor();
        if ((r6 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r7 = (TypeParameterDescriptor) r6;
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        int r0 = r7.getIndex();
        TypeParameterDescriptor[] r2 = this.parameters;
        if (r0 < r2.length) goto L11;
    L14:
        return null;
    L11:
        if (Intrinsics.areEqual(r2[r0].getTypeConstructor(), r7.getTypeConstructor()) == false) goto L14;
        return this.arguments[r0];
    L5:
        r7 = null;
        goto L6
    }
}
