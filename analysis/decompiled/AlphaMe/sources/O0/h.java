package O0;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final h f1531a = new h();

    @Override // O0.k
    public final Object a(JsonReader jsonReader, float f4) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek != JsonToken.BEGIN_ARRAY && jsonTokenPeek != JsonToken.BEGIN_OBJECT) {
            if (jsonTokenPeek != JsonToken.NUMBER) {
                throw new IllegalArgumentException("Cannot convert json to point. Next token is " + jsonTokenPeek);
            }
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f4, ((float) jsonReader.nextDouble()) * f4);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        return com.stepos.statsrpk.c.B(jsonReader, f4);
    }
}
