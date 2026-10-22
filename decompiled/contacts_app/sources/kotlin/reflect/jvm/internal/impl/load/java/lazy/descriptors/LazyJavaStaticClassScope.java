package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    private final JavaClass jClass;
    private final LazyJavaClassDescriptor ownerDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r1, LookupLocation r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, BatteryTypeInf.BATTERY_LOC_API);
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclaredMemberIndex computeMemberIndex() {
        return computeMemberIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public LazyJavaStaticClassScope(LazyJavaResolverContext r2, JavaClass r3, LazyJavaClassDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "jClass");
        Intrinsics.checkNotNullParameter(r4, "ownerDescriptor");
        super(r2);
        this.jClass = r3;
        this.ownerDescriptor = r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeFunctionNames(DescriptorKindFilter r3, Function1<? super Name, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "kindFilter");
        Set<Name> r5 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getMethodNames());
        LazyJavaStaticClassScope r6 = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        if (r6 == null) goto L5;
        Set<Name> r7 = r6.getFunctionNames();
    L6:
        if (r7 != null) goto L8;
        r7 = SetsKt.emptySet();
    L8:
        r5.addAll(r7);
        if (this.jClass.isEnum() == false) goto L11;
        r5.addAll(CollectionsKt.listOf(new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES}));
    L11:
        r5.addAll(getC().getComponents().getSyntheticPartsProvider().getStaticFunctionNames(getOwnerDescriptor()));
        return r5;
    L5:
        r7 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Set<Name> r4 = CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), r4, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r8, Name r9) {
        Intrinsics.checkNotNullParameter(r8, "result");
        Intrinsics.checkNotNullParameter(r9, "name");
        Collection<? extends SimpleFunctionDescriptor> r0 = DescriptorResolverUtils.resolveOverridesForStaticMembers(r9, getStaticFunctionsFromJavaSuperClasses(r9, getOwnerDescriptor()), r8, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r0, "resolveOverridesForStati….overridingUtil\n        )");
        r8.addAll(r0);
        if (this.jClass.isEnum() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r9, StandardNames.ENUM_VALUE_OF) == false) goto L8;
        SimpleFunctionDescriptor r7 = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
        Intrinsics.checkNotNullExpressionValue(r7, "createEnumValueOfMethod(ownerDescriptor)");
        r8.add(r7);
        return;
    L8:
        if (Intrinsics.areEqual(r9, StandardNames.ENUM_VALUES) == false) goto L13;
        SimpleFunctionDescriptor r10 = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
        Intrinsics.checkNotNullExpressionValue(r10, "createEnumValuesMethod(ownerDescriptor)");
        r8.add(r10);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "name");
        getC().getComponents().getSyntheticPartsProvider().generateStaticFunctions(getOwnerDescriptor(), r3, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(final Name r11, Collection<PropertyDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "result");
        Set r0 = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(r11));
        if ((!r12.isEmpty()) == false) goto L5;
        Collection<? extends PropertyDescriptor> r10 = DescriptorResolverUtils.resolveOverridesForStaticMembers(r11, r0, r12, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r10, "resolveOverridesForStati…ingUtil\n                )");
        r12.addAll(r10);
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        PropertyDescriptor r4 = getRealOriginal((PropertyDescriptor) r3);
        Object r5 = r1.get(r4);
        if (r5 != null) goto L11;
        r5 = (List) new ArrayList();
        r1.put(r4, r5);
    L11:
        ((List) r5).add(r3);
        goto L7
    L12:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.entrySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        Collection r8 = DescriptorResolverUtils.resolveOverridesForStaticMembers(r11, (Collection) ((Map.Entry) r7.next()).getValue(), r12, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r8, "resolveOverridesForStati…ingUtil\n                )");
        CollectionsKt.addAll(r6, r8);
        goto L14
    L16:
        r12.addAll(r6);
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name r1, ClassDescriptor r2) {
        LazyJavaStaticClassScope r0 = UtilKt.getParentJavaStaticClassScope(r2);
        if (r0 != null) goto L7;
        return SetsKt.emptySet();
    L7:
        return CollectionsKt.toSet(r0.getContributedFunctions(r1, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(final ClassDescriptor r3, final Set<R> r4, final Function1<? super MemberScope, ? extends Collection<? extends R>> r5) {
        DFS.dfs(CollectionsKt.listOf(r3), C04691.INSTANCE, new AnonymousClass2(r3, r4, r5));
        return r4;
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor r4) {
        if (r4.getKind().isReal() == false) goto L5;
        return r4;
    L5:
        Collection<? extends PropertyDescriptor> r5 = r4.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r5, "this.overriddenDescriptors");
        Collection<? extends PropertyDescriptor> r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L10;
        PropertyDescriptor r1 = (PropertyDescriptor) r7.next();
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        r0.add(getRealOriginal(r1));
        goto L7
    L10:
        return (PropertyDescriptor) CollectionsKt.single(CollectionsKt.distinct(r0));
    }
}
