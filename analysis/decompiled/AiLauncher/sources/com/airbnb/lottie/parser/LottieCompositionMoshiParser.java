package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.j;
import androidx.collection.u;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LottieCompositionMoshiParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "ip", "op", Const.SP_KEY_FIRSTLOC_RELOC, "v", "layers", "assets", "fonts", "chars", "markers");
    static JsonReader.Options ASSETS_NAMES = JsonReader.Options.of("id", "layers", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "p", "u");
    private static final JsonReader.Options FONT_NAMES = JsonReader.Options.of("list");
    private static final JsonReader.Options MARKER_NAMES = JsonReader.Options.of("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0044. Please report as an issue. */
    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        float f10;
        JsonReader jsonReader2 = jsonReader;
        float fDpScale = Utils.dpScale();
        j<Layer> jVar = new j<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        u<FontCharacter> uVar = new u<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader2.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextDouble = 0;
        int iNextDouble2 = 0;
        while (jsonReader2.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    f10 = fDpScale;
                    iNextDouble2 = (int) jsonReader.nextDouble();
                    jsonReader2 = jsonReader;
                    fDpScale = f10;
                    break;
                case 1:
                    f10 = fDpScale;
                    iNextDouble = (int) jsonReader.nextDouble();
                    jsonReader2 = jsonReader;
                    fDpScale = f10;
                    break;
                case 2:
                    f10 = fDpScale;
                    fNextDouble = (float) jsonReader.nextDouble();
                    jsonReader2 = jsonReader;
                    fDpScale = f10;
                    break;
                case 3:
                    f10 = fDpScale;
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    jsonReader2 = jsonReader;
                    fDpScale = f10;
                    break;
                case 4:
                    f10 = fDpScale;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    jsonReader2 = jsonReader;
                    fDpScale = f10;
                    break;
                case 5:
                    String[] strArrSplit = jsonReader2.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    jsonReader2 = jsonReader;
                    break;
                case 6:
                    parseLayers(jsonReader2, lottieComposition, arrayList, jVar);
                    jsonReader2 = jsonReader;
                    break;
                case 7:
                    parseAssets(jsonReader2, lottieComposition, map, map2);
                    jsonReader2 = jsonReader;
                    break;
                case 8:
                    parseFonts(jsonReader2, map3);
                    jsonReader2 = jsonReader;
                    break;
                case 9:
                    parseChars(jsonReader2, lottieComposition, uVar);
                    jsonReader2 = jsonReader;
                    break;
                case 10:
                    parseMarkers(jsonReader2, arrayList2);
                    jsonReader2 = jsonReader;
                    break;
                default:
                    jsonReader2.skipName();
                    jsonReader2.skipValue();
                    jsonReader2 = jsonReader;
                    break;
            }
        }
        float f11 = fDpScale;
        lottieComposition.init(new Rect(0, 0, (int) (iNextDouble2 * f11), (int) (iNextDouble * f11)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, jVar, map, map2, Utils.dpScale(), uVar, map3, arrayList2, iNextDouble2, iNextDouble);
        return lottieComposition;
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            j jVar = new j();
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            while (jsonReader.hasNext()) {
                int iSelectName = jsonReader.selectName(ASSETS_NAMES);
                if (iSelectName == 0) {
                    strNextString = jsonReader.nextString();
                } else if (iSelectName == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer layer = LayerParser.parse(jsonReader, lottieComposition);
                        jVar.n(layer.getId(), layer);
                        arrayList.add(layer);
                    }
                    jsonReader.endArray();
                } else if (iSelectName == 2) {
                    iNextInt = jsonReader.nextInt();
                } else if (iSelectName == 3) {
                    iNextInt2 = jsonReader.nextInt();
                } else if (iSelectName == 4) {
                    strNextString2 = jsonReader.nextString();
                } else if (iSelectName != 5) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    strNextString3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, u<FontCharacter> uVar) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter fontCharacter = FontCharacterParser.parse(jsonReader, lottieComposition);
            uVar.j(fontCharacter.hashCode(), fontCharacter);
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(FONT_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font font = FontParser.parse(jsonReader);
                    map.put(font.getName(), font);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, j<Layer> jVar) throws IOException {
        jsonReader.beginArray();
        int i10 = 0;
        while (jsonReader.hasNext()) {
            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
            if (layer.getLayerType() == Layer.LayerType.IMAGE) {
                i10++;
            }
            list.add(layer);
            jVar.n(layer.getId(), layer);
            if (i10 > 4) {
                Logger.warning("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void parseMarkers(JsonReader jsonReader, List<Marker> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                int iSelectName = jsonReader.selectName(MARKER_NAMES);
                if (iSelectName == 0) {
                    strNextString = jsonReader.nextString();
                } else if (iSelectName == 1) {
                    fNextDouble = (float) jsonReader.nextDouble();
                } else if (iSelectName != 2) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    fNextDouble2 = (float) jsonReader.nextDouble();
                }
            }
            jsonReader.endObject();
            list.add(new Marker(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
