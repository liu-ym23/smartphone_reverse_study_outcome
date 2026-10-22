package zc;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import tb.AbstractC5531D;
import yc.h;

/* loaded from: classes5.dex */
public final class c<T> implements h<AbstractC5531D, T> {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f45476a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f45477b;

    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f45476a = gson;
        this.f45477b = typeAdapter;
    }

    @Override // yc.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T convert(AbstractC5531D abstractC5531D) throws IOException {
        JsonReader jsonReaderNewJsonReader = this.f45476a.newJsonReader(abstractC5531D.e());
        try {
            T t10 = this.f45477b.read(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return t10;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            abstractC5531D.close();
        }
    }
}
