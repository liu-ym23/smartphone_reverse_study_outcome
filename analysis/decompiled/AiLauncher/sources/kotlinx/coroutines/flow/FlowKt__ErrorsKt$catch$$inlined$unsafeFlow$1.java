package kotlinx.coroutines.flow;

import Xa.b;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f36448a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f36449b;

    @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {112, 113}, m = "collect", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f36450a;

        /* renamed from: b, reason: collision with root package name */
        public int f36451b;

        /* renamed from: d, reason: collision with root package name */
        public Object f36453d;

        /* renamed from: e, reason: collision with root package name */
        public Object f36454e;

        /* renamed from: f, reason: collision with root package name */
        public Object f36455f;

        /* renamed from: g, reason: collision with root package name */
        public Object f36456g;

        /* renamed from: h, reason: collision with root package name */
        public int f36457h;

        public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f36450a = obj;
            this.f36451b |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(b bVar, q qVar) {
        this.f36448a = bVar;
        this.f36449b = qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        if (r7 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Xa.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(Xa.c<? super T> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f36451b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36451b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f36450a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36451b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5a
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r7 = r0.f36456g
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r7 = r0.f36455f
            Xa.c r7 = (Xa.c) r7
            java.lang.Object r7 = r0.f36454e
            e9.c r7 = (e9.InterfaceC4014c) r7
            java.lang.Object r7 = r0.f36453d
            Xa.c r7 = (Xa.c) r7
            kotlin.C4849c.b(r9)
            goto Lac
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            int r8 = r0.f36457h
            java.lang.Object r2 = r0.f36455f
            Xa.c r2 = (Xa.c) r2
            java.lang.Object r4 = r0.f36454e
            e9.c r4 = (e9.InterfaceC4014c) r4
            java.lang.Object r5 = r0.f36453d
            Xa.c r5 = (Xa.c) r5
            kotlin.C4849c.b(r9)
            r6 = r2
            r2 = r8
            r8 = r6
            goto L7b
        L5a:
            kotlin.C4849c.b(r9)
            Xa.b r9 = r7.f36448a
            java.lang.Object r2 = g9.h.a(r8)
            r0.f36453d = r2
            java.lang.Object r2 = g9.h.a(r0)
            r0.f36454e = r2
            r0.f36455f = r8
            r2 = 0
            r0.f36457h = r2
            r0.f36451b = r4
            java.lang.Object r9 = Xa.d.h(r9, r8, r0)
            if (r9 != r1) goto L79
            goto Lab
        L79:
            r5 = r8
            r4 = r0
        L7b:
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            if (r9 == 0) goto Lac
            p9.q r7 = r7.f36449b
            java.lang.Object r5 = g9.h.a(r5)
            r0.f36453d = r5
            java.lang.Object r4 = g9.h.a(r4)
            r0.f36454e = r4
            java.lang.Object r4 = g9.h.a(r8)
            r0.f36455f = r4
            java.lang.Object r4 = g9.h.a(r9)
            r0.f36456g = r4
            r0.f36457h = r2
            r0.f36451b = r3
            r2 = 6
            kotlin.jvm.internal.n.c(r2)
            java.lang.Object r7 = r7.invoke(r8, r9, r0)
            r8 = 7
            kotlin.jvm.internal.n.c(r8)
            if (r7 != r1) goto Lac
        Lab:
            return r1
        Lac:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.collect(Xa.c, e9.c):java.lang.Object");
    }
}
