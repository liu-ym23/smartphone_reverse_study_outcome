package com.bytedance.ai.model.widgets;

import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b1 implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageInfo f37015a;

    public b1(PageInfo r100) {
        this.f37015a = r100;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = this.f37015a.getMessageId();
        if (r101 == null) goto L5;
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, r101);
    L5:
        r100.i(new JSONObject(GsonProtectorUtils.toJson(new Gson(), this.f37015a)));
        r100.g("success", true);
    }
}
