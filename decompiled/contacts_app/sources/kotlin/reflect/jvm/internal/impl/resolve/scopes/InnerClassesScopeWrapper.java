package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: InnerClassesScopeWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    private final MemberScope workerScope;

    public InnerClassesScopeWrapper(MemberScope r2) {
        Intrinsics.checkNotNullParameter(r2, "workerScope");
        this.workerScope = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r1, Function1 r2) {
        return getContributedDescriptors(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        ClassifierDescriptor r1 = this.workerScope.mo2085getContributedClassifier(r2, r3);
        ClassifierDescriptor r4 = null;
        if (r1 == null) goto L15;
        if ((r1 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r5 = (ClassDescriptor) r1;
    L8:
        if (r5 == null) goto L11;
        r4 = r5;
        goto L15
    L11:
        if ((r1 instanceof TypeAliasDescriptor) == false) goto L13;
        r4 = (TypeAliasDescriptor) r1;
    L13:
        r4 = (ClassifierDescriptorWithTypeParameters) r4;
        goto L15
    L7:
        r5 = null;
    L15:
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        DescriptorKindFilter r4 = r2.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (r4 == null) goto L5;
        Collection<DeclarationDescriptor> r1 = this.workerScope.getContributedDescriptors(r4, r3);
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r1.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        if ((r7 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        r5.add(r7);
        goto L8
    L13:
        return r5;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        this.workerScope.mo2089recordLookup(r2, r3);
    }

    public String toString() {
        return "Classes from " + this.workerScope;
    }
}
