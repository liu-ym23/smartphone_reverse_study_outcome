package c6;

import b5.a0;
import kotlin.jvm.internal.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n extends c {

    /* renamed from: l, reason: collision with root package name */
    public final a f1144l;

    public n(int i8, a aVar) {
        super(i8);
        this.f1144l = aVar;
        if (aVar != a.f1102a) {
            if (i8 < 1) {
                throw new IllegalArgumentException(a8.b.k(i8, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + z.a(c.class).b() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(java.lang.Object r16, boolean r17) throws a6.o0 {
        /*
            r15 = this;
            c6.a r1 = r15.f1144l
            c6.a r2 = c6.a.f1104c
            b5.a0 r8 = b5.a0.f883a
            if (r1 != r2) goto L17
            java.lang.Object r0 = super.k(r16)
            boolean r1 = r0 instanceof c6.i
            if (r1 == 0) goto L16
            boolean r1 = r0 instanceof c6.h
            if (r1 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r0
        L17:
            androidx.emoji2.text.r r6 = c6.e.d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = c6.c.f1111f
            java.lang.Object r1 = r1.get(r15)
            c6.k r1 = (c6.k) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = c6.c.f1108b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.v(r2, r7)
            int r9 = c6.e.f1119b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f2659c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            c6.k r2 = c6.c.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r0 = r15.s()
            c6.h r1 = new c6.h
            r1.<init>(r0)
            return r1
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = c6.c.g(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.b()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = c6.c.f1109c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.b()
        L7e:
            java.lang.Throwable r0 = r15.s()
            c6.h r1 = new c6.h
            r1.<init>(r0)
            return r1
        L88:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L90:
            if (r7 == 0) goto L9f
            r1.i()
            java.lang.Throwable r0 = r15.s()
            c6.h r1 = new c6.h
            r1.<init>(r0)
            return r1
        L9f:
            boolean r3 = r6 instanceof a6.g2
            if (r3 == 0) goto La6
            a6.g2 r6 = (a6.g2) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.b(r1, r12)
        Lae:
            long r3 = r1.f2659c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.n(r3)
        Lb6:
            return r8
        Lb7:
            r1.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.n.G(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // c6.c, c6.r
    public final Object d(f5.c cVar, Object obj) throws Throwable {
        if (G(obj, true) instanceof h) {
            throw s();
        }
        return a0.f883a;
    }

    @Override // c6.c, c6.r
    public final Object k(Object obj) {
        return G(obj, false);
    }

    @Override // c6.c
    public final boolean w() {
        return this.f1144l == a.f1103b;
    }
}
