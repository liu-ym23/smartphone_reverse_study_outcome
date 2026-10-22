package androidx.compose.material3.internal;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;

@Stable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R+\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00028V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/compose/material3/internal/BasicTooltipStateImpl;", "Landroidx/compose/material3/TooltipState;", "", "initialIsVisible", "isPersistent", "Landroidx/compose/foundation/MutatorMutex;", "mutatorMutex", AppAgent.CONSTRUCT, "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "Landroidx/compose/foundation/MutatePriority;", "mutatePriority", "LC7/r;", "show", "(Landroidx/compose/foundation/MutatePriority;LH7/c;)Ljava/lang/Object;", "dismiss", "()V", "onDispose", "Z", "()Z", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "isVisible", "setVisible", "(Z)V", "Landroidx/compose/animation/core/MutableTransitionState;", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "Lm9/j;", "job", "Lm9/j;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class BasicTooltipStateImpl implements TooltipState {
    private final boolean isPersistent;

    /* renamed from: isVisible$delegate, reason: from kotlin metadata */
    private final MutableState isVisible;
    private InterfaceC1717j job;
    private final MutatorMutex mutatorMutex;
    private final MutableTransitionState<Boolean> transition = new MutableTransitionState<>(Boolean.FALSE);

    @c(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$2", f = "BasicTooltip.kt", l = {152, 154}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.BasicTooltipStateImpl$show$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements k {
        final /* synthetic */ k $cancellableShow;
        int label;

        @c(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1", f = "BasicTooltip.kt", l = {154}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ k $cancellableShow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(k kVar, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$cancellableShow = kVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$cancellableShow, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    k kVar = this.$cancellableShow;
                    this.label = 1;
                    if (kVar.invoke(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$cancellableShow = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return BasicTooltipStateImpl.this.new AnonymousClass2(this.$cancellableShow, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        
            if (kotlinx.coroutines.a.o(1500, r6, r5) == r0) goto L20;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v4, types: [C7.r, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r5.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1b
                if (r1 == r4) goto Ld
                if (r1 != r3) goto L13
            Ld:
                kotlin.b.b(r6)     // Catch: java.lang.Throwable -> L11
                goto L44
            L11:
                r6 = move-exception
                goto L4c
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.b.b(r6)
                androidx.compose.material3.internal.BasicTooltipStateImpl r6 = androidx.compose.material3.internal.BasicTooltipStateImpl.this     // Catch: java.lang.Throwable -> L11
                boolean r6 = r6.getIsPersistent()     // Catch: java.lang.Throwable -> L11
                if (r6 == 0) goto L31
                S7.k r6 = r5.$cancellableShow     // Catch: java.lang.Throwable -> L11
                r5.label = r4     // Catch: java.lang.Throwable -> L11
                java.lang.Object r6 = r6.invoke(r5)     // Catch: java.lang.Throwable -> L11
                if (r6 != r0) goto L44
                goto L43
            L31:
                androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1 r6 = new androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1     // Catch: java.lang.Throwable -> L11
                S7.k r1 = r5.$cancellableShow     // Catch: java.lang.Throwable -> L11
                r4 = 0
                r6.<init>(r1, r4)     // Catch: java.lang.Throwable -> L11
                r5.label = r3     // Catch: java.lang.Throwable -> L11
                r3 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r6 = kotlinx.coroutines.a.o(r3, r6, r5)     // Catch: java.lang.Throwable -> L11
                if (r6 != r0) goto L44
            L43:
                return r0
            L44:
                androidx.compose.material3.internal.BasicTooltipStateImpl r5 = androidx.compose.material3.internal.BasicTooltipStateImpl.this
                r5.setVisible(r2)
                C7.r r5 = C7.r.f317a
                return r5
            L4c:
                androidx.compose.material3.internal.BasicTooltipStateImpl r5 = androidx.compose.material3.internal.BasicTooltipStateImpl.this
                r5.setVisible(r2)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipStateImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public BasicTooltipStateImpl(boolean z10, boolean z11, MutatorMutex mutatorMutex) {
        this.isPersistent = z11;
        this.mutatorMutex = mutatorMutex;
        this.isVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z10), null, 2, null);
    }

    @Override // androidx.compose.material3.TooltipState
    public void dismiss() {
        setVisible(false);
    }

    @Override // androidx.compose.material3.TooltipState
    public MutableTransitionState<Boolean> getTransition() {
        return this.transition;
    }

    @Override // androidx.compose.material3.TooltipState
    /* renamed from: isPersistent, reason: from getter */
    public boolean getIsPersistent() {
        return this.isPersistent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.material3.TooltipState
    /* renamed from: isVisible */
    public boolean getIsVisible() {
        return ((Boolean) this.isVisible.getValue()).booleanValue();
    }

    @Override // androidx.compose.material3.TooltipState
    public void onDispose() {
        InterfaceC1717j interfaceC1717j = this.job;
        if (interfaceC1717j != null) {
            interfaceC1717j.l(null);
        }
    }

    public void setVisible(boolean z10) {
        this.isVisible.setValue(Boolean.valueOf(z10));
    }

    @Override // androidx.compose.material3.TooltipState
    public Object show(MutatePriority mutatePriority, H7.c<? super r> cVar) {
        Object objMutate = this.mutatorMutex.mutate(mutatePriority, new AnonymousClass2(new BasicTooltipStateImpl$show$cancellableShow$1(this, null), null), cVar);
        return objMutate == CoroutineSingletons.f4909a ? objMutate : r.f317a;
    }
}
