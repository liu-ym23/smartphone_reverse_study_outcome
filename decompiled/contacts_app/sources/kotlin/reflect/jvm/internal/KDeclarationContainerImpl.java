package kotlin.reflect.jvm.internal;

import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.TraceStatsConsts;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", TraceStatsConsts.STATS_KEY_END, "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = null;
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = null;
    private static final Regex LOCAL_PROPERTY_SIGNATURE = null;

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.access$getLOCAL_PROPERTY_SIGNATURE$cp();
        }
    }

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final ReflectProperties.LazySoftVal moduleData$delegate;
        final /* synthetic */ KDeclarationContainerImpl this$0;

        public Data(final KDeclarationContainerImpl r2) {
            this.this$0 = r2;
            this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(r2));
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            T r3 = this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(r3, "<get-moduleData>(...)");
            return (RuntimeModuleData) r3;
        }
    }

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    protected static final enum MemberBelonginess extends Enum<MemberBelonginess> {
        private static final /* synthetic */ MemberBelonginess[] $VALUES = null;
        public static final MemberBelonginess DECLARED = null;
        public static final MemberBelonginess INHERITED = null;

        private static final /* synthetic */ MemberBelonginess[] $values() {
            return new MemberBelonginess[]{DECLARED, INHERITED};
        }

        public static MemberBelonginess valueOf(String r1) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, r1);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        private MemberBelonginess(String r1, int r2) {
            super(r1, r2);
        }

        static {
            DECLARED = new MemberBelonginess("DECLARED", 0);
            INHERITED = new MemberBelonginess("INHERITED", 1);
            $VALUES = $values();
        }

        public final boolean accept(CallableMemberDescriptor r4) {
            Intrinsics.checkNotNullParameter(r4, "member");
            boolean r5 = r4.getKind().isReal();
            if (this != DECLARED) goto L5;
            boolean r3 = true;
        L6:
            if (r5 != r3) goto L9;
            return true;
        L9:
            return false;
        L5:
            r3 = false;
            goto L6
        }
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name r1);

    public abstract PropertyDescriptor getLocalProperty(int r1);

    public abstract Collection<PropertyDescriptor> getProperties(Name r1);

    public KDeclarationContainerImpl() {
    }

    public static final /* synthetic */ Regex access$getLOCAL_PROPERTY_SIGNATURE$cp() {
        return LOCAL_PROPERTY_SIGNATURE;
    }

    protected Class<?> getMethodOwner() {
        Class<?> r0 = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getJClass();
    }

    protected final Collection<KCallableImpl<?>> getMembers(MemberScope r7, MemberBelonginess r8) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "belonginess");
        CreateKCallableVisitor r0 = new KDeclarationContainerImpl$getMembers$visitor$1(this);
        Collection r6 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r7, null, null, 3, null);
        ArrayList r9 = new ArrayList();
        Iterator r10 = r6.iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        DeclarationDescriptor r2 = (DeclarationDescriptor) r10.next();
        if ((r2 instanceof CallableMemberDescriptor) == false) goto L12;
        CallableMemberDescriptor r3 = (CallableMemberDescriptor) r2;
        if (Intrinsics.areEqual(r3.getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) == true) goto L12;
        if (r8.accept(r3) == false) goto L12;
        KCallableImpl r4 = (KCallableImpl) r2.accept(r0, Unit.INSTANCE);
    L13:
        if (r4 == null) goto L4;
        r9.add(r4);
    L12:
        r4 = null;
        goto L13
    L16:
        return CollectionsKt.toList(r9);
    }

    public final PropertyDescriptor findPropertyDescriptor(String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "name");
        Intrinsics.checkNotNullParameter(r21, "signature");
        MatchResult r3 = LOCAL_PROPERTY_SIGNATURE.matchEntire(r21);
        boolean r4 = true;
        if (r3 == null) goto L9;
        String r1 = r3.getDestructured().getMatch().getGroupValues().get(1);
        PropertyDescriptor r2 = getLocalProperty(Integer.parseInt(r1));
        if (r2 == null) goto L8;
        return r2;
    L8:
        throw new KotlinReflectionInternalError("Local property #" + r1 + " not found in " + getJClass());
    L9:
        Name r5 = Name.identifier(r20);
        Intrinsics.checkNotNullExpressionValue(r5, "identifier(name)");
        Collection<PropertyDescriptor> r6 = getProperties(r5);
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) r9).asString(), r21) == false) goto L11;
        r7.add(r9);
        goto L11
    L15:
        ArrayList r10 = r7;
        if (r10.isEmpty() == true) goto L42;
        if (r10.size() == 1) goto L40;
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.iterator();
    L21:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();
        DescriptorVisibility r14 = ((PropertyDescriptor) r13).getVisibility();
        Object r15 = r11.get(r14);
        if (r15 != null) goto L25;
        r15 = (List) new ArrayList();
        r11.put(r14, r15);
    L25:
        ((List) r15).add(r13);
        goto L21
    L26:
        Collection r16 = MapsKt.toSortedMap(r11, KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2.INSTANCE).values();
        Intrinsics.checkNotNullExpressionValue(r16, "properties\n             …\n                }.values");
        List r17 = (List) CollectionsKt.last(r16);
        if (r17.size() != 1) goto L30;
        Intrinsics.checkNotNullExpressionValue(r17, "mostVisibleProperties");
        return (PropertyDescriptor) CollectionsKt.first(r17);
    L30:
        Name r18 = Name.identifier(r20);
        Intrinsics.checkNotNullExpressionValue(r18, "identifier(name)");
        String r19 = CollectionsKt.joinToString$default(getProperties(r18), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, null);
        StringBuilder r0 = new StringBuilder("Property '").append(r20).append("' (JVM signature: ").append(r21).append(") not resolved in ").append(this).append(':');
        if (r19.length() == 0) goto L34;
        r4 = false;
    L34:
        if (r4 == false) goto L36;
        String r22 = " no members found";
    L38:
        throw new KotlinReflectionInternalError(r0.append(r22).toString());
    L36:
        r22 = "\n" + r19;
        goto L38
    L40:
        return (PropertyDescriptor) CollectionsKt.single(r10);
    L42:
        throw new KotlinReflectionInternalError("Property '" + r20 + "' (JVM signature: " + r21 + ") not resolved in " + this);
    }

    public final FunctionDescriptor findFunctionDescriptor(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "name");
        Intrinsics.checkNotNullParameter(r13, "signature");
        if (Intrinsics.areEqual(r12, "<init>") == false) goto L5;
        List r0 = CollectionsKt.toList(getConstructorDescriptors());
    L6:
        Collection<FunctionDescriptor> r1 = r0;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) r4).asString(), r13) == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        ArrayList r5 = r2;
        boolean r10 = true;
        if (r5.size() == 1) goto L24;
        String r6 = CollectionsKt.joinToString$default(r1, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, null);
        StringBuilder r11 = new StringBuilder("Function '").append(r12).append("' (JVM signature: ").append(r13).append(") not resolved in ").append(this).append(':');
        if (r6.length() == 0) goto L18;
        r10 = false;
    L18:
        if (r10 == false) goto L20;
        String r14 = " no members found";
    L22:
        throw new KotlinReflectionInternalError(r11.append(r14).toString());
    L20:
        r14 = "\n" + r6;
        goto L22
    L24:
        return (FunctionDescriptor) CollectionsKt.single(r5);
    L5:
        Name r7 = Name.identifier(r12);
        Intrinsics.checkNotNullExpressionValue(r7, "identifier(name)");
        r0 = getFunctions(r7);
        goto L6
    }

    private final Method lookupMethod(Class<?> r11, String r12, Class<?>[] r13, Class<?> r14, boolean r15) {
        if (r15 == false) goto L5;
        r13[0] = r11;
    L5:
        Method r1 = tryGetMethod(r11, r12, r13, r14);
        if (r1 == null) goto L8;
        return r1;
    L8:
        Class<? super Object> r3 = r11.getSuperclass();
        if (r3 == null) goto L13;
        Method r2 = lookupMethod(r3, r12, r13, r14, r15);
        if (r2 == null) goto L13;
        return r2;
    L13:
        Class<?>[] r16 = r11.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r16, "interfaces");
        int r4 = r16.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L25;
        Class<?> r9 = r16[r5];
        Intrinsics.checkNotNullExpressionValue(r9, "superInterface");
        Method r6 = lookupMethod(r9, r12, r13, r14, r15);
        if (r6 != null) goto L17;
        if (r15 == false) goto L24;
        Class<?> r7 = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(r9), r9.getName() + "$DefaultImpls");
        if (r7 == null) goto L24;
        r13[0] = r9;
        Method r8 = tryGetMethod(r7, r12, r13, r14);
        if (r8 == null) goto L24;
        return r8;
    L24:
        r5 = r5 + 1;
        goto L14
    L17:
        return r6;
    L25:
        return null;
    }

    private final Method tryGetMethod(Class<?> r7, String r8, Class<?>[] r9, Class<?> r10) {
        Method r0 = r7.getDeclaredMethod(r8, (Class[]) Arrays.copyOf(r9, r9.length));     // Catch: NoSuchMethodException -> L22
        if (Intrinsics.areEqual(r0.getReturnType(), r10) == true) goto L28;
        Method[] r11 = r7.getDeclaredMethods();     // Catch: NoSuchMethodException -> L22
        Intrinsics.checkNotNullExpressionValue(r11, "declaredMethods");     // Catch: NoSuchMethodException -> L22
        Method[] r12 = r11;     // Catch: NoSuchMethodException -> L22
        int r1 = r12.length;     // Catch: NoSuchMethodException -> L22
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L19;
        Method r3 = r12[r2];     // Catch: NoSuchMethodException -> L22
        Method r4 = r3;     // Catch: NoSuchMethodException -> L22
        if (Intrinsics.areEqual(r4.getName(), r8) == true) goto L11;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L20;
        r2 = r2 + 1;     // Catch: NoSuchMethodException -> L22
    L20:
        return r3;
    L11:
        if (Intrinsics.areEqual(r4.getReturnType(), r10) == false) goto L15;
        if (Arrays.equals(r4.getParameterTypes(), r9) == false) goto L15;
        r5 = true;
        goto L16
    L19:
        r3 = null;
        goto L20
    L28:
        return r0;
    L22:
        Method r13 = (Method) null;
        return null;
    }

    private final Constructor<?> tryGetConstructor(Class<?> r1, List<? extends Class<?>> r2) {
        Object[] r0 = r2.toArray(new Class[0]);     // Catch: NoSuchMethodException -> L4
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: NoSuchMethodException -> L4
        Class[] r3 = (Class[]) r0;     // Catch: NoSuchMethodException -> L4
        return r1.getDeclaredConstructor((Class[]) Arrays.copyOf(r3, r3.length));
    L4:
        Constructor r4 = (Constructor) null;
        return null;
    }

    public final Method findMethodBySignature(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L5;
        return null;
    L5:
        Object[] r0 = loadParameterTypes(r11).toArray(new Class[0]);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Class<?>[] r1 = (Class[]) r0;
        Class<?> r12 = loadReturnType(r11);
        Method r2 = lookupMethod(getMethodOwner(), r10, r1, r12, false);
        if (r2 == null) goto L9;
        return r2;
    L9:
        if (getMethodOwner().isInterface() == false) goto L13;
        Method r9 = lookupMethod(Object.class, r10, r1, r12, false);
        if (r9 == null) goto L13;
        return r9;
    L13:
        return null;
    }

    public final Method findDefaultMethod(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        if (r12 == false) goto L9;
        r0.add(getJClass());
    L9:
        addParametersAndMasks(r0, r11, false);
        Class<?> r4 = getMethodOwner();
        String r5 = r10 + "$default";
        Object[] r13 = r0.toArray(new Class[0]);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return lookupMethod(r4, r5, (Class[]) r13, loadReturnType(r11), r12);
    }

    public final Constructor<?> findConstructorBySignature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(r2));
    }

    public final Constructor<?> findDefaultConstructor(String r4) {
        Intrinsics.checkNotNullParameter(r4, "desc");
        Class<?> r0 = getJClass();
        ArrayList r1 = new ArrayList();
        addParametersAndMasks(r1, r4, true);
        Unit r5 = Unit.INSTANCE;
        return tryGetConstructor(r0, r1);
    }

    private final void addParametersAndMasks(List<Class<?>> r3, String r4, boolean r5) {
        List<Class<?>> r2 = loadParameterTypes(r4);
        r3.addAll(r2);
        int r6 = ((r2.size() + 32) - 1) / 32;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        Class<?> r0 = Integer.TYPE;
        Intrinsics.checkNotNullExpressionValue(r0, VCardConstants.PARAM_TYPE);
        r3.add(r0);
        r7 = r7 + 1;
        goto L3
    L5:
        if (r5 == false) goto L7;
        Class<?> r8 = DEFAULT_CONSTRUCTOR_MARKER;
        r3.remove(r8);
        Intrinsics.checkNotNullExpressionValue(r8, "DEFAULT_CONSTRUCTOR_MARKER");
        r3.add(r8);
        return;
    L7:
        r3.add(Object.class);
    }

    private final List<Class<?>> loadParameterTypes(String r10) {
        ArrayList r0 = new ArrayList();
        int r8 = 1;
    L4:
        if (r10.charAt(r8) == ')') goto L19;
        int r2 = r8;
    L7:
        if (r10.charAt(r2) != '[') goto L9;
        r2 = r2 + 1;
        goto L7
    L9:
        char r3 = r10.charAt(r2);
        if (StringsKt.contains$default("VZCBSIFJD", r3, false, 2, null) == false) goto L13;
        int r4 = r2 + 1;
    L15:
        r0.add(parseType(r10, r8, r4));
        r8 = r4;
        goto L4
    L13:
        if (r3 != 'L') goto L17;
        r4 = StringsKt.indexOf$default(r10, ';', r8, false, 4, null) + 1;
        goto L15
    L17:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + r10);
    L19:
        return r0;
    }

    private final Class<?> parseType(String r7, int r8, int r9) {
        char r0 = r7.charAt(r8);
        if (r0 != 'L') goto L6;
        ClassLoader r6 = ReflectClassUtilKt.getSafeClassLoader(getJClass());
        String r1 = r7.substring(r8 + 1, r9 - 1);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");
        Class<?> r10 = r6.loadClass(StringsKt.replace$default(r1, '/', '.', false, 4, null));
        Intrinsics.checkNotNullExpressionValue(r10, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
        return r10;
    L6:
        if (r0 != '[') goto L9;
        return UtilKt.createArrayType(parseType(r7, r8 + 1, r9));
    L9:
        if (r0 != 'V') goto L12;
        Class<?> r11 = Void.TYPE;
        Intrinsics.checkNotNullExpressionValue(r11, VCardConstants.PARAM_TYPE);
        return r11;
    L12:
        if (r0 != 'Z') goto L15;
        return Boolean.TYPE;
    L15:
        if (r0 != 'C') goto L18;
        return Character.TYPE;
    L18:
        if (r0 != 'B') goto L21;
        return Byte.TYPE;
    L21:
        if (r0 != 'S') goto L24;
        return Short.TYPE;
    L24:
        if (r0 != 'I') goto L27;
        return Integer.TYPE;
    L27:
        if (r0 != 'F') goto L30;
        return Float.TYPE;
    L30:
        if (r0 != 'J') goto L33;
        return Long.TYPE;
    L33:
        if (r0 != 'D') goto L37;
        return Double.TYPE;
    L37:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + r7);
    }

    private final Class<?> loadReturnType(String r7) {
        return parseType(r7, StringsKt.indexOf$default(r7, ')', 0, false, 6, null) + 1, r7.length());
    }

    static {
        Companion = new Companion(null);
        DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
        LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");
    }
}
