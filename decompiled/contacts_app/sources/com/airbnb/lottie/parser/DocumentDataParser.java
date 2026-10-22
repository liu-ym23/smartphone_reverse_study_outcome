package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = null;
    private static final JsonReader.Options NAMES = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ DocumentData parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new DocumentDataParser();
        NAMES = JsonReader.Options.of(new String[]{"t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz"});
    }

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public DocumentData parse(JsonReader r20, float r21) throws IOException {
        DocumentData.Justification r0 = DocumentData.Justification.CENTER;
        r20.beginObject();
        DocumentData.Justification r9 = r0;
        String r6 = null;
        String r7 = null;
        PointF r17 = null;
        PointF r18 = null;
        float r8 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
        float r15 = 0.0f;
        int r10 = 0;
        int r13 = 0;
        int r14 = 0;
        boolean r16 = true;
    L4:
        if (r20.hasNext() == false) goto L26;
        switch(r20.selectName(NAMES)) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        r20.beginArray();
        PointF r1 = new PointF(((float) r20.nextDouble()) * r21, ((float) r20.nextDouble()) * r21);
        r20.endArray();
        r18 = r1;
        goto L4
    L9:
        r20.beginArray();
        PointF r2 = new PointF(((float) r20.nextDouble()) * r21, ((float) r20.nextDouble()) * r21);
        r20.endArray();
        r17 = r2;
        goto L4
    L10:
        r16 = r20.nextBoolean();
        goto L4
    L11:
        r15 = (float) r20.nextDouble();
        goto L4
    L12:
        r14 = JsonUtils.jsonToColor(r20);
        goto L4
    L13:
        r13 = JsonUtils.jsonToColor(r20);
        goto L4
    L14:
        r12 = (float) r20.nextDouble();
        goto L4
    L15:
        r11 = (float) r20.nextDouble();
        goto L4
    L16:
        r10 = r20.nextInt();
        goto L4
    L17:
        int r3 = r20.nextInt();
        if (r3 > DocumentData.Justification.CENTER.ordinal()) goto L22;
        if (r3 < 0) goto L22;
        r9 = DocumentData.Justification.values()[r3];
    L22:
        r9 = DocumentData.Justification.CENTER;
        goto L4
    L23:
        r8 = (float) r20.nextDouble();
        goto L4
    L24:
        r7 = r20.nextString();
        goto L4
    L25:
        r6 = r20.nextString();
        goto L4
    L7:
        r20.skipName();
        r20.skipValue();
        goto L4
    L26:
        r20.endObject();
        return new DocumentData(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
