package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser INSTANCE = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ Float parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new FloatParser();
    }

    private FloatParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Float parse(JsonReader r1, float r2) throws IOException {
        return Float.valueOf(JsonUtils.valueFromObject(r1) * r2);
    }
}
