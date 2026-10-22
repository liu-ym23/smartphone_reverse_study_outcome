package android.view;

import Ua.A0;
import Ua.C1056g;
import Ua.M;
import Ua.Y;
import Y8.t;
import android.view.Lifecycle;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14213a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14214b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f14215c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f14216d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p<M, InterfaceC4014c<? super t>, Object> f14217e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f14218a;

        /* renamed from: b, reason: collision with root package name */
        public Object f14219b;

        /* renamed from: c, reason: collision with root package name */
        public Object f14220c;

        /* renamed from: d, reason: collision with root package name */
        public Object f14221d;

        /* renamed from: e, reason: collision with root package name */
        public Object f14222e;

        /* renamed from: f, reason: collision with root package name */
        public Object f14223f;

        /* renamed from: g, reason: collision with root package name */
        public int f14224g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f14225h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Lifecycle.State f14226i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ M f14227j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ p<M, InterfaceC4014c<? super t>, Object> f14228k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, M m10, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f14225h = lifecycle;
            this.f14226i = state;
            this.f14227j = m10;
            this.f14228k = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f14225h, this.f14226i, this.f14227j, this.f14228k, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r13.f14224g
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L37
                if (r1 != r3) goto L2f
                java.lang.Object r0 = r13.f14223f
                p9.p r0 = (p9.p) r0
                java.lang.Object r0 = r13.f14222e
                Ua.M r0 = (Ua.M) r0
                java.lang.Object r0 = r13.f14221d
                androidx.lifecycle.Lifecycle r0 = (android.view.Lifecycle) r0
                java.lang.Object r0 = r13.f14220c
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r13.f14219b
                r1 = r0
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                java.lang.Object r0 = r13.f14218a
                r4 = r0
                kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
                kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L2b
                goto La9
            L2b:
                r0 = move-exception
                r14 = r0
                goto Lc0
            L2f:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L37:
                kotlin.C4849c.b(r14)
                androidx.lifecycle.Lifecycle r14 = r13.f14225h
                androidx.lifecycle.Lifecycle$State r14 = r14.getState()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r14 != r1) goto L47
                Y8.t r13 = Y8.t.f7040a
                return r13
            L47:
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r14 = r13.f14226i     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle r12 = r13.f14225h     // Catch: java.lang.Throwable -> La1
                Ua.M r7 = r13.f14227j     // Catch: java.lang.Throwable -> La1
                p9.p<Ua.M, e9.c<? super Y8.t>, java.lang.Object> r11 = r13.f14228k     // Catch: java.lang.Throwable -> La1
                r13.f14218a = r6     // Catch: java.lang.Throwable -> La1
                r13.f14219b = r1     // Catch: java.lang.Throwable -> La1
                r13.f14220c = r14     // Catch: java.lang.Throwable -> La1
                r13.f14221d = r12     // Catch: java.lang.Throwable -> La1
                r13.f14222e = r7     // Catch: java.lang.Throwable -> La1
                r13.f14223f = r11     // Catch: java.lang.Throwable -> La1
                r13.f14224g = r3     // Catch: java.lang.Throwable -> La1
                kotlinx.coroutines.c r9 = new kotlinx.coroutines.c     // Catch: java.lang.Throwable -> La1
                e9.c r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r13)     // Catch: java.lang.Throwable -> La1
                r9.<init>(r4, r3)     // Catch: java.lang.Throwable -> La1
                r9.I()     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle$Event$a r4 = androidx.lifecycle.Lifecycle.Event.INSTANCE     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle$Event r5 = r4.d(r14)     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle$Event r8 = r4.a(r14)     // Catch: java.lang.Throwable -> La1
                r14 = 0
                eb.a r10 = eb.f.b(r14, r3, r2)     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La1
                r4.<init>()     // Catch: java.lang.Throwable -> La1
                r1.f34820a = r4     // Catch: java.lang.Throwable -> La1
                java.lang.String r14 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.p.g(r4, r14)     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.m r4 = (android.view.InterfaceC1395m) r4     // Catch: java.lang.Throwable -> La1
                r12.a(r4)     // Catch: java.lang.Throwable -> La1
                java.lang.Object r14 = r9.C()     // Catch: java.lang.Throwable -> La1
                java.lang.Object r4 = f9.C4063a.g()     // Catch: java.lang.Throwable -> La1
                if (r14 != r4) goto La5
                g9.f.c(r13)     // Catch: java.lang.Throwable -> La1
                goto La5
            La1:
                r0 = move-exception
                r14 = r0
                r4 = r6
                goto Lc0
            La5:
                if (r14 != r0) goto La8
                return r0
            La8:
                r4 = r6
            La9:
                T r14 = r4.f34820a
                kotlinx.coroutines.g r14 = (kotlinx.coroutines.g) r14
                if (r14 == 0) goto Lb2
                kotlinx.coroutines.g.a.a(r14, r2, r3, r2)
            Lb2:
                T r14 = r1.f34820a
                androidx.lifecycle.m r14 = (android.view.InterfaceC1395m) r14
                if (r14 == 0) goto Lbd
                androidx.lifecycle.Lifecycle r13 = r13.f14225h
                r13.d(r14)
            Lbd:
                Y8.t r13 = Y8.t.f7040a
                return r13
            Lc0:
                T r0 = r4.f34820a
                kotlinx.coroutines.g r0 = (kotlinx.coroutines.g) r0
                if (r0 == 0) goto Lc9
                kotlinx.coroutines.g.a.a(r0, r2, r3, r2)
            Lc9:
                T r0 = r1.f34820a
                androidx.lifecycle.m r0 = (android.view.InterfaceC1395m) r0
                if (r0 == 0) goto Ld4
                androidx.lifecycle.Lifecycle r13 = r13.f14225h
                r13.d(r0)
            Ld4:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: android.view.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14215c = lifecycle;
        this.f14216d = state;
        this.f14217e = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.f14215c, this.f14216d, this.f14217e, interfaceC4014c);
        repeatOnLifecycleKt$repeatOnLifecycle$3.f14214b = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14213a;
        if (i10 == 0) {
            C4849c.b(obj);
            M m10 = (M) this.f14214b;
            A0 immediate = Y.c().getImmediate();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14215c, this.f14216d, m10, this.f14217e, null);
            this.f14213a = 1;
            if (C1056g.j(immediate, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
