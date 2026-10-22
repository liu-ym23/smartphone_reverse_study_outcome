package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f34697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f34698c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f("click_from", this.f34696a);
        r100.f("app_key", this.f34697b.f34682c.f548386a);
        r100.f("app_name", this.f34697b.f34682c.f548387b);
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, this.f34697b.f34682c.f548391f.f548379a);
        r100.f(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, this.f34698c);
    }

    public p(String r100, f r101, String r102) {
        this.f34696a = r100;
        this.f34697b = r101;
        this.f34698c = r102;
    }
}
