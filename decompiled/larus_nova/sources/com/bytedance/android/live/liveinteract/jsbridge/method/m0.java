package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateViewInLiveBgResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.ob;
import w20.t3;

/* JADX INFO: loaded from: classes46.dex */
public final class m0 extends t3<ob, LiveUpdateViewInLiveBgResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f74235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ih0.b f74236b;

    public m0() {
        this(false, null);
    }

    public m0(boolean r100, ih0.b r101) {
        this.f74235a = r100;
        this.f74236b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ob r102 = (ob) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        JsonObject r104 = r102.a();
        ALogger.i("MultiLinkUpdateViewInLiveBgMethod", "updateViewInLiveBgEvent: type=" + r103 + ", data=" + r104 + ", isFeed=" + this.f74235a);
        l0 r105 = new l0(this);
        if (this.f74235a == false) goto L11;
        if (r104 == null) goto L17;
        ih0.b r106 = this.f74236b;
        if (r106 == null) goto L18;
        r106.updateViewInLiveBg(r103, r104, r105);
        return;
    L18:
        return;
    L17:
        return;
    L11:
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r104 == null) goto L15;
        if (r107 == null) goto L15;
        r107.updateViewInLiveBg(r103, r104, r105);
        return;
    L15:
        finishWithFailure();
    }
}
