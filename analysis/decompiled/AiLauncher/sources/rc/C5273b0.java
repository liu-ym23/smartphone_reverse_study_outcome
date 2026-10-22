package rc;

import java.util.ArrayList;

/* renamed from: rc.b0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5273b0 extends o1 {
    public C5273b0(long j10, long j11) {
        n(1);
        p(true);
        String[] strArrQ = q(j10, j11);
        J0 j02 = new J0(1, 0.0f, 1, 2.6f, 1, 0.5f);
        for (int i10 = 0; i10 < strArrQ.length; i10++) {
            AbstractC5276d abstractC5276d = new a1(strArrQ[i10]).f39212d;
            if (i10 % 2 == 0) {
                I0 i02 = new I0(abstractC5276d);
                i02.i(j02);
                if (i10 == 0) {
                    j(i02);
                } else {
                    j(new l1(i02));
                }
            } else if (i10 == 1) {
                String string = Long.toString(j10);
                C5278e c5278e = new C5278e(W0.p(a1.f39205k[41]), 1);
                I0 i03 = new I0(new C5312v0(c5278e, false, true, true));
                i03.i(new Q0(new A0(c5278e, 13, 3.5f, 13, 0.0f, 13, 0.0f)));
                i03.i(abstractC5276d);
                C5308t0 c5308t0 = new C5308t0(i03);
                I0 i04 = new I0(new a1(string).f39212d);
                i04.i(new R0(1));
                i04.i(c5308t0);
                j(i04);
            } else {
                I0 i05 = new I0(abstractC5276d);
                i05.i(j02);
                j(i05);
            }
        }
    }

    public final String[] q(long j10, long j11) {
        ArrayList arrayList = new ArrayList();
        long j12 = j11 / j10;
        arrayList.add(Long.toString(j12));
        arrayList.add(Long.toString(j11));
        while (j12 != 0) {
            double d10 = j12;
            double dPow = Math.pow(10.0d, Math.floor(Math.log10(d10)));
            long jFloor = (long) (Math.floor(d10 / dPow) * dPow);
            long j13 = jFloor * j10;
            arrayList.add(Long.toString(j13));
            j11 -= j13;
            arrayList.add(Long.toString(j11));
            j12 -= jFloor;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
