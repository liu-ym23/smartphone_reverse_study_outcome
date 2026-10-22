package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.CornerType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f177875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a f177876b;

    public h(com.bytedance.android.shopping.mall.homepage.card.headercard.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mallContext");
        this.f177876b = r100;
        this.f177875a = Collections.synchronizedSet(new LinkedHashSet());
    }

    public static final void a(h r100, int r101, ToolVO r102, Map r103) {
        r100.getClass();
        Pair[] r104 = new Pair[12];
        String r105 = null;
        if (r102 == null) goto L5;
        String r106 = r102.getTitle();
    L6:
        r104[0] = TuplesKt.to("module_name", r106);
        r104[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_TYPE, "icon");
        if (r102 == null) goto L9;
        ToolVO.Corner r107 = r102.getCorner();
    L10:
        if (r107 == null) goto L15;
        ToolVO.Corner r108 = r102.getCorner();
        if (r108 == null) goto L14;
        String r109 = r108.getText();
    L19:
        r104[2] = TuplesKt.to("notice_name", r109);
        r104[3] = TuplesKt.to("position", "top");
        r104[4] = TuplesKt.to("btm_index", Integer.valueOf(r101));
        if (r102 == null) goto L22;
        String r110 = r102.getTitle();
    L23:
        r104[5] = TuplesKt.to("btm_desc", r110);
        if (r102 == null) goto L26;
        String r111 = r102.getTitle();
    L27:
        r104[6] = TuplesKt.to("btm_module_name", r111);
        if (r102 == null) goto L30;
        String r112 = r102.getComponentId();
    L31:
        r104[7] = TuplesKt.to("component_id", r112);
        if (r102 == null) goto L36;
        ToolVO.Corner r113 = r102.getCorner();
        if (r113 == null) goto L36;
        r105 = r113.getType();
    L36:
        r104[8] = TuplesKt.to("has_red_dot", Integer.valueOf(Intrinsics.areEqual(r105, CornerType.DOT.getValue()) ? 1 : 0));
        r104[9] = TuplesKt.to("is_new_layout", 0);
        r104[10] = TuplesKt.to("is_more_tool", 0);
        r104[11] = TuplesKt.to("relative_index", -1);
        b(r100, false, MapsKt.mutableMapOf(r104), r101, r103);
        return;
    L30:
        r112 = null;
        goto L31
    L26:
        r111 = null;
        goto L27
    L22:
        r110 = null;
        goto L23
    L14:
        r109 = null;
        goto L19
    L15:
        if (r102 == null) goto L18;
        r109 = r102.getBadge();
        if (r109 != null) goto L19;
    L18:
        r109 = "";
        goto L19
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public static void b(h r100, boolean r101, Map r102, int r110, Map r111) {
        r100.getClass();
        Object r103 = r111.get("enter_from");
        if (r103 == null) goto L5;
        String r104 = r103.toString();
    L6:
        Object r105 = r111.get("page_name");
        if (r105 == null) goto L9;
        String r106 = r105.toString();
    L10:
        Object r107 = r111.get("previous_page");
        if (r107 == null) goto L16;
        String r108 = r107.toString();
        if (r108 == null) goto L16;
        r104 = r108;
    L16:
        Object r109 = r102.get("component_id");
        if (r109 == null) goto L20;
        String r112 = r109.toString();
        if (r112 == null) goto L20;
    L21:
        r102.put("enter_from", r104);
        r102.put("page_name", r106);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r102.put("previous_page", r104);
        r102.put("module_id", "tool_list");
        String r113 = com.bytedance.android.shopping.mall.homepage.card.headercard.util.b.b(r110, r112, null);
        if (r101 == false) goto L24;
        String r114 = "click_order_homepage_module_entrance";
    L25:
        com.bytedance.android.shopping.mall.homepage.card.headercard.util.e.b(r100.f177876b, r114, r113, r102, r111);
        return;
    L24:
        r114 = "show_order_homepage_module_entrance";
    L20:
        r112 = "";
        goto L21
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
