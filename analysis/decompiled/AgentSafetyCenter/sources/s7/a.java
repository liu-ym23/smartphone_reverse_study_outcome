package s7;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import m7.h;
import m7.n;
import m7.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final C0012a f11408b = new C0012a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f11409a;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: s7.a$a, reason: collision with other inner class name */
    public class C0012a implements o {
        @Override // m7.o
        public final n a(m7.e eVar, t7.a aVar) {
            if (aVar.getRawType() == Date.class) {
                return new a(0);
            }
            return null;
        }
    }

    private a() {
        this.f11409a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        Date date;
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        synchronized (this) {
            TimeZone timeZone = this.f11409a.getTimeZone();
            try {
                try {
                    date = new Date(this.f11409a.parse(strW).getTime());
                } catch (ParseException e10) {
                    throw new h("Failed parsing '" + strW + "' as SQL Date; at path " + aVar.F(), e10);
                }
            } finally {
                this.f11409a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            cVar.C();
            return;
        }
        synchronized (this) {
            str = this.f11409a.format((java.util.Date) date);
        }
        cVar.S(str);
    }

    public /* synthetic */ a(int i) {
        this();
    }
}
