package kotlinx.coroutines.flow;

import Xa.b;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f36378a;

    @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", f = "Builders.kt", l = {114}, m = "collect", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f36379a;

        /* renamed from: b, reason: collision with root package name */
        public int f36380b;

        /* renamed from: d, reason: collision with root package name */
        public Object f36382d;

        /* renamed from: e, reason: collision with root package name */
        public Object f36383e;

        /* renamed from: f, reason: collision with root package name */
        public Object f36384f;

        /* renamed from: g, reason: collision with root package name */
        public Object f36385g;

        /* renamed from: h, reason: collision with root package name */
        public Object f36386h;

        /* renamed from: i, reason: collision with root package name */
        public Object f36387i;

        /* renamed from: j, reason: collision with root package name */
        public Object f36388j;

        /* renamed from: k, reason: collision with root package name */
        public int f36389k;

        /* renamed from: l, reason: collision with root package name */
        public int f36390l;

        /* renamed from: m, reason: collision with root package name */
        public int f36391m;

        public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f36379a = obj;
            this.f36380b |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(Iterable iterable) {
        this.f36378a = iterable;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Xa.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(Xa.c<? super T> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3.AnonymousClass1) r0
            int r1 = r0.f36380b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36380b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f36379a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36380b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L53
            if (r2 != r3) goto L4b
            int r10 = r0.f36390l
            int r11 = r0.f36389k
            java.lang.Object r2 = r0.f36386h
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.f36385g
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r6 = r0.f36384f
            Xa.c r6 = (Xa.c) r6
            java.lang.Object r7 = r0.f36383e
            e9.c r7 = (e9.InterfaceC4014c) r7
            java.lang.Object r8 = r0.f36382d
            Xa.c r8 = (Xa.c) r8
            kotlin.C4849c.b(r12)
            r12 = r0
            r0 = r11
            r11 = r6
            r6 = r2
            r2 = r12
            r12 = r7
            r7 = r5
            r5 = r12
            r12 = r8
            goto L63
        L4b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L53:
            kotlin.C4849c.b(r12)
            java.lang.Iterable r10 = r10.f36378a
            java.util.Iterator r12 = r10.iterator()
            r7 = r10
            r6 = r12
            r2 = r0
            r5 = r2
            r10 = r4
            r0 = r10
            r12 = r11
        L63:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L9e
            java.lang.Object r8 = r6.next()
            java.lang.Object r9 = g9.h.a(r12)
            r2.f36382d = r9
            java.lang.Object r9 = g9.h.a(r5)
            r2.f36383e = r9
            r2.f36384f = r11
            java.lang.Object r9 = g9.h.a(r7)
            r2.f36385g = r9
            r2.f36386h = r6
            java.lang.Object r9 = g9.h.a(r8)
            r2.f36387i = r9
            java.lang.Object r9 = g9.h.a(r8)
            r2.f36388j = r9
            r2.f36389k = r0
            r2.f36390l = r10
            r2.f36391m = r4
            r2.f36380b = r3
            java.lang.Object r8 = r11.emit(r8, r2)
            if (r8 != r1) goto L63
            return r1
        L9e:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3.collect(Xa.c, e9.c):java.lang.Object");
    }
}
