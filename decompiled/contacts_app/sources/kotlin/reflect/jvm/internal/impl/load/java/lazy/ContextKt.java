package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextKt {
    public static final LazyJavaResolverContext child(LazyJavaResolverContext r2, TypeParameterResolver r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "typeParameterResolver");
        return new LazyJavaResolverContext(r2.getComponents(), r3, r2.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(LazyJavaResolverContext r1, Annotations r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "additionalAnnotations");
        return r1.getComponents().getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(r1.getDefaultTypeQualifiers(), r2);
    }

    public static final LazyJavaResolverContext replaceComponents(LazyJavaResolverContext r2, JavaResolverComponents r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "components");
        return new LazyJavaResolverContext(r3, r2.getTypeParameterResolver(), r2.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    private static final LazyJavaResolverContext child(LazyJavaResolverContext r2, DeclarationDescriptor r3, JavaTypeParameterListOwner r4, int r5, Lazy<JavaTypeQualifiersByElementType> r6) {
        JavaResolverComponents r0 = r2.getComponents();
        if (r4 == null) goto L5;
        LazyJavaTypeParameterResolver r1 = new LazyJavaTypeParameterResolver(r2, r3, r4, r5);
    L7:
        return new LazyJavaResolverContext(r0, r1, r6);
    L5:
        r1 = r2.getTypeParameterResolver();
        goto L7
    }

    public static /* synthetic */ LazyJavaResolverContext childForMethod$default(LazyJavaResolverContext r0, DeclarationDescriptor r1, JavaTypeParameterListOwner r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        return childForMethod(r0, r1, r2, r3);
    }

    public static final LazyJavaResolverContext childForMethod(LazyJavaResolverContext r1, DeclarationDescriptor r2, JavaTypeParameterListOwner r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r3, "typeParameterOwner");
        return child(r1, r2, r3, r4, r1.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ LazyJavaResolverContext childForClassOrPackage$default(LazyJavaResolverContext r0, ClassOrPackageFragmentDescriptor r1, JavaTypeParameterListOwner r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        return childForClassOrPackage(r0, r1, r2, r3);
    }

    public static final LazyJavaResolverContext childForClassOrPackage(final LazyJavaResolverContext r3, final ClassOrPackageFragmentDescriptor r4, JavaTypeParameterListOwner r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "containingDeclaration");
        return child(r3, r4, r5, r6, LazyKt.lazy(LazyThreadSafetyMode.NONE, new AnonymousClass1(r3, r4)));
    }

    public static final LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(final LazyJavaResolverContext r5, final Annotations r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "additionalAnnotations");
        if (r6.isEmpty() == false) goto L6;
        return r5;
    L6:
        return new LazyJavaResolverContext(r5.getComponents(), r5.getTypeParameterResolver(), LazyKt.lazy(LazyThreadSafetyMode.NONE, new C04671(r5, r6)));
    }
}
