package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.oui.dialog.base.AbstractDialog;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ah\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\b\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\b\u0019\u001ac\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c23\b\u0002\u0010\u001d\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a}\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001d\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0!¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ErrorsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0}, l = {AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT}, m = "catchImpl", n = {"fromDownstream"}, s = {"L$0"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.catchImpl(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $collector;
        final /* synthetic */ Ref.ObjectRef<Throwable> $fromDownstream;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(FlowCollector<? super T> r1, Ref.ObjectRef<Throwable> r2) {
            this.$collector = r1;
            this.$fromDownstream = r2;
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r5, Continuation<? super Unit> r6) {
            if ((r6 instanceof FlowKt__ErrorsKt$catchImpl$2$emit$1) == false) goto L7;
            FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) r6;
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L16;
            if (r2 != 1) goto L15;
            AnonymousClass2 r4 = (AnonymousClass2) r0.L$0;
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L22
        L20:
            AnonymousClass2<T> this = (AnonymousClass2<T>) Unit.INSTANCE;
            return this;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r7);
            FlowCollector<T> r8 = this.$collector;     // Catch: Throwable -> L22
            r0.L$0 = this;     // Catch: Throwable -> L22
            r0.label = 1;     // Catch: Throwable -> L22
            if (r8.emit(r5, r0) != r1) goto L20;
            return r1;
        L22:
            th = move-exception;
            r5 = (T) th;
            this.$fromDownstream.element = r5;
            throw r5;
        L7:
            r0 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, r6);
            goto L8
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05631 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {
        int label;

        C05631(Continuation<? super C05631> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C05631(r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Throwable r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Throwable r1, Continuation<? super Boolean> r2) {
            return ((C05631) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            return Boxing.boxBoolean(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3, reason: invalid class name */
    /* JADX INFO: compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3<T> extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ long $retries;
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(long r1, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r3, Continuation<? super AnonymousClass3> r4) {
            this.$retries = r1;
            this.$predicate = r3;
            super(4, r4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object r7, Throwable r8, Long r9, Continuation<? super Boolean> r10) {
            return invoke((FlowCollector) r7, r8, r9.longValue(), r10);
        }

        public final Object invoke(FlowCollector<? super T> r3, Throwable r4, long r5, Continuation<? super Boolean> r7) {
            AnonymousClass3 r6 = new AnonymousClass3(this.$retries, this.$predicate, r7);
            r6.L$0 = r4;
            r6.J$0 = r5;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L14:
            if (((Boolean) r8).booleanValue() == true) goto L18;
        L16:
            r2 = false;
        L18:
            return Boxing.boxBoolean(r2);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Throwable r9 = (Throwable) this.L$0;
            if (this.J$0 >= this.$retries) goto L16;
            Function2<Throwable, Continuation<? super Boolean>, Object> r3 = this.$predicate;
            this.label = 1;
            r8 = r3.invoke(r9, this);
            if (r8 != r0) goto L14;
            return r0;
        }
    }

    public static /* synthetic */ Flow retry$default(Flow r0, long r1, C05631 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = Long.MAX_VALUE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = new C05631(null);
    L9:
        return FlowKt.retry(r0, r1, r3);
    }

    public static final <T> Flow<T> retry(Flow<? extends T> r2, long r3, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r5) {
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return FlowKt.retryWhen(r2, new AnonymousClass3(r3, r5, null));
    L10:
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Object catchImpl(Flow<? extends T> r4, FlowCollector<? super T> r5, Continuation<? super Throwable> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
        return null;
    L14:
        th = th;
    L26:
        Throwable r9 = (Throwable) r8.element;
        if (isSameExceptionAs$FlowKt__ErrorsKt(th, r9) == false) goto L29;
    L38:
        throw th;
    L29:
        if (isCancellationCause$FlowKt__ErrorsKt(th, r0.getContext()) == true) goto L38;
        if (r9 != null) goto L33;
        return th;
    L33:
        if ((th instanceof CancellationException) == false) goto L36;
        ExceptionsKt.addSuppressed(r9, th);
        throw r9;
    L36:
        ExceptionsKt.addSuppressed(th, r9);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        FlowCollector<? super Object> r3 = new AnonymousClass2(r5, r10);     // Catch: Throwable -> L24
        r0.L$0 = r10;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        if (r4.collect(r3, r0) != r1) goto L22;
        return r1;
    L22:
        return null;
    L24:
        th = th;
        r8 = r10;
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable r1, CoroutineContext r2) {
        Job r3 = (Job) r2.get(Job.Key);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isCancelled() == true) goto L8;
        return false;
    L8:
        return isSameExceptionAs$FlowKt__ErrorsKt(r1, r3.getCancellationException());
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m2361catch(Flow<? extends T> r1, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(r1, r2);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> r1, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> r2) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(r1, r2);
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable r1, Throwable r2) {
        if (r2 != null) goto L4;
    L14:
        return false;
    L4:
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L8;
        r2 = StackTraceRecoveryKt.unwrapImpl(r2);
    L8:
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L12;
        r1 = StackTraceRecoveryKt.unwrapImpl(r1);
    L12:
        if (Intrinsics.areEqual(r2, r1) == false) goto L14;
        return true;
    }
}
