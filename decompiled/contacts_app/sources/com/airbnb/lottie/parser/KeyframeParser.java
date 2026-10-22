package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class KeyframeParser {
    static JsonReader.Options INTERPOLATOR_NAMES = null;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final float MAX_CP_VALUE = 100.0f;
    static JsonReader.Options NAMES;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    KeyframeParser() {
    }

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        NAMES = JsonReader.Options.of(new String[]{"t", "s", "e", "o", "i", "h", "to", "ti"});
        INTERPOLATOR_NAMES = JsonReader.Options.of(new String[]{MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y});
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache != null) goto L6;
        pathInterpolatorCache = new SparseArrayCompat();
    L6:
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int r2) {
        monitor-enter(KeyframeParser.class);
        WeakReference<Interpolator> r3 = pathInterpolatorCache().get(r2);     // Catch: Throwable -> L7
        monitor-exit(KeyframeParser.class);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    private static void putInterpolator(int r2, WeakReference<Interpolator> r3) {
        monitor-enter(KeyframeParser.class);
        pathInterpolatorCache.put(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(KeyframeParser.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static <T> Keyframe<T> parse(JsonReader r0, LottieComposition r1, float r2, ValueParser<T> r3, boolean r4, boolean r5) throws IOException {
        if (r4 == false) goto L6;
        if (r5 == false) goto L6;
        return parseMultiDimensionalKeyframe(r1, r0, r2, r3);
    L6:
        if (r4 == false) goto L10;
        return parseKeyframe(r1, r0, r2, r3);
    L10:
        return parseStaticValue(r0, r2, r3);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition r12, JsonReader r13, float r14, ValueParser<T> r15) throws IOException {
        r13.beginObject();
        PointF r0 = null;
        T r3 = null;
        T r5 = null;
        PointF r10 = null;
        PointF r11 = null;
        float r8 = 0.0f;
        boolean r4 = false;
        PointF r1 = null;
    L4:
        if (r13.hasNext() == false) goto L19;
        switch(r13.selectName(NAMES)) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r11 = JsonUtils.jsonToPoint(r13, r14);
        goto L4
    L9:
        r10 = JsonUtils.jsonToPoint(r13, r14);
        goto L4
    L11:
        if (r13.nextInt() == 1) goto L12;
        r4 = false;
        goto L4
    L12:
        r4 = true;
        goto L4
    L14:
        r1 = JsonUtils.jsonToPoint(r13, 1.0f);
        goto L4
    L15:
        r0 = JsonUtils.jsonToPoint(r13, 1.0f);
        goto L4
    L16:
        r3 = r15.parse(r13, r14);
        goto L4
    L17:
        r5 = r15.parse(r13, r14);
        goto L4
    L18:
        r8 = (float) r13.nextDouble();
        goto L4
    L7:
        r13.skipValue();
        goto L4
    L19:
        r13.endObject();
        if (r4 == false) goto L22;
        Interpolator r7 = LINEAR_INTERPOLATOR;
        T r6 = r5;
    L27:
        Keyframe<T> r16 = new Keyframe(r12, r5, r6, r7, r8, null);
        r16.pathCp1 = r10;
        r16.pathCp2 = r11;
        return r16;
    L22:
        if (r0 == null) goto L25;
        if (r1 == null) goto L25;
        Interpolator r17 = interpolatorFor(r0, r1);
    L26:
        r7 = r17;
        r6 = r3;
    L25:
        r17 = LINEAR_INTERPOLATOR;
        goto L26
    }

    private static <T> Keyframe<T> parseMultiDimensionalKeyframe(LottieComposition r20, JsonReader r21, float r22, ValueParser<T> r23) throws IOException {
        r21.beginObject();
        PointF r3 = null;
        boolean r6 = false;
        PointF r7 = null;
        PointF r8 = null;
        PointF r9 = null;
        T r10 = null;
        PointF r11 = null;
        PointF r12 = null;
        PointF r13 = null;
        float r14 = 0.0f;
        PointF r15 = null;
        T r16 = null;
    L4:
        if (r21.hasNext() == false) goto L77;
        switch(r21.selectName(NAMES)) {
            case 0: goto L75;
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L44;
            case 4: goto L15;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r3 = JsonUtils.jsonToPoint(r21, r22);
        goto L4
    L9:
        r15 = JsonUtils.jsonToPoint(r21, r22);
        goto L4
    L11:
        if (r21.nextInt() == 1) goto L12;
        r6 = false;
        goto L4
    L12:
        r6 = true;
        goto L4
    L7:
        PointF r19 = r3;
        r21.skipValue();
    L76:
        r3 = r19;
        goto L4
    L15:
        if (r21.peek() != JsonReader.Token.BEGIN_OBJECT) goto L43;
        r21.beginObject();
        float r4 = 0.0f;
        float r5 = 0.0f;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L18:
        if (r21.hasNext() == false) goto L42;
        PointF r110 = r15;
        int r111 = r21.selectName(INTERPOLATOR_NAMES);
        if (r111 == 0) goto L33;
        PointF r112 = r3;
        if (r111 == 1) goto L26;
        r21.skipValue();
    L24:
        r15 = r110;
        r3 = r112;
        goto L18
    L26:
        if (r21.peek() != JsonReader.Token.NUMBER) goto L28;
        r18 = (float) r21.nextDouble();
        r14 = r14;
        r5 = r18;
        goto L24
    L28:
        float r24 = r14;
        r21.beginArray();
        r5 = (float) r21.nextDouble();
        if (r21.peek() != JsonReader.Token.NUMBER) goto L31;
        r18 = (float) r21.nextDouble();
    L32:
        r21.endArray();
    L41:
        r14 = r24;
        goto L24
    L31:
        r18 = r5;
        goto L32
    L33:
        r112 = r3;
        r24 = r14;
        if (r21.peek() != JsonReader.Token.NUMBER) goto L36;
        r17 = (float) r21.nextDouble();
        r14 = r24;
        r4 = r17;
        goto L24
    L36:
        r21.beginArray();
        r4 = (float) r21.nextDouble();
        if (r21.peek() != JsonReader.Token.NUMBER) goto L39;
        r17 = (float) r21.nextDouble();
    L40:
        r21.endArray();
        goto L41
    L39:
        r17 = r4;
        goto L40
    L42:
        r19 = r3;
        float r25 = r14;
        PointF r113 = new PointF(r4, r5);
        PointF r26 = new PointF(r17, r18);
        r21.endObject();
        r13 = r26;
        r12 = r113;
    L71:
        r14 = r25;
        goto L76
    L43:
        r19 = r3;
        r8 = JsonUtils.jsonToPoint(r21, r22);
        goto L76
    L44:
        r19 = r3;
        r25 = r14;
        PointF r114 = r15;
        if (r21.peek() != JsonReader.Token.BEGIN_OBJECT) goto L72;
        r21.beginObject();
        float r27 = 0.0f;
        float r28 = 0.0f;
        float r29 = 0.0f;
        float r115 = 0.0f;
    L48:
        if (r21.hasNext() == false) goto L70;
        int r116 = r21.selectName(INTERPOLATOR_NAMES);
        if (r116 != 0) goto L52;
        if (r21.peek() == JsonReader.Token.NUMBER) goto L64;
        r21.beginArray();
        r27 = (float) r21.nextDouble();
        if (r21.peek() != JsonReader.Token.NUMBER) goto L68;
        r29 = (float) r21.nextDouble();
    L69:
        r21.endArray();
        goto L48
    L68:
        r29 = r27;
        goto L69
    L64:
        r29 = (float) r21.nextDouble();
        r27 = r29;
        goto L48
    L52:
        if (r116 != 1) goto L53;
        if (r21.peek() == JsonReader.Token.NUMBER) goto L56;
        r21.beginArray();
        r28 = (float) r21.nextDouble();
        if (r21.peek() != JsonReader.Token.NUMBER) goto L60;
        r115 = (float) r21.nextDouble();
    L61:
        r21.endArray();
        goto L48
    L60:
        r115 = r28;
        goto L61
    L56:
        r115 = (float) r21.nextDouble();
        r28 = r115;
        goto L48
    L53:
        r21.skipValue();
        goto L48
    L70:
        PointF r117 = new PointF(r27, r28);
        PointF r30 = new PointF(r29, r115);
        r21.endObject();
        r11 = r30;
        r9 = r117;
        r15 = r114;
        goto L71
    L72:
        r7 = JsonUtils.jsonToPoint(r21, r22);
        r14 = r25;
        r15 = r114;
        goto L76
    L73:
        r19 = r3;
        r16 = r23.parse(r21, r22);
        goto L76
    L74:
        r19 = r3;
        r10 = r23.parse(r21, r22);
        goto L76
    L75:
        r19 = r3;
        r14 = (float) r21.nextDouble();
        goto L76
    L77:
        PointF r118 = r3;
        float r31 = r14;
        PointF r119 = r15;
        r21.endObject();
        if (r6 == false) goto L81;
        Interpolator r0 = LINEAR_INTERPOLATOR;
        T r120 = r10;
    L80:
        Interpolator r121 = null;
        Interpolator r122 = null;
    L91:
        if (r121 == null) goto L94;
        if (r122 == null) goto L94;
        Keyframe<T> r1 = new Keyframe(r20, r10, r120, r121, r122, r31, null);
    L95:
        r1.pathCp1 = r119;
        r1.pathCp2 = r118;
        return r1;
    L94:
        r1 = new Keyframe(r20, r10, r120, r0, r31, null);
        goto L95
    L81:
        if (r7 == null) goto L84;
        if (r8 == null) goto L84;
        r0 = interpolatorFor(r7, r8);
    L90:
        r120 = r16;
    L84:
        if (r9 == null) goto L89;
        if (r11 == null) goto L89;
        if (r12 == null) goto L89;
        if (r13 == null) goto L89;
        r121 = interpolatorFor(r9, r12);
        r122 = interpolatorFor(r11, r13);
        r120 = r16;
        r0 = null;
    L89:
        r0 = LINEAR_INTERPOLATOR;
        goto L90
    }

    private static Interpolator interpolatorFor(PointF r6, PointF r7) {
        r6.x = MiscUtils.clamp(r6.x, -1.0f, 1.0f);
        r6.y = MiscUtils.clamp(r6.y, -100.0f, MAX_CP_VALUE);
        r7.x = MiscUtils.clamp(r7.x, -1.0f, 1.0f);
        r7.y = MiscUtils.clamp(r7.y, -100.0f, MAX_CP_VALUE);
        int r0 = Utils.hashFor(r6.x, r6.y, r7.x, r7.y);
        Interpolator r3 = null;
        if (L.getDisablePathInterpolatorCache() == false) goto L5;
        WeakReference<Interpolator> r1 = null;
    L6:
        if (r1 == null) goto L8;
        r3 = r1.get();
    L8:
        if (r1 == null) goto L24;
        if (r3 == null) goto L24;
    L20:
        return r3;
    L24:
        Interpolator r8 = PathInterpolatorCompat.create(r6.x, r6.y, r7.x, r7.y);     // Catch: IllegalArgumentException -> L12
    L17:
        r3 = r8;
        if (L.getDisablePathInterpolatorCache() == true) goto L20;
        putInterpolator(r0, new WeakReference(r3));     // Catch: ArrayIndexOutOfBoundsException -> L21
    L12:
        e = move-exception;
        if ("The Path cannot loop back on itself.".equals(e.getMessage()) == false) goto L16;
        r8 = PathInterpolatorCompat.create(Math.min(r6.x, 1.0f), r6.y, Math.max(r7.x, 0.0f), r7.y);
        goto L17
    L16:
        r8 = new LinearInterpolator();
        goto L17
    L5:
        r1 = getInterpolator(r0);
        goto L6
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader r0, float r1, ValueParser<T> r2) throws IOException {
        return new Keyframe(r2.parse(r0, r1));
    }
}
