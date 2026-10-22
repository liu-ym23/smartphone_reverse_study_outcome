package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.bytedance.apm.constant.PerfConsts;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class FontCharacterParser {
    private static final JsonReader.Options DATA_NAMES = null;
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"ch", PerfConsts.PERF_DISK_FILE_SIZE, "w", "style", "fFamily", "data"});
        DATA_NAMES = JsonReader.Options.of(new String[]{"shapes"});
    }

    private FontCharacterParser() {
    }

    static FontCharacter parse(JsonReader r11, LottieComposition r12) throws IOException {
        ArrayList r1 = new ArrayList();
        r11.beginObject();
        double r5 = 0.0d;
        String r7 = null;
        String r8 = null;
        char r2 = 0;
        double r3 = 0.0d;
    L4:
        if (r11.hasNext() == false) goto L35;
        int r9 = r11.selectName(NAMES);
        if (r9 != 0) goto L8;
        r2 = r11.nextString().charAt(0);
        goto L4
    L8:
        if (r9 != 1) goto L10;
        r3 = r11.nextDouble();
        goto L4
    L10:
        if (r9 != 2) goto L12;
        r5 = r11.nextDouble();
        goto L4
    L12:
        if (r9 != 3) goto L14;
        r7 = r11.nextString();
        goto L4
    L14:
        if (r9 != 4) goto L16;
        r8 = r11.nextString();
        goto L4
    L16:
        if (r9 != 5) goto L17;
        r11.beginObject();
    L20:
        if (r11.hasNext() == false) goto L29;
        if (r11.selectName(DATA_NAMES) != 0) goto L23;
        r11.beginArray();
    L26:
        if (r11.hasNext() == false) goto L28;
        r1.add((ShapeGroup) ContentModelParser.parse(r11, r12));
        goto L26
    L28:
        r11.endArray();
        goto L20
    L23:
        r11.skipName();
        r11.skipValue();
        goto L20
    L29:
        r11.endObject();
        goto L4
    L17:
        r11.skipName();
        r11.skipValue();
        goto L4
    L35:
        r11.endObject();
        return new FontCharacter(r1, r2, r3, r5, r7, r8);
    }
}
