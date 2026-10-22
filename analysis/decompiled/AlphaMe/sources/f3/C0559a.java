package f3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import org.jetbrains.annotations.Nullable;

/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0559a extends Thread {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12545i = AtomicIntegerFieldUpdater.newUpdater(C0559a.class, "workerCtl");

    /* renamed from: a, reason: collision with root package name */
    public final l f12546a;

    /* renamed from: b, reason: collision with root package name */
    public final Ref.ObjectRef f12547b;

    /* renamed from: c, reason: collision with root package name */
    public int f12548c;

    /* renamed from: d, reason: collision with root package name */
    public long f12549d;

    /* renamed from: e, reason: collision with root package name */
    public long f12550e;

    /* renamed from: f, reason: collision with root package name */
    public int f12551f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12552g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f12553h;
    private volatile int indexInArray;

    @Nullable
    private volatile Object nextParkedWorker;

    @Volatile
    private volatile int workerCtl;

    public C0559a(b bVar, int i4) {
        this.f12553h = bVar;
        setDaemon(true);
        this.f12546a = new l();
        this.f12547b = new Ref.ObjectRef();
        this.f12548c = 4;
        this.nextParkedWorker = b.f12557k;
        this.f12551f = Random.INSTANCE.nextInt();
        f(i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f3.h a(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.f12548c
            r1 = 1
            r2 = 0
            f3.l r3 = r11.f12546a
            f3.b r4 = r11.f12553h
            if (r0 != r1) goto Lc
            goto L7f
        Lc:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f3.b.f12555i
        Le:
            f3.b r6 = r11.f12553h
            long r7 = r0.get(r6)
            r9 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r7
            r5 = 42
            long r9 = r9 >> r5
            int r5 = (int) r9
            if (r5 != 0) goto L6e
            r3.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f3.l.f12582b
            java.lang.Object r0 = r12.get(r3)
            f3.h r0 = (f3.h) r0
            if (r0 != 0) goto L2e
            goto L3c
        L2e:
            E3.b r5 = r0.f12571b
            int r5 = r5.f411a
            if (r5 != r1) goto L3c
            boolean r12 = r12.compareAndSet(r3, r0, r2)
            if (r12 == 0) goto L23
            r2 = r0
            goto L5c
        L3c:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = f3.l.f12584d
            int r12 = r12.get(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f3.l.f12583c
            int r0 = r0.get(r3)
        L48:
            if (r12 == r0) goto L5c
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = f3.l.f12585e
            int r5 = r5.get(r3)
            if (r5 != 0) goto L53
            goto L5c
        L53:
            int r0 = r0 + (-1)
            f3.h r5 = r3.c(r0, r1)
            if (r5 == 0) goto L48
            r2 = r5
        L5c:
            if (r2 != 0) goto L6d
            f3.e r12 = r4.f12563f
            java.lang.Object r12 = r12.c()
            r2 = r12
            f3.h r2 = (f3.h) r2
            if (r2 != 0) goto L6d
            f3.h r2 = r11.i(r1)
        L6d:
            return r2
        L6e:
            r9 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r9 = r7 - r9
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = f3.b.f12555i
            boolean r5 = r5.compareAndSet(r6, r7, r9)
            if (r5 == 0) goto Le
            r11.f12548c = r1
        L7f:
            if (r12 == 0) goto Lb3
            int r12 = r4.f12558a
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L8c
            goto L8d
        L8c:
            r1 = 0
        L8d:
            if (r1 == 0) goto L96
            f3.h r12 = r11.e()
            if (r12 == 0) goto L96
            goto Lbf
        L96:
            r3.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f3.l.f12582b
            java.lang.Object r12 = r12.getAndSet(r3, r2)
            f3.h r12 = (f3.h) r12
            if (r12 != 0) goto La7
            f3.h r12 = r3.b()
        La7:
            if (r12 == 0) goto Laa
            goto Lbf
        Laa:
            if (r1 != 0) goto Lba
            f3.h r12 = r11.e()
            if (r12 == 0) goto Lba
            goto Lbf
        Lb3:
            f3.h r12 = r11.e()
            if (r12 == 0) goto Lba
            goto Lbf
        Lba:
            r12 = 3
            f3.h r12 = r11.i(r12)
        Lbf:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.C0559a.a(boolean):f3.h");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i4) {
        int i5 = this.f12551f;
        int i6 = i5 ^ (i5 << 13);
        int i7 = i6 ^ (i6 >> 17);
        int i8 = i7 ^ (i7 << 5);
        this.f12551f = i8;
        int i9 = i4 - 1;
        return (i9 & i4) == 0 ? i9 & i8 : (Integer.MAX_VALUE & i8) % i4;
    }

    public final h e() {
        int iD = d(2);
        b bVar = this.f12553h;
        if (iD == 0) {
            h hVar = (h) bVar.f12562e.c();
            return hVar != null ? hVar : (h) bVar.f12563f.c();
        }
        h hVar2 = (h) bVar.f12563f.c();
        return hVar2 != null ? hVar2 : (h) bVar.f12562e.c();
    }

    public final void f(int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12553h.f12561d);
        sb.append("-worker-");
        sb.append(i4 == 0 ? "TERMINATED" : String.valueOf(i4));
        setName(sb.toString());
        this.indexInArray = i4;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i4) {
        int i5 = this.f12548c;
        boolean z4 = i5 == 1;
        if (z4) {
            b.f12555i.addAndGet(this.f12553h, 4398046511104L);
        }
        if (i5 != i4) {
            this.f12548c = i4;
        }
        return z4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r19 = r6;
        r6 = -2;
        r5 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [T, f3.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [f3.h] */
    /* JADX WARN: Type inference failed for: r7v9, types: [f3.h] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f3.h i(int r24) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.C0559a.i(int):f3.h");
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.C0559a.run():void");
    }
}
