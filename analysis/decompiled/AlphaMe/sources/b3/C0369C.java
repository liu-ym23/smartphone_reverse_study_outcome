package b3;

import Z2.C0128h;
import c3.AbstractC0395b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* renamed from: b3.C, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0369C extends AbstractC0395b implements z, InterfaceC0379h {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4381e = AtomicReferenceFieldUpdater.newUpdater(C0369C.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: d, reason: collision with root package name */
    public int f4382d;

    public C0369C(Object obj) {
        this._state = obj;
    }

    public final Object a() {
        X.r rVar = c3.m.f4505a;
        Object obj = f4381e.get(this);
        if (obj == rVar) {
            return null;
        }
        return obj;
    }

    public final void b(Object obj) {
        int i4;
        c3.c[] cVarArr;
        X.r rVar;
        if (obj == null) {
            obj = c3.m.f4505a;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4381e;
            if (Intrinsics.areEqual(atomicReferenceFieldUpdater.get(this), obj)) {
                return;
            }
            atomicReferenceFieldUpdater.set(this, obj);
            int i5 = this.f4382d;
            if ((i5 & 1) != 0) {
                this.f4382d = i5 + 2;
                return;
            }
            int i6 = i5 + 1;
            this.f4382d = i6;
            c3.c[] cVarArr2 = this.f4471a;
            Unit unit = Unit.INSTANCE;
            while (true) {
                C0371E[] c0371eArr = (C0371E[]) cVarArr2;
                if (c0371eArr != null) {
                    for (C0371E c0371e : c0371eArr) {
                        if (c0371e != null) {
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0371E.f4385a;
                                Object obj2 = atomicReferenceFieldUpdater2.get(c0371e);
                                if (obj2 != null && obj2 != (rVar = AbstractC0370D.f4384b)) {
                                    X.r rVar2 = AbstractC0370D.f4383a;
                                    if (obj2 != rVar2) {
                                        if (atomicReferenceFieldUpdater2.compareAndSet(c0371e, obj2, rVar2)) {
                                            Result.Companion companion = Result.INSTANCE;
                                            ((C0128h) obj2).resumeWith(Result.m22constructorimpl(Unit.INSTANCE));
                                            break;
                                        }
                                    } else {
                                        if (atomicReferenceFieldUpdater2.compareAndSet(c0371e, obj2, rVar)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i4 = this.f4382d;
                    if (i4 == i6) {
                        this.f4382d = i6 + 1;
                        return;
                    } else {
                        cVarArr = this.f4471a;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                cVarArr2 = cVarArr;
                i6 = i4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:61:0x00e8, B:63:0x00ee], limit reached: 93 */
    /* JADX WARN: Path cross not found for [B:63:0x00ee, B:61:0x00e8], limit reached: 93 */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8 A[Catch: all -> 0x003c, TryCatch #3 {all -> 0x003c, blocks: (B:14:0x0037, B:53:0x00d0, B:55:0x00d8, B:58:0x00df, B:59:0x00e5, B:61:0x00e8, B:71:0x0109, B:74:0x011c, B:63:0x00ee, B:67:0x00f5, B:21:0x0051), top: B:96:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e8 A[Catch: all -> 0x003c, TryCatch #3 {all -> 0x003c, blocks: (B:14:0x0037, B:53:0x00d0, B:55:0x00d8, B:58:0x00df, B:59:0x00e5, B:61:0x00e8, B:71:0x0109, B:74:0x011c, B:63:0x00ee, B:67:0x00f5, B:21:0x0051), top: B:96:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0107 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011c A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #3 {all -> 0x003c, blocks: (B:14:0x0037, B:53:0x00d0, B:55:0x00d8, B:58:0x00df, B:59:0x00e5, B:61:0x00e8, B:71:0x0109, B:74:0x011c, B:63:0x00ee, B:67:0x00f5, B:21:0x0051), top: B:96:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18, types: [b3.E] */
    /* JADX WARN: Type inference failed for: r2v19, types: [b3.E] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x011b -> B:53:0x00d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x012c -> B:53:0x00d0). Please report as a decompilation issue!!! */
    @Override // b3.InterfaceC0379h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(b3.InterfaceC0380i r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.C0369C.collect(b3.i, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // b3.InterfaceC0380i
    public final Object emit(Object obj, Continuation continuation) {
        b(obj);
        return Unit.INSTANCE;
    }
}
