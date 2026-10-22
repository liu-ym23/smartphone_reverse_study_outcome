package p1;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p1.j;

/* loaded from: classes.dex */
public class u extends j {

    /* renamed from: R, reason: collision with root package name */
    public int f38213R;

    /* renamed from: P, reason: collision with root package name */
    public ArrayList<j> f38211P = new ArrayList<>();

    /* renamed from: Q, reason: collision with root package name */
    public boolean f38212Q = true;

    /* renamed from: S, reason: collision with root package name */
    public boolean f38214S = false;

    /* renamed from: T, reason: collision with root package name */
    public int f38215T = 0;

    public class a extends q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f38216a;

        public a(j jVar) {
            this.f38216a = jVar;
        }

        @Override // p1.q, p1.j.h
        public void f(j jVar) {
            this.f38216a.k0();
            jVar.g0(this);
        }
    }

    public class b extends q {
        public b() {
        }

        @Override // p1.q, p1.j.h
        public void c(j jVar) {
            u.this.f38211P.remove(jVar);
            if (u.this.R()) {
                return;
            }
            u.this.c0(j.i.f38200c, false);
            u uVar = u.this;
            uVar.f38143B = true;
            uVar.c0(j.i.f38199b, false);
        }
    }

    public static class c extends q {

        /* renamed from: a, reason: collision with root package name */
        public u f38219a;

        public c(u uVar) {
            this.f38219a = uVar;
        }

        @Override // p1.q, p1.j.h
        public void e(j jVar) {
            u uVar = this.f38219a;
            if (uVar.f38214S) {
                return;
            }
            uVar.s0();
            this.f38219a.f38214S = true;
        }

        @Override // p1.q, p1.j.h
        public void f(j jVar) {
            u uVar = this.f38219a;
            int i10 = uVar.f38213R - 1;
            uVar.f38213R = i10;
            if (i10 == 0) {
                uVar.f38214S = false;
                uVar.w();
            }
            jVar.g0(this);
        }
    }

    public final int A0(long j10) {
        for (int i10 = 1; i10 < this.f38211P.size(); i10++) {
            if (this.f38211P.get(i10).f38152K > j10) {
                return i10 - 1;
            }
        }
        return this.f38211P.size() - 1;
    }

    @Override // p1.j
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public u g0(j.h hVar) {
        return (u) super.g0(hVar);
    }

    @Override // p1.j
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public u h0(View view) {
        for (int i10 = 0; i10 < this.f38211P.size(); i10++) {
            this.f38211P.get(i10).h0(view);
        }
        return (u) super.h0(view);
    }

    @Override // p1.j
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public u m0(long j10) {
        ArrayList<j> arrayList;
        super.m0(j10);
        if (this.f38155c >= 0 && (arrayList = this.f38211P) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f38211P.get(i10).m0(j10);
            }
        }
        return this;
    }

    @Override // p1.j
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public u o0(TimeInterpolator timeInterpolator) {
        this.f38215T |= 1;
        ArrayList<j> arrayList = this.f38211P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f38211P.get(i10).o0(timeInterpolator);
            }
        }
        return (u) super.o0(timeInterpolator);
    }

    public u F0(int i10) {
        if (i10 == 0) {
            this.f38212Q = true;
            return this;
        }
        if (i10 == 1) {
            this.f38212Q = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
    }

    @Override // p1.j
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public u r0(long j10) {
        return (u) super.r0(j10);
    }

    public final void H0() {
        c cVar = new c(this);
        Iterator<j> it = this.f38211P.iterator();
        while (it.hasNext()) {
            it.next().f(cVar);
        }
        this.f38213R = this.f38211P.size();
    }

    @Override // p1.j
    public boolean R() {
        for (int i10 = 0; i10 < this.f38211P.size(); i10++) {
            if (this.f38211P.get(i10).R()) {
                return true;
            }
        }
        return false;
    }

    @Override // p1.j
    public boolean S() {
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f38211P.get(i10).S()) {
                return false;
            }
        }
        return true;
    }

    @Override // p1.j
    public void cancel() {
        super.cancel();
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f38211P.get(i10).cancel();
        }
    }

    @Override // p1.j
    public void d0(View view) {
        super.d0(view);
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f38211P.get(i10).d0(view);
        }
    }

    @Override // p1.j
    public void f0() {
        this.f38150I = 0L;
        b bVar = new b();
        for (int i10 = 0; i10 < this.f38211P.size(); i10++) {
            j jVar = this.f38211P.get(i10);
            jVar.f(bVar);
            jVar.f0();
            long jO = jVar.O();
            if (this.f38212Q) {
                this.f38150I = Math.max(this.f38150I, jO);
            } else {
                long j10 = this.f38150I;
                jVar.f38152K = j10;
                this.f38150I = j10 + jO;
            }
        }
    }

    @Override // p1.j
    public void i0(View view) {
        super.i0(view);
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f38211P.get(i10).i0(view);
        }
    }

    @Override // p1.j
    public void k(w wVar) {
        if (U(wVar.f38222b)) {
            Iterator<j> it = this.f38211P.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next.U(wVar.f38222b)) {
                    next.k(wVar);
                    wVar.f38223c.add(next);
                }
            }
        }
    }

    @Override // p1.j
    public void k0() {
        if (this.f38211P.isEmpty()) {
            s0();
            w();
            return;
        }
        H0();
        if (this.f38212Q) {
            Iterator<j> it = this.f38211P.iterator();
            while (it.hasNext()) {
                it.next().k0();
            }
            return;
        }
        for (int i10 = 1; i10 < this.f38211P.size(); i10++) {
            this.f38211P.get(i10 - 1).f(new a(this.f38211P.get(i10)));
        }
        j jVar = this.f38211P.get(0);
        if (jVar != null) {
            jVar.k0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // p1.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l0(long r20, long r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            long r5 = r0.O()
            p1.u r7 = r0.f38170r
            r8 = 0
            if (r7 == 0) goto L22
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 >= 0) goto L18
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 < 0) goto Lc2
        L18:
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            goto Lc2
        L22:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r10 = 0
            r11 = 1
            if (r7 >= 0) goto L2a
            r12 = r11
            goto L2b
        L2a:
            r12 = r10
        L2b:
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 < 0) goto L33
            int r14 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r14 < 0) goto L3b
        L33:
            int r14 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r14 > 0) goto L42
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 <= 0) goto L42
        L3b:
            r0.f38143B = r10
            p1.j$i r14 = p1.j.i.f38198a
            r0.c0(r14, r12)
        L42:
            boolean r14 = r0.f38212Q
            if (r14 == 0) goto L5f
        L46:
            java.util.ArrayList<p1.j> r7 = r0.f38211P
            int r7 = r7.size()
            if (r10 >= r7) goto L5c
            java.util.ArrayList<p1.j> r7 = r0.f38211P
            java.lang.Object r7 = r7.get(r10)
            p1.j r7 = (p1.j) r7
            r7.l0(r1, r3)
            int r10 = r10 + 1
            goto L46
        L5c:
            r16 = r8
            goto La7
        L5f:
            int r10 = r0.A0(r3)
            if (r7 < 0) goto L8a
        L65:
            java.util.ArrayList<p1.j> r7 = r0.f38211P
            int r7 = r7.size()
            if (r10 >= r7) goto L5c
            java.util.ArrayList<p1.j> r7 = r0.f38211P
            java.lang.Object r7 = r7.get(r10)
            p1.j r7 = (p1.j) r7
            long r14 = r7.f38152K
            r16 = r8
            long r8 = r1 - r14
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 >= 0) goto L80
            goto La7
        L80:
            long r14 = r3 - r14
            r7.l0(r8, r14)
            int r10 = r10 + 1
            r8 = r16
            goto L65
        L8a:
            r16 = r8
        L8c:
            if (r10 < 0) goto La7
            java.util.ArrayList<p1.j> r7 = r0.f38211P
            java.lang.Object r7 = r7.get(r10)
            p1.j r7 = (p1.j) r7
            long r8 = r7.f38152K
            long r14 = r1 - r8
            long r8 = r3 - r8
            r7.l0(r14, r8)
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 < 0) goto La4
            goto La7
        La4:
            int r10 = r10 + (-1)
            goto L8c
        La7:
            p1.u r7 = r0.f38170r
            if (r7 == 0) goto Lc2
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto Lb3
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto Lb9
        Lb3:
            if (r13 >= 0) goto Lc2
            int r2 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r2 < 0) goto Lc2
        Lb9:
            if (r1 <= 0) goto Lbd
            r0.f38143B = r11
        Lbd:
            p1.j$i r1 = p1.j.i.f38199b
            r0.c0(r1, r12)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.u.l0(long, long):void");
    }

    @Override // p1.j
    public void n0(j.e eVar) {
        super.n0(eVar);
        this.f38215T |= 8;
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f38211P.get(i10).n0(eVar);
        }
    }

    @Override // p1.j
    public void o(w wVar) {
        super.o(wVar);
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f38211P.get(i10).o(wVar);
        }
    }

    @Override // p1.j
    public void p(w wVar) {
        if (U(wVar.f38222b)) {
            Iterator<j> it = this.f38211P.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next.U(wVar.f38222b)) {
                    next.p(wVar);
                    wVar.f38223c.add(next);
                }
            }
        }
    }

    @Override // p1.j
    public void p0(AbstractC5046g abstractC5046g) {
        super.p0(abstractC5046g);
        this.f38215T |= 4;
        if (this.f38211P != null) {
            for (int i10 = 0; i10 < this.f38211P.size(); i10++) {
                this.f38211P.get(i10).p0(abstractC5046g);
            }
        }
    }

    @Override // p1.j
    public void q0(s sVar) {
        super.q0(sVar);
        this.f38215T |= 2;
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f38211P.get(i10).q0(sVar);
        }
    }

    @Override // p1.j
    /* renamed from: s */
    public j clone() {
        u uVar = (u) super.clone();
        uVar.f38211P = new ArrayList<>();
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            uVar.x0(this.f38211P.get(i10).clone());
        }
        return uVar;
    }

    @Override // p1.j
    public String t0(String str) {
        String strT0 = super.t0(str);
        for (int i10 = 0; i10 < this.f38211P.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strT0);
            sb2.append("\n");
            sb2.append(this.f38211P.get(i10).t0(str + "  "));
            strT0 = sb2.toString();
        }
        return strT0;
    }

    @Override // p1.j
    public void u(ViewGroup viewGroup, x xVar, x xVar2, ArrayList<w> arrayList, ArrayList<w> arrayList2) {
        long jI = I();
        int size = this.f38211P.size();
        for (int i10 = 0; i10 < size; i10++) {
            j jVar = this.f38211P.get(i10);
            if (jI > 0 && (this.f38212Q || i10 == 0)) {
                long jI2 = jVar.I();
                if (jI2 > 0) {
                    jVar.r0(jI2 + jI);
                } else {
                    jVar.r0(jI);
                }
            }
            jVar.u(viewGroup, xVar, xVar2, arrayList, arrayList2);
        }
    }

    @Override // p1.j
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public u f(j.h hVar) {
        return (u) super.f(hVar);
    }

    @Override // p1.j
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public u g(View view) {
        for (int i10 = 0; i10 < this.f38211P.size(); i10++) {
            this.f38211P.get(i10).g(view);
        }
        return (u) super.g(view);
    }

    public u w0(j jVar) {
        x0(jVar);
        long j10 = this.f38155c;
        if (j10 >= 0) {
            jVar.m0(j10);
        }
        if ((this.f38215T & 1) != 0) {
            jVar.o0(z());
        }
        if ((this.f38215T & 2) != 0) {
            E();
            jVar.q0(null);
        }
        if ((this.f38215T & 4) != 0) {
            jVar.p0(D());
        }
        if ((this.f38215T & 8) != 0) {
            jVar.n0(y());
        }
        return this;
    }

    public final void x0(j jVar) {
        this.f38211P.add(jVar);
        jVar.f38170r = this;
    }

    public j y0(int i10) {
        if (i10 < 0 || i10 >= this.f38211P.size()) {
            return null;
        }
        return this.f38211P.get(i10);
    }

    public int z0() {
        return this.f38211P.size();
    }
}
