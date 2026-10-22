package com.bytedance.applet.aibridge.navi;

import android.app.Application;
import com.bytedance.ai.api.navi.IAppletNaviService;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.ss.android.lark.utils.statistics.PerfLog;
import f3.h;
import k3.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements IAppletNaviService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h<AbsStartThirdNaviOrPlanMethodIDL.b> f191250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f191251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StartThirdNaviOrPlanMethod f191252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f191253d;

    @Override // com.bytedance.ai.api.navi.IAppletNaviService.a
    public final void onResult(int r100, String r101) {
        h<AbsStartThirdNaviOrPlanMethodIDL.b> r102 = this.f191250a;
        Intrinsics.checkNotNullParameter(AbsStartThirdNaviOrPlanMethodIDL.b.class, "<this>");
        BaseModel r103 = c.a(AbsStartThirdNaviOrPlanMethodIDL.b.class);
        String r104 = this.f191251b;
        StartThirdNaviOrPlanMethod r105 = this.f191252c;
        String r106 = this.f191253d;
        AbsStartThirdNaviOrPlanMethodIDL.b r107 = (AbsStartThirdNaviOrPlanMethodIDL.b) r103;
        r107.setResult(r100);
        r107.setAppName(r101);
        AppHost.Companion r108 = AppHost.f326268a;
        r107.setBackground(r108.a().isAppBackground() ? 1 : 0);
        if (r104 != null) goto L17;
        int r109 = StartThirdNaviOrPlanMethod.f191246b;
        r105.getClass();
        xv3.h r110 = xv3.h.f565166a;
        Application r111 = r108.getApplication();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (xv3.h.b(r111, MapRouteService.MapPackageName.PACKAGE_NAME_AMAP) == false) goto L7;
        r104 = ",amap";
    L8:
        Application r112 = r108.getApplication();
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (xv3.h.b(r112, MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP) == false) goto L12;
        r104 = r104.concat(",baidu");
    L12:
        if (r104.length() <= 0) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == false) goto L17;
        r104 = r104.substring(1);
        goto L17
    L14:
        r113 = false;
        goto L15
    L7:
        r104 = "";
    L17:
        r107.setAvailableApps(r104);
        r107.setSelectedApp(r106);
        h.a.b(r102, (ResultModel) r103);
    }

    public b(h<AbsStartThirdNaviOrPlanMethodIDL.b> r100, String r101, StartThirdNaviOrPlanMethod r102, String r103) {
        this.f191250a = r100;
        this.f191251b = r101;
        this.f191252c = r102;
        this.f191253d = r103;
    }
}
