package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue allDescriptors$delegate;
    private final ClassDescriptor containingClass;

    protected abstract List<FunctionDescriptor> computeDeclaredFunctions();

    public static final /* synthetic */ List access$createFakeOverrides(GivenFunctionsMemberScope r0, List r1) {
        return r0.createFakeOverrides(r1);
    }

    protected final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    public GivenFunctionsMemberScope(StorageManager r2, ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "containingClass");
        this.containingClass = r3;
        this.allDescriptors$delegate = r2.createLazyValue(new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List) StorageKt.getValue(this.allDescriptors$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        if (r2.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return getAllDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r3, LookupLocation r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, BatteryTypeInf.BATTERY_LOC_API);
        List<DeclarationDescriptor> r2 = getAllDescriptors();
        SmartList r5 = new SmartList();
        Iterator<T> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if ((r0 instanceof SimpleFunctionDescriptor) == false) goto L4;
        if (Intrinsics.areEqual(((SimpleFunctionDescriptor) r0).getName(), r3) == false) goto L4;
        r5.add(r0);
        goto L4
    L10:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r3, LookupLocation r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, BatteryTypeInf.BATTERY_LOC_API);
        List<DeclarationDescriptor> r2 = getAllDescriptors();
        SmartList r5 = new SmartList();
        Iterator<T> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if ((r0 instanceof PropertyDescriptor) == false) goto L4;
        if (Intrinsics.areEqual(((PropertyDescriptor) r0).getName(), r3) == false) goto L4;
        r5.add(r0);
        goto L4
    L10:
        return r5;
    }

    private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> r12) {
        final ArrayList r0 = new ArrayList(3);
        Collection<KotlinType> r2 = this.containingClass.getTypeConstructor().mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r2, "containingClass.typeConstructor.supertypes");
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        CollectionsKt.addAll(r3, ResolutionScope.DefaultImpls.getContributedDescriptors$default(((KotlinType) r4.next()).getMemberScope(), null, null, 3, null));
        goto L4
    L6:
        ArrayList r1 = new ArrayList();
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if ((r6 instanceof CallableMemberDescriptor) == false) goto L8;
        r1.add(r6);
        goto L8
    L12:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        Name r10 = ((CallableMemberDescriptor) r9).getName();
        Object r11 = r7.get(r10);
        if (r11 != null) goto L18;
        r11 = (List) new ArrayList();
        r7.put(r10, r11);
    L18:
        ((List) r11).add(r9);
        goto L14
    L19:
        Iterator r13 = r7.entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L44;
        Map.Entry r14 = (Map.Entry) r13.next();
        Name r15 = (Name) r14.getKey();
        List r16 = (List) r14.getValue();
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r16.iterator();
    L24:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        Boolean r20 = Boolean.valueOf(((CallableMemberDescriptor) r19) instanceof FunctionDescriptor);
        Object r21 = r17.get(r20);
        if (r21 != null) goto L28;
        r21 = (List) new ArrayList();
        r17.put(r20, r21);
    L28:
        ((List) r21).add(r19);
        goto L24
    L29:
        Iterator r22 = r17.entrySet().iterator();
    L31:
        if (r22.hasNext() == false) goto L21;
        Map.Entry r23 = (Map.Entry) r22.next();
        boolean r24 = ((Boolean) r23.getKey()).booleanValue();
        List r25 = (List) r23.getValue();
        OverridingUtil r26 = OverridingUtil.DEFAULT;
        List r27 = r25;
        if (r24 == false) goto L41;
        ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r12.iterator();
    L36:
        if (r29.hasNext() == false) goto L40;
        Object r30 = r29.next();
        if (Intrinsics.areEqual(((FunctionDescriptor) r30).getName(), r15) == false) goto L36;
        r28.add(r30);
        goto L36
    L40:
        ArrayList r31 = r28;
    L42:
        r26.generateOverridesInFunctionGroup(r15, r27, r31, this.containingClass, new AnonymousClass4(r0, this));
        goto L31
    L41:
        r31 = CollectionsKt.emptyList();
        goto L42
    L44:
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(r0);
    }
}
