package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    private final Annotations annotations;
    private final DeserializationContext c;
    private final ClassId classId;
    private final ProtoBuf.Class classProto;
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    private final DeclarationDescriptor containingDeclaration;
    private final EnumEntryClassDescriptors enumEntries;
    private final ClassKind kind;
    private final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    private final BinaryVersion metadataVersion;
    private final Modality modality;
    private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    private final SourceElement sourceElement;
    private final MemberScopeImpl staticScope;
    private final ProtoContainer.Class thisAsProtoContainer;
    private final DeserializedClassTypeConstructor typeConstructor;
    private final NullableLazyValue<ValueClassRepresentation<SimpleType>> valueClassRepresentation;
    private final DescriptorVisibility visibility;

    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassMemberScope extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public DeserializedClassMemberScope(DeserializedClassDescriptor r8, KotlinTypeRefiner r9) {
            Intrinsics.checkNotNullParameter(r9, "kotlinTypeRefiner");
            this.this$0 = r8;
            DeserializationContext r2 = r8.getC();
            List<ProtoBuf.Function> r3 = r8.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(r3, "classProto.functionList");
            List<ProtoBuf.Property> r4 = r8.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(r4, "classProto.propertyList");
            List<ProtoBuf.TypeAlias> r5 = r8.getClassProto().getTypeAliasList();
            Intrinsics.checkNotNullExpressionValue(r5, "classProto.typeAliasList");
            List<Integer> r0 = r8.getClassProto().getNestedClassNameList();
            Intrinsics.checkNotNullExpressionValue(r0, "classProto.nestedClassNameList");
            List<Integer> r1 = r0;
            NameResolver r10 = r8.getC().getNameResolver();
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r7 = r1.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            r6.add(NameResolverUtilKt.getName(r10, ((Number) r7.next()).intValue()));
            goto L4
        L6:
            final ArrayList r11 = r6;
            super(r2, r3, r4, r5, new DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(r11));
            this.kotlinTypeRefiner = r9;
            this.allDescriptors = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(this));
            this.refinedSupertypes = getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(this));
        }

        public static final /* synthetic */ DeserializedClassDescriptor access$getClassDescriptor(DeserializedClassMemberScope r0) {
            return r0.getClassDescriptor();
        }

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(DeserializedClassMemberScope r0) {
            return r0.kotlinTypeRefiner;
        }

        private final DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "kindFilter");
            Intrinsics.checkNotNullParameter(r3, "nameFilter");
            return this.allDescriptors.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            mo2089recordLookup(r2, r3);
            return super.getContributedFunctions(r2, r3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            mo2089recordLookup(r2, r3);
            return super.getContributedVariables(r2, r3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void computeNonDeclaredFunctions(Name r5, List<SimpleFunctionDescriptor> r6) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r6, "functions");
            ArrayList r0 = new ArrayList();
            Iterator<KotlinType> r1 = this.refinedSupertypes.invoke().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.addAll(r1.next().getMemberScope().getContributedFunctions(r5, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            r6.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(r5, this.this$0));
            generateFakeOverrides(r5, r0, r6);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void computeNonDeclaredProperties(Name r5, List<PropertyDescriptor> r6) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r6, "descriptors");
            ArrayList r0 = new ArrayList();
            Iterator<KotlinType> r1 = this.refinedSupertypes.invoke().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.addAll(r1.next().getMemberScope().getContributedVariables(r5, NoLookupLocation.FOR_ALREADY_TRACKED));
            goto L4
        L6:
            generateFakeOverrides(r5, r0, r6);
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name r9, Collection<? extends D> r10, final List<D> r11) {
            ArrayList r0 = new ArrayList(r11);
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(r9, r10, r0, getClassDescriptor(), new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(r11));
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected Set<Name> getNonDeclaredFunctionNames() {
            List r0 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo2084getSupertypes();
            LinkedHashSet r1 = new LinkedHashSet();
            Iterator r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            CollectionsKt.addAll(r1, ((KotlinType) r2.next()).getMemberScope().getFunctionNames());
            goto L4
        L6:
            DeserializedClassDescriptor r3 = this.this$0;
            r1.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(r3));
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected Set<Name> getNonDeclaredVariableNames() {
            List r2 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo2084getSupertypes();
            LinkedHashSet r0 = new LinkedHashSet();
            Iterator r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            CollectionsKt.addAll(r0, ((KotlinType) r3.next()).getMemberScope().getVariableNames());
            goto L4
        L7:
            return r0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected Set<Name> getNonDeclaredClassifierNames() {
            List r2 = DeserializedClassDescriptor.access$getTypeConstructor$p(getClassDescriptor()).mo2084getSupertypes();
            LinkedHashSet r0 = new LinkedHashSet();
            Iterator r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L10;
            Set<Name> r1 = ((KotlinType) r3.next()).getMemberScope().getClassifierNames();
            if (r1 == null) goto L7;
            CollectionsKt.addAll(r0, r1);
            goto L4
        L7:
            r0 = null;
        L10:
            return r0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: getContributedClassifier */
        public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            mo2089recordLookup(r2, r3);
            EnumEntryClassDescriptors r0 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r0 == null) goto L9;
            ClassDescriptor r1 = r0.findEnumEntry(r2);
            if (r1 == null) goto L9;
            return r1;
        L9:
            return super.mo2085getContributedClassifier(r2, r3);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected ClassId createClassId(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            ClassId r1 = DeserializedClassDescriptor.access$getClassId$p(this.this$0).createNestedClassId(r2);
            Intrinsics.checkNotNullExpressionValue(r1, "classId.createNestedClassId(name)");
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r2, Function1<? super Name, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "nameFilter");
            EnumEntryClassDescriptors r1 = DeserializedClassDescriptor.access$getEnumEntries$p(getClassDescriptor());
            if (r1 == null) goto L5;
            List r4 = r1.all();
        L6:
            if (r4 != null) goto L8;
            r4 = CollectionsKt.emptyList();
        L8:
            r2.addAll(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: recordLookup */
        public void mo2089recordLookup(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            UtilsKt.record(getC().getComponents().getLookupTracker(), r3, getClassDescriptor(), r2);
        }
    }

    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public DeserializedClassTypeConstructor(final DeserializedClassDescriptor r3) {
            this.this$0 = r3;
            super(r3.getC().getStorageManager());
            this.parameters = r3.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(r3));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassDescriptor mo2083getDeclarationDescriptor() {
            return mo2083getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo2083getDeclarationDescriptor() {
            return mo2083getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            List<ProtoBuf.Type> r0 = ProtoTypeTableUtilKt.supertypes(this.this$0.getClassProto(), this.this$0.getC().getTypeTable());
            DeserializedClassDescriptor r1 = this.this$0;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(r1.getC().getTypeDeserializer().type((ProtoBuf.Type) r3.next()));
            goto L4
        L6:
            List r4 = CollectionsKt.plus(r2, this.this$0.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.this$0));
            ArrayList r5 = new ArrayList();
            Iterator r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L15;
            ClassifierDescriptor r7 = ((KotlinType) r6.next()).getConstructor().mo2083getDeclarationDescriptor();
            if ((r7 instanceof NotFoundClasses.MockClassDescriptor) == false) goto L12;
            NotFoundClasses.MockClassDescriptor r8 = (NotFoundClasses.MockClassDescriptor) r7;
        L13:
            if (r8 == null) goto L8;
            r5.add(r8);
            goto L8
        L12:
            r8 = null;
            goto L13
        L15:
            ArrayList r9 = r5;
            if ((!r9.isEmpty()) == false) goto L30;
            ErrorReporter r10 = this.this$0.getC().getComponents().getErrorReporter();
            DeserializedClassDescriptor r11 = this.this$0;
            ArrayList r12 = r9;
            ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator r14 = r12.iterator();
        L19:
            if (r14.hasNext() == false) goto L28;
            NotFoundClasses.MockClassDescriptor r15 = (NotFoundClasses.MockClassDescriptor) r14.next();
            ClassId r16 = DescriptorUtilsKt.getClassId(r15);
            if (r16 == null) goto L26;
            FqName r17 = r16.asSingleFqName();
            if (r17 == null) goto L26;
            String r18 = r17.asString();
            if (r18 == null) goto L26;
        L27:
            r13.add(r18);
        L26:
            r18 = r15.getName().asString();
            goto L27
        L28:
            r10.reportIncompleteHierarchy(r11, r13);
        L30:
            return CollectionsKt.toList(r4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public DeserializedClassDescriptor mo2083getDeclarationDescriptor() {
            return this.this$0;
        }

        public String toString() {
            String r1 = this.this$0.getName().toString();
            Intrinsics.checkNotNullExpressionValue(r1, "name.toString()");
            return r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    private final class EnumEntryClassDescriptors {
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        private final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        private final NotNullLazyValue<Set<Name>> enumMemberNames;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor r6) {
            this.this$0 = r6;
            List<ProtoBuf.EnumEntry> r0 = r6.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(r0, "classProto.enumEntryList");
            List<ProtoBuf.EnumEntry> r1 = r0;
            LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
            Iterator<T> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            Object r4 = r3.next();
            r2.put(NameResolverUtilKt.getName(r6.getC().getNameResolver(), ((ProtoBuf.EnumEntry) r4).getName()), r4);
            goto L4
        L6:
            this.enumEntryProtos = r2;
            StorageManager r7 = this.this$0.getC().getStorageManager();
            final DeserializedClassDescriptor r5 = this.this$0;
            this.enumEntryByName = r7.createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, r5));
            this.enumMemberNames = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        public static final /* synthetic */ Set access$computeEnumMemberNames(EnumEntryClassDescriptors r0) {
            return r0.computeEnumMemberNames();
        }

        public static final /* synthetic */ Map access$getEnumEntryProtos$p(EnumEntryClassDescriptors r0) {
            return r0.enumEntryProtos;
        }

        public static final /* synthetic */ NotNullLazyValue access$getEnumMemberNames$p(EnumEntryClassDescriptors r0) {
            return r0.enumMemberNames;
        }

        public final ClassDescriptor findEnumEntry(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            return this.enumEntryByName.invoke(r2);
        }

        private final Set<Name> computeEnumMemberNames() {
            HashSet r0 = new HashSet();
            Iterator<KotlinType> r1 = this.this$0.getTypeConstructor().mo2084getSupertypes().iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            Iterator r2 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r1.next().getMemberScope(), null, null, 3, null).iterator();
        L7:
            if (r2.hasNext() == false) goto L4;
            DeclarationDescriptor r3 = (DeclarationDescriptor) r2.next();
            if ((r3 instanceof SimpleFunctionDescriptor) == true) goto L12;
            if ((r3 instanceof PropertyDescriptor) == false) goto L7;
        L12:
            r0.add(r3.getName());
            goto L7
        L13:
            List<ProtoBuf.Function> r4 = this.this$0.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(r4, "classProto.functionList");
            DeserializedClassDescriptor r5 = this.this$0;
            Iterator<T> r6 = r4.iterator();
        L15:
            if (r6.hasNext() == false) goto L17;
            ProtoBuf.Function r7 = (ProtoBuf.Function) r6.next();
            r0.add(NameResolverUtilKt.getName(r5.getC().getNameResolver(), r7.getName()));
            goto L15
        L17:
            HashSet r8 = r0;
            HashSet r9 = r8;
            List<ProtoBuf.Property> r10 = this.this$0.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(r10, "classProto.propertyList");
            DeserializedClassDescriptor r11 = this.this$0;
            Iterator<T> r12 = r10.iterator();
        L19:
            if (r12.hasNext() == false) goto L22;
            ProtoBuf.Property r13 = (ProtoBuf.Property) r12.next();
            r8.add(NameResolverUtilKt.getName(r11.getC().getNameResolver(), r13.getName()));
            goto L19
        L22:
            return SetsKt.plus(r9, r8);
        }

        public final Collection<ClassDescriptor> all() {
            Set<Name> r0 = this.enumEntryProtos.keySet();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            ClassDescriptor r3 = findEnumEntry((Name) r2.next());
            if (r3 == null) goto L4;
            r1.add(r3);
            goto L4
        L9:
            return r1;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    public static final /* synthetic */ ClassDescriptor access$computeCompanionObjectDescriptor(DeserializedClassDescriptor r0) {
        return r0.computeCompanionObjectDescriptor();
    }

    public static final /* synthetic */ Collection access$computeConstructors(DeserializedClassDescriptor r0) {
        return r0.computeConstructors();
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$computePrimaryConstructor(DeserializedClassDescriptor r0) {
        return r0.computePrimaryConstructor();
    }

    public static final /* synthetic */ Collection access$computeSubclassesForSealedClass(DeserializedClassDescriptor r0) {
        return r0.computeSubclassesForSealedClass();
    }

    public static final /* synthetic */ ValueClassRepresentation access$computeValueClassRepresentation(DeserializedClassDescriptor r0) {
        return r0.computeValueClassRepresentation();
    }

    public static final /* synthetic */ ClassId access$getClassId$p(DeserializedClassDescriptor r0) {
        return r0.classId;
    }

    public static final /* synthetic */ EnumEntryClassDescriptors access$getEnumEntries$p(DeserializedClassDescriptor r0) {
        return r0.enumEntries;
    }

    public static final /* synthetic */ DeserializedClassTypeConstructor access$getTypeConstructor$p(DeserializedClassDescriptor r0) {
        return r0.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getStaticScope() {
        return getStaticScope();
    }

    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    public final BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public DeserializedClassDescriptor(DeserializationContext r9, ProtoBuf.Class r10, NameResolver r11, BinaryVersion r12, SourceElement r13) {
        Intrinsics.checkNotNullParameter(r9, "outerContext");
        Intrinsics.checkNotNullParameter(r10, "classProto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "metadataVersion");
        Intrinsics.checkNotNullParameter(r13, "sourceElement");
        super(r9.getStorageManager(), NameResolverUtilKt.getClassId(r11, r10.getFqName()).getShortClassName());
        this.classProto = r10;
        this.metadataVersion = r12;
        this.sourceElement = r13;
        this.classId = NameResolverUtilKt.getClassId(r11, r10.getFqName());
        this.modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(r10.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r10.getFlags()));
        ClassKind r0 = ProtoEnumFlags.INSTANCE.classKind(Flags.CLASS_KIND.get(r10.getFlags()));
        this.kind = r0;
        List<ProtoBuf.TypeParameter> r3 = r10.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r3, "classProto.typeParameterList");
        ProtoBuf.TypeTable r1 = r10.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r1, "classProto.typeTable");
        TypeTable r5 = new TypeTable(r1);
        VersionRequirementTable.Companion r2 = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable r4 = r10.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(r4, "classProto.versionRequirementTable");
        DeserializationContext r14 = r9.childContext(this, r3, r11, r5, r2.create(r4), r12);
        this.c = r14;
        if (r0 != ClassKind.ENUM_CLASS) goto L5;
        MemberScopeImpl r15 = new StaticScopeForKotlinEnum(r14.getStorageManager(), this);
    L6:
        this.staticScope = r15;
        this.typeConstructor = new DeserializedClassTypeConstructor(this);
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, r14.getStorageManager(), r14.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class r6 = null;
        if (r0 != ClassKind.ENUM_CLASS) goto L9;
        EnumEntryClassDescriptors r16 = new EnumEntryClassDescriptors(this);
    L10:
        this.enumEntries = r16;
        DeclarationDescriptor r17 = r9.getContainingDeclaration();
        this.containingDeclaration = r17;
        this.primaryConstructor = r14.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.constructors = r14.getStorageManager().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.companionObjectDescriptor = r14.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.sealedSubclasses = r14.getStorageManager().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        this.valueClassRepresentation = r14.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$valueClassRepresentation$1(this));
        NameResolver r7 = r14.getNameResolver();
        TypeTable r8 = r14.getTypeTable();
        if ((r17 instanceof DeserializedClassDescriptor) == false) goto L13;
        DeserializedClassDescriptor r18 = (DeserializedClassDescriptor) r17;
    L14:
        if (r18 == null) goto L16;
        r6 = r18.thisAsProtoContainer;
    L16:
        this.thisAsProtoContainer = new ProtoContainer.Class(r10, r7, r8, r13, r6);
        if (Flags.HAS_ANNOTATIONS.get(r10.getFlags()).booleanValue() == true) goto L19;
        NonEmptyDeserializedAnnotations r19 = Annotations.Companion.getEMPTY();
    L20:
        this.annotations = r19;
        return;
    L19:
        r19 = new NonEmptyDeserializedAnnotations(r14.getStorageManager(), new DeserializedClassDescriptor$annotations$1(this));
        goto L20
    L13:
        r18 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = MemberScope.Empty.INSTANCE;
        goto L6
    }

    public final DeserializationContext getC() {
        return this.c;
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return (DeserializedClassMemberScope) this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean r1 = Flags.IS_INNER.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_INNER.get(classProto.flags)");
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        Boolean r1 = Flags.IS_DATA.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_DATA.get(classProto.flags)");
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        Boolean r0 = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r0, "IS_VALUE_CLASS.get(classProto.flags)");
        if (r0.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.metadataVersion.isAtMost(1, 4, 1) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        Boolean r1 = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_EXPECT_CLASS.get(classProto.flags)");
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean r1 = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        Boolean r1 = Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_FUN_INTERFACE.get(classProto.flags)");
        return r1.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        Boolean r0 = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(r0, "IS_VALUE_CLASS.get(classProto.flags)");
        if (r0.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.metadataVersion.isAtLeast(1, 4, 2) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    protected MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        if (Flags.CLASS_KIND.get(this.classProto.getFlags()) != ProtoBuf.Class.Kind.COMPANION_OBJECT) goto L5;
        return true;
    L5:
        return false;
    }

    private final ClassConstructorDescriptor computePrimaryConstructor() {
        if (this.kind.isSingleton() == false) goto L6;
        ClassConstructorDescriptorImpl r0 = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
        r0.setReturnType(getDefaultType());
        return r0;
    L6:
        List<ProtoBuf.Constructor> r1 = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(r1, "classProto.constructorList");
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if ((!Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) r3).getFlags()).booleanValue()) == false) goto L8;
    L13:
        ProtoBuf.Constructor r4 = (ProtoBuf.Constructor) r3;
        if (r4 != null) goto L16;
        return null;
    L16:
        return this.c.getMemberDeserializer().loadConstructor(r4, true);
    L12:
        r3 = null;
        goto L13
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo2077getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor.invoke();
    }

    private final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus(CollectionsKt.plus(computeSecondaryConstructors(), CollectionsKt.listOfNotNull(mo2077getUnsubstitutedPrimaryConstructor())), this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf.Constructor> r0 = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(r0, "classProto.constructorList");
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        Boolean r4 = Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) r3).getFlags());
        Intrinsics.checkNotNullExpressionValue(r4, "IS_SECONDARY.get(it.flags)");
        if (r4.booleanValue() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        ArrayList r5 = r1;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L13;
        ProtoBuf.Constructor r8 = (ProtoBuf.Constructor) r7.next();
        MemberDeserializer r9 = this.c.getMemberDeserializer();
        Intrinsics.checkNotNullExpressionValue(r8, "it");
        r6.add(r9.loadConstructor(r8, false));
        goto L10
    L13:
        return r6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return this.constructors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ProtoBuf.Type> r0 = ProtoTypeTableUtilKt.contextReceiverTypes(this.classProto, this.c.getTypeTable());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        ProtoBuf.Type r3 = (ProtoBuf.Type) r2.next();
        KotlinType r4 = this.c.getTypeDeserializer().type(r3);
        r1.add(new ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new ContextClassReceiver(this, r4, null), Annotations.Companion.getEMPTY()));
        goto L4
    L7:
        return r1;
    }

    private final ClassDescriptor computeCompanionObjectDescriptor() {
        if (this.classProto.hasCompanionObjectName() == true) goto L5;
        return null;
    L5:
        Name r0 = NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName());
        ClassifierDescriptor r3 = getMemberScope().mo2085getContributedClassifier(r0, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r3 instanceof ClassDescriptor) == true) goto L8;
        return null;
    L8:
        return (ClassDescriptor) r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo2076getCompanionObjectDescriptor() {
        return this.companionObjectDescriptor.invoke();
    }

    public final boolean hasNestedClass$deserialization(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return getMemberScope().getClassNames$deserialization().contains(r2);
    }

    private final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) goto L5;
        List<Integer> r0 = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(r0, "fqNames");
        if ((!r0.isEmpty()) == false) goto L17;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        Integer r3 = (Integer) r2.next();
        DeserializationComponents r4 = this.c.getComponents();
        NameResolver r5 = this.c.getNameResolver();
        Intrinsics.checkNotNullExpressionValue(r3, "index");
        ClassDescriptor r6 = r4.deserializeClass(NameResolverUtilKt.getClassId(r5, r3.intValue()));
        if (r6 == null) goto L10;
        r1.add(r6);
        goto L10
    L15:
        return r1;
    L17:
        return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return this.sealedSubclasses.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return this.valueClassRepresentation.invoke();
    }

    private final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        InlineClassRepresentation<SimpleType> r0 = computeInlineClassRepresentation();
        MultiFieldValueClassRepresentation<SimpleType> r1 = computeMultiFieldValueClassRepresentation();
        if (r0 == null) goto L9;
        if (r1 == null) goto L9;
        throw new IllegalArgumentException("Class cannot have both inline class representation and multi field class representation: " + this);
    L9:
        if (isValue() == false) goto L11;
    L12:
        if (r0 != null) goto L17;
        if (r1 != null) goto L17;
        throw new IllegalArgumentException("Value class has no value class representation: " + this);
    L17:
        if (r0 == null) goto L20;
        return r0;
    L20:
        return r1;
    L11:
        if (isInline() == false) goto L17;
        goto L12
    }

    private final InlineClassRepresentation<SimpleType> computeInlineClassRepresentation() {
        Object r1 = null;
        if (isInline() == true) goto L8;
        if (isValue() == true) goto L8;
        return null;
    L8:
        if (isValue() == false) goto L19;
        if (this.classProto.hasInlineClassUnderlyingPropertyName() == true) goto L19;
        if (this.classProto.hasInlineClassUnderlyingType() == true) goto L19;
        if (this.classProto.hasInlineClassUnderlyingTypeId() == true) goto L19;
        if (this.classProto.getMultiFieldValueClassUnderlyingNameCount() <= 0) goto L19;
        return null;
    L19:
        if (this.classProto.hasInlineClassUnderlyingPropertyName() == false) goto L22;
        Name r0 = NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getInlineClassUnderlyingPropertyName());
    L26:
        ProtoBuf.Type r3 = ProtoTypeTableUtilKt.inlineClassUnderlyingType(this.classProto, this.c.getTypeTable());
        if (r3 == null) goto L30;
        SimpleType r4 = TypeDeserializer.simpleType$default(this.c.getTypeDeserializer(), r3, false, 2, null);
        if (r4 == null) goto L30;
    L48:
        return new InlineClassRepresentation(r0, r4);
    L30:
        Iterator<T> r5 = getMemberScope().getContributedVariables(r0, NoLookupLocation.FROM_DESERIALIZATION).iterator();
        Object r6 = null;
        boolean r7 = false;
    L32:
        if (r5.hasNext() == false) goto L41;
        Object r8 = r5.next();
        if (((PropertyDescriptor) r8).getExtensionReceiverParameter() != null) goto L36;
        boolean r9 = true;
    L37:
        if (r9 == false) goto L32;
        if (r7 == true) goto L44;
        r7 = true;
        r6 = r8;
    L44:
        PropertyDescriptor r2 = (PropertyDescriptor) r1;
        if (r2 == null) goto L50;
        KotlinType r10 = r2.getType();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        r4 = (SimpleType) r10;
        goto L48
    L50:
        throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
    L36:
        r9 = false;
        goto L37
    L41:
        if (r7 == false) goto L44;
        r1 = r6;
        goto L44
    L22:
        if (this.metadataVersion.isAtLeast(1, 5, 1) == true) goto L54;
        ClassConstructorDescriptor r11 = mo2077getUnsubstitutedPrimaryConstructor();
        if (r11 == null) goto L52;
        List<ValueParameterDescriptor> r12 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "constructor.valueParameters");
        r0 = ((ValueParameterDescriptor) CollectionsKt.first(r12)).getName();
        Intrinsics.checkNotNullExpressionValue(r0, "{\n                // Bef…irst().name\n            }");
        goto L26
    L52:
        throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
    L54:
        throw new IllegalStateException(("Inline class has no underlying property name in metadata: " + this).toString());
    }

    private final MultiFieldValueClassRepresentation<SimpleType> computeMultiFieldValueClassRepresentation() {
        List<Integer> r0 = this.classProto.getMultiFieldValueClassUnderlyingNameList();
        Intrinsics.checkNotNullExpressionValue(r0, "classProto.multiFieldValueClassUnderlyingNameList");
        List<Integer> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Integer r4 = (Integer) r3.next();
        NameResolver r5 = this.c.getNameResolver();
        Intrinsics.checkNotNullExpressionValue(r4, "it");
        r2.add(NameResolverUtilKt.getName(r5, r4.intValue()));
        goto L4
    L6:
        ArrayList r6 = r2;
        if ((!r6.isEmpty()) == true) goto L10;
        r6 = null;
    L10:
        if (r6 != null) goto L13;
        return null;
    L13:
        if (isValue() == false) goto L33;
        Pair r7 = TuplesKt.to(Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeCount()));
        if (Intrinsics.areEqual(r7, TuplesKt.to(Integer.valueOf(r6.size()), 0)) == false) goto L22;
        List<Integer> r8 = this.classProto.getMultiFieldValueClassUnderlyingTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r8, "classProto.multiFieldVal…ClassUnderlyingTypeIdList");
        List<Integer> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        Integer r12 = (Integer) r11.next();
        TypeTable r13 = this.c.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(r12, "it");
        r10.add(r13.get(r12.intValue()));
        goto L18
    L20:
        ArrayList r14 = r10;
    L24:
        Intrinsics.checkNotNullExpressionValue(r14, "when (typeIdCount to typ…tation: $this\")\n        }");
        List<ProtoBuf.Type> r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L26:
        if (r17.hasNext() == false) goto L29;
        ProtoBuf.Type r18 = (ProtoBuf.Type) r17.next();
        TypeDeserializer r19 = this.c.getTypeDeserializer();
        Intrinsics.checkNotNullExpressionValue(r18, "it");
        r16.add(TypeDeserializer.simpleType$default(r19, r18, false, 2, null));
        goto L26
    L29:
        return new MultiFieldValueClassRepresentation(CollectionsKt.zip(r6, r16));
    L22:
        if (Intrinsics.areEqual(r7, TuplesKt.to(0, Integer.valueOf(r6.size()))) == false) goto L31;
        r14 = this.classProto.getMultiFieldValueClassUnderlyingTypeList();
        goto L24
    L31:
        throw new IllegalStateException(("Illegal multi-field value class representation: " + this).toString());
    L33:
        throw new IllegalArgumentException(("Not a value class: " + this).toString());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("deserialized ");
        if (isExpect() == false) goto L5;
        String r1 = "expect ";
    L7:
        return r0.append(r1).append("class ").append(getName()).toString();
    L5:
        r1 = "";
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }
}
