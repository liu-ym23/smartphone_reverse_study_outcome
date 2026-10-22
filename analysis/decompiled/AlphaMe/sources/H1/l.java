package H1;

import F1.A;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public final class l extends A {

    /* renamed from: b, reason: collision with root package name */
    public static final j f731b = new j(0, new l());

    /* renamed from: a, reason: collision with root package name */
    public final F1.z f732a = F1.y.f453b;

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i4 = k.f730a[jsonTokenPeek.ordinal()];
        if (i4 == 1) {
            jsonReader.nextNull();
            return null;
        }
        if (i4 == 2 || i4 == 3) {
            return this.f732a.a(jsonReader);
        }
        throw new F1.q("Expecting number, got: " + jsonTokenPeek + "; at path " + jsonReader.getPath(), 5);
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.value((Number) obj);
    }
}
