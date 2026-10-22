package g5;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.u;
import d5.v;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<T extends Date> extends u<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f8972c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final b<T> f8973a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8974b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements v {
        @Override // d5.v
        public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new c(b.f8975b, 2, 2);
            }
            return null;
        }

        public final String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    }

    public c(b bVar, int i10, int i11) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        this.f8974b = arrayList;
        Objects.requireNonNull(bVar);
        this.f8973a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (f5.f.f8751a >= 9) {
            StringBuilder sb2 = new StringBuilder();
            if (i10 == 0) {
                str = "EEEE, MMMM d, yyyy";
            } else if (i10 == 1) {
                str = "MMMM d, yyyy";
            } else if (i10 == 2) {
                str = "MMM d, yyyy";
            } else {
                if (i10 != 3) {
                    throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Unknown DateFormat style: "));
                }
                str = "M/d/yy";
            }
            sb2.append(str);
            sb2.append(" ");
            if (i11 == 0 || i11 == 1) {
                str2 = "h:mm:ss a z";
            } else if (i11 == 2) {
                str2 = "h:mm:ss a";
            } else {
                if (i11 != 3) {
                    throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i11, "Unknown DateFormat style: "));
                }
                str2 = "h:mm a";
            }
            sb2.append(str2);
            arrayList.add(new SimpleDateFormat(sb2.toString(), locale));
        }
    }

    @Override // d5.u
    public final Object a(k5.a aVar) throws IOException {
        Date dateB;
        if (aVar.R0() == JsonToken.f5478l) {
            aVar.N0();
            return null;
        }
        String strP0 = aVar.P0();
        synchronized (this.f8974b) {
            try {
                ArrayList arrayList = this.f8974b;
                int size = arrayList.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        try {
                            dateB = h5.a.b(strP0, new ParsePosition(0));
                            break;
                        } catch (ParseException e10) {
                            StringBuilder sbQ = a0.a.q("Failed parsing '", strP0, "' as Date; at path ");
                            sbQ.append(aVar.g0());
                            throw new JsonSyntaxException(sbQ.toString(), e10);
                        }
                    }
                    Object obj = arrayList.get(i10);
                    i10++;
                    DateFormat dateFormat = (DateFormat) obj;
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strP0);
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
        return this.f8973a.a(dateB);
    }

    @Override // d5.u
    public final void b(k5.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.c0();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f8974b.get(0);
        synchronized (this.f8974b) {
            str = dateFormat.format(date);
        }
        bVar.K0(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f8974b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final a f8975b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f8976a;

        public b(Class<T> cls) {
            this.f8976a = cls;
        }

        public abstract T a(Date date);

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends b<Date> {
            @Override // g5.c.b
            public final Date a(Date date) {
                return date;
            }
        }
    }
}
