package pc;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kc.m0;
import kc.n0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9991b = AtomicIntegerFieldUpdater.newUpdater(x.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public m0[] f9992a;

    public final void a(m0 m0Var) {
        m0Var.c((n0) this);
        m0[] m0VarArr = this.f9992a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9991b;
        if (m0VarArr == null) {
            m0VarArr = new m0[4];
            this.f9992a = m0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= m0VarArr.length) {
            m0VarArr = (m0[]) Arrays.copyOf(m0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            this.f9992a = m0VarArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        m0VarArr[i] = m0Var;
        m0Var.f7457f = i;
        c(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kc.m0 b(int r9) {
        /*
            r8 = this;
            kc.m0[] r0 = r8.f9992a
            r0.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = pc.x.f9991b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.d(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            r4.getClass()
            r5 = r0[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.d(r9, r2)
            r8.c(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            kc.m0[] r5 = r8.f9992a
            r5.getClass()
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            r6.getClass()
            r7 = r5[r4]
            r7.getClass()
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            r4.getClass()
            r5 = r5[r2]
            r5.getClass()
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.d(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            r9.getClass()
            r2 = 0
            r9.c(r2)
            r9.f7457f = r3
            int r8 = r1.get(r8)
            r0[r8] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: pc.x.b(int):kc.m0");
    }

    public final void c(int i) {
        while (i > 0) {
            m0[] m0VarArr = this.f9992a;
            m0VarArr.getClass();
            int i3 = (i - 1) / 2;
            m0 m0Var = m0VarArr[i3];
            m0Var.getClass();
            m0 m0Var2 = m0VarArr[i];
            m0Var2.getClass();
            if (m0Var.compareTo(m0Var2) <= 0) {
                return;
            }
            d(i, i3);
            i = i3;
        }
    }

    public final void d(int i, int i3) {
        m0[] m0VarArr = this.f9992a;
        m0VarArr.getClass();
        m0 m0Var = m0VarArr[i3];
        m0Var.getClass();
        m0 m0Var2 = m0VarArr[i];
        m0Var2.getClass();
        m0VarArr[i] = m0Var;
        m0VarArr[i3] = m0Var2;
        m0Var.f7457f = i;
        m0Var2.f7457f = i3;
    }
}
