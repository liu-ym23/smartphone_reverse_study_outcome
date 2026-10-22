package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ GradientColor parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    public GradientColorParser(int r1) {
        this.colorPoints = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public GradientColor parse(JsonReader r18, float r19) throws IOException {
        ArrayList r1 = new ArrayList();
        int r5 = 0;
        if (r18.peek() != JsonReader.Token.BEGIN_ARRAY) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        r18.beginArray();
    L9:
        if (r18.hasNext() == false) goto L12;
        r1.add(Float.valueOf((float) r18.nextDouble()));
        goto L9
    L12:
        if (r1.size() == 4) goto L14;
    L16:
        if (r2 == false) goto L19;
        r18.endArray();
    L19:
        if (this.colorPoints != (-1)) goto L21;
        this.colorPoints = r1.size() / 4;
    L21:
        int r3 = this.colorPoints;
        float[] r4 = new float[r3];
        int[] r6 = new int[r3];
        int r9 = 0;
        int r10 = 0;
    L23:
        if (r5 >= (this.colorPoints * 4)) goto L41;
        int r11 = r5 / 4;
        double r12 = r1.get(r5).floatValue();
        int r14 = r5 % 4;
        if (r14 != 0) goto L27;
        if (r11 <= 0) goto L38;
        float r15 = (float) r12;
        if (r4[r11 - 1] < r15) goto L38;
        r4[r11] = r15 + 0.01f;
    L39:
        r5 = r5 + 1;
    L38:
        r4[r11] = (float) r12;
        goto L39
    L27:
        if (r14 == 1) goto L33;
        if (r14 == 2) goto L32;
        if (r14 != 3) goto L39;
        r6[r11] = Color.argb(255, r9, r10, (int) (r12 * 255.0d));
        goto L39
    L32:
        r10 = (int) (r12 * 255.0d);
        goto L39
    L33:
        r9 = (int) (r12 * 255.0d);
        goto L39
    L41:
        return addOpacityStopsToGradientIfNeeded(new GradientColor(r4, r6), r1);
    L14:
        if (r1.get(0).floatValue() != 1.0f) goto L16;
        r1.set(0, Float.valueOf(0.0f));
        r1.add(Float.valueOf(1.0f));
        r1.add(r1.get(1));
        r1.add(r1.get(2));
        r1.add(r1.get(3));
        this.colorPoints = 2;
        goto L16
    L5:
        r2 = false;
        goto L6
    }

    private GradientColor addOpacityStopsToGradientIfNeeded(GradientColor r10, List<Float> r11) {
        int r0 = this.colorPoints * 4;
        if (r11.size() > r0) goto L5;
        return r10;
    L5:
        float[] r1 = r10.getPositions();
        int[] r2 = r10.getColors();
        int r3 = (r11.size() - r0) / 2;
        float[] r4 = new float[r3];
        float[] r5 = new float[r3];
        int r6 = 0;
        int r7 = 0;
    L7:
        if (r0 >= r11.size()) goto L13;
        if ((r0 % 2) != 0) goto L11;
        r4[r7] = r11.get(r0).floatValue();
    L12:
        r0 = r0 + 1;
        goto L7
    L11:
        r5[r7] = r11.get(r0).floatValue();
        r7 = r7 + 1;
        goto L12
    L13:
        float[] r12 = mergeUniqueElements(r10.getPositions(), r4);
        int r13 = r12.length;
        int[] r8 = new int[r13];
    L14:
        if (r6 >= r13) goto L25;
        float r9 = r12[r6];
        int r14 = Arrays.binarySearch(r1, r9);
        int r15 = Arrays.binarySearch(r4, r9);
        if (r14 < 0) goto L20;
        if (r15 > 0) goto L20;
        r8[r6] = getColorInBetweenOpacityStops(r9, r2[r14], r4, r5);
    L23:
        r6 = r6 + 1;
    L20:
        if (r15 >= 0) goto L22;
        r15 = -(r15 + 1);
    L22:
        r8[r6] = getColorInBetweenColorStops(r9, r5[r15], r1, r2);
        goto L23
    L25:
        return new GradientColor(r12, r8);
    }

    int getColorInBetweenColorStops(float r4, float r5, float[] r6, int[] r7) {
        if (r7.length < 2) goto L20;
        if (r4 == r6[0]) goto L20;
        int r0 = 1;
    L9:
        if (r0 >= r6.length) goto L18;
        float r1 = r6[r0];
        if (r1 >= r4) goto L15;
        if (r0 == (r6.length - 1)) goto L15;
        r0 = r0 + 1;
    L15:
        int r3 = r0 - 1;
        float r8 = r6[r3];
        float r9 = (r4 - r8) / (r1 - r8);
        int r10 = r7[r0];
        int r11 = r7[r3];
        return Color.argb((int) (r5 * 255.0f), GammaEvaluator.evaluate(r9, Color.red(r11), Color.red(r10)), GammaEvaluator.evaluate(r9, Color.green(r11), Color.green(r10)), GammaEvaluator.evaluate(r9, Color.blue(r11), Color.blue(r10)));
    L18:
        throw new IllegalArgumentException("Unreachable code.");
    L20:
        return r7[0];
    }

    private int getColorInBetweenOpacityStops(float r6, int r7, float[] r8, float[] r9) {
        if (r9.length < 2) goto L23;
        if (r6 <= r8[0]) goto L23;
        int r0 = 1;
    L9:
        if (r0 >= r8.length) goto L21;
        float r1 = r8[r0];
        if (r1 >= r6) goto L15;
        if (r0 == (r8.length - 1)) goto L15;
        r0 = r0 + 1;
    L15:
        if (r1 > r6) goto L17;
        float r5 = r9[r0];
    L19:
        return Color.argb((int) (r5 * 255.0f), Color.red(r7), Color.green(r7), Color.blue(r7));
    L17:
        int r10 = r0 - 1;
        float r11 = r8[r10];
        r5 = MiscUtils.lerp(r9[r10], r9[r0], (r6 - r11) / (r1 - r11));
        goto L19
    L21:
        throw new IllegalArgumentException("Unreachable code.");
    L23:
        return Color.argb((int) (r9[0] * 255.0f), Color.red(r7), Color.green(r7), Color.blue(r7));
    }

    protected static float[] mergeUniqueElements(float[] r9, float[] r10) {
        if (r9.length != 0) goto L6;
        return r10;
    L6:
        if (r10.length != 0) goto L8;
        return r9;
    L8:
        int r0 = r9.length + r10.length;
        float[] r1 = new float[r0];
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r2 >= r0) goto L31;
        float r7 = Float.NaN;
        if (r4 >= r9.length) goto L13;
        float r6 = r9[r4];
    L15:
        if (r5 >= r10.length) goto L18;
        r7 = r10[r5];
    L18:
        if (Float.isNaN(r7) == false) goto L20;
    L29:
        r1[r2] = r6;
        r4 = r4 + 1;
    L30:
        r2 = r2 + 1;
        goto L9
    L20:
        if (r6 < r7) goto L29;
        if (Float.isNaN(r6) == false) goto L25;
    L28:
        r1[r2] = r7;
        r5 = r5 + 1;
        goto L30
    L25:
        if (r7 < r6) goto L28;
        r1[r2] = r6;
        r4 = r4 + 1;
        r5 = r5 + 1;
        r3 = r3 + 1;
        goto L30
    L13:
        r6 = Float.NaN;
        goto L15
    L31:
        if (r3 != 0) goto L34;
        return r1;
    L34:
        return Arrays.copyOf(r1, r0 - r3);
    }
}
