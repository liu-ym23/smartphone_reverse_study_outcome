package com.bytedance.android.gamecp.business.download.custommade;

import com.bytedance.android.gamecp.business.download.custommade.bean.CustomInstallInfo;
import com.bytedance.android.gamecp.business.download.custommade.bean.InInstallGuide;
import com.bytedance.android.gamecp.common.utils.e0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.keva.Keva;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class CustomInstallManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f52572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, BeforeInstallGuide> f52573b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f52574c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, InInstallGuide> f52575d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, CustomInstallInfo> f52576e = null;

    public static Keva c() {
        return (Keva) f52572a.getValue();
    }

    static {
        f52572a = LazyKt.lazy(LazyThreadSafetyMode.NONE, CustomInstallManager$keva$2.INSTANCE);
        f52573b = new LinkedHashMap();
        f52574c = new LinkedHashMap();
        f52575d = new LinkedHashMap();
        f52576e = new LinkedHashMap();
    }

    public static BeforeInstallGuide a(long r100) {
        yr.c.a("CustomInstallManager", "getBeforeInstallGuideDefault");
        BeforeInstallGuide r101 = new BeforeInstallGuide();
        if (r100 >= 300) goto L6;
        r101.packageGuideText = "";
    L12:
        r101.stayDuration = 3;
        r101.guideDesc = CollectionsKt.mutableListOf(new BeforeInstallGuideDesc[]{new BeforeInstallGuideDesc(y0.i(R.string.gamecp_custom_install_guide_first_step_text), "https://p3-webcast-material.byteimg.com/tos-cn-i-nvpupgq6uj/16443f56d635289571946fa6344930d8.png~tplv-nvpupgq6uj-png-compress:0:0.png"), new BeforeInstallGuideDesc(y0.i(R.string.gamecp_custom_install_guide_first_step_text), "https://p3-webcast-material.byteimg.com/tos-cn-i-nvpupgq6uj/21cfc73169ab2b366c1e56d1e9ae5707.png~tplv-nvpupgq6uj-png-compress:0:0.png")});
        return r101;
    L6:
        if (r100 >= 500) goto L9;
        r101.packageGuideText = y0.i(R.string.gamecp_custom_before_install_pkg_guide_text_300);
        goto L12
    L9:
        if (r100 >= 1024) goto L11;
        r101.packageGuideText = y0.i(R.string.gamecp_custom_before_install_pkg_guide_text_500);
        goto L12
    L11:
        r101.packageGuideText = y0.i(R.string.gamecp_custom_before_install_pkg_guide_text_1024);
        goto L12
    }

    public static InInstallGuide b(long r100) {
        InInstallGuide r101 = new InInstallGuide();
        if (r100 >= 300) goto L6;
        r101.packageGuideText = "";
    L12:
        r101.stayDuration = 3;
        r101.attractUserInstallText = y0.i(R.string.gamecp_custom_in_install_attract_user_text);
        return r101;
    L6:
        if (r100 >= 500) goto L9;
        r101.packageGuideText = y0.i(R.string.gamecp_custom_in_install_pkg_guide_text_300);
        goto L12
    L9:
        if (r100 >= 1024) goto L11;
        r101.packageGuideText = y0.i(R.string.gamecp_custom_in_install_pkg_guide_text_500);
        goto L12
    L11:
        r101.packageGuideText = y0.i(R.string.gamecp_custom_in_install_pkg_guide_text_1024);
        goto L12
    }

    public static void d(String r100, BeforeInstallGuide r101) {
        yr.c.a("CustomInstallManager", "setBeforeInstallGuide gameId = " + r100);
        String r102 = "key_before_install_guide_data" + r100;
        f52573b.put(r102, r101);
        c().storeString(r102, e0.h(r101));
    }

    public static void e(String r100, InInstallGuide r101) {
        yr.c.a("CustomInstallManager", "setInInstallGuide gameId = " + r100);
        String r102 = "key_in_install_guide_data" + r100;
        f52575d.put(r102, r101);
        c().storeString(r102, e0.h(r101));
    }
}
