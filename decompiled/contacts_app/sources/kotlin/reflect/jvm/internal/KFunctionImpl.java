package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;

/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J.\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00106\u001a\u00020)H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u00105\u001a\u000209H\u0002J\u0013\u0010<\u001a\u00020)2\b\u0010=\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "isDefault", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazyVal caller$delegate;
    private final KDeclarationContainerImpl container;
    private final ReflectProperties.LazyVal defaultCaller$delegate;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final Object rawBoundReceiver;
    private final String signature;

    public static final /* synthetic */ CallerImpl access$createConstructorCaller(KFunctionImpl r0, Constructor r1, FunctionDescriptor r2, boolean r3) {
        return r0.createConstructorCaller(r1, r2, r3);
    }

    public static final /* synthetic */ CallerImpl.Method access$createInstanceMethodCaller(KFunctionImpl r0, Method r1) {
        return r0.createInstanceMethodCaller(r1);
    }

    public static final /* synthetic */ CallerImpl.Method access$createJvmStaticInObjectCaller(KFunctionImpl r0, Method r1) {
        return r0.createJvmStaticInObjectCaller(r1);
    }

    public static final /* synthetic */ CallerImpl.Method access$createStaticMethodCaller(KFunctionImpl r0, Method r1) {
        return r0.createStaticMethodCaller(r1);
    }

    public static final /* synthetic */ String access$getSignature$p(KFunctionImpl r0) {
        return r0.signature;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getDescriptor() {
        return getDescriptor();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r1) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object r1, Object r2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object r1, Object r2, Object r3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3);
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // kotlin.jvm.functions.Function18
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // kotlin.jvm.functions.Function19
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // kotlin.jvm.functions.Function20
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    @Override // kotlin.jvm.functions.Function21
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object r2, Object r3, Object r4, Object r5, Object r6, Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18, Object r19, Object r20, Object r21, Object r22, Object r23) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl r7, String r8, String r9, FunctionDescriptor r10, Object r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = CallableReference.NO_RECEIVER;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    private KFunctionImpl(KDeclarationContainerImpl r1, final String r2, String r3, FunctionDescriptor r4, Object r5) {
        this.container = r1;
        this.signature = r3;
        this.rawBoundReceiver = r5;
        this.descriptor$delegate = ReflectProperties.lazySoft(r4, new KFunctionImpl$descriptor$2(this, r2));
        this.caller$delegate = ReflectProperties.lazy(new KFunctionImpl$caller$2(this));
        this.defaultCaller$delegate = ReflectProperties.lazy(new KFunctionImpl$defaultCaller$2(this));
    }

    public KFunctionImpl(KDeclarationContainerImpl r8, String r9, String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r8, "container");
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "signature");
        this(r8, r9, r10, null, r11);
    }

    public KFunctionImpl(KDeclarationContainerImpl r10, FunctionDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        String r3 = r11.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r3, "descriptor.name.asString()");
        this(r10, r3, RuntimeTypeMapper.INSTANCE.mapSignature(r11).asString(), r11, null, 16, null);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        T r3 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(r3, "<get-descriptor>(...)");
        return (FunctionDescriptor) r3;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String r1 = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "descriptor.name.asString()");
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getCaller() {
        T r3 = this.caller$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(r3, "<get-caller>(...)");
        return (Caller) r3;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller$delegate.getValue(this, $$delegatedProperties[2]);
    }

    private final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    private final CallerImpl.Method createStaticMethodCaller(Method r2) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundStatic(r2, getBoundReceiver());
    L6:
        return new CallerImpl.Method.Static(r2);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method r1) {
        if (isBound() == false) goto L5;
        CallerImpl.Method r0 = new CallerImpl.Method.BoundJvmStaticInObject(r1);
    L7:
        return r0;
    L5:
        r0 = new CallerImpl.Method.JvmStaticInObject(r1);
        goto L7
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method r2) {
        if (isBound() == false) goto L6;
        return new CallerImpl.Method.BoundInstance(r2, getBoundReceiver());
    L6:
        return new CallerImpl.Method.Instance(r2);
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> r1, FunctionDescriptor r2, boolean r3) {
        if (r3 == true) goto L10;
        if (InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters(r2) == false) goto L10;
        if (isBound() == false) goto L15;
        return new CallerImpl.AccessorForHiddenBoundConstructor(r1, getBoundReceiver());
    L15:
        return new CallerImpl.AccessorForHiddenConstructor(r1);
    L10:
        if (isBound() == false) goto L13;
        return new CallerImpl.BoundConstructor(r1, getBoundReceiver());
    L13:
        return new CallerImpl.Constructor(r1);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public boolean equals(Object r4) {
        KFunctionImpl r5 = UtilKt.asKFunctionImpl(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getContainer(), r5.getContainer()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getName(), r5.getName()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signature, r5.signature) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawBoundReceiver, r5.rawBoundReceiver) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }
}
