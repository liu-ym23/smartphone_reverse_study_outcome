package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f34700b;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f(BdpAppEventConstant.PARAMS_AUTH_TYPE, this.f34699a);
        r100.f("app_key", this.f34700b.f34682c.f548386a);
        r100.f("app_name", this.f34700b.f34682c.f548387b);
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, this.f34700b.f34682c.f548391f.f548379a);
    }

    public q(String r100, f r101) {
        this.f34699a = r100;
        this.f34700b = r101;
    }
}
