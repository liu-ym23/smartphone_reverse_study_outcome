package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ShapePathParser {
    static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "ind", "ks", "hd"});
    }

    private ShapePathParser() {
    }

    static ShapePath parse(JsonReader r6, LottieComposition r7) throws IOException {
        String r0 = null;
        int r2 = 0;
        boolean r3 = false;
        AnimatableShapeValue r1 = null;
    L4:
        if (r6.hasNext() == false) goto L19;
        int r4 = r6.selectName(NAMES);
        if (r4 != 0) goto L8;
        r0 = r6.nextString();
        goto L4
    L8:
        if (r4 != 1) goto L10;
        r2 = r6.nextInt();
        goto L4
    L10:
        if (r4 != 2) goto L12;
        r1 = AnimatableValueParser.parseShapeData(r6, r7);
        goto L4
    L12:
        if (r4 != 3) goto L13;
        r3 = r6.nextBoolean();
        goto L4
    L13:
        r6.skipValue();
        goto L4
    L19:
        return new ShapePath(r0, r2, r1, r3);
    }
}
