package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f128186a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f128187b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f128188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f128189d;

    static {
        f128186a = s1.h(R.color.ttlive_base_gift_panel_diamond);
        f128187b = s1.B(R.string.ttlive_send_v2);
        f128188c = s1.j(R.dimen.ttlive_gift_panel_icon_size);
        f128189d = SystemClock.uptimeMillis();
    }

    public static int a() {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.f127364s.getValue()).booleanValue() == false) goto L7;
        return f128186a;
    L7:
        return s1.h(R.color.ttlive_base_gift_panel_diamond);
    }

    public static String c() {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.f127364s.getValue()).booleanValue() == false) goto L7;
        return f128187b;
    L7:
        return s1.B(R.string.ttlive_send_v2);
    }

    @JvmStatic
    public static final int b(int r100) {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.f127364s.getValue()).booleanValue() == false) goto L12;
        if (r100 != R.dimen.ttlive_gift_panel_icon_size) goto L12;
        if ((SystemClock.uptimeMillis() - f128189d) <= 1000) goto L10;
        f128188c = s1.j(R.dimen.ttlive_gift_panel_icon_size);
        f128189d = SystemClock.uptimeMillis();
    L10:
        return f128188c;
    L12:
        return s1.j(r100);
    }
}
