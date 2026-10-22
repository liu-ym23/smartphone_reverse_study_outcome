package F1;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public final class j extends A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f433a;

    public j(int i4) {
        this.f433a = i4;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        switch (this.f433a) {
            case 0:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            default:
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
        }
    }

    @Override // F1.A
    public final /* bridge */ /* synthetic */ void c(JsonWriter jsonWriter, Object obj) throws IOException {
        switch (this.f433a) {
            case 0:
                d(jsonWriter, (Number) obj);
                break;
            default:
                d(jsonWriter, (Number) obj);
                break;
        }
    }

    public final void d(JsonWriter jsonWriter, Number number) throws IOException {
        switch (this.f433a) {
            case 0:
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    n.a(dDoubleValue);
                    jsonWriter.value(dDoubleValue);
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
            default:
                if (number != null) {
                    float fFloatValue = number.floatValue();
                    n.a(fFloatValue);
                    if (!(number instanceof Float)) {
                        number = Float.valueOf(fFloatValue);
                    }
                    jsonWriter.value(number);
                    break;
                } else {
                    jsonWriter.nullValue();
                    break;
                }
        }
    }
}
