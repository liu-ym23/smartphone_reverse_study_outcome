package D1;

import A1.r;
import A1.t;
import A1.u;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class j extends t<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final u f1089b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f1090a = new SimpleDateFormat("MMM d, yyyy");

    static class a implements u {
        a() {
        }

        @Override // A1.u
        public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // A1.t
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Date b(G1.a aVar) {
        if (aVar.V() == G1.b.NULL) {
            aVar.O();
            return null;
        }
        try {
            return new Date(this.f1090a.parse(aVar.T()).getTime());
        } catch (ParseException e6) {
            throw new r(e6);
        }
    }

    @Override // A1.t
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(G1.c cVar, Date date) {
        cVar.Y(date == null ? null : this.f1090a.format((java.util.Date) date));
    }
}
