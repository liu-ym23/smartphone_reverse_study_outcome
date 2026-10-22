package pa;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q7.v;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8530n = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: f, reason: collision with root package name */
    public final m f8531f;

    /* renamed from: g, reason: collision with root package name */
    public final v f8532g;

    /* renamed from: h, reason: collision with root package name */
    public b f8533h;

    /* renamed from: i, reason: collision with root package name */
    public long f8534i;
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public long f8535j;

    /* renamed from: k, reason: collision with root package name */
    public int f8536k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8537l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f8538m;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i2) {
        this.f8538m = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f8531f = new m();
        this.f8532g = new v();
        this.f8533h = b.f8542i;
        this.nextParkedWorker = c.f8548p;
        int iNanoTime = (int) System.nanoTime();
        this.f8536k = iNanoTime == 0 ? 42 : iNanoTime;
        f(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r12 = pa.m.f8573d.get(r10);
        r0 = pa.m.f8572c.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r12 == r0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (pa.m.f8574e.get(r10) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r0 = r0 - 1;
        r1 = r10.c(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r1 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r8 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final pa.i a(boolean r12) {
        /*
            r11 = this;
            pa.b r0 = r11.f8533h
            pa.b r1 = pa.b.f8539f
            pa.c r3 = r11.f8538m
            r8 = 0
            r9 = 1
            pa.m r10 = r11.f8531f
            if (r0 != r1) goto Le
            goto L87
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pa.c.f8546n
        L10:
            long r4 = r0.get(r3)
            r1 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r1 = r1 & r4
            r6 = 42
            long r1 = r1 >> r6
            int r1 = (int) r1
            if (r1 != 0) goto L74
            r10.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = pa.m.f8571b
            java.lang.Object r0 = r12.get(r10)
            pa.i r0 = (pa.i) r0
            if (r0 != 0) goto L2e
            goto L41
        L2e:
            boolean r1 = r0.f8562g
            if (r1 != r9) goto L41
        L32:
            boolean r1 = r12.compareAndSet(r10, r0, r8)
            if (r1 == 0) goto L3a
            r8 = r0
            goto L61
        L3a:
            java.lang.Object r1 = r12.get(r10)
            if (r1 == r0) goto L32
            goto L23
        L41:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = pa.m.f8573d
            int r12 = r12.get(r10)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = pa.m.f8572c
            int r0 = r0.get(r10)
        L4d:
            if (r12 == r0) goto L61
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = pa.m.f8574e
            int r1 = r1.get(r10)
            if (r1 != 0) goto L58
            goto L61
        L58:
            int r0 = r0 + (-1)
            pa.i r1 = r10.c(r0, r9)
            if (r1 == 0) goto L4d
            r8 = r1
        L61:
            if (r8 != 0) goto L73
            pa.f r12 = r3.f8554k
            java.lang.Object r12 = r12.d()
            pa.i r12 = (pa.i) r12
            if (r12 != 0) goto L72
            pa.i r11 = r11.i(r9)
            return r11
        L72:
            return r12
        L73:
            return r8
        L74:
            r1 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r6 = r4 - r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = pa.c.f8546n
            boolean r1 = r2.compareAndSet(r3, r4, r6)
            if (r1 == 0) goto L10
            pa.b r0 = pa.b.f8539f
            r11.f8533h = r0
        L87:
            if (r12 == 0) goto Lbb
            int r12 = r3.f8549f
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L94
            goto L95
        L94:
            r9 = 0
        L95:
            if (r9 == 0) goto L9e
            pa.i r12 = r11.e()
            if (r12 == 0) goto L9e
            return r12
        L9e:
            r10.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = pa.m.f8571b
            java.lang.Object r12 = r12.getAndSet(r10, r8)
            pa.i r12 = (pa.i) r12
            if (r12 != 0) goto Laf
            pa.i r12 = r10.b()
        Laf:
            if (r12 == 0) goto Lb2
            return r12
        Lb2:
            if (r9 != 0) goto Lc2
            pa.i r12 = r11.e()
            if (r12 == 0) goto Lc2
            return r12
        Lbb:
            pa.i r12 = r11.e()
            if (r12 == 0) goto Lc2
            return r12
        Lc2:
            r12 = 3
            pa.i r11 = r11.i(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.a.a(boolean):pa.i");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i2) {
        int i10 = this.f8536k;
        int i11 = i10 ^ (i10 << 13);
        int i12 = i11 ^ (i11 >> 17);
        int i13 = i12 ^ (i12 << 5);
        this.f8536k = i13;
        int i14 = i2 - 1;
        return (i14 & i2) == 0 ? i14 & i13 : (Integer.MAX_VALUE & i13) % i2;
    }

    public final i e() {
        int iD = d(2);
        c cVar = this.f8538m;
        if (iD == 0) {
            i iVar = (i) cVar.f8553j.d();
            return iVar != null ? iVar : (i) cVar.f8554k.d();
        }
        i iVar2 = (i) cVar.f8554k.d();
        return iVar2 != null ? iVar2 : (i) cVar.f8553j.d();
    }

    public final void f(int i2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8538m.f8552i);
        sb2.append("-worker-");
        sb2.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
        setName(sb2.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f8533h;
        boolean z4 = bVar2 == b.f8539f;
        if (z4) {
            c.f8546n.addAndGet(this.f8538m, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f8533h = bVar;
        }
        return z4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        r7 = -2;
        r5 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final pa.i i(int r26) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.a.i(int):pa.i");
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.a.run():void");
    }
}
