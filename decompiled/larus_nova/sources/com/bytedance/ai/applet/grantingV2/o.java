package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f34694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f34695c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f(BdpAppEventConstant.PARAMS_AUTH_TYPE, this.f34693a);
        r100.f("app_key", this.f34694b.f34682c.f548386a);
        r100.f("app_name", this.f34694b.f34682c.f548387b);
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, this.f34694b.f34682c.f548391f.f548379a);
        r100.f("click_from", this.f34695c);
    }

    public o(String r100, f r101, String r102) {
        this.f34693a = r100;
        this.f34694b = r101;
        this.f34695c = r102;
    }
}
