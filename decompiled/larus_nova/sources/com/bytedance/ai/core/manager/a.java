package com.bytedance.ai.core.manager;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f36162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f36163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f36164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f36165d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        r100.f37145f = this.f36162a;
        String r101 = this.f36163b;
        if (r101 == null) goto L5;
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, r101);
    L5:
        String r102 = this.f36164c;
        if (r102 == null) goto L8;
        r100.f("botId", r102);
    L8:
        String r103 = this.f36165d;
        if (r103 == null) goto L12;
        r100.f("replyFor", r103);
        return;
    }

    public a(String r100, String r101, String r102, String r103) {
        this.f36162a = r100;
        this.f36163b = r101;
        this.f36164c = r102;
        this.f36165d = r103;
    }
}
