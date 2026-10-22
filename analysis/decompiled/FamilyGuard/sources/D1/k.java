package D1;

import A1.r;
import A1.t;
import A1.u;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class k extends t<Time> {

    /* renamed from: b, reason: collision with root package name */
    public static final u f1091b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f1092a = new SimpleDateFormat("hh:mm:ss a");

    static class a implements u {
        a() {
        }

        @Override // A1.u
        public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // A1.t
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Time b(G1.a aVar) {
        if (aVar.V() == G1.b.NULL) {
            aVar.O();
            return null;
        }
        try {
            return new Time(this.f1092a.parse(aVar.T()).getTime());
        } catch (ParseException e6) {
            throw new r(e6);
        }
    }

    @Override // A1.t
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(G1.c cVar, Time time) {
        cVar.Y(time == null ? null : this.f1092a.format((Date) time));
    }
}
