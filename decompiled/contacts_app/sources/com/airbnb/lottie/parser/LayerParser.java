package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.obric.oui.calendar.format.DayFormatter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class LayerParser {
    private static final JsonReader.Options EFFECTS_NAMES = null;
    private static final JsonReader.Options NAMES = null;
    private static final JsonReader.Options TEXT_NAMES = null;

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = null;

        static {
            int[] r0 = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = r0;
            r0[Layer.MatteType.LUMA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private LayerParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd"});
        TEXT_NAMES = JsonReader.Options.of(new String[]{DayFormatter.DEFAULT_FORMAT, "a"});
        EFFECTS_NAMES = JsonReader.Options.of(new String[]{"ty", "nm"});
    }

    public static Layer parse(LottieComposition r28) {
        Rect r18 = r28.getBounds();
        return new Layer(Collections.emptyList(), r28, "__container", -1, Layer.LayerType.PRE_COMP, -1, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, r18.width(), r18.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer parse(JsonReader r40, LottieComposition r41) throws IOException {
        Layer.MatteType r1 = Layer.MatteType.NONE;
        ArrayList r10 = new ArrayList();
        ArrayList r8 = new ArrayList();
        r40.beginObject();
        Float r11 = Float.valueOf(0.0f);
        Float r15 = Float.valueOf(1.0f);
        Layer.MatteType r32 = r1;
        Layer.LayerType r18 = null;
        String r21 = null;
        AnimatableTransform r22 = null;
        AnimatableTextFrame r30 = null;
        AnimatableTextProperties r31 = null;
        AnimatableFloatValue r33 = null;
        BlurEffect r35 = null;
        DropShadowEffect r36 = null;
        long r16 = 0;
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
        boolean r34 = false;
        float r27 = 0.0f;
        float r28 = 0.0f;
        float r29 = 0.0f;
        float r37 = 0.0f;
        long r19 = -1;
        float r26 = 1.0f;
        String r12 = "UNSET";
        String r13 = null;
        float r14 = 0.0f;
    L4:
        if (r40.hasNext() == false) goto L87;
        switch(r40.selectName(NAMES)) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L80;
            case 4: goto L79;
            case 5: goto L78;
            case 6: goto L77;
            case 7: goto L76;
            case 8: goto L75;
            case 9: goto L64;
            case 10: goto L59;
            case 11: goto L52;
            case 12: goto L36;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            default: goto L7;
        };
    L8:
        r34 = r40.nextBoolean();
        goto L4
    L9:
        r13 = r40.nextString();
        goto L4
    L10:
        r33 = AnimatableValueParser.parseFloat(r40, r41, false);
        goto L4
    L11:
        r37 = (float) r40.nextDouble();
        goto L4
    L12:
        r14 = (float) r40.nextDouble();
        goto L4
    L13:
        r29 = (float) (r40.nextDouble() * ((double) Utils.dpScale()));
        goto L4
    L14:
        r28 = (float) (r40.nextDouble() * ((double) Utils.dpScale()));
        goto L4
    L15:
        r27 = (float) r40.nextDouble();
        goto L4
    L16:
        r26 = (float) r40.nextDouble();
        goto L4
    L17:
        r40.beginArray();
        ArrayList r2 = new ArrayList();
    L19:
        if (r40.hasNext() == false) goto L35;
        r40.beginObject();
    L22:
        if (r40.hasNext() == false) goto L34;
        int r3 = r40.selectName(EFFECTS_NAMES);
        if (r3 != 0) goto L25;
        int r4 = r40.nextInt();
        if (r4 == 29) goto L30;
        if (r4 != 25) goto L22;
        r36 = new DropShadowEffectParser().parse(r40, r41);
        goto L22
    L30:
        r35 = BlurEffectParser.parse(r40, r41);
        goto L22
    L25:
        if (r3 != 1) goto L26;
        r2.add(r40.nextString());
        goto L22
    L26:
        r40.skipName();
        r40.skipValue();
        goto L22
    L34:
        r40.endObject();
        goto L19
    L35:
        r40.endArray();
        r41.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + r2);
        goto L4
    L36:
        r40.beginObject();
    L38:
        if (r40.hasNext() == false) goto L51;
        int r5 = r40.selectName(TEXT_NAMES);
        if (r5 != 0) goto L41;
        r30 = AnimatableValueParser.parseDocumentData(r40, r41);
        goto L38
    L41:
        if (r5 != 1) goto L42;
        r40.beginArray();
        if (r40.hasNext() == false) goto L47;
        r31 = AnimatableTextPropertiesParser.parse(r40, r41);
    L47:
        if (r40.hasNext() == false) goto L49;
        r40.skipValue();
        goto L47
    L49:
        r40.endArray();
        goto L38
    L42:
        r40.skipName();
        r40.skipValue();
        goto L38
    L51:
        r40.endObject();
        goto L4
    L52:
        r40.beginArray();
    L54:
        if (r40.hasNext() == false) goto L58;
        ContentModel r6 = ContentModelParser.parse(r40, r41);
        if (r6 == null) goto L54;
        r8.add(r6);
        goto L54
    L58:
        r40.endArray();
        goto L4
    L59:
        r40.beginArray();
    L61:
        if (r40.hasNext() == false) goto L63;
        r10.add(MaskParser.parse(r40, r41));
        goto L61
    L63:
        r41.incrementMatteOrMaskCount(r10.size());
        r40.endArray();
        goto L4
    L64:
        int r7 = r40.nextInt();
        if (r7 >= Layer.MatteType.values().length) goto L66;
        r32 = Layer.MatteType.values()[r7];
        int r9 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[r32.ordinal()];
        if (r9 != 1) goto L70;
        r41.addWarning("Unsupported matte type: Luma");
    L74:
        r41.incrementMatteOrMaskCount(1);
        goto L4
    L70:
        if (r9 != 2) goto L74;
        r41.addWarning("Unsupported matte type: Luma Inverted");
        goto L74
    L66:
        r41.addWarning("Unsupported matte type: " + r7);
        goto L4
    L75:
        r22 = AnimatableTransformParser.parse(r40, r41);
        goto L4
    L76:
        r25 = Color.parseColor(r40.nextString());
        goto L4
    L77:
        r24 = (int) (r40.nextInt() * Utils.dpScale());
        goto L4
    L78:
        r23 = (int) (r40.nextInt() * Utils.dpScale());
        goto L4
    L79:
        r19 = r40.nextInt();
        goto L4
    L80:
        int r17 = r40.nextInt();
        if (r17 < Layer.LayerType.UNKNOWN.ordinal()) goto L82;
        r18 = Layer.LayerType.UNKNOWN;
        goto L4
    L82:
        r18 = Layer.LayerType.values()[r17];
        goto L4
    L84:
        r21 = r40.nextString();
        goto L4
    L85:
        r16 = r40.nextInt();
        goto L4
    L86:
        r12 = r40.nextString();
        goto L4
    L7:
        r40.skipName();
        r40.skipValue();
        goto L4
    L87:
        r40.endObject();
        ArrayList r20 = new ArrayList();
        if (r14 <= 0.0f) goto L90;
        ArrayList r110 = r20;
        r110.add(new Keyframe(r41, r11, r11, null, 0.0f, Float.valueOf(r14)));
        float r0 = 0.0f;
    L92:
        if (r37 > r0) goto L95;
        r37 = r41.getEndFrame();
    L95:
        r110.add(new Keyframe(r41, r15, r15, null, r14, Float.valueOf(r37)));
        r110.add(new Keyframe(r41, r11, r11, null, r37, Float.valueOf(Float.MAX_VALUE)));
        if (r12.endsWith(".ai") == false) goto L98;
    L99:
        r41.addWarning("Convert your Illustrator layers to shape layers.");
    L101:
        return new Layer(r8, r41, r12, r16, r18, r19, r21, r10, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r110, r32, r33, r34, r35, r36);
    L98:
        if ("ai".equals(r13) == false) goto L101;
    L90:
        r110 = r20;
        r0 = 0.0f;
        goto L92
    }
}
