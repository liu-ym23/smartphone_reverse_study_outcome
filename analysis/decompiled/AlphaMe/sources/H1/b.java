package H1;

import F1.A;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b extends A {

    /* renamed from: c, reason: collision with root package name */
    public static final a f707c = new a(0);

    /* renamed from: a, reason: collision with root package name */
    public final Class f708a;

    /* renamed from: b, reason: collision with root package name */
    public final u f709b;

    public b(F1.n nVar, A a4, Class cls) {
        this.f709b = new u(nVar, a4, cls);
        this.f708a = cls;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f709b.b(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Class cls = this.f708a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i4 = 0; i4 < size; i4++) {
            Array.set(objNewInstance, i4, arrayList.get(i4));
        }
        return objNewInstance;
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i4 = 0; i4 < length; i4++) {
            this.f709b.c(jsonWriter, Array.get(obj, i4));
        }
        jsonWriter.endArray();
    }
}
