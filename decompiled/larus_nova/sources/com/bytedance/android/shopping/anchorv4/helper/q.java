package com.bytedance.android.shopping.anchorv4.helper;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f166972a = 0;

    static {
    }

    public static void a(View r110, com.bytedance.android.shopping.anchorv4.dto.business.a r111, com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r210, int r211, int r212, List r213) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r213, "defaultPadding");
        Object r100 = 0;
        if (r111 == null) goto L12;
        List<Float> r101 = r111.c();
        if (r101 == null) goto L12;
        if (r101.size() != 4) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L14:
        if (r111 == null) goto L25;
        List<Float> r112 = r111.b();
        if (r112 == null) goto L25;
        if (r112.size() != 4) goto L20;
        boolean r113 = true;
    L21:
        if (r113 == true) goto L24;
        r112 = null;
    L24:
        if (r112 == null) goto L25;
    L26:
        if (r111 == null) goto L32;
        String r114 = r111.a();
        if (r114 == null) goto L32;
        Integer r115 = rc3.a.a(r114);
        if (r115 == null) goto L32;
        int r116 = r115.intValue();
    L33:
        if (r111 == null) goto L42;
        List<Float> r117 = r111.d();
        if (r117 == null) goto L42;
        if (r117.size() != 4) goto L39;
        boolean r103 = true;
    L40:
        if (r103 == false) goto L42;
    L43:
        if (r101 == null) goto L51;
        Object r104 = Float.valueOf(0.0f);
        Object r118 = CollectionsKt.getOrNull(r101, 3);
        if (r118 == null) goto L48;
        r104 = r118;
    L48:
        Float r105 = (Float) r104;
        if (r105 == null) goto L51;
        int r106 = com.bytedance.android.shopping.extensions.b.a(r105);
    L55:
        if (r101 == null) goto L63;
        Object r119 = Float.valueOf(0.0f);
        Object r120 = CollectionsKt.getOrNull(r101, 0);
        if (r120 == null) goto L60;
        r119 = r120;
    L60:
        Float r121 = (Float) r119;
        if (r121 == null) goto L63;
        int r122 = com.bytedance.android.shopping.extensions.b.a(r121);
    L67:
        if (r101 == null) goto L75;
        Object r123 = Float.valueOf(0.0f);
        Object r124 = CollectionsKt.getOrNull(r101, 1);
        if (r124 == null) goto L72;
        r123 = r124;
    L72:
        Float r125 = (Float) r123;
        if (r125 == null) goto L75;
        int r126 = com.bytedance.android.shopping.extensions.b.a(r125);
    L79:
        int r107 = r126;
        if (r101 == null) goto L88;
        Object r127 = Float.valueOf(0.0f);
        Object r108 = CollectionsKt.getOrNull(r101, 2);
        if (r108 == null) goto L85;
        r127 = r108;
    L85:
        Float r128 = (Float) r127;
        if (r128 == null) goto L88;
        int r109 = com.bytedance.android.shopping.extensions.b.a(r128);
    L93:
        r110.setPadding(r106, r122, r107, r109);
        ViewGroup.LayoutParams r129 = r110.getLayoutParams();
        if ((r129 instanceof ViewGroup.MarginLayoutParams) == true) goto L96;
        ViewGroup.LayoutParams r130 = null;
    L97:
        ViewGroup.MarginLayoutParams r131 = (ViewGroup.MarginLayoutParams) r130;
        if (r131 != null) goto L100;
        r131 = new ViewGroup.MarginLayoutParams(-2, -2);
    L100:
        Object r132 = Float.valueOf(0.0f);
        Object r133 = CollectionsKt.getOrNull(r112, 3);
        if (r133 == null) goto L104;
        r132 = r133;
    L104:
        r131.leftMargin = com.bytedance.android.shopping.extensions.b.a((Number) r132);
        Object r134 = Float.valueOf(0.0f);
        Object r135 = CollectionsKt.getOrNull(r112, 0);
        if (r135 == null) goto L108;
        r134 = r135;
    L108:
        r131.topMargin = com.bytedance.android.shopping.extensions.b.a((Number) r134);
        Object r136 = Float.valueOf(0.0f);
        Object r137 = CollectionsKt.getOrNull(r112, 1);
        if (r137 == null) goto L112;
        r136 = r137;
    L112:
        r131.rightMargin = com.bytedance.android.shopping.extensions.b.a((Number) r136);
        Object r138 = Float.valueOf(0.0f);
        Object r139 = CollectionsKt.getOrNull(r112, 2);
        if (r139 == null) goto L116;
        r138 = r139;
    L116:
        r131.bottomMargin = com.bytedance.android.shopping.extensions.b.a((Number) r138);
        Unit r140 = Unit.INSTANCE;
        r110.setLayoutParams(r131);
        r110.setBackgroundColor(r116);
        if (r210 != null) goto L119;
        return;
    L119:
        if (r117 == null) goto L127;
        Object r141 = Float.valueOf(0.0f);
        Object r142 = CollectionsKt.getOrNull(r117, 0);
        if (r142 == null) goto L124;
        r141 = r142;
    L124:
        Float r143 = (Float) r141;
        if (r143 == null) goto L127;
        int r144 = com.bytedance.android.shopping.extensions.b.a(r143);
    L128:
        if (r117 == null) goto L136;
        Object r145 = Float.valueOf(0.0f);
        Object r146 = CollectionsKt.getOrNull(r117, 1);
        if (r146 == null) goto L133;
        r145 = r146;
    L133:
        Float r147 = (Float) r145;
        if (r147 == null) goto L136;
        int r148 = com.bytedance.android.shopping.extensions.b.a(r147);
    L137:
        if (r117 == null) goto L145;
        Object r149 = Float.valueOf(0.0f);
        Object r150 = CollectionsKt.getOrNull(r117, 2);
        if (r150 == null) goto L142;
        r149 = r150;
    L142:
        Float r151 = (Float) r149;
        if (r151 == null) goto L145;
        int r152 = com.bytedance.android.shopping.extensions.b.a(r151);
    L146:
        if (r117 == null) goto L154;
        Object r153 = Float.valueOf(0.0f);
        Object r154 = CollectionsKt.getOrNull(r117, 3);
        if (r154 == null) goto L151;
        r153 = r154;
    L151:
        Float r155 = (Float) r153;
        if (r155 == null) goto L154;
        int r156 = com.bytedance.android.shopping.extensions.b.a(r155);
    L155:
        r210.f(new Radius(r144, r148, r152, r156));
        return;
    L154:
        r156 = r211;
    L145:
        r152 = r211;
    L136:
        r148 = r211;
    L127:
        r144 = r211;
        goto L128
    L96:
        r130 = r129;
    L88:
        Object r157 = CollectionsKt.getOrNull(r213, 2);
        if (r157 == null) goto L92;
        r100 = r157;
    L92:
        r109 = ((Number) r100).intValue();
    L75:
        Object r158 = CollectionsKt.getOrNull(r213, 1);
        if (r158 != null) goto L78;
        r158 = r100;
    L78:
        r126 = ((Number) r158).intValue();
    L63:
        Object r159 = CollectionsKt.getOrNull(r213, 0);
        if (r159 != null) goto L66;
        r159 = r100;
    L66:
        r122 = ((Number) r159).intValue();
    L51:
        Object r160 = CollectionsKt.getOrNull(r213, 3);
        if (r160 != null) goto L54;
        r160 = r100;
    L54:
        r106 = ((Number) r160).intValue();
        goto L55
    L39:
        r103 = false;
    L42:
        r117 = null;
    L32:
        r116 = r212;
        goto L33
    L20:
        r113 = false;
    L25:
        r112 = CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)});
        goto L26
    L9:
        r102 = false;
    L12:
        r101 = null;
        goto L14
    }
}
