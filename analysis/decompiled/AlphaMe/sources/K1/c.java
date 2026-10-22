package K1;

import F1.A;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
public final class c extends A {

    /* renamed from: b, reason: collision with root package name */
    public static final H1.a f1036b = new H1.a(5);

    /* renamed from: a, reason: collision with root package name */
    public final A f1037a;

    public c(A a4) {
        this.f1037a = a4;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) {
        Date date = (Date) this.f1037a.b(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) {
        this.f1037a.c(jsonWriter, (Timestamp) obj);
    }
}
