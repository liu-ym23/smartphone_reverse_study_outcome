package com.bytedance.android.livesdk.log;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.room.logger.ILivePromotionActionListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class z implements ILivePromotionActionListener, com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f153455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f153456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f153457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f153458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f153459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f153460h;

    public static m0 a(String r100, JSONObject r101, Map r102) {
        m0 r103 = new m0();
        if (r101 == null) goto L6;
        Map<String, String> r104 = r103.f153381a;
        HashMap r105 = (HashMap) r104;
        r105.put("ad_extra_data", r101.toString());
    L6:
        r103.c(r102);
        if (TextUtils.isEmpty(r100) == true) goto L9;
        r103.b("refer", r100);
    L9:
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.room.logger.ILivePromotionActionListener, com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener
    public final void onClickPromotion(String r100, String r101, String r102, JSONObject r103) {
        if (this.f153453a == false) goto L6;
        ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).logEvent(true, r100, r101, a(r102, r103, this.f153456d).f153381a);
    L6:
        if (this.f153454b == false) goto L17;
        ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).logEvent(true, r100, r101, a(r102, r103, this.f153457e).f153381a);
        if (com.bytedance.android.live.core.feed.a.a().c(this.f153460h) == true) goto L12;
        if (com.bytedance.android.live.core.feed.a.a().b(this.f153460h) == false) goto L17;
    L12:
        if (TextUtils.equals("slidecart_click", r101) == false) goto L14;
    L15:
        ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).logEvent(true, "draw_ad", "click", a(r102, r103, this.f153457e).f153381a);
        goto L17
    L14:
        if (TextUtils.equals(com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, r101) == true) goto L15;
    L17:
        if (this.f153455c == true) goto L19;
        return;
    L19:
        if (TextUtils.equals(com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, r101) == false) goto L23;
        ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).logEvent(true, "live_ad", "realtime_click", a(r102, r103, this.f153459g).f153381a);
        return;
    }

    public z(boolean r100, boolean r101, boolean r102, Map r103, Map r104, Map r105, Map r106, Long r107) {
        this.f153453a = r100;
        this.f153454b = r101;
        this.f153455c = r102;
        this.f153456d = r103;
        this.f153457e = r104;
        this.f153458f = r106;
        this.f153459g = r105;
        this.f153460h = r107;
    }
}
