package com.bytedance.ai.applet.login;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f34775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f34776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u2.c f34777d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f("current_page", this.f34774a);
        r100.f("login_type", this.f34775b);
        r100.f("success", this.f34776c);
        r100.f("app_key", this.f34777d.f548386a);
        r100.f("app_name", this.f34777d.f548387b);
    }

    public n(String r100, String r101, String r102, u2.c r103) {
        this.f34774a = r100;
        this.f34775b = r101;
        this.f34776c = r102;
        this.f34777d = r103;
    }
}
