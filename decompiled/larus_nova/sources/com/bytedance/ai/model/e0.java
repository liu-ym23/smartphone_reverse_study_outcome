package com.bytedance.ai.model;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e0 implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5.g f36862a;

    public e0(h5.g r100) {
        this.f36862a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, this.f36862a.f483819b);
        r100.g("shouldSwitchBot", false);
        String r101 = this.f36862a.f483823f;
        if (r101 == null) goto L6;
        r100.f("questionId", r101);
        return;
    }
}
