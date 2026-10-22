package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* JADX INFO: compiled from: DeserializedPackageMemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    private final String debugName;
    private final PackageFragmentDescriptor packageDescriptor;
    private final FqName packageFqName;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r2, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r1, Function1 r2) {
        return getContributedDescriptors(r1, r2);
    }

    public DeserializedPackageMemberScope(PackageFragmentDescriptor r17, ProtoBuf.Package r18, NameResolver r19, BinaryVersion r20, DeserializedContainerSource r21, DeserializationComponents r22, String r23, Function0<? extends Collection<Name>> r24) {
        Intrinsics.checkNotNullParameter(r17, "packageDescriptor");
        Intrinsics.checkNotNullParameter(r18, "proto");
        Intrinsics.checkNotNullParameter(r19, "nameResolver");
        Intrinsics.checkNotNullParameter(r20, "metadataVersion");
        Intrinsics.checkNotNullParameter(r22, "components");
        Intrinsics.checkNotNullParameter(r23, "debugName");
        Intrinsics.checkNotNullParameter(r24, "classNames");
        ProtoBuf.TypeTable r0 = r18.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r0, "proto.typeTable");
        TypeTable r10 = new TypeTable(r0);
        VersionRequirementTable.Companion r1 = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable r7 = r18.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(r7, "proto.versionRequirementTable");
        DeserializationContext r2 = r22.createContext(r17, r19, r10, r1.create(r7), r20, r21);
        List<ProtoBuf.Function> r3 = r18.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(r3, "proto.functionList");
        List<ProtoBuf.Property> r4 = r18.getPropertyList();
        Intrinsics.checkNotNullExpressionValue(r4, "proto.propertyList");
        List<ProtoBuf.TypeAlias> r8 = r18.getTypeAliasList();
        Intrinsics.checkNotNullExpressionValue(r8, "proto.typeAliasList");
        super(r2, r3, r4, r8, r24);
        this.packageDescriptor = r17;
        this.debugName = r23;
        this.packageFqName = r17.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r4, Function1<? super Name, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "kindFilter");
        Intrinsics.checkNotNullParameter(r5, "nameFilter");
        Collection<DeclarationDescriptor> r6 = computeDescriptors(r4, r5, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> r7 = getC().getComponents().getFictitiousClassDescriptorFactories();
        ArrayList r0 = new ArrayList();
        Iterator<ClassDescriptorFactory> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, r8.next().getAllContributedClassesIfPossible(this.packageFqName));
        goto L4
    L7:
        return CollectionsKt.plus(r6, r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected boolean hasClass(Name r6) {
        Intrinsics.checkNotNullParameter(r6, "name");
        if (super.hasClass(r6) == true) goto L22;
        Iterable<ClassDescriptorFactory> r0 = getC().getComponents().getFictitiousClassDescriptorFactories();
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<ClassDescriptorFactory> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (r1.next().shouldCreateClass(this.packageFqName, r6) == false) goto L11;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L18;
        return true;
    L18:
        return false;
    L8:
        r5 = false;
        goto L15
    L7:
        if (((Collection) r0).isEmpty() == false) goto L9;
    L22:
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected ClassId createClassId(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return new ClassId(this.packageFqName, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r2, r3);
        return super.mo2085getContributedClassifier(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        UtilsKt.record(getC().getComponents().getLookupTracker(), r3, this.packageDescriptor, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected Set<Name> getNonDeclaredVariableNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected Set<Name> getNonDeclaredClassifierNames() {
        return SetsKt.emptySet();
    }

    public String toString() {
        return this.debugName;
    }
}
