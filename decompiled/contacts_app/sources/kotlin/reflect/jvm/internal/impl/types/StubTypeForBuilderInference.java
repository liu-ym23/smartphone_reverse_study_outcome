package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* JADX INFO: compiled from: StubTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {
    private final TypeConstructor constructor;
    private final MemberScope memberScope;

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public StubTypeForBuilderInference(NewTypeVariableConstructor r2, boolean r3, TypeConstructor r4) {
        Intrinsics.checkNotNullParameter(r2, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(r4, "constructor");
        super(r2, r3);
        this.constructor = r4;
        this.memberScope = r2.getBuiltIns().getAnyType().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType
    public AbstractStubType materialize(boolean r3) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), r3, getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractStubType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        StringBuilder r0 = new StringBuilder("Stub (BI): ").append(getOriginalTypeVariable());
        if (isMarkedNullable() == false) goto L5;
        String r2 = "?";
    L7:
        return r0.append(r2).toString();
    L5:
        r2 = "";
        goto L7
    }
}
