package android.view;

import C7.r;
import J7.c;
import S7.n;
import android.view.Lifecycle;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import n9.C1748d;
import s9.k;
import u9.d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a@\u0010\t\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@¢\u0006\u0004\b\t\u0010\f¨\u0006\r"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function2;", "Lm9/z;", "LH7/c;", "LC7/r;", "", "block", "repeatOnLifecycle", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;LS7/n;LH7/c;)Ljava/lang/Object;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepeatOnLifecycleKt {

    @c(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
        /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
            final /* synthetic */ n $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, InterfaceC1733z interfaceC1733z, n nVar, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = interfaceC1733z;
                this.$block = nVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, cVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:40:? A[SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
                /*
                    r14 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r14.label
                    r2 = 0
                    C7.r r3 = C7.r.f317a
                    r4 = 1
                    if (r1 == 0) goto L36
                    if (r1 != r4) goto L2e
                    java.lang.Object r0 = r14.L$5
                    S7.n r0 = (S7.n) r0
                    java.lang.Object r0 = r14.L$4
                    m9.z r0 = (m9.InterfaceC1733z) r0
                    java.lang.Object r0 = r14.L$3
                    androidx.lifecycle.Lifecycle r0 = (android.view.Lifecycle) r0
                    java.lang.Object r0 = r14.L$2
                    androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                    java.lang.Object r0 = r14.L$1
                    r1 = r0
                    kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                    java.lang.Object r0 = r14.L$0
                    r4 = r0
                    kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
                    kotlin.b.b(r15)     // Catch: java.lang.Throwable -> L2a
                    goto L91
                L2a:
                    r0 = move-exception
                    r15 = r0
                    goto La9
                L2e:
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                    java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                    r14.<init>(r15)
                    throw r14
                L36:
                    kotlin.b.b(r15)
                    androidx.lifecycle.Lifecycle r15 = r14.$this_repeatOnLifecycle
                    androidx.lifecycle.Lifecycle$State r15 = r15.getState()
                    androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                    if (r15 != r1) goto L44
                    goto La5
                L44:
                    kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
                    r7.<init>()
                    kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                    r1.<init>()
                    androidx.lifecycle.Lifecycle$State r15 = r14.$state     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle r13 = r14.$this_repeatOnLifecycle     // Catch: java.lang.Throwable -> La6
                    m9.z r8 = r14.$$this$coroutineScope     // Catch: java.lang.Throwable -> La6
                    S7.n r12 = r14.$block     // Catch: java.lang.Throwable -> La6
                    r14.L$0 = r7     // Catch: java.lang.Throwable -> La6
                    r14.L$1 = r1     // Catch: java.lang.Throwable -> La6
                    r14.L$2 = r15     // Catch: java.lang.Throwable -> La6
                    r14.L$3 = r13     // Catch: java.lang.Throwable -> La6
                    r14.L$4 = r8     // Catch: java.lang.Throwable -> La6
                    r14.L$5 = r12     // Catch: java.lang.Throwable -> La6
                    r14.label = r4     // Catch: java.lang.Throwable -> La6
                    m9.k r10 = new m9.k     // Catch: java.lang.Throwable -> La6
                    H7.c r5 = U7.a.I(r14)     // Catch: java.lang.Throwable -> La6
                    r10.<init>(r4, r5)     // Catch: java.lang.Throwable -> La6
                    r10.y()     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.INSTANCE     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle$Event r6 = r4.upTo(r15)     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.Lifecycle$Event r9 = r4.downFrom(r15)     // Catch: java.lang.Throwable -> La6
                    kotlinx.coroutines.sync.a r11 = new kotlinx.coroutines.sync.a     // Catch: java.lang.Throwable -> La6
                    r11.<init>()     // Catch: java.lang.Throwable -> La6
                    androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r5 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La6
                    r5.<init>()     // Catch: java.lang.Throwable -> La6
                    r1.f4920a = r5     // Catch: java.lang.Throwable -> La6
                    r13.addObserver(r5)     // Catch: java.lang.Throwable -> La6
                    java.lang.Object r15 = r10.x()     // Catch: java.lang.Throwable -> La6
                    if (r15 != r0) goto L90
                    return r0
                L90:
                    r4 = r7
                L91:
                    java.lang.Object r15 = r4.f4920a
                    m9.c0 r15 = (m9.c0) r15
                    if (r15 == 0) goto L9a
                    r15.cancel(r2)
                L9a:
                    java.lang.Object r15 = r1.f4920a
                    androidx.lifecycle.LifecycleEventObserver r15 = (android.view.LifecycleEventObserver) r15
                    if (r15 == 0) goto La5
                    androidx.lifecycle.Lifecycle r14 = r14.$this_repeatOnLifecycle
                    r14.removeObserver(r15)
                La5:
                    return r3
                La6:
                    r0 = move-exception
                    r15 = r0
                    r4 = r7
                La9:
                    java.lang.Object r0 = r4.f4920a
                    m9.c0 r0 = (m9.c0) r0
                    if (r0 == 0) goto Lb2
                    r0.cancel(r2)
                Lb2:
                    java.lang.Object r0 = r1.f4920a
                    androidx.lifecycle.LifecycleEventObserver r0 = (android.view.LifecycleEventObserver) r0
                    if (r0 == 0) goto Lbd
                    androidx.lifecycle.Lifecycle r14 = r14.$this_repeatOnLifecycle
                    r14.removeObserver(r0)
                Lbd:
                    throw r15
                */
                throw new UnsupportedOperationException("Method not decompiled: android.view.RepeatOnLifecycleKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, n nVar, H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                d dVar = AbstractC1691I.f5315a;
                C1748d c1748d = k.f6003a.d;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, interfaceC1733z, this.$block, null);
                this.label = 1;
                if (AbstractC1683A.w(c1748d, anonymousClass1, this) == coroutineSingletons) {
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
            return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, n nVar, H7.c<? super r> cVar) {
        Object objF;
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        Lifecycle.State state2 = lifecycle.getState();
        Lifecycle.State state3 = Lifecycle.State.DESTROYED;
        r rVar = r.f317a;
        return (state2 != state3 && (objF = AbstractC1683A.f(new AnonymousClass3(lifecycle, state, nVar, null), cVar)) == CoroutineSingletons.f4909a) ? objF : rVar;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, n nVar, H7.c<? super r> cVar) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, nVar, cVar);
        return objRepeatOnLifecycle == CoroutineSingletons.f4909a ? objRepeatOnLifecycle : r.f317a;
    }
}
