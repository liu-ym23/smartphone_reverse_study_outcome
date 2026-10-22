package i6;

import a6.i0;
import androidx.emoji2.text.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends h implements a {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3154h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public c() {
        super(1);
        this.owner$volatile = d.f3155a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r5 = r0.f3153b;
        i6.c.f3154h.set(r5, null);
        r2 = r0.f3152a;
        r2.B(r1, r2.f209c, new a6.l(0, new c5.a(r5, r0)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(f5.c r6) throws a6.o0 {
        /*
            r5 = this;
            boolean r0 = r5.d()
            b5.a0 r1 = b5.a0.f883a
            if (r0 == 0) goto L9
            goto L50
        L9:
            f5.c r6 = b8.h.u(r6)
            a6.m r6 = a6.i0.m(r6)
            i6.b r0 = new i6.b     // Catch: java.lang.Throwable -> L51
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = i6.h.f3161g     // Catch: java.lang.Throwable -> L51
            int r2 = r2.getAndDecrement(r5)     // Catch: java.lang.Throwable -> L51
            int r3 = r5.f3162a     // Catch: java.lang.Throwable -> L51
            if (r2 > r3) goto L16
            if (r2 <= 0) goto L3d
            i6.c r5 = r0.f3153b     // Catch: java.lang.Throwable -> L51
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = i6.c.f3154h     // Catch: java.lang.Throwable -> L51
            r3 = 0
            r2.set(r5, r3)     // Catch: java.lang.Throwable -> L51
            a6.m r2 = r0.f3152a     // Catch: java.lang.Throwable -> L51
            c5.a r3 = new c5.a     // Catch: java.lang.Throwable -> L51
            r3.<init>(r5, r0)     // Catch: java.lang.Throwable -> L51
            int r5 = r2.f209c     // Catch: java.lang.Throwable -> L51
            a6.l r0 = new a6.l     // Catch: java.lang.Throwable -> L51
            r4 = 0
            r0.<init>(r4, r3)     // Catch: java.lang.Throwable -> L51
            r2.B(r1, r5, r0)     // Catch: java.lang.Throwable -> L51
            goto L43
        L3d:
            boolean r2 = r5.a(r0)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L16
        L43:
            java.lang.Object r5 = r6.s()
            g5.a r6 = g5.a.f2984a
            if (r5 != r6) goto L4c
            goto L4d
        L4c:
            r5 = r1
        L4d:
            if (r5 != r6) goto L50
            return r5
        L50:
            return r1
        L51:
            r5 = move-exception
            r6.A()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.c.c(f5.c):java.lang.Object");
    }

    public final boolean d() {
        int i8;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h.f3161g;
            int i9 = atomicIntegerFieldUpdater.get(this);
            int i10 = this.f3162a;
            if (i9 > i10) {
                do {
                    i8 = atomicIntegerFieldUpdater.get(this);
                    if (i8 > i10) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, i10));
            } else {
                if (i9 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i9, i9 - 1)) {
                    f3154h.set(this, null);
                    return true;
                }
            }
        }
    }

    public final void e(Object obj) {
        while (Math.max(h.f3161g.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3154h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            r rVar = d.f3155a;
            if (obj2 != rVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, rVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Mutex@");
        sb.append(i0.k(this));
        sb.append("[isLocked=");
        sb.append(Math.max(h.f3161g.get(this), 0) == 0);
        sb.append(",owner=");
        sb.append(f3154h.get(this));
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
