package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class RectangleShapeParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "p", "s", "r", "hd"});
    }

    private RectangleShapeParser() {
    }

    static RectangleShape parse(JsonReader r8, LottieComposition r9) throws IOException {
        String r3 = null;
        AnimatableValue<PointF, PointF> r4 = null;
        AnimatablePointValue r5 = null;
        AnimatableFloatValue r6 = null;
        boolean r7 = false;
    L4:
        if (r8.hasNext() == false) goto L22;
        int r0 = r8.selectName(NAMES);
        if (r0 != 0) goto L8;
        r3 = r8.nextString();
        goto L4
    L8:
        if (r0 != 1) goto L10;
        r4 = AnimatablePathValueParser.parseSplitPath(r8, r9);
        goto L4
    L10:
        if (r0 != 2) goto L12;
        r5 = AnimatableValueParser.parsePoint(r8, r9);
        goto L4
    L12:
        if (r0 != 3) goto L14;
        r6 = AnimatableValueParser.parseFloat(r8, r9);
        goto L4
    L14:
        if (r0 != 4) goto L15;
        r7 = r8.nextBoolean();
        goto L4
    L15:
        r8.skipValue();
        goto L4
    L22:
        return new RectangleShape(r3, r4, r5, r6, r7);
    }
}
