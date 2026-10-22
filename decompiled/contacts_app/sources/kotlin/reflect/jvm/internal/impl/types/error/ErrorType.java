package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorType extends SimpleType {
    private final List<TypeProjection> arguments;
    private final TypeConstructor constructor;
    private final String debugMessage;
    private final String[] formatParams;
    private final boolean isMarkedNullable;
    private final ErrorTypeKind kind;
    private final MemberScope memberScope;

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public ErrorType refine(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r1) {
        return makeNullableAsSpecified(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r1) {
        return replaceAttributes(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    public /* synthetic */ ErrorType(TypeConstructor r8, MemberScope r9, ErrorTypeKind r10, List r11, boolean r12, String[] r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        List r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = false;
    L8:
        this(r8, r9, r10, r4, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorType(TypeConstructor r2, MemberScope r3, ErrorTypeKind r4, List<? extends TypeProjection> r5, boolean r6, String... r7) {
        Intrinsics.checkNotNullParameter(r2, "constructor");
        Intrinsics.checkNotNullParameter(r3, "memberScope");
        Intrinsics.checkNotNullParameter(r4, "kind");
        Intrinsics.checkNotNullParameter(r5, "arguments");
        Intrinsics.checkNotNullParameter(r7, "formatParams");
        this.constructor = r2;
        this.memberScope = r3;
        this.kind = r4;
        this.arguments = r5;
        this.isMarkedNullable = r6;
        this.formatParams = r7;
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        String r9 = r4.getDebugMessage();
        Object[] r10 = Arrays.copyOf(r7, r7.length);
        String r11 = String.format(r9, Arrays.copyOf(r10, r10.length));
        Intrinsics.checkNotNullExpressionValue(r11, "format(format, *args)");
        this.debugMessage = r11;
    }

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r2) {
        Intrinsics.checkNotNullParameter(r2, "newAttributes");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean r9) {
        TypeConstructor r1 = getConstructor();
        MemberScope r2 = getMemberScope();
        ErrorTypeKind r3 = this.kind;
        List<TypeProjection> r4 = getArguments();
        String[] r8 = this.formatParams;
        return new ErrorType(r1, r2, r3, r4, r9, (String[]) Arrays.copyOf(r8, r8.length));
    }
}
