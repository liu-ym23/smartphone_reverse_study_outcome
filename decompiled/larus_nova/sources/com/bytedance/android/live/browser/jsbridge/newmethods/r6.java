package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveOpenLiveEffectSelectPanelResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r6 implements zg1.e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s6 f63628a;

    public r6(s6 r100) {
        this.f63628a = r100;
    }

    @Override // zg1.e2
    public final void a(Sticker r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        LiveOpenLiveEffectSelectPanelResultModel r102 = new LiveOpenLiveEffectSelectPanelResultModel();
        r102.b(LiveOpenLiveEffectSelectPanelResultModel.Code.Success);
        LiveOpenLiveEffectSelectPanelResultModel.a r103 = new LiveOpenLiveEffectSelectPanelResultModel.a();
        String r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.getEffectId();
    L6:
        r103.e(r105);
        if (r100 == null) goto L9;
        String r106 = r100.getName();
    L10:
        r103.h(r106);
        if (r100 == null) goto L13;
        Long r107 = Long.valueOf(r100.getDefaultDuration());
    L14:
        r103.c(r107);
        String r108 = "";
        if (r100 == null) goto L22;
        UrlModel r109 = r100.getIcon();
        if (r109 == null) goto L22;
        List<String> r110 = r109.getUrlList();
        if (r110 == null) goto L22;
        String r111 = (String) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L22;
    L23:
        r103.f(r111);
        r103.g(LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue());
        if (r100 == null) goto L26;
        boolean r112 = r100.enableCustomizeDuration();
    L27:
        r103.d(Boolean.valueOf(r112));
        String r113 = r101.get("effect_type");
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        r103.i(r113);
        String r114 = r101.get("sub_effect_type");
        if (r114 == null) goto L34;
        r108 = r114;
    L34:
        r103.j(r108);
        Unit r115 = Unit.INSTANCE;
        r102.c(r103);
        StringBuilder r116 = new StringBuilder("result: effectID: ");
        LiveOpenLiveEffectSelectPanelResultModel.a r117 = r102.a();
        if (r117 == null) goto L37;
        String r118 = r117.a();
    L38:
        r116.append(r118);
        r116.append(", effectName: ");
        LiveOpenLiveEffectSelectPanelResultModel.a r119 = r102.a();
        if (r119 == null) goto L41;
        r104 = r119.b();
    L41:
        r116.append(r104);
        ALogger.d("live.openLiveEffectSelectPanel", r116.toString());
        this.f63628a.finishWithResult(r102);
        return;
    L37:
        r118 = null;
        goto L38
    L26:
        r112 = true;
    L22:
        r111 = "";
        goto L23
    L13:
        r107 = LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue();
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
