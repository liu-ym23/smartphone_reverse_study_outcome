package K1;

import B0.g;
import F1.A;
import F1.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class b extends A {

    /* renamed from: b, reason: collision with root package name */
    public static final H1.a f1034b = new H1.a(4);

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f1035a = new SimpleDateFormat("hh:mm:ss a");

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        try {
            synchronized (this) {
                time = new Time(this.f1035a.parse(strNextString).getTime());
            }
            return time;
        } catch (ParseException e4) {
            StringBuilder sbW = g.w("Failed parsing '", strNextString, "' as SQL Time; at path ");
            sbW.append(jsonReader.getPreviousPath());
            throw new q(sbW.toString(), 5, e4);
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f1035a.format((Date) time);
        }
        jsonWriter.value(str);
    }
}
