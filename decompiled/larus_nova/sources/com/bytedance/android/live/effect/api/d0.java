package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.config.n21;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f66751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f66752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f66753c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f66754d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f66755e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f66756f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f66757g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f66758h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f66759i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f66760j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f66761k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f66762l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, String> f66763m = null;

    static {
        if (LiveEffectSettings.LIVE_ENABLE_NEW_GESTURE_DIALOG.getValue().booleanValue() == false) goto L8;
        int r100 = n21.f120803a;
        if (n21.a.a() == false) goto L7;
        String r101 = s1.B(R.string.ttlive_effect_live_effect_new_sticker_panel_guest);
    L9:
        f66752b = r101;
        int r102 = n21.f120803a;
        if (n21.a.a() == false) goto L12;
        String r103 = s1.B(R.string.ttlive_effect_live_effect_sticker_panel);
    L13:
        f66753c = r103;
        f66754d = "liveinteractiveeffect";
        if (n21.a.a() == false) goto L16;
        r103 = "live_guest_tab";
    L16:
        f66755e = r103;
        f66756f = "live_guest_activity";
        f66757g = s1.B(R.string.ttlive_effect_live_effect_pix_panel);
        if (n21.a.a() == false) goto L19;
        int r104 = R.string.ttlive_effect_live_effect_sticker_panel_interact;
    L20:
        f66758h = s1.B(r104);
        f66760j = s1.B(R.string.ttlive_effect_live_effect_area_small_item_beauty_panel);
        s1.B(R.string.ttlive_effect_live_effect_area_filter_panel);
        if (n21.a.a() == false) goto L23;
        int r105 = R.string.ttlive_effect_live_effect_beauty_small_item_panel;
    L24:
        String r106 = s1.B(r105);
        f66759i = r106;
        f66761k = "makeupforever";
        if (n21.a.a() == false) goto L27;
        int r107 = R.string.ttlive_effect_live_effect_filter_panel;
    L28:
        f66751a = s1.B(r107);
        f66762l = s1.B(R.string.ttlive_effect_live_effect_composer_filter_panel);
        f66763m = MapsKt.mapOf(new Pair[]{TuplesKt.to(r106, "beauty"), TuplesKt.to("makeupforever", "makeups"), TuplesKt.to("livesoundeffect", RemoteMessageConst.Notification.SOUND)});
        return;
    L27:
        r107 = R.string.ttlive_effect_live_effect_filter_panel_saas;
        goto L28
    L23:
        r105 = R.string.ttlive_effect_live_effect_beauty_small_item_panel_saas;
        goto L24
    L19:
        r104 = R.string.ttlive_effect_live_effect_sticker_panel_interact_saas;
        goto L20
    L12:
        r103 = s1.B(R.string.ttlive_effect_live_effect_sticker_panel_saas);
        goto L13
    L7:
        r101 = s1.B(R.string.ttlive_effect_live_effect_new_sticker_panel_guest_saas);
        goto L9
    L8:
        r101 = s1.B(R.string.ttlive_effect_live_effect_sticker_panel_guest);
        goto L9
    }
}
