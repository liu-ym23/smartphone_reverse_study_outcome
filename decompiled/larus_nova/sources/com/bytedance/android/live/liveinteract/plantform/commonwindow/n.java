package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.config.ub0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Deprecated(message = "已废弃，后续请使用LayoutConfigGeckoResManager")
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f75850a = 0;

    static {
    }

    public static int a(int r100) {
        if (r100 != 7) goto L5;
    L27:
        return 0;
    L5:
        if (r100 == 25) goto L27;
        if (r100 == 29) goto L27;
        MultiLinkFrequencyOptConfig r101 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.f75889a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(0, Integer.valueOf(r100)) == true) goto L27;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.g(0, Integer.valueOf(r100)) == true) goto L27;
        if (r100 == 4) goto L27;
        if (aj0.b.c(r100) == true) goto L27;
        if (r100 == 21) goto L27;
        if (r100 == 22) goto L27;
        if (r100 == 27) goto L27;
        if (r100 == 26) goto L27;
        return s1.f(ub0.f121359a.getValue().floatValue());
    }

    public static o b(m r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        int r103 = c1.f78742a;
        if (c1.a(0, Integer.valueOf(r100.getUiLayout())) == true) goto L5;
        o r104 = new o();
        r104.f75851a = 0;
        r104.f75852b = 0;
        r104.f75853c = 0;
        r104.f75854d = 0;
        return r104;
    L5:
        if (r100.f() != 0) goto L8;
        int r105 = s1.f(95.0f);
        int r106 = s1.f(93.0f);
        int r107 = (r101 - r105) - s1.f(12.0f);
        int r108 = r106 * 2;
        int r109 = (r102 - r108) - s1.f(87.0f);
        o r110 = new o();
        r110.f75851a = r107;
        r110.f75852b = r109;
        r110.f75853c = r105;
        r110.f75854d = r108;
        return r110;
    L8:
        int r111 = s1.f(90.0f);
        int r112 = s1.f(90.0f);
        int r113 = s1.f(14.0f);
        if (PadConfigUtils.c() == false) goto L11;
        int r114 = s1.f(230.0f);
    L12:
        int r115 = r112 * 2;
        int r116 = (r102 - r115) - r114;
        o r117 = new o();
        r117.f75851a = r113;
        r117.f75852b = r116;
        r117.f75853c = r111;
        r117.f75854d = r115;
        return r117;
    L11:
        r114 = s1.f(65.0f);
        goto L12
    }
}
