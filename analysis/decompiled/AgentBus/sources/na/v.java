package na;

import ia.u0;
import ia.v0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6930b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public u0[] f6931a;

    public final void a(u0 u0Var) {
        u0Var.d((v0) this);
        u0[] u0VarArr = this.f6931a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6930b;
        if (u0VarArr == null) {
            u0VarArr = new u0[4];
            this.f6931a = u0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= u0VarArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(u0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            u0VarArr = (u0[]) objArrCopyOf;
            this.f6931a = u0VarArr;
        }
        int i2 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i2 + 1);
        u0VarArr[i2] = u0Var;
        u0Var.f5009g = i2;
        c(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ia.u0 b(int r9) {
        /*
            r8 = this;
            ia.u0[] r0 = r8.f6931a
            q7.k.b(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = na.v.f6930b
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
            q7.k.b(r4)
            r5 = r0[r2]
            q7.k.b(r5)
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
            ia.u0[] r5 = r8.f6931a
            q7.k.b(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            q7.k.b(r6)
            r7 = r5[r4]
            q7.k.b(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            q7.k.b(r4)
            r5 = r5[r2]
            q7.k.b(r5)
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
            q7.k.b(r9)
            r2 = 0
            r9.d(r2)
            r9.f5009g = r3
            int r8 = r1.get(r8)
            r0[r8] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: na.v.b(int):ia.u0");
    }

    public final void c(int i2) {
        while (i2 > 0) {
            u0[] u0VarArr = this.f6931a;
            q7.k.b(u0VarArr);
            int i10 = (i2 - 1) / 2;
            u0 u0Var = u0VarArr[i10];
            q7.k.b(u0Var);
            u0 u0Var2 = u0VarArr[i2];
            q7.k.b(u0Var2);
            if (u0Var.compareTo(u0Var2) <= 0) {
                return;
            }
            d(i2, i10);
            i2 = i10;
        }
    }

    public final void d(int i2, int i10) {
        u0[] u0VarArr = this.f6931a;
        q7.k.b(u0VarArr);
        u0 u0Var = u0VarArr[i10];
        q7.k.b(u0Var);
        u0 u0Var2 = u0VarArr[i2];
        q7.k.b(u0Var2);
        u0VarArr[i2] = u0Var;
        u0VarArr[i10] = u0Var2;
        u0Var.f5009g = i2;
        u0Var2.f5009g = i10;
    }
}
