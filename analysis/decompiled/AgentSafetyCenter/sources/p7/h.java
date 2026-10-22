package p7;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends m7.n {

    /* renamed from: c, reason: collision with root package name */
    public static final e f9870c = new e();

    /* renamed from: a, reason: collision with root package name */
    public g f9871a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f9872b;

    @Override // m7.n
    public final Object read(u7.a aVar) {
        Date dateB;
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        synchronized (this.f9872b) {
            try {
                ArrayList arrayList = this.f9872b;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        try {
                            dateB = q7.a.b(strW, new ParsePosition(0));
                            break;
                        } catch (ParseException e10) {
                            StringBuilder sbO = androidx.activity.b.o("Failed parsing '", strW, "' as Date; at path ");
                            sbO.append(aVar.F());
                            throw new m7.h(sbO.toString(), e10);
                        }
                    }
                    Object obj = arrayList.get(i);
                    i++;
                    DateFormat dateFormat = (DateFormat) obj;
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strW);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f9871a.a(dateB);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f9872b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            cVar.C();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f9872b.get(0);
        synchronized (this.f9872b) {
            str = dateFormat.format(date);
        }
        cVar.S(str);
    }
}
