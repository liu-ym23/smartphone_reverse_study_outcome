package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: ErrorTypeConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorTypeConstructor implements TypeConstructor {
    private final String debugText;
    private final String[] formatParams;
    private final ErrorTypeKind kind;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public ErrorTypeConstructor(ErrorTypeKind r5, String... r6) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r6, "formatParams");
        this.kind = r5;
        this.formatParams = r6;
        String r0 = ErrorEntity.ERROR_TYPE.getDebugText();
        String r7 = r5.getDebugMessage();
        Object[] r8 = Arrays.copyOf(r6, r6.length);
        String r9 = String.format(r7, Arrays.copyOf(r8, r8.length));
        Intrinsics.checkNotNullExpressionValue(r9, "format(this, *args)");
        String r10 = String.format(r0, Arrays.copyOf(new Object[]{r9}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(this, *args)");
        this.debugText = r10;
    }

    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    public final String getParam(int r1) {
        return this.formatParams[r1];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public Collection<KotlinType> mo2084getSupertypes() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2083getDeclarationDescriptor() {
        return ErrorUtils.INSTANCE.getErrorClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return DefaultBuiltIns.Companion.getInstance();
    }

    public String toString() {
        return this.debugText;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return this;
    }
}
