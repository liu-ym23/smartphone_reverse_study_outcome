package u9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState;

/* renamed from: u9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2051a extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(C2051a.class, "workerCtl$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final l f6740a;
    public final Ref$ObjectRef b;
    public CoroutineScheduler$WorkerState c;
    public long d;
    public long e;
    public int f;
    public boolean g;
    public final /* synthetic */ b h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public C2051a(b bVar, int i6) {
        this.h = bVar;
        setDaemon(true);
        setContextClassLoader(b.class.getClassLoader());
        this.f6740a = new l();
        this.b = new Ref$ObjectRef();
        this.c = CoroutineScheduler$WorkerState.d;
        this.nextParkedWorker = b.k;
        int iNanoTime = (int) System.nanoTime();
        this.f = iNanoTime == 0 ? 42 : iNanoTime;
        g(i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final u9.h a(boolean r12) {
        /*
            r11 = this;
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = r11.c
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.f5252a
            u9.b r3 = r11.h
            r8 = 0
            r9 = 1
            u9.l r10 = r11.f6740a
            if (r0 != r1) goto Le
            goto L80
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = u9.b.i
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
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = u9.l.b
            java.lang.Object r0 = r12.get(r10)
            u9.h r0 = (u9.h) r0
            if (r0 != 0) goto L2e
            goto L3a
        L2e:
            boolean r1 = r0.b
            if (r1 != r9) goto L3a
            boolean r12 = r12.compareAndSet(r10, r0, r8)
            if (r12 == 0) goto L23
            r8 = r0
            goto L5a
        L3a:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = u9.l.d
            int r12 = r12.get(r10)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = u9.l.c
            int r0 = r0.get(r10)
        L46:
            if (r12 == r0) goto L5a
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = u9.l.e
            int r1 = r1.get(r10)
            if (r1 != 0) goto L51
            goto L5a
        L51:
            int r0 = r0 + (-1)
            u9.h r1 = r10.c(r0, r9)
            if (r1 == 0) goto L46
            r8 = r1
        L5a:
            if (r8 != 0) goto L6c
            u9.e r12 = r3.f
            java.lang.Object r12 = r12.c()
            u9.h r12 = (u9.h) r12
            if (r12 != 0) goto L6b
            u9.h r11 = r11.j(r9)
            return r11
        L6b:
            return r12
        L6c:
            return r8
        L6d:
            r1 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r6 = r4 - r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = u9.b.i
            boolean r1 = r2.compareAndSet(r3, r4, r6)
            if (r1 == 0) goto L10
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.f5252a
            r11.c = r0
        L80:
            if (r12 == 0) goto Lb4
            int r12 = r3.f6742a
            int r12 = r12 * 2
            int r12 = r11.e(r12)
            if (r12 != 0) goto L8d
            goto L8e
        L8d:
            r9 = 0
        L8e:
            if (r9 == 0) goto L97
            u9.h r12 = r11.f()
            if (r12 == 0) goto L97
            return r12
        L97:
            r10.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = u9.l.b
            java.lang.Object r12 = r12.getAndSet(r10, r8)
            u9.h r12 = (u9.h) r12
            if (r12 != 0) goto La8
            u9.h r12 = r10.b()
        La8:
            if (r12 == 0) goto Lab
            return r12
        Lab:
            if (r9 != 0) goto Lbb
            u9.h r12 = r11.f()
            if (r12 == 0) goto Lbb
            return r12
        Lb4:
            u9.h r12 = r11.f()
            if (r12 == 0) goto Lbb
            return r12
        Lbb:
            r12 = 3
            u9.h r11 = r11.j(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.C2051a.a(boolean):u9.h");
    }

    public final int c() {
        return this.indexInArray;
    }

    public final Object d() {
        return this.nextParkedWorker;
    }

    public final int e(int i6) {
        int i10 = this.f;
        int i11 = i10 ^ (i10 << 13);
        int i12 = i11 ^ (i11 >> 17);
        int i13 = i12 ^ (i12 << 5);
        this.f = i13;
        int i14 = i6 - 1;
        return (i14 & i6) == 0 ? i14 & i13 : (Integer.MAX_VALUE & i13) % i6;
    }

    public final h f() {
        int iE = e(2);
        b bVar = this.h;
        if (iE == 0) {
            h hVar = (h) bVar.e.c();
            return hVar != null ? hVar : (h) bVar.f.c();
        }
        h hVar2 = (h) bVar.f.c();
        return hVar2 != null ? hVar2 : (h) bVar.e.c();
    }

    public final void g(int i6) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h.d);
        sb.append("-worker-");
        sb.append(i6 == 0 ? "TERMINATED" : String.valueOf(i6));
        setName(sb.toString());
        this.indexInArray = i6;
    }

    public final void h(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean i(CoroutineScheduler$WorkerState coroutineScheduler$WorkerState) {
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState2 = this.c;
        boolean z10 = coroutineScheduler$WorkerState2 == CoroutineScheduler$WorkerState.f5252a;
        if (z10) {
            b.i.addAndGet(this.h, 4398046511104L);
        }
        if (coroutineScheduler$WorkerState2 != coroutineScheduler$WorkerState) {
            this.c = coroutineScheduler$WorkerState;
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
    public final u9.h j(int r27) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.C2051a.j(int):u9.h");
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
        throw new UnsupportedOperationException("Method not decompiled: u9.C2051a.run():void");
    }
}
