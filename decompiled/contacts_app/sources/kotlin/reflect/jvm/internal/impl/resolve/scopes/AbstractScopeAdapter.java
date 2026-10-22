package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: AbstractScopeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractScopeAdapter implements MemberScope {
    protected abstract MemberScope getWorkerScope();

    public AbstractScopeAdapter() {
    }

    public final MemberScope getActualScope() {
        if ((getWorkerScope() instanceof AbstractScopeAdapter) == false) goto L6;
        MemberScope r1 = getWorkerScope();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((AbstractScopeAdapter) r1).getActualScope();
    L6:
        return getWorkerScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return getWorkerScope().getContributedFunctions(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return getWorkerScope().mo2085getContributedClassifier(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return getWorkerScope().getContributedVariables(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return getWorkerScope().getContributedDescriptors(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getWorkerScope().getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getWorkerScope().getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getWorkerScope().getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        getWorkerScope().mo2089recordLookup(r2, r3);
    }
}
