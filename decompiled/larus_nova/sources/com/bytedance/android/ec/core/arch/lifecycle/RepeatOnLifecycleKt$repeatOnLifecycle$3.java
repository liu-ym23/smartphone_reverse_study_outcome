package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {176}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $this_coroutineScope;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ RepeatOnLifecycleKt$repeatOnLifecycle$3 this$0;

        public AnonymousClass1(RepeatOnLifecycleKt$repeatOnLifecycle$3 r100, CoroutineScope r101, Continuation r102) {
            this.this$0 = r100;
            this.$this_coroutineScope = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "completion");
            return new AnonymousClass1(this.this$0, this.$this_coroutineScope, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [T, androidx.lifecycle.LifecycleObserver, com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 != 1) goto L11;
            AnonymousClass1 r102 = (AnonymousClass1) this.L$2;
            Ref.ObjectRef r103 = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef r104 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L8
        L41:
            Job r111 = (Job) r104.element;
            if (r111 == null) goto L44;
            Job.DefaultImpls.cancel$default(r111, null, 1, null);
        L44:
            LifecycleEventObserver r112 = (LifecycleEventObserver) r103.element;
            if (r112 == null) goto L48;
            this.this$0.$this_repeatOnLifecycle.removeObserver(r112);
        L48:
            return Unit.INSTANCE;
        L8:
            Throwable th10 = th;
        L51:
            Job r105 = (Job) r104.element;
            if (r105 == null) goto L54;
            Job.DefaultImpls.cancel$default(r105, null, 1, null);
        L54:
            LifecycleEventObserver r106 = (LifecycleEventObserver) r103.element;
            if (r106 == null) goto L57;
            this.this$0.$this_repeatOnLifecycle.removeObserver(r106);
        L57:
            throw th10;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r110);
            if (this.this$0.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
            r104 = new Ref.ObjectRef();
            r104.element = null;
            Ref.ObjectRef r113 = new Ref.ObjectRef();
            r113.element = null;
            this.L$0 = r104;     // Catch: Throwable -> L49
            this.L$1 = r113;     // Catch: Throwable -> L49
            this.L$2 = this;     // Catch: Throwable -> L49
            this.label = 1;     // Catch: Throwable -> L49
            j r114 = new j(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L49
            int r107 = h.f43855a[this.this$0.$state.ordinal()];     // Catch: Throwable -> L49
            if (r107 == 1) goto L24;
            if (r107 == 2) goto L23;
            if (r107 == 3) goto L22;
            Lifecycle.Event r108 = null;
        L26:
            int r109 = h.f43856b[this.this$0.$state.ordinal()];     // Catch: Throwable -> L49
            if (r109 == 1) goto L33;
            if (r109 == 2) goto L32;
            if (r109 == 3) goto L31;
            Lifecycle.Event r115 = null;
        L35:
            ?? r116 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1(r108, kotlinx.coroutines.sync.b.a(), r115, r114, this, r104);     // Catch: Throwable -> L49
            r113.element = r116;     // Catch: Throwable -> L49
            this.this$0.$this_repeatOnLifecycle.addObserver(r116);     // Catch: Throwable -> L49
            Object r117 = r114.B();     // Catch: Throwable -> L49
            if (r117 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
            DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L49
        L38:
            if (r117 != r100) goto L40;
            return r100;
        L40:
            r103 = r113;
            goto L41
        L31:
            Lifecycle.Event r118 = Lifecycle.Event.ON_PAUSE;     // Catch: Throwable -> L49
        L34:
            r115 = r118;
            goto L35
        L32:
            r118 = Lifecycle.Event.ON_STOP;     // Catch: Throwable -> L49
            goto L34
        L33:
            r118 = Lifecycle.Event.ON_DESTROY;     // Catch: Throwable -> L49
            goto L34
        L22:
            Lifecycle.Event r119 = Lifecycle.Event.ON_RESUME;     // Catch: Throwable -> L49
        L25:
            r108 = r119;
            goto L26
        L23:
            r119 = Lifecycle.Event.ON_START;     // Catch: Throwable -> L49
            goto L25
        L24:
            r119 = Lifecycle.Event.ON_CREATE;     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            r103 = r113;
            th10 = th;
            goto L51
        L15:
            return Unit.INSTANCE;
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle r100, Lifecycle.State r101, Function2 r102, Continuation r103) {
        this.$this_repeatOnLifecycle = r100;
        this.$state = r101;
        this.$block = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        RepeatOnLifecycleKt$repeatOnLifecycle$3 r102 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        MainCoroutineDispatcher r104 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r105 = new AnonymousClass1(this, r103, null);
        this.label = 1;
        if (BuildersKt.withContext(r104, r105, this) != r101) goto L12;
        return r101;
    }
}
