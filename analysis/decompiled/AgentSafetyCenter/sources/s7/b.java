package s7;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import m7.h;
import m7.n;
import m7.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final a f11410b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f11411a;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class a implements o {
        @Override // m7.o
        public final n a(m7.e eVar, t7.a aVar) {
            if (aVar.getRawType() == Time.class) {
                return new b(0);
            }
            return null;
        }
    }

    private b() {
        this.f11411a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        Time time;
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        synchronized (this) {
            TimeZone timeZone = this.f11411a.getTimeZone();
            try {
                try {
                    time = new Time(this.f11411a.parse(strW).getTime());
                } catch (ParseException e10) {
                    throw new h("Failed parsing '" + strW + "' as SQL Time; at path " + aVar.F(), e10);
                }
            } finally {
                this.f11411a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            cVar.C();
            return;
        }
        synchronized (this) {
            str = this.f11411a.format((Date) time);
        }
        cVar.S(str);
    }

    public /* synthetic */ b(int i) {
        this();
    }
}
