package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import am2.x;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f139797a = 0;

    static {
    }

    public static void a(String r100, n5 r101) {
        HashMap r102 = new HashMap();
        String r103 = r101.getScene();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("scene", r103);
        String r105 = r101.getSubScene();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r102.put(BdpAppEventConstant.PARAMS_SUB_SCENE, r104);
        r102.put("duration", String.valueOf(f.a(r101)));
        Intrinsics.checkNotNullParameter(r101, "$this$isAssemble");
        n5.e r106 = r101.getDynamicConfig();
        if (r106 == null) goto L12;
        boolean r107 = r106.isAssemble;
    L13:
        String r108 = "1";
        if (r107 == false) goto L16;
        Object r109 = "1";
    L17:
        r102.put("is_assemble", r109);
        n5.e r110 = r101.getDynamicConfig();
        if (r110 == null) goto L20;
        n5.b r111 = r110.comboInfo;
    L21:
        if (r111 != null) goto L24;
        r108 = "0";
    L24:
        r102.put("has_combo", r108);
        Intrinsics.checkNotNullParameter(r101, "$this$displayEffectType");
        n5.e r112 = r101.getDynamicConfig();
        if (r112 == null) goto L27;
        int r113 = r112.displayEffectType;
    L28:
        r102.put("display_effect_type", String.valueOf(r113));
        Intrinsics.checkNotNullParameter(r101, "$this$showPriority");
        n5.f r114 = r101.getPriorityConfig();
        if (r114 == null) goto L31;
        int r115 = r114.priority;
    L32:
        r102.put("priority", String.valueOf(r115));
        Intrinsics.checkNotNullParameter(r101, "$this$priorityLowerStrategy");
        n5.f r116 = r101.getPriorityConfig();
        if (r116 == null) goto L35;
        int r117 = r116.priorityLowerStrategy;
    L36:
        r102.put("priority_lower_strategy", String.valueOf(r117));
        Intrinsics.checkNotNullParameter(r101, "$this$priorityEqualStrategy");
        n5.f r118 = r101.getPriorityConfig();
        if (r118 == null) goto L39;
        int r119 = r118.priorityEqualStrategy;
    L40:
        r102.put("priority_equal_strategy", String.valueOf(r119));
        Intrinsics.checkNotNullParameter(r101, "$this$priorityHigherStrategy");
        n5.f r120 = r101.getPriorityConfig();
        if (r120 == null) goto L43;
        int r121 = r120.priorityHigherStrategy;
    L44:
        r102.put("priority_higher_strategy", String.valueOf(r121));
        Map<String, String> r122 = r101.getEventParams();
        if (r122 != null) goto L47;
        r122 = MapsKt.emptyMap();
    L47:
        r102.putAll(r122);
        j0.l().sendLog(r100, r102, new Object[]{IRoom.class, x.class});
        return;
    L43:
        r121 = 2;
        goto L44
    L39:
        r119 = 1;
        goto L40
    L35:
        r117 = 0;
        goto L36
    L31:
        r115 = 0;
        goto L32
    L27:
        r113 = 0;
        goto L28
    L20:
        r111 = null;
        goto L21
    L16:
        r109 = "0";
        goto L17
    L12:
        r107 = false;
        goto L13
    }
}
