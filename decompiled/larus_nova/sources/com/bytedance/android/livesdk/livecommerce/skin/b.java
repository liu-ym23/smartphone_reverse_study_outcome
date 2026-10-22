package com.bytedance.android.livesdk.livecommerce.skin;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTabUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.tab.ECLiveSkinTabEnhanceElement;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b {
    public b() {
    }

    public static ECLiveSkinBaseViewUIConfig a(int r100, boolean r101, boolean r110) {
        ECLiveSkinUtil.f152968l.getClass();
        if (ECLiveSkinUtil.f152966j != null) goto L37;
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = (String) ECLiveSkinUtil.f152965i.getValue();
        boolean r104 = true;
        if (r103.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r103 = null;
    L11:
        if (r103 != null) goto L14;
        r103 = "{\"1\":{\"style\":{\"unselected\":{\"text\":{\"color\":[\"#FF7075\",\"#FF3344\"],\"font_size\":13,\"font_weight\":600}}}}}";
    L14:
        if (r103.length() > 0) goto L17;
        r104 = false;
    L17:
        if (r104 == true) goto L20;
        r103 = null;
    L20:
        if (r103 == null) goto L37;
        JSONObject r106 = ECLiveSkinUtil.a(r103, "normal");
        if (r106 == null) goto L36;
        Iterator<String> r107 = r106.keys();
    L25:
        if (r107.hasNext() == false) goto L36;
        String r108 = r107.next();
        JSONObject r109 = r106.optJSONObject(r108);
        if (r109 == null) goto L25;
        String r111 = r109.toString();
        if (r111 == null) goto L25;
        int r112 = m0.f153098a;     // Catch: Exception -> L34
        ECLiveSkinTabEnhanceElement r113 = (ECLiveSkinTabEnhanceElement) m0.a.f153099a.fromJson(r111, ECLiveSkinTabEnhanceElement.class);     // Catch: Exception -> L34
        if (r113 == null) goto L25;
        r102.put(r108, r113);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L36:
        ECLiveSkinUtil.f152966j = r102;
        goto L37
    L7:
        r105 = false;
    L37:
        Map<String, ECLiveSkinTabEnhanceElement> r114 = ECLiveSkinUtil.f152966j;
        if (r114 == null) goto L40;
        ECLiveSkinTabEnhanceElement r115 = (ECLiveSkinTabEnhanceElement) ((LinkedHashMap) r114).get(String.valueOf(r100));
    L41:
        if (r115 != null) goto L43;
        return null;
    L43:
        if (r101 == true) goto L47;
        ECLiveSkinTabUIConfig r116 = r115.getStyle();
        if (r116 != null) goto L67;
        return null;
    L67:
        return r116.getDisabled();
    L47:
        if (r110 == false) goto L51;
        ECLiveSkinTabUIConfig r117 = r115.getStyle();
        if (r117 != null) goto L69;
        return null;
    L69:
        return r117.getSelected();
    L51:
        ECLiveSkinTabUIConfig r118 = r115.getStyle();
        if (r118 != null) goto L54;
        return null;
    L54:
        return r118.getUnselected();
    L40:
        r115 = null;
        goto L41
    }

    public final int[] b(int r100, boolean r101, boolean r102) {
        ECLiveSkinBaseViewUIConfig r103 = a(r100, r101, r102);
        if (r103 == null) goto L16;
        ECLiveSkinTextElement r104 = r103.getText();
        if (r104 == null) goto L23;
        List<String> r105 = r104.getColor();
        if (r105 == null) goto L24;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L15;
        Integer r108 = s.b((String) r107.next());
        if (r108 == null) goto L10;
        r106.add(Integer.valueOf(r108.intValue()));
        goto L10
    L15:
        return CollectionsKt.toIntArray(r106);
    L24:
        return null;
    L23:
        return null;
    L16:
        return null;
    }

    public final Integer c(int r100, boolean r101, boolean r102) {
        ECLiveSkinBaseViewUIConfig r103 = a(r100, r101, r102);
        if (r103 == null) goto L7;
        ECLiveSkinTextElement r104 = r103.getText();
        if (r104 == null) goto L7;
        return Integer.valueOf(r104.getFontSize());
    L7:
        return null;
    }

    public final Integer d(int r100, boolean r101, boolean r102) {
        ECLiveSkinBaseViewUIConfig r103 = a(r100, r101, r102);
        if (r103 == null) goto L7;
        ECLiveSkinTextElement r104 = r103.getText();
        if (r104 == null) goto L7;
        return Integer.valueOf(r104.getFontWeight());
    L7:
        return null;
    }
}
