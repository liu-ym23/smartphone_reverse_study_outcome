package d6;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y extends e6.b implements u, b, e6.g {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f1921e = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int d;

    public y(Object obj) {
        this._state$volatile = obj;
    }

    @Override // e6.g
    public final b a(f5.h hVar, int i8, c6.a aVar) {
        return z.f(this, hVar, i8, aVar);
    }

    public final void b(Object obj) {
        if (obj == null) {
            obj = e6.i.f2386a;
        }
        c(null, obj);
    }

    public final boolean c(Object obj, Object obj2) {
        int i8;
        a0[] a0VarArr;
        androidx.emoji2.text.r rVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1921e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.p.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.p.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i9 = this.d;
            if ((i9 & 1) != 0) {
                this.d = i9 + 2;
                return true;
            }
            int i10 = i9 + 1;
            this.d = i10;
            a0[] a0VarArr2 = this.f2370a;
            while (true) {
                if (a0VarArr2 != null) {
                    for (a0 a0Var : a0VarArr2) {
                        if (a0Var != null) {
                            AtomicReference atomicReference = a0Var.f1854a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (rVar = z.f1923b)) {
                                    androidx.emoji2.text.r rVar2 = z.f1922a;
                                    if (obj4 != rVar2) {
                                        while (!atomicReference.compareAndSet(obj4, rVar2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((a6.m) obj4).resumeWith(b5.a0.f883a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, rVar)) {
                                        if (atomicReference.get() != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i8 = this.d;
                    if (i8 == i10) {
                        this.d = i10 + 1;
                        return true;
                    }
                    a0VarArr = this.f2370a;
                }
                a0VarArr2 = a0VarArr;
                i10 = i8;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0149, code lost:
    
        if (r1 != r3) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0146, code lost:
    
        if (r5 != r3) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2 A[Catch: all -> 0x003f, TryCatch #4 {all -> 0x003f, blocks: (B:14:0x0039, B:53:0x00ca, B:55:0x00d2, B:58:0x00d9, B:59:0x00dd, B:61:0x00e0, B:71:0x0101, B:74:0x0111, B:75:0x012d, B:81:0x013d, B:78:0x0134, B:80:0x013a, B:63:0x00e6, B:67:0x00ed, B:21:0x0054), top: B:111:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0 A[Catch: all -> 0x003f, TryCatch #4 {all -> 0x003f, blocks: (B:14:0x0039, B:53:0x00ca, B:55:0x00d2, B:58:0x00d9, B:59:0x00dd, B:61:0x00e0, B:71:0x0101, B:74:0x0111, B:75:0x012d, B:81:0x013d, B:78:0x0134, B:80:0x013a, B:63:0x00e6, B:67:0x00ed, B:21:0x0054), top: B:111:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0111 A[Catch: all -> 0x003f, TryCatch #4 {all -> 0x003f, blocks: (B:14:0x0039, B:53:0x00ca, B:55:0x00d2, B:58:0x00d9, B:59:0x00dd, B:61:0x00e0, B:71:0x0101, B:74:0x0111, B:75:0x012d, B:81:0x013d, B:78:0x0134, B:80:0x013a, B:63:0x00e6, B:67:0x00ed, B:21:0x0054), top: B:111:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0110 -> B:53:0x00ca). Please report as a decompilation issue!!! */
    @Override // d6.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(d6.c r18, f5.c r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.y.collect(d6.c, f5.c):java.lang.Object");
    }

    @Override // d6.c
    public final Object emit(Object obj, f5.c cVar) {
        b(obj);
        return b5.a0.f883a;
    }

    @Override // d6.w
    public final Object getValue() {
        Object obj = f1921e.get(this);
        if (obj == e6.i.f2386a) {
            return null;
        }
        return obj;
    }
}
