package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    private final LazyJavaResolverContext c;
    private final DeclarationDescriptor containingDeclaration;
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    private final Map<JavaTypeParameter, Integer> typeParameters;
    private final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext r2, DeclarationDescriptor r3, JavaTypeParameterListOwner r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r4, "typeParameterOwner");
        this.c = r2;
        this.containingDeclaration = r3;
        this.typeParametersIndexOffset = r5;
        this.typeParameters = CollectionsKt.mapToIndex(r4.getTypeParameters());
        this.resolve = r2.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaTypeParameterResolver r0) {
        return r0.c;
    }

    public static final /* synthetic */ DeclarationDescriptor access$getContainingDeclaration$p(LazyJavaTypeParameterResolver r0) {
        return r0.containingDeclaration;
    }

    public static final /* synthetic */ Map access$getTypeParameters$p(LazyJavaTypeParameterResolver r0) {
        return r0.typeParameters;
    }

    public static final /* synthetic */ int access$getTypeParametersIndexOffset$p(LazyJavaTypeParameterResolver r0) {
        return r0.typeParametersIndexOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r2) {
        Intrinsics.checkNotNullParameter(r2, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor r0 = this.resolve.invoke(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.c.getTypeParameterResolver().resolveTypeParameter(r2);
    }
}
