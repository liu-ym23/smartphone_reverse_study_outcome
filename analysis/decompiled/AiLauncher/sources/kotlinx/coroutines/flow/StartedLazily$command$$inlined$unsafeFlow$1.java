package kotlinx.coroutines.flow;

import Xa.b;
import Xa.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/StartedLazily$command$$inlined$unsafeFlow$1", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartedLazily$command$$inlined$unsafeFlow$1 implements b<SharingCommand> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f36630a;

    @InterfaceC4112d(c = "kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1", f = "SharingStarted.kt", l = {113}, m = "collect", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f36631a;

        /* renamed from: b, reason: collision with root package name */
        public int f36632b;

        /* renamed from: d, reason: collision with root package name */
        public Object f36634d;

        /* renamed from: e, reason: collision with root package name */
        public Object f36635e;

        /* renamed from: f, reason: collision with root package name */
        public Object f36636f;

        /* renamed from: g, reason: collision with root package name */
        public Object f36637g;

        /* renamed from: h, reason: collision with root package name */
        public int f36638h;

        public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f36631a = obj;
            this.f36632b |= Integer.MIN_VALUE;
            return StartedLazily$command$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public StartedLazily$command$$inlined$unsafeFlow$1(t tVar) {
        this.f36630a = tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Xa.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(Xa.c<? super kotlinx.coroutines.flow.SharingCommand> r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f36632b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36632b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f36631a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36632b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            java.lang.Object r5 = r0.f36637g
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref$BooleanRef) r5
            java.lang.Object r5 = r0.f36636f
            Xa.c r5 = (Xa.c) r5
            java.lang.Object r5 = r0.f36635e
            e9.c r5 = (e9.InterfaceC4014c) r5
            java.lang.Object r5 = r0.f36634d
            Xa.c r5 = (Xa.c) r5
            kotlin.C4849c.b(r7)
            goto L74
        L41:
            kotlin.C4849c.b(r7)
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            Xa.t r5 = r5.f36630a
            kotlinx.coroutines.flow.StartedLazily$command$1$1 r2 = new kotlinx.coroutines.flow.StartedLazily$command$1$1
            r2.<init>(r7, r6)
            java.lang.Object r4 = g9.h.a(r6)
            r0.f36634d = r4
            java.lang.Object r4 = g9.h.a(r0)
            r0.f36635e = r4
            java.lang.Object r6 = g9.h.a(r6)
            r0.f36636f = r6
            java.lang.Object r6 = g9.h.a(r7)
            r0.f36637g = r6
            r6 = 0
            r0.f36638h = r6
            r0.f36632b = r3
            java.lang.Object r5 = r5.collect(r2, r0)
            if (r5 != r1) goto L74
            return r1
        L74:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1.collect(Xa.c, e9.c):java.lang.Object");
    }
}
