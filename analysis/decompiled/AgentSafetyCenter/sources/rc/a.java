package rc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10529m = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final l f10530c;

    /* renamed from: f, reason: collision with root package name */
    public final u f10531f;

    /* renamed from: g, reason: collision with root package name */
    public b f10532g;

    /* renamed from: h, reason: collision with root package name */
    public long f10533h;
    public long i;
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public int f10534j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10535k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c f10536l;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i) {
        this.f10536l = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        l lVar = new l();
        lVar.f10571a = new AtomicReferenceArray(128);
        VarHandle.storeStoreFence();
        this.f10530c = lVar;
        this.f10531f = new u();
        this.f10532g = b.f10540h;
        this.nextParkedWorker = c.f10545o;
        int iNanoTime = (int) System.nanoTime();
        this.f10534j = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final rc.h a(boolean r12) {
        /*
            r11 = this;
            rc.b r0 = r11.f10532g
            rc.b r1 = rc.b.f10537c
            rc.c r3 = r11.f10536l
            r8 = 0
            r9 = 1
            rc.l r10 = r11.f10530c
            if (r0 != r1) goto Le
            goto L80
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = rc.c.f10543m
        L10:
            long r4 = r0.get(r3)
            r1 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r1 = r1 & r4
            r6 = 42
            long r1 = r1 >> r6
            int r1 = (int) r1
            if (r1 != 0) goto L6d
            r10.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = rc.l.f10567b
            java.lang.Object r0 = r12.get(r10)
            rc.h r0 = (rc.h) r0
            if (r0 != 0) goto L2e
            goto L3a
        L2e:
            boolean r1 = r0.f10558f
            if (r1 != r9) goto L3a
            boolean r12 = r12.compareAndSet(r10, r0, r8)
            if (r12 == 0) goto L23
            r8 = r0
            goto L5a
        L3a:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = rc.l.f10569d
            int r12 = r12.get(r10)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = rc.l.f10568c
            int r0 = r0.get(r10)
        L46:
            if (r12 == r0) goto L5a
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = rc.l.f10570e
            int r1 = r1.get(r10)
            if (r1 != 0) goto L51
            goto L5a
        L51:
            int r0 = r0 + (-1)
            rc.h r1 = r10.c(r0, r9)
            if (r1 == 0) goto L46
            r8 = r1
        L5a:
            if (r8 != 0) goto L6c
            rc.f r12 = r3.f10550j
            java.lang.Object r12 = r12.c()
            rc.h r12 = (rc.h) r12
            if (r12 != 0) goto L6b
            rc.h r11 = r11.i(r9)
            return r11
        L6b:
            return r12
        L6c:
            return r8
        L6d:
            r1 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r6 = r4 - r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = rc.c.f10543m
            boolean r1 = r2.compareAndSet(r3, r4, r6)
            if (r1 == 0) goto L10
            rc.b r0 = rc.b.f10537c
            r11.f10532g = r0
        L80:
            if (r12 == 0) goto Lb4
            int r12 = r3.f10546c
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L8d
            goto L8e
        L8d:
            r9 = 0
        L8e:
            if (r9 == 0) goto L97
            rc.h r12 = r11.e()
            if (r12 == 0) goto L97
            return r12
        L97:
            r10.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = rc.l.f10567b
            java.lang.Object r12 = r12.getAndSet(r10, r8)
            rc.h r12 = (rc.h) r12
            if (r12 != 0) goto La8
            rc.h r12 = r10.b()
        La8:
            if (r12 == 0) goto Lab
            return r12
        Lab:
            if (r9 != 0) goto Lbb
            rc.h r12 = r11.e()
            if (r12 == 0) goto Lbb
            return r12
        Lb4:
            rc.h r12 = r11.e()
            if (r12 == 0) goto Lbb
            return r12
        Lbb:
            r12 = 3
            rc.h r11 = r11.i(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.a.a(boolean):rc.h");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i3 = this.f10534j;
        int i10 = i3 ^ (i3 << 13);
        int i11 = i10 ^ (i10 >> 17);
        int i12 = i11 ^ (i11 << 5);
        this.f10534j = i12;
        int i13 = i - 1;
        return (i13 & i) == 0 ? i13 & i12 : (Integer.MAX_VALUE & i12) % i;
    }

    public final h e() {
        int iD = d(2);
        c cVar = this.f10536l;
        f fVar = cVar.f10550j;
        f fVar2 = cVar.i;
        if (iD == 0) {
            h hVar = (h) fVar2.c();
            return hVar != null ? hVar : (h) fVar.c();
        }
        h hVar2 = (h) fVar.c();
        return hVar2 != null ? hVar2 : (h) fVar2.c();
    }

    public final void f(int i) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10536l.f10549h);
        sb2.append("-worker-");
        sb2.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb2.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f10532g;
        boolean z10 = bVar2 == b.f10537c;
        if (z10) {
            c.f10543m.addAndGet(this.f10536l, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f10532g = bVar;
        }
        return z10;
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
    public final rc.h i(int r27) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.a.i(int):rc.h");
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
        throw new UnsupportedOperationException("Method not decompiled: rc.a.run():void");
    }
}
