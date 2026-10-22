package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class RoundedCornersParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "r", "hd"});
    }

    private RoundedCornersParser() {
    }

    static RoundedCorners parse(JsonReader r6, LottieComposition r7) throws IOException {
        boolean r1 = false;
        String r2 = null;
        AnimatableFloatValue r3 = null;
    L4:
        if (r6.hasNext() == false) goto L15;
        int r4 = r6.selectName(NAMES);
        if (r4 != 0) goto L8;
        r2 = r6.nextString();
        goto L4
    L8:
        if (r4 != 1) goto L10;
        r3 = AnimatableValueParser.parseFloat(r6, r7, true);
        goto L4
    L10:
        if (r4 != 2) goto L11;
        r1 = r6.nextBoolean();
        goto L4
    L11:
        r6.skipValue();
        goto L4
    L15:
        if (r1 == false) goto L18;
        return null;
    L18:
        return new RoundedCorners(r2, r3);
    }
}
