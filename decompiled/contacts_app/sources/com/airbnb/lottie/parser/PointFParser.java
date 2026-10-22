package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser INSTANCE = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ PointF parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new PointFParser();
    }

    private PointFParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public PointF parse(JsonReader r4, float r5) throws IOException {
        JsonReader.Token r3 = r4.peek();
        if (r3 != JsonReader.Token.BEGIN_ARRAY) goto L7;
        return JsonUtils.jsonToPoint(r4, r5);
    L7:
        if (r3 != JsonReader.Token.BEGIN_OBJECT) goto L11;
        return JsonUtils.jsonToPoint(r4, r5);
    L11:
        if (r3 != JsonReader.Token.NUMBER) goto L18;
        PointF r6 = new PointF(((float) r4.nextDouble()) * r5, ((float) r4.nextDouble()) * r5);
    L14:
        if (r4.hasNext() == false) goto L16;
        r4.skipValue();
        goto L14
    L16:
        return r6;
    L18:
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + r3);
    }
}
