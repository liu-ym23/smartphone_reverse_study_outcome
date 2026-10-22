package com.bytedance.android.ec.hybrid.delivery;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    static {
    }

    public static Uri a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        String r100 = r110.getHost();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Map r101 = (Map) ECHybridSettings.f46247c.getValue();
        if (r101.isEmpty() == false) goto L69;
        return r110;
    L69:
        Iterator r102 = r101.entrySet().iterator();     // Catch: Exception -> L68
        Uri r103 = r110;
    L71:
        if (r102.hasNext() == false) goto L65;
        Map.Entry r104 = (Map.Entry) r102.next();     // Catch: Exception -> L66
        String r105 = (String) r104.getKey();     // Catch: Exception -> L66
        Object r106 = r104.getValue();     // Catch: Exception -> L66
        if (Intrinsics.areEqual(r105, r100) == false) goto L71;
        if ((r106 instanceof List) == true) goto L17;
        r106 = null;
    L17:
        List r107 = (List) r106;     // Catch: Exception -> L66
        if (r107 == null) goto L71;
        Iterator r108 = r107.iterator();     // Catch: Exception -> L66
    L21:
        if (r108.hasNext() == false) goto L71;
        Map r109 = (Map) r108.next();     // Catch: Exception -> L66
        Object r111 = r109.get(PlayerResolution.SDKKEY.ORIGIN);     // Catch: Exception -> L66
        if ((r111 instanceof String) == true) goto L25;
        r111 = null;
    L25:
        String r112 = (String) r111;     // Catch: Exception -> L66
        Object r113 = r109.get(PickerReporterConstants.KEY.TARGET);     // Catch: Exception -> L66
        if ((r113 instanceof String) == true) goto L28;
        r113 = null;
    L28:
        String r114 = (String) r113;     // Catch: Exception -> L66
        Object r115 = r109.get("transform_rule");     // Catch: Exception -> L66
        if ((r115 instanceof String) == true) goto L31;
        r115 = null;
    L31:
        String r116 = (String) r115;     // Catch: Exception -> L66
        Object r117 = r109.get("disable_force_replace");     // Catch: Exception -> L66
        if ((r117 instanceof Boolean) == true) goto L34;
        r117 = null;
    L34:
        Boolean r118 = (Boolean) r117;     // Catch: Exception -> L66
        boolean r119 = false;
        if (r118 == null) goto L37;
        boolean r120 = r118.booleanValue();     // Catch: Exception -> L66
    L39:
        if (r112 != null) goto L41;
    L44:
        boolean r121 = true;
    L45:
        if (r121 == true) goto L21;
        if (r114 != null) goto L48;
    L49:
        r119 = true;
    L50:
        if (r119 == true) goto L21;
        if (r116 == null) goto L60;
        if (r116.hashCode() != 1948205991) goto L60;
        if (r116.equals("mall_transparent") == false) goto L60;
        r103 = b(r103, r112, r114, !r120);     // Catch: Exception -> L66
    L60:
        String r122 = UriProtector.getQueryParameter(r110, r112);     // Catch: Exception -> L66
        if (r122 == null) goto L21;
        r103 = w36.a.b(r110, r112).buildUpon().appendQueryParameter(r114, r122).build();     // Catch: Exception -> L66
        goto L21
    L48:
        if (StringsKt.isBlank(r114) == false) goto L50;
    L41:
        if (StringsKt.isBlank(r112) == true) goto L44;
        r121 = false;
        goto L45
    L37:
        r120 = false;
        goto L39
    L65:
        return r103;
    L67:
        return r103;
    L95:
        return r110;
    }

    public static Uri b(Uri r110, String r111, String r112, boolean r113) {
        if (r112 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return r110;
    L11:
        String r101 = UriProtector.getQueryParameter(r110, r111);
        if (r101 != null) goto L14;
        return r110;
    L14:
        List r114 = StringsKt.split$default(r112, new String[]{"."}, false, 0, 6, null);
        if (r114.size() <= 2) goto L17;
        return r110;
    L17:
        if (r114.isEmpty() == true) goto L56;
        String r102 = "";
        if (r114.size() != 1) goto L32;
        String r103 = (String) CollectionsKt.getOrNull(r114, 0);
        if (r103 != null) goto L24;
        r103 = "";
    L24:
        String r104 = UriProtector.getQueryParameter(r110, r103);
        int r105 = MallTransparentTransformer.f46838a;
        String r115 = MallTransparentTransformer.a(r104, MapsKt.mapOf(TuplesKt.to(r111, r101)), r113);
        String[] r106 = new String[2];
        r106[0] = r111;
        String r116 = (String) CollectionsKt.getOrNull(r114, 0);
        if (r116 != null) goto L27;
        r116 = "";
    L27:
        r106[1] = r116;
        Uri.Builder r117 = w36.a.c(r110, CollectionsKt.listOf(r106)).buildUpon();
        String r118 = (String) CollectionsKt.getOrNull(r114, 0);
        if (r118 == null) goto L55;
        r102 = r118;
    L55:
        return r117.appendQueryParameter(r102, r115).build();
    L32:
        String r107 = (String) CollectionsKt.getOrNull(r114, 0);
        if (r107 != null) goto L35;
        r107 = "";
    L35:
        String r119 = (String) CollectionsKt.getOrNull(r114, 1);
        if (r119 == null) goto L39;
        r102 = r119;
    L39:
        String r120 = UriProtector.getQueryParameter(r110, r107);
        if (r120 != null) goto L53;
    L45:
        boolean r108 = true;
    L46:
        if (r108 == false) goto L49;
        JSONObject r121 = new JSONObject();     // Catch: Exception -> L50
    L51:
        String r109 = r121.optString(r102);
        int r122 = MallTransparentTransformer.f46838a;
        r121.put(r102, MallTransparentTransformer.a(r109, MapsKt.mapOf(TuplesKt.to(r111, r101)), r113));
        return w36.a.c(r110, CollectionsKt.listOf(new String[]{r111, r107})).buildUpon().appendQueryParameter(r107, r121.toString()).build();
    L49:
        r121 = new JSONObject(r120);     // Catch: Exception -> L50
        goto L51
    L53:
    L50:
        r121 = new JSONObject();
        goto L51
    L42:
        if (StringsKt.isBlank(r120) == true) goto L45;
        r108 = false;
        goto L46
    L56:
        return r110;
    L5:
        if (StringsKt.isBlank(r112) == true) goto L8;
        r100 = false;
        goto L9
    }
}
