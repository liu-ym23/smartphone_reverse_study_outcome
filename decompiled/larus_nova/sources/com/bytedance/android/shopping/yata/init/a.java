package com.bytedance.android.shopping.yata.init;

import com.bytedance.kmp.ec.yata.common.init.c;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187608a = 0;

    static {
    }

    public static void a(String r100, c r101, Map r102, boolean r110, boolean r111) {
        Object r103 = r102.get("force_log_in_bg_thread_3740");
        Object r104 = null;
        if ((r103 instanceof Boolean) == true) goto L5;
        r103 = null;
    L5:
        Boolean r105 = (Boolean) r103;
        if (r105 == null) goto L8;
        r105.booleanValue();
    L8:
        Object r106 = r102.get("enable_assert_3380");
        if ((r106 instanceof Boolean) == true) goto L11;
        r106 = null;
    L11:
        Boolean r107 = (Boolean) r106;
        boolean r108 = true;
        if (r107 == null) goto L14;
        boolean r109 = r107.booleanValue();
    L15:
        Object r112 = r102.get("enable_warning_3460");
        if ((r112 instanceof Boolean) == true) goto L18;
        r112 = null;
    L18:
        Boolean r113 = (Boolean) r112;
        if (r113 == null) goto L21;
        boolean r114 = r113.booleanValue();
    L22:
        Object r115 = r102.get("enable_node_service_report_error_3460");
        if ((r115 instanceof Boolean) == true) goto L25;
        r115 = null;
    L25:
        Boolean r116 = (Boolean) r115;
        if (r116 == null) goto L28;
        boolean r117 = r116.booleanValue();
    L29:
        Object r118 = r102.get("enable_ensure_not_reach_here_3490");
        if ((r118 instanceof Boolean) == true) goto L32;
        r118 = null;
    L32:
        Boolean r119 = (Boolean) r118;
        if (r119 == null) goto L35;
        boolean r120 = r119.booleanValue();
    L36:
        YaTaLog.f251437b = r109;
        YaTaLog.f251438c = r114;
        YaTaLog.f251439d = r117;
        YaTaLog.f251440e = r120;
        Object r121 = r102.get(r100);
        if ((r121 instanceof Map) == true) goto L39;
        r121 = null;
    L39:
        Map r122 = (Map) r121;
        if (r122 == null) goto L42;
        Object r123 = r122.get("enable_passive_change");
    L44:
        if ((r123 instanceof Boolean) == true) goto L46;
        r123 = null;
    L46:
        Boolean r124 = (Boolean) r123;
        if (r124 == null) goto L49;
        r110 = r124.booleanValue();
    L49:
        r101.f251425a = r110;
        Object r125 = r102.get(r100);
        if ((r125 instanceof Map) == true) goto L52;
        r125 = null;
    L52:
        Map r126 = (Map) r125;
        if (r126 == null) goto L55;
        Object r127 = r126.get("enable_item_anim_3510");
    L57:
        if ((r127 instanceof Boolean) == true) goto L59;
        r127 = null;
    L59:
        Boolean r128 = (Boolean) r127;
        if (r128 == null) goto L62;
        r111 = r128.booleanValue();
    L62:
        r101.f251426b = r111;
        Object r129 = r102.get(r100);
        if ((r129 instanceof Map) == true) goto L65;
        r129 = null;
    L65:
        Map r130 = (Map) r129;
        if (r130 == null) goto L68;
        Object r131 = r130.get("use_biz_tracker");
    L70:
        if ((r131 instanceof Boolean) == true) goto L72;
        r131 = null;
    L72:
        Boolean r132 = (Boolean) r131;
        if (r132 == null) goto L75;
        boolean r133 = r132.booleanValue();
    L76:
        r101.f251427c = r133;
        boolean r134 = false;
        if (r101.f251429e == false) goto L94;
        Object r135 = r102.get(r100);
        if ((r135 instanceof Map) == true) goto L81;
        r135 = null;
    L81:
        Map r136 = (Map) r135;
        if (r136 == null) goto L84;
        Object r137 = r136.get("use_hidden_container_perf_opt_3760");
    L86:
        if ((r137 instanceof Boolean) == true) goto L88;
        r137 = null;
    L88:
        Boolean r138 = (Boolean) r137;
        if (r138 == null) goto L91;
        boolean r139 = r138.booleanValue();
    L92:
        if (r139 == false) goto L94;
        boolean r140 = true;
    L95:
        r101.f251429e = r140;
        Object r141 = r102.get(r100);
        if ((r141 instanceof Map) == true) goto L98;
        r141 = null;
    L98:
        Map r142 = (Map) r141;
        if (r142 == null) goto L101;
        Object r143 = r142.get("use_view_zero_size_invisible_3440");
    L103:
        if ((r143 instanceof Boolean) == true) goto L105;
        r143 = null;
    L105:
        Boolean r144 = (Boolean) r143;
        if (r144 == null) goto L108;
        boolean r145 = r144.booleanValue();
    L109:
        r101.f251430f = r145;
        Object r146 = r102.get(r100);
        if ((r146 instanceof Map) == true) goto L112;
        r146 = null;
    L112:
        Map r147 = (Map) r146;
        if (r147 == null) goto L115;
        Object r148 = r147.get("use_make_up_auto_exposure_3440");
    L117:
        if ((r148 instanceof Boolean) == true) goto L119;
        r148 = null;
    L119:
        Boolean r149 = (Boolean) r148;
        if (r149 == null) goto L122;
        boolean r150 = r149.booleanValue();
    L123:
        r101.f251431g = r150;
        Object r151 = r102.get(r100);
        if ((r151 instanceof Map) == true) goto L126;
        r151 = null;
    L126:
        Map r152 = (Map) r151;
        if (r152 == null) goto L129;
        Object r153 = r152.get("use_group_exposure_3440");
    L131:
        if ((r153 instanceof Boolean) == true) goto L133;
        r153 = null;
    L133:
        Boolean r154 = (Boolean) r153;
        if (r154 == null) goto L136;
        r134 = r154.booleanValue();
    L136:
        r101.f251432h = r134;
        Object r155 = r102.get(r100);
        if ((r155 instanceof Map) == true) goto L139;
        r155 = null;
    L139:
        Map r156 = (Map) r155;
        if (r156 == null) goto L142;
        Object r157 = r156.get("use_collect_dispatch_chain_3740");
    L144:
        if ((r157 instanceof Boolean) == true) goto L146;
        r157 = null;
    L146:
        Boolean r158 = (Boolean) r157;
        if (r158 == null) goto L149;
        r158.booleanValue();
    L149:
        Object r159 = r102.get(r100);
        if ((r159 instanceof Map) == true) goto L152;
        r159 = null;
    L152:
        Map r160 = (Map) r159;
        if (r160 == null) goto L155;
        Object r161 = r160.get("enable_kmp_slice_expr_3850");
    L157:
        if ((r161 instanceof Boolean) == true) goto L159;
        r161 = null;
    L159:
        Boolean r162 = (Boolean) r161;
        if (r162 == null) goto L162;
        boolean r163 = r162.booleanValue();
    L163:
        r101.f251434j = r163;
        Object r164 = r102.get(r100);
        if ((r164 instanceof Map) == true) goto L166;
        r164 = null;
    L166:
        Map r165 = (Map) r164;
        if (r165 == null) goto L169;
        Object r166 = r165.get("fix_recycler_view_render_callback_3860");
    L171:
        if ((r166 instanceof Boolean) == true) goto L173;
        r166 = null;
    L173:
        Boolean r167 = (Boolean) r166;
        if (r167 == null) goto L176;
        boolean r168 = r167.booleanValue();
    L177:
        r101.f251435k = r168;
        Object r169 = r102.get("sdk");
        if ((r169 instanceof Map) == true) goto L180;
        r169 = null;
    L180:
        Map r170 = (Map) r169;
        if (r170 == null) goto L183;
        Object r171 = r170.get("use_deep_event_fields_expr");
    L185:
        if ((r171 instanceof Boolean) == false) goto L188;
        r104 = r171;
    L188:
        Boolean r172 = (Boolean) r104;
        if (r172 == null) goto L191;
        r108 = r172.booleanValue();
    L191:
        r101.f251433i = r108;
        return;
    L183:
        r171 = null;
        goto L185
    L176:
        r168 = true;
        goto L177
    L169:
        r166 = null;
        goto L171
    L162:
        r163 = true;
        goto L163
    L155:
        r161 = null;
        goto L157
    L142:
        r157 = null;
        goto L144
    L129:
        r153 = null;
        goto L131
    L122:
        r150 = true;
        goto L123
    L115:
        r148 = null;
        goto L117
    L108:
        r145 = false;
        goto L109
    L101:
        r143 = null;
        goto L103
    L91:
        r139 = true;
        goto L92
    L84:
        r137 = null;
    L94:
        r140 = false;
        goto L95
    L75:
        r133 = true;
        goto L76
    L68:
        r131 = null;
        goto L70
    L55:
        r127 = null;
        goto L57
    L42:
        r123 = null;
        goto L44
    L35:
        r120 = true;
        goto L36
    L28:
        r117 = true;
        goto L29
    L21:
        r114 = true;
        goto L22
    L14:
        r109 = true;
        goto L15
    }
}
