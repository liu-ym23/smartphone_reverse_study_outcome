package com.autonavi.base.ae.gmap;

import com.alipay.sdk.m.n.a;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.framework.common.ContainerUtils;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.UByte;
import kotlin.text.Typography;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes39.dex */
final class TileRequestIdentifier {
    private static final Charset UTF_8 = null;

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    private TileRequestIdentifier() {
    }

    private static String interfaceName(String r100) {
        if (r100.contains("/bmd/tile") == false) goto L7;
        return "bmd_tile";
    L7:
        if (r100.contains("/ws/render/lnds/tile") == false) goto L11;
        return "lnds_tile";
    L11:
        if (r100.contains("/vmap") == false) goto L15;
        return "vmap";
    L15:
        if (r100.contains("/rtt") == false) goto L19;
        return "rtt";
    L19:
        if (r100.contains("/smap") == false) goto L22;
        return "smap";
    L22:
        return null;
    }

    private static long stableHash(String r100) {
        byte[] r101 = r100.getBytes(UTF_8);
        int r102 = r101.length;
        long r103 = 2166136261L;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103 = ((r103 ^ ((long) (r101[r104] & UByte.MAX_VALUE))) * 16777619) & BodyPartID.bodyIdMax;
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public static String create(String r100, Map<String, String> r101) {
        if (r100 != null) goto L5;
        return "non_tile";
    L5:
        String r102 = interfaceName(r100);
        if (r102 != null) goto L8;
        return "non_tile";
    L8:
        String r103 = queryValue(r101, r100, "tileId");
        if (r103.length() != 0) goto L17;
        String r104 = queryValue(r101, r100, "x");
        String r105 = queryValue(r101, r100, "y");
        String r106 = queryValue(r101, r100, MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z);
        if (r104.length() <= 0) goto L13;
    L16:
        r103 = r106 + "_" + r104 + "_" + r105;
        goto L17
    L13:
        if (r105.length() > 0) goto L16;
        if (r106.length() > 0) goto L16;
    L17:
        String r107 = queryValue(r101, r100, "tileType");
        if (r103.length() != 0) goto L20;
        r103 = "hash_" + stableHash(stableRequestIdentity(r100, r101));
    L20:
        String r108 = r102 + ":" + r103;
        if (r107.length() != 0) goto L24;
        return r108;
    L24:
        return r108 + ":" + r107;
    }

    private static String stableRequestIdentity(String r100, Map<String, String> r101) {
        StringBuilder r102 = new StringBuilder(r100);
        if (r101 == null) goto L9;
        Iterator r103 = new TreeMap(r101).entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.append(Typography.amp);
        r102.append((String) r104.getKey());
        r102.append(a.f25612h);
        r102.append((String) r104.getValue());
    L9:
        return r102.toString();
    }

    private static String queryValue(Map<String, String> r100, String r101, String r102) {
        if (r100 == null) goto L6;
        String r103 = r100.get(r102);
        if (r103 == null) goto L6;
        return r103;
    L6:
        String r104 = r102 + ContainerUtils.KEY_VALUE_DELIMITER;
        int r105 = r101.indexOf("?" + r104);
        if (r105 >= 0) goto L9;
        r105 = r101.indexOf("&" + r104);
    L9:
        if (r105 < 0) goto L11;
    L13:
        int r106 = 1;
    L14:
        if (r105 >= 0) goto L17;
        return "";
    L17:
        int r107 = (r105 + r106) + r104.length();
        int r108 = r101.indexOf(38, r107);
        if (r108 >= 0) goto L21;
        return r101.substring(r107);
    L21:
        return r101.substring(r107, r108);
    L11:
        if (r101.startsWith(r104) == false) goto L13;
        r105 = 0;
        r106 = 0;
        goto L14
    }
}
