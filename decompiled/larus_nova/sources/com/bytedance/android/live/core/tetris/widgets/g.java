package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.config.i91;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i91 f65986a = null;

    static {
        if (com.bytedance.android.livesdk.config.setting.w.f121219a.a() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        i91 r101 = LiveInfraSettingKeys.LIVE_WIDGET_MONITOR_CONFIG.getValue();
    L9:
        f65986a = r101;
        return;
    L8:
        r101 = null;
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    @JvmStatic
    public static final i91 c() {
        if (com.bytedance.android.livesdk.config.setting.w.f121219a.a() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        i91 r101 = f65986a;
        if (r101 == null) goto L10;
        return r101;
    L10:
        return LiveInfraSettingKeys.LIVE_WIDGET_MONITOR_CONFIG.getValue();
    L12:
        return LiveInfraSettingKeys.LIVE_WIDGET_MONITOR_CONFIG.getValue();
    L5:
        r100 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean a() {
        i91 r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @JvmStatic
    public static final boolean b() {
        if (a() == false) goto L11;
        i91 r100 = c();
        if (r100 == null) goto L7;
        boolean r101 = r100.c();
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    L11:
        return false;
    }
}
