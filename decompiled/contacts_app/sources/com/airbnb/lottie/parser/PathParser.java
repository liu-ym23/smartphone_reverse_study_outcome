package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PathParser implements ValueParser<PointF> {
    public static final PathParser INSTANCE = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ PointF parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new PathParser();
    }

    private PathParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public PointF parse(JsonReader r1, float r2) throws IOException {
        return JsonUtils.jsonToPoint(r1, r2);
    }
}
