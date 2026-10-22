package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: compiled from: SubstitutingScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SubstitutingScope implements MemberScope {
    private final Lazy _allDescriptors$delegate;
    private final TypeSubstitutor capturingSubstitutor;
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final Lazy substitutor$delegate;
    private final MemberScope workerScope;

    public SubstitutingScope(MemberScope r3, final TypeSubstitutor r4) {
        Intrinsics.checkNotNullParameter(r3, "workerScope");
        Intrinsics.checkNotNullParameter(r4, "givenSubstitutor");
        this.workerScope = r3;
        this.substitutor$delegate = LazyKt.lazy(new SubstitutingScope$substitutor$2(r4));
        TypeSubstitution r5 = r4.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(r5, "givenSubstitutor.substitution");
        this.capturingSubstitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(r5, false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = LazyKt.lazy(new SubstitutingScope$_allDescriptors$2(this));
    }

    public static final /* synthetic */ MemberScope access$getWorkerScope$p(SubstitutingScope r0) {
        return r0.workerScope;
    }

    public static final /* synthetic */ Collection access$substitute(SubstitutingScope r0, Collection r1) {
        return r0.substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r1, LookupLocation r2) {
        MemberScope.DefaultImpls.recordLookup(this, r1, r2);
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D r3) {
        if (this.capturingSubstitutor.isEmpty() == false) goto L6;
        return r3;
    L6:
        if (this.substitutedDescriptors != null) goto L8;
        this.substitutedDescriptors = new HashMap();
    L8:
        Map<DeclarationDescriptor, DeclarationDescriptor> r0 = this.substitutedDescriptors;
        Intrinsics.checkNotNull(r0);
        DeclarationDescriptorNonRoot r1 = r0.get(r3);
        if (r1 == null) goto L11;
    L19:
        D r2 = (D) r1;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return r2;
    L11:
        if ((r3 instanceof Substitutable) == false) goto L18;
        DeclarationDescriptorNonRoot r4 = ((Substitutable) r3).substitute(this.capturingSubstitutor);
        if (r4 == null) goto L16;
        r1 = r4;
        r0.put(r3, r1);
        goto L19
    L16:
        throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + r3 + " substitution fails");
    L18:
        throw new IllegalStateException(("Unknown descriptor in scope: " + r3).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> r3) {
        if (this.capturingSubstitutor.isEmpty() == false) goto L6;
        return r3;
    L6:
        if (r3.isEmpty() == false) goto L8;
        return r3;
    L8:
        LinkedHashSet r0 = CollectionsKt.newLinkedHashSetWithExpectedSize(r3.size());
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        r0.add(substitute((DeclarationDescriptor) r4.next()));
        goto L10
    L13:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return substitute(this.workerScope.getContributedVariables(r2, r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        ClassifierDescriptor r4 = this.workerScope.mo2085getContributedClassifier(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (ClassifierDescriptor) substitute(r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return substitute(this.workerScope.getContributedFunctions(r2, r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }
}
