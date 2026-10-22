package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class GradientStrokeParser {
    private static final JsonReader.Options DASH_PATTERN_NAMES = null;
    private static final JsonReader.Options GRADIENT_NAMES = null;
    private static final JsonReader.Options NAMES = null;

    private GradientStrokeParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", DayFormatter.DEFAULT_FORMAT});
        GRADIENT_NAMES = JsonReader.Options.of(new String[]{"p", "k"});
        DASH_PATTERN_NAMES = JsonReader.Options.of(new String[]{"n", BaseSwitches.V});
    }

    static GradientStroke parse(JsonReader r21, LottieComposition r22) throws IOException {
        ArrayList r11 = new ArrayList();
        float r13 = 0.0f;
        String r3 = null;
        GradientType r5 = null;
        AnimatableGradientColorValue r6 = null;
        AnimatablePointValue r7 = null;
        AnimatablePointValue r8 = null;
        AnimatableFloatValue r9 = null;
        ShapeStroke.LineCapType r10 = null;
        ShapeStroke.LineJoinType r12 = null;
        AnimatableFloatValue r14 = null;
        boolean r15 = false;
        AnimatableIntegerValue r16 = null;
    L4:
        if (r21.hasNext() == false) goto L65;
        switch(r21.selectName(NAMES)) {
            case 0: goto L64;
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L40;
            case 9: goto L39;
            case 10: goto L38;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        r21.beginArray();
    L10:
        if (r21.hasNext() == false) goto L33;
        r21.beginObject();
        String r2 = null;
        AnimatableFloatValue r18 = null;
    L13:
        if (r21.hasNext() == false) goto L22;
        int r4 = r21.selectName(DASH_PATTERN_NAMES);
        if (r4 != 0) goto L16;
        r2 = r21.nextString();
        goto L13
    L16:
        AnimatableFloatValue r20 = r14;
        if (r4 == 1) goto L19;
        r21.skipName();
        r21.skipValue();
    L20:
        r14 = r20;
        goto L13
    L19:
        r18 = AnimatableValueParser.parseFloat(r21, r22);
        goto L20
    L22:
        AnimatableFloatValue r23 = r14;
        r21.endObject();
        if (r2.equals("o") == true) goto L24;
        if (r2.equals(DayFormatter.DEFAULT_FORMAT) == false) goto L28;
    L31:
        r22.setHasDashPattern(true);
        r11.add(r18);
    L32:
        r14 = r23;
        goto L10
    L28:
        if (r2.equals("g") == false) goto L32;
    L24:
        r14 = r18;
        goto L10
    L33:
        AnimatableFloatValue r24 = r14;
        r21.endArray();
        if (r11.size() != 1) goto L37;
        r11.add((AnimatableFloatValue) r11.get(0));
    L37:
        r14 = r24;
        goto L4
    L38:
        r15 = r21.nextBoolean();
        goto L4
    L39:
        r13 = (float) r21.nextDouble();
    L42:
        r3 = r3;
        goto L4
    L40:
        r12 = ShapeStroke.LineJoinType.values()[r21.nextInt() - 1];
        goto L42
    L41:
        r10 = ShapeStroke.LineCapType.values()[r21.nextInt() - 1];
        goto L42
    L43:
        r9 = AnimatableValueParser.parseFloat(r21, r22);
        goto L4
    L44:
        r8 = AnimatableValueParser.parsePoint(r21, r22);
        goto L4
    L45:
        r7 = AnimatableValueParser.parsePoint(r21, r22);
        goto L4
    L47:
        if (r21.nextInt() != 1) goto L49;
        GradientType r17 = GradientType.LINEAR;
    L50:
        r5 = r17;
        goto L42
    L49:
        r17 = GradientType.RADIAL;
        goto L50
    L51:
        r16 = AnimatableValueParser.parseInteger(r21, r22);
        goto L4
    L52:
        r21.beginObject();
        int r19 = -1;
    L54:
        if (r21.hasNext() == false) goto L63;
        int r25 = r21.selectName(GRADIENT_NAMES);
        if (r25 == 0) goto L61;
        if (r25 != 1) goto L59;
        r6 = AnimatableValueParser.parseGradientColor(r21, r22, r19);
        goto L54
    L59:
        r21.skipName();
        r21.skipValue();
    L62:
        r6 = r6;
        goto L54
    L61:
        r19 = r21.nextInt();
        goto L62
    L63:
        r21.endObject();
        goto L42
    L64:
        r3 = r21.nextString();
        goto L4
    L7:
        r21.skipName();
        r21.skipValue();
        goto L4
    L65:
        String r26 = r3;
        if (r16 != null) goto L69;
        r16 = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
    L69:
        return new GradientStroke(r26, r5, r6, r16, r7, r8, r9, r10, r12, r13, r11, r14, r15);
    }
}
