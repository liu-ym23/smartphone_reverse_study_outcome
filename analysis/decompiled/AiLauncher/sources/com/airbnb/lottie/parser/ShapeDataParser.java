package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("c", "v", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "o");

    private ShapeDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public ShapeData parse(JsonReader jsonReader, float f10) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listJsonToPoints = null;
        List<PointF> listJsonToPoints2 = null;
        List<PointF> listJsonToPoints3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (iSelectName == 1) {
                listJsonToPoints = JsonUtils.jsonToPoints(jsonReader, f10);
            } else if (iSelectName == 2) {
                listJsonToPoints2 = JsonUtils.jsonToPoints(jsonReader, f10);
            } else if (iSelectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                listJsonToPoints3 = JsonUtils.jsonToPoints(jsonReader, f10);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (listJsonToPoints == null || listJsonToPoints2 == null || listJsonToPoints3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listJsonToPoints.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = listJsonToPoints.size();
        PointF pointF = listJsonToPoints.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 1; i10 < size; i10++) {
            PointF pointF2 = listJsonToPoints.get(i10);
            int i11 = i10 - 1;
            arrayList.add(new CubicCurveData(MiscUtils.addPoints(listJsonToPoints.get(i11), listJsonToPoints3.get(i11)), MiscUtils.addPoints(pointF2, listJsonToPoints2.get(i10)), pointF2));
        }
        if (zNextBoolean) {
            PointF pointF3 = listJsonToPoints.get(0);
            int i12 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.addPoints(listJsonToPoints.get(i12), listJsonToPoints3.get(i12)), MiscUtils.addPoints(pointF3, listJsonToPoints2.get(0)), pointF3));
        }
        return new ShapeData(pointF, zNextBoolean, arrayList);
    }
}
