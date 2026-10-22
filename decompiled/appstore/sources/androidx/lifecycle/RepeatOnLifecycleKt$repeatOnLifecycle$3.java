package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.o1;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle r10, Lifecycle.State r11, CoroutineScope r12, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r13, Continuation<? super AnonymousClass1> r14) {
            this.$this_repeatOnLifecycle = r10;
            this.$state = r11;
            this.$$this$coroutineScope = r12;
            this.$block = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r17) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L12;
            if (r11 != 1) goto L11;
            Function2 r12 = (Function2) this.L$5;
            CoroutineScope r13 = (CoroutineScope) this.L$4;
            Lifecycle r14 = (Lifecycle) this.L$3;
            Lifecycle.State r15 = (Lifecycle.State) this.L$2;
            Ref$ObjectRef r16 = (Ref$ObjectRef) this.L$1;
            Ref$ObjectRef r18 = (Ref$ObjectRef) this.L$0;
            kotlin.c.b(r17);     // Catch: Throwable -> L8
        L26:
            Job r19 = (Job) r18.element;
            if (r19 == null) goto L29;
            Job.a.b(r19, null, 1, null);
        L29:
            LifecycleEventObserver r20 = (LifecycleEventObserver) r16.element;
            if (r20 == null) goto L33;
            this.$this_repeatOnLifecycle.d(r20);
        L33:
            return Unit.f21064a;
        L8:
            th = th;
        L34:
            Job r21 = (Job) r18.element;
            if (r21 == null) goto L37;
            Job.a.b(r21, null, 1, null);
        L37:
            LifecycleEventObserver r22 = (LifecycleEventObserver) r16.element;
            if (r22 == null) goto L40;
            this.$this_repeatOnLifecycle.d(r22);
        L40:
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            kotlin.c.b(r17);
            if (this.$this_repeatOnLifecycle.b() == Lifecycle.State.DESTROYED) goto L15;
            final Ref$ObjectRef r23 = new Ref$ObjectRef();
            Ref$ObjectRef r110 = new Ref$ObjectRef();
            Lifecycle.State r24 = this.$state;     // Catch: Throwable -> L21
            Lifecycle r111 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L21
            final CoroutineScope r25 = this.$$this$coroutineScope;     // Catch: Throwable -> L21
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> r112 = this.$block;     // Catch: Throwable -> L21
            this.L$0 = r23;     // Catch: Throwable -> L21
            this.L$1 = r110;     // Catch: Throwable -> L21
            this.L$2 = r24;     // Catch: Throwable -> L21
            this.L$3 = r111;     // Catch: Throwable -> L21
            this.L$4 = r25;     // Catch: Throwable -> L21
            this.L$5 = r112;     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            final kotlinx.coroutines.n r113 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(this), 1);     // Catch: Throwable -> L21
            r113.initCancellability();     // Catch: Throwable -> L21
            Lifecycle.Event.a r26 = Lifecycle.Event.Companion;     // Catch: Throwable -> L21
            final Lifecycle.Event r27 = r26.d(r24);     // Catch: Throwable -> L21
            final Lifecycle.Event r28 = r26.a(r24);     // Catch: Throwable -> L21
            final Mutex r114 = MutexKt.b(false, 1, null);     // Catch: Throwable -> L21
            ?? r115 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r27, r23, r25, r28, r113, r114, r112);     // Catch: Throwable -> L21
            r110.element = r115;     // Catch: Throwable -> L21
            kotlin.jvm.internal.q.e(r115, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L21
            r111.a((LifecycleEventObserver) r115);     // Catch: Throwable -> L21
            Object r29 = r113.q();     // Catch: Throwable -> L21
            if (r29 != kotlin.coroutines.intrinsics.a.d()) goto L23;
            tf.d.c(this);     // Catch: Throwable -> L21
        L23:
            if (r29 != r10) goto L25;
            return r10;
        L25:
            r18 = r23;
            r16 = r110;
        L21:
            th = th;
            r18 = r23;
            r16 = r110;
            goto L34
        L15:
            return Unit.f21064a;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle r10, Lifecycle.State r11, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> r13) {
        this.$this_repeatOnLifecycle = r10;
        this.$state = r11;
        this.$block = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 r12 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        kotlin.c.b(r10);
    L12:
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        o1 r14 = kotlinx.coroutines.l0.c().e();
        AnonymousClass1 r15 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r13, this.$block, null);
        this.label = 1;
        if (kotlinx.coroutines.h.g(r14, r15, this) != r11) goto L12;
        return r11;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
