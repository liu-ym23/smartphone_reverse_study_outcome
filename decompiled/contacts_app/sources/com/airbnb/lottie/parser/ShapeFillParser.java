package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
class ShapeFillParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "c", "o", "fillEnabled", "r", "hd"});
    }

    private ShapeFillParser() {
    }

    static ShapeFill parse(JsonReader r10, LottieComposition r11) throws IOException {
        AnimatableIntegerValue r0 = null;
        String r4 = null;
        AnimatableColorValue r7 = null;
        boolean r5 = false;
        boolean r9 = false;
        int r1 = 1;
    L4:
        if (r10.hasNext() == false) goto L23;
        int r3 = r10.selectName(NAMES);
        if (r3 != 0) goto L7;
        r4 = r10.nextString();
        goto L4
    L7:
        if (r3 != 1) goto L9;
        r7 = AnimatableValueParser.parseColor(r10, r11);
        goto L4
    L9:
        if (r3 != 2) goto L11;
        r0 = AnimatableValueParser.parseInteger(r10, r11);
        goto L4
    L11:
        if (r3 != 3) goto L13;
        r5 = r10.nextBoolean();
        goto L4
    L13:
        if (r3 != 4) goto L15;
        r1 = r10.nextInt();
        goto L4
    L15:
        if (r3 != 5) goto L16;
        r9 = r10.nextBoolean();
        goto L4
    L16:
        r10.skipName();
        r10.skipValue();
        goto L4
    L23:
        if (r0 != null) goto L25;
        r0 = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
    L25:
        AnimatableIntegerValue r8 = r0;
        if (r1 != 1) goto L28;
        Path.FillType r12 = Path.FillType.WINDING;
    L30:
        return new ShapeFill(r4, r5, r12, r7, r8, r9);
    L28:
        r12 = Path.FillType.EVEN_ODD;
        goto L30
    }
}
