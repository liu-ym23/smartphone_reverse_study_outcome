package H1;

import F1.A;
import androidx.room.AbstractC0351g;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends A {

    /* renamed from: a, reason: collision with root package name */
    public final u f722a;

    /* renamed from: b, reason: collision with root package name */
    public final u f723b;

    /* renamed from: c, reason: collision with root package name */
    public final G1.p f724c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f725d;

    public h(i iVar, F1.n nVar, Type type, A a4, Type type2, A a5, G1.p pVar) {
        this.f725d = iVar;
        this.f722a = new u(nVar, a4, type);
        this.f723b = new u(nVar, a5, type2);
        this.f724c = pVar;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Map map = (Map) this.f724c.i();
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        u uVar = this.f723b;
        u uVar2 = this.f722a;
        if (jsonTokenPeek == jsonToken) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                Object objB = uVar2.b(jsonReader);
                if (map.put(objB, uVar.b(jsonReader)) != null) {
                    throw new F1.q(AbstractC0351g.o("duplicate key: ", objB), 5);
                }
                jsonReader.endArray();
            }
            jsonReader.endArray();
        } else {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                G1.i.INSTANCE.promoteNameToValue(jsonReader);
                Object objB2 = uVar2.b(jsonReader);
                if (map.put(objB2, uVar.b(jsonReader)) != null) {
                    throw new F1.q(AbstractC0351g.o("duplicate key: ", objB2), 5);
                }
            }
            jsonReader.endObject();
        }
        return map;
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        String strA;
        Map map = (Map) obj;
        if (map == null) {
            jsonWriter.nullValue();
            return;
        }
        boolean z4 = this.f725d.f727b;
        u uVar = this.f723b;
        if (!z4) {
            jsonWriter.beginObject();
            for (Map.Entry entry : map.entrySet()) {
                jsonWriter.name(String.valueOf(entry.getKey()));
                uVar.c(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
            return;
        }
        ArrayList arrayList = new ArrayList(map.size());
        ArrayList arrayList2 = new ArrayList(map.size());
        int i4 = 0;
        boolean z5 = false;
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            u uVar2 = this.f722a;
            uVar2.getClass();
            try {
                g gVar = new g();
                uVar2.c(gVar, key);
                ArrayList arrayList3 = gVar.f719a;
                if (!arrayList3.isEmpty()) {
                    throw new IllegalStateException("Expected one JSON element but was " + arrayList3);
                }
                F1.p pVar = gVar.f721c;
                arrayList.add(pVar);
                arrayList2.add(entry2.getValue());
                pVar.getClass();
                z5 |= (pVar instanceof F1.o) || (pVar instanceof F1.s);
            } catch (IOException e4) {
                throw new F1.q(5, e4);
            }
        }
        if (z5) {
            jsonWriter.beginArray();
            int size = arrayList.size();
            while (i4 < size) {
                jsonWriter.beginArray();
                com.airbnb.lottie.h.L((F1.p) arrayList.get(i4), jsonWriter);
                uVar.c(jsonWriter, arrayList2.get(i4));
                jsonWriter.endArray();
                i4++;
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginObject();
        int size2 = arrayList.size();
        while (i4 < size2) {
            F1.p pVar2 = (F1.p) arrayList.get(i4);
            pVar2.getClass();
            boolean z6 = pVar2 instanceof F1.t;
            if (z6) {
                if (!z6) {
                    throw new IllegalStateException("Not a JSON Primitive: " + pVar2);
                }
                F1.t tVar = (F1.t) pVar2;
                Serializable serializable = tVar.f451a;
                if (serializable instanceof Number) {
                    strA = String.valueOf(tVar.c());
                } else if (serializable instanceof Boolean) {
                    strA = Boolean.toString(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(tVar.a()));
                } else {
                    if (!(serializable instanceof String)) {
                        throw new AssertionError();
                    }
                    strA = tVar.a();
                }
            } else {
                if (!(pVar2 instanceof F1.r)) {
                    throw new AssertionError();
                }
                strA = "null";
            }
            jsonWriter.name(strA);
            uVar.c(jsonWriter, arrayList2.get(i4));
            i4++;
        }
        jsonWriter.endObject();
    }
}
