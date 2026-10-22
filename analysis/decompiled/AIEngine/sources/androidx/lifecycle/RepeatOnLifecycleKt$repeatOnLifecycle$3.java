package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2221a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2222b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f2223c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zb.p<CoroutineScope, qb.b<? super lb.n>, Object> f2224d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Ref$ObjectRef f2225a;

        /* renamed from: b, reason: collision with root package name */
        public Ref$ObjectRef f2226b;

        /* renamed from: c, reason: collision with root package name */
        public CoroutineScope f2227c;

        /* renamed from: d, reason: collision with root package name */
        public Object f2228d;

        /* renamed from: e, reason: collision with root package name */
        public int f2229e;
        public final /* synthetic */ Lifecycle h;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f2230j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ zb.p<CoroutineScope, qb.b<? super lb.n>, Object> f2231k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, CoroutineScope coroutineScope, zb.p pVar, qb.b bVar) {
            super(2, bVar);
            Lifecycle.State state = Lifecycle.State.f2214a;
            this.h = lifecycle;
            this.f2230j = coroutineScope;
            this.f2231k = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
            Lifecycle.State state = Lifecycle.State.f2214a;
            return new AnonymousClass1(this.h, this.f2230j, this.f2231k, bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, androidx.lifecycle.p] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r13.f2229e
                androidx.lifecycle.Lifecycle r2 = r13.h
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 != r4) goto L18
                kotlin.jvm.internal.Ref$ObjectRef r1 = r13.f2226b
                kotlin.jvm.internal.Ref$ObjectRef r13 = r13.f2225a
                kotlin.c.b(r14)     // Catch: java.lang.Throwable -> L14
                goto L76
            L14:
                r0 = move-exception
                r14 = r0
                goto L93
            L18:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L20:
                kotlin.c.b(r14)
                androidx.lifecycle.Lifecycle$State r14 = r2.b()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.f2214a
                if (r14 != r1) goto L2e
                lb.n r13 = lb.n.f10413a
                return r13
            L2e:
                kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
                r7.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r14 = androidx.lifecycle.Lifecycle.State.f2217d     // Catch: java.lang.Throwable -> L8b
                kotlinx.coroutines.CoroutineScope r8 = r13.f2230j     // Catch: java.lang.Throwable -> L8b
                zb.p<kotlinx.coroutines.CoroutineScope, qb.b<? super lb.n>, java.lang.Object> r12 = r13.f2231k     // Catch: java.lang.Throwable -> L8b
                r13.f2225a = r7     // Catch: java.lang.Throwable -> L8b
                r13.f2226b = r1     // Catch: java.lang.Throwable -> L8b
                r13.f2227c = r8     // Catch: java.lang.Throwable -> L8b
                r13.f2228d = r12     // Catch: java.lang.Throwable -> L8b
                r13.f2229e = r4     // Catch: java.lang.Throwable -> L8b
                kotlinx.coroutines.CancellableContinuationImpl r10 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L8b
                qb.b r13 = jd.b.w(r13)     // Catch: java.lang.Throwable -> L8b
                r10.<init>(r13, r4)     // Catch: java.lang.Throwable -> L8b
                r10.initCancellability()     // Catch: java.lang.Throwable -> L8b
                androidx.lifecycle.Lifecycle$Event$a r13 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> L8b
                r13.getClass()     // Catch: java.lang.Throwable -> L8f
                androidx.lifecycle.Lifecycle$Event r6 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch: java.lang.Throwable -> L8f
                androidx.lifecycle.Lifecycle$Event r9 = androidx.lifecycle.Lifecycle.Event.a.a(r14)     // Catch: java.lang.Throwable -> L8b
                r13 = 0
                kotlinx.coroutines.sync.Mutex r11 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r13, r4, r3)     // Catch: java.lang.Throwable -> L8b
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r5 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> L8b
                r5.<init>()     // Catch: java.lang.Throwable -> L8b
                r1.f10076a = r5     // Catch: java.lang.Throwable -> L8b
                r2.a(r5)     // Catch: java.lang.Throwable -> L8b
                java.lang.Object r13 = r10.getResult()     // Catch: java.lang.Throwable -> L8b
                if (r13 != r0) goto L75
                return r0
            L75:
                r13 = r7
            L76:
                T r13 = r13.f10076a
                kotlinx.coroutines.Job r13 = (kotlinx.coroutines.Job) r13
                if (r13 == 0) goto L7f
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(r13, r3, r4, r3)
            L7f:
                T r13 = r1.f10076a
                androidx.lifecycle.o r13 = (androidx.lifecycle.o) r13
                if (r13 == 0) goto L88
                r2.c(r13)
            L88:
                lb.n r13 = lb.n.f10413a
                return r13
            L8b:
                r0 = move-exception
                r14 = r0
            L8d:
                r13 = r7
                goto L93
            L8f:
                r0 = move-exception
                r13 = r0
                r14 = r13
                goto L8d
            L93:
                T r13 = r13.f10076a
                kotlinx.coroutines.Job r13 = (kotlinx.coroutines.Job) r13
                if (r13 == 0) goto L9c
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(r13, r3, r4, r3)
            L9c:
                T r13 = r1.f10076a
                androidx.lifecycle.o r13 = (androidx.lifecycle.o) r13
                if (r13 == 0) goto La5
                r2.c(r13)
            La5:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, zb.p pVar, qb.b bVar) {
        super(2, bVar);
        Lifecycle.State state = Lifecycle.State.f2214a;
        this.f2223c = lifecycle;
        this.f2224d = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        Lifecycle.State state = Lifecycle.State.f2214a;
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.f2223c, this.f2224d, bVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.f2222b = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2221a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f2222b;
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            Lifecycle.State state = Lifecycle.State.f2214a;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f2223c, coroutineScope, this.f2224d, null);
            this.f2221a = 1;
            if (BuildersKt.withContext(immediate, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }
}
