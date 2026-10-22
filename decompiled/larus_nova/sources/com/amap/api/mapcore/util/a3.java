package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.autonavi.base.ae.gmap.style.StyleElement;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.mapcore.Convert;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.crypto.utils.CryptoConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class a3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f26853d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<w2> f26856c;

    static {
        f26853d = new int[]{1};
    }

    private List<w2> b() {
        String r100 = "name";
        String r101 = "subType";
        this.f26856c = new ArrayList();
        JSONArray r102 = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");     // Catch: JSONException -> L53
        if (r102.length() == 0) goto L6;
        JSONObject r110 = r102.optJSONObject(0);     // Catch: JSONException -> L53
        if (r110 == null) goto L10;
        JSONArray r111 = r110.names();     // Catch: JSONException -> L53
        int r112 = r111.length();     // Catch: JSONException -> L53
        int r113 = 0;
    L12:
        if (r113 >= r112) goto L56;
        String r114 = r111.optString(r113);     // Catch: JSONException -> L53
        JSONObject r103 = r110.optJSONObject(r114);     // Catch: JSONException -> L53
        if (r103 != null) goto L16;
    L15:
        String r210 = r100;
        String r211 = r101;
        JSONObject r115 = r110;
        JSONArray r116 = r111;
    L52:
        r113 = r113 + 1;
        r110 = r115;
        r111 = r116;
        r100 = r210;
        r101 = r211;
        goto L12
    L16:
        String r104 = r103.optString(r100);     // Catch: JSONException -> L53
        if (r103.has("styleMap") == false) goto L20;
        a(r103.optJSONArray("styleMap"), r114, null, r104, this.f26856c);     // Catch: JSONException -> L53
    L51:
        r210 = r100;
        r211 = r101;
        r115 = r110;
        r116 = r111;
        this.f26856c.add(new w2(20021, f26853d, "roads", "trafficRoadBackgroundColor", null));     // Catch: JSONException -> L53
        goto L52
    L20:
        if (r103.has(r101) == false) goto L51;
        JSONObject r105 = r103.optJSONObject(r101);     // Catch: JSONException -> L53
        if (r105 == null) goto L15;
        JSONArray r106 = r105.names();     // Catch: JSONException -> L53
        int r107 = r106.length();     // Catch: JSONException -> L53
        int r108 = 0;
    L25:
        if (r108 >= r107) goto L51;
        String r109 = r106.optString(r108);     // Catch: JSONException -> L53
        JSONObject r117 = r105.optJSONObject(r109);     // Catch: JSONException -> L53
        if (r117 != null) goto L29;
        String r212 = r100;
        String r118 = r104;
        String r213 = r101;
        JSONObject r119 = r110;
        JSONArray r120 = r111;
    L50:
        r108 = r108 + 1;     // Catch: JSONException -> L53
        r110 = r119;
        r111 = r120;
        r104 = r118;
        r107 = r107;
        r106 = r106;
        r105 = r105;
        r100 = r212;
        r101 = r213;
        goto L25
    L29:
        r119 = r110;
        String r121 = r117.optString(r100);     // Catch: JSONException -> L53
        r120 = r111;
        if (r117.has("styleMap") == false) goto L33;
        a(r117.optJSONArray("styleMap"), r114, r109, r104 + "-" + r121, this.f26856c);     // Catch: JSONException -> L53
        r212 = r100;
        r213 = r101;
        r118 = r104;
        goto L50
    L33:
        String r122 = r109;
        if (r117.has(r101) == false) goto L49;
        JSONObject r123 = r117.optJSONObject(r101);     // Catch: JSONException -> L53
        if (r123 == null) goto L49;
        JSONArray r124 = r123.names();     // Catch: JSONException -> L53
        int r125 = r124.length();     // Catch: JSONException -> L53
        int r126 = 0;
    L39:
        if (r126 >= r125) goto L49;
        String r127 = r124.optString(r126);     // Catch: JSONException -> L53
        JSONObject r128 = r123.optJSONObject(r127);     // Catch: JSONException -> L53
        if (r128 != null) goto L44;
        int r214 = r126;
    L43:
        String r129 = r122;
    L48:
        r126 = r214 + 1;     // Catch: JSONException -> L53
        r124 = r124;
        r104 = r104;
        r100 = r100;
        r125 = r125;
        r122 = r129;
        r101 = r101;
        goto L39
    L44:
        r214 = r126;
        String r130 = r128.optString(r100);     // Catch: JSONException -> L53
        if (r128.has("styleMap") == false) goto L43;
        JSONArray r131 = r128.optJSONArray("styleMap");     // Catch: JSONException -> L53
        r100 = r100;
        StringBuilder r132 = new StringBuilder();     // Catch: JSONException -> L53
        r129 = r122;
        r132.append(r129);     // Catch: JSONException -> L53
        r132.append("-");     // Catch: JSONException -> L53
        r132.append(r127);     // Catch: JSONException -> L53
        a(r131, r114, r132.toString(), r104 + "-" + r121 + "-" + r130, this.f26856c);     // Catch: JSONException -> L53
    L49:
        r212 = r100;
        r118 = r104;
        r213 = r101;
    L56:
        return this.f26856c;
    L10:
        return this.f26856c;
    L6:
        return this.f26856c;
    L53:
        e = move-exception;
        e.printStackTrace();
        goto L56
    }

    public a3() {
        this.f26854a = 0;
        this.f26855b = -1;
        this.f26856c = null;
    }

    public int a() {
        return this.f26854a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static x2 a(byte[] r110) {
        String r100 = null;
        x2 r101 = new x2();     // Catch: Throwable -> L16
        byte[] r102 = "l".getBytes(XML.CHARSET_UTF8);     // Catch: Throwable -> L14
        int r103 = r110.length;     // Catch: Throwable -> L14
        int r104 = r102.length;     // Catch: Throwable -> L14
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        byte r106 = r110[r105];     // Catch: Throwable -> L14
        r110[r105] = (byte) (r102[r105 % r104] ^ r106);     // Catch: Throwable -> L14
        r105 = r105 + 1;     // Catch: Throwable -> L14
        goto L5
    L7:
        Convert.getString(r110, 0, 4);     // Catch: Throwable -> L14
        Convert.getString(r110, 4, 32);     // Catch: Throwable -> L14
        Convert.getString(r110, 36, 10);     // Catch: Throwable -> L14
        byte[] r107 = Convert.getSubBytes(r110, 46, 16);     // Catch: Throwable -> L14
        byte[] r108 = Convert.getSubBytes(r110, 62, 16);     // Catch: Throwable -> L14
        byte[] r111 = Convert.getSubBytes(r110, 78, r103 - 78);     // Catch: Throwable -> L14
        IvParameterSpec r109 = new IvParameterSpec(r108);     // Catch: Throwable -> L10
        SecretKeySpec r112 = new SecretKeySpec(r107, CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L10
        Cipher r113 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Throwable -> L10
        r113.init(2, r112, r109);     // Catch: Throwable -> L10
        r100 = new String(r113.doFinal(r111), XML.CHARSET_UTF8);     // Catch: Throwable -> L10
    L12:
        r101.a(r100);     // Catch: Throwable -> L14
        return r101;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = th;
        r100 = r101;
    L17:
        th.printStackTrace();
        return r100;
    L16:
        th = th;
        goto L17
    }

    public void a(b3 r100) {
        if (this.f26855b == (-1)) goto L8;
        Map<Integer, StyleItem> r101 = r100.c();
        Iterator r102 = ((ArrayList) a("roads", "trafficRoadBackgroundColor")).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        w2 r103 = (w2) r102.next();
        StyleElement r104 = a(r101, r103.f28276d, y2.a("fillColor"), r103);
        r104.value = this.f26855b;
        StyleElement r105 = a(r101, r103.f28276d, y2.a("strokeColor"), r103);
        r105.value = this.f26855b;
        goto L6
    L10:
        return;
    }

    public static int a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return 0;
    L13:
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L6:
        if (r100.startsWith("#") == true) goto L8;
        r100 = "#".concat(r100);     // Catch: Throwable -> L10
    L8:
        return Color.parseColor(r100);
    }

    private boolean a(Map<Integer, StyleItem> r110, byte[] r111) {
        JSONArray r112 = new JSONArray(new String(r111, "UTF-8"));     // Catch: Throwable -> L61 JSONException -> L64
        int r100 = 0;
    L4:
        if (r100 >= r112.length()) goto L59;
        JSONObject r101 = r112.optJSONObject(r100);     // Catch: Throwable -> L61 JSONException -> L64
        String r102 = r101.optString("featureType");     // Catch: Throwable -> L61 JSONException -> L64
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L58:
        r100 = r100 + 1;
        goto L4
    L10:
        if ("background".equals(r102) == false) goto L18;
        JSONObject r103 = r101.optJSONObject("stylers");     // Catch: Throwable -> L61 JSONException -> L64
        if (r103 == null) goto L58;
        int r104 = a(r103.optString("color"));     // Catch: Throwable -> L61 JSONException -> L64
        if (r104 == 0) goto L58;
        this.f26854a = r104;     // Catch: Throwable -> L61 JSONException -> L64
        goto L58
    L18:
        if (TextUtils.isEmpty(r102) == true) goto L30;
        int r105 = 0;
    L21:
        String[] r106 = z2.f28553a;     // Catch: Throwable -> L61 JSONException -> L64
        if (r105 >= r106.length) goto L27;
        if (r106[r105].equals(r102) == true) goto L28;
        r105 = r105 + 1;     // Catch: Throwable -> L61 JSONException -> L64
    L28:
        if (r105 < 0) goto L30;
        String r107 = z2.f28555c[r105];     // Catch: Throwable -> L61 JSONException -> L64
    L31:
        if (r107 == null) goto L58;
        if (TextUtils.isEmpty(r102) == true) goto L46;
        int r108 = 0;
    L37:
        String[] r109 = z2.f28553a;     // Catch: Throwable -> L61 JSONException -> L64
        if (r108 >= r109.length) goto L43;
        if (r109[r108].equals(r102) == true) goto L44;
        r108 = r108 + 1;     // Catch: Throwable -> L61 JSONException -> L64
    L44:
        if (r108 < 0) goto L46;
        String[] r113 = z2.f28554b[r108];     // Catch: Throwable -> L61 JSONException -> L64
    L47:
        if (r113 == null) goto L58;
        if (r113.length == 0) goto L58;
        String r114 = r101.optString("elementType");     // Catch: Throwable -> L61 JSONException -> L64
        if (TextUtils.isEmpty(r114) == true) goto L58;
        int r115 = y2.a(r114);     // Catch: Throwable -> L61 JSONException -> L64
        if (r115 == (-1)) goto L58;
        a(r110, r101, r107, r113, r115);     // Catch: Throwable -> L61 JSONException -> L64
        goto L58
    L43:
        r108 = -1;
    L46:
        r113 = null;
        goto L47
    L27:
        r105 = -1;
    L30:
        r107 = null;
        goto L31
    L59:
        return true;
    L61:
        th = move-exception;
        th.printStackTrace();
    L63:
        return false;
    }

    private List<w2> a(String r100, String r101) {
        ArrayList r102 = new ArrayList();
        Iterator<w2> r103 = this.f26856c.iterator();
    L4:
        if (r103.hasNext() == false) goto L22;
        w2 r104 = r103.next();
        if (r104 == null) goto L4;
        String r105 = r104.f28277e;
        if (r105 == null) goto L13;
        if (r105.equals(r101) == false) goto L13;
        r102.add(r104);
    L13:
        String r106 = r104.f28277e;
        if (r106 == null) goto L4;
        if (r106.equals(r100) == false) goto L4;
        String r107 = r104.f28278f;
        if (r107 == null) goto L4;
        if (r107.contains(r101) == false) goto L4;
        r102.add(r104);
        goto L4
    L22:
        return r102;
    }

    public b3 a(byte[] r100, boolean r101) {
        b3 r102 = new b3();
    L8:
        th = move-exception;
        th.printStackTrace();
    L10:
        return r102;
    L4:
        if (a(r102.c(), r100) == true) goto L6;
        a(r102, r100, r101);     // Catch: Throwable -> L8
    L6:
        a(r102);     // Catch: Throwable -> L8
        r102.a();     // Catch: Throwable -> L8
        goto L10
    }

    private void a(b3 r210, byte[] r211, boolean r212) {
        x2 r100 = a(r211);
        if (r100 == null) goto L50;
        if (r100.a() == null) goto L50;
        JSONObject r101 = new JSONObject(r100.a());     // Catch: Throwable -> L46
        JSONArray r102 = r101.names();     // Catch: Throwable -> L46
        int r103 = 0;
    L7:
        if (r103 >= r102.length()) goto L50;
        String r104 = r102.getString(r103);     // Catch: Throwable -> L46
        if (r104 != null) goto L12;
    L14:
        if (r104 != null) goto L16;
    L20:
        JSONObject r110 = r101.optJSONObject(r104);     // Catch: Throwable -> L44
        if (r110 == null) goto L43;
        Map<Integer, StyleItem> r111 = r210.c();     // Catch: Throwable -> L44
        JSONObject r112 = r110.optJSONObject("subType");     // Catch: Throwable -> L44
        if (r112 != null) goto L25;
        a(r104, r104, r111, r110, r212);     // Catch: Throwable -> L44
        goto L43
    L25:
        JSONArray r113 = r112.names();     // Catch: Throwable -> L44
        int r114 = 0;
    L27:
        if (r114 >= r113.length()) goto L43;
        String r105 = r113.optString(r114);     // Catch: Throwable -> L44
        JSONObject r115 = r112.optJSONObject(r105);     // Catch: Throwable -> L44
        if (r115.has("detailedType") == false) goto L41;
        JSONObject r116 = r115.optJSONObject("detailedType");     // Catch: Throwable -> L44
        if (r116 != null) goto L33;
    L32:
        int r213 = r114;
        JSONArray r117 = r113;
    L42:
        r114 = r213 + 1;
        r113 = r117;
        goto L27
    L33:
        JSONArray r106 = r116.names();     // Catch: Throwable -> L44
        int r107 = 0;
    L35:
        if (r107 >= r106.length()) goto L32;
        String r108 = r106.optString(r107);     // Catch: Throwable -> L44
        JSONObject r118 = r116.optJSONObject(r108);     // Catch: Throwable -> L44
        if (r118 == null) goto L40;
        a(r104, r108, r111, r118, r212);     // Catch: Throwable -> L44
    L40:
        r107 = r107 + 1;     // Catch: Throwable -> L44
        r113 = r113;
        r116 = r116;
        r106 = r106;
        r114 = r114;
        goto L35
    L41:
        r213 = r114;
        r117 = r113;
        a(r104, r105, r111, r115, r212);     // Catch: Throwable -> L44
    L43:
        r103 = r103 + 1;
        goto L7
    L16:
        if (r104.trim().equals("background") == false) goto L20;
        this.f26854a = a("#" + r101.optString("background"));     // Catch: Throwable -> L44
    L44:
        th = th;
    L48:
        th.printStackTrace();
        return;
    L12:
        if (r104.trim().equals("sdkTextures") == false) goto L14;
    L46:
        th = th;
    }

    private StyleElement a(Map<Integer, StyleItem> r100, int r101, int r102, w2 r103) {
        StyleItem r104 = r100.get(Integer.valueOf(r101));
        if (r104 != null) goto L5;
        r104 = new StyleItem(r103.f28275c);
        r104.mainKey = r103.f28273a;
        r104.subKey = r103.f28274b;
        r100.put(Integer.valueOf(r101), r104);
    L5:
        StyleElement r105 = r104.get(r102);
        if (r105 != null) goto L9;
        StyleElement r106 = new StyleElement();
        r106.styleElementType = r102;
        r104.put(r102, r106);
        return r106;
    L9:
        return r105;
    }

    private void a(String r110, String r111, Map<Integer, StyleItem> r112, JSONObject r113, boolean r114) throws JSONException {
        if (r113 != null) goto L5;
        return;
    L5:
        if (this.f26856c != null) goto L7;
        this.f26856c = b();
    L7:
        ArrayList r115 = (ArrayList) a(r110, r111);
        Iterator r116 = r115.iterator();
    L9:
        if (r116.hasNext() == false) goto L35;
        w2 r100 = (w2) r116.next();
        if (r100 == null) goto L34;
        if (r100.f28275c == (-1000)) goto L53;
        int r101 = r100.f28276d;
        if (r113.optBoolean("visible", true) == false) goto L17;
        if (r113.optBoolean("showIcon", true) == true) goto L22;
        a(r112, r101, y2.a("textFillColor"), r100).textureId = -1;
    L22:
        if (r113.optBoolean("showLabel", true) == true) goto L24;
        a(r112, r101, y2.a("textFillColor"), r100).opacity = 0.0f;
        StyleElement r102 = a(r112, r101, y2.a("textStrokeColor"), r100);
        r102.opacity = 0.0f;
        r102.visible = 0;
        r102.textureId = -1;
    L24:
        a(r112, r113, "color", GXTemplateKey.STYLE_OPACITY, r101, r100);
        a(r112, r113, "fillColor", "fillOpacity", r101, r100);
        a(r112, r113, "strokeColor", "strokeOpacity", r101, r100);
        a(r112, r113, "textFillColor", "textFillOpacity", r101, r100);
        a(r112, r113, "textStrokeColor", "textStrokeOpacity", r101, r100);
        a(r112, r113, "backgroundColor", "backgroundOpacity", r101, r100);
        if (r114 == false) goto L9;
        int r103 = r113.optInt("textureName", 0);     // Catch: Throwable -> L32
        if (r103 == 0) goto L9;
        a(r112, r101, y2.a("textureName"), r100).textureId = r103;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L17:
        StyleElement r104 = a(r112, r101, y2.a("visible"), r100);
        r104.textureId = -1;
        r104.visible = 0;
        goto L9
    L53:
        return;
    L34:
        return;
    L35:
        r115.clear();
    }

    private void a(Map<Integer, StyleItem> r110, JSONObject r111, String r112, String[] r113, int r114) throws JSONException {
        int r100 = 0;
    L4:
        if (r100 >= r113.length) goto L29;
        String r101 = r113[r100];
        if (this.f26856c != null) goto L8;
        this.f26856c = b();
    L8:
        Iterator r102 = ((ArrayList) a(r112, r101)).iterator();
    L10:
        if (r102.hasNext() == false) goto L28;
        w2 r103 = (w2) r102.next();
        int r104 = r103.f28276d;
        StyleElement r105 = a(r110, r104, r114, r103);
        JSONObject r106 = r111.optJSONObject("stylers");
        if (r106 == null) goto L10;
        int r107 = a(r106.optString("color"));
        if (r107 == 0) goto L10;
        r105.value = r107;
        r105.textureId = r106.optInt("textureName", 0);
        r105.lineWidth = r106.optInt("lineWidth", 0);
        if (r104 < 30) goto L21;
        if (r104 > 38) goto L21;
        a(r110, r104, 4, r103).opacity = 0.1f;
    L21:
        String r108 = r103.f28277e;
        if (r108 == null) goto L10;
        if (r108.equals("water") == false) goto L10;
        if (r114 != 3) goto L10;
        a(r110, r104, 2, r103).value = r107;
        goto L10
    L28:
        r100 = r100 + 1;
        goto L4
    }

    private void a(JSONArray r110, String r111, String r112, String r113, List<w2> r114) {
        if (r110 != null) goto L5;
        return;
    L5:
        int r100 = r110.length();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L19;
        JSONObject r102 = r110.optJSONObject(r101);
        if (r102 == null) goto L18;
        int r103 = r102.optInt("mainkey");
        int[] r104 = new int[0];
        JSONArray r105 = r102.optJSONArray("subkey");
        if (r105 == null) goto L16;
        int r106 = r105.length();
        int[] r107 = new int[r106];
        int r108 = 0;
    L13:
        if (r108 >= r106) goto L15;
        r107[r108] = r105.optInt(r108);
        r108 = r108 + 1;
        goto L13
    L15:
        int[] r109 = r107;
    L17:
        r114.add(new w2(r103, r109, r111, r112, r113));
        goto L18
    L16:
        r109 = r104;
    L18:
        r101 = r101 + 1;
        goto L6
    }

    private void a(Map<Integer, StyleItem> r100, JSONObject r101, String r102, String r103, int r110, w2 r111) {
        String r104 = r101.optString(r102, null);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r104) == false) goto L6;
        float r105 = (float) r101.optDouble(r103, 1.0d);     // Catch: Throwable -> L24
        int r106 = 0;
    L7:
        if (r106 == 0) goto L9;
    L11:
        int r107 = y2.a(r102);     // Catch: Throwable -> L24
        StyleElement r108 = a(r100, r110, r107, r111);     // Catch: Throwable -> L24
        r108.value = r106;     // Catch: Throwable -> L24
        r108.opacity = r105;     // Catch: Throwable -> L24
        String r109 = r111.f28278f;     // Catch: Throwable -> L24
        if (r109 != null) goto L14;
    L16:
        String r112 = r111.f28277e;     // Catch: Throwable -> L24
        if (r112 != null) goto L19;
        return;
    L19:
        if (r112.equals("water") == true) goto L21;
        return;
    L21:
        if (r107 != 3) goto L31;
        StyleElement r113 = a(r100, r110, 2, r111);     // Catch: Throwable -> L24
        r113.value = r106;     // Catch: Throwable -> L24
        r113.opacity = r105;     // Catch: Throwable -> L24
        return;
    L31:
        return;
    L14:
        if (r109.equals("China") == false) goto L16;
        a(r100, r110, r107, r111).opacity = 0.0f;     // Catch: Throwable -> L24
        return;
    L9:
        if (r105 != 1.0d) goto L11;
        return;
    L6:
        r106 = a("#" + r104);     // Catch: Throwable -> L24
        r105 = 1.0f;
    L24:
        th = move-exception;
        th.printStackTrace();
    }
}
