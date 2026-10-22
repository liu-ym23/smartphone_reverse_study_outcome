package f6;

import a6.x0;
import a6.y0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class t {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2662b = AtomicIntegerFieldUpdater.newUpdater(t.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public x0[] f2663a;

    public final void a(x0 x0Var) {
        x0Var.d((y0) this);
        x0[] x0VarArr = this.f2663a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2662b;
        if (x0VarArr == null) {
            x0VarArr = new x0[4];
            this.f2663a = x0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= x0VarArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(x0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.p.d(objArrCopyOf, "copyOf(...)");
            x0VarArr = (x0[]) objArrCopyOf;
            this.f2663a = x0VarArr;
        }
        int i8 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i8 + 1);
        x0VarArr[i8] = x0Var;
        x0Var.f226b = i8;
        c(i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a6.x0 b(int r9) {
        /*
            r8 = this;
            a6.x0[] r0 = r8.f2663a
            kotlin.jvm.internal.p.b(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = f6.t.f2662b
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
            kotlin.jvm.internal.p.b(r4)
            r5 = r0[r2]
            kotlin.jvm.internal.p.b(r5)
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
            a6.x0[] r5 = r8.f2663a
            kotlin.jvm.internal.p.b(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            kotlin.jvm.internal.p.b(r6)
            r7 = r5[r4]
            kotlin.jvm.internal.p.b(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            kotlin.jvm.internal.p.b(r4)
            r5 = r5[r2]
            kotlin.jvm.internal.p.b(r5)
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
            kotlin.jvm.internal.p.b(r9)
            r2 = 0
            r9.d(r2)
            r9.f226b = r3
            int r8 = r1.get(r8)
            r0[r8] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.t.b(int):a6.x0");
    }

    public final void c(int i8) {
        while (i8 > 0) {
            x0[] x0VarArr = this.f2663a;
            kotlin.jvm.internal.p.b(x0VarArr);
            int i9 = (i8 - 1) / 2;
            x0 x0Var = x0VarArr[i9];
            kotlin.jvm.internal.p.b(x0Var);
            x0 x0Var2 = x0VarArr[i8];
            kotlin.jvm.internal.p.b(x0Var2);
            if (x0Var.compareTo(x0Var2) <= 0) {
                return;
            }
            d(i8, i9);
            i8 = i9;
        }
    }

    public final void d(int i8, int i9) {
        x0[] x0VarArr = this.f2663a;
        kotlin.jvm.internal.p.b(x0VarArr);
        x0 x0Var = x0VarArr[i9];
        kotlin.jvm.internal.p.b(x0Var);
        x0 x0Var2 = x0VarArr[i8];
        kotlin.jvm.internal.p.b(x0Var2);
        x0VarArr[i8] = x0Var;
        x0VarArr[i9] = x0Var2;
        x0Var.f226b = i8;
        x0Var2.f226b = i9;
    }
}
