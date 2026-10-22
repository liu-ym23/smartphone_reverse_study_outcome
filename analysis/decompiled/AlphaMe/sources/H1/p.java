package H1;

import F1.A;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import f1.AbstractC0557a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class p extends A {

    /* renamed from: a, reason: collision with root package name */
    public final Map f750a;

    public p(LinkedHashMap linkedHashMap) {
        this.f750a = linkedHashMap;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Object objD = d();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                o oVar = (o) this.f750a.get(jsonReader.nextName());
                if (oVar == null || !oVar.f741e) {
                    jsonReader.skipValue();
                } else {
                    f(objD, jsonReader, oVar);
                }
            }
            jsonReader.endObject();
            return e(objD);
        } catch (IllegalAccessException e4) {
            AbstractC0557a abstractC0557a = J1.c.f880a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        } catch (IllegalStateException e5) {
            throw new F1.q(5, e5);
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        try {
            Iterator it = this.f750a.values().iterator();
            while (it.hasNext()) {
                ((o) it.next()).a(jsonWriter, obj);
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException e4) {
            AbstractC0557a abstractC0557a = J1.c.f880a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        }
    }

    public abstract Object d();

    public abstract Object e(Object obj);

    public abstract void f(Object obj, JsonReader jsonReader, o oVar);
}
