package n1;

import kc.t;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public g f8626a;

    /* renamed from: b, reason: collision with root package name */
    public g f8627b;

    /* renamed from: c, reason: collision with root package name */
    public l f8628c = new ad.l(this, 15);

    /* renamed from: d, reason: collision with root package name */
    public t f8629d;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        if (r0 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
    
        if (r0 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r8, long r10, pb.c r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof n1.b
            if (r0 == 0) goto L14
            r0 = r12
            n1.b r0 = (n1.b) r0
            int r1 = r0.f8622g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f8622g = r1
        L12:
            r12 = r0
            goto L1a
        L14:
            n1.b r0 = new n1.b
            r0.<init>(r7, r12)
            goto L12
        L1a:
            java.lang.Object r0 = r12.f8620c
            ob.a r1 = ob.a.f9351c
            int r2 = r12.f8622g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2c
            id.c.I(r0)
            goto L7c
        L2c:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L33:
            id.c.I(r0)
            goto L5c
        L37:
            id.c.I(r0)
            n1.g r0 = r7.f8626a
            r2 = 0
            if (r0 == 0) goto L4a
            boolean r5 = r0.f15126r
            if (r5 == 0) goto L4a
            u1.a2 r0 = u1.f.j(r0)
            n1.g r0 = (n1.g) r0
            goto L4b
        L4a:
            r0 = r2
        L4b:
            r5 = 0
            if (r0 != 0) goto L61
            n1.g r7 = r7.f8627b
            if (r7 == 0) goto L80
            r12.f8622g = r4
            java.lang.Object r0 = r7.S(r8, r10, r12)
            if (r0 != r1) goto L5c
            goto L7b
        L5c:
            o2.p r0 = (o2.p) r0
            long r5 = r0.f9131a
            goto L80
        L61:
            n1.g r7 = r7.f8626a
            if (r7 == 0) goto L70
            boolean r0 = r7.f15126r
            if (r0 == 0) goto L70
            u1.a2 r7 = u1.f.j(r7)
            r2 = r7
            n1.g r2 = (n1.g) r2
        L70:
            r7 = r2
            if (r7 == 0) goto L80
            r12.f8622g = r3
            java.lang.Object r0 = r7.S(r8, r10, r12)
            if (r0 != r1) goto L7c
        L7b:
            return r1
        L7c:
            o2.p r0 = (o2.p) r0
            long r5 = r0.f9131a
        L80:
            o2.p r7 = o2.p.a(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.d.a(long, long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r5, pb.c r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof n1.c
            if (r0 == 0) goto L13
            r0 = r7
            n1.c r0 = (n1.c) r0
            int r1 = r0.f8625g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8625g = r1
            goto L18
        L13:
            n1.c r0 = new n1.c
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f8623c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8625g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r7)
            goto L4c
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r7)
            n1.g r4 = r4.f8626a
            r7 = 0
            if (r4 == 0) goto L41
            boolean r2 = r4.f15126r
            if (r2 == 0) goto L41
            u1.a2 r4 = u1.f.j(r4)
            r7 = r4
            n1.g r7 = (n1.g) r7
        L41:
            if (r7 == 0) goto L51
            r0.f8625g = r3
            java.lang.Object r7 = r7.v(r5, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            o2.p r7 = (o2.p) r7
            long r4 = r7.f9131a
            goto L53
        L51:
            r4 = 0
        L53:
            o2.p r4 = o2.p.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.d.b(long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [xb.a, yb.l] */
    public final t c() {
        t tVar = (t) this.f8628c.invoke();
        if (tVar != null) {
            return tVar;
        }
        od.f.e("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        return null;
    }
}
