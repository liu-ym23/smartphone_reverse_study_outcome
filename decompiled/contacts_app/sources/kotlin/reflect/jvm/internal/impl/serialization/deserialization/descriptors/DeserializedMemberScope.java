package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final DeserializationContext c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    private final Implementation impl;

    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    private interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r1, DescriptorKindFilter r2, Function1<? super Name, Boolean> r3, LookupLocation r4);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r1, LookupLocation r2);

        Collection<PropertyDescriptor> getContributedVariables(Name r1, LookupLocation r2);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name r1);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    private final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final NotNullLazyValue allFunctions$delegate;
        private final NotNullLazyValue allProperties$delegate;
        private final NotNullLazyValue allTypeAliases$delegate;
        private final NotNullLazyValue declaredFunctions$delegate;
        private final NotNullLazyValue declaredProperties$delegate;
        private final List<ProtoBuf.Function> functionList;
        private final NotNullLazyValue functionNames$delegate;
        private final NotNullLazyValue functionsByName$delegate;
        private final NotNullLazyValue propertiesByName$delegate;
        private final List<ProtoBuf.Property> propertyList;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        private final NotNullLazyValue typeAliasesByName$delegate;
        private final NotNullLazyValue variableNames$delegate;

        public NoReorderImplementation(final DeserializedMemberScope r2, List<ProtoBuf.Function> r3, List<ProtoBuf.Property> r4, List<ProtoBuf.TypeAlias> r5) {
            Intrinsics.checkNotNullParameter(r3, "functionList");
            Intrinsics.checkNotNullParameter(r4, "propertyList");
            Intrinsics.checkNotNullParameter(r5, "typeAliasList");
            this.this$0 = r2;
            this.functionList = r3;
            this.propertyList = r4;
            if (r2.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == true) goto L6;
            r5 = CollectionsKt.emptyList();
        L6:
            this.typeAliasList = r5;
            this.declaredFunctions$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.declaredProperties$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.allTypeAliases$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.functionsByName$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.propertiesByName$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.functionNames$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, r2));
            this.variableNames$delegate = r2.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, r2));
        }

        public static final /* synthetic */ List access$computeAllNonDeclaredFunctions(NoReorderImplementation r0) {
            return r0.computeAllNonDeclaredFunctions();
        }

        public static final /* synthetic */ List access$computeAllNonDeclaredProperties(NoReorderImplementation r0) {
            return r0.computeAllNonDeclaredProperties();
        }

        public static final /* synthetic */ List access$computeFunctions(NoReorderImplementation r0) {
            return r0.computeFunctions();
        }

        public static final /* synthetic */ List access$computeProperties(NoReorderImplementation r0) {
            return r0.computeProperties();
        }

        public static final /* synthetic */ List access$computeTypeAliases(NoReorderImplementation r0) {
            return r0.computeTypeAliases();
        }

        public static final /* synthetic */ List access$getAllFunctions(NoReorderImplementation r0) {
            return r0.getAllFunctions();
        }

        public static final /* synthetic */ List access$getAllProperties(NoReorderImplementation r0) {
            return r0.getAllProperties();
        }

        public static final /* synthetic */ List access$getAllTypeAliases(NoReorderImplementation r0) {
            return r0.getAllTypeAliases();
        }

        public static final /* synthetic */ List access$getDeclaredFunctions(NoReorderImplementation r0) {
            return r0.getDeclaredFunctions();
        }

        public static final /* synthetic */ List access$getDeclaredProperties(NoReorderImplementation r0) {
            return r0.getDeclaredProperties();
        }

        public static final /* synthetic */ List access$getFunctionList$p(NoReorderImplementation r0) {
            return r0.functionList;
        }

        public static final /* synthetic */ List access$getPropertyList$p(NoReorderImplementation r0) {
            return r0.propertyList;
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(NoReorderImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        private final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List) StorageKt.getValue(this.declaredFunctions$delegate, this, $$delegatedProperties[0]);
        }

        private final List<PropertyDescriptor> getDeclaredProperties() {
            return (List) StorageKt.getValue(this.declaredProperties$delegate, this, $$delegatedProperties[1]);
        }

        private final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List) StorageKt.getValue(this.allTypeAliases$delegate, this, $$delegatedProperties[2]);
        }

        private final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List) StorageKt.getValue(this.allFunctions$delegate, this, $$delegatedProperties[3]);
        }

        private final List<PropertyDescriptor> getAllProperties() {
            return (List) StorageKt.getValue(this.allProperties$delegate, this, $$delegatedProperties[4]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map) StorageKt.getValue(this.typeAliasesByName$delegate, this, $$delegatedProperties[5]);
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map) StorageKt.getValue(this.functionsByName$delegate, this, $$delegatedProperties[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map) StorageKt.getValue(this.propertiesByName$delegate, this, $$delegatedProperties[7]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[9]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            List<ProtoBuf.TypeAlias> r0 = this.typeAliasList;
            LinkedHashSet r1 = new LinkedHashSet();
            DeserializedMemberScope r4 = this.this$0;
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            MessageLite r3 = (MessageLite) r2.next();
            r1.add(NameResolverUtilKt.getName(r4.getC().getNameResolver(), ((ProtoBuf.TypeAlias) r3).getName()));
            goto L4
        L7:
            return r1;
        }

        private final List<SimpleFunctionDescriptor> computeFunctions() {
            List<ProtoBuf.Function> r0 = this.functionList;
            DeserializedMemberScope r4 = this.this$0;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L13;
            MessageLite r3 = (MessageLite) r2.next();
            SimpleFunctionDescriptor r5 = r4.getC().getMemberDeserializer().loadFunction((ProtoBuf.Function) r3);
            if (r4.isDeclaredFunctionAvailable(r5) == true) goto L9;
            r5 = null;
        L9:
            SimpleFunctionDescriptor r6 = r5;
            if (r6 == null) goto L4;
            r1.add(r6);
            goto L4
        L13:
            return r1;
        }

        private final List<PropertyDescriptor> computeProperties() {
            List<ProtoBuf.Property> r0 = this.propertyList;
            DeserializedMemberScope r4 = this.this$0;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            MessageLite r3 = (MessageLite) r2.next();
            PropertyDescriptor r5 = r4.getC().getMemberDeserializer().loadProperty((ProtoBuf.Property) r3);
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L9:
            return r1;
        }

        private final List<TypeAliasDescriptor> computeTypeAliases() {
            List<ProtoBuf.TypeAlias> r0 = this.typeAliasList;
            DeserializedMemberScope r4 = this.this$0;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            MessageLite r3 = (MessageLite) r2.next();
            TypeAliasDescriptor r5 = r4.getC().getMemberDeserializer().loadTypeAlias((ProtoBuf.TypeAlias) r3);
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L9:
            return r1;
        }

        private final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Set<Name> r0 = this.this$0.getNonDeclaredFunctionNames();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            CollectionsKt.addAll(r1, computeNonDeclaredFunctionsForName((Name) r2.next()));
            goto L4
        L7:
            return r1;
        }

        private final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Set<Name> r0 = this.this$0.getNonDeclaredVariableNames();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            CollectionsKt.addAll(r1, computeNonDeclaredPropertiesForName((Name) r2.next()));
            goto L4
        L7:
            return r1;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name r5) {
            List<SimpleFunctionDescriptor> r0 = getDeclaredFunctions();
            DeserializedMemberScope r4 = this.this$0;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (Intrinsics.areEqual(((DeclarationDescriptor) r3).getName(), r5) == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            ArrayList r6 = r1;
            int r7 = r6.size();
            r4.computeNonDeclaredFunctions(r5, r6);
            return r6.subList(r7, r6.size());
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name r5) {
            List<PropertyDescriptor> r0 = getDeclaredProperties();
            DeserializedMemberScope r4 = this.this$0;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (Intrinsics.areEqual(((DeclarationDescriptor) r3).getName(), r5) == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            ArrayList r6 = r1;
            int r7 = r6.size();
            r4.computeNonDeclaredProperties(r5, r6);
            return r6.subList(r7, r6.size());
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            if (getFunctionNames().contains(r2) == false) goto L5;
            Collection<SimpleFunctionDescriptor> r1 = getFunctionsByName().get(r2);
            if (r1 == null) goto L9;
            return r1;
        L9:
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            return getTypeAliasesByName().get(r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            if (getVariableNames().contains(r2) == false) goto L5;
            Collection<PropertyDescriptor> r1 = getPropertiesByName().get(r2);
            if (r1 == null) goto L9;
            return r1;
        L9:
            return CollectionsKt.emptyList();
        L5:
            return CollectionsKt.emptyList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r4, DescriptorKindFilter r5, Function1<? super Name, Boolean> r6, LookupLocation r7) {
            Intrinsics.checkNotNullParameter(r4, "result");
            Intrinsics.checkNotNullParameter(r5, "kindFilter");
            Intrinsics.checkNotNullParameter(r6, "nameFilter");
            Intrinsics.checkNotNullParameter(r7, BatteryTypeInf.BATTERY_LOC_API);
            if (r5.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L11;
            Iterator<T> r8 = getAllProperties().iterator();
        L6:
            if (r8.hasNext() == false) goto L11;
            Object r1 = r8.next();
            Name r2 = ((PropertyDescriptor) r1).getName();
            Intrinsics.checkNotNullExpressionValue(r2, "it.name");
            if (r6.invoke(r2).booleanValue() == false) goto L6;
            r4.add(r1);
        L11:
            if (r5.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L18;
            Iterator<T> r3 = getAllFunctions().iterator();
        L14:
            if (r3.hasNext() == false) goto L29;
            Object r9 = r3.next();
            Name r10 = ((SimpleFunctionDescriptor) r9).getName();
            Intrinsics.checkNotNullExpressionValue(r10, "it.name");
            if (r6.invoke(r10).booleanValue() == false) goto L14;
            r4.add(r9);
            goto L14
        L29:
            return;
        }
    }

    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    private final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final NotNullLazyValue functionNames$delegate;
        private final Map<Name, byte[]> functionProtosBytes;
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        private final Map<Name, byte[]> propertyProtosBytes;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        private final Map<Name, byte[]> typeAliasBytes;
        private final NotNullLazyValue variableNames$delegate;

        public OptimizedImplementation(DeserializedMemberScope r5, List<ProtoBuf.Function> r6, List<ProtoBuf.Property> r7, List<ProtoBuf.TypeAlias> r8) {
            Intrinsics.checkNotNullParameter(r6, "functionList");
            Intrinsics.checkNotNullParameter(r7, "propertyList");
            Intrinsics.checkNotNullParameter(r8, "typeAliasList");
            this.this$0 = r5;
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r9 = r6.iterator();
        L4:
            if (r9.hasNext() == false) goto L9;
            Object r1 = r9.next();
            Name r2 = NameResolverUtilKt.getName(r5.getC().getNameResolver(), ((ProtoBuf.Function) ((MessageLite) r1)).getName());
            Object r3 = r0.get(r2);
            if (r3 != null) goto L8;
            r3 = (List) new ArrayList();
            r0.put(r2, r3);
        L8:
            ((List) r3).add(r1);
            goto L4
        L9:
            this.functionProtosBytes = packToByteArray(r0);
            DeserializedMemberScope r10 = this.this$0;
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator<T> r12 = r7.iterator();
        L11:
            if (r12.hasNext() == false) goto L16;
            Object r4 = r12.next();
            Name r13 = NameResolverUtilKt.getName(r10.getC().getNameResolver(), ((ProtoBuf.Property) ((MessageLite) r4)).getName());
            Object r14 = r11.get(r13);
            if (r14 != null) goto L15;
            r14 = (List) new ArrayList();
            r11.put(r13, r14);
        L15:
            ((List) r14).add(r4);
            goto L11
        L16:
            this.propertyProtosBytes = packToByteArray(r11);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed() == false) goto L26;
            DeserializedMemberScope r15 = this.this$0;
            LinkedHashMap r16 = new LinkedHashMap();
            Iterator<T> r17 = r8.iterator();
        L20:
            if (r17.hasNext() == false) goto L25;
            Object r18 = r17.next();
            Name r19 = NameResolverUtilKt.getName(r15.getC().getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) r18)).getName());
            Object r20 = r16.get(r19);
            if (r20 != null) goto L24;
            r20 = (List) new ArrayList();
            r16.put(r19, r20);
        L24:
            ((List) r20).add(r18);
            goto L20
        L25:
            Map<Name, byte[]> r21 = packToByteArray(r16);
        L27:
            this.typeAliasBytes = r21;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            StorageManager r22 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r23 = this.this$0;
            this.functionNames$delegate = r22.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, r23));
            StorageManager r24 = this.this$0.getC().getStorageManager();
            final DeserializedMemberScope r25 = this.this$0;
            this.variableNames$delegate = r24.createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, r25));
            return;
        L26:
            r21 = MapsKt.emptyMap();
            goto L27
        }

        public static final /* synthetic */ Collection access$computeFunctions(OptimizedImplementation r0, Name r1) {
            return r0.computeFunctions(r1);
        }

        public static final /* synthetic */ Collection access$computeProperties(OptimizedImplementation r0, Name r1) {
            return r0.computeProperties(r1);
        }

        public static final /* synthetic */ TypeAliasDescriptor access$createTypeAlias(OptimizedImplementation r0, Name r1) {
            return r0.createTypeAlias(r1);
        }

        public static final /* synthetic */ Map access$getFunctionProtosBytes$p(OptimizedImplementation r0) {
            return r0.functionProtosBytes;
        }

        public static final /* synthetic */ Map access$getPropertyProtosBytes$p(OptimizedImplementation r0) {
            return r0.propertyProtosBytes;
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[1]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        private final Collection<SimpleFunctionDescriptor> computeFunctions(Name r6) {
            Map<Name, byte[]> r0 = this.functionProtosBytes;
            Parser<ProtoBuf.Function> r1 = ProtoBuf.Function.PARSER;
            Intrinsics.checkNotNullExpressionValue(r1, "PARSER");
            DeserializedMemberScope r2 = this.this$0;
            byte[] r3 = r0.get(r6);
            if (r3 == null) goto L7;
            DeserializedMemberScope r5 = this.this$0;
            List r7 = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r1, new ByteArrayInputStream(r3), r5)));
            if (r7 == null) goto L7;
            List r8 = r7;
        L8:
            List r4 = r8;
            ArrayList r9 = new ArrayList(r8.size());
            Iterator r10 = r4.iterator();
        L10:
            if (r10.hasNext() == false) goto L17;
            ProtoBuf.Function r11 = (ProtoBuf.Function) r10.next();
            MemberDeserializer r12 = r2.getC().getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(r11, "it");
            SimpleFunctionDescriptor r13 = r12.loadFunction(r11);
            if (r2.isDeclaredFunctionAvailable(r13) == true) goto L15;
            r13 = null;
        L15:
            if (r13 == null) goto L10;
            r9.add(r13);
            goto L10
        L17:
            ArrayList r14 = r9;
            r2.computeNonDeclaredFunctions(r6, r14);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r14);
        L7:
            r8 = CollectionsKt.emptyList();
            goto L8
        }

        private final Collection<PropertyDescriptor> computeProperties(Name r6) {
            Map<Name, byte[]> r0 = this.propertyProtosBytes;
            Parser<ProtoBuf.Property> r1 = ProtoBuf.Property.PARSER;
            Intrinsics.checkNotNullExpressionValue(r1, "PARSER");
            DeserializedMemberScope r2 = this.this$0;
            byte[] r3 = r0.get(r6);
            if (r3 == null) goto L7;
            DeserializedMemberScope r5 = this.this$0;
            List r7 = SequencesKt.toList(SequencesKt.generateSequence(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(r1, new ByteArrayInputStream(r3), r5)));
            if (r7 == null) goto L7;
            List r8 = r7;
        L8:
            List r4 = r8;
            ArrayList r9 = new ArrayList(r8.size());
            Iterator r10 = r4.iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            ProtoBuf.Property r11 = (ProtoBuf.Property) r10.next();
            MemberDeserializer r12 = r2.getC().getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(r11, "it");
            PropertyDescriptor r13 = r12.loadProperty(r11);
            if (r13 == null) goto L10;
            r9.add(r13);
            goto L10
        L14:
            ArrayList r14 = r9;
            r2.computeNonDeclaredProperties(r6, r14);
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r14);
        L7:
            r8 = CollectionsKt.emptyList();
            goto L8
        }

        private final TypeAliasDescriptor createTypeAlias(Name r3) {
            byte[] r4 = this.typeAliasBytes.get(r3);
            if (r4 != null) goto L5;
            return null;
        L5:
            ProtoBuf.TypeAlias r5 = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(r4), this.this$0.getC().getComponents().getExtensionRegistryLite());
            if (r5 != null) goto L9;
            return null;
        L9:
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            if (getFunctionNames().contains(r2) == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return this.functions.invoke(r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            return this.typeAliasByName.invoke(r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
            if (getVariableNames().contains(r2) == true) goto L7;
            return CollectionsKt.emptyList();
        L7:
            return this.properties.invoke(r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> r6, DescriptorKindFilter r7, Function1<? super Name, Boolean> r8, LookupLocation r9) {
            Intrinsics.checkNotNullParameter(r6, "result");
            Intrinsics.checkNotNullParameter(r7, "kindFilter");
            Intrinsics.checkNotNullParameter(r8, "nameFilter");
            Intrinsics.checkNotNullParameter(r9, BatteryTypeInf.BATTERY_LOC_API);
            if (r7.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L12;
            Set<Name> r0 = getVariableNames();
            ArrayList r2 = new ArrayList();
            Iterator<Name> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            Name r3 = r1.next();
            if (r8.invoke(r3).booleanValue() == false) goto L6;
            r2.addAll(getContributedVariables(r3, r9));
            goto L6
        L10:
            MemberComparator.NameAndTypeMemberComparator r4 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r4, "INSTANCE");
            CollectionsKt.sortWith(r2, r4);
            r6.addAll(r2);
        L12:
            if (r7.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L31;
            Set<Name> r10 = getFunctionNames();
            ArrayList r5 = new ArrayList();
            Iterator<Name> r11 = r10.iterator();
        L15:
            if (r11.hasNext() == false) goto L19;
            Name r12 = r11.next();
            if (r8.invoke(r12).booleanValue() == false) goto L15;
            r5.addAll(getContributedFunctions(r12, r9));
            goto L15
        L19:
            MemberComparator.NameAndTypeMemberComparator r13 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(r13, "INSTANCE");
            CollectionsKt.sortWith(r5, r13);
            r6.addAll(r5);
            return;
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> r7) {
            LinkedHashMap r6 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));
            Iterator<T> r8 = r7.entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L10;
            Map.Entry r0 = (Map.Entry) r8.next();
            Object r1 = r0.getKey();
            ByteArrayOutputStream r2 = new ByteArrayOutputStream();
            Iterable r3 = (Iterable) r0.getValue();
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r5 = r3.iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            ((AbstractMessageLite) r5.next()).writeDelimitedTo(r2);
            r4.add(Unit.INSTANCE);
            goto L7
        L9:
            r6.put(r1, r2.toByteArray());
            goto L4
        L10:
            return r6;
        }
    }

    protected abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> r1, Function1<? super Name, Boolean> r2);

    protected void computeNonDeclaredFunctions(Name r1, List<SimpleFunctionDescriptor> r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "functions");
    }

    protected void computeNonDeclaredProperties(Name r1, List<PropertyDescriptor> r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "descriptors");
    }

    protected abstract ClassId createClassId(Name r1);

    protected abstract Set<Name> getNonDeclaredClassifierNames();

    protected abstract Set<Name> getNonDeclaredFunctionNames();

    protected abstract Set<Name> getNonDeclaredVariableNames();

    protected boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "function");
        return true;
    }

    public static final /* synthetic */ Implementation access$getImpl$p(DeserializedMemberScope r0) {
        return r0.impl;
    }

    protected final DeserializationContext getC() {
        return this.c;
    }

    protected DeserializedMemberScope(DeserializationContext r2, List<ProtoBuf.Function> r3, List<ProtoBuf.Property> r4, List<ProtoBuf.TypeAlias> r5, final Function0<? extends Collection<Name>> r6) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "functionList");
        Intrinsics.checkNotNullParameter(r4, "propertyList");
        Intrinsics.checkNotNullParameter(r5, "typeAliasList");
        Intrinsics.checkNotNullParameter(r6, "classNames");
        this.c = r2;
        this.impl = createImplementation(r3, r4, r5);
        this.classNames$delegate = r2.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(r6));
        this.classifierNamesLazy$delegate = r2.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return this.impl.getContributedFunctions(r2, r3);
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name r1) {
        return this.impl.getTypeAliasByName(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        return this.impl.getContributedVariables(r2, r3);
    }

    protected final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r6, "nameFilter");
        Intrinsics.checkNotNullParameter(r7, BatteryTypeInf.BATTERY_LOC_API);
        ArrayList r0 = new ArrayList(0);
        if (r5.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        addEnumEntryDescriptors(r0, r6);
    L5:
        ArrayList r2 = r0;
        this.impl.addFunctionsAndPropertiesTo(r2, r5, r6, r7);
        if (r5.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()) == false) goto L14;
        Iterator<Name> r8 = getClassNames$deserialization().iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        Name r1 = r8.next();
        if (r6.invoke(r1).booleanValue() == false) goto L9;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r2, deserializeClass(r1));
    L14:
        if (r5.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK()) == false) goto L22;
        Iterator<Name> r9 = this.impl.getTypeAliasNames().iterator();
    L17:
        if (r9.hasNext() == false) goto L22;
        Name r10 = r9.next();
        if (r6.invoke(r10).booleanValue() == false) goto L17;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r2, this.impl.getTypeAliasByName(r10));
    L22:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        if (hasClass(r2) == false) goto L6;
        return deserializeClass(r2);
    L6:
        if (this.impl.getTypeAliasNames().contains(r2) == true) goto L11;
        return null;
    L11:
        return getTypeAliasByName(r2);
    }

    private final ClassDescriptor deserializeClass(Name r2) {
        return this.c.getComponents().deserializeClass(createClassId(r2));
    }

    protected boolean hasClass(Name r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return getClassNames$deserialization().contains(r2);
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> r2, List<ProtoBuf.Property> r3, List<ProtoBuf.TypeAlias> r4) {
        if (this.c.getComponents().getConfiguration().getPreserveDeclarationsOrdering() == false) goto L6;
        return new NoReorderImplementation(this, r2, r3, r4);
    L6:
        return new OptimizedImplementation(this, r2, r3, r4);
    }
}
