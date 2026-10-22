package retrofit2.converter.gson;

import F1.A;
import F1.n;
import F1.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import h3.f0;
import java.io.IOException;
import java.io.Reader;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<f0, T> {
    private final A adapter;
    private final n gson;

    public GsonResponseBodyConverter(n nVar, A a4) {
        this.gson = nVar;
        this.adapter = a4;
    }

    @Override // retrofit2.Converter
    public T convert(f0 f0Var) throws IOException {
        n nVar = this.gson;
        Reader readerCharStream = f0Var.charStream();
        nVar.getClass();
        JsonReader jsonReader = new JsonReader(readerCharStream);
        jsonReader.setLenient(false);
        try {
            T t4 = (T) this.adapter.b(jsonReader);
            if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                return t4;
            }
            throw new q("JSON document was not fully consumed.", 5);
        } finally {
            f0Var.close();
        }
    }
}
