package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DropShadowEffectParser {
    private static final JsonReader.Options DROP_SHADOW_EFFECT_NAMES = null;
    private static final JsonReader.Options INNER_EFFECT_NAMES = null;
    private AnimatableColorValue color;
    private AnimatableFloatValue direction;
    private AnimatableFloatValue distance;
    private AnimatableFloatValue opacity;
    private AnimatableFloatValue radius;

    public DropShadowEffectParser() {
    }

    static {
        DROP_SHADOW_EFFECT_NAMES = JsonReader.Options.of(new String[]{"ef"});
        INNER_EFFECT_NAMES = JsonReader.Options.of(new String[]{"nm", BaseSwitches.V});
    }

    DropShadowEffect parse(JsonReader r7, LottieComposition r8) throws IOException {
    L3:
        if (r7.hasNext() == false) goto L13;
        if (r7.selectName(DROP_SHADOW_EFFECT_NAMES) != 0) goto L6;
        r7.beginArray();
    L9:
        if (r7.hasNext() == false) goto L11;
        maybeParseInnerEffect(r7, r8);
        goto L9
    L11:
        r7.endArray();
        goto L3
    L6:
        r7.skipName();
        r7.skipValue();
        goto L3
    L13:
        if (this.color != null) goto L15;
        return null;
    L15:
        if (this.opacity != null) goto L17;
        return null;
    L17:
        if (this.direction != null) goto L19;
        return null;
    L19:
        if (this.distance != null) goto L21;
        return null;
    L21:
        if (this.radius != null) goto L23;
        return null;
    L23:
        return new DropShadowEffect(this.color, this.opacity, this.direction, this.distance, this.radius);
    }

    private void maybeParseInnerEffect(JsonReader r6, LottieComposition r7) throws IOException {
        r6.beginObject();
        String r0 = "";
    L4:
        if (r6.hasNext() == false) goto L40;
        int r1 = r6.selectName(INNER_EFFECT_NAMES);
        if (r1 != 0) goto L7;
        r0 = r6.nextString();
        goto L4
    L7:
        byte r2 = 1;
        if (r1 != 1) goto L9;
        r0.hashCode();
        switch(r0.hashCode()) {
            case 353103893: goto L29;
            case 397447147: goto L26;
            case 1041377119: goto L22;
            case 1379387491: goto L18;
            case 1383710113: goto L14;
            default: goto L12;
        };
    L12:
        r2 = -1;
    L32:
        switch(r2) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            default: goto L33;
        };
    L34:
        this.radius = AnimatableValueParser.parseFloat(r6, r7);
        goto L4
    L35:
        this.color = AnimatableValueParser.parseColor(r6, r7);
        goto L4
    L36:
        this.direction = AnimatableValueParser.parseFloat(r6, r7, false);
        goto L4
    L37:
        this.opacity = AnimatableValueParser.parseFloat(r6, r7, false);
        goto L4
    L38:
        this.distance = AnimatableValueParser.parseFloat(r6, r7);
        goto L4
    L33:
        r6.skipValue();
        goto L4
    L14:
        if (r0.equals("Softness") == false) goto L62;
        r2 = 4;
        goto L32
    L62:
        r2 = -1;
        goto L32
    L18:
        if (r0.equals("Shadow Color") == false) goto L63;
        r2 = 3;
        goto L32
    L63:
        r2 = -1;
        goto L32
    L22:
        if (r0.equals("Direction") == false) goto L64;
        r2 = 2;
        goto L32
    L64:
        r2 = -1;
        goto L32
    L26:
        if (r0.equals("Opacity") == true) goto L32;
        r2 = -1;
        goto L32
    L29:
        if (r0.equals("Distance") == false) goto L66;
        r2 = 0;
        goto L32
    L66:
        r2 = -1;
        goto L32
    L9:
        r6.skipName();
        r6.skipValue();
        goto L4
    L40:
        r6.endObject();
    }
}
