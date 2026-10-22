package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: compiled from: JavaDescriptorResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaDescriptorResolver {
    private final JavaResolverCache javaResolverCache;
    private final LazyJavaPackageFragmentProvider packageFragmentProvider;

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider r2, JavaResolverCache r3) {
        Intrinsics.checkNotNullParameter(r2, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r3, "javaResolverCache");
        this.packageFragmentProvider = r2;
        this.javaResolverCache = r3;
    }

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final ClassDescriptor resolveClass(JavaClass r4) {
        Intrinsics.checkNotNullParameter(r4, "javaClass");
        FqName r0 = r4.getFqName();
        if (r0 != null) goto L5;
    L8:
        JavaClass r1 = r4.getOuterClass();
        if (r1 == null) goto L21;
        ClassDescriptor r3 = resolveClass(r1);
        if (r3 == null) goto L13;
        MemberScope r5 = r3.getUnsubstitutedInnerClassesScope();
    L14:
        if (r5 == null) goto L16;
        ClassifierDescriptor r6 = r5.mo2085getContributedClassifier(r4.getName(), NoLookupLocation.FROM_JAVA_LOADER);
    L18:
        if ((r6 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r6;
    L16:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L21:
        if (r0 != null) goto L23;
        return null;
    L23:
        LazyJavaPackageFragmentProvider r7 = this.packageFragmentProvider;
        FqName r2 = r0.parent();
        Intrinsics.checkNotNullExpressionValue(r2, "fqName.parent()");
        LazyJavaPackageFragment r8 = (LazyJavaPackageFragment) CollectionsKt.firstOrNull(r7.getPackageFragments(r2));
        if (r8 != null) goto L26;
        return null;
    L26:
        return r8.findClassifierByJavaClass$descriptors_jvm(r4);
    L5:
        if (r4.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L8;
        return this.javaResolverCache.getClassResolvedFromSource(r0);
    }
}
