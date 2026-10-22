package com.bytedance.ai.applet.page;

import com.bytedance.ai.monitor.AppletErrorCode;
import com.ivy.ivykit.api.plugin.IIvyPageService;
import java.util.Map;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IIvyPageService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletPageTimelineTracker f34893a;

    @Override // com.ivy.ivykit.api.plugin.IIvyPageService.a
    public final void onDestroy() {
        AppletPageTimelineTracker r100 = this.f34893a;
        if (r100.f34892c == true) goto L7;
        i1 r101 = y0.f512051a;
        y0.p(r100.f34890a, "applet_page_timeline_full", false);
        y0.o(r100.f34890a, "applet_page_timeline_full");
        r100.f34892c = true;
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyPageService.a
    public final void onLoadSuccess() {
        AppletPageTimelineTracker r100 = this.f34893a;
        if (r100.f34891b == true) goto L7;
        i1 r101 = y0.f512051a;
        y0.f(r100.f34890a, "applet_page_timeline_full");
        r100.f34891b = true;
        return;
    }

    public a(AppletPageTimelineTracker r100) {
        this.f34893a = r100;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyPageService.a
    public final void onTimingSetup(Map<String, Object> r100) {
        AppletPageTimelineTracker r101 = this.f34893a;
        r101.getClass();
        i1 r102 = y0.f512051a;
        y0.n(r101.f34890a, r100, "applet_page_timeline_full");
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyPageService.a
    public final void a(Integer r100, String r101) {
        AppletPageTimelineTracker r102 = this.f34893a;
        if (r100 == null) goto L5;
        int r103 = r100.intValue();
    L6:
        r102.a(r101, r103);
        return;
    L5:
        r103 = AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType();
        goto L6
    }
}
