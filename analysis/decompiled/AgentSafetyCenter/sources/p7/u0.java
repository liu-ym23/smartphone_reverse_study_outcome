package p7;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class u0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) throws IOException, NumberFormatException {
        int iQ;
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        aVar.e();
        int i = 0;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (aVar.Y() != u7.b.f14165h) {
            String strS = aVar.S();
            iQ = aVar.Q();
            strS.getClass();
            switch (strS) {
                case "dayOfMonth":
                    i10 = iQ;
                    break;
                case "minute":
                    i12 = iQ;
                    break;
                case "second":
                    i13 = iQ;
                    break;
                case "year":
                    i = iQ;
                    break;
                case "month":
                    i3 = iQ;
                    break;
                case "hourOfDay":
                    i11 = iQ;
                    break;
            }
        }
        aVar.o();
        return new GregorianCalendar(i, i3, i10, i11, i12, i13);
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) throws IOException {
        if (((Calendar) obj) == null) {
            cVar.C();
            return;
        }
        cVar.g();
        cVar.r("year");
        cVar.P(r4.get(1));
        cVar.r("month");
        cVar.P(r4.get(2));
        cVar.r("dayOfMonth");
        cVar.P(r4.get(5));
        cVar.r("hourOfDay");
        cVar.P(r4.get(11));
        cVar.r("minute");
        cVar.P(r4.get(12));
        cVar.r("second");
        cVar.P(r4.get(13));
        cVar.o();
    }
}
