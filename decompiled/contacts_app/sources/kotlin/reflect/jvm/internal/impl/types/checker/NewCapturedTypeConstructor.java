package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NewCapturedTypeConstructor implements CapturedTypeConstructor {
    private final Lazy _supertypes$delegate;
    private final NewCapturedTypeConstructor original;
    private final TypeProjection projection;
    private Function0<? extends List<? extends UnwrappedType>> supertypesComputation;
    private final TypeParameterDescriptor typeParameter;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2083getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public NewCapturedTypeConstructor(TypeProjection r2, Function0<? extends List<? extends UnwrappedType>> r3, NewCapturedTypeConstructor r4, TypeParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r2, "projection");
        this.projection = r2;
        this.supertypesComputation = r3;
        this.original = r4;
        this.typeParameter = r5;
        this._supertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new NewCapturedTypeConstructor$_supertypes$2(this));
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection r2, Function0 r3, NewCapturedTypeConstructor r4, TypeParameterDescriptor r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ Function0 access$getSupertypesComputation$p(NewCapturedTypeConstructor r0) {
        return r0.supertypesComputation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public /* bridge */ /* synthetic */ Collection mo2084getSupertypes() {
        return mo2084getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public TypeProjection getProjection() {
        return this.projection;
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection r1, List r2, NewCapturedTypeConstructor r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public NewCapturedTypeConstructor(TypeProjection r9, final List<? extends UnwrappedType> r10, NewCapturedTypeConstructor r11) {
        Intrinsics.checkNotNullParameter(r9, "projection");
        Intrinsics.checkNotNullParameter(r10, "supertypes");
        this(r9, new AnonymousClass1(r10), r11, null, 8, null);
    }

    private final List<UnwrappedType> get_supertypes() {
        return (List) this._supertypes$delegate.getValue();
    }

    public final void initializeSupertypes(final List<? extends UnwrappedType> r2) {
        Intrinsics.checkNotNullParameter(r2, "supertypes");
        this.supertypesComputation = new AnonymousClass2(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public List<UnwrappedType> mo2084getSupertypes() {
        List<UnwrappedType> r0 = get_supertypes();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinType r1 = getProjection().getType();
        Intrinsics.checkNotNullExpressionValue(r1, "projection.type");
        return TypeUtilsKt.getBuiltIns(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public NewCapturedTypeConstructor refine(final KotlinTypeRefiner r4) {
        Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
        TypeProjection r0 = getProjection().refine(r4);
        Intrinsics.checkNotNullExpressionValue(r0, "projection.refine(kotlinTypeRefiner)");
        if (this.supertypesComputation == null) goto L5;
        Function0<List<? extends UnwrappedType>> r1 = new NewCapturedTypeConstructor$refine$1$1(this, r4);
    L6:
        NewCapturedTypeConstructor r5 = this.original;
        if (r5 != null) goto L10;
        r5 = this;
    L10:
        return new NewCapturedTypeConstructor(r0, r1, r5, this.typeParameter);
    L5:
        r1 = null;
        goto L6
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedTypeConstructor r5 = (NewCapturedTypeConstructor) r4;
        NewCapturedTypeConstructor r3 = this.original;
        if (r3 == null) goto L16;
        NewCapturedTypeConstructor this = r3;
    L16:
        NewCapturedTypeConstructor r6 = r5.original;
        if (r6 == null) goto L20;
        r5 = r6;
    L20:
        if (this != r5) goto L23;
        return true;
    L23:
        return false;
    L8:
        r2 = null;
        goto L10
    }

    public int hashCode() {
        NewCapturedTypeConstructor r0 = this.original;
        if (r0 == null) goto L6;
        return r0.hashCode();
    L6:
        return super.hashCode();
    }

    public String toString() {
        return "CapturedType(" + getProjection() + ')';
    }
}
