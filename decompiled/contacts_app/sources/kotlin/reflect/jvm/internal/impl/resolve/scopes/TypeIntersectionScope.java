package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: TypeIntersectionScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope workerScope;

    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MemberScope create(String r2, Collection<? extends KotlinType> r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, GloableSearchConfig.KEY_CONFIGS);
            Collection<? extends KotlinType> r4 = r3;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r1.add(((KotlinType) r5.next()).getMemberScope());
            goto L4
        L6:
            SmartList<MemberScope> r6 = ScopeUtilsKt.listOfNonEmptyScopes(r1);
            MemberScope r7 = ChainedMemberScope.Companion.createOrSingle$descriptors(r2, r6);
            if (r6.size() > 1) goto L10;
            return r7;
        L10:
            return new TypeIntersectionScope(r2, r7, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeIntersectionScope(String r1, MemberScope r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final MemberScope create(String r1, Collection<? extends KotlinType> r2) {
        return Companion.create(r1, r2);
    }

    private TypeIntersectionScope(String r1, MemberScope r2) {
        this.debugName = r1;
        this.workerScope = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.workerScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(r2, r3), AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(r2, r3), C04791.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r3, Function1<? super Name, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "kindFilter");
        Intrinsics.checkNotNullParameter(r4, "nameFilter");
        Collection<DeclarationDescriptor> r2 = super.getContributedDescriptors(r3, r4);
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r2.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r0 = r7.next();
        if ((((DeclarationDescriptor) r0) instanceof CallableDescriptor) == true) goto L7;
        r6.add(r0);
        goto L4
    L7:
        r5.add(r0);
        goto L4
    L9:
        Pair r8 = new Pair(r5, r6);
        List r9 = (List) r8.component1();
        List r10 = (List) r8.component2();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r9, AnonymousClass2.INSTANCE), r10);
    }
}
