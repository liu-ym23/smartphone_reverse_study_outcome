package h6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3036j = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final m f3037a;

    /* renamed from: b, reason: collision with root package name */
    public final y f3038b;

    /* renamed from: c, reason: collision with root package name */
    public b f3039c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public long f3040e;

    /* renamed from: f, reason: collision with root package name */
    public int f3041f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3042g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f3043h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i8) {
        this.f3043h = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f3037a = new m();
        this.f3038b = new y();
        this.f3039c = b.d;
        this.nextParkedWorker = c.f3052l;
        int iNanoTime = (int) System.nanoTime();
        this.f3041f = iNanoTime == 0 ? 42 : iNanoTime;
        f(i8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r12 = h6.m.d.get(r10);
        r0 = h6.m.f3072c.get(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r12 == r0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (h6.m.f3073e.get(r10) != 0) goto L25;
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
    public final h6.i a(boolean r12) {
        /*
            r11 = this;
            h6.b r0 = r11.f3039c
            h6.b r1 = h6.b.f3044a
            h6.c r3 = r11.f3043h
            r8 = 0
            r9 = 1
            h6.m r10 = r11.f3037a
            if (r0 != r1) goto Le
            goto L87
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = h6.c.f3050j
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = h6.m.f3071b
            java.lang.Object r0 = r12.get(r10)
            h6.i r0 = (h6.i) r0
            if (r0 != 0) goto L2e
            goto L41
        L2e:
            boolean r1 = r0.f3063b
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
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = h6.m.d
            int r12 = r12.get(r10)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = h6.m.f3072c
            int r0 = r0.get(r10)
        L4d:
            if (r12 == r0) goto L61
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = h6.m.f3073e
            int r1 = r1.get(r10)
            if (r1 != 0) goto L58
            goto L61
        L58:
            int r0 = r0 + (-1)
            h6.i r1 = r10.c(r0, r9)
            if (r1 == 0) goto L4d
            r8 = r1
        L61:
            if (r8 != 0) goto L73
            h6.f r12 = r3.f3057f
            java.lang.Object r12 = r12.d()
            h6.i r12 = (h6.i) r12
            if (r12 != 0) goto L72
            h6.i r11 = r11.i(r9)
            return r11
        L72:
            return r12
        L73:
            return r8
        L74:
            r1 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r6 = r4 - r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = h6.c.f3050j
            boolean r1 = r2.compareAndSet(r3, r4, r6)
            if (r1 == 0) goto L10
            h6.b r0 = h6.b.f3044a
            r11.f3039c = r0
        L87:
            if (r12 == 0) goto Lbb
            int r12 = r3.f3053a
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L94
            goto L95
        L94:
            r9 = 0
        L95:
            if (r9 == 0) goto L9e
            h6.i r12 = r11.e()
            if (r12 == 0) goto L9e
            return r12
        L9e:
            r10.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = h6.m.f3071b
            java.lang.Object r12 = r12.getAndSet(r10, r8)
            h6.i r12 = (h6.i) r12
            if (r12 != 0) goto Laf
            h6.i r12 = r10.b()
        Laf:
            if (r12 == 0) goto Lb2
            return r12
        Lb2:
            if (r9 != 0) goto Lc2
            h6.i r12 = r11.e()
            if (r12 == 0) goto Lc2
            return r12
        Lbb:
            h6.i r12 = r11.e()
            if (r12 == 0) goto Lc2
            return r12
        Lc2:
            r12 = 3
            h6.i r11 = r11.i(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.a.a(boolean):h6.i");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i8) {
        int i9 = this.f3041f;
        int i10 = i9 ^ (i9 << 13);
        int i11 = i10 ^ (i10 >> 17);
        int i12 = i11 ^ (i11 << 5);
        this.f3041f = i12;
        int i13 = i8 - 1;
        return (i13 & i8) == 0 ? i13 & i12 : (Integer.MAX_VALUE & i12) % i8;
    }

    public final i e() {
        int iD = d(2);
        c cVar = this.f3043h;
        if (iD == 0) {
            i iVar = (i) cVar.f3056e.d();
            return iVar != null ? iVar : (i) cVar.f3057f.d();
        }
        i iVar2 = (i) cVar.f3057f.d();
        return iVar2 != null ? iVar2 : (i) cVar.f3056e.d();
    }

    public final void f(int i8) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3043h.d);
        sb.append("-worker-");
        sb.append(i8 == 0 ? "TERMINATED" : String.valueOf(i8));
        setName(sb.toString());
        this.indexInArray = i8;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f3039c;
        boolean z = bVar2 == b.f3044a;
        if (z) {
            c.f3050j.addAndGet(this.f3043h, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f3039c = bVar;
        }
        return z;
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
    public final h6.i i(int r26) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.a.i(int):h6.i");
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
        throw new UnsupportedOperationException("Method not decompiled: h6.a.run():void");
    }
}
