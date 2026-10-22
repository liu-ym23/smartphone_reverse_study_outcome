package j6;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.p;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3530a = new g(new byte[0], 0, 0, null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f3531b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f3532c;
    public static final int d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f3533e;

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceArray f3534f;

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceArray f3535g;

    static {
        int iIntValue;
        int i8 = 0;
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f3531b = iHighestOneBit;
        int i9 = iHighestOneBit / 2;
        int i10 = i9 >= 1 ? i9 : 1;
        f3532c = i10;
        String property = System.getProperty("kotlinx.io.pool.size.bytes", p.a(System.getProperty("java.vm.name"), "Dalvik") ? "0" : "4194304");
        p.d(property, "getProperty(...)");
        Integer numD1 = u.d1(property);
        if (numD1 != null && (iIntValue = numD1.intValue()) >= 0) {
            i8 = iIntValue;
        }
        d = i8;
        int i11 = i8 / i10;
        if (i11 < 8192) {
            i11 = 8192;
        }
        f3533e = i11;
        f3534f = new AtomicReferenceArray(iHighestOneBit);
        f3535g = new AtomicReferenceArray(i10);
    }

    public static final void a(g segment) {
        g gVar = f3530a;
        p.e(segment, "segment");
        if (segment.f3528f != null || segment.f3529g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        k kVar = segment.d;
        if (kVar != null) {
            f fVar = (f) kVar;
            if (fVar.f3523b != 0) {
                int iDecrementAndGet = f.f3522c.decrementAndGet(fVar);
                if (iDecrementAndGet >= 0) {
                    return;
                }
                if (iDecrementAndGet != -1) {
                    throw new IllegalStateException(("Shared copies count is negative: " + (iDecrementAndGet + 1)).toString());
                }
                fVar.f3523b = 0;
            }
        }
        AtomicReferenceArray atomicReferenceArray = f3534f;
        int id = (int) ((f3531b - 1) & Thread.currentThread().getId());
        segment.f3525b = 0;
        segment.f3527e = true;
        while (true) {
            g gVar2 = (g) atomicReferenceArray.get(id);
            if (gVar2 != gVar) {
                int i8 = gVar2 != null ? gVar2.f3526c : 0;
                if (i8 < 65536) {
                    segment.f3528f = gVar2;
                    segment.f3526c = i8 + 8192;
                    while (!atomicReferenceArray.compareAndSet(id, gVar2, segment)) {
                        if (atomicReferenceArray.get(id) != gVar2) {
                            break;
                        }
                    }
                    return;
                }
                if (d <= 0) {
                    return;
                }
                segment.f3525b = 0;
                segment.f3527e = true;
                int id2 = (int) ((f3532c - 1) & Thread.currentThread().getId());
                AtomicReferenceArray atomicReferenceArray2 = f3535g;
                int i9 = 0;
                while (true) {
                    g gVar3 = (g) atomicReferenceArray2.get(id2);
                    if (gVar3 != gVar) {
                        int i10 = (gVar3 != null ? gVar3.f3526c : 0) + 8192;
                        if (i10 <= f3533e) {
                            segment.f3528f = gVar3;
                            segment.f3526c = i10;
                            while (!atomicReferenceArray2.compareAndSet(id2, gVar3, segment)) {
                                if (atomicReferenceArray2.get(id2) != gVar3) {
                                    break;
                                }
                            }
                            return;
                        }
                        int i11 = f3532c;
                        if (i9 >= i11) {
                            return;
                        }
                        i9++;
                        id2 = (id2 + 1) & (i11 - 1);
                    }
                }
            }
        }
    }

    public static final g b() {
        AtomicReferenceArray atomicReferenceArray;
        g gVar;
        g gVar2;
        int id = (int) ((f3531b - 1) & Thread.currentThread().getId());
        do {
            atomicReferenceArray = f3534f;
            gVar = f3530a;
            gVar2 = (g) atomicReferenceArray.getAndSet(id, gVar);
        } while (p.a(gVar2, gVar));
        if (gVar2 != null) {
            atomicReferenceArray.set(id, gVar2.f3528f);
            gVar2.f3528f = null;
            gVar2.f3526c = 0;
            return gVar2;
        }
        atomicReferenceArray.set(id, null);
        if (d <= 0) {
            return new g();
        }
        int i8 = f3532c;
        int id2 = (int) (Thread.currentThread().getId() & (i8 - 1));
        int i9 = 0;
        while (true) {
            AtomicReferenceArray atomicReferenceArray2 = f3535g;
            g gVar3 = (g) atomicReferenceArray2.getAndSet(id2, gVar);
            if (!p.a(gVar3, gVar)) {
                if (gVar3 != null) {
                    atomicReferenceArray2.set(id2, gVar3.f3528f);
                    gVar3.f3528f = null;
                    gVar3.f3526c = 0;
                    return gVar3;
                }
                atomicReferenceArray2.set(id2, null);
                if (i9 >= i8) {
                    return new g();
                }
                id2 = (id2 + 1) & (i8 - 1);
                i9++;
            }
        }
    }
}
