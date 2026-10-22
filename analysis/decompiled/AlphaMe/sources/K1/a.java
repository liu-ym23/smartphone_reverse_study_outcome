package K1;

import B0.g;
import F1.A;
import F1.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public final class a extends A {

    /* renamed from: b, reason: collision with root package name */
    public static final H1.a f1032b = new H1.a(3);

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f1033a = new SimpleDateFormat("MMM d, yyyy");

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        Date date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        try {
            synchronized (this) {
                date = this.f1033a.parse(strNextString);
            }
            return new java.sql.Date(date.getTime());
        } catch (ParseException e4) {
            StringBuilder sbW = g.w("Failed parsing '", strNextString, "' as SQL Date; at path ");
            sbW.append(jsonReader.getPreviousPath());
            throw new q(sbW.toString(), 5, e4);
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        java.sql.Date date = (java.sql.Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f1033a.format((Date) date);
        }
        jsonWriter.value(str);
    }
}
