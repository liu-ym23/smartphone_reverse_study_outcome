package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdk.gift.model.Prop;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.alog.middleware.ALogService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class w0 extends a<am2.f0> {
    public w0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r110, Object r111) {
        am2.f0 r112 = (am2.f0) r111;
        super.u(r110, r112);
        if (r112 == null) goto L66;
        h2 r100 = r112.f4282c;
        Prop r101 = (Prop) com.bytedance.android.live.base.model.m.b(r112.f4283d, Prop.class);
        if (r100 != null) goto L9;
    L24:
        String r102 = "single_gift";
    L26:
        if (r110.containsKey("gift_source") == true) goto L28;
        r110.put("gift_source", "gift_tab");
    L28:
        J("gift_cnt", r110, r112.f4285f);
        J("combo_cnt", r110, r112.f4284e);
        J("money", r110, r112.f4287h * r112.f4285f);
        if (r110.containsKey("request_page") == true) goto L31;
        r110.put("request_page", "normal");
    L31:
        long r103 = r112.f4281b;
        if (r103 <= 0) goto L34;
        String r104 = "prop_type";
    L35:
        if (r103 <= 0) goto L37;
        String r105 = "prop_id";
    L38:
        r110.put(r104, r102);
        long r106 = r112.f4281b;
        if (r106 > 0) goto L42;
        r106 = r112.f4280a;
    L42:
        r110.put(r105, String.valueOf(r106));
        if (r112.f4281b > 0) goto L45;
        r110.put("gift_cnt", String.valueOf(r112.f4285f));
    L46:
        r110.put("group_cnt", String.valueOf(r112.f4286g));
        r110.put("combo_cnt", String.valueOf(r112.f4284e));
        long r107 = r112.f4281b;
        if (r107 > 0) goto L50;
        if (r100 == null) goto L50;
        r110.put("money", String.valueOf((r112.f4284e * r112.f4286g) * ((long) r100.getDiamondCount())));
    L63:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L59
        long r109 = r112.f4281b;     // Catch: Exception -> L59
        if (r109 > 0) goto L57;
        r108.put(String.valueOf(r112.f4280a), String.valueOf(r112.f4285f));     // Catch: Exception -> L59
        r110.put("gift_info", r108.toString());     // Catch: Exception -> L59
    L62:
        return;
    L57:
        r108.put(String.valueOf(r109), String.valueOf(r112.f4285f));     // Catch: Exception -> L59
        r110.put("prop_info", r108.toString());     // Catch: Exception -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
        return;
    L50:
        if (r107 <= 0) goto L63;
        if (r101 == null) goto L63;
        if (r100 == null) goto L63;
        r110.put("income", String.valueOf((r112.f4284e * r112.f4286g) * ((long) r100.getDiamondCount())));
        r110.put("money", String.valueOf((r112.f4284e * r112.f4286g) * ((long) r100.getDiamondCount())));
        goto L63
    L45:
        r110.put("prop_cnt", String.valueOf(r112.f4285f));
        goto L46
    L37:
        r105 = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID;
        goto L38
    L34:
        r104 = "gift_type";
        goto L35
    L9:
        if (r100.getType() != 10) goto L12;
        r102 = "coin_gift";
        goto L26
    L12:
        if (r112.f4285f == 1) goto L24;
        long r113 = r112.f4284e;
        if (r113 <= 1) goto L20;
        if (r112.f4286g <= 1) goto L20;
        r102 = "bunchrunning_gift";
    L20:
        if (r112.f4286g <= 1) goto L22;
        r102 = "bunching_gift";
        goto L26
    L22:
        if (r113 <= 1) goto L24;
        r102 = "running_gift";
        goto L26
    }

    public static void J(String r100, Map r101, long r102) {
        if (r101.containsKey(r100) == true) goto L5;
    L13:
        int r103 = 0;
    L15:
        if (r103 >= r102) goto L20;
        r101.put(r100, String.valueOf(r102));
        return;
    L20:
        return;
    L5:
        if (r101.get(r100) == null) goto L13;
        r103 = CastIntegerProtector.parseInt((String) r101.get(r100));     // Catch: NumberFormatException -> L9
    L9:
        String r104 = "parse " + r100 + " error";
        int r105 = ww2.a.f561626a;
        Intrinsics.checkNotNullParameter("SendGiftResultFilter", "tag");
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        Intrinsics.checkNotNullParameter("SendGiftResultFilter", "tag");
        Intrinsics.checkNotNullParameter(r104, "msg");
        ALogService.dSafely("SendGiftResultFilter", r104);
        goto L13
    }
}
