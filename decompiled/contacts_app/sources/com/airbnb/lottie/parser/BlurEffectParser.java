package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class BlurEffectParser {
    private static final JsonReader.Options BLUR_EFFECT_NAMES = null;
    private static final JsonReader.Options INNER_BLUR_EFFECT_NAMES = null;

    BlurEffectParser() {
    }

    static {
        BLUR_EFFECT_NAMES = JsonReader.Options.of(new String[]{"ef"});
        INNER_BLUR_EFFECT_NAMES = JsonReader.Options.of(new String[]{"ty", BaseSwitches.V});
    }

    static BlurEffect parse(JsonReader r2, LottieComposition r3) throws IOException {
        BlurEffect r0 = null;
    L4:
        if (r2.hasNext() == false) goto L15;
        if (r2.selectName(BLUR_EFFECT_NAMES) != 0) goto L7;
        r2.beginArray();
    L10:
        if (r2.hasNext() == false) goto L14;
        BlurEffect r1 = maybeParseInnerEffect(r2, r3);
        if (r1 == null) goto L10;
        r0 = r1;
        goto L10
    L14:
        r2.endArray();
        goto L4
    L7:
        r2.skipName();
        r2.skipValue();
        goto L4
    L15:
        return r0;
    }

    private static BlurEffect maybeParseInnerEffect(JsonReader r5, LottieComposition r6) throws IOException {
        r5.beginObject();
        BlurEffect r0 = null;
    L3:
        boolean r2 = false;
    L5:
        if (r5.hasNext() == false) goto L16;
        int r3 = r5.selectName(INNER_BLUR_EFFECT_NAMES);
        if (r3 != 0) goto L8;
        if (r5.nextInt() != 0) goto L3;
        r2 = true;
        goto L5
    L8:
        if (r3 != 1) goto L9;
        if (r2 == true) goto L11;
        r5.skipValue();
        goto L5
    L11:
        r0 = new BlurEffect(AnimatableValueParser.parseFloat(r5, r6));
        goto L5
    L9:
        r5.skipName();
        r5.skipValue();
        goto L5
    L16:
        r5.endObject();
        return r0;
    }
}
