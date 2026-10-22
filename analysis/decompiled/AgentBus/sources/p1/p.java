package p1;

import i1.f0;
import k.z;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f8321a;

    /* renamed from: b, reason: collision with root package name */
    public final c f8322b;

    /* renamed from: c, reason: collision with root package name */
    public final k.j f8323c;

    /* renamed from: d, reason: collision with root package name */
    public final z f8324d = new z(2);

    public p(f0 f0Var, c cVar, k.t tVar) {
        this.f8321a = f0Var;
        this.f8322b = cVar;
        this.f8323c = tVar;
    }

    public final n a() {
        return new n(this.f8322b, false, this.f8321a, new i());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(i1.f0 r13, p1.i r14) {
        /*
            r12 = this;
            k.z r12 = r12.f8324d
            java.lang.Object[] r0 = r12.f5556a
            int r12 = r12.f5557b
            r1 = 0
            r2 = r1
        L8:
            if (r2 >= r12) goto L9d
            r3 = r0[r2]
            o0.b r3 = (o0.b) r3
            k.u r4 = r3.f7178g
            j1.y r5 = r3.f7174c
            a7.d r3 = r3.f7172a
            p1.i r6 = r13.q()
            int r7 = r13.f4453g
            r8 = 0
            if (r14 == 0) goto L2f
            p1.v r9 = p1.s.B
            k.a0 r10 = r14.f8304f
            java.lang.Object r9 = r10.g(r9)
            if (r9 != 0) goto L28
            r9 = r8
        L28:
            s1.e r9 = (s1.e) r9
            if (r9 == 0) goto L2f
            java.lang.String r9 = r9.f9246g
            goto L30
        L2f:
            r9 = r8
        L30:
            if (r6 == 0) goto L43
            p1.v r10 = p1.s.B
            k.a0 r11 = r6.f8304f
            java.lang.Object r10 = r11.g(r10)
            if (r10 != 0) goto L3d
            r10 = r8
        L3d:
            s1.e r10 = (s1.e) r10
            if (r10 == 0) goto L43
            java.lang.String r8 = r10.f9246g
        L43:
            r10 = 1
            if (r9 == r8) goto L71
            if (r9 != 0) goto L4c
            r3.w(r5, r7, r10)
            goto L71
        L4c:
            if (r8 != 0) goto L52
            r3.w(r5, r7, r1)
            goto L71
        L52:
            p1.v r9 = p1.s.f8361r
            java.lang.Object r9 = p1.q.d(r6, r9)
            o0.c r9 = (o0.c) r9
            o0.c r11 = o0.i.f7183a
            boolean r9 = q7.k.a(r9, r11)
            if (r9 == 0) goto L71
            java.lang.String r8 = r8.toString()
            android.view.autofill.AutofillValue r8 = android.view.autofill.AutofillValue.forText(r8)
            java.lang.Object r3 = r3.f411g
            android.view.autofill.AutofillManager r3 = (android.view.autofill.AutofillManager) r3
            r3.notifyValueChanged(r5, r7, r8)
        L71:
            if (r14 == 0) goto L7f
            k.a0 r3 = r14.f8304f
            p1.v r5 = p1.s.f8360q
            boolean r3 = r3.b(r5)
            if (r3 != r10) goto L7f
            r3 = r10
            goto L80
        L7f:
            r3 = r1
        L80:
            if (r6 == 0) goto L8d
            k.a0 r5 = r6.f8304f
            p1.v r6 = p1.s.f8360q
            boolean r5 = r5.b(r6)
            if (r5 != r10) goto L8d
            goto L8e
        L8d:
            r10 = r1
        L8e:
            if (r3 == r10) goto L99
            if (r10 == 0) goto L96
            r4.a(r7)
            goto L99
        L96:
            r4.e(r7)
        L99:
            int r2 = r2 + 1
            goto L8
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.p.b(i1.f0, p1.i):void");
    }
}
