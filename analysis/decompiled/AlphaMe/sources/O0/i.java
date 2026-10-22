package O0;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: classes.dex */
public final class i implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final i f1532a = new i();

    @Override // O0.k
    public final Object a(JsonReader jsonReader, float f4) throws IOException {
        boolean z4 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z4) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z4) {
            jsonReader.endArray();
        }
        return new Q0.c((fNextDouble / 100.0f) * f4, (fNextDouble2 / 100.0f) * f4);
    }
}
