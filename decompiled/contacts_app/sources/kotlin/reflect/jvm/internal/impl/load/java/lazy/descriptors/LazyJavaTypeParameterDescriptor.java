package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: LazyJavaTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaResolverContext c;
    private final JavaTypeParameter javaTypeParameter;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError */
    protected void mo2086reportSupertypeLoopError(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext r12, JavaTypeParameter r13, int r14, DeclarationDescriptor r15) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "javaTypeParameter");
        Intrinsics.checkNotNullParameter(r15, "containingDeclaration");
        super(r12.getStorageManager(), r15, new LazyJavaAnnotations(r12, r13, false, 4, null), r13.getName(), Variance.INVARIANT, false, r14, SourceElement.NO_SOURCE, r12.getComponents().getSupertypeLoopChecker());
        this.c = r12;
        this.javaTypeParameter = r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> r0 = this.javaTypeParameter.getUpperBounds();
        if (r0.isEmpty() == false) goto L6;
        SimpleType r1 = this.c.getModule().getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(r1, "c.module.builtIns.anyType");
        SimpleType r10 = this.c.getModule().getBuiltIns().getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r10, "c.module.builtIns.nullableAnyType");
        return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(r1, r10));
    L6:
        Collection<JavaClassifierType> r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        JavaClassifierType r5 = (JavaClassifierType) r4.next();
        r3.add(this.c.getTypeResolver().transformJavaType(r5, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, this, 3, null)));
        goto L8
    L11:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> r3) {
        Intrinsics.checkNotNullParameter(r3, "bounds");
        return this.c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, r3, this.c);
    }
}
