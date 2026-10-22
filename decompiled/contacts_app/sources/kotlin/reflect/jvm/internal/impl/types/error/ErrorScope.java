package kotlin.reflect.jvm.internal.impl.types.error;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: compiled from: ErrorScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ErrorScope implements MemberScope {
    private final String debugMessage;
    private final ErrorScopeKind kind;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r1, LookupLocation r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, BatteryTypeInf.BATTERY_LOC_API);
    }

    public ErrorScope(ErrorScopeKind r2, String... r3) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        Intrinsics.checkNotNullParameter(r3, "formatParams");
        this.kind = r2;
        String r4 = r2.getDebugMessage();
        Object[] r5 = Arrays.copyOf(r3, r3.length);
        String r6 = String.format(r4, Arrays.copyOf(r5, r5.length));
        Intrinsics.checkNotNullExpressionValue(r6, "format(this, *args)");
        this.debugMessage = r6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedFunctions(Name r1, LookupLocation r2) {
        return getContributedFunctions(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public /* bridge */ /* synthetic */ Collection getContributedVariables(Name r1, LookupLocation r2) {
        return getContributedVariables(r1, r2);
    }

    protected final String getDebugMessage() {
        return this.debugMessage;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r4, LookupLocation r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, BatteryTypeInf.BATTERY_LOC_API);
        String r6 = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{r4}, 1));
        Intrinsics.checkNotNullExpressionValue(r6, "format(this, *args)");
        Name r7 = Name.special(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "special(ErrorEntity.ERRO…S.debugText.format(name))");
        return new ErrorClassDescriptor(r7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<PropertyDescriptor> getContributedVariables(Name r1, LookupLocation r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, BatteryTypeInf.BATTERY_LOC_API);
        return ErrorUtils.INSTANCE.getErrorPropertyGroup();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Set<SimpleFunctionDescriptor> getContributedFunctions(Name r1, LookupLocation r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, BatteryTypeInf.BATTERY_LOC_API);
        return SetsKt.setOf(new ErrorFunctionDescriptor(ErrorUtils.INSTANCE.getErrorClass()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        Intrinsics.checkNotNullParameter(r2, "nameFilter");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    public String toString() {
        return "ErrorScope{" + this.debugMessage + '}';
    }
}
