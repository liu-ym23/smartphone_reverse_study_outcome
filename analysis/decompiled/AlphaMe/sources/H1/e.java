package H1;

import F1.A;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e extends A {

    /* renamed from: b, reason: collision with root package name */
    public static final a f715b = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f716a;

    public e() {
        ArrayList arrayList = new ArrayList();
        this.f716a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (G1.h.f602a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        Date dateB;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        synchronized (this.f716a) {
            try {
                Iterator it = this.f716a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        try {
                            dateB = I1.a.b(strNextString, new ParsePosition(0));
                            break;
                        } catch (ParseException e4) {
                            StringBuilder sbW = B0.g.w("Failed parsing '", strNextString, "' as Date; at path ");
                            sbW.append(jsonReader.getPreviousPath());
                            throw new F1.q(sbW.toString(), 5, e4);
                        }
                    }
                    try {
                        dateB = ((DateFormat) it.next()).parse(strNextString);
                    } catch (ParseException unused) {
                    }
                }
            } finally {
            }
        }
        return dateB;
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f716a.get(0);
        synchronized (this.f716a) {
            str = dateFormat.format(date);
        }
        jsonWriter.value(str);
    }
}
