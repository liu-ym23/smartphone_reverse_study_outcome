package com.bytedance.ai.core.manager;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f36175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f36176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f36177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f36178d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f37145f = this.f36175a;
        String r101 = this.f36176b;
        if (r101 == null) goto L5;
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, r101);
    L5:
        String r102 = this.f36177c;
        if (r102 == null) goto L8;
        r100.f("replyFor", r102);
    L8:
        r100.f("content", this.f36178d);
        r100.g("success", false);
    }

    public d(String r100, String r101, String r102, String r103) {
        this.f36175a = r100;
        this.f36176b = r101;
        this.f36177c = r102;
        this.f36178d = r103;
    }
}
