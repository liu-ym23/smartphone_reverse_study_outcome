package com.bytedance.android.livesdk.livecommerce.largemode;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LargeModeConfig;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f149250c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f149251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f149252b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.largemode.a$a, reason: collision with other inner class name */
    public static final class C2309a {
        public static float a() {
            Float r100 = ECAppInfoService.f48114e.getCurrentFontScale();
            if (r100 == null) goto L5;
            float r101 = r100.floatValue();
        L7:
            if (r101 < 1.0f) goto L12;
            if (r101 >= 1.15f) goto L12;
            return 1.0f;
        L12:
            if (r101 < 1.15f) goto L15;
            return 1.15f;
        L15:
            return 1.0f;
        L5:
            r101 = 1.0f;
            goto L7
        }
    }

    static {
    }

    public a(float r100) {
        this.f149252b = r100;
        this.f149251a = true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.largemode.b
    public final void a(boolean r100) {
        this.f149251a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.largemode.b
    public final ComponentLargeModeConfig b(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r111, "component");
        if (this.f149251a == false) goto L167;
        Lazy r100 = ECLiveLargeModeConfigHelper.f149245a;
        float r101 = this.f149252b;
        Intrinsics.checkNotNullParameter(r110, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r111, "componentName");
        Map r102 = ECLiveLargeModeConfigHelper.f149248d.get(String.valueOf(r101));
        if (r102 != null) goto L111;
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, LargeModeConfig> r104 = ECLiveLargeModeConfigHelper.f149247c.get(String.valueOf(r101));
        if (r104 == null) goto L46;
        Iterator<Map.Entry<String, LargeModeConfig>> r105 = r104.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L46;
        Map.Entry<String, LargeModeConfig> r106 = r105.next();
        List<ComponentLargeModeConfig> r107 = r106.getValue().getData();
        if (r107 == null) goto L11;
        if ((!r107.isEmpty()) == true) goto L18;
        r107 = null;
    L18:
        if (r107 == null) goto L11;
        LinkedHashMap r108 = new LinkedHashMap();
        List<ComponentLargeModeConfig> r109 = r106.getValue().getData();
        if (r109 == null) goto L35;
        Iterator<T> r112 = r109.iterator();
    L23:
        if (r112.hasNext() == false) goto L35;
        ComponentLargeModeConfig r113 = (ComponentLargeModeConfig) r112.next();
        String r114 = r113.getComponentName();
        if (r114 == null) goto L23;
        if (r114.length() <= 0) goto L29;
        boolean r115 = true;
    L30:
        if (r115 == true) goto L33;
        r114 = null;
    L33:
        if (r114 == null) goto L23;
        r108.put(r114, r113);
        goto L23
    L29:
        r115 = false;
    L35:
        String r116 = r106.getValue().getComponentName();
        if (r116 == null) goto L11;
        if (r116.length() <= 0) goto L40;
        boolean r117 = true;
    L41:
        if (r117 == true) goto L44;
        r116 = null;
    L44:
        if (r116 == null) goto L11;
        r103.put(r116, r108);
        goto L11
    L40:
        r117 = false;
    L46:
        List r118 = (List) ECLiveLargeModeConfigHelper.f149246b.getValue();
        if (r118 == null) goto L105;
        ArrayList r119 = new ArrayList();
        Iterator r120 = r118.iterator();
    L50:
        if (r120.hasNext() == false) goto L54;
        Object r121 = r120.next();
        if (Intrinsics.areEqual(((LargeModeConfig) r121).getBigFontScale(), String.valueOf(r101)) == false) goto L50;
        r119.add(r121);
        goto L50
    L54:
        Iterator r122 = r119.iterator();
    L56:
        if (r122.hasNext() == false) goto L105;
        LargeModeConfig r123 = (LargeModeConfig) r122.next();
        if (r103.containsKey(r123.getComponentName()) == true) goto L59;
        String r124 = r123.getComponentName();
        if (r124 == null) goto L56;
        if (r124.length() <= 0) goto L82;
        boolean r125 = true;
    L83:
        if (r125 == true) goto L86;
        r124 = null;
    L86:
        if (r124 == null) goto L56;
        LinkedHashMap r126 = new LinkedHashMap();
        List<ComponentLargeModeConfig> r127 = r123.getData();
        if (r127 == null) goto L103;
        Iterator<T> r128 = r127.iterator();
    L91:
        if (r128.hasNext() == false) goto L103;
        ComponentLargeModeConfig r129 = (ComponentLargeModeConfig) r128.next();
        String r130 = r129.getComponentName();
        if (r130 == null) goto L91;
        if (r130.length() <= 0) goto L97;
        boolean r131 = true;
    L98:
        if (r131 == true) goto L101;
        r130 = null;
    L101:
        if (r130 == null) goto L91;
        r126.put(r130, r129);
        goto L91
    L97:
        r131 = false;
    L103:
        r103.put(r124, r126);
        goto L56
    L82:
        r125 = false;
        goto L83
    L59:
        Map r132 = (Map) r103.get(r123.getComponentName());
        if (r132 == null) goto L56;
        List<ComponentLargeModeConfig> r133 = r123.getData();
        if (r133 == null) goto L56;
        Iterator<T> r134 = r133.iterator();
    L65:
        if (r134.hasNext() == false) goto L56;
        ComponentLargeModeConfig r135 = (ComponentLargeModeConfig) r134.next();
        String r136 = r135.getComponentName();
        if (r136 == null) goto L65;
        if (r136.length() <= 0) goto L71;
        boolean r137 = true;
    L72:
        if (r137 == true) goto L75;
        r136 = null;
    L75:
        if (r136 == null) goto L65;
        r132.put(r136, r135);
        goto L65
    L71:
        r137 = false;
    L105:
        if ((!r103.isEmpty()) == false) goto L107;
        LinkedHashMap r138 = r103;
    L108:
        if (r138 == null) goto L110;
        ECLiveLargeModeConfigHelper.f149248d.put(String.valueOf(r101), r103);
        r102 = r138;
        goto L111
    L110:
        r102 = null;
        goto L111
    L107:
        r138 = null;
    L111:
        if (r102 == null) goto L113;
        Map r139 = (Map) r102.get(r110);
    L114:
        if (r139 != null) goto L116;
        return null;
    L116:
        return (ComponentLargeModeConfig) r139.get(r111);
    L113:
        r139 = null;
        goto L114
    L167:
        return null;
    }
}
