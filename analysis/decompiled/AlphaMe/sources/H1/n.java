package H1;

import F1.A;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class n extends A {

    /* renamed from: c, reason: collision with root package name */
    public static final j f734c = new j(1, F1.y.f452a);

    /* renamed from: a, reason: collision with root package name */
    public final F1.n f735a;

    /* renamed from: b, reason: collision with root package name */
    public final F1.z f736b;

    public n(F1.n nVar, F1.z zVar) {
        this.f735a = nVar;
        this.f736b = zVar;
    }

    public static Serializable e(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i4 = m.f733a[jsonToken.ordinal()];
        if (i4 == 1) {
            jsonReader.beginArray();
            return new ArrayList();
        }
        if (i4 != 2) {
            return null;
        }
        jsonReader.beginObject();
        return new G1.o(true);
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        Object objE = e(jsonReader, jsonTokenPeek);
        if (objE == null) {
            return d(jsonReader, jsonTokenPeek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                String strNextName = objE instanceof Map ? jsonReader.nextName() : null;
                JsonToken jsonTokenPeek2 = jsonReader.peek();
                Serializable serializableE = e(jsonReader, jsonTokenPeek2);
                boolean z4 = serializableE != null;
                if (serializableE == null) {
                    serializableE = d(jsonReader, jsonTokenPeek2);
                }
                if (objE instanceof List) {
                    ((List) objE).add(serializableE);
                } else {
                    ((Map) objE).put(strNextName, serializableE);
                }
                if (z4) {
                    arrayDeque.addLast(objE);
                    objE = serializableE;
                }
            } else {
                if (objE instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return objE;
                }
                objE = arrayDeque.removeLast();
            }
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Class<?> cls = obj.getClass();
        F1.n nVar = this.f735a;
        nVar.getClass();
        A aE = nVar.e(TypeToken.get((Class) cls));
        if (!(aE instanceof n)) {
            aE.c(jsonWriter, obj);
        } else {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        }
    }

    public final Serializable d(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int i4 = m.f733a[jsonToken.ordinal()];
        if (i4 == 3) {
            return jsonReader.nextString();
        }
        if (i4 == 4) {
            return this.f736b.a(jsonReader);
        }
        if (i4 == 5) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i4 == 6) {
            jsonReader.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }
}
