package D1;

import A1.r;
import A1.t;
import A1.u;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c extends t<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final u f1049b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f1050a;

    static class a implements u {
        a() {
        }

        @Override // A1.u
        public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f1050a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (C1.e.e()) {
            arrayList.add(C1.j.c(2, 2));
        }
    }

    private synchronized Date e(String str) {
        Iterator<DateFormat> it = this.f1050a.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return E1.a.c(str, new ParsePosition(0));
        } catch (ParseException e6) {
            throw new r(str, e6);
        }
    }

    @Override // A1.t
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(G1.a aVar) throws IOException {
        if (aVar.V() != G1.b.NULL) {
            return e(aVar.T());
        }
        aVar.O();
        return null;
    }

    @Override // A1.t
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized void d(G1.c cVar, Date date) {
        if (date == null) {
            cVar.D();
        } else {
            cVar.Y(this.f1050a.get(0).format(date));
        }
    }
}
