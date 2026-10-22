package d3;

import Z2.Y;
import Z2.Z;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class C {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12437b = AtomicIntegerFieldUpdater.newUpdater(C.class, "_size");

    @Volatile
    private volatile int _size;

    /* renamed from: a, reason: collision with root package name */
    public Y[] f12438a;

    public final void a(Y y4) {
        y4.d((Z) this);
        Y[] yArr = this.f12438a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12437b;
        if (yArr == null) {
            yArr = new Y[4];
            this.f12438a = yArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= yArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(yArr, atomicIntegerFieldUpdater.get(this) * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            yArr = (Y[]) objArrCopyOf;
            this.f12438a = yArr;
        }
        int i4 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i4 + 1);
        yArr[i4] = y4;
        y4.f2201b = i4;
        c(i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Z2.Y b(int r9) {
        /*
            r8 = this;
            Z2.Y[] r0 = r8.f12438a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = d3.C.f12437b
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
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r5 = r0[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
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
            Z2.Y[] r5 = r8.f12438a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r7 = r5[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r5 = r5[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
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
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r2 = 0
            r9.d(r2)
            r9.f2201b = r3
            int r8 = r1.get(r8)
            r0[r8] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.C.b(int):Z2.Y");
    }

    public final void c(int i4) {
        while (i4 > 0) {
            Y[] yArr = this.f12438a;
            Intrinsics.checkNotNull(yArr);
            int i5 = (i4 - 1) / 2;
            Y y4 = yArr[i5];
            Intrinsics.checkNotNull(y4);
            Y y5 = yArr[i4];
            Intrinsics.checkNotNull(y5);
            if (y4.compareTo(y5) <= 0) {
                return;
            }
            d(i4, i5);
            i4 = i5;
        }
    }

    public final void d(int i4, int i5) {
        Y[] yArr = this.f12438a;
        Intrinsics.checkNotNull(yArr);
        Y y4 = yArr[i5];
        Intrinsics.checkNotNull(y4);
        Y y5 = yArr[i4];
        Intrinsics.checkNotNull(y5);
        yArr[i4] = y4;
        yArr[i5] = y5;
        y4.f2201b = i4;
        y5.f2201b = i5;
    }
}
