package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends com.bytedance.android.ecom.arch.slice.render.elements.b<e> {
    public String H3;
    public Map<String, ? extends Object> I3;
    public com.bytedance.android.shopping.deepfeed.slice.service.a J3;

    public d(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.H3 = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        Map<String, ? extends Object> r100 = null;
        if (this.J3 != null) goto L12;
        c r101 = new c(this);
        Object r102 = this.f50260a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r102 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L8;
        r102 = null;
    L8:
        com.bytedance.android.shopping.deepfeed.slice.service.b r103 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r102;
        if (r103 == null) goto L11;
        r103.K(r101);
    L11:
        this.J3 = r101;
    L12:
        ?? r104 = 0;
        r104 = 0;
        o1(r110, "loop", 0);
        Object r105 = r110.get("autoPlay");
        if ((r105 instanceof Boolean) == false) goto L16;
        r104 = ((Boolean) r105).booleanValue();
    L28:
        Object r106 = r110.get("src");
        if ((r106 instanceof String) == true) goto L31;
        r106 = null;
    L31:
        String r107 = (String) r106;
        String r108 = "";
        if (r107 != null) goto L34;
        r107 = "";
    L34:
        Object r109 = r110.get("type");
        if ((r109 instanceof String) == true) goto L37;
        r109 = null;
    L37:
        String r111 = (String) r109;
        if (r111 != null) goto L41;
        r111 = "";
    L41:
        if (StringsKt.isBlank(r111) == false) goto L43;
        r111 = com.alipay.sdk.m.k.b.f25406k;
    L43:
        Object r112 = r110.get("android_url");
        if ((r112 instanceof String) == true) goto L46;
        r112 = null;
    L46:
        String r113 = (String) r112;
        if (r113 != null) goto L49;
        r113 = "";
    L49:
        o1(r110, "play", o1(r110, "play", r104));
        Object r114 = r110.get("modifyParams");
        if ((r114 instanceof Map) == true) goto L52;
        r114 = null;
    L52:
        Map r115 = (Map) r114;
        if (r115 != null) goto L55;
        Map r116 = MapsKt.emptyMap();
    L70:
        Object r117 = r110.get("animationEndAction");
        if ((r117 instanceof String) == false) goto L76;
        if ((true ^ StringsKt.isBlank((CharSequence) r117)) == false) goto L76;
        Pair r118 = TuplesKt.to(r117, null);
    L109:
        if (r118 == null) goto L114;
        String r119 = (String) r118.getFirst();
        if (r119 == null) goto L114;
        r108 = r119;
    L114:
        this.H3 = r108;
        if (r118 == null) goto L117;
        r100 = (Map) r118.getSecond();
    L117:
        this.I3 = r100;
        if (k1() == null) goto L135;
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r113, "androidUrl");
        Intrinsics.checkNotNullParameter(r107, "src");
        Intrinsics.checkNotNullParameter(r116, "modifyParams");
        return;
    L135:
        return;
    L76:
        if ((r117 instanceof Map) == true) goto L78;
        r117 = null;
    L78:
        Map r120 = (Map) r117;
        if (r120 == null) goto L86;
        Object r121 = r120.get("type");
        if ((r121 instanceof String) == true) goto L84;
        r121 = null;
    L84:
        String r122 = (String) r121;
        if (r122 == null) goto L86;
        Object r123 = r120.get(SlcCommonAction.KEY_PARAMS);
        if ((r123 instanceof Map) == true) goto L90;
        r123 = null;
    L90:
        Map r124 = (Map) r123;
        if (r124 == null) goto L107;
        Set r125 = r124.entrySet();
        if (r125 == null) goto L107;
        ArrayList r126 = new ArrayList();
        Iterator r127 = r125.iterator();
    L96:
        if (r127.hasNext() == false) goto L106;
        Map.Entry r128 = (Map.Entry) r127.next();
        Object r129 = r128.getKey();
        Object r130 = r128.getValue();
        if ((r129 instanceof String) == true) goto L100;
        r129 = null;
    L100:
        String r131 = (String) r129;
        if (r131 == null) goto L103;
        Pair r132 = TuplesKt.to(r131, r130);
    L104:
        if (r132 == null) goto L96;
        r126.add(r132);
        goto L96
    L103:
        r132 = null;
        goto L104
    L106:
        Map r133 = MapsKt.toMap(r126);
    L108:
        r118 = TuplesKt.to(r122, r133);
    L107:
        r133 = null;
    L86:
        r118 = null;
        goto L109
    L55:
        LinkedHashMap r134 = new LinkedHashMap();
        Iterator r135 = r115.entrySet().iterator();
    L57:
        if (r135.hasNext() == false) goto L69;
        Map.Entry r136 = (Map.Entry) r135.next();
        Object r137 = r136.getKey();
        Object r138 = r136.getValue();
        if ((r137 instanceof String) == true) goto L61;
        r137 = null;
    L61:
        String r139 = (String) r137;
        if (r139 == null) goto L57;
        if (r138 == null) goto L57;
        String r140 = r138.toString();
        if (r140 == null) goto L57;
        r134.put(r139, r140);
        goto L57
    L69:
        r116 = r134;
        goto L70
    L16:
        if ((r105 instanceof Integer) == false) goto L19;
        r104 = Intrinsics.areEqual(r105, 1);
        goto L28
    L19:
        if ((r105 instanceof Long) == false) goto L22;
        r104 = Intrinsics.areEqual(r105, 1L);
        goto L28
    L22:
        if ((r105 instanceof String) == false) goto L28;
        if (Intrinsics.areEqual(r105, "1") == false) goto L26;
    L27:
        r104 = 1;
        goto L28
    L26:
        if (StringsKt.equals((String) r105, "true", true) == false) goto L28;
        goto L27
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final e r101 = new e(r100);
        r101.setOnAnimationEndListener(new DeepFeedSlcLottieManager$onCreateContentView$$inlined$apply$lambda$1(r101, this));
        return r101;
    }

    public static int o1(Map r100, String r101, int r102) {
        Object r103 = r100.get(r101);
        if ((r103 instanceof Integer) == false) goto L6;
        return ((Number) r103).intValue();
    L6:
        if ((r103 instanceof Long) == false) goto L9;
        return (int) ((Number) r103).longValue();
    L9:
        if ((r103 instanceof Float) == false) goto L12;
        return (int) ((Number) r103).floatValue();
    L12:
        if ((r103 instanceof Double) == false) goto L15;
        return (int) ((Number) r103).doubleValue();
    L15:
        if ((r103 instanceof String) == false) goto L24;
        Integer r104 = StringsKt.toIntOrNull((String) r103);
        if (r104 != null) goto L19;
        return r102;
    L19:
        return r104.intValue();
    L24:
        return r102;
    }
}
