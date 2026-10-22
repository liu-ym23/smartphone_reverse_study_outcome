package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0.h f79871a;

    public q(ih0.h r100) {
        this.f79871a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.w("LynxSettingPanelHandler", "get_client_settings fail, readon=" + r101.getMessage());
        ih0.h r102 = this.f79871a;
        UpdateLinkmicStatusResultModel.Code r103 = UpdateLinkmicStatusResultModel.Code.Failed;
        String r104 = r101.getMessage();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r102.a(r103, r104, null);
    }
}
