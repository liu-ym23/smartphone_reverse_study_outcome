package kotlinx.coroutines.flow.internal;

import Ua.M;
import Wa.g;
import Wa.s;
import Xa.b;
import Xa.c;
import Y8.t;
import Z8.IndexedValue;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {51, 73, 76}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36725a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36726b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36727c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36728d;

    /* renamed from: e, reason: collision with root package name */
    public Object f36729e;

    /* renamed from: f, reason: collision with root package name */
    public Object f36730f;

    /* renamed from: g, reason: collision with root package name */
    public int f36731g;

    /* renamed from: h, reason: collision with root package name */
    public int f36732h;

    /* renamed from: i, reason: collision with root package name */
    public int f36733i;

    /* renamed from: j, reason: collision with root package name */
    public int f36734j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f36735k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b<T>[] f36736l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5063a<T[]> f36737m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ q<c<? super R>, T[], InterfaceC4014c<? super t>, Object> f36738n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c<R> f36739o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {28}, m = "invokeSuspend", v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f36740a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b<T>[] f36741b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f36742c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f36743d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g<IndexedValue<Object>> f36744e;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04641<T> implements c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g<IndexedValue<Object>> f36745a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f36746b;

            public C04641(g<IndexedValue<Object>> gVar, int i10) {
                this.f36745a = gVar;
                this.f36746b = i10;
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
            
                if (Ua.W0.a(r0) == r1) goto L21;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // Xa.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.f36750d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f36750d = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r5, r7)
                L18:
                    java.lang.Object r7 = r0.f36748b
                    java.lang.Object r1 = f9.C4063a.g()
                    int r2 = r0.f36750d
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3a
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.C4849c.b(r7)
                    goto L64
                L2c:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L34:
                    java.lang.Object r6 = r0.f36747a
                    kotlin.C4849c.b(r7)
                    goto L55
                L3a:
                    kotlin.C4849c.b(r7)
                    Wa.g<Z8.J<java.lang.Object>> r7 = r5.f36745a
                    Z8.J r2 = new Z8.J
                    int r5 = r5.f36746b
                    r2.<init>(r5, r6)
                    java.lang.Object r5 = g9.h.a(r6)
                    r0.f36747a = r5
                    r0.f36750d = r4
                    java.lang.Object r5 = r7.send(r2, r0)
                    if (r5 != r1) goto L55
                    goto L63
                L55:
                    java.lang.Object r5 = g9.h.a(r6)
                    r0.f36747a = r5
                    r0.f36750d = r3
                    java.lang.Object r5 = Ua.W0.a(r0)
                    if (r5 != r1) goto L64
                L63:
                    return r1
                L64:
                    Y8.t r5 = Y8.t.f7040a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C04641.emit(java.lang.Object, e9.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(b<? extends T>[] bVarArr, int i10, AtomicInteger atomicInteger, g<IndexedValue<Object>> gVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f36741b = bVarArr;
            this.f36742c = i10;
            this.f36743d = atomicInteger;
            this.f36744e = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f36741b, this.f36742c, this.f36743d, this.f36744e, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AtomicInteger atomicInteger;
            Object objG = C4063a.g();
            int i10 = this.f36740a;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    b[] bVarArr = this.f36741b;
                    int i11 = this.f36742c;
                    b bVar = bVarArr[i11];
                    C04641 c04641 = new C04641(this.f36744e, i11);
                    this.f36740a = 1;
                    if (bVar.collect(c04641, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    s.a(this.f36744e, null, 1, null);
                }
                return t.f7040a;
            } finally {
                if (this.f36743d.decrementAndGet() == 0) {
                    s.a(this.f36744e, null, 1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(b<? extends T>[] bVarArr, InterfaceC5063a<T[]> interfaceC5063a, q<? super c<? super R>, ? super T[], ? super InterfaceC4014c<? super t>, ? extends Object> qVar, c<? super R> cVar, InterfaceC4014c<? super CombineKt$combineInternal$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36736l = bVarArr;
        this.f36737m = interfaceC5063a;
        this.f36738n = qVar;
        this.f36739o = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.f36736l, this.f36737m, this.f36738n, this.f36739o, interfaceC4014c);
        combineKt$combineInternal$2.f36735k = obj;
        return combineKt$combineInternal$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CombineKt$combineInternal$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x01ac, code lost:
    
        if (r10.invoke(r11, r14, r22) == r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x016e, code lost:
    
        r20 = r12;
        r12 = r4;
        r4 = r6;
        r6 = r20;
        r20 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fd A[LOOP:0: B:28:0x00fd->B:36:0x0126, LOOP_START, PHI: r4 r14
      0x00fd: PHI (r4v6 int) = (r4v5 int), (r4v7 int) binds: [B:25:0x00f8, B:36:0x0126] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r14v5 Z8.J) = (r14v4 Z8.J), (r14v10 Z8.J) binds: [B:25:0x00f8, B:36:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r15v1, types: [Xa.b<T>[], Xa.b[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [Xa.b<T>[]] */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01af -> B:20:0x00c3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
