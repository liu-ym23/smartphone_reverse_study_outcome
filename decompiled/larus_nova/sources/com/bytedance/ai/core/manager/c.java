package com.bytedance.ai.core.manager;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f36171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f36172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f36173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f36174d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f37145f = this.f36171a;
        String r101 = this.f36172b;
        if (r101 == null) goto L5;
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, r101);
    L5:
        String r102 = this.f36173c;
        if (r102 == null) goto L8;
        r100.f("replyFor", r102);
    L8:
        r100.d("isNew", 0);
        r100.e(ChameleonOpenTracker.ParamKey.COST, this.f36174d);
        r100.g("success", true);
    }

    public c(String r100, String r101, String r102, long r103) {
        this.f36171a = r100;
        this.f36172b = r101;
        this.f36173c = r102;
        this.f36174d = r103;
    }
}
