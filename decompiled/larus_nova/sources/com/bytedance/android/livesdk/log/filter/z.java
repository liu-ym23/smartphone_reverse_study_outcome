package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class z extends a<am2.n> implements q {
    static {
    }

    public z() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, am2.n r101) {
        am2.n r102 = r101;
        super.u(r100, r102);
        boolean r103 = tb1.c.f545229a;
        if (r103 == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102.f4313b) == true) goto L8;
        r100.put(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE, r102.f4313b);
        this.f153291b.put(ILiveRoomPlayFragmentConstant.IES_LIVE_EFFECT_AD_TRACK_EXTRA_SERVICE, r102.f4313b);
    L8:
        if (TextUtils.isEmpty(r102.f4314c) == true) goto L11;
        r100.put("ad_extra_data", r102.f4314c);
        this.f153291b.put("ad_extra_data", r102.f4314c);
    L11:
        if (TextUtils.isEmpty(r102.f4315d) == true) goto L14;
        r100.put("is_other_channel", r102.f4315d);
        this.f153291b.put("is_other_channel", r102.f4315d);
        r100.put("is_ad", "1");
        this.f153291b.put("is_ad", "1");
    L14:
        if (TextUtils.isEmpty(r102.f4316e) == true) goto L18;
        if (r103 == false) goto L18;
        r100.put("enter_from_merge", r102.f4316e);
    L18:
        if (TextUtils.isEmpty(r102.a()) == true) goto L21;
        r100.put("ad_plan_id", r102.a());
    L21:
        if (TextUtils.isEmpty(r102.c()) == true) goto L24;
        r100.put("creative_id", r102.c());
    L24:
        if (TextUtils.isEmpty(r102.b()) == true) goto L28;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_PREVIEW_EXTRA_INFO, r102.b());
        return;
    }
}
