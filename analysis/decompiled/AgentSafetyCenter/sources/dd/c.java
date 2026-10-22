package dd;

import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public d f3305a;

    /* renamed from: b, reason: collision with root package name */
    public String f3306b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3307c;

    /* renamed from: d, reason: collision with root package name */
    public a f3308d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3309e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3310f;

    public final void a() {
        byte[] bArr = bd.b.f2074a;
        synchronized (this.f3305a) {
            if (b()) {
                this.f3305a.d(this);
            }
        }
    }

    public final boolean b() {
        ArrayList arrayList = this.f3309e;
        a aVar = this.f3308d;
        if (aVar != null && aVar.f3300b) {
            this.f3310f = true;
        }
        boolean z10 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f3300b) {
                a aVar2 = (a) arrayList.get(size);
                d dVar = d.f3311h;
                if (d.i.isLoggable(Level.FINE)) {
                    a.a.g(aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    public final void c(a aVar, long j10) {
        aVar.getClass();
        synchronized (this.f3305a) {
            if (!this.f3307c) {
                if (d(aVar, j10, false)) {
                    this.f3305a.d(this);
                }
            } else if (aVar.f3300b) {
                d dVar = d.f3311h;
                if (d.i.isLoggable(Level.FINE)) {
                    a.a.g(aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                d dVar2 = d.f3311h;
                if (d.i.isLoggable(Level.FINE)) {
                    a.a.g(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(dd.a r11, long r12, boolean r14) {
        /*
            r10 = this;
            java.util.ArrayList r0 = r10.f3309e
            r11.getClass()
            dd.c r1 = r11.f3301c
            r2 = 0
            if (r1 != r10) goto Lb
            goto Lf
        Lb:
            if (r1 != 0) goto L8b
            r11.f3301c = r10
        Lf:
            long r3 = java.lang.System.nanoTime()
            long r5 = r3 + r12
            int r1 = r0.indexOf(r11)
            r7 = -1
            if (r1 == r7) goto L37
            long r8 = r11.f3302d
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 > 0) goto L34
            dd.d r12 = dd.d.f3311h
            java.util.logging.Logger r12 = dd.d.i
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r12 = r12.isLoggable(r13)
            if (r12 == 0) goto L8a
            java.lang.String r12 = "already scheduled"
            a.a.g(r11, r10, r12)
            return r2
        L34:
            r0.remove(r1)
        L37:
            r11.f3302d = r5
            dd.d r1 = dd.d.f3311h
            java.util.logging.Logger r1 = dd.d.i
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            boolean r1 = r1.isLoggable(r8)
            if (r1 == 0) goto L61
            if (r14 == 0) goto L53
            long r5 = r5 - r3
            java.lang.String r14 = a.a.w(r5)
            java.lang.String r1 = "run again after "
            java.lang.String r14 = r1.concat(r14)
            goto L5e
        L53:
            long r5 = r5 - r3
            java.lang.String r14 = a.a.w(r5)
            java.lang.String r1 = "scheduled after "
            java.lang.String r14 = r1.concat(r14)
        L5e:
            a.a.g(r11, r10, r14)
        L61:
            int r10 = r0.size()
            r14 = r2
            r1 = r14
        L67:
            if (r1 >= r10) goto L7c
            java.lang.Object r5 = r0.get(r1)
            int r1 = r1 + 1
            dd.a r5 = (dd.a) r5
            long r5 = r5.f3302d
            long r5 = r5 - r3
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 <= 0) goto L79
            goto L7d
        L79:
            int r14 = r14 + 1
            goto L67
        L7c:
            r14 = r7
        L7d:
            if (r14 != r7) goto L83
            int r14 = r0.size()
        L83:
            r0.add(r14, r11)
            if (r14 != 0) goto L8a
            r10 = 1
            return r10
        L8a:
            return r2
        L8b:
            java.lang.String r10 = "task is in multiple queues"
            od.f.e(r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dd.c.d(dd.a, long, boolean):boolean");
    }

    public final void e() {
        byte[] bArr = bd.b.f2074a;
        synchronized (this.f3305a) {
            this.f3307c = true;
            if (b()) {
                this.f3305a.d(this);
            }
        }
    }

    public final String toString() {
        return this.f3306b;
    }
}
