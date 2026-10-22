package F1;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class l extends A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f435a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f436b;

    public l(A a4, int i4) {
        this.f435a = i4;
        this.f436b = a4;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        int i4 = this.f435a;
        A a4 = this.f436b;
        switch (i4) {
            case 0:
                return new AtomicLong(((Number) a4.b(jsonReader)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) a4.b(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i5 = 0; i5 < size; i5++) {
                    atomicLongArray.set(i5, ((Long) arrayList.get(i5)).longValue());
                }
                return atomicLongArray;
            default:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return a4.b(jsonReader);
                }
                jsonReader.nextNull();
                return null;
        }
    }

    @Override // F1.A
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        int i4 = this.f435a;
        A a4 = this.f436b;
        switch (i4) {
            case 0:
                a4.c(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
                break;
            case 1:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    a4.c(jsonWriter, Long.valueOf(atomicLongArray.get(i5)));
                }
                jsonWriter.endArray();
                break;
            default:
                if (obj == null) {
                    jsonWriter.nullValue();
                    break;
                } else {
                    a4.c(jsonWriter, obj);
                    break;
                }
        }
    }
}
