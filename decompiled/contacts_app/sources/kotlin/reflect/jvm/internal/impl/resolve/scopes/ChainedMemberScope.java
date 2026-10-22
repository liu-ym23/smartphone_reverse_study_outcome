package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope[] scopes;

    /* JADX INFO: compiled from: ChainedMemberScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final MemberScope create(String r4, Iterable<? extends MemberScope> r5) {
            Intrinsics.checkNotNullParameter(r4, "debugName");
            Intrinsics.checkNotNullParameter(r5, "scopes");
            SmartList r0 = new SmartList();
            Iterator<? extends MemberScope> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L12;
            MemberScope r1 = r6.next();
            if (r1 == MemberScope.Empty.INSTANCE) goto L4;
            if ((r1 instanceof ChainedMemberScope) == true) goto L9;
            r0.add(r1);
            goto L4
        L9:
            CollectionsKt.addAll(r0, ChainedMemberScope.access$getScopes$p((ChainedMemberScope) r1));
            goto L4
        L12:
            return createOrSingle$descriptors(r4, r0);
        }

        public final MemberScope createOrSingle$descriptors(String r3, List<? extends MemberScope> r4) {
            Intrinsics.checkNotNullParameter(r3, "debugName");
            Intrinsics.checkNotNullParameter(r4, "scopes");
            int r2 = r4.size();
            if (r2 == 0) goto L9;
            if (r2 == 1) goto L11;
            Object[] r5 = r4.toArray(new MemberScope[0]);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new ChainedMemberScope(r3, (MemberScope[]) r5, null);
        L11:
            return r4.get(0);
        L9:
            return MemberScope.Empty.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ChainedMemberScope(String r1, MemberScope[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private ChainedMemberScope(String r1, MemberScope[] r2) {
        this.debugName = r1;
        this.scopes = r2;
    }

    public static final /* synthetic */ MemberScope[] access$getScopes$p(ChainedMemberScope r0) {
        return r0.scopes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, BatteryTypeInf.BATTERY_LOC_API);
        MemberScope[] r5 = this.scopes;
        int r0 = r5.length;
        ClassifierDescriptor r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        ClassifierDescriptor r3 = r5[r2].mo2085getContributedClassifier(r6, r7);
        if (r3 == null) goto L13;
        if ((r3 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        if (((ClassifierDescriptorWithTypeParameters) r3).isExpect() == false) goto L14;
        if (r1 != null) goto L13;
        r1 = r3;
    L14:
        return r3;
    L13:
        r2 = r2 + 1;
        goto L3
    L21:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, BatteryTypeInf.BATTERY_LOC_API);
        MemberScope[] r4 = this.scopes;
        int r0 = r4.length;
        if (r0 == 0) goto L13;
        int r1 = 0;
        if (r0 == 1) goto L17;
        int r2 = r4.length;
        Collection<PropertyDescriptor> r3 = null;
    L7:
        if (r1 >= r2) goto L9;
        r3 = ScopeUtilsKt.concat(r3, r4[r1].getContributedVariables(r5, r6));
        r1 = r1 + 1;
        goto L7
    L9:
        if (r3 == null) goto L16;
        return r3;
    L16:
        return SetsKt.emptySet();
    L17:
        return r4[0].getContributedVariables(r5, r6);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, BatteryTypeInf.BATTERY_LOC_API);
        MemberScope[] r4 = this.scopes;
        int r0 = r4.length;
        if (r0 == 0) goto L13;
        int r1 = 0;
        if (r0 == 1) goto L17;
        int r2 = r4.length;
        Collection<SimpleFunctionDescriptor> r3 = null;
    L7:
        if (r1 >= r2) goto L9;
        r3 = ScopeUtilsKt.concat(r3, r4[r1].getContributedFunctions(r5, r6));
        r1 = r1 + 1;
        goto L7
    L9:
        if (r3 == null) goto L16;
        return r3;
    L16:
        return SetsKt.emptySet();
    L17:
        return r4[0].getContributedFunctions(r5, r6);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r6, "nameFilter");
        MemberScope[] r4 = this.scopes;
        int r0 = r4.length;
        if (r0 == 0) goto L13;
        int r1 = 0;
        if (r0 == 1) goto L17;
        int r2 = r4.length;
        Collection<DeclarationDescriptor> r3 = null;
    L7:
        if (r1 >= r2) goto L9;
        r3 = ScopeUtilsKt.concat(r3, r4[r1].getContributedDescriptors(r5, r6));
        r1 = r1 + 1;
        goto L7
    L9:
        if (r3 == null) goto L16;
        return r3;
    L16:
        return SetsKt.emptySet();
    L17:
        return r4[0].getContributedDescriptors(r5, r6);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r4 = this.scopes;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        CollectionsKt.addAll(r0, r4[r2].getFunctionNames());
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r4 = this.scopes;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        CollectionsKt.addAll(r0, r4[r2].getVariableNames());
        r2 = r2 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r4, LookupLocation r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, BatteryTypeInf.BATTERY_LOC_API);
        MemberScope[] r3 = this.scopes;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].mo2089recordLookup(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    public String toString() {
        return this.debugName;
    }
}
