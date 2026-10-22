package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class KeyframesParser {
    static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"k"});
    }

    private KeyframesParser() {
    }

    static <T> List<Keyframe<T>> parse(JsonReader r9, LottieComposition r10, float r11, ValueParser<T> r12, boolean r13) throws IOException {
        ArrayList r0 = new ArrayList();
        if (r9.peek() != JsonReader.Token.STRING) goto L6;
        r10.addWarning("Lottie doesn't support expressions.");
        return r0;
    L6:
        r9.beginObject();
    L8:
        if (r9.hasNext() == false) goto L22;
        if (r9.selectName(NAMES) != 0) goto L11;
        if (r9.peek() == JsonReader.Token.BEGIN_ARRAY) goto L14;
        r0.add(KeyframeParser.parse(r9, r10, r11, r12, false, r13));
        goto L8
    L14:
        r9.beginArray();
        if (r9.peek() != JsonReader.Token.NUMBER) goto L18;
        r0.add(KeyframeParser.parse(r9, r10, r11, r12, false, r13));
    L20:
        r9.endArray();
    L18:
        if (r9.hasNext() == false) goto L20;
        r0.add(KeyframeParser.parse(r9, r10, r11, r12, true, r13));
        goto L18
    L11:
        r9.skipValue();
        goto L8
    L22:
        r9.endObject();
        setEndFrames(r0);
        return r0;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> r5) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        int r3 = r0 - 1;
        if (r1 >= r3) goto L12;
        Keyframe<T> r2 = r5.get(r1);
        r1 = r1 + 1;
        Keyframe<T> r4 = r5.get(r1);
        r2.endFrame = Float.valueOf(r4.startFrame);
        if (r2.endValue != null) goto L3;
        if (r4.startValue == null) goto L3;
        r2.endValue = r4.startValue;
        if ((r2 instanceof PathKeyframe) == false) goto L3;
        ((PathKeyframe) r2).createPath();
        goto L3
    L12:
        Keyframe<T> r6 = r5.get(r3);
        if (r6.startValue == null) goto L17;
        if (r6.endValue == null) goto L17;
        return;
    L17:
        if (r5.size() <= 1) goto L30;
        r5.remove(r6);
        return;
    }
}
