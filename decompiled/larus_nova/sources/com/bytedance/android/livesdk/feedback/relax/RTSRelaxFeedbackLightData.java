package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.rts.client_utils.IESLiveRTSSettingUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class RTSRelaxFeedbackLightData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f124766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f124767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f124768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f124769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f124770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f124771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f124772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f124773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f124774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f124775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f124776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f124777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f124778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f124779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f124780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f124781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, Object> f124782q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, Object> f124783r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, Object> f124784s;

    public RTSRelaxFeedbackLightData(Map<String, Object> r110) {
        this.f124766a = "";
        this.f124767b = "";
        this.f124768c = "";
        this.f124769d = "";
        this.f124770e = "";
        this.f124771f = "";
        String r100 = "0";
        this.f124773h = "0";
        this.f124774i = "room";
        String r101 = "live_banner_horizontal";
        this.f124775j = "live_banner_horizontal";
        String r102 = "single";
        this.f124776k = "single";
        this.f124777l = "";
        this.f124778m = "";
        this.f124780o = "";
        this.f124781p = "";
        int r103 = com.bytedance.rts.foundation.f.f267579a;
        Object r104 = null;
        if (r110 == null) goto L5;
        Object r105 = r110.get("feedbackData");
    L7:
        if ((r105 instanceof String) == true) goto L9;
        r105 = null;
    L9:
        String r106 = (String) r105;
        String r107 = SliceInitService.DEFAULT_SWITCH;
        if (r106 != null) goto L12;
        r106 = SliceInitService.DEFAULT_SWITCH;
    L12:
        Map<String, Object> r108 = com.bytedance.rts.foundation.f.a.c(r106, RTSRelaxFeedbackLightData$feedback$1.INSTANCE);
        if (r110 == null) goto L15;
        Object r109 = r110.get("enter_from_merge");
    L17:
        if ((r109 instanceof String) == true) goto L19;
        r109 = null;
    L19:
        String r111 = (String) r109;
        if (r111 != null) goto L22;
        r111 = (String) com.bytedance.rts.foundation.g.m(r108, "enter_from_merge");
    L22:
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        this.f124766a = r111;
        if (r110 == null) goto L27;
        Object r112 = r110.get("enter_method");
    L29:
        if ((r112 instanceof String) == true) goto L31;
        r112 = null;
    L31:
        String r113 = (String) r112;
        if (r113 != null) goto L34;
        r113 = (String) com.bytedance.rts.foundation.g.m(r108, "enter_method");
    L34:
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        this.f124767b = r113;
        if (r110 == null) goto L39;
        Object r114 = r110.get("action_type");
    L41:
        if ((r114 instanceof String) == true) goto L43;
        r114 = null;
    L43:
        String r115 = (String) r114;
        if (r115 != null) goto L46;
        r115 = "";
    L46:
        this.f124768c = r115;
        if (r110 == null) goto L49;
        Object r116 = r110.get("room_id");
    L51:
        if ((r116 instanceof String) == true) goto L53;
        r116 = null;
    L53:
        String r117 = (String) r116;
        if (r117 != null) goto L56;
        r117 = (String) com.bytedance.rts.foundation.g.m(r108, "room_id");
    L56:
        if (r117 != null) goto L58;
        r117 = "";
    L58:
        this.f124769d = r117;
        if (r110 == null) goto L61;
        Object r118 = r110.get("anchor_id");
    L63:
        if ((r118 instanceof String) == true) goto L65;
        r118 = null;
    L65:
        String r119 = (String) r118;
        if (r119 != null) goto L68;
        r119 = "";
    L68:
        this.f124770e = r119;
        if (r110 == null) goto L71;
        Object r120 = r110.get("request_id");
    L73:
        if ((r120 instanceof String) == true) goto L75;
        r120 = null;
    L75:
        String r121 = (String) r120;
        if (r121 != null) goto L78;
        r121 = (String) com.bytedance.rts.foundation.g.m(r108, "request_id");
    L78:
        if (r121 != null) goto L80;
        r121 = "";
    L80:
        this.f124771f = r121;
        Long r122 = (Long) com.bytedance.rts.foundation.g.l(r108, "feedback_id");
        if (r122 == null) goto L83;
        long r123 = r122.longValue();
    L84:
        this.f124772g = r123;
        if (r110 == null) goto L87;
        Object r124 = r110.get("duration");
    L89:
        if ((r124 instanceof String) == true) goto L91;
        r124 = null;
    L91:
        String r125 = (String) r124;
        if (r110 == null) goto L94;
        Object r126 = r110.get(ILiveRoomPlayFragmentConstant.ORDER_CENTER_DRAW_INDEX);
    L96:
        if ((r126 instanceof String) == true) goto L98;
        r126 = null;
    L98:
        String r127 = (String) r126;
        if (r127 == null) goto L102;
        r100 = r127;
    L102:
        this.f124773h = r100;
        if (r110 == null) goto L105;
        Object r128 = r110.get("flow_type");
    L107:
        if ((r128 instanceof String) == true) goto L109;
        r128 = null;
    L109:
        String r129 = (String) r128;
        if (r129 != null) goto L112;
        r129 = "";
    L112:
        this.f124774i = r129;
        if (r110 == null) goto L115;
        Object r130 = r110.get("question_text");
    L117:
        if ((r130 instanceof String) == true) goto L119;
        r130 = null;
    L119:
        String r131 = (String) r130;
        if (r110 == null) goto L122;
        Object r132 = r110.get(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE);
    L124:
        if ((r132 instanceof String) == true) goto L126;
        r132 = null;
    L126:
        String r133 = (String) r132;
        if (r133 == null) goto L130;
        r101 = r133;
    L130:
        this.f124775j = r101;
        if (r110 == null) goto L133;
        Object r134 = r110.get("question_type");
    L135:
        if ((r134 instanceof String) == true) goto L137;
        r134 = null;
    L137:
        String r135 = (String) r134;
        if (r135 == null) goto L141;
        r102 = r135;
    L141:
        this.f124776k = r102;
        if (r110 == null) goto L144;
        Object r136 = r110.get("pk_id");
    L146:
        if ((r136 instanceof String) == true) goto L148;
        r136 = null;
    L148:
        String r137 = (String) r136;
        if (r137 != null) goto L151;
        r137 = "";
    L151:
        this.f124777l = r137;
        if (r110 == null) goto L154;
        Object r138 = r110.get("feedbackData");
    L156:
        if ((r138 instanceof String) == true) goto L158;
        r138 = null;
    L158:
        String r139 = (String) r138;
        if (r139 == null) goto L162;
        r107 = r139;
    L162:
        this.f124778m = r107;
        if (r110 == null) goto L165;
        Object r140 = r110.get("position");
    L167:
        if ((r140 instanceof String) == true) goto L169;
        r140 = null;
    L169:
        String r141 = (String) r140;
        if (r141 != null) goto L172;
        r141 = "";
    L172:
        this.f124780o = r141;
        if (r110 == null) goto L175;
        Object r142 = r110.get("recent_room_ids");
    L177:
        if ((r142 instanceof String) == false) goto L180;
        r104 = r142;
    L180:
        String r143 = (String) r104;
        if (r143 != null) goto L183;
        r143 = "";
    L183:
        this.f124781p = r143;
        int r144 = IESLiveRTSSettingUtils.f100460a;
        IESLiveRTSSettingUtils.a(new com.bytedance.android.live.rts.client_utils.a("live_light_feedback_config", "object", ""), new RTSRelaxFeedbackLightData$getClientSetting$1(this));
        IESLiveRTSSettingUtils.a(new com.bytedance.android.live.rts.client_utils.a("live_feedback_tomain_config", "object", ""), new RTSRelaxFeedbackLightData$getClientSetting$2(this));
        IESLiveRTSSettingUtils.a(new com.bytedance.android.live.rts.client_utils.a("live_public_screen_emoji_feedback_config", "object", ""), new RTSRelaxFeedbackLightData$getClientSetting$3(this));
        this.f124779n = r108;
        return;
    L175:
        r142 = null;
        goto L177
    L165:
        r140 = null;
        goto L167
    L154:
        r138 = null;
        goto L156
    L144:
        r136 = null;
        goto L146
    L133:
        r134 = null;
        goto L135
    L122:
        r132 = null;
        goto L124
    L115:
        r130 = null;
        goto L117
    L105:
        r128 = null;
        goto L107
    L94:
        r126 = null;
        goto L96
    L87:
        r124 = null;
        goto L89
    L83:
        r123 = 0;
        goto L84
    L71:
        r120 = null;
        goto L73
    L61:
        r118 = null;
        goto L63
    L49:
        r116 = null;
        goto L51
    L39:
        r114 = null;
        goto L41
    L27:
        r112 = null;
        goto L29
    L15:
        r109 = null;
        goto L17
    L5:
        r105 = null;
        goto L7
    }
}
