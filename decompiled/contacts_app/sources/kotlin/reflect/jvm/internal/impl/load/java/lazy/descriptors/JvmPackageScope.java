package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final LazyJavaResolverContext c;
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(LazyJavaResolverContext r2, JavaPackage r3, LazyJavaPackageFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "jPackage");
        Intrinsics.checkNotNullParameter(r4, "packageFragment");
        this.c = r2;
        this.packageFragment = r4;
        this.javaScope = new LazyJavaPackageScope(r2, r3, r4);
        this.kotlinScopes$delegate = r2.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(JvmPackageScope r0) {
        return r0.c;
    }

    public static final /* synthetic */ LazyJavaPackageFragment access$getPackageFragment$p(JvmPackageScope r0) {
        return r0.packageFragment;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r6, r7);
        ClassDescriptor r0 = this.javaScope.mo2085getContributedClassifier(r6, r7);
        if (r0 != null) goto L5;
        MemberScope[] r5 = getKotlinScopes();
        int r1 = r5.length;
        ClassifierDescriptor r2 = null;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L25;
        ClassifierDescriptor r4 = r5[r3].mo2085getContributedClassifier(r6, r7);
        if (r4 == null) goto L17;
        if ((r4 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        if (((ClassifierDescriptorWithTypeParameters) r4).isExpect() == false) goto L18;
        if (r2 != null) goto L17;
        r2 = r4;
    L18:
        return r4;
    L17:
        r3 = r3 + 1;
        goto L7
    L25:
        return r2;
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r5, r6);
        LazyJavaPackageScope r0 = this.javaScope;
        MemberScope[] r4 = getKotlinScopes();
        Collection<? extends PropertyDescriptor> r1 = r0.getContributedVariables(r5, r6);
        int r2 = r4.length;
        int r3 = 0;
        Collection r7 = r1;
    L3:
        if (r3 >= r2) goto L5;
        Collection r8 = ScopeUtilsKt.concat(r7, r4[r3].getContributedVariables(r5, r6));
        r3 = r3 + 1;
        r7 = r8;
        goto L3
    L5:
        if (r7 == null) goto L7;
        return r7;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r5, r6);
        LazyJavaPackageScope r0 = this.javaScope;
        MemberScope[] r4 = getKotlinScopes();
        Collection<? extends SimpleFunctionDescriptor> r1 = r0.getContributedFunctions(r5, r6);
        int r2 = r4.length;
        int r3 = 0;
        Collection r7 = r1;
    L3:
        if (r3 >= r2) goto L5;
        Collection r8 = ScopeUtilsKt.concat(r7, r4[r3].getContributedFunctions(r5, r6));
        r3 = r3 + 1;
        r7 = r8;
        goto L3
    L5:
        if (r7 == null) goto L7;
        return r7;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r6, "nameFilter");
        LazyJavaPackageScope r0 = this.javaScope;
        MemberScope[] r4 = getKotlinScopes();
        Collection<DeclarationDescriptor> r1 = r0.getContributedDescriptors(r5, r6);
        int r2 = r4.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = ScopeUtilsKt.concat(r1, r4[r3].getContributedDescriptors(r5, r6));
        r3 = r3 + 1;
        goto L3
    L5:
        if (r1 == null) goto L7;
        return r1;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r0 = getKotlinScopes();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CollectionsKt.addAll(r1, r0[r3].getFunctionNames());
        r3 = r3 + 1;
        goto L3
    L5:
        LinkedHashSet r4 = r1;
        r4.addAll(this.javaScope.getFunctionNames());
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r0 = getKotlinScopes();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CollectionsKt.addAll(r1, r0[r3].getVariableNames());
        r3 = r3 + 1;
        goto L3
    L5:
        LinkedHashSet r4 = r1;
        r4.addAll(this.javaScope.getVariableNames());
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Set<Name> r0 = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(getKotlinScopes()));
        if (r0 == null) goto L5;
        r0.addAll(this.javaScope.getClassifierNames());
        return r0;
    L5:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        UtilsKt.record(this.c.getComponents().getLookupTracker(), r3, this.packageFragment, r2);
    }

    public String toString() {
        return "scope for " + this.packageFragment;
    }
}
