package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveTryLoadCertPluginResultModel;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class r1 implements IHostOCRApiProxy.LiveCertPreloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f142182a;

    public r1(s1 r100) {
        this.f142182a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostOCRApiProxy.LiveCertPreloadListener
    public final void onCertPluginLoaded(boolean r100, boolean r101) {
        if (r100 == false) goto L4;
        s1 r102 = this.f142182a;
        LiveTryLoadCertPluginResultModel r103 = new LiveTryLoadCertPluginResultModel();
        r103.a(LiveTryLoadCertPluginResultModel.Code.Success);
        r103.b("cert plugin loaded");
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
        return;
    L4:
        if (r101 == false) goto L6;
        s1 r105 = this.f142182a;
        LiveTryLoadCertPluginResultModel r106 = new LiveTryLoadCertPluginResultModel();
        r106.a(LiveTryLoadCertPluginResultModel.Code.Cancel);
        r106.b("cert plugin load canceled");
        Unit r107 = Unit.INSTANCE;
        r105.finishWithResult(r106);
        return;
    L6:
        s1 r108 = this.f142182a;
        LiveTryLoadCertPluginResultModel r109 = new LiveTryLoadCertPluginResultModel();
        r109.a(LiveTryLoadCertPluginResultModel.Code.Failed);
        r109.b("cert plugin load failed");
        Unit r110 = Unit.INSTANCE;
        r108.finishWithResult(r109);
    }
}
