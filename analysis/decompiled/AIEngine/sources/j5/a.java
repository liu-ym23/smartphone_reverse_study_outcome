package j5;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.i;
import d5.u;
import d5.v;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends u<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final C0095a f9696b = new C0095a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f9697a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: j5.a$a, reason: collision with other inner class name */
    public class C0095a implements v {
        @Override // d5.v
        public final <T> u<T> b(i iVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new a(0);
            }
            return null;
        }
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    @Override // d5.u
    public final Date a(k5.a aVar) throws IOException {
        Date date;
        if (aVar.R0() == JsonToken.f5478l) {
            aVar.N0();
            return null;
        }
        String strP0 = aVar.P0();
        synchronized (this) {
            TimeZone timeZone = this.f9697a.getTimeZone();
            try {
                try {
                    date = new Date(this.f9697a.parse(strP0).getTime());
                } catch (ParseException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + strP0 + "' as SQL Date; at path " + aVar.g0(), e10);
                }
            } finally {
                this.f9697a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // d5.u
    public final void b(k5.b bVar, Date date) throws IOException {
        String str;
        Date date2 = date;
        if (date2 == null) {
            bVar.c0();
            return;
        }
        synchronized (this) {
            str = this.f9697a.format((java.util.Date) date2);
        }
        bVar.K0(str);
    }

    private a() {
        this.f9697a = new SimpleDateFormat("MMM d, yyyy");
    }
}
