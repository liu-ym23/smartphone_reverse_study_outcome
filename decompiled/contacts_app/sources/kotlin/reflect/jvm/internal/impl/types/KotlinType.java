package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class KotlinType implements Annotated, KotlinTypeMarker {
    private int cachedHashCode;

    public /* synthetic */ KotlinType(DefaultConstructorMarker r1) {
        this();
    }

    public abstract List<TypeProjection> getArguments();

    public abstract TypeAttributes getAttributes();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope getMemberScope();

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner r1);

    public abstract UnwrappedType unwrap();

    private KotlinType() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return AnnotationsTypeAttributeKt.getAnnotations(getAttributes());
    }

    private final int computeHashCode() {
        if (KotlinTypeKt.isError(this) == false) goto L7;
        return super.hashCode();
    L7:
        return (((getConstructor().hashCode() * 31) + getArguments().hashCode()) * 31) + (isMarkedNullable() ? 1 : 0);
    }

    public final int hashCode() {
        int r0 = this.cachedHashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = computeHashCode();
        this.cachedHashCode = r1;
        return r1;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KotlinType) == true) goto L8;
        return false;
    L8:
        KotlinType r6 = (KotlinType) r5;
        if (isMarkedNullable() != r6.isMarkedNullable()) goto L14;
        if (StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(unwrap(), r6.unwrap()) == false) goto L14;
        return true;
    L14:
        return false;
    }
}
