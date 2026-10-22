package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.obric.oui.calendar.format.DayFormatter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class PolystarShapeParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", DayFormatter.DEFAULT_FORMAT});
    }

    private PolystarShapeParser() {
    }

    static PolystarShape parse(JsonReader r19, LottieComposition r20, int r21) throws IOException {
        if (r21 != 3) goto L5;
        boolean r5 = true;
    L6:
        boolean r17 = false;
        boolean r18 = r5;
        String r8 = null;
        PolystarShape.Type r9 = null;
        AnimatableFloatValue r10 = null;
        AnimatableValue<PointF, PointF> r11 = null;
        AnimatableFloatValue r12 = null;
        AnimatableFloatValue r13 = null;
        AnimatableFloatValue r14 = null;
        AnimatableFloatValue r15 = null;
        AnimatableFloatValue r16 = null;
    L8:
        if (r19.hasNext() == false) goto L27;
        switch(r19.selectName(NAMES)) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L13;
            default: goto L11;
        };
    L13:
        if (r19.nextInt() == 3) goto L14;
        r18 = false;
        goto L8
    L14:
        r18 = true;
        goto L8
    L16:
        r17 = r19.nextBoolean();
        goto L8
    L17:
        r15 = AnimatableValueParser.parseFloat(r19, r20, false);
        goto L8
    L18:
        r13 = AnimatableValueParser.parseFloat(r19, r20);
        goto L8
    L19:
        r16 = AnimatableValueParser.parseFloat(r19, r20, false);
        goto L8
    L20:
        r14 = AnimatableValueParser.parseFloat(r19, r20);
        goto L8
    L21:
        r12 = AnimatableValueParser.parseFloat(r19, r20, false);
        goto L8
    L22:
        r11 = AnimatablePathValueParser.parseSplitPath(r19, r20);
        goto L8
    L23:
        r10 = AnimatableValueParser.parseFloat(r19, r20, false);
        goto L8
    L24:
        r9 = PolystarShape.Type.forValue(r19.nextInt());
        goto L8
    L25:
        r8 = r19.nextString();
        goto L8
    L11:
        r19.skipName();
        r19.skipValue();
        goto L8
    L27:
        return new PolystarShape(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L5:
        r5 = false;
        goto L6
    }
}
