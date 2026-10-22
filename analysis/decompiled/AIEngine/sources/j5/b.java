package j5;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.i;
import d5.u;
import d5.v;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends u<Time> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9698b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f9699a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements v {
        @Override // d5.v
        public final <T> u<T> b(i iVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new b(0);
            }
            return null;
        }
    }

    public /* synthetic */ b(int i10) {
        this();
    }

    @Override // d5.u
    public final Time a(k5.a aVar) throws IOException {
        Time time;
        if (aVar.R0() == JsonToken.f5478l) {
            aVar.N0();
            return null;
        }
        String strP0 = aVar.P0();
        synchronized (this) {
            TimeZone timeZone = this.f9699a.getTimeZone();
            try {
                try {
                    time = new Time(this.f9699a.parse(strP0).getTime());
                } catch (ParseException e10) {
                    throw new JsonSyntaxException("Failed parsing '" + strP0 + "' as SQL Time; at path " + aVar.g0(), e10);
                }
            } finally {
                this.f9699a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // d5.u
    public final void b(k5.b bVar, Time time) throws IOException {
        String str;
        Time time2 = time;
        if (time2 == null) {
            bVar.c0();
            return;
        }
        synchronized (this) {
            str = this.f9699a.format((Date) time2);
        }
        bVar.K0(str);
    }

    private b() {
        this.f9699a = new SimpleDateFormat("hh:mm:ss a");
    }
}
