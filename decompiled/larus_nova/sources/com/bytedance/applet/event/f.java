package com.bytedance.applet.event;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f191816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f191817b;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, this.f191816a);
        r100.f("questionId", this.f191817b);
        r100.f("content", "onServerAction");
    }

    public f(String r100, String r101) {
        this.f191816a = r100;
        this.f191817b = r101;
    }
}
