package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    static PathKeyframe parse(JsonReader r7, LottieComposition r8) throws IOException {
        if (r7.peek() != JsonReader.Token.BEGIN_OBJECT) goto L5;
        boolean r0 = true;
    L6:
        float r3 = Utils.dpScale();
        PathParser r4 = PathParser.INSTANCE;
        return new PathKeyframe(r8, KeyframeParser.parse(r7, r8, r3, r4, r0, false));
    L5:
        r0 = false;
        goto L6
    }
}
