package s9;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import m9.AbstractRunnableC1698P;
import m9.C1699Q;

/* loaded from: classes4.dex */
public class u {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(u.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    public AbstractRunnableC1698P[] f6010a;

    public final void a(AbstractRunnableC1698P abstractRunnableC1698P) {
        abstractRunnableC1698P.d((C1699Q) this);
        AbstractRunnableC1698P[] abstractRunnableC1698PArr = this.f6010a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (abstractRunnableC1698PArr == null) {
            abstractRunnableC1698PArr = new AbstractRunnableC1698P[4];
            this.f6010a = abstractRunnableC1698PArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= abstractRunnableC1698PArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(abstractRunnableC1698PArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.k.e(objArrCopyOf, "copyOf(...)");
            abstractRunnableC1698PArr = (AbstractRunnableC1698P[]) objArrCopyOf;
            this.f6010a = abstractRunnableC1698PArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        abstractRunnableC1698PArr[i] = abstractRunnableC1698P;
        abstractRunnableC1698P.b = i;
        c(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m9.AbstractRunnableC1698P b(int r9) {
        /*
            r8 = this;
            m9.P[] r0 = r8.f6010a
            kotlin.jvm.internal.k.c(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = s9.u.b
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
            kotlin.jvm.internal.k.c(r4)
            r5 = r0[r2]
            kotlin.jvm.internal.k.c(r5)
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
            m9.P[] r5 = r8.f6010a
            kotlin.jvm.internal.k.c(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            kotlin.jvm.internal.k.c(r6)
            r7 = r5[r4]
            kotlin.jvm.internal.k.c(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            kotlin.jvm.internal.k.c(r4)
            r5 = r5[r2]
            kotlin.jvm.internal.k.c(r5)
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
            kotlin.jvm.internal.k.c(r9)
            r2 = 0
            r9.d(r2)
            r9.b = r3
            int r8 = r1.get(r8)
            r0[r8] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.u.b(int):m9.P");
    }

    public final void c(int i) {
        while (i > 0) {
            AbstractRunnableC1698P[] abstractRunnableC1698PArr = this.f6010a;
            kotlin.jvm.internal.k.c(abstractRunnableC1698PArr);
            int i6 = (i - 1) / 2;
            AbstractRunnableC1698P abstractRunnableC1698P = abstractRunnableC1698PArr[i6];
            kotlin.jvm.internal.k.c(abstractRunnableC1698P);
            AbstractRunnableC1698P abstractRunnableC1698P2 = abstractRunnableC1698PArr[i];
            kotlin.jvm.internal.k.c(abstractRunnableC1698P2);
            if (abstractRunnableC1698P.compareTo(abstractRunnableC1698P2) <= 0) {
                return;
            }
            d(i, i6);
            i = i6;
        }
    }

    public final void d(int i, int i6) {
        AbstractRunnableC1698P[] abstractRunnableC1698PArr = this.f6010a;
        kotlin.jvm.internal.k.c(abstractRunnableC1698PArr);
        AbstractRunnableC1698P abstractRunnableC1698P = abstractRunnableC1698PArr[i6];
        kotlin.jvm.internal.k.c(abstractRunnableC1698P);
        AbstractRunnableC1698P abstractRunnableC1698P2 = abstractRunnableC1698PArr[i];
        kotlin.jvm.internal.k.c(abstractRunnableC1698P2);
        abstractRunnableC1698PArr[i] = abstractRunnableC1698P;
        abstractRunnableC1698PArr[i6] = abstractRunnableC1698P2;
        abstractRunnableC1698P.b = i;
        abstractRunnableC1698P2.b = i6;
    }
}
