package com.bytedance.android.ec.hybrid.delivery;

import com.alipay.sdk.m.u.i;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.ECHybridLogUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yj.k;

/* JADX INFO: loaded from: classes44.dex */
public final class MallTransparentTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46838a = 0;

    static {
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        return StringsKt.startsWith$default(r100, "mall_transparent;", false, 2, null);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static Map c(String r100) {
        if (b(r100) == true) goto L7;
        return MapsKt.emptyMap();
    L7:
        if (r100 == null) goto L12;
        String r101 = StringsKt.substringAfter$default(r100, "mall_transparent;", null, 2, null);
        if (r101 == null) goto L12;
        List r102 = StringsKt.split$default(r101, new String[]{i.f25853b}, false, 0, 6, null);
        if (r102 == null) goto L12;
    L13:
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L30;
        List r105 = StringsKt.split$default((String) r104.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
        if (r105.size() != 2) goto L15;
        String r106 = (String) CollectionsKt.getOrNull(r105, 0);
        String r107 = "";
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        String r108 = (String) CollectionsKt.getOrNull(r105, 1);
        if (r108 == null) goto L26;
        r107 = r108;
    L26:
        if ((!StringsKt.isBlank(r106)) == false) goto L15;
        if ((!StringsKt.isBlank(r107)) == false) goto L15;
        r103.put(r106, r107);
        goto L15
    L30:
        return r103;
    L12:
        r102 = CollectionsKt.emptyList();
        goto L13
    }

    public static String a(String r110, Map r111, boolean r112) {
        if (r111 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return r110;
    L12:
        if (r110 != null) goto L14;
    L18:
        r110 = "mall_transparent;";
    L20:
        if (b(r110) == true) goto L35;
        if (r112 == false) goto L34;
        IHybridHostService r113 = com.bytedance.android.ec.hybrid.a.h();
        if (r113 == null) goto L33;
        k r114 = r113.getIHybridHostEventService();
        if (r114 == null) goto L33;
        JSONObject r101 = new JSONObject();
        if (r111 == null) goto L32;
        Iterator r102 = r111.entrySet().iterator();
    L30:
        if (r102.hasNext() == false) goto L32;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.putOpt((String) r103.getKey(), r103.getValue());
    L32:
        r101.putOpt("type", "unknown_source_query");
        r101.putOpt("source_query", r110);
        Unit r104 = Unit.INSTANCE;
        r114.logV3("mall_session_params_transformer_warning", r101);
    L33:
        Lazy r115 = ECHybridLogUtil.f47525a;
        ECHybridLogUtil.a("MallTransparentTransformer", "mall_session_params_transformer_warning, unknown source query, sourceQueryString = " + r110 + ", params = " + r111);
        goto L35
    L34:
        return r110;
    L35:
        LinkedHashMap r116 = new LinkedHashMap();
        r116.putAll(c(r110));
        r116.putAll(r111);
        LinkedHashMap r117 = new LinkedHashMap();
        Iterator r118 = r116.entrySet().iterator();
    L37:
        if (r118.hasNext() == false) goto L47;
        Map.Entry r119 = (Map.Entry) r118.next();
        if ((!StringsKt.isBlank((CharSequence) r119.getKey())) == true) goto L41;
    L43:
        boolean r105 = false;
    L44:
        if (r105 == false) goto L37;
        r117.put(r119.getKey(), r119.getValue());
        goto L37
    L41:
        if ((!StringsKt.isBlank((CharSequence) r119.getValue())) == false) goto L43;
        r105 = true;
        goto L44
    L47:
        return ((StringBuilder) CollectionsKt.joinTo$default(MapsKt.toList(r117), new StringBuilder("mall_transparent;"), i.f25853b, null, null, 0, null, MallTransparentTransformer$create$2.INSTANCE, 60, null)).toString();
    L14:
        if ((!StringsKt.isBlank(r110)) == true) goto L17;
        r110 = null;
    L17:
        if (r110 != null) goto L20;
    L5:
        if (r111.isEmpty() == true) goto L8;
        r100 = false;
        goto L9
    }
}
