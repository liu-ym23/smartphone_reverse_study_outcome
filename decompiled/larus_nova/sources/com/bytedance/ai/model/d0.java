package com.bytedance.ai.model;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d0 implements k5.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LLMData f36858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f36859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.g f36860c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        LLMData r101 = this.f36858a;
        if (r101 == null) goto L19;
        String r102 = r101.getMsgId();
        if (r102 == null) goto L7;
        r100.f(MusicAppletPage.KEY_MESSAGE_ID, r102);
    L7:
        String r103 = r101.getRealJSONData();
        if (r103 == null) goto L10;
        r100.f("realJSONData", r103);
    L10:
        String r104 = r101.getQuestionId();
        if (r104 == null) goto L13;
        r100.f("questionId", r104);
    L13:
        Boolean r105 = r101.isSystemAgent();
        if (r105 == null) goto L16;
        r100.f("isSystemAgent", String.valueOf(r105.booleanValue()));
    L16:
        Boolean r106 = r101.getFinished();
        if (r106 == null) goto L19;
        r100.f(CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, String.valueOf(r106.booleanValue()));
    L19:
        r100.f("fromBotId", this.f36859b);
        String r107 = this.f36860c.f483826i;
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        r100.f("applet_id", r107);
    }

    public d0(LLMData r100, String r101, h5.g r102) {
        this.f36858a = r100;
        this.f36859b = r101;
        this.f36860c = r102;
    }
}
