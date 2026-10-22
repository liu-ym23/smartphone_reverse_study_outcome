package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;

/* JADX INFO: compiled from: KCallables.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a9\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0016H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "getInstanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findParameterByName", "name", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KCallables {

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: KCallables.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0}, l = {56}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspendBy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: KCallables.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", "args", "kCallable"}, s = {"L$0", "L$1", "L$2"})
    static final class C04601<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04601(Continuation<? super C04601> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspendBy(null, null, this);
        }
    }

    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable r0) {
    }

    public static /* synthetic */ void getInstanceParameter$annotations(KCallable r0) {
    }

    public static /* synthetic */ void getValueParameters$annotations(KCallable r0) {
    }

    public static final KParameter getInstanceParameter(KCallable<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Iterator<T> r9 = r8.getParameters().iterator();
        Object r0 = null;
        Object r3 = null;
        boolean r2 = false;
    L4:
        if (r9.hasNext() == false) goto L13;
        Object r4 = r9.next();
        if (((KParameter) r4).getKind() != KParameter.Kind.INSTANCE) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        if (r2 == true) goto L17;
        r3 = r4;
        r2 = true;
    L17:
        return (KParameter) r0;
    L8:
        r5 = false;
        goto L9
    L13:
        if (r2 == false) goto L17;
        r0 = r3;
        goto L17
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Iterator<T> r9 = r8.getParameters().iterator();
        Object r0 = null;
        Object r3 = null;
        boolean r2 = false;
    L4:
        if (r9.hasNext() == false) goto L13;
        Object r4 = r9.next();
        if (((KParameter) r4).getKind() != KParameter.Kind.EXTENSION_RECEIVER) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        if (r2 == true) goto L17;
        r3 = r4;
        r2 = true;
    L17:
        return (KParameter) r0;
    L8:
        r5 = false;
        goto L9
    L13:
        if (r2 == false) goto L17;
        r0 = r3;
        goto L17
    }

    public static final List<KParameter> getValueParameters(KCallable<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List<KParameter> r5 = r4.getParameters();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r1 = r6.next();
        if (((KParameter) r1).getKind() != KParameter.Kind.VALUE) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L12:
        return r0;
    }

    public static final KParameter findParameterByName(KCallable<?> r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "name");
        Iterator<T> r7 = r5.getParameters().iterator();
        Object r0 = null;
        boolean r1 = false;
        Object r2 = null;
    L4:
        if (r7.hasNext() == false) goto L10;
        Object r3 = r7.next();
        if (Intrinsics.areEqual(((KParameter) r3).getName(), r6) == false) goto L4;
        if (r1 == true) goto L14;
        r1 = true;
        r2 = r3;
    L14:
        return (KParameter) r0;
    L10:
        if (r1 == false) goto L14;
        r0 = r2;
        goto L14
    }

    public static final <R> Object callSuspend(KCallable<? extends R> r4, Object[] r5, Continuation<? super R> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Object[] r8 = (Object[]) r0.L$1;
        r4 = (KCallable) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L26:
        if (Intrinsics.areEqual(r4.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) == true) goto L28;
    L31:
        return r7;
    L28:
        if (r4.getReturnType().isMarkedNullable() == true) goto L31;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (r4.isSuspend() == true) goto L19;
        return r4.call(Arrays.copyOf(r5, r5.length));
    L19:
        if ((r4 instanceof KFunction) == false) goto L33;
        r0.L$0 = r4;
        r0.L$1 = r5;
        r0.label = 1;
        AnonymousClass1 r3 = r0;
        SpreadBuilder r9 = new SpreadBuilder(2);
        r9.addSpread(r5);
        r9.add(r3);
        r7 = r4.call(r9.toArray(new Object[r9.size()]));
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L23:
        if (r7 != r1) goto L26;
        return r1;
    L33:
        throw new IllegalArgumentException("Cannot callSuspend on a property " + r4 + ": suspend properties are not supported yet");
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    public static final <R> Object callSuspendBy(KCallable<? extends R> r4, Map<KParameter, ? extends Object> r5, Continuation<? super R> r6) {
        if ((r6 instanceof C04601) == false) goto L7;
        C04601 r0 = (C04601) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        KCallableImpl r8 = (KCallableImpl) r0.L$2;
        Map r9 = (Map) r0.L$1;
        r4 = (KCallable) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L28:
        if (Intrinsics.areEqual(r4.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) == true) goto L30;
    L33:
        return r7;
    L30:
        if (r4.getReturnType().isMarkedNullable() == true) goto L33;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (r4.isSuspend() == true) goto L19;
        return r4.callBy(r5);
    L19:
        if ((r4 instanceof KFunction) == false) goto L37;
        KCallableImpl<?> r10 = UtilKt.asKCallableImpl(r4);
        if (r10 == null) goto L35;
        r0.L$0 = r4;
        r0.L$1 = r5;
        r0.L$2 = r10;
        r0.label = 1;
        C04601 r3 = r0;
        r7 = r10.callDefaultMethod$kotlin_reflection(r5, r3);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L25:
        if (r7 != r1) goto L28;
        return r1;
    L35:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + r4);
    L37:
        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + r4 + ": suspend properties are not supported yet");
    L7:
        r0 = new C04601(r6);
        goto L8
    }
}
