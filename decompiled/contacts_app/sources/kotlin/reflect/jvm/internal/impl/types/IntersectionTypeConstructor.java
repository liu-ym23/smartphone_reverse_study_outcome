package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    private KotlinType alternative;
    private final int hashCode;
    private final LinkedHashSet<KotlinType> intersectedTypes;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2083getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public IntersectionTypeConstructor(Collection<? extends KotlinType> r2) {
        Intrinsics.checkNotNullParameter(r2, "typesToIntersect");
        r2.isEmpty();
        LinkedHashSet<KotlinType> r0 = new LinkedHashSet(r2);
        this.intersectedTypes = r0;
        this.hashCode = r0.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> r1, KotlinType r2) {
        this(r1);
        this.alternative = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public Collection<KotlinType> mo2084getSupertypes() {
        return this.intersectedTypes;
    }

    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns r1 = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(r1, "intersectedTypes.iterato…xt().constructor.builtIns");
        return r1;
    }

    public String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor r0, C04821 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = C04821.INSTANCE;
    L6:
        return r0.makeDebugNameForIntersectionType(r1);
    }

    public final String makeDebugNameForIntersectionType(final Function1<? super KotlinType, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "getProperTypeRelatedToStringify");
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(this.intersectedTypes, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(r10)), " & ", "{", "}", 0, null, new AnonymousClass3(r10), 24, null);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof IntersectionTypeConstructor) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) r2).intersectedTypes);
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), new AnonymousClass1(this));
    }

    public int hashCode() {
        return this.hashCode;
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType r2) {
        return new IntersectionTypeConstructor(this.intersectedTypes, r2);
    }

    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        Collection<KotlinType> r0 = mo2084getSupertypes();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
        boolean r3 = false;
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((KotlinType) r2.next()).refine(r5));
        r3 = true;
        goto L4
    L6:
        ArrayList r4 = r1;
        IntersectionTypeConstructor r6 = null;
        KotlinType r7 = null;
        if (r3 == false) goto L13;
        KotlinType r8 = getAlternativeType();
        if (r8 == null) goto L12;
        r7 = r8.refine(r5);
    L12:
        r6 = new IntersectionTypeConstructor(r4).setAlternative(r7);
    L13:
        if (r6 != null) goto L16;
        return this;
    L16:
        return r6;
    }
}
