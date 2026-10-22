package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class GradientFillParser {
    private static final JsonReader.Options GRADIENT_NAMES = null;
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "g", "o", "t", "s", "e", "r", "hd"});
        GRADIENT_NAMES = JsonReader.Options.of(new String[]{"p", "k"});
    }

    private GradientFillParser() {
    }

    static GradientFill parse(JsonReader r14, LottieComposition r15) throws IOException {
        AnimatableIntegerValue r1 = null;
        Path.FillType r6 = Path.FillType.WINDING;
        String r4 = null;
        GradientType r5 = null;
        AnimatableGradientColorValue r7 = null;
        AnimatablePointValue r9 = null;
        AnimatablePointValue r10 = null;
        boolean r13 = false;
    L4:
        if (r14.hasNext() == false) goto L33;
        switch(r14.selectName(NAMES)) {
            case 0: goto L32;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L10;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r13 = r14.nextBoolean();
        goto L4
    L10:
        if (r14.nextInt() != 1) goto L12;
        Path.FillType r0 = Path.FillType.WINDING;
    L13:
        r6 = r0;
        goto L4
    L12:
        r0 = Path.FillType.EVEN_ODD;
        goto L13
    L14:
        r10 = AnimatableValueParser.parsePoint(r14, r15);
        goto L4
    L15:
        r9 = AnimatableValueParser.parsePoint(r14, r15);
        goto L4
    L17:
        if (r14.nextInt() != 1) goto L19;
        GradientType r2 = GradientType.LINEAR;
    L20:
        r5 = r2;
        goto L4
    L19:
        r2 = GradientType.RADIAL;
        goto L20
    L21:
        r1 = AnimatableValueParser.parseInteger(r14, r15);
        goto L4
    L22:
        r14.beginObject();
        int r3 = -1;
    L24:
        if (r14.hasNext() == false) goto L31;
        int r8 = r14.selectName(GRADIENT_NAMES);
        if (r8 != 0) goto L27;
        r3 = r14.nextInt();
        goto L24
    L27:
        if (r8 != 1) goto L28;
        r7 = AnimatableValueParser.parseGradientColor(r14, r15, r3);
        goto L24
    L28:
        r14.skipName();
        r14.skipValue();
        goto L24
    L31:
        r14.endObject();
        goto L4
    L32:
        r4 = r14.nextString();
        goto L4
    L7:
        r14.skipName();
        r14.skipValue();
        goto L4
    L33:
        if (r1 != null) goto L35;
        AnimatableIntegerValue r11 = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
    L37:
        return new GradientFill(r4, r5, r6, r7, r11, r9, r10, null, null, r13);
    L35:
        r11 = r1;
        goto L37
    }
}
