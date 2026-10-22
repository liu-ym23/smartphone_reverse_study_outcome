package v4;

import V3.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import x4.C1294F;

/* loaded from: classes.dex */
final class l<T> extends w4.b<n> implements j<T>, InterfaceC1193b {

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23368e = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    private int f23369d;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a, reason: collision with root package name */
        Object f23370a;

        /* renamed from: b, reason: collision with root package name */
        Object f23371b;

        /* renamed from: c, reason: collision with root package name */
        Object f23372c;

        /* renamed from: d, reason: collision with root package name */
        Object f23373d;

        /* renamed from: e, reason: collision with root package name */
        Object f23374e;

        /* renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f23375f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ l<T> f23376g;

        /* renamed from: h, reason: collision with root package name */
        int f23377h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l<T> lVar, Z3.e<? super a> eVar) {
            super(eVar);
            this.f23376g = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f23375f = obj;
            this.f23377h |= Integer.MIN_VALUE;
            return this.f23376g.a(null, this);
        }
    }

    public l(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean k(Object obj, Object obj2) {
        int i5;
        n[] nVarArrF;
        synchronized (this) {
            Object obj3 = f23368e.get(this);
            if (obj != null && !j4.k.b(obj3, obj)) {
                return false;
            }
            if (j4.k.b(obj3, obj2)) {
                return true;
            }
            f23368e.set(this, obj2);
            int i6 = this.f23369d;
            if ((i6 & 1) != 0) {
                this.f23369d = i6 + 2;
                return true;
            }
            int i7 = i6 + 1;
            this.f23369d = i7;
            n[] nVarArrF2 = f();
            v vVar = v.f5542a;
            while (true) {
                n[] nVarArr = nVarArrF2;
                if (nVarArr != null) {
                    for (n nVar : nVarArr) {
                        if (nVar != null) {
                            nVar.g();
                        }
                    }
                }
                synchronized (this) {
                    i5 = this.f23369d;
                    if (i5 == i7) {
                        this.f23369d = i7 + 1;
                        return true;
                    }
                    nVarArrF = f();
                    v vVar2 = v.f5542a;
                }
                nVarArrF2 = nVarArrF;
                i7 = i5;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00ac, B:52:0x00e6], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:52:0x00e6, B:35:0x00ac], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6 A[Catch: all -> 0x0078, TryCatch #1 {all -> 0x0078, blocks: (B:35:0x00ac, B:37:0x00b6, B:39:0x00bb, B:50:0x00e0, B:52:0x00e6, B:41:0x00c1, B:45:0x00c8, B:24:0x0074, B:34:0x009d, B:29:0x0087, B:31:0x008b), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb A[Catch: all -> 0x0078, TryCatch #1 {all -> 0x0078, blocks: (B:35:0x00ac, B:37:0x00b6, B:39:0x00bb, B:50:0x00e0, B:52:0x00e6, B:41:0x00c1, B:45:0x00c8, B:24:0x0074, B:34:0x009d, B:29:0x0087, B:31:0x008b), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e6 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:35:0x00ac, B:37:0x00b6, B:39:0x00bb, B:50:0x00e0, B:52:0x00e6, B:41:0x00c1, B:45:0x00c8, B:24:0x0074, B:34:0x009d, B:29:0x0087, B:31:0x008b), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [w4.d] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e4 -> B:35:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f6 -> B:35:0x00ac). Please report as a decompilation issue!!! */
    @Override // v4.InterfaceC1193b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(v4.InterfaceC1194c<? super T> r11, Z3.e<?> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.l.a(v4.c, Z3.e):java.lang.Object");
    }

    @Override // v4.InterfaceC1194c
    public Object g(T t5, Z3.e<? super v> eVar) {
        setValue(t5);
        return v.f5542a;
    }

    @Override // v4.j
    public T getValue() {
        C1294F c1294f = w4.h.f23721a;
        T t5 = (T) f23368e.get(this);
        if (t5 == c1294f) {
            return null;
        }
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w4.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public n c() {
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w4.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public n[] d(int i5) {
        return new n[i5];
    }

    @Override // v4.j
    public void setValue(T t5) {
        if (t5 == null) {
            t5 = (T) w4.h.f23721a;
        }
        k(null, t5);
    }
}
