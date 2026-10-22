package v4;

import androidx.emoji2.text.r;
import c5.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.p;
import p5.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5970a;

    /* renamed from: b, reason: collision with root package name */
    public int f5971b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5972c;
    public r d;
    private volatile /* synthetic */ Object interceptors$delegate;

    public e(r... rVarArr) {
        new r4.d();
        Object[] elements = Arrays.copyOf(rVarArr, rVarArr.length);
        p.e(elements, "elements");
        this.f5970a = elements.length == 0 ? new ArrayList() : new ArrayList(new c5.i(elements, true));
        this.interceptors$delegate = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r13, java.lang.Object r14, h5.c r15) {
        /*
            r12 = this;
            f5.h r0 = r15.getContext()
            java.lang.Object r1 = r12.interceptors$delegate
            java.util.List r1 = (java.util.List) r1
            r2 = 1
            if (r1 != 0) goto L94
            int r1 = r12.f5971b
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L1b
            c5.s r1 = c5.s.f1092a
            r12.interceptors$delegate = r1
            r12.f5972c = r3
            r12.d = r4
            goto L94
        L1b:
            java.util.ArrayList r5 = r12.f5970a
            if (r1 != r2) goto L4f
            int r1 = c5.n.j0(r5)
            if (r1 < 0) goto L4f
            r6 = r3
        L26:
            java.lang.Object r7 = r5.get(r6)
            boolean r8 = r7 instanceof v4.d
            if (r8 == 0) goto L31
            v4.d r7 = (v4.d) r7
            goto L32
        L31:
            r7 = r4
        L32:
            if (r7 != 0) goto L35
            goto L4a
        L35:
            java.util.List r8 = r7.f5969c
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L4a
            java.util.List r1 = r7.f5969c
            r7.d = r2
            r12.interceptors$delegate = r1
            r12.f5972c = r3
            androidx.emoji2.text.r r1 = r7.f5967a
            r12.d = r1
            goto L94
        L4a:
            if (r6 == r1) goto L4f
            int r6 = r6 + 1
            goto L26
        L4f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r6 = c5.n.j0(r5)
            if (r6 < 0) goto L8e
            r7 = r3
        L5b:
            java.lang.Object r8 = r5.get(r7)
            boolean r9 = r8 instanceof v4.d
            if (r9 == 0) goto L66
            v4.d r8 = (v4.d) r8
            goto L67
        L66:
            r8 = r4
        L67:
            if (r8 != 0) goto L6a
            goto L89
        L6a:
            java.util.List r8 = r8.f5969c
            int r9 = r1.size()
            int r10 = r8.size()
            int r10 = r10 + r9
            r1.ensureCapacity(r10)
            int r9 = r8.size()
            r10 = r3
        L7d:
            if (r10 >= r9) goto L89
            java.lang.Object r11 = r8.get(r10)
            r1.add(r11)
            int r10 = r10 + 1
            goto L7d
        L89:
            if (r7 == r6) goto L8e
            int r7 = r7 + 1
            goto L5b
        L8e:
            r12.interceptors$delegate = r1
            r12.f5972c = r3
            r12.d = r4
        L94:
            r12.f5972c = r2
            java.lang.Object r1 = r12.interceptors$delegate
            java.util.List r1 = (java.util.List) r1
            kotlin.jvm.internal.p.b(r1)
            boolean r12 = r12.d()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.p.e(r13, r2)
            java.lang.String r2 = "subject"
            kotlin.jvm.internal.p.e(r14, r2)
            java.lang.String r2 = "coroutineContext"
            kotlin.jvm.internal.p.e(r0, r2)
            boolean r2 = v4.g.f5974a
            if (r2 != 0) goto Lbd
            if (r12 == 0) goto Lb7
            goto Lbd
        Lb7:
            v4.m r12 = new v4.m
            r12.<init>(r14, r13, r1)
            goto Lc2
        Lbd:
            v4.b r12 = new v4.b
            r12.<init>(r13, r1, r14, r0)
        Lc2:
            java.lang.Object r12 = r12.a(r14, r15)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.e.a(java.lang.Object, java.lang.Object, h5.c):java.lang.Object");
    }

    public final d b(r rVar) {
        ArrayList arrayList = this.f5970a;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = arrayList.get(i8);
            if (obj == rVar) {
                d dVar = new d(rVar, j.f5976a);
                arrayList.set(i8, dVar);
                return dVar;
            }
            if (obj instanceof d) {
                d dVar2 = (d) obj;
                if (dVar2.f5967a == rVar) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    public final int c(r rVar) {
        ArrayList arrayList = this.f5970a;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = arrayList.get(i8);
            if (obj == rVar || ((obj instanceof d) && ((d) obj).f5967a == rVar)) {
                return i8;
            }
        }
        return -1;
    }

    public abstract boolean d();

    public final boolean e(r rVar) {
        ArrayList arrayList = this.f5970a;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = arrayList.get(i8);
            if (obj == rVar) {
                return true;
            }
            if ((obj instanceof d) && ((d) obj).f5967a == rVar) {
                return true;
            }
        }
        return false;
    }

    public final void f(r phase, q qVar) {
        p.e(phase, "phase");
        d dVarB = b(phase);
        if (dVarB == null) {
            throw new c("Phase " + phase + " was not registered for this pipeline");
        }
        List list = (List) this.interceptors$delegate;
        if (!this.f5970a.isEmpty() && list != null && !this.f5972c && (!(list instanceof q5.a) || (list instanceof q5.c))) {
            if (p.a(this.d, phase)) {
                list.add(qVar);
            } else if (phase.equals(c5.m.B0(this.f5970a)) || c(phase) == n.j0(this.f5970a)) {
                d dVarB2 = b(phase);
                p.b(dVarB2);
                if (dVarB2.d) {
                    dVarB2.f5969c = c5.m.O0(dVarB2.f5969c);
                    dVarB2.d = false;
                }
                dVarB2.f5969c.add(qVar);
                list.add(qVar);
            }
            this.f5971b++;
            return;
        }
        if (dVarB.d) {
            dVarB.f5969c = c5.m.O0(dVarB.f5969c);
            dVarB.d = false;
        }
        dVarB.f5969c.add(qVar);
        this.f5971b++;
        this.interceptors$delegate = null;
        this.f5972c = false;
        this.d = null;
    }
}
