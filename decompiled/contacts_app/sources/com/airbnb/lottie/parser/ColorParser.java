package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ColorParser implements ValueParser<Integer> {
    public static final ColorParser INSTANCE = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ Integer parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new ColorParser();
    }

    private ColorParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Integer parse(JsonReader r12, float r13) throws IOException {
        if (r12.peek() != JsonReader.Token.BEGIN_ARRAY) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        r12.beginArray();
    L8:
        double r0 = r12.nextDouble();
        double r2 = r12.nextDouble();
        double r4 = r12.nextDouble();
        if (r12.peek() != JsonReader.Token.NUMBER) goto L11;
        double r9 = r12.nextDouble();
    L12:
        if (r11 == false) goto L15;
        r12.endArray();
    L15:
        if (r0 > 1.0d) goto L24;
        if (r2 > 1.0d) goto L24;
        if (r4 > 1.0d) goto L24;
        r0 = r0 * 255.0d;
        r2 = r2 * 255.0d;
        r4 = r4 * 255.0d;
        if (r9 > 1.0d) goto L24;
        r9 = r9 * 255.0d;
    L24:
        return Integer.valueOf(Color.argb((int) r9, (int) r0, (int) r2, (int) r4));
    L11:
        r9 = 1.0d;
        goto L12
    L5:
        r11 = false;
        goto L6
    }
}
