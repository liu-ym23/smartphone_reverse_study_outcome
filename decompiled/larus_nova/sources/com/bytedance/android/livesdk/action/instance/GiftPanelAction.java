package com.bytedance.android.livesdk.action.instance;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
@ActionMethod("webcast_inroom_giftpanel")
public class GiftPanelAction extends BaseActionMethod<Void> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public GiftPanelAction() {
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map r310) throws Exception {
        int r100 = 0;
        if (r310 != null) goto L141;
        String r101 = "";
        String r102 = r101;
        String r103 = r102;
        String r110 = r103;
        int r104 = 0;
        long r105 = -1;
        long r111 = -1;
        long r112 = 0;
        long r113 = -1;
    L101:
        int r210 = r104;
        int r211 = r100;
        long r212 = r111;
        String r106 = r110;
        String r114 = r103;
        String r107 = r102;
        long r108 = r113;
        long r115 = r105;
    L103:
        if (yt0.c.i() == null) goto L106;
        yt0.c.i().getBubbleRefId().setValue(Long.valueOf(r112));
    L106:
        if (TextUtils.isEmpty(r114) == true) goto L108;
    L132:
        Bundle r109 = new Bundle();
        if (TextUtils.isEmpty(r106) == true) goto L135;
        r109.putString("gift_show_from", r106);
    L136:
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r211, r212, r109, r114, r115);
    L137:
        finishWithResult(0);
        return;
    L135:
        r109.putString("gift_show_from", "");
        goto L136
    L108:
        if (r115 > 0) goto L132;
        if (TextUtils.isEmpty(r106) == false) goto L113;
    L121:
        Bundle r116 = new Bundle();
        if (TextUtils.isEmpty(r107) == true) goto L125;
        r116.putString("buff_source", r107);
    L125:
        if (TextUtils.isEmpty(r106) == true) goto L128;
        r116.putString("gift_show_from", r106);
    L128:
        if (r212 <= 0) goto L130;
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r211, r212, "0", r116, r210, null, r101);
        goto L137
    L130:
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r211, r212, "0", r116, r210, null, r101);
        goto L137
    L113:
        if (r108 <= 0) goto L121;
        Bundle r117 = new Bundle();
        r117.putString("gift_show_from", r106);
        if (TextUtils.isEmpty(r107) == true) goto L118;
        r117.putString("buff_source", r107);
    L118:
        if (r212 <= 0) goto L120;
        int r213 = r211;
        long r214 = r212;
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r213, r214, n0.e(Long.valueOf(r108), null), r117, r210, null, r101);
        goto L137
    L120:
        ((IGiftCoreService) k.f(IGiftCoreService.class)).openGiftDialog(r211, r212, n0.e(Long.valueOf(r108), null), r117, null);
        goto L137
    L141:
        Object r118 = r310.get("tab");     // Catch: Exception -> L94
        if ((r118 instanceof Integer) == false) goto L8;
        int r119 = ((Integer) r118).intValue();     // Catch: Exception -> L94
    L150:
        Object r120 = r310.get(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID);     // Catch: Exception -> L92
        if ((r120 instanceof String) == false) goto L16;
        r111 = CastLongProtector.parseLong((String) r120);     // Catch: Exception -> L92
    L143:
        Object r121 = r310.get("buff_level");     // Catch: Exception -> L90
        if ((r121 instanceof String) == false) goto L26;
        r100 = CastIntegerProtector.parseInt((String) r121);     // Catch: Exception -> L90
    L153:
        Object r122 = r310.get("ref_id");     // Catch: Exception -> L88
        if ((r122 instanceof String) == false) goto L32;
        r112 = CastLongProtector.parseLong((String) r122);     // Catch: Exception -> L88
    L146:
        Object r123 = r310.get("gift_show_from");     // Catch: Exception -> L85
        if (r123 == null) goto L40;
        r110 = r123.toString();     // Catch: Exception -> L85
    L151:
        Object r124 = r310.get("user_id");     // Catch: Exception -> L83
        if (r124 == null) goto L45;
        r113 = CastLongProtector.parseLong((String) r124);     // Catch: Exception -> L83
    L144:
        Object r125 = r310.get("card_name");     // Catch: Exception -> L79
        if (r125 == null) goto L50;
        String r126 = r125.toString();     // Catch: Exception -> L79
    L148:
        Object r127 = r310.get("buff_source");     // Catch: Exception -> L77
        if ((r127 instanceof String) == false) goto L55;
        r107 = (String) r127;     // Catch: Exception -> L77
    L139:
        Object r128 = r310.get("prop_ref_id");     // Catch: Exception -> L75
        if ((r128 instanceof String) == false) goto L60;
        String r129 = (String) r128;     // Catch: Exception -> L75
    L142:
        Object r130 = r310.get("prop_def_id");     // Catch: Exception -> L73
        if ((r130 instanceof String) == false) goto L66;
        long r131 = CastLongProtector.parseLong((String) r130);     // Catch: Exception -> L73
    L64:
        r104 = r100;
        r102 = r107;
        r100 = r119;
        r103 = r129;
        r101 = r126;
        r105 = r131;
        goto L101
    L66:
        if ((r130 instanceof Integer) == false) goto L68;
    L71:
        r131 = ((Long) r130).longValue();     // Catch: Exception -> L73
        goto L64
    L68:
        if ((r130 instanceof Long) == true) goto L71;
        r104 = r100;
        r102 = r107;
        r100 = r119;
        r103 = r129;
        r101 = r126;
        r105 = -1;
    L73:
        e = move-exception;
        Exception r132 = e;
        r100 = r100;
    L82:
        r100 = r119;
    L99:
        r132.printStackTrace();
        r210 = r100;
        r211 = r100;
        r212 = r111;
        r106 = r110;
        r114 = r129;
        r101 = r126;
        r108 = r113;
        r115 = -1;
        goto L103
    L60:
        r129 = "";
    L75:
        e = move-exception;
        r132 = e;
        r100 = r100;
        r129 = "";
        goto L82
    L55:
        r107 = "";
    L77:
        e = move-exception;
        r132 = e;
        r107 = "";
    L81:
        r129 = r107;
        goto L82
    L50:
        r126 = "";
    L79:
        e = move-exception;
        r132 = e;
        r126 = "";
        r107 = r126;
        goto L81
    L45:
        r113 = -1;
    L83:
        e = move-exception;
        r132 = e;
        r126 = "";
        r107 = r126;
        r129 = r107;
    L87:
        r100 = r119;
    L98:
        r113 = -1;
        goto L99
    L40:
        r110 = "";
    L85:
        e = move-exception;
        r132 = e;
        r126 = "";
        r107 = r126;
        r129 = r107;
        r110 = r129;
        goto L87
    L32:
        if ((r122 instanceof Long) == false) goto L35;
        r112 = ((Long) r122).longValue();     // Catch: Exception -> L88
        goto L146
    L35:
        r112 = 0;
    L88:
        e = move-exception;
        r132 = e;
        r100 = r100;
        r126 = "";
        r107 = r126;
        r129 = r107;
        r110 = r129;
        r100 = r119;
    L97:
        r112 = 0;
        goto L98
    L26:
        if ((r121 instanceof Integer) == false) goto L153;
        r100 = ((Integer) r121).intValue();     // Catch: Exception -> L90
    L90:
        e = move-exception;
        r132 = e;
        r126 = "";
        r107 = r126;
        r129 = r107;
        r110 = r129;
        r100 = r119;
        r100 = 0;
        goto L97
    L16:
        if ((r120 instanceof Integer) == false) goto L18;
    L21:
        r111 = ((Long) r120).longValue();     // Catch: Exception -> L92
        goto L143
    L18:
        if ((r120 instanceof Long) == true) goto L21;
        r111 = -1;
    L92:
        e = move-exception;
        r132 = e;
        r126 = "";
        r107 = r126;
        r129 = r107;
        r110 = r129;
        r100 = r119;
    L96:
        r100 = 0;
        r111 = -1;
        goto L97
    L8:
        if ((r118 instanceof String) == false) goto L11;
        r119 = CastIntegerProtector.parseInt((String) r118);     // Catch: Exception -> L94
        goto L150
    L11:
        r119 = 0;
    L94:
        e = move-exception;
        r132 = e;
        r126 = "";
        r107 = r126;
        r129 = r107;
        r110 = r129;
        goto L96
    }
}
