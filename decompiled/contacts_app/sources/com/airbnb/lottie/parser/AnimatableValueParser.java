package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableFloatValue parseFloat(JsonReader r1, LottieComposition r2) throws IOException {
        return parseFloat(r1, r2, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader r2, LottieComposition r3, boolean r4) throws IOException {
        if (r4 == false) goto L5;
        float r5 = Utils.dpScale();
    L7:
        return new AnimatableFloatValue(parse(r2, r5, r3, FloatParser.INSTANCE));
    L5:
        r5 = 1.0f;
        goto L7
    }

    static AnimatableIntegerValue parseInteger(JsonReader r2, LottieComposition r3) throws IOException {
        return new AnimatableIntegerValue(parse(r2, r3, IntegerParser.INSTANCE));
    }

    static AnimatablePointValue parsePoint(JsonReader r4, LottieComposition r5) throws IOException {
        return new AnimatablePointValue(KeyframesParser.parse(r4, r5, Utils.dpScale(), PointFParser.INSTANCE, true));
    }

    static AnimatableScaleValue parseScale(JsonReader r2, LottieComposition r3) throws IOException {
        return new AnimatableScaleValue(parse(r2, r3, ScaleXYParser.INSTANCE));
    }

    static AnimatableShapeValue parseShapeData(JsonReader r3, LottieComposition r4) throws IOException {
        return new AnimatableShapeValue(parse(r3, Utils.dpScale(), r4, ShapeDataParser.INSTANCE));
    }

    static AnimatableTextFrame parseDocumentData(JsonReader r3, LottieComposition r4) throws IOException {
        return new AnimatableTextFrame(parse(r3, Utils.dpScale(), r4, DocumentDataParser.INSTANCE));
    }

    static AnimatableColorValue parseColor(JsonReader r2, LottieComposition r3) throws IOException {
        return new AnimatableColorValue(parse(r2, r3, ColorParser.INSTANCE));
    }

    static AnimatableGradientColorValue parseGradientColor(JsonReader r2, LottieComposition r3, int r4) throws IOException {
        return new AnimatableGradientColorValue(parse(r2, r3, new GradientColorParser(r4)));
    }

    private static <T> List<Keyframe<T>> parse(JsonReader r2, LottieComposition r3, ValueParser<T> r4) throws IOException {
        return KeyframesParser.parse(r2, r3, 1.0f, r4, false);
    }

    private static <T> List<Keyframe<T>> parse(JsonReader r1, float r2, LottieComposition r3, ValueParser<T> r4) throws IOException {
        return KeyframesParser.parse(r1, r3, r2, r4, false);
    }
}
