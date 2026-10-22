package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* JADX INFO: compiled from: InlineClassAwareCaller.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange r2, Method[] r3, Method r4) {
            Intrinsics.checkNotNullParameter(r2, "argumentRange");
            Intrinsics.checkNotNullParameter(r3, "unbox");
            this.argumentRange = r2;
            this.unbox = r3;
            this.box = r4;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InlineClassAwareCaller(CallableMemberDescriptor r11, Caller<? extends M> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "caller");
        this.caller = r12;
        this.isDefault = r13;
        KotlinType r14 = r11.getReturnType();
        Intrinsics.checkNotNull(r14);
        Class<?> r15 = InlineClassAwareCallerKt.toInlineClass(r14);
        if (r15 == null) goto L5;
        Method r16 = InlineClassAwareCallerKt.getBoxMethod(r15, r11);
    L7:
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r11) == false) goto L9;
        BoxUnboxData r17 = new BoxUnboxData(IntRange.Companion.getEMPTY(), new Method[0], r16);
    L72:
        this.data = r17;
        return;
    L9:
        Caller<M> r0 = this.caller;
        int r4 = -1;
        if ((r0 instanceof CallerImpl.Method.BoundStatic) == false) goto L13;
    L26:
        ArrayList r1 = new ArrayList();
        ReceiverParameterDescriptor r2 = r11.getExtensionReceiverParameter();
        if (r2 == null) goto L29;
        KotlinType r3 = r2.getType();
    L30:
        if (r3 == null) goto L33;
        r1.add(r3);
    L42:
        List<ValueParameterDescriptor> r5 = r11.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "descriptor.valueParameters");
        Iterator<T> r6 = r5.iterator();
    L44:
        if (r6.hasNext() == false) goto L46;
        r1.add(((ValueParameterDescriptor) r6.next()).getType());
        goto L44
    L46:
        ArrayList r7 = r1;
        if (this.isDefault == false) goto L49;
        int r8 = (((r7.size() + 32) - 1) / 32) + 1;
    L51:
        if ((r11 instanceof FunctionDescriptor) == true) goto L53;
    L55:
        int r9 = 0;
    L56:
        int r10 = (r7.size() + r4) + (r8 + r9);
        InlineClassAwareCaller<M> r18 = this;
        if (CallerKt.getArity(r18) != r10) goto L75;
        IntRange r19 = RangesKt.until(Math.max(r4, 0), r7.size() + r4);
        Method[] r20 = new Method[r10];
        int r21 = 0;
    L59:
        if (r21 >= r10) goto L71;
        int r22 = r19.getFirst();
        if (r21 > r19.getLast()) goto L64;
        if (r22 > r21) goto L64;
        boolean r23 = true;
    L65:
        if (r23 == false) goto L69;
        Class<?> r24 = InlineClassAwareCallerKt.toInlineClass((KotlinType) r7.get(r21 - r4));
        if (r24 == null) goto L69;
        Method r25 = InlineClassAwareCallerKt.getUnboxMethod(r24, r11);
    L70:
        r20[r21] = r25;
        r21 = r21 + 1;
    L69:
        r25 = null;
    L64:
        r23 = false;
        goto L65
    L71:
        r17 = new BoxUnboxData(r19, r20, r16);
        goto L72
    L75:
        throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(r18) + " != " + r10 + "\nCalling: " + r11 + "\nParameter types: " + getParameterTypes() + ")\nDefault: " + this.isDefault);
    L53:
        if (((FunctionDescriptor) r11).isSuspend() == false) goto L55;
        r9 = 1;
        goto L56
    L49:
        r8 = 0;
        goto L51
    L33:
        if ((r11 instanceof ConstructorDescriptor) == false) goto L37;
        ClassDescriptor r26 = ((ConstructorDescriptor) r11).getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(r26, "descriptor.constructedClass");
        if (r26.isInner() == false) goto L42;
        DeclarationDescriptor r27 = r26.getContainingDeclaration();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        r1.add(((ClassDescriptor) r27).getDefaultType());
        goto L42
    L37:
        DeclarationDescriptor r28 = r11.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r28, "descriptor.containingDeclaration");
        if ((r28 instanceof ClassDescriptor) == false) goto L42;
        if (InlineClassesUtilsKt.isInlineClass(r28) == false) goto L42;
        r1.add(((ClassDescriptor) r28).getDefaultType());
        goto L42
    L29:
        r3 = null;
        goto L30
    L13:
        if ((r11 instanceof ConstructorDescriptor) == false) goto L18;
        if ((r0 instanceof BoundCaller) == true) goto L26;
    L25:
        r4 = 0;
        goto L26
    L18:
        if (r11.getDispatchReceiverParameter() == null) goto L25;
        if ((this.caller instanceof BoundCaller) == true) goto L25;
        DeclarationDescriptor r29 = r11.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r29, "descriptor.containingDeclaration");
        if (InlineClassesUtilsKt.isInlineClass(r29) == true) goto L25;
        r4 = 1;
        goto L26
    L5:
        r16 = null;
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public M mo2075getMember() {
        return (M) this.caller.mo2075getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        BoxUnboxData r0 = this.data;
        IntRange r1 = r0.component1();
        Method[] r2 = r0.component2();
        Method r3 = r0.component3();
        Object[] r4 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, size)");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int r5 = r1.getFirst();
        int r6 = r1.getLast();
        if (r5 > r6) goto L12;
    L4:
        Method r7 = r2[r5];
        Object r8 = r10[r5];
        if (r7 == null) goto L9;
        if (r8 == null) goto L8;
        r8 = r7.invoke(r8, new Object[0]);
        goto L9
    L8:
        Class<?> r9 = r7.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r9, "method.returnType");
        r8 = UtilKt.defaultPrimitiveValue(r9);
    L9:
        r4[r5] = r8;
        if (r5 == r6) goto L12;
        r5 = r5 + 1;
    L12:
        Object r11 = this.caller.call(r4);
        if (r3 == null) goto L20;
        Object r12 = r3.invoke(null, new Object[]{r11});
        if (r12 != null) goto L18;
        return r11;
    L18:
        return r12;
    L20:
        return r11;
    }
}
