package a5;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d implements e {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f124e = AtomicLongFieldUpdater.newUpdater(d.class, "top");

    /* renamed from: a, reason: collision with root package name */
    public final int f125a;

    /* renamed from: b, reason: collision with root package name */
    public final int f126b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceArray f127c;
    public final int[] d;
    private volatile /* synthetic */ long top;

    public d(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "capacity should be positive but it is ").toString());
        }
        if (i8 > 536870911) {
            throw new IllegalArgumentException(a8.b.j(i8, "capacity should be less or equal to 536870911 but it is ").toString());
        }
        this.top = 0L;
        int iHighestOneBit = Integer.highestOneBit((i8 * 4) - 1) * 2;
        this.f125a = iHighestOneBit;
        this.f126b = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
        int i9 = iHighestOneBit + 1;
        this.f127c = new AtomicReferenceArray(i9);
        this.d = new int[i9];
    }

    public abstract Object b();

    @Override // java.lang.AutoCloseable
    public final void close() {
        while (e() != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        r6 = 0;
        r1 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e() {
        /*
            r10 = this;
        L0:
            long r2 = r10.top
            r0 = 0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r1 = 0
            if (r0 != 0) goto Lc
        L9:
            r6 = r1
            r1 = r10
            goto L2e
        Lc:
            r0 = 32
            long r4 = r2 >> r0
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            r8 = 1
            long r4 = r4 + r8
            long r6 = r6 & r2
            int r6 = (int) r6
            if (r6 != 0) goto L1e
            goto L9
        L1e:
            int[] r1 = r10.d
            r1 = r1[r6]
            long r4 = r4 << r0
            long r0 = (long) r1
            long r4 = r4 | r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = a5.d.f124e
            r1 = r10
            boolean r10 = r0.compareAndSet(r1, r2, r4)
            if (r10 == 0) goto L39
        L2e:
            r10 = 0
            if (r6 != 0) goto L32
            return r10
        L32:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.f127c
            java.lang.Object r10 = r0.getAndSet(r6, r10)
            return r10
        L39:
            r10 = r1
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.d.e():java.lang.Object");
    }

    public void g(Object instance) {
        p.e(instance, "instance");
    }

    @Override // a5.e
    public final Object p() {
        Object objE = e();
        return objE != null ? a(objE) : b();
    }

    @Override // a5.e
    public final void y(Object instance) {
        p.e(instance, "instance");
        g(instance);
        int iIdentityHashCode = ((System.identityHashCode(instance) * (-1640531527)) >>> this.f126b) + 1;
        int i8 = 0;
        while (i8 < 8) {
            AtomicReferenceArray atomicReferenceArray = this.f127c;
            while (!atomicReferenceArray.compareAndSet(iIdentityHashCode, null, instance)) {
                d dVar = this;
                if (atomicReferenceArray.get(iIdentityHashCode) != null) {
                    iIdentityHashCode--;
                    if (iIdentityHashCode == 0) {
                        iIdentityHashCode = dVar.f125a;
                    }
                    i8++;
                    this = dVar;
                } else {
                    this = dVar;
                }
            }
            if (iIdentityHashCode <= 0) {
                throw new IllegalArgumentException("index should be positive");
            }
            while (true) {
                long j4 = this.top;
                long j8 = ((((j4 >> 32) & 4294967295L) + 1) << 32) | iIdentityHashCode;
                this.d[iIdentityHashCode] = (int) (4294967295L & j4);
                d dVar2 = this;
                if (f124e.compareAndSet(dVar2, j4, j8)) {
                    return;
                } else {
                    this = dVar2;
                }
            }
        }
    }

    public Object a(Object obj) {
        return obj;
    }
}
