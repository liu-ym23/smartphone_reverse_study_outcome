package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final LazyJavaPackageFragment ownerDescriptor;

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    private static final class FindClassRequest {
        private final JavaClass javaClass;
        private final Name name;

        public FindClassRequest(Name r2, JavaClass r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.name = r2;
            this.javaClass = r3;
        }

        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final Name getName() {
            return this.name;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof FindClassRequest) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.name, ((FindClassRequest) r2).name) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
    private static abstract class KotlinClassLookupResult {

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class Found extends KotlinClassLookupResult {
            private final ClassDescriptor descriptor;

            public Found(ClassDescriptor r2) {
                Intrinsics.checkNotNullParameter(r2, "descriptor");
                super(null);
                this.descriptor = r2;
            }

            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound INSTANCE = null;

            static {
                INSTANCE = new NotFound();
            }

            private NotFound() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: LazyJavaPackageScope.kt */
        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE = null;

            static {
                INSTANCE = new SyntheticClass();
            }

            private SyntheticClass() {
                super(null);
            }
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker r1) {
            this();
        }

        private KotlinClassLookupResult() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r1, Name r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r2, "name");
    }

    public static final /* synthetic */ KotlinClassLookupResult access$resolveKotlinBinaryClass(LazyJavaPackageScope r0, KotlinJvmBinaryClass r1) {
        return r0.resolveKotlinBinaryClass(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo2085getContributedClassifier(Name r1, LookupLocation r2) {
        return mo2085getContributedClassifier(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public LazyJavaPackageScope(final LazyJavaResolverContext r2, JavaPackage r3, LazyJavaPackageFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "jPackage");
        Intrinsics.checkNotNullParameter(r4, "ownerDescriptor");
        super(r2);
        this.jPackage = r3;
        this.ownerDescriptor = r4;
        this.knownClassNamesInPackage = r2.getStorageManager().createNullableLazyValue(new LazyJavaPackageScope$knownClassNamesInPackage$1(r2, this));
        this.classes = r2.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$classes$1(this, r2));
    }

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass r3) {
        if (r3 != null) goto L5;
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L5:
        if (r3.getClassHeader().getKind() != KotlinClassHeader.Kind.CLASS) goto L11;
        ClassDescriptor r2 = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(r3);
        if (r2 == null) goto L14;
        return new KotlinClassLookupResult.Found(r2);
    L14:
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L11:
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return findClassifier(r2, null);
    }

    private final ClassDescriptor findClassifier(Name r4, JavaClass r5) {
        if (SpecialNames.INSTANCE.isSafeIdentifier(r4) == true) goto L5;
        return null;
    L5:
        Set<String> r0 = this.knownClassNamesInPackage.invoke();
        if (r5 != null) goto L12;
        if (r0 == null) goto L12;
        if (r0.contains(r4.asString()) == true) goto L12;
        return null;
    L12:
        return this.classes.invoke(new FindClassRequest(r4, r5));
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass r2) {
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        return findClassifier(r2.getName(), r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r1, LookupLocation r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, BatteryTypeInf.BATTERY_LOC_API);
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter r3, Function1<? super Name, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "kindFilter");
        if (r3.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        Set<String> r5 = this.knownClassNamesInPackage.invoke();
        if (r5 == null) goto L14;
        HashSet r2 = new HashSet();
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        r2.add(Name.identifier((String) r6.next()));
        goto L10
    L13:
        return r2;
    L14:
        JavaPackage r7 = this.jPackage;
        if (r4 != null) goto L17;
        r4 = FunctionsKt.alwaysTrue();
    L17:
        Collection<JavaClass> r8 = r7.getClasses(r4);
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator<T> r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L27;
        JavaClass r11 = (JavaClass) r10.next();
        if (r11.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L23;
        Name r12 = null;
    L24:
        if (r12 == null) goto L19;
        r9.add(r12);
        goto L19
    L23:
        r12 = r11.getName();
        goto L24
    L27:
        return r9;
    L5:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeFunctionNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r4, Function1<? super Name, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "kindFilter");
        Intrinsics.checkNotNullParameter(r5, "nameFilter");
        if (r4.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK() | DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK()) == false) goto L23;
        Collection<DeclarationDescriptor> r3 = getAllDescriptors().invoke();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r3.iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        Object r0 = r7.next();
        DeclarationDescriptor r1 = (DeclarationDescriptor) r0;
        if ((r1 instanceof ClassDescriptor) == false) goto L13;
        Name r2 = ((ClassDescriptor) r1).getName();
        Intrinsics.checkNotNullExpressionValue(r2, "it.name");
        if (r5.invoke(r2).booleanValue() == false) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L7;
        r6.add(r0);
    L13:
        r8 = false;
        goto L14
    L17:
        return r6;
    L23:
        return CollectionsKt.emptyList();
    }
}
