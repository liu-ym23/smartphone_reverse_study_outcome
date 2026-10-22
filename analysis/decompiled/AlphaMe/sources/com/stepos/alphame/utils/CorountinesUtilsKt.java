package com.stepos.alphame.utils;

import Z2.AbstractC0123e0;
import Z2.C0125f0;
import Z2.E;
import Z2.F;
import Z2.G;
import Z2.I;
import Z2.InterfaceC0131i0;
import Z2.Q;
import Z2.o0;
import Z2.x0;
import com.stepos.alphame.awareness.AwarenessDataItem;
import d3.q;
import f3.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001b\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u001b\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\b\u0010\u0004\u001a\u0017\u0010\u000b\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\u0001*\u00020\r¢\u0006\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\"\u0017\u0010\u0017\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lkotlin/Function0;", "", "invoke", "launchInIo", "(Lkotlin/jvm/functions/Function0;)V", "launchInMain", "launchInDefault", "launchInSingleLocationDispatcher", "launchInSingleDispatcher", "", "any", "logX", "(Ljava/lang/Object;)V", "LZ2/o0;", "log", "(LZ2/o0;)V", "LZ2/e0;", "singleDispatcher", "LZ2/e0;", "getSingleDispatcher", "()LZ2/e0;", "singleIoDispatcher", "getSingleIoDispatcher", "singleLocationDispatcher", "getSingleLocationDispatcher", "app_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCorountinesUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CorountinesUtils.kt\ncom/stepos/alphame/utils/CorountinesUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
/* loaded from: classes.dex */
public final class CorountinesUtilsKt {

    @NotNull
    private static final AbstractC0123e0 singleDispatcher;

    @NotNull
    private static final AbstractC0123e0 singleIoDispatcher;

    @NotNull
    private static final AbstractC0123e0 singleLocationDispatcher;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.utils.CorountinesUtilsKt$launchInDefault$1", f = "CorountinesUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.utils.CorountinesUtilsKt$launchInDefault$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $invoke;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$invoke = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$invoke, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$invoke.invoke();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.utils.CorountinesUtilsKt$launchInIo$1", f = "CorountinesUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.utils.CorountinesUtilsKt$launchInIo$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04811 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $invoke;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04811(Function0<Unit> function0, Continuation<? super C04811> continuation) {
            super(2, continuation);
            this.$invoke = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04811(this.$invoke, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04811) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$invoke.invoke();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.utils.CorountinesUtilsKt$launchInMain$1", f = "CorountinesUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.utils.CorountinesUtilsKt$launchInMain$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04821 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $invoke;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04821(Function0<Unit> function0, Continuation<? super C04821> continuation) {
            super(2, continuation);
            this.$invoke = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04821(this.$invoke, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04821) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$invoke.invoke();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.utils.CorountinesUtilsKt$launchInSingleDispatcher$1", f = "CorountinesUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.utils.CorountinesUtilsKt$launchInSingleDispatcher$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04831 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $invoke;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04831(Function0<Unit> function0, Continuation<? super C04831> continuation) {
            super(2, continuation);
            this.$invoke = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04831(this.$invoke, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04831) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$invoke.invoke();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.utils.CorountinesUtilsKt$launchInSingleLocationDispatcher$1", f = "CorountinesUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.utils.CorountinesUtilsKt$launchInSingleLocationDispatcher$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04841 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $invoke;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04841(Function0<Unit> function0, Continuation<? super C04841> continuation) {
            super(2, continuation);
            this.$invoke = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C04841(this.$invoke, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04841) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$invoke.invoke();
            return Unit.INSTANCE;
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new com.stepos.alphame.dailyusage.a(4));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        singleDispatcher = new C0125f0(executorServiceNewSingleThreadExecutor);
        ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor(new com.stepos.alphame.dailyusage.a(5));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor2, "newSingleThreadExecutor(...)");
        singleIoDispatcher = new C0125f0(executorServiceNewSingleThreadExecutor2);
        ExecutorService executorServiceNewSingleThreadExecutor3 = Executors.newSingleThreadExecutor(new com.stepos.alphame.dailyusage.a(6));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor3, "newSingleThreadExecutor(...)");
        singleLocationDispatcher = new C0125f0(executorServiceNewSingleThreadExecutor3);
    }

    @NotNull
    public static final AbstractC0123e0 getSingleDispatcher() {
        return singleDispatcher;
    }

    @NotNull
    public static final AbstractC0123e0 getSingleIoDispatcher() {
        return singleIoDispatcher;
    }

    @NotNull
    public static final AbstractC0123e0 getSingleLocationDispatcher() {
        return singleLocationDispatcher;
    }

    public static final void launchInDefault(@NotNull Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        J.y(G.a(Q.f2189a), null, new AnonymousClass1(invoke, null), 3);
    }

    public static final void launchInIo(@NotNull Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        J.y(G.a(Q.f2190b), null, new C04811(invoke, null), 3);
    }

    public static final void launchInMain(@NotNull Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        d dVar = Q.f2189a;
        J.y(G.a(q.f12477a), null, new C04821(invoke, null), 3);
    }

    public static final void launchInSingleDispatcher(@NotNull Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        J.y(G.a(CoroutineContext.Element.DefaultImpls.plus(I.a(), singleDispatcher).plus(new E("MyCoroutine"))), null, new C04831(invoke, null), 3);
    }

    public static final void launchInSingleLocationDispatcher(@NotNull Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        J.y(G.a(CoroutineContext.Element.DefaultImpls.plus(I.a(), singleLocationDispatcher).plus(new E("LocationCoroutine"))), null, new C04841(invoke, null), 3);
    }

    public static final void log(@NotNull o0 o0Var) {
        Intrinsics.checkNotNullParameter(o0Var, "<this>");
        boolean zA = o0Var.a();
        x0 x0Var = (x0) o0Var;
        logX(StringsKt.trimIndent(" \n        isActive = " + zA + " \n        isCancelled = " + x0Var.L() + " \n        isCompleted = " + (!(x0Var.G() instanceof InterfaceC0131i0)) + AwarenessDataItem.PERMISSION_SPLITTER));
    }

    public static final void logX(@Nullable Object obj) {
        System.out.println((Object) StringsKt.trimIndent("\n        ================================\n        " + obj + " \n        Thread:" + Thread.currentThread().getName() + "\n        ================================"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleDispatcher$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "SingleThread");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleIoDispatcher$lambda$3(Runnable runnable) {
        Thread thread = new Thread(runnable, "SingleIo");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleLocationDispatcher$lambda$5(Runnable runnable) {
        Thread thread = new Thread(runnable, "locationThread");
        thread.setDaemon(true);
        return thread;
    }
}
