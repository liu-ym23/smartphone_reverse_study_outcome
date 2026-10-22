package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatableTextPropertiesParser {
    private static final JsonReader.Options ANIMATABLE_PROPERTIES_NAMES = null;
    private static final JsonReader.Options PROPERTIES_NAMES = null;

    static {
        PROPERTIES_NAMES = JsonReader.Options.of(new String[]{"a"});
        ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of(new String[]{"fc", "sc", "sw", "t"});
    }

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties parse(JsonReader r3, LottieComposition r4) throws IOException {
        r3.beginObject();
        AnimatableTextProperties r1 = null;
    L4:
        if (r3.hasNext() == false) goto L9;
        if (r3.selectName(PROPERTIES_NAMES) != 0) goto L7;
        r1 = parseAnimatableTextProperties(r3, r4);
        goto L4
    L7:
        r3.skipName();
        r3.skipValue();
        goto L4
    L9:
        r3.endObject();
        if (r1 == null) goto L12;
        return r1;
    L12:
        return new AnimatableTextProperties(null, null, null, null);
    }

    private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader r6, LottieComposition r7) throws IOException {
        r6.beginObject();
        AnimatableColorValue r0 = null;
        AnimatableColorValue r1 = null;
        AnimatableFloatValue r2 = null;
        AnimatableFloatValue r3 = null;
    L4:
        if (r6.hasNext() == false) goto L18;
        int r4 = r6.selectName(ANIMATABLE_PROPERTIES_NAMES);
        if (r4 != 0) goto L8;
        r0 = AnimatableValueParser.parseColor(r6, r7);
        goto L4
    L8:
        if (r4 != 1) goto L10;
        r1 = AnimatableValueParser.parseColor(r6, r7);
        goto L4
    L10:
        if (r4 != 2) goto L12;
        r2 = AnimatableValueParser.parseFloat(r6, r7);
        goto L4
    L12:
        if (r4 != 3) goto L13;
        r3 = AnimatableValueParser.parseFloat(r6, r7);
        goto L4
    L13:
        r6.skipName();
        r6.skipValue();
        goto L4
    L18:
        r6.endObject();
        return new AnimatableTextProperties(r0, r1, r2, r3);
    }
}
