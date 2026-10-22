package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {
    private final TypeAttributes attributes;
    private final CaptureStatus captureStatus;
    private final NewCapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final boolean isProjectionNotNull;
    private final UnwrappedType lowerType;

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ TypeConstructor getConstructor() {
        return getConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public /* bridge */ /* synthetic */ SimpleType makeNullableAsSpecified(boolean r1) {
        return makeNullableAsSpecified(r1);
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

    public final CaptureStatus getCaptureStatus() {
        return this.captureStatus;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    public final UnwrappedType getLowerType() {
        return this.lowerType;
    }

    public /* synthetic */ NewCapturedType(CaptureStatus r8, NewCapturedTypeConstructor r9, UnwrappedType r10, TypeAttributes r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = TypeAttributes.Companion.getEmpty();
    L5:
        TypeAttributes r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        boolean r5 = false;
    L10:
        if ((r14 & 32) == 0) goto L12;
        boolean r6 = false;
    L13:
        this(r8, r9, r10, r4, r5, r6);
        return;
    L12:
        r6 = r13;
        goto L13
    L8:
        r5 = r12;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public final boolean isProjectionNotNull() {
        return this.isProjectionNotNull;
    }

    public NewCapturedType(CaptureStatus r2, NewCapturedTypeConstructor r3, UnwrappedType r4, TypeAttributes r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "captureStatus");
        Intrinsics.checkNotNullParameter(r3, "constructor");
        Intrinsics.checkNotNullParameter(r5, "attributes");
        this.captureStatus = r2;
        this.constructor = r3;
        this.lowerType = r4;
        this.attributes = r5;
        this.isMarkedNullable = r6;
        this.isProjectionNotNull = r7;
    }

    public NewCapturedType(CaptureStatus r11, UnwrappedType r12, TypeProjection r13, TypeParameterDescriptor r14) {
        Intrinsics.checkNotNullParameter(r11, "captureStatus");
        Intrinsics.checkNotNullParameter(r13, "projection");
        Intrinsics.checkNotNullParameter(r14, "typeParameter");
        this(r11, new NewCapturedTypeConstructor(r13, null, null, r14, 6, null), r12, null, false, false, 56, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAttributes(TypeAttributes r9) {
        Intrinsics.checkNotNullParameter(r9, "newAttributes");
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, r9, isMarkedNullable(), this.isProjectionNotNull);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NewCapturedType makeNullableAsSpecified(boolean r11) {
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAttributes(), r11, false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public NewCapturedType refine(KotlinTypeRefiner r11) {
        Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
        CaptureStatus r2 = this.captureStatus;
        NewCapturedTypeConstructor r3 = getConstructor().refine(r11);
        UnwrappedType r0 = this.lowerType;
        if (r0 == null) goto L5;
        UnwrappedType r12 = r11.refineType(r0).unwrap();
    L7:
        return new NewCapturedType(r2, r3, r12, getAttributes(), isMarkedNullable(), false, 32, null);
    L5:
        r12 = null;
        goto L7
    }
}
