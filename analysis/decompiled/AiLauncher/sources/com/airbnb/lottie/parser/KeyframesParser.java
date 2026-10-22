package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class KeyframesParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("k");

    private KeyframesParser() {
    }

    public static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f10, ValueParser<T> valueParser, boolean z10) throws IOException {
        JsonReader jsonReader2;
        LottieComposition lottieComposition2;
        float f11;
        ValueParser<T> valueParser2;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(NAMES) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    JsonReader jsonReader3 = jsonReader;
                    LottieComposition lottieComposition3 = lottieComposition;
                    float f12 = f10;
                    ValueParser<T> valueParser3 = valueParser;
                    boolean z12 = z10;
                    Keyframe keyframe = KeyframeParser.parse(jsonReader3, lottieComposition3, f12, valueParser3, false, z12);
                    jsonReader2 = jsonReader3;
                    lottieComposition2 = lottieComposition3;
                    f11 = f12;
                    valueParser2 = valueParser3;
                    z11 = z12;
                    arrayList.add(keyframe);
                } else {
                    jsonReader2 = jsonReader;
                    lottieComposition2 = lottieComposition;
                    f11 = f10;
                    valueParser2 = valueParser;
                    z11 = z10;
                    while (jsonReader2.hasNext()) {
                        arrayList.add(KeyframeParser.parse(jsonReader2, lottieComposition2, f11, valueParser2, true, z11));
                    }
                }
                jsonReader2.endArray();
                jsonReader = jsonReader2;
                lottieComposition = lottieComposition2;
                f10 = f11;
                valueParser = valueParser2;
                z10 = z11;
            } else {
                JsonReader jsonReader4 = jsonReader;
                arrayList.add(KeyframeParser.parse(jsonReader4, lottieComposition, f10, valueParser, false, z10));
                jsonReader = jsonReader4;
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> list) {
        int i10;
        T t10;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            Keyframe<T> keyframe = list.get(i11);
            i11++;
            Keyframe<T> keyframe2 = list.get(i11);
            keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
            if (keyframe.endValue == null && (t10 = keyframe2.startValue) != null) {
                keyframe.endValue = t10;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i10);
        if ((keyframe3.startValue == null || keyframe3.endValue == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
